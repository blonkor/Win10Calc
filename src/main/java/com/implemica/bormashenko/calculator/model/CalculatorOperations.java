package com.implemica.bormashenko.calculator.model;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This utility class contains model of how the calculator works.
 *
 * @author Mykhailo Bormashenko
 */
public class CalculatorOperations {

    private static final MathContext PRECISION = new MathContext(16);

    /**
     * Calculates sum of two values.
     * @param firstValue first big decimal value.
     * @param secondValue second big decimal value.
     * @return sum of those two values.
     */
    public static BigDecimal add(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.add(secondValue).round(PRECISION).stripTrailingZeros();
    }

    /**
     * Calculates difference of two values.
     * @param firstValue first big decimal value.
     * @param secondValue second big decimal value.
     * @return difference of those two values.
     */
    public static BigDecimal subtract(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.subtract(secondValue);
    }

    /**
     * Calculates result of multiplying two values.
     * @param firstValue first big decimal value.
     * @param secondValue second big decimal value.
     * @return result of multiplying those two values.
     */
    public static BigDecimal multiply(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.multiply(secondValue);
    }

    /**
     * Calculates result of dividing two values.
     * @param firstValue first big decimal value.
     * @param secondValue second big decimal value.
     * @return result of dividing those two values.
     */
    public static BigDecimal divide(BigDecimal firstValue, BigDecimal secondValue) {
        return firstValue.divide(secondValue, BigDecimal.ROUND_CEILING);
    }

    /**
     * Inverses value (inversion is dividing one on the value).
     * @param value big decimal value.
     * @return result of inverting this value.
     */
    public static BigDecimal inverse(BigDecimal value) {
        return BigDecimal.ONE.divide(value, BigDecimal.ROUND_CEILING);
    }

    /**
     * Calculates square of the value.
     * @param value big decimal value.
     * @return result of square operation on this value.
     */
    public static BigDecimal sqr(BigDecimal value) {
        return value.multiply(value);
    }

    /**
     * Calculates square root of the value.
     * @param value  big decimal value.
     * @return result of square root operation on this value.
     */
    public static BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }

}
