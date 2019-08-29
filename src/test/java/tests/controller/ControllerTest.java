package tests.controller;

import org.junit.Test;
import util.RobotControl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for controller.
 *
 * @author Mykhailo Bormashenko
 * @see com.implemica.bormashenko.calculator.controller.Controller
 */
public class ControllerTest extends RobotControl {

    /**
     * Tests for appending digits.
     */
    @Test
    public void appendDigitTests() {
//        checkAppendDigits("", "0");
//        checkAppendDigits("0", "0");
//        checkAppendDigits("00", "0");
//
//        //can append
//        //without operations
//        //no commas
//        checkAppendDigits("1", "1");
//        checkAppendDigits("2", "2");
//        checkAppendDigits("3", "3");
//        checkAppendDigits("4", "4");
//        checkAppendDigits("5", "5");
//        checkAppendDigits("6", "6");
//        checkAppendDigits("7", "7");
//        checkAppendDigits("8", "8");
//        checkAppendDigits("9", "9");
//
//        checkAppendDigits("10", "10");
//        checkAppendDigits("111", "111");
//        checkAppendDigits("123", "123");
//        checkAppendDigits("567", "567");
//        checkAppendDigits("235", "235");
//        checkAppendDigits("899", "899");
//        checkAppendDigits("123", "123");
//        checkAppendDigits("736", "736");
//
//        //commas
//        checkAppendDigits("4890", "4,890");
//        checkAppendDigits("1234567890", "1,234,567,890");
//        checkAppendDigits("2523568346536", "2,523,568,346,536");
//        checkAppendDigits("8246", "8,246");
//        checkAppendDigits("2652626", "2,652,626");
//        checkAppendDigits("15135945", "15,135,945");
//        checkAppendDigits("1240917825971", "1,240,917,825,971");
//        checkAppendDigits("218175", "218,175");
//
//        //16 digits
//        checkAppendDigits("1122334455667788", "1,122,334,455,667,788");
//        checkAppendDigits("5893127592375922", "5,893,127,592,375,922");
//        checkAppendDigits("3250293850723580", "3,250,293,850,723,580");
//        checkAppendDigits("3259000234000023", "3,259,000,234,000,023");


        //with negated number (minus should be saved)
        //no commas
        checkAppendDigits("1~1", "-11");
        checkAppendDigits("5~5", "-55");
        checkAppendDigits("8~7", "-87");
        checkAppendDigits("6~78", "-678");
        checkAppendDigits("8~27", "-827");
        checkAppendDigits("2~36", "-236");
        checkAppendDigits("7~82", "-782");
        checkAppendDigits("8~96", "-896");

        //commas
        checkAppendDigits("6~1237", "-61,237");
        checkAppendDigits("8~734", "-8,734");
        checkAppendDigits("8~8632463", "-88,632,463");
        checkAppendDigits("7~8436346", "-78,436,346");
        checkAppendDigits("2~25834535", "-225,834,535");
        checkAppendDigits("1~7346456252", "-17,346,456,252");
        checkAppendDigits("2~6234626", "-26,234,626");
        checkAppendDigits("3~7774236523452", "-37,774,236,523,452");

        //16 digits
        checkAppendDigits("7~890635789000000", "-7,890,635,789,000,000");
        checkAppendDigits("1~765323523658345", "-1,765,323,523,658,345");
        checkAppendDigits("8~234876435942583", "-8,234,876,435,942,583");
        checkAppendDigits("6~235483463468345", "-6,235,483,463,468,345");
    }

    /**
     * Checks that screen label has required text after clicking on digits.
     *
     * @param digits             digits that should be clicked.
     * @param expectedScreenText required text on screen after clicking.
     */
    private void checkAppendDigits(String digits, String expectedScreenText) {
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons(digits);

        assertEquals(expectedScreenText, getLabeledBySelector(SCREEN_LABEL_ID).getText());
    }
}
