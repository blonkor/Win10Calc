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

import java.io.*;

/**
 * Main view of application.
 *
 * @author Mykhailo Bormashenko
 */
public class View implements Serializable {

    /**
     * Title of the application.
     */
    private static final String TITLE = "Calculator";

    /**
     * Unicode escape sequence for symbol "ChromeRestore" in "Segoe MDL2 Assets" font representation.
     */
    private static final String MAXIMIZED_ICON = "\uE923";

    /**
     * Text shown in tooltip while application is maximized.
     */
    private static final String MAXIMIZED_TOOLTIP_TEXT = "Restore down";

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

    private static final String EQUATION_LABEL_ID = "#equation";

    /**
     * Minimal width of application.
     */
    private static final double MIN_WIDTH = 322;

    /**
     * Maximal width of application.
     */
    private static final double MIN_HEIGHT = 501;

    /**
     * Default application's location X.
     */
    private static final double DEFAULT_X = 700;

    /**
     * Default application's location Y.
     */
    private static final double DEFAULT_Y = 150;

    /**
     * Default application's maximize.
     */
    private static final boolean DEFAULT_MAXIMIZED = false;

    /**
     * Width of application.
     */
    private double width = MIN_WIDTH;

    /**
     * Height of application.
     */
    private double height = MIN_HEIGHT;

    /**
     * LocationX of application.
     */
    private double locationX = DEFAULT_X;

    /**
     * LocationY of application.
     */
    private double locationY = DEFAULT_Y;

    /**
     * True if application is maximized.
     */
    private boolean isMaximized = DEFAULT_MAXIMIZED;

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

        addListeners(primaryStage, scene);

        primaryStage.setTitle(TITLE);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(ICON_PATH)));
        primaryStage.setScene(scene);

        setParams(primaryStage, scene);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(true);

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
        close.setOnAction(new ExitListener(primaryStage, this));

        //expand listener
        Button expand = (Button) scene.lookup(EXPAND_ID);
        expand.setOnAction(new ExpandListener(scene, primaryStage, this));

        //hide listener
        Button hide = (Button) scene.lookup(HIDE_ID);
        hide.setOnAction(new HideListener(primaryStage));

        //move listener
        AnchorPane topPanel = (AnchorPane) scene.lookup(TOP_PANEL_ID);
        MoveListener moveListener = new MoveListener(primaryStage, this);
        topPanel.setOnMousePressed(moveListener);
        topPanel.setOnMouseDragged(moveListener);

        //resize listener
        ResizeListener resizeListener = new ResizeListener(scene, primaryStage, this);
        scene.setOnMouseMoved(resizeListener);
        scene.setOnMouseDragged(resizeListener);

        //font resize listener
        Label screen = (Label) scene.lookup(RESULT_LABEL_ID);
        FontResizeListener fontResizeListener = new FontResizeListener(scene);
        screen.textProperty().addListener(fontResizeListener);
        scene.widthProperty().addListener(fontResizeListener);

        //equation label length listener
        Label equation  = (Label)scene.lookup(EQUATION_LABEL_ID);
        equation.textProperty().addListener(new EquationLabelLengthListener(scene));

        //save view listener
        primaryStage.setOnCloseRequest(new SaveViewListener(this));

        //keyboard listener
        scene.setOnKeyPressed(new KeyboardListener(scene));
    }

    /**
     * Sets size and location for view.
     *
     * @param primaryStage JavaFX stage.
     * @param scene        JavaFX scene.
     */
    private void setParams(Stage primaryStage, Scene scene) {
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setX(locationX);
        primaryStage.setY(locationY);
        primaryStage.setMaximized(isMaximized);

        if (isMaximized) {
            Button expand = (Button) scene.lookup(EXPAND_ID);
            expand.setText(MAXIMIZED_ICON);
            expand.getTooltip().setText(MAXIMIZED_TOOLTIP_TEXT);
        }
    }

    /**
     * Resets size and location to default.
     *
     * @param primaryStage JavaFX stage.
     * @param scene        JavaFX scene.
     */
    public void resetToDefault(Stage primaryStage, Scene scene) {
        width = MIN_WIDTH;
        height = MIN_HEIGHT;
        locationX = DEFAULT_X;
        locationY = DEFAULT_Y;
        isMaximized = DEFAULT_MAXIMIZED;

        setParams(primaryStage, scene);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLocationX(double locationX) {
        if (locationX < 0) {
            locationX = 0;
        }

        this.locationX = locationX;
    }

    public void setLocationY(double locationY) {
        if (locationY < 0) {
            locationY = 0;
        }

        this.locationY = locationY;
    }

    public void setMaximized(boolean maximized) {
        isMaximized = maximized;
    }
}
