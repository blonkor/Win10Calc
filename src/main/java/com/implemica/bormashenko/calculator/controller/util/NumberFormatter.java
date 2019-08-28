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
     * Negative number symbol.
     */
    private static final String MINUS = "-";

    /**
     * Decimal symbol.
     */
    private static final String DOT = ".";

    /**
     * Engineer number symbol.
     */
    private static final String ENGINEER = "e";

    /**
     * Symbol for separating every three digits in number.
     */
    private static final String COMMA = ",";

    /**
     * Origin string in screen label.
     */
    private static final String ZERO = "0";

    /**
     * Empty string to replace commas.
     */
    private static final String EMPTY_STRING = "";

    /**
     * Maximal amount of digit symbols that can be shown on screen.
     */
    private final static int MAX_SYMBOLS = 16;

    /**
     * Precision for rounding result, calculated in tests.model.
     */
    private final static MathContext PRECISION_TO_SHOW = new MathContext(MAX_SYMBOLS);

    /**
     * Deletes last char in non-engineer number.
     *
     * @param number number to edit.
     * @return number without last char if it was possible to edit or origin number otherwise.
     */
    public static String deleteLastChar(String number) {
        number = number.replaceAll(COMMA, EMPTY_STRING);

        if (!number.contains(ENGINEER)) {

            if (number.length() == 1 || (number.startsWith(MINUS) && number.length() == 2)) {
                number = ZERO;
            } else {
                number = number.substring(0, number.length() - 1);
            }

        }

        return separateNumberWithCommas(number);
    }

    /**
     * Adds dot to number if the number does not contain dot.
     * If the number can not be edited, replaces number with zero with dot.
     *
     * @param number     number to edit.
     * @param isEditable true if number can be edited.
     * @return number with dot if it was possible to edit or "0." otherwise.
     */
    public static String addDot(String number, boolean isEditable) {
        if (!isEditable) {
            number = ZERO + DOT;
        } else if (!number.endsWith(DOT) && !number.contains(DOT)) {
            number += DOT;
        }

        return number;
    }

    /**
     * Adds digit to screen if the number can be edited, otherwise returns digit.
     *
     * @param number     number to edit.
     * @param digit      digit to add.
     * @param isEditable true if number can be edited.
     * @return number with added digit if it was possible to edit or digit otherwise.
     */
    public static String addDigit(String number, String digit, boolean isEditable) {
        if (!isEditable) {
            return digit;
        } else {
            return addDigitToScreen(number, digit);
        }
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

    public static String bigDecimalToScreen(BigDecimal number) {
        return separateNumberWithCommas(number.toString());
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
     * Adds digit symbol to result number string.
     *
     * @param digit symbol to add.
     */
    private static String addDigitToScreen(String currentNumber, String digit) {
        currentNumber = currentNumber.replaceAll(COMMA, EMPTY_STRING);

        if (currentNumber.equals(ZERO)) {
            currentNumber = digit;
        } else if (currentNumber.length() < MAX_SYMBOLS) {
            currentNumber += digit;
        }

        return NumberFormatter.separateNumberWithCommas(currentNumber);
    }


    /**
     * Separates every three digit in number.
     *
     * @param number number to edit.
     */
    private static String separateNumberWithCommas(String number) {
        if (number.contains(ENGINEER)) {
            return number;
        }

        boolean negative = number.startsWith(MINUS);
        number = number.replaceAll(MINUS, EMPTY_STRING);
        String digitsAfterDot = EMPTY_STRING;

        if (number.contains(DOT)) {
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
}
