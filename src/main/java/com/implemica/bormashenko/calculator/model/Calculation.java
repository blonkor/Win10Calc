package com.implemica.bormashenko.calculator.model;

import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;

import java.math.BigDecimal;

/**
 * This class contains model of how the calculator works.
 *
 * @author Mykhailo Bormashenko
 */
public class Calculation {

    /**
     * Scale for divide operation.
     */
    private static final int DIVIDE_SCALE = 10000;

    /**
     * First number of expression.
     */
    private BigDecimal first = BigDecimal.ZERO;

    /**
     * Second number of expression.
     */
    private BigDecimal second = BigDecimal.ZERO;

    /**
     * Second number of expression.
     */
    private BigDecimal result = BigDecimal.ZERO;

    /**
     * Binary operation of expression.
     */
    private BinaryOperations binaryOperation;

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public void setFirst(BigDecimal first) {
        this.first = first;
    }

    public BigDecimal getFirst() {
        return first;
    }

    public void setSecond(BigDecimal second) {
        this.second = second;
    }

    public BigDecimal getSecond() {
        return second;
    }

    public void setBinaryOperation(BinaryOperations binaryOperation) {
        this.binaryOperation = binaryOperation;
    }

    public BinaryOperations getBinaryOperation() {
        return binaryOperation;
    }

    public void resetAll() {
        first = BigDecimal.ZERO;
        second = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        binaryOperation = null;
    }

    /**
     * Calculates result using first value, binary operation and second value.
     *
     * @return result of expression.
     */
    public void calculateBinary() {
        if (binaryOperation == BinaryOperations.ADD) {
            result = add();
        } else if (binaryOperation == BinaryOperations.SUBTRACT) {
            result = subtract();
        } else if (binaryOperation == BinaryOperations.MULTIPLY) {
            result = multiply();
        } else if (binaryOperation == BinaryOperations.DIVIDE) {
            result = divide();
        }
    }

    /**
     * Adds first number to second.
     *
     * @return result of adding two numbers.
     */
    private BigDecimal add() {
        return first.add(second);
    }

    /**
     * Subtracts second value from first.
     *
     * @return result of subtracting one number from another.
     */
    private BigDecimal subtract() {
        return first.subtract(second);
    }

    /**
     * Multiplies first number and second.
     *
     * @return result of multiplying two numbers.
     */
    private BigDecimal multiply() {
        return first.multiply(second);
    }

    /**
     * Divides first number on second.
     *
     * @return result of dividing one number on another.
     */
    private BigDecimal divide() {
        return first.divide(second, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP);
    }
}
