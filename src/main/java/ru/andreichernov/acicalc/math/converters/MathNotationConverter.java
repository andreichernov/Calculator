package ru.andreichernov.acicalc.math.converters;

import ru.andreichernov.acicalc.exception.WrongExpression;

import java.util.List;

public interface MathNotationConverter {
    List convert2List(String infixExpression) throws WrongExpression;
}
