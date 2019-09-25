package com.implemica.bormashenko.calculator.model.util;

import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;

import java.math.BigDecimal;

/**
 * Utility class for overflow validation.
 *
 * @author Mykhailo Bormashenko
 */
public class OverflowValidation {

    /**
     * Bound for maximal value.
     * <p>
     * If this bound reached, {@link OverflowException} should be thrown.
     */
    private static final BigDecimal MAX_INTEGER_VALUE = new BigDecimal("1.e+10000");

    /**
     * Bound for minimal value.
     * <p>
     * If this bound reached, {@link OverflowException} should be thrown.
     */
    private static final BigDecimal MIN_DECIMAL_VALUE = new BigDecimal("1.e-10000");

    /**
     * Checks that number in range ({@code MAX_INTEGER_VALUE}, {@code MAX_INTEGER_VALUE}).
     * <p>
     * Special validation required if divide operation was just performed.
     *
     * @param value    {@code BigDecimal} value to check.
     * @param divide   true if divide operation was just performed.
     * @param dividend {@code BigDecimal} value that was used as dividend for divide operation.
     * @return true if validation failed or false otherwise.
     */
    public static boolean overflowValidationFailed(BigDecimal value, boolean divide, BigDecimal dividend) {
        return (overflowValidationFailedForDivide(value, divide, dividend)) ||
                (value.abs().compareTo(MAX_INTEGER_VALUE) >= 0 ||
                (value.abs().compareTo(MIN_DECIMAL_VALUE) <= 0 && value.compareTo(BigDecimal.ZERO) != 0));
    }

    /**
     * Checks overflow validation after divide operation.
     * <p>
     * If result's scale more than divide operation scale, result will equal to zero. In that way, if result is zero and
     * dividend is not zero, validation failed.
     *
     * @param value    {@code BigDecimal} value to check.
     * @param divide   true if divide operation was just performed.
     * @param dividend {@code BigDecimal} value that was used as dividend.
     * @return true if validation failed or false otherwise.
     */
    private static boolean overflowValidationFailedForDivide(BigDecimal value, boolean divide, BigDecimal dividend) {
        return divide && dividend.compareTo(BigDecimal.ZERO) != 0 && value.compareTo(BigDecimal.ZERO) == 0;
    }
}
