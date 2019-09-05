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
 * @todo refactoring
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
     * Constructor for listener.
     *
     * @param stage JavaFX stage.
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