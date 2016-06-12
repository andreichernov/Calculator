package ru.andreichernov.acicalc.math.converters;

import ru.andreichernov.acicalc.math.MathObject;
import ru.andreichernov.acicalc.math.operand.Arabic;
import ru.andreichernov.acicalc.math.operand.BaseOperand;
import ru.andreichernov.acicalc.math.operand.OperandHelper;
import ru.andreichernov.acicalc.math.operator.Operator;
import ru.andreichernov.acicalc.math.operator.OperatorsHelper;
import ru.andreichernov.acicalc.math.splitters.SimpleExpressionSplitter;

import java.util.*;

public class Infix2PostfixConverter implements MathNotationConverter {
    private List<Operator> availableOperatorsList;
    private List<BaseOperand> availableOperandList;
    private Stack<Double> operandStack = new Stack<>();
    private Stack<Operator> operatorStack = new Stack<>();

    public Infix2PostfixConverter() {
        availableOperatorsList = new OperatorsHelper().getAvailableOperatorsList();
        availableOperandList = new OperandHelper().getAvailableOperandsList();
    }

    @Override
    public List<MathObject> convert2List(String infixExpression) {

        List<MathObject> resultPostfixList = null;
        BaseOperand currentOperand = null;
        List<Integer> currentOperandCodepoints = new ArrayList<>();
        int expressionSize = infixExpression.length();

        boolean isNotationFound = false;
        for (int i = 0; i < expressionSize; i++) {
            int readedCodepoint = infixExpression.codePointAt(i);
            // Если codePoint прочитанного символа входит в одну из разрешенных систем счисления,
            // то запомним в какую систему счисления он входит
            if (!isNotationFound) {
                for (int indexOfCurrNotation = 0; indexOfCurrNotation < availableOperandList.size(); indexOfCurrNotation++) {
                    if (availableOperandList.get(i).isAvailableDigit(readedCodepoint)) {
                        currentOperand = availableOperandList.get(i);// например Arabic
                        currentOperandCodepoints.add(readedCodepoint);
                        isNotationFound = true;
                    }
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
                            resultPostfixList.add((MathObject) currentOperand);
                            currentOperandCodepoints.clear();
                            isNotationFound = false;

                            if (operatorStack.empty()){
                                operatorStack.push(availableOperatorsList.get(j));
                            }else{
                                while(availableOperatorsList.get(j).getPrecedence() <= operatorStack.pop().getPrecedence())
                                {
                                    resultPostfixList.add((MathObject) operatorStack.pop());
                                }
                                operatorStack.push(availableOperatorsList.get(j));
                            }
                        }
                    }

                }
            }
        }
        return resultPostfixList;
    }
}
