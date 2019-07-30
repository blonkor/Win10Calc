package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Listener for maximizing application.
 *
 * @author Mykhailo Bormashenko
 */
public class ExpandListener implements EventHandler<ActionEvent> {

    /**
     * JavaFX stage.
     */
    private Stage stage;

    public ExpandListener(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        boolean isMaximized = !stage.isMaximized();
        stage.setMaximized(isMaximized);
    }
}
