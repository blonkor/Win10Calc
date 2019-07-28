package com.implemica.bormashenko.calculator;

import com.implemica.bormashenko.calculator.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    private View view = new View();

    @Override
    public void start(Stage primaryStage) throws Exception {
        view.initStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}