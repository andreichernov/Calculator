package ru.andreichernov.acicalc.operator;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorsHelperTest {
    @Test
    public void getAvailableOperatorsString() throws Exception {
        OperatorsHelper operatorsHelper = new OperatorsHelper();
        String expected = "+-*/";
        assertEquals(expected, operatorsHelper.getAvailableOperatorsString());
    }


}