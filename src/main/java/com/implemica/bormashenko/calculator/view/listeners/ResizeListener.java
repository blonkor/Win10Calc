package com.implemica.bormashenko.calculator.view.listeners;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Listener for resizing an application.
 *
 * @author Mykhailo Bormashenko
 */
public class ResizeListener implements EventHandler<MouseEvent> {

    /**
     * Padding for scene in which resize is possible.
     */
    private static final double BORDER = 2;

    /**
     * Minimal window width.
     */
    private static final double MIN_WIDTH = 322;

    /**
     * Minimal window height.
     */
    private static final double MIN_HEIGHT = 501;

    /**
     * True if window should be moved horizontally
     * (when the cursor is on the left edge of the window).
     */
    private boolean moveH;

    /**
     * True if window should be moved vertically
     * (when the cursor is on the top edge of the window).
     */
    private boolean moveV;

    /**
     * True if applying horizontal resizing.
     */
    private boolean resizeH = false;

    /**
     * True if applying vertical resizing.
     */
    private boolean resizeV = false;

    /**
     * JavaFX scene.
     */
    private Scene scene;

    /**
     * JavaFX stage.
     */
    private Stage stage;

    /**
     * Constructor for listener.
     *
     * @param scene JavaFX scene.
     * @param stage JavaFX stage.
     */
    public ResizeListener(Scene scene, Stage stage) {
        this.scene = scene;
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent event) {
        if (!stage.isMaximized()) {
            EventType type = event.getEventType();

            if (type.equals(MouseEvent.MOUSE_MOVED)) {
                changeCursor(event);
            } else if (type.equals(MouseEvent.MOUSE_DRAGGED)) {
                if (resizeH) {
                    changeWidth(event);
                }
                if (resizeV) {
                    changeHeight(event);
                }
            }
        }
    }

    /**
     * Changes type of cursor and enabling resizing.
     * This code was taken from
     * {@link <https://geektortoise.wordpress.com/2014/02/07/how-to-programmatically-resize-the-stage-in-a-javafx-app/>}
     * and then optimized.
     *
     * @param event mouse event.
     */
    private void changeCursor(MouseEvent event) {
        Cursor cursor;
        double eventX = event.getX();
        double eventY = event.getY();
        double width = scene.getWidth();
        double height = scene.getHeight();

        //up and left resizing
        if (eventX < BORDER && eventY < BORDER) {
            cursor = Cursor.NW_RESIZE;
            resizeH = true;
            resizeV = true;
            moveH = true;
            moveV = true;
        }
        //down and left resizing
        else if (eventX < BORDER && eventY > height - BORDER) {
            cursor = Cursor.SW_RESIZE;
            resizeH = true;
            resizeV = true;
            moveH = true;
            moveV = false;
        }
        //up and right resizing
        else if (eventX > width - BORDER && eventY < BORDER) {
            cursor = Cursor.NE_RESIZE;
            resizeH = true;
            resizeV = true;
            moveH = false;
            moveV = true;
        }
        //down and right resizing
        else if (eventX > width - BORDER && eventY > height - BORDER) {
            cursor = Cursor.SE_RESIZE;
            resizeH = true;
            resizeV = true;
            moveH = false;
            moveV = false;
        }
        //right or left resizing
        else if (eventX < BORDER || eventX > width - BORDER) {
            cursor = Cursor.H_RESIZE;
            resizeH = true;
            resizeV = false;
            moveH = (eventX < BORDER);
            moveV = false;
        }
        //up or down resizing
        else if (eventY < BORDER || eventY > height - BORDER) {
            cursor = Cursor.V_RESIZE;
            resizeH = false;
            resizeV = true;
            moveH = false;
            moveV = (eventY < BORDER);
        }
        //not a resizing
        else {
            cursor = Cursor.DEFAULT;
            resizeH = false;
            resizeV = false;
            moveH = false;
            moveV = false;
        }

        scene.setCursor(cursor);
    }

    /**
     * Right or left resizing.
     *
     * @param event mouse event.
     */
    private void changeWidth(MouseEvent event) {
        double deltaX = stage.getX() - event.getScreenX();
        double width = stage.getWidth();
        double eventX = event.getX();
        double newWidth = stage.getWidth();
        double newX = stage.getX();

        if (width <= MIN_WIDTH) {
            if (moveH) {
                if (eventX < 0) {
                    newWidth = deltaX + width;
                    newX = event.getScreenX();
                }
            } else if (eventX - width > 0) {
                newWidth = eventX;
            }
        } else if (width > MIN_WIDTH) {
            if (moveH) {
                newWidth = deltaX + width;
                newX = event.getScreenX();
            } else {
                newWidth = eventX;
            }
        }

        if (newWidth < MIN_WIDTH) {
            newWidth = MIN_WIDTH;
        }

        stage.setWidth(newWidth);
        stage.setX(newX);
    }

    /**
     * Up or down resizing.
     *
     * @param event mouse event.
     */
    private void changeHeight(MouseEvent event) {
        double deltaY = stage.getY() - event.getScreenY();
        double height = stage.getHeight();
        double eventY = event.getY();
        double newHeight = stage.getHeight();
        double newY = stage.getY();

        if (height <= MIN_HEIGHT) {
            if (moveV) {
                if (eventY < 0) {
                    newHeight = deltaY + height;
                    newY = event.getScreenY();
                }
            } else if (eventY - height > 0) {
                newHeight = eventY;
            }
        } else if (height > MIN_HEIGHT) {
            if (moveV) {
                newHeight = deltaY + height;
                newY = event.getScreenY();
            } else {
                newHeight = eventY;
            }
        }

        if (newHeight < MIN_HEIGHT) {
            newHeight = MIN_HEIGHT;
        }

        stage.setHeight(newHeight);
        stage.setY(newY);
    }
}
