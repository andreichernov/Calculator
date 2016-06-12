package ru.andreichernov.acicalc.math.evaluator;

import java.util.List;

public interface ExpEvaluator {
    Double evaluate(String expression);
    Double evaluate(List expression);
}
