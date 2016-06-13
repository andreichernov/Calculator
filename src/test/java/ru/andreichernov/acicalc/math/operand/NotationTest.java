package ru.andreichernov.acicalc.math.operand;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NotationTest{
    @Test
    public void arabToDecimal() throws Exception {
        BaseOperand baseOperand = new Arabic();
        baseOperand.setNumber(Arrays.asList(49,50,51));
        int exprected = 123;
        assertEquals(exprected, baseOperand.toDecimal());
    }

    @Test
    public void romanToDecimal() throws Exception {
        BaseOperand baseOperand = new Roman();
        List<Integer> list = BaseOperand.getCodePointsListFromString("XVIII");
        baseOperand.setNumber(list);
        int exprected = 18;
        assertEquals(exprected, baseOperand.toDecimal());
    }

}