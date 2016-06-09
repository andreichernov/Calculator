package ru.andreichernov.acicalc.math.converters;

public class Infix2PostfixConverter implements MathNotationConverter {
    @Override
    public String convert(String infixExpression){
        String postfixExpression = new String(infixExpression);

        return postfixExpression;
    }
}
