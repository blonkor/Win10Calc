package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Listener for minimizing an application.
 *
 * @author Mykhailo Bormashenko
 * @todo refactoring
 */
public class HideListener implements EventHandler<ActionEvent> {

    /**
     * JavaFX stage.
     */
    private Stage stage;

    /**
     * Constructor for listener.
     *
     * @param stage JavaFX stage.
     */
    public HideListener(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setIconified(true);
    }
}
