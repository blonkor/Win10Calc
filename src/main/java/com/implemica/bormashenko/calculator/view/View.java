package com.implemica.bormashenko.calculator.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class View {

    private static final String TITLE = "Calculator";

    private static final String FXML_PATH = "resources/fxml/calc.fxml";

    private static final String ICON_PATH = "resources/images/icon.png";

    private static final String STYLE_PATH = "resources/css/style.css";

    public void initStage(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(FXML_PATH));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(STYLE_PATH).toExternalForm());

        primaryStage.setTitle(TITLE);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(ICON_PATH)));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        scene.setFill(Color.color(1, 1, 1, 0));
        primaryStage.show();
    }
}
