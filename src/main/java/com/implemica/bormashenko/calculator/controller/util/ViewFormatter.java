package com.implemica.bormashenko.calculator.controller.util;

import com.implemica.bormashenko.calculator.model.Memory;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Utility class for programmatically changing view.
 *
 * @author Mykhailo Bormashenko
 */
public class ViewFormatter {

    /**
     * This message is shown after showing memory while memory is empty.
     */
    private static final String EMPTY_MEMORY_MESSAGE = "There's nothing saved in memory";

    /**
     * Changes locations for gray tooltips.
     * Gray tooltip is a tooltip with {@code styleClass = "tooltip_gray"}.
     * Gray tooltip have to appear above the cursor.
     *
     * @param buttons controllers with tooltip.
     */
    public static void setGrayTooltipsLocation(Button[] buttons) {
        final double[] currentMouseX = new double[1];
        final double[] currentMouseY = new double[1];
        for (Button button : buttons) {
            button.setOnMouseMoved(m -> {
                currentMouseX[0] = m.getScreenX();
                currentMouseY[0] = m.getScreenY();
            });
            button.getTooltip().setOnShowing(s -> {
                button.getTooltip().setX(currentMouseX[0] - button.getTooltip().getWidth() / 2);
                button.getTooltip().setY(currentMouseY[0] - 50);
            });
        }
    }

    /**
     * Changes locations for white tooltips.
     * White tooltip is a tooltip with {@code styleClass = "tooltip_white"}.
     * White tooltip have to appear below the cursor.
     *
     * @param buttons controllers with tooltip.
     */
    public static void setWhiteTooltipsLocation(Button[] buttons) {
        final double[] currentMouseX = new double[1];
        final double[] currentMouseY = new double[1];
        for (Button button : buttons) {
            button.setOnMouseMoved(m -> {
                currentMouseX[0] = m.getScreenX();
                currentMouseY[0] = m.getScreenY();
            });
            button.getTooltip().setOnShowing(s -> {
                button.getTooltip().setX(currentMouseX[0]);
                button.getTooltip().setY(currentMouseY[0] + 6);
            });
        }
    }

    /**
     * Disables or enables buttons, passed as args.
     *
     * @param flag    true for disabling and false for enabling.
     * @param buttons buttons that should change their disability.
     */
    public static void setButtonsDisability(boolean flag, Button... buttons) {
        for (Button button : buttons) {
            button.setDisable(flag);
        }
    }

    /**
     * Shows or hides navigation panel and "about" button.
     *
     * @param navigationPanel scroll pane to show or hide.
     * @param about           button to show or hide.
     */
    public static void showNavigationPanel(ScrollPane navigationPanel, Button about) {
        navigationPanel.setVisible(!navigationPanel.isVisible());
        about.setVisible(!about.isVisible());
    }

    /**
     * Opens or closes memory panel.
     *
     * @param memoryPanel panel where memory is shown.
     * @param memoryLabel label with memory.
     */
    public static void showMemoryPanel(AnchorPane memoryPanel, Label memoryLabel) {
        memoryPanel.setVisible(!memoryPanel.isVisible());
        //memoryLabel.setText(EMPTY_MEMORY_MESSAGE);
    }

    public static void updateMemoryLabels(Memory memory, AnchorPane memoryPanel, Label memoryLabel) {
        Stack<BigDecimal> store = memory.getStore();

        if (store.isEmpty()) {
            memoryLabel.setText(EMPTY_MEMORY_MESSAGE);
        } else {
            memoryLabel.setText("");
            memoryPanel.getChildren().removeAll(memoryPanel.getChildren());

            double layoutY = 16;
            for (int i = 0; i < store.size(); i++) {
                Label label = new Label();
                label.setText(store.elementAt(store.size() - i - 1).toString());
                label.setPrefWidth(memoryPanel.getWidth());
                label.setPrefHeight(63);
                label.setMinHeight(label.getPrefHeight());
                label.setMaxHeight(label.getPrefHeight());
                label.setPadding(new Insets(0, 0, 0 ,15));
                label.setLayoutY(layoutY);
                layoutY += 63 + 16;

                label.setStyle(setStyleForLabels());
                label.setWrapText(true);
                label.setOnMouseMoved(event -> label.setStyle(setStyleOnHover()));
                label.setOnMouseExited(event -> label.setStyle(setStyleForLabels()));
                label.setAlignment(Pos.TOP_LEFT);

                memoryPanel.getChildren().add(label);

            }
        }
    }

    private static String setStyleForLabels() {
        return "-fx-background-color: transparent;" +
                "-fx-font-size: " + 24 + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }

    private static String setStyleOnHover() {
        return "-fx-background-color: #e7e7e7;" +
                "-fx-font-size: " + 24 + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }
}
