package ru.andreichernov.acicalc.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperatorsHelper {
    private List<Operator> operators = new ArrayList<>();

    public OperatorsHelper() {
        initOperators();
    }

    private void initOperators() {
        operators.add(new AdditionOperator());
        operators.add(new SubtractionOperator());
        operators.add(new MultiplicationOperator());
        operators.add(new DivisionOperator());
    }

    public List<Operator> getAvailableOperatorsList(){
        return operators;
    }

    public String getAvailableOperatorsString(){
        return operators.stream().map(Operator::getSymbol).collect(Collectors.joining());
    }

    public List<Integer> getAvailableOperatorsCodepoint(){
        return operators.stream().map(Operator::getCodepoint).collect(Collectors.toList());
    }
}
