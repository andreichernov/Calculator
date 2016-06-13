package ru.andreichernov.acicalc;


import org.slf4j.Logger;
import ru.andreichernov.acicalc.command.CommandExecutor;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

import java.util.Locale;

import static org.slf4j.LoggerFactory.getLogger;

public class Calculator {
    private static final Logger LOG = getLogger(Calculator.class);

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            LOG.error(e.getMessage());
        }
    }
}
