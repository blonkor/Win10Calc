package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**
 * Listener for keyboard codes and combinations.
 *
 * @author Mykhailo Bormashenko
 */
public class KeyboardListener implements EventHandler<KeyEvent> {

    /**
     * ID of 0 button.
     */
    private static final String ZERO_ID = "#zero";

    /**
     * ID of 1 button.
     */
    private static final String ONE_ID = "#one";

    /**
     * ID of 2 button.
     */
    private static final String TWO_ID = "#two";

    /**
     * ID of 3 button.
     */
    private static final String THREE_ID = "#three";

    /**
     * ID of 4 button.
     */
    private static final String FOUR_ID = "#four";

    /**
     * ID of 5 button.
     */
    private static final String FIVE_ID = "#five";

    /**
     * ID of 6 button.
     */
    private static final String SIX_ID = "#six";

    /**
     * ID of 7 button.
     */
    private static final String SEVEN_ID = "#seven";

    /**
     * ID of 8 button.
     */
    private static final String EIGHT_ID = "#eight";

    /**
     * ID of 9 button.
     */
    private static final String NINE_ID = "#nine";

    /**
     * ID of dot button.
     */
    private static final String DOT_ID = "#dot";

    /**
     * ID of backspace button.
     */
    private static final String BACKSPACE_ID = "#backspace";

    /**
     * ID of add button.
     */
    private static final String ADD_ID = "#add";

    /**
     * ID of subtract button.
     */
    private static final String SUBTRACT_ID = "#subtract";

    /**
     * ID of multiply button.
     */
    private static final String MULTIPLY_ID = "#multiply";

    /**
     * ID of divide button.
     */
    private static final String DIVIDE_ID = "#divide";

    /**
     * ID of equals button.
     */
    private static final String EQUALS_ID = "#equals";

    /**
     * ID of percent button.
     */
    private static final String PERCENT_ID = "#percent";

    /**
     * ID of negate button.
     */
    private static final String NEGATE_ID = "#negate";

    /**
     * ID of inverse button.
     */
    private static final String INVERSE_ID = "#inverse";

    /**
     * ID of sqrt button.
     */
    private static final String SQUARE_ROOT_ID = "#sqrt";

    /**
     * ID of clear text button.
     */
    private static final String CLEAR_TEXT_ID = "#clearText";

    /**
     * ID of clear all button.
     */
    private static final String CLEAR_ALL_ID = "#clearAll";

    /**
     * ID of memory clear button.
     */
    private static final String MEMORY_CLEAR_ID = "#memoryClear";

    /**
     * ID of memory recall button.
     */
    private static final String MEMORY_RECALL_ID = "#memoryRecall";

    /**
     * ID of memory add button.
     */
    private static final String MEMORY_ADD_ID = "#memoryAdd";

    /**
     * ID of memory subtract button.
     */
    private static final String MEMORY_SUBTRACT_ID = "#memorySubtract";

    /**
     * ID of memory store button.
     */
    private static final String MEMORY_STORE_ID = "#memoryStore";

    /**
     * Ctrl + M combination on keypad.
     */
    private static final KeyCombination CTRL_M = new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN);

    /**
     * Ctrl + P combination on keypad.
     */
    private static final KeyCombination CTRL_P = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);

    /**
     * Ctrl + Q combination on keypad.
     */
    private static final KeyCombination CTRL_Q = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN);

    /**
     * Ctrl + R combination on keypad.
     */
    private static final KeyCombination CTRL_R = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);

    /**
     * Ctrl + L combination on keypad.
     */
    private static final KeyCombination CTRL_L = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);

    /**
     * Shift + 2 (@) combination on keypad.
     */
    private static final KeyCombination SHIFT_TWO = new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.SHIFT_DOWN);

    /**
     * Shift + 5 (%) combination on keypad.
     */
    private static final KeyCombination SHIFT_FIVE = new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.SHIFT_DOWN);

    /**
     * Shift + 8 (*) combination on keypad.
     */
    private static final KeyCombination SHIFT_EIGHT = new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.SHIFT_DOWN);

    /**
     * Shift + = (+) combination on keypad.
     */
    private static final KeyCombination SHIFT_EQUALS = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.SHIFT_DOWN);

    /**
     * JavaFX scene.
     */
    private Scene scene;

    /**
     * Constructor for listener.
     *
     * @param scene JavaFX scene.
     */
    public KeyboardListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        String selector = "";

        //combinations with ctrl
        if (event.isControlDown()) {

            if (CTRL_M.match(event)) {
                selector = MEMORY_STORE_ID;
            } else if (CTRL_P.match(event)) {
                selector = MEMORY_ADD_ID;
            } else if (CTRL_Q.match(event)) {
                selector = MEMORY_SUBTRACT_ID;
            } else if (CTRL_R.match(event)) {
                selector = MEMORY_RECALL_ID;
            } else if (CTRL_L.match(event)) {
                selector = MEMORY_CLEAR_ID;
            }

            //combinations with shift
        } else if (event.isShiftDown()) {

            if (SHIFT_TWO.match(event)) {
                selector = SQUARE_ROOT_ID;
            } else if (SHIFT_FIVE.match(event)) {
                selector = PERCENT_ID;
            } else if (SHIFT_EIGHT.match(event)) {
                selector = MULTIPLY_ID;
            } else if (SHIFT_EQUALS.match(event)) {
                selector = ADD_ID;
            }

            //digit symbols
        } else if (keyCode.isDigitKey()) {

            if (keyCode == KeyCode.DIGIT0 || keyCode == KeyCode.NUMPAD0) {
                selector = ZERO_ID;
            } else if (keyCode == KeyCode.DIGIT1 || keyCode == KeyCode.NUMPAD1) {
                selector = ONE_ID;
            } else if (keyCode == KeyCode.DIGIT2 || keyCode == KeyCode.NUMPAD2) {
                selector = TWO_ID;
            } else if (keyCode == KeyCode.DIGIT3 || keyCode == KeyCode.NUMPAD3) {
                selector = THREE_ID;
            } else if (keyCode == KeyCode.DIGIT4 || keyCode == KeyCode.NUMPAD4) {
                selector = FOUR_ID;
            } else if (keyCode == KeyCode.DIGIT5 || keyCode == KeyCode.NUMPAD5) {
                selector = FIVE_ID;
            } else if (keyCode == KeyCode.DIGIT6 || keyCode == KeyCode.NUMPAD6) {
                selector = SIX_ID;
            } else if (keyCode == KeyCode.DIGIT7 || keyCode == KeyCode.NUMPAD7) {
                selector = SEVEN_ID;
            } else if (keyCode == KeyCode.DIGIT8 || keyCode == KeyCode.NUMPAD8) {
                selector = EIGHT_ID;
            } else if (keyCode == KeyCode.DIGIT9 || keyCode == KeyCode.NUMPAD9) {
                selector = NINE_ID;
            }

            //letter symbols
        } else if (keyCode.isLetterKey()) {

            if (keyCode == KeyCode.R) {
                selector = INVERSE_ID;
            }

            //f symbols
        } else if (keyCode.isFunctionKey()) {

            if (keyCode == KeyCode.F9) {
                selector = NEGATE_ID;
            }

            //any else symbols
        } else {

            if (keyCode == KeyCode.PERIOD) {
                selector = DOT_ID;
            } else if (keyCode == KeyCode.BACK_SPACE) {
                selector = BACKSPACE_ID;
            } else if (keyCode == KeyCode.PLUS || keyCode == KeyCode.ADD) {
                selector = ADD_ID;
            } else if (keyCode == KeyCode.MINUS || keyCode == KeyCode.SUBTRACT) {
                selector = SUBTRACT_ID;
            } else if (keyCode == KeyCode.MULTIPLY || keyCode == KeyCode.STAR) {
                selector = MULTIPLY_ID;
            } else if (keyCode == KeyCode.DIVIDE || keyCode == KeyCode.SLASH) {
                selector = DIVIDE_ID;
            } else if (keyCode == KeyCode.EQUALS || keyCode == KeyCode.ENTER) {
                selector = EQUALS_ID;
            } else if (keyCode == KeyCode.AT) {
                selector = SQUARE_ROOT_ID;
            } else if (keyCode == KeyCode.DELETE) {
                selector = CLEAR_TEXT_ID;
            } else if (keyCode == KeyCode.ESCAPE) {
                selector = CLEAR_ALL_ID;
            }

        }

        if (!selector.isEmpty()) {
            Button button = (Button) scene.lookup(selector);
            button.fire();
        }
    }
}
