package ru.andreichernov.acicalc.converters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.andreichernov.acicalc.MathObject;
import ru.andreichernov.acicalc.exception.WrongExpression;
import ru.andreichernov.acicalc.operand.Arabic;
import ru.andreichernov.acicalc.operand.BaseOperand;
import ru.andreichernov.acicalc.operator.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Infix2PostfixConverterTest {

    @Test
    public void convertValidArabicDirectPrecedence() throws Exception {
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
    public void convertValidArabicBackwardPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "10+2*3-4";
        //System.out.print("On input: [10, +, 2, *, 3, -, 4]");
        List<MathObject> postfixList = new ArrayList<>();// 10 2 3 * + 4 -

        BaseOperand firstNumber = new Arabic();
        firstNumber.saveDirect2Decimal(10);
        postfixList.add(firstNumber);

        BaseOperand secondNumber = new Arabic();
        secondNumber.saveDirect2Decimal(2);
        postfixList.add(secondNumber);

        BaseOperand thirdNumber = new Arabic();
        thirdNumber.saveDirect2Decimal(3);
        postfixList.add(thirdNumber);

        BaseOperator mult = new MultiplicationOperator();
        postfixList.add(mult);

        BaseOperator add = new AdditionOperator();
        postfixList.add(add);

        BaseOperand fourthNumber = new Arabic();
        fourthNumber.saveDirect2Decimal(4);
        postfixList.add(fourthNumber);

        BaseOperator sub = new SubtractionOperator();
        postfixList.add(sub);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }

    @Test
    public void convertValidArabicMixPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "1*2+3*4";
        //System.out.print("On input: [1, *, 2, +, 3, *, 4]");
        List<MathObject> postfixList = new ArrayList<>();// 1 2 * 3 4 * +

        BaseOperand firstNumber = new Arabic();
        firstNumber.saveDirect2Decimal(1);
        postfixList.add(firstNumber);

        BaseOperand secondNumber = new Arabic();
        secondNumber.saveDirect2Decimal(2);
        postfixList.add(secondNumber);

        BaseOperator mult = new MultiplicationOperator();
        postfixList.add(mult);

        BaseOperand thirdNumber = new Arabic();
        thirdNumber.saveDirect2Decimal(3);
        postfixList.add(thirdNumber);

        BaseOperand fourthNumber = new Arabic();
        fourthNumber.saveDirect2Decimal(4);
        postfixList.add(fourthNumber);

        BaseOperator mult2 = new MultiplicationOperator();
        postfixList.add(mult2);

        BaseOperator add = new AdditionOperator();
        postfixList.add(add);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }

    @Test
    public void convertValidArabicHardPrecedence() throws Exception {
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

    @Test
    public void convertValidRomanBackwardPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "X+2*3-IV"; // 12
        //System.out.print("On input: [10, +, 2, *, 3, -, 4]");
        List<MathObject> postfixList = new ArrayList<>();// 10 2 3 * + 4 -

        BaseOperand firstNumber = new Arabic();
        firstNumber.saveDirect2Decimal(10);
        postfixList.add(firstNumber);

        BaseOperand secondNumber = new Arabic();
        secondNumber.saveDirect2Decimal(2);
        postfixList.add(secondNumber);

        BaseOperand thirdNumber = new Arabic();
        thirdNumber.saveDirect2Decimal(3);
        postfixList.add(thirdNumber);

        BaseOperator mult = new MultiplicationOperator();
        postfixList.add(mult);

        BaseOperator add = new AdditionOperator();
        postfixList.add(add);

        BaseOperand fourthNumber = new Arabic();
        fourthNumber.saveDirect2Decimal(4);
        postfixList.add(fourthNumber);

        BaseOperator sub = new SubtractionOperator();
        postfixList.add(sub);

        assertEquals(postfixList, mathNotationConverter.convert2List(infix));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void convertInvalidRomanBackwardPrecedence() throws Exception {
        MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
        String infix = "X++2*3-IV"; // 12 // 10 2 3 * + 4 -
        thrown.expect(WrongExpression.class);
        mathNotationConverter.convert2List(infix);

    }
}