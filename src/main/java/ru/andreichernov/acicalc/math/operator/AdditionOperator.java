package ru.andreichernov.acicalc.math.operator;

public class AdditionOperator extends BaseOperator {
    public AdditionOperator() {
        super("+", 5, true);
    }

    public double evaluate(final double leftOperand, final double rightOperand) {
        return leftOperand + rightOperand;
    }
}
