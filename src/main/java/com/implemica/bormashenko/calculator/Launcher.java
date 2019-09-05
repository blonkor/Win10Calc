package com.implemica.bormashenko.calculator;

import com.implemica.bormashenko.calculator.view.View;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Main class for application.
 *
 * @author Mykhailo Bormashenko
 * @todo refactoring
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