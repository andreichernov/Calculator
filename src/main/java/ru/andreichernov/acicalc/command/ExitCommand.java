package ru.andreichernov.acicalc.command;

import ru.andreichernov.acicalc.ConsoleHelper;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

class ExitCommand implements Command {

    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("You want to exit? <y/n>");
        String exitAnswer = ConsoleHelper.readString();
        if (exitAnswer.equalsIgnoreCase("yes") || exitAnswer.equalsIgnoreCase("y")) {
            ConsoleHelper.writeMessage("Thank you. Bye-bye!");
        }
    }
}
