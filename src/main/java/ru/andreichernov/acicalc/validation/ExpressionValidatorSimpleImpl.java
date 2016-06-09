package ru.andreichernov.acicalc.validation;

public class ExpressionValidatorSimpleImpl implements ExpressionValidator {
    /**
     *
     * @param expression подаваемое на вход математическое выражение
     * @return результат предварительной оценки выражения на корректность по заданному правилу
     */
    @Override
    public boolean validate(String expression) {
        boolean result = false;
        if (expression != null && !expression.isEmpty()){
            result = true;
        }
// NumberFormatException
        return result;
    }
}
