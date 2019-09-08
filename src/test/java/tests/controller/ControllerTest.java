package tests.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
        keyboardTests();

        showNavigationPanelTest();
        moveEquationLabelTextTest();

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
    }

    /**
     * Tests for keyboard handling.
     */
    private void keyboardTests() {
        //digits
        checkKeyboardForOperations("1 2 3 4 5 6 7 8 9 0 .",
                "1,234,567,890.", "");

        checkKeyboardForOperations("num1 num2 num3 num4 num5 num6 num7 num8 num9 num0 ",
                "1,234,567,890", "");

        //clearing
        checkKeyboardForOperations("1 2 3 4 5 backspace backspace backspace", "12",
                "");
        checkKeyboardForOperations("1 2 3 4 5 shift+= del", "0",
                "12345 +");
        checkKeyboardForOperations("1 2 3 4 5 shift+= esc", "0", "");

        //operations
        //add
        checkKeyboardForOperations("1 2 3 4 5 shift+= 1 2 3 4 5 shift+=", "24,690",
                "12345 + 12345 +");
        checkKeyboardForOperations("1 2 3 4 5 num+ 1 2 3 4 5 num+", "24,690",
                "12345 + 12345 +");

        //subtract
        checkKeyboardForOperations("9 8 7 6 5 - 1 2 3 4 5 -", "86,420",
                "98765 - 12345 -");
        checkKeyboardForOperations("9 8 7 6 5 num- 1 2 3 4 5 num-", "86,420",
                "98765 - 12345 -");

        //multiply
        checkKeyboardForOperations("1 2 3 4 5 shift+8 1 2 3 4 5 shift+8",
                "152,399,025", "12345 × 12345 ×");
        checkKeyboardForOperations("1 2 3 4 5 num* 1 2 3 4 5 num*",
                "152,399,025", "12345 × 12345 ×");

        //divide
        checkKeyboardForOperations("5 0 0 0 / 5 /",
                "1,000", "5000 ÷ 5 ÷");
        checkKeyboardForOperations("5 0 0 0 num/ 5 num/",
                "1,000", "5000 ÷ 5 ÷");

        //negate
        checkKeyboardForOperations("1 2 3 4 5 F9", "-12,345", "");
        checkKeyboardForOperations("1 2 3 4 5 shift+= F9", "-12,345",
                "12345 + negate( 12345 )");

        //sqrt
        checkKeyboardForOperations("1 0 0 shift+2", "10",
                "√( 100 )");
        checkKeyboardForOperations("1 F9 shift+2", "Invalid input",
                "√( -1 )");

        //inverse
        checkKeyboardForOperations("0 . 1 R", "10", "1/( 0.1 )");
        checkKeyboardForOperations("R", "Cannot divide by zero",
                "1/( 0 )");

        //percent
        checkKeyboardForOperations("5 shift+= 5 shift+5", "0.25",
                "5 + 0.25");
        checkKeyboardForOperations("1 5 0 shift+8 2 1 0 shift+5", "2.1",
                "150 × 2.1");

        //equals
        checkKeyboardForOperations("1 2 3 4 5 shift+= = = =", "49,380",
                "");
        checkKeyboardForOperations("1 2 3 4 5 shift+= enter enter enter", "49,380",
                "");
    }

    /**
     * Tests for showing navigation panel.
     */
    private void showNavigationPanelTest() {
        assertFalse(getNodeBySelector(NAVIGATION_PANEL_ID).isVisible());
        assertFalse(getNodeBySelector(ABOUT_PANEL_ID).isVisible());
        assertFalse(getNodeBySelector(NAVIGATION_BLOCK_ID).isVisible());

        clickOn(getButtonBySelector(NAVIGATION_ID));

        assertTrue(getNodeBySelector(NAVIGATION_PANEL_ID).isVisible());
        assertTrue(getNodeBySelector(ABOUT_PANEL_ID).isVisible());
        assertTrue(getNodeBySelector(NAVIGATION_BLOCK_ID).isVisible());

        clickOn(getButtonBySelector(NAVIGATION_ID));

        assertFalse(getNodeBySelector(NAVIGATION_PANEL_ID).isVisible());
        assertFalse(getNodeBySelector(ABOUT_PANEL_ID).isVisible());
        assertFalse(getNodeBySelector(NAVIGATION_BLOCK_ID).isVisible());
    }

    /**
     * Tests for moving text in equation {@code Label}.
     */
    private void moveEquationLabelTextTest() {
        resetAll();

        clickButtons("sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr");

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

        clickButtons("sqr sqr sqr sqr sqr sqr");

        clickOn(leftArrow);

        assertTrue(rightArrow.isVisible());
        assertTrue(leftArrow.isVisible());
        assertEquals(0.57, equationScroll.getHvalue());

        clickOn(leftArrow);

        assertTrue(rightArrow.isVisible());
        assertFalse(leftArrow.isVisible());
        assertEquals(equationScroll.getHmax(), equationScroll.getHvalue());

        clickOn(rightArrow);

        assertTrue(leftArrow.isVisible());
        assertTrue(rightArrow.isVisible());
        assertEquals(0.43000000000000005, equationScroll.getHvalue());

        clickOn(rightArrow);

        assertTrue(leftArrow.isVisible());
        assertFalse(rightArrow.isVisible());
        assertEquals(equationScroll.getHmin(), equationScroll.getHvalue());
    }

    /**
     * Tests for appending digits.
     */
    private void appendDigitTests() {
        //can append
        {
            //without operations
            //no commas
            checkTyped("1", "1");
            checkTyped("2", "2");
            checkTyped("3", "3");
            checkTyped("4", "4");
            checkTyped("5", "5");
            checkTyped("6", "6");
            checkTyped("7", "7");
            checkTyped("8", "8");
            checkTyped("9", "9");

            checkTyped("1 2 3", "123");
            checkTyped("7 3 6", "736");

            //commas
            checkTyped("4 8 9 0", "4,890");
            checkTyped("1 2 3 4 5 6 7 8 9 0", "1,234,567,890");

            //16 digits
            checkTyped("1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8", "1,122,334,455,667,788");
            checkTyped("3 2 5 9 0 0 0 2 3 4 0 0 0 0 2 3", "3,259,000,234,000,023");

            //with negated number ( minus should be saved )
            //no commas
            checkTyped("1 neg 1", "-11");
            checkTyped("8 neg 9 6", "-896");

            //commas
            checkTyped("6 neg 1 2 3 7", "-61,237");
            checkTyped("3 neg 7 7 7 4 2 3 6 5 2 3 4 5 2", "-37,774,236,523,452");

            //16 digits
            checkTyped("7 neg 8 9 0 6 3 5 7 8 9 0 0 0 0 0 0", "-7,890,635,789,000,000");
            checkTyped("6 neg 2 3 5 4 8 3 4 6 3 4 6 8 3 4 5", "-6,235,483,463,468,345");

            //after unary ( but not negate ) operation pressed
            checkTyped("1 sqr 7 5 2", "752");
            checkTyped("7 2 3 8 sqr 1 4 7 8 5", "14,785");

            checkTyped("9 sqrt 8 2 5", "825");
            checkTyped("3 2 5 2 7 3 sqrt 7 2 3 5 2 5 2 5", "72,352,525");

            checkTyped("7 1 7 inverse 7", "7");
            checkTyped("7 2 3 5 inverse 1 2 4 5 3 4 7 6 4 3 6", "12,453,476,436");

            //after binary operations
            checkTyped("9 + 2", "2");
            checkTyped("8 7 6 2 4 5 2 + 6 3 3 3 3", "63,333");

            checkTyped("3 2 4 - 0", "0");
            checkTyped("3 2 5 4 - 7 3 2 4 5 5 2", "7,324,552");

            checkTyped("1 2 3 1 3 * 1", "1");
            checkTyped("1 1 5 7 * 2 1 3 7 6", "21,376");

            checkTyped("2 3 / 7 8", "78");
            checkTyped("2 4 2 2 2 2 / 1 2 3 0 0 0", "123,000");

            //after equals
            checkTyped("1 3 2 5 = 1 3 1", "131");
            checkTyped("7 6 5 4 5 2 4 5 2 = 1 3 1 3 1 3 3 1 5 2 1 3 2 5",
                    "13,131,331,521,325");

            //after error
            checkTyped("/ 0 = 1 2 3", "123");
            checkTyped("/ 0 = 8 2 3 4 6 2 9", "8,234,629");

            //after dot
            checkTyped("1 2 3 . 9 8 7 1 4", "123.98714");
            checkTyped("2 5 7 3 5 2 5 . 3 4", "2,573,525.34");

            //after dot with 16 digits summary
            checkTyped("7 8 4 . 0 9 7 2 3 4 7 8 5 9 8 2 5", "784.0972347859825");
            checkTyped("1 2 3 0 1 9 . 8 4 9 8 5 3 3 5 6 4", "123,019.8498533564");

            //after dot with 17 digits summary ( starts with 0. )
            checkTyped("0 . 1 2 2 3 4 5 8 9 0 1 2 4 5 6 7 8", "0.1223458901245678");
            checkTyped("0 . 1 4 3 1 4 1 3 5 3 2 1 5 7 5 6 7", "0.1431413532157567");

            //after dot and negated
            checkTyped("7 neg 2 5 . 7 2 5 7 2", "-725.72572");
            checkTyped("7 8 6 3 2 . 2 2 4 neg 3 2 6 7 8", "-78,632.22432678");

            //after dot with 16 digits summary and negated
            checkTyped("9 neg . 0 3 4 5 6 7 8 2 3 4 5 9 8 7 5", "-9.034567823459875");
            checkTyped("1 2 3 6 5 7 . 2 9 5 8 2 neg 0 0 2 5 6", "-123,657.2958200256");

            //after dot with 17 digits summary ( starts with 0. ) and negated
            checkTyped("0 . 8 5 2 9 8 neg 2 3 5 4 6 7 3 6 7 6 5", "-0.8529823546736765");
            checkTyped("0 . 1 3 7 6 neg 6 6 3 5 3 4 6 8 7 6 6 7", "-0.1376663534687667");

            //after backspace
            checkTyped("backspace 1 3 2", "132");
            checkTyped("backspace 2 5 7 5 3 7 3 5 6", "257,537,356");

            checkTyped("8 backspace 3 2 4", "324");
            checkTyped("7 backspace 1 5 3 1 6 5 1 6", "15,316,516");

            checkTyped("6 4 backspace 6", "66");
            checkTyped("1 2 3 5 backspace 6 4 3", "123,643");
        }

        //can not append
        {
            checkTyped("0", "0");
            checkTyped("0 0", "0");

            //17 digits
            checkTyped("1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7", "1,234,567,890,123,456");
            checkTyped("8 7 9 8 4 7 1 9 5 7 1 9 8 7 5 9 1", "8,798,471,957,198,759");

            //more than 17 digits
            checkTyped("2 1 9 8 3 7 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 1",
                    "2,198,370,919,080,518");
            checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 2",
                    "1,209,847,102,458,012");

            //17 and negate
            checkTyped("1 2 3 4 5 6 7 8 9 neg 0 1 2 3 4 5 6 7", "-1,234,567,890,123,456");
            checkTyped("8 7 9 8 4 neg 7 1 9 5 7 1 9 8 7 5 9 1", "-8,798,471,957,198,759");

            //more than 17 and negate
            checkTyped("2 1 9 neg 8 3 7 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 1",
                    "-2,198,370,919,080,518");
            checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 neg 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 2",
                    "-1,209,847,102,458,012");

            //17 and dot
            checkTyped("1 2 3 4 5 6 7 8 9 . 0 1 2 3 4 5 6 7", "123,456,789.0123456");
            checkTyped("8 7 9 8 4 . 7 1 9 5 7 1 9 8 7 5 9 1", "87,984.71957198759");

            //more than 17 and dot
            checkTyped("2 1 9 . 8 3 7 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 1",
                    "219.8370919080518");
            checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 . 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 2",
                    "120,984,710,245.8012");

            //17 and dot and negate
            checkTyped("1 2 3 4 5 6 neg 7 8 9 . 0 1 2 3 4 5 6 7", "-123,456,789.0123456");
            checkTyped("8 7 9 neg 8 4 . 7 1 9 5 7 1 9 8 7 5 9 1", "-87,984.71957198759");

            //more than 17 and dot and negate
            checkTyped("2 1 9 . 8 3 7 neg 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 1",
                    "-219.8370919080518");
            checkTyped("1 2 0 neg 9 8 4 7 1 0 2 4 5 . 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 2",
                    "-120,984,710,245.8012");

            //18 and dot and starts with 0.
            checkTyped("0 . 8 7 5 2 3 4 5 6 8 9 0 0 7 6 3 4 5", "0.8752345689007634");
            checkTyped("0 . 7 4 3 6 3 7 3 8 7 3 6 3 6 3 6 3 6", "0.7436373873636363");

            //more than 18 and dot and starts with 0.
            checkTyped("0 . 1 9 8 7 8 9 1 3 7 5 9 3 2 1 7 5 2 4 3 0 6 2 6 2 3 6 5 2 5",
                    "0.1987891375932175");
            checkTyped("0 . 3 2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 7 6 0 2 6 0 2 8 6",
                    "0.3242384729375982");

            //18 and dot and starts with 0. and negate
            checkTyped("0 . 8 7 5 2 3 4 5 neg 6 8 9 0 0 7 6 3 4 5", "-0.8752345689007634");
            checkTyped("0 . 7 4 neg 3 6 3 7 3 8 7 3 6 3 6 3 6 3 6", "-0.7436373873636363");

            //more than 18 and dot and starts with 0. and negate
            checkTyped("0 . 1 9 8 7 8 neg 9 1 3 7 5 9 3 2 1 7 5 2 4 3 0 6 2 6 2 3 6 5 2 5",
                    "-0.1987891375932175");
            checkTyped("0 . 3 neg 2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 7 6 0 2 6 0 2 8 6",
                    "-0.3242384729375982");
        }
    }

    /**
     * Tests for appending dot.
     */
    private void appendDotTests() {
        //can append
        {
            //without operations
            //no commas
            checkTyped("1 .", "1.");
            checkTyped("2 .", "2.");
            checkTyped("3 .", "3.");
            checkTyped("4 .", "4.");
            checkTyped("5 .", "5.");
            checkTyped("6 .", "6.");
            checkTyped("7 .", "7.");
            checkTyped("8 .", "8.");
            checkTyped("9 .", "9.");

            checkTyped("1 0 .", "10.");
            checkTyped("1 1 1 .", "111.");
            checkTyped("1 2 3 .", "123.");
            checkTyped("7 3 6 .", "736.");

            //commas
            checkTyped("4 8 9 0 .", "4,890.");
            checkTyped("1 2 3 4 5 6 7 8 9 0 .", "1,234,567,890.");
            checkTyped("1 2 4 0 9 1 7 8 2 5 9 7 1 .", "1,240,917,825,971.");
            checkTyped("2 1 8 1 7 5 .", "218,175.");

            //16 digits
            checkTyped("1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 .", "1,122,334,455,667,788.");
            checkTyped("5 8 9 3 1 2 7 5 9 2 3 7 5 9 2 2 .", "5,893,127,592,375,922.");

            //17 digits
            checkTyped("1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 8 .", "1,234,567,890,123,456.");
            checkTyped("8 7 9 8 4 7 1 9 5 7 1 9 8 7 5 9 4 .", "8,798,471,957,198,759.");

            //more than 17 digits
            checkTyped("2 1 9 8 3 7 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 .",
                    "2,198,370,919,080,518.");
            checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 .",
                    "1,209,847,102,458,012.");

            //17 and negate
            checkTyped("1 2 3 4 5 6 7 8 9 neg 0 1 2 3 4 5 6 7 .", "-1,234,567,890,123,456.");
            checkTyped("8 7 9 8 4 neg 7 1 9 5 7 1 9 8 7 5 9 1 .", "-8,798,471,957,198,759.");

            //more than 17 and negate
            checkTyped("2 1 9 neg 8 3 7 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 1 .",
                    "-2,198,370,919,080,518.");
            checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 neg 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 2 .",
                    "-1,209,847,102,458,012.");

            //with negated number
            //no commas
            checkTyped("1 neg .", "-1.");
            checkTyped("5 neg .", "-5.");
            checkTyped("8 neg 2 7 .", "-827.");
            checkTyped("8 neg 9 6 .", "-896.");

            //commas
            checkTyped("6 1 2 3 7 neg .", "-61,237.");
            checkTyped("8 7 3 4 neg .", "-8,734.");
            checkTyped("2 neg 6 2 3 4 6 2 6 .", "-26,234,626.");
            checkTyped("3 neg 7 7 7 4 2 3 6 5 2 3 4 5 2 .", "-37,774,236,523,452.");

            //16 digits
            checkTyped("7 8 9 0 6 3 5 7 8 9 0 0 0 0 0 0 neg .", "-7,890,635,789,000,000.");
            checkTyped("1 7 6 5 3 2 3 5 2 3 6 5 8 3 4 5 neg .", "-1,765,323,523,658,345.");
            checkTyped("8 neg 2 3 4 8 7 6 4 3 5 9 4 2 5 8 3 .", "-8,234,876,435,942,583.");
            checkTyped("6 neg 2 3 5 4 8 3 4 6 3 4 6 8 3 4 5 .", "-6,235,483,463,468,345.");

            //after unary ( but not negate ) operation pressed
            checkTyped("1 sqr .", "0.");
            checkTyped("7 2 3 8 sqr .", "0.");

            checkTyped("9 5 3 sqrt .", "0.");
            checkTyped("3 2 5 2 7 3 sqrt .", "0.");

            checkTyped("7 1 7 7 inverse .", "0.");
            checkTyped("7 2 3 5 inverse .", "0.");

            //after binary operations
            checkTyped("9 + .", "0.");
            checkTyped("8 7 6 2 4 5 2 + .", "0.");

            checkTyped("3 2 4 - .", "0.");
            checkTyped("3 2 5 4 - .", "0.");

            checkTyped("1 2 3 1 3 * .", "0.");
            checkTyped("1 1 5 7 * .", "0.");

            checkTyped("2 3 / .", "0.");
            checkTyped("2 4 2 2 2 2 / .", "0.");

            //after percent
            checkTyped("1 4 % .", "0.");
            checkTyped("5 1 3 5 2 1 5 % .", "0.");

            //after equals
            checkTyped("1 3 2 5 = .", "0.");
            checkTyped("7 6 5 4 5 2 4 5 2 = .", "0.");

            checkTyped("1 1 + 6 7 = .", "0.");
            checkTyped("8 2 3 5 2 6 / 2 4 3 6 2 = .", "0.");

            //after backspace
            checkTyped("1 2 3 backspace .", "12.");
            checkTyped("2 1 5 2 3 4 3 backspace .", "215,234.");
        }

        //can not append
        {
            checkTyped(". .", "0.");
            checkTyped(". .", "0.");
            checkTyped(". . .", "0.");

            //17 and dot
            checkTyped("1 2 3 4 5 6 7 8 9 . 0 1 2 3 4 5 6 7 .", "123,456,789.0123456");
            checkTyped("8 7 9 8 4 . 7 1 9 5 7 1 9 8 7 5 9 1 .", "87,984.71957198759");

            //more than 17 and dot
            checkTyped("2 1 9 . 8 3 7 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 1 .",
                    "219.8370919080518");
            checkTyped("1 2 0 9 8 4 7 1 0 2 4 5 . 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 2 .",
                    "120,984,710,245.8012");

            //17 and dot and negate
            checkTyped("1 2 3 4 5 6 neg 7 8 9 . 0 1 2 3 4 5 6 7 .", "-123,456,789.0123456");
            checkTyped("8 7 9 neg 8 4 . 7 1 9 5 7 1 9 8 7 5 9 1 .", "-87,984.71957198759");

            //more than 17 and dot and negate
            checkTyped("2 1 9 . 8 3 7 neg 0 9 1 9 0 8 0 5 1 8 3 2 5 0 7 1 0 5 1 .",
                    "-219.8370919080518");
            checkTyped("1 2 0 neg 9 8 4 7 1 0 2 4 5 . 8 0 1 2 8 5 0 9 3 2 8 0 5 8 2 4 0 9 2 .",
                    "-120,984,710,245.8012");

            //18 and dot and starts with 0.
            checkTyped("0 . 8 7 5 2 3 4 5 6 8 9 0 0 7 6 3 4 5 .", "0.8752345689007634");
            checkTyped("0 . 7 4 3 6 3 7 3 8 7 3 6 3 6 3 6 3 6 .", "0.7436373873636363");

            //more than 18 and dot and starts with 0.
            checkTyped("0 . 1 9 8 7 8 9 1 3 7 5 9 3 2 1 7 5 2 4 3 0 6 2 6 2 3 6 5 2 5 .",
                    "0.1987891375932175");
            checkTyped("0 . 3 2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 7 6 0 2 6 0 2 8 6 .",
                    "0.3242384729375982");

            //18 and dot and starts with 0. and negate
            checkTyped("0 . 8 7 5 2 3 4 5 neg 6 8 9 0 0 7 6 3 4 5 .", "-0.8752345689007634");
            checkTyped("0 . 7 4 neg 3 6 3 7 3 8 7 3 6 3 6 3 6 3 6 .", "-0.7436373873636363");

            //more than 18 and dot and starts with 0. and negate
            checkTyped("0 . 1 9 8 7 8 neg 9 1 3 7 5 9 3 2 1 7 5 2 4 3 0 6 2 6 2 3 6 5 2 5 .",
                    "-0.1987891375932175");
            checkTyped("0 . 3 neg 2 4 2 3 8 4 7 2 9 3 7 5 9 8 2 7 6 0 2 6 0 2 8 6 .",
                    "-0.3242384729375982");

            //already with dot
            checkTyped("1 4 1 4 . 1 . 2 . .", "1,414.12");
            checkTyped("1 2 3 . 7 6 5 .", "123.765");
            checkTyped("6 2 4 3 6 2 . 5 . 3 4 .", "624,362.534");
            checkTyped("8 7 6 4 . . . .", "8,764.");
        }
    }

    /**
     * Tests for backspace.
     */
    private void backspaceTests() {
        //last digit
        checkTyped("backspace", "0");
        checkTyped("0 backspace", "0");
        checkTyped("1 backspace", "0");
        checkTyped("2 backspace", "0");
        checkTyped("3 backspace", "0");
        checkTyped("4 backspace", "0");
        checkTyped("5 backspace", "0");
        checkTyped("6 backspace", "0");
        checkTyped("7 backspace", "0");
        checkTyped("8 backspace", "0");
        checkTyped("9 backspace", "0");

        //not last digit
        //no commas
        checkTyped("2 1 3 backspace", "21");
        checkTyped("1 4 1 5 backspace", "141");

        //commas
        checkTyped("1 4 5 1 3 5 1 5 backspace", "1,451,351");
        checkTyped("6 2 4 3 6 2 6 7 2 backspace", "62,436,267");

        //after dot
        checkTyped("1 4 2 1 4 . backspace", "14,214");
        checkTyped("2 1 3 5 1 5 1 2 5 . backspace", "213,515,125");

        //after negated
        checkTyped("1 4 1 5 1 5 2 1 neg backspace", "-1,415,152");
        checkTyped("6 5 6 3 2 5 2 neg backspace", "-656,325");

        checkTyped("6 2 3 5 2 6 neg 2 1 3 1 backspace", "-623,526,213");
        checkTyped("6 5 2 5 3 neg 1 2 3 1 backspace", "-65,253,123");

        //after unary operation ( but not negate )
        checkTyped("1 sqr backspace", "1");
        checkTyped("1 0 0 sqr backspace", "10,000");

        checkTyped("9 0 0 sqrt backspace", "30");
        checkTyped("2 5 0 0 0 0 0 0 sqrt backspace", "5,000");

        checkTyped("8 inverse backspace", "0.125");
        checkTyped("0 . 0 0 0 1 2 5 inverse backspace", "8,000");

        //after binary operation
        checkTyped("1 4 1 4 + backspace", "1,414");
        checkTyped("2 1 3 6 2 + backspace", "21,362");

        checkTyped("3 2 5 4 2 5 - backspace", "325,425");
        checkTyped("1 4 - backspace", "14");

        checkTyped("7 6 3 5 3 * backspace", "76,353");
        checkTyped("8 7 3 * backspace", "873");

        checkTyped("1 3 2 / backspace", "132");
        checkTyped("5 2 3 / backspace", "523");

        //after percent
        checkTyped("1 4 % backspace", "0");
        checkTyped("5 1 3 5 2 1 5 % backspace", "0");

        //after equals
        checkTyped("5 1 4 1 4 = backspace", "51,414");
        checkTyped("4 1 2 1 4 1 4 = backspace", "4,121,414");

        //after error
        checkTyped("/ 0 = backspace", "0");
        checkTyped("1 3 / 0 backspace", "0");

        //after backspace
        checkTyped("1 2 3 backspace backspace", "1");
        checkTyped("2 1 5 2 3 4 3 backspace backspace", "21,523");
    }

    /**
     * Tests for clear operations ( clear text and clear all ).
     */
    private void clearTests() {

        //without operations
        checkClear("0");
        checkClear("1");
        checkClear("2");
        checkClear("3");
        checkClear("4");
        checkClear("5");
        checkClear("6");
        checkClear("7");
        checkClear("8");
        checkClear("9");

        checkClear("1 2 3");
        checkClear("1 2 3 1 2 4 1 4 5 1 5");

        checkClear("1 . 2 3");
        checkClear("1 2 3 1 2 . 4 1 4 5 1 5");

        //negate
        checkClear("1 2 3 neg");
        checkClear("1 2 3 1 2 4 1 4 5 1 5 neg");

        //unary
        checkClear("1 2 sqr");
        checkClear("1 2 3 1 2 sqrt");
        checkClear("3 8 1 6 2 9 8 4 3 1 2 9 9 inverse");

        //binary
        checkClear("1 2 3 +");
        checkClear("1 4 1 2 9 1 2 4 9 1 2 6 4 9 5 1 -");
        checkClear("3 1 2 4 1 5 2 1 6 5 3 1 5 1 5 1 *");
        checkClear("1 5 9 8 1 7 5 9 1 9 5 8 7 1 3 2 9 5 7 1 9 3 5 7 9 1 7 5 9 1 7 5 9 8 1 /");

        //percent
        checkClear("1 2 %");
        checkClear("1 2 3 1 2 %");

        //equals
        checkClear("1 2 =");
        checkClear("1 2 3 1 2 =");

        //backspace
        checkClear("1 2 backspace");
        checkClear("1 2 3 1 2 backspace");

        //after error
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("/ = 0");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("/ = 0");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("inverse 0");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("inverse 0");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("5 neg sqrt");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("5 neg sqrt");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for add operation.
     */
    private void addTests() {
        //standard cases
        checkTyped("+", "0", "0 +");
        checkTyped("0 +", "0", "0 +");
        checkTyped("1 +", "1", "1 +");
        checkTyped("2 +", "2", "2 +");
        checkTyped("3 +", "3", "3 +");
        checkTyped("4 +", "4", "4 +");
        checkTyped("5 +", "5", "5 +");
        checkTyped("6 +", "6", "6 +");
        checkTyped("7 +", "7", "7 +");
        checkTyped("8 +", "8", "8 +");
        checkTyped("9 +", "9", "9 +");

        //without comma
        checkTyped("1 7 +", "17", "17 +");
        checkTyped("2 5 6 +", "256", "256 +");

        //with comma
        checkTyped("1 1 5 1 5 +", "11,515", "11515 +");
        checkTyped("7 3 4 3 4 7 9 5 6 +", "734,347,956", "734347956 +");

        //several add operations
        checkTyped("1 + 2 + 3", "3",
                "1 + 2 +");
        checkTyped("1 + 2 + 3 +", "6",
                "1 + 2 + 3 +");
        checkTyped("1 0 0 + 1 0 0 0 + 1 0 0 0 0 + 1 0 0 0 0 0", "100,000",
                "100 + 1000 + 10000 +");
        checkTyped("1 0 0 + 1 0 0 0 + 1 0 0 0 0 + 1 0 0 0 0 0 +", "111,100",
                "100 + 1000 + 10000 + 100000 +");

        //after dot
        checkTyped("6 2 . +", "62", "62 +");
        checkTyped("6 2 3 6 2 6 . +", "623,626", "623626 +");

        //after negate
        checkTyped("8 6 6 neg +", "-866", "-866 +");
        checkTyped("9 8 7 9 1 4 8 0 neg +", "-98,791,480", "-98791480 +");

        //after another unary
        checkTyped("8 sqr +", "64", "sqr( 8 ) +");
        checkTyped("1 2 3 sqr +", "15,129", "sqr( 123 ) +");
        checkTyped("4 9 sqrt +", "7", "√( 49 ) +");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqrt +", "60,000",
                "√( 3600000000 ) +");
        checkTyped("1 inverse +", "1", "1/( 1 ) +");
        checkTyped("0 . 0 0 0 0 0 1 inverse +", "1,000,000",
                "1/( 0.000001 ) +");

        //in a row
        checkTyped("5 5 + +", "55", "55 +");
        checkTyped("1 5 6 7 + + + + +", "1,567", "1567 +");

        //after another binary
        checkTyped("1 6 - +", "16", "16 +");
        checkTyped("7 6 2 4 - +", "7,624", "7624 +");
        checkTyped("5 6 4 * +", "564", "564 +");
        checkTyped("6 5 2 2 4 5 6 * +", "6,522,456", "6522456 +");
        checkTyped("1 2 / +", "12", "12 +");
        checkTyped("3 4 4 3 6 3 / +", "344,363", "344363 +");

        //after percent
        checkTyped("7 8 % +", "0", "0 +");
        checkTyped("5 6 2 4 5 % +", "0", "0 +");

        //after equals
        checkTyped("7 3 = +", "73", "73 +");
        checkTyped("5 3 2 6 2 6 = +", "532,626", "532626 +");

        //calculating
        checkTyped("9 2 + 5 4 +", "146", "92 + 54 +");
        checkTyped("8 8 9 8 + 1 2 3 +", "9,021", "8898 + 123 +");

        checkTyped("9 1 3 + 1 4 . 1 +", "927.1", "913 + 14.1 +");
        checkTyped("7 3 6 2 . 5 + 6 3 8 . 1 +", "8,000.6",
                "7362.5 + 638.1 +");

        //engineers
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 + 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 +",
                "1.e+16", "9000000000000000 + 1000000000000000 +");
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 + 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 + 1 +",
                "1.e+16", "9000000000000000 + 1000000000000000 + 1 +");
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 + 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 + 6 +",
                "1.000000000000001e+16",
                "9000000000000000 + 1000000000000000 + 6 +");
        checkTyped("9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 + 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 +",
                "2.e+16", "9999999999999999 + 9999999999999999 +");
    }

    /**
     * Tests for subtract operation.
     */
    private void subtractTests() {
        //standard cases
        checkTyped("-", "0", "0 -");
        checkTyped("0 -", "0", "0 -");
        checkTyped("1 -", "1", "1 -");
        checkTyped("2 -", "2", "2 -");
        checkTyped("3 -", "3", "3 -");
        checkTyped("4 -", "4", "4 -");
        checkTyped("5 -", "5", "5 -");
        checkTyped("6 -", "6", "6 -");
        checkTyped("7 -", "7", "7 -");
        checkTyped("8 -", "8", "8 -");
        checkTyped("9 -", "9", "9 -");

        //without comma
        checkTyped("1 7 -", "17", "17 -");
        checkTyped("2 5 6 -", "256", "256 -");

        //with comma
        checkTyped("1 1 5 1 5 -", "11,515", "11515 -");
        checkTyped("7 3 4 3 4 7 9 5 6 -", "734,347,956", "734347956 -");

        //several subtract operations
        checkTyped("1 - 2 - 3", "3", "1 - 2 -");
        checkTyped("1 - 2 - 3 -", "-4", "1 - 2 - 3 -");
        checkTyped("1 0 0 - 1 0 0 0 - 1 0 0 0 0 - 1 0 0 0 0 0", "100,000",
                "100 - 1000 - 10000 -");
        checkTyped("1 0 0 - 1 0 0 0 - 1 0 0 0 0 - 1 0 0 0 0 0 -", "-110,900",
                "100 - 1000 - 10000 - 100000 -");

        //after dot
        checkTyped("6 2 . -", "62", "62 -");
        checkTyped("6 2 3 6 2 6 . -", "623,626", "623626 -");

        //after negate
        checkTyped("8 6 6 neg -", "-866", "-866 -");
        checkTyped("9 8 7 9 1 4 8 0 neg -", "-98,791,480", "-98791480 -");

        //after another unary
        checkTyped("8 sqr -", "64", "sqr( 8 ) -");
        checkTyped("1 2 3 sqr -", "15,129", "sqr( 123 ) -");
        checkTyped("4 9 sqrt -", "7", "√( 49 ) -");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqrt -", "60,000",
                "√( 3600000000 ) -");
        checkTyped("1 inverse -", "1", "1/( 1 ) -");
        checkTyped("0 . 0 0 0 0 0 1 inverse -", "1,000,000",
                "1/( 0.000001 ) -");

        //in a row
        checkTyped("5 5 - -", "55", "55 -");
        checkTyped("1 5 6 7 - - - - -", "1,567", "1567 -");

        //after another binary
        checkTyped("1 6 + -", "16", "16 -");
        checkTyped("7 6 2 4 + -", "7,624", "7624 -");
        checkTyped("5 6 4 * -", "564", "564 -");
        checkTyped("6 5 2 2 4 5 6 * -", "6,522,456", "6522456 -");
        checkTyped("1 2 / -", "12", "12 -");
        checkTyped("3 4 4 3 6 3 / -", "344,363", "344363 -");

        //after percent
        checkTyped("7 8 % -", "0", "0 -");
        checkTyped("5 6 2 4 5 % -", "0", "0 -");

        //after equals
        checkTyped("7 3 = -", "73", "73 -");
        checkTyped("5 3 2 6 2 6 = -", "532,626", "532626 -");

        //calculating
        checkTyped("9 2 - 5 4 -", "38", "92 - 54 -");
        checkTyped("8 8 9 8 - 1 2 3 -", "8,775", "8898 - 123 -");

        checkTyped("9 1 3 - 1 4 . 1 -", "898.9", "913 - 14.1 -");
        checkTyped("7 3 6 2 . 5 - 6 3 8 . 1 -", "6,724.4",
                "7362.5 - 638.1 -");

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
    private void multiplyTests() {
        //standard cases
        checkTyped("*", "0", "0 ×");
        checkTyped("0 *", "0", "0 ×");
        checkTyped("1 *", "1", "1 ×");
        checkTyped("2 *", "2", "2 ×");
        checkTyped("3 *", "3", "3 ×");
        checkTyped("4 *", "4", "4 ×");
        checkTyped("5 *", "5", "5 ×");
        checkTyped("6 *", "6", "6 ×");
        checkTyped("7 *", "7", "7 ×");
        checkTyped("8 *", "8", "8 ×");
        checkTyped("9 *", "9", "9 ×");

        //without comma
        checkTyped("1 7 *", "17", "17 ×");
        checkTyped("2 5 6 *", "256", "256 ×");

        //with comma
        checkTyped("1 1 5 1 5 *", "11,515", "11515 ×");
        checkTyped("7 3 4 3 4 7 9 5 6 *", "734,347,956", "734347956 ×");

        //several multiply operations
        checkTyped("1 * 2 * 3", "3", "1 × 2 ×");
        checkTyped("1 * 2 * 3 *", "6", "1 × 2 × 3 ×");
        checkTyped("1 0 0 * 1 0 0 0 * 1 0 0 0 0 * 1 0 0 0 0 0", "100,000",
                "100 × 1000 × 10000 ×");
        checkTyped("1 0 0 * 1 0 0 0 * 1 0 0 0 0 * 1 0 0 0 0 0 *", "100,000,000,000,000",
                "100 × 1000 × 10000 × 100000 ×");

        //after dot
        checkTyped("6 2 . *", "62", "62 ×");
        checkTyped("6 2 3 6 2 6 . *", "623,626", "623626 ×");

        //after negate
        checkTyped("8 6 6 neg *", "-866", "-866 ×");
        checkTyped("9 8 7 9 1 4 8 0 neg *", "-98,791,480", "-98791480 ×");

        //after another unary
        checkTyped("8 sqr *", "64", "sqr( 8 ) ×");
        checkTyped("1 2 3 sqr *", "15,129", "sqr( 123 ) ×");
        checkTyped("4 9 sqrt *", "7", "√( 49 ) ×");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqrt *", "60,000",
                "√( 3600000000 ) ×");
        checkTyped("1 inverse *", "1", "1/( 1 ) ×");
        checkTyped("0 . 0 0 0 0 0 1 inverse *", "1,000,000",
                "1/( 0.000001 ) ×");

        //in a row
        checkTyped("5 5 * *", "55", "55 ×");
        checkTyped("1 5 6 7 * * * * *", "1,567", "1567 ×");

        //after another binary
        checkTyped("1 6 + *", "16", "16 ×");
        checkTyped("7 6 2 4 + *", "7,624", "7624 ×");
        checkTyped("5 6 4 - *", "564", "564 ×");
        checkTyped("6 5 2 2 4 5 6 - *", "6,522,456", "6522456 ×");
        checkTyped("1 2 / *", "12", "12 ×");
        checkTyped("3 4 4 3 6 3 / *", "344,363", "344363 ×");

        //after percent
        checkTyped("7 8 % *", "0", "0 ×");
        checkTyped("5 6 2 4 5 % *", "0", "0 ×");

        //after equals
        checkTyped("7 3 = *", "73", "73 ×");
        checkTyped("5 3 2 6 2 6 = *", "532,626", "532626 ×");

        //calculating
        checkTyped("9 2 * 5 *", "460", "92 × 5 ×");
        checkTyped("8 8 9 8 * 1 2 3 *", "1,094,454", "8898 × 123 ×");

        checkTyped("9 1 3 * 1 . 0 1 *", "922.13", "913 × 1.01 ×");
        checkTyped("7 3 6 2 . 5 * 6 3 8 . 1 *", "4,698,011.25",
                "7362.5 × 638.1 ×");

        //engineers
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 * 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 *",
                "9.e+30", "9000000000000000 × 1000000000000000 ×");
        checkTyped("9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 * 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 *",
                "9.999999999999999e+30", "9999999999999999 × 1000000000000000 ×");
        checkTyped("9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 * 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 * 4 *",
                "3.6e+31", "9000000000000000 × 1000000000000000 × 4 ×");
        checkTyped("0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 * 0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 *",
                "0.9999999999999998", "0.9999999999999999 × 0.9999999999999999 ×");
        checkTyped("0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 * 0 . 1 *", "0.1",
                "0.9999999999999999 × 0.1 ×");
        checkTyped("0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 * 0 . 5 *", "0.5",
                "0.9999999999999999 × 0.5 ×");
        checkTyped("0 . 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 * 0 . 6 *", "0.5999999999999999",
                "0.9999999999999999 × 0.6 ×");
        checkTyped("9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 * 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 *",
                "9.999999999999998e+31", "9999999999999999 × 9999999999999999 ×");
    }

    /**
     * Tests for divide operation.
     */
    private void divideTests() {
        //standard cases
        checkTyped("/", "0", "0 ÷");
        checkTyped("0 /", "0", "0 ÷");
        checkTyped("1 /", "1", "1 ÷");
        checkTyped("2 /", "2", "2 ÷");
        checkTyped("3 /", "3", "3 ÷");
        checkTyped("4 /", "4", "4 ÷");
        checkTyped("5 /", "5", "5 ÷");
        checkTyped("6 /", "6", "6 ÷");
        checkTyped("7 /", "7", "7 ÷");
        checkTyped("8 /", "8", "8 ÷");
        checkTyped("9 /", "9", "9 ÷");

        //without comma
        checkTyped("1 7 /", "17", "17 ÷");
        checkTyped("2 5 6 /", "256", "256 ÷");

        //with comma
        checkTyped("1 1 5 1 5 /", "11,515", "11515 ÷");
        checkTyped("7 3 4 3 4 7 9 5 6 /", "734,347,956", "734347956 ÷");

        //several multiply operations
        checkTyped("1 / 2 / 3", "3", "1 ÷ 2 ÷");
        checkTyped("1 / 2 / 3 /", "0.1666666666666667", "1 ÷ 2 ÷ 3 ÷");
        checkTyped("1 0 0 / 1 0 0 0 / 1 0 0 0 0 / 1 0 0 0 0 0", "100,000",
                "100 ÷ 1000 ÷ 10000 ÷");
        checkTyped("1 0 0 / 1 0 0 0 / 1 0 0 0 0 / 1 0 0 0 0 0 /", "0.0000000001",
                "100 ÷ 1000 ÷ 10000 ÷ 100000 ÷");

        //after dot
        checkTyped("6 2 . /", "62", "62 ÷");
        checkTyped("6 2 3 6 2 6 . /", "623,626", "623626 ÷");

        //after negate
        checkTyped("8 6 6 neg /", "-866", "-866 ÷");
        checkTyped("9 8 7 9 1 4 8 0 neg /", "-98,791,480", "-98791480 ÷");

        //after another unary
        checkTyped("8 sqr /", "64", "sqr( 8 ) ÷");
        checkTyped("1 2 3 sqr /", "15,129", "sqr( 123 ) ÷");
        checkTyped("4 9 sqrt /", "7", "√( 49 ) ÷");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqrt /", "60,000",
                "√( 3600000000 ) ÷");
        checkTyped("1 inverse /", "1", "1/( 1 ) ÷");
        checkTyped("0 . 0 0 0 0 0 1 inverse /", "1,000,000",
                "1/( 0.000001 ) ÷");

        //in a row
        checkTyped("5 5 / /", "55", "55 ÷");
        checkTyped("1 5 6 7 / / / / /", "1,567", "1567 ÷");

        //after another binary
        checkTyped("1 6 + /", "16", "16 ÷");
        checkTyped("7 6 2 4 + /", "7,624", "7624 ÷");
        checkTyped("5 6 4 - /", "564", "564 ÷");
        checkTyped("6 5 2 2 4 5 6 - /", "6,522,456", "6522456 ÷");
        checkTyped("1 2 * /", "12", "12 ÷");
        checkTyped("3 4 4 3 6 3 * /", "344,363", "344363 ÷");

        //after percent
        checkTyped("7 8 % /", "0", "0 ÷");
        checkTyped("5 6 2 4 5 % /", "0", "0 ÷");

        //after equals
        checkTyped("7 3 = /", "73", "73 ÷");
        checkTyped("5 3 2 6 2 6 = /", "532,626", "532626 ÷");

        //calculating
        checkTyped("9 2 / 5 /", "18.4", "92 ÷ 5 ÷");
        checkTyped("8 8 9 8 / 1 2 3 /", "72.34146341463415",
                "8898 ÷ 123 ÷");

        checkTyped("9 1 3 / 1 . 0 1 /", "903.960396039604",
                "913 ÷ 1.01 ÷");
        checkTyped("7 3 6 2 . 5 / 6 3 8 . 1 /", "11.53816016298386",
                "7362.5 ÷ 638.1 ÷");

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
    private void negateTests() {
        //standard cases
        checkTyped("neg", "0", "");
        checkTyped("0 neg", "0", "");
        checkTyped("1 neg", "-1", "");
        checkTyped("2 neg", "-2", "");
        checkTyped("3 neg", "-3", "");
        checkTyped("4 neg", "-4", "");
        checkTyped("5 neg", "-5", "");
        checkTyped("6 neg", "-6", "");
        checkTyped("7 neg", "-7", "");
        checkTyped("8 neg", "-8", "");
        checkTyped("9 neg", "-9", "");

        //without comma
        checkTyped("1 7 neg", "-17", "");
        checkTyped("2 5 6 neg", "-256", "");

        //with comma
        checkTyped("1 1 5 1 5 neg", "-11,515", "");
        checkTyped("7 3 4 3 4 7 9 5 6 neg", "-734,347,956", "");

        //several negate operations
        checkTyped("1 neg 2 neg 3", "123", "");
        checkTyped("1 neg 2 neg 3 neg", "-123", "");
        checkTyped("1 0 0 neg 1 0 0 0 neg 1 0 0 0 0 neg 1 0 0 0 0 0", "-1,001,000,100,001,000",
                "");
        checkTyped("1 0 0 neg 1 0 0 0 neg 1 0 0 0 0 neg 1 0 0 0 0 0 neg",
                "1,001,000,100,001,000","");

        //after dot
        checkTyped("6 2 . neg", "-62.", "");
        checkTyped("6 2 3 6 2 6 . neg", "-623,626.", "");

        //in a row
        checkTyped("8 6 6 neg neg neg neg neg", "-866", "");
        checkTyped("9 8 7 9 1 4 8 0 neg neg neg neg neg neg", "98,791,480",
                "");

        //after another unary
        checkTyped("8 sqr neg", "-64", "negate( sqr( 8 ) )");
        checkTyped("1 2 3 sqr neg", "-15,129", "negate( sqr( 123 ) )");
        checkTyped("4 9 sqrt neg", "-7", "negate( √( 49 ) )");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqrt neg", "-60,000",
                "negate( √( 3600000000 ) )");
        checkTyped("1 inverse neg", "-1", "negate( 1/( 1 ) )");
        checkTyped("0 . 0 0 0 0 0 1 inverse neg", "-1,000,000",
                "negate( 1/( 0.000001 ) )");

        //after binary
        checkTyped("1 6 + neg", "-16", "16 + negate( 16 )");
        checkTyped("7 6 2 4 + neg", "-7,624", "7624 + negate( 7624 )");
        checkTyped("5 6 4 - neg", "-564", "564 - negate( 564 )");
        checkTyped("6 5 2 2 4 5 6 - neg", "-6,522,456",
                "6522456 - negate( 6522456 )");
        checkTyped("1 2 * neg", "-12", "12 × negate( 12 )");
        checkTyped("3 4 4 3 6 3 * neg", "-344,363",
                "344363 × negate( 344363 )");
        checkTyped("5 5 / neg", "-55", "55 ÷ negate( 55 )");
        checkTyped("1 5 6 7 / neg", "-1,567", "1567 ÷ negate( 1567 )");

        //after percent
        checkTyped("7 8 % neg", "0", "negate( 0 )");
        checkTyped("5 6 2 4 5 % neg", "0", "negate( 0 )");

        //after equals
        checkTyped("7 3 = neg", "-73", "negate( 73 )");
        checkTyped("5 3 2 6 2 6 = neg", "-532,626", "negate( 532626 )");

        //negating negated
        checkTyped("9 2 / 5 = neg neg", "18.4", "negate( negate( 18.4 ) )");
        checkTyped("8 8 9 8 + 1 2 3 = neg neg neg", "-9,021",
                "negate( negate( negate( 9021 ) ) )");

        //negating after second inputted
        checkTyped("8 * 6 neg", "-6", "8 ×");
        checkTyped("8 5 6 - 3 0 neg", "-30", "856 -");

        //after second calculating
        checkTyped("8 * 6 sqr neg", "-36", "8 × negate( sqr( 6 ) )");
        checkTyped("1 + 2 + 3 + 4 sqr sqr neg", "-256",
                "1 + 2 + 3 + negate( sqr( sqr( 4 ) ) )");
    }

    /**
     * Tests for square operation.
     */
    private void sqrTests() {
        //standard cases
        checkTyped("sqr", "0", "sqr( 0 )");
        checkTyped("0 sqr", "0", "sqr( 0 )");
        checkTyped("1 sqr", "1", "sqr( 1 )");
        checkTyped("2 sqr", "4", "sqr( 2 )");
        checkTyped("3 sqr", "9", "sqr( 3 )");
        checkTyped("4 sqr", "16", "sqr( 4 )");
        checkTyped("5 sqr", "25", "sqr( 5 )");
        checkTyped("6 sqr", "36", "sqr( 6 )");
        checkTyped("7 sqr", "49", "sqr( 7 )");
        checkTyped("8 sqr", "64", "sqr( 8 )");
        checkTyped("9 sqr", "81", "sqr( 9 )");

        //without comma
        checkTyped("1 7 sqr", "289", "sqr( 17 )");
        checkTyped("2 5 6 sqr", "65,536", "sqr( 256 )");

        //with comma
        checkTyped("1 1 5 1 5 sqr", "132,595,225", "sqr( 11515 )");
        checkTyped("7 3 4 3 4 7 9 5 6 sqr", "5.392669204813779e+17",
                "sqr( 734347956 )");

        //several sqr operations
        checkTyped("1 sqr 2 sqr 3", "3", "");
        checkTyped("1 sqr 2 sqr 3 sqr", "9", "sqr( 3 )");
        checkTyped("1 0 0 sqr 1 0 0 0 sqr 1 0 0 0 0 sqr 1 0 0 0 0 0", "100,000",
                "");
        checkTyped("1 0 0 sqr 1 0 0 0 sqr 1 0 0 0 0 sqr 1 0 0 0 0 0 sqr", "10,000,000,000",
                "sqr( 100000 )");

        //after dot
        checkTyped("6 2 . sqr", "3,844", "sqr( 62 )");
        checkTyped("6 2 3 6 2 6 . sqr", "388,909,387,876", "sqr( 623626 )");

        //in a row
        checkTyped("8 6 6 sqr sqr sqr sqr sqr", "1.00131920194e+94",
                "sqr( sqr( sqr( sqr( sqr( 866 ) ) ) ) )");
        checkTyped("9 8 7 9 1 4 8 0 sqr sqr sqr sqr sqr sqr", "4.592482041402361e+511",
                "sqr( sqr( sqr( sqr( sqr( sqr( 98791480 ) ) ) ) ) )");

        //after another unary
        checkTyped("8 neg sqr", "64", "sqr( -8 )");
        checkTyped("1 2 3 neg sqr", "15,129", "sqr( -123 )");
        checkTyped("4 9 sqrt sqr", "49", "sqr( √( 49 ) )");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqrt sqr", "3,600,000,000",
                "sqr( √( 3600000000 ) )");
        checkTyped("1 inverse sqr", "1", "sqr( 1/( 1 ) )");
        checkTyped("0 . 0 0 0 0 0 1 inverse sqr", "1,000,000,000,000",
                "sqr( 1/( 0.000001 ) )");

        //after binary
        checkTyped("1 6 + sqr", "256", "16 + sqr( 16 )");
        checkTyped("7 6 2 4 + sqr", "58,125,376", "7624 + sqr( 7624 )");
        checkTyped("5 6 4 - sqr", "318,096", "564 - sqr( 564 )");
        checkTyped("6 5 2 2 4 5 6 - sqr", "42,542,432,271,936",
                "6522456 - sqr( 6522456 )");
        checkTyped("1 2 * sqr", "144", "12 × sqr( 12 )");
        checkTyped("3 4 4 3 6 3 * sqr", "118,585,875,769",
                "344363 × sqr( 344363 )");
        checkTyped("5 5 / sqr", "3,025", "55 ÷ sqr( 55 )");
        checkTyped("1 5 6 7 / sqr", "2,455,489", "1567 ÷ sqr( 1567 )");

        //after percent
        checkTyped("7 8 % sqr", "0", "sqr( 0 )");
        checkTyped("5 6 2 4 5 % sqr", "0", "sqr( 0 )");

        //after equals
        checkTyped("7 3 = sqr", "5,329", "sqr( 73 )");
        checkTyped("5 3 2 6 2 6 = sqr", "283,690,455,876", "sqr( 532626 )");

        //sqr after second inputted
        checkTyped("8 * 6 sqr", "36", "8 × sqr( 6 )");
        checkTyped("8 5 6 - 3 0 sqr", "900", "856 - sqr( 30 )");

        //after second calculating
        checkTyped("8 * 6 sqr sqr", "1,296", "8 × sqr( sqr( 6 ) )");
        checkTyped("1 + 2 + 3 + 4 inverse sqr", "0.0625",
                "1 + 2 + 3 + sqr( 1/( 4 ) )");
    }

    /**
     * Tests for square root operation.
     */
    private void sqrtTests() {
        //standard cases
        checkTyped("sqrt", "0", "√( 0 )");
        checkTyped("0 sqrt", "0", "√( 0 )");
        checkTyped("1 sqrt", "1", "√( 1 )");
        checkTyped("2 sqrt", "1.414213562373095", "√( 2 )");
        checkTyped("3 sqrt", "1.732050807568877", "√( 3 )");
        checkTyped("4 sqrt", "2", "√( 4 )");
        checkTyped("5 sqrt", "2.23606797749979", "√( 5 )");
        checkTyped("6 sqrt", "2.449489742783178", "√( 6 )");
        checkTyped("7 sqrt", "2.645751311064591", "√( 7 )");
        checkTyped("8 sqrt", "2.82842712474619", "√( 8 )");
        checkTyped("9 sqrt", "3", "√( 9 )");

        //without comma
        checkTyped("1 7 sqrt", "4.123105625617661", "√( 17 )");
        checkTyped("2 5 6 sqrt", "16", "√( 256 )");

        //with comma
        checkTyped("1 1 5 1 5 sqrt", "107.3079680172912", "√( 11515 )");
        checkTyped("7 3 4 3 4 7 9 5 6 sqrt", "27,098.85525257478",
                "√( 734347956 )");

        //several sqrt operations
        checkTyped("1 sqrt 2 sqrt 3", "3", "");
        checkTyped("1 sqrt 2 sqrt 3 sqrt", "1.732050807568877", "√( 3 )");
        checkTyped("1 0 0 sqrt 1 0 0 0 sqrt 1 0 0 0 0 sqrt 1 0 0 0 0 0",
                "100,000", "");
        checkTyped("1 0 0 sqrt 1 0 0 0 sqrt 1 0 0 0 0 sqrt 1 0 0 0 0 0 sqrt",
                "316.2277660168379", "√( 100000 )");

        //after dot
        checkTyped("6 2 . sqrt", "7.874007874011811", "√( 62 )");
        checkTyped("6 2 3 6 2 6 . sqrt", "789.6999430163333",
                "√( 623626 )");

        //in a row
        checkTyped("8 6 6 sqrt sqrt sqrt sqrt sqrt", "1.235371090882345",
                "√( √( √( √( √( 866 ) ) ) ) )");
        checkTyped("9 8 7 9 1 4 8 0 sqrt sqrt sqrt sqrt sqrt sqrt", "1.333268111746662",
                "√( √( √( √( √( √( 98791480 ) ) ) ) ) )");

        //after another unary
        checkTyped("8 neg sqrt", "Invalid input", "√( -8 )");
        checkTyped("1 2 3 neg sqrt", "Invalid input", "√( -123 )");
        checkTyped("4 9 sqr sqrt", "49", "√( sqr( 49 ) )");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqr sqrt", "3,600,000,000",
                "√( sqr( 3600000000 ) )");
        checkTyped("1 inverse sqrt", "1", "√( 1/( 1 ) )");
        checkTyped("0 . 0 0 0 0 0 1 inverse sqrt", "1,000",
                "√( 1/( 0.000001 ) )");

        //after binary
        checkTyped("1 6 + sqrt", "4", "16 + √( 16 )");
        checkTyped("7 6 2 4 + sqrt", "87.31551981177229",
                "7624 + √( 7624 )");
        checkTyped("5 6 4 - sqrt", "23.74868417407583", "564 - √( 564 )");
        checkTyped("6 5 2 2 4 5 6 - sqrt", "2,553.909943596289",
                "6522456 - √( 6522456 )");
        checkTyped("1 2 * sqrt", "3.464101615137755", "12 × √( 12 )");
        checkTyped("3 4 4 3 6 3 * sqrt", "586.8245052824567",
                "344363 × √( 344363 )");
        checkTyped("5 5 / sqrt", "7.416198487095663", "55 ÷ √( 55 )");
        checkTyped("1 5 6 7 / sqrt", "39.58535082577897",
                "1567 ÷ √( 1567 )");

        //after percent
        checkTyped("7 8 % sqrt", "0", "√( 0 )");
        checkTyped("5 6 2 4 5 % sqrt", "0", "√( 0 )");

        //after equals
        checkTyped("7 3 = sqrt", "8.544003745317531", "√( 73 )");
        checkTyped("5 3 2 6 2 6 = sqrt", "729.8123046372951",
                "√( 532626 )");

        //sqrt after second inputted
        checkTyped("8 * 6 sqrt", "2.449489742783178", "8 × √( 6 )");
        checkTyped("8 5 6 - 3 0 sqrt", "5.477225575051661",
                "856 - √( 30 )");

        //after second calculating
        checkTyped("8 * 6 sqr sqrt", "6", "8 × √( sqr( 6 ) )");
        checkTyped("1 + 2 + 3 + 4 inverse sqrt", "0.5",
                "1 + 2 + 3 + √( 1/( 4 ) )");
    }

    /**
     * Tests for inverse operation.
     */
    private void inverseTests() {
        //standard cases
        checkTyped("0 inverse", "Cannot divide by zero", "1/( 0 )");
        checkTyped("1 inverse", "1", "1/( 1 )");
        checkTyped("2 inverse", "0.5", "1/( 2 )");
        checkTyped("3 inverse", "0.3333333333333333", "1/( 3 )");
        checkTyped("4 inverse", "0.25", "1/( 4 )");
        checkTyped("5 inverse", "0.2", "1/( 5 )");
        checkTyped("6 inverse", "0.1666666666666667", "1/( 6 )");
        checkTyped("7 inverse", "0.1428571428571429", "1/( 7 )");
        checkTyped("8 inverse", "0.125", "1/( 8 )");
        checkTyped("9 inverse", "0.1111111111111111", "1/( 9 )");

        //without comma
        checkTyped("1 7 inverse", "0.0588235294117647", "1/( 17 )");
        checkTyped("2 5 6 inverse", "0.00390625", "1/( 256 )");

        //with comma
        checkTyped("1 1 5 1 5 inverse", "8.684324793747286e-5",
                "1/( 11515 )");
        checkTyped("7 3 4 3 4 7 9 5 6 inverse", "1.361752275375027e-9",
                "1/( 734347956 )");

        //several inverse operations
        checkTyped("1 inverse 2 inverse 3", "3", "");
        checkTyped("1 inverse 2 inverse 3 inverse", "0.3333333333333333",
                "1/( 3 )");
        checkTyped("1 0 0 inverse 1 0 0 0 inverse 1 0 0 0 0 inverse 1 0 0 0 0 0", "100,000",
                "");
        checkTyped("1 0 0 inverse 1 0 0 0 inverse 1 0 0 0 0 inverse 1 0 0 0 0 0 inverse",
                "0.00001",
                "1/( 100000 )");

        //after dot
        checkTyped("6 2 . inverse", "0.0161290322580645", "1/( 62 )");
        checkTyped("6 2 3 6 2 6 . inverse", "1.603525189777206e-6",
                "1/( 623626 )");

        //in a row
        checkTyped("8 6 6 inverse inverse inverse inverse inverse", "0.0011547344110855",
                "1/( 1/( 1/( 1/( 1/( 866 ) ) ) ) )");
        checkTyped("9 8 7 9 1 4 8 0 inverse inverse inverse inverse inverse inverse",
                "98,791,480",
                "1/( 1/( 1/( 1/( 1/( 1/( 98791480 ) ) ) ) ) )");

        //after another unary
        checkTyped("8 neg inverse", "-0.125", "1/( -8 )");
        checkTyped("1 2 3 neg inverse", "-0.008130081300813", "1/( -123 )");
        checkTyped("4 9 sqr inverse", "4.164931278633903e-4",
                "1/( sqr( 49 ) )");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqr inverse", "7.716049382716049e-20",
                "1/( sqr( 3600000000 ) )");
        checkTyped("1 sqrt inverse", "1", "1/( √( 1 ) )");
        checkTyped("0 . 0 0 0 0 0 1 sqrt inverse", "1,000",
                "1/( √( 0.000001 ) )");

        //after binary
        checkTyped("1 6 + inverse", "0.0625", "16 + 1/( 16 )");
        checkTyped("7 6 2 4 + inverse", "1.311647429171039e-4",
                "7624 + 1/( 7624 )");
        checkTyped("5 6 4 - inverse", "0.0017730496453901",
                "564 - 1/( 564 )");
        checkTyped("6 5 2 2 4 5 6 - inverse", "1.533164807857654e-7",
                "6522456 - 1/( 6522456 )");
        checkTyped("1 2 * inverse", "0.0833333333333333", "12 × 1/( 12 )");
        checkTyped("3 4 4 3 6 3 * inverse", "2.903912441232072e-6",
                "344363 × 1/( 344363 )");
        checkTyped("5 5 / inverse", "0.0181818181818182", "55 ÷ 1/( 55 )");
        checkTyped("1 5 6 7 / inverse", "6.381620931716656e-4",
                "1567 ÷ 1/( 1567 )");

        //after percent
        checkTyped("7 8 % inverse", "Cannot divide by zero", "1/( 0 )");
        checkTyped("5 6 2 4 5 % inverse", "Cannot divide by zero",
                "1/( 0 )");

        //after equals
        checkTyped("7 3 = inverse", "0.0136986301369863", "1/( 73 )");
        checkTyped("5 3 2 6 2 6 = inverse", "1.877490021140538e-6",
                "1/( 532626 )");

        //inverse after second inputted
        checkTyped("8 * 6 inverse", "0.1666666666666667", "8 × 1/( 6 )");
        checkTyped("8 5 6 - 3 0 inverse", "0.0333333333333333",
                "856 - 1/( 30 )");

        //after second calculating
        checkTyped("8 * 6 sqr inverse", "0.0277777777777778",
                "8 × 1/( sqr( 6 ) )");
        checkTyped("1 + 2 + 3 + 4 inverse inverse", "4",
                "1 + 2 + 3 + 1/( 1/( 4 ) )");
    }

    /**
     * Tests for percentage operation.
     */
    private void percentageTests() {
        //standard cases
        checkTyped("%", "0", "0");
        checkTyped("0 %", "0", "0");
        checkTyped("1 %", "0", "0");
        checkTyped("2 %", "0", "0");
        checkTyped("3 %", "0", "0");
        checkTyped("4 %", "0", "0");
        checkTyped("5 %", "0", "0");
        checkTyped("6 %", "0", "0");
        checkTyped("7 %", "0", "0");
        checkTyped("8 %", "0", "0");
        checkTyped("9 %", "0", "0");

        //without comma
        checkTyped("1 7 %", "0", "0");
        checkTyped("2 5 6 %", "0", "0");

        //with comma
        checkTyped("1 1 5 1 5 %", "0", "0");
        checkTyped("7 3 4 3 4 7 9 5 6 %", "0", "0");

        //several sqrt operations
        checkTyped("1 % 2 % 3", "3", "");
        checkTyped("1 % 2 % 3 %", "0", "0");
        checkTyped("1 0 0 % 1 0 0 0 % 1 0 0 0 0 % 1 0 0 0 0 0", "100,000",
                "");
        checkTyped("1 0 0 % 1 0 0 0 % 1 0 0 0 0 % 1 0 0 0 0 0 %", "0", "0");

        //after dot
        checkTyped("6 2 . %", "0", "0");
        checkTyped("6 2 3 6 2 6 . %", "0", "0");

        //in a row
        checkTyped("8 6 6 % % % % %", "0", "0");
        checkTyped("9 8 7 9 1 4 8 0 % % % % % %", "0", "0");

        //after unary
        checkTyped("8 neg %", "0", "0");
        checkTyped("1 2 3 neg %", "0", "0");
        checkTyped("4 9 sqr %", "0", "0");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqr %", "0", "0");
        checkTyped("6 4 sqrt %", "0", "0");
        checkTyped("1 2 3 4 sqrt %", "0", "0");
        checkTyped("1 inverse %", "0", "0");
        checkTyped("0 . 0 0 0 0 0 1 inverse %", "0", "0");

        //after binary
        checkTyped("1 6 + %", "2.56", "16 + 2.56");
        checkTyped("7 6 2 4 + %", "581,253.76", "7624 + 581253.76");
        checkTyped("5 6 4 - %", "3,180.96", "564 - 3180.96");
        checkTyped("6 5 2 2 4 5 6 - %", "425,424,322,719.36",
                "6522456 - 425424322719.36");
        checkTyped("1 2 * %", "0.12", "12 × 0.12");
        checkTyped("3 4 4 3 6 3 * %", "3,443.63", "344363 × 3443.63");
        checkTyped("5 5 / %", "0.55", "55 ÷ 0.55");
        checkTyped("1 5 6 7 / %", "15.67", "1567 ÷ 15.67");

        //after equals
        checkTyped("7 3 = %", "0", "0");
        checkTyped("5 3 2 6 2 6 = %", "0", "0");

        //percent after second inputted
        checkTyped("8 * 6 %", "0.06", "8 × 0.06");
        checkTyped("8 5 6 - 3 0 %", "256.8", "856 - 256.8");

        //after second calculating
        checkTyped("8 * 6 sqr %", "0.36", "8 × 0.36");
        checkTyped("1 + 2 + 3 + 4 inverse %", "0.015", "1 + 2 + 3 + 0.015");
    }

    /**
     * Tests for equals operation.
     */
    private void equalsTests() {
        //standard cases
        checkTyped("=", "0", "");
        checkTyped("0 =", "0", "");
        checkTyped("1 =", "1", "");
        checkTyped("2 =", "2", "");
        checkTyped("3 =", "3", "");
        checkTyped("4 =", "4", "");
        checkTyped("5 =", "5", "");
        checkTyped("6 =", "6", "");
        checkTyped("7 =", "7", "");
        checkTyped("8 =", "8", "");
        checkTyped("9 =", "9", "");

        //without comma
        checkTyped("1 7 =", "17", "");
        checkTyped("2 5 6 =", "256", "");

        //with comma
        checkTyped("1 1 5 1 5 =", "11,515", "");
        checkTyped("7 3 4 3 4 7 9 5 6 =", "734,347,956", "");

        //several equals operations
        checkTyped("1 = 2 = 3", "3", "");
        checkTyped("1 = 2 = 3 =", "3", "");
        checkTyped("1 0 0 = 1 0 0 0 = 1 0 0 0 0 = 1 0 0 0 0 0", "100,000",
                "");
        checkTyped("1 0 0 = 1 0 0 0 = 1 0 0 0 0 = 1 0 0 0 0 0 =", "100,000",
                "");

        //after dot
        checkTyped("6 2 . =", "62", "");
        checkTyped("6 2 3 6 2 6 . =", "623,626", "");

        //in a row without binary set
        checkTyped("8 6 6 = = = = =", "866", "");
        checkTyped("9 8 7 9 1 4 8 0 = = = = = =", "98,791,480", "");

        //in a row with binary set
        checkTyped("8 6 6 + 1 2 3 = = = = =", "1,481", "");
        checkTyped("9 8 7 9 1 4 8 0 / 1 0 = = = = = =", "98.79148", "");

        //after unary without binary set
        checkTyped("8 neg =", "-8", "");
        checkTyped("1 2 3 neg =", "-123", "");
        checkTyped("4 9 sqr =", "2,401", "");
        checkTyped("3 6 0 0 0 0 0 0 0 0 sqr =", "1.296e+19", "");
        checkTyped("6 4 sqrt =", "8", "");
        checkTyped("1 2 3 4 sqrt =", "35.12833614050059", "");
        checkTyped("1 inverse =", "1", "");
        checkTyped("0 . 0 0 0 0 0 1 inverse =", "1,000,000", "");

        //after unary with binary set
        checkTyped("5 + 8 neg =", "-3", "");
        checkTyped("1 3 - 1 2 3 neg =", "136", "");
        checkTyped("7 5 4 3 * 4 9 sqr =", "18,110,743", "");
        checkTyped("0 / 3 6 0 0 0 0 0 0 0 0 sqr =", "0", "");
        checkTyped("5 5 + 6 4 sqrt =", "63", "");
        checkTyped("2 1 3 4 - 1 2 3 4 sqrt =", "2,098.871663859499", "");
        checkTyped("2 1 3 * 1 inverse =", "213", "");
        checkTyped("1 0 0 0 / 0 . 0 0 0 0 0 1 inverse =", "0.001", "");

        //several in a row after unary with binary set
        checkTyped("5 + 8 neg = = = = =", "-35", "");
        checkTyped("1 3 - 1 2 3 neg = = = =", "505", "");
        checkTyped("7 5 4 3 * 4 9 sqr = = = = = =", "1.445097228303612e+24",
                "");
        checkTyped("0 / 3 6 0 0 0 0 0 0 0 0 sqr = = = =", "0", "");
        checkTyped("5 5 + 6 4 sqrt = = = =", "87", "");
        checkTyped("2 1 3 4 - 1 2 3 4 sqrt = =", "2,063.743327718999", "");
        checkTyped("2 1 3 * 1 inverse = = = =", "213", "");
        checkTyped("1 0 0 0 / 0 . 0 0 0 0 0 1 inverse = = = = = = =", "1.e-39",
                "");

        //after binary
        checkTyped("1 6 + =", "32", "");
        checkTyped("7 6 2 4 + =", "15,248", "");
        checkTyped("5 6 4 - =", "0", "");
        checkTyped("6 5 2 2 4 5 6 - =", "0", "");
        checkTyped("1 2 * =", "144", "");
        checkTyped("3 4 4 3 6 3 * =", "118,585,875,769", "");
        checkTyped("5 5 / =", "1", "");
        checkTyped("1 5 6 7 / =", "1", "");

        //several in a row after binary
        checkTyped("1 6 + = =", "48", "");
        checkTyped("7 6 2 4 + = = =", "30,496", "");
        checkTyped("5 6 4 - = = = =", "-1,692", "");
        checkTyped("6 5 2 2 4 5 6 - = = = = =", "-26,089,824", "");
        checkTyped("1 2 * = = = = =", "2,985,984", "");
        checkTyped("3 4 4 3 6 3 * = = =", "1.40626099319007e+22", "");
        checkTyped("5 5 / = = = =", "6.010518407212622e-6", "");
        checkTyped("1 5 6 7 / = =", "6.381620931716656e-4", "");

        //after percent
        checkTyped("6 % =", "0", "");
        checkTyped("7 3 0 % =", "0", "");

        //after percent with binary set
        checkTyped("5 + 6 % =", "5.3", "");
        checkTyped("1 2 3 * 7 3 0 % =", "897.9", "");

        //several in a row after percent with binary set
        checkTyped("5 + 6 % = = = =", "6.2", "");
        checkTyped("1 2 3 * 7 3 0 % = = =", "47,849.091", "");

        //equals after second inputted
        checkTyped("8 * 6 =", "48", "");
        checkTyped("8 5 6 - 3 0 =", "826", "");

        //after error
        checkTyped("/ 0 = =", "0", "");
        checkTyped("inverse =", "0", "");
    }

    /**
     * Tests for exceptions.
     */
    private void exceptionTests() {
        //overflow
        //add
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = * 1 0 = = = + = = = = = = = = =", "Overflow");

        //subtract
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = * 1 0 = = = - = = = = = = = = = = =", "Overflow");

        //multiply
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = * 1 0 = = = =", "Overflow");

        //divide
        checkException("0 . 0 0 0 0 0 0 0 0 1 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * 0 . 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 1 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = / 1 0 = = = =", "Overflow");

        //sqr
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "Overflow");
        checkException("0 . 0 0 0 0 0 0 0 0 1 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr", "Overflow");

        //percentage
        checkException("1 0 0 0 0 0 0 0 0 0 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = = = * 1 0 = = = + %", "Overflow");
        checkException("0 . 0 0 0 0 0 0 0 0 1 sqr sqr sqr sqr sqr sqr sqr sqr sqr sqr * 0 . 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 1 = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = " +
                "= = = = = / 1 0 = = = * %", "Overflow");

        //invalid input
        checkException("8 neg sqrt", "Invalid input");
        checkException("1 0 0 neg sqrt", "Invalid input");
        checkException("2 5 2 3 6 2 6 2 3 neg sqrt", "Invalid input");

        //divide by zero
        checkException("1 4 / 0 = ", "Cannot divide by zero");
        checkException("5 3 1 5 1 5 / 0 =", "Cannot divide by zero");
        checkException("0 . 1 3 2 / 0 =", "Cannot divide by zero");
        checkException("0 inverse", "Cannot divide by zero");

        //divide zero by zero
        checkException("0 / 0 =", "Result is undefined");
    }

    /**
     * Checks that keyboard buttons and combinations work correctly.
     *
     * @param keyboardButtons      keyboard buttons that should be pressed.
     * @param expectedScreenText   required text on screen {@code Label} after pressing.
     * @param expectedEquationText required text on equation {@code Label} after pressing.
     */
    private void checkKeyboardForOperations(String keyboardButtons, String expectedScreenText,
                                            String expectedEquationText) {
        resetAll();
        pressKeyboard(keyboardButtons);

        assertEquals(expectedScreenText, getLabeledBySelector(SCREEN_LABEL_ID).getText());

        expectedEquationText = expectedEquationText.replaceAll(SPACE, NARROW_SPACE);
        assertEquals(expectedEquationText, getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Checks that screen {@code Label} has required text after clicking on several {@code Button}.
     *
     * @param buttons            several {@code Button} that should be clicked.
     * @param expectedScreenText required text on screen {@code Label} after clicking.
     */
    private void checkTyped(String buttons, String expectedScreenText) {
        resetAll();
        clickButtons(buttons);

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
     * @param buttons several {@code Button} that should be clicked before clearing.
     */
    private void checkClear(String buttons) {
        resetAll();

        Label screenLabel = (Label) getLabeledBySelector(SCREEN_LABEL_ID);
        Label equationLabel = (Label) getLabeledBySelector(EQUATION_LABEL_ID);

        clickButtons(buttons);
        String expectedEquationText = equationLabel.getText();
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));

        assertEquals("0", screenLabel.getText());
        assertEquals(expectedEquationText, equationLabel.getText());

        clickButtons(buttons);
        clickOn(getButtonBySelector(CLEAR_ALL_ID));

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
