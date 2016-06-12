package ru.andreichernov.acicalc.command;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.Operation;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

public class CommandExecutor {
    private static final Logger LOG = getLogger(CommandExecutor.class);

    private static Map<Operation, Command> map = new HashMap<>();

    static {
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.CALC, new CalcCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    public static void execute(Operation operation) throws InterruptOperationException {
        LOG.info("Transition to execute operation: " + operation.toString());
        map.get(operation).execute();
    }
}
