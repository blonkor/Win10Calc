package com.implemica.bormashenko.calculator.model.enums;

/**
 * This enum contains unary operations used in calculator.
 *
 * @author Mykhailo Bormashenko
 */
public enum UnaryOperations {

    /**
     * This operation inverses number.
     */
    INVERSE("1/"),

    /**
     * This operation calculates square of number.
     */
    SQR("sqr"),

    /**
     * This operation calculates square root of number.
     */
    SQRT("√"),

    /**
     * This operation negates number.
     */
    NEGATE("negate");

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
