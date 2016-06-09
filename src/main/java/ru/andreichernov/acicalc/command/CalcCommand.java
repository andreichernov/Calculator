package ru.andreichernov.acicalc.command;

import ru.andreichernov.acicalc.ConsoleHelper;
import ru.andreichernov.acicalc.exception.InterruptOperationException;
import ru.andreichernov.acicalc.math.converters.Infix2PostfixConverter;
import ru.andreichernov.acicalc.math.converters.MathNotationConverter;
import ru.andreichernov.acicalc.math.solvers.ExpEvaluator;
import ru.andreichernov.acicalc.math.solvers.PostfixExprEvaluator;
import ru.andreichernov.acicalc.validation.ExpressionValidator;
import ru.andreichernov.acicalc.validation.ExpressionValidatorSimpleImpl;

/**
 * Считать выражение будем по приписываемому Кнуту подходу: http://www.ibm.com/developerworks/library/j-w3eval/
 * 1) Parsing an infix expression
 * 2) Converting infix expression to a postfix expression
 * 3) Evaluating the postfix expression
 */
class CalcCommand implements Command {

    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Введите выражение:");
        String expressionInInfixNotation = ConsoleHelper.readString();

        ExpressionValidator validator = new ExpressionValidatorSimpleImpl();
        if (validator.validate(expressionInInfixNotation)){
            MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
            ExpEvaluator expEvaluator = new PostfixExprEvaluator();

            System.out.println(expEvaluator.evaluate(mathNotationConverter.convert(expressionInInfixNotation)));
        }
    }
}
