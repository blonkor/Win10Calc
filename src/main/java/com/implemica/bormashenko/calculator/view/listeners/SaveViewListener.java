package com.implemica.bormashenko.calculator.view.listeners;

import com.implemica.bormashenko.calculator.view.View;
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
public class SaveViewListener implements EventHandler<WindowEvent> {

    /**
     * View of application.
     */
    private View view;

    /**
     * Path to dat file.
     */
    private static final String FILE_PATH = "src/main/java/com/implemica/bormashenko/calculator/view/resources/dat/view.dat";

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
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
