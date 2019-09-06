package com.implemica.bormashenko.calculator.model.enums;

/**
 * This enum contains binary operations used in {@link com.implemica.bormashenko.calculator.model.Calculation}.
 *
 * @author Mykhailo Bormashenko
 */
public enum BinaryOperations {

    /**
     * Sums two numbers.
     */
    ADD("+"),

    /**
     * Subtracts one number from another.
     */
    SUBTRACT("-"),

    /**
     * Multiplies two numbers.
     */
    MULTIPLY("×"),

    /**
     * Divides one number to another.
     */
    DIVIDE("÷");

    /**
     * Symbol representation of operation.
     */
    public String symbol;

    /**
     * Constructor for the enum.
     *
     * @param symbol symbol representation of operation.
     */
    BinaryOperations(String symbol) {
        this.symbol = symbol;
    }
}
