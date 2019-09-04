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
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

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
    private static final String SPACE = " ";

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
     * Moves text in equation label to the left.
     */
    public void moveEquationLeft() {
        rightArrow.setVisible(true);

        Text text = new Text(equation.getText());
        text.setFont(equation.getFont());

        double newHValue = equationScroll.getHvalue();

        if (text.getBoundsInLocal().getWidth() > leftArrow.getScene().getWidth() * 1.5) {
            newHValue += text.getBoundsInLocal().getWidth() / leftArrow.getScene().getWidth() / 2 * 0.1;
        } else {
            newHValue = equationScroll.getHmax();
        }

        equationScroll.setHvalue(newHValue);

        if (equationScroll.getHvalue() == equationScroll.getHmax()) {
            leftArrow.setVisible(false);
        }
    }

    /**
     * Moves text in equation label to the right.
     */
    public void moveEquationRight() {
        leftArrow.setVisible(true);

        Text text = new Text(equation.getText());
        text.setFont(equation.getFont());

        double newHValue = equationScroll.getHvalue();

        if (text.getBoundsInLocal().getWidth() > rightArrow.getScene().getWidth() * 1.5) {
            newHValue -= text.getBoundsInLocal().getWidth() / rightArrow.getScene().getWidth() / 2 * 0.1;
        } else {
            newHValue = equationScroll.getHmin();
        }

        equationScroll.setHvalue(newHValue);

        if (equationScroll.getHvalue() == equationScroll.getHmin()) {
            rightArrow.setVisible(false);
        }
    }

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

            //digit symbols
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

            //letter symbols
        } else if (keyCode.isLetterKey()) {

            if (keyCode == KeyCode.R) {
                buttonToFire = inverse;
            }

            //f symbols
        } else if (keyCode.isFunctionKey()) {

            if (keyCode == KeyCode.F9) {
                buttonToFire = negate;
            }

            //any else symbols
        } else {

            if (keyCode == KeyCode.PERIOD) {
                buttonToFire = dot;
            } else if (keyCode == KeyCode.BACK_SPACE) {
                buttonToFire = backspace;
            } else if (keyCode == KeyCode.PLUS || keyCode == KeyCode.ADD) {
                buttonToFire = add;
            } else if (keyCode == KeyCode.MINUS || keyCode == KeyCode.SUBTRACT) {
                buttonToFire = subtract;
            } else if (keyCode == KeyCode.MULTIPLY || keyCode == KeyCode.STAR) {
                buttonToFire = multiply;
            } else if (keyCode == KeyCode.DIVIDE || keyCode == KeyCode.SLASH) {
                buttonToFire = divide;
            } else if (keyCode == KeyCode.EQUALS || keyCode == KeyCode.ENTER) {
                buttonToFire = equals;
            } else if (keyCode == KeyCode.AT) {
                buttonToFire = sqrt;
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

        screen.setText(NumberFormatter.appendDigit(number, digit));

        if (isUnaryOrPercentOperationPressed) {
            equation.setText(EMPTY_STRING);
        }

        if (isEqualsPressed || isUnaryOrPercentOperationPressed) {
            isFirstCalculated = false;
        }

        setFlags(true, false, false, false,
                isFirstCalculated, false);
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

        screen.setText(NumberFormatter.appendDecimalSeparator(number));

        if (isUnaryOrPercentOperationPressed) {
            equation.setText(EMPTY_STRING);
        }

        if (isEqualsPressed || isUnaryOrPercentOperationPressed) {
            isFirstCalculated = false;
        }

        setFlags(true, false, false, false,
                isFirstCalculated, false);
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
            screen.setText(NumberFormatter.deleteLastChar(number));
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

        setFlags(true, false, false, false,
                isFirstCalculated, false);
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

        setFlags(true, false, false, false,
                false, false);
    }

    /**
     * Performs add operation from {@code Calculation}.
     */
    public void addOperation() {
        binaryOperationPressed(BinaryOperations.ADD);
    }

    /**
     * Performs subtract operation from {@code Calculation}.
     */
    public void subtractOperation() {
        binaryOperationPressed(BinaryOperations.SUBTRACT);
    }

    /**
     * Performs multiply operation from {@code Calculation}.
     */
    public void multiplyOperation() {
        binaryOperationPressed(BinaryOperations.MULTIPLY);
    }

    /**
     * Performs dibide operation from {@code Calculation}.
     */
    public void divideOperation() {
        binaryOperationPressed(BinaryOperations.DIVIDE);
    }

    /**
     * Performs negate operation from {@code Calculation}.
     */
    public void negateOperation() {
        if (isEditableScreen) {
            screen.setText(NumberFormatter.changeSign(screen.getText()));
        } else {
            unaryOperationPressed(UnaryOperations.NEGATE);
        }
    }

    /**
     * Performs sqr operation from {@code Calculation}.
     */
    public void squareOperation() {
        unaryOperationPressed(UnaryOperations.SQR);
    }

    /**
     * Performs sqrt operation from {@code Calculation}.
     */
    public void squareRootOperation() {
        unaryOperationPressed(UnaryOperations.SQRT);
    }

    /**
     * Performs inverse operation from {@code Calculation}.
     */
    public void inverseOperation() {
        unaryOperationPressed(UnaryOperations.INVERSE);
    }

    /**
     * Performs percentage operation from {@code Calculation}.
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
        if (isError) {
            returnAfterError();
        }

        if (screen.getText().endsWith(".")) {
            screen.setText(screen.getText().replace(".", ""));
        }

        try {
            if (calculation.getBinaryOperation() != null) {
                BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());

                if (!isEqualsPressed && !isUnaryOrPercentOperationPressed) {

                    if (!isFirstCalculated) {
                        calculation.setFirst(number);
                    } else {
                        calculation.setSecond(number);
                    }

                    calculation.calculateBinary();
                    calculation.setFirst(calculation.getResult());
                } else {

                    if (isEqualsPressed) {
                        calculation.setFirst(calculation.getResult());
                    }

                    calculation.calculateBinary();
                }

                screen.setText(NumberFormatter.formatNumber(calculation.getResult()));

                setFlags(false, false, false, true,
                        true, false);
            }

            equation.setText(EMPTY_STRING);

            isEditableScreen = false;
            isEqualsPressed = true;
            isFirstCalculated = true;
        } catch (Exception e) {
            exceptionThrown(e.getMessage());
        }
    }

    /**
     * Shows memory.
     */
    public void memoryShowOperation() {
        ViewFormatter.showOrHideMemoryPanel(memoryAnchorPane, memoryPanel, memoryBlock, memory);
    }

    /**
     * Clears all memory.
     */
    public void memoryClearOperation() {
        memory.clearMemory();
        ViewFormatter.setButtonsDisability(true, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Recalls number in memory.
     */
    public void memoryRecallOperation() {
        BigDecimal number = memory.recall();
        screen.setText(NumberFormatter.formatNumber(number));

        isEditableScreen = false;
    }

    /**
     * Adds number to memory.
     */
    public void memoryAddOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
        memory.addToMemory(number);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Subtracts number from memory.
     */
    public void memorySubtractOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
        memory.subtractFromMemory(number);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Saves number in memory.
     */
    public void memoryStoreOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
        memory.storeToMemory(number);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Opens or closes navigation bar.
     */
    public void showNavigationPanel() {
        ViewFormatter.showOrHideNavigationPanel(navigationPanel, aboutPanel, navigationBlock);
    }

    /**
     * Calculates equation with binary operation.
     * Calls when any binary operation is pressed.
     * <p>
     * If first number is not saved, saves number on screen as first number,
     * sets inputted binary operation to tests.model and shows first number and operation in equation label.
     * <p>
     * If first number is saved and calculation was not just made, saves number on screen as second,
     * calculates result of binary operation set in tests.model, saves result of operation as first number,
     * sets inputted binary operation to tests.model, than shows result of previous operation om screen and
     * adds second number in tests.model and operation symbol to equation label.
     * <p>
     * If first number is saved and calculation was just made, sets inputted binary operation to tests.model
     * and shows first number and operation in equation label (this is needed because after calculation was made result
     * of calculation is saved as first number).
     * <p>
     * If operation was just pressed, sets inputted binary operation to tests.model and changes last symbol (which is a symbol
     * of previously inputted binary operation) in equation label to actual.
     *
     * @param operation binary operation to set.
     * @see BinaryOperations
     * @see Calculation
     */
    private void binaryOperationPressed(BinaryOperations operation) {
        if (screen.getText().endsWith(".")) {
            screen.setText(screen.getText().replace(".", ""));
        }

        String equationTextToSet = "";

        try {
            if (!isBinaryOperationPressed) {
                BigDecimal numberOnScreen = NumberFormatter.screenToBigDecimal(screen.getText());

                if (!isFirstCalculated) {
                    calculation.setFirst(numberOnScreen);
                    calculation.setBinaryOperation(operation);

                    equationTextToSet = NumberFormatter.formatWithoutGroupSeparator(calculation.getFirst())
                            + SPACE + operation.symbol;

                } else if (!isEqualsPressed && !isUnaryOrPercentOperationPressed) {
                    calculation.setSecond(numberOnScreen);

                    equationTextToSet = equation.getText() + SPACE +
                            NumberFormatter.formatWithoutGroupSeparator(calculation.getSecond()) +
                            SPACE + operation.symbol;


                    calculation.calculateBinary();
                    calculation.setFirst(calculation.getResult());
                    calculation.setBinaryOperation(operation);

                    screen.setText(NumberFormatter.formatNumber(calculation.getResult()));

                } else {

                    if (isUnaryOrPercentOperationPressed) {
                        calculation.setSecond(calculation.getResult());

                        calculation.calculateBinary();

                        calculation.setFirst(calculation.getResult());

                        screen.setText(NumberFormatter.formatNumber(calculation.getResult()));
                    }

                    if (isEqualsPressed) {
                        calculation.setFirst(numberOnScreen);

                        if (calculation.getBinaryOperation() == null) {
                            equationTextToSet = numberOnScreen + SPACE + operation.symbol;
                        } else {
                            equationTextToSet = NumberFormatter.formatWithoutGroupSeparator(calculation.getResult()) +
                                    SPACE + operation.symbol;
                        }

                    } else {
                        equationTextToSet = equation.getText() + SPACE + operation.symbol;
                    }

                    calculation.setBinaryOperation(operation);
                }

            } else {
                calculation.setBinaryOperation(operation);

                equationTextToSet = equation.getText().substring(0, equation.getText().length() - 1) + operation.symbol;
            }

            setFlags(false, true, false, false,
                    true, false);

        } catch (Exception e) {
            exceptionThrown(e.getMessage());
        } finally {
            equation.setText(equationTextToSet);
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
        String equationTextToSet = "";

        try {
            BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());

            if (!isFirstCalculated) {
                calculation.setFirst(number);

                equationTextToSet = operation.symbol + OPENING_BRACKET + number.toString() + CLOSING_BRACKET;

                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());
                screen.setText(NumberFormatter.formatNumber(calculation.getResult()));

            } else if (isUnaryOrPercentOperationPressed) {
                calculation.setFirst(calculation.getResult());

                equationTextToSet = equation.getText();

                int lastIndexOfOperation;

                String textBefore = EMPTY_STRING;
                String textAfter = equationTextToSet;

                if (equationTextToSet.contains(BinaryOperations.ADD.symbol) ||
                        equationTextToSet.contains(BinaryOperations.SUBTRACT.symbol) ||
                        equationTextToSet.contains(BinaryOperations.MULTIPLY.symbol) ||
                        equationTextToSet.contains(BinaryOperations.DIVIDE.symbol)) {

                    int lastIndexOfAdd = equationTextToSet.lastIndexOf(BinaryOperations.ADD.symbol);
                    int lastIndexOfSubtract = equationTextToSet.lastIndexOf(BinaryOperations.SUBTRACT.symbol);
                    int lastIndexOfMultiply = equationTextToSet.lastIndexOf(BinaryOperations.MULTIPLY.symbol);
                    int lastIndexOfDivide = equationTextToSet.lastIndexOf(BinaryOperations.SUBTRACT.symbol);
                    lastIndexOfOperation = Math.max(Math.max(lastIndexOfAdd, lastIndexOfSubtract),
                            Math.max(lastIndexOfMultiply, lastIndexOfDivide));

                    textBefore = equationTextToSet.substring(0, lastIndexOfOperation + 1);
                    textAfter = equationTextToSet.substring(lastIndexOfOperation + 2);
                }

                if (textBefore.equals(EMPTY_STRING)) {
                    equationTextToSet = operation.symbol + OPENING_BRACKET + textAfter + CLOSING_BRACKET;
                } else {
                    equationTextToSet = textBefore + SPACE + operation.symbol + OPENING_BRACKET + textAfter + CLOSING_BRACKET;
                }

                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());

                screen.setText(NumberFormatter.formatNumber(calculation.getResult()));

            } else {
                calculation.setSecond(calculation.getFirst());
                calculation.setFirst(number);

                if (isUnaryOrPercentOperationPressed && equation.getText().equals(ZERO)) {
                    equationTextToSet = operation.symbol + OPENING_BRACKET +
                            NumberFormatter.formatWithoutGroupSeparator(number) + CLOSING_BRACKET;
                } else {

                    if (equation.getText().equals(EMPTY_STRING)) {
                        equationTextToSet = operation.symbol + OPENING_BRACKET +
                                NumberFormatter.formatWithoutGroupSeparator(number) + CLOSING_BRACKET;
                    } else {
                        equationTextToSet = equation.getText() + SPACE + operation.symbol + OPENING_BRACKET +
                                NumberFormatter.formatWithoutGroupSeparator(number) + CLOSING_BRACKET;
                    }
                }

                calculation.calculateUnary(operation);

                if (isEqualsPressed) {
                    calculation.setFirst(calculation.getResult());
                } else {
                    calculation.setFirst(calculation.getSecond());
                    calculation.setSecond(calculation.getResult());
                }

                screen.setText(NumberFormatter.formatNumber(calculation.getResult()));
            }

            setFlags(false, false, true, false,
                    true,  false);
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
     */
    private void calculatePercentage() {
        String equationTextToSet = equation.getText();

        if (calculation.getBinaryOperation() == null) {
            screen.setText(ZERO);

            equation.setText(ZERO);

            setFlags(false, false, true, false,
                    true, false);
        } else {

            try {
                BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
                calculation.setSecond(number);

                calculation.calculatePercentage();

                screen.setText(NumberFormatter.formatNumber(calculation.getSecond()));

                if (isUnaryOrPercentOperationPressed) {
                    String textBefore;
                    int lastIndexOfAdd = equationTextToSet.lastIndexOf(BinaryOperations.ADD.symbol);
                    int lastIndexOfSubtract = equationTextToSet.lastIndexOf(BinaryOperations.SUBTRACT.symbol);
                    int lastIndexOfMultiply = equationTextToSet.lastIndexOf(BinaryOperations.MULTIPLY.symbol);
                    int lastIndexOfDivide = equationTextToSet.lastIndexOf(BinaryOperations.SUBTRACT.symbol);
                    int lastIndexOfOperation = Math.max(Math.max(lastIndexOfAdd, lastIndexOfSubtract),
                            Math.max(lastIndexOfMultiply, lastIndexOfDivide));

                    textBefore = equationTextToSet.substring(0, lastIndexOfOperation + 1);

                    equationTextToSet = textBefore + SPACE +
                            NumberFormatter.formatWithoutGroupSeparator(calculation.getSecond());
                } else {
                    equationTextToSet += SPACE + NumberFormatter.formatWithoutGroupSeparator(calculation.getSecond());
                }

                setFlags(false, false, true, false,
                        true, false);

            } catch (Exception e) {
                exceptionThrown(e.getMessage());
            } finally {
                equation.setText(equationTextToSet);
            }
        }
    }

    private void exceptionThrown(String message) {
        calculation.resetAll();
        screen.setText(message);
        Button[] buttonsToDisable = {
                memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore,
                percent, sqrt, sqr, inverse, divide, multiply, subtract, add, negate, dot
        };
        ViewFormatter.setButtonsDisability(true, buttonsToDisable);

        setFlags(false, false, false, false,
                false, true);
    }

    private void returnAfterError() {
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

    /**
     * Sets flags for boolean fields of controller.
     *
     * @param isEditableScreen         true if digit should be appended to screen number.
     * @param isBinaryOperationPressed true if binary operation was just pressed.
     * @param isUnaryOrPercentOperationPressed  true if unary operation was just pressed.
     * @param isEqualsPressed          true if equals was just pressed.
     * @param isFirstCalculated        true if first operand for model is calculated.
     * @param isError                  true if is error was just happened.
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
