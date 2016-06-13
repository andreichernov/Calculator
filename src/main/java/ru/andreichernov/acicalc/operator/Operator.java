package ru.andreichernov.acicalc.operator;

public interface Operator {
    double evaluate(double leftOperand, double rightOperand);
    String getSymbol();
    int getCodepoint();
    int getPrecedence();
    int getLength();
    boolean isUnary();
}
