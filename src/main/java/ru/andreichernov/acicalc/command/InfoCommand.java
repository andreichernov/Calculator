package ru.andreichernov.acicalc.command;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.ConsoleHelper;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

import static org.slf4j.LoggerFactory.getLogger;


class InfoCommand implements Command {
    private static final Logger LOG = getLogger(InfoCommand.class);

    public void execute() throws InterruptOperationException {
        LOG.info("In InfoCommand.");
        ConsoleHelper.writeMessage("Task description:\n" +
                "\"We need a way to evaluate a arithmetic formula which contains 4 basic operations\n" +
                "(+, -, *, /) and numbers in different numeric systems\n" +
                "(at least Arabic (0, 1, 2.7, 3.14, etc.) and Roman (I, IV, MCMxcvi, etc.) numbers,\n" +
                " but expandable to support others like Hebrew (א, ב, ג, מ, קעז, ת״ר, etc.),\n" +
                "Cyrillic (А, В, Є, Ѳ, Н, Ѯ, Ѱ, ЦҀѲ etc.), etc.).\n" +
                "For example: 123+CXXIII-13-CX\n" +
                "Please include documentation required to learn about your solution.\"\n");
    }
}
