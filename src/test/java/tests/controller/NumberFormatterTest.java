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
     * Tests for append digit operation.
     */
    @Test
    public void appendDigitTests() {
        //can append
        {
            //empty string
            checkAppendDigit("", "0", "0");
            checkAppendDigit("", "1", "1");
            checkAppendDigit("", "5", "5");
            checkAppendDigit("", "8", "8");
            checkAppendDigit("", "9", "9");

            //append to zero
            checkAppendDigit("0", "0", "0");
            checkAppendDigit("0", "1", "1");
            checkAppendDigit("0", "5", "5");
            checkAppendDigit("0", "8", "8");
            checkAppendDigit("0", "9", "9");

            //append to one-digit positive integer number
            checkAppendDigit("1", "0", "10");
            checkAppendDigit("1", "1", "11");
            checkAppendDigit("1", "5", "15");
            checkAppendDigit("1", "8", "18");
            checkAppendDigit("1", "9", "19");


            checkAppendDigit("5", "0", "50");
            checkAppendDigit("5", "1", "51");
            checkAppendDigit("5", "5", "55");
            checkAppendDigit("5", "8", "58");
            checkAppendDigit("5", "9", "59");

            checkAppendDigit("9", "0", "90");
            checkAppendDigit("9", "1", "91");
            checkAppendDigit("9", "5", "95");
            checkAppendDigit("9", "8", "98");
            checkAppendDigit("9", "9", "99");

            //append to one-digit negative integer number
            checkAppendDigit("-1", "0", "-10");
            checkAppendDigit("-1", "1", "-11");
            checkAppendDigit("-1", "5", "-15");
            checkAppendDigit("-1", "8", "-18");
            checkAppendDigit("-1", "9", "-19");

            checkAppendDigit("-5", "0", "-50");
            checkAppendDigit("-5", "1", "-51");
            checkAppendDigit("-5", "5", "-55");
            checkAppendDigit("-5", "8", "-58");
            checkAppendDigit("-5", "9", "-59");

            checkAppendDigit("-9", "0", "-90");
            checkAppendDigit("-9", "1", "-91");
            checkAppendDigit("-9", "5", "-95");
            checkAppendDigit("-9", "8", "-98");
            checkAppendDigit("-9", "9", "-99");

            //append to one-digit positive decimal number
            checkAppendDigit("1.", "0", "1.0");
            checkAppendDigit("1.", "1", "1.1");
            checkAppendDigit("1.", "5", "1.5");
            checkAppendDigit("1.", "8", "1.8");
            checkAppendDigit("1.", "9", "1.9");

            checkAppendDigit("5.", "0", "5.0");
            checkAppendDigit("5.", "1", "5.1");
            checkAppendDigit("5.", "5", "5.5");
            checkAppendDigit("5.", "8", "5.8");
            checkAppendDigit("5.", "9", "5.9");

            checkAppendDigit("9.", "0", "9.0");
            checkAppendDigit("9.", "1", "9.1");
            checkAppendDigit("9.", "5", "9.5");
            checkAppendDigit("9.", "8", "9.8");
            checkAppendDigit("9.", "9", "9.9");

            //append to one-digit negative decimal number
            checkAppendDigit("-1", "0", "-10");
            checkAppendDigit("-1", "1", "-11");
            checkAppendDigit("-1", "5", "-15");
            checkAppendDigit("-1", "8", "-18");
            checkAppendDigit("-1", "9", "-19");

            checkAppendDigit("-5", "0", "-50");
            checkAppendDigit("-5", "1", "-51");
            checkAppendDigit("-5", "5", "-55");
            checkAppendDigit("-5", "8", "-58");
            checkAppendDigit("-5", "9", "-59");

            checkAppendDigit("-9", "0", "-90");
            checkAppendDigit("-9", "1", "-91");
            checkAppendDigit("-9", "5", "-95");
            checkAppendDigit("-9", "8", "-98");
            checkAppendDigit("-9", "9", "-99");

            //append to three-digits positive integer number
            checkAppendDigit("934", "0", "9,340");
            checkAppendDigit("825", "1", "8,251");
            checkAppendDigit("230", "2", "2,302");
            checkAppendDigit("827", "3", "8,273");
            checkAppendDigit("828", "4", "8,284");
            checkAppendDigit("821", "5", "8,215");
            checkAppendDigit("997", "6", "9,976");
            checkAppendDigit("282", "7", "2,827");
            checkAppendDigit("962", "8", "9,628");
            checkAppendDigit("973", "9", "9,739");

            //append to three-digits negative integer number
            checkAppendDigit("-641", "0", "-6,410");
            checkAppendDigit("-345", "1", "-3,451");
            checkAppendDigit("-970", "2", "-9,702");
            checkAppendDigit("-175", "3", "-1,753");
            checkAppendDigit("-962", "4", "-9,624");
            checkAppendDigit("-537", "5", "-5,375");
            checkAppendDigit("-970", "6", "-9,706");
            checkAppendDigit("-234", "7", "-2,347");
            checkAppendDigit("-468", "8", "-4,688");
            checkAppendDigit("-738", "9", "-7,389");

            //append to three-digits (before dot) positive decimal number
            checkAppendDigit("623.", "0", "623.0");
            checkAppendDigit("838.", "1", "838.1");
            checkAppendDigit("234.", "5", "234.5");
            checkAppendDigit("126.", "8", "126.8");
            checkAppendDigit("967.", "9", "967.9");

            checkAppendDigit("821.25", "0", "821.250");
            checkAppendDigit("997.813489", "1", "997.8134891");
            checkAppendDigit("282.342342", "5", "282.3423425");
            checkAppendDigit("962.9253", "8", "962.92538");
            checkAppendDigit("973.8234", "9", "973.82349");

            //append to three-digits (before dot) negative decimal number
            checkAppendDigit("-836.", "0", "-836.0");
            checkAppendDigit("-822.", "1", "-822.1");
            checkAppendDigit("-147.", "5", "-147.5");
            checkAppendDigit("-890.", "8", "-890.8");
            checkAppendDigit("-100.", "9", "-100.9");

            checkAppendDigit("-450.74790", "0", "-450.747900");
            checkAppendDigit("-670.9259304", "1", "-670.92593041");
            checkAppendDigit("-532.83", "5", "-532.835");
            checkAppendDigit("-842.82452", "8", "-842.824528");
            checkAppendDigit("-341.72368", "9", "-341.723689");

            //append to integer number with commas
            checkAppendDigit("723,567", "0", "7,235,670");
            checkAppendDigit("82,458", "1", "824,581");
            checkAppendDigit("23,634", "5", "236,345");
            checkAppendDigit("2,578", "8", "25,788");
            checkAppendDigit("2,155,478,547", "9", "21,554,785,479");

            checkAppendDigit("-457,345", "0", "-4,573,450");
            checkAppendDigit("-73,456", "1", "-734,561");
            checkAppendDigit("-3,457", "5", "-34,575");
            checkAppendDigit("-25679", "8", "-256,798");
            checkAppendDigit("-63,467,435", "9", "-634,674,359");

            //append to decimal number with commas
            checkAppendDigit("21,344.", "0", "21,344.0");
            checkAppendDigit("7,346,346.8", "1", "7,346,346.81");
            checkAppendDigit("83,463.375", "5", "83,463.3755");
            checkAppendDigit("32,467,778.34678", "8", "32,467,778.346788");
            checkAppendDigit("23,447.84365346", "9", "23,447.843653469");

            checkAppendDigit("-32,567.", "0", "-32,567.0");
            checkAppendDigit("-23,654.7", "1", "-23,654.71");
            checkAppendDigit("-8,762,435.425", "5", "-8,762,435.4255");
            checkAppendDigit("-34,637,457.7346", "8", "-34,637,457.73468");
            checkAppendDigit("-3,453,635.8346346", "9", "-3,453,635.83463469");

            //append to 15-digits integer number
            checkAppendDigit("678,096,234,678,975", "0", "6,780,962,346,789,750");
            checkAppendDigit("780,875,456,897,543", "1", "7,808,754,568,975,431");
            checkAppendDigit("987,456,875,345,789", "5", "9,874,568,753,457,895");
            checkAppendDigit("987,564,567,986,246", "8", "9,875,645,679,862,468");
            checkAppendDigit("189,090,098,567,245", "9", "1,890,900,985,672,459");

            checkAppendDigit("-987,456,752,346,783", "0", "-9,874,567,523,467,830");
            checkAppendDigit("-987,567,356,782,345", "1", "-9,875,673,567,823,451");
            checkAppendDigit("-987,457,621,103,536", "5", "-9,874,576,211,035,365");
            checkAppendDigit("-123,567,256,721,457", "8", "-1,235,672,567,214,578");
            checkAppendDigit("-423,767,464,768,144", "9", "-4,237,674,647,681,449");

            //append to 15-digits (summary) decimal number
            checkAppendDigit("678,987,175,238.357", "0", "678,987,175,238.3570");
            checkAppendDigit("89,798.6297342734", "1", "89,798.62973427341");
            checkAppendDigit("98,273,492,302.5727", "5", "98,273,492,302.57275");
            checkAppendDigit("863.240000000023", "8", "863.2400000000238");
            checkAppendDigit("624,592,234,242.500", "9", "624,592,234,242.5009");

            checkAppendDigit("-7,862,359,237.50226", "0", "-7,862,359,237.502260");
            checkAppendDigit("-842.789273942046", "1", "-842.7892739420461");
            checkAppendDigit("-898,402,348,028.492", "5", "-898,402,348,028.4925");
            checkAppendDigit("-725,836.826346363", "8", "-725,836.8263463638");
            checkAppendDigit("-90,000,000.0000000", "9", "-90,000,000.00000009");

            //append to decimal number with 16 digits summary (while integer part is 0)
            checkAppendDigit("0.678986456781345", "0", "0.6789864567813450");
            checkAppendDigit("0.825252834573467", "1", "0.8252528345734671");
            checkAppendDigit("0.000000000000000", "5", "0.0000000000000005");
            checkAppendDigit("0.845634528235992", "8", "0.8456345282359928");
            checkAppendDigit("0.029840234005268", "9", "0.0298402340052689");

            checkAppendDigit("-0.09234927358283", "0", "-0.092349273582830");
            checkAppendDigit("-0.23492759238567", "1", "-0.234927592385671");
            checkAppendDigit("-0.03295027359285", "5", "-0.032950273592855");
            checkAppendDigit("-0.02934982635782", "8", "-0.029349826357828");
            checkAppendDigit("-0.76235826754836", "9", "-0.762358267548369");
        }

        //can not append
        {
            //append to 16-digits integer number
            checkAppendDigit("9,847,862,357,839,869", "0", "9,847,862,357,839,869");
            checkAppendDigit("7,374,149,817,289,492", "1", "7,374,149,817,289,492");
            checkAppendDigit("7,349,564,303,904,532", "5", "7,349,564,303,904,532");
            checkAppendDigit("9,872,358,289,579,258", "8", "9,872,358,289,579,258");
            checkAppendDigit("6,729,423,840,284,622", "9", "6,729,423,840,284,622");

            checkAppendDigit("-9,239,582,957,295,726", "0", "-9,239,582,957,295,726");
            checkAppendDigit("-7,290,000,008,234,928", "1", "-7,290,000,008,234,928");
            checkAppendDigit("-6,666,666,666,666,666", "5", "-6,666,666,666,666,666");
            checkAppendDigit("-2,592,838,592,590,224", "8", "-2,592,838,592,590,224");
            checkAppendDigit("-7,535,253,536,367,367", "9", "-7,535,253,536,367,367");

            //append to 16-digits (summary) decimal number
            checkAppendDigit("6,269,657,463,635,353.", "0", "6,269,657,463,635,353.");
            checkAppendDigit("7.334536437634563", "1", "7.334536437634563");
            checkAppendDigit("74,564.64654646464", "5", "74,564.64654646464");
            checkAppendDigit("966,434,529,745,647.4", "8", "966,434,529,745,647.4");
            checkAppendDigit("84.74745745745749", "9", "84.74745745745749");

            checkAppendDigit("-6,346,346,394,365,337.", "0", "-6,346,346,394,365,337.");
            checkAppendDigit("-845,787,846,363,733.7", "1", "-845,787,846,363,733.7");
            checkAppendDigit("-734.6367934653793", "5", "-734.6367934653793");
            checkAppendDigit("-95,675.67568758474", "8", "-95,675.67568758474");
            checkAppendDigit("-734,639,356,475.4563", "9", "-734,639,356,475.4563");

            //append to decimal number with 17 digits summary (while integer part is 0)
            checkAppendDigit("0.7564734634634638", "0", "0.7564734634634638");
            checkAppendDigit("0.2359346457735875", "1", "0.2359346457735875");
            checkAppendDigit("0.8847352526843832", "5", "0.8847352526843832");
            checkAppendDigit("0.8457934693468346", "8", "0.8457934693468346");
            checkAppendDigit("0.8734636834583467", "9", "0.8734636834583467");

            checkAppendDigit("-0.8346362645875478", "0", "-0.8346362645875478");
            checkAppendDigit("-0.8734634634683468", "1", "-0.8734634634683468");
            checkAppendDigit("-0.2353645754673458", "5", "-0.2353645754673458");
            checkAppendDigit("-0.3468435473637297", "8", "-0.3468435473637297");
            checkAppendDigit("-0.4578657686567588", "9", "-0.4578657686567588");
        }
    }

    /**
     * Tests for add dot operation.
     */
    @Test
    public void appendDotTests() {
        //without dot
        //without commas
        checkAppendDot("0", "0.");
        checkAppendDot("1", "1.");
        checkAppendDot("8", "8.");
        checkAppendDot("9", "9.");
        checkAppendDot("10", "10.");
        checkAppendDot("100", "100.");
        checkAppendDot("500", "500.");

        checkAppendDot("-0", "-0.");
        checkAppendDot("-1", "-1.");
        checkAppendDot("-8", "-8.");
        checkAppendDot("-9", "-9.");
        checkAppendDot("-10", "-10.");
        checkAppendDot("-100", "-100.");
        checkAppendDot("-500", "-500.");

        //with commas
        checkAppendDot("84,357", "84,357.");
        checkAppendDot("8,762,423,634", "8,762,423,634.");
        checkAppendDot("873,283,568", "873,283,568.");
        checkAppendDot("8,235,854,645", "8,235,854,645.");
        checkAppendDot("23,482,314", "23,482,314.");
        checkAppendDot("234,643,737", "234,643,737.");

        checkAppendDot("-72,341,234", "-72,341,234.");
        checkAppendDot("-8,023,042,394", "-8,023,042,394.");
        checkAppendDot("-626,356,345", "-626,356,345.");
        checkAppendDot("-67,235,923,052", "-67,235,923,052.");
        checkAppendDot("-7,625,252,352,352", "-7,625,252,352,352.");
        checkAppendDot("-62,523,523,523,525", "-62,523,523,523,525.");

        //with dot at the end
        //without commas
        checkAppendDot("0.", "0.");
        checkAppendDot("1.", "1.");
        checkAppendDot("8.", "8.");
        checkAppendDot("9.", "9.");
        checkAppendDot("10.", "10.");
        checkAppendDot("100.", "100.");
        checkAppendDot("500.", "500.");

        checkAppendDot("-0.", "-0.");
        checkAppendDot("-1.", "-1.");
        checkAppendDot("-8.", "-8.");
        checkAppendDot("-9.", "-9.");
        checkAppendDot("-10.", "-10.");
        checkAppendDot("-100.", "-100.");
        checkAppendDot("-500.", "-500.");

        //with commas
        checkAppendDot("8,235.", "8,235.");
        checkAppendDot("9,342.", "9,342.");
        checkAppendDot("142,326,735.", "142,326,735.");
        checkAppendDot("9,346,843,456.", "9,346,843,456.");
        checkAppendDot("924,536,576.", "924,536,576.");
        checkAppendDot("945,358,636.", "945,358,636.");

        checkAppendDot("54,363,463,463.", "54,363,463,463.");
        checkAppendDot("8,846,356,367.", "8,846,356,367.");
        checkAppendDot("834,634,634,636.", "834,634,634,636.");
        checkAppendDot("8,456,363.", "8,456,363.");
        checkAppendDot("436,373,563.", "436,373,563.");
        checkAppendDot("3,643,563.", "3,643,563.");

        //with dot in the middle
        //without commas
        checkAppendDot("0.6", "0.6");
        checkAppendDot("1.235", "1.235");
        checkAppendDot("8.8236", "8.8236");
        checkAppendDot("9.8245", "9.8245");
        checkAppendDot("10.7", "10.7");
        checkAppendDot("100.3247", "100.3247");
        checkAppendDot("500.7235", "500.7235");

        checkAppendDot("-0.736", "-0.736");
        checkAppendDot("-1.8356", "-1.8356");
        checkAppendDot("-8.5437", "-8.5437");
        checkAppendDot("-9.7235", "-9.7235");
        checkAppendDot("-10.834", "-10.834");
        checkAppendDot("-100.01", "-100.01");
        checkAppendDot("-500.5", "-500.5");

        //with commas
        checkAppendDot("124,513.25835", "124,513.25835");
        checkAppendDot("62,352.7235", "62,352.7235");
        checkAppendDot("6,626.8256", "6,626.8256");
        checkAppendDot("2,346.7925", "2,346.7925");
        checkAppendDot("762,462.6782", "762,462.6782");
        checkAppendDot("7,624,623.2", "7,624,623.2");
        checkAppendDot("762,362,62.72", "762,362,62.72");

        checkAppendDot("-77,322,225.7", "-77,322,225.7");
        checkAppendDot("-823,452,168,746.734535", "-823,452,168,746.734535");
        checkAppendDot("-2,523,578.725", "-2,523,578.725");
        checkAppendDot("-8,643.825", "-8,643.825");
        checkAppendDot("-6,235.725", "-6,235.725");
        checkAppendDot("-734,535.73", "-734,535.73");
        checkAppendDot("-84,564.622", "-84,564.622");

        //engineer numbers
        checkAppendDot("7.e+7234", "7.e+7234");
        checkAppendDot("1.e+72", "1.e+72");
        checkAppendDot("5.e+92", "5.e+92");
        checkAppendDot("4.e-234", "4.e-234");
        checkAppendDot("8.e-19", "8.e-19");
        checkAppendDot("2.e-84", "2.e-84");

        checkAppendDot("-4.e+13", "-4.e+13");
        checkAppendDot("-2.e+126", "-2.e+126");
        checkAppendDot("-7.e+1482", "-7.e+1482");
        checkAppendDot("-6.e-723", "-6.e-723");
        checkAppendDot("-5.e-17", "-5.e-17");
        checkAppendDot("-2.e-79", "-2.e-79");

        checkAppendDot("6.21e+24", "6.21e+24");
        checkAppendDot("3.762e+789", "3.762e+789");
        checkAppendDot("1.627e+25", "1.627e+25");
        checkAppendDot("7.831e-19", "7.831e-19");
        checkAppendDot("9.1346e-3216", "9.1346e-3216");
        checkAppendDot("1.143e-1446", "1.143e-1446");

        checkAppendDot("-8.09e+74", "-8.09e+74");
        checkAppendDot("-6.863e+835", "-6.863e+835");
        checkAppendDot("-4.325e+7267", "-4.325e+7267");
        checkAppendDot("-2.13e-874", "-2.13e-874");
        checkAppendDot("-2.126e-1353", "-2.126e-1353");
        checkAppendDot("-1.73e-735", "-1.73e-735");
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

        checkDeleteLastChar("6.21e+24", "6.21e+24");
        checkDeleteLastChar("3.762e+789", "3.762e+789");
        checkDeleteLastChar("1.627e+25", "1.627e+25");
        checkDeleteLastChar("7.831e-19", "7.831e-19");
        checkDeleteLastChar("9.1346e-3216", "9.1346e-3216");
        checkDeleteLastChar("1.143e-1446", "1.143e-1446");

        checkDeleteLastChar("-8.09e+74", "-8.09e+74");
        checkDeleteLastChar("-6.863e+835", "-6.863e+835");
        checkDeleteLastChar("-4.325e+7267", "-4.325e+7267");
        checkDeleteLastChar("-2.13e-874", "-2.13e-874");
        checkDeleteLastChar("-2.126e-1353", "-2.126e-1353");
        checkDeleteLastChar("-1.73e-735", "-1.73e-735");
    }

    /**
     * Tests for screen to big decimal and big decimal to screen operations.
     */
    @Test
    public void screenToBigDecimalTestsAndViceVersa() {
        //integers
        //without commas
        checkScreenToBigDecimalAndViceVersa("0", new BigDecimal("0"));

        checkScreenToBigDecimalAndViceVersa("1", new BigDecimal("1"));
        checkScreenToBigDecimalAndViceVersa("8", new BigDecimal("8"));
        checkScreenToBigDecimalAndViceVersa("9", new BigDecimal("9"));
        checkScreenToBigDecimalAndViceVersa("10", new BigDecimal("10"));
        checkScreenToBigDecimalAndViceVersa("100", new BigDecimal("100"));
        checkScreenToBigDecimalAndViceVersa("500", new BigDecimal("500"));

        checkScreenToBigDecimalAndViceVersa("-1", new BigDecimal("-1"));
        checkScreenToBigDecimalAndViceVersa("-8", new BigDecimal("-8"));
        checkScreenToBigDecimalAndViceVersa("-9", new BigDecimal("-9"));
        checkScreenToBigDecimalAndViceVersa("-10", new BigDecimal("-10"));
        checkScreenToBigDecimalAndViceVersa("-100", new BigDecimal("-100"));
        checkScreenToBigDecimalAndViceVersa("-500", new BigDecimal("-500"));

        //with commas
        checkScreenToBigDecimalAndViceVersa("84,357", new BigDecimal("84357"));
        checkScreenToBigDecimalAndViceVersa("8,762,423,634", new BigDecimal("8762423634"));
        checkScreenToBigDecimalAndViceVersa("873,283,568", new BigDecimal("873283568"));
        checkScreenToBigDecimalAndViceVersa("8,235,854,645", new BigDecimal("8235854645"));
        checkScreenToBigDecimalAndViceVersa("23,482,314", new BigDecimal("23482314"));
        checkScreenToBigDecimalAndViceVersa("234,643,737", new BigDecimal("234643737"));

        checkScreenToBigDecimalAndViceVersa("-72,341,234", new BigDecimal("-72341234"));
        checkScreenToBigDecimalAndViceVersa("-8,023,042,394", new BigDecimal("-8023042394"));
        checkScreenToBigDecimalAndViceVersa("-626,356,345", new BigDecimal("-626356345"));
        checkScreenToBigDecimalAndViceVersa("-67,235,923,052", new BigDecimal("-67235923052"));
        checkScreenToBigDecimalAndViceVersa("-7,625,252,352,352", new BigDecimal("-7625252352352"));
        checkScreenToBigDecimalAndViceVersa("-62,523,523,523,525", new BigDecimal("-62523523523525"));

        //decimals
        //without commas
        checkScreenToBigDecimalAndViceVersa("0.6", new BigDecimal("0.6"));
        checkScreenToBigDecimalAndViceVersa("1.235", new BigDecimal("1.235"));
        checkScreenToBigDecimalAndViceVersa("8.8236", new BigDecimal("8.8236"));
        checkScreenToBigDecimalAndViceVersa("9.8245", new BigDecimal("9.8245"));
        checkScreenToBigDecimalAndViceVersa("10.7", new BigDecimal("10.7"));
        checkScreenToBigDecimalAndViceVersa("100.3247", new BigDecimal("100.3247"));
        checkScreenToBigDecimalAndViceVersa("500.7235", new BigDecimal("500.7235"));

        checkScreenToBigDecimalAndViceVersa("-0.736", new BigDecimal("-0.736"));
        checkScreenToBigDecimalAndViceVersa("-1.8356", new BigDecimal("-1.8356"));
        checkScreenToBigDecimalAndViceVersa("-8.5437", new BigDecimal("-8.5437"));
        checkScreenToBigDecimalAndViceVersa("-9.7235", new BigDecimal("-9.7235"));
        checkScreenToBigDecimalAndViceVersa("-10.834", new BigDecimal("-10.834"));
        checkScreenToBigDecimalAndViceVersa("-100.01", new BigDecimal("-100.01"));
        checkScreenToBigDecimalAndViceVersa("-500.5", new BigDecimal("-500.5"));

        //with commas
        checkScreenToBigDecimalAndViceVersa("124,513.25835", new BigDecimal("124513.25835"));
        checkScreenToBigDecimalAndViceVersa("62,352.7235", new BigDecimal("62352.7235"));
        checkScreenToBigDecimalAndViceVersa("6,626.8256", new BigDecimal("6626.8256"));
        checkScreenToBigDecimalAndViceVersa("2,346.7925", new BigDecimal("2346.7925"));
        checkScreenToBigDecimalAndViceVersa("762,462.6782", new BigDecimal("762462.6782"));
        checkScreenToBigDecimalAndViceVersa("7,624,623.2", new BigDecimal("7624623.2"));
        checkScreenToBigDecimalAndViceVersa("76,236,262.72", new BigDecimal("76236262.72"));

        checkScreenToBigDecimalAndViceVersa("-77,322,225.7", new BigDecimal("-77322225.7"));
        checkScreenToBigDecimalAndViceVersa("-823,452,168,746.734535", new BigDecimal("-823452168746.734535"));
        checkScreenToBigDecimalAndViceVersa("-2,523,578.725", new BigDecimal("-2523578.725"));
        checkScreenToBigDecimalAndViceVersa("-8,643.825", new BigDecimal("-8643.825"));
        checkScreenToBigDecimalAndViceVersa("-6,235.725", new BigDecimal("-6235.725"));
        checkScreenToBigDecimalAndViceVersa("-734,535.73", new BigDecimal("-734535.73"));
        checkScreenToBigDecimalAndViceVersa("-84,564.622", new BigDecimal("-84564.622"));

        //engineer numbers
        checkScreenToBigDecimalAndViceVersa("7.e+7234", new BigDecimal("7.e+7234"));
        checkScreenToBigDecimalAndViceVersa("1.e+72", new BigDecimal("1.e+72"));
        checkScreenToBigDecimalAndViceVersa("5.e+92", new BigDecimal("5.e+92"));
        checkScreenToBigDecimalAndViceVersa("4.e-234", new BigDecimal("4.e-234"));
        checkScreenToBigDecimalAndViceVersa("8.e-19", new BigDecimal("8.e-19"));
        checkScreenToBigDecimalAndViceVersa("2.e-84", new BigDecimal("2.e-84"));

        checkScreenToBigDecimalAndViceVersa("-4.e+13", new BigDecimal("-4.e+13"));
        checkScreenToBigDecimalAndViceVersa("-2.e+126", new BigDecimal("-2.e+126"));
        checkScreenToBigDecimalAndViceVersa("-7.e+1482", new BigDecimal("-7.e+1482"));
        checkScreenToBigDecimalAndViceVersa("-6.e-723", new BigDecimal("-6.e-723"));
        checkScreenToBigDecimalAndViceVersa("-5.e-17", new BigDecimal("-5.e-17"));
        checkScreenToBigDecimalAndViceVersa("-2.e-79", new BigDecimal("-2.e-79"));

        checkScreenToBigDecimalAndViceVersa("6.21e+24", new BigDecimal("6.21e+24"));
        checkScreenToBigDecimalAndViceVersa("3.762e+789", new BigDecimal("3.762e+789"));
        checkScreenToBigDecimalAndViceVersa("1.627e+25", new BigDecimal("1.627e+25"));
        checkScreenToBigDecimalAndViceVersa("7.831e-19", new BigDecimal("7.831e-19"));
        checkScreenToBigDecimalAndViceVersa("9.1346e-3216", new BigDecimal("9.1346e-3216"));
        checkScreenToBigDecimalAndViceVersa("1.143e-1446", new BigDecimal("1.143e-1446"));

        checkScreenToBigDecimalAndViceVersa("-8.09e+74", new BigDecimal("-8.09e+74"));
        checkScreenToBigDecimalAndViceVersa("-6.863e+835", new BigDecimal("-6.863e+835"));
        checkScreenToBigDecimalAndViceVersa("-4.325e+7267", new BigDecimal("-4.325e+7267"));
        checkScreenToBigDecimalAndViceVersa("-2.13e-874", new BigDecimal("-2.13e-874"));
        checkScreenToBigDecimalAndViceVersa("-2.126e-1353", new BigDecimal("-2.126e-1353"));
        checkScreenToBigDecimalAndViceVersa("-1.73e-735", new BigDecimal("-1.73e-735"));
    }

    /**
     * Tests for round operation.
     */
    @Test
    public void roundTests() {
        //integers
        {
            //less that 16 digits
            checkRound(new BigDecimal("0"), new BigDecimal("0"));

            checkRound(new BigDecimal("1"), new BigDecimal("1"));
            checkRound(new BigDecimal("2"), new BigDecimal("2"));
            checkRound(new BigDecimal("15"), new BigDecimal("15"));
            checkRound(new BigDecimal("25"), new BigDecimal("25"));
            checkRound(new BigDecimal("100"), new BigDecimal("100"));
            checkRound(new BigDecimal("5000"), new BigDecimal("5000"));
            checkRound(new BigDecimal("62368"), new BigDecimal("62368"));
            checkRound(new BigDecimal("73737375"), new BigDecimal("73737375"));
            checkRound(new BigDecimal("42989024782"), new BigDecimal("42989024782"));
            checkRound(new BigDecimal("3252652632693"), new BigDecimal("3252652632693"));
            checkRound(new BigDecimal("736346834"), new BigDecimal("736346834"));
            checkRound(new BigDecimal("1267983456891567"), new BigDecimal("1267983456891567"));

            checkRound(new BigDecimal("-1"), new BigDecimal("-1"));
            checkRound(new BigDecimal("-2"), new BigDecimal("-2"));
            checkRound(new BigDecimal("-15"), new BigDecimal("-15"));
            checkRound(new BigDecimal("-25"), new BigDecimal("-25"));
            checkRound(new BigDecimal("-100"), new BigDecimal("-100"));
            checkRound(new BigDecimal("-5000"), new BigDecimal("-5000"));
            checkRound(new BigDecimal("-137687"), new BigDecimal("-137687"));
            checkRound(new BigDecimal("-1236879000"), new BigDecimal("-1236879000"));
            checkRound(new BigDecimal("-8910"), new BigDecimal("-8910"));
            checkRound(new BigDecimal("-72523"), new BigDecimal("-72523"));
            checkRound(new BigDecimal("-52134234"), new BigDecimal("-52134234"));
            checkRound(new BigDecimal("-7345298761213"), new BigDecimal("-7345298761213"));

            //16 digits
            checkRound(new BigDecimal("7891236742367892"), new BigDecimal("7891236742367892"));
            checkRound(new BigDecimal("8914815712245616"), new BigDecimal("8914815712245616"));
            checkRound(new BigDecimal("5731897581912065"), new BigDecimal("5731897581912065"));
            checkRound(new BigDecimal("1385219952592750"), new BigDecimal("1385219952592750"));
            checkRound(new BigDecimal("2345678614899523"), new BigDecimal("2345678614899523"));
            checkRound(new BigDecimal("1472184129453219"), new BigDecimal("1472184129453219"));

            checkRound(new BigDecimal("-1237894562345678"), new BigDecimal("-1237894562345678"));
            checkRound(new BigDecimal("-7123912369284216"), new BigDecimal("-7123912369284216"));
            checkRound(new BigDecimal("-1237891401000000"), new BigDecimal("-1237891401000000"));
            checkRound(new BigDecimal("-1324587652332142"), new BigDecimal("-1324587652332142"));
            checkRound(new BigDecimal("-1823194986032146"), new BigDecimal("-1823194986032146"));
            checkRound(new BigDecimal("-1328959285727529"), new BigDecimal("-1328959285727529"));

            //more than 16 digits
            checkRound(new BigDecimal("354678126471241518756213"), new BigDecimal("3.546781264712415e+23"));
            checkRound(new BigDecimal("86583242839429024222221664265286"), new BigDecimal("8.658324283942902e+31"));
            checkRound(new BigDecimal("123121238535432345324235"), new BigDecimal("1.231212385354323e+23"));
            checkRound(new BigDecimal("13657532425234753632"), new BigDecimal("1.365753242523475e+19"));
            checkRound(new BigDecimal("23456786148995237"), new BigDecimal("2.345678614899524e+16"));
            checkRound(new BigDecimal("982147981274912749812748912749"), new BigDecimal("9.821479812749127e+29"));

            checkRound(new BigDecimal("-141298172396321459238752"), new BigDecimal("-1.412981723963215e+23"));
            checkRound(new BigDecimal("-6315214812841571983251953218198156"), new BigDecimal("-6.315214812841572e+33"));
            checkRound(new BigDecimal("-63562342573463436343535"), new BigDecimal("-6.356234257346344e+22"));
            checkRound(new BigDecimal("-1231238456344543890000000000"), new BigDecimal("-1.231238456344544e+27"));
            checkRound(new BigDecimal("-123123873543259234234873"), new BigDecimal("-1.231238735432592e+23"));
            checkRound(new BigDecimal("-3123137862452352347899"), new BigDecimal("-3.123137862452352e+21"));
        }

        //decimals
        {
            //less that 16 digits (summary)
            checkRound(new BigDecimal("13.16325"), new BigDecimal("13.16325"));
            checkRound(new BigDecimal("0.724658"), new BigDecimal("0.724658"));
            checkRound(new BigDecimal("12383254.8234324"), new BigDecimal("12383254.8234324"));
            checkRound(new BigDecimal("12312476.2434"), new BigDecimal("12312476.2434"));
            checkRound(new BigDecimal("1316.123"), new BigDecimal("1316.123"));
            checkRound(new BigDecimal("625.72"), new BigDecimal("625.72"));

            checkRound(new BigDecimal("-14312.73"), new BigDecimal("-14312.73"));
            checkRound(new BigDecimal("-552.43521"), new BigDecimal("-552.43521"));
            checkRound(new BigDecimal("-23425252.25"), new BigDecimal("-23425252.25"));
            checkRound(new BigDecimal("-12.1"), new BigDecimal("-12.1"));
            checkRound(new BigDecimal("-21437.73"), new BigDecimal("-21437.73"));
            checkRound(new BigDecimal("-0.721111"), new BigDecimal("-0.721111"));

            //16 digits (summary) and starts with 0.
            checkRound(new BigDecimal("0.765986234567097"), new BigDecimal("0.765986234567097"));
            checkRound(new BigDecimal("0.172841949812748"), new BigDecimal("0.172841949812748"));
            checkRound(new BigDecimal("0.198379513179088"), new BigDecimal("0.198379513179088"));
            checkRound(new BigDecimal("0.132918479185915"), new BigDecimal("0.132918479185915"));
            checkRound(new BigDecimal("0.987187591481567"), new BigDecimal("0.987187591481567"));
            checkRound(new BigDecimal("0.123689238599145"), new BigDecimal("0.123689238599145"));

            checkRound(new BigDecimal("-0.126789043256784"), new BigDecimal("-0.126789043256784"));
            checkRound(new BigDecimal("-0.213123099852516"), new BigDecimal("-0.213123099852516"));
            checkRound(new BigDecimal("-0.918237192749815"), new BigDecimal("-0.918237192749815"));
            checkRound(new BigDecimal("-0.328957983257892"), new BigDecimal("-0.328957983257892"));
            checkRound(new BigDecimal("-0.123091875127591"), new BigDecimal("-0.123091875127591"));
            checkRound(new BigDecimal("-0.123886598000012"), new BigDecimal("-0.123886598000012"));

            //16 digits (summary) and does not start with 0.
            checkRound(new BigDecimal("765678.6786785423"), new BigDecimal("765678.6786785423"));
            checkRound(new BigDecimal("988624352525.7111"), new BigDecimal("988624352525.7111"));
            checkRound(new BigDecimal("3192831937198.355"), new BigDecimal("3192831937198.355"));
            checkRound(new BigDecimal("174.9164914921961"), new BigDecimal("174.9164914921961"));
            checkRound(new BigDecimal("68789921739.82145"), new BigDecimal("68789921739.82145"));
            checkRound(new BigDecimal("8.721681581259151"), new BigDecimal("8.721681581259151"));

            checkRound(new BigDecimal("-98.12748917915915"), new BigDecimal("-98.12748917915915"));
            checkRound(new BigDecimal("-1235823.592917895"), new BigDecimal("-1235823.592917895"));
            checkRound(new BigDecimal("-31293874177.81938"), new BigDecimal("-31293874177.81938"));
            checkRound(new BigDecimal("-1287.382142174858"), new BigDecimal("-1287.382142174858"));
            checkRound(new BigDecimal("-103198237917576.1"), new BigDecimal("-103198237917576.1"));
            checkRound(new BigDecimal("-12936661991.79419"), new BigDecimal("-12936661991.79419"));

            //17 digits (summary) and starts with 0.
            checkRound(new BigDecimal("0.7634568901234567"), new BigDecimal("0.7634568901234567"));
            checkRound(new BigDecimal("0.8269023457876125"), new BigDecimal("0.8269023457876125"));
            checkRound(new BigDecimal("0.1234567891234567"), new BigDecimal("0.1234567891234567"));
            checkRound(new BigDecimal("0.4197492149146879"), new BigDecimal("0.4197492149146879"));
            checkRound(new BigDecimal("0.9001013124014956"), new BigDecimal("0.9001013124014956"));
            checkRound(new BigDecimal("0.1465698791749184"), new BigDecimal("0.1465698791749184"));

            checkRound(new BigDecimal("-0.123123213698235"), new BigDecimal("-0.123123213698235"));
            checkRound(new BigDecimal("-0.102398019815789"), new BigDecimal("-0.102398019815789"));
            checkRound(new BigDecimal("-0.876523452349824"), new BigDecimal("-0.876523452349824"));
            checkRound(new BigDecimal("-0.123629867292267"), new BigDecimal("-0.123629867292267"));
            checkRound(new BigDecimal("-0.123147194519916"), new BigDecimal("-0.123147194519916"));
            checkRound(new BigDecimal("-0.123985025329267"), new BigDecimal("-0.123985025329267"));

            //17 digits (summary) and does not start with 0.
            checkRound(new BigDecimal("1237894445.6723489"), new BigDecimal("1237894445.672349"));
            checkRound(new BigDecimal("73463.632980090322"), new BigDecimal("73463.63298009032"));
            checkRound(new BigDecimal("926598259202.22578"), new BigDecimal("926598259202.2258"));
            checkRound(new BigDecimal("219.88371948157672"), new BigDecimal("219.8837194815767"));
            checkRound(new BigDecimal("193195717917.59185"), new BigDecimal("193195717917.5919"));
            checkRound(new BigDecimal("991.20391000151356"), new BigDecimal("991.2039100015136"));

            checkRound(new BigDecimal("-1238091250715979.8"), new BigDecimal("-1238091250715980"));
            checkRound(new BigDecimal("-723.52358725265225"), new BigDecimal("-723.5235872526523"));
            checkRound(new BigDecimal("-3447.7789023345812"), new BigDecimal("-3447.778902334581"));
            checkRound(new BigDecimal("-1985815792362.6785"), new BigDecimal("-1985815792362.679"));
            checkRound(new BigDecimal("-139878.98175981956"), new BigDecimal("-139878.9817598196"));
            checkRound(new BigDecimal("-123995921352.35267"), new BigDecimal("-123995921352.3527"));

            //more than 17 digits (summary) and starts with 0.
            checkRound(new BigDecimal("0.9418724917491750150179815191"), new BigDecimal("0.941872491749175"));
            checkRound(new BigDecimal("0.5418715871759237626982786206123"), new BigDecimal("0.5418715871759238"));
            checkRound(new BigDecimal("0.982137987150875380173258619"), new BigDecimal("0.9821379871508754"));
            checkRound(new BigDecimal("0.1259817598315098175983215916"), new BigDecimal("0.1259817598315098"));
            checkRound(new BigDecimal("0.1242128798215709184178957195713"), new BigDecimal("0.1242128798215709"));
            checkRound(new BigDecimal("0.12351791951090870987519832759266"), new BigDecimal("0.1235179195109087"));

            checkRound(new BigDecimal("-0.198471895719857193751084791"), new BigDecimal("-0.1984718957198572"));
            checkRound(new BigDecimal("-0.12310958190357878062046206"), new BigDecimal("-0.1231095819035788"));
            checkRound(new BigDecimal("-0.13109870600000000003252525"), new BigDecimal("-0.131098706"));
            checkRound(new BigDecimal("-0.124560283765098276022256"), new BigDecimal("-0.1245602837650983"));
            checkRound(new BigDecimal("-0.1415400000000000000000000000918"), new BigDecimal("-0.14154"));
            checkRound(new BigDecimal("-0.12465982153209520592805"), new BigDecimal("-0.1246598215320952"));

            //more than 17 digits (summary) and does not start with 0.
            checkRound(new BigDecimal("128419581095019580128.75019875"), new BigDecimal("1.284195810950196e+20"));
            checkRound(new BigDecimal("128758.917509715091750128750175"), new BigDecimal("128758.9175097151"));
            checkRound(new BigDecimal("876210983758927.650828750275820"), new BigDecimal("876210983758927.7"));
            checkRound(new BigDecimal("14819.98572882827452001"), new BigDecimal("14819.98572882827"));
            checkRound(new BigDecimal("1235187829570201.92843"), new BigDecimal("1235187829570202"));
            checkRound(new BigDecimal("1235992.1347819991923816"), new BigDecimal("1235992.134781999"));

            checkRound(new BigDecimal("-1312981740181908.0985023"), new BigDecimal("-1312981740181908"));
            checkRound(new BigDecimal("-1240982.74065829052808833"), new BigDecimal("-1240982.740658291"));
            checkRound(new BigDecimal("-12318275.021850219840184"), new BigDecimal("-12318275.02185022"));
            checkRound(new BigDecimal("-1231585919918347140194194114.14141"), new BigDecimal("-1.231585919918347e+27"));
            checkRound(new BigDecimal("-51351309848719847109847109.7431098471984"), new BigDecimal("-5.135130984871985e+25"));
            checkRound(new BigDecimal("-124189579327598.4325798327592769"), new BigDecimal("-124189579327598.4"));
        }

        //engineer
        {
            //e+
            checkRound(new BigDecimal("1.e+1"), new BigDecimal("10"));
            checkRound(new BigDecimal("1.e+2"), new BigDecimal("100"));
            checkRound(new BigDecimal("5.e+5"), new BigDecimal("500000"));
            checkRound(new BigDecimal("6.e+15"), new BigDecimal("6000000000000000"));
            checkRound(new BigDecimal("9.e+16"), new BigDecimal("9.e+16"));

            checkRound(new BigDecimal("1.5e+1"), new BigDecimal("15"));
            checkRound(new BigDecimal("1.68e+2"), new BigDecimal("168"));
            checkRound(new BigDecimal("5.25e+5"), new BigDecimal("525000"));
            checkRound(new BigDecimal("6.73e+15"), new BigDecimal("6730000000000000"));
            checkRound(new BigDecimal("9.74e+16"), new BigDecimal("9.74e+16"));

            checkRound(new BigDecimal("1.3e+67"), new BigDecimal("1.3e+67"));
            checkRound(new BigDecimal("1.6128e+22"), new BigDecimal("1.6128e+22"));
            checkRound(new BigDecimal("5.21235e+1235"), new BigDecimal("5.21235e+1235"));
            checkRound(new BigDecimal("6.71563e+1213"), new BigDecimal("6.71563e+1213"));
            checkRound(new BigDecimal("9.744e+156"), new BigDecimal("9.744e+156"));

            //-e+
            checkRound(new BigDecimal("-1.e+1"), new BigDecimal("-10"));
            checkRound(new BigDecimal("-1.e+2"), new BigDecimal("-100"));
            checkRound(new BigDecimal("-5.e+5"), new BigDecimal("-500000"));
            checkRound(new BigDecimal("-6.e+15"), new BigDecimal("-6000000000000000"));
            checkRound(new BigDecimal("-9.e+16"), new BigDecimal("-9.e+16"));

            checkRound(new BigDecimal("-1.5e+1"), new BigDecimal("-15"));
            checkRound(new BigDecimal("-1.68e+2"), new BigDecimal("-168"));
            checkRound(new BigDecimal("-5.25e+5"), new BigDecimal("-525000"));
            checkRound(new BigDecimal("-6.73e+15"), new BigDecimal("-6730000000000000"));
            checkRound(new BigDecimal("-9.74e+16"), new BigDecimal("-9.74e+16"));

            checkRound(new BigDecimal("-1.3e+67"), new BigDecimal("-1.3e+67"));
            checkRound(new BigDecimal("-1.6128e+22"), new BigDecimal("-1.6128e+22"));
            checkRound(new BigDecimal("-5.21235e+1235"), new BigDecimal("-5.21235e+1235"));
            checkRound(new BigDecimal("-6.71563e+1213"), new BigDecimal("-6.71563e+1213"));
            checkRound(new BigDecimal("-9.744e+156"), new BigDecimal("-9.744e+156"));

            //e-
            checkRound(new BigDecimal("1.e-1"), new BigDecimal("0.1"));
            checkRound(new BigDecimal("1.e-2"), new BigDecimal("0.01"));
            checkRound(new BigDecimal("5.e-5"), new BigDecimal("0.00005"));
            checkRound(new BigDecimal("6.e-15"), new BigDecimal("0.000000000000006"));
            checkRound(new BigDecimal("9.e-16"), new BigDecimal("9.e-16"));

            checkRound(new BigDecimal("1.5e-1"), new BigDecimal("0.15"));
            checkRound(new BigDecimal("1.68e-2"), new BigDecimal("0.0168"));
            checkRound(new BigDecimal("5.25e-5"), new BigDecimal("0.0000525"));
            checkRound(new BigDecimal("6.73e-15"), new BigDecimal("6.73e-15"));
            checkRound(new BigDecimal("9.74e-16"), new BigDecimal("9.74e-16"));

            checkRound(new BigDecimal("1.3e-67"), new BigDecimal("1.3e-67"));
            checkRound(new BigDecimal("1.6128e-22"), new BigDecimal("1.6128e-22"));
            checkRound(new BigDecimal("5.21235e-1235"), new BigDecimal("5.21235e-1235"));
            checkRound(new BigDecimal("6.71563e-1213"), new BigDecimal("6.71563e-1213"));
            checkRound(new BigDecimal("9.744e-156"), new BigDecimal("9.744e-156"));

            //-e-
            checkRound(new BigDecimal("-1.e-1"), new BigDecimal("-0.1"));
            checkRound(new BigDecimal("-1.e-2"), new BigDecimal("-0.01"));
            checkRound(new BigDecimal("-5.e-5"), new BigDecimal("-0.00005"));
            checkRound(new BigDecimal("-6.e-15"), new BigDecimal("-0.000000000000006"));
            checkRound(new BigDecimal("-9.e-16"), new BigDecimal("-0.0000000000000009"));

            checkRound(new BigDecimal("-1.5e-1"), new BigDecimal("-0.15"));
            checkRound(new BigDecimal("-1.68e-2"), new BigDecimal("-0.0168"));
            checkRound(new BigDecimal("-5.25e-5"), new BigDecimal("-0.0000525"));
            checkRound(new BigDecimal("-6.73e-15"), new BigDecimal("-6.73e-15"));
            checkRound(new BigDecimal("-9.74e-16"), new BigDecimal("-9.74e-16"));

            checkRound(new BigDecimal("-1.3e-67"), new BigDecimal("-1.3e-67"));
            checkRound(new BigDecimal("-1.6128e-22"), new BigDecimal("-1.6128e-22"));
            checkRound(new BigDecimal("-5.21235e-1235"), new BigDecimal("-5.21235e-1235"));
            checkRound(new BigDecimal("-6.71563e-1213"), new BigDecimal("-6.71563e-1213"));
            checkRound(new BigDecimal("-9.744e-156"), new BigDecimal("-9.744e-156"));
        }
    }

    /**
     * Checks that digit appended to number if it should be appended.
     *
     * @param number         number to edit.
     * @param digit          digit to append.
     * @param expectedResult required result after performing operation.
     */
    private void checkAppendDigit(String number, String digit, String expectedResult) {
        String result = NumberFormatter.appendDigit(number, digit);
        assertEquals(expectedResult, result);
    }

    /**
     * Checks that dot is added to number.
     *
     * @param number         number to edit.
     * @param expectedResult required result after performing operation.
     */
    private void checkAppendDot(String number, String expectedResult) {
        String result = NumberFormatter.appendDot(number);
        assertEquals(expectedResult, result);
    }

    /**
     * Checks result of delete last char operation.
     *
     * @param number         number to edit.
     * @param expectedResult required result after performing operation.
     */
    private void checkDeleteLastChar(String number, String expectedResult) {
        String result = NumberFormatter.deleteLastChar(number);
        assertEquals(expectedResult, result);
    }

    /**
     * Check result of screen to big decimal and big decimal to screen operations.
     *
     * @param string     number to convert.
     * @param bigDecimal required big decimal result.
     */
    private void checkScreenToBigDecimalAndViceVersa(String string, BigDecimal bigDecimal) {
        BigDecimal bigDecimalResult = NumberFormatter.screenToBigDecimal(string);
        assertEquals(bigDecimal, bigDecimalResult);

        String stringResult = NumberFormatter.bigDecimalToScreen(bigDecimal);
        assertEquals(string, stringResult);
    }

    /**
     * Checks result of round operation for big decimal.
     *
     * @param bigDecimal     number to convert.
     * @param expectedResult required big decimal result.
     */
    private void checkRound(BigDecimal bigDecimal, BigDecimal expectedResult) {
        BigDecimal result = NumberFormatter.round(bigDecimal);
        assertEquals(expectedResult, result);
    }

}
