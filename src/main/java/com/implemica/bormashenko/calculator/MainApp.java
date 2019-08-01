package com.implemica.bormashenko.calculator;

import com.implemica.bormashenko.calculator.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class for application.
 */
public class MainApp extends Application {
    //check commit

    /**
     * View of application.
     */
    private View view = new View();

    @Override
    public void start(Stage primaryStage) throws Exception {
        view.initStage(primaryStage);
    }

    /**
     * Entry point.
     * @param args command line parameters.
     */
    public static void main(String[] args) {
        launch(args);
    }
}