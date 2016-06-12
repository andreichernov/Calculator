package ru.andreichernov.acicalc.math.evaluator;

import ru.andreichernov.acicalc.math.MathObject;

import java.util.List;

public interface ExpEvaluator {
    Double evaluate(String expression);
    Double evaluate(List<MathObject> expression);
}
