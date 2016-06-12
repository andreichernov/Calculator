package ru.andreichernov.acicalc.exception;

public class WrongExpression extends Exception {

    /**
     * This constructor takes a custom message as input.
     *
     * @param message
     *            A custom message for the exception to display.
     */
    public WrongExpression(String message) {
        super(message);
    }

    /**
     * This constructor takes an exception as input.
     *
     * @param exception
     *            An exception.
     */
    WrongExpression(Exception exception) {
        super(exception);
    }

    /**
     * This constructor takes an exception as input.
     *
     * @param message
     *            A custom message for the exception to display.
     * @param exception
     *            An exception.
     */
    WrongExpression(String message, Exception exception) {
        super(message, exception);
    }
}
