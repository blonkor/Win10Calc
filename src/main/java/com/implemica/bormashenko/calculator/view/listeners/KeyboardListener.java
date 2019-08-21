package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

public class KeyboardListener implements EventHandler<KeyEvent> {

    private static final String ZERO_ID = "#zero";

    private static final String ONE_ID = "#one";

    private static final String TWO_ID = "#two";

    private static final String THREE_ID = "#three";

    private static final String FOUR_ID = "#four";

    private static final String FIVE_ID = "#five";

    private static final String SIX_ID = "#six";

    private static final String SEVEN_ID = "#seven";

    private static final String EIGHT_ID = "#eight";

    private static final String NINE_ID = "#nine";

    private static final String DOT_ID = "#dot";

    private static final String BACKSPACE_ID = "#backspace";

    private static final String ADD_ID = "#add";

    private static final String SUBTRACT_ID = "#subtract";

    private static final String MULTIPLY_ID = "#multiply";

    private static final String DIVIDE_ID = "#divide";

    private static final String EQUALS_ID = "#equals";

    private static final String PERCENT_ID = "#percent";

    private static final String NEGATE_ID = "#negate";

    private static final String INVERSE_ID = "#inverse";

    private static final String SQUARE_ROOT_ID = "#sqrt";

    private static final String CLEAR_TEXT_ID = "#clearText";

    private static final String CLEAR_ALL_ID = "#clearAll";

    private static final String MEMORY_CLEAR_ID = "#memoryClear";

    private static final String MEMORY_RECALL_ID = "#memoryRecall";

    private static final String MEMORY_ADD_ID = "#memoryAdd";

    private static final String MEMORY_SUBTRACT_ID = "#memorySubtract";

    private static final String MEMORY_STORE_ID = "#memoryStore";

    private static final KeyCombination CTRL_M = new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN);

    private static final KeyCombination CTRL_P = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);

    private static final KeyCombination CTRL_Q = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN);

    private static final KeyCombination CTRL_R = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);

    private static final KeyCombination CTRL_L = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);

    private static final KeyCombination SHIFT_TWO = new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.SHIFT_DOWN);

    private static final KeyCombination SHIFT_FIVE = new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.SHIFT_DOWN);

    private static final KeyCombination SHIFT_EIGHT = new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.SHIFT_DOWN);

    private static final KeyCombination SHIFT_EQUALS = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.SHIFT_DOWN);

    private Scene scene;

    public KeyboardListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        String selector = "";

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

        } else

            if (keyCode.isDigitKey()) {

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

        } else if (keyCode.isLetterKey()) {

            if (keyCode == KeyCode.R) {
                selector = INVERSE_ID;
            }

        } else if (keyCode.isFunctionKey()) {

            if (keyCode == KeyCode.F9) {
                selector = NEGATE_ID;
            }

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
