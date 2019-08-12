package com.implemica.bormashenko.calculator.view.listeners;

import com.implemica.bormashenko.calculator.view.View;
import com.implemica.bormashenko.calculator.view.util.SerializationView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Listener for exit from an application.
 * Added to close button.
 *
 * @author Mykhailo Bormashenko
 */
public class ExitListener implements EventHandler<ActionEvent> {

    /**
     * JavaFX stage.
     */
    private Stage stage;

    /**
     * View of application.
     */
    private View view;

    /**
     * Constructor for listener.
     *
     * @param stage JavaFX stage.
     * @param view View of application.
     */
    public ExitListener(Stage stage, View view) {
        this.stage = stage;
        this.view = view;
    }

    @Override
    public void handle(ActionEvent event) {
        SerializationView.saveView(view);
        stage.close();
    }
}