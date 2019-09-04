package tests.controller;

import javafx.scene.control.Label;
import org.junit.Test;
import util.RobotControl;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for controller.
 *
 * @author Mykhailo Bormashenko
 * @see com.implemica.bormashenko.calculator.controller.Controller
 */
public class ControllerTest extends RobotControl {

    public ControllerTest() throws AWTException {
    }

    /**
     * Runs all tests
     */
    @Test
    public void allTests() {
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

            checkTyped("123", "123");
            checkTyped("736", "736");

            //commas
            checkTyped("4890", "4,890");
            checkTyped("1234567890", "1,234,567,890");

            //16 digits
            checkTyped("1122334455667788", "1,122,334,455,667,788");
            checkTyped("3259000234000023", "3,259,000,234,000,023");

            //with negated number (minus should be saved)
            //no commas
            checkTyped("1~1", "-11");
            checkTyped("8~96", "-896");

            //commas
            checkTyped("6~1237", "-61,237");
            checkTyped("3~7774236523452", "-37,774,236,523,452");

            //16 digits
            checkTyped("7~890635789000000", "-7,890,635,789,000,000");
            checkTyped("6~235483463468345", "-6,235,483,463,468,345");

            //after unary (but not negate) operation pressed
            checkTyped("1^752", "752");
            checkTyped("7238^14785", "14,785");

            checkTyped("9@825", "825");
            checkTyped("325273@72352525", "72,352,525");

            checkTyped("717;7", "7");
            checkTyped("7235;12453476436", "12,453,476,436");

            //after binary operations
            checkTyped("9+2", "2");
            checkTyped("8762452+63333", "63,333");

            checkTyped("324-0", "0");
            checkTyped("3254-7324552", "7,324,552");

            checkTyped("12313*1", "1");
            checkTyped("1157*21376", "21,376");

            checkTyped("23/78", "78");
            checkTyped("242222/123000", "123,000");

            //after equals
            checkTyped("1325=131", "131");
            checkTyped("765452452=13131331521325", "13,131,331,521,325");

            //after error
            checkTyped("/0=123", "123");
            checkTyped("/0=8234629", "8,234,629");

            //after dot
            checkTyped("123.98714", "123.98714");
            checkTyped("2573525.34", "2,573,525.34");

            //after dot with 16 digits summary
            checkTyped("784.0972347859825", "784.0972347859825");
            checkTyped("123019.8498533564", "123,019.8498533564");

            //after dot with 17 digits summary (starts with 0.)
            checkTyped("0.1223458901245678", "0.1223458901245678");
            checkTyped("0.1431413532157567", "0.1431413532157567");

            //after dot and negated
            checkTyped("7~25.72572", "-725.72572");
            checkTyped("78632.224~32678", "-78,632.22432678");

            //after dot with 16 digits summary and negated
            checkTyped("9~.034567823459875", "-9.034567823459875");
            checkTyped("123657.29582~00256", "-123,657.2958200256");

            //after dot with 17 digits summary (starts with 0.) and negated
            checkTyped("0.85298~23546736765", "-0.8529823546736765");
            checkTyped("0.1376~663534687667", "-0.1376663534687667");

            //after backspace
            checkTyped("<132", "132");
            checkTyped("<257537356", "257,537,356");

            checkTyped("8<324", "324");
            checkTyped("7<15316516", "15,316,516");

            checkTyped("64<6", "66");
            checkTyped("1235<643", "123,643");

            //after clear text
            clickButtons("561235");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkTyped("654", "654");

            clickButtons("1462656");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkTyped("141514", "141,514");

            //after clear all
            clickButtons("736346");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkTyped("12", "12");

            clickButtons("213");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkTyped("12467", "12,467");
        }

        //can not append
        {
            checkTyped("", "0");
            checkTyped("0", "0");
            checkTyped("00", "0");

            //17 digits
            checkTyped("12345678901234567", "1,234,567,890,123,456");
            checkTyped("87984719571987591", "8,798,471,957,198,759");

            //more than 17 digits
            checkTyped("2198370919080518325071051", "2,198,370,919,080,518");
            checkTyped("1209847102458012850932805824092", "1,209,847,102,458,012");

            //17 and negate
            checkTyped("123456789~01234567", "-1,234,567,890,123,456");
            checkTyped("87984~719571987591", "-8,798,471,957,198,759");

            //more than 17 and negate
            checkTyped("219~8370919080518325071051", "-2,198,370,919,080,518");
            checkTyped("120984710245~8012850932805824092", "-1,209,847,102,458,012");

            //17 and dot
            checkTyped("123456789.01234567", "123,456,789.0123456");
            checkTyped("87984.719571987591", "87,984.71957198759");

            //more than 17 and dot
            checkTyped("219.8370919080518325071051", "219.8370919080518");
            checkTyped("120984710245.8012850932805824092", "120,984,710,245.8012");

            //17 and dot and negate
            checkTyped("123456~789.01234567", "-123,456,789.0123456");
            checkTyped("879~84.719571987591", "-87,984.71957198759");

            //more than 17 and dot and negate
            checkTyped("219.837~0919080518325071051", "-219.8370919080518");
            checkTyped("120~984710245.8012850932805824092", "-120,984,710,245.8012");

            //18 and dot and starts with 0.
            checkTyped("0.87523456890076345", "0.8752345689007634");
            checkTyped("0.74363738736363636", "0.7436373873636363");

            //more than 18 and dot and starts with 0.
            checkTyped("0.19878913759321752430626236525", "0.1987891375932175");
            checkTyped("0.3242384729375982760260286", "0.3242384729375982");

            //18 and dot and starts with 0. and negate
            checkTyped("0.8752345~6890076345", "-0.8752345689007634");
            checkTyped("0.74~363738736363636", "-0.7436373873636363");

            //more than 18 and dot and starts with 0. and negate
            checkTyped("0.19878~913759321752430626236525", "-0.1987891375932175");
            checkTyped("0.3~242384729375982760260286", "-0.3242384729375982");
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
            checkTyped("1.", "1.");
            checkTyped("2.", "2.");
            checkTyped("3.", "3.");
            checkTyped("4.", "4.");
            checkTyped("5.", "5.");
            checkTyped("6.", "6.");
            checkTyped("7.", "7.");
            checkTyped("8.", "8.");
            checkTyped("9.", "9.");

            checkTyped("10.", "10.");
            checkTyped("111.", "111.");
            checkTyped("123.", "123.");
            checkTyped("736.", "736.");

            //commas
            checkTyped("4890.", "4,890.");
            checkTyped("1234567890.", "1,234,567,890.");
            checkTyped("1240917825971.", "1,240,917,825,971.");
            checkTyped("218175.", "218,175.");

            //16 digits
            checkTyped("1122334455667788.", "1,122,334,455,667,788.");
            checkTyped("5893127592375922.", "5,893,127,592,375,922.");

            //17 digits
            checkTyped("12345678901234568.", "1,234,567,890,123,456.");
            checkTyped("87984719571987594.", "8,798,471,957,198,759.");

            //more than 17 digits
            checkTyped("219837091908051832507105.", "2,198,370,919,080,518.");
            checkTyped("120984710245801285093280582409.", "1,209,847,102,458,012.");

            //17 and negate
            checkTyped("123456789~01234567.", "-1,234,567,890,123,456.");
            checkTyped("87984~719571987591.", "-8,798,471,957,198,759.");

            //more than 17 and negate
            checkTyped("219~8370919080518325071051.", "-2,198,370,919,080,518.");
            checkTyped("120984710245~8012850932805824092.", "-1,209,847,102,458,012.");

            //with negated number
            //no commas
            checkTyped("1~.", "-1.");
            checkTyped("5~.", "-5.");
            checkTyped("8~27.", "-827.");
            checkTyped("8~96.", "-896.");

            //commas
            checkTyped("61237~.", "-61,237.");
            checkTyped("8734~.", "-8,734.");
            checkTyped("2~6234626.", "-26,234,626.");
            checkTyped("3~7774236523452.", "-37,774,236,523,452.");

            //16 digits
            checkTyped("7890635789000000~.", "-7,890,635,789,000,000.");
            checkTyped("1765323523658345~.", "-1,765,323,523,658,345.");
            checkTyped("8~234876435942583.", "-8,234,876,435,942,583.");
            checkTyped("6~235483463468345.", "-6,235,483,463,468,345.");

            //after unary (but not negate) operation pressed
            checkTyped("1^.", "0.");
            checkTyped("7238^.", "0.");

            checkTyped("953@.", "0.");
            checkTyped("325273@.", "0.");

            checkTyped("7177;.", "0.");
            checkTyped("7235;.", "0.");

            //after binary operations
            checkTyped("9+.", "0.");
            checkTyped("8762452+.", "0.");

            checkTyped("324-.", "0.");
            checkTyped("3254-.", "0.");

            checkTyped("12313*.", "0.");
            checkTyped("1157*.", "0.");

            checkTyped("23/.", "0.");
            checkTyped("242222/.", "0.");

            //after percent
            checkTyped("14%.", "0.");
            checkTyped("5135215%.", "0.");

            //after equals
            checkTyped("1325=.", "0.");
            checkTyped("765452452=.", "0.");

            checkTyped("11+67=.", "0.");
            checkTyped("823526/24362=.", "0.");

            //after backspace
            checkTyped("123<.", "12.");
            checkTyped("2152343<.", "215,234.");

            //after clear text
            clickButtons("561235");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkTyped(".", "0.");

            clickButtons("1462656");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkTyped(".", "0.");

            //after clear all
            clickButtons("736346");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkTyped(".", "0.");

            clickButtons("213");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkTyped(".", "0.");
        }

        //can not append
        {
            checkTyped("..", "0.");
            checkTyped("..", "0.");
            checkTyped("...", "0.");

            //17 and dot
            checkTyped("123456789.01234567.", "123,456,789.0123456");
            checkTyped("87984.719571987591.", "87,984.71957198759");

            //more than 17 and dot
            checkTyped("219.8370919080518325071051.", "219.8370919080518");
            checkTyped("120984710245.8012850932805824092.", "120,984,710,245.8012");

            //17 and dot and negate
            checkTyped("123456~789.01234567.", "-123,456,789.0123456");
            checkTyped("879~84.719571987591.", "-87,984.71957198759");

            //more than 17 and dot and negate
            checkTyped("219.837~0919080518325071051.", "-219.8370919080518");
            checkTyped("120~984710245.8012850932805824092.", "-120,984,710,245.8012");

            //18 and dot and starts with 0.
            checkTyped("0.87523456890076345.", "0.8752345689007634");
            checkTyped("0.74363738736363636.", "0.7436373873636363");

            //more than 18 and dot and starts with 0.
            checkTyped("0.19878913759321752430626236525.", "0.1987891375932175");
            checkTyped("0.3242384729375982760260286.", "0.3242384729375982");

            //18 and dot and starts with 0. and negate
            checkTyped("0.8752345~6890076345.", "-0.8752345689007634");
            checkTyped("0.74~363738736363636.", "-0.7436373873636363");

            //more than 18 and dot and starts with 0. and negate
            checkTyped("0.19878~913759321752430626236525.", "-0.1987891375932175");
            checkTyped("0.3~242384729375982760260286.", "-0.3242384729375982");

            //already with dot
            checkTyped("1414.1.2..", "1,414.12");
            checkTyped("123.765.", "123.765");
            checkTyped("624362.5.34.", "624,362.534");
            checkTyped("8764....", "8,764.");
        }
    }

    /**
     * Tests for backspace.
     */
    private void backspaceTests() {
        //last digit
        checkTyped("<", "0");
        checkTyped("0<", "0");
        checkTyped("1<", "0");
        checkTyped("2<", "0");
        checkTyped("3<", "0");
        checkTyped("4<", "0");
        checkTyped("5<", "0");
        checkTyped("6<", "0");
        checkTyped("7<", "0");
        checkTyped("8<", "0");
        checkTyped("9<", "0");

        //not last digit
        //no commas
        checkTyped("213<", "21");
        checkTyped("1415<", "141");

        //commas
        checkTyped("14513515<", "1,451,351");
        checkTyped("624362672<", "62,436,267");

        //after dot
        checkTyped("14214.<", "14,214");
        checkTyped("213515125.<", "213,515,125");

        //after negated
        checkTyped("14151521~<", "-1,415,152");
        checkTyped("6563252~<", "-656,325");

        checkTyped("623526~2131<", "-623,526,213");
        checkTyped("65253~1231<", "-65,253,123");

        //after unary operation (but not negate)
        checkTyped("1^<", "1");
        checkTyped("100^<", "10,000");

        checkTyped("900@<", "30");
        checkTyped("25000000@<", "5,000");

        checkTyped("8;<", "0.125");
        checkTyped("0.000125;<", "8,000");

        //after binary operation
        checkTyped("1414+<", "1,414");
        checkTyped("21362+<", "21,362");

        checkTyped("325425-<", "325,425");
        checkTyped("14-<", "14");

        checkTyped("76353*<", "76,353");
        checkTyped("873*<", "873");

        checkTyped("132/<", "132");
        checkTyped("523/<", "523");

        //after percent
        checkTyped("14%<", "0");
        checkTyped("5135215%<", "0");

        //after equals
        checkTyped("51414=<", "51,414");
        checkTyped("4121414=<", "4,121,414");

        //after error
        checkTyped("/0=<", "0");
        checkTyped("13/0<", "0");

        //after backspace
        checkTyped("123<<", "1");
        checkTyped("2152343<<", "21,523");

        //after clear text
        clickButtons("561235");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        checkTyped("<", "0");

        clickButtons("1462656");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        checkTyped("<", "0");

        //after clear all
        clickButtons("736346");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        checkTyped("<", "0");

        clickButtons("213");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        checkTyped("<", "0");
    }

    /**
     * Tests for clear operations (clear text and clear all).
     */
    private void clearTests() {

        //without operations
        checkClear("");
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

        checkClear("123");
        checkClear("12312414515");

        checkClear("1.23");
        checkClear("12312.414515");

        //negate
        checkClear("123~");
        checkClear("12312414515~");

        //unary
        checkClear("12^");
        checkClear("12312@");
        checkClear("3816298431299;");

        //binary
        checkClear("123+");
        checkClear("1412912491264951-");
        checkClear("3124152165315151*");
        checkClear("15981759195871329571935791759175981/");

        //percent
        checkClear("12%");
        checkClear("12312%");

        //equals
        checkClear("12=");
        checkClear("12312=");

        //backspace
        checkClear("12<");
        checkClear("12312<");

        //after clear text
        clickButtons("561235");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        checkClear("");

        //after clear all
        clickButtons("213");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        checkClear("");


        //error
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("/=0");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("/=0");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons(";0");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons(";0");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("5~@");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("5~@");
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
        checkTyped("0+", "0", "0 +");
        checkTyped("1+", "1", "1 +");
        checkTyped("2+", "2", "2 +");
        checkTyped("3+", "3", "3 +");
        checkTyped("4+", "4", "4 +");
        checkTyped("5+", "5", "5 +");
        checkTyped("6+", "6", "6 +");
        checkTyped("7+", "7", "7 +");
        checkTyped("8+", "8", "8 +");
        checkTyped("9+", "9", "9 +");

        //without comma
        checkTyped("17+", "17", "17 +");
        checkTyped("256+", "256", "256 +");

        //with comma
        checkTyped("11515+", "11,515", "11515 +");
        checkTyped("734347956+", "734,347,956", "734347956 +");

        //several add operations
        checkTyped("1+2+3", "3",
                "1 + 2 +");
        checkTyped("1+2+3+", "6",
                "1 + 2 + 3 +");
        checkTyped("100+1000+10000+100000", "100,000",
                "100 + 1000 + 10000 +");
        checkTyped("100+1000+10000+100000+", "111,100",
                "100 + 1000 + 10000 + 100000 +");

        //after dot
        checkTyped("62.+", "62", "62 +");
        checkTyped("623626.+", "623,626", "623626 +");

        //after negate
        checkTyped("866~+", "-866", "-866 +");
        checkTyped("98791480~+", "-98,791,480", "-98791480 +");

        //after another unary
        checkTyped("8^+", "64", "sqr(8) +");
        checkTyped("123^+", "15,129", "sqr(123) +");
        checkTyped("49@+", "7", "√(49) +");
        checkTyped("3600000000@+", "60,000", "√(3600000000) +");
        checkTyped("1;+", "1", "1/(1) +");
        checkTyped("0.000001;+", "1,000,000", "1/(0.000001) +");

        //in a row
        checkTyped("55++", "55", "55 +");
        checkTyped("1567+++++", "1,567", "1567 +");

        //after another binary
        checkTyped("16-+", "16", "16 +");
        checkTyped("7624-+", "7,624", "7624 +");
        checkTyped("564*+", "564", "564 +");
        checkTyped("6522456*+", "6,522,456", "6522456 +");
        checkTyped("12/+", "12", "12 +");
        checkTyped("344363/+", "344,363", "344363 +");

        //after percent
        checkTyped("78%+", "0", "0 +");
        checkTyped("56245%+", "0", "0 +");

        //after equals
        checkTyped("73=+", "73", "73 +");
        checkTyped("532626=+", "532,626", "532626 +");

        //calculating
        checkTyped("92+54+", "146", "92 + 54 +");
        checkTyped("8898+123+", "9,021", "8898 + 123 +");

        checkTyped("913+14.1+", "927.1", "913 + 14.1 +");
        checkTyped("7362.5+638.1+", "8,000.6", "7362.5 + 638.1 +");

        //engineers
        checkTyped("9000000000000000+1000000000000000+", "1.e+16",
                "9000000000000000 + 1000000000000000 +");
        checkTyped("9000000000000000+1000000000000000+1+", "1.e+16",
                "9000000000000000 + 1000000000000000 + 1 +");
        checkTyped("9000000000000000+1000000000000000+6+", "1.000000000000001e+16",
                "9000000000000000 + 1000000000000000 + 6 +");
        checkTyped("9999999999999999+9999999999999999+", "2.e+16",
                "9999999999999999 + 9999999999999999 +");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("+");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 +", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564+");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("+");
        assertEquals("564", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("564 + 0 +", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("+");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 +", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("+");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 +", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for subtract operation.
     */
    private void subtractTests() {
        //standard cases
        checkTyped("-", "0", "0 -");
        checkTyped("0-", "0", "0 -");
        checkTyped("1-", "1", "1 -");
        checkTyped("2-", "2", "2 -");
        checkTyped("3-", "3", "3 -");
        checkTyped("4-", "4", "4 -");
        checkTyped("5-", "5", "5 -");
        checkTyped("6-", "6", "6 -");
        checkTyped("7-", "7", "7 -");
        checkTyped("8-", "8", "8 -");
        checkTyped("9-", "9", "9 -");

        //without comma
        checkTyped("17-", "17", "17 -");
        checkTyped("256-", "256", "256 -");

        //with comma
        checkTyped("11515-", "11,515", "11515 -");
        checkTyped("734347956-", "734,347,956", "734347956 -");

        //several subtract operations
        checkTyped("1-2-3", "3",
                "1 - 2 -");
        checkTyped("1-2-3-", "-4",
                "1 - 2 - 3 -");
        checkTyped("100-1000-10000-100000", "100,000",
                "100 - 1000 - 10000 -");
        checkTyped("100-1000-10000-100000-", "-110,900",
                "100 - 1000 - 10000 - 100000 -");

        //after dot
        checkTyped("62.-", "62", "62 -");
        checkTyped("623626.-", "623,626", "623626 -");

        //after negate
        checkTyped("866~-", "-866", "-866 -");
        checkTyped("98791480~-", "-98,791,480", "-98791480 -");

        //after another unary
        checkTyped("8^-", "64", "sqr(8) -");
        checkTyped("123^-", "15,129", "sqr(123) -");
        checkTyped("49@-", "7", "√(49) -");
        checkTyped("3600000000@-", "60,000", "√(3600000000) -");
        checkTyped("1;-", "1", "1/(1) -");
        checkTyped("0.000001;-", "1,000,000", "1/(0.000001) -");

        //in a row
        checkTyped("55--", "55", "55 -");
        checkTyped("1567-----", "1,567", "1567 -");

        //after another binary
        checkTyped("16+-", "16", "16 -");
        checkTyped("7624+-", "7,624", "7624 -");
        checkTyped("564*-", "564", "564 -");
        checkTyped("6522456*-", "6,522,456", "6522456 -");
        checkTyped("12/-", "12", "12 -");
        checkTyped("344363/-", "344,363", "344363 -");

        //after percent
        checkTyped("78%-", "0", "0 -");
        checkTyped("56245%-", "0", "0 -");

        //after equals
        checkTyped("73=-", "73", "73 -");
        checkTyped("532626=-", "532,626", "532626 -");

        //calculating
        checkTyped("92-54-", "38", "92 - 54 -");
        checkTyped("8898-123-", "8,775", "8898 - 123 -");

        checkTyped("913-14.1-", "898.9", "913 - 14.1 -");
        checkTyped("7362.5-638.1-", "6,724.4", "7362.5 - 638.1 -");

        //engineers
        checkTyped("-9000000000000000-1000000000000000-", "-1.e+16",
                "0 - 9000000000000000 - 1000000000000000 -");
        checkTyped("-9000000000000000-1000000000000000-1-", "-1.e+16",
                "0 - 9000000000000000 - 1000000000000000 - 1 -");
        checkTyped("-9000000000000000-1000000000000000-6-", "-1.000000000000001e+16",
                "0 - 9000000000000000 - 1000000000000000 - 6 -");
        checkTyped("-9999999999999999-9999999999999999-", "-2.e+16",
                "0 - 9999999999999999 - 9999999999999999 -");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("-");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 -", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("-");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 -", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("-");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 -", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564-");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("-");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 -", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for multiply operation.
     */
    private void multiplyTests() {
        //standard cases
        checkTyped("*", "0", "0 ×");
        checkTyped("0*", "0", "0 ×");
        checkTyped("1*", "1", "1 ×");
        checkTyped("2*", "2", "2 ×");
        checkTyped("3*", "3", "3 ×");
        checkTyped("4*", "4", "4 ×");
        checkTyped("5*", "5", "5 ×");
        checkTyped("6*", "6", "6 ×");
        checkTyped("7*", "7", "7 ×");
        checkTyped("8*", "8", "8 ×");
        checkTyped("9*", "9", "9 ×");

        //without comma
        checkTyped("17*", "17", "17 ×");
        checkTyped("256*", "256", "256 ×");

        //with comma
        checkTyped("11515*", "11,515", "11515 ×");
        checkTyped("734347956*", "734,347,956", "734347956 ×");

        //several multiply operations
        checkTyped("1*2*3", "3",
                "1 × 2 ×");
        checkTyped("1*2*3*", "6",
                "1 × 2 × 3 ×");
        checkTyped("100*1000*10000*100000", "100,000",
                "100 × 1000 × 10000 ×");
        checkTyped("100*1000*10000*100000*", "100,000,000,000,000",
                "100 × 1000 × 10000 × 100000 ×");

        //after dot
        checkTyped("62.*", "62", "62 ×");
        checkTyped("623626.*", "623,626", "623626 ×");

        //after negate
        checkTyped("866~*", "-866", "-866 ×");
        checkTyped("98791480~*", "-98,791,480", "-98791480 ×");

        //after another unary
        checkTyped("8^*", "64", "sqr(8) ×");
        checkTyped("123^*", "15,129", "sqr(123) ×");
        checkTyped("49@*", "7", "√(49) ×");
        checkTyped("3600000000@*", "60,000", "√(3600000000) ×");
        checkTyped("1;*", "1", "1/(1) ×");
        checkTyped("0.000001;*", "1,000,000", "1/(0.000001) ×");

        //in a row
        checkTyped("55**", "55", "55 ×");
        checkTyped("1567*****", "1,567", "1567 ×");

        //after another binary
        checkTyped("16+*", "16", "16 ×");
        checkTyped("7624+*", "7,624", "7624 ×");
        checkTyped("564-*", "564", "564 ×");
        checkTyped("6522456-*", "6,522,456", "6522456 ×");
        checkTyped("12/*", "12", "12 ×");
        checkTyped("344363/*", "344,363", "344363 ×");

        //after percent
        checkTyped("78%*", "0", "0 ×");
        checkTyped("56245%*", "0", "0 ×");

        //after equals
        checkTyped("73=*", "73", "73 ×");
        checkTyped("532626=*", "532,626", "532626 ×");

        //calculating
        checkTyped("92*5*", "460", "92 × 5 ×");
        checkTyped("8898*123*", "1,094,454", "8898 × 123 ×");

        checkTyped("913*1.01*", "922.13", "913 × 1.01 ×");
        checkTyped("7362.5*638.1*", "4,698,011.25", "7362.5 × 638.1 ×");

        //engineers
        checkTyped("9000000000000000*1000000000000000*", "9.e+30",
                "9000000000000000 × 1000000000000000 ×");
        checkTyped("9999999999999999*1000000000000000*", "9.999999999999999e+30",
                "9999999999999999 × 1000000000000000 ×");
        checkTyped("9000000000000000*1000000000000000*4*", "3.6e+31",
                "9000000000000000 × 1000000000000000 × 4 ×");
        checkTyped("0.9999999999999999*0.9999999999999999*", "0.9999999999999998",
                "0.9999999999999999 × 0.9999999999999999 ×");
        checkTyped("0.9999999999999999*0.1*", "0.1",
                "0.9999999999999999 × 0.1 ×");
        checkTyped("0.9999999999999999*0.5*", "0.5",
                "0.9999999999999999 × 0.5 ×");
        checkTyped("0.9999999999999999*0.6*", "0.5999999999999999",
                "0.9999999999999999 × 0.6 ×");
        checkTyped("9999999999999999*9999999999999999*", "9.999999999999998e+31",
                "9999999999999999 × 9999999999999999 ×");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("*");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 ×", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("*");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("564 × 0 ×", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("*");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 ×", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("*");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 ×", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for divide operation.
     */
    private void divideTests() {
        //standard cases
        checkTyped("/", "0", "0 ÷");
        checkTyped("0/", "0", "0 ÷");
        checkTyped("1/", "1", "1 ÷");
        checkTyped("2/", "2", "2 ÷");
        checkTyped("3/", "3", "3 ÷");
        checkTyped("4/", "4", "4 ÷");
        checkTyped("5/", "5", "5 ÷");
        checkTyped("6/", "6", "6 ÷");
        checkTyped("7/", "7", "7 ÷");
        checkTyped("8/", "8", "8 ÷");
        checkTyped("9/", "9", "9 ÷");

        //without comma
        checkTyped("17/", "17", "17 ÷");
        checkTyped("256/", "256", "256 ÷");

        //with comma
        checkTyped("11515/", "11,515", "11515 ÷");
        checkTyped("734347956/", "734,347,956", "734347956 ÷");

        //several multiply operations
        checkTyped("1/2/3", "3",
                "1 ÷ 2 ÷");
        checkTyped("1/2/3/", "0.1666666666666667",
                "1 ÷ 2 ÷ 3 ÷");
        checkTyped("100/1000/10000/100000", "100,000",
                "100 ÷ 1000 ÷ 10000 ÷");
        checkTyped("100/1000/10000/100000/", "0.0000000001",
                "100 ÷ 1000 ÷ 10000 ÷ 100000 ÷");

        //after dot
        checkTyped("62./", "62", "62 ÷");
        checkTyped("623626./", "623,626", "623626 ÷");

        //after negate
        checkTyped("866~/", "-866", "-866 ÷");
        checkTyped("98791480~/", "-98,791,480", "-98791480 ÷");

        //after another unary
        checkTyped("8^/", "64", "sqr(8) ÷");
        checkTyped("123^/", "15,129", "sqr(123) ÷");
        checkTyped("49@/", "7", "√(49) ÷");
        checkTyped("3600000000@/", "60,000", "√(3600000000) ÷");
        checkTyped("1;/", "1", "1/(1) ÷");
        checkTyped("0.000001;/", "1,000,000", "1/(0.000001) ÷");

        //in a row
        checkTyped("55//", "55", "55 ÷");
        checkTyped("1567/////", "1,567", "1567 ÷");

        //after another binary
        checkTyped("16+/", "16", "16 ÷");
        checkTyped("7624+/", "7,624", "7624 ÷");
        checkTyped("564-/", "564", "564 ÷");
        checkTyped("6522456-/", "6,522,456", "6522456 ÷");
        checkTyped("12*/", "12", "12 ÷");
        checkTyped("344363*/", "344,363", "344363 ÷");

        //after percent
        checkTyped("78%/", "0", "0 ÷");
        checkTyped("56245%/", "0", "0 ÷");

        //after equals
        checkTyped("73=/", "73", "73 ÷");
        checkTyped("532626=/", "532,626", "532626 ÷");

        //calculating
        checkTyped("92/5/", "18.4", "92 ÷ 5 ÷");
        checkTyped("8898/123/", "72.34146341463415", "8898 ÷ 123 ÷");

        checkTyped("913/1.01/", "903.960396039604", "913 ÷ 1.01 ÷");
        checkTyped("7362.5/638.1/", "11.53816016298386", "7362.5 ÷ 638.1 ÷");

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

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("/");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 ÷", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("/");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 ÷", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("/");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 ÷", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("/");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0 ÷", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for negate operation.
     */
    private void negateTests() {
        //standard cases
        checkTyped("~", "0", "");
        checkTyped("0~", "0", "");
        checkTyped("1~", "-1", "");
        checkTyped("2~", "-2", "");
        checkTyped("3~", "-3", "");
        checkTyped("4~", "-4", "");
        checkTyped("5~", "-5", "");
        checkTyped("6~", "-6", "");
        checkTyped("7~", "-7", "");
        checkTyped("8~", "-8", "");
        checkTyped("9~", "-9", "");

        //without comma
        checkTyped("17~", "-17", "");
        checkTyped("256~", "-256", "");

        //with comma
        checkTyped("11515~", "-11,515", "");
        checkTyped("734347956~", "-734,347,956", "");

        //several negate operations
        checkTyped("1~2~3", "123", "");
        checkTyped("1~2~3~", "-123","");
        checkTyped("100~1000~10000~100000", "-1,001,000,100,001,000", "");
        checkTyped("100~1000~10000~100000~", "1,001,000,100,001,000", "");

        //after dot
        checkTyped("62.~", "-62.", "");
        checkTyped("623626.~", "-623,626.", "");

        //in a row
        checkTyped("866~~~~~", "-866", "");
        checkTyped("98791480~~~~~~", "98,791,480", "");

        //after another unary
        checkTyped("8^~", "-64", "negate(sqr(8))");
        checkTyped("123^~", "-15,129", "negate(sqr(123))");
        checkTyped("49@~", "-7", "negate(√(49))");
        checkTyped("3600000000@~", "-60,000", "negate(√(3600000000))");
        checkTyped("1;~", "-1", "negate(1/(1))");
        checkTyped("0.000001;~", "-1,000,000", "negate(1/(0.000001))");

        //after binary
        checkTyped("16+~", "-16", "16 + negate(16)");
        checkTyped("7624+~", "-7,624", "7624 + negate(7624)");
        checkTyped("564-~", "-564", "564 - negate(564)");
        checkTyped("6522456-~", "-6,522,456", "6522456 - negate(6522456)");
        checkTyped("12*~", "-12", "12 × negate(12)");
        checkTyped("344363*~", "-344,363", "344363 × negate(344363)");
        checkTyped("55/~", "-55", "55 ÷ negate(55)");
        checkTyped("1567/~", "-1,567", "1567 ÷ negate(1567)");

        //after percent
        checkTyped("78%~", "0", "negate(0)");
        checkTyped("56245%~", "0", "negate(0)");

        //after equals
        checkTyped("73=~", "-73", "negate(73)");
        checkTyped("532626=~", "-532,626", "negate(532626)");

        //negating negated
        checkTyped("92/5=~~", "18.4", "negate(negate(18.4))");
        checkTyped("8898+123=~~~", "-9,021", "negate(negate(negate(9021)))");

        //negating after second inputted
        checkTyped("8*6~", "-6", "8 ×");
        checkTyped("856-30~", "-30", "856 -");

        //after second calculating
        checkTyped("8*6^~", "-36", "8 × negate(sqr(6))");
        checkTyped("1+2+3+4^^~", "-256", "1 + 2 + 3 + negate(sqr(sqr(4)))");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("~");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("~");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("~");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("~");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for square operation.
     */
    private void sqrTests() {
        //standard cases
        checkTyped("^", "0", "sqr(0)");
        checkTyped("0^", "0", "sqr(0)");
        checkTyped("1^", "1", "sqr(1)");
        checkTyped("2^", "4", "sqr(2)");
        checkTyped("3^", "9", "sqr(3)");
        checkTyped("4^", "16", "sqr(4)");
        checkTyped("5^", "25", "sqr(5)");
        checkTyped("6^", "36", "sqr(6)");
        checkTyped("7^", "49", "sqr(7)");
        checkTyped("8^", "64", "sqr(8)");
        checkTyped("9^", "81", "sqr(9)");

        //without comma
        checkTyped("17^", "289", "sqr(17)");
        checkTyped("256^", "65,536", "sqr(256)");

        //with comma
        checkTyped("11515^", "132,595,225", "sqr(11515)");
        checkTyped("734347956^", "5.392669204813779e+17", "sqr(734347956)");

        //several sqr operations
        checkTyped("1^2^3", "3", "");
        checkTyped("1^2^3^", "9","sqr(3)");
        checkTyped("100^1000^10000^100000", "100,000", "");
        checkTyped("100^1000^10000^100000^", "10,000,000,000", "sqr(100000)");

        //after dot
        checkTyped("62.^", "3,844", "sqr(62)");
        checkTyped("623626.^", "388,909,387,876", "sqr(623626)");

        //in a row
        checkTyped("866^^^^^", "1.00131920194e+94",
                "sqr(sqr(sqr(sqr(sqr(866)))))");
        checkTyped("98791480^^^^^^", "4.592482041402361e+511",
                "sqr(sqr(sqr(sqr(sqr(sqr(98791480))))))");

        //after another unary
        checkTyped("8~^", "64", "sqr(-8)");
        checkTyped("123~^", "15,129", "sqr(-123)");
        checkTyped("49@^", "49", "sqr(√(49))");
        checkTyped("3600000000@^", "3,600,000,000", "sqr(√(3600000000))");
        checkTyped("1;^", "1", "sqr(1/(1))");
        checkTyped("0.000001;^", "1,000,000,000,000", "sqr(1/(0.000001))");

        //after binary
        checkTyped("16+^", "256", "16 + sqr(16)");
        checkTyped("7624+^", "58,125,376", "7624 + sqr(7624)");
        checkTyped("564-^", "318,096", "564 - sqr(564)");
        checkTyped("6522456-^", "42,542,432,271,936", "6522456 - sqr(6522456)");
        checkTyped("12*^", "144", "12 × sqr(12)");
        checkTyped("344363*^", "118,585,875,769", "344363 × sqr(344363)");
        checkTyped("55/^", "3,025", "55 ÷ sqr(55)");
        checkTyped("1567/^", "2,455,489", "1567 ÷ sqr(1567)");

        //after percent
        checkTyped("78%^", "0", "sqr(0)");
        checkTyped("56245%^", "0", "sqr(0)");

        //after equals
        checkTyped("73=^", "5,329", "sqr(73)");
        checkTyped("532626=^", "283,690,455,876", "sqr(532626)");

        //sqr after second inputted
        checkTyped("8*6^", "36", "8 × sqr(6)");
        checkTyped("856-30^", "900", "856 - sqr(30)");

        //after second calculating
        checkTyped("8*6^^", "1,296", "8 × sqr(sqr(6))");
        checkTyped("1+2+3+4;^", "0.0625", "1 + 2 + 3 + sqr(1/(4))");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("^");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("sqr(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("^");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("sqr(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("^");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("sqr(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("^");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("sqr(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for square root operation.
     */
    private void sqrtTests() {
        //standard cases
        checkTyped("@", "0", "√(0)");
        checkTyped("0@", "0", "√(0)");
        checkTyped("1@", "1", "√(1)");
        checkTyped("2@", "1.414213562373095", "√(2)");
        checkTyped("3@", "1.732050807568877", "√(3)");
        checkTyped("4@", "2", "√(4)");
        checkTyped("5@", "2.23606797749979", "√(5)");
        checkTyped("6@", "2.449489742783178", "√(6)");
        checkTyped("7@", "2.645751311064591", "√(7)");
        checkTyped("8@", "2.82842712474619", "√(8)");
        checkTyped("9@", "3", "√(9)");

        //without comma
        checkTyped("17@", "4.123105625617661", "√(17)");
        checkTyped("256@", "16", "√(256)");

        //with comma
        checkTyped("11515@", "107.3079680172912", "√(11515)");
        checkTyped("734347956@", "27,098.85525257478", "√(734347956)");

        //several sqrt operations
        checkTyped("1@2@3", "3", "");
        checkTyped("1@2@3@", "1.732050807568877","√(3)");
        checkTyped("100@1000@10000@100000", "100,000", "");
        checkTyped("100@1000@10000@100000@", "316.2277660168379", "√(100000)");

        //after dot
        checkTyped("62.@", "7.874007874011811", "√(62)");
        checkTyped("623626.@", "789.6999430163333", "√(623626)");

        //in a row
        checkTyped("866@@@@@", "1.235371090882345",
                "√(√(√(√(√(866)))))");
        checkTyped("98791480@@@@@@", "1.333268111746662",
                "√(√(√(√(√(√(98791480))))))");

        //after another unary
        checkTyped("8~@", "Invalid input", "√(-8)");
        checkTyped("123~@", "Invalid input", "√(-123)");
        checkTyped("49^@", "49", "√(sqr(49))");
        checkTyped("3600000000^@", "3,600,000,000", "√(sqr(3600000000))");
        checkTyped("1;@", "1", "√(1/(1))");
        checkTyped("0.000001;@", "1,000", "√(1/(0.000001))");

        //after binary
        checkTyped("16+@", "4", "16 + √(16)");
        checkTyped("7624+@", "87.31551981177229", "7624 + √(7624)");
        checkTyped("564-@", "23.74868417407583", "564 - √(564)");
        checkTyped("6522456-@", "2,553.909943596289", "6522456 - √(6522456)");
        checkTyped("12*@", "3.464101615137755", "12 × √(12)");
        checkTyped("344363*@", "586.8245052824567", "344363 × √(344363)");
        checkTyped("55/@", "7.416198487095663", "55 ÷ √(55)");
        checkTyped("1567/@", "39.58535082577897", "1567 ÷ √(1567)");

        //after percent
        checkTyped("78%@", "0", "√(0)");
        checkTyped("56245%@", "0", "√(0)");

        //after equals
        checkTyped("73=@", "8.544003745317531", "√(73)");
        checkTyped("532626=@", "729.8123046372951", "√(532626)");

        //sqrt after second inputted
        checkTyped("8*6@", "2.449489742783178", "8 × √(6)");
        checkTyped("856-30@", "5.477225575051661", "856 - √(30)");

        //after second calculating
        checkTyped("8*6^@", "6", "8 × √(sqr(6))");
        checkTyped("1+2+3+4;@", "0.5", "1 + 2 + 3 + √(1/(4))");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("@");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("√(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("@");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("√(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("@");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("√(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("@");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("√(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for inverse operation.
     */
    private void inverseTests() {
        //standard cases
        checkTyped(";", "Cannot divide by zero", "1/(0)");
        checkTyped("0;", "Cannot divide by zero", "1/(0)");
        checkTyped("1;", "1", "1/(1)");
        checkTyped("2;", "0.5", "1/(2)");
        checkTyped("3;", "0.3333333333333333", "1/(3)");
        checkTyped("4;", "0.25", "1/(4)");
        checkTyped("5;", "0.2", "1/(5)");
        checkTyped("6;", "0.1666666666666667", "1/(6)");
        checkTyped("7;", "0.1428571428571429", "1/(7)");
        checkTyped("8;", "0.125", "1/(8)");
        checkTyped("9;", "0.1111111111111111", "1/(9)");

        //without comma
        checkTyped("17;", "0.0588235294117647", "1/(17)");
        checkTyped("256;", "0.00390625", "1/(256)");

        //with comma
        checkTyped("11515;", "8.684324793747286e-5", "1/(11515)");
        checkTyped("734347956;", "1.361752275375027e-9", "1/(734347956)");

        //several inverse operations
        checkTyped("1;2;3", "3", "");
        checkTyped("1;2;3;", "0.3333333333333333","1/(3)");
        checkTyped("100;1000;10000;100000", "100,000", "");
        checkTyped("100;1000;10000;100000;", "0.00001", "1/(100000)");

        //after dot
        checkTyped("62.;", "0.0161290322580645", "1/(62)");
        checkTyped("623626.;", "1.603525189777206e-6", "1/(623626)");

        //in a row
        checkTyped("866;;;;;", "0.0011547344110855",
                "1/(1/(1/(1/(1/(866)))))");
        checkTyped("98791480;;;;;;", "98,791,480",
                "1/(1/(1/(1/(1/(1/(98791480))))))");

        //after another unary
        checkTyped("8~;", "-0.125", "1/(-8)");
        checkTyped("123~;", "-0.008130081300813", "1/(-123)");
        checkTyped("49^;", "4.164931278633903e-4", "1/(sqr(49))");
        checkTyped("3600000000^;", "7.716049382716049e-20", "1/(sqr(3600000000))");
        checkTyped("1@;", "1", "1/(√(1))");
        checkTyped("0.000001@;", "1,000", "1/(√(0.000001))");

        //after binary
        checkTyped("16+;", "0.0625", "16 + 1/(16)");
        checkTyped("7624+;", "1.311647429171039e-4", "7624 + 1/(7624)");
        checkTyped("564-;", "0.0017730496453901", "564 - 1/(564)");
        checkTyped("6522456-;", "1.533164807857654e-7", "6522456 - 1/(6522456)");
        checkTyped("12*;", "0.0833333333333333", "12 × 1/(12)");
        checkTyped("344363*;", "2.903912441232072e-6", "344363 × 1/(344363)");
        checkTyped("55/;", "0.0181818181818182", "55 ÷ 1/(55)");
        checkTyped("1567/;", "6.381620931716656e-4", "1567 ÷ 1/(1567)");

        //after percent
        checkTyped("78%;", "Cannot divide by zero", "1/(0)");
        checkTyped("56245%;", "Cannot divide by zero", "1/(0)");

        //after equals
        checkTyped("73=;", "0.0136986301369863", "1/(73)");
        checkTyped("532626=;", "1.877490021140538e-6", "1/(532626)");

        //inverse after second inputted
        checkTyped("8*6;", "0.1666666666666667", "8 × 1/(6)");
        checkTyped("856-30;", "0.0333333333333333", "856 - 1/(30)");

        //after second calculating
        checkTyped("8*6^;", "0.0277777777777778", "8 × 1/(sqr(6))");
        checkTyped("1+2+3+4;;", "4", "1 + 2 + 3 + 1/(1/(4))");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons(";");
        assertEquals("Cannot divide by zero", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("1/(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons(";");
        assertEquals("Cannot divide by zero", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("1/(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons(";");
        assertEquals("Cannot divide by zero", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("1/(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons(";");
        assertEquals("Cannot divide by zero", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("1/(0)", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for percentage operation.
     */
    private void percentageTests() {
        //standard cases
        checkTyped("%", "0", "0");
        checkTyped("0%", "0", "0");
        checkTyped("1%", "0", "0");
        checkTyped("2%", "0", "0");
        checkTyped("3%", "0", "0");
        checkTyped("4%", "0", "0");
        checkTyped("5%", "0", "0");
        checkTyped("6%", "0", "0");
        checkTyped("7%", "0", "0");
        checkTyped("8%", "0", "0");
        checkTyped("9%", "0", "0");

        //without comma
        checkTyped("17%", "0", "0");
        checkTyped("256%", "0", "0");

        //with comma
        checkTyped("11515%", "0", "0");
        checkTyped("734347956%", "0", "0");

        //several sqrt operations
        checkTyped("1%2%3", "3", "");
        checkTyped("1%2%3%", "0","0");
        checkTyped("100%1000%10000%100000", "100,000", "");
        checkTyped("100%1000%10000%100000%", "0", "0");

        //after dot
        checkTyped("62.%", "0", "0");
        checkTyped("623626.%", "0", "0");

        //in a row
        checkTyped("866%%%%%", "0","0");
        checkTyped("98791480%%%%%%", "0","0");

        //after unary
        checkTyped("8~%", "0", "0");
        checkTyped("123~%", "0", "0");
        checkTyped("49^%", "0", "0");
        checkTyped("3600000000^%", "0", "0");
        checkTyped("64@%", "0", "0");
        checkTyped("1234@%", "0", "0");
        checkTyped("1;%", "0", "0");
        checkTyped("0.000001;%", "0", "0");

        //after binary
        checkTyped("16+%", "2.56", "16 + 2.56");
        checkTyped("7624+%", "581,253.76", "7624 + 581253.76");
        checkTyped("564-%", "3,180.96", "564 - 3180.96");
        checkTyped("6522456-%", "425,424,322,719.36",
                "6522456 - 425424322719.36");
        checkTyped("12*%", "0.12", "12 × 0.12");
        checkTyped("344363*%", "3,443.63", "344363 × 3443.63");
        checkTyped("55/%", "0.55", "55 ÷ 0.55");
        checkTyped("1567/%", "15.67", "1567 ÷ 15.67");

        //after equals
        checkTyped("73=%", "0", "0");
        checkTyped("532626=%", "0", "0");

        //percent after second inputted
        checkTyped("8*6%", "0.06", "8 × 0.06");
        checkTyped("856-30%", "256.8", "856 - 256.8");

        //after second calculating
        checkTyped("8*6^%", "0.36", "8 × 0.36");
        checkTyped("1+2+3+4;%", "0.015", "1 + 2 + 3 + 0.015");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("%");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("%");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("%");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("%");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("0", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Tests for equals operation.
     */
    private void equalsTests() {
        //standard cases
        checkTyped("=", "0", "");
        checkTyped("0=", "0", "");
        checkTyped("1=", "1", "");
        checkTyped("2=", "2", "");
        checkTyped("3=", "3", "");
        checkTyped("4=", "4", "");
        checkTyped("5=", "5", "");
        checkTyped("6=", "6", "");
        checkTyped("7=", "7", "");
        checkTyped("8=", "8", "");
        checkTyped("9=", "9", "");

        //without comma
        checkTyped("17=", "17", "");
        checkTyped("256=", "256", "");

        //with comma
        checkTyped("11515=", "11,515", "");
        checkTyped("734347956=", "734,347,956", "");

        //several equals operations
        checkTyped("1=2=3", "3", "");
        checkTyped("1=2=3=", "3","");
        checkTyped("100=1000=10000=100000", "100,000", "");
        checkTyped("100=1000=10000=100000=", "100,000", "");

        //after dot
        checkTyped("62.=", "62", "");
        checkTyped("623626.=", "623,626", "");

        //in a row without binary set
        checkTyped("866=====", "866","");
        checkTyped("98791480======", "98,791,480","");

        //in a row with binary set
        checkTyped("866+123=====", "1,481","");
        checkTyped("98791480/10======", "98.79148","");

        //after unary without binary set
        checkTyped("8~=", "-8", "");
        checkTyped("123~=", "-123", "");
        checkTyped("49^=", "2,401", "");
        checkTyped("3600000000^=", "1.296e+19", "");
        checkTyped("64@=", "8", "");
        checkTyped("1234@=", "35.12833614050059", "");
        checkTyped("1;=", "1", "");
        checkTyped("0.000001;=", "1,000,000", "");

        //after unary with binary set
        checkTyped("5+8~=", "-3", "");
        checkTyped("13-123~=", "136", "");
        checkTyped("7543*49^=", "18,110,743", "");
        checkTyped("0/3600000000^=", "0", "");
        checkTyped("55+64@=", "63", "");
        checkTyped("2134-1234@=", "2,098.871663859499", "");
        checkTyped("213*1;=", "213", "");
        checkTyped("1000/0.000001;=", "0.001", "");

        //several in a row after unary with binary set
        checkTyped("5+8~=====", "-35", "");
        checkTyped("13-123~====", "505", "");
        checkTyped("7543*49^======", "1.445097228303612e+24", "");
        checkTyped("0/3600000000^====", "0", "");
        checkTyped("55+64@====", "87", "");
        checkTyped("2134-1234@==", "2,063.743327718998", "");
        checkTyped("213*1;====", "213", "");
        checkTyped("1000/0.000001;=======", "1.e-39", "");

        //after binary
        checkTyped("16+=", "32", "");
        checkTyped("7624+=", "15,248", "");
        checkTyped("564-=", "0", "");
        checkTyped("6522456-=", "0", "");
        checkTyped("12*=", "144", "");
        checkTyped("344363*=", "118,585,875,769", "");
        checkTyped("55/=", "1", "");
        checkTyped("1567/=", "1", "");

        //several in a row after binary
        checkTyped("16+==", "48", "");
        checkTyped("7624+===", "30,496", "");
        checkTyped("564-====", "-1,692", "");
        checkTyped("6522456-=====", "-26,089,824", "");
        checkTyped("12*=====", "2,985,984", "");
        checkTyped("344363*===", "1.40626099319007e+22", "");
        checkTyped("55/====", "6.010518407212627e-6", "");
        checkTyped("1567/==", "6.381620931716656e-4", "");

        //after percent
        checkTyped("6%=", "0", "");
        checkTyped("730%=", "0", "");

        //after percent with binary set
        checkTyped("5+6%=", "5.3", "");
        checkTyped("123*730%=", "897.9", "");

        //several in a row after percent with binary set
        checkTyped("5+6%====", "6.2", "");
        checkTyped("123*730%===", "47,849.091", "");

        //equals after second inputted
        checkTyped("8*6=", "48", "");
        checkTyped("856-30=", "826", "");

        //after error
        checkTyped("/0==", "0", "");
        checkTyped(";=", "0", "");

        //after clear text
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("=");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564");
        clickOn(getButtonBySelector(CLEAR_TEXT_ID));
        clickButtons("=");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        //after clear all
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("124");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("=");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());

        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("564*");
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons("=");
        assertEquals("0", getLabeledBySelector(SCREEN_LABEL_ID).getText());
        assertEquals("", getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Checks that screen label has required text after clicking on buttons.
     *
     * @param buttons            buttons that should be clicked.
     * @param expectedScreenText required text on screen after clicking.
     */
    private void checkTyped(String buttons, String expectedScreenText) {
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons(buttons);

        assertEquals(expectedScreenText, getLabeledBySelector(SCREEN_LABEL_ID).getText());
    }

    /**
     * Checks that screen label and equation label have required texts after clicking on buttons.
     *
     * @param buttons              buttons that should be clicked.
     * @param expectedScreenText   required text on screen after clicking.
     * @param expectedEquationText required text on equation label after clicking.
     */
    private void checkTyped(String buttons, String expectedScreenText, String expectedEquationText) {
        checkTyped(buttons, expectedScreenText);
        assertEquals(expectedEquationText, getLabeledBySelector(EQUATION_LABEL_ID).getText());
    }

    /**
     * Checks that text in screen label is cleared but not in equation label after clear text operation.
     * Then checks that  text in screen label is cleared as well as in equation label after clear all operation.
     *
     * @param buttons buttons that should be clicked before clearing.
     */
    private void checkClear(String buttons) {
        clickOn(getButtonBySelector(CLEAR_ALL_ID));

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
}
