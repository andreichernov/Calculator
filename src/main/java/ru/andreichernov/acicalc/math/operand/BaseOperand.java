package ru.andreichernov.acicalc.math.operand;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.math.MathObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class BaseOperand implements OperandConversion, MathObject{

    private final Logger LOG = getLogger(this.getClass().getName());
    private List<Integer> valuesRangeList = new ArrayList<>();
    private Integer[] valuesCodepointArray;
    private List<Integer> number;

    public int getValue() {
        return value;
    }

    private int value;


    BaseOperand(final Integer[] valuesCodepointArray) {
        init(valuesCodepointArray);
    }

    BaseOperand(final String[] valuesCharArray) {
        init(convertChars2Codepoints(valuesCharArray));
    }

    private void init(final Integer[] valuesCodepointArray) {
        this.valuesCodepointArray = valuesCodepointArray;
        valuesRangeList.addAll(Arrays.asList(valuesCodepointArray));
    }

    private Integer[] convertChars2Codepoints(final String[] valuesCharArray) {
        Integer[] convertationArray = new Integer[valuesCharArray.length];
        for (int i = 0; i < valuesCharArray.length; i++) {
            convertationArray[i] = valuesCharArray[i].codePointAt(0);
        }
        return convertationArray;
    }

    public boolean isIncludeCodepoint(final int codepoint){
        return valuesRangeList.contains(codepoint);
    }

    List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = new ArrayList<>(number);
    }

    protected Integer[] getValuesCodepointArray() {
        return valuesCodepointArray;
    }

    @Override
    public int toDecimal() {
        return Integer.MIN_VALUE;
    }

    public void saveDirect2Decimal(int decimalValue){
        this.value = decimalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseOperand)) return false;

        BaseOperand that = (BaseOperand) o;

        return value == that.value;

    }

    @Override
    public int hashCode() {
        // как-то неправильно возможно
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public static List<Integer> getCodePointsListFromString(String string){
        List<Integer> listOfCodepoints = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            listOfCodepoints.add(string.codePointAt(i));
        }
        return listOfCodepoints;
    }
}


