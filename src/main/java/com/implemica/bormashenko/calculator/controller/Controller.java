package com.implemica.bormashenko.calculator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for application's controls.
 *
 * @author Mykhailo Bormashenko
 */
public class Controller implements Initializable {

    /**
     * Application's buttons.
     */
    @FXML
    private Button memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore, memoryShow,
            navigation, history, close, hide, expand, about;

    /**
     * Application's labels.
     */
    @FXML
    private Label result, historyMemoryLabel;

    /**
     * Application's scroll pane.
     */
    @FXML
    private ScrollPane navigationPanel;

    /**
     * Application's anchor pane.
     */
    @FXML
    private AnchorPane historyMemoryPanel;

    /**
     * Zero symbol is used instead of empty string.
     */
    private static final String ZERO = "0";

    /**
     * Symbol for separation every three digit in number.
     */
    private static final String COMMA = ",";

    /**
     * Symbol for separation every three digit in number.
     */
    private static final String DOT = ".";

    /**
     * Symbol for negating number.
     */
    private static final String MINUS = "-";


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
     * Opens or closes navigation bar.
     */
    public void showNavigationPanel() {
        if (navigationPanel.isVisible()) {
            setNavigationVisible(false);
        } else {
            setNavigationVisible(true);
        }
    }

    /**
     * Opens or closes history bar.
     */
    public void showHistoryPanel() {
        String emptyHistory = "There's no history yet.";
        if (historyMemoryPanel.isVisible()) {
            setHistoryMemoryVisible(false, emptyHistory);
        } else {
            setHistoryMemoryVisible(true, emptyHistory);
        }
    }

    public void memoryClearOperation() {
        setMemoryDisable(true);
    }


    public void memoryRecallOperation() {

    }

    public void memoryAddOperation() {
        if (memoryClear.isDisabled()) {
            setMemoryDisable(false);
        }
    }

    public void memorySubtractOperation() {
        if (memoryClear.isDisabled()) {
            setMemoryDisable(false);
        }
    }

    public void memoryStoreOperation() {
        if (memoryClear.isDisabled()) {
            setMemoryDisable(false);
        }
    }

    public void memoryShowOperation() {
        String emptyMemory = "There's nothing saved in memory";
        if (historyMemoryPanel.isVisible()) {
            setHistoryMemoryVisible(false, emptyMemory);
        } else {
            setHistoryMemoryVisible(true, emptyMemory);
        }
    }

    /**
     * Sets text in result screen to 0.
     */
    public void clearText() {
        result.setText(ZERO);
    }

    /**
     * Deletes last symbol in result screen.
     */
    public void backspace() {
        String number = result.getText();

        if (number.length() == 1) {
            number = ZERO;
        } else {
            number = number.substring(0, number.length() - 1);
        }

        addCommasToResultScreen(number);
    }

    /**
     * Sums two numbers.
     */
    public void addOperation() {

    }

    /**
     * Subtracts two numbers.
     */
    public void subtractOperation() {

    }

    /**
     * Multiplies two numbers.
     */
    public void multiplyOperation() {

    }

    /**
     * Divides two numbers.
     */
    public void divideOperation() {

    }

    /**
     * Inverses number.
     */
    public void inverseOperation() {

    }

    /**
     * Calculates square of number.
     */
    public void squareOperation() {

    }

    /**
     * Calculates square root of number.
     */
    public void squareRootOperation() {

    }

    /**
     * Calculates percent of number.
     */
    public void percentOperation() {

    }

    /**
     * Calculates result of operation.
     */
    public void calculateResult() {

    }

    /**
     * Makes number in result screen decimal.
     */
    public void makeDecimal() {
        String number = result.getText();

        if (number.endsWith(DOT)) {
            number = number.replace(DOT, "");
        } else if (!number.contains(DOT)) {
            number += DOT;
        }

        result.setText(number);
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
     */
    public void negate() {
        String number = result.getText();
        if (number.equals(ZERO)) {

        } else if (number.startsWith(MINUS)) {
            number = number.substring(1);
        } else {
            number = MINUS + number;
        }

        result.setText(number);
    }

    /**
     * Adds digit symbol to result number string.
     *
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
     *
     * @param number number to manipulate with.
     */
    private void addCommasToResultScreen(String number) {
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

        result.setText(str.reverse().append(digitsAfterDot).toString());
    }

    /**
     * Sets disabling for those memory buttons: clear, recall, show.
     *
     * @param flag flag for disabling or enabling buttons.
     */
    private void setMemoryDisable(boolean flag) {
        memoryClear.setDisable(flag);
        memoryRecall.setDisable(flag);
        memoryShow.setDisable(flag);
    }

    /**
     * Sets visibility for navigation bar.
     *
     * @param flag flag for making visible or invisible navigation bar.
     */
    private void setNavigationVisible(boolean flag) {
        navigationPanel.setVisible(flag);
        about.setVisible(flag);
    }

    /**
     * Sets visibility for history bar.
     *
     * @param flag flag for making visible or invisible history bar.
     */
    private void setHistoryMemoryVisible(boolean flag, String text) {
        historyMemoryPanel.setVisible(flag);
        historyMemoryLabel.setText(text);
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
}
