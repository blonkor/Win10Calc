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
     * True if any binary operation was just pressed.
     */
    private boolean isBinaryOperationPressed = false;

    /**
     * True if any unary operation was just pressed.
     */
    private boolean isUnaryOperationPressed = false;

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
        isUnaryOperationPressed = false;
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
        isUnaryOperationPressed = false;
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

        if (isPercentPressed || isUnaryOperationPressed) {
            equation.setText(EMPTY_STRING);
        }

        if (isEqualsPressed || isUnaryOperationPressed) {
            isFirstCalculated = false;
        }

        isBinaryOperationPressed = false;
        isUnaryOperationPressed = false;
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
        boolean isOperationPressed = isBinaryOperationPressed && isUnaryOperationPressed && isPercentPressed;
        screen.setText(NumberFormatter.addDot(number, isOperationPressed));
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
     */
    public void negate() {
        unaryOperationPressed(UnaryOperations.NEGATE);
    }

    /**
     * Calculates square of number.
     */
    public void squareOperation() {
        unaryOperationPressed(UnaryOperations.SQR);
    }

    /**
     * Calculates square root of number.
     */
    public void squareRootOperation() {
        unaryOperationPressed(UnaryOperations.SQRT);
    }

    /**
     * Inverses number.
     */
    public void inverseOperation() {
        unaryOperationPressed(UnaryOperations.INVERSE);
    }

    /**
     * Calculates percent of number.
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

            if (!isEqualsPressed && !isUnaryOperationPressed) {

                if (!isFirstCalculated) {
                    calculation.setFirst(numberOnScreen);
                } else {
                    calculation.setSecond(numberOnScreen);
                }

                calculation.calculateBinary();
                calculation.setFirst(calculation.getResult());
            } else {

                if (isEqualsPressed) {
                    calculation.setFirst(numberOnScreen);
                }

                calculation.calculateBinary();
            }

            screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.roundResult(calculation)));

            isBinaryOperationPressed = false;
            isUnaryOperationPressed = false;
            isPercentPressed = false;
            isEqualsPressed = true;
            isFirstCalculated = true;
            isEditableScreen = false;
        }

        equation.setText(EMPTY_STRING);

        System.out.println(calculation.getFirst());
        System.out.println(calculation.getSecond());
        System.out.println(calculation.getResult());
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
            } else if (!isEqualsPressed && !isUnaryOperationPressed) {
                calculation.setSecond(numberOnScreen);
                calculation.calculateBinary();
                calculation.setFirst(calculation.getResult());
                calculation.setBinaryOperation(operation);

                screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.roundResult(calculation)));
                equation.setText(equation.getText() + SPACE + calculation.getSecond() + SPACE + operation.symbol);
            } else {
                calculation.setBinaryOperation(operation);

                if (isEqualsPressed) {
                    calculation.setFirst(numberOnScreen);

                    equation.setText(NumberFormatter.roundResult(calculation) + SPACE + operation.symbol);
                } else {
                    equation.setText(equation.getText() + SPACE + operation.symbol);
                }

            }

        } else {
            calculation.setBinaryOperation(operation);

            equation.setText(equation.getText().substring(0, equation.getText().length() - 1) + operation.symbol);
        }

        isBinaryOperationPressed = true;
        isUnaryOperationPressed = false;
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
            calculation.calculateUnary(operation);
            calculation.setFirst(calculation.getResult());

            screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.roundResult(calculation)));
            equation.setText(operation.symbol + OPENING_BRACKET + SPACE + number.toString() +
                    SPACE + CLOSING_BRACKET + SPACE);
        } else if (isUnaryOperationPressed) {
            calculation.calculateUnary(operation);
            calculation.setFirst(calculation.getResult());

            screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.roundResult(calculation)));

            String equationText = equation.getText();
            int lastIndexOfOperation = 0;

            String textBefore = EMPTY_STRING;
            String textAfter = equationText;

            if (equationText.contains(BinaryOperations.ADD.symbol) ||
                    equationText.contains(BinaryOperations.SUBTRACT.symbol) ||
                    equationText.contains(BinaryOperations.MULTIPLY.symbol) ||
                    equationText.contains(BinaryOperations.DIVIDE.symbol)) {

                int lastIndexOfAdd = equationText.lastIndexOf(BinaryOperations.ADD.symbol);
                int lastIndexOfSubtract = equationText.lastIndexOf(BinaryOperations.SUBTRACT.symbol);
                int lastIndexOfMultiply = equationText.lastIndexOf(BinaryOperations.MULTIPLY.symbol);
                int lastIndexOfDivide = equationText.lastIndexOf(BinaryOperations.SUBTRACT.symbol);
                lastIndexOfOperation = Math.max(Math.max(lastIndexOfAdd, lastIndexOfSubtract),
                        Math.max(lastIndexOfMultiply, lastIndexOfDivide));

                textBefore = equationText.substring(0, lastIndexOfOperation);
                textAfter = equationText.substring(lastIndexOfOperation + 1);
            }

            equationText = textBefore + SPACE + operation.symbol + OPENING_BRACKET + SPACE +
                    textAfter + SPACE + CLOSING_BRACKET;
            equation.setText(equationText);

        } else {
            calculation.setSecond(calculation.getFirst());
            calculation.setFirst(number);
            calculation.calculateUnary(operation);
            calculation.setFirst(calculation.getSecond());
            calculation.setSecond(calculation.getResult());

            screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.roundResult(calculation)));
            equation.setText(equation.getText() + SPACE + operation.symbol + OPENING_BRACKET + SPACE + number +
                    SPACE + CLOSING_BRACKET);
        }

        isBinaryOperationPressed = false;
        isUnaryOperationPressed = true;
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
        isUnaryOperationPressed = false;
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
