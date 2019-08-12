package com.implemica.bormashenko.calculator.view.listeners;

import com.implemica.bormashenko.calculator.view.View;
import com.implemica.bormashenko.calculator.view.util.SerializationView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Listener for saving view fields such as size and location.
 * Added to close action.
 *
 * @author Mykhailo Bormashenko
 */
public class SaveViewListener implements EventHandler<WindowEvent>{

    /**
     * View of application.
     */
    private View view;

    /**
     * Constructor for listener.
     *
     * @param view view to save.
     */
    public SaveViewListener(View view) {
        this.view = view;
    }

    @Override
    public void handle(WindowEvent event) {
        SerializationView.saveView(view);
    }
}
