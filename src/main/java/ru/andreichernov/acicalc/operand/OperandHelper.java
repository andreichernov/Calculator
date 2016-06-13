package ru.andreichernov.acicalc.operand;

import java.util.ArrayList;
import java.util.List;

public class OperandHelper {
    private List<BaseOperand> operandList = new ArrayList<>();

    public OperandHelper() {
        initOperands();
    }

    private void initOperands() {
        operandList.add(new Arabic());
        operandList.add(new Roman());
    }

    public List<BaseOperand> getAvailableOperandsList(){
        return operandList;
    }
}
