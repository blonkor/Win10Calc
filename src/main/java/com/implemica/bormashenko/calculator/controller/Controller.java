package com.implemica.bormashenko.calculator.controller;

import com.implemica.bormashenko.calculator.controller.util.NumberFormatter;
import com.implemica.bormashenko.calculator.controller.util.ViewFormatter;
import com.implemica.bormashenko.calculator.model.Memory;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperations;
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
 * Controller for application's controls.
 *
 * @author Mykhailo Bormashenko
 */
public class Controller implements Initializable {

    /**
     * Application's buttons.
     */
    @FXML
    private Button one, two, three, four, five, six, seven, eight, nine, zero,
            memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore, memoryShow,
            percent, sqrt, sqr, inverse, divide, multiply, subtract, add, negate, dot, backspace,
            navigation, history, close, hide, expand, leftArrow, rightArrow, equals, clearText, clearAll;

    /**
     * Application's labels.
     */
    @FXML
    private Label screen, equation;

    /**
     * Application's scroll pane.
     */
    @FXML
    private ScrollPane navigationPanel, equationScroll;

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

    private String equationText;

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

    private boolean isError = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //no initializing is needed
    }

    /**
     * Appends digit from button to result screen if it is allowed.
     * Otherwise, sets the digit to result screen.
     *
     * @param event {@code ActionEvent} that caused the method.
     */
    public void appendDigit(ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();

        String number;

        if (isEditableScreen) {
            number = screen.getText();
        } else {
            number = EMPTY_STRING;
        }

        screen.setText(NumberFormatter.appendDigit(number, digit));

//        if (isPercentPressed || isUnaryOperationPressed) {
//            equation.setText(EMPTY_STRING);
        //    equationText = EMPTY_STRING;
//        }
//
//        if (isEqualsPressed || isUnaryOperationPressed) {
//            isFirstCalculated = false;
//        }

        isBinaryOperationPressed = false;
        isUnaryOperationPressed = false;
        isPercentPressed = false;
        isEqualsPressed = false;
        isError = false;
        isEditableScreen = true;
    }

    /**
     * Makes number in result screen decimal (if not decimal yet) if it is allowed.
     * Otherwise, sets "0." to result screen.
     */
    public void makeDecimal() {
        String number;

        if (isEditableScreen) {
            number = screen.getText();
        } else {
            number = ZERO;
        }

        screen.setText(NumberFormatter.appendDot(number));
    }

    /**
     * Deletes last symbol in result screen if it is allowed.
     */
    public void backspace() {
        if (isEditableScreen) {
            String number = screen.getText();
            screen.setText(NumberFormatter.deleteLastChar(number));
        }
    }

    /**
     * Opens or closes navigation bar.
     */
    public void showNavigationPanel() {
        ViewFormatter.showOrHideNavigationPanel(navigationPanel, aboutPanel, navigationBlock);
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
     * Shows memory.
     */
    public void memoryShowOperation() {
        ViewFormatter.showOrHideMemoryPanel(memoryAnchorPane, memoryBlock,
                new Button[]{memoryAdd, memorySubtract, memoryStore},
                new Button[]{memoryClear, memoryRecall});
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
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
        memory.addToMemory(number);
        ViewFormatter.updateMemoryLabels(memory, memoryPanel);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Subtracts number from memory.
     */
    public void memorySubtractOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
        memory.subtractFromMemory(number);
        ViewFormatter.updateMemoryLabels(memory, memoryPanel);
        ViewFormatter.setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);
    }

    /**
     * Saves number in memory.
     */
    public void memoryStoreOperation() {
        BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
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
        equationText = EMPTY_STRING;

        isBinaryOperationPressed = false;
        isUnaryOperationPressed = false;
        isPercentPressed = false;
        isEqualsPressed = false;
        isFirstCalculated = false;
        isEditableScreen = true;
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
                BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());

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
            equationText = EMPTY_STRING;

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
        try {
            if (!isBinaryOperationPressed) {
                BigDecimal numberOnScreen = NumberFormatter.screenToBigDecimal(screen.getText());

                if (!isFirstCalculated) {
                    calculation.setFirst(numberOnScreen);
                    calculation.setBinaryOperation(operation);

                    equation.setText(calculation.getFirst() + SPACE + operation.symbol);
                    equationText = calculation.getFirst() + SPACE + operation.symbol;
                } else if (!isEqualsPressed && !isUnaryOperationPressed) {
                    calculation.setSecond(numberOnScreen);
                    calculation.calculateBinary();
                    calculation.setFirst(calculation.getResult());
                    calculation.setBinaryOperation(operation);

                    screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));
                    equation.setText(equation.getText() + SPACE + calculation.getSecond() + SPACE + operation.symbol);
                    equationText = equation.getText() + SPACE + calculation.getSecond() + SPACE + operation.symbol;
                } else {

                    if (isUnaryOperationPressed) {
                        calculation.calculateBinary();

                        screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));
                    }

                    calculation.setBinaryOperation(operation);

                    if (isEqualsPressed) {
                        calculation.setFirst(numberOnScreen);

                        equation.setText(NumberFormatter.round(calculation.getResult()) + SPACE + operation.symbol);
                        equationText = NumberFormatter.round(calculation.getResult()) + SPACE + operation.symbol;
                    } else {
                        equation.setText(equation.getText() + SPACE + operation.symbol);
                        equationText = equation.getText() + SPACE + operation.symbol;
                    }

                }

            } else {
                calculation.setBinaryOperation(operation);

                equation.setText(equation.getText().substring(0, equation.getText().length() - 1) + operation.symbol);
                equationText = equation.getText().substring(0, equation.getText().length() - 1) + operation.symbol;
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

            BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());

            if (!isFirstCalculated) {
                calculation.setFirst(number);
                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());

                screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));
                equation.setText(operation.symbol + OPENING_BRACKET + SPACE + number.toString() +
                        SPACE + CLOSING_BRACKET + SPACE);
                equationText = operation.symbol + OPENING_BRACKET + SPACE + number.toString() +
                        SPACE + CLOSING_BRACKET + SPACE;

            } else if (isUnaryOperationPressed) {
                calculation.setSecond(calculation.getFirst());
                calculation.setFirst(number);
                calculation.calculateUnary(operation);
                calculation.setFirst(calculation.getResult());

                screen.setText(NumberFormatter.bigDecimalToScreen(NumberFormatter.round(calculation.getResult())));

                String equationTextToSet = equation.getText();
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
                    textAfter = equationTextToSet.substring(lastIndexOfOperation + 1);
                }

                equationTextToSet = textBefore + SPACE + operation.symbol + OPENING_BRACKET + SPACE +
                        textAfter + SPACE + CLOSING_BRACKET;
                equation.setText(equationTextToSet);
                equationText = equationTextToSet;

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
                equationText = equation.getText() + SPACE + operation.symbol + OPENING_BRACKET + SPACE +
                        NumberFormatter.bigDecimalToScreen(NumberFormatter.round(number)) + SPACE + CLOSING_BRACKET;
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
        if (calculation.getBinaryOperation() == null) {
            calculation.setFirst(BigDecimal.ZERO);

            screen.setText(ZERO);
            equation.setText(ZERO);
            equationText = ZERO;

        } else {
            BinaryOperations operation = calculation.getBinaryOperation();
            BigDecimal number = NumberFormatter.screenToBigDecimal(screen.getText());
            calculation.setSecond(number);

            if (operation == BinaryOperations.ADD || operation == BinaryOperations.SUBTRACT) {
                calculation.percentageOfFirst();
            } else if (operation == BinaryOperations.MULTIPLY || operation == BinaryOperations.DIVIDE) {
                calculation.percentageOf100();
            }

            screen.setText(NumberFormatter.bigDecimalToScreen(calculation.getSecond()));
            equation.setText(equation.getText() + SPACE + NumberFormatter.bigDecimalToScreen(calculation.getSecond()));
            equationText = equation.getText() + SPACE + NumberFormatter.bigDecimalToScreen(calculation.getSecond());
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
