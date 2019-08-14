package com.implemica.bormashenko.calculator.controller.util;

import com.implemica.bormashenko.calculator.model.Calculation;
import javafx.scene.control.Label;

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
     * Precision for rounding result, calculated in model, and showing it on screen.
     */
    private final static MathContext PRECISION_TO_SHOW = new MathContext(16);

    /**
     * Deletes last char in number.
     *
     * @param number number to edit.
     * @return number without last char.
     */
    public static String deleteLastChar(String number) {
        number = number.replaceAll(COMMA, EMPTY_STRING);

        if (!number.contains("e")) {
            if (number.length() == 1) {
                number = "0";
            } else {
                number = number.substring(0, number.length() - 1);
            }
        }

        return bigDecimalToScreen(new BigDecimal(number));
    }

    /**
     * Adds dot to screen.
     *
     * @param number             current number in label.
     * @param isOperationPressed true if operation was just pressed.
     * @return number with dot.
     */
    public static String addDot(String number, boolean isOperationPressed) {
        if (isOperationPressed) {
            number = ZERO + DOT;
        } else {

            if (number.endsWith(DOT)) {
                number = number.replace(DOT, "");
            } else if (!number.contains(DOT)) {
                number += DOT;
            }

        }

        return number;
    }

    /**
     * Adds digit to screen.
     *
     * @param currentNumber current number in label.
     * @param digit         digit to add.
     * @param isEditable    true if digit should be appended to the end of the number.
     * @return string with added digit.
     */
    public static String addDigit(String currentNumber, String digit, boolean isEditable) {
        if (!isEditable) {
            return digit;
        } else {
            return addDigitToScreen(currentNumber, digit);
        }
    }

    /**
     * Separates every three digit in number.
     *
     * @param bigDecimal number to manipulate with.
     */
    public static String bigDecimalToScreen(BigDecimal bigDecimal) {
        String number = tripZeros(bigDecimal);

        if (number.contains("e")) {
            return number;
        }

        boolean negative = number.startsWith(MINUS);
        number = number.replaceAll(MINUS, EMPTY_STRING);
        number = number.replaceAll(COMMA, EMPTY_STRING);
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

    /**
     * Adds digit symbol to result number string.
     *
     * @param digit symbol to add.
     */
    private static String addDigitToScreen(String currentNumber, String digit) {
        int maxSymbols = 16;
        currentNumber = currentNumber.replaceAll(COMMA, "");

        if (currentNumber.equals(ZERO)) {
            currentNumber = digit;
        } else if (currentNumber.length() < maxSymbols) {
            currentNumber += digit;
        }

        return NumberFormatter.bigDecimalToScreen(new BigDecimal(currentNumber));
    }


    /**
     * Converts number from label with commas to big decimal.
     *
     * @param screen label with number.
     * @return big decimal value of the number.
     */
    public static BigDecimal screenToBigDecimal(Label screen) {
        return new BigDecimal(screen.getText().replaceAll(COMMA, EMPTY_STRING));
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

    private static String tripZeros(BigDecimal bigDecimal) {
        String number = bigDecimal.toString();

        if (!number.contains(DOT) && !number.contains("E")) {
            return number;
        } else {
            boolean engineering = number.contains("E");
            String engSubstring = EMPTY_STRING;

            if (engineering) {
                int engIndex = number.indexOf("E");
                engSubstring = number.substring(engIndex + 1);
                number = number.substring(0, engIndex);
            }

            while (true) {
                if (number.charAt(number.length() - 1) == '0') {
                    number = number.substring(0, number.length() - 1);
                } else {
                    break;
                }
            }

            if (number.endsWith(DOT) && !engineering) {
                number = number.substring(0, number.length() - 1);
            }

            if (engineering) {
                if (number.contains(DOT)) {
                    number += "e";
                } else {
                    number += ".e";
                }
                number += engSubstring;
            }

            return number;
        }
    }
}
