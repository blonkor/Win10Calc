package com.implemica.bormashenko.calculator.controller;

import com.implemica.bormashenko.calculator.controller.util.NumberFormatter;
import com.implemica.bormashenko.calculator.controller.util.ViewFormatter;
import com.implemica.bormashenko.calculator.model.operations.BinaryOperations;
import com.implemica.bormashenko.calculator.model.Calculation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.math.BigDecimal;
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

    private Calculation calculation = new Calculation();

    private boolean isOperationPressed = false;

    private boolean isMemoryDisabled = true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button[] buttonsWithGrayTooltip = {
                memoryClear, memoryRecall, memoryAdd, memoryStore,
                memorySubtract, memoryShow, navigation, history
        };
        ViewFormatter.setGrayTooltipsLocation(buttonsWithGrayTooltip);

        Button[] buttonsWithWhiteTooltip = {
                close, hide, expand
        };
        ViewFormatter.setWhiteTooltipsLocation(buttonsWithWhiteTooltip);
    }

    /**
     * Opens or closes navigation bar.
     */
    public void showNavigationPanel() {
        ViewFormatter.showNavigationPanel(navigationPanel, about);
    }

    /**
     * Opens or closes history bar.
     */
    public void showHistoryPanel() {
        ViewFormatter.showHistoryPanel(historyMemoryPanel, historyMemoryLabel);
    }

    public void memoryClearOperation() {
        ViewFormatter.setButtonsDisability(true, memoryClear, memoryRecall, memoryShow);
        isMemoryDisabled = true;
    }


    public void memoryRecallOperation() {

    }

    public void memoryAddOperation() {
        enableMemory();
    }

    public void memorySubtractOperation() {
        enableMemory();
    }

    public void memoryStoreOperation() {
        enableMemory();
    }

    public void memoryShowOperation() {
        ViewFormatter.memoryShowOperation(historyMemoryPanel, historyMemoryLabel);
    }

    /**
     * Sets text in result screen to 0.
     */
    public void clearText() {
        result.setText(ZERO);
        isOperationPressed = false;
    }

    /**
     * Sets text in result screen to 0.
     */
    public void clearAll() {
        clearText();
        calculation.resetAll();
    }

    /**
     * Deletes last symbol in result screen.
     */
    public void backspace() {
        String number = result.getText();
        result.setText(NumberFormatter.deleteLastChar(number));
    }

    /**
     * Sums two numbers.
     */
    public void addOperation() {
        binaryOperationPressed(BinaryOperations.ADD);
    }

    /**
     * Subtracts two numbers.
     */
    public void subtractOperation() {
        binaryOperationPressed(BinaryOperations.SUBTRACT);
    }

    /**
     * Multiplies two numbers.
     */
    public void multiplyOperation() {
        binaryOperationPressed(BinaryOperations.MULTIPLY);
    }

    /**
     * Divides two numbers.
     */
    public void divideOperation() {
        binaryOperationPressed(BinaryOperations.DIVIDE);
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
        calculation.setSecond(textToBigDecimal());
        BigDecimal res = calculation.calculateBinary();
        result.setText(NumberFormatter.separateNumberWithCommas(res.toString()));
    }

    /**
     * Makes number in result screen decimal.
     */
    public void makeDecimal() {
        String number = result.getText();
        result.setText(NumberFormatter.addDot(number, isOperationPressed));
    }

    /**
     * Adds digit from button to result screen while button is clicked.
     */
    public void addDigit(MouseEvent event) {
        String digit = ((Button) event.getSource()).getText();
        String currentNumber = result.getText();
        result.setText(NumberFormatter.addDigit(currentNumber, digit, isOperationPressed));
        isOperationPressed = false;
    }

    /**
     * Negates number in result screen while button is clicked.
     */
    public void negate() {

    }

    private void enableMemory() {
        if (isMemoryDisabled) {
            ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
        }

        isMemoryDisabled = false;
    }

    private BigDecimal textToBigDecimal() {
        String number = result.getText();
        number = number.replaceAll(COMMA, "");
        return new BigDecimal(number);
    }

    private void binaryOperationPressed(BinaryOperations operation) {
        calculation.setFirst(textToBigDecimal());
        calculation.setBinaryOperation(operation);
        isOperationPressed = true;
    }








}
