package ru.andreichernov.acicalc.evaluator;

import org.junit.Test;
import ru.andreichernov.acicalc.converters.Infix2PostfixConverter;
import ru.andreichernov.acicalc.converters.MathNotationConverter;

import static org.junit.Assert.*;

/**
 * Тесты класса вычисления постфиксного выражения
 */
public class PostfixExprEvaluatorTest {
    @Test
    public void evaluateValidArabicMixPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "1*2+3*4";

        ExpEvaluator expEvaluator = new PostfixExprEvaluator();
        int compareResult = Double.compare(14.0, expEvaluator.evaluate(mathNotationConverter.convert2List(infix)));
        assertEquals(0, compareResult);
    }

    @Test
    public void evaluateValidArabicDirectPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "10*2+34";

        ExpEvaluator expEvaluator = new PostfixExprEvaluator();
        int compareResult = Double.compare(54.0, expEvaluator.evaluate(mathNotationConverter.convert2List(infix)));
        assertEquals(0, compareResult);
    }

    @Test
    public void evaluateValidArabicHardPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "1+23*4-4*23+56/8-7+1000-500*2";

        ExpEvaluator expEvaluator = new PostfixExprEvaluator();
        int compareResult = Double.compare(1.0, expEvaluator.evaluate(mathNotationConverter.convert2List(infix)));
        assertEquals(0, compareResult);
    }

    @Test
    public void evaluateValidRomanMixPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "X+2*3-IV";

        ExpEvaluator expEvaluator = new PostfixExprEvaluator();
        int compareResult = Double.compare(12.0, expEvaluator.evaluate(mathNotationConverter.convert2List(infix)));
        assertEquals(0, compareResult);
    }
    @Test
    public void evaluateValidRomanHardPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "I+23*IV-4*23+56/VIII-7+1000-500*II";

        ExpEvaluator expEvaluator = new PostfixExprEvaluator();
        int compareResult = Double.compare(1.0, expEvaluator.evaluate(mathNotationConverter.convert2List(infix)));
        assertEquals(0, compareResult);
    }

}