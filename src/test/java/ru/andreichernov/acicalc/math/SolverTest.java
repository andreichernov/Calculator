package ru.andreichernov.acicalc.math;

import org.junit.Test;
import ru.andreichernov.acicalc.Solver;
import ru.andreichernov.acicalc.operator.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolverTest {
    @Test
    public void getAvailableOperators() throws Exception {
        Solver solver = new Solver();
        List<Operator> operators = new ArrayList<>();
        operators.add(new AdditionOperator());
        operators.add(new SubtractionOperator());
        operators.add(new MultiplicationOperator());
        operators.add(new DivisionOperator());

        String expectedOperators = "+-*/";
        assertEquals(expectedOperators, solver.getAvailableOperators(operators));
    }

}