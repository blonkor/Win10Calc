package tests.controller;

import javafx.scene.control.Label;
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
     * Runs al tests
     */
    @Test
    public void allTests() {
        appendDigitTests();
        appendDotTests();
        backspaceTests();
        clearTests();
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
