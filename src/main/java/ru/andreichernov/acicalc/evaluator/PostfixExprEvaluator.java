package ru.andreichernov.acicalc.evaluator;

import ru.andreichernov.acicalc.exception.WrongPostfixNotation;
import ru.andreichernov.acicalc.MathObject;
import ru.andreichernov.acicalc.operand.BaseOperand;
import ru.andreichernov.acicalc.operator.BaseOperator;

import java.util.List;
import java.util.Stack;

public class PostfixExprEvaluator implements ExpEvaluator {
    /**
     * Будем использовать следующий алгоритм:
     * 1) Инициализируем пустой стек.
     * 2) Будем читать postfix выражение слева на право по-элементно.
     * 3) Если элемент - операнд, то пушим его в стек.
     * 4) Если элемент оператор, то берем из стека два операнда, выполняем операцию, соответствующую оператору, и
     * пушим результат обратно в стек. Здесь подразумевается, что если нет двух операндов в стеке, то
     * постфиксное выражение было ошибочным.
     * 5) В конечном итоге, берем результат с вершиным стека.
     * Если постфиксное выражение было корректно, то стек после этого должен быть пустым.
     *
     * @param postfixExpression - List с элементами выражения в постфиксной форме
     * @return результат вычисления выражения в формате Double
     */
    @Override
    public Double evaluate(List<MathObject> postfixExpression) throws WrongPostfixNotation {
        Double result;

        Stack<Double> stackOfOperand = new Stack<>(); // 1) Инициализируем пустой стек.

        for (MathObject objectOfExpression : postfixExpression) { // 2) Будем читать postfix выражение слева на право по-элементно.

            if (objectOfExpression instanceof BaseOperand){// 3) Если элемент - операнд, то пушим его в стек.
                stackOfOperand.push(getDoubleFromOperand((BaseOperand) objectOfExpression));
            }
            else if(objectOfExpression instanceof BaseOperator){
                //4) Если элемент оператор, то берем из стека два операнда
                if(stackOfOperand.size() < 2){//Если нет двух операндов в стеке, то
                    // постфиксное выражение было ошибочным.
                    throw new WrongPostfixNotation("In Stack must be at least 2 numbers.");
                }
                Double rightOperand = stackOfOperand.pop();
                Double leftOperand = stackOfOperand.pop();
                // выполняем операцию, соответствующую оператору,
                Double subTotalResult = getResultWithOperand((BaseOperator) objectOfExpression, leftOperand, rightOperand);
                //и пушим результат обратно в стек.
                stackOfOperand.push(subTotalResult);
            }
            else {
                throw new WrongPostfixNotation("Stack must contain only operand and operators.");
            }
        }
        result = stackOfOperand.pop();
        if (!stackOfOperand.empty()){
            throw new WrongPostfixNotation("Stack must be empty after calculation.");
        }
        return result;
    }

    private Double getResultWithOperand(final BaseOperator objectOfExpression, double leftOperand, double rightOperand) {
        return objectOfExpression.evaluate(leftOperand, rightOperand);
    }

    private Double getDoubleFromOperand(final BaseOperand operand){
        return (double) operand.getValue();
    }
}
