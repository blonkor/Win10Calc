package com.implemica.bormashenko.calculator.view.listeners;

import com.implemica.bormashenko.calculator.view.View;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Listener for moving an application.
 *
 * @author Mykhailo Bormashenko
 */
public class MoveListener implements EventHandler<MouseEvent> {

    /**
     * X value of current position.
     */
    private double currentX;

    /**
     * Y value of current position.
     */
    private double currentY;

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
     * @param view  View of application.
     */
    public MoveListener(Stage stage, View view) {
        this.stage = stage;
        this.view = view;
    }

    @Override
    public void handle(MouseEvent event) {
        EventType type = event.getEventType();

        if (type.equals(MouseEvent.MOUSE_PRESSED)) {
            currentX = stage.getX() - event.getScreenX();
            currentY = stage.getY() - event.getScreenY();
        } else if (type.equals(MouseEvent.MOUSE_DRAGGED)) {
            stage.setX(event.getScreenX() + currentX);
            stage.setY(event.getScreenY() + currentY);
        }

        view.setLocationX(stage.getX());
        view.setLocationY(stage.getY());
    }
}