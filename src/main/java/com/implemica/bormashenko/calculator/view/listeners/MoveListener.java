package com.implemica.bormashenko.calculator.view.listeners;

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
     * X coordinate of current position.
     */
    private double currentX;

    /**
     * Y coordinate of current position.
     */
    private double currentY;

    /**
     * JavaFX {@code Stage}.
     */
    private Stage stage;

    /**
     * Constructor for listener.
     *
     * @param stage JavaFX {@code Stage}.
     */
    public MoveListener(Stage stage) {
        this.stage = stage;
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
    }
}