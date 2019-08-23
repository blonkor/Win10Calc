package view.tests;

import javafx.geometry.Bounds;
import javafx.geometry.VerticalDirection;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import org.testfx.api.FxRobot;
import view.util.MainTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for testing view.
 *
 * @author Mykhailo Bormashenko
 */
public class ViewTest extends GuiTest {

    private static final double TWO = 2.0;

    /**
     * Robot for automatically control.
     */
    private FxRobot robot = new FxRobot();

    @Test
    public void checkColorTests() {
        //digits
        checkButtonColor(".digits", new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"},
                "0xfafafaff", "0x333333ff",
                new Font("Segoe UI Semibold", 22.5),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI Semibold", 22.5));

        //standard operations
        checkButtonColor(".blue_hover", new String[]{"\uE94A", "\uE947", "\uE949", "\uE948", "\uE94E"}, //divide, multiply, subtract, add, equals
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 14.5),
                "0x0078d7ff", "0xffffffff",
                new Font("Segoe MDL2 Assets", 14.5));

        //special operations
        checkButtonColor(".font_assets", new String[]{"\uE94D", "\uE94C", "\uE94B"}, //negate, percent, sqrt
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 14.5),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 14.5));

        //degree operations
        checkButtonColor(".operations_degree", new String[]{"\uD835\uDC65²", "⅟\uD835\uDC65"}, //sqr, inverse
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe UI", 20),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI", 20));

        //clear operations
        checkButtonColor(".font_segoe_ui", new String[]{"CE", "C"},
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe UI", 14.5),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI", 14.5));

        //dot
        checkButtonColor(".dot", new String[]{"#dot"},
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe UI Black", 16),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI Black", 16));

        //backspace
        checkButtonColor(".backspace", new String[]{"\uE94F"},
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 16),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 16));

        //memory
        checkButtonColor(".memory", new String[]{"MC", "MR", "M+", "M-", "MS", "M"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI Semibold", 12),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI Semibold", 12));

        setNodeDisabled(".memory", "MC", false);
        setNodeDisabled(".memory", "MR", false);

        checkButtonColor(".memory", new String[]{"MC", "MR"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI Semibold", 12),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI Semibold", 12));

        setNodeDisabled(".memory", "MC", true);
        setNodeDisabled(".memory", "MR", true);

        setNodeDisabled(".memory", "M", false);

        checkButtonColor(".memory", new String[]{"M"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI Semibold", 12),
                "0xd0d0d0ff", "0x333333ff",
                new Font("Segoe UI Semibold", 12));

        setNodeDisabled(".memory", "M", true);

        //navigation
        checkButtonColor(".font_assets", new String[]{"\uE700"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 16),
                "0xd0d0d0ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 16));

        //history
        checkButtonColor(".font_assets", new String[]{"\uE81C"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 16),
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 16));

        //minimize and expand
        checkButtonColor(".window", new String[]{"\uE921", "\uE922"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 10),
                "0xd0d0d0ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 10));

        //close
        checkButtonColor(".window_close", new String[]{"\uE8BB"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 10),
                "0xe9091eff", "0xffffffff",
                new Font("Segoe MDL2 Assets", 10));

        setNodeVisible(".scroll_pane_navigation", "#navigationPanel", true);
        setNodeVisible(".gray_background", "#about", true);
        setNodeVisible("", "#navigationBlock", true);

        checkButtonColor(".navigation_buttons", new String[]{"Standard", "Scientific", "Programmer", "Date Calculation",
                        "Currency", "Volume", "Length"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI", 15),
                "0xd0d0d0ff", "0x333333ff",
                new Font("Segoe UI", 15));

        robot.scroll(15, VerticalDirection.DOWN);

        checkButtonColor(".navigation_buttons", new String[]{"Weight and Mass", "Temperature", "Energy", "Area",
                        "Speed", "Time", "Power", "Data"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI", 15),
                "0xd0d0d0ff", "0x333333ff",
                new Font("Segoe UI", 15));

        robot.scroll(5, VerticalDirection.DOWN);

        checkButtonColor(".navigation_buttons", new String[]{"Pressure", "Angle", "About"},
                "0xe6e6e6ff", "0x333333ff",
                new Font("Segoe UI", 15),
                "0xd0d0d0ff", "0x333333ff",
                new Font("Segoe UI", 15));

        checkButtonColor(".blue_hover", new String[]{"\uE94A", "\uE947", "\uE949", "\uE948", "\uE94E"}, //divide, multiply, subtract, add, equals
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 14.5),
                "0xf0f0f0ff", "0x333333ff",
                new Font("Segoe MDL2 Assets", 14.5));

        setNodeVisible(".scroll_pane_navigation", "#navigationPanel", false);
        setNodeVisible(".gray_background", "#about", false);
        setNodeVisible("", "#navigationBlock", false);
    }

    /**
     * Checks that button have required color, required text color, required font, and the same information
     * while the button is hovered.
     *
     * @param from                     string name of styleclass to which buttons belong. If it is empty,
     *                                 searching buttons with selector only.
     * @param selectors                array where every element is text on different buttons or button's selector.
     * @param expectedColor            background color that should be set for every button in array.
     * @param expectedTextColor        text color that should be set for every button in array.
     * @param expectedFont             font that should be set for every button in array.
     * @param expectedColorOnHover     background color that should be set for
     *                                 every button in array while button is hovered.
     * @param expectedTextColorOnHover text color that should be set for every button in array while button is hovered.
     * @param expectedFontOnHover      font that should be set for every button in array while button is hovered.
     */
    private void checkButtonColor(String from, String[] selectors,
                                  String expectedColor, String expectedTextColor,
                                  Font expectedFont,
                                  String expectedColorOnHover, String expectedTextColorOnHover,
                                  Font expectedFontOnHover) {

        for (String selector : selectors) {
            Button control = getButtonBySelector(from, selector);

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
     * Moves cursor to the middle of node using robot.
     *
     * @param node node from view where cursor should be moved.
     */
    private void hoverOn(Node node) {
        Bounds bounds = node.localToScreen(node.getBoundsInLocal());

        double centerX = (bounds.getMinX() + bounds.getMaxX()) / TWO;
        double centerY = (bounds.getMinY() + bounds.getMaxY()) / TWO;

        robot.moveTo(centerX, centerY);

        FXTestUtils.awaitEvents();
    }

    /**
     * Enables or disables node.
     *
     * @param from     string name of styleclass to which buttons belong. If it is empty,
     *                 searching buttons with selector only.
     * @param selector id of node.
     */
    private void setNodeDisabled(String from, String selector, boolean flag) {
        Node control = getNodeBySelector(from, selector);
        control.setDisable(flag);
    }

    /**
     * Makes node visible or invisible.
     *
     * @param from     string name of styleclass to which buttons belong. If it is empty,
     *                 searching buttons with selector only.
     * @param selector id of node.
     */
    private void setNodeVisible(String from, String selector, boolean flag) {
        Node control = getNodeBySelector(from, selector);
        control.setVisible(flag);
    }

    /**
     * Looks up for node by styleclass and selector.
     *
     * @param from     string name of styleclass to which node belongs. If it is empty,
     *                 searching node with selector only.
     * @param selector id of node.
     * @return node.
     */
    private Node getNodeBySelector(String from, String selector) {
        Node control;

        if (from.isEmpty()) {
            control = robot.lookup(selector).query();
        } else {
            control = robot.from(robot.lookup(from).queryAll()).lookup(selector).query();
        }

        return control;
    }

    /**
     * Looks up for button by styleclass and selector.
     *
     * @param from     string name of styleclass to which button belongs. If it is empty,
     *                 searching button with selector only.
     * @param selector id of button.
     * @return button.
     */
    private Button getButtonBySelector(String from, String selector) {
        Button control;

        if (from.isEmpty()) {
            control = robot.lookup(selector).queryButton();
        } else {
            control = robot.from(robot.lookup(from).queryAll()).lookup(selector).queryButton();
        }

        return control;
    }


    @Override
    public void setupStage() {
        FXTestUtils.launchApp(MainTest.class, "");

        try {
            stage = targetWindow(MainTest.getStageFuture().get(25, TimeUnit.SECONDS));
            FXTestUtils.bringToFront(stage);
        } catch (Exception e) {
            throw new RuntimeException("Unable to show stage", e);
        }
    }

    @Override
    protected Parent getRootNode() {
        if (stage == null) {
            setupStage();
        }

        return stage.getScene().getRoot();
    }
}
