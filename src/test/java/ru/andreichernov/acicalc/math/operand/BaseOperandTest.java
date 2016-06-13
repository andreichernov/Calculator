package ru.andreichernov.acicalc.math.operand;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseOperandTest {
    @Test
    public void isAvailableDigitInArabic() throws Exception {
        BaseOperand baseOperand = new Arabic();
        int codepointOf0 = "0".codePointAt(0);
        assertEquals(true, baseOperand.isIncludeCodepoint(codepointOf0));

        int codepointOfR = "R".codePointAt(0);
        assertEquals(false, baseOperand.isIncludeCodepoint(codepointOfR));


    }

    @Test
    public void isAvailableDigitInRoman() throws Exception {
        BaseOperand baseOperand = new Roman();
        int codepointOf0 = "0".codePointAt(0);
        assertEquals(false, baseOperand.isIncludeCodepoint(codepointOf0));

        int codepointOfX = "X".codePointAt(0);
        assertEquals(true, baseOperand.isIncludeCodepoint(codepointOfX));


    }

}