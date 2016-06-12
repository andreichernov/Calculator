package ru.andreichernov.acicalc.exception;

public class ValidationException extends WrongExpression {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Exception exception) {
        super(exception);
    }

    public ValidationException(String message, Exception exception) {
        super(message, exception);
    }
}
