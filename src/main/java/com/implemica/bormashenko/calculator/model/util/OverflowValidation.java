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
     *
     * @param value big decimal value to check.
     * @return true if validation failed or false otherwise.
     */
    public static boolean overflowValidationFailed(BigDecimal value) {
        return value.abs().compareTo(MAX_INTEGER_VALUE) >= 0 ||
                (value.abs().compareTo(MIN_DECIMAL_VALUE) <= 0 && !value.equals(BigDecimal.ZERO));
    }

    /**
     * Checks overflow validation after divide operation.
     * <p>
     * If result's scale more than divide operation scale, result will equal to zero. In that way, if result is zero and
     * dividend is not zero, validation failed.
     *
     * @param result   big decimal value to check.
     * @param dividend number that was used as dividend.
     * @return true if validation failed or false otherwise.
     */
    public static boolean overflowValidationFailedForDivide(BigDecimal result, BigDecimal dividend) {
        return !dividend.equals(BigDecimal.ZERO) && result.equals(BigDecimal.ZERO);
    }
}
