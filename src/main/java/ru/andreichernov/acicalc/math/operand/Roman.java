package ru.andreichernov.acicalc.math.operand;

public class Roman extends BaseOperand {
    //https://en.wikipedia.org/wiki/Numerals_in_Unicode#Roman_numerals

    private static Integer[] valuesCodepointArray = {};
    private static String[] valuesCharArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    Roman() {
        super(Roman.valuesCharArray);
    }
}
