package ru.andreichernov.acicalc.math.operator;

public class MultiplicationOperator extends BaseOperator {
    public MultiplicationOperator() {
        super("*", 6);
    }

    public double evaluate(final double leftOperand, final double rightOperand) {
        return leftOperand * rightOperand;
    }
}
