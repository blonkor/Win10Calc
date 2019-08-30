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
        //can append
        {
            //without operations
            //no commas
            checkAppendDigits("1", "1");
            checkAppendDigits("2", "2");
            checkAppendDigits("3", "3");
            checkAppendDigits("4", "4");
            checkAppendDigits("5", "5");
            checkAppendDigits("6", "6");
            checkAppendDigits("7", "7");
            checkAppendDigits("8", "8");
            checkAppendDigits("9", "9");

            checkAppendDigits("10", "10");
            checkAppendDigits("111", "111");
            checkAppendDigits("123", "123");
            checkAppendDigits("567", "567");
            checkAppendDigits("235", "235");
            checkAppendDigits("899", "899");
            checkAppendDigits("123", "123");
            checkAppendDigits("736", "736");

            //commas
            checkAppendDigits("4890", "4,890");
            checkAppendDigits("1234567890", "1,234,567,890");
            checkAppendDigits("2523568346536", "2,523,568,346,536");
            checkAppendDigits("8246", "8,246");
            checkAppendDigits("2652626", "2,652,626");
            checkAppendDigits("15135945", "15,135,945");
            checkAppendDigits("1240917825971", "1,240,917,825,971");
            checkAppendDigits("218175", "218,175");

            //16 digits
            checkAppendDigits("1122334455667788", "1,122,334,455,667,788");
            checkAppendDigits("5893127592375922", "5,893,127,592,375,922");
            checkAppendDigits("3250293850723580", "3,250,293,850,723,580");
            checkAppendDigits("3259000234000023", "3,259,000,234,000,023");

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

            //after unary (but not negate) operation pressed
            checkAppendDigits("1^752", "752");
            checkAppendDigits("79^234", "234");
            checkAppendDigits("682^2124", "2,124");
            checkAppendDigits("7238^14785", "14,785");

            checkAppendDigits("9@825", "825");
            checkAppendDigits("2148@213", "213");
            checkAppendDigits("345724@23478", "23,478");
            checkAppendDigits("325273@72352525", "72,352,525");

            checkAppendDigits("717;7", "7");
            checkAppendDigits("72358;123", "123");
            checkAppendDigits("124135;3252362367", "3,252,362,367");
            checkAppendDigits("7235;12453476436", "12,453,476,436");

            //after binary operations
            checkAppendDigits("9+2", "2");
            checkAppendDigits("124+12", "12");
            checkAppendDigits("82561+132414", "132,414");
            checkAppendDigits("8762452+63333", "63,333");

            checkAppendDigits("324-0", "0");
            checkAppendDigits("3224-213", "213");
            checkAppendDigits("76524-08244", "8,244");
            checkAppendDigits("3254-7324552", "7,324,552");

            checkAppendDigits("12313*1", "1");
            checkAppendDigits("31235*3", "3");
            checkAppendDigits("213773*213783", "213,783");
            checkAppendDigits("1157*21376", "21,376");

            checkAppendDigits("23/78", "78");
            checkAppendDigits("2465/744", "744");
            checkAppendDigits("1249/876511", "876,511");
            checkAppendDigits("242222/123000", "123,000");

            //after equals
            checkAppendDigits("1325=131", "131");
            checkAppendDigits("52229=0", "0");
            checkAppendDigits("33=145266", "145,266");
            checkAppendDigits("765452452=13131331521325", "13,131,331,521,325");

            checkAppendDigits("11+67=1", "1");
            checkAppendDigits("13456-9000=33", "33");
            checkAppendDigits("789*624=12462", "12,462");
            checkAppendDigits("823526/24362=235111145", "235,111,145");

            //after error
            checkAppendDigits("/0123", "123");
            checkAppendDigits("/000678", "678");
            checkAppendDigits("/01238765", "1,238,765");
            checkAppendDigits("/08234629", "8,234,629");

            checkAppendDigits("13/0823", "823");
            checkAppendDigits("87623/0188", "188");
            checkAppendDigits("324654/06752", "6,752");
            checkAppendDigits("14356/032466", "32,466");

            //after dot
            checkAppendDigits("123.98714", "123.98714");
            checkAppendDigits(".14415", "0.14415");
            checkAppendDigits("363242.735636", "363,242.735636");
            checkAppendDigits("2573525.34", "2,573,525.34");

            //after dot with 16 digits summary
            checkAppendDigits("784.0972347859825", "784.0972347859825");
            checkAppendDigits("3.982173917495125", "3.982173917495125");
            checkAppendDigits("21319487195.79321", "21,319,487,195.79321");
            checkAppendDigits("123019.8498533564", "123,019.8498533564");

            //after dot with 17 digits summary (starts with 0.)
            checkAppendDigits("0.1223458901245678", "0.1223458901245678");
            checkAppendDigits("0.0935678239045672", "0.0935678239045672");
            checkAppendDigits("0.1427634784364787", "0.1427634784364787");
            checkAppendDigits("0.1431413532157567", "0.1431413532157567");

            //after dot and negated
            checkAppendDigits("7~25.72572", "-725.72572");
            checkAppendDigits("124~.4167", "-124.4167");
            checkAppendDigits("865243.6~2342345", "-865,243.62342345");
            checkAppendDigits("78632.224~32678", "-78,632.22432678");

            //after dot with 16 digits summary and negated
            checkAppendDigits("9~.034567823459875", "-9.034567823459875");
            checkAppendDigits("897~.1421005093210", "-897.1421005093210");
            checkAppendDigits("1241987502.35~0063", "-1,241,987,502.350063");
            checkAppendDigits("123657.29582~00256", "-123,657.2958200256");

            //after dot with 17 digits summary (starts with 0.) and negated
            checkAppendDigits("0.85298~23546736765", "-0.8529823546736765");
            checkAppendDigits("0.143219~8529579336", "-0.1432198529579336");
            checkAppendDigits("0.19352187392572~34", "-0.1935218739257234");
            checkAppendDigits("0.1376~663534687667", "-0.1376663534687667");

            //after backspace
            checkAppendDigits("<132", "132");
            checkAppendDigits("<87", "87");
            checkAppendDigits("<5633563", "5,633,563");
            checkAppendDigits("<257537356", "257,537,356");

            checkAppendDigits("8<324", "324");
            checkAppendDigits("9<625", "625");
            checkAppendDigits("2<5232", "5,232");
            checkAppendDigits("7<15316516", "15,316,516");

            checkAppendDigits("64<6", "66");
            checkAppendDigits("11<12", "112");
            checkAppendDigits("74363<231321", "7,436,231,321");
            checkAppendDigits("1235<643", "123,643");

            //after clear text
            clickButtons("561235");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkAppendDigits("654", "654");

            clickButtons("1462656");
            clickOn(getButtonBySelector(CLEAR_TEXT_ID));
            checkAppendDigits("141514", "141,514");

            //after clear all
            clickButtons("736346");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkAppendDigits("12", "12");

            clickButtons("213");
            clickOn(getButtonBySelector(CLEAR_ALL_ID));
            checkAppendDigits("12467", "12,467");
        }

        //can not append
        {
            checkAppendDigits("", "0");
            checkAppendDigits("0", "0");
            checkAppendDigits("00", "0");

            //17 digits
            checkAppendDigits("12345678901234567", "1,234,567,890,123,456");
            checkAppendDigits("87984719571987591", "8,798,471,957,198,759");

            //more than 17 digits
            checkAppendDigits("2198370919080518325071051", "2,198,370,919,080,518");
            checkAppendDigits("1209847102458012850932805824092", "1,209,847,102,458,012");

            //17 and negate
            checkAppendDigits("123456789~01234567", "-1,234,567,890,123,456");
            checkAppendDigits("87984~719571987591", "-8,798,471,957,198,759");

            //more than 17 and negate
            checkAppendDigits("219~8370919080518325071051", "-2,198,370,919,080,518");
            checkAppendDigits("120984710245~8012850932805824092", "-1,209,847,102,458,012");

            //17 and dot
            checkAppendDigits("123456789.01234567", "123,456,789.0123456");
            checkAppendDigits("87984.719571987591", "87,984.71957198759");

            //more than 17 and dot
            checkAppendDigits("219.8370919080518325071051", "219.8370919080518");
            checkAppendDigits("120984710245.8012850932805824092", "120,984,710,245.8012");

            //17 and dot and negate
            checkAppendDigits("123456~789.01234567", "-123,456,789.0123456");
            checkAppendDigits("879~84.719571987591", "-87,984.71957198759");

            //more than 17 and dot and negate
            checkAppendDigits("219.837~0919080518325071051", "-219.8370919080518");
            checkAppendDigits("120~984710245.8012850932805824092", "-120,984,710,245.8012");

            //18 and dot and starts with 0.
            checkAppendDigits("0.87523456890076345", "0.8752345689007634");
            checkAppendDigits("0.74363738736363636", "0.7436373873636363");

            //more than 18 and dot and starts with 0.
            checkAppendDigits("0.19878913759321752430626236525", "0.1987891375932175");
            checkAppendDigits("0.3242384729375982760260286", "0.3242384729375982");

            //18 and dot and starts with 0. and negate
            checkAppendDigits("0.8752345~6890076345", "-0.8752345689007634");
            checkAppendDigits("0.74~363738736363636", "-0.7436373873636363");

            //more than 18 and dot and starts with 0. and negate
            checkAppendDigits("0.19878~913759321752430626236525", "-0.1987891375932175");
            checkAppendDigits("0.3~242384729375982760260286", "-0.3242384729375982");
        }
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
