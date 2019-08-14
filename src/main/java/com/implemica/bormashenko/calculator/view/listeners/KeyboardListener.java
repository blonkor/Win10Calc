package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
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

    private static final String BACKSPACE_ID = "#backspace";

    private static final String ADD_ID = "#add";

    private static final String SUBTRACT_ID = "#subtract";

    private static final String MULTIPLY_ID = "#multiply";

    private static final String DIVIDE_ID = "#divide";

    private static final String EQUALS_ID = "#equals";

    private Scene scene;

    public KeyboardListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        String selector = "";

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

            } else if (keyCode.isFunctionKey()) {
                System.out.println(true);
            }

        } else {

            if (keyCode == KeyCode.BACK_SPACE) {
                selector = BACKSPACE_ID;
            } else if (keyCode == KeyCode.PLUS  || keyCode == KeyCode.ADD) {
                selector = ADD_ID;
            } else if (keyCode == KeyCode.MINUS || keyCode == KeyCode.SUBTRACT) {
                selector = SUBTRACT_ID;
            } else if (keyCode == KeyCode.MULTIPLY || keyCode == KeyCode.STAR) {
                selector = MULTIPLY_ID;
            } else if (keyCode == KeyCode.DIVIDE || keyCode == KeyCode.SLASH) {
                selector = DIVIDE_ID;
            } else if (keyCode == KeyCode.EQUALS || keyCode == KeyCode.ENTER) {
                selector = EQUALS_ID;
            }

        }

        if (!selector.isEmpty()) {
            Button button = (Button) scene.lookup(selector);
            button.fire();
        }
    }
}
