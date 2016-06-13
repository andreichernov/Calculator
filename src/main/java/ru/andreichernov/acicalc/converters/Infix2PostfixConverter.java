package ru.andreichernov.acicalc.converters;

import ru.andreichernov.acicalc.cleaners.EmptyCharacterCleaner;
import ru.andreichernov.acicalc.cleaners.ExpCleaner;
import ru.andreichernov.acicalc.exception.WrongExpression;
import ru.andreichernov.acicalc.MathObject;
import ru.andreichernov.acicalc.operand.Arabic;
import ru.andreichernov.acicalc.operand.BaseOperand;
import ru.andreichernov.acicalc.operand.OperandHelper;
import ru.andreichernov.acicalc.operator.Operator;
import ru.andreichernov.acicalc.operator.OperatorsHelper;

import java.util.*;

public class Infix2PostfixConverter implements MathNotationConverter {
    private List<Operator> availableOperatorsList;
    private List<BaseOperand> availableOperandList;
    private Stack<Operator> operatorStack = new Stack<>();

    public Infix2PostfixConverter() {
        availableOperatorsList = new OperatorsHelper().getAvailableOperatorsList();
        availableOperandList = new OperandHelper().getAvailableOperandsList();
    }

    @Override
    public List convert2List(String expression) throws WrongExpression, IllegalAccessException, InstantiationException {
        ExpCleaner expCleaner = new EmptyCharacterCleaner();
        String infixExpression = expCleaner.clean(expression);

        List<MathObject> postfixList = new ArrayList<>();
        BaseOperand currentOperand = null;
        List<Integer> currentOperandCodepoints = new ArrayList<>();
        int expressionSize = infixExpression.length();

        boolean isNotationFound = false;
        boolean isOperatorFound = false;
        boolean isDotAdded = false;
        for (int i = 0; i < expressionSize; i++) {
            //int readedCodepoint = infixExpression.codePointAt(i);
            String s = infixExpression.substring(i, i + 1);
            int readedCodepoint = s.codePointAt(0);
            // Если codePoint прочитанного символа входит в одну из разрешенных систем счисления,
            // то запомним в какую систему счисления он входит
            if (!isNotationFound) {
                for (int indexOfCurrNotation = 0; indexOfCurrNotation < availableOperandList.size(); indexOfCurrNotation++) {
                    if (availableOperandList.get(indexOfCurrNotation).isIncludeCodepoint(readedCodepoint)) {
                        currentOperand = availableOperandList.get(indexOfCurrNotation).getClass().newInstance();// например Arabic
                        currentOperandCodepoints.add(readedCodepoint);
                        isNotationFound = true;
                        break;
                    }
                }
                if(!isNotationFound){
                    throw new WrongExpression("Wrong expression at : " + (i + 1) + " position. " + "Check expression for " +
                            "correctnes.");
                }

            } else { // если система счисления уже была найдена, то уже сразу проверяем входит ли codepoint в нее
                if(currentOperand instanceof Arabic){
                    if(readedCodepoint == ".".codePointAt(0) || readedCodepoint == ",".codePointAt(0)){
                        if (isDotAdded){
                            throw new WrongExpression("Wrong expression at : " + (i + 1) + " position. " + "Check number for " +
                                    "correctnes.");
                        }
                        currentOperandCodepoints.add(readedCodepoint);
                        isDotAdded = true;
                        continue;
                    }
                }
                if (currentOperand.isIncludeCodepoint(readedCodepoint)) {
                    // Добавим codePointAt(i) в список формирования конечного операнда (т.к. операнд может состоять из нескольких символов)
                    currentOperandCodepoints.add(readedCodepoint);
                } else { // если не входит, то это либо оператор, либо мусорный символ => исключение
                    // проверим оператор или нет

                    currentOperand.setNumber(currentOperandCodepoints);
                    currentOperand.saveDirect2Decimal(currentOperand.toDecimal());
                    postfixList.add(currentOperand);
                    currentOperandCodepoints.clear();
                    isNotationFound = false;
                    for (int j = 0; j < availableOperatorsList.size(); j++) {
                        if (availableOperatorsList.get(j).getCodepoint() == readedCodepoint) {
                            isOperatorFound = true;

                            if (operatorStack.empty()) {
                                operatorStack.push(availableOperatorsList.get(j));
                            } else {
                                while (!operatorStack.empty() && operatorStack.peek().getPrecedence()
                                        >= availableOperatorsList.get(j).getPrecedence()) {
                                    postfixList.add((MathObject) operatorStack.pop().getClass().newInstance());
                                    if (operatorStack.empty()) {
                                        break;
                                    }
                                }
                                operatorStack.push(availableOperatorsList.get(j));
                            }
                            break;
                        }
                    }
                    if (!isOperatorFound) {
                        throw new WrongExpression("Bad character: " +
                                (char) readedCodepoint + " in expression at " + (i + 1) + " position.");
                    }

                }
            }



        }
        if (currentOperandCodepoints.size() > 0) {
            currentOperand.setNumber(currentOperandCodepoints);
            currentOperand.saveDirect2Decimal(currentOperand.toDecimal());
            postfixList.add(currentOperand);
            try {
                while (!operatorStack.empty()) {
                    postfixList.add((MathObject) operatorStack.pop().getClass().newInstance());
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();//todo: add logger
            }
            currentOperandCodepoints.clear();
        }
        return postfixList;
    }
}
