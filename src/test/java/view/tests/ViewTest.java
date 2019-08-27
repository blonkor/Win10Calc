package view.tests;

import javafx.geometry.Bounds;
import javafx.geometry.VerticalDirection;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Window;
import org.junit.Test;
import view.util.RobotControl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for testing view.
 *
 * @author Mykhailo Bormashenko
 * @see com.implemica.bormashenko.calculator.view.View
 */
public class ViewTest extends RobotControl {

    /**
     * Default application's width.
     */
    private static int DEFAULT_WIDTH = 322;

    /**
     * Default application's height.
     */
    private static int DEFAULT_HEIGHT = 501;

    /**
     * Default application's coordinate X.
     */
    private static int DEFAULT_X = 700;

    /**
     * Default application's coordinate Y.
     */
    private static int DEFAULT_Y = 150;

    /**
     * Runs all tests.
     */
    @Test
    public void allTests() {
        colorAndFontTests();
        textTests();
        sizeAndLayoutTests();
        resizeTests();
        moveWindowTests();
    }

    /**
     * Tests for background color, color of text and font for buttons and labels.
     */
    @Test
    public void colorAndFontTests() {
        //colors
        String whiteColor = "0xffffffff";
        String mostlyWhileColor = "0xfafafaff";
        String veryLightGrayColor = "0xf0f0f0ff";
        String lightGrayColor = "0xe6e6e6ff";
        String grayColor = "0xd0d0d0ff";
        String veryDarkGrayColor = "0x333333ff";
        String vividRedColor = "0xe9091eff";
        String strongBlueColor = "0x0078d7ff";

        //fonts
        Font system_12 = new Font("System", 12);
        Font system_18 = new Font("System", 18);
        Font systemBold_14 = new Font("System Bold", 14);
        Font segoeUI_14_5 = new Font("Segoe UI", 14.5);
        Font segoeUI_15 = new Font("Segoe UI", 15);
        Font segoeUI_20 = new Font("Segoe UI", 20);
        Font segoeBlack_16 = new Font("Segoe UI Black", 16);
        Font segoeSemilight_14 = new Font("Segoe UI Semilight", 14);
        Font segoeSemibold_12 = new Font("Segoe UI Semibold", 12);
        Font segoeSemibold_22_5 = new Font("Segoe UI Semibold", 22.5);
        Font segoeSemibold_47 = new Font("Segoe UI Semibold", 47);
        Font segoeAssets_6 = new Font("Segoe MDL2 Assets", 6);
        Font segoeAssets_10 = new Font("Segoe MDL2 Assets", 10);
        Font segoeAssets_14_5 = new Font("Segoe MDL2 Assets", 14.5);
        Font segoeAssets_16 = new Font("Segoe MDL2 Assets", 16);
        Font calcAssets_15 = new Font("Calculator MDL2 Assets", 15);

        //buttons
        {
            //digits
            checkColorAndFontForButtons(new String[]{ONE_ID, TWO_ID, THREE_ID, FOUR_ID, FIVE_ID, SIX_ID,
                            SEVEN_ID, EIGHT_ID, NINE_ID, ZERO_ID},
                    mostlyWhileColor, veryDarkGrayColor, segoeSemibold_22_5,
                    lightGrayColor, veryDarkGrayColor);

            //dot
            checkColorAndFontForButtons(new String[]{DOT_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeBlack_16,
                    lightGrayColor, veryDarkGrayColor);

            //math operations
            checkColorAndFontForButtons(new String[]{DIVIDE_ID, MULTIPLY_ID, SUBTRACT_ID, ADD_ID, EQUALS_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                    strongBlueColor, whiteColor);

            checkColorAndFontForButtons(new String[]{NEGATE_ID, PERCENT_ID, SQRT_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                    lightGrayColor, veryDarkGrayColor);

            checkColorAndFontForButtons(new String[]{SQR_ID, INVERSE_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeUI_20,
                    lightGrayColor, veryDarkGrayColor);

            //clear operations
            checkColorAndFontForButtons(new String[]{CLEAR_ALL_ID, CLEAR_TEXT_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeUI_14_5,
                    lightGrayColor, veryDarkGrayColor);

            checkColorAndFontForButtons(new String[]{BACKSPACE_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    lightGrayColor, veryDarkGrayColor);

            //memory buttons
            checkColorAndFontForButtons(new String[]{MEMORY_CLEAR_ID, MEMORY_RECALL_ID, MEMORY_ADD_ID, MEMORY_SUBTRACT_ID,
                            MEMORY_STORE_ID, MEMORY_SHOW_ID},
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                    lightGrayColor, veryDarkGrayColor);

            setNodeDisabled(MEMORY_CLEAR_ID, false);
            setNodeDisabled(MEMORY_RECALL_ID, false);

            checkColorAndFontForButtons(new String[]{MEMORY_CLEAR_ID, MEMORY_RECALL_ID},
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                    lightGrayColor, veryDarkGrayColor);

            setNodeDisabled(MEMORY_CLEAR_ID, true);
            setNodeDisabled(MEMORY_RECALL_ID, true);

            setNodeDisabled(MEMORY_SHOW_ID, false);

            checkColorAndFontForButtons(new String[]{MEMORY_SHOW_ID},
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                    grayColor, veryDarkGrayColor);

            setNodeDisabled(MEMORY_SHOW_ID, true);

            //navigation
            checkColorAndFontForButtons(new String[]{NAVIGATION_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    grayColor, veryDarkGrayColor);

            //history
            checkColorAndFontForButtons(new String[]{HISTORY_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    lightGrayColor, veryDarkGrayColor);

            //arrows
            setNodeVisible(RIGHT_ARROW_ID, true);
            setNodeVisible(LEFT_ARROW_ID, true);

            checkColorAndFontForButtons(new String[]{RIGHT_ARROW_ID, LEFT_ARROW_ID},
                    lightGrayColor, strongBlueColor, system_12,
                    grayColor, veryDarkGrayColor);

            setNodeVisible(RIGHT_ARROW_ID, false);
            setNodeVisible(LEFT_ARROW_ID, false);

            //minimize and expand
            checkColorAndFontForButtons(new String[]{HIDE_ID, EXPAND_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    grayColor, veryDarkGrayColor);

            //close
            checkColorAndFontForButtons(new String[]{CLOSE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    vividRedColor, whiteColor);

            //navigation buttons in scroll pane
            setNodeVisible(NAVIGATION_PANEL_ID, true);
            setNodeVisible(ABOUT_PANEL_ID, true);
            setNodeVisible(NAVIGATION_BLOCK_ID, true);

            checkColorAndFontForButtons(new String[]{STANDARD_MODE_ID, SCIENTIFIC_MODE_ID, PROGRAMMER_MODE_ID,
                            DATE_CALCULATION_MODE_ID, CURRENCY_MODE_ID, VOLUME_MODE_ID, LENGTH_MODE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeUI_15,
                    grayColor, veryDarkGrayColor);

            robot.scroll(SCROLL_AMOUNT, VerticalDirection.DOWN);

            checkColorAndFontForButtons(new String[]{WEIGHT_AND_MASS_MODE_ID, TEMPERATURE_MODE_ID, ENERGY_MODE_ID,
                            AREA_MODE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeUI_15,
                    grayColor, veryDarkGrayColor);

            robot.scroll(SCROLL_AMOUNT, VerticalDirection.DOWN);

            checkColorAndFontForButtons(new String[]{SPEED_MODE_ID, TIME_MODE_ID, POWER_MODE_ID, DATA_MODE_ID, PRESSURE_MODE_ID,
                            ANGLE_MODE_ID, ABOUT_ID},
                    lightGrayColor, veryDarkGrayColor, segoeUI_15,
                    grayColor, veryDarkGrayColor);

            //check that standard operations buttons is under the navigation block,
            // while buttons in top panel are not under the block
            checkColorAndFontForButtons(new String[]{DIVIDE_ID, MULTIPLY_ID, SUBTRACT_ID, ADD_ID, EQUALS_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                    veryLightGrayColor, veryDarkGrayColor);

            //minimize and expand
            checkColorAndFontForButtons(new String[]{HIDE_ID, EXPAND_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    grayColor, veryDarkGrayColor);

            //close
            checkColorAndFontForButtons(new String[]{CLOSE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    vividRedColor, whiteColor);

            setNodeVisible(NAVIGATION_PANEL_ID, false);
            setNodeVisible(ABOUT_PANEL_ID, false);
            setNodeVisible(NAVIGATION_BLOCK_ID, false);

            //check that navigation button is under the memory block,
            // while buttons in top panel are not under the block
            setNodeVisible(MEMORY_PANEL_ID, true);
            setNodeVisible(MEMORY_BLOCK_ID, true);

            checkColorAndFontForButtons(new String[]{NAVIGATION_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    lightGrayColor, veryDarkGrayColor);

            //minimize and expand
            checkColorAndFontForButtons(new String[]{HIDE_ID, EXPAND_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    grayColor, veryDarkGrayColor);

            //close
            checkColorAndFontForButtons(new String[]{CLOSE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    vividRedColor, whiteColor);

            setNodeVisible(MEMORY_PANEL_ID, false);
            setNodeVisible(MEMORY_BLOCK_ID, false);
        }

        //labels
        {
            checkColorAndFontForLabels(new String[]{TITLE_LABEL_ID}, veryDarkGrayColor, system_12);
            checkColorAndFontForLabels(new String[]{TYPE_LABEL_ID}, veryDarkGrayColor, system_18);
            checkColorAndFontForLabels(new String[]{EQUATION_LABEL_ID}, veryDarkGrayColor, segoeSemilight_14);
            checkColorAndFontForLabels(new String[]{SCREEN_LABEL_ID}, veryDarkGrayColor, segoeSemibold_47);
            checkColorAndFontForLabels(new String[]{MODE_LABEL_ID, CONVERTER_LABEL_ID}, veryDarkGrayColor, systemBold_14);
            checkColorAndFontForLabels(new String[]{MEMORY_SHOW_SYMBOL}, veryDarkGrayColor, segoeAssets_6);
            checkColorAndFontForLabels(new String[]{STANDARD_MODE_SYMBOL, DATE_CALCULATION_MODE_SYMBOL, LENGTH_MODE_SYMBOL,
                            AREA_MODE_SYMBOL, POWER_MODE_SYMBOL, PRESSURE_MODE_SYMBOL, ABOUT_SYMBOL},
                    veryDarkGrayColor, segoeAssets_16);
            checkColorAndFontForLabels(new String[]{SCIENTIFIC_MODE_SYMBOL, PROGRAMMER_MODE_SYMBOL, CURRENCY_MODE_SYMBOL,
                            VOLUME_MODE_SYMBOL, WEIGHT_AND_MASS_MODE_SYMBOL, TEMPERATURE_MODE_SYMBOL, ENERGY_MODE_SYMBOL,
                            SPEED_MODE_SYMBOL, TIME_MODE_SYMBOL, DATA_MODE_SYMBOL, ANGLE_MODE_SYMBOL},
                    veryDarkGrayColor, calcAssets_15);
        }
    }

    /**
     * Tests for text that buttons and labels contain.
     */
    @Test
    public void textTests() {
        //buttons
        {
            checkTextForButton(ONE_ID, "1");
            checkTextForButton(TWO_ID, "2");
            checkTextForButton(THREE_ID, "3");
            checkTextForButton(FOUR_ID, "4");
            checkTextForButton(FIVE_ID, "5");
            checkTextForButton(SIX_ID, "6");
            checkTextForButton(SEVEN_ID, "7");
            checkTextForButton(EIGHT_ID, "8");
            checkTextForButton(NINE_ID, "9");
            checkTextForButton(ZERO_ID, "0");
            checkTextForButton(DOT_ID, ".");

            checkTextForButton(ADD_ID, "\uE948");
            checkTextForButton(SUBTRACT_ID, "\uE949");
            checkTextForButton(MULTIPLY_ID, "\uE947");
            checkTextForButton(DIVIDE_ID, "\uE94A");
            checkTextForButton(EQUALS_ID, "\uE94E");
            checkTextForButton(PERCENT_ID, "\uE94C");
            checkTextForButton(NEGATE_ID, "\uE94D");
            checkTextForButton(SQR_ID, "\uD835\uDC65²");
            checkTextForButton(SQRT_ID, "\uE94B");
            checkTextForButton(INVERSE_ID, "⅟\uD835\uDC65");
            checkTextForButton(CLEAR_ALL_ID, "C");
            checkTextForButton(CLEAR_TEXT_ID, "CE");
            checkTextForButton(BACKSPACE_ID, "\uE94F");

            checkTextForButton(MEMORY_CLEAR_ID, "MC");
            checkTextForButton(MEMORY_RECALL_ID, "MR");
            checkTextForButton(MEMORY_ADD_ID, "M+");
            checkTextForButton(MEMORY_SUBTRACT_ID, "M-");
            checkTextForButton(MEMORY_STORE_ID, "MS");
            checkTextForButton(MEMORY_SHOW_ID, "M");

            checkTextForButton(NAVIGATION_ID, "\uE700");
            checkTextForButton(HISTORY_ID, "\uE81C");
            checkTextForButton(HIDE_ID, "\uE921");
            checkTextForButton(EXPAND_ID, "\uE922");
            checkTextForButton(CLOSE_ID, "\uE8BB");

            checkTextForButton(STANDARD_MODE_ID, "Standard");
            checkTextForButton(SCIENTIFIC_MODE_ID, "Scientific");
            checkTextForButton(PROGRAMMER_MODE_ID, "Programmer");
            checkTextForButton(DATE_CALCULATION_MODE_ID, "Date Calculation");
            checkTextForButton(CURRENCY_MODE_ID, "Currency");
            checkTextForButton(VOLUME_MODE_ID, "Volume");
            checkTextForButton(LENGTH_MODE_ID, "Length");
            checkTextForButton(WEIGHT_AND_MASS_MODE_ID, "Weight and Mass");
            checkTextForButton(TEMPERATURE_MODE_ID, "Temperature");
            checkTextForButton(ENERGY_MODE_ID, "Energy");
            checkTextForButton(AREA_MODE_ID, "Area");
            checkTextForButton(SPEED_MODE_ID, "Speed");
            checkTextForButton(TIME_MODE_ID, "Time");
            checkTextForButton(POWER_MODE_ID, "Power");
            checkTextForButton(DATA_MODE_ID, "Data");
            checkTextForButton(PRESSURE_MODE_ID, "Pressure");
            checkTextForButton(ANGLE_MODE_ID, "Angle");
            checkTextForButton(ABOUT_ID, "About");
        }

        //labels
        {
            checkTextForLabel(TITLE_LABEL_ID, "Calculator");
            checkTextForLabel(TYPE_LABEL_ID, "Standard");
            checkTextForLabel(EQUATION_LABEL_ID, "");
            checkTextForLabel(SCREEN_LABEL_ID, "0");
            checkTextForLabel(MODE_LABEL_ID, "Calculator");
            checkTextForLabel(CONVERTER_LABEL_ID, "Converter");
            checkTextForLabel(RIGHT_ARROW_SYMBOL, "\uE970");
            checkTextForLabel(LEFT_ARROW_SYMBOL, "\uE96F");
        }
    }

    /**
     * Tests for size and layouts that buttons and labels have.
     */
    @Test
    public void sizeAndLayoutTests() {
        //buttons
        {
            int mainButtonsHeight = 45;
            int upperEdgeButtonsHeight = 44;
            int fourthRowHeight = 42;
            int memoryHeight = 30;
            int navigationHeight = 40;


            int mainButtonsWidth = 79;
            int rightEdgeButtonsWidth = 77;
            int navigationWidth = 257;

            int firstColumnX = 2;
            int secondColumnX = 83;
            int thirdColumnX = 164;
            int fourthColumnX = 245;

            int memoryY = 2;
            int thirdRowY = 101;
            int fourthRowY = 148;
            int fifthRowY = 193;
            int sixthRowY = 241;
            int seventhRowY = 289;
            int eighthRowY = 337;

            checkSizeAndLayoutForControl(ONE_ID, mainButtonsHeight, mainButtonsWidth, firstColumnX, seventhRowY);
            checkSizeAndLayoutForControl(TWO_ID, mainButtonsHeight, mainButtonsWidth, secondColumnX, seventhRowY);
            checkSizeAndLayoutForControl(THREE_ID, mainButtonsHeight, mainButtonsWidth, thirdColumnX, seventhRowY);
            checkSizeAndLayoutForControl(FOUR_ID, mainButtonsHeight, mainButtonsWidth, firstColumnX, sixthRowY);
            checkSizeAndLayoutForControl(FIVE_ID, mainButtonsHeight, mainButtonsWidth, secondColumnX, sixthRowY);
            checkSizeAndLayoutForControl(SIX_ID, mainButtonsHeight, mainButtonsWidth, thirdColumnX, sixthRowY);
            checkSizeAndLayoutForControl(SEVEN_ID, mainButtonsHeight, mainButtonsWidth, firstColumnX, fifthRowY);
            checkSizeAndLayoutForControl(EIGHT_ID, mainButtonsHeight, mainButtonsWidth, secondColumnX, fifthRowY);
            checkSizeAndLayoutForControl(NINE_ID, mainButtonsHeight, mainButtonsWidth, thirdColumnX, fifthRowY);
            checkSizeAndLayoutForControl(ZERO_ID, mainButtonsHeight, mainButtonsWidth, secondColumnX, eighthRowY);
            checkSizeAndLayoutForControl(DOT_ID, mainButtonsHeight, mainButtonsWidth, thirdColumnX, eighthRowY);

            checkSizeAndLayoutForControl(ADD_ID, mainButtonsHeight, rightEdgeButtonsWidth, fourthColumnX, seventhRowY);
            checkSizeAndLayoutForControl(SUBTRACT_ID, mainButtonsHeight, rightEdgeButtonsWidth, fourthColumnX, sixthRowY);
            checkSizeAndLayoutForControl(MULTIPLY_ID, mainButtonsHeight, rightEdgeButtonsWidth, fourthColumnX, fifthRowY);
            checkSizeAndLayoutForControl(DIVIDE_ID, fourthRowHeight, rightEdgeButtonsWidth, fourthColumnX, fourthRowY);
            checkSizeAndLayoutForControl(EQUALS_ID, mainButtonsHeight, rightEdgeButtonsWidth, fourthColumnX, eighthRowY);
            checkSizeAndLayoutForControl(PERCENT_ID, upperEdgeButtonsHeight, mainButtonsWidth, firstColumnX, thirdRowY);
            checkSizeAndLayoutForControl(NEGATE_ID, mainButtonsHeight, mainButtonsWidth, firstColumnX, eighthRowY);
            checkSizeAndLayoutForControl(SQR_ID, upperEdgeButtonsHeight, mainButtonsWidth, thirdColumnX, thirdRowY);
            checkSizeAndLayoutForControl(SQRT_ID, upperEdgeButtonsHeight, mainButtonsWidth, secondColumnX, thirdRowY);
            checkSizeAndLayoutForControl(INVERSE_ID, upperEdgeButtonsHeight, rightEdgeButtonsWidth, fourthColumnX, thirdRowY);
            checkSizeAndLayoutForControl(CLEAR_ALL_ID, fourthRowHeight, mainButtonsWidth, secondColumnX, fourthRowY);
            checkSizeAndLayoutForControl(CLEAR_TEXT_ID, fourthRowHeight, mainButtonsWidth, firstColumnX, fourthRowY);
            checkSizeAndLayoutForControl(BACKSPACE_ID, fourthRowHeight, mainButtonsWidth, thirdColumnX, fourthRowY);

            checkSizeAndLayoutForControl(MEMORY_CLEAR_ID, memoryHeight, 53, 5, memoryY);
            checkSizeAndLayoutForControl(MEMORY_RECALL_ID, memoryHeight, 53, 58, memoryY);
            checkSizeAndLayoutForControl(MEMORY_ADD_ID, memoryHeight, 53, 111, memoryY);
            checkSizeAndLayoutForControl(MEMORY_SUBTRACT_ID, memoryHeight, 49, 164, memoryY);
            checkSizeAndLayoutForControl(MEMORY_STORE_ID, memoryHeight, 51, 213, memoryY);
            checkSizeAndLayoutForControl(MEMORY_SHOW_ID, memoryHeight, 51, 264, memoryY);

            checkSizeAndLayoutForControl(NAVIGATION_ID, navigationHeight, 40, 0, 0);
            checkSizeAndLayoutForControl(HISTORY_ID, navigationHeight, 40, 0, 0);
            checkSizeAndLayoutForControl(HIDE_ID, 32, 46, 2, 0);
            checkSizeAndLayoutForControl(EXPAND_ID, 32, 46, 48, 0);
            checkSizeAndLayoutForControl(CLOSE_ID, 32, 46, 94, 0);

            checkSizeAndLayoutForControl(STANDARD_MODE_ID, navigationHeight, navigationWidth, 0, 40);
            checkSizeAndLayoutForControl(SCIENTIFIC_MODE_ID, navigationHeight, navigationWidth, 0, 80);
            checkSizeAndLayoutForControl(PROGRAMMER_MODE_ID, navigationHeight, navigationWidth, 0, 120);
            checkSizeAndLayoutForControl(DATE_CALCULATION_MODE_ID, navigationHeight, navigationWidth, 0, 160);
            checkSizeAndLayoutForControl(CURRENCY_MODE_ID, navigationHeight, navigationWidth, 0, 240);
            checkSizeAndLayoutForControl(VOLUME_MODE_ID, navigationHeight, navigationWidth, 0, 280);
            checkSizeAndLayoutForControl(LENGTH_MODE_ID, navigationHeight, navigationWidth, 0, 320);
            checkSizeAndLayoutForControl(WEIGHT_AND_MASS_MODE_ID, navigationHeight, navigationWidth, 0, 360);
            checkSizeAndLayoutForControl(TEMPERATURE_MODE_ID, navigationHeight, navigationWidth, 0, 400);
            checkSizeAndLayoutForControl(ENERGY_MODE_ID, navigationHeight, navigationWidth, 0, 440);
            checkSizeAndLayoutForControl(AREA_MODE_ID, navigationHeight, navigationWidth, 0, 480);
            checkSizeAndLayoutForControl(SPEED_MODE_ID, navigationHeight, navigationWidth, 0, 520);
            checkSizeAndLayoutForControl(TIME_MODE_ID, navigationHeight, navigationWidth, 0, 560);
            checkSizeAndLayoutForControl(POWER_MODE_ID, navigationHeight, navigationWidth, 0, 600);
            checkSizeAndLayoutForControl(DATA_MODE_ID, navigationHeight, navigationWidth, 0, 640);
            checkSizeAndLayoutForControl(PRESSURE_MODE_ID, navigationHeight, navigationWidth, 0, 680);
            checkSizeAndLayoutForControl(ANGLE_MODE_ID, navigationHeight, navigationWidth, 0, 720);
            checkSizeAndLayoutForControl(ABOUT_ID, navigationHeight, 256, 0, 24);
        }

        //labels
        {
            checkSizeAndLayoutForControl(TITLE_LABEL_ID, 17, 71, 0, 0);
            checkSizeAndLayoutForControl(TYPE_LABEL_ID, 27, 72, 0, 0);
            checkSizeAndLayoutForControl(EQUATION_LABEL_ID, 20, 0, 305, 0);
            checkSizeAndLayoutForControl(SCREEN_LABEL_ID, 69, 27, 283, 0);
            checkSizeAndLayoutForControl(MODE_LABEL_ID, 40, 257, 0, 0);
            checkSizeAndLayoutForControl(CONVERTER_LABEL_ID, 40, 257, 0, 200);
            checkSizeAndLayoutForControl(RIGHT_ARROW_SYMBOL, 17, 20, 0, 0);
            checkSizeAndLayoutForControl(LEFT_ARROW_SYMBOL, 17, 20, 0, 0);
        }
    }

    /**
     * Tests for resizing application.
     */
    @Test
    public void resizeTests() {
        int ten = 10;
        int fifty = 50;
        int hundred = 100;
        int fiveHundred = 500;

        //left up corner
        {
            //width is not changed
            //height is not changed
            checkResize(DEFAULT_X, DEFAULT_Y, 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            //narrow height
            checkResize(DEFAULT_X, DEFAULT_Y, 0, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, 0, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, 0, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, 0, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            //expand height
            checkResize(DEFAULT_X, DEFAULT_Y, 0, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, 0, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, 0, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, 0, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);


            //narrow width
            //height is not changed
            checkResize(DEFAULT_X, DEFAULT_Y, ten, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fifty, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, hundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            //narrow height
            checkResize(DEFAULT_X, DEFAULT_Y, ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, ten, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, ten, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, ten, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, fifty, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fifty, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fifty, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, hundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, hundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, hundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            //expand height
            checkResize(DEFAULT_X, DEFAULT_Y, ten, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, ten, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, ten, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, ten, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, fifty, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fifty, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fifty, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fifty, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, hundred, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, hundred, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, hundred, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, hundred, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, fiveHundred, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);


            //expand width
            //height is not changed
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, 0,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, 0,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, 0,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, 0,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            //narrow height
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, ten,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, fifty,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, hundred,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, fiveHundred,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, ten,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, fifty,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, hundred,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, fiveHundred,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, ten,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, fifty,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, hundred,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, fiveHundred,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, ten,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, fifty,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, hundred,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, fiveHundred,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            //expand height
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, -ten,
                    DEFAULT_X - ten, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, -fifty,
                    DEFAULT_X - ten, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, -hundred,
                    DEFAULT_X - ten, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -ten, -fiveHundred,
                    DEFAULT_X - ten, 0,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, -ten,
                    DEFAULT_X - fifty, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, -fifty,
                    DEFAULT_X - fifty, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, -hundred,
                    DEFAULT_X - fifty, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fifty, -fiveHundred,
                    DEFAULT_X - fifty, 0,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, -ten,
                    DEFAULT_X - hundred, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, -fifty,
                    DEFAULT_X - hundred, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, -hundred,
                    DEFAULT_X - hundred, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -hundred, -fiveHundred,
                    DEFAULT_X - hundred, 0,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, -ten,
                    DEFAULT_X - fiveHundred, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + ten,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, -fifty,
                    DEFAULT_X - fiveHundred, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + fifty,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, -hundred,
                    DEFAULT_X - fiveHundred, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + hundred,
                    Cursor.NW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y, -fiveHundred, -fiveHundred,
                    DEFAULT_X - fiveHundred, 0,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + 150,
                    Cursor.NW_RESIZE);
        }

        //right up corner
        {
            //width is not changed
            //height is not changed
            checkResize(DEFAULT_X, DEFAULT_Y, 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NW_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            //expand height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, 0, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);


            //narrow width
            //height is not changed
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            //expand height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -ten, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fifty, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -hundred, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, -fiveHundred, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);


            //expand width
            //height is not changed
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.NE_RESIZE);

            //expand height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, ten, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fifty, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, hundred, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + ten,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + fifty,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + hundred,
                    Cursor.NE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y, fiveHundred, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + 150,
                    Cursor.NE_RESIZE);
        }

        //left down corner
        {
            //width is not changed
            //height is not changed
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            //narrow height
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            //expand height
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);


            //narrow width
            //height is not changed
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            //narrow height
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            //expand height
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);


            //expand width
            //height is not changed
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, 0,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, 0,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, 0,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, 0,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            //narrow height
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -ten,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -fifty,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -hundred,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -fiveHundred,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -ten,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -fifty,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -hundred,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -fiveHundred,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -ten,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -fifty,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -hundred,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -fiveHundred,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -ten,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -fifty,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -hundred,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -fiveHundred,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.SW_RESIZE);


            //expand height
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, ten,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, fifty,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, hundred,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, fiveHundred,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, ten,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, fifty,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, hundred,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, fiveHundred,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, ten,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, fifty,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, hundred,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, fiveHundred,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);

            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, ten,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, fifty,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, hundred,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SW_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, fiveHundred,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT + 248,
                    Cursor.SW_RESIZE);
        }

        //right down corner
        {
            //width is not changed
            //height is not changed
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            //expand height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);


            //narrow width
            //height is not changed
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            //expand height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);


            //expand width
            //height is not changed
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.SE_RESIZE);


            //expand height
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, hundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);

            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + ten - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.SE_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT + 248,
                    Cursor.SE_RESIZE);
        }

        //left side
        {
            //width is not changed
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);

            //narrow width
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), fifty, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);

            //expand width
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -ten, -hundred,
                    DEFAULT_X - ten, DEFAULT_Y,
                    DEFAULT_WIDTH + ten, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -fifty, fiveHundred,
                    DEFAULT_X - fifty, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -hundred, -fiveHundred,
                    DEFAULT_X - hundred, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -fiveHundred, 0,
                    DEFAULT_X - fiveHundred, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
        }

        //right side
        {
            //width is not changed
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);

            //narrow width
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -fifty, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -hundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), -fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);

            //expand width
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), ten, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + ten - 1, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fifty - 1, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), hundred, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + hundred - 1, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
            checkResize(DEFAULT_X + DEFAULT_WIDTH - 1, DEFAULT_Y + (DEFAULT_HEIGHT / 2), fiveHundred, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH + fiveHundred - 1, DEFAULT_HEIGHT,
                    Cursor.H_RESIZE);
        }

        //top side
        {
            //height is not changed
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, ten, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, -ten, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, fifty, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, -fifty, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);

            //expand height
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, -hundred, -ten,
                    DEFAULT_X, DEFAULT_Y - ten,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, fiveHundred, -fifty,
                    DEFAULT_X, DEFAULT_Y - fifty,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, -fiveHundred, -hundred,
                    DEFAULT_X, DEFAULT_Y - hundred,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y, 0, -fiveHundred,
                    DEFAULT_X, 0,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 150,
                    Cursor.V_RESIZE);
        }

        //bottom side
        {
            //height is not changed
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, 0,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);

            //narrow height
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, ten, -ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, -ten, -fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, fifty, -hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, -fifty, -fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT,
                    Cursor.V_RESIZE);

            //expand height
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, -hundred, ten,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + ten - 1,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, fiveHundred, fifty,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + fifty - 1,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, -fiveHundred, hundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + hundred - 1,
                    Cursor.V_RESIZE);
            checkResize(DEFAULT_X + (DEFAULT_WIDTH / 2), DEFAULT_Y + DEFAULT_HEIGHT - 1, 0, fiveHundred,
                    DEFAULT_X, DEFAULT_Y,
                    DEFAULT_WIDTH, DEFAULT_HEIGHT + 248,
                    Cursor.V_RESIZE);
        }
    }

    /**
     * Tests for moving window.
     */
    @Test
    public void moveWindowTests() {
        int ten = 10;
        int fifty = 50;
        int hundred = 100;
        int fiveHundred = 500;

        //do not move
        checkMovingWindow(0, 0, DEFAULT_X, DEFAULT_Y);

        //move horizontal
        //right
        checkMovingWindow(ten, 0, DEFAULT_X + ten, DEFAULT_Y);
        checkMovingWindow(fifty, 0, DEFAULT_X + fifty, DEFAULT_Y);
        checkMovingWindow(hundred, 0, DEFAULT_X + hundred, DEFAULT_Y);
        checkMovingWindow(fiveHundred, 0, DEFAULT_X + fiveHundred, DEFAULT_Y);

        //left
        checkMovingWindow(-ten, 0, DEFAULT_X - ten, DEFAULT_Y);
        checkMovingWindow(-fifty, 0, DEFAULT_X - fifty, DEFAULT_Y);
        checkMovingWindow(-hundred, 0, DEFAULT_X - hundred, DEFAULT_Y);
        checkMovingWindow(-fiveHundred, 0, DEFAULT_X - fiveHundred, DEFAULT_Y);

        //move vertical
        //up
        checkMovingWindow(0, -ten, DEFAULT_X, DEFAULT_Y - ten);
        checkMovingWindow(0, -fifty, DEFAULT_X, DEFAULT_Y - fifty);
        checkMovingWindow(0, -hundred, DEFAULT_X, DEFAULT_Y - hundred);
        checkMovingWindow(0, -fiveHundred, DEFAULT_X, -20);

        //down
        checkMovingWindow(0, ten, DEFAULT_X, DEFAULT_Y + ten);
        checkMovingWindow(0, fifty, DEFAULT_X, DEFAULT_Y + fifty);
        checkMovingWindow(0, hundred, DEFAULT_X, DEFAULT_Y + hundred);
        checkMovingWindow(0, fiveHundred, DEFAULT_X, DEFAULT_Y + fiveHundred);

        //horizontal and vertical
        //right up
        checkMovingWindow(ten, -ten, DEFAULT_X + ten, DEFAULT_Y - ten);
        checkMovingWindow(fifty, -ten, DEFAULT_X + fifty, DEFAULT_Y - ten);
        checkMovingWindow(hundred, -ten, DEFAULT_X + hundred, DEFAULT_Y - ten);
        checkMovingWindow(fiveHundred, -ten, DEFAULT_X + fiveHundred, DEFAULT_Y - ten);

        checkMovingWindow(ten, -fifty, DEFAULT_X + ten, DEFAULT_Y - fifty);
        checkMovingWindow(fifty, -fifty, DEFAULT_X + fifty, DEFAULT_Y - fifty);
        checkMovingWindow(hundred, -fifty, DEFAULT_X + hundred, DEFAULT_Y - fifty);
        checkMovingWindow(fiveHundred, -fifty, DEFAULT_X + fiveHundred, DEFAULT_Y - fifty);

        checkMovingWindow(ten, -hundred, DEFAULT_X + ten, DEFAULT_Y - hundred);
        checkMovingWindow(fifty, -hundred, DEFAULT_X + fifty, DEFAULT_Y - hundred);
        checkMovingWindow(hundred, -hundred, DEFAULT_X + hundred, DEFAULT_Y - hundred);
        checkMovingWindow(fiveHundred, -hundred, DEFAULT_X + fiveHundred, DEFAULT_Y - hundred);

        checkMovingWindow(ten, -fiveHundred, DEFAULT_X + ten, -20);
        checkMovingWindow(fifty, -fiveHundred, DEFAULT_X + fifty, -20);
        checkMovingWindow(hundred, -fiveHundred, DEFAULT_X + hundred, -20);
        checkMovingWindow(fiveHundred, -fiveHundred, DEFAULT_X + fiveHundred, -20);

        //right down
        checkMovingWindow(ten, ten, DEFAULT_X + ten, DEFAULT_Y + ten);
        checkMovingWindow(fifty, ten, DEFAULT_X + fifty, DEFAULT_Y + ten);
        checkMovingWindow(hundred, ten, DEFAULT_X + hundred, DEFAULT_Y + ten);
        checkMovingWindow(fiveHundred, ten, DEFAULT_X + fiveHundred, DEFAULT_Y + ten);

        checkMovingWindow(ten, fifty, DEFAULT_X + ten, DEFAULT_Y + fifty);
        checkMovingWindow(fifty, fifty, DEFAULT_X + fifty, DEFAULT_Y + fifty);
        checkMovingWindow(hundred, fifty, DEFAULT_X + hundred, DEFAULT_Y + fifty);
        checkMovingWindow(fiveHundred, fifty, DEFAULT_X + fiveHundred, DEFAULT_Y + fifty);

        checkMovingWindow(ten, hundred, DEFAULT_X + ten, DEFAULT_Y + hundred);
        checkMovingWindow(fifty, hundred, DEFAULT_X + fifty, DEFAULT_Y + hundred);
        checkMovingWindow(hundred, hundred, DEFAULT_X + hundred, DEFAULT_Y + hundred);
        checkMovingWindow(fiveHundred, hundred, DEFAULT_X + fiveHundred, DEFAULT_Y + hundred);

        checkMovingWindow(ten, fiveHundred, DEFAULT_X + ten, DEFAULT_Y + fiveHundred);
        checkMovingWindow(fifty, fiveHundred, DEFAULT_X + fifty, DEFAULT_Y + fiveHundred);
        checkMovingWindow(hundred, fiveHundred, DEFAULT_X + hundred, DEFAULT_Y + fiveHundred);
        checkMovingWindow(fiveHundred, fiveHundred, DEFAULT_X + fiveHundred, DEFAULT_Y + fiveHundred);

        //left up
        checkMovingWindow(-ten, -ten, DEFAULT_X - ten, DEFAULT_Y - ten);
        checkMovingWindow(-fifty, -ten, DEFAULT_X - fifty, DEFAULT_Y - ten);
        checkMovingWindow(-hundred, -ten, DEFAULT_X - hundred, DEFAULT_Y - ten);
        checkMovingWindow(-fiveHundred, -ten, DEFAULT_X - fiveHundred, DEFAULT_Y - ten);

        checkMovingWindow(-ten, -fifty, DEFAULT_X - ten, DEFAULT_Y - fifty);
        checkMovingWindow(-fifty, -fifty, DEFAULT_X - fifty, DEFAULT_Y - fifty);
        checkMovingWindow(-hundred, -fifty, DEFAULT_X - hundred, DEFAULT_Y - fifty);
        checkMovingWindow(-fiveHundred, -fifty, DEFAULT_X - fiveHundred, DEFAULT_Y - fifty);

        checkMovingWindow(-ten, -hundred, DEFAULT_X - ten, DEFAULT_Y - hundred);
        checkMovingWindow(-fifty, -hundred, DEFAULT_X - fifty, DEFAULT_Y - hundred);
        checkMovingWindow(-hundred, -hundred, DEFAULT_X - hundred, DEFAULT_Y - hundred);
        checkMovingWindow(-fiveHundred, -hundred, DEFAULT_X - fiveHundred, DEFAULT_Y - hundred);

        checkMovingWindow(-ten, -fiveHundred, DEFAULT_X - ten, -20);
        checkMovingWindow(-fifty, -fiveHundred, DEFAULT_X - fifty, -20);
        checkMovingWindow(-hundred, -fiveHundred, DEFAULT_X - hundred, -20);
        checkMovingWindow(-fiveHundred, -fiveHundred, DEFAULT_X - fiveHundred, -20);

        //left down
        checkMovingWindow(-ten, ten, DEFAULT_X - ten, DEFAULT_Y + ten);
        checkMovingWindow(-fifty, ten, DEFAULT_X - fifty, DEFAULT_Y + ten);
        checkMovingWindow(-hundred, ten, DEFAULT_X - hundred, DEFAULT_Y + ten);
        checkMovingWindow(-fiveHundred, ten, DEFAULT_X - fiveHundred, DEFAULT_Y + ten);

        checkMovingWindow(-ten, fifty, DEFAULT_X - ten, DEFAULT_Y + fifty);
        checkMovingWindow(-fifty, fifty, DEFAULT_X - fifty, DEFAULT_Y + fifty);
        checkMovingWindow(-hundred, fifty, DEFAULT_X - hundred, DEFAULT_Y + fifty);
        checkMovingWindow(-fiveHundred, fifty, DEFAULT_X - fiveHundred, DEFAULT_Y + fifty);

        checkMovingWindow(-ten, hundred, DEFAULT_X - ten, DEFAULT_Y + hundred);
        checkMovingWindow(-fifty, hundred, DEFAULT_X - fifty, DEFAULT_Y + hundred);
        checkMovingWindow(-hundred, hundred, DEFAULT_X - hundred, DEFAULT_Y + hundred);
        checkMovingWindow(-fiveHundred, hundred, DEFAULT_X - fiveHundred, DEFAULT_Y + hundred);

        checkMovingWindow(-ten, fiveHundred, DEFAULT_X - ten, DEFAULT_Y + fiveHundred);
        checkMovingWindow(-fifty, fiveHundred, DEFAULT_X - fifty, DEFAULT_Y + fiveHundred);
        checkMovingWindow(-hundred, fiveHundred, DEFAULT_X - hundred, DEFAULT_Y + fiveHundred);
        checkMovingWindow(-fiveHundred, fiveHundred, DEFAULT_X - fiveHundred, DEFAULT_Y + fiveHundred);
    }

    /**
     * @todo
     */
    public void serializationTests() {

    }

    /**
     * @todo
     */
    public void visibleArrowsTests() {

    }

    /**
     * @todo
     */
    public void exitTests() {

    }

    /**
     * @todo
     */
    public void expandTests() {

    }

    /**
     * @todo
     */
    public void resizeFontTests() {

    }

    /**
     * @todo
     */
    public void hideTests() {

    }

    /**
     * @todo
     */
    public void keyBoardTests() {

    }

    /**
     * Checks that buttons have required color, required text color, required font, and the same information
     * while the button is hovered.
     *
     * @param selectors                array with buttons's selectors.
     * @param expectedColor            background color that should be set for every button in array.
     * @param expectedTextColor        text color that should be set for every button in array.
     * @param expectedFont             font that should be set for every button in array.
     * @param expectedColorOnHover     background color that should be set for
     *                                 every button in array while button is hovered.
     * @param expectedTextColorOnHover text color that should be set for every button in array while button is hovered.
     */
    private void checkColorAndFontForButtons(String[] selectors,
                                             String expectedColor, String expectedTextColor,
                                             Font expectedFont,
                                             String expectedColorOnHover, String expectedTextColorOnHover) {

        for (String selector : selectors) {
            Button button = getButtonBySelector(selector);
            assertEquals(expectedColor, button.getBackground().getFills().get(0).getFill().toString());
            assertEquals(expectedTextColor, button.getTextFill().toString());
            assertEquals(expectedFont, button.getFont());

            hoverOn(button);

            assertEquals(expectedColorOnHover, button.getBackground().getFills().get(0).getFill().toString());
            assertEquals(expectedTextColorOnHover, button.getTextFill().toString());
        }
    }

    /**
     * Checks that labels have required text color and font.
     *
     * @param selectors         array with labels' selectors.
     * @param expectedTextColor text color that should be set for every label in array.
     * @param expectedFont      font that should be set for every label in array.
     */
    private void checkColorAndFontForLabels(String[] selectors, String expectedTextColor, Font expectedFont) {

        for (String selector : selectors) {
            Labeled labeled = getLabeledBySelector(selector);
            assertEquals(expectedTextColor, labeled.getTextFill().toString());
            assertEquals(expectedFont, labeled.getFont());
        }
    }

    /**
     * Checks that buttons has required text.
     *
     * @param selector     button's selector.
     * @param expectedText text that button should contain.
     */
    private void checkTextForButton(String selector, String expectedText) {
        Button button = getButtonBySelector(selector);
        assertEquals(expectedText, button.getText());
    }

    /**
     * Checks that label has required text.
     *
     * @param selector     label's selector.
     * @param expectedText text that label should contain.
     */
    private void checkTextForLabel(String selector, String expectedText) {
        Labeled labeled = getLabeledBySelector(selector);
        assertEquals(expectedText, labeled.getText());
    }

    /**
     * Checks that control has required size and layout.
     *
     * @param selector       control's selector.
     * @param expectedHeight current height that control should has.
     * @param expectedWidth  current width that control should has.
     * @param expectedX      current layout X that control should has.
     * @param expectedY      current layout Y that control should has.
     */
    private void checkSizeAndLayoutForControl(String selector, int expectedHeight, int expectedWidth,
                                              int expectedX, int expectedY) {
        Control control = getControlBySelector(selector);

        assertEquals(expectedHeight, control.getHeight());
        assertEquals(expectedWidth, control.getWidth());
        assertEquals(expectedX, control.getLayoutX());
        assertEquals(expectedY, control.getLayoutY());
    }


    /**
     * Checks that window has required location and size after being resized.
     * After each test window's size and location should be restired to default.
     *
     * @param fromX          coordinate X from where cursor should start resizing.
     * @param fromY          coordinate Y from where cursor should start resizing.
     * @param offsetX        offset for moving cursor by X coordinate.
     * @param offsetY        offset for moving cursor by Y coordinate.
     * @param expectedX      coordinate X that window should has after resizing.
     * @param expectedY      coordinate Y that window should has after resizing.
     * @param expectedHeight height that window should has after resizing.
     * @param expectedWidth  window that window should has after resizing.
     */
    private void checkResize(double fromX, double fromY, double offsetX, double offsetY,
                             double expectedX, double expectedY, double expectedWidth, double expectedHeight,
                             Cursor expectedCursor) {
        setWindowsSizeAndLayout(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_X, DEFAULT_Y);

        dragFromTo(fromX, fromY, fromX + offsetX, fromY + offsetY);

        Window window = getWindowByIndex(0);
        assertEquals(expectedCursor, window.getScene().getCursor());
        assertEquals(expectedX, window.getX());
        assertEquals(expectedY, window.getY());
        assertEquals(expectedWidth, window.getWidth());
        assertEquals(expectedHeight, window.getHeight());
    }

    /**
     * Checks that window has required location after moving it by dragging top panel.
     *
     * @param offsetX   offset for moving cursor by X coordinate.
     * @param offsetY   offset for moving cursor by Y coordinate.
     * @param expectedX coordinate X that window should has after moving.
     * @param expectedY coordinate Y that window should has after moving.
     */
    private void checkMovingWindow(double offsetX, double offsetY, double expectedX, double expectedY) {
        setWindowsSizeAndLayout(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_X, DEFAULT_Y);

        AnchorPane topPanel = (AnchorPane) getNodeBySelector(TOP_PANEL_ID);
        Bounds bounds = topPanel.localToScreen(topPanel.getBoundsInLocal());

        double centerX = (bounds.getMinX() + bounds.getMaxX()) / 2;
        double centerY = (bounds.getMinY() + bounds.getMaxY()) / 2;


        dragFromTo(centerX, centerY, centerX + offsetX, centerY + offsetY);

        Window window = getWindowByIndex(0);
        assertEquals(expectedX, window.getX());
        assertEquals(expectedY, window.getY());
    }
}
