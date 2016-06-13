package ru.andreichernov.acicalc.math;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.cleaners.EmptyCharacterCleaner;
import ru.andreichernov.acicalc.cleaners.ExpCleaner;
import ru.andreichernov.acicalc.exception.NotatitionConvertException;
import ru.andreichernov.acicalc.exception.WrongExpression;
import ru.andreichernov.acicalc.exception.WrongPostfixNotation;
import ru.andreichernov.acicalc.math.converters.Infix2PostfixConverter;
import ru.andreichernov.acicalc.math.converters.MathNotationConverter;
import ru.andreichernov.acicalc.math.evaluator.ExpEvaluator;
import ru.andreichernov.acicalc.math.evaluator.PostfixExprEvaluator;
import ru.andreichernov.acicalc.math.operator.*;
import ru.andreichernov.acicalc.math.splitters.ExpressionSplitter;
import ru.andreichernov.acicalc.math.splitters.SimpleExpressionSplitter;
import ru.andreichernov.acicalc.validation.ExpressionValidator;
import ru.andreichernov.acicalc.validation.ExpressionValidatorSimpleImpl;

import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

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


    public String solve(final String expression) throws WrongExpression, WrongPostfixNotation {
        ExpCleaner expCleaner = new EmptyCharacterCleaner();
        String cleanedExpression = expCleaner.clean(expression);

        ExpressionValidator validator = new ExpressionValidatorSimpleImpl();
        if (validator.validate(cleanedExpression)){
            // пока считаем, что валидация отсеивает некорректные выражения, т.е. здесь работаем с корректными
            MathNotationConverter mathNotationConverter = new Infix2PostfixConverter();
            ExpEvaluator expEvaluator = new PostfixExprEvaluator();

            return expEvaluator.evaluate(mathNotationConverter.convert2List(cleanedExpression)).toString();
        }
        else {
            String msg = "Expression is not valid: \"" + expression + "\"";
            LOG.error(msg);
            throw new WrongExpression(msg);
        }
    }

    String getAvailableOperators(List<Operator> operators) {
        StringBuilder availableOperators = new StringBuilder();
        for (Operator operator : operators) {
            availableOperators.append(operator.getSymbol());
        }
        return availableOperators.toString();
    }


}
