package com.implemica.bormashenko.calculator.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button memoryClear;

    @FXML
    private Button memoryRecall;

    @FXML
    private Button memoryAdd;

    @FXML
    private Button memorySubtract;

    @FXML
    private Button memoryStore;

    @FXML
    private Button memoryShow;

    @FXML
    private Button navigation;

    @FXML
    private Button history;

    @FXML
    private Button close;

    @FXML
    private Button hide;

    @FXML
    private Button expand;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button[] buttonsWithGrayTooltip = {
                memoryClear, memoryRecall, memoryAdd, memoryStore,
                memorySubtract, memoryShow, navigation, history
        };
        setGrayTooltipsLocation(buttonsWithGrayTooltip);

        Button[] buttonsWithWhiteTooltip = {
                close, hide, expand
        };
        setWhiteTooltipsLocation(buttonsWithWhiteTooltip);
    }

    private void setGrayTooltipsLocation(Button[] buttons) {
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

    private void setWhiteTooltipsLocation(Button[] buttons) {
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
}
