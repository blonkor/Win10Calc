package com.implemica.bormashenko.calculator.view;

import com.implemica.bormashenko.calculator.view.listeners.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;

/**
 * View of application.
 *
 * @author Mykhailo Bormashenko
 */
public class View implements Serializable {

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
     * ID of exit {@code Button} that closes the application.
     */
    private static final String CLOSE_ID = "#close";

    /**
     * ID of expand {@code Button} that maximizes the application.
     */
    private static final String EXPAND_ID = "#expand";

    /**
     * ID of hide {@code Button} that minimizes the application.
     */
    private static final String HIDE_ID = "#hide";

    /**
     * ID of top panel with which the application can be moved.
     */
    private static final String TOP_PANEL_ID = "#topPanel";

    /**
     * ID of {@code Label} in which the result of operations is shown.
     */
    private static final String RESULT_LABEL_ID = "#screen";

    /**
     * ID of equation {@code Scroll Pane}.
     */
    private static final String EQUATION_SCROLL_ID = "#equationScroll";

    /**
     * Initializing view and listeners.
     *
     * @param primaryStage JavaFX {@code Stage}.
     * @throws IOException signals that an I/O exception of some sort has occurred.
     */
    public void initStage(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(FXML_PATH));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(STYLE_PATH).toExternalForm());

        addListeners(primaryStage, scene);

        primaryStage.setTitle(TITLE);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(ICON_PATH)));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.show();
    }

    /**
     * Add listeners to components.
     *
     * @param primaryStage JavaFX stage.
     * @param scene        JavaFX scene.
     */
    private void addListeners(Stage primaryStage, Scene scene) {
        //close listener
        Button close = (Button) scene.lookup(CLOSE_ID);
        close.setOnAction(new ExitListener(primaryStage));

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
        Label screen = (Label) scene.lookup(RESULT_LABEL_ID);
        FontResizeListener fontResizeListener = new FontResizeListener(scene);
        screen.textProperty().addListener(fontResizeListener);
        scene.widthProperty().addListener(fontResizeListener);

        //equation label length listener
        ScrollPane scrollPaneEquation = (ScrollPane) scene.lookup(EQUATION_SCROLL_ID);
        Label equation = (Label) scrollPaneEquation.getContent();
        EquationLabelLengthListener equationLabelLengthListener = new EquationLabelLengthListener(scene);
        equation.textProperty().addListener(equationLabelLengthListener);
        scene.widthProperty().addListener(equationLabelLengthListener);
    }
}
