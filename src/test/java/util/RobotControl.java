package util;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.input.*;
import javafx.stage.Window;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import org.testfx.api.FxRobot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Class for controlling FxRobot. Extending it allows to automatically control mouse and keypad.
 *
 * @author Mykhailo Bormashenko.
 * @see com.implemica.bormashenko.calculator.view.View
 * @todo refactoring
 */
public class RobotControl extends GuiTest {

    /**
     * ID of one button.
     */
    protected static final String ONE_ID = "#one";

    /**
     * ID of two button.
     */
    protected static final String TWO_ID = "#two";

    /**
     * ID of three button.
     */
    protected static final String THREE_ID = "#three";

    /**
     * ID of four button.
     */
    protected static final String FOUR_ID = "#four";

    /**
     * ID of five button.
     */
    protected static final String FIVE_ID = "#five";

    /**
     * ID of six button.
     */
    protected static final String SIX_ID = "#six";

    /**
     * ID of seven button.
     */
    protected static final String SEVEN_ID = "#seven";

    /**
     * ID of eight button.
     */
    protected static final String EIGHT_ID = "#eight";

    /**
     * ID of nine button.
     */
    protected static final String NINE_ID = "#nine";

    /**
     * ID of zero button.
     */
    protected static final String ZERO_ID = "#zero";

    /**
     * ID of dot button.
     */
    protected static final String DOT_ID = "#dot";

    /**
     * ID of add button.
     */
    protected static final String ADD_ID = "#add";

    /**
     * ID of subtract button.
     */
    protected static final String SUBTRACT_ID = "#subtract";

    /**
     * ID of multiply button.
     */
    protected static final String MULTIPLY_ID = "#multiply";

    /**
     * ID of divide button.
     */
    protected static final String DIVIDE_ID = "#divide";

    /**
     * ID of equals button.
     */
    protected static final String EQUALS_ID = "#equals";

    /**
     * ID of percent button.
     */
    protected static final String PERCENT_ID = "#percent";

    /**
     * ID of negate button.
     */
    protected static final String NEGATE_ID = "#negate";

    /**
     * ID of sqr button.
     */
    protected static final String SQR_ID = "#sqr";

    /**
     * ID of sqrt button.
     */
    protected static final String SQRT_ID = "#sqrt";

    /**
     * ID of inverse button.
     */
    protected static final String INVERSE_ID = "#inverse";

    /**
     * ID of clear all button.
     */
    protected static final String CLEAR_ALL_ID = "#clearAll";

    /**
     * ID of clear text button.
     */
    protected static final String CLEAR_TEXT_ID = "#clearText";

    /**
     * ID of backspace button.
     */
    protected static final String BACKSPACE_ID = "#backspace";

    /**
     * ID of memory clear button.
     */
    protected static final String MEMORY_CLEAR_ID = "#memoryClear";

    /**
     * ID of memory recall button.
     */
    protected static final String MEMORY_RECALL_ID = "#memoryRecall";

    /**
     * ID of memory add button.
     */
    protected static final String MEMORY_ADD_ID = "#memoryAdd";

    /**
     * ID of memory subtract button.
     */
    protected static final String MEMORY_SUBTRACT_ID = "#memorySubtract";

    /**
     * ID of memory store button.
     */
    protected static final String MEMORY_STORE_ID = "#memoryStore";

    /**
     * ID of memory show button.
     */
    protected static final String MEMORY_SHOW_ID = "#memoryShow";

    /**
     * ID of navigation button.
     */
    protected static final String NAVIGATION_ID = "#navigation";

    /**
     * ID of history button.
     */
    protected static final String HISTORY_ID = "#history";

    /**
     * ID of right arrow button.
     */
    protected static final String RIGHT_ARROW_ID = "#rightArrow";

    /**
     * ID of left arrow button.
     */
    protected static final String LEFT_ARROW_ID = "#leftArrow";

    /**
     * ID of hide button.
     */
    protected static final String HIDE_ID = "#hide";

    /**
     * ID of expand button.
     */
    protected static final String EXPAND_ID = "#expand";

    /**
     * ID of close button.
     */
    protected static final String CLOSE_ID = "#close";

    /**
     * ID of navigation panel (scroll pane).
     */
    protected static final String NAVIGATION_PANEL_ID = "#navigationPanel";

    /**
     * ID of about panel (anchor pane).
     */
    protected static final String ABOUT_PANEL_ID = "#aboutPanel";

    /**
     * ID of navigation block (anchor pane).
     */
    protected static final String NAVIGATION_BLOCK_ID = "#navigationBlock";

    /**
     * ID of standard mode button.
     */
    protected static final String STANDARD_MODE_ID = "#standard";

    /**
     * ID of scientific mode button.
     */
    protected static final String SCIENTIFIC_MODE_ID = "#scientific";

    /**
     * ID of programmer mode button.
     */
    protected static final String PROGRAMMER_MODE_ID = "#programmer";

    /**
     * ID of date calculation mode button.
     */
    protected static final String DATE_CALCULATION_MODE_ID = "#dateCalculation";

    /**
     * ID of currency mode button.
     */
    protected static final String CURRENCY_MODE_ID = "#currency";

    /**
     * ID of volume mode button.
     */
    protected static final String VOLUME_MODE_ID = "#volume";

    /**
     * ID of length mode button.
     */
    protected static final String LENGTH_MODE_ID = "#length";

    /**
     * ID of weight and mass mode button.
     */
    protected static final String WEIGHT_AND_MASS_MODE_ID = "#weightAndMass";

    /**
     * ID of temperature mode button.
     */
    protected static final String TEMPERATURE_MODE_ID = "#temperature";

    /**
     * ID of energy mode button.
     */
    protected static final String ENERGY_MODE_ID = "#energy";

    /**
     * ID of area mode button.
     */
    protected static final String AREA_MODE_ID = "#area";

    /**
     * ID of speed mode button.
     */
    protected static final String SPEED_MODE_ID = "#speed";

    /**
     * ID of time mode button.
     */
    protected static final String TIME_MODE_ID = "#time";

    /**
     * ID of power mode button.
     */
    protected static final String POWER_MODE_ID = "#power";

    /**
     * ID of data mode button.
     */
    protected static final String DATA_MODE_ID = "#data";

    /**
     * ID of pressure mode button.
     */
    protected static final String PRESSURE_MODE_ID = "#pressure";

    /**
     * ID of angle mode button.
     */
    protected static final String ANGLE_MODE_ID = "#angle";

    /**
     * ID of about button.
     */
    protected static final String ABOUT_ID = "#about";

    /**
     * ID of memory panel (anchor pane).
     */
    protected static final String MEMORY_PANEL_ID = "#memoryAnchorPane";

    /**
     * ID of memory block (anchor pane).
     */
    protected static final String MEMORY_BLOCK_ID = "#memoryBlock";

    /**
     * ID of top panel.
     */
    protected static final String TOP_PANEL_ID = "#topPanel";

    /**
     * ID of title label.
     */
    protected static final String TITLE_LABEL_ID = "#title";

    /**
     * ID of type label.
     */
    protected static final String TYPE_LABEL_ID = "#type";

    /**
     * ID of equation label.
     */
    protected static final String EQUATION_LABEL_ID = "#equation";

    /**
     * ID of screen label.
     */
    protected static final String SCREEN_LABEL_ID = "#screen";

    /**
     * ID of mode label.
     */
    protected static final String MODE_LABEL_ID = "#mode";

    /**
     * ID of converter label.
     */
    protected static final String CONVERTER_LABEL_ID = "#converter";

    /**
     * Unicode escape sequence of flick down symbol in MDL2 assets.
     */
    protected static final String MEMORY_SHOW_SYMBOL = "\uE936";

    /**
     * Unicode escape sequence of flick up symbol in MDL2 assets.
     */
    protected static final String STANDARD_MODE_SYMBOL = "\uE8EF";

    /**
     * Unicode escape sequence of scientific symbol in MDL2 assets.
     */
    protected static final String SCIENTIFIC_MODE_SYMBOL = "\uF196";

    /**
     * Unicode escape sequence of programmer symbol in MDL2 assets.
     */
    protected static final String PROGRAMMER_MODE_SYMBOL = "\uECCE";

    /**
     * Unicode escape sequence of date calculation symbol in MDL2 assets.
     */
    protected static final String DATE_CALCULATION_MODE_SYMBOL = "\uE787";

    /**
     * Unicode escape sequence of currency symbol in MDL2 assets.
     */
    protected static final String CURRENCY_MODE_SYMBOL = "\uEB0D";

    /**
     * Unicode escape sequence of volume symbol in MDL2 assets.
     */
    protected static final String VOLUME_MODE_SYMBOL = "\uF1AA";

    /**
     * Unicode escape sequence of length symbol in MDL2 assets.
     */
    protected static final String LENGTH_MODE_SYMBOL = "\uECC6";

    /**
     * Unicode escape sequence of weight and mass symbol in MDL2 assets.
     */
    protected static final String WEIGHT_AND_MASS_MODE_SYMBOL = "\uF4C1";

    /**
     * Unicode escape sequence of temperature symbol in MDL2 assets.
     */
    protected static final String TEMPERATURE_MODE_SYMBOL = "\uE7A3";

    /**
     * Unicode escape sequence of energy symbol in MDL2 assets.
     */
    protected static final String ENERGY_MODE_SYMBOL = "\uECAD";

    /**
     * Unicode escape sequence of area symbol in MDL2 assets.
     */
    protected static final String AREA_MODE_SYMBOL = "\uE809";

    /**
     * Unicode escape sequence of speed symbol in MDL2 assets.
     */
    protected static final String SPEED_MODE_SYMBOL = "\uEADA";

    /**
     * Unicode escape sequence of time symbol in MDL2 assets.
     */
    protected static final String TIME_MODE_SYMBOL = "\uE917";

    /**
     * Unicode escape sequence of power symbol in MDL2 assets.
     */
    protected static final String POWER_MODE_SYMBOL = "\uE945";

    /**
     * Unicode escape sequence of data symbol in MDL2 assets.
     */
    protected static final String DATA_MODE_SYMBOL = "\uF20F";

    /**
     * Unicode escape sequence of pressure symbol in MDL2 assets.
     */
    protected static final String PRESSURE_MODE_SYMBOL = "\uEC4A";

    /**
     * Unicode escape sequence of angle symbol in MDL2 assets.
     */
    protected static final String ANGLE_MODE_SYMBOL = "\uF515";

    /**
     * Unicode escape sequence of about symbol in MDL2 assets.
     */
    protected static final String ABOUT_SYMBOL = "\uE946";

    /**
     * Unicode escape sequence of right arrow symbol in MDL2 assets.
     */
    protected static final String RIGHT_ARROW_SYMBOL = "\uE970";

    /**
     * Unicode escape sequence of left arrow symbol in MDL2 assets.
     */
    protected static final String LEFT_ARROW_SYMBOL = "\uE96F";

    /**
     * Value for scroll using FxRobot.
     */
    protected static final int SCROLL_AMOUNT = 10;

    /**
     * Robot for automatically control application.
     */
    protected FxRobot robot = new FxRobot();

    private Robot awtRobot = new Robot();

    protected RobotControl() throws AWTException {
    }

    @Override
    public void setupStage() {
        FXTestUtils.launchApp(SetLauncherAppForTests.class, "");

        try {
            stage = targetWindow(SetLauncherAppForTests.getStageFuture().get(25, TimeUnit.SECONDS));
            FXTestUtils.bringToFront(stage);
        } catch (Exception e) {
            throw new RuntimeException("Unable to show stage", e);
        }
    }

    @Override
    public Parent getRootNode() {
        if (stage == null) {
            setupStage();
        }

        return stage.getScene().getRoot();
    }

    /**
     * Looks up for node by selector.
     *
     * @param selector id of node.
     * @return node.
     */
    protected Node getNodeBySelector(String selector) {
        return robot.lookup(selector).query();
    }

    /**
     * Looks up for button by selector.
     *
     * @param selector id or text of button.
     * @return button found by selector.
     */
    protected Button getButtonBySelector(String selector) {
        return robot.lookup(selector).queryButton();
    }

    protected Button[] getSeveralButtonsBySelector(String... selectors) {
        Button[] buttons = new Button[selectors.length];

        for (int i = 0; i < selectors.length; i++) {
            buttons[i] = getButtonBySelector(selectors[i]);
        }

        return buttons;
    }

    /**
     * Looks up for label by selector.
     *
     * @param selector id or text of label.
     * @return label found by selector.
     */
    protected Labeled getLabeledBySelector(String selector) {
        return robot.lookup(selector).queryLabeled();
    }

    /**
     * Clicks on buttons in application to type required text.
     *
     * @param text text to type by clicking buttons.
     * @throws NullPointerException if required text is not a number.
     */
    protected void clickButtons(String text) {
        for (int i = 0; i < text.length(); i++) {
            String selector;
            char charAtI = text.charAt(i);

            if (charAtI == '0') {
                selector = ZERO_ID;
            } else if (charAtI == '1') {
                selector = ONE_ID;
            } else if (charAtI == '2') {
                selector = TWO_ID;
            } else if (charAtI == '3') {
                selector = THREE_ID;
            } else if (charAtI == '4') {
                selector = FOUR_ID;
            } else if (charAtI == '5') {
                selector = FIVE_ID;
            } else if (charAtI == '6') {
                selector = SIX_ID;
            } else if (charAtI == '7') {
                selector = SEVEN_ID;
            } else if (charAtI == '8') {
                selector = EIGHT_ID;
            } else if (charAtI == '9') {
                selector = NINE_ID;
            } else if (charAtI == '.') {
                selector = DOT_ID;
            } else if (charAtI == '+') {
                selector = ADD_ID;
            } else if (charAtI == '-') {
                selector = SUBTRACT_ID;
            } else if (charAtI == '*') {
                selector = MULTIPLY_ID;
            } else if (charAtI == '/') {
                selector = DIVIDE_ID;
            } else if (charAtI == '=') {
                selector = EQUALS_ID;
            } else if (charAtI == '%') {
                selector = PERCENT_ID;
            } else if (charAtI == '~') {
                selector = NEGATE_ID;
            } else if (charAtI == '^') {
                selector = SQR_ID;
            } else if (charAtI == '@') {
                selector = SQRT_ID;
            } else if (charAtI == ';') {
                selector = INVERSE_ID;
            } else if (charAtI == '<') {
                selector = BACKSPACE_ID;
            } else {
                throw new IllegalArgumentException("Expected: string with correct buttons representation only. \n" +
                        "Got: " + charAtI);
            }

            clickOn(getButtonBySelector(selector));
        }
    }

    protected void pressKeyboard(String text) {
        String[] codes = text.split(" ");

        for (String code : codes) {

            int additionalKey = 0;
            int mainKey;

            //ctrl combinations
            if (code.equals("ctrl+M")) {
                additionalKey = KeyEvent.VK_CONTROL;
                mainKey = KeyEvent.VK_M;
            } else if (code.equals("ctrl+P")) {
                additionalKey = KeyEvent.VK_CONTROL;
                mainKey = KeyEvent.VK_P;
            } else if (code.equals("ctrl+Q")) {
                additionalKey = KeyEvent.VK_CONTROL;
                mainKey = KeyEvent.VK_Q;
            } else if (code.equals("ctrl+R")) {
                additionalKey = KeyEvent.VK_CONTROL;
                mainKey = KeyEvent.VK_R;
            } else if (code.equals("ctrl+L")) {
                additionalKey = KeyEvent.VK_CONTROL;
                mainKey = KeyEvent.VK_L;

                //shift combinations
            } else if (code.equals("shift+2")) {
                additionalKey = KeyEvent.VK_SHIFT;
                mainKey = KeyEvent.VK_2;
            } else if (code.equals("shift+5")) {
                additionalKey = KeyEvent.VK_SHIFT;
                mainKey = KeyEvent.VK_5;
            } else if (code.equals("shift+8")) {
                additionalKey = KeyEvent.VK_SHIFT;
                mainKey = KeyEvent.VK_8;
            } else if (code.equals("shift+=")) {
                additionalKey = KeyEvent.VK_SHIFT;
                mainKey = KeyEvent.VK_EQUALS;

                //digits
            } else if (code.equals("0")) {
                mainKey = KeyEvent.VK_0;
            } else if (code.equals("1")) {
                mainKey = KeyEvent.VK_1;
            } else if (code.equals("2")) {
                mainKey = KeyEvent.VK_2;
            } else if (code.equals("3")) {
                mainKey = KeyEvent.VK_3;
            } else if (code.equals("4")) {
                mainKey = KeyEvent.VK_4;
            } else if (code.equals("5")) {
                mainKey = KeyEvent.VK_5;
            } else if (code.equals("6")) {
                mainKey = KeyEvent.VK_6;
            } else if (code.equals("7")) {
                mainKey = KeyEvent.VK_7;
            } else if (code.equals("8")) {
                mainKey = KeyEvent.VK_8;
            } else if (code.equals("9")) {
                mainKey = KeyEvent.VK_9;

                //num digits
            } else if (code.equals("num0")) {
                mainKey = KeyEvent.VK_NUMPAD0;
            } else if (code.equals("num1")) {
                mainKey = KeyEvent.VK_NUMPAD1;
            } else if (code.equals("num2")) {
                mainKey = KeyEvent.VK_NUMPAD2;
            } else if (code.equals("num3")) {
                mainKey = KeyEvent.VK_NUMPAD3;
            } else if (code.equals("num4")) {
                mainKey = KeyEvent.VK_NUMPAD4;
            } else if (code.equals("num5")) {
                mainKey = KeyEvent.VK_NUMPAD5;
            } else if (code.equals("num6")) {
                mainKey = KeyEvent.VK_NUMPAD6;
            } else if (code.equals("num7")) {
                mainKey = KeyEvent.VK_NUMPAD7;
            } else if (code.equals("num8")) {
                mainKey = KeyEvent.VK_NUMPAD8;
            } else if (code.equals("num9")) {
                mainKey = KeyEvent.VK_NUMPAD9;

                //letters
            } else if (code.equals("R")) {
                mainKey = KeyEvent.VK_R;

                //function
            } else if (code.equals("F9")) {
                mainKey = KeyEvent.VK_F9;

                //else
            } else if (code.equals(".")) {
                mainKey = KeyEvent.VK_PERIOD;
            } else if (code.equals("<")) {
                mainKey = KeyEvent.VK_BACK_SPACE;
            } else if (code.equals("num+")) {
                mainKey = KeyEvent.VK_ADD;
            } else if (code.equals("-")) {
                mainKey = KeyEvent.VK_MINUS;
            } else if (code.equals("num-")) {
                mainKey = KeyEvent.VK_SUBTRACT;
            } else if (code.equals("num*")) {
                mainKey = KeyEvent.VK_MULTIPLY;
            } else if (code.equals("/")) {
                mainKey = KeyEvent.VK_SLASH;
            } else if (code.equals("num/")) {
                mainKey = KeyEvent.VK_DIVIDE;
            } else if (code.equals("=")) {
                mainKey = KeyEvent.VK_EQUALS;
            } else if (code.equals("enter")) {
                mainKey = KeyEvent.VK_ENTER;
            } else if (code.equals("del")) {
                mainKey = KeyEvent.VK_DELETE;
            } else if (code.equals("esc")) {
                mainKey = KeyEvent.VK_ESCAPE;
            } else {
                throw new IllegalArgumentException("Expected: string with correct keypad representation only. \n" +
                        "Got: " + code);
            }

            if (additionalKey != 0) {
                awtRobot.keyPress(additionalKey);
            }

            awtRobot.keyPress(mainKey);

            if (additionalKey != 0) {
                awtRobot.keyRelease(additionalKey);
            }

            awtRobot.keyRelease(mainKey);

            FXTestUtils.awaitEvents();
        }
    }

    /**
     * Moves cursor to the center of node using robot and performs mouse click operation.
     *
     * @param node node where cursor should be moved.
     */
    protected void clickOn(Node node) {
        hoverOn(node);
        click(MouseButton.PRIMARY);

        FXTestUtils.awaitEvents();
    }

    /**
     * Moves cursor to the center of node using robot.
     *
     * @param node node where cursor should be moved.
     */
    protected void hoverOn(Node node) {
        Bounds bounds = node.localToScreen(node.getBoundsInLocal());

        int centerX = (int) ((bounds.getMinX() + bounds.getMaxX()) / 2);
        int centerY = (int) ((bounds.getMinY() + bounds.getMaxY()) / 2);

        awtRobot.mouseMove(centerX, centerY);

        FXTestUtils.awaitEvents();
    }

    /**
     * Moves cursor to required location and drags it to another location.
     *
     * @param fromX coordinate X to move cursor firstly.
     * @param fromY coordinate Y to move cursor firstly.
     * @param toX   coordinate X to drag cursor.
     * @param toY   coordinate Y to drag cursor.
     */
    protected void dragFromTo(double fromX, double fromY, double toX, double toY) {
        robot.moveTo(fromX, fromY);
        robot.press(MouseButton.PRIMARY);
        robot.moveTo(toX, toY);
        robot.release(MouseButton.PRIMARY);

        FXTestUtils.awaitEvents();
    }

    /**
     * Sets window's size and layout to required.
     *
     * @param width  width to set.
     * @param height height to set.
     * @param x      coordinate X to set.
     * @param y      coordinate Y to set.
     */
    protected void setWindowsSizeAndLayout(double width, double height, double x, double y) {
        Window window = getWindowByIndex(0);

        window.setWidth(width);
        window.setHeight(height);
        window.setX(x);
        window.setY(y);
    }

    /**
     * Enables or disables node.
     *
     * @param selector id or text of node.
     * @param flag     flag for setting up disability.
     */
    protected void setNodeDisabled(String selector, boolean flag) {
        Node control = getNodeBySelector(selector);
        control.setDisable(flag);
    }

    /**
     * Makes node visible or invisible.
     *
     * @param selector id of node.
     * @param flag     flag for setting visibility.
     */
    protected void setNodeVisible(String selector, boolean flag) {
        Node control = getNodeBySelector(selector);
        control.setVisible(flag);
    }
}
