package com.implemica.bormashenko.calculator.controller.util;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

/**
 * Utility class for programmatically changing view.
 *
 * @author Mykhailo Bormashenko
 */
public class ViewFormatter {

    /**
     * This message is shown after showing history while history is empty.
     */
    private static final String EMPTY_HISTORY_MESSAGE = "There's no history yet.";

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
     * Opens or closes history panel.
     *
     * @param historyPanel panel where history is shown.
     * @param historyLabel label with history.
     */
    public static void showHistoryPanel(AnchorPane historyPanel, Label historyLabel) {
        historyPanel.setVisible(!historyPanel.isVisible());
        historyLabel.setText(EMPTY_HISTORY_MESSAGE);
    }

    /**
     * Opens or closes memory panel.
     *
     * @param memoryPanel panel where memory is shown.
     * @param memoryLabel label with memory.
     */
    public static void showMemoryPanel(AnchorPane memoryPanel, Label memoryLabel) {
        memoryPanel.setVisible(!memoryPanel.isVisible());
        memoryLabel.setText(EMPTY_MEMORY_MESSAGE);
    }
}
