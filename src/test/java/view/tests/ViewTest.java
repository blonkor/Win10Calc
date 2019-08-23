package view.tests;

import javafx.geometry.VerticalDirection;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.junit.Test;
import view.util.RobotControl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for testing view.
 *
 * @author Mykhailo Bormashenko
 */
public class ViewTest extends RobotControl {


    @Test
    public void colorAndFontTests() {
        String whiteColor = "0xffffffff";
        String mostlyWhileColor = "0xfafafaff";
        String veryLightGrayColor = "0xf0f0f0ff";
        String lightGrayColor = "0xe6e6e6ff";
        String grayColor = "0xd0d0d0ff";
        String veryDarkGrayColor = "0x333333ff";
        String vividRedColor = "0xe9091eff";
        String strongBlueColor = "0x0078d7ff";

        Font system_12 = new Font("System", 12);
        Font segoeUI_14_5 = new Font("Segoe UI", 14.5);
        Font segoeUI_15 = new Font("Segoe UI", 15);
        Font segoeUI_20 = new Font("Segoe UI", 20);
        Font segoeBlack_16 = new Font("Segoe UI Black", 16);
        Font segoeSemibold_12 = new Font("Segoe UI Semibold", 12);
        Font segoeSemibold_22_5 = new Font("Segoe UI Semibold", 22.5);
        Font segoeAssets_10 = new Font("Segoe MDL2 Assets", 10);
        Font segoeAssets_14_5 = new Font("Segoe MDL2 Assets", 14.5);
        Font segoeAssets_16 = new Font("Segoe MDL2 Assets", 16);

        //digits
        checkButtonColorAndFont(new String[]{"#zero", "#one", "#two", "#three", "#four", "#five",
                        "#six", "#seven", "#eight", "#nine"},
                mostlyWhileColor, veryDarkGrayColor, segoeSemibold_22_5,
                lightGrayColor, veryDarkGrayColor, segoeSemibold_22_5);

        //standard operations (divide, multiply, subtract, add, equals)
        checkButtonColorAndFont(new String[]{"#divide", "#multiply", "#subtract", "#add", "#equals"},
                veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                strongBlueColor, whiteColor, segoeAssets_14_5);

        //special operations
        checkButtonColorAndFont(new String[]{"#negate", "#percent", "#sqrt"}, //negate, percent, sqrt
                veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                lightGrayColor, veryDarkGrayColor, segoeAssets_14_5);

        //degree operations
        checkButtonColorAndFont(new String[]{"#sqr", "#inverse"}, //sqr, inverse
                veryLightGrayColor, veryDarkGrayColor, segoeUI_20,
                lightGrayColor, veryDarkGrayColor, segoeUI_20);

        //clear operations
        checkButtonColorAndFont(new String[]{"#clearAll", "#clearText"},
                veryLightGrayColor, veryDarkGrayColor, segoeUI_14_5,
                lightGrayColor, veryDarkGrayColor, segoeUI_14_5);

        //dot
        checkButtonColorAndFont(new String[]{"#dot"},
                veryLightGrayColor, veryDarkGrayColor, segoeBlack_16,
                lightGrayColor, veryDarkGrayColor, segoeBlack_16);

        //backspace
        checkButtonColorAndFont(new String[]{"#backspace"},
                veryLightGrayColor, veryDarkGrayColor, segoeAssets_16,
                lightGrayColor, veryDarkGrayColor, segoeAssets_16);

        //memory
        checkButtonColorAndFont(new String[]{"#memoryClear", "#memoryRecall", "#memoryAdd", "#memorySubtract",
                        "#memoryStore", "#memoryShow"},
                lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                lightGrayColor, veryDarkGrayColor, segoeSemibold_12);

        setNodeDisabled("#memoryClear", false);
        setNodeDisabled("#memoryRecall", false);

        checkButtonColorAndFont(new String[]{"#memoryClear", "#memoryRecall"},
                lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                lightGrayColor, veryDarkGrayColor, segoeSemibold_12);

        setNodeDisabled("#memoryClear", true);
        setNodeDisabled("#memoryRecall", true);
        setNodeDisabled("#memoryShow", false);

        checkButtonColorAndFont(new String[]{"#memoryShow"},
                lightGrayColor, veryDarkGrayColor, segoeSemibold_12,
                grayColor, veryDarkGrayColor, segoeSemibold_12);

        setNodeDisabled("#memoryShow", true);

        //navigation
        checkButtonColorAndFont(new String[]{"#navigation"},
                lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                grayColor, veryDarkGrayColor, segoeAssets_16);

        //history
        checkButtonColorAndFont(new String[]{"#history"},
                lightGrayColor, veryDarkGrayColor, segoeAssets_16,
                lightGrayColor, veryDarkGrayColor, segoeAssets_16);

        //minimize and expand
        checkButtonColorAndFont(new String[]{"#hide", "#expand"},
                lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                grayColor, veryDarkGrayColor, segoeAssets_10);

        //close
        checkButtonColorAndFont(new String[]{"#close"},
                lightGrayColor, veryDarkGrayColor, segoeAssets_10,
                vividRedColor, whiteColor, segoeAssets_10);

        setNodeVisible("#navigationPanel", true);
        setNodeVisible("#about", true);
        setNodeVisible("#navigationBlock", true);

        checkButtonColorAndFont(new String[]{"#standard", "#scientific", "#programmer", "#dateCalculation",
                        "#currency", "#volume", "#length"},
                lightGrayColor, veryDarkGrayColor, segoeUI_15,
                grayColor, veryDarkGrayColor, segoeUI_15);

        robot.scroll(15, VerticalDirection.DOWN);

        checkButtonColorAndFont(new String[]{"#weightAndMass", "#temperature", "#energy", "#area",
                        "#speed", "#time", "#power", "#data"},
                lightGrayColor, veryDarkGrayColor, segoeUI_15,
                grayColor, veryDarkGrayColor, segoeUI_15);

        robot.scroll(5, VerticalDirection.DOWN);

        checkButtonColorAndFont(new String[]{"#pressure", "#angle", "About"},
                lightGrayColor, veryDarkGrayColor, segoeUI_15,
                grayColor, veryDarkGrayColor, segoeUI_15);

        checkButtonColorAndFont(new String[]{"#divide", "#multiply", "#subtract", "#add", "#equals"},
                veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5,
                veryLightGrayColor, veryDarkGrayColor, segoeAssets_14_5);

        setNodeVisible("#navigationPanel", false);
        setNodeVisible("#about", false);
        setNodeVisible("#navigationBlock", false);

        setNodeVisible("#rightArrow", true);
        setNodeVisible("#leftArrow", true);

        checkButtonColorAndFont(new String[]{"#rightArrow", "#leftArrow"},
                lightGrayColor, strongBlueColor, system_12,
                grayColor, veryDarkGrayColor, system_12);

        setNodeVisible("#rightArrow", false);
        setNodeVisible("#leftArrow", false);
    }

    /**
     * @todo
     */
    @Test
    void textTests() {

    }

    /**
     * @todo
     */
    @Test
    void resizeTests() {

    }

    /**
     * @todo
     */
    @Test
    void moveWindowTests() {

    }

    /**
     * @todo
     */
    @Test
    void serializationTests() {

    }

    /**
     * @todo
     */
    @Test
    void visibleArrowsTests() {

    }

    /**
     * @todo
     */
    @Test
    void exitTests() {

    }

    /**
     * @todo
     */
    @Test
    void expandTests() {

    }

    /**
     * @todo
     */
    @Test
    void resizeFontTests() {

    }

    /**
     * @todo
     */
    @Test
    void hideTests() {

    }

    /**
     * @todo
     */
    @Test
    void keyBoardTests() {

    }

    /**
     * Checks that button have required color, required text color, required font, and the same information
     * while the button is hovered.
     *
     * @param selectors                array where every element is text on different buttons or button's selector.
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
}
