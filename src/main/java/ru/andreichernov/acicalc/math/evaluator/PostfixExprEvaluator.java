package ru.andreichernov.acicalc.math.evaluator;

import ru.andreichernov.acicalc.math.MathObject;

import java.util.List;

public class PostfixExprEvaluator implements ExpEvaluator{
    public Double evaluate(String postfixExpression){
        Double result = -49.0;
        //
        return result;
    }

    @Override
    public Double evaluate(List<MathObject> expression) {
        return null;
    }
}
