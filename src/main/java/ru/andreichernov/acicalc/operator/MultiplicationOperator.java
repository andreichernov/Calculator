package ru.andreichernov.acicalc.operator;

public class MultiplicationOperator extends BaseOperator {
    // 42
    public MultiplicationOperator() {
        super("*", 6);
    }

    public double evaluate(final double leftOperand, final double rightOperand) {
        return leftOperand * rightOperand;
    }
}
