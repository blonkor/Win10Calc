package com.implemica.bormashenko.calculator.model;

import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperations;

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
    private static final int DIVIDE_SCALE = 10500;

    private static final BigDecimal MAX_INTEGER_VALUE = new BigDecimal("1.e+10000");

    private static final BigDecimal MIN_DECIMAL_VALUE = new BigDecimal("1.e-10000");

    /**
     * Big decimal value of 100.
     */
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    /**
     * First number of expression.
     */
    private BigDecimal first = BigDecimal.ZERO;

    /**
     * Second number of expression.
     */
    private BigDecimal second = BigDecimal.ZERO;

    /**
     * Result of expression.
     */
    private BigDecimal result = BigDecimal.ZERO;

    /**
     * Binary operation of expression.
     */
    private BinaryOperations binaryOperation;

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

    public BigDecimal getResult() {
        return result;
    }

    public void setBinaryOperation(BinaryOperations binaryOperation) {
        this.binaryOperation = binaryOperation;
    }

    public BinaryOperations getBinaryOperation() {
        return binaryOperation;
    }

    /**
     * Resets all fields to theirs primary state.
     */
    public void resetAll() {
        first = BigDecimal.ZERO;
        second = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        binaryOperation = null;
    }

    /**
     * Calculates result using first value, binary operation and second value.
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

        result = result.stripTrailingZeros();

        if (result.abs().compareTo(MAX_INTEGER_VALUE) >= 0 ||
                (result.abs().compareTo(MIN_DECIMAL_VALUE) <= 0 && !result.equals(BigDecimal.ZERO)))  {
            throw new ArithmeticException("Overflow");
        }
    }

    /**
     * Calculates result using first value and binary operation
     *
     * @param unaryOperation operation to perform.
     */
    public void calculateUnary(UnaryOperations unaryOperation) {
        if (unaryOperation == UnaryOperations.NEGATE) {
            result = negate();
        } else if (unaryOperation == UnaryOperations.SQR) {
            result = sqr();
        } else if (unaryOperation == UnaryOperations.SQRT) {
            result = sqrt();
        } else if (unaryOperation == UnaryOperations.INVERSE) {
            result = inverse();
        }

        if (result.abs().compareTo(MAX_INTEGER_VALUE) >= 0 || result.abs().compareTo(MIN_DECIMAL_VALUE) <= 0)  {
            throw new ArithmeticException("Overflow");
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
        if (first.equals(BigDecimal.ZERO) && !second.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }

        if (second.equals(BigDecimal.ZERO)) {

            if (first.equals(BigDecimal.ZERO)) {
                throw new ArithmeticException("Result is undefined");
            }

            throw new ArithmeticException("Cannot divide by zero");
        }

        return first.divide(second, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Calculates negated first number.
     *
     * @return negated first number.
     */
    private BigDecimal negate() {
        return first.negate();
    }

    /**
     * Calculates square of first number.
     *
     * @return square of first number.
     */
    private BigDecimal sqr() {
        return first.multiply(first);
    }

    /**
     * Calculates square root of first number.
     *
     * @return square root of first number.
     */
    private BigDecimal sqrt() {
        if (first.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("Invalid input");
        }

        if (first.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }

        BigDecimal x = new BigDecimal(Math.sqrt(first.doubleValue()));
        return x.add(new BigDecimal(first.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }

    /**
     * Calculates inverted first number.
     *
     * @return inverted first number.
     */
    private BigDecimal inverse() {
        if (first.equals(BigDecimal.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return BigDecimal.ONE.divide(first, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Calculates second number as a percentage of the first.
     */
    public void percentageOfFirst() {
        second = first.multiply(second).divide(ONE_HUNDRED, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Calculates second number as a percentage of 100.
     */
    public void percentageOf100() {
        second = second.divide(ONE_HUNDRED, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP);
    }
}
