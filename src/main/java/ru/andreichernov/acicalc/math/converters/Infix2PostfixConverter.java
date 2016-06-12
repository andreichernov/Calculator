package ru.andreichernov.acicalc.math.converters;

import ru.andreichernov.acicalc.exception.WrongExpression;
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
        Stack<BaseOperand> tempOperandStack = new Stack<>();
        Stack<Operator> tempOperatorStack = new Stack<>();
        List resultPostfixList = new ArrayList();
        BaseOperand currentOperand = null;
        List<Integer> currentOperandCodepoints = new ArrayList<>();
        int expressionSize = infixExpression.length();

        boolean isNotationFound = false;
        for (int i = 0; i < expressionSize; i++) {
            String s = infixExpression.substring(i, i + 1);
            //int readedCodepoint = infixExpression.codePointAt(i);
            int readedCodepoint = s.codePointAt(0);
            // Если codePoint прочитанного символа входит в одну из разрешенных систем счисления,
            // то запомним в какую систему счисления он входит
            if (!isNotationFound) {
                for (int indexOfCurrNotation = 0; indexOfCurrNotation < availableOperandList.size(); indexOfCurrNotation++) {
                    if (availableOperandList.get(indexOfCurrNotation).isAvailableDigit(readedCodepoint)) {
                        currentOperand = availableOperandList.get(indexOfCurrNotation);// например Arabic
                        currentOperandCodepoints.add(readedCodepoint);
                        isNotationFound = true;
                        break;
                    } /*else {
                        throw new WrongExpression("Bad character: " +
                                (char) readedCodepoint + " in expression at " + (i + 1) + " position.");
                    }*/
                }
            } else { // если система счисления уже была найдена, то уже сразу проверяем входит ли codepoint в нее
                if (currentOperand.isAvailableDigit(readedCodepoint)) {
                    // Добавим codePointAt(i) в список формирования конечного операнда (т.к. операнд может состоять из нескольких символов)
                    currentOperandCodepoints.add(readedCodepoint);
                } else { // если не входит, то это либо оператор, либо мусорный символ => исключение
                    // проверим оператор или нет
                    for (int j = 0; j < availableOperatorsList.size(); j++) {
                        if (availableOperatorsList.get(j).getCodepoint() == readedCodepoint) {

                            currentOperand.setNumber(currentOperandCodepoints);
                            currentOperand.saveValue(currentOperand.toDecimal());

                            tempOperandStack.push(currentOperand);
                            currentOperandCodepoints.clear();
                            isNotationFound = false;

                            if (tempOperatorStack.empty()) {
                                tempOperatorStack.push(availableOperatorsList.get(j));
                            } else {
                                while (availableOperatorsList.get(j).getPrecedence() <= tempOperatorStack.pop().getPrecedence()) {
                                    tempOperatorStack.add(tempOperatorStack.pop());
                                }
                                tempOperatorStack.push(availableOperatorsList.get(j));
                            }
                            break;
                        } else {
                            throw new WrongExpression("Bad character: " +
                                    (char) readedCodepoint + " in expression at " + (i + 1) + " position.");
                        }
                    }
                }
            }
        }
        operandStack = (Stack<BaseOperand>) tempOperandStack.clone();
        operatorStack = (Stack<Operator>) tempOperatorStack.clone();
        return resultPostfixList;
    }
}
