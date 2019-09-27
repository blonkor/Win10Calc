package com.implemica.bormashenko.calculator;

import com.implemica.bormashenko.calculator.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class for application.
 *
 * @author Mykhailo Bormashenko
 */
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new View().initStage(primaryStage);
    }

    /**
     * Entry point.
     *
     * @param args command line parameters.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
//Looooohhhh, pidor
