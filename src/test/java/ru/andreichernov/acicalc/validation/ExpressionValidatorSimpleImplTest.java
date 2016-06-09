package ru.andreichernov.acicalc.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionValidatorSimpleImplTest {
    @Test
    public void validate() throws Exception {
        ExpressionValidatorSimpleImpl validatorSimple = new ExpressionValidatorSimpleImpl();
        assertEquals(false, validatorSimple.validate(""));
        assertEquals(true, validatorSimple.validate("1"));
    }

}