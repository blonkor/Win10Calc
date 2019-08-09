package com.implemica.bormashenko.calculator.view.listeners;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Listener for resizing font in result label.
 *
 * @author Mykhailo Bormashenko
 */
public class FontResizeListener implements InvalidationListener {

    /**
     * Size of font used as big.
     */
    private static final int MAX_FONT_SIZE = 47;

    /**
     * Size of font used as small.
     */
    private static final int MIN_FONT_SIZE = 29;

    /**
     * If width of text more than scene's width minus this value, font size should be reduced.
     */
    private static final int WIDTH_DIFF_TO_REDUCE = 35;

    /**
     * If width of text less than scene's width minus this value, font size should be increased.
     */
    private static final int WIDTH_DIFF_TO_INCREASE = 50;

    /**
     * ID of label in which the result of operations is shown.
     */
    private static final String RESULT_LABEL_ID = "#screen";

    /**
     * JavaFX scene.
     */
    private Scene scene;

    public FontResizeListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void invalidated(Observable observable) {
        Label label = (Label) scene.lookup(RESULT_LABEL_ID);

        Text text = new Text(label.getText());
        text.setFont(label.getFont());
        double width = text.getBoundsInLocal().getWidth();

        double fontSize = label.getFont().getSize();

        double widthToReduce = scene.getWidth() - WIDTH_DIFF_TO_REDUCE;
        while (width > widthToReduce) {
            text.setFont(new Font(fontSize--));
            width = text.getBoundsInLocal().getWidth();
        }

        double widthToIncrease = scene.getWidth() - WIDTH_DIFF_TO_INCREASE;
        while (width < widthToIncrease) {
            text.setFont(new Font(fontSize++));
            width = text.getBoundsInLocal().getWidth();
        }

        if (fontSize < MIN_FONT_SIZE) {
            fontSize = MIN_FONT_SIZE;
        }

        if (fontSize > MAX_FONT_SIZE) {
            fontSize = MAX_FONT_SIZE;
        }

        label.setStyle(getFontString(fontSize));
    }

    /**
     * Stylesheet representation of font size.
     *
     * @param size size of font to set in px.
     * @return string for setting size of font in stylesheets.
     */
    private String getFontString(double size) {
        return "-fx-font-size: " + size + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }
}