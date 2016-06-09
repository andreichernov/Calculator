package ru.andreichernov.acicalc.command;

import ru.andreichernov.acicalc.ConsoleHelper;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

class CalcCommand implements Command {

    public void execute() throws InterruptOperationException {

        String expression = ConsoleHelper.readString();


    }
}
