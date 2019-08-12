package com.implemica.bormashenko.calculator.controller;

import com.implemica.bormashenko.calculator.controller.util.NumberFormatter;
import com.implemica.bormashenko.calculator.controller.util.ViewFormatter;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperations;
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
     * Opens text in equation label while unary operation is pressed.
     */
    private static final String OPENING_BRACKET = "(";

    /**
     * Closes text in equation label while unary operation is pressed.
     */
    private static final String CLOSING_BRACKET = ")";

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
     * True if binaryOperation was just pressed.
     */
    private boolean isBinaryOperationPressed = false;

    /**
     * True if equals was just pressed.
     */
    private boolean isEqualsPressed = false;

    /**
     * True if first number was calculated.
     */
    private boolean isFirstCalculated = false;

    /**
     * True if percent was just pressed.
     */
    private boolean isPercentPressed = false;

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

        isBinaryOperationPressed = false;
        isPercentPressed = false;
        isEqualsPressed = false;
        isEditableScreen = true;
    }

    /**
     * Sets text in result screen to 0.
     */
    public void clearAll() {
        clearText();
        calculation.resetAll();
        equation.setText(EMPTY_STRING);

        isBinaryOperationPressed = false;
        isPercentPressed = false;
        isEqualsPressed = false;
        isFirstCalculated = false;
        isEditableScreen = true;
    }

    /**
     * Adds digit from button to result screen while button is clicked.
     */
    public void addDigit(MouseEvent event) {
        String digit = ((Button) event.getSource()).getText();
        String currentNumber = screen.getText();
        screen.setText(NumberFormatter.addDigit(currentNumber, digit, isEditableScreen));

        if (isPercentPressed) {
            equation.setText(EMPTY_STRING);
        }

        isBinaryOperationPressed = false;
        isPercentPressed = false;
        isEqualsPressed = false;
        isEditableScreen = true;
    }

    /**
     * Makes number in result screen decimal.
     *
     * @todo probably does not work correctly
     */
    public void makeDecimal() {
        String number = screen.getText();
        screen.setText(NumberFormatter.addDot(number, isBinaryOperationPressed));
    }

    /**
     * Deletes last symbol in result screen.
     *
     * @todo does not works properly
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
     * Negates number in result screen while button is clicked.
     *
     * @todo
     */
    public void negate() {
        unaryOperationPressed(UnaryOperations.NEGATE);
    }

    /**
     * Calculates square of number.
     *
     * @todo
     */
    public void squareOperation() {
        unaryOperationPressed(UnaryOperations.SQR);
    }

    /**
     * Calculates square root of number.
     *
     * @todo
     */
    public void squareRootOperation() {
        unaryOperationPressed(UnaryOperations.SQRT);
    }

    /**
     * Inverses number.
     *
     * @todo
     */
    public void inverseOperation() {
        unaryOperationPressed(UnaryOperations.INVERSE);
    }


    /**
     * Calculates percent of number.
     *
     * @todo
     */
    public void percentOperation() {
        calculatePercentage();
    }

    /**
     * Calls when equals button is pressed.
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

            isBinaryOperationPressed = false;
            isPercentPressed = false;
            isEqualsPressed = true;
            isFirstCalculated = true;
            isEditableScreen = false;
        }
    }

    /**
     * Calculates equation with binary operation.
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
        if (!isBinaryOperationPressed) {
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

        isBinaryOperationPressed = true;
        isPercentPressed = false;
        isEqualsPressed = false;
        isFirstCalculated = true;
        isEditableScreen = false;
    }

    /**
     * Calculates equation with unary operation.
     * Calls when any unary operation button is pressed.
     * <p>
     * If first number is not saved, sets number from screen as first number.
     * <p>
     * Calculates unary operation with first number and sets result as first number.
     *
     * @param operation UnaryOperation to perform.
     */
    private void unaryOperationPressed(UnaryOperations operation) {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen);

        if (!isFirstCalculated) {
            calculation.setFirst(number);
        }

        calculation.calculateUnary(operation);
        calculation.setFirst(calculation.getResult());

        if (equation.getText().equals(EMPTY_STRING)) {
            equation.setText(operation.symbol + OPENING_BRACKET + number.toString() + CLOSING_BRACKET);
        } else {
            equation.setText(operation.symbol + OPENING_BRACKET + equation.getText() + CLOSING_BRACKET);
        }

        screen.setText(NumberFormatter.roundResult(calculation));

        isBinaryOperationPressed = false;
        isPercentPressed = false;
        isEqualsPressed = false;
        isFirstCalculated = true;
        isEditableScreen = false;
    }

    /**
     * Calculates percentage.
     * Calls when percent button is pressed.
     * <p>
     * Calculation is possible if only binary operation is set. Otherwise, sets first number in calculation model
     * to 0, and shows it in main screen and equation label.
     * <p>
     * Sets number from screen as second number in calculation model. Next steps depends on which binary operation
     * is set:
     * If set binary operation is add or subtract, sets second number as percentage of first number.
     * If set binary operation is multiply or divide, sets second number as percentage of 100.
     * <p>
     * Than shows changed second number on screen and adds it to equation label.
     */
    private void calculatePercentage() {
        if (calculation.getBinaryOperation() == null) {
            calculation.setFirst(BigDecimal.ZERO);

            screen.setText(ZERO);
            equation.setText(ZERO);

        } else {
            BinaryOperations operation = calculation.getBinaryOperation();
            BigDecimal number = NumberFormatter.screenToBigDecimal(screen);
            calculation.setSecond(number);

            if (operation == BinaryOperations.ADD || operation == BinaryOperations.SUBTRACT) {
                calculation.percentageOfFirst();
            } else if (operation == BinaryOperations.MULTIPLY || operation == BinaryOperations.DIVIDE) {
                calculation.percentageOf100();
            }

            screen.setText(NumberFormatter.bigDecimalToScreen(calculation.getSecond()));
            equation.setText(equation.getText() + SPACE + calculation.getSecond().toString());
        }

        isBinaryOperationPressed = false;
        isPercentPressed = true;
        isEqualsPressed = false;
        isFirstCalculated = true;
        isEditableScreen = false;
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
}
