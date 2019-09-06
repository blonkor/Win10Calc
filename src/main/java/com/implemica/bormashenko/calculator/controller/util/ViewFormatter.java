package com.implemica.bormashenko.calculator.controller.util;

import com.implemica.bormashenko.calculator.model.Memory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Utility class for programmatically changing {@link com.implemica.bormashenko.calculator.view.View}.
 *
 * @author Mykhailo Bormashenko
 * @todo  tests
 */
public class ViewFormatter {

    /**
     * Layout for memory {@code Label}.
     */
    private static final int MEMORY_LABELS_LAYOUT = 16;

    /**
     * Pref height for memory {@code Label}.
     */
    private static final int MEMORY_LABELS_HEIGHT = 63;

    /**
     * Font size for memory {@code Label}.
     */
    private static final int MEMORY_LABELS_FONT_SIZE = 24;

    /**
     * Multiplicand for {@code Text} used in moving the {@code Text} in {@code Label}.
     */
    private static final double MULTIPLICAND_FOR_TEXT_WIDTH = 1.5;

    /**
     * Divisor for {@code Scene} width used in moving the {@code Text} in {@code Label}.
     */
    private static final double DIVISOR_FOR_SCENE_WIDTH = 2;

    /**
     * Multiplicand for {@code Scene} width used in moving the {@code Text} in {@code Label}.
     */
    private static final double MULTIPLICAND_FOR_SCENE_WIDTH = 0.1;

    /**
     * Insets for memory {@code Label}.
     */
    private static final Insets MEMORY_LABELS_INSETS = new Insets(0, 15, 0, 15);

    /**
     * Moves {@code Text} in {@code Label} to the right or left.
     * <p>
     * The {@code Label} should be wrapped into {@code ScrollPane}.
     *
     * @param clickedButton  {@code Button} that should move {@code Text} to the specific side.
     * @param oppositeButton {@code Button} that should move {@code Text} to the opposite of clicked button side.
     * @param label          {@code Label} that contains {@code Text} that should be moved.
     * @param labelScroll    {@code ScrollPane} that contains required {@code Label}.
     * @param moveLeft       true if moving left or false if moving right.
     */
    public static void moveTextInLabel(Button clickedButton, Button oppositeButton, Label label,
                                       ScrollPane labelScroll, boolean moveLeft) {
        oppositeButton.setVisible(true);

        Text text = new Text(label.getText());
        text.setFont(label.getFont());

        double newHValue = labelScroll.getHvalue();

        if (text.getBoundsInLocal().getWidth() > clickedButton.getScene().getWidth() * MULTIPLICAND_FOR_TEXT_WIDTH) {
            double offset = text.getBoundsInLocal().getWidth() / oppositeButton.getScene().getWidth() /
                    DIVISOR_FOR_SCENE_WIDTH * MULTIPLICAND_FOR_SCENE_WIDTH;

            if (moveLeft) {
                newHValue += offset;
            } else {
                newHValue -= offset;
            }

        } else {

            if (moveLeft) {
                newHValue = labelScroll.getHmax();
            } else {
                newHValue = labelScroll.getHmin();
            }

        }

        labelScroll.setHvalue(newHValue);

        if (labelScroll.getHvalue() == labelScroll.getHmax()) {
            clickedButton.setVisible(false);
        }
    }

    /**
     * Shows or hides memory panel.
     *
     * @param memoryAnchorPane memory panel that should be shown or hided.
     * @param memoryPanel      memory panel that contains {@code Label}.
     * @param block            invisible block for other {@code Button} in calculator.
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
     * Shows or hides navigation panel and about {@code Button}.
     *
     * @param navigationPanel navigation panel that should be shown.
     * @param about           panel with about {@code Button} that should be shown.
     * @param block           invisible block for other {@code Button} in calculator.
     */
    public static void showOrHideNavigationPanel(ScrollPane navigationPanel, AnchorPane about, AnchorPane block) {
        navigationPanel.setVisible(!navigationPanel.isVisible());
        about.setVisible(!about.isVisible());
        block.setVisible(!block.isVisible());
    }

    /**
     * Creates memory {@code Label} for each {@link Memory} cell.
     *
     * @param memory      model of {@link Memory}.
     * @param memoryPanel parent for {@code Label}.
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
     * Disables or enables several {@code Button}, passed as args.
     *
     * @param flag    true for disabling and false for enabling.
     * @param buttons several {@code Button} that should change their disability.
     */
    public static void setButtonsDisability(boolean flag, Button... buttons) {
        for (Button button : buttons) {
            button.setDisable(flag);
        }
    }

    /**
     * Sets configuration such as size, layout and style for memory {@code Label}.
     *
     * @param label       {@code Label} to edit.
     * @param memoryPanel parent for {@code Label}.
     * @param layoutY     coordinate Y for the {@code Label}.
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
     * Sets style for memory {@code Label}.
     *
     * @return style (as css representation).
     */
    private static String setStyleForLabels() {
        return "-fx-background-color: transparent;" +
                "-fx-font-size: " + MEMORY_LABELS_FONT_SIZE + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }

    /**
     * Sets style for memory {@code Label} on hover.
     *
     * @return style (as css representation).
     */
    private static String setStyleForLabelsOnHover() {
        return "-fx-background-color: #e7e7e7;" +
                "-fx-font-size: " + MEMORY_LABELS_FONT_SIZE + "px;" +
                "-fx-font-family: \"Segoe UI Semibold\"";
    }
}
