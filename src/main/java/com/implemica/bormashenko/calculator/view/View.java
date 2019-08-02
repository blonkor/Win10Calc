package com.implemica.bormashenko.calculator.view;

import com.implemica.bormashenko.calculator.view.listeners.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Main view of application.
 *
 * @author Mykhailo Bormashenko
 */
public class View {

    /**
     * Title of application.
     */
    private static final String TITLE = "Calculator";

    /**
     * Path to fxml representation of application.
     */
    private static final String FXML_PATH = "resources/fxml/calc.fxml";

    /**
     * Path to application's icon.
     */
    private static final String ICON_PATH = "resources/images/icon.png";

    /**
     * Path to stylesheets used in application.
     */
    private static final String STYLE_PATH = "resources/css/style.css";

    /**
     * ID of close button.
     */
    private static final String CLOSE_ID = "#close";

    /**
     * ID of expand button.
     */
    private static final String EXPAND_ID = "#expand";

    /**
     * ID of expand button.
     */
    private static final String HIDE_ID = "#hide";

    /**
     * ID of top panel (anchor pane).
     */
    private static final String TOP_PANEL_ID = "#topPanel";

    private static final String SCREEN_LABEL_ID = "#mainScreen";

    /**
     * Initializing main view and listeners.
     *
     * @param primaryStage JavaFX stage.
     */
    public void initStage(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(FXML_PATH));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(STYLE_PATH).toExternalForm());

        //close listener
        Button exit = (Button) scene.lookup(CLOSE_ID);
        exit.setOnAction(new ExitListener(primaryStage));

        //expand listener
        Button expand = (Button) scene.lookup(EXPAND_ID);
        expand.setOnAction(new ExpandListener(scene, primaryStage));

        //hide listener
        Button hide = (Button) scene.lookup(HIDE_ID);
        hide.setOnAction(new HideListener(primaryStage));

        //add move listener
        AnchorPane topPanel = (AnchorPane) scene.lookup(TOP_PANEL_ID);
        MoveListener moveListener = new MoveListener(primaryStage);
        topPanel.setOnMousePressed(moveListener);
        topPanel.setOnMouseDragged(moveListener);

        //resize listener
        ResizeListener resizeListener = new ResizeListener(scene, primaryStage);
        scene.setOnMouseMoved(resizeListener);
        scene.setOnMouseDragged(resizeListener);

        //add numeric field font resize
        Label numericLabel = (Label) scene.lookup(SCREEN_LABEL_ID);
        numericLabel.textProperty().addListener(new DigitsResizeListener(scene));

        primaryStage.setTitle(TITLE);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(ICON_PATH)));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(true);

        scene.setFill(Color.color(1, 1, 1, 0));
        primaryStage.show();
    }
}
