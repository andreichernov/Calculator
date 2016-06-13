package ru.andreichernov.acicalc.validation;

import org.slf4j.Logger;
import ru.andreichernov.acicalc.cleaners.EmptyCharacterCleaner;
import ru.andreichernov.acicalc.cleaners.ExpCleaner;
import ru.andreichernov.acicalc.exception.ValidationException;

import static org.slf4j.LoggerFactory.getLogger;

public class ExpressionValidatorSimpleImpl implements ExpressionValidator {
    private static final Logger LOG = getLogger(ExpressionValidatorSimpleImpl.class);

    /**
     *
     * @param expression математическое выражение
     * @return результат предварительной оценки выражения на корректность по заданному правилу
     */
    @Override
    public boolean validate(final String expression) {//todo: bad validation -> need improving!
        boolean valid = false;
        if (expression != null && !expression.isEmpty()){
            // добавить проверку regex`ом на допустимость встречающихся знаков {+, -, *, /} и цифр входящих систем счисления..
            // пока предполагается, что выражение корректно
            valid = true;
        }
        else {
            try {
                throw new ValidationException("No expression has been specified.");
            } catch (ValidationException e) {
                LOG.debug(e.getMessage());
            }
        }
        return valid;
    }
}
