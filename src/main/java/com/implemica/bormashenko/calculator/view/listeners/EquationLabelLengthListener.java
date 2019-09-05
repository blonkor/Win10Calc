package com.implemica.bormashenko.calculator.view.listeners;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * This listener turns on buttons for moving text in equation label.
 *
 * @author Mykhailo Bormashenko
 * @todo refactoring
 */
public class EquationLabelLengthListener implements InvalidationListener {

    /**
     * ID of equation label.
     */
    private static final String EQUATION_LABEL_ID = "#equation";

    /**
     * ID of button that allows to move text left.
     */
    private static final String LEFT_ARROW_ID = "#leftArrow";

    /**
     * ID of button that allows to move text right.
     */
    private static final String RIGHT_ARROW_ID = "#rightArrow";

    /**
     * If width of text more than scene's width minus this value, left arrow button should appear.
     */
    private static final double WIDTH_DIFF_TO_SHOW = 50;

    /**
     * JavaFX scene.
     */
    private Scene scene;

    /**
     * Constructor for listener.
     *
     * @param scene JavaFX scene.
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
        double width = text.getBoundsInLocal().getWidth();

        //check condition for appearing or disappearing buttons
        double widthToShowLeftArrow = scene.getWidth() - WIDTH_DIFF_TO_SHOW;
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
