package tests.controller;

import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;
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
    private static final String KEY_MS = "ctrl+M";

    /**
     * Keypad combination for firing memory clear {@code Button}.
     */
    private static final String KEY_MC = "ctrl+L";

    /**
     * Keypad combination for firing memory recall {@code Button}.
     */
    private static final String KEY_MR = "ctrl+R";

    /**
     * Keypad combination for firing memory add {@code Button}.
     */
    private static final String KEY_M_ADD = "ctrl+P";

    /**
     * Keypad combination for firing memory subtract {@code Button}.
     */
    private static final String KEY_M_SUBTRACT = "ctrl+Q";

    /**
     * Keypad combination for firing add {@code Button}.
     */
    private static final String KEY_ADD = "shift+=";

    /**
     * Keypad combination for firing multiply {@code Button}.
     */
    private static final String KEY_MULTIPLY = "shift+8";

    /**
     * Keypad button for firing negate {@code Button}.
     */
    private static final String KEY_NEG = "F9";

    /**
     * Keypad button for firing inverse {@code Button}.
     */
    private static final String KEY_INVERSE = "R";

    /**
     * Keypad combination for firing sqrt {@code Button}.
     */
    private static final String KEY_SQRT = "shift+2";

    /**
     * Keypad combination for firing percent {@code Button}.
     */
    private static final String KEY_PERCENT = "shift+5";

    /**
     * Symbol that should be replaced in equation {@code Label}.
     */
    private static final String SPACE = " ";

    /**
     * Symbol for separation numbers and operations in equation {@code Label} that should replace spaces in tests.
     */
    private static final String NARROW_SPACE = "\u2009";

    /**
     * Exception message for {@link OverflowException}.
     */
    private static final String OVERFLOW_MESSAGE = "Overflow";

    /**
     * Exception message for divide by zero {@link ArithmeticException}.
     */
    private static final String DIVIDE_BY_ZERO_MESSAGE = "Cannot divide by zero";

    /**
     * Exception message for divide zero by zero {@link ArithmeticException}.
     */
    private static final String DIVIDE_ZERO_BY_ZERO_MESSAGE = "Result is undefined";

    /**
     * Exception message for invalid input {@link ArithmeticException}.
     */
    private static final String INVALID_INPUT_MESSAGE = "Invalid input";

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
        sqrtTests();
        inverseTests();

        percentageTests();
        equalsTests();

        exceptionTests();
        boundaryTests();
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

        pressKeyboard("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_MS);
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

        pressKeyboard("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_MS + KEY_MC);

        assertTrue(getButtonBySelector(MEMORY_CLEAR_ID).isDisabled());
        assertTrue(getButtonBySelector(MEMORY_RECALL_ID).isDisabled());
        assertTrue(getButtonBySelector(MEMORY_SHOW_ID).isDisabled());
    }

    /**
     * Tests for memory recall operation.
     */
    @Test
    public void memoryRecallTests() {
        checkTyped("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_MS + KEY_MR, "3");
        checkTyped("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_MR, "2");
        checkTyped(KEY_MS + "100" + KEY_MR, "0");
    }

    /**
     * Tests for memory add operation.
     */
    @Test
    public void memoryAddTests() {
        checkTyped("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_MS + KEY_M_ADD + KEY_MR, "6");
        checkTyped("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_M_ADD + KEY_MR, "5");
        checkTyped(KEY_MS + "1 0 0 " + KEY_ADD + KEY_M_ADD + KEY_MR, "100");

        checkTyped("8" + KEY_M_ADD + KEY_MR, "8");
        checkTyped("1" + KEY_NEG + "28" + KEY_M_ADD + KEY_MR, "-128");
    }

    /**
     * Tests for memory subtract operation.
     */
    @Test
    public void memorySubtractTests() {
        checkTyped("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_MS + KEY_M_SUBTRACT + KEY_MR, "0");
        checkTyped("1" + KEY_MS + "2" + KEY_MS + "3" + KEY_M_SUBTRACT + KEY_MR, "-1");
        checkTyped(KEY_MS + "1 0 0 " + KEY_ADD + KEY_M_SUBTRACT + KEY_MR, "-100");

        checkTyped("8" + KEY_M_SUBTRACT + KEY_MR, "-8");
        checkTyped("1" + KEY_NEG + "28" + KEY_M_SUBTRACT + KEY_MR, "128");
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
        checkTyped("736", "736");
        checkTyped("4890", "4,890");
        checkTyped("3259000234000023", "3,259,000,234,000,023");

        //after negate
        checkTyped("8" + KEY_NEG + "96", "-896");
        checkTyped("7" + KEY_NEG + "890635789000000", "-7,890,635,789,000,000");

        //after dot
        checkTyped("7255.34", "7,255.34");
        //after dot with 16 digits summary
        checkTyped("123019.8498533564", "123,019.8498533564");

        //after dot with 17 digits summary ( starts with 0. )
        checkTyped("0.1223458901245678", "0.1223458901245678");

        //after dot and negate
        checkTyped("7" + KEY_NEG + "25.72", "-725.72");

        //after dot with 16 digits summary and negate
        checkTyped("123657.29582" + KEY_NEG + "00256", "-123,657.2958200256");

        //after dot with 17 digits summary ( starts with 0. ) and negate
        checkTyped("0.85298" + KEY_NEG + "23546736765", "-0.8529823546736765");

        //after backspace
        checkTyped("8 backspace 32", "32");

        //after unary operation pressed
        checkTyped("9" + KEY_SQRT + "825", "825");
        checkTyped("22" + KEY_INVERSE + "7", "7");

        //after binary operation pressed
        checkTyped("9-2", "2");
        checkTyped("12/1", "1");
        //after percent pressed
        checkTyped("6" + KEY_PERCENT + "2", "2");
        checkTyped("1-" + KEY_PERCENT + "90", "90");

        //after equals pressed
        checkTyped("13=131", "131");
        checkTyped("76-14=13", "13");

        //after error
        checkTyped("/0=3", "3");


        //can not append
        checkTyped("00", "0");

        //17 digits
        checkTyped("12345678901234567", "1,234,567,890,123,456");

        //more than 17 digits
        checkTyped("2198370919080518325", "2,198,370,919,080,518");

        //17 and negate
        checkTyped("123456789" + KEY_NEG + "01234567", "-1,234,567,890,123,456");

        //more than 17 and negate
        checkTyped("120984710245" + KEY_NEG + "8012850", "-1,209,847,102,458,012");

        //17 and dot
        checkTyped("123456789.01234567", "123,456,789.0123456");

        //more than 17 and dot
        checkTyped("120984710245.8012730", "120,984,710,245.8012");

        //17 and dot and negate
        checkTyped("123456" + KEY_NEG + "789.01234567", "-123,456,789.0123456");

        //more than 17 and dot and negate
        checkTyped("219.837" + KEY_NEG + "091908051832", "-219.8370919080518");

        //18 and dot and starts with 0.
        checkTyped("0.74363738736363636", "0.7436373873636363");

        //more than 18 and dot and starts with 0.
        checkTyped("0.3242384729375982868", "0.3242384729375982");

        //18 and dot and starts with 0. and negate
        checkTyped("0.8752345" + KEY_NEG + "6890076345", "-0.8752345689007634");

        //more than 18 and dot and starts with 0. and negate
        checkTyped("0.3" + KEY_NEG + "242384729375982760", "-0.3242384729375982");
    }

    /**
     * Tests for appending dot.
     */
    @Test
    public void appendDotTests() {
        //can append
        //without operations
        checkTyped("1.", "1.");
        checkTyped("2.", "2.");
        checkTyped("111.", "111.");
        checkTyped("4890.", "4,890.");
        checkTyped("5893127592375922.", "5,893,127,592,375,922.");

        //17 digits
        checkTyped("12345678901234568.", "1,234,567,890,123,456.");

        //more than 17 digits
        checkTyped("1209847102458012409.", "1,209,847,102,458,012.");

        //17 and negate
        checkTyped("87984" + KEY_NEG + "719571987591.", "-8,798,471,957,198,759.");

        //more than 17 and negate
        checkTyped("219" + KEY_NEG + "8370919080518051.", "-2,198,370,919,080,518.");

        //with negated number
        checkTyped("1" + KEY_NEG + ".", "-1.");
        checkTyped("61237" + KEY_NEG + ".", "-61,237.");

        //16 digits
        checkTyped("6" + KEY_NEG + "235483463468345.", "-6,235,483,463,468,345.");

        //after unary operation pressed
        checkTyped("953" + KEY_SQRT + ".", "0.");
        checkTyped("71" + KEY_INVERSE + ".", "0.");

        //after binary operations
        checkTyped("3254-.", "0.");
        checkTyped("24/.", "0.");

        //after percent
        checkTyped("14" + KEY_PERCENT + ".", "0.");
        checkTyped("5-" + KEY_PERCENT + ".", "0.");

        //after equals
        checkTyped("15=.", "0.");
        checkTyped("7-12=.", "0.");

        //after backspace
        checkTyped("12135 backspace.", "1,213.");
        checkTyped("21 backspace.", "2.");

        //can not append
        //17 and dot
        checkTyped("123456789.01234567.", "123,456,789.0123456");

        //more than 17 and dot
        checkTyped("120984710245.8012092.", "120,984,710,245.8012");

        //17 and dot and negate
        checkTyped("123456" + KEY_NEG + "789.01234567.", "-123,456,789.0123456");

        //more than 17 and dot and negate
        checkTyped("120" + KEY_NEG + "984710245.8012092.", "-120,984,710,245.8012");

        //18 and dot and starts with 0.
        checkTyped("0.74363738736363636.", "0.7436373873636363");

        //more than 18 and dot and starts with 0.
        checkTyped("0.324238472937598286.", "0.3242384729375982");

        //18 and dot and starts with 0. and negate
        checkTyped("0.74" + KEY_NEG + "363738736363636.", "-0.7436373873636363");

        //more than 18 and dot and starts with 0. and negate
        checkTyped("0.3" + KEY_NEG + "24238472937598286.", "-0.3242384729375982");

        //already with dot
        checkTyped("1414.1.2..", "1,414.12");
        checkTyped("8764....", "8,764.");
    }

    /**
     * Tests for backspace.
     */
    @Test
    public void backspaceTests() {
        checkTyped("0 backspace", "0");
        checkTyped("1 backspace", "0");
        checkTyped("9 backspace", "0");
        checkTyped("213 backspace", "21");
        checkTyped("1415 backspace", "141");
        checkTyped("14513515 backspace", "1,451,351");

        //after dot
        checkTyped("14214. backspace", "14,214");

        //after negate
        checkTyped("6563252" + KEY_NEG + "backspace", "-656,325");

        //after unary operation
        checkTyped("900" + KEY_SQRT + "backspace", "30");
        checkTyped("8" + KEY_INVERSE + "backspace", "0.125");

        //after binary operation
        checkTyped("14- backspace", "14");
        checkTyped("523/ backspace", "523");

        //after percent
        checkTyped("14" + KEY_PERCENT + "backspace", "0");
        checkTyped("14-" + KEY_PERCENT + "backspace", "1.96");

        //after equals
        checkTyped("51= backspace", "51");
        checkTyped("4001-1= backspace", "4,000");

        //after error
        checkTyped("/0= backspace", "0");

        //several in a row
        checkTyped("123 backspace backspace backspace", "0");
        checkTyped("2152343 backspace backspace", "21,523");
    }

    /**
     * Tests for clear operations (clear text and clear all).
     */
    @Test
    public void clearTests() {
        //without operations
        checkClear("1");
        checkClear("2");
        checkClear("123");
        checkClear("1215");
        checkClear("1.23");

        //unary
        checkClear("123" + KEY_NEG);
        checkClear("1231" + KEY_SQRT);
        checkClear("38" + KEY_INVERSE);

        //binary
        checkClear("51-");
        checkClear("1816/");

        //percent
        checkClear("12" + KEY_PERCENT);
        checkClear("122-" + KEY_PERCENT);

        //equals
        checkClear("12=");
        checkClear("1-3=");

        //backspace
        checkClear("123 backspace");

        //after error
        resetAll();
        pressKeyboard("/0=");
        pressKeyboard(KEY_CE);
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        resetAll();
        pressKeyboard("/0=");
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
        checkTyped("0" + KEY_ADD, "0", "0 +");
        checkTyped("1" + KEY_ADD, "1", "1 +");
        checkTyped("256" + KEY_ADD, "256", "256 +");
        checkTyped("1155" + KEY_ADD, "1,155", "1155 +");

        //several operations
        checkTyped("1" + KEY_ADD + "2" + KEY_ADD + "3" + KEY_ADD, "6",
                "1 + 2 + 3 +");
        checkTyped("100" + KEY_ADD + "1000" + KEY_ADD + "10000" + KEY_ADD + "100000" + KEY_ADD,
                "111,100", "100 + 1000 + 10000 + 100000 +");

        //after dot
        checkTyped("62." + KEY_ADD, "62", "62 +");
        checkTyped("623626." + KEY_ADD, "623,626", "623626 +");

        //after negate
        checkTyped("866" + KEY_NEG + KEY_ADD, "-866", "-866 +");
        checkTyped("98791480" + KEY_NEG + KEY_ADD, "-98,791,480",
                "-98791480 +");

        //after another unary
        checkTyped("8 sqr" + KEY_ADD, "64", "sqr( 8 ) +");
        checkTyped("3600000000" + KEY_SQRT + KEY_ADD, "60,000",
                "√( 3600000000 ) +");
        checkTyped("1" + KEY_INVERSE + KEY_ADD, "1", "1/( 1 ) +");

        //in a row
        checkTyped("55" + KEY_ADD + KEY_ADD, "55", "55 +");
        checkTyped("1567" + KEY_ADD + KEY_ADD + KEY_ADD, "1,567", "1567 +");

        //after another binary
        checkTyped("16-" + KEY_ADD, "16", "16 +");
        checkTyped("564" + KEY_MULTIPLY + KEY_ADD, "564", "564 +");
        checkTyped("344363/" + KEY_ADD, "344,363", "344363 +");

        //after percent
        checkTyped("78" + KEY_PERCENT + KEY_ADD, "0", "0 +");
        checkTyped("562-" + KEY_PERCENT + KEY_ADD, "-2,596.44",
                "562 - 3158.44 +");

        //after equals
        checkTyped("73=" + KEY_ADD, "73", "73 +");
        checkTyped("53-12=" + KEY_ADD, "41", "41 +");

        //engineers
        checkTyped("9000000000000000" + KEY_ADD + "1000000000000000" + KEY_ADD, "1.e+16",
                "9000000000000000 + 1000000000000000 +");
        checkTyped("9000000000000000" + KEY_ADD + "1000000000000000" + KEY_ADD + "1" + KEY_ADD,
                "1.e+16", "9000000000000000 + 1000000000000000 + 1 +");
        checkTyped("9000000000000000" + KEY_ADD + "1000000000000000" + KEY_ADD + "6" + KEY_ADD,
                "1.000000000000001e+16",
                "9000000000000000 + 1000000000000000 + " + "6 +");
        checkTyped("9999999999999999" + KEY_ADD + "9999999999999999" + KEY_ADD, "2.e+16",
                "9999999999999999 + 9999999999999999 +");
    }

    /**
     * Tests for subtract operation.
     */
    @Test
    public void subtractTests() {
        //standard cases
        checkTyped("0-", "0", "0 -");
        checkTyped("1-", "1", "1 -");
        checkTyped("256-", "256", "256 -");
        checkTyped("1155-", "1,155", "1155 -");

        //several operations
        checkTyped("1-2-3-", "-4", "1 - 2 - 3 -");
        checkTyped("100-1000-10000-100000-", "-110,900",
                "100 - 1000 - 10000 - 100000 -");

        //after dot
        checkTyped("62.-", "62", "62 -");
        checkTyped("623626.-", "623,626", "623626 -");

        //after negate
        checkTyped("866" + KEY_NEG + "-", "-866", "-866 -");
        checkTyped("98791480" + KEY_NEG + "-", "-98,791,480",
                "-98791480 -");

        //after another unary
        checkTyped("8 sqr -", "64", "sqr( 8 ) -");
        checkTyped("3600000000" + KEY_SQRT + "-", "60,000",
                "√( 3600000000 ) -");
        checkTyped("1" + KEY_INVERSE + "-", "1", "1/( 1 ) -");

        //in a row
        checkTyped("55--", "55", "55 -");
        checkTyped("1567---", "1,567", "1567 -");

        //after another binary
        checkTyped("16" + KEY_ADD + "-", "16", "16 -");
        checkTyped("564" + KEY_MULTIPLY + "-", "564", "564 -");
        checkTyped("344363/-", "344,363", "344363 -");

        //after percent
        checkTyped("78" + KEY_PERCENT + "-", "0", "0 -");
        checkTyped("562-" + KEY_PERCENT + "-", "-2,596.44",
                "562 - 3158.44 -");

        //after equals
        checkTyped("73=-", "73", "73 -");
        checkTyped("53-12=-", "41", "41 -");

        //engineers
        checkTyped("-9000000000000000-1000000000000000-", "-1.e+16",
                "0 - 9000000000000000 - 1000000000000000 -");
        checkTyped("-9000000000000000-1000000000000000-1-", "-1.e+16",
                "0 - 9000000000000000 - 1000000000000000 - 1 -");
        checkTyped("-9000000000000000-1000000000000000-6-", "-1.000000000000001e+16",
                "0 - 9000000000000000 - 1000000000000000 - 6 -");
        checkTyped("-9999999999999999-9999999999999999-", "-2.e+16",
                "0 - 9999999999999999 - 9999999999999999 -");
    }

    /**
     * Tests for multiply operation.
     */
    @Test
    public void multiplyTests() {
        //standard cases
        checkTyped("0" + KEY_MULTIPLY, "0", "0 ×");
        checkTyped("1" + KEY_MULTIPLY, "1", "1 ×");
        checkTyped("256" + KEY_MULTIPLY, "256", "256 ×");
        checkTyped("1155" + KEY_MULTIPLY, "1,155", "1155 ×");

        //several operations
        checkTyped("1" + KEY_MULTIPLY + "2" + KEY_MULTIPLY + "3" + KEY_MULTIPLY, "6",
                "1 × 2 × 3 ×");
        checkTyped("100" + KEY_MULTIPLY + "1000" + KEY_MULTIPLY + "10000" + KEY_MULTIPLY + "100" + "000" +
                        KEY_MULTIPLY, "100,000,000,000,000",
                "100 × 1000 × 10000 × 100000 ×");

        //after dot
        checkTyped("62." + KEY_MULTIPLY, "62", "62 ×");
        checkTyped("623626." + KEY_MULTIPLY, "623,626", "623626 ×");

        //after negate
        checkTyped("866" + KEY_NEG + KEY_MULTIPLY, "-866", "-866 ×");
        checkTyped("98791480" + KEY_NEG + KEY_MULTIPLY, "-98,791,480",
                "-98791480 ×");

        //after another unary
        checkTyped("8 sqr" + KEY_MULTIPLY, "64", "sqr( 8 ) ×");
        checkTyped("3600000000" + KEY_SQRT + KEY_MULTIPLY, "60,000",
                "√( 3600000000 ) ×");
        checkTyped("1" + KEY_INVERSE + KEY_MULTIPLY, "1", "1/( 1 ) ×");

        //in a row
        checkTyped("55" + KEY_MULTIPLY + KEY_MULTIPLY, "55", "55 ×");
        checkTyped("1567" + KEY_MULTIPLY + KEY_MULTIPLY + KEY_MULTIPLY, "1,567",
                "1567 ×");

        //after another binary
        checkTyped("16-" + KEY_MULTIPLY, "16", "16 ×");
        checkTyped("564" + KEY_ADD + KEY_MULTIPLY, "564", "564 ×");
        checkTyped("344363/" + KEY_MULTIPLY, "344,363", "344363 ×");

        //after percent
        checkTyped("78" + KEY_PERCENT + KEY_MULTIPLY, "0", "0 ×");
        checkTyped("562-" + KEY_PERCENT + KEY_MULTIPLY, "-2,596.44",
                "562 - 3158.44 ×");

        //after equals
        checkTyped("73=" + KEY_MULTIPLY, "73", "73 ×");
        checkTyped("53-12=" + KEY_MULTIPLY, "41", "41 ×");

        //engineers
        checkTyped("9000000000000000" + KEY_MULTIPLY + "1000000000000000" + KEY_MULTIPLY,
                "9.e+30", "9000000000000000 × 1000000000000000 ×");
        checkTyped("9000000000000000" + KEY_MULTIPLY + "1000000000000000" + KEY_MULTIPLY + "4" + KEY_MULTIPLY,
                "3.6e+31", "9000000000000000 × 1000000000000000 × 4 ×");
        checkTyped("0.9999999999999999" + KEY_MULTIPLY + "0.1" + KEY_MULTIPLY, "0.1",
                "0.9999999999999999 × 0.1 ×");
        checkTyped("0.9999999999999999" + KEY_MULTIPLY + "0.6" + KEY_MULTIPLY,
                "0.5999999999999999", "0.9999999999999999 × 0.6 ×");
    }

    /**
     * Tests for divide operation.
     */
    @Test
    public void divideTests() {
        //standard cases
        checkTyped("0/", "0", "0 ÷");
        checkTyped("1/", "1", "1 ÷");
        checkTyped("256/", "256", "256 ÷");
        checkTyped("1155/", "1,155", "1155 ÷");

        //several operations
        checkTyped("1/2/3/", "0.1666666666666667", "1 ÷ 2 ÷ 3 ÷");
        checkTyped("100/1000/10000/100000/", "0.0000000001",
                "100 ÷ 1000 ÷ 10000 ÷ 100000 ÷");

        //after dot
        checkTyped("62./", "62", "62 ÷");
        checkTyped("623626./", "623,626", "623626 ÷");

        //after negate
        checkTyped("866" + KEY_NEG + "/", "-866", "-866 ÷");
        checkTyped("98791480" + KEY_NEG + "/", "-98,791,480",
                "-98791480 ÷");

        //after another unary
        checkTyped("8 sqr /", "64", "sqr( 8 ) ÷");
        checkTyped("3600000000" + KEY_SQRT + "/", "60,000",
                "√( 3600000000 ) ÷");
        checkTyped("1" + KEY_INVERSE + "/", "1", "1/( 1 ) ÷");

        //in a row
        checkTyped("55//", "55", "55 ÷");
        checkTyped("1567///", "1,567", "1567 ÷");

        //after another binary
        checkTyped("16" + KEY_ADD + "/", "16", "16 ÷");
        checkTyped("564" + KEY_MULTIPLY + "/", "564", "564 ÷");
        checkTyped("344363-/", "344,363", "344363 ÷");

        //after percent
        checkTyped("78" + KEY_PERCENT + "/", "0", "0 ÷");
        checkTyped("562-" + KEY_PERCENT + "/", "-2,596.44",
                "562 - 3158.44 ÷");

        //after equals
        checkTyped("73=/", "73", "73 ÷");
        checkTyped("53-12=/", "41", "41 ÷");

        //engineers
        checkTyped("9000000000000000/0.1/", "9.e+16",
                "9000000000000000 ÷ 0.1 ÷");
        checkTyped("9999999999999999/0.123/", "8.130081300813007e+16",
                "9999999999999999 ÷ 0.123 ÷");
        checkTyped("9000000000000000/0.5/0.5/", "3.6e+16",
                "9000000000000000 ÷ 0.5 ÷ 0.5 ÷");
        checkTyped("0.9999999999999999/0.11/", "9.09090909090909",
                "0.9999999999999999 ÷ 0.11 ÷");
        checkTyped("0.0000000000000009/965/", "9.326424870466321e-19",
                "0.0000000000000009 ÷ 965 ÷");
        checkTyped("0.9000000000000009/5/", "0.1800000000000002",
                "0.9000000000000009 ÷ 5 ÷");
        checkTyped("9999999999999999/0.9/", "1.111111111111111e+16",
                "9999999999999999 ÷ 0.9 ÷");
        checkTyped("9999999999999999/9999999999999998/", "1",
                "9999999999999999 ÷ 9999999999999998 ÷");
    }

    /**
     * Tests for negate operation.
     */
    @Test
    public void negateTests() {
        //standard cases
        checkTyped("0" + KEY_NEG, "0", "");
        checkTyped("0.00" + KEY_NEG, "-0.00", "");
        checkTyped("1" + KEY_NEG, "-1", "");
        checkTyped("2" + KEY_NEG, "-2", "");
        checkTyped("256" + KEY_NEG, "-256", "");
        checkTyped("1151" + KEY_NEG, "-1,151", "");

        //several operations
        checkTyped("1" + KEY_NEG + "2" + KEY_NEG + "3", "123", "");
        checkTyped("1" + KEY_NEG + "2" + KEY_NEG + "3" + KEY_NEG, "-123",
                "");

        //after dot
        checkTyped("62." + KEY_NEG, "-62.", "");

        //in a row
        checkTyped("866" + KEY_NEG + KEY_NEG + KEY_NEG + KEY_NEG + KEY_NEG, "-866",
                "");

        //after another unary
        checkTyped("8 sqr" + KEY_NEG, "-64", "negate( sqr( 8 ) )");
        checkTyped("49" + KEY_SQRT + KEY_NEG, "-7", "negate( √( 49 ) )");
        checkTyped("1" + KEY_INVERSE + KEY_NEG, "-1", "negate( 1/( 1 ) )");

        //after binary
        checkTyped("564-" + KEY_NEG, "-564", "564 - negate( 564 )");
        checkTyped("55/" + KEY_NEG, "-55", "55 ÷ negate( 55 )");

        //after percent
        checkTyped("78" + KEY_PERCENT + KEY_NEG, "0", "negate( 0 )");
        checkTyped("565-" + KEY_PERCENT + KEY_NEG, "-3,192.25",
                "565 - negate( 3192.25 )");

        //after equals
        checkTyped("73=" + KEY_NEG, "-73", "negate( 73 )");
        checkTyped("53-11=" + KEY_NEG, "-42", "negate( 42 )");

        //negating negated
        checkTyped("92/5=" + KEY_NEG + KEY_NEG, "18.4",
                "negate( negate( 18.4 ) )");

        //negating after second inputted
        checkTyped("856-30" + KEY_NEG, "-30", "856 -");

        //after second calculating
        checkTyped("8" + KEY_MULTIPLY + "6 sqr" + KEY_NEG, "-36",
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
        checkTyped("256 sqr", "65,536", "sqr( 256 )");
        checkTyped("1151 sqr", "1,324,801", "sqr( 1151 )");

        //several operations
        checkTyped("1 sqr 2 sqr 3 sqr", "9", "sqr( 3 )");

        //after dot
        checkTyped("62. sqr", "3,844", "sqr( 62 )");

        //in a row
        checkTyped("866 sqr sqr sqr sqr sqr", "1.00131920194e+94",
                "sqr( sqr( sqr( sqr( sqr( 866 ) ) ) ) )");

        //after another unary
        checkTyped("8" + KEY_NEG + "sqr", "64", "sqr( -8 )");
        checkTyped("49 " + KEY_SQRT + "sqr", "49", "sqr( √( 49 ) )");
        checkTyped("0.000001" + KEY_INVERSE + "sqr", "1,000,000,000,000",
                "sqr( 1/( 0.000001 ) )");

        //after binary
        checkTyped("564- sqr", "318,096", "564 - sqr( 564 )");
        checkTyped("55/ sqr", "3,025", "55 ÷ sqr( 55 )");

        //after percent
        checkTyped("78" + KEY_PERCENT + "sqr", "0", "sqr( 0 )");
        checkTyped("565-" + KEY_PERCENT + "sqr", "10,190,460.0625",
                "565 - sqr( 3192.25 )");

        //after equals
        checkTyped("73= sqr", "5,329", "sqr( 73 )");
        checkTyped("53-14= sqr", "1,521", "sqr( 39 )");

        //after second inputted
        checkTyped("8" + KEY_MULTIPLY + "6 sqr", "36", "8 × sqr( 6 )");

        //after second calculating
        checkTyped("8" + KEY_MULTIPLY + "6 sqr sqr", "1,296",
                "8 × sqr( sqr( 6 ) )");
    }

    /**
     * Tests for square root operation.
     */
    @Test
    public void sqrtTests() {
        //standard cases
        checkTyped("0" + KEY_SQRT, "0", "√( 0 )");
        checkTyped("1" + KEY_SQRT, "1", "√( 1 )");
        checkTyped("256" + KEY_SQRT, "16", "√( 256 )");
        checkTyped("1151 " + KEY_SQRT, "33.92639090737475", "√( 1151 )");

        //several operations
        checkTyped("1" + KEY_SQRT + "2 " + KEY_SQRT + "3 " + KEY_SQRT, "1.732050807568877",
                "√( 3 )");

        //after dot
        checkTyped("62." + KEY_SQRT, "7.874007874011811", "√( 62 )");

        //in a row
        checkTyped("866" + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT + KEY_SQRT,
                "1.235371090882345", "√( √( √( √( √( 866 ) ) ) ) )");

        //after another unary
        checkTyped("8" + KEY_NEG + KEY_SQRT, INVALID_INPUT_MESSAGE, "√( -8 )");
        checkTyped("3600000000 sqr" + KEY_SQRT, "3,600,000,000",
                "√( sqr( 3600000000 ) )");
        checkTyped("0.000001" + KEY_INVERSE + KEY_SQRT, "1,000",
                "√( 1/( 0.000001 ) )");

        //after binary
        checkTyped("564-" + KEY_SQRT, "23.74868417407583", "564 - √( 564 )");
        checkTyped("1567/" + KEY_SQRT, "39.58535082577897",
                "1567 ÷ √( 1567 )");

        //after percent
        checkTyped("78" + KEY_PERCENT + KEY_SQRT, "0", "√( 0 )");
        checkTyped("562-" + KEY_PERCENT + KEY_SQRT, "56.2",
                "562 - √( 3158.44 )");

        //after equals
        checkTyped("73=" + KEY_SQRT, "8.544003745317531", "√( 73 )");
        checkTyped("53-23=" + KEY_SQRT, "5.477225575051661", "√( 30 )");

        //after second inputted
        checkTyped("856-30" + KEY_SQRT, "5.477225575051661",
                "856 - √( 30 )");

        //after second calculating
        checkTyped("1" + KEY_ADD + "2" + KEY_ADD + "3" + KEY_ADD + "4" + KEY_INVERSE + KEY_SQRT,
                "0.5", "1 + 2 + 3 + √( 1/( 4 ) )");
    }

    /**
     * Tests for inverse operation.
     */
    @Test
    public void inverseTests() {
        //standard cases
        checkTyped("1" + KEY_INVERSE, "1", "1/( 1 )");
        checkTyped("2" + KEY_INVERSE, "0.5", "1/( 2 )");
        checkTyped("256" + KEY_INVERSE, "0.00390625", "1/( 256 )");
        checkTyped("1151" + KEY_INVERSE, "8.688097306689835e-4",
                "1/( 1151 )");

        //several operations
        checkTyped("1" + KEY_INVERSE + "2" + KEY_INVERSE + "3" + KEY_INVERSE,
                "0.3333333333333333", "1/( 3 )");

        //after dot
        checkTyped("62." + KEY_INVERSE, "0.0161290322580645", "1/( 62 )");

        //in a row
        checkTyped("866" + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE, "866",
                "1/( 1/( 1/( 1/( 866 ) ) ) )");
        checkTyped("866" + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE + KEY_INVERSE,
                "0.0011547344110855", "1/( 1/( 1/( 1/( 1/( 866 ) ) ) ) )");

        //after another unary
        checkTyped("123" + KEY_NEG + KEY_INVERSE, "-0.008130081300813",
                "1/( -123 )");
        checkTyped("49 sqr" + KEY_INVERSE, "4.164931278633903e-4",
                "1/( sqr( 49 ) )");
        checkTyped("1" + KEY_SQRT + KEY_INVERSE, "1", "1/( √( 1 ) )");

        //after binary
        checkTyped("6522456-" + KEY_INVERSE, "1.533164807857654e-7",
                "6522456 - 1/( 6522456 )");
        checkTyped("55/" + KEY_INVERSE, "0.0181818181818182",
                "55 ÷ 1/( 55 )");

        //after percent
        checkTyped("78" + KEY_PERCENT + KEY_INVERSE, DIVIDE_BY_ZERO_MESSAGE,
                "1/( 0 )");
        checkTyped("562-" + KEY_PERCENT + KEY_INVERSE, "3.166119983282886e-4",
                "562 - 1/( 3158.44 )");

        //after equals
        checkTyped("73=" + KEY_INVERSE, "0.0136986301369863", "1/( 73 )");
        checkTyped("53-26=" + KEY_INVERSE, "0.037037037037037",
                "1/( 27 )");

        //after second inputted
        checkTyped("856-30" + KEY_INVERSE, "0.0333333333333333",
                "856 - 1/( 30 )");

        //after second calculating
        checkTyped("8" + KEY_MULTIPLY + "6 sqr " + KEY_INVERSE, "0.0277777777777778",
                "8 × 1/( sqr( 6 ) )");
    }

    /**
     * Tests for percentage operation.
     */
    @Test
    public void percentageTests() {
        //standard cases
        checkTyped("0" + KEY_PERCENT, "0", "0");
        checkTyped("1" + KEY_PERCENT, "0", "0");
        checkTyped("256" + KEY_PERCENT, "0", "0");
        checkTyped("1151" + KEY_PERCENT, "0", "0");

        //several operations
        checkTyped("1" + KEY_PERCENT + "2" + KEY_PERCENT + "3" + KEY_PERCENT, "0",
                "0");

        //after dot
        checkTyped("62." + KEY_PERCENT, "0", "0");

        //in a row
        checkTyped("866" + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT,
                "0", "0");
        checkTyped("866" + KEY_ADD + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT,
                "42,180,075.43559148", "866 + 42180075.43559148");
        checkTyped("866/" + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT + KEY_PERCENT,
                "0.0000000866", "866 ÷ 0.0000000866");

        //after unary
        checkTyped("8" + KEY_NEG + KEY_PERCENT, "0", "0");
        checkTyped("49- sqr" + KEY_PERCENT, "1,176.49", "49 - 1176.49");
        checkTyped("64/" + KEY_SQRT + KEY_PERCENT, "0.08", "64 ÷ 0.08");

        //after binary
        checkTyped("564-" + KEY_PERCENT, "3,180.96", "564 - 3180.96");
        checkTyped("6522456-" + KEY_PERCENT, "425,424,322,719.36",
                "6522456 - 425424322719.36");
        checkTyped("55/" + KEY_PERCENT, "0.55", "55 ÷ 0.55");
        checkTyped("1567/" + KEY_PERCENT, "15.67", "1567 ÷ 15.67");

        //after equals
        checkTyped("73=" + KEY_PERCENT, "0", "0");
        checkTyped("53" + KEY_ADD + "1 2 = " + KEY_PERCENT, "42.25",
                "42.25");
        checkTyped("53/12=" + KEY_PERCENT, "0.0441666666666667",
                "0.0441666666666667");

        //percent after second inputted
        checkTyped("8" + KEY_MULTIPLY + "6" + KEY_PERCENT, "0.06",
                "8 × 0.06");
        checkTyped("856-30" + KEY_PERCENT, "256.8", "856 - 256.8");

        //after second calculating
        checkTyped("8" + KEY_MULTIPLY + "6 sqr" + KEY_PERCENT, "0.36",
                "8 × 0.36");
        checkTyped("1" + KEY_ADD + "2" + KEY_ADD + "3" + KEY_ADD + "4" + KEY_INVERSE + KEY_PERCENT,
                "0.015", "1 + 2 + 3 + 0.015");
    }

    /**
     * Tests for equals operation.
     */
    @Test
    public void equalsTests() {
        //standard cases
        checkTyped("0=", "0", "");
        checkTyped("1=", "1", "");
        checkTyped("256=", "256", "");
        checkTyped("1151=", "1,151", "");

        //several equals operations
        checkTyped("1=2=3=", "3", "");

        //after dot
        checkTyped("62.=", "62", "");

        //in a row without binary set
        checkTyped("866=====", "866", "");

        //in a row with binary set
        checkTyped("866" + KEY_ADD + "123=====", "1,481", "");

        //after unary without binary set
        checkTyped("8" + KEY_NEG + "=", "-8", "");
        checkTyped("49 sqr =", "2,401", "");
        checkTyped("1234" + KEY_SQRT + "=", "35.12833614050059", "");
        checkTyped("0.000001" + KEY_INVERSE + "=", "1,000,000", "");

        //after unary with binary set
        checkTyped("5" + KEY_ADD + "8" + KEY_NEG + "=", "-3", "");
        checkTyped("5" + KEY_ADD + "8" + KEY_NEG + "==", "-11", "");

        checkTyped("7543" + KEY_MULTIPLY + "49 sqr =", "18,110,743", "");
        checkTyped("7543" + KEY_MULTIPLY + "49 sqr ==", "43,483,893,943",
                "");

        checkTyped("0/3600000000" + KEY_SQRT + "=", "0", "");
        checkTyped("0/3600000000" + KEY_SQRT + "==", "0", "");

        checkTyped("213" + KEY_MULTIPLY + "1" + KEY_INVERSE + "=", "213",
                "");
        checkTyped("213" + KEY_MULTIPLY + "1" + KEY_INVERSE + "==", "213",
                "");

        //after binary
        checkTyped("16" + KEY_ADD + "=", "32", "");
        checkTyped("16" + KEY_ADD + "==", "48", "");

        checkTyped("344363" + KEY_MULTIPLY + "=", "118,585,875,769", "");
        checkTyped("344363" + KEY_MULTIPLY + "===", "1.40626099319007e+22",
                "");

        //after percent
        checkTyped("6" + KEY_PERCENT + "=", "0", "");
        checkTyped("6" + KEY_ADD + KEY_PERCENT + "=", "6.36", "");
        checkTyped("6" + KEY_MULTIPLY + KEY_PERCENT + "==", "0.0216", "");

        //equals after second inputted
        checkTyped("8" + KEY_MULTIPLY + "6=", "48", "");

        //equals after second calculated
        checkTyped("856-30 sqr =", "-44", "");

        //after error
        checkTyped("/0==", "0", "");
    }

    /**
     * Tests for exceptions.
     */
    @Test
    public void exceptionTests() {
        //overflow
        //add
        checkException("1000000000 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY + "1000000000000000=======" +
                        "=============================================" + KEY_MULTIPLY + "10===" + KEY_ADD + "=========",
                OVERFLOW_MESSAGE);

        //subtract
        checkException("1000000000 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY + "1000000000000000======" +
                "==============================================" + KEY_MULTIPLY + "10===-===========", OVERFLOW_MESSAGE);

        //multiply
        checkException("1000000000 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY + "1000000000000000======" +
                "==============================================" + KEY_MULTIPLY + "10====", OVERFLOW_MESSAGE);

        //divide
        checkException("0.000000001 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY + "0.000000000000001====" +
                "================================================/10====", OVERFLOW_MESSAGE);

        //sqr
        checkException("1000000000 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", OVERFLOW_MESSAGE);
        checkException("0.000000001 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", OVERFLOW_MESSAGE);

        //percentage
        checkException("1000000000 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY + "1000000000000000======" +
                        "==============================================" + KEY_MULTIPLY + "10===" + KEY_ADD +
                        KEY_PERCENT, OVERFLOW_MESSAGE);
        checkException("0.000000001 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY + "0.000000000000001=====" +
                "===============================================/10===" + KEY_MULTIPLY + KEY_PERCENT, OVERFLOW_MESSAGE);

        //invalid input
        checkException("1" + KEY_NEG + KEY_SQRT, INVALID_INPUT_MESSAGE);
        checkException("8" + KEY_NEG + KEY_SQRT, INVALID_INPUT_MESSAGE);

        //divide by zero
        checkException("14/0=", DIVIDE_BY_ZERO_MESSAGE);
        checkException("0" + KEY_INVERSE, DIVIDE_BY_ZERO_MESSAGE);

        //divide zero by zero
        checkException("0/0=", DIVIDE_ZERO_BY_ZERO_MESSAGE);
    }

    /**
     * Tests for bounds.
     */
    @Test
    public void boundaryTests() {
        //string for calculating number 1.e+9999
        String oneDotEPlusFourNines = "1000000000 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY +
                "10000000000" + "00000====================================================" + KEY_MULTIPLY + "10===";

        //string for calculating number 1.e-9999
        String theSmallestNumber = "0.000000001 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr" + KEY_MULTIPLY + "0.00000000" +
                "00000001================================================" + KEY_MULTIPLY + "0.000000000000001=";

        //string for calculating number 999999999999999949999.....9.9999...9.8
        //(16 nines, then digit 4, then 9983 nines, dot, and 9998 nines, and the last one digit is 8)
        String boundaryNumber = oneDotEPlusFourNines + KEY_MULTIPLY + "0.5=" + KEY_MULTIPLY + "0.1===============" +
                KEY_MS + "/5=" + KEY_MULTIPLY + "10================-" + KEY_INVERSE + "==-" + KEY_MR + "=" +
                KEY_MULTIPLY + "10=" + KEY_MULTIPLY + "0.1=" + KEY_MS + "esc" + oneDotEPlusFourNines + KEY_MULTIPLY +
                "9" + KEY_ADD + KEY_MR + "=";

        //max numbers
        //right
        checkTyped(boundaryNumber + KEY_MS + "esc" + theSmallestNumber + KEY_ADD + KEY_MR + "=",
                "9.999999999999999e+9999");
        checkOverflowExceptionWithoutResetMemory(theSmallestNumber + KEY_ADD + "=" + KEY_ADD + KEY_MR + "=");
        checkOverflowExceptionWithoutResetMemory(theSmallestNumber + KEY_ADD + "==" + KEY_ADD + KEY_MR + "=");

        //left
        checkTypedWithoutResetMemory(KEY_MR + KEY_NEG + KEY_MS + "esc" + theSmallestNumber + KEY_MULTIPLY +
                "-1" + KEY_ADD + KEY_MR,"-9.999999999999999e+9999");
        checkOverflowExceptionWithoutResetMemory(theSmallestNumber + KEY_MULTIPLY + "-1" + KEY_ADD + "=" +
                KEY_ADD + KEY_MR + "=");
        checkOverflowExceptionWithoutResetMemory(theSmallestNumber + KEY_MULTIPLY + "-1" + KEY_ADD + "==" +
                KEY_ADD + KEY_MR + "=");

        //min numbers
        checkTyped(theSmallestNumber + KEY_MS + KEY_MULTIPLY + "2=-" + KEY_MR + "=",
                "1.e-9999");

        checkTypedWithoutResetMemory(KEY_MR + KEY_MULTIPLY + "10" + KEY_MULTIPLY + "0.1=",
                "1.e-9999");
        checkTypedWithoutResetMemory(KEY_MR + KEY_MULTIPLY + "10/10=", "1.e-9999");

        checkOverflowExceptionWithoutResetMemory(KEY_MR + KEY_MULTIPLY + "0.1=");
        checkOverflowExceptionWithoutResetMemory(KEY_MR + "/10=");
        checkOverflowExceptionWithoutResetMemory(KEY_MR + KEY_MULTIPLY + "0.01=");
        checkOverflowExceptionWithoutResetMemory(KEY_MR + "/100=");
    }

    /**
     * Checks that screen {@code Label} has required text after clicking on several {@code Button}.
     *
     * @param buttons            several {@code Button} that should be clicked.
     * @param expectedScreenText required text on screen {@code Label} after clicking.
     */
    private void checkTyped(String buttons, String expectedScreenText) {
        resetAll();
        checkTypedWithoutResetMemory(buttons, expectedScreenText);
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
     * Checks that screen {@code Label} has required text after clicking on several {@code Button}.
     * This method does not resets memory to its primary stage.
     *
     * @param buttons            several {@code Button} that should be clicked.
     * @param expectedScreenText required text on screen {@code Label} after clicking.
     */
    private void checkTypedWithoutResetMemory(String buttons, String expectedScreenText) {
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        pressKeyboard(buttons);

        assertEquals(expectedScreenText, getLabeledBySelector(SCREEN_LABEL_ID).getText());
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
        checkButtonsAfterException(getButtonBySelector(MEMORY_SHOW_ID).isDisabled());
    }

    /**
     * Checks that exception was thrown after clicking several {@code Button}.
     * This method does not reset application to its primary stage.
     *
     * @param buttons            several {@code Button} that should be clicked.
     */
    private void checkOverflowExceptionWithoutResetMemory(String buttons) {
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        checkTypedWithoutResetMemory(buttons, OVERFLOW_MESSAGE);
        checkButtonsAfterException(getButtonBySelector(MEMORY_SHOW_ID).isDisabled());
    }

    /**
     * Checks that required buttons are disabled or enabled after exception thrown.
     *
     * @param isMemoryDisabled false if memory contains something and memory buttons are enabled or true otherwise.
     */
    private void checkButtonsAfterException(boolean isMemoryDisabled) {
        Button[] enabledButtons = getSeveralButtonsBySelector(CLEAR_ALL_ID, CLEAR_TEXT_ID, BACKSPACE_ID,
                ZERO_ID, ONE_ID, TWO_ID, THREE_ID, FOUR_ID, FIVE_ID, SIX_ID, SEVEN_ID, EIGHT_ID, NINE_ID, EQUALS_ID);
        Button[] disabledButtons = getSeveralButtonsBySelector(MEMORY_CLEAR_ID, MEMORY_RECALL_ID,
                MEMORY_ADD_ID, MEMORY_SUBTRACT_ID, MEMORY_STORE_ID, PERCENT_ID, SQRT_ID, SQR_ID, INVERSE_ID, DIVIDE_ID,
                MULTIPLY_ID, SUBTRACT_ID, ADD_ID, NEGATE_ID, DOT_ID);

        for (Button button : enabledButtons) {
            assertFalse(button.isDisabled());
        }

        for (Button button : disabledButtons) {
            assertTrue(button.isDisabled());
        }

        assertEquals(isMemoryDisabled, getButtonBySelector(MEMORY_SHOW_ID).isDisabled());
    }
}
