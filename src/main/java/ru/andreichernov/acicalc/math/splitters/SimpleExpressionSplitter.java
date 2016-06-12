package ru.andreichernov.acicalc.math.splitters;

import ru.andreichernov.acicalc.math.operator.Operator;
import ru.andreichernov.acicalc.math.operator.OperatorsHelper;

import java.util.*;

public class SimpleExpressionSplitter implements ExpressionSplitter {
    private String availableOperators;

    public SimpleExpressionSplitter() {
        availableOperators = new OperatorsHelper().getAvailableOperatorsString();
    }

    @Override
    public Map<String, List<String>> split2Map(String cleanedExpression) {
        List<String> operatorList = new ArrayList<>();
        List<String> operandList = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(cleanedExpression, availableOperators, true);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (availableOperators.contains(token)) {
                operatorList.add(token);
            } else {
                operandList.add(token);
            }
        }
        Map<String, List<String>> operatorsAndOperandsMap = new HashMap<>();
        operatorsAndOperandsMap.put("operatorList", operandList);
        operatorsAndOperandsMap.put("operandList", operandList);
        return operatorsAndOperandsMap;
    }

    public List<String> split2List(String cleanedExpression){
        List<String> operatorList = new ArrayList<>();
        List<String> operandList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(cleanedExpression, availableOperators, true);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (availableOperators.contains(token)) {
                operatorList.add(token);
            } else {
                operandList.add(token);
            }
        }
        return null;
    }
}
