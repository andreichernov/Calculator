package ru.andreichernov.acicalc.math.converters;

import org.junit.Test;
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
        String infix = "10+23";
        //String postfix = "123*+";
        ArrayList postfixList = new ArrayList<>();
        BaseOperand firstNumber = new Arabic();
        firstNumber.saveValue(1);
        BaseOperand secondNumber = new Arabic();
        secondNumber.saveValue(2);
        BaseOperator baseOperator = new AdditionOperator();

        //postfixList.add(firstNumber);
        //postfixList.add(secondNumber);
        //postfixList.add(baseOperator);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }
}