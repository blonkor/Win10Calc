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
     * Runs al tests
     */
    @Test
    public void allTests() {
        appendDigitTests();
        appendDotTests();
    }

    /**
     * Tests for appending digits.
     */
    private void appendDigitTests() {
        //can append
        {
            //without operations
            //no commas
            checkAppend("1", "1");
            checkAppend("2", "2");
            checkAppend("3", "3");
            checkAppend("4", "4");
            checkAppend("5", "5");
            checkAppend("6", "6");
            checkAppend("7", "7");
            checkAppend("8", "8");
            checkAppend("9", "9");

            checkAppend("10", "10");
            checkAppend("111", "111");
            checkAppend("123", "123");
            checkAppend("736", "736");

            //commas
            checkAppend("4890", "4,890");
            checkAppend("1234567890", "1,234,567,890");
            checkAppend("1240917825971", "1,240,917,825,971");
            checkAppend("218175", "218,175");

            //16 digits
            checkAppend("1122334455667788", "1,122,334,455,667,788");
            checkAppend("3259000234000023", "3,259,000,234,000,023");

            //with negated number (minus should be saved)
            //no commas
            checkAppend("1~1", "-11");
            checkAppend("5~5", "-55");
            checkAppend("8~27", "-827");
            checkAppend("8~96", "-896");

            //commas
            checkAppend("6~1237", "-61,237");
            checkAppend("8~734", "-8,734");
            checkAppend("2~6234626", "-26,234,626");
            checkAppend("3~7774236523452", "-37,774,236,523,452");

            //16 digits
            checkAppend("7~890635789000000", "-7,890,635,789,000,000");
            checkAppend("6~235483463468345", "-6,235,483,463,468,345");

            //after unary (but not negate) operation pressed
            checkAppend("1^752", "752");
            checkAppend("7238^14785", "14,785");

            checkAppend("9@825", "825");
            checkAppend("325273@72352525", "72,352,525");

            checkAppend("717;7", "7");
            checkAppend("7235;12453476436", "12,453,476,436");

            //after binary operations
            checkAppend("9+2", "2");
            checkAppend("8762452+63333", "63,333");

            checkAppend("324-0", "0");
            checkAppend("3254-7324552", "7,324,552");

            checkAppend("12313*1", "1");
            checkAppend("1157*21376", "21,376");

            checkAppend("23/78", "78");
            checkAppend("242222/123000", "123,000");

            //after equals
            checkAppend("1325=131", "131");
            checkAppend("765452452=13131331521325", "13,131,331,521,325");

            //after error
            checkAppend("/0123", "123");
            checkAppend("/08234629", "8,234,629");

            //after dot
            checkAppend("123.98714", "123.98714");
            checkAppend("2573525.34", "2,573,525.34");

            //after dot with 16 digits summary
            checkAppend("784.0972347859825", "784.0972347859825");
            checkAppend("123019.8498533564", "123,019.8498533564");

            //after dot with 17 digits summary (starts with 0.)
            checkAppend("0.1223458901245678", "0.1223458901245678");
            checkAppend("0.1431413532157567", "0.1431413532157567");

            //after dot and negated
            checkAppend("7~25.72572", "-725.72572");
            checkAppend("78632.224~32678", "-78,632.22432678");

            //after dot with 16 digits summary and negated
            checkAppend("9~.034567823459875", "-9.034567823459875");
            checkAppend("123657.29582~00256", "-123,657.2958200256");

            //after dot with 17 digits summary (starts with 0.) and negated
            checkAppend("0.85298~23546736765", "-0.8529823546736765");
            checkAppend("0.1376~663534687667", "-0.1376663534687667");

            //after backspace
            checkAppend("<132", "132");
            checkAppend("<257537356", "257,537,356");

            checkAppend("8<324", "324");
            checkAppend("7<15316516", "15,316,516");

            checkAppend("64<6", "66");
            checkAppend("1235<643", "123,643");

            //after clear text
            clickButtons("561235");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkAppend("654", "654");

            clickButtons("1462656");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkAppend("141514", "141,514");

            //after clear all
            clickButtons("736346");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkAppend("12", "12");

            clickButtons("213");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkAppend("12467", "12,467");
        }

        //can not append
        {
            checkAppend("", "0");
            checkAppend("0", "0");
            checkAppend("00", "0");

            //17 digits
            checkAppend("12345678901234567", "1,234,567,890,123,456");
            checkAppend("87984719571987591", "8,798,471,957,198,759");

            //more than 17 digits
            checkAppend("2198370919080518325071051", "2,198,370,919,080,518");
            checkAppend("1209847102458012850932805824092", "1,209,847,102,458,012");

            //17 and negate
            checkAppend("123456789~01234567", "-1,234,567,890,123,456");
            checkAppend("87984~719571987591", "-8,798,471,957,198,759");

            //more than 17 and negate
            checkAppend("219~8370919080518325071051", "-2,198,370,919,080,518");
            checkAppend("120984710245~8012850932805824092", "-1,209,847,102,458,012");

            //17 and dot
            checkAppend("123456789.01234567", "123,456,789.0123456");
            checkAppend("87984.719571987591", "87,984.71957198759");

            //more than 17 and dot
            checkAppend("219.8370919080518325071051", "219.8370919080518");
            checkAppend("120984710245.8012850932805824092", "120,984,710,245.8012");

            //17 and dot and negate
            checkAppend("123456~789.01234567", "-123,456,789.0123456");
            checkAppend("879~84.719571987591", "-87,984.71957198759");

            //more than 17 and dot and negate
            checkAppend("219.837~0919080518325071051", "-219.8370919080518");
            checkAppend("120~984710245.8012850932805824092", "-120,984,710,245.8012");

            //18 and dot and starts with 0.
            checkAppend("0.87523456890076345", "0.8752345689007634");
            checkAppend("0.74363738736363636", "0.7436373873636363");

            //more than 18 and dot and starts with 0.
            checkAppend("0.19878913759321752430626236525", "0.1987891375932175");
            checkAppend("0.3242384729375982760260286", "0.3242384729375982");

            //18 and dot and starts with 0. and negate
            checkAppend("0.8752345~6890076345", "-0.8752345689007634");
            checkAppend("0.74~363738736363636", "-0.7436373873636363");

            //more than 18 and dot and starts with 0. and negate
            checkAppend("0.19878~913759321752430626236525", "-0.1987891375932175");
            checkAppend("0.3~242384729375982760260286", "-0.3242384729375982");
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
            checkAppend("1.", "1.");
            checkAppend("2.", "2.");
            checkAppend("3.", "3.");
            checkAppend("4.", "4.");
            checkAppend("5.", "5.");
            checkAppend("6.", "6.");
            checkAppend("7.", "7.");
            checkAppend("8.", "8.");
            checkAppend("9.", "9.");

            checkAppend("10.", "10.");
            checkAppend("111.", "111.");
            checkAppend("123.", "123.");
            checkAppend("736.", "736.");

            //commas
            checkAppend("4890.", "4,890.");
            checkAppend("1234567890.", "1,234,567,890.");
            checkAppend("1240917825971.", "1,240,917,825,971.");
            checkAppend("218175.", "218,175.");

            //16 digits
            checkAppend("1122334455667788.", "1,122,334,455,667,788.");
            checkAppend("5893127592375922.", "5,893,127,592,375,922.");

            //17 digits
            checkAppend("12345678901234568.", "1,234,567,890,123,456.");
            checkAppend("87984719571987594.", "8,798,471,957,198,759.");

            //more than 17 digits
            checkAppend("219837091908051832507105.", "2,198,370,919,080,518.");
            checkAppend("120984710245801285093280582409.", "1,209,847,102,458,012.");

            //17 and negate
            checkAppend("123456789~01234567.", "-1,234,567,890,123,456.");
            checkAppend("87984~719571987591.", "-8,798,471,957,198,759.");

            //more than 17 and negate
            checkAppend("219~8370919080518325071051.", "-2,198,370,919,080,518.");
            checkAppend("120984710245~8012850932805824092.", "-1,209,847,102,458,012.");

            //with negated number
            //no commas
            checkAppend("1~.", "-1.");
            checkAppend("5~.", "-5.");
            checkAppend("8~27.", "-827.");
            checkAppend("8~96.", "-896.");

            //commas
            checkAppend("61237~.", "-61,237.");
            checkAppend("8734~.", "-8,734.");
            checkAppend("2~6234626.", "-26,234,626.");
            checkAppend("3~7774236523452.", "-37,774,236,523,452.");

            //16 digits
            checkAppend("7890635789000000~.", "-7,890,635,789,000,000.");
            checkAppend("1765323523658345~.", "-1,765,323,523,658,345.");
            checkAppend("8~234876435942583.", "-8,234,876,435,942,583.");
            checkAppend("6~235483463468345.", "-6,235,483,463,468,345.");

            //after unary (but not negate) operation pressed
            checkAppend("1^.", "0.");
            checkAppend("7238^.", "0.");

            checkAppend("953@.", "0.");
            checkAppend("325273@.", "0.");

            checkAppend("7177;.", "0.");
            checkAppend("7235;.", "0.");

            //after binary operations
            checkAppend("9+.", "0.");
            checkAppend("8762452+.", "0.");

            checkAppend("324-.", "0.");
            checkAppend("3254-.", "0.");

            checkAppend("12313*.", "0.");
            checkAppend("1157*.", "0.");

            checkAppend("23/.", "0.");
            checkAppend("242222/.", "0.");

            //after equals
            checkAppend("1325=.", "0.");
            checkAppend("765452452=.", "0.");

            checkAppend("11+67=.", "0.");
            checkAppend("823526/24362=.", "0.");

            //after error
            checkAppend("/0.", "0.");
            checkAppend("13/0.", "0.");

            //after backspace
            checkAppend("123<.", "12.");
            checkAppend("2152343<.", "215,234.");

            //after clear text
            clickButtons("561235");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkAppend(".", "0.");

            clickButtons("1462656");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkAppend(".", "0.");

            //after clear all
            clickButtons("736346");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkAppend(".", "0.");

            clickButtons("213");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkAppend(".", "0.");
        }

        //can not append
        {
            checkAppend("..", "0.");
            checkAppend("..", "0.");
            checkAppend("...", "0.");

            //17 and dot
            checkAppend("123456789.01234567.", "123,456,789.0123456");
            checkAppend("87984.719571987591.", "87,984.71957198759");

            //more than 17 and dot
            checkAppend("219.8370919080518325071051.", "219.8370919080518");
            checkAppend("120984710245.8012850932805824092.", "120,984,710,245.8012");

            //17 and dot and negate
            checkAppend("123456~789.01234567.", "-123,456,789.0123456");
            checkAppend("879~84.719571987591.", "-87,984.71957198759");

            //more than 17 and dot and negate
            checkAppend("219.837~0919080518325071051.", "-219.8370919080518");
            checkAppend("120~984710245.8012850932805824092.", "-120,984,710,245.8012");

            //18 and dot and starts with 0.
            checkAppend("0.87523456890076345.", "0.8752345689007634");
            checkAppend("0.74363738736363636.", "0.7436373873636363");

            //more than 18 and dot and starts with 0.
            checkAppend("0.19878913759321752430626236525.", "0.1987891375932175");
            checkAppend("0.3242384729375982760260286.", "0.3242384729375982");

            //18 and dot and starts with 0. and negate
            checkAppend("0.8752345~6890076345.", "-0.8752345689007634");
            checkAppend("0.74~363738736363636.", "-0.7436373873636363");

            //more than 18 and dot and starts with 0. and negate
            checkAppend("0.19878~913759321752430626236525.", "-0.1987891375932175");
            checkAppend("0.3~242384729375982760260286.", "-0.3242384729375982");

            //already with dot
            checkAppend("1414.1.2..", "1,414.12");
            checkAppend("123.765.", "123.765");
            checkAppend("624362.5.34.", "624,362.534");
            checkAppend("8764....", "8,764.");
        }
    }



    /**
     * Checks that screen label has required text after clicking on buttons.
     *
     * @param buttons             buttons that should be clicked.
     * @param expectedScreenText required text on screen after clicking.
     */
    private void checkAppend(String buttons, String expectedScreenText) {
        clickOn(getButtonBySelector(CLEAR_ALL_ID));
        clickButtons(buttons);

        assertEquals(expectedScreenText, getLabeledBySelector(SCREEN_LABEL_ID).getText());
    }
}
