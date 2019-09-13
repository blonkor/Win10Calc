package com.implemica.bormashenko.calculator.view.listeners;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Listener for resizing font in screen {@code Label}.
 *
 * @author Mykhailo Bormashenko
 */
public class FontResizeListener implements InvalidationListener {

    /**
     * Max size of font.
     */
    private static final int MAX_FONT_SIZE = 47;

    /**
     * If width of text in {@code Label} more than application's width minus this value, font size should be reduced.
     */
    private static final int WIDTH_DIFF_TO_REDUCE = 35;

    /**
     * If width of text in {@code Label} less than applications's width minus this value, font size should be increased.
     */
    private static final int WIDTH_DIFF_TO_INCREASE = 50;

    /**
     * ID of screen {@code Label}.
     */
    private static final String SCREEN_LABEL_ID = "#screen";

    /**
     * JavaFX {@code Scene}.
     */
    private Scene scene;

    /**
     * Constructor for listener.
     *
     * @param scene JavaFX {@code Scene}.
     */
    public FontResizeListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void invalidated(Observable observable) {
        setFontForButtons();

        Label label = (Label) scene.lookup(SCREEN_LABEL_ID);

        //get text width
        Text text = new Text(label.getText());
        text.setFont(label.getFont());
        int width = (int) text.getBoundsInLocal().getWidth();

        int fontSize = (int) label.getFont().getSize();

        //reduce font size
        int widthToReduce = (int) (scene.getWidth() - WIDTH_DIFF_TO_REDUCE);
        while (width > widthToReduce) {
            text.setFont(new Font(fontSize--));
            width = (int) text.getBoundsInLocal().getWidth();
        }

        //increase font size
        int widthToIncrease = (int) (scene.getWidth() - WIDTH_DIFF_TO_INCREASE);
        while (width < widthToIncrease) {
            text.setFont(new Font(fontSize++));
            width = (int) text.getBoundsInLocal().getWidth();
        }

        //fit font size
        if (fontSize > MAX_FONT_SIZE) {
            fontSize = MAX_FONT_SIZE;
        }

        if (scene.getHeight() >= 800) {
            fontSize = 72;
        }

        //set font size
        label.setStyle(getFontString(fontSize, "Segoe UI Semibold"));
    }


    private void setFontForButtons() {
        double operationFont = 14.5;
        double backspaceAndDotFont = 16.5;
        double degreeFont = 20;
        double digitsFont = 22.5;

        if (scene.getHeight() >= 750 && scene.getWidth() >= 400) {
            operationFont = 19.5;
            backspaceAndDotFont = 20.5;
            degreeFont++;
            digitsFont++;
        }

        Button[] operationButtonsAssets = new Button[]{
                (Button) scene.lookup("#percent"),
                (Button) scene.lookup("#sqrt"),
                (Button) scene.lookup("#divide"),
                (Button) scene.lookup("#multiply"),
                (Button) scene.lookup("#subtract"),
                (Button) scene.lookup("#add"),
                (Button) scene.lookup("#equals"),
                (Button) scene.lookup("#negate")
        };

        for (Button button : operationButtonsAssets) {
            button.setStyle(getFontString(operationFont, "Segoe MDL2 Assets"));
        }

        Button[] operationButtonsSegoeUI = new Button[]{
                (Button) scene.lookup("#clearText"),
                (Button) scene.lookup("#clearAll")
        };

        for (Button button : operationButtonsSegoeUI) {
            button.setStyle(getFontString(operationFont, "Segoe UI"));
        }

        scene.lookup("#backspace").setStyle(getFontString(backspaceAndDotFont,
                "Segoe MDL2 Assets"));
        scene.lookup("#dot").setStyle(getFontString(backspaceAndDotFont, "Segoe UI Black"));

        Button[] degreeButtons = new Button[] {
                (Button) scene.lookup("#sqr"),
                (Button) scene.lookup("#inverse")
        };



    }


    /**
     * Stylesheet representation of font size.
     *
     * @param size size of font to set in px.
     * @return string for setting size of font in stylesheets.
     */
    private String getFontString(double size, String fontFamily) {
        return "-fx-font-size: " + size + "px;" +
                "-fx-font-family: \"" + fontFamily + "\"";
    }
}