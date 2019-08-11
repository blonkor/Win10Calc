package com.implemica.bormashenko.calculator.controller.util;

import com.implemica.bormashenko.calculator.model.Calculation;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.math.MathContext;

public class NumberFormatter {

    private static final String MINUS = "-";

    private static final String DOT = ".";

    private static final String COMMA = ",";

    private static final String ZERO = "0";
    private static final String EMPTY_STRING = "";
    /**
     * Precision for rounding result, calculated in model, and showing it on screen.
     */
    private final static MathContext PRECISION_TO_SHOW = new MathContext(16);

    public static String deleteLastChar(String number) {
        if (!number.contains("e")) {
            if (number.length() == 1) {
                number = "0";
            } else {
                number = number.substring(0, number.length() - 1);
            }
        }

        return separateNumberWithCommas(number);
    }

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

    public static String addDigit(String currentNumber, String digit, boolean isEditable) {
        if (!isEditable) {
            return digit;
        } else {
            return addDigitToScreen(currentNumber, digit);
        }
    }

    /**
     * Separates every three digit in number and sets this number to result label.
     *
     * @param number number to manipulate with.
     */
    public static String separateNumberWithCommas(String number) {
        boolean negative = number.startsWith(MINUS);
        number = number.replaceAll(MINUS, "");
        number = number.replaceAll(COMMA, "");
        String digitsAfterDot = "";

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

        return NumberFormatter.separateNumberWithCommas(currentNumber);
    }


    public static BigDecimal screenToBigDecimal(Label screen) {
        return new BigDecimal(screen.getText().replaceAll(COMMA, EMPTY_STRING));
    }

    public static String roundResult(Calculation calculation) {
        return calculation.getResult().round(PRECISION_TO_SHOW).toString();
    }
}
