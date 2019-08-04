package com.implemica.bormashenko.calculator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for application's controls.
 *
 * @author Mykhailo Bormashenko
 */
public class Controller implements Initializable {

    /**
     * Application buttons.
     */
    @FXML
    private Button memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore, memoryShow,
            navigation, history, close, hide, expand;

    /**
     * Application labels.
     */
    @FXML
    private Label result;

    /**
     * Zero symbol is used instead of empty string.
     */
    private static final String ZERO = "0";

    /**
     * Symbol for separation every three digit in number.
     */
    private static final String COMMA = ",";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button[] buttonsWithGrayTooltip = {
                memoryClear, memoryRecall, memoryAdd, memoryStore,
                memorySubtract, memoryShow, navigation, history
        };
        setGrayTooltipsLocation(buttonsWithGrayTooltip);

        Button[] buttonsWithWhiteTooltip = {
                close, hide, expand
        };
        setWhiteTooltipsLocation(buttonsWithWhiteTooltip);
    }

    /**
     * Changes locations for gray tooltips.
     * Gray tooltip is a tooltip with {@code styleClass = "tooltip_gray"}.
     * Gray tooltip have to appear above the cursor.
     *
     * @param buttons controllers with tooltip.
     */
    private void setGrayTooltipsLocation(Button[] buttons) {
        final double[] currentMouseX = new double[1];
        final double[] currentMouseY = new double[1];
        for (Button button : buttons) {
            button.setOnMouseMoved(m -> {
                currentMouseX[0] = m.getScreenX();
                currentMouseY[0] = m.getScreenY();
            });
            button.getTooltip().setOnShowing(s -> {
                button.getTooltip().setX(currentMouseX[0] - button.getTooltip().getWidth() / 2);
                button.getTooltip().setY(currentMouseY[0] - 50);
            });
        }
    }

    /**
     * Changes locations for white tooltips.
     * White tooltip is a tooltip with {@code styleClass = "tooltip_white"}.
     * White tooltip have to appear below the cursor.
     *
     * @param buttons controllers with tooltip.
     */
    private void setWhiteTooltipsLocation(Button[] buttons) {
        final double[] currentMouseX = new double[1];
        final double[] currentMouseY = new double[1];
        for (Button button : buttons) {
            button.setOnMouseMoved(m -> {
                currentMouseX[0] = m.getScreenX();
                currentMouseY[0] = m.getScreenY();
            });
            button.getTooltip().setOnShowing(s -> {
                button.getTooltip().setX(currentMouseX[0]);
                button.getTooltip().setY(currentMouseY[0] + 6);
            });
        }
    }

    /**
     * Adds digit "0" to result screen while button is clicked.
     */
    public void zeroClick() {
        String digit = "0";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "1" to result screen while button is clicked.
     */
    public void oneClick() {
        String digit = "1";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "2" to result screen while button is clicked.
     */
    public void twoClick() {
        String digit = "2";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "3" to result screen while button is clicked.
     */
    public void threeClick() {
        String digit = "3";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "4" to result screen while button is clicked.
     */
    public void fourClick() {
        String digit = "4";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "5" to result screen while button is clicked.
     */
    public void fiveClick() {
        String digit = "5";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "6" to result screen while button is clicked.
     */
    public void sixClick() {
        String digit = "6";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "7" to result screen while button is clicked.
     */
    public void sevenClick() {
        String digit = "7";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "8" to result screen while button is clicked.
     */
    public void eightClick() {
        String digit = "8";
        addDigitToResult(digit);
    }

    /**
     * Adds digit "9" to result screen while button is clicked.
     */
    public void nineClick() {
        String digit = "9";
        addDigitToResult(digit);
    }

    /**
     * Negates number in result screen while button is clicked.
     * @TODO
     */
    public void negate() {
        String number = result.getText();
    }

    /**
     * Adds digit symbol to result number string.
     * @param digit symbol to add.
     */
    private void addDigitToResult(String digit) {
        String number = result.getText();
        int maxSymbols = 16;
        number = number.replaceAll(COMMA, "");

        if (number.equals(ZERO)) {
            number = digit;
        } else if (number.length() < maxSymbols) {
            number += digit;
        }

        addCommasToResultScreen(number);
    }

    /**
     * Separates every three digit in number and sets this number to result label.
     * @param number number to manipulate with.
     */
    private void addCommasToResultScreen(String number) {
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
        result.setText(str.reverse().toString());
    }
}
