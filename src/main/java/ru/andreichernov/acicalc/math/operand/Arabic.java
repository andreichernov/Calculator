package ru.andreichernov.acicalc.math.operand;

import java.util.List;

/**
 * '\u0030' through '\u0039', ISO-LATIN-1 digits ('0' through '9')
 */
public class Arabic extends BaseOperand{
    //                                                    {0,  1,  2,  3,  4,  5,  6,  7,  8,  9}
    private final static Integer[] valuesCodepointArray = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};

    public Arabic(){
        super(Arabic.valuesCodepointArray);
    }

    @Override
    public int toDecimal() {
        List<Integer> list = super.getNumber();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer aList : list) {
            stringBuilder.appendCodePoint(aList);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
