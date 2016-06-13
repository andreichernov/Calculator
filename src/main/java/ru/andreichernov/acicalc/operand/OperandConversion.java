package ru.andreichernov.acicalc.operand;

/**
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#isDigit(int)
 * Some Unicode character ranges that contain digits:
 * '\u0030' through '\u0039', ISO-LATIN-1 digits ('0' through '9')
 * '\u0660' through '\u0669', Arabic-Indic digits
 * '\u06F0' through '\u06F9', Extended Arabic-Indic digits
 * '\u0966' through '\u096F', Devanagari digits
 * '\uFF10' through '\uFF19', Fullwidth digits
 * Many other character ranges contain digits as well.
 */
public interface OperandConversion {
    int toDecimal();
}
