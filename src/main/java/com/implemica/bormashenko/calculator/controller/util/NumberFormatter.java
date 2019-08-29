package com.implemica.bormashenko.calculator.controller.util;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Class for editing numbers' representation.
 *
 * @author Mykhailo Bormashenko
 */
public class NumberFormatter {

    /**
     * Symbol for separating every three digits in number.
     */
    private static final String COMMA = ",";

    /**
     * Empty string for replacement.
     */
    private static final String EMPTY_STRING = "";

    /**
     * Decimal symbol.
     */
    private static final String DOT = ".";

    /**
     * Negative number symbol.
     */
    private static final String MINUS = "-";

    /**
     * Origin string in screen label.
     */
    private static final String ZERO = "0";

    /**
     * Engineer number symbol in calculator.
     */
    private static final String CALC_ENGINEER_SYMBOL = "e";

    /**
     * Engineer number symbol in big decimal.
     */
    private static final String BIG_DEC_ENGINEER_SYMBOL = "E";

    /**
     * Maximal amount of digit symbols that can be shown on screen.
     */
    private final static int MAX_SYMBOLS = 16;

    /**
     * Precision for rounding result, calculated in tests.model.
     */
    private final static MathContext PRECISION_TO_SHOW = new MathContext(MAX_SYMBOLS);

    /**
     * Appends digit to screen.
     *
     * @param number number to edit.
     * @param digit  digit to add.
     * @return number with appended digit.
     */
    public static String appendDigit(String number, String digit) {
        number = number.replaceAll(COMMA, EMPTY_STRING);

        if (number.equals(ZERO)) {
            number = digit;
        } else {
            int additionalLength = 0;

            if (number.startsWith(ZERO)) {
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

        return NumberFormatter.separateNumberWithCommas(number);
    }

    /**
     * Adds dot to number if the number does not contain dot yet.
     *
     * @param number number to edit.
     * @return number with dot if it does not contain dot yet.
     */
    public static String appendDot(String number) {
        if (!number.contains(DOT)) {
            number += DOT;
        }

        return number;
    }

    /**
     * Deletes last char in non-engineer number.
     *
     * @param number number to edit.
     * @return number without last char if it was possible to edit or origin number otherwise.
     */
    public static String deleteLastChar(String number) {
        number = number.replaceAll(COMMA, EMPTY_STRING);

        if (!isEngineerNumber(number)) {

            if (number.length() == 1 || (number.startsWith(MINUS) && number.length() == 2)) {
                number = ZERO;
            } else {
                number = number.substring(0, number.length() - 1);
            }

        }

        return separateNumberWithCommas(number);
    }

    /**
     * Converts number with separating commas to big decimal.
     *
     * @param number number to convert.
     * @return big decimal value of the number.
     */
    public static BigDecimal screenToBigDecimal(String number) {
        return new BigDecimal(number.replaceAll(COMMA, EMPTY_STRING));
    }

    /**
     * Separates big decimal value with commas.
     *
     * @param number big decimal number to separate.
     * @return string contains big decimal number separated with commas.
     */
    public static String bigDecimalToScreen(BigDecimal number) {
        String stringNumber = number.toString();

        if (stringNumber.contains(BIG_DEC_ENGINEER_SYMBOL)) {

            if (Character.toString(stringNumber.charAt(1)).equals(BIG_DEC_ENGINEER_SYMBOL) ||
                    (Character.toString(stringNumber.charAt(2)).equals(BIG_DEC_ENGINEER_SYMBOL) &&
                            isNegativeNumber(stringNumber))) {
                stringNumber = stringNumber.replaceAll(BIG_DEC_ENGINEER_SYMBOL, DOT + CALC_ENGINEER_SYMBOL);
            } else {
                stringNumber = stringNumber.replaceAll(BIG_DEC_ENGINEER_SYMBOL, CALC_ENGINEER_SYMBOL);
            }
        }

        return separateNumberWithCommas(stringNumber);
    }

    /**
     * Rounds big decimal number.
     *
     * @param bigDecimal number to round.
     * @return rounded number.
     */
    public static BigDecimal round(BigDecimal bigDecimal) {
        return bigDecimal.round(PRECISION_TO_SHOW);
    }

    /**
     * Separates every three digit in number.
     *
     * @param number number to edit.
     */
    private static String separateNumberWithCommas(String number) {
        if (isEngineerNumber(number)) {
            return number;
        }

        boolean negative = isNegativeNumber(number);
        number = number.replaceAll(MINUS, EMPTY_STRING);
        String digitsAfterDot = EMPTY_STRING;

        if (isDecimalNumber(number)) {
            int dotIndex = number.indexOf(DOT);
            digitsAfterDot = number.substring(dotIndex);
            number = number.substring(0, dotIndex);
        }

        StringBuilder str = new StringBuilder();
        char[] chars = number.toCharArray();
        int counter = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (counter == 3) {
                str.append(COMMA);
                counter = 0;
            }
            str.append(chars[i]);
            counter++;
        }

        if (negative) {
            str.append(MINUS);
        }

        return str.reverse().append(digitsAfterDot).toString();
    }

    /**
     * Checks if number contains engineer symbol.
     *
     * @param number number to check.
     * @return true if number contains engineer symbol or false otherwise.
     */
    private static boolean isEngineerNumber(String number) {
        return number.contains(CALC_ENGINEER_SYMBOL);
    }

    /**
     * Checks if number contains decimal symbol.
     *
     * @param number number to check.
     * @return true if number contains decimal symbol or false otherwise.
     */
    private static boolean isDecimalNumber(String number) {
        return number.contains(DOT);
    }

    /**
     * Checks if number contains negative symbol.
     *
     * @param number number to check.
     * @return true if number starts with minus or false otherwise.
     */
    private static boolean isNegativeNumber(String number) {
        return number.startsWith(MINUS);
    }
}
