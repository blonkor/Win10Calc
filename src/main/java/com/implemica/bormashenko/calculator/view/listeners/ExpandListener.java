package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Listener for maximizing application.
 *
 * @author Mykhailo Bormashenko
 */
public class ExpandListener implements EventHandler<ActionEvent> {

    /**
     * ID of expand button.
     */
    private static final String EXPAND_ID = "#expand";

    /**
     * JavaFX scene.
     */
    private Scene scene;

    /**
     * JavaFX stage.
     */
    private Stage stage;

    public ExpandListener(Scene scene, Stage stage) {
        this.scene = scene;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        boolean isMaximized = !stage.isMaximized();
        stage.setMaximized(isMaximized);
        Button expand = (Button)scene.lookup(EXPAND_ID);

        if (isMaximized) {
            expand.setText("\uE923");
            expand.getTooltip().setText("Restore down");
        } else {
            expand.setText("\uE922");
            expand.getTooltip().setText("Maximize");
        }
    }
}
