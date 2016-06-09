package ru.andreichernov.acicalc.command;

import ru.andreichernov.acicalc.ConsoleHelper;
import ru.andreichernov.acicalc.exception.InterruptOperationException;


class InfoCommand implements Command {

    public void execute() throws InterruptOperationException {

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
