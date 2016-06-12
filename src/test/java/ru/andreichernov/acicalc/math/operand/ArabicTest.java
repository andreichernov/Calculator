package ru.andreichernov.acicalc.math.operand;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArabicTest {
    @Test
    public void toDecimal() throws Exception {
        BaseOperand baseOperand = new Arabic();
        baseOperand.setNumber(Arrays.asList(49,50,51));
        int exprected = 123;
        assertEquals(exprected, baseOperand.toDecimal());
    }

}