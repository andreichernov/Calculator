package ru.andreichernov.acicalc.math.converters;

import org.junit.Test;

import static org.junit.Assert.*;

public class Infix2PostfixConverterTest {
    @Test
    public void convert() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String expression = "ABC";
        assertEquals(expression, mathNotationConverter.convert(expression));
    }

}