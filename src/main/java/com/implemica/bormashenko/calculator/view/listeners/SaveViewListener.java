package com.implemica.bormashenko.calculator.view.listeners;

import com.implemica.bormashenko.calculator.view.View;
import com.implemica.bormashenko.calculator.view.util.SerializationView;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

/**
 * Listener for saving view fields such as size and location.
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
