package ru.andreichernov.acicalc.exception;

public class InterruptOperationException extends Exception {
    /**
     * This constructor takes a custom message as input.
     *
     * @param message
     *            A custom message for the exception to display.
     */
    public InterruptOperationException(String message) {
        super(message);
    }

    /**
     * This constructor takes an exception as input.
     *
     * @param exception
     *            An exception.
     */
    public InterruptOperationException(Exception exception) {
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
    public InterruptOperationException(String message, Exception exception) {
        super(message, exception);
    }
}
