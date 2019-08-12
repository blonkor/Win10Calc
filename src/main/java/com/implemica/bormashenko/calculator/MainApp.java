package com.implemica.bormashenko.calculator;

import com.implemica.bormashenko.calculator.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Main class for application.
 *
 * @author Mykhailo Bormashenko
 */
public class MainApp extends Application {

    /**
     * Path to dat file.
     */
    private static final String DAT_PATH = "src/main/java/com/implemica/bormashenko/calculator/view/resources/dat/view.dat";

    @Override
    public void start(Stage primaryStage) throws Exception {
        View view;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DAT_PATH))) {
            view = (View)objectInputStream.readObject();
        } catch (IOException e) {
            view = new View();
        }

        view.initStage(primaryStage);
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