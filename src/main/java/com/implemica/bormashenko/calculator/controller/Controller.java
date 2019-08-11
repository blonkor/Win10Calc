package com.implemica.bormashenko.calculator.controller;

import com.implemica.bormashenko.calculator.controller.util.NumberFormatter;
import com.implemica.bormashenko.calculator.controller.util.ViewFormatter;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
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
    private Label screen, historyMemoryLabel, equation;

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
     * Symbol for separation numbers and operations in equation.
     */
    private static final String SPACE = " ";

    /**
     * Empty string for replacing commas in number and clearing equation.
     */
    private static final String EMPTY_STRING = "";

    /**
     * Model of application.
     */
    private Calculation calculation = new Calculation();

    /**
     * True if memory is empty and memory buttons such as clear, recall and show should be disabled.
     */
    private boolean isMemoryDisabled = true;

    /**
     * True if number on screen can be edited.
     */
    private boolean isEditableScreen = true;

    /**
     * True if operation was just pressed.
     */
    private boolean isOperationPressed = false;

    /**
     * True if equals was just pressed.
     */
    private boolean isEqualsPressed = false;

    /**
     * True if first number was calculated.
     */
    private boolean isFirstCalculated = false;

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

    /**
     * Clears all memory.
     *
     * @todo
     */
    public void memoryClearOperation() {
        ViewFormatter.setButtonsDisability(true, memoryClear, memoryRecall, memoryShow);
        isMemoryDisabled = true;
    }

    /**
     * Recalls number in memory.
     *
     * @todo
     */
    public void memoryRecallOperation() {

    }

    /**
     * Adds number to memory.
     *
     * @todo
     */
    public void memoryAddOperation() {
        enableMemory();
    }

    /**
     * Subtracts number from memory.
     *
     * @todo
     */
    public void memorySubtractOperation() {
        enableMemory();
    }

    /**
     * Saves number in memory.
     *
     * @todo
     */
    public void memoryStoreOperation() {
        enableMemory();
    }

    /**
     * Shows memory.
     *
     * @todo
     */
    public void memoryShowOperation() {
        ViewFormatter.showMemoryPanel(historyMemoryPanel, historyMemoryLabel);
    }

    /**
     * Sets text in result screen to 0.
     */
    public void clearText() {
        screen.setText(ZERO);
        isOperationPressed = false;
        isEqualsPressed = false;
    }

    /**
     * Sets text in result screen to 0.
     */
    public void clearAll() {
        clearText();
        calculation.resetAll();
        equation.setText(EMPTY_STRING);
        isOperationPressed = false;
        isEditableScreen = true;
        isEqualsPressed = false;
        isFirstCalculated = false;
    }

    /**
     * Deletes last symbol in result screen.
     */
    public void backspace() {
        String number = screen.getText();
        screen.setText(NumberFormatter.deleteLastChar(number));
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
     *
     * @todo
     */
    public void inverseOperation() {

    }

    /**
     * Calculates square of number.
     *
     * @todo
     */
    public void squareOperation() {

    }

    /**
     * Calculates square root of number.
     *
     * @todo
     */
    public void squareRootOperation() {

    }

    /**
     * Calculates percent of number.
     *
     * @todo
     */
    public void percentOperation() {

    }

    /**
     * Calculates result of operation. Calculation is possible only if operation is set.
     * <p>
     * If user inputs number, operation and presses calculate button (without inputting second number), second number
     * will be the same as first.
     * <p>
     * If user presses calculate button several times in a row, result of every operation will be set as first number
     * and second number will not change from the first operation, and calculation will be made again with the same
     * operation.
     *
     * @see Calculation
     */
    public void calculateResult() {
        if (calculation.getBinaryOperation() != null) {

            BigDecimal numberOnScreen = NumberFormatter.screenToBigDecimal(screen);

            if (!isEqualsPressed) {
                calculation.setSecond(numberOnScreen);
                calculation.calculateBinary();
                calculation.setFirst(calculation.getResult());
            } else {
                calculation.setFirst(numberOnScreen);
                calculation.calculateBinary();
            }

            screen.setText(NumberFormatter.roundResult(calculation));
            equation.setText(EMPTY_STRING);

            isFirstCalculated = true;
            isEditableScreen = false;
            isOperationPressed = false;
            isEqualsPressed = true;
        }
    }

    /**
     * Makes number in result screen decimal.
     *
     * @todo probably does not work correctly
     */
    public void makeDecimal() {
        String number = screen.getText();
        screen.setText(NumberFormatter.addDot(number, isOperationPressed));
    }

    /**
     * Adds digit from button to result screen while button is clicked.
     */
    public void addDigit(MouseEvent event) {
        String digit = ((Button) event.getSource()).getText();
        String currentNumber = screen.getText();
        screen.setText(NumberFormatter.addDigit(currentNumber, digit, isEditableScreen));
        isOperationPressed = false;
        isEditableScreen = true;
    }

    /**
     * Negates number in result screen while button is clicked.
     *
     * @todo
     */
    public void negate() {

    }

    /**
     * Enables memory buttons such as clear, recall and show.
     */
    private void enableMemory() {
        if (isMemoryDisabled) {
            ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
        }

        isMemoryDisabled = false;
    }

    /**
     * Calls when any binary operation is pressed.
     * <p>
     * If first number is not saved, saves number on screen as first number,
     * sets inputted binary operation to model and shows first number and operation in equation label.
     * <p>
     * If first number is saved and calculation was not just made, saves number on screen as second,
     * calculates result of binary operation set in model, saves result of operation as first number,
     * sets inputted binary operation to model, than shows result of previous operation om screen and
     * adds second number in model and operation symbol to equation label.
     * <p>
     * If first number is saved and calculation was just made, sets inputted binary operation to model
     * and shows first number and operation in equation label (this is needed because after calculation was made result
     * of calculation is saved as first number).
     * <p>
     * If operation was just pressed, sets inputted binary operation to model and changes last symbol (which is a symbol
     * of previously inputted binary operation) in equation label to actual.
     *
     * @param operation binary operation to set.
     * @see BinaryOperations
     * @see Calculation
     */
    private void binaryOperationPressed(BinaryOperations operation) {
        if (!isOperationPressed) {
            BigDecimal numberOnScreen = NumberFormatter.screenToBigDecimal(screen);

            if (!isFirstCalculated) {
                calculation.setFirst(numberOnScreen);
                calculation.setBinaryOperation(operation);

                equation.setText(calculation.getFirst() + SPACE + operation.symbol);
            } else if (!isEqualsPressed) {
                calculation.setSecond(numberOnScreen);
                calculation.calculateBinary();
                calculation.setFirst(calculation.getResult());
                calculation.setBinaryOperation(operation);

                screen.setText(NumberFormatter.roundResult(calculation));
                equation.setText(equation.getText() + SPACE + calculation.getSecond() + SPACE + operation.symbol);
            } else {
                calculation.setBinaryOperation(operation);

                equation.setText(calculation.getFirst() + SPACE + operation.symbol);
            }

        } else {
            calculation.setBinaryOperation(operation);

            equation.setText(equation.getText().substring(0, equation.getText().length() - 1) + operation.symbol);
        }

        isFirstCalculated = true;
        isEditableScreen = false;
        isOperationPressed = true;
        isEqualsPressed = false;
    }
}
