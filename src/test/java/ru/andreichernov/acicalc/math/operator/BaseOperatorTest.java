package ru.andreichernov.acicalc.math.operator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BaseOperatorTest {
    @Test
    public void getCodepoint() throws Exception {
        List<Operator> operators = new ArrayList<>();
        operators.add(new AdditionOperator());
        operators.add(new SubtractionOperator());
        operators.add(new MultiplicationOperator());
        operators.add(new DivisionOperator());

        int[] expectedCodepoints = {43, 45, 42, 47};
        for (int i = 0; i < operators.size(); i++) {
            assertEquals(expectedCodepoints[i], operators.get(i).getCodepoint());
        }
    }

}