package ru.andreichernov.acicalc.math.converters;

import org.junit.Test;
import ru.andreichernov.acicalc.math.MathObject;
import ru.andreichernov.acicalc.math.operand.Arabic;
import ru.andreichernov.acicalc.math.operand.BaseOperand;
import ru.andreichernov.acicalc.math.operand.Roman;
import ru.andreichernov.acicalc.math.operator.AdditionOperator;
import ru.andreichernov.acicalc.math.operator.BaseOperator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Infix2PostfixConverterTest {
    @Test
    public void convert2List() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "1+2";
        //String postfix = "123*+";
        List<MathObject> postfixList = new ArrayList<>();
        BaseOperand firstNumber = new Arabic();
        firstNumber.saveValue(1);
        BaseOperand secondNumber = new Arabic();
        secondNumber.saveValue(2);
        BaseOperator baseOperator = new AdditionOperator();
        postfixList.add((MathObject) firstNumber);
        postfixList.add((MathObject) baseOperator);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }
}