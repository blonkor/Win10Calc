package com.implemica.bormashenko.calculator.view.listeners;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * This listener sets visibility for arrow {@code Button}.
 * <p>
 * The visibility of the {@code Button} depends on {@code Label}'s and application's width.
 *
 * @author Mykhailo Bormashenko
 */
public class EquationLabelLengthListener implements InvalidationListener {

    /**
     * ID of equation {@code Label}.
     */
    private static final String EQUATION_LABEL_ID = "#equation";

    /**
     * ID of left arrow {@code Button}.
     */
    private static final String LEFT_ARROW_ID = "#leftArrow";

    /**
     * ID of right arrow {@code Button}.
     */
    private static final String RIGHT_ARROW_ID = "#rightArrow";

    /**
     * If width of text in {@code Label} more than applications's width minus this value, left arrow {@code Button}
     * should be visible.
     */
    private static final double WIDTH_DIFF_TO_SHOW = 50;

    /**
     * JavaFX {@code Scene}.
     */
    private Scene scene;

    /**
     * Constructor for listener.
     *
     * @param scene JavaFX {@code Scene}.
     */
    public EquationLabelLengthListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void invalidated(Observable observable) {
        Label label = (Label) scene.lookup(EQUATION_LABEL_ID);

        //get text width
        Text text = new Text(label.getText());
        text.setFont(label.getFont());
        int width = (int) text.getBoundsInLocal().getWidth();

        //check condition for appearing or disappearing buttons
        int widthToShowLeftArrow = (int) (scene.getWidth() - WIDTH_DIFF_TO_SHOW);
        Button leftArrow = (Button) scene.lookup(LEFT_ARROW_ID);
        Button rightArrow = (Button) scene.lookup(RIGHT_ARROW_ID);

        if (width > widthToShowLeftArrow) {
            leftArrow.setVisible(true);
        } else {
            leftArrow.setVisible(false);
            rightArrow.setVisible(false);
        }
    }
}
