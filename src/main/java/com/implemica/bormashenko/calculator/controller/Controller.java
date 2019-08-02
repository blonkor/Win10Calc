package com.implemica.bormashenko.calculator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for application's controls.
 *
 * @author Mykhailo Bormashenko
 */
public class Controller implements Initializable {

    /**
     * Calculator buttons.
     */
    @FXML
    private Button memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore, memoryShow,
            navigation, history, close, hide, expand;

    @FXML
    private Label mainScreen;

    private static final String ZERO = "0";

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

    public void zeroClick(MouseEvent mouseEvent) {
        String digit = "0";
        addDigitToMainScreen(digit);
    }

    public void oneClick(MouseEvent mouseEvent) {
        String digit = "1";
        addDigitToMainScreen(digit);
    }

    public void twoClick(MouseEvent mouseEvent) {
        String digit = "2";
        addDigitToMainScreen(digit);
    }

    public void threeClick(MouseEvent mouseEvent) {
        String digit = "3";
        addDigitToMainScreen(digit);
    }

    public void fourClick(MouseEvent mouseEvent) {
        String digit = "4";
        addDigitToMainScreen(digit);
    }

    public void fiveClick(MouseEvent mouseEvent) {
        String digit = "5";
        addDigitToMainScreen(digit);
    }

    public void sixClick(MouseEvent mouseEvent) {
        String digit = "6";
        addDigitToMainScreen(digit);
    }

    public void sevenClick(MouseEvent mouseEvent) {
        String digit = "7";
        addDigitToMainScreen(digit);
    }

    public void eightClick(MouseEvent mouseEvent) {
        String digit = "8";
        addDigitToMainScreen(digit);
    }

    public void nineClick(MouseEvent mouseEvent) {
        String digit = "9";
        addDigitToMainScreen(digit);
    }

    public void negate(MouseEvent mouseEvent) {
        String number = mainScreen.getText();
    }

    private void addDigitToMainScreen(String digit) {
        String number = mainScreen.getText();
        int maxSymbols = 16;
        number = number.replaceAll(COMMA, "");

        if (number.equals(ZERO)) {
            number = digit;
        } else if (number.length() < maxSymbols) {
            number += digit;
        }

        addCommasToMainScreen(number);
    }

    private void addCommasToMainScreen(String number) {
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
        mainScreen.setText(str.reverse().toString());
    }
}
