package ru.andreichernov.acicalc.math.converters;

import ru.andreichernov.acicalc.math.MathObject;

import java.util.List;

public interface MathNotationConverter {
    List<MathObject> convert2List(String infixExpression);
}
