package com.implemica.bormashenko.calculator.view.listeners;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * Listener for resizing font in result label.
 *
 * @author Mykhailo Bormashenko
 */
public class DigitsResizeListener implements InvalidationListener {

    /**
     * Size of font used as big.
     */
    private static final int BIG_FONT = 47;

    /**
     * Size of font used as medium.
     */
    private static final int MEDIUM_FONT = 35;

    /**
     * Size of font used as small.
     */
    private static final int SMALL_FONT = 21;

    /**
     * Number of symbols in label from which the big font is used.
     */
    private static final int BIG_FONT_COUNT = 11;

    /**
     * Number of symbols in label from which the medium font is used.
     */
    private static final int MEDIUM_FONT_COUNT = 15;

    /**
     * ID of label in which the result of operations is shown.
     */
    private static final String RESULT_LABEL_ID = "#result";

    /**
     * JavaFX scene.
     */
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
            font = BIG_FONT;
        } else if (length < MEDIUM_FONT_COUNT) {
            font = MEDIUM_FONT;
        } else {
            font = SMALL_FONT;
        }

        field.setStyle(getFontString(font));
    }

    /**
     * Stylesheet representation of font size.
     * @param size size of font to set in px.
     * @return string for setting size of font in stylesheets.
     */
    private String getFontString(int size) {
        return "-fx-font-size: " + size + "px;";
    }
}