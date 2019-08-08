package com.implemica.bormashenko.calculator.controller.util;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class ViewFormatter {

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

    public static void setButtonsDisability(boolean flag, Button... buttons) {
        for (Button button : buttons) {
            button.setDisable(flag);
        }
    }

    public static void showNavigationPanel(ScrollPane navigationPanel, Button about) {
        if (navigationPanel.isVisible()) {
            setNavigationVisible(navigationPanel, about, false);
        } else {
            setNavigationVisible(navigationPanel, about,true);
        }
    }

    /**
     * Opens or closes history bar.
     */
    public static void showHistoryPanel(AnchorPane historyMemoryPanel, Label historyMemoryLabel) {
        String emptyHistory = "There's no history yet.";
        if (historyMemoryPanel.isVisible()) {
            setHistoryMemoryVisible(historyMemoryPanel, historyMemoryLabel, false, emptyHistory);
        } else {
            setHistoryMemoryVisible(historyMemoryPanel, historyMemoryLabel, true, emptyHistory);
        }
    }

    public static void memoryShowOperation(AnchorPane historyMemoryPanel, Label historyMemoryLabel) {
        String emptyMemory = "There's nothing saved in memory";
        if (historyMemoryPanel.isVisible()) {
            setHistoryMemoryVisible(historyMemoryPanel, historyMemoryLabel,false, emptyMemory);
        } else {
            setHistoryMemoryVisible(historyMemoryPanel, historyMemoryLabel,true, emptyMemory);
        }
    }

    /**
     * Sets visibility for navigation bar.
     *
     * @param flag flag for making visible or invisible navigation bar.
     */
    private static void setNavigationVisible(ScrollPane navigationPanel, Button about, boolean flag) {
        navigationPanel.setVisible(flag);
        about.setVisible(flag);
    }

    /**
     * Sets visibility for history bar.
     *
     * @param flag flag for making visible or invisible history bar.
     */
    private static void setHistoryMemoryVisible(AnchorPane historyMemoryPanel, Label historyMemoryLabel,
                                         boolean flag, String text) {
        historyMemoryPanel.setVisible(flag);
        historyMemoryLabel.setText(text);
    }
}
