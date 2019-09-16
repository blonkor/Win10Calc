package tests.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import org.junit.Test;
import util.RobotControl;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link com.implemica.bormashenko.calculator.controller.Controller}.
 *
 * @author Mykhailo Bormashenko
 */
public class ControllerTest extends RobotControl {

    /**
     * Keypad button for firing clear all {@code Button}.
     */
    private static final String KEY_C = "esc";

    /**
     * Keypad button for firing clear text {@code Button}.
     */
    private static final String KEY_CE = "del";

    /**
     * Keypad combination for firing memory store {@code Button}.
     */
    private static final String KEY_MS = "ctrl+M ";

    /**
     * Keypad combination for firing memory clear {@code Button}.
     */
    private static final String KEY_MC = "ctrl+L ";

    /**
     * Keypad combination for firing memory recall {@code Button}.
     */
    private static final String KEY_MR = "ctrl+R ";

    /**
     * Keypad combination for firing memory add {@code Button}.
     */
    private static final String KEY_M_ADD = "ctrl+P ";

    /**
     * Keypad combination for firing memory subtract {@code Button}.
     */
    private static final String KEY_M_SUBTRACT = "ctrl+Q ";

    /**
     * Keypad combination for firing add {@code Button}.
     */
    private static final String KEY_ADD = "shift+= ";

    /**
     * Keypad combination for firing multiply {@code Button}.
     */
    private static final String KEY_MULTIPLY = "shift+8 ";

    /**
     * Keypad button for firing negate {@code Button}.
     */
    private static final String KEY_NEG = "F9 ";

    /**
     * Keypad button for firing inverse {@code Button}.
     */
    private static final String KEY_INVERSE = "R ";

    /**
     * Keypad combination for firing sqrt {@code Button}.
     */
    private static final String KEY_SQRT = "shift+2 ";

    /**
     * Keypad combination for firing percent {@code Button}.
     */
    private static final String KEY_PERCENT = "shift+5 ";

    /**
     * Symbol that should be replaced in equation {@code Label}.
     */
    private static final String SPACE = " ";

    /**
     * Symbol for separation numbers and operations in equation {@code Label} that should replace spaces in tests.
     */
    private static final String NARROW_SPACE = "\u2009";

    /**
     * Constructor needed to extend {@link RobotControl}
     *
     * @throws AWTException signals that an Abstract Window Toolkit exception has occurred.
     */
    public ControllerTest() throws AWTException {
        //nothing to construct
    }

    /**
     * Runs all tests
     */
    @Test
    public void allTests() {
        showNavigationPanelTest();
        moveEquationLabelTextTest();

        memoryStoreTest();
        memoryShowTest();
        memoryClearTest();
        memoryRecallTests();
        memoryAddTests();
        memorySubtractTests();

        appendDigitTests();
        appendDotTests();
        backspaceTests();
        clearTests();

        addTests();
        subtractTests();
        multiplyTests();
        divideTests();

        negateTests();
        sqrTests();
        sqrtTests(); //24min
        inverseTests();

        percentageTests();
        equalsTests();

        exceptionTests();
    }

    /**
     * Tests for showing navigation panel.
     */
    @Test
    public void showNavigationPanelTest() {
        assertEquals(0, getNodeBySelector(NAVIGATION_PANEL_ID).getTranslateX());
        assertEquals(0, getNodeBySelector(ABOUT_PANEL_ID).getTranslateX());
        assertFalse(getNodeBySelector(NAVIGATION_BLOCK_ID).isVisible());

        clickOn(getButtonBySelector(NAVIGATION_ID));

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(256, getNodeBySelector(NAVIGATION_PANEL_ID).getTranslateX());
        assertEquals(257, getNodeBySelector(ABOUT_PANEL_ID).getTranslateX());
        assertTrue(getNodeBySelector(NAVIGATION_BLOCK_ID).isVisible());

        clickOn(getButtonBySelector(NAVIGATION_ID));

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(0, getNodeBySelector(NAVIGATION_PANEL_ID).getTranslateX());
        assertEquals(0, getNodeBySelector(ABOUT_PANEL_ID).getTranslateX());
        assertFalse(getNodeBySelector(NAVIGATION_BLOCK_ID).isVisible());
    }

    /**
     * Tests for moving text in equation {@code Label}.
     */
    @Test
    public void moveEquationLabelTextTest() {
        resetAll();

        pressKeyboard(KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT +
                KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT);

        ScrollPane equationScroll = (ScrollPane) getNodeBySelector(EQUATION_SCROLL_ID);
        assertEquals(equationScroll.getHmin(), equationScroll.getHvalue());

        Button leftArrow = getButtonBySelector(LEFT_ARROW_ID);
        Button rightArrow = getButtonBySelector(RIGHT_ARROW_ID);

        clickOn(leftArrow);

        assertTrue(rightArrow.isVisible());
        assertFalse(leftArrow.isVisible());
        assertEquals(equationScroll.getHmax(), equationScroll.getHvalue());

        clickOn(rightArrow);

        assertTrue(leftArrow.isVisible());
        assertFalse(rightArrow.isVisible());
        assertEquals(equationScroll.getHmin(), equationScroll.getHvalue());

        pressKeyboard(KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT +
                KEY_SQRT + KEY_SQRT);

        clickOn(leftArrow);

        assertTrue(rightArrow.isVisible());
        assertTrue(leftArrow.isVisible());

        double expectedHValueLeft = 0.56;
        assertEquals(expectedHValueLeft, equationScroll.getHvalue());

        clickOn(leftArrow);

        assertTrue(rightArrow.isVisible());
        assertFalse(leftArrow.isVisible());
        assertEquals(equationScroll.getHmax(), equationScroll.getHvalue());

        clickOn(rightArrow);

        assertTrue(leftArrow.isVisible());
        assertTrue(rightArrow.isVisible());

        double expectedHValueRight = 1 - expectedHValueLeft;
        assertEquals(expectedHValueRight, equationScroll.getHvalue());

        clickOn(rightArrow);

        assertTrue(leftArrow.isVisible());
        assertFalse(rightArrow.isVisible());
        assertEquals(equationScroll.getHmin(), equationScroll.getHvalue());
    }

    /**
     * Tests for memory store operation.
     */
    @Test
    public void memoryStoreTest() {
        resetAll();

        pressKeyboard(KEY_MS);

        assertFalse(getButtonBySelector(MEMORY_CLEAR_ID).isDisabled());
        assertFalse(getButtonBySelector(MEMORY_RECALL_ID).isDisabled());
        assertFalse(getButtonBySelector(MEMORY_SHOW_ID).isDisabled());
    }

    /**
     * Test for memory show operation.
     */
    @Test
    public void memoryShowTest() {
        resetAll();

        int memoryLabelsLayout = 16;
        int memoryLabelsHeight = 63;
        int memoryLabelsFontSize = 24;
        Insets memoryLabelInsets = new Insets(0, 15, 0, 15);

        pressKeyboard("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_MS);
        clickOn(getButtonBySelector(MEMORY_SHOW_ID));
        int numberOfLabels = 3;

        AnchorPane memoryPanel = (AnchorPane) getNodeBySelector(MEMORY_PANEL_ID);
        AnchorPane memoryBlock = (AnchorPane) getNodeBySelector(MEMORY_BLOCK_ID);

        assertTrue(memoryPanel.isVisible());
        assertTrue(memoryBlock.isVisible());

        int layoutY = memoryLabelsLayout;

        for (int i = 0; i < numberOfLabels; i++) {
            ScrollPane scrollPane = (ScrollPane) memoryPanel.getChildren().get(0);
            AnchorPane anchorPane = (AnchorPane) scrollPane.getContent();
            Label label = (Label) anchorPane.getChildren().get(i);

            assertEquals(String.valueOf(numberOfLabels - i), label.getText());
            assertEquals(memoryPanel.getWidth() - 2, label.getPrefWidth());
            assertEquals(memoryLabelsHeight, label.getPrefHeight());
            assertEquals(memoryLabelsHeight, label.getMinHeight());
            assertEquals(memoryLabelsHeight, label.getMaxHeight());
            assertEquals(memoryLabelInsets, label.getPadding());
            assertEquals(layoutY, label.getLayoutY());
            assertEquals(Paint.valueOf("transparent"), label.getBackground().getFills().get(0).getFill());
            assertEquals(new Font("Segoe UI Semibold", memoryLabelsFontSize), label.getFont());
            assertTrue(label.isWrapText());

            hoverOn(label);

            assertEquals(Paint.valueOf("0xe7e7e7ff"), label.getBackground().getFills().get(0).getFill());
            assertEquals(new Font("Segoe UI Semibold", memoryLabelsFontSize), label.getFont());

            hoverOn(getButtonBySelector(MEMORY_SHOW_ID));

            assertEquals(Paint.valueOf("transparent"), label.getBackground().getFills().get(0).getFill());
            assertEquals(new Font("Segoe UI Semibold", memoryLabelsFontSize), label.getFont());

            assertEquals(Pos.TOP_LEFT, label.getAlignment());

            layoutY += memoryLabelsHeight + memoryLabelsLayout;
        }

        clickOn(getButtonBySelector(MEMORY_SHOW_ID));

        assertFalse(memoryPanel.isVisible());
        assertFalse(memoryBlock.isVisible());
    }

    /**
     * Test for memory clear operation.
     */
    @Test
    public void memoryClearTest() {
        resetAll();

        pressKeyboard("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_MS + KEY_MC);

        assertTrue(getButtonBySelector(MEMORY_CLEAR_ID).isDisabled());
        assertTrue(getButtonBySelector(MEMORY_RECALL_ID).isDisabled());
        assertTrue(getButtonBySelector(MEMORY_SHOW_ID).isDisabled());
    }

    /**
     * Tests for memory recall operation.
     */
    @Test
    public void memoryRecallTests() {
        checkTyped("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_MS + KEY_MR,
                "3");
        checkTyped("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_MR, "2");
        checkTyped(KEY_MS + "1 0 0 " + KEY_MR, "0");
    }

    /**
     * Tests for memory add operation.
     */
    @Test
    public void memoryAddTests() {
        checkTyped("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_MS + KEY_M_ADD + KEY_MR, "6");
        checkTyped("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_M_ADD + KEY_MR, "5");
        checkTyped(KEY_MS + "1 0 0 " + KEY_ADD + KEY_M_ADD + KEY_MR, "100");

        checkTyped("8 " + KEY_M_ADD + KEY_MR, "8");
        checkTyped("1 " + KEY_NEG + "2 8 " + KEY_M_ADD + KEY_MR, "-128");
    }

    /**
     * Tests for memory subtract operation.
     */
    @Test
    public void memorySubtractTests() {
        checkTyped("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_MS + KEY_M_SUBTRACT +
                KEY_MR, "0");
        checkTyped("1 " + KEY_MS + "2 " + KEY_MS + "3 " + KEY_M_SUBTRACT + KEY_MR, "-1");
        checkTyped(KEY_MS + "1 0 0 " + KEY_ADD + KEY_M_SUBTRACT + KEY_MR, "-100");

        checkTyped("8 " + KEY_M_SUBTRACT + KEY_MR, "-8");
        checkTyped("1 " + KEY_NEG + "2 8 " + KEY_M_SUBTRACT + KEY_MR, "128");
    }

    /**
     * Tests for appending digits.
     */
    @Test
    public void appendDigitTests() {
        //can append
        //without operations
        checkTyped("1", "1");
        checkTyped("2", "2");
        checkTyped("7 3 6", "736");
        checkTyped("4 8 9 0", "4,890");
        checkTyped("3 2 5 9 0 0 0 2 3 4 0 0 0 0 2 3",
                "3,259,000,234,000,023");

        //after negate
        checkTyped("8 " + KEY_NEG + "9 6", "-896");
        checkTyped("7 " + KEY_NEG + "8 9 0 6 3 5 7 8 9 0 0 0 0 0 0",
                "-7,890,635,789,000,000");

        //after dot
        checkTyped("7 2 5 5 . 3 4", "7,255.34");

        //after dot with 16 digits summary
        checkTyped("1 2 3 0 1 9 . 8 4 9 8 5 3 3 5 6 4",
                "123,019.8498533564");

        //after dot with 17 digits summary ( starts with 0. )
        checkTyped("0 . 1 2 2 3 4 5 8 9 0 1 2 4 5 6 7 8",
                "0.1223458901245678");

        //after dot and negate
        checkTyped("7 " + KEY_NEG + "2 5 . 7 2",
                "-725.72");

        //after dot with 16 digits summary and negate
        checkTyped("1 2 3 6 5 7 . 2 9 5 8 2 " + KEY_NEG + "0 0 2 5 6",
                "-123,657.2958200256");

        //after dot with 17 digits summary ( starts with 0. ) and negate
        checkTyped("0 . 8 5 2 9 8 " + KEY_NEG + "2 3 5 4 6 7 3 6 7 6 5",
                "-0.8529823546736765");

        //after backspace
        checkTyped("8 backspace 3 2", "32");

        //after unary operation pressed
        checkTyped("9 " + KEY_SQRT + "8 2 5", "825");
        checkTyped("2 2 " + KEY_INVERSE + "7", "7");

        //after binary operation pressed
        checkTyped("9 - 2", "2");
        checkTyped("1 2 / 1 ", "1");

        //after percent pressed
        checkTyped("6 " + KEY_PERCENT + "2", "2");
        checkTyped("1 - " + KEY_PERCENT + "9 0", "90");

        //after equals pressed
        checkTyped("1 3 = 1 3 1", "131");
        checkTyped("7 6 - 1 4 = 1 3", "13");

        //after error
        checkTyped("/ 0 = 3", "3");


        //can not append
        checkTyped("0 0", "0");

        //17 digits
        checkTyped("1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7",
                "1,234,567,890,123,456");

        //more than 17 digits
        checkTyped("2 1 9 8 3 7 0 9 1 9 0 8 0 5 1 8 3 2 5",
                "2,198,370,919,080,518");

        //17 and negate
        checkTyped("1 2 3 4 5 6 7 8 9 " + KEY_NEG + "0 1 2 3 4 5 6 7",
                "-1,234,567,890,123,456");

        //more than 17 and negate
        checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 " + KEY_NEG + "8 0 1 2 8 5 0 ",
                "-1,209,847,102,458,012");

        //17 and dot
        checkTyped("1 2 3 4 5 6 7 8 9 . 0 1 2 3 4 5 6 7",
                "123,456,789.0123456");

        //more than 17 and dot
        checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 . 8 0 1 2 7 3 0",
                "120,984,710,245.8012");

        //17 and dot and negate
        checkTyped("1 2 3 4 5 6 " + KEY_NEG + "7 8 9 . 0 1 2 3 4 5 6 7",
                "-123,456,789.0123456");

        //more than 17 and dot and negate
        checkTyped("2 1 9 . 8 3 7 " + KEY_NEG + "0 9 1 9 0 8 0 5 1 8 3 2",
                "-219.8370919080518");

        //18 and dot and starts with 0.
        checkTyped("0 . 7 4 3 6 3 7 3 8 7 3 6 3 6 3 6 3 6",
                "0.7436373873636363");

        //more than 18 and dot and starts with 0.
        checkTyped("0 . 3 2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 8 6 8",
                "0.3242384729375982");

        //18 and dot and starts with 0. and negate
        checkTyped("0 . 8 7 5 2 3 4 5 " + KEY_NEG + "6 8 9 0 0 7 6 3 4 5",
                "-0.8752345689007634");

        //more than 18 and dot and starts with 0. and negate
        checkTyped("0 . 3 " + KEY_NEG + "2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 7 6 0",
                "-0.3242384729375982");
    }

    /**
     * Tests for appending dot.
     */
    @Test
    public void appendDotTests() {
        //can append
        //without operations
        checkTyped("1 .", "1.");
        checkTyped("2 .", "2.");
        checkTyped("1 1 1 .", "111.");
        checkTyped("4 8 9 0 .", "4,890.");
        checkTyped("5 8 9 3 1 2 7 5 9 2 3 7 5 9 2 2 .",
                "5,893,127,592,375,922.");

        //17 digits
        checkTyped("1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 8 .",
                "1,234,567,890,123,456.");

        //more than 17 digits
        checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 8 0 1 2 4 0 9 .",
                "1,209,847,102,458,012.");

        //17 and negate
        checkTyped("8 7 9 8 4 " + KEY_NEG + "7 1 9 5 7 1 9 8 7 5 9 1 .",
                "-8,798,471,957,198,759.");

        //more than 17 and negate
        checkTyped("2 1 9 " + KEY_NEG + "8 3 7 0 9 1 9 0 8 0 5 1 8 0 5 1 .",
                "-2,198,370,919,080,518.");

        //with negated number
        checkTyped("1 " + KEY_NEG + ".", "-1.");
        checkTyped("6 1 2 3 7 " + KEY_NEG + ".", "-61,237.");

        //16 digits
        checkTyped("6 " + KEY_NEG + "2 3 5 4 8 3 4 6 3 4 6 8 3 4 5 .",
                "-6,235,483,463,468,345.");

        //after unary operation pressed
        checkTyped("9 5 3 " + KEY_SQRT + ".", "0.");
        checkTyped("7 1 " + KEY_INVERSE + ".", "0.");

        //after binary operations
        checkTyped("3 2 5 4 - .", "0.");
        checkTyped("2 4 / .", "0.");

        //after percent
        checkTyped("1 4 " + KEY_PERCENT + ".", "0.");
        checkTyped("5 - " + KEY_PERCENT + ".", "0.");

        //after equals
        checkTyped("1 5 = .", "0.");
        checkTyped("7 - 1 2 = .", "0.");

        //after backspace
        checkTyped("1 2 1 3 5 backspace .", "1,213.");
        checkTyped("2 1 backspace .", "2.");

        //can not append
        //17 and dot
        checkTyped("1 2 3 4 5 6 7 8 9 . 0 1 2 3 4 5 6 7 .",
                "123,456,789.0123456");

        //more than 17 and dot
        checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 . 8 0 1 2 0 9 2 .",
                "120,984,710,245.8012");

        //17 and dot and negate
        checkTyped("1 2 3 4 5 6 " + KEY_NEG + "7 8 9 . 0 1 2 3 4 5 6 7 .",
                "-123,456,789.0123456");

        //more than 17 and dot and negate
        checkTyped("1 2 0 " + KEY_NEG + "9 8 4 7 1 0 2 4 5 . 8 0 1 2 0 9 2 .",
                "-120,984,710,245.8012");

        //18 and dot and starts with 0.
        checkTyped("0 . 7 4 3 6 3 7 3 8 7 3 6 3 6 3 6 3 6 .",
                "0.7436373873636363");

        //more than 18 and dot and starts with 0.
        checkTyped("0 . 3 2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 8 6 .",
                "0.3242384729375982");

        //18 and dot and starts with 0. and negate
        checkTyped("0 . 7 4 " + KEY_NEG + "3 6 3 7 3 8 7 3 6 3 6 3 6 3 6 .",
                "-0.7436373873636363");

        //more than 18 and dot and starts with 0. and negate
        checkTyped("0 . 3 " + KEY_NEG + "2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 8 6 .",
                "-0.3242384729375982");

        //already with dot
        checkTyped("1 4 1 4 . 1 . 2 . .", "1,414.12");
        checkTyped("8 7 6 4 . . . .", "8,764.");
    }

    /**
     * Tests for backspace.
     */
    @Test
    public void backspaceTests() {
        checkTyped("0 backspace", "0");
        checkTyped("1 backspace", "0");
        checkTyped("9 backspace", "0");
        checkTyped("2 1 3 backspace", "21");
        checkTyped("1 4 1 5 backspace", "141");
        checkTyped("1 4 5 1 3 5 1 5 backspace", "1,451,351");

        //after dot
        checkTyped("1 4 2 1 4 . backspace", "14,214");

        //after negate
        checkTyped("6 5 6 3 2 5 2 " + KEY_NEG + "backspace",
                "-656,325");

        //after unary operation
        checkTyped("9 0 0 " + KEY_SQRT + "backspace", "30");
        checkTyped("8 " + KEY_INVERSE + "backspace", "0.125");

        //after binary operation
        checkTyped("1 4 - backspace", "14");
        checkTyped("5 2 3 / backspace", "523");

        //after percent
        checkTyped("1 4 " + KEY_PERCENT + "backspace", "0");
        checkTyped("1 4 - " + KEY_PERCENT + "backspace", "1.96");

        //after equals
        checkTyped("5 1 = backspace", "51");
        checkTyped("4 0 0 1 - 1 = backspace", "4,000");

        //after error
        checkTyped("/ 0 = backspace", "0");

        //several in a row
        checkTyped("1 2 3 backspace backspace backspace", "0");
        checkTyped("2 1 5 2 3 4 3 backspace backspace", "21,523");
    }

    /**
     * Tests for clear operations (clear text and clear all).
     */
    @Test
    public void clearTests() {
        //without operations
        checkClear("1");
        checkClear("2");
        checkClear("1 2 3");
        checkClear("1 2 1 5");
        checkClear("1 . 2 3");

        //unary
        checkClear("1 2 3 " + KEY_NEG);
        checkClear("1 2 3 1 " + KEY_SQRT);
        checkClear("3 8 " + KEY_INVERSE);

        //binary
        checkClear("5 1 -");
        checkClear("1 8 1 6 / ");

        //percent
        checkClear("1 2 " + KEY_PERCENT);
        checkClear("1 2 2 - " + KEY_PERCENT);

        //equals
        checkClear("1 2 =");
        checkClear("1 - 3 =");

        //backspace
        checkClear("1 2 3 backspace");

        //after error
        resetAll();
        pressKeyboard("/ 0 =");
        pressKeyboard(KEY_CE);
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        resetAll();
        pressKeyboard("/ 0 =");
        pressKeyboard(KEY_C);
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for add operation.
     */
    @Test
    public void addTests() {
        //standard cases
        checkTyped("0 " + KEY_ADD, "0", "0 +");
        checkTyped("1 " + KEY_ADD, "1", "1 +");
        checkTyped("2 5 6 " + KEY_ADD, "256", "256 +");
        checkTyped("1 1 5 5 " + KEY_ADD, "1,155", "1155 +");

        //several operations
        checkTyped("1 " + KEY_ADD + "2 " + KEY_ADD + "3 " + KEY_ADD, "6",
                "1 + 2 + 3 +");
        checkTyped("1 0 0 " + KEY_ADD + "1 0 0 0 " + KEY_ADD + "1 0 0 0 0 " + KEY_ADD + "1 0 0 0 0 0 " +
                        KEY_ADD,
                "111,100", "100 + 1000 + 10000 + 100000 +");

        //after dot
        checkTyped("6 2 . " + KEY_ADD, "62", "62 +");
        checkTyped("6 2 3 6 2 6 . " + KEY_ADD, "623,626", "623626 +");

        //after negate
        checkTyped("8 6 6 " + KEY_NEG + KEY_ADD, "-866", "-866 +");
        checkTyped("9 8 7 9 1 4 8 0 " + KEY_NEG + KEY_ADD, "-98,791,480",
                "-98791480 +");

        //after another unary
        checkTyped("8 sqr " + KEY_ADD, "64", "sqr( 8 ) +");

        checkTyped("3 6 0 0 0 0 0 0 0 0 " + KEY_SQRT + KEY_ADD, "60,000",
                "√( 3600000000 ) +");
        checkTyped("1 " + KEY_INVERSE + KEY_ADD, "1", "1/( 1 ) +");

        //in a row
        checkTyped("5 5 " + KEY_ADD + KEY_ADD, "55", "55 +");
        checkTyped("1 5 6 7 " + KEY_ADD + KEY_ADD + KEY_ADD, "1,567",
                "1567 +");

        //after another binary
        checkTyped("1 6 - " + KEY_ADD, "16", "16 +");
        checkTyped("5 6 4 " + KEY_MULTIPLY + KEY_ADD, "564", "564 +");
        checkTyped("3 4 4 3 6 3 / " + KEY_ADD, "344,363", "344363 +");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + KEY_ADD, "0", "0 +");
        checkTyped("5 6 2 - " + KEY_PERCENT + KEY_ADD, "-2,596.44",
                "562 - 3158.44 +");

        //after equals
        checkTyped("7 3 = " + KEY_ADD, "73", "73 +");
        checkTyped("5 3 - 1 2 = " + KEY_ADD, "41", "41 +");

        //engineers
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_ADD + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_ADD,
                "1.e+16", "9000000000000000 + 1000000000000000 +");
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_ADD + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_ADD +
                        "1 " + KEY_ADD,
                "1.e+16", "9000000000000000 + 1000000000000000 + 1 +");
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_ADD + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_ADD +
                        "6 " + KEY_ADD,
                "1.000000000000001e+16",
                "9000000000000000 + 1000000000000000 + 6 +");
        checkTyped("9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 " + KEY_ADD + "9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 " + KEY_ADD,
                "2.e+16", "9999999999999999 + 9999999999999999 +");
    }

    /**
     * Tests for subtract operation.
     */
    @Test
    public void subtractTests() {
        //standard cases
        checkTyped("0 -", "0", "0 -");
        checkTyped("1 -", "1", "1 -");
        checkTyped("2 5 6 -", "256", "256 -");
        checkTyped("1 1 5 5 -", "1,155", "1155 -");

        //several operations
        checkTyped("1 - 2 - 3 -", "-4", "1 - 2 - 3 -");
        checkTyped("1 0 0 - 1 0 0 0 - 1 0 0 0 0 - 1 0 0 0 0 0 -", "-110,900",
                "100 - 1000 - 10000 - 100000 -");

        //after dot
        checkTyped("6 2 . -", "62", "62 -");
        checkTyped("6 2 3 6 2 6 . -", "623,626", "623626 -");

        //after negate
        checkTyped("8 6 6 " + KEY_NEG + "-", "-866", "-866 -");
        checkTyped("9 8 7 9 1 4 8 0 " + KEY_NEG + "-", "-98,791,480",
                "-98791480 -");

        //after another unary
        checkTyped("8 sqr -", "64", "sqr( 8 ) -");
        checkTyped("3 6 0 0 0 0 0 0 0 0 " + KEY_SQRT + "-", "60,000",
                "√( 3600000000 ) -");
        checkTyped("1 " + KEY_INVERSE + "-", "1", "1/( 1 ) -");

        //in a row
        checkTyped("5 5 - -", "55", "55 -");
        checkTyped("1 5 6 7 - - -", "1,567", "1567 -");

        //after another binary
        checkTyped("1 6 " + KEY_ADD + "-", "16", "16 -");
        checkTyped("5 6 4 " + KEY_MULTIPLY + "-", "564", "564 -");
        checkTyped("3 4 4 3 6 3 / -", "344,363", "344363 -");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + "-", "0", "0 -");
        checkTyped("5 6 2 - " + KEY_PERCENT + "-", "-2,596.44",
                "562 - 3158.44 -");

        //after equals
        checkTyped("7 3 = -", "73", "73 -");
        checkTyped("5 3 - 1 2 = -", "41", "41 -");

        //engineers
        checkTyped("- 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 - 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -",
                "-1.e+16", "0 - 9000000000000000 - 1000000000000000 -");
        checkTyped("- 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 - 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 - 1 -",
                "-1.e+16", "0 - 9000000000000000 - 1000000000000000 - 1 -");
        checkTyped("- 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 - 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 - 6 -",
                "-1.000000000000001e+16",
                "0 - 9000000000000000 - 1000000000000000 - 6 -");
        checkTyped("- 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 - 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 -",
                "-2.e+16", "0 - 9999999999999999 - 9999999999999999 -");
    }

    /**
     * Tests for multiply operation.
     */
    @Test
    public void multiplyTests() {
        //standard cases
        checkTyped("0 " + KEY_MULTIPLY, "0", "0 ×");
        checkTyped("1 " + KEY_MULTIPLY, "1", "1 ×");
        checkTyped("2 5 6 " + KEY_MULTIPLY, "256", "256 ×");
        checkTyped("1 1 5 5 " + KEY_MULTIPLY, "1,155", "1155 ×");

        //several operations
        checkTyped("1 " + KEY_MULTIPLY + "2 " + KEY_MULTIPLY + "3 " + KEY_MULTIPLY, "6",
                "1 × 2 × 3 ×");
        checkTyped("1 0 0 " + KEY_MULTIPLY + "1 0 0 0 " + KEY_MULTIPLY + "1 0 0 0 0 " + KEY_MULTIPLY + "1 0 0" +
                        " 0 0 0 " + KEY_MULTIPLY,
                "100,000,000,000,000", "100 × 1000 × 10000 × 100000 ×");

        //after dot
        checkTyped("6 2 . " + KEY_MULTIPLY, "62", "62 ×");
        checkTyped("6 2 3 6 2 6 . " + KEY_MULTIPLY, "623,626", "623626 ×");

        //after negate
        checkTyped("8 6 6 " + KEY_NEG + KEY_MULTIPLY, "-866", "-866 ×");
        checkTyped("9 8 7 9 1 4 8 0 " + KEY_NEG + KEY_MULTIPLY, "-98,791,480",
                "-98791480 ×");

        //after another unary
        checkTyped("8 sqr " + KEY_MULTIPLY, "64", "sqr( 8 ) ×");
        checkTyped("3 6 0 0 0 0 0 0 0 0 " + KEY_SQRT + KEY_MULTIPLY, "60,000",
                "√( 3600000000 ) ×");
        checkTyped("1 " + KEY_INVERSE + KEY_MULTIPLY, "1", "1/( 1 ) ×");

        //in a row
        checkTyped("5 5 " + KEY_MULTIPLY + KEY_MULTIPLY, "55", "55 ×");
        checkTyped("1 5 6 7 " + KEY_MULTIPLY + KEY_MULTIPLY + KEY_MULTIPLY, "1,567",
                "1567 ×");

        //after another binary
        checkTyped("1 6 - " + KEY_MULTIPLY, "16", "16 ×");
        checkTyped("5 6 4 " + KEY_ADD + KEY_MULTIPLY, "564", "564 ×");
        checkTyped("3 4 4 3 6 3 / " + KEY_MULTIPLY, "344,363", "344363 ×");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + KEY_MULTIPLY, "0", "0 ×");
        checkTyped("5 6 2 - " + KEY_PERCENT + KEY_MULTIPLY, "-2,596.44",
                "562 - 3158.44 ×");

        //after equals
        checkTyped("7 3 = " + KEY_MULTIPLY, "73", "73 ×");
        checkTyped("5 3 - 1 2 = " + KEY_MULTIPLY, "41", "41 ×");

        //engineers
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_MULTIPLY + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                        KEY_MULTIPLY,
                "9.e+30", "9000000000000000 × 1000000000000000 ×");
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " + KEY_MULTIPLY + "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                        KEY_MULTIPLY + "4 " + KEY_MULTIPLY,
                "3.6e+31", "9000000000000000 × 1000000000000000 × 4 ×");
        checkTyped("0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 " + KEY_MULTIPLY + "0 . 1 " + KEY_MULTIPLY,
                "0.1", "0.9999999999999999 × 0.1 ×");
        checkTyped("0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 " + KEY_MULTIPLY + "0 . 6 " + KEY_MULTIPLY,
                "0.5999999999999999", "0.9999999999999999 × 0.6 ×");
    }

    /**
     * Tests for divide operation.
     */
    @Test
    public void divideTests() {
        //standard cases
        checkTyped("0 /", "0", "0 ÷");
        checkTyped("1 /", "1", "1 ÷");
        checkTyped("2 5 6 /", "256", "256 ÷");
        checkTyped("1 1 5 5 /", "1,155", "1155 ÷");

        //several operations
        checkTyped("1 / 2 / 3 /", "0.1666666666666667", "1 ÷ 2 ÷ 3 ÷");
        checkTyped("1 0 0 / 1 0 0 0 / 1 0 0 0 0 / 1 0 0 0 0 0 /", "0.0000000001",
                "100 ÷ 1000 ÷ 10000 ÷ 100000 ÷");

        //after dot
        checkTyped("6 2 . /", "62", "62 ÷");
        checkTyped("6 2 3 6 2 6 . /", "623,626", "623626 ÷");

        //after negate
        checkTyped("8 6 6 " + KEY_NEG + "/", "-866", "-866 ÷");
        checkTyped("9 8 7 9 1 4 8 0 " + KEY_NEG + "/", "-98,791,480",
                "-98791480 ÷");

        //after another unary
        checkTyped("8 sqr /", "64", "sqr( 8 ) ÷");
        checkTyped("3 6 0 0 0 0 0 0 0 0 " + KEY_SQRT + "/", "60,000",
                "√( 3600000000 ) ÷");
        checkTyped("1 " + KEY_INVERSE + "/", "1", "1/( 1 ) ÷");

        //in a row
        checkTyped("5 5 / /", "55", "55 ÷");
        checkTyped("1 5 6 7 / / /", "1,567", "1567 ÷");

        //after another binary
        checkTyped("1 6 " + KEY_ADD + "/", "16", "16 ÷");
        checkTyped("5 6 4 " + KEY_MULTIPLY + "/", "564", "564 ÷");
        checkTyped("3 4 4 3 6 3 - /", "344,363", "344363 ÷");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + "/", "0", "0 ÷");
        checkTyped("5 6 2 - " + KEY_PERCENT + "/", "-2,596.44",
                "562 - 3158.44 ÷");

        //after equals
        checkTyped("7 3 = /", "73", "73 ÷");
        checkTyped("5 3 - 1 2 = /", "41", "41 ÷");

        //engineers
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 / 0 . 1 /", "9.e+16",
                "9000000000000000 ÷ 0.1 ÷");
        checkTyped("9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 / 0 . 1 2 3 /",
                "8.130081300813007e+16",
                "9999999999999999 ÷ 0.123 ÷");
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 / 0 . 5 / 0 . 5 /", "3.6e+16",
                "9000000000000000 ÷ 0.5 ÷ 0.5 ÷");
        checkTyped("0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 / 0 . 1 1 / ", "9.09090909090909",
                "0.9999999999999999 ÷ 0.11 ÷");
        checkTyped("0 . 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 / 9 6 5 /", "9.326424870466321e-19",
                "0.0000000000000009 ÷ 965 ÷");
        checkTyped("0 . 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 / 5 /", "0.1800000000000002",
                "0.9000000000000009 ÷ 5 ÷");
        checkTyped("9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 / 0 . 9 /", "1.111111111111111e+16",
                "9999999999999999 ÷ 0.9 ÷");
        checkTyped("9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 / 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 8 /", "1",
                "9999999999999999 ÷ 9999999999999998 ÷");
    }

    /**
     * Tests for negate operation.
     */
    @Test
    public void negateTests() {
        //standard cases
        checkTyped("0 " + KEY_NEG, "0", "");
        checkTyped("0 . 0 0 " + KEY_NEG, "-0.00", "");
        checkTyped("1 " + KEY_NEG, "-1", "");
        checkTyped("2 " + KEY_NEG, "-2", "");
        checkTyped("2 5 6 " + KEY_NEG, "-256", "");
        checkTyped("1 1 5 1 " + KEY_NEG, "-1,151", "");

        //several operations
        checkTyped("1 " + KEY_NEG + "2 " + KEY_NEG + "3", "123", "");
        checkTyped("1 " + KEY_NEG + "2 " + KEY_NEG + "3 " + KEY_NEG, "-123",
                "");

        //after dot
        checkTyped("6 2 . " + KEY_NEG, "-62.", "");

        //in a row
        checkTyped("8 6 6 " + KEY_NEG + KEY_NEG + KEY_NEG + KEY_NEG + KEY_NEG, "-866",
                "");

        //after another unary
        checkTyped("8 sqr " + KEY_NEG, "-64", "negate( sqr( 8 ) )");
        checkTyped("4 9 " + KEY_SQRT + KEY_NEG, "-7", "negate( √( 49 ) )");
        checkTyped("1 " + KEY_INVERSE + KEY_NEG, "-1", "negate( 1/( 1 ) )");

        //after binary
        checkTyped("5 6 4 - " + KEY_NEG, "-564", "564 - negate( 564 )");
        checkTyped("5 5 / " + KEY_NEG, "-55", "55 ÷ negate( 55 )");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + KEY_NEG, "0", "negate( 0 )");
        checkTyped("5 6 5 - " + KEY_PERCENT + KEY_NEG, "-3,192.25",
                "565 - negate( 3192.25 )");

        //after equals
        checkTyped("7 3 = " + KEY_NEG, "-73", "negate( 73 )");
        checkTyped("5 3 - 1 1 = " + KEY_NEG, "-42", "negate( 42 )");

        //negating negated
        checkTyped("9 2 / 5 = " + KEY_NEG + KEY_NEG, "18.4",
                "negate( negate( 18.4 ) )");

        //negating after second inputted
        checkTyped("8 5 6 - 3 0 " + KEY_NEG, "-30", "856 -");

        //after second calculating
        checkTyped("8 " + KEY_MULTIPLY + "6 sqr " + KEY_NEG, "-36",
                "8 × negate( sqr( 6 ) )");
    }

    /**
     * Tests for square operation.
     */
    @Test
    public void sqrTests() {
        //standard cases
        checkTyped("0 sqr", "0", "sqr( 0 )");
        checkTyped("1 sqr", "1", "sqr( 1 )");
        checkTyped("2 5 6 sqr", "65,536", "sqr( 256 )");
        checkTyped("1 1 5 1 sqr", "1,324,801", "sqr( 1151 )");

        //several operations
        checkTyped("1 sqr 2 sqr 3 sqr", "9", "sqr( 3 )");

        //after dot
        checkTyped("6 2 . sqr", "3,844", "sqr( 62 )");

        //in a row
        checkTyped("8 6 6 sqr sqr sqr sqr sqr", "1.00131920194e+94",
                "sqr( sqr( sqr( sqr( sqr( 866 ) ) ) ) )");

        //after another unary
        checkTyped("8 " + KEY_NEG + "sqr", "64", "sqr( -8 )");
        checkTyped("4 9 " + KEY_SQRT + "sqr", "49", "sqr( √( 49 ) )");
        checkTyped("0 . 0 0 0 0 0 1 " + KEY_INVERSE + "sqr", "1,000,000,000,000",
                "sqr( 1/( 0.000001 ) )");

        //after binary
        checkTyped("5 6 4 - sqr", "318,096", "564 - sqr( 564 )");
        checkTyped("5 5 / sqr", "3,025", "55 ÷ sqr( 55 )");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + "sqr", "0", "sqr( 0 )");
        checkTyped("5 6 5 - " + KEY_PERCENT + "sqr", "10,190,460.0625",
                "565 - sqr( 3192.25 )");

        //after equals
        checkTyped("7 3 = sqr", "5,329", "sqr( 73 )");
        checkTyped("5 3 - 1 4 = sqr", "1,521", "sqr( 39 )");

        //after second inputted
        checkTyped("8 " + KEY_MULTIPLY + "6 sqr", "36", "8 × sqr( 6 )");

        //after second calculating
        checkTyped("8 " + KEY_MULTIPLY + "6 sqr sqr", "1,296",
                "8 × sqr( sqr( 6 ) )");
    }

    /**
     * Tests for square root operation.
     */
    @Test
    public void sqrtTests() {
        //standard cases
        checkTyped("0 " + KEY_SQRT, "0", "√( 0 )");
        checkTyped("1 " + KEY_SQRT, "1", "√( 1 )");
        checkTyped("2 5 6 " + KEY_SQRT, "16", "√( 256 )");
        checkTyped("1 1 5 1 " + KEY_SQRT, "33.92639090737475", "√( 1151 )");

        //several operations
        checkTyped("1 " + KEY_SQRT + "2 " + KEY_SQRT + "3 " + KEY_SQRT, "1.732050807568877",
                "√( 3 )");

        //after dot
        checkTyped("6 2 . " + KEY_SQRT, "7.874007874011811", "√( 62 )");

        //in a row
        checkTyped("8 6 6 " + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT,
                "1.235371090882345", "√( √( √( √( √( 866 ) ) ) ) )");

        //after another unary
        checkTyped("8 " + KEY_NEG + KEY_SQRT, "Invalid input", "√( -8 )");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqr " + KEY_SQRT, "3,600,000,000",
                "√( sqr( 3600000000 ) )");
        checkTyped("0 . 0 0 0 0 0 1 " + KEY_INVERSE + KEY_SQRT, "1,000",
                "√( 1/( 0.000001 ) )");

        //after binary
        checkTyped("5 6 4 - " + KEY_SQRT, "23.74868417407583", "564 - √( 564 )");
        checkTyped("1 5 6 7 / " + KEY_SQRT, "39.58535082577897",
                "1567 ÷ √( 1567 )");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + KEY_SQRT, "0", "√( 0 )");
        checkTyped("5 6 2 - " + KEY_PERCENT + KEY_SQRT, "56.2",
                "562 - √( 3158.44 )");

        //after equals
        checkTyped("7 3 = " + KEY_SQRT, "8.544003745317531", "√( 73 )");
        checkTyped("5 3 - 2 3 = " + KEY_SQRT, "5.477225575051661", "√( 30 )");

        //after second inputted
        checkTyped("8 5 6 - 3 0 " + KEY_SQRT, "5.477225575051661",
                "856 - √( 30 )");

        //after second calculating
        checkTyped("1 " + KEY_ADD + "2 " + KEY_ADD + "3 " + KEY_ADD + "4 " + KEY_INVERSE + KEY_SQRT,
                "0.5", "1 + 2 + 3 + √( 1/( 4 ) )");
    }

    /**
     * Tests for inverse operation.
     */
    @Test
    public void inverseTests() {
        //standard cases
        checkTyped("1 " + KEY_INVERSE, "1", "1/( 1 )");
        checkTyped("2 " + KEY_INVERSE, "0.5", "1/( 2 )");
        checkTyped("2 5 6 " + KEY_INVERSE, "0.00390625", "1/( 256 )");
        checkTyped("1 1 5 1 " + KEY_INVERSE, "8.688097306689835e-4",
                "1/( 1151 )");

        //several operations
        checkTyped("1 " + KEY_INVERSE + "2 " + KEY_INVERSE + "3 " + KEY_INVERSE,
                "0.3333333333333333", "1/( 3 )");

        //after dot
        checkTyped("6 2 . " + KEY_INVERSE, "0.0161290322580645",
                "1/( 62 )");

        //in a row
        checkTyped("8 6 6 " + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE, "866",
                "1/( 1/( 1/( 1/( 866 ) ) ) )");
        checkTyped("8 6 6 " + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE,
                "0.0011547344110855", "1/( 1/( 1/( 1/( 1/( 866 ) ) ) ) )");

        //after another unary
        checkTyped("1 2 3 " + KEY_NEG + KEY_INVERSE, "-0.008130081300813",
                "1/( -123 )");
        checkTyped("4 9 sqr " + KEY_INVERSE, "4.164931278633903e-4",
                "1/( sqr( 49 ) )");
        checkTyped("1 " + KEY_SQRT + KEY_INVERSE, "1", "1/( √( 1 ) )");

        //after binary
        checkTyped("6 5 2 2 4 5 6 - " + KEY_INVERSE, "1.533164807857654e-7",
                "6522456 - 1/( 6522456 )");
        checkTyped("5 5 / " + KEY_INVERSE, "0.0181818181818182",
                "55 ÷ 1/( 55 )");

        //after percent
        checkTyped("7 8 " + KEY_PERCENT + KEY_INVERSE, "Cannot divide by zero",
                "1/( 0 )");
        checkTyped("5 6 2 - " + KEY_PERCENT + KEY_INVERSE, "3.166119983282886e-4",
                "562 - 1/( 3158.44 )");

        //after equals
        checkTyped("7 3 = " + KEY_INVERSE, "0.0136986301369863",
                "1/( 73 )");
        checkTyped("5 3 - 2 6 = " + KEY_INVERSE, "0.037037037037037",
                "1/( 27 )");

        //after second inputted
        checkTyped("8 5 6 - 3 0 " + KEY_INVERSE, "0.0333333333333333",
                "856 - 1/( 30 )");

        //after second calculating
        checkTyped("8 " + KEY_MULTIPLY + "6 sqr " + KEY_INVERSE, "0.0277777777777778",
                "8 × 1/( sqr( 6 ) )");
    }

    /**
     * Tests for percentage operation.
     */
    @Test
    public void percentageTests() {
        //standard cases
        checkTyped("0 " + KEY_PERCENT, "0", "0");
        checkTyped("1 " + KEY_PERCENT, "0", "0");
        checkTyped("2 5 6 " + KEY_PERCENT, "0", "0");
        checkTyped("1 1 5 1 " + KEY_PERCENT, "0", "0");

        //several operations
        checkTyped("1 " + KEY_PERCENT + "2 " + KEY_PERCENT + "3 " + KEY_PERCENT, "0",
                "0");

        //after dot
        checkTyped("6 2 . " + KEY_PERCENT, "0", "0");

        //in a row
        checkTyped("8 6 6 " + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT,
                "0", "0");
        checkTyped("8 6 6 " + KEY_ADD + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT,
                "42,180,075.43559148", "866 + 42180075.43559148");
        checkTyped("8 6 6 / " + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT,
                "0.0000000866", "866 ÷ 0.0000000866");

        //after unary
        checkTyped("8 " + KEY_NEG + KEY_PERCENT, "0", "0");
        checkTyped("4 9 - sqr " + KEY_PERCENT, "1,176.49", "49 - 1176.49");
        checkTyped("6 4 / " + KEY_SQRT + KEY_PERCENT, "0.08", "64 ÷ 0.08");

        //after binary
        checkTyped("5 6 4 - " + KEY_PERCENT, "3,180.96", "564 - 3180.96");
        checkTyped("6 5 2 2 4 5 6 - " + KEY_PERCENT, "425,424,322,719.36",
                "6522456 - 425424322719.36");
        checkTyped("5 5 / " + KEY_PERCENT, "0.55", "55 ÷ 0.55");
        checkTyped("1 5 6 7 / " + KEY_PERCENT, "15.67", "1567 ÷ 15.67");

        //after equals
        checkTyped("7 3 = " + KEY_PERCENT, "0", "0");
        checkTyped("5 3 " + KEY_ADD + "1 2 = " + KEY_PERCENT, "42.25",
                "42.25");
        checkTyped("5 3 / 1 2 = " + KEY_PERCENT, "0.0441666666666667",
                "0.0441666666666667");

        //percent after second inputted
        checkTyped("8 " + KEY_MULTIPLY + "6 " + KEY_PERCENT, "0.06",
                "8 × 0.06");
        checkTyped("8 5 6 - 3 0 " + KEY_PERCENT, "256.8", "856 - 256.8");

        //after second calculating
        checkTyped("8 " + KEY_MULTIPLY + "6 sqr " + KEY_PERCENT, "0.36",
                "8 × 0.36");
        checkTyped("1 " + KEY_ADD + "2 " + KEY_ADD + "3 " + KEY_ADD + "4 " + KEY_INVERSE + KEY_PERCENT,
                "0.015", "1 + 2 + 3 + 0.015");
    }

    /**
     * Tests for equals operation.
     */
    @Test
    public void equalsTests() {
        //standard cases
        checkTyped("0 =", "0", "");
        checkTyped("1 =", "1", "");
        checkTyped("2 5 6 =", "256", "");
        checkTyped("1 1 5 1 =", "1,151", "");

        //several equals operations
        checkTyped("1 = 2 = 3 =", "3", "");

        //after dot
        checkTyped("6 2 . =", "62", "");

        //in a row without binary set
        checkTyped("8 6 6 = = = = =", "866", "");

        //in a row with binary set
        checkTyped("8 6 6 " + KEY_ADD + "1 2 3 = = = = =", "1,481", "");

        //after unary without binary set
        checkTyped("8 " + KEY_NEG + "=", "-8", "");
        checkTyped("4 9 sqr =", "2,401", "");
        checkTyped("1 2 3 4 " + KEY_SQRT + "=", "35.12833614050059", "");
        checkTyped("0 . 0 0 0 0 0 1 " + KEY_INVERSE + "=", "1,000,000", "");

        //after unary with binary set
        checkTyped("5 " + KEY_ADD + "8 " + KEY_NEG + "=", "-3", "");
        checkTyped("5 " + KEY_ADD + "8 " + KEY_NEG + "= =", "-11", "");

        checkTyped("7 5 4 3 " + KEY_MULTIPLY + "4 9 sqr =", "18,110,743",
                "");
        checkTyped("7 5 4 3 " + KEY_MULTIPLY + "4 9 sqr = =", "43,483,893,943",
                "");

        checkTyped("0 / 3 6 0 0 0 0 0 0 0 0 " + KEY_SQRT + "=", "0", "");
        checkTyped("0 / 3 6 0 0 0 0 0 0 0 0 " + KEY_SQRT + "= =", "0", "");

        checkTyped("2 1 3 " + KEY_MULTIPLY + "1 " + KEY_INVERSE + "=", "213",
                "");
        checkTyped("2 1 3 " + KEY_MULTIPLY + "1 " + KEY_INVERSE + "= =", "213",
                "");

        //after binary
        checkTyped("1 6 " + KEY_ADD + "=", "32", "");
        checkTyped("1 6 " + KEY_ADD + "= =", "48", "");

        checkTyped("3 4 4 3 6 3 " + KEY_MULTIPLY + "=", "118,585,875,769",
                "");
        checkTyped("3 4 4 3 6 3 " + KEY_MULTIPLY + "= = =", "1.40626099319007e+22",
                "");

        //after percent
        checkTyped("6 " + KEY_PERCENT + "=", "0", "");
        checkTyped("6 " + KEY_ADD + KEY_PERCENT + "=", "6.36", "");
        checkTyped("6 " + KEY_MULTIPLY + KEY_PERCENT + "= =", "0.0216", "");

        //equals after second inputted
        checkTyped("8 " + KEY_MULTIPLY + "6 =", "48", "");

        //equals after second calculated
        checkTyped("8 5 6 - 3 0 sqr =", "-44", "");

        //after error
        checkTyped("/ 0 = =", "0", "");
    }

    /**
     * Tests for exceptions.
     */
    @Test
    public void exceptionTests() {
        //overflow
        //add
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr " + KEY_MULTIPLY + "1 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = = = = = = " + KEY_MULTIPLY + "1 0 = = = " + KEY_ADD + "= = = = = = = = =", "Overflow");

        //subtract
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr " + KEY_MULTIPLY + "1 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = = = = = = " + KEY_MULTIPLY + "1 0 = = = - = = = = = = = = = = =", "Overflow");

        //multiply
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr " + KEY_MULTIPLY + "1 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = = = = = = " + KEY_MULTIPLY + "1 0 = = = =", "Overflow");

        //divide
        checkException("0 . 0 0 0 0 0 0 0 0 1 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr " + KEY_MULTIPLY + "0 . 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 1 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = = = = = = = = / 1 0 = = = =", "Overflow");

        //sqr
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "Overflow");
        checkException("0 . 0 0 0 0 0 0 0 0 1 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "Overflow");

        //percentage
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr " + KEY_MULTIPLY + "1 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = = = = = = " + KEY_MULTIPLY + "1 0 = = = " + KEY_ADD + KEY_PERCENT, "Overflow");
        checkException("0 . 0 0 0 0 0 0 0 0 1 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr " + KEY_MULTIPLY + "0 . 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 1 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = = = = = = = = / 1 0 = = = " + KEY_MULTIPLY + KEY_PERCENT, "Overflow");

        //invalid input
        checkException("8 " + KEY_NEG + KEY_SQRT, "Invalid input");

        //divide by zero
        checkException("1 4 / 0 = ", "Cannot divide by zero");
        checkException("0 " + KEY_INVERSE, "Cannot divide by zero");

        //divide zero by zero
        checkException("0 / 0 =", "Result is undefined");
    }

    /**
     * Checks that screen {@code Label} has required text after clicking on several {@code Button}.
     *
     * @param buttons            several {@code Button} that should be clicked.
     * @param expectedScreenText required text on screen {@code Label} after clicking.
     */
    private void checkTyped(String buttons, String expectedScreenText) {
        resetAll();
        pressKeyboard(buttons);

        assertEquals(expectedScreenText, getLabeledBySelector(SCREEN_LABEL_ID).getText());
    }

    /**
     * Checks that screen and equation {@code Label} have required texts after clicking on several {@code Button}.
     *
     * @param buttons              several {@code Button} that should be clicked.
     * @param expectedScreenText   required text on screen {@code Label} after clicking.
     * @param expectedEquationText required text on equation {@code Label} after clicking.
     */
    private void checkTyped(String buttons, String expectedScreenText, String expectedEquationText) {
        checkTyped(buttons, expectedScreenText);

        expectedEquationText = expectedEquationText.replaceAll(SPACE, NARROW_SPACE);
        assertEquals(expectedEquationText, getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Checks that text in screen {@code Label} is cleared but not in equation {@code Label} after clear text operation.
     * Then checks that text in screen {@code Label} is cleared as well as in equation {@code Label} after clear all
     * operation.
     *
     * @param keys several {@code Button} that should be clicked before clearing.
     */
    private void checkClear(String keys) {
        resetAll();

        Label screenLabel = (Label) getLabeledBySelector(SCREEN_LABEL_ID);
        Label equationLabel = (Label) getLabeledBySelector(EQUATION_LABEL_ID);

        pressKeyboard(keys);
        String expectedEquationText = equationLabel.getText();
        pressKeyboard(KEY_CE);

        assertEquals("0", screenLabel.getText());
        assertEquals(expectedEquationText, equationLabel.getText());

        resetAll();
        pressKeyboard(keys);
        pressKeyboard(KEY_C);

        assertEquals("0", screenLabel.getText());
        assertEquals("", equationLabel.getText());
    }

    /**
     * Checks that exception was thrown after clicking several {@code Button}.
     *
     * @param buttons            several {@code Button} that should be clicked.
     * @param expectedScreenText required text on screen {@code Label} after clicking.
     */
    private void checkException(String buttons, String expectedScreenText) {
        checkTyped(buttons, expectedScreenText);

        Button[] enabledButtons = getSeveralButtonsBySelector(CLEAR_ALL_ID, CLEAR_TEXT_ID, BACKSPACE_ID,
                ZERO_ID, ONE_ID, TWO_ID, THREE_ID, FOUR_ID, FIVE_ID, SIX_ID, SEVEN_ID, EIGHT_ID, NINE_ID, EQUALS_ID);
        Button[] disabledButtons = getSeveralButtonsBySelector(MEMORY_SHOW_ID, MEMORY_CLEAR_ID, MEMORY_RECALL_ID,
                MEMORY_ADD_ID, MEMORY_SUBTRACT_ID, MEMORY_STORE_ID, PERCENT_ID, SQRT_ID, SQR_ID, INVERSE_ID, DIVIDE_ID,
                MULTIPLY_ID, SUBTRACT_ID, ADD_ID, NEGATE_ID, DOT_ID);

        for (Button button : enabledButtons) {
            assertFalse(button.isDisabled());
        }

        for (Button button : disabledButtons) {
            assertTrue(button.isDisabled());
        }
    }
}
