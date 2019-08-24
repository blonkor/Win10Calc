package view.tests;

import javafx.geometry.VerticalDirection;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.text.Font;
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
            checkButtonColorAndFont(new String[]{ONE_ID, TWO_ID, THREE_ID, FOUR_ID, FIVE_ID, SIX_ID,
                            SEVEN_ID, EIGHT_ID, NINE_ID, ZERO_ID},
                    mostlyWhileColor, veryDarkGrayColor, segoeSemibold_22_5,
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_22_5);

            //dot
            checkButtonColorAndFont(new String[]{DOT_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeBlack_16,
                    lightGrayColor, veryDarkGrayColor, segoeBlack_16);

            //math operations
            checkButtonColorAndFont(new String[]{DIVIDE_ID, MULTIPLY_ID, SUBTRACT_ID, ADD_ID, EQUALS_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                    strongBlueColor, whiteColor, segoeAssets_14_5);

            checkButtonColorAndFont(new String[]{NEGATE_ID, PERCENT_ID, SQRT_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                    lightGrayColor, veryDarkGrayColor, segoeAssets_14_5);

            checkButtonColorAndFont(new String[]{SQR_ID, INVERSE_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeUI_20,
                    lightGrayColor, veryDarkGrayColor, segoeUI_20);

            //clear operations
            checkButtonColorAndFont(new String[]{CLEAR_ALL_ID, CLEAR_TEXT_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeUI_14_5,
                    lightGrayColor, veryDarkGrayColor, segoeUI_14_5);

            checkButtonColorAndFont(new String[]{BACKSPACE_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16);

            //memory buttons
            checkButtonColorAndFont(new String[]{MEMORY_CLEAR_ID, MEMORY_RECALL_ID, MEMORY_ADD_ID, MEMORY_SUBTRACT_ID,
                            MEMORY_STORE_ID, MEMORY_SHOW_ID},
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12);

            setNodeDisabled(MEMORY_CLEAR_ID, false);
            setNodeDisabled(MEMORY_RECALL_ID, false);

            checkButtonColorAndFont(new String[]{MEMORY_CLEAR_ID, MEMORY_RECALL_ID},
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12);

            setNodeDisabled(MEMORY_CLEAR_ID, true);
            setNodeDisabled(MEMORY_RECALL_ID, true);

            setNodeDisabled(MEMORY_SHOW_ID, false);

            checkButtonColorAndFont(new String[]{MEMORY_SHOW_ID},
                    lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                    grayColor, veryDarkGrayColor, segoeSemibold_12);

            setNodeDisabled(MEMORY_SHOW_ID, true);

            //navigation
            checkButtonColorAndFont(new String[]{NAVIGATION_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    grayColor, veryDarkGrayColor, segoeAssets_16);

            //history
            checkButtonColorAndFont(new String[]{HISTORY_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16);

            //arrows
            setNodeVisible(RIGHT_ARROW_ID, true);
            setNodeVisible(LEFT_ARROW_ID, true);

            checkButtonColorAndFont(new String[]{RIGHT_ARROW_ID, LEFT_ARROW_ID},
                    lightGrayColor, strongBlueColor, system_12,
                    grayColor, veryDarkGrayColor, system_12);

            setNodeVisible(RIGHT_ARROW_ID, false);
            setNodeVisible(LEFT_ARROW_ID, false);

            //minimize and expand
            checkButtonColorAndFont(new String[]{HIDE_ID, EXPAND_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    grayColor, veryDarkGrayColor, segoeAssets_10);

            //close
            checkButtonColorAndFont(new String[]{CLOSE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    vividRedColor, whiteColor, segoeAssets_10);

            //navigation buttons in scroll pane
            setNodeVisible(NAVIGATION_PANEL_ID, true);
            setNodeVisible(ABOUT_PANEL_ID, true);
            setNodeVisible(NAVIGATION_BLOCK_ID, true);

            checkButtonColorAndFont(new String[]{STANDARD_MODE_ID, SCIENTIFIC_MODE_ID, PROGRAMMER_MODE_ID,
                            DATE_CALCULATION_MODE_ID, CURRENCY_MODE_ID, VOLUME_MODE_ID, LENGTH_MODE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeUI_15,
                    grayColor, veryDarkGrayColor, segoeUI_15);

            robot.scroll(SCROLL_AMOUNT, VerticalDirection.DOWN);

            checkButtonColorAndFont(new String[]{WEIGHT_AND_MASS_MODE_ID, TEMPERATURE_MODE_ID, ENERGY_MODE_ID,
                            AREA_MODE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeUI_15,
                    grayColor, veryDarkGrayColor, segoeUI_15);

            robot.scroll(SCROLL_AMOUNT, VerticalDirection.DOWN);

            checkButtonColorAndFont(new String[]{SPEED_MODE_ID, TIME_MODE_ID, POWER_MODE_ID, DATA_MODE_ID, PRESSURE_MODE_ID,
                            ANGLE_MODE_ID, ABOUT_ID},
                    lightGrayColor, veryDarkGrayColor, segoeUI_15,
                    grayColor, veryDarkGrayColor, segoeUI_15);

            //check that standard operations buttons is under the navigation block,
            // while buttons in top panel are not under the block
            checkButtonColorAndFont(new String[]{DIVIDE_ID, MULTIPLY_ID, SUBTRACT_ID, ADD_ID, EQUALS_ID},
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                    veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5);

            //minimize and expand
            checkButtonColorAndFont(new String[]{HIDE_ID, EXPAND_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    grayColor, veryDarkGrayColor, segoeAssets_10);

            //close
            checkButtonColorAndFont(new String[]{CLOSE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    vividRedColor, whiteColor, segoeAssets_10);

            setNodeVisible(NAVIGATION_PANEL_ID, false);
            setNodeVisible(ABOUT_PANEL_ID, false);
            setNodeVisible(NAVIGATION_BLOCK_ID, false);

            //check that navigation button is under the memory block,
            // while buttons in top panel are not under the block
            setNodeVisible(MEMORY_PANEL_ID, true);
            setNodeVisible(MEMORY_BLOCK_ID, true);

            checkButtonColorAndFont(new String[]{NAVIGATION_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                    lightGrayColor, veryDarkGrayColor, segoeAssets_16);

            //minimize and expand
            checkButtonColorAndFont(new String[]{HIDE_ID, EXPAND_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    grayColor, veryDarkGrayColor, segoeAssets_10);

            //close
            checkButtonColorAndFont(new String[]{CLOSE_ID},
                    lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                    vividRedColor, whiteColor, segoeAssets_10);

            setNodeVisible(MEMORY_PANEL_ID, false);
            setNodeVisible(MEMORY_BLOCK_ID, false);
        }

        //labels
        {
            checkLabelColorAndFont(new String[]{TITLE_LABEL_ID}, veryDarkGrayColor, system_12);
            checkLabelColorAndFont(new String[]{TYPE_LABEL_ID}, veryDarkGrayColor, system_18);
            checkLabelColorAndFont(new String[]{EQUATION_LABEL_ID}, veryDarkGrayColor, segoeSemilight_14);
            checkLabelColorAndFont(new String[]{SCREEN_LABEL_ID}, veryDarkGrayColor, segoeSemibold_47);
            checkLabelColorAndFont(new String[]{MODE_LABEL_ID, CONVERTER_LABEL_ID}, veryDarkGrayColor, systemBold_14);
            checkLabelColorAndFont(new String[]{MEMORY_SHOW_SYMBOL}, veryDarkGrayColor, segoeAssets_6);
            checkLabelColorAndFont(new String[]{STANDARD_MODE_SYMBOL, DATE_CALCULATION_MODE_SYMBOL, LENGTH_MODE_SYMBOL,
                            AREA_MODE_SYMBOL, POWER_MODE_SYMBOL, PRESSURE_MODE_SYMBOL, ABOUT_SYMBOL},
                    veryDarkGrayColor, segoeAssets_16);
            checkLabelColorAndFont(new String[]{SCIENTIFIC_MODE_SYMBOL, PROGRAMMER_MODE_SYMBOL, CURRENCY_MODE_SYMBOL,
                            VOLUME_MODE_SYMBOL, WEIGHT_AND_MASS_MODE_SYMBOL, TEMPERATURE_MODE_SYMBOL, ENERGY_MODE_SYMBOL,
                            SPEED_MODE_SYMBOL, TIME_MODE_SYMBOL, DATA_MODE_SYMBOL, ANGLE_MODE_SYMBOL},
                    veryDarkGrayColor, calcAssets_15);
        }
    }

    /**
     * @todo
     */
    @Test
    public void textTests() {

    }

    /**
     * @todo
     */
    @Test
    public void resizeTests() {

    }

    /**
     * @todo
     */
    @Test
    public void moveWindowTests() {

    }

    /**
     * @todo
     */
    @Test
    public void serializationTests() {

    }

    /**
     * @todo
     */
    @Test
    public void visibleArrowsTests() {

    }

    /**
     * @todo
     */
    @Test
    public void exitTests() {

    }

    /**
     * @todo
     */
    @Test
    public void expandTests() {

    }

    /**
     * @todo
     */
    @Test
    public void resizeFontTests() {

    }

    /**
     * @todo
     */
    @Test
    public void hideTests() {

    }

    /**
     * @todo
     */
    @Test
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
     * @param expectedFontOnHover      font that should be set for every button in array while button is hovered.
     */
    private void checkButtonColorAndFont(String[] selectors,
                                         String expectedColor, String expectedTextColor,
                                         Font expectedFont,
                                         String expectedColorOnHover, String expectedTextColorOnHover,
                                         Font expectedFontOnHover) {

        for (String selector : selectors) {
            Button control = getButtonBySelector(selector);

            assertEquals(expectedColor, control.getBackground().getFills().get(0).getFill().toString());
            assertEquals(expectedTextColor, control.getTextFill().toString());
            assertEquals(expectedFont, control.getFont());

            hoverOn(control);

            assertEquals(expectedColorOnHover, control.getBackground().getFills().get(0).getFill().toString());
            assertEquals(expectedTextColorOnHover, control.getTextFill().toString());
            assertEquals(expectedFontOnHover, control.getFont());
        }
    }

    /**
     * Checks that labels have required text color and font.
     *
     * @param selectors         array with labels' selectors.
     * @param expectedTextColor text color that should be set for every label in array.
     * @param expectedFont      font that should be set for every label in array.
     */
    private void checkLabelColorAndFont(String[] selectors, String expectedTextColor, Font expectedFont) {

        for (String selector : selectors) {
            Labeled control = getLabeledBySelector(selector);

            assertEquals(expectedTextColor, control.getTextFill().toString());
            assertEquals(expectedFont, control.getFont());
        }
    }
}
