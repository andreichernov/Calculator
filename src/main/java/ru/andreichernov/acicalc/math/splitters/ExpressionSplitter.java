package ru.andreichernov.acicalc.math.splitters;

import java.util.List;
import java.util.Map;

public interface ExpressionSplitter {
    Map<String, List<String>> split2Map(String cleanedExpression);
    List<String> split2List(String cleanedExpression);


}
