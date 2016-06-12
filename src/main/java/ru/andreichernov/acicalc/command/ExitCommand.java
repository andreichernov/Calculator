package ru.andreichernov.acicalc.command;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.ConsoleHelper;
import ru.andreichernov.acicalc.exception.InterruptOperationException;

import static org.slf4j.LoggerFactory.getLogger;

class ExitCommand implements Command {
    private static final Logger LOG = getLogger(ExitCommand.class);

    public void execute() throws InterruptOperationException {
        LOG.info("In ExitCommand.");
        ConsoleHelper.writeMessage("You want to exit? <y/n>");
        String exitAnswer = ConsoleHelper.readString();
        if (exitAnswer.equalsIgnoreCase("yes") || exitAnswer.equalsIgnoreCase("y")) {
            ConsoleHelper.writeMessage("Thank you. Bye-bye!");
        }
    }
}
