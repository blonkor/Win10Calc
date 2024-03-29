package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Listener for exit from an application.
 *
 * @author Mykhailo Bormashenko
 */
public class ExitListener implements EventHandler<ActionEvent> {

    /**
     * JavaFX {@code Stage}.
     */
    private Stage stage;

    /**
     * Constructor for listener.
     *
     * @param stage JavaFX {@code Stage}.
     */
    public ExitListener(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.close();
    }
}