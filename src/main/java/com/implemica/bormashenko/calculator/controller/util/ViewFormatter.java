package com.implemica.bormashenko.calculator.controller.util;

import com.implemica.bormashenko.calculator.model.Memory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Utility class for programmatically changing view.
 *
 * @author Mykhailo Bormashenko
 */
public class ViewFormatter {

    /**
     * Layout for memory labels.
     */
    private static final int MEMORY_LABELS_LAYOUT = 16;

    /**
     * Pref height for memory labels.
     */
    private static final int MEMORY_LABELS_HEIGHT = 63;

    /**
     * Font size for memory labels.
     */
    private static final int MEMORY_LABELS_FONT_SIZE = 24;

    /**
     * Insets for memory labels.
     */
    private static final Insets MEMORY_LABELS_INSETS = new Insets(0, 15, 0, 15);

    /**
     * Shows or hides memory panel.
     *
     * @param memoryAnchorPane memory panel that should be shown or hided.
     * @param memoryPanel      memory panel that contains labels.
     * @param block            invisible block for other buttons in calculator.
     * @param memory           model of memory.
     */
    public static void showOrHideMemoryPanel(AnchorPane memoryAnchorPane, AnchorPane memoryPanel, AnchorPane block,
                                             Memory memory) {
        memoryAnchorPane.setVisible(!memoryAnchorPane.isVisible());
        block.setVisible(!block.isVisible());

        if (memoryAnchorPane.isVisible()) {
            updateMemoryLabels(memory, memoryPanel);
        }
    }

    /**
     * Shows or hides navigation panel and about button.
     *
     * @param navigationPanel navigation panel that should be shown.
     * @param about           panel with about button that should be shown.
     * @param block           invisible block for other buttons in calculator.
     */
    public static void showOrHideNavigationPanel(ScrollPane navigationPanel, AnchorPane about, AnchorPane block) {
        navigationPanel.setVisible(!navigationPanel.isVisible());
        about.setVisible(!about.isVisible());
        block.setVisible(!block.isVisible());
    }

    /**
     * Creates memory labels for each memory cell.
     *
     * @param memory      model of memory.
     * @param memoryPanel parent for labels.
     */
    private static void updateMemoryLabels(Memory memory, AnchorPane memoryPanel) {
        Stack<BigDecimal> store = memory.getStore();

        if (!store.isEmpty()) {
            memoryPanel.getChildren().removeAll(memoryPanel.getChildren());

            double layoutY = MEMORY_LABELS_LAYOUT;

            for (int i = 0; i < store.size(); i++) {
                Label label = new Label();
                label.setText(store.elementAt(store.size() - i - 1).toString());
                configureMemoryLabel(label, memoryPanel, layoutY);

                memoryPanel.getChildren().add(label);
                layoutY += MEMORY_LABELS_HEIGHT + MEMORY_LABELS_LAYOUT;
            }
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
     * Sets configuration such as size, layout and style for memory label.
     *
     * @param label       label to edit.
     * @param memoryPanel parent for label.
     * @param layoutY     coordinate Y for the label.
     */
    private static void configureMemoryLabel(Label label, AnchorPane memoryPanel, double layoutY) {
        label.setPrefWidth(memoryPanel.getWidth());
        label.setPrefHeight(MEMORY_LABELS_HEIGHT);
        label.setMinHeight(label.getPrefHeight());
        label.setMaxHeight(label.getPrefHeight());
        label.setPadding(MEMORY_LABELS_INSETS);
        label.setLayoutY(layoutY);
        label.setStyle(setStyleForLabels());
        label.setWrapText(true);
        label.setOnMouseMoved(event -> label.setStyle(setStyleForLabelsOnHover()));
        label.setOnMouseExited(event -> label.setStyle(setStyleForLabels()));
        label.setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Sets style for memory label.
     *
     * @return style (as css representation).
     */
    private static String setStyleForLabels() {
        return "-fx-background-color: transparent;" +
                "-fx-font-size: " + MEMORY_LABELS_FONT_SIZE + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }

    /**
     * Sets style for memory label on hover.
     *
     * @return style (as css representation).
     */
    private static String setStyleForLabelsOnHover() {
        return "-fx-background-color: #e7e7e7;" +
                "-fx-font-size: " + MEMORY_LABELS_FONT_SIZE + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }
}
