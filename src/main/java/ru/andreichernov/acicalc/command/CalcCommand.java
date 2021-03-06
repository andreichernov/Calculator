package ru.andreichernov.acicalc.command;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.ConsoleHelper;
import ru.andreichernov.acicalc.exception.InterruptOperationException;
import ru.andreichernov.acicalc.exception.WrongExpression;
import ru.andreichernov.acicalc.exception.WrongPostfixNotation;
import ru.andreichernov.acicalc.Solver;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Считать выражение будем по приписываемому Кнуту подходу: http://www.ibm.com/developerworks/library/j-w3eval/
 * 1) Parsing an infix expression
 * 2) Converting infix expression to a postfix expression
 * 3) Evaluating the postfix expression
 */
class CalcCommand implements Command {
    private static final Logger LOG = getLogger(CalcCommand.class);

    public void execute() throws InterruptOperationException {
        LOG.info("In CalcCommand.");
        ConsoleHelper.writeMessage("Введите выражение:");
        String expression = ConsoleHelper.readString();
        Solver solver = new Solver();
        try {
            ConsoleHelper.writeMessage(solver.solve(expression));
        } catch (WrongExpression wrongExpression) {
            LOG.error("Wrong expression: \"" + wrongExpression + "\"");
        } catch (WrongPostfixNotation wrongPostfixNotation) {
            LOG.error("Wrong postfix notation: \"" + wrongPostfixNotation.toString() + "\"");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
