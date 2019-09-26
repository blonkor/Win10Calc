package com.implemica.bormashenko.calculator.controller.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

/**
 * Class for editing numbers' representation.
 *
 * @author Mykhailo Bormashenko
 */
public class NumberFormatter {

    /**
     * Maximal amount of digit symbols that can be shown on screen {@code Label}.
     */
    private final static int MAX_SYMBOLS = 16;

    /**
     * Minimal value that can be shown on screen {@code Label} without using engineer representation.
     */
    private static final BigDecimal MIN_PLAIN_VALUE = new BigDecimal("0.001");

    /**
     * Decimal formatter for formatting output.
     */
    private static final DecimalFormat format = new DecimalFormat();

    /**
     * Symbol for separating integer and decimal parts of number.
     */
    public static final char DECIMAL_SEPARATOR = '.';

    /**
     * Symbol for separating every three digits in integer number.
     */
    private static final char GROUPING_SEPARATOR = ',';

    /**
     * Symbol for separating exponent part of number if number is decimal.
     */
    private static final String DECIMAL_EXPONENT_SEPARATOR = "e";

    /**
     * Symbol for separating exponent part of number if number is integer.
     */
    private static final String INTEGER_EXPONENT_SEPARATOR = "e+";

    /**
     * Pattern string for 15 digits if they exist.
     */
    private static final String PATTERN_15_DIGITS = "###############";

    /**
     * Pattern string for splitting integer group.
     */
    private static final String PATTERN_SPLIT_GROUP = "###" + GROUPING_SEPARATOR + "###" + DECIMAL_SEPARATOR;

    /**
     * Pattern for exponent symbol.
     */
    private static final String PATTERN_EXPONENT = "E";

    /**
     * Pattern for digit if it exists.
     */
    private static final String PATTERN_DIGIT = "#";

    /**
     * Origin string in screen {@code Label}. Also used as symbol-or-zero part of pattern.
     */
    private static final String ZERO = "0";

    /**
     * Negative number symbol.
     */
    private static final String MINUS = "-";

    /**
     * Empty string for replacements.
     */
    private static final String EMPTY_STRING = "";

    /**
     * {@code BigDecimal} value for appending new digit to decimal number.
     */
    private static final BigDecimal ONE_TENTH = new BigDecimal("0.1");

    /**
     * Object for setting symbols for decimal formatter.
     */
    private static DecimalFormatSymbols symbols = new DecimalFormatSymbols();

    static {
        symbols.setGroupingSeparator(GROUPING_SEPARATOR);
        symbols.setDecimalSeparator(DECIMAL_SEPARATOR);
        format.setDecimalFormatSymbols(symbols);
        format.setParseBigDecimal(true);
    }

    /**
     * Appends digit to number if it's precision less than {@code MAX_SYMBOLS}.
     * <p>
     * For appending digit, math operations are used.
     * <p>
     * If number < 0, digit should be negated.
     * <p>
     * If dot should be prepended before digit, multiplies digit on 0.1 and adds it to number.
     * <p>
     * Otherwise, if number is 0 (with scale = 0), returns digit only.
     * <p>
     * Otherwise, if number does not have decimal part, multiplies number on 10 and adds digit to number.
     * <p>
     * Otherwise, multiplies digit on 0.1^(number's scale + 1) and adds it to number.
     *
     * @param number                number to edit.
     * @param digit                 digit to append to number.
     * @param prependDotBeforeDigit true if {@code DECIMAL_SEPARATOR} should be prepended before digit or false
     *                              otherwise. It helps not to loose trailing {@code DECIMAL_SEPARATOR} in string
     *                              representation of number while parsing it to {@code BigDecimal}.
     * @return edited number if it was possible to edit.
     */
    public static BigDecimal appendDigitToNumber(BigDecimal number, BigDecimal digit, boolean prependDotBeforeDigit) {
        BigDecimal result = number;

        if (number.precision() < MAX_SYMBOLS) {

            if (number.signum() < 0) {
                digit = digit.negate();
            }

            if (prependDotBeforeDigit) {
                digit = digit.multiply(ONE_TENTH);
                result = number.add(digit);
            } else if (number.equals(BigDecimal.ZERO)) {
                result = digit;
            } else if (number.scale() == 0) {
                result = number.multiply(BigDecimal.TEN).add(digit);
            } else {
                digit = digit.multiply(ONE_TENTH.pow(number.scale() + 1));
                result = result.add(digit);
            }
        }

        return result;
    }

    /**
     * Deletes last char in number.
     * <p>
     * Last char for engineer numbers can not be deleted.
     * <p>
     * If number ends with {@code DECIMAL_SEPARATOR}, deletes last symbol in number and returns it.
     * <p>
     * If number ends with 0 and the whole number is not 0 or -0, deletes last symbol in number. Then returns it if
     * it ends with {@code DECIMAL_SEPARATOR}, or returns formatted number otherwise.
     * <p>
     * Otherwise, formats number without {@code GROUPING_SEPARATOR} and then returns formatted result without last
     * symbol or 0 if there was only one digit. Also, saves last {@code DECIMAL_SEPARATOR} if number ends with it after
     * deleting last symbol.
     *
     * @param number number to edit.
     * @return edited number if it was possible to edit.
     * @throws ParseException if impossible to parse number.
     */
    public static String deleteLastChar(String number) throws ParseException {//todo
        if (isEngineerNumber(number)) {
            return number;
        }

        if (isLastDecimalSeparator(number)) {
            return StringUtils.chop(number);
        }

        if (number.endsWith(ZERO) && !isOneDigitNumber(number)) {
            number = StringUtils.chop(number);

            if (number.endsWith(String.valueOf(DECIMAL_SEPARATOR))) {
                return number;
            }

            return formatNumber(parseToBigDecimal(number), true);
        }

        number = formatNumber(parseToBigDecimal(number), false);

        if (isOneDigitNumber(number)) {
            number = ZERO;
        } else {
            number = StringUtils.chop(number);
        }

        if (number.endsWith(String.valueOf(DECIMAL_SEPARATOR))) {
            return formatNumber(parseToBigDecimal(number), true) + DECIMAL_SEPARATOR;
        }

        return formatNumber(parseToBigDecimal(number), true);
    }

    /**
     * Changes sign of number.
     * <p>
     * Prepends {@code MINUS} if number is positive or removes it otherwise.
     * <p>
     * If number is {@code ZERO}, returns {@code ZERO}.
     *
     * @param number number to edit.
     * @return edited number if it was possible to edit.
     * @throws ParseException if impossible to parse number.
     */
    public static String changeSign(String number) throws ParseException {
        if (!number.equals(ZERO)) {
            if (!isNegativeNumber(number)) {
                number = StringUtils.prependIfMissing(number, MINUS);
            } else {
                number = number.replace(MINUS, EMPTY_STRING);
            }
        }

        return number;
    }

    /**
     * Formats number using {@link DecimalFormat}.
     * <p>
     * If number is less than {@code MIN_PLAIN_VALUE} and it's scale is more than {@code MAX_SYMBOLS}, shows number with
     * one-digit integer part and {@code MAX_SYMBOLS}-digits decimal part in engineer representation.
     * <p>
     * The same pattern applied if integer part of number contains more than {@code MAX_SYMBOLS} digits and scale is non
     * positive or more than {@code MAX_SYMBOLS}.
     * <p>
     * If integer part of number contains more than {@code MAX_SYMBOLS} digits and its scale is between 0 and
     * {@code MAX_SYMBOLS}, shows number with one-digit integer part and scale-digits decimal part in engineer
     * representation.
     * <p>
     * If number contains less than {@code MAX_SYMBOLS} or the same number of digits, shows number in usual way with
     * {@code GROUPING_SEPARATOR}.
     *
     * @param number      number to format.
     * @param useGrouping true if {@code GROUPING_SEPARATOR} should be used or false otherwise.
     * @return formatted number as string.
     */
    public static String formatNumber(BigDecimal number, boolean useGrouping) {
        BigDecimal numberToWorkWith;

        if (number.scale() == 0) {
            numberToWorkWith = number;
        } else {
            numberToWorkWith = number.stripTrailingZeros();
        }

        int trailingZeros = number.scale() - numberToWorkWith.scale();

        setExponentSeparatorSymbol(number.abs().compareTo(BigDecimal.ONE) >= 0);
        //format.setGroupingUsed();

        int scale = number.scale();
        int precision = number.precision();

        StringBuilder pattern;

        if (number.abs().compareTo(MIN_PLAIN_VALUE) < 0 && scale > MAX_SYMBOLS) {
            pattern = new StringBuilder(ZERO + DECIMAL_SEPARATOR + PATTERN_15_DIGITS + PATTERN_EXPONENT + ZERO);
        } else {
            int integerPartLength = precision - scale;

            if (integerPartLength > MAX_SYMBOLS) {
                pattern = new StringBuilder(ZERO + DECIMAL_SEPARATOR);

                if (scale > 0 && scale < MAX_SYMBOLS) {
                    for (int i = 0; i < scale; i++) {
                        pattern.append(ZERO);
                    }
                } else {
                    pattern.append(PATTERN_15_DIGITS);
                }

                pattern.append(PATTERN_EXPONENT + ZERO);
            } else {
                pattern = new StringBuilder(PATTERN_SPLIT_GROUP);

                for (int i = 0; i < MAX_SYMBOLS - integerPartLength; i++) {
                    pattern.append(PATTERN_DIGIT);
                }

                number = number.setScale(MAX_SYMBOLS, BigDecimal.ROUND_HALF_UP);//todo
            }
        }

        format.applyPattern(pattern.toString());

        return finalFormat(format.format(number), useGrouping, trailingZeros);
    }

    /**
     * Parses string number obtained by formatter to {@code BigDecimal}.
     * <p>
     * If number is engineer, creates new {@code BigDecimal} object using this number.
     * <p>
     * Otherwise, parses it using {@code DecimalFormatter}.
     *
     * @param number number to edit.
     * @return edited number if it was necessary to edit.
     * @throws ParseException if impossible to parse number.
     */
    public static BigDecimal parseToBigDecimal(String number) throws ParseException {
        if (isEngineerNumber(number)) {
            return new BigDecimal(number);
        }

        return (BigDecimal) format.parse(number);
    }

    /**
     * Sets symbol for exponent separator in decimal formatter.
     *
     * @param isIntegerSeparator true if integer exponent separator should be used or false if decimal.
     */
    private static void setExponentSeparatorSymbol(boolean isIntegerSeparator) {
        symbols.setExponentSeparator(isIntegerSeparator ? INTEGER_EXPONENT_SEPARATOR : DECIMAL_EXPONENT_SEPARATOR);
        format.setDecimalFormatSymbols(symbols);
    }

    /**
     * Corrects formatted number.
     * <p>
     * If engineer number is not formatted correctly (no {@code DECIMAL_SEPARATOR} in engineer number), prepends
     * {@code DECIMAL_SEPARATOR} before {@code EXPONENT_SEPARATOR}.
     * <p>
     * If the last symbol of number is {@code DECIMAL_SEPARATOR}, removes it.
     * <p>
     * If {@code GROUPING_SEPARATOR} should not be used, replaces them with empty string.
     *
     * @param number      number that was formatted.
     * @param useGrouping true if {@code GROUPING_SEPARATOR} should be used or false otherwise.
     * @return corrected number if it was necessary to correct.
     */
    private static String finalFormat(String number, boolean useGrouping, int trailingZeros) {
        if (isSecondCharEngineer(number)) {
            number = number.replace(DECIMAL_EXPONENT_SEPARATOR,
                    DECIMAL_SEPARATOR + DECIMAL_EXPONENT_SEPARATOR);
        }

        if (isLastDecimalSeparator(number)) {
            number = StringUtils.chop(number);
        }

        if (!useGrouping) {
            number = number.replaceAll(String.valueOf(GROUPING_SEPARATOR), EMPTY_STRING);
        }

        if (trailingZeros != 0) {
            StringBuilder zeros = new StringBuilder();

            for (int i = 0; i < trailingZeros; i++) {
                zeros.append(ZERO);
            }

            if (!number.contains(String.valueOf(DECIMAL_SEPARATOR))) {
                number += DECIMAL_SEPARATOR;
            }

            number += zeros;
        }

        return number;
    }

    /**
     * Checks if second char of unsigned number is {@code EXPONENT_SEPARATOR}.
     *
     * @param number number to check.
     * @return true if second char of unsigned number is {@code EXPONENT_SEPARATOR} or false otherwise.
     */
    private static boolean isSecondCharEngineer(String number) {
        return number.matches("-?\\d" + DECIMAL_EXPONENT_SEPARATOR + "\\+?-?\\d+");
    }

    /**
     * Checks if last symbol of string is {@code DECIMAL_SEPARATOR}.
     *
     * @param string string to check.
     * @return true if last symbol of string is {@code DECIMAL_SEPARATOR} or false otherwise.
     */
    private static boolean isLastDecimalSeparator(String string) {
        return string.endsWith(String.valueOf(DECIMAL_SEPARATOR));
    }

    /**
     * Checks if number contains {@code EXPONENT_SEPARATOR}.
     *
     * @param number number to check.
     * @return true if number contains {@code EXPONENT_SEPARATOR} or false otherwise.
     */
    private static boolean isEngineerNumber(String number) {
        return number.contains(DECIMAL_EXPONENT_SEPARATOR);
    }

    /**
     * Checks if number contains {@code DECIMAL_SEPARATOR}.
     *
     * @param number number to check.
     * @return true if number contains {@code DECIMAL_SEPARATOR} or false otherwise.
     * @throws ParseException if impossible to parse number.
     */
    private static boolean isDecimalNumber(String number) throws ParseException {
        return isLastDecimalSeparator(number) || parseToBigDecimal(number).scale() != 0;
    }

    /**
     * Checks if number is negative.
     *
     * @param number number to check.
     * @return true if number is negative or false otherwise.
     * @throws ParseException if impossible to parse number.
     */
    private static boolean isNegativeNumber(String number) throws ParseException {
        boolean negativeZero = isIntegerPartZero(number) && number.startsWith(MINUS);
        return negativeZero || parseToBigDecimal(number).signum() < 0;
    }

    /**
     * Checks if integer part of number is 0.
     *
     * @param number number to check.
     * @return true if integer part of number is 0 or false otherwise.
     * @throws ParseException if impossible to parse number.
     */
    private static boolean isIntegerPartZero(String number) throws ParseException {
        return parseToBigDecimal(number).abs().compareTo(BigDecimal.ONE) < 0;
    }

    /**
     * Checks if number contains only one digit.
     *
     * @param number number to check.
     * @return true if number contains only one digit or false otherwise.
     * @throws ParseException if impossible to parse number.
     */
    private static boolean isOneDigitNumber(String number) throws ParseException {
        BigDecimal bigDecimal = parseToBigDecimal(number);
        return bigDecimal.abs().compareTo(BigDecimal.TEN) < 0 && bigDecimal.scale() == 0;
    }
}
