package com.implemica.bormashenko.calculator.model.exceptions;

/**
 * Custom made exception which shows that something is out of range.
 *
 * @author Mykhailo Bormashenko
 */
public class OverflowException extends Exception {

    /**
     * Message for thrown exception.
     */
    private static final String MESSAGE = "Overflow";

    /**
     * Constructor for exception.
     */
    public OverflowException() {
        super(MESSAGE);
    }
}
