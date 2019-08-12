package com.implemica.bormashenko.calculator.view.listeners;

import com.implemica.bormashenko.calculator.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Listener for maximizing application.
 * Added to expand button.
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
     * Text shown in tooltip while application is minimized.
     */
    private static final String MINIMIZED_TOOLTIP_TEXT = "Maximize";

    /**
     * Unicode escape sequence for symbol "ChromeRestore" in "Segoe MDL2 Assets" font representation.
     */
    private static final String MAXIMIZED_ICON = "\uE923";

    /**
     * Text shown in tooltip while application is maximized.
     */
    private static final String MAXIMIZED_TOOLTIP_TEXT = "Restore down";

    /**
     * JavaFX scene.
     */
    private Scene scene;

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
     * @param scene JavaFX scene.
     * @param stage JavaFX stage.
     * @param view  View of application.
     */
    public ExpandListener(Scene scene, Stage stage, View view) {
        this.scene = scene;
        this.stage = stage;
        this.view = view;
    }

    @Override
    public void handle(ActionEvent event) {
        boolean isMaximized = stage.isMaximized();
        double currentWidth = scene.getWidth();
        stage.setMaximized(!isMaximized);
        view.setMaximized(!isMaximized);
        double newWidth = scene.getWidth();

        if (currentWidth == newWidth) {
            view.resetToDefault(stage, scene);
        }

        Button expand = (Button) scene.lookup(EXPAND_ID);

        if (!isMaximized) {
            expand.setText(MAXIMIZED_ICON);
            expand.getTooltip().setText(MAXIMIZED_TOOLTIP_TEXT);
        } else {
            expand.setText(MINIMIZED_ICON);
            expand.getTooltip().setText(MINIMIZED_TOOLTIP_TEXT);
        }
    }
}
