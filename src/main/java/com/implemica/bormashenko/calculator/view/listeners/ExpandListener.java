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
     * Unicode escape sequence for symbol "ChromeMaximize" in "Segoe MDL2 Assets" font representation.
     */
    private static final String MINIMIZED_ICON = "\uE922";

    /**
     * Unicode escape sequence for symbol "ChromeRestore" in "Segoe MDL2 Assets" font representation.
     */
    private static final String MAXIMIZED_ICON = "\uE923";

    /**
     * Text shown in tooltip while application is maximized.
     */
    private static final String MAXIMIZED_TOOLTIP_TEXT = "Restore down";

    /**
     * Text shown in tooltip while application is minimized.
     */
    private static final String MINIMIZED_TOOLTIP_TEXT = "Maximize";

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
            expand.setText(MAXIMIZED_ICON);
            expand.getTooltip().setText(MAXIMIZED_TOOLTIP_TEXT);
        } else {
            expand.setText(MINIMIZED_ICON);
            expand.getTooltip().setText(MINIMIZED_TOOLTIP_TEXT);
        }
    }
}
