package ru.andreichernov.acicalc.math.solvers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostfixExprEvaluatorTest {
    @Test
    public void evaluate() throws Exception {
        ExpEvaluator expEvaluator = new PostfixExprEvaluator();
        int compareResult = Double.compare(-49.0, expEvaluator.evaluate("NOTHING_HERE"));
        assertEquals(0, compareResult);
    }

}