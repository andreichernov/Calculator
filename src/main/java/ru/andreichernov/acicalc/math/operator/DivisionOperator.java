package ru.andreichernov.acicalc.math.operator;

public class DivisionOperator extends BaseOperator {
    public DivisionOperator() {
        super("/", 6);
    }

    public double evaluate(final double leftOperand, final double rightOperand) {
        return leftOperand / rightOperand;
    }
}