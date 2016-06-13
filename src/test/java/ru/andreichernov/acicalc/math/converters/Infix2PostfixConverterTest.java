package ru.andreichernov.acicalc.math.converters;

import org.junit.Before;
import org.junit.Test;
import ru.andreichernov.acicalc.math.MathObject;
import ru.andreichernov.acicalc.math.operand.Arabic;
import ru.andreichernov.acicalc.math.operand.BaseOperand;
import ru.andreichernov.acicalc.math.operator.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Infix2PostfixConverterTest {

    @Test
    public void convert2ListArabicSimplePrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "10*2+34";
        List<MathObject> postfixList = new ArrayList<>();
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

    @Test
    public void convert2ListArabicDifficultPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "10+2*3";
        List<MathObject> postfixList = new ArrayList<>();// 10 2 3 * +

        BaseOperand firstNumber = new Arabic();
        firstNumber.saveDirect2Decimal(10);
        postfixList.add(firstNumber);

        BaseOperand secondNumber = new Arabic();
        secondNumber.saveDirect2Decimal(2);
        postfixList.add(secondNumber);

        BaseOperand thirdNumber = new Arabic();
        thirdNumber.saveDirect2Decimal(34);
        postfixList.add(thirdNumber);

        BaseOperator mult = new MultiplicationOperator();
        postfixList.add(mult);

        BaseOperator add = new AdditionOperator();
        postfixList.add(add);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }

    @Test
    public void convert2ListArabicHardPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "1+23*4-4*23+56/8-7+1000-500*2";
        // in postfix must be: 1 23 4 * + 4 23 * - 56 8 / + 7 - 1000 + 500 2 * -
        List<MathObject> postfixList = new ArrayList<>();

        BaseOperand num01 = new Arabic();
        num01.saveDirect2Decimal(1);
        postfixList.add(num01);

        BaseOperand num02 = new Arabic();
        num02.saveDirect2Decimal(23);
        postfixList.add(num02);

        BaseOperand num03 = new Arabic();
        num03.saveDirect2Decimal(4);
        postfixList.add(num03);

        BaseOperator operator01_mult = new MultiplicationOperator();
        postfixList.add(operator01_mult);

        BaseOperator operator02_add = new AdditionOperator();
        postfixList.add(operator02_add);

        BaseOperand num04 = new Arabic();
        num04.saveDirect2Decimal(4);
        postfixList.add(num04);

        BaseOperand num05 = new Arabic();
        num05.saveDirect2Decimal(23);
        postfixList.add(num05);

        BaseOperator operator03_mult = new MultiplicationOperator();
        postfixList.add(operator03_mult);

        BaseOperator operator04_sub = new SubtractionOperator();
        postfixList.add(operator04_sub);

        BaseOperand num06 = new Arabic();
        num06.saveDirect2Decimal(56);
        postfixList.add(num06);

        BaseOperand num07 = new Arabic();
        num07.saveDirect2Decimal(8);
        postfixList.add(num07);

        BaseOperator operator05_div = new DivisionOperator();
        postfixList.add(operator05_div);

        BaseOperator operator06_add = new AdditionOperator();
        postfixList.add(operator06_add);

        BaseOperand num08 = new Arabic();
        num08.saveDirect2Decimal(7);
        postfixList.add(num08);

        BaseOperator operator07_sub = new SubtractionOperator();
        postfixList.add(operator07_sub);

        BaseOperand num09 = new Arabic();
        num09.saveDirect2Decimal(1000);
        postfixList.add(num09);

        BaseOperator operator08_add = new AdditionOperator();
        postfixList.add(operator08_add);

        BaseOperand num10 = new Arabic();
        num10.saveDirect2Decimal(500);
        postfixList.add(num10);

        BaseOperand num11 = new Arabic();
        num11.saveDirect2Decimal(2);
        postfixList.add(num11);

        BaseOperator operator09_mult = new MultiplicationOperator();
        postfixList.add(operator09_mult);

        BaseOperator operator10_sub = new SubtractionOperator();
        postfixList.add(operator10_sub);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }
}