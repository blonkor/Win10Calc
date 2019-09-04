package com.implemica.bormashenko.calculator.controller.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Class for editing numbers' representation.
 *
 * @author Mykhailo Bormashenko
 * @todo refactor
 */
public class NumberFormatter {

    /**
     * Maximal amount of digit symbols that can be shown on screen.
     */
    private final static int MAX_SYMBOLS = 16;

    /**
     * Minimal value that can be shown on screen without using engineer representation.
     */
    private static final BigDecimal MIN_PLAIN_VALUE = new BigDecimal("0.001");

    /**
     * Decimal formatter for formatting output.
     */
    private static final DecimalFormat format = new DecimalFormat();

    /**
     * Symbol for separating every three digits in integer number.
     */
    private static final char GROUPING_SEPARATOR = ',';

    /**
     * Symbol for separating integer and decimal parts of number.
     */
    private static final char DECIMAL_SEPARATOR = '.';

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
     * Origin string in screen label.
     * Also used as symbol-or-zero part of pattern.
     */
    private static final String ZERO = "0";

    /**
     * Negative number symbol.
     */
    private static final String MINUS = "-";

    /**
     * Empty string for replacement.
     */
    private static final String EMPTY_STRING = "";

    /**
     * Appends digit to number.
     * <p>
     * If number is 0, replaces it with inputted digit.
     * Otherwise, checks if the digit can be appended.
     * <p>
     * If number already contains 16 digits (or 17 if it starts with 0. or -0.), digit can not be appended.
     *
     * @param number number to edit.
     * @param digit  digit to append.
     * @return edited number if it was possible to edit.
     */
    public static String appendDigitToNumber(String number, String digit) {
        number = number.replaceAll(String.valueOf(GROUPING_SEPARATOR), EMPTY_STRING);

        if (number.equals(ZERO)) {
            number = digit;
        } else {
            int additionalLength = 0;

            if (number.replace(MINUS, EMPTY_STRING).startsWith(ZERO)) {
                additionalLength++;
            }

            if (isDecimalNumber(number)) {
                additionalLength++;
            }

            if (isNegativeNumber(number)) {
                additionalLength++;
            }

            if (number.length() < MAX_SYMBOLS + additionalLength) {
                number += digit;
            }
        }

        return NumberFormatter.separateNumberGroups(number);
    }

    /**
     * Appends decimal separator to number.
     * <p>
     * If number already has decimal separator, it can not be appended.
     *
     * @param number number to edit.
     * @return edited number if it was possible to edit.
     */
    public static String appendDecimalSeparatorIfMissed(String number) {
        if (!number.contains(String.valueOf(DECIMAL_SEPARATOR))) {
            number += DECIMAL_SEPARATOR;
        }

        return number;
    }

    /**
     * Deletes last char in number.
     * <p>
     * Last char for engineer numbers can not be deleted.
     * <p>
     * If number contains only one digit, this operation will replace the number with 0.
     *
     * @param number number to edit.
     * @return edited number if it was possible to edit.
     */
    public static String deleteLastChar(String number) {
        number = number.replaceAll(String.valueOf(GROUPING_SEPARATOR), EMPTY_STRING);

        if (!isEngineerNumber(number)) {

            if (isOneDigitNumber(number)) {
                number = ZERO;
            } else {
                number = StringUtils.chop(number);
            }

        }

        return separateNumberGroups(number);
    }

    /**
     * Changes sign of number.
     * <p>
     * Prepends minus if number is positive or removes it otherwise.
     * <p>
     * If number is zero, returns zero.
     *
     * @param number number to edit.
     * @return edited number.
     * @todo tests
     */
    public static String changeSign(String number) {
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
     * Converts number with grouping separators to big decimal.
     *
     * @param number number to convert.
     * @return big decimal value of the number.
     */
    public static BigDecimal screenToBigDecimal(String number) {
        return new BigDecimal(number.replaceAll(String.valueOf(GROUPING_SEPARATOR), EMPTY_STRING));
    }

    /**
     * Formats number using {@link DecimalFormat}.
     * <p>
     * If number is less than minimal plain value and it's scale is more than can be shown (16),
     * shows number with one-digit integer part and 16-digits decimal part in engineer representation.
     * <p>
     * The same pattern applied if integer part of number is more than can be shown (16) and scale
     * is non positive or more than can be shown (16).
     * <p>
     * If integer part of number is more than can be shown (16) and scale is between 0 and can be shown (16),
     * shows number with one-digit integer part and scale-digits decimal part in engineer representation.
     * <p>
     * If number is less than can be shown, shows number in usual way with group separator.
     *
     * @param number number to format.
     * @return formatted number.
     */
    public static String formatNumber(BigDecimal number) {
        setFormatSymbols(number.abs().compareTo(BigDecimal.ONE) >= 0);

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

                number = number.setScale(MAX_SYMBOLS, BigDecimal.ROUND_HALF_UP);
            }
        }

        format.applyPattern(pattern.toString());
        return finalFormat(format.format(number));
    }

    /**
     * Formats number using {@link DecimalFormat} without using group separator.
     * <p>
     * If number is less than minimal plain value and it's scale is more than can be shown (16),
     * shows number with one-digit integer part and 16-digits decimal part in engineer representation.
     * <p>
     * The same pattern applied if integer part of number is more than can be shown (16) and scale
     * is non positive or more than can be shown (16).
     * <p>
     * If integer part of number is more than can be shown (16) and scale is between 0 and can be shown (16),
     * shows number with one-digit integer part and scale-digits decimal part in engineer representation.
     * <p>
     * If number is less than can be shown, shows number in usual way.
     *
     * @param number number to format.
     * @return formatted number without group separator.
     * @todo tests
     */
    public static String formatWithoutGroupSeparator(BigDecimal number) {
        return formatNumber(number).replaceAll(String.valueOf(GROUPING_SEPARATOR), EMPTY_STRING);
    }

    /**
     * Sets up symbols for formatter.
     *
     * @param isIntegerSeparator true if number is engineering and integer or false if decimal.
     */
    private static void setFormatSymbols(boolean isIntegerSeparator) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setExponentSeparator(isIntegerSeparator ? INTEGER_EXPONENT_SEPARATOR : DECIMAL_EXPONENT_SEPARATOR);
        symbols.setGroupingSeparator(GROUPING_SEPARATOR);
        symbols.setDecimalSeparator(DECIMAL_SEPARATOR);
        format.setDecimalFormatSymbols(symbols);
        format.setParseBigDecimal(true);
    }

    /**
     * Corrects formatted number.
     * <p>
     * If engineer number is not formatted correctly (no decimal separator in engineer number),
     * prepends decimal separator before engineer separator.
     * <p>
     * If the last symbol of number is decimal separator, removes it.
     *
     * @param number number that was formatted.
     * @return corrected number if it was necessary to correct.
     */
    private static String finalFormat(String number) {
        if (isSecondCharEngineer(number)) {
            number = number.replace(DECIMAL_EXPONENT_SEPARATOR, DECIMAL_SEPARATOR + DECIMAL_EXPONENT_SEPARATOR);
        }

        if (number.endsWith(String.valueOf(DECIMAL_SEPARATOR))) {
            number = number.replace(String.valueOf(DECIMAL_SEPARATOR), EMPTY_STRING);
        }

        return number;
    }

    /**
     * Separates every three digit in number.
     * <p>
     * Separation is made only for non-engineer numbers.
     * <p>
     * Decimal part should not be separated.
     *
     * @param number number to edit.
     * @return edited number if it was possible to edit.
     */
    private static String separateNumberGroups(String number) {
        if (isEngineerNumber(number)) {
            return number;
        }

        boolean negative = isNegativeNumber(number);
        number = number.replaceAll(MINUS, EMPTY_STRING);
        String digitsAfterDecimal = EMPTY_STRING;

        if (isDecimalNumber(number)) {
            int decimalIndex = number.indexOf(DECIMAL_SEPARATOR);
            digitsAfterDecimal = number.substring(decimalIndex);
            number = number.substring(0, decimalIndex);
        }

        return separate(number, digitsAfterDecimal, negative);
    }

    /**
     * Separates every three digits in number with group separator and appends required digits after decimal
     * to the result and prepends minus if needed.
     *
     * @param number             number to edit.
     * @param digitsAfterDecimal digits that should be appended to the result after decimal separator.
     * @param negative           true if minus should be prepended to the result.
     * @return edited number if it was possible to edit.
     */
    private static String separate(String number, String digitsAfterDecimal, boolean negative) {
        StringBuilder str = new StringBuilder();
        char[] chars = number.toCharArray();
        int counter = 0;

        for (int i = chars.length - 1; i >= 0; i--) {

            if (counter == 3) {
                str.append(GROUPING_SEPARATOR);
                counter = 0;
            }

            str.append(chars[i]);
            counter++;
        }

        if (negative) {
            str.append(MINUS);
        }

        return str.reverse().append(digitsAfterDecimal).toString();
    }

    /**
     * Checks if number contains decimal symbol.
     *
     * @param number number to check.
     * @return true if number contains decimal symbol or false otherwise.
     */
    private static boolean isDecimalNumber(String number) {
        return number.contains(String.valueOf(DECIMAL_SEPARATOR));
    }

    /**
     * Checks if number starts with minus.
     *
     * @param number number to check.
     * @return true if number starts with minus or false otherwise.
     */
    private static boolean isNegativeNumber(String number) {
        return number.startsWith(MINUS);
    }

    /**
     * Checks if number contains engineer symbol.
     *
     * @param number number to check.
     * @return true if number contains engineer symbol or false otherwise.
     */
    private static boolean isEngineerNumber(String number) {
        return number.contains(DECIMAL_EXPONENT_SEPARATOR);
    }

    /**
     * Checks if number contains only one digit.
     *
     * @param number number to check.
     * @return true if number contains only one digit or false otherwise.
     */
    private static boolean isOneDigitNumber(String number) {
        return number.length() == 1 || (number.startsWith(MINUS) && number.length() == 2);
    }

    /**
     * Checks if second char of unsigned number is engineer symbol.
     *
     * @param number number to check.
     * @return true if number contains engineer symbol or false otherwise.
     */
    private static boolean isSecondCharEngineer(String number) {
        number = number.replaceAll(MINUS, EMPTY_STRING);
        return number.length() > 1 && String.valueOf(number.charAt(1)).equals(DECIMAL_EXPONENT_SEPARATOR);
    }
}
