package com.implemica.bormashenko.calculator.controller;

import com.implemica.bormashenko.calculator.controller.util.NumberFormatter;
import com.implemica.bormashenko.calculator.controller.util.ViewFormatter;
import com.implemica.bormashenko.calculator.model.Memory;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperations;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
            percent, sqrt, sqr, inverse, divide, multiply, subtract, add, negate, dot,
            navigation, history, close, hide, expand, leftArrow, rightArrow;

    /**
     * Application's labels.
     */
    @FXML
    private Label screen, equation;

    /**
     * Application's scroll pane.
     */
    @FXML
    private ScrollPane navigationPanel;

    /**
     * Application's anchor pane.
     */
    @FXML
    private AnchorPane mainAnchor, memoryAnchorPane, memoryPanel, memoryBlock, navigationBlock, aboutPanel;

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
     * Model of application's calculation.
     */
    private Calculation calculation = new Calculation();

    /**
     * Model of application's memory.
     */
    private Memory memory = new Memory();

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

    private boolean isError= false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //no initializing is needed
    }

    /**
     * Opens or closes navigation bar.
     */
    public void showNavigationPanel() {
        ViewFormatter.showNavigationPanel(navigationPanel, aboutPanel, navigationBlock);
    }

    public void moveEquationLeft() {
        ViewFormatter.moveEquationLeft();
    }

    public void moveEquationRight() {
        ViewFormatter.moveEquationRight();
    }

    /**
     * Shows memory.
     */
    public void memoryShowOperation() {
        ViewFormatter.showMemoryPanel(memoryAnchorPane, memoryBlock,
                new Button[]{memoryAdd, memorySubtract, memoryStore},
                new Button[]{memoryClear, memoryRecall},
                memory.getStore().isEmpty());
    }

    /**
     * Clears all memory.
     */
    public void memoryClearOperation() {
        memory.clearMemory();
        ViewFormatter.updateMemoryLabels(memory, memoryPanel);
        ViewFormatter.setButtonsDisability(true, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Recalls number in memory.
     */
    public void memoryRecallOperation() {
        BigDecimal number = memory.recall();
        screen.setText(NumberFormatter.bigDecimalToScreen(number));

        isEditableScreen = false;
    }

    /**
     * Adds number to memory.
     */
    public void memoryAddOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen);
        memory.addToMemory(number);
        ViewFormatter.updateMemoryLabels(memory, memoryPanel);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Subtracts number from memory.
     */
    public void memorySubtractOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen);
        memory.subtractFromMemory(number);
        ViewFormatter.updateMemoryLabels(memory, memoryPanel);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Saves number in memory.
     */
    public void memoryStoreOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen);
        memory.storeToMemory(number);
        ViewFormatter.updateMemoryLabels(memory, memoryPanel);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
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

    public void addDigitZero() {
        addDigit("0");
    }

    public void addDigitOne() {
        addDigit("1");
    }

    public void addDigitTwo() {
        addDigit("2");
    }

    public void addDigitThree() {
        addDigit("3");
    }

    public void addDigitFour() {
        addDigit("4");
    }

    public void addDigitFive() {
        addDigit("5");
    }

    public void addDigitSix() {
        addDigit("6");
    }

    public void addDigitSeven() {
        addDigit("7");
    }

    public void addDigitEight() {
        addDigit("8");
    }

    public void addDigitNine() {
        addDigit("9");
    }

    /**
     * Adds digit from button to result screen while button is clicked.
     */
    private void addDigit(String digit) {
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
     */
    public void makeDecimal() {
        String number = screen.getText();
        boolean isOperationPressed = isBinaryOperationPressed && isUnaryOperationPressed && isPercentPressed;
        screen.setText(NumberFormatter.addDot(number, isOperationPressed));
    }

    /**
     * Deletes last symbol in result screen.
     */
    public void backspace() {
        if (isEditableScreen) {
            String number = screen.getText();
            screen.setText(NumberFormatter.deleteLastChar(number));
        }
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
        try {
            if (calculation.getBinaryOperation() != null) {
                BigDecimal number = NumberFormatter.screenToBigDecimal(screen);

                if (!isEqualsPressed && !isUnaryOperationPressed) {

                    if (!isFirstCalculated) {
                        calculation.setFirst(number);
                    } else {
                        calculation.setSecond(number);
                    }

                    calculation.calculateBinary();
                    calculation.setFirst(calculation.getResult());
                } else {

                    if (isEqualsPressed) {
                        calculation.setFirst(number);
                    }

                    calculation.calculateBinary();
                }

                screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));

                isBinaryOperationPressed = false;
                isUnaryOperationPressed = false;
                isPercentPressed = false;
                isEqualsPressed = true;
                isFirstCalculated = true;
            }

            equation.setText(EMPTY_STRING);

            isEditableScreen = false;
        } catch (ArithmeticException e) {
            exceptionThrown(e.getMessage());
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
        try {
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

                    screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));
                    equation.setText(equation.getText() + SPACE + calculation.getSecond() + SPACE + operation.symbol);
                } else {

                    if (isUnaryOperationPressed) {
                        calculation.calculateBinary();

                        screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));
                    }

                    calculation.setBinaryOperation(operation);

                    if (isEqualsPressed) {
                        calculation.setFirst(numberOnScreen);

                        equation.setText(NumberFormatter.round(calculation.getResult()) + SPACE + operation.symbol);
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
        } catch (ArithmeticException e) {
            exceptionThrown(e.getMessage());
        }
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
        try {

            BigDecimal number = NumberFormatter.screenToBigDecimal(screen);

            if (!isFirstCalculated) {
                calculation.setFirst(number);
                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());

                screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));
                equation.setText(operation.symbol + OPENING_BRACKET + SPACE + number.toString() +
                        SPACE + CLOSING_BRACKET + SPACE);

            } else if (isUnaryOperationPressed) {
                calculation.setSecond(calculation.getFirst());
                calculation.setFirst(number);
                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());

                screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));

                String equationText = equation.getText();
                int lastIndexOfOperation;

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

                    textBefore = equationText.substring(0, lastIndexOfOperation + 1);
                    textAfter = equationText.substring(lastIndexOfOperation + 1);
                }

                equationText = textBefore + SPACE + operation.symbol + OPENING_BRACKET + SPACE +
                        textAfter + SPACE + CLOSING_BRACKET;
                equation.setText(equationText);

            } else {
                calculation.setSecond(calculation.getFirst());
                calculation.setFirst(number);
                calculation.calculateUnary(operation);

                if (isEqualsPressed) {
                    calculation.setFirst(calculation.getResult());
                } else {
                    calculation.setFirst(calculation.getSecond());
                    calculation.setSecond(calculation.getResult());
                }

                screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));
                equation.setText(equation.getText() + SPACE + operation.symbol + OPENING_BRACKET + SPACE +
                        NumberFormatter.bigDecimalToScreen(NumberFormatter.round(number)) + SPACE + CLOSING_BRACKET);
            }


            isBinaryOperationPressed = false;
            isUnaryOperationPressed = true;
            isPercentPressed = false;
            isEqualsPressed = false;
            isFirstCalculated = true;
            isEditableScreen = false;
        } catch (ArithmeticException e) {
            exceptionThrown(e.getMessage());
        }
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
            equation.setText(equation.getText() + SPACE + NumberFormatter.bigDecimalToScreen(calculation.getSecond()));
        }

        isBinaryOperationPressed = false;
        isUnaryOperationPressed = false;
        isPercentPressed = true;
        isEqualsPressed = false;
        isFirstCalculated = true;
        isEditableScreen = false;
    }

    private void exceptionThrown(String message) {
        calculation.resetAll();
        screen.setText(message);
        Button[] buttonsToDisable = {
                memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore,
                percent, sqrt, sqr, inverse, divide, multiply, subtract, add, negate, dot
        };
        ViewFormatter.setButtonsDisability(true, buttonsToDisable);

        isError = true;
    }
}
