package ru.andreichernov.acicalc.math.converters;

import ru.andreichernov.acicalc.exception.WrongExpression;
import ru.andreichernov.acicalc.math.MathObject;
import ru.andreichernov.acicalc.math.operand.BaseOperand;
import ru.andreichernov.acicalc.math.operand.OperandHelper;
import ru.andreichernov.acicalc.math.operator.Operator;
import ru.andreichernov.acicalc.math.operator.OperatorsHelper;

import java.util.*;

public class Infix2PostfixConverter implements MathNotationConverter {
    private List<Operator> availableOperatorsList;
    private List<BaseOperand> availableOperandList;
    private Stack<BaseOperand> operandStack = new Stack<>();
    private Stack<Operator> operatorStack = new Stack<>();

    public Infix2PostfixConverter() {
        availableOperatorsList = new OperatorsHelper().getAvailableOperatorsList();
        availableOperandList = new OperandHelper().getAvailableOperandsList();
    }

    @Override
    public List convert2List(String infixExpression) throws WrongExpression {
        List<MathObject> postfixList = new ArrayList<>();
        Stack<BaseOperand> tempOperandStack = new Stack<>();
        Stack<Operator> tempOperatorStack = new Stack<>();
        BaseOperand currentOperand = null;
        List<Integer> currentOperandCodepoints = new ArrayList<>();
        int expressionSize = infixExpression.length();

        boolean isNotationFound = false;
        boolean isOperatorFound = false;
        for (int i = 0; i < expressionSize; i++) {
            //int readedCodepoint = infixExpression.codePointAt(i);
            String s = infixExpression.substring(i, i + 1);
            int readedCodepoint = s.codePointAt(0);
            // Если codePoint прочитанного символа входит в одну из разрешенных систем счисления,
            // то запомним в какую систему счисления он входит
            if (!isNotationFound) {
                for (int indexOfCurrNotation = 0; indexOfCurrNotation < availableOperandList.size(); indexOfCurrNotation++) {
                    if (availableOperandList.get(indexOfCurrNotation).isIncludeCodepoint(readedCodepoint)) {
                        try {
                            currentOperand = availableOperandList.get(indexOfCurrNotation).getClass().newInstance();// например Arabic
                        } catch (InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        currentOperandCodepoints.add(readedCodepoint);
                        isNotationFound = true;
                        break;
                    }else {
                        if (isOperatorFound){
                            throw new WrongExpression("Wrong expression at : " + (i + 1) + " position. " + "Two operators " +
                                    "consecutive.");
                        }
                    }
                }
            } else { // если система счисления уже была найдена, то уже сразу проверяем входит ли codepoint в нее
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
                                while (!operatorStack.empty() || operatorStack.peek().getPrecedence()
                                        >= availableOperatorsList.get(j).getPrecedence()) {
                                    try {
                                        postfixList.add((MathObject) operatorStack.pop().getClass().newInstance());
                                    } catch (InstantiationException | IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                    if (operatorStack.empty()){
                                        break;
                                    }
                                }
                                operatorStack.push(availableOperatorsList.get(j));
                            }
                            break;
                        }
                    }
                    if (!isOperatorFound){
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
                postfixList.add((MathObject) operatorStack.pop().getClass().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            currentOperandCodepoints.clear();
        }
        return postfixList;
    }
}
