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

    @Test
    public void deleteLastCharTests() {
        //one-digit numbers
        checkDeleteLastChar("0", "0");
        checkDeleteLastChar("1", "0");
        checkDeleteLastChar("2", "0");
        checkDeleteLastChar("3", "0");
        checkDeleteLastChar("4", "0");
        checkDeleteLastChar("5", "0");
        checkDeleteLastChar("6", "0");
        checkDeleteLastChar("7", "0");
        checkDeleteLastChar("8", "0");
        checkDeleteLastChar("9", "0");

        checkDeleteLastChar("-0", "0");
        checkDeleteLastChar("-1", "0");
        checkDeleteLastChar("-2", "0");
        checkDeleteLastChar("-3", "0");
        checkDeleteLastChar("-4", "0");
        checkDeleteLastChar("-5", "0");
        checkDeleteLastChar("-6", "0");
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
        checkDeleteLastChar("0.e-134", "0.e-134");

        checkDeleteLastChar("-1.e+1237", "-1.e+1237");
        checkDeleteLastChar("-0.e+185", "-0.e+185");
        checkDeleteLastChar("-3.e+1237", "-3.e+1237");
        checkDeleteLastChar("-8.e-123", "-8.e-123");
        checkDeleteLastChar("-3.e-85", "-3.e-85");
        checkDeleteLastChar("-5.e-12", "-5.e-12");
    }

    /**
     * @todo
     */
    @Test
    public void addDotTests() {

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
     * Checks result of delete last char operation.
     * @param number number to edit.
     * @param expectedResult required result.
     */
    private void checkDeleteLastChar(String number, String expectedResult) {
        String result = NumberFormatter.deleteLastChar(number);
        assertEquals(expectedResult, result);
    }

    private void checkAddDot(String number, boolean isEditable, String expectedResult) {

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
