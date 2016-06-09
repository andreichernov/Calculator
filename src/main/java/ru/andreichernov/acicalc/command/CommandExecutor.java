package ru.andreichernov.acicalc.command;

import ru.andreichernov.acicalc.Operation;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static Map<Operation, Command> map = new HashMap<>();

    static
    {
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.CALC, new CalcCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }
    public static void execute(Operation operation) throws InterruptOperationException {
        map.get(operation).execute();
    }
}
