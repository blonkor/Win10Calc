package tests.controller;

import com.implemica.bormashenko.calculator.controller.util.NumberFormatter;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for testing {@code NumberFormatter} in controller.
 *
 * @author Mykhailo Bormashenko
 * @see NumberFormatter
 */
public class NumberFormatterTest {

    /**
     * Tests for add dot operation.
     */
    @Test
    public void addDotTests() {
        //without dot
        //without commas
        checkAddDot("0", "0.");
        checkAddDot("1", "1.");
        checkAddDot("8", "8.");
        checkAddDot("9", "9.");
        checkAddDot("10", "10.");
        checkAddDot("100", "100.");
        checkAddDot("500", "500.");

        checkAddDot("-0", "-0.");
        checkAddDot("-1", "-1.");
        checkAddDot("-8", "-8.");
        checkAddDot("-9", "-9.");
        checkAddDot("-10", "-10.");
        checkAddDot("-100", "-100.");
        checkAddDot("-500", "-500.");

        //with commas
        checkAddDot("84,357", "84,357.");
        checkAddDot("8,762,423,634", "8,762,423,634.");
        checkAddDot("873,283,568", "873,283,568.");
        checkAddDot("8,235,854,645", "8,235,854,645.");
        checkAddDot("23,482,314", "23,482,314.");
        checkAddDot("234,643,737", "234,643,737.");

        checkAddDot("-72,341,234", "-72,341,234.");
        checkAddDot("-8,023,042,394", "-8,023,042,394.");
        checkAddDot("-626,356,345", "-626,356,345.");
        checkAddDot("-67,235,923,052", "-67,235,923,052.");
        checkAddDot("-7,625,252,352,352", "-7,625,252,352,352.");
        checkAddDot("-62,523,523,523,525", "-62,523,523,523,525.");

        //with dot at the end
        //without commas
        checkAddDot("0.", "0.");
        checkAddDot("1.", "1.");
        checkAddDot("8.", "8.");
        checkAddDot("9.", "9.");
        checkAddDot("10.", "10.");
        checkAddDot("100.", "100.");
        checkAddDot("500.", "500.");

        checkAddDot("-0.", "-0.");
        checkAddDot("-1.", "-1.");
        checkAddDot("-8.", "-8.");
        checkAddDot("-9.", "-9.");
        checkAddDot("-10.", "-10.");
        checkAddDot("-100.", "-100.");
        checkAddDot("-500.", "-500.");

        //with commas
        checkAddDot("8,235.", "8,235.");
        checkAddDot("9,342.", "9,342.");
        checkAddDot("142,326,735.", "142,326,735.");
        checkAddDot("9,346,843,456.", "9,346,843,456.");
        checkAddDot("924,536,576.", "924,536,576.");
        checkAddDot("945,358,636.", "945,358,636.");

        checkAddDot("54,363,463,463.", "54,363,463,463.");
        checkAddDot("8,846,356,367.", "8,846,356,367.");
        checkAddDot("834,634,634,636.", "834,634,634,636.");
        checkAddDot("8,456,363.", "8,456,363.");
        checkAddDot("436,373,563.", "436,373,563.");
        checkAddDot("3,643,563.", "3,643,563.");

        //with in the middle
        //without commas
        checkAddDot("0.6", "0.6");
        checkAddDot("1.235", "1.235");
        checkAddDot("8.8236", "8.8236");
        checkAddDot("9.8245", "9.8245");
        checkAddDot("10.7", "10.7");
        checkAddDot("100.3247", "100.3247");
        checkAddDot("500.7235", "500.7235");

        checkAddDot("-0.736", "-0.736");
        checkAddDot("-1.8356", "-1.8356");
        checkAddDot("-8.5437", "-8.5437");
        checkAddDot("-9.7235", "-9.7235");
        checkAddDot("-10.834", "-10.834");
        checkAddDot("-100.01", "-100.01");
        checkAddDot("-500.5", "-500.5");

        //with commas
        checkAddDot("124513.25835", "124513.25835");
        checkAddDot("62352.7235", "62352.7235");
        checkAddDot("6626.8256", "6626.8256");
        checkAddDot("2346.7925", "2346.7925");
        checkAddDot("762462.6782", "762462.6782");
        checkAddDot("7624623.2", "7624623.2");
        checkAddDot("76236262.72", "76236262.72");

        checkAddDot("-77322225.7", "-77322225.7");
        checkAddDot("-823452168746.734535", "-823452168746.734535");
        checkAddDot("-2523578.725", "-2523578.725");
        checkAddDot("-8643.825", "-8643.825");
        checkAddDot("-6235.725", "-6235.725");
        checkAddDot("-734535.73", "-734535.73");
        checkAddDot("-84564.622", "-84564.622");

        //engineer numbers
        checkAddDot("7.e+7234", "7.e+7234");
        checkAddDot("1.e+72", "1.e+72");
        checkAddDot("5.e+92", "5.e+92");
        checkAddDot("4.e-234", "4.e-234");
        checkAddDot("8.e-19", "8.e-19");
        checkAddDot("2.e-84", "2.e-84");

        checkAddDot("-4.e+13", "-4.e+13");
        checkAddDot("-2.e+126", "-2.e+126");
        checkAddDot("-7.e+1482", "-7.e+1482");
        checkAddDot("-6.e-723", "-6.e-723");
        checkAddDot("-5.e-17", "-5.e-17");
        checkAddDot("-2.e-79", "-2.e-79");
    }

    /**
     * Tests for delete last char operation.
     */
    @Test
    public void deleteLastCharTests() {
        //one-digit numbers
        checkDeleteLastChar("0", "0");
        checkDeleteLastChar("1", "0");
        checkDeleteLastChar("2", "0");
        checkDeleteLastChar("7", "0");
        checkDeleteLastChar("8", "0");
        checkDeleteLastChar("9", "0");

        checkDeleteLastChar("-0", "0");
        checkDeleteLastChar("-1", "0");
        checkDeleteLastChar("-2", "0");
        checkDeleteLastChar("-7", "0");
        checkDeleteLastChar("-8", "0");
        checkDeleteLastChar("-9", "0");

        //several digits without commas
        checkDeleteLastChar("10", "1");
        checkDeleteLastChar("21", "2");
        checkDeleteLastChar("35", "3");
        checkDeleteLastChar("488", "48");
        checkDeleteLastChar("516", "51");
        checkDeleteLastChar("741", "74");

        checkDeleteLastChar("-15", "-1");
        checkDeleteLastChar("-75", "-7");
        checkDeleteLastChar("-84", "-8");
        checkDeleteLastChar("-763", "-76");
        checkDeleteLastChar("-862", "-86");
        checkDeleteLastChar("-123", "-12");

        //with commas
        checkDeleteLastChar("1,234", "123");
        checkDeleteLastChar("6,225", "622");
        checkDeleteLastChar("84,623", "8,462");
        checkDeleteLastChar("64,362,234", "6,436,223");
        checkDeleteLastChar("752,384,257", "75,238,425");
        checkDeleteLastChar("32,572,357,832", "3,257,235,783");

        checkDeleteLastChar("-235,623", "-23,562");
        checkDeleteLastChar("-762,723", "-76,272");
        checkDeleteLastChar("-142,790", "-14,279");
        checkDeleteLastChar("-35,246,980", "-3,524,698");
        checkDeleteLastChar("-234,268,436", "-23,426,843");
        checkDeleteLastChar("-2,435,724,525", "-243,572,452");

        //with dot at the end and no commas
        checkDeleteLastChar("86.", "86");
        checkDeleteLastChar("12.", "12");
        checkDeleteLastChar("75.", "75");
        checkDeleteLastChar("632.", "632");
        checkDeleteLastChar("754.", "754");
        checkDeleteLastChar("851.", "851");

        checkDeleteLastChar("-12.", "-12");
        checkDeleteLastChar("-85.", "-85");
        checkDeleteLastChar("-75.", "-75");
        checkDeleteLastChar("-234.", "-234");
        checkDeleteLastChar("-752.", "-752");
        checkDeleteLastChar("-146.", "-146");

        //with dot at the end and commas
        checkDeleteLastChar("65,327.", "65,327");
        checkDeleteLastChar("1,461,234.", "1,461,234");
        checkDeleteLastChar("65,237,234.", "65,237,234");
        checkDeleteLastChar("2,598,753.", "2,598,753");
        checkDeleteLastChar("234,578,349.", "234,578,349");
        checkDeleteLastChar("23,478,235.", "23,478,235");

        checkDeleteLastChar("-862,458.", "-862,458");
        checkDeleteLastChar("-23,468,634.", "-23,468,634");
        checkDeleteLastChar("-25,869,876.", "-25,869,876");
        checkDeleteLastChar("-43,578,235.", "-43,578,235");
        checkDeleteLastChar("-86,346,835.", "-86,346,835");
        checkDeleteLastChar("-754,546,735.", "-754,546,735");

        //with dot in the middle and no commas
        checkDeleteLastChar("1.76", "1.7");
        checkDeleteLastChar("7.8", "7.");
        checkDeleteLastChar("85.0", "85.");
        checkDeleteLastChar("123.82", "123.8");
        checkDeleteLastChar("752.26782", "752.2678");
        checkDeleteLastChar("126.1", "126.");

        checkDeleteLastChar("-12.1765", "-12.176");
        checkDeleteLastChar("-2.23765", "-2.2376");
        checkDeleteLastChar("-236.76532", "-236.7653");
        checkDeleteLastChar("-822.12", "-822.1");
        checkDeleteLastChar("-752.752", "-752.75");
        checkDeleteLastChar("-80.213", "-80.21");

        //with dot in the middle and commas
        checkDeleteLastChar("1,477.234", "1,477.23");
        checkDeleteLastChar("23,572.23462", "23,572.2346");
        checkDeleteLastChar("762,852.0", "762,852.");
        checkDeleteLastChar("2,575,723,572.9", "2,575,723,572.");
        checkDeleteLastChar("876,532.2", "876,532.");
        checkDeleteLastChar("9,014.23", "9,014.2");

        checkDeleteLastChar("-234,823,547.234", "-234,823,547.23");
        checkDeleteLastChar("-23,472.23468", "-23,472.2346");
        checkDeleteLastChar("-87,358,245.24", "-87,358,245.2");
        checkDeleteLastChar("-2,472,357.23478", "-2,472,357.2347");
        checkDeleteLastChar("-32,723,467.23482", "-32,723,467.2348");
        checkDeleteLastChar("-23,475,345.7625", "-23,475,345.762");

        //engineer numbers
        checkDeleteLastChar("6.e+136", "6.e+136");
        checkDeleteLastChar("8.e+17", "8.e+17");
        checkDeleteLastChar("1.e+147", "1.e+147");
        checkDeleteLastChar("8.e-1487", "8.e-1487");
        checkDeleteLastChar("3.e-3254", "3.e-3254");
        checkDeleteLastChar("7.e-134", "7.e-134");

        checkDeleteLastChar("-1.e+1237", "-1.e+1237");
        checkDeleteLastChar("-1.e+185", "-1.e+185");
        checkDeleteLastChar("-3.e+1237", "-3.e+1237");
        checkDeleteLastChar("-8.e-123", "-8.e-123");
        checkDeleteLastChar("-3.e-85", "-3.e-85");
        checkDeleteLastChar("-5.e-29", "-5.e-29");
    }

    /**
     * @todo
     */
    @Test
    public void addDigitTests() {

    }

    /**
     * @todo
     */
    @Test
    public void bigDecimalToScreenTests() {

    }

    /**
     * @todo
     */
    @Test
    public void screenToBigDecimalTests() {

    }

    /**
     * @todo
     */
    @Test
    public void roundTests() {

    }

    /**
     * Checks that dot is added to number.
     * @param number number to edit.
     * @param expectedResult required result after performing operation.
     */
    private void checkAddDot(String number, String expectedResult) {
        String result = NumberFormatter.appendDot(number);
        assertEquals(expectedResult, result);
    }

    /**
     * Checks result of delete last char operation.
     * @param number number to edit.
     * @param expectedResult required result after performing operation.
     */
    private void checkDeleteLastChar(String number, String expectedResult) {
        String result = NumberFormatter.deleteLastChar(number);
        assertEquals(expectedResult, result);
    }

    private void checkAddDigit(String number, String digit, boolean isEditable, String expectedResult) {

    }

    private void checkBigDecimalToScreen(BigDecimal bigDecimal, String expectedResult) {

    }

    private void checkScreenToBigDecimal(String number, BigDecimal expectedNumber) {

    }

    private void checkRound(BigDecimal bigDecimal, BigDecimal expectedNumber) {

    }

}
