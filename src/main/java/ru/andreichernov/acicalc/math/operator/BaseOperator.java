package ru.andreichernov.acicalc.math.operator;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class BaseOperator implements Operator  {
    private final Logger LOG = getLogger(this.getClass().getName());

    private String symbol = null;

    private int precedence = 0;

    private boolean unary = false;

    BaseOperator(final String symbol, final int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    BaseOperator(String symbol, int precedence, boolean unary) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.unary = unary;
    }

    public double evaluate(final double leftOperand, final double rightOperand) {
        return 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getCodepoint(){
        return symbol.codePointAt(0);
    }

    public int getPrecedence() {
        return precedence;
    }

    public int getLength() {
        return symbol.length();
    }

    public boolean isUnary() {
        return unary;
    }

    public boolean equals(final Object object) {
        if (object == null) {
            return false;
        }

        try {
            if (!(object instanceof BaseOperator)) {
                throw new IllegalStateException("Invalid operator.");
            }
        }
        catch (IllegalStateException e){
            LOG.debug(e.getMessage());
        }

        BaseOperator operator = (BaseOperator) object;

        return symbol.equals(operator.getSymbol());
    }

    public String toString() {
        return getSymbol();
    }

}
