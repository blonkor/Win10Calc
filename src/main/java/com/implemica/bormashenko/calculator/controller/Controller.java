package com.implemica.bormashenko.calculator.controller;

import com.implemica.bormashenko.calculator.controller.util.*;
import com.implemica.bormashenko.calculator.model.*;
import com.implemica.bormashenko.calculator.model.enums.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import static com.implemica.bormashenko.calculator.controller.util.NumberFormatter.*;

/**
 * Controller for application.
 *
 * @author Mykhailo Bormashenko
 */
public class Controller implements Initializable {

    /**
     * Application's {@code Button} used in controller.
     */
    @FXML
    private Button one, two, three, four, five, six, seven, eight, nine, zero, dot,
            add, subtract, multiply, divide, equals, percent, negate, sqr, sqrt, inverse,
            memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore, memoryShow,
            clearAll, clearText, backspace, leftArrow, rightArrow;

    /**
     * Application's {@code Label} used in controller.
     */
    @FXML
    private Label screen, equation;

    /**
     * Application's {@code AnchorPane} used in controller.
     */
    @FXML
    private AnchorPane memoryAnchorPane, memoryPanel, memoryBlock, navigationBlock, aboutPanel;

    /**
     * Application's {@code ScrollPane} used in controller.
     */
    @FXML
    private ScrollPane navigationPanel, equationScroll;

    /**
     * Zero symbol is primary number in screen {@code Label}.
     */
    private static final String ZERO = "0";

    /**
     * Symbol for separation numbers and operations in equation {@code Label}.
     */
    private static final String NARROW_SPACE = "\u2009";

    /**
     * Empty string is primary string in equation {@code Label}.
     */
    private static final String EMPTY_STRING = "";

    /**
     * Symbol for separating number and operation's symbol while using {@code UnaryOperation} (before number).
     */
    private static final String OPENING_BRACKET = "(";

    /**
     * Symbol for separating number and operation's symbol while using {@code UnaryOperation} (after number).
     */
    private static final String CLOSING_BRACKET = ")";

    /**
     * {@link Calculation} model of application.
     */
    private Calculation calculation = new Calculation();

    /**
     * {@link Memory} model of application.
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
    private boolean isUnaryOrPercentOperationPressed = false;

    /**
     * True if equals was just pressed.
     */
    private boolean isEqualsPressed = false;

    /**
     * True if first number was calculated.
     */
    private boolean isFirstCalculated = false;

    /**
     * True if error was just happened.
     */
    private boolean isError = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //no initializing is needed
    }

    /**
     * Handles keyboard input and fires required {@code Button}.
     *
     * @param event keyboard code or combination that was/were pressed.
     */
    public void keyboardHandling(KeyEvent event) {

        KeyCombination ctrlM = new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN);
        KeyCombination ctrlP = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);
        KeyCombination ctrlQ = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN);
        KeyCombination ctrlR = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        KeyCombination ctrlL = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);
        KeyCombination shiftTwo = new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.SHIFT_DOWN);
        KeyCombination shiftFive = new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.SHIFT_DOWN);
        KeyCombination shiftEight = new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.SHIFT_DOWN);
        KeyCombination shiftEquals = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.SHIFT_DOWN);

        KeyCode keyCode = event.getCode();
        Button buttonToFire = null;

        //combinations with ctrl
        if (event.isControlDown()) {

            if (ctrlM.match(event)) {
                buttonToFire = memoryStore;
            } else if (ctrlP.match(event)) {
                buttonToFire = memoryAdd;
            } else if (ctrlQ.match(event)) {
                buttonToFire = memorySubtract;
            } else if (ctrlR.match(event)) {
                buttonToFire = memoryRecall;
            } else if (ctrlL.match(event)) {
                buttonToFire = memoryClear;
            }

            //combinations with shift
        } else if (event.isShiftDown()) {

            if (shiftTwo.match(event)) {
                buttonToFire = sqrt;
            } else if (shiftFive.match(event)) {
                buttonToFire = percent;
            } else if (shiftEight.match(event)) {
                buttonToFire = multiply;
            } else if (shiftEquals.match(event)) {
                buttonToFire = add;
            }

            //digit buttons
        } else if (keyCode.isDigitKey()) {

            if (keyCode == KeyCode.DIGIT0 || keyCode == KeyCode.NUMPAD0) {
                buttonToFire = zero;
            } else if (keyCode == KeyCode.DIGIT1 || keyCode == KeyCode.NUMPAD1) {
                buttonToFire = one;
            } else if (keyCode == KeyCode.DIGIT2 || keyCode == KeyCode.NUMPAD2) {
                buttonToFire = two;
            } else if (keyCode == KeyCode.DIGIT3 || keyCode == KeyCode.NUMPAD3) {
                buttonToFire = three;
            } else if (keyCode == KeyCode.DIGIT4 || keyCode == KeyCode.NUMPAD4) {
                buttonToFire = four;
            } else if (keyCode == KeyCode.DIGIT5 || keyCode == KeyCode.NUMPAD5) {
                buttonToFire = five;
            } else if (keyCode == KeyCode.DIGIT6 || keyCode == KeyCode.NUMPAD6) {
                buttonToFire = six;
            } else if (keyCode == KeyCode.DIGIT7 || keyCode == KeyCode.NUMPAD7) {
                buttonToFire = seven;
            } else if (keyCode == KeyCode.DIGIT8 || keyCode == KeyCode.NUMPAD8) {
                buttonToFire = eight;
            } else if (keyCode == KeyCode.DIGIT9 || keyCode == KeyCode.NUMPAD9) {
                buttonToFire = nine;
            }

            //letter buttons
        } else if (keyCode.isLetterKey()) {

            if (keyCode == KeyCode.R) {
                buttonToFire = inverse;
            }

            //f buttons
        } else if (keyCode.isFunctionKey()) {

            if (keyCode == KeyCode.F9) {
                buttonToFire = negate;
            }

            //any else buttons
        } else {

            if (keyCode == KeyCode.PERIOD) {
                buttonToFire = dot;
            } else if (keyCode == KeyCode.BACK_SPACE) {
                buttonToFire = backspace;
            } else if (keyCode == KeyCode.ADD) {
                buttonToFire = add;
            } else if (keyCode == KeyCode.MINUS || keyCode == KeyCode.SUBTRACT) {
                buttonToFire = subtract;
            } else if (keyCode == KeyCode.MULTIPLY) {
                buttonToFire = multiply;
            } else if (keyCode == KeyCode.DIVIDE || keyCode == KeyCode.SLASH) {
                buttonToFire = divide;
            } else if (keyCode == KeyCode.EQUALS || keyCode == KeyCode.ENTER) {
                buttonToFire = equals;
            } else if (keyCode == KeyCode.DELETE) {
                buttonToFire = clearText;
            } else if (keyCode == KeyCode.ESCAPE) {
                buttonToFire = clearAll;
            }

        }

        if (buttonToFire != null && !memoryBlock.isVisible() && !navigationBlock.isVisible()) {
            buttonToFire.fire();
        }
    }

    /**
     * Opens or closes navigation bar.
     *
     * @todo tests
     */
    public void showNavigationPanel() {
        ViewFormatter.showOrHideNavigationPanel(navigationPanel, aboutPanel, navigationBlock);
    }

    /**
     * Moves text in equation {@code Label} to the left.
     *
     * @todo tests
     */
    public void moveEquationLeft() {
        ViewFormatter.moveTextInLabel(leftArrow, rightArrow, equation, equationScroll, true);
    }

    /**
     * Moves text in equation {@code Label} to the right.
     *
     * @todo tests
     */
    public void moveEquationRight() {
        ViewFormatter.moveTextInLabel(rightArrow, leftArrow, equation, equationScroll, false);
    }

    /**
     * Shows memory.
     *
     * @todo tests
     */
    public void memoryShowOperation() {
        ViewFormatter.showOrHideMemoryPanel(memoryAnchorPane, memoryPanel, memoryBlock, memory);
    }

    /**
     * Clears all memory.
     *
     * @todo tests
     */
    public void memoryClearOperation() {
        memory.clearMemory();
        ViewFormatter.setButtonsDisability(true, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Recalls number in memory.
     *
     * @todo tests
     */
    public void memoryRecallOperation() {
        BigDecimal number = memory.recall();
        screen.setText(formatNumber(number));

        isEditableScreen = false;
    }

    /**
     * Adds number to memory.
     *
     * @todo tests
     */
    public void memoryAddOperation() {
        BigDecimal number = screenToBigDecimal(screen.getText());
        memory.addToMemory(number);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Subtracts number from memory.
     *
     * @todo tests
     */
    public void memorySubtractOperation() {
        BigDecimal number = screenToBigDecimal(screen.getText());
        memory.subtractFromMemory(number);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Saves number in memory.
     *
     * @todo tests
     */
    public void memoryStoreOperation() {
        BigDecimal number = screenToBigDecimal(screen.getText());
        memory.storeToMemory(number);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Appends digit from {@code Button} to screen {@code Label} if it is allowed.
     * Otherwise, sets the digit to screen {@code Label}.
     *
     * @param event {@code ActionEvent} that called the method.
     */
    public void appendDigit(ActionEvent event) {
        if (isError) {
            returnAfterError();
        }

        String digit = ((Button) event.getSource()).getText();
        String number;

        if (isEditableScreen) {
            number = screen.getText();
        } else {
            number = EMPTY_STRING;
        }

        screen.setText(appendDigitToNumber(number, digit));

        if (isUnaryOrPercentOperationPressed) {
            equation.setText(EMPTY_STRING);
        }

        if (isEqualsPressed || isUnaryOrPercentOperationPressed) {
            isFirstCalculated = false;
        }

        setFlags(true, false, false,
                false, isFirstCalculated, false);
    }

    /**
     * Makes number in screen {@code Label} decimal (if not decimal yet) if it is allowed.
     * Otherwise, sets "0." to screen {@code Label}.
     */
    public void appendDecimalSeparator() {
        String number;

        if (isEditableScreen) {
            number = screen.getText();
        } else {
            number = ZERO;
        }

        screen.setText(appendDecimalSeparatorIfMissed(number));

        if (isUnaryOrPercentOperationPressed) {
            equation.setText(EMPTY_STRING);
        }

        if (isEqualsPressed || isUnaryOrPercentOperationPressed) {
            isFirstCalculated = false;
        }

        setFlags(true, false, false,
                false, isFirstCalculated, false);
    }

    /**
     * Deletes last symbol in screen {@code Label} if it is allowed.
     */
    public void backspace() {
        if (isError) {
            returnAfterError();
        }

        if (isEditableScreen) {
            String number = screen.getText();
            screen.setText(deleteLastChar(number));
        }
    }

    /**
     * Sets text in screen {@code Label} to 0.
     */
    public void clearText() {
        if (isError) {
            returnAfterError();
        }

        screen.setText(ZERO);

        setFlags(true, false, false,
                false, isFirstCalculated, false);
    }

    /**
     * Resets application to it's primary.
     */
    public void resetAll() {
        if (isError) {
            returnAfterError();
        }

        clearText();
        calculation.resetAll();
        equation.setText(EMPTY_STRING);

        setFlags(true, false, false,
                false, false, false);
    }

    /**
     * Performs add operation from {@link Calculation}.
     */
    public void addOperation() {
        binaryOperationPressed(BinaryOperation.ADD);
    }

    /**
     * Performs subtract operation from {@link Calculation}.
     */
    public void subtractOperation() {
        binaryOperationPressed(BinaryOperation.SUBTRACT);
    }

    /**
     * Performs multiply operation from {@link Calculation}.
     */
    public void multiplyOperation() {
        binaryOperationPressed(BinaryOperation.MULTIPLY);
    }

    /**
     * Performs divide operation from {@link Calculation}.
     */
    public void divideOperation() {
        binaryOperationPressed(BinaryOperation.DIVIDE);
    }

    /**
     * Performs negate operation from {@link Calculation}.
     */
    public void negateOperation() {
        if (isEditableScreen) {
            screen.setText(changeSign(screen.getText()));
        } else {
            unaryOperationPressed(UnaryOperation.NEGATE);
        }
    }

    /**
     * Performs sqr operation from {@link Calculation}.
     */
    public void squareOperation() {
        unaryOperationPressed(UnaryOperation.SQR);
    }

    /**
     * Performs sqrt operation from {@link Calculation}.
     */
    public void squareRootOperation() {
        unaryOperationPressed(UnaryOperation.SQRT);
    }

    /**
     * Performs inverse operation from {@link Calculation}.
     */
    public void inverseOperation() {
        unaryOperationPressed(UnaryOperation.INVERSE);
    }

    /**
     * Performs percentage operation from {@link Calculation}.
     */
    public void percentOperation() {
        calculatePercentage();
    }

    /**
     * Performs calculate result operation.
     *
     * @see Calculation
     */
    public void equalsOperation() {
        calculateResult();
    }

    /**
     * Called when any {@code BinaryOperation} {@code Button} is pressed.
     * <p>
     * If number in screen {@code Label} ends with {@code DECIMAL_SEPARATOR}, removes it.
     * <p>
     * If {@code BinaryOperation} {@code Button} was not just pressed, performs binary not after binary operation.
     * Otherwise, performs binary after binary operation.
     *
     * @param operation {@link BinaryOperation} that should be set.
     */
    private void binaryOperationPressed(BinaryOperation operation) {
        removeLastDecimalSeparator();

        if (!isBinaryOperationPressed) {
            binaryNotAfterBinary(operation);
        } else {
            binaryAfterBinary(operation);
        }
    }

    /**
     * Performs {@code BinaryOperation} if any {@code BinaryOperation} was not just pressed.
     * <p>
     * If first number is not set, sets number in screen {@code Label} as first number. Also sets number in screen
     * {@code Label} with operation's symbol after it to equation {@code Label}.
     * <p>
     * If equals or unary or percent operation was not just performed, calculates result with first number, previously
     * set {@code BinaryOperation} and number in screen {@code Label} as second number. Result of calculation is shown
     * on screen {@code Label}. Also appends to current equation {@code Label} text number in screen {@code Label} and
     * new operation's symbol.
     * <p>
     * Otherwise, if equals was just pressed, sets number in screen {@code Label} as first number. Also, sets result of
     * calculation (or number in screen {@code Label} if current {@code BinaryOperation} is null) with new operation's
     * symbol to equation {@code Label}.
     * <p>
     * If equals was not just pressed, just appends operation's symbol to equation {@code Label}.
     * <p>
     * Also, if unary or percent operation was just performed, sets result of calculation as second number and performs
     * calculating with previously set {@code BinaryOperation}. Result of calculation is shown on screen {@code Label}.
     * <p>
     * After successfully performing any of steps below, {@code BinaryOperation} in {@code Calculation} is updated.
     * <p>
     * If any exception was thrown during calculating, it's message will be shown in screen {@code Label}.
     *
     * @param operation new operation to sen in {@code Calculation}.
     */
    private void binaryNotAfterBinary(BinaryOperation operation) {
        BigDecimal number = screenToBigDecimal(screen.getText());
        String equationTextToSet = EMPTY_STRING;

        try {

            if (!isFirstCalculated) {
                equationTextToSet = formatWithoutGroupSeparator(number) + NARROW_SPACE + operation.symbol;

                setBinaryAndFirst(operation, number);

            } else if (!isEqualsPressed && !isUnaryOrPercentOperationPressed) {
                equationTextToSet = equation.getText() + NARROW_SPACE + formatWithoutGroupSeparator(number) +
                        NARROW_SPACE + operation.symbol;

                calculateBinaryAndSetNewBinary(operation, number);

            } else {

                if (isEqualsPressed) {
                    equationTextToSet = binaryAfterEquals(operation, number);
                } else {
                    equationTextToSet = equation.getText() + NARROW_SPACE + operation.symbol;
                }

                if (isUnaryOrPercentOperationPressed) {
                    calculateBinaryAndSetNewBinary(operation, calculation.getResult());
                }
            }

            setFlags(false, true, false,
                    false, true, false);
        } catch (Exception e) {
            exceptionThrown(e.getMessage());
        } finally {
            equation.setText(equationTextToSet);
        }
    }

    /**
     * Sets {@code BinaryOperation} and first number in {@code Calculation}.
     *
     * @param operation {@code BinaryOperation} to set.
     * @param first     {@code BigDecimal} number to set as first.
     */
    private void setBinaryAndFirst(BinaryOperation operation, BigDecimal first) {
        calculation.setBinaryOperation(operation);
        calculation.setFirst(first);
    }

    /**
     * Sets second number and performs binary calculating. Then sets result as first number, sets
     * {@code BinaryOperation} and shows result in screen {@code Label}.
     *
     * @param operation {@code BinaryOperation} to set.
     * @param second    {@code BigDecimal} number to set as second.
     */
    private void calculateBinaryAndSetNewBinary(BinaryOperation operation, BigDecimal second) {
        calculation.setSecond(second);
        calculation.calculateBinary();

        setBinaryAndFirst(operation, calculation.getResult());

        screen.setText(formatNumber(calculation.getResult()));
    }

    /**
     * Builds string for equation {@code Label} with number (that is in screen {@code Label} or calculated in
     * {@code Calculation}) and operation's symbol. Then sets {@code BinaryOperation} and first number in
     * {@code Calculation}.
     * @param operation {@code BinaryOperation} to set.
     * @param number {@code BigDecimal} number to set as first.
     * @return string that should be set in equation {@code Label}.
     */
    private String binaryAfterEquals(BinaryOperation operation, BigDecimal number) {
        String equationTextToSet;

        if (calculation.getBinaryOperation() == null) {
            equationTextToSet = formatWithoutGroupSeparator(number) +
                    NARROW_SPACE + operation.symbol;
        } else {
            equationTextToSet = formatWithoutGroupSeparator(calculation.getResult()) +
                    NARROW_SPACE + operation.symbol;
        }

        setBinaryAndFirst(operation, number);

        return equationTextToSet;
    }

    /**
     * Sets new {@code BinaryOperation} and changes last symbol in equation {@code Label}.
     * @param operation {@code BinaryOperation} to set.
     */
    private void binaryAfterBinary(BinaryOperation operation) {
        calculation.setBinaryOperation(operation);

        equation.setText(equation.getText().substring(0, equation.getText().length() - 1) + operation.symbol);

        setFlags(false, true, false,
                false, true, false);
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
     * @todo refactor
     */
    private void unaryOperationPressed(UnaryOperation operation) {
        String equationTextToSet = "";

        try {
            BigDecimal number = screenToBigDecimal(screen.getText());

            if (!isFirstCalculated) {
                calculation.setFirst(number);

                equationTextToSet = operation.symbol + OPENING_BRACKET + NARROW_SPACE +
                        formatWithoutGroupSeparator(number) + NARROW_SPACE + CLOSING_BRACKET;

                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());
                screen.setText(formatNumber(calculation.getResult()));

            } else if (isUnaryOrPercentOperationPressed) {
                calculation.setFirst(calculation.getResult());

                equationTextToSet = equation.getText();

                int lastIndexOfOperation;

                String textBefore = EMPTY_STRING;
                String textAfter = equationTextToSet;

                if (equationTextToSet.contains(BinaryOperation.ADD.symbol) ||
                        equationTextToSet.contains(BinaryOperation.SUBTRACT.symbol) ||
                        equationTextToSet.contains(BinaryOperation.MULTIPLY.symbol) ||
                        equationTextToSet.contains(BinaryOperation.DIVIDE.symbol)) {

                    int lastIndexOfAdd = equationTextToSet.lastIndexOf(BinaryOperation.ADD.symbol);
                    int lastIndexOfSubtract = equationTextToSet.lastIndexOf(BinaryOperation.SUBTRACT.symbol);
                    int lastIndexOfMultiply = equationTextToSet.lastIndexOf(BinaryOperation.MULTIPLY.symbol);
                    int lastIndexOfDivide = equationTextToSet.lastIndexOf(BinaryOperation.SUBTRACT.symbol);
                    lastIndexOfOperation = Math.max(Math.max(lastIndexOfAdd, lastIndexOfSubtract),
                            Math.max(lastIndexOfMultiply, lastIndexOfDivide));

                    textBefore = equationTextToSet.substring(0, lastIndexOfOperation + 1);
                    textAfter = equationTextToSet.substring(lastIndexOfOperation + 2);
                }

                if (textBefore.equals(EMPTY_STRING)) {
                    equationTextToSet = operation.symbol + OPENING_BRACKET + NARROW_SPACE + textAfter + NARROW_SPACE +
                            CLOSING_BRACKET;
                } else {
                    equationTextToSet = textBefore + NARROW_SPACE + operation.symbol + OPENING_BRACKET + NARROW_SPACE +
                            textAfter + NARROW_SPACE + CLOSING_BRACKET;
                }

                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());

                screen.setText(formatNumber(calculation.getResult()));

            } else {
                calculation.setSecond(calculation.getFirst());
                calculation.setFirst(number);

                if (isUnaryOrPercentOperationPressed && equation.getText().equals(ZERO)) {
                    equationTextToSet = operation.symbol + OPENING_BRACKET + NARROW_SPACE +
                            formatWithoutGroupSeparator(number) + NARROW_SPACE + CLOSING_BRACKET;
                } else {

                    if (equation.getText().equals(EMPTY_STRING)) {
                        equationTextToSet = operation.symbol + OPENING_BRACKET + NARROW_SPACE +
                                formatWithoutGroupSeparator(number) + NARROW_SPACE + CLOSING_BRACKET;
                    } else {
                        equationTextToSet = equation.getText() + NARROW_SPACE + operation.symbol + OPENING_BRACKET +
                                NARROW_SPACE +
                                formatWithoutGroupSeparator(number) + NARROW_SPACE + CLOSING_BRACKET;
                    }
                }

                calculation.calculateUnary(operation);

                if (isEqualsPressed) {
                    calculation.setFirst(calculation.getResult());
                } else {
                    calculation.setFirst(calculation.getSecond());
                    calculation.setSecond(calculation.getResult());
                }

                screen.setText(formatNumber(calculation.getResult()));
            }

            setFlags(false, false, true,
                    false,
                    true, false);
        } catch (Exception e) {
            exceptionThrown(e.getMessage());
        } finally {
            equation.setText(equationTextToSet);
        }
    }

    /**
     * Calculates percentage.
     * Calls when percent button is pressed.
     * <p>
     * Calculation is possible if only binary operation is set. Otherwise, sets first number in calculation tests.model
     * to 0, and shows it in main screen and equation label.
     * <p>
     * Sets number from screen as second number in calculation tests.model. Next steps depends on which binary operation
     * is set:
     * If set binary operation is add or subtract, sets second number as percentage of first number.
     * If set binary operation is multiply or divide, sets second number as percentage of 100.
     * <p>
     * Than shows changed second number on screen and adds it to equation label.
     *
     * @todo refactor
     */
    private void calculatePercentage() {
        String equationTextToSet = equation.getText();

        if (calculation.getBinaryOperation() == null) {
            screen.setText(ZERO);

            equation.setText(ZERO);

            setFlags(false, false, true,
                    false, true, false);
        } else {

            try {
                BigDecimal number = screenToBigDecimal(screen.getText());
                calculation.setSecond(number);

                calculation.calculatePercentage();
                calculation.setSecond(calculation.getResult());

                screen.setText(formatNumber(calculation.getResult()));

                if (isUnaryOrPercentOperationPressed) {
                    String textBefore;
                    int lastIndexOfAdd = equationTextToSet.lastIndexOf(BinaryOperation.ADD.symbol);
                    int lastIndexOfSubtract = equationTextToSet.lastIndexOf(BinaryOperation.SUBTRACT.symbol);
                    int lastIndexOfMultiply = equationTextToSet.lastIndexOf(BinaryOperation.MULTIPLY.symbol);
                    int lastIndexOfDivide = equationTextToSet.lastIndexOf(BinaryOperation.SUBTRACT.symbol);
                    int lastIndexOfOperation = Math.max(Math.max(lastIndexOfAdd, lastIndexOfSubtract),
                            Math.max(lastIndexOfMultiply, lastIndexOfDivide));

                    textBefore = equationTextToSet.substring(0, lastIndexOfOperation + 1);

                    equationTextToSet = textBefore + NARROW_SPACE +
                            formatWithoutGroupSeparator(calculation.getResult());
                } else {
                    equationTextToSet += NARROW_SPACE + formatWithoutGroupSeparator(calculation.getResult());
                }

                setFlags(false, false, true,
                        false,
                        true, false);

            } catch (Exception e) {
                exceptionThrown(e.getMessage());
            } finally {
                equation.setText(equationTextToSet);
            }
        }
    }

    /**
     * Calculates result for {@link Calculation}.
     * <p>
     * Can be performed after error.
     * If number in screen {@code Label} ends with {@code DECIMAL_SEPARATOR}, removes it.
     * <p>
     * If {@code BinaryOperation} is set, calculates result for the {@code BinaryOperation}.
     * <p>
     * Equation {@code Label} text is always empty after this operation.
     * <p>
     * If {@code Exception} was thrown while calculating, performs {@code exceptionThrown} operation.
     */
    private void calculateResult() {
        returnAfterError();
        removeLastDecimalSeparator();

        try {
            if (calculation.getBinaryOperation() != null) {
                calculateResultForBinaryNotNull();
            }

            equation.setText(EMPTY_STRING);

            setFlags(false, false, false,
                    true, true, false);
        } catch (Exception e) {
            exceptionThrown(e.getMessage());
        }
    }

    /**
     * Calculates result for {@link Calculation} if {@code BinaryOperation} is set.
     * <p>
     * If equals or unary or percent operation was not just performed, calculates result not after those operations.
     * Otherwise, calculates result after those operations.
     * <p>
     * Sets result to screen {@code Label}.
     */
    private void calculateResultForBinaryNotNull() {
        BigDecimal number = screenToBigDecimal(screen.getText());

        if (!isEqualsPressed && !isUnaryOrPercentOperationPressed) {
            calculateResultNotAfterEqualsOrUnaryOrPercentage(number);
        } else {
            calculateResultAfterEqualsOrUnaryOrPercentage();
        }

        screen.setText(formatNumber(calculation.getResult()));
    }

    /**
     * Calculates result not after equals or unary or percent operation just performed.
     * <p>
     * If first number is not set, sets passed number as first. Otherwise, sets passed number as second.
     * <p>
     * Then performs {@code calculateBinary} operation from {@code Calculation} and sets result as first number.
     *
     * @param number {@code BigDecimal} number with which calculation should be performed.
     */
    private void calculateResultNotAfterEqualsOrUnaryOrPercentage(BigDecimal number) {
        if (!isFirstCalculated) {
            calculation.setFirst(number);
        } else {
            calculation.setSecond(number);
        }

        calculation.calculateBinary();
        calculation.setFirst(calculation.getResult());
    }

    /**
     * Calculates result after equals or unary or percent operation just performed.
     * <p>
     * If equals operation was just performed, sets result from {@code Calculation} as first number.
     * <p>
     * {@code calculateBinary} operation from {@code Calculation} is performed.
     */
    private void calculateResultAfterEqualsOrUnaryOrPercentage() {
        if (isEqualsPressed) {
            calculation.setFirst(calculation.getResult());
        }

        calculation.calculateBinary();
    }

    /**
     * @todo refactor
     */
    private void exceptionThrown(String message) {
        calculation.resetAll();
        screen.setText(message);
        Button[] buttonsToDisable = {
                memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore,
                percent, sqrt, sqr, inverse, divide, multiply, subtract, add, negate, dot
        };
        ViewFormatter.setButtonsDisability(true, buttonsToDisable);

        setFlags(false, false, false,
                false,
                false, true);
    }

    /**
     * @todo refactor
     */
    private void returnAfterError() {
        if (isError) {
            screen.setText(ZERO);
            equation.setText(EMPTY_STRING);

            Button[] buttonsToEnable = {
                    memoryAdd, memorySubtract, memoryStore,
                    percent, sqrt, sqr, inverse, divide, multiply, subtract, add, negate, dot
            };

            Button[] memoryStandardDisabledButtons = {
                    memoryClear, memoryRecall, memoryShow
            };

            ViewFormatter.setButtonsDisability(false, buttonsToEnable);
            ViewFormatter.setButtonsDisability(memory.getStore().isEmpty(), memoryStandardDisabledButtons);
        }
    }

    private void removeLastDecimalSeparator() {
        if (screen.getText().endsWith(String.valueOf(DECIMAL_SEPARATOR))) {
            screen.setText(screen.getText().replace(String.valueOf(DECIMAL_SEPARATOR), EMPTY_STRING));
        }
    }

    /**
     * Sets flags for boolean fields of controller.
     *
     * @param isEditableScreen                 true if digit should be appended to screen number.
     * @param isBinaryOperationPressed         true if binary operation was just pressed.
     * @param isUnaryOrPercentOperationPressed true if unary operation was just pressed.
     * @param isEqualsPressed                  true if equals was just pressed.
     * @param isFirstCalculated                true if first operand for model is calculated.
     * @param isError                          true if is error was just happened.
     */
    private void setFlags(boolean isEditableScreen, boolean isBinaryOperationPressed,
                          boolean isUnaryOrPercentOperationPressed, boolean isEqualsPressed, boolean isFirstCalculated,
                          boolean isError) {
        this.isEditableScreen = isEditableScreen;
        this.isBinaryOperationPressed = isBinaryOperationPressed;
        this.isUnaryOrPercentOperationPressed = isUnaryOrPercentOperationPressed;
        this.isEqualsPressed = isEqualsPressed;
        this.isFirstCalculated = isFirstCalculated;
        this.isError = isError;
    }
}
