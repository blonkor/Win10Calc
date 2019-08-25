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
    public static void showNavigationPanel(ScrollPane navigationPanel, AnchorPane about, AnchorPane block) {
        navigationPanel.setVisible(!navigationPanel.isVisible());
        about.setVisible(!about.isVisible());
        block.setVisible(!block.isVisible());
    }

    /**
     * Opens or closes memory panel.
     *
     * @param memoryPanel panel where memory is shown.
     */
    public static void showMemoryPanel(AnchorPane memoryPanel, AnchorPane block,
                                       Button[] memoryStandardEnabledButtons, Button[] memoryStandardDisabledButtons,
                                       boolean isEmptyMemory) {
        memoryPanel.setVisible(!memoryPanel.isVisible());
        block.setVisible(!block.isVisible());

        setButtonsDisability(memoryPanel.isVisible(), memoryStandardEnabledButtons);

        if (memoryPanel.isVisible()) {
            setButtonsDisability(true, memoryStandardDisabledButtons);
        } else {
            setButtonsDisability(isEmptyMemory, memoryStandardDisabledButtons);
        }
    }

    public static void moveEquationLeft() {

    }

    public static void moveEquationRight() {

    }

    public static void updateMemoryLabels(Memory memory, AnchorPane memoryPanel) {
        Stack<BigDecimal> store = memory.getStore();

        if (!store.isEmpty()) {
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
