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
     * ID of expand {@code Button}.
     */
    private static final String EXPAND_ID = "#expand";

    /**
     * Unicode escape sequence for symbol "ChromeMaximize" in "Segoe MDL2 Assets" font.
     */
    private static final String MINIMIZED_ICON = "\uE922";

    /**
     * Unicode escape sequence for symbol "ChromeRestore" in "Segoe MDL2 Assets" font.
     */
    private static final String MAXIMIZED_ICON = "\uE923";

    /**
     * JavaFX {@code Scene}.
     */
    private Scene scene;

    /**
     * JavaFX {@code Stage}.
     */
    private Stage stage;

    /**
     * Constructor for listener.
     *
     * @param scene JavaFX {@code Scene}.
     * @param stage JavaFX {@code Stage}.
     */
    public ExpandListener(Scene scene, Stage stage) {
        this.scene = scene;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        boolean isMaximized = stage.isMaximized();
        stage.setMaximized(!isMaximized);

        //setup icons and tooltips
        Button expand = (Button) scene.lookup(EXPAND_ID);

        if (!isMaximized) {
            expand.setText(MAXIMIZED_ICON);
        } else {
            expand.setText(MINIMIZED_ICON);
        }
    }
}
