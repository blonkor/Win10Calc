package com.implemica.bormashenko.calculator.controller;

import com.implemica.bormashenko.calculator.model.*;
import com.implemica.bormashenko.calculator.model.enums.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

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
     * Multiplicand for {@code Text} width used in moving the {@code Text} in equation {@code Label}.
     */
    private static final double MULTIPLICAND_FOR_TEXT_WIDTH = 1.5;

    /**
     * Scale for offset that should be applied to H value of equation scroll.
     */
    private static final int MOVE_LABEL_SCALE = 2;

    /**
     * Layout for memory {@code Label}.
     */
    private static final int MEMORY_LABELS_LAYOUT = 16;

    /**
     * Pref height for memory {@code Label}.
     */
    private static final int MEMORY_LABELS_HEIGHT = 63;

    /**
     * Font size for memory {@code Label}.
     */
    private static final int MEMORY_LABELS_FONT_SIZE = 24;

    /**
     * Insets for memory {@code Label}.
     */
    private static final Insets MEMORY_LABELS_INSETS = new Insets(0, 15, 0, 15);

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
    private boolean isUnaryOrPercentPressed = false;

    /**
     * True if equals was just pressed.
     */
    private boolean isEqualsPressed = false;

    /**
     * True if first number was calculated.
     */
    private boolean isFirstSet = false;

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
     */
    public void showOrHideNavigationPanel() {
        navigationPanel.setVisible(!navigationPanel.isVisible());
        aboutPanel.setVisible(!aboutPanel.isVisible());
        navigationBlock.setVisible(!navigationBlock.isVisible());
    }

    /**
     * Moves text in equation {@code Label} to the left.
     */
    public void moveEquationLeft() {
        moveTextInEquationLabel(leftArrow, rightArrow, true);
    }

    /**
     * Moves text in equation {@code Label} to the right.
     */
    public void moveEquationRight() {
        moveTextInEquationLabel(rightArrow, leftArrow, false);
    }

    /**
     * Saves number in memory.
     */
    public void memoryStoreOperation() {
        BigDecimal number = screenToBigDecimal(screen.getText());
        memory.storeToMemory(number);
        setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);

        isEditableScreen = false;
    }

    /**
     * Shows memory.
     */
    public void memoryShowOperation() {
        memoryAnchorPane.setVisible(!memoryAnchorPane.isVisible());
        memoryBlock.setVisible(!memoryBlock.isVisible());

        if (memoryAnchorPane.isVisible()) {
            updateMemoryLabels();
        }
    }

    /**
     * Clears all memory.
     */
    public void memoryClearOperation() {
        memory.clearMemory();
        setButtonsDisability(true, memoryClear, memoryRecall, memoryShow);

        isEditableScreen = false;
    }

    /**
     * Recalls number in memory.
     */
    public void memoryRecallOperation() {
        try {
            BigDecimal number = memory.recall();
            screen.setText(formatNumber(number));

            isEditableScreen = false;
        } catch (Exception e) {
            exceptionThrown(e.getMessage());
        }
    }

    /**
     * Adds number to memory.
     */
    public void memoryAddOperation() {
        BigDecimal number = screenToBigDecimal(screen.getText());
        memory.addToMemory(number);
        setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);

        isEditableScreen = false;
    }

    /**
     * Subtracts number from memory.
     */
    public void memorySubtractOperation() {
        BigDecimal number = screenToBigDecimal(screen.getText());
        memory.subtractFromMemory(number);
        setButtonsDisability(false, memoryClear, memoryRecall, memoryShow);

        isEditableScreen = false;
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

        if (isUnaryOrPercentPressed) {
            equation.setText(EMPTY_STRING);
        }

        if (isEqualsPressed || isUnaryOrPercentPressed) {
            isFirstSet = false;
        }

        setFlags(true, false, false,
                false, isFirstSet, false);
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

        if (isUnaryOrPercentPressed) {
            equation.setText(EMPTY_STRING);
        }

        if (isEqualsPressed || isUnaryOrPercentPressed) {
            isFirstSet = false;
        }

        setFlags(true, false, false,
                false, isFirstSet, false);
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
                false, isFirstSet, false);
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
     * @todo bug
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
     * Moves {@code Text} in equation {@code Label} to the right or left.
     *
     * @param clickedButton  right or left arrow {@code Button} that should move {@code Text} to the specific side.
     * @param oppositeButton left or right{@code Button} that should move {@code Text} to the opposite of clicked
     *                       {@code Button} side.
     * @param moveLeft       true if moving left or false if moving right.
     */
    private void moveTextInEquationLabel(Button clickedButton, Button oppositeButton, boolean moveLeft) {
        oppositeButton.setVisible(true);

        Text text = new Text(equation.getText());
        text.setFont(equation.getFont());

        double newHValue = equationScroll.getHvalue();

        if (text.getBoundsInLocal().getWidth() > clickedButton.getScene().getWidth() * MULTIPLICAND_FOR_TEXT_WIDTH) {
            double offset = NumberUtils.toScaledBigDecimal(clickedButton.getScene().getWidth() /
                    text.getBoundsInLocal().getWidth(), MOVE_LABEL_SCALE, RoundingMode.HALF_UP).doubleValue();

            if (moveLeft) {
                newHValue += offset;
            } else {
                newHValue -= offset;
            }

        } else {

            if (moveLeft) {
                newHValue = equationScroll.getHmax();
            } else {
                newHValue = equationScroll.getHmin();
            }

        }

        equationScroll.setHvalue(newHValue);

        if ((moveLeft && equationScroll.getHvalue() == equationScroll.getHmax()) ||
                (!moveLeft && equationScroll.getHvalue() == equationScroll.getHmin())) {
            clickedButton.setVisible(false);
        }
    }

    /**
     * Creates memory {@code Label} for each {@link Memory} cell.
     */
    private void updateMemoryLabels() {
        Stack<BigDecimal> store = memory.getStore();

        if (!store.isEmpty()) {
            memoryPanel.getChildren().removeAll(memoryPanel.getChildren());

            double layoutY = MEMORY_LABELS_LAYOUT;

            for (int i = 0; i < store.size(); i++) {
                Label label = new Label();
                label.setText(store.elementAt(store.size() - i - 1).toString());
                configureMemoryLabel(label, layoutY);

                memoryPanel.getChildren().add(label);
                layoutY += MEMORY_LABELS_HEIGHT + MEMORY_LABELS_LAYOUT;
            }
        }
    }

    /**
     * Sets configuration such as size, layout and style for memory {@code Label}.
     *
     * @param label   {@code Label} to edit.
     * @param layoutY coordinate Y for the {@code Label}.
     */
    private void configureMemoryLabel(Label label, double layoutY) {
        label.setPrefWidth(memoryPanel.getWidth());
        label.setPrefHeight(MEMORY_LABELS_HEIGHT);
        label.setMinHeight(label.getPrefHeight());
        label.setMaxHeight(label.getPrefHeight());
        label.setPadding(MEMORY_LABELS_INSETS);
        label.setLayoutY(layoutY);
        label.setStyle(setStyleForLabels());
        label.setWrapText(true);
        label.setOnMouseMoved(event -> label.setStyle(setStyleForLabelsOnHover()));
        label.setOnMouseExited(event -> label.setStyle(setStyleForLabels()));
        label.setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Sets style for memory {@code Label}.
     *
     * @return style (as css representation).
     */
    private static String setStyleForLabels() {
        return "-fx-background-color: transparent;" +
                "-fx-font-size: " + MEMORY_LABELS_FONT_SIZE + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }

    /**
     * Sets style for memory {@code Label} on hover.
     *
     * @return style (as css representation).
     */
    private static String setStyleForLabelsOnHover() {
        return "-fx-background-color: #e7e7e7;" +
                "-fx-font-size: " + MEMORY_LABELS_FONT_SIZE + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
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
        String equationTextToSet = EMPTY_STRING;

        try {
            BigDecimal number = screenToBigDecimal(screen.getText());

            if (!isFirstSet) {
                equationTextToSet = formatWithoutGroupSeparator(number) + NARROW_SPACE + operation.symbol;

                setBinaryAndFirst(operation, number);

            } else if (!isEqualsPressed && !isUnaryOrPercentPressed) {
                equationTextToSet = equation.getText() + NARROW_SPACE + formatWithoutGroupSeparator(number) +
                        NARROW_SPACE + operation.symbol;

                calculateBinaryAndSetNewBinary(operation, number);

            } else {

                if (isEqualsPressed) {
                    equationTextToSet = binaryAfterEquals(operation, calculation.getResult());
                } else {
                    equationTextToSet = equation.getText() + NARROW_SPACE + operation.symbol;
                }

                if (isUnaryOrPercentPressed) {
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
     *
     * @param operation {@code BinaryOperation} to set.
     * @param number    {@code BigDecimal} number to set as first.
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
     *
     * @param operation {@code BinaryOperation} to set.
     */
    private void binaryAfterBinary(BinaryOperation operation) {
        calculation.setBinaryOperation(operation);
        equation.setText(StringUtils.chop(equation.getText()) + operation.symbol);

        setFlags(false, true, false,
                false, true, false);
    }

    /**
     * Called when any {@code UnaryOperation} {@code Button} is pressed.
     * <p>
     * If number in screen {@code Label} ends with {@code DECIMAL_SEPARATOR}, removes it.
     * <p>
     * If first number is not set, sets number in screen {@code Label} as first and performs the {@code UnaryOperation}.
     * Also, sets operation's symbol and number in screen {@code Label} (wrapped in brackets) to equation {@code Label}.
     * <p>
     * If unary or percentage operation was just performed, sets result from {@code Calculation} as first and performs
     * the {@code UnaryOperation}. Also, wraps last {@code UnaryOperation} representation in equation {@code Label} into
     * new operation's symbol and brackets.
     * <p>
     * Otherwise, performs the operation with number in screen {@code Label} and appends operation's symbol and number
     * in screen {@code Label} (wrapped in brackets) to equation {@code Label}.
     * <p>
     * If any exception was thrown during calculating, it's message will be shown in screen {@code Label}.
     *
     * @param operation {@link UnaryOperation} that should be performed.
     */
    private void unaryOperationPressed(UnaryOperation operation) {
        removeLastDecimalSeparator();
        String equationTextToSet = EMPTY_STRING;

        try {
            BigDecimal number = screenToBigDecimal(screen.getText());

            if (!isFirstSet) {
                equationTextToSet = operation.symbol + OPENING_BRACKET + NARROW_SPACE +
                        formatWithoutGroupSeparator(number) + NARROW_SPACE + CLOSING_BRACKET;

                setFirstAndCalculateUnary(operation, number);

            } else if (isUnaryOrPercentPressed) {
                equationTextToSet = setEquationAfterSeveralUnaryOrPercentage(operation);

                severalUnaryInARow(operation);

            } else {
                equationTextToSet = setEquationAfterUnary(operation, number);

                calculateUnaryFirstIsSet(operation, number);
            }

            setFlags(false, false, true,
                    false, true, false);
        } catch (Exception e) {
            exceptionThrown(e.getMessage());
        } finally {
            equation.setText(equationTextToSet);
        }
    }

    /**
     * Sets first number, performs {@code UnaryOperation} and sets result of it as first number. Also shows result in
     * screen {@code Label}.
     *
     * @param operation {@code UnaryOperation} to perform.
     * @param first     {@code BigDecimal} number to set as first.
     */
    private void setFirstAndCalculateUnary(UnaryOperation operation, BigDecimal first) {
        calculation.setFirst(first);
        calculation.calculateUnary(operation);
        calculation.setFirst(calculation.getResult());
        screen.setText(formatNumber(calculation.getResult()));
    }

    /**
     * Calculates result of {@code UnaryOperation} after several {@code UnaryOperation} in a row.
     *
     * Sets first number as second (for saving it), sets result of previous calculating as first number, calculates
     * {@code UnaryOperation}, then sets saved first number (in second) as first, sets result as second and shows result
     * in screen {@code Label}.
     *
     * @param operation {@code UnaryOperation} to perform.
     */
    private void severalUnaryInARow(UnaryOperation operation) {
        calculation.setSecond(calculation.getFirst());
        calculation.setFirst(calculation.getResult());
        calculation.calculateUnary(operation);
        calculation.setFirst(calculation.getSecond());
        calculation.setSecond(calculation.getResult());
        screen.setText(formatNumber(calculation.getResult()));
    }

    /**
     * Updates text set in equation {@code Label} after several unary or percentage operations in a row (but the last
     * one is percentage) and returns it.
     * <p>
     * First of all, looks for the last {@code BinaryOperation} symbol in equation {@code Label}. If it was found,
     * separates text in equation {@code Label} into two parts: text before the last {@code BinaryOperation} symbol
     * (including it) and text after. Then wraps "text after" into brackets and operation's symbol, and appends received
     * string to "text after".
     * <p>
     * If equation {@code Label} does not contain any {@code BinaryOperation} symbol, wraps text in equation
     * {@code Label} into brackets and operation's symbol.
     *
     * @param operation {@code UnaryOperation} that was performed.
     * @return string that was received after operations described below.
     */
    private String setEquationAfterSeveralUnaryOrPercentage(UnaryOperation operation) {
        String equationTextToSet = equation.getText();

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
                    Math.max(lastIndexOfMultiply, lastIndexOfDivide)) + 1;

            textBefore = equationTextToSet.substring(0, lastIndexOfOperation);
            textAfter = equationTextToSet.substring(lastIndexOfOperation + 1);
        }

        if (textBefore.equals(EMPTY_STRING)) {
            equationTextToSet = operation.symbol + OPENING_BRACKET + NARROW_SPACE + textAfter + NARROW_SPACE +
                    CLOSING_BRACKET;
        } else {
            equationTextToSet = textBefore + NARROW_SPACE + operation.symbol + OPENING_BRACKET + NARROW_SPACE +
                    textAfter + NARROW_SPACE + CLOSING_BRACKET;
        }

        return equationTextToSet;
    }

    /**
     * Updates text set in equation {@code Label} after {@code UnaryOperation} performed and returns it.
     * <p>
     * Appends operation's symbol with wrapped into brackets number to current text in equation {@code Label}.
     *
     * @param operation {@code UnaryOperation} that was performed.
     * @param number    {@code BigDecimal} number to wrap into brackets.
     * @return string that was received after operations described below.
     */
    private String setEquationAfterUnary(UnaryOperation operation, BigDecimal number) {
        String equationTextToSet;

        if (equation.getText().equals(EMPTY_STRING)) {
            equationTextToSet = operation.symbol + OPENING_BRACKET + NARROW_SPACE +
                    formatWithoutGroupSeparator(number) + NARROW_SPACE + CLOSING_BRACKET;
        } else {
            equationTextToSet = equation.getText() + NARROW_SPACE + operation.symbol + OPENING_BRACKET +
                    NARROW_SPACE + formatWithoutGroupSeparator(number) + NARROW_SPACE + CLOSING_BRACKET;
        }

        return equationTextToSet;
    }

    /**
     * Performs {@code UnaryOperation} while first number is set.
     * <p>
     * Sets current first number as second number (for not loosing it), sets number with which the operation should be
     * performed as first number and performs {@code UnaryOperation}.
     * <p>
     * If equals was just pressed before the operation, set received result as first number, otherwise sets second
     * number as first number and received result as second number.
     *
     * @param operation {@code UnaryOperation} to perform.
     * @param number    {@code BigDecimal} number with which the operation should be performed.
     */
    private void calculateUnaryFirstIsSet(UnaryOperation operation, BigDecimal number) {
        calculation.setSecond(calculation.getFirst());
        calculation.setFirst(number);
        calculation.calculateUnary(operation);

        if (isEqualsPressed) {
            calculation.setFirst(calculation.getResult());
        } else {
            calculation.setFirst(calculation.getSecond());
            calculation.setSecond(calculation.getResult());
        }

        screen.setText(formatNumber(calculation.getResult()));
    }

    /**
     * Called when percentage {@code Buttons} is pressed.
     * <p>
     * If number in screen {@code Label} ends with {@code DECIMAL_SEPARATOR}, removes it.
     * <p>
     * Calculation is possible if only binary operation is set. Otherwise, shows {@code ZERO} in screen and equation
     * {@code Label}.
     * <p>
     * Sets number from screen {@code Label} as second number and performs calculate percentage operation from
     * {@link Calculation}. Then sets received result as second number and shows it in screen {@code Label}.
     * <p>
     * Also appends result to equation {@code Label}.
     * <p>
     * If any exception was thrown during calculating, it's message will be shown in screen {@code Label}.
     */
    private void calculatePercentage() {
        removeLastDecimalSeparator();

        if (calculation.getBinaryOperation() == null) {
            percentageWithoutBinary();
        } else {
            String equationTextToSet = equation.getText();

            try {
                percentageWithBinary();

                if (isUnaryOrPercentPressed) {
                    equationTextToSet = equationTextToSetAfterSeveralPercentage(equationTextToSet);
                } else {
                    equationTextToSet += NARROW_SPACE + formatWithoutGroupSeparator(calculation.getResult());
                }

                setFlags(false, false, true,
                        false, true, false);
            } catch (Exception e) {
                exceptionThrown(e.getMessage());
            } finally {
                equation.setText(equationTextToSet);
            }
        }
    }

    /**
     * Shows {@code ZERO} in screen and equation {@code Label} and updates flags.
     */
    private void percentageWithoutBinary() {
        screen.setText(ZERO);
        equation.setText(ZERO);

        setFlags(false, false, true,
                false, true, false);
    }

    /**
     * Sets number in screen {@code Label} as second number and performs calculate percentage operation from
     * {@link Calculation}. Then sets received result as second nu,ber and shows it in screen {@code Label}.
     */
    private void percentageWithBinary() {
        BigDecimal number = screenToBigDecimal(screen.getText());
        calculation.setSecond(number);
        calculation.calculatePercentage();
        calculation.setSecond(calculation.getResult());
        screen.setText(formatNumber(calculation.getResult()));
    }

    /**
     * Updates text set in equation {@code Label} after several unary or percentage operations in a row (but the last
     * one is percentage) and returns it.
     * <p>
     * Looks for the last {@code BinaryOperation} symbol in equation {@code Label} and appends to text before the last
     * symbol result of calculation.
     *
     * @param equationTextToSet text to update.
     * @return updated text.
     */
    private String equationTextToSetAfterSeveralPercentage(String equationTextToSet) {
        String textBefore;

        int lastIndexOfAdd = equationTextToSet.lastIndexOf(BinaryOperation.ADD.symbol);

        if (lastIndexOfAdd != -1 && equationTextToSet.charAt(lastIndexOfAdd - 1) == 'e') {
            lastIndexOfAdd = equationTextToSet.substring(0, lastIndexOfAdd - 1).lastIndexOf(BinaryOperation.ADD.symbol);
        }

        int lastIndexOfSubtract = equationTextToSet.lastIndexOf(BinaryOperation.SUBTRACT.symbol);

        if (lastIndexOfSubtract != -1 && equationTextToSet.charAt(lastIndexOfSubtract - 1) == 'e') {
            lastIndexOfSubtract = equationTextToSet.substring(0, lastIndexOfSubtract - 1).lastIndexOf(
                    BinaryOperation.SUBTRACT.symbol);
        }

        int lastIndexOfMultiply = equationTextToSet.lastIndexOf(BinaryOperation.MULTIPLY.symbol);
        int lastIndexOfDivide = equationTextToSet.lastIndexOf(BinaryOperation.SUBTRACT.symbol);
        int lastIndexOfOperation = Math.max(Math.max(lastIndexOfAdd, lastIndexOfSubtract),
                Math.max(lastIndexOfMultiply, lastIndexOfDivide));

        textBefore = equationTextToSet.substring(0, lastIndexOfOperation + 1);

        return textBefore + NARROW_SPACE + formatWithoutGroupSeparator(calculation.getResult());
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
            boolean isBinarySet = calculation.getBinaryOperation() != null;

            if (isBinarySet) {
                calculateResultForBinaryNotNull();
            }

            equation.setText(EMPTY_STRING);

            setFlags(false, false, false,
                    true, isBinarySet, false);
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

        if (!isEqualsPressed && !isUnaryOrPercentPressed) {
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
        if (!isFirstSet) {
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
     * Performs reset all operation in {@link Calculation} and sets message to screen {@code Label}.
     * Also disables mostly all {@code Button}.
     *
     * @param message message of exception to set as screen {@code Label} text.
     */
    private void exceptionThrown(String message) {
        calculation.resetAll();
        screen.setText(message);

        Button[] buttonsToDisable = {
                memoryClear, memoryRecall, memoryAdd, memorySubtract, memoryStore,
                percent, sqrt, sqr, inverse, divide, multiply, subtract, add, negate, dot
        };

        setButtonsDisability(true, buttonsToDisable);

        setFlags(false, false, false,
                false, false, true);
    }

    /**
     * Returns to normal state after any exception was thrown.
     * <p>
     * Sets text in screen and equation {@code Label} to default. Enables all disabled {@code Button} (but memory
     * {@code Button} such as {@code memoryClear}, {@code memoryRecall}, {@code memoryShow} enabled only if there is
     * anything stored in memory).
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

            setButtonsDisability(false, buttonsToEnable);
            setButtonsDisability(memory.getStore().isEmpty(), memoryStandardDisabledButtons);
        }
    }

    /**
     * Removes last char in screen {@code Label} if it is a {@code DECIMAL_SEPARATOR}.
     */
    private void removeLastDecimalSeparator() {
        if (screen.getText().endsWith(String.valueOf(DECIMAL_SEPARATOR))) {
            screen.setText(StringUtils.chop(screen.getText()));
        }
    }

    /**
     * Sets flags for boolean fields of controller.
     *
     * @param isEditableScreen                 true if digit should be appended to screen number.
     * @param isBinaryOperationPressed         true if binary operation was just pressed.
     * @param isUnaryOrPercentOperationPressed true if unary operation was just pressed.
     * @param isEqualsPressed                  true if equals was just pressed.
     * @param isFirstSet                       true if first operand for model is set.
     * @param isError                          true if is error was just happened.
     */
    private void setFlags(boolean isEditableScreen, boolean isBinaryOperationPressed,
                          boolean isUnaryOrPercentOperationPressed, boolean isEqualsPressed, boolean isFirstSet,
                          boolean isError) {
        this.isEditableScreen = isEditableScreen;
        this.isBinaryOperationPressed = isBinaryOperationPressed;
        this.isUnaryOrPercentPressed = isUnaryOrPercentOperationPressed;
        this.isEqualsPressed = isEqualsPressed;
        this.isFirstSet = isFirstSet;
        this.isError = isError;
    }

    /**
     * Disables or enables several {@code Button}, passed as args.
     *
     * @param flag    true for disabling and false for enabling.
     * @param buttons several {@code Button} that should change their disability.
     */
    private static void setButtonsDisability(boolean flag, Button... buttons) {
        for (Button button : buttons) {
            button.setDisable(flag);
        }
    }
}
