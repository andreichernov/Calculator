package ru.andreichernov.acicalc.math.evaluator;

import ru.andreichernov.acicalc.exception.WrongPostfixNotation;
import ru.andreichernov.acicalc.math.MathObject;

import java.util.List;

public interface ExpEvaluator {
    Double evaluate(List<MathObject> postfixExpression) throws WrongPostfixNotation;
}
