package com.implemica.bormashenko.calculator.model.enums;

/**
 * This enum contains binary operations used in calculator.
 *
 * @author Mykhailo Bormashenko
 */
public enum BinaryOperations {

    /**
     * This operations sums two numbers.
     */
    ADD("+"),

    /**
     * This operation subtracts one number from another.
     */
    SUBTRACT("-"),

    /**
     * This operation multiplies two numbers.
     */
    MULTIPLY("×"),

    /**
     * This operation divides one number to another.
     */
    DIVIDE("÷");

    /**
     * Symbol representation of operation.
     */
    public String symbol;

    /**
     * Constructor for enum.
     *
     * @param symbol Symbol representation of operation.
     */
    BinaryOperations(String symbol) {
        this.symbol = symbol;
    }

}