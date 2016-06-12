package ru.andreichernov.acicalc.math.operator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OperatorsHelperTest {
    @Test
    public void getAvailableOperatorsString() throws Exception {
        OperatorsHelper operatorsHelper = new OperatorsHelper();
        String expected = "+-*/";
        assertEquals(expected, operatorsHelper.getAvailableOperatorsString());
    }


}