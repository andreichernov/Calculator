package ru.andreichernov.acicalc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleHelperTest {
    @Test
    public void checkWithRegExp() throws Exception {
        boolean inRangeOfDefinition = ConsoleHelper.checkWithRegExp("1");
        assertTrue(inRangeOfDefinition);

        boolean outRangeOfDefinition = ConsoleHelper.checkWithRegExp("zz");
        assertFalse(outRangeOfDefinition);

        boolean nullOfDefinition = ConsoleHelper.checkWithRegExp("zz");
        assertFalse(nullOfDefinition);
    }



}