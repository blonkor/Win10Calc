package com.implemica.bormashenko.calculator.view.listeners;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.Label;


public class DigitsResizeListener implements InvalidationListener {

    private static final int FONT_BIG = 47;

    private static final int FONT_MEDIUM = 35;

    private static final int FONT_SMALL = 21;

    private static final int BIG_FONT_COUNT = 11;

    private static final int MEDIUM_FONT_COUNT = 15;

    private static final String RESULT_LABEL_ID = "#result";

    private Scene scene;

    public DigitsResizeListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void invalidated(Observable observable) {
        Label field = (Label) scene.lookup(RESULT_LABEL_ID);
        int length = field.getText().length();
        int font;

        if (length < BIG_FONT_COUNT) {
            font = FONT_BIG;
        } else if (length < MEDIUM_FONT_COUNT) {
            font = FONT_MEDIUM;
        } else {
            font = FONT_SMALL;
        }

        field.setStyle(getFontString(font));
    }

    private String getFontString(int size) {
        return "-fx-font-size: " + size + "px;";
    }
}