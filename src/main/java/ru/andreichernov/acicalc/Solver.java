package ru.andreichernov.acicalc;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.cleaners.EmptyCharacterCleaner;
import ru.andreichernov.acicalc.cleaners.ExpCleaner;
import ru.andreichernov.acicalc.converters.Infix2PostfixConverter;
import ru.andreichernov.acicalc.converters.MathNotationConverter;
import ru.andreichernov.acicalc.evaluator.ExpEvaluator;
import ru.andreichernov.acicalc.evaluator.PostfixExprEvaluator;
import ru.andreichernov.acicalc.exception.WrongExpression;
import ru.andreichernov.acicalc.exception.WrongPostfixNotation;
import ru.andreichernov.acicalc.operator.*;
import ru.andreichernov.acicalc.validation.ExpressionValidator;
import ru.andreichernov.acicalc.validation.ExpressionValidatorSimpleImpl;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

public class Solver {
    private static final Logger LOG = getLogger(Solver.class);

    // Список разрешенных операторов.
    private List<Operator> operators;
    // Основной рабочий стек операторов
    private Stack mainOperatorStack = null;
    // Основной рабочий стек операндов
    private Stack mainOperandStack = null;
    // Стек прочитанных операторов
    private Stack tempOperatorStack = null;
    // Стек прочитанных операндов
    private Stack tempOperandStack = null;

    public Solver() {
        operators = new OperatorsHelper().getAvailableOperatorsList();
    }


    public String solve(final String expression) throws WrongExpression, WrongPostfixNotation, InstantiationException, IllegalAccessException {


        ExpressionValidator validator = new ExpressionValidatorSimpleImpl();
        if (validator.validate(expression)){
            // пока считаем, что валидация отсеивает некорректные выражения, т.е. здесь работаем с корректными
            MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
            ExpEvaluator expEvaluator = new PostfixExprEvaluator();

            return expEvaluator.evaluate(mathNotationConverter.convert2List(expression)).toString();
        }
        else {
            String msg = "Expression is not valid: \"" + expression + "\"";
            LOG.error(msg);
            throw new WrongExpression(msg);
        }
    }

    public String getAvailableOperators(List<Operator> operators) {
        StringBuilder availableOperators = new StringBuilder();
        for (Operator operator : operators) {
            availableOperators.append(operator.getSymbol());
        }
        return availableOperators.toString();
    }


}
