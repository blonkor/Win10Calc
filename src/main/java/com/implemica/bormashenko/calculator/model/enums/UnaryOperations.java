package com.implemica.bormashenko.calculator.model.enums;

/**
 * This enum contains unary operations used in {@link com.implemica.bormashenko.calculator.model.Calculation}.
 *
 * @author Mykhailo Bormashenko
 */
public enum UnaryOperations {

    /**
     * Negates number.
     */
    NEGATE("negate"),

    /**
     * Calculates square of number.
     */
    SQR("sqr"),

    /**
     * Calculates square root of number.
     */
    SQRT("√"),

    /**
     * Inverses number.
     */
    INVERSE("1/");

    /**
     * Symbol representation of operation.
     */
    public String symbol;

    /**
     * Constructor for enum.
     *
     * @param symbol Symbol representation of operation.
     */
    UnaryOperations(String symbol) {
        this.symbol = symbol;
    }
}
