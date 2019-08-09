package com.implemica.bormashenko.calculator.view;

import com.implemica.bormashenko.calculator.view.listeners.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Main view of application.
 *
 * @author Mykhailo Bormashenko
 */
public class View {

    /**
     * Title of the application.
     */
    private static final String TITLE = "Calculator";

    /**
     * Path to fxml representation of the application.
     */
    private static final String FXML_PATH = "resources/fxml/calc.fxml";

    /**
     * Path to stylesheets used in application.
     */
    private static final String STYLE_PATH = "resources/css/style.css";

    /**
     * Path to application's icon.
     */
    private static final String ICON_PATH = "resources/images/icon.png";

    /**
     * ID of exit button that closes the application.
     */
    private static final String CLOSE_ID = "#close";

    /**
     * ID of expand button that maximizes the application.
     */
    private static final String EXPAND_ID = "#expand";

    /**
     * ID of hide button that minimizes the application.
     */
    private static final String HIDE_ID = "#hide";

    /**
     * ID of top panel with which the application can be moved.
     */
    private static final String TOP_PANEL_ID = "#topPanel";

    /**
     * ID of label in which the result of operations is shown.
     */
    private static final String RESULT_LABEL_ID = "#screen";

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

        //move listener
        AnchorPane topPanel = (AnchorPane) scene.lookup(TOP_PANEL_ID);
        MoveListener moveListener = new MoveListener(primaryStage);
        topPanel.setOnMousePressed(moveListener);
        topPanel.setOnMouseDragged(moveListener);

        //resize listener
        ResizeListener resizeListener = new ResizeListener(scene, primaryStage);
        scene.setOnMouseMoved(resizeListener);
        scene.setOnMouseDragged(resizeListener);

        //font resize listener
        Label resultLabel = (Label) scene.lookup(RESULT_LABEL_ID);
        FontResizeListener fontResizeListener = new FontResizeListener(scene);
        resultLabel.textProperty().addListener(fontResizeListener);
        scene.widthProperty().addListener(fontResizeListener);

        primaryStage.setTitle(TITLE);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(ICON_PATH)));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(true);

        primaryStage.show();
    }
}
