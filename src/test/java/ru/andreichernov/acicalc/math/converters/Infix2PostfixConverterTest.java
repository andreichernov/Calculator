package ru.andreichernov.acicalc.math.converters;

import org.junit.Test;
import ru.andreichernov.acicalc.math.MathObject;
import ru.andreichernov.acicalc.math.operand.Arabic;
import ru.andreichernov.acicalc.math.operand.BaseOperand;
import ru.andreichernov.acicalc.math.operator.AdditionOperator;
import ru.andreichernov.acicalc.math.operator.BaseOperator;
import ru.andreichernov.acicalc.math.operator.MultiplicationOperator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Infix2PostfixConverterTest {
    @Test
    public void convert2List() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        List<MathObject> postfixList = new ArrayList<>();
        String infix = "10*2+34";
        BaseOperand firstNumber = new Arabic();
        firstNumber.saveDirect2Decimal(10);

        BaseOperator mult = new MultiplicationOperator();

        BaseOperand secondNumber = new Arabic();
        secondNumber.saveDirect2Decimal(2);

        BaseOperator add = new AdditionOperator();

        BaseOperand thirdNumber = new Arabic();
        thirdNumber.saveDirect2Decimal(34);

        postfixList.add(firstNumber);
        postfixList.add(secondNumber);
        postfixList.add(mult);
        postfixList.add(thirdNumber);
        postfixList.add(add);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }
}