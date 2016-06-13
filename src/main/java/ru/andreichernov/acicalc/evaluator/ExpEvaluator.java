package ru.andreichernov.acicalc.evaluator;

import ru.andreichernov.acicalc.exception.WrongPostfixNotation;
import ru.andreichernov.acicalc.MathObject;

import java.util.List;

public interface ExpEvaluator {
    Double evaluate(List<MathObject> postfixExpression) throws WrongPostfixNotation;
}
