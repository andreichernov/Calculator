package ru.andreichernov.acicalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operation {

    INFO,
    CALC,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        switch (i) {
            case 1:
                return INFO;
            case 2:
                return CALC;
            case 3:
                return EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static List<String> getOperations(){
        return Arrays.stream(Operation.values()).map(Enum::toString).collect(Collectors.toList());
    }
}
