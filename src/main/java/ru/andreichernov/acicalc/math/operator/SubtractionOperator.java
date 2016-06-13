package ru.andreichernov.acicalc.math.operator;

public class SubtractionOperator extends BaseOperator {
    public SubtractionOperator() {
        super("-", 5, true);
    }

    public double evaluate(final double leftOperand, final double rightOperand) {
        return leftOperand - rightOperand;
    }
}