package tests.controller;

import com.implemica.bormashenko.calculator.controller.util.NumberFormatter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for testing {@link NumberFormatter}.
 *
 * @author Mykhailo Bormashenko
 */
class NumberFormatterTest {

    /**
     * Tests for append digit operation.
     */
    @Test
    void appendDigitTests() {
        //can append
        {
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
            checkAppendDigit("934", "0", "9340");
            checkAppendDigit("825", "1", "8251");
            checkAppendDigit("230", "2", "2302");
            checkAppendDigit("827", "3", "8273");
            checkAppendDigit("828", "4", "8284");
            checkAppendDigit("821", "5", "8215");
            checkAppendDigit("997", "6", "9976");
            checkAppendDigit("282", "7", "2827");
            checkAppendDigit("962", "8", "9628");
            checkAppendDigit("973", "9", "9739");

            //append to three-digits negative integer number
            checkAppendDigit("-641", "0", "-6410");
            checkAppendDigit("-345", "1", "-3451");
            checkAppendDigit("-970", "2", "-9702");
            checkAppendDigit("-175", "3", "-1753");
            checkAppendDigit("-962", "4", "-9624");
            checkAppendDigit("-537", "5", "-5375");
            checkAppendDigit("-970", "6", "-9706");
            checkAppendDigit("-234", "7", "-2347");
            checkAppendDigit("-468", "8", "-4688");
            checkAppendDigit("-738", "9", "-7389");

            //append to three-digits (before dot) positive decimal number
            checkAppendDigit("623.", "0", "623.0");
            checkAppendDigit("838.", "1", "838.1");
            checkAppendDigit("234.", "5", "234.5");
            checkAppendDigit("126.", "8", "126.8");
            checkAppendDigit("967.", "9", "967.9");

            //checkAppendDigit("821.25", "0", "821.250");
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
            checkAppendDigit("723567", "0", "7235670");
            checkAppendDigit("82458", "1", "824581");
            checkAppendDigit("23634", "5", "236345");
            checkAppendDigit("2578", "8", "25788");
            checkAppendDigit("2155478547", "9", "21554785479");

            checkAppendDigit("-457345", "0", "-4573450");
            checkAppendDigit("-73456", "1", "-734561");
            checkAppendDigit("-3457", "5", "-34575");
            checkAppendDigit("-25679", "8", "-256798");
            checkAppendDigit("-63467435", "9", "-634674359");

            //append to decimal number with commas
            checkAppendDigit("21344.", "0", "21344.0");
            checkAppendDigit("7346346.8", "1", "7346346.81");
            checkAppendDigit("83463.375", "5", "83463.3755");
            checkAppendDigit("32467778.34678", "8", "32467778.346788");
            checkAppendDigit("23447.84365346", "9", "23447.843653469");

            checkAppendDigit("-32567.", "0", "-32567.0");
            checkAppendDigit("-23654.7", "1", "-23654.71");
            checkAppendDigit("-8762435.425", "5", "-8762435.4255");
            checkAppendDigit("-34637457.7346", "8", "-34637457.73468");
            checkAppendDigit("-3453635.8346346", "9", "-3453635.83463469");

            //append to 15-digits integer number
            checkAppendDigit("678096234678975", "0", "6780962346789750");
            checkAppendDigit("780875456897543", "1", "7808754568975431");
            checkAppendDigit("987456875345789", "5", "9874568753457895");
            checkAppendDigit("987564567986246", "8", "9875645679862468");
            checkAppendDigit("189090098567245", "9", "1890900985672459");

            checkAppendDigit("-987456752346783", "0", "-9874567523467830");
            checkAppendDigit("-987567356782345", "1", "-9875673567823451");
            checkAppendDigit("-987457621103536", "5", "-9874576211035365");
            checkAppendDigit("-123567256721457", "8", "-1235672567214578");
            checkAppendDigit("-423767464768144", "9", "-4237674647681449");

            //append to 15-digits (summary) decimal number
            checkAppendDigit("678987175238.357", "0", "678987175238.3570");
            checkAppendDigit("89798.6297342734", "1", "89798.62973427341");
            checkAppendDigit("98273492302.5727", "5", "98273492302.57275");
            checkAppendDigit("863.240000000023", "8", "863.2400000000238");
            checkAppendDigit("624592234242.500", "9", "624592234242.5009");

            checkAppendDigit("-7862359237.50226", "0", "-7862359237.502260");
            checkAppendDigit("-842.789273942046", "1", "-842.7892739420461");
            checkAppendDigit("-898402348028.492", "5", "-898402348028.4925");
            checkAppendDigit("-725836.826346363", "8", "-725836.8263463638");
            checkAppendDigit("-90000000.0000000", "9", "-90000000.00000009");

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
            checkAppendDigit("9847862357839869", "0", "9847862357839869");
            checkAppendDigit("7374149817289492", "1", "7374149817289492");
            checkAppendDigit("7349564303904532", "5", "7349564303904532");
            checkAppendDigit("9872358289579258", "8", "9872358289579258");
            checkAppendDigit("6729423840284622", "9", "6729423840284622");

            checkAppendDigit("-9239582957295726", "0", "-9239582957295726");
            checkAppendDigit("-7290000008234928", "1", "-7290000008234928");
            checkAppendDigit("-6666666666666666", "5", "-6666666666666666");
            checkAppendDigit("-2592838592590224", "8", "-2592838592590224");
            checkAppendDigit("-7535253536367367", "9", "-7535253536367367");

            //append to 16-digits (summary) decimal number
            checkAppendDigit("6269657463635353.", "0", "6269657463635353.");
            checkAppendDigit("7.334536437634563", "1", "7.334536437634563");
            checkAppendDigit("74564.64654646464", "5", "74564.64654646464");
            checkAppendDigit("966434529745647.4", "8", "966434529745647.4");
            checkAppendDigit("84.74745745745749", "9", "84.74745745745749");

            checkAppendDigit("-6346346394365337.", "0", "-6346346394365337.");
            checkAppendDigit("-845787846363733.7", "1", "-845787846363733.7");
            checkAppendDigit("-734.6367934653793", "5", "-734.6367934653793");
            checkAppendDigit("-95675.67568758474", "8", "-95675.67568758474");
            checkAppendDigit("-734639356475.4563", "9", "-734639356475.4563");

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
     * Tests for delete last char operation.
     */
    @Test
    void deleteLastCharTests() {
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
     * Tests for change sign operation.
     */
    @Test
    void changeSignTests() throws ParseException {
        checkChangeSign("0", "0");
        checkChangeSign("0.", "-0.");
        checkChangeSign("0.00", "-0.00");

        checkChangeSign("1", "-1");
        checkChangeSign("5", "-5");
        checkChangeSign("10", "-10");
        checkChangeSign("100", "-100");
        checkChangeSign("1,000", "-1,000");
        checkChangeSign("10,000", "-10,000");
    }

    /**
     * Tests for screen to big decimal operation.
     */
    @Test
    void screenToBigDecimalTests() throws ParseException {
        //integers
        //without commas
        checkScreenToBigDecimal("0", new BigDecimal("0"));

        checkScreenToBigDecimal("1", new BigDecimal("1"));
        checkScreenToBigDecimal("8", new BigDecimal("8"));
        checkScreenToBigDecimal("9", new BigDecimal("9"));
        checkScreenToBigDecimal("10", new BigDecimal("10"));
        checkScreenToBigDecimal("100", new BigDecimal("100"));
        checkScreenToBigDecimal("500", new BigDecimal("500"));

        checkScreenToBigDecimal("-1", new BigDecimal("-1"));
        checkScreenToBigDecimal("-8", new BigDecimal("-8"));
        checkScreenToBigDecimal("-9", new BigDecimal("-9"));
        checkScreenToBigDecimal("-10", new BigDecimal("-10"));
        checkScreenToBigDecimal("-100", new BigDecimal("-100"));
        checkScreenToBigDecimal("-500", new BigDecimal("-500"));

        //with commas
        checkScreenToBigDecimal("84,357", new BigDecimal("84357"));
        checkScreenToBigDecimal("8,762,423,634", new BigDecimal("8762423634"));
        checkScreenToBigDecimal("873,283,568", new BigDecimal("873283568"));
        checkScreenToBigDecimal("8,235,854,645", new BigDecimal("8235854645"));
        checkScreenToBigDecimal("23,482,314", new BigDecimal("23482314"));
        checkScreenToBigDecimal("234,643,737", new BigDecimal("234643737"));

        checkScreenToBigDecimal("-72,341,234", new BigDecimal("-72341234"));
        checkScreenToBigDecimal("-8,023,042,394", new BigDecimal("-8023042394"));
        checkScreenToBigDecimal("-626,356,345", new BigDecimal("-626356345"));
        checkScreenToBigDecimal("-67,235,923,052", new BigDecimal("-67235923052"));
        checkScreenToBigDecimal("-7,625,252,352,352", new BigDecimal("-7625252352352"));
        checkScreenToBigDecimal("-62,523,523,523,525", new BigDecimal("-62523523523525"));

        //decimals
        //without commas
        checkScreenToBigDecimal("0.6", new BigDecimal("0.6"));
        checkScreenToBigDecimal("1.235", new BigDecimal("1.235"));
        checkScreenToBigDecimal("8.8236", new BigDecimal("8.8236"));
        checkScreenToBigDecimal("9.8245", new BigDecimal("9.8245"));
        checkScreenToBigDecimal("10.7", new BigDecimal("10.7"));
        checkScreenToBigDecimal("100.3247", new BigDecimal("100.3247"));
        checkScreenToBigDecimal("500.7235", new BigDecimal("500.7235"));

        checkScreenToBigDecimal("-0.736", new BigDecimal("-0.736"));
        checkScreenToBigDecimal("-1.8356", new BigDecimal("-1.8356"));
        checkScreenToBigDecimal("-8.5437", new BigDecimal("-8.5437"));
        checkScreenToBigDecimal("-9.7235", new BigDecimal("-9.7235"));
        checkScreenToBigDecimal("-10.834", new BigDecimal("-10.834"));
        checkScreenToBigDecimal("-100.01", new BigDecimal("-100.01"));
        checkScreenToBigDecimal("-500.5", new BigDecimal("-500.5"));

        //with commas
        checkScreenToBigDecimal("124,513.25835", new BigDecimal("124513.25835"));
        checkScreenToBigDecimal("62,352.7235", new BigDecimal("62352.7235"));
        checkScreenToBigDecimal("6,626.8256", new BigDecimal("6626.8256"));
        checkScreenToBigDecimal("2,346.7925", new BigDecimal("2346.7925"));
        checkScreenToBigDecimal("762,462.6782", new BigDecimal("762462.6782"));
        checkScreenToBigDecimal("7,624,623.2", new BigDecimal("7624623.2"));
        checkScreenToBigDecimal("76,236,262.72", new BigDecimal("76236262.72"));

        checkScreenToBigDecimal("-77,322,225.7", new BigDecimal("-77322225.7"));
        checkScreenToBigDecimal("-823,452,168,746.734535", new BigDecimal("-823452168746.734535"));
        checkScreenToBigDecimal("-2,523,578.725", new BigDecimal("-2523578.725"));
        checkScreenToBigDecimal("-8,643.825", new BigDecimal("-8643.825"));
        checkScreenToBigDecimal("-6,235.725", new BigDecimal("-6235.725"));
        checkScreenToBigDecimal("-734,535.73", new BigDecimal("-734535.73"));
        checkScreenToBigDecimal("-84,564.622", new BigDecimal("-84564.622"));

        //engineer numbers
        checkScreenToBigDecimal("7.e+7234", new BigDecimal("7.e+7234"));
        checkScreenToBigDecimal("1.e+72", new BigDecimal("1.e+72"));
        checkScreenToBigDecimal("5.e+92", new BigDecimal("5.e+92"));
        checkScreenToBigDecimal("4.e-234", new BigDecimal("4.e-234"));
        checkScreenToBigDecimal("8.e-19", new BigDecimal("8.e-19"));
        checkScreenToBigDecimal("2.e-84", new BigDecimal("2.e-84"));

        checkScreenToBigDecimal("-4.e+13", new BigDecimal("-4.e+13"));
        checkScreenToBigDecimal("-2.e+126", new BigDecimal("-2.e+126"));
        checkScreenToBigDecimal("-7.e+1482", new BigDecimal("-7.e+1482"));
        checkScreenToBigDecimal("-6.e-723", new BigDecimal("-6.e-723"));
        checkScreenToBigDecimal("-5.e-17", new BigDecimal("-5.e-17"));
        checkScreenToBigDecimal("-2.e-79", new BigDecimal("-2.e-79"));

        checkScreenToBigDecimal("6.21e+24", new BigDecimal("6.21e+24"));
        checkScreenToBigDecimal("3.762e+789", new BigDecimal("3.762e+789"));
        checkScreenToBigDecimal("1.627e+25", new BigDecimal("1.627e+25"));
        checkScreenToBigDecimal("7.831e-19", new BigDecimal("7.831e-19"));
        checkScreenToBigDecimal("9.1346e-3216", new BigDecimal("9.1346e-3216"));
        checkScreenToBigDecimal("1.143e-1446", new BigDecimal("1.143e-1446"));

        checkScreenToBigDecimal("-8.09e+74", new BigDecimal("-8.09e+74"));
        checkScreenToBigDecimal("-6.863e+835", new BigDecimal("-6.863e+835"));
        checkScreenToBigDecimal("-4.325e+7267", new BigDecimal("-4.325e+7267"));
        checkScreenToBigDecimal("-2.13e-874", new BigDecimal("-2.13e-874"));
        checkScreenToBigDecimal("-2.126e-1353", new BigDecimal("-2.126e-1353"));
        checkScreenToBigDecimal("-1.73e-735", new BigDecimal("-1.73e-735"));
    }

    /**
     * Tests for format operation.
     */
    @Test
    void formatTests() {
        //integers
        {
            //less that 16 digits
            checkFormat(new BigDecimal("0"), "0");

            checkFormat(new BigDecimal("1"), "1");
            checkFormat(new BigDecimal("2"), "2");
            checkFormat(new BigDecimal("100"), "100");

            checkFormat(new BigDecimal("5000"), "5,000");
            checkFormat(new BigDecimal("62368"), "62,368");
            checkFormat(new BigDecimal("73737375"), "73,737,375");

            checkFormat(new BigDecimal("-1"), "-1");
            checkFormat(new BigDecimal("-2"), "-2");
            checkFormat(new BigDecimal("-100"), "-100");

            checkFormat(new BigDecimal("-5000"), "-5,000");
            checkFormat(new BigDecimal("-137687"), "-137,687");
            checkFormat(new BigDecimal("-1236879000"), "-1,236,879,000");

            //16 digits
            checkFormat(new BigDecimal("7891236742367892"), "7,891,236,742,367,892");
            checkFormat(new BigDecimal("8914815712245616"), "8,914,815,712,245,616");
            checkFormat(new BigDecimal("1472184129453219"), "1,472,184,129,453,219");

            checkFormat(new BigDecimal("-1237894562345678"), "-1,237,894,562,345,678");
            checkFormat(new BigDecimal("-7123912369284216"), "-7,123,912,369,284,216");
            checkFormat(new BigDecimal("-1237891401000000"), "-1,237,891,401,000,000");

            //more than 16 digits
            checkFormat(new BigDecimal("354678126471241518756213"), "3.546781264712415e+23");
            checkFormat(new BigDecimal("86583242839429024222221664265286"), "8.658324283942902e+31");
            checkFormat(new BigDecimal("982147981274912749812748912749"), "9.821479812749127e+29");

            checkFormat(new BigDecimal("-6315214812841571983251953218198156"), "-6.315214812841572e+33");
            checkFormat(new BigDecimal("-1231238456344543890000000000"), "-1.231238456344544e+27");
            checkFormat(new BigDecimal("-3123137862452352347899"), "-3.123137862452352e+21");
        }

        //decimals
        {
            //less that 16 digits (summary)
            checkFormat(new BigDecimal("13.16325"), "13.16325");
            checkFormat(new BigDecimal("0.724658"), "0.724658");
            checkFormat(new BigDecimal("625.72"), "625.72");

            checkFormat(new BigDecimal("12383254.8234324"), "12,383,254.8234324");
            checkFormat(new BigDecimal("12312476.2434"), "12,312,476.2434");
            checkFormat(new BigDecimal("1316.123"), "1,316.123");

            checkFormat(new BigDecimal("-0.721111"), "-0.721111");
            checkFormat(new BigDecimal("-12.1"), "-12.1");
            checkFormat(new BigDecimal("-0.721111"), "-0.721111");

            checkFormat(new BigDecimal("-14312.73"), "-14,312.73");
            checkFormat(new BigDecimal("-5952.43521"), "-5,952.43521");
            checkFormat(new BigDecimal("-23425252.25"), "-23,425,252.25");

            //16 digits (summary) and starts with 0.
            checkFormat(new BigDecimal("0.765986234567097"), "0.765986234567097");
            checkFormat(new BigDecimal("0.987187591481567"), "0.987187591481567");
            checkFormat(new BigDecimal("0.123689238599145"), "0.123689238599145");

            checkFormat(new BigDecimal("-0.126789043256784"), "-0.126789043256784");
            checkFormat(new BigDecimal("-0.213123099852516"), "-0.213123099852516");
            checkFormat(new BigDecimal("-0.918237192749815"), "-0.918237192749815");

            //16 digits (summary) and does not start with 0.
            checkFormat(new BigDecimal("765678.6786785423"), "765,678.6786785423");
            checkFormat(new BigDecimal("988624352525.7111"), "988,624,352,525.7111");
            checkFormat(new BigDecimal("3192831937198.355"), "3,192,831,937,198.355");

            checkFormat(new BigDecimal("-98.12748917915915"), "-98.12748917915915");
            checkFormat(new BigDecimal("-1235823.592917895"), "-1,235,823.592917895");
            checkFormat(new BigDecimal("-12936661991.79419"), "-12,936,661,991.79419");

            //17 digits (summary) and starts with 0.
            checkFormat(new BigDecimal("0.7634568901234567"), "0.7634568901234567");
            checkFormat(new BigDecimal("0.8269023457876125"), "0.8269023457876125");
            checkFormat(new BigDecimal("0.1465698791749184"), "0.1465698791749184");

            checkFormat(new BigDecimal("-0.123123213698235"), "-0.123123213698235");
            checkFormat(new BigDecimal("-0.102398019815789"), "-0.102398019815789");
            checkFormat(new BigDecimal("-0.876523452349824"), "-0.876523452349824");

            //17 digits (summary) and does not start with 0.
            checkFormat(new BigDecimal("1237894445.6723489"), "1,237,894,445.672349");
            checkFormat(new BigDecimal("73463.632980090322"), "73,463.63298009032");
            checkFormat(new BigDecimal("926598259202.22578"), "926,598,259,202.2258");

            checkFormat(new BigDecimal("-1238091250715979.8"), "-1,238,091,250,715,980");
            checkFormat(new BigDecimal("-723.52358725265226"), "-723.5235872526523");
            checkFormat(new BigDecimal("-3447.7789023345812"), "-3,447.778902334581");

            //more than 17 digits (summary) and starts with 0.
            checkFormat(new BigDecimal("0.9418724917491750150179815191"), "0.941872491749175");
            checkFormat(new BigDecimal("0.5418715871759237626982786206123"), "0.5418715871759238");
            checkFormat(new BigDecimal("0.982137987150875380173258619"), "0.9821379871508754");

            checkFormat(new BigDecimal("-0.198471895719857193751084791"), "-0.1984718957198572");
            checkFormat(new BigDecimal("-0.12310958190357878062046206"), "-0.1231095819035788");
            checkFormat(new BigDecimal("-0.12465982153209520592805"), "-0.1246598215320952");

            //more than 17 digits (summary) and does not start with 0.
            checkFormat(new BigDecimal("128419581095019580128.75019875"), "1.28419581e+20");
            checkFormat(new BigDecimal("128758.917509715091750128750175"), "128,758.9175097151");
            checkFormat(new BigDecimal("1235992.1347819991923816"), "1,235,992.134781999");

            checkFormat(new BigDecimal("-1312981740181908.0985023"), "-1,312,981,740,181,908");
            checkFormat(new BigDecimal("-51351309848719847109847109.7431098471984"), "-5.1351309848720e+25");
            checkFormat(new BigDecimal("-124189579327598.4325798327592769"), "-124,189,579,327,598.4");
        }

        //engineer
        {
            //e+
            checkFormat(new BigDecimal("1.e+1"), "10");
            checkFormat(new BigDecimal("1.e+2"), "100");
            checkFormat(new BigDecimal("5.e+5"), "500,000");
            checkFormat(new BigDecimal("6.e+15"), "6,000,000,000,000,000");
            checkFormat(new BigDecimal("9.e+16"), "9.e+16");

            checkFormat(new BigDecimal("1.5e+1"), "15");
            checkFormat(new BigDecimal("1.68e+2"), "168");
            checkFormat(new BigDecimal("5.25e+5"), "525,000");
            checkFormat(new BigDecimal("6.73e+15"), "6,730,000,000,000,000");
            checkFormat(new BigDecimal("9.74e+16"), "9.74e+16");

            checkFormat(new BigDecimal("1.3e+67"), "1.3e+67");
            checkFormat(new BigDecimal("1.6128e+22"), "1.6128e+22");
            checkFormat(new BigDecimal("5.21235e+1235"), "5.21235e+1235");
            checkFormat(new BigDecimal("6.71563e+1213"), "6.71563e+1213");
            checkFormat(new BigDecimal("9.744e+156"), "9.744e+156");

            //-e+
            checkFormat(new BigDecimal("-1.e+1"), "-10");
            checkFormat(new BigDecimal("-1.e+2"), "-100");
            checkFormat(new BigDecimal("-5.e+5"), "-500,000");
            checkFormat(new BigDecimal("-6.e+15"), "-6,000,000,000,000,000");
            checkFormat(new BigDecimal("-9.e+16"), "-9.e+16");

            checkFormat(new BigDecimal("-1.5e+1"), "-15");
            checkFormat(new BigDecimal("-1.68e+2"), "-168");
            checkFormat(new BigDecimal("-5.25e+5"), "-525,000");
            checkFormat(new BigDecimal("-6.73e+15"), "-6,730,000,000,000,000");
            checkFormat(new BigDecimal("-9.74e+16"), "-9.74e+16");

            checkFormat(new BigDecimal("-1.3e+67"), "-1.3e+67");
            checkFormat(new BigDecimal("-1.6128e+22"), "-1.6128e+22");
            checkFormat(new BigDecimal("-5.21235e+1235"), "-5.21235e+1235");
            checkFormat(new BigDecimal("-6.71563e+1213"), "-6.71563e+1213");
            checkFormat(new BigDecimal("-9.744e+156"), "-9.744e+156");

            //e-
            checkFormat(new BigDecimal("1.e-1"), "0.1");
            checkFormat(new BigDecimal("1.e-2"), "0.01");
            checkFormat(new BigDecimal("5.e-5"), "0.00005");
            checkFormat(new BigDecimal("9.e-16"), "0.0000000000000009");
            checkFormat(new BigDecimal("9.e-17"), "9.e-17");

            checkFormat(new BigDecimal("1.5e-1"), "0.15");
            checkFormat(new BigDecimal("1.68e-2"), "0.0168");
            checkFormat(new BigDecimal("5.25e-5"), "0.0000525");
            checkFormat(new BigDecimal("6.73e-16"), "6.73e-16");
            checkFormat(new BigDecimal("9.74e-17"), "9.74e-17");

            checkFormat(new BigDecimal("1.3e-67"), "1.3e-67");
            checkFormat(new BigDecimal("1.6128e-22"), "1.6128e-22");
            checkFormat(new BigDecimal("5.21235e-1235"), "5.21235e-1235");
            checkFormat(new BigDecimal("6.71563e-1213"), "6.71563e-1213");
            checkFormat(new BigDecimal("9.744e-156"), "9.744e-156");

            //-e-
            checkFormat(new BigDecimal("-1.e-1"), "-0.1");
            checkFormat(new BigDecimal("-1.e-2"), "-0.01");
            checkFormat(new BigDecimal("-5.e-5"), "-0.00005");
            checkFormat(new BigDecimal("-6.e-15"), "-0.000000000000006");
            checkFormat(new BigDecimal("-9.e-16"), "-0.0000000000000009");

            checkFormat(new BigDecimal("-1.5e-1"), "-0.15");
            checkFormat(new BigDecimal("-1.68e-2"), "-0.0168");
            checkFormat(new BigDecimal("-5.25e-5"), "-0.0000525");
            checkFormat(new BigDecimal("-6.73e-16"), "-6.73e-16");
            checkFormat(new BigDecimal("-9.74e-17"), "-9.74e-17");

            checkFormat(new BigDecimal("-1.3e-67"), "-1.3e-67");
            checkFormat(new BigDecimal("-1.6128e-22"), "-1.6128e-22");
            checkFormat(new BigDecimal("-5.21235e-1235"), "-5.21235e-1235");
            checkFormat(new BigDecimal("-6.71563e-1213"), "-6.71563e-1213");
            checkFormat(new BigDecimal("-9.744e-156"), "-9.744e-156");
        }
    }

    /**
     * Checks that digit appended to number if it should be appended.
     *
     * @param number         number to edit.
     * @param digit          digit to append.
     * @param expectedResult expected result after performing operation.
     */
    private void checkAppendDigit(String number, String digit, String expectedResult) {
        BigDecimal bigDecimalNumber = new BigDecimal(number);
        BigDecimal bigDecimalDigit = new BigDecimal(digit);
        BigDecimal bigDecimalExpectedResult = new BigDecimal(expectedResult);

        assertEquals(bigDecimalExpectedResult, NumberFormatter.appendDigitToNumber(bigDecimalNumber, bigDecimalDigit,
                number.endsWith(String.valueOf(NumberFormatter.DECIMAL_SEPARATOR))));
    }

    /**
     * Checks result of delete last char operation.
     *
     * @param number         number to edit.
     * @param expectedResult expected result after performing operation.
     */
    private void checkDeleteLastChar(String number, String expectedResult) {
        String result = null;

        try {
            result = NumberFormatter.deleteLastChar(number);
        } catch (ParseException e) {
            fail();
        }
        assertEquals(expectedResult, result);
    }

    /**
     * Checks result of change sign operation (after first and second performing this operation in a row).
     *
     * @param number         number to edit (and vise versa with expected result for second time).
     * @param expectedResult expected result after performing operation (and vise versa with number for second time).
     */
    private void checkChangeSign(String number, String expectedResult) throws ParseException {
        assertEquals(expectedResult, NumberFormatter.changeSign(number));
        assertEquals(number, NumberFormatter.changeSign(expectedResult));
    }

    /**
     * Check result of screen to big decimal operation.
     *
     * @param string     number to convert.
     * @param bigDecimal expected result after performing operation.
     */
    private void checkScreenToBigDecimal(String string, BigDecimal bigDecimal) throws ParseException {
        BigDecimal bigDecimalResult = NumberFormatter.parseToBigDecimal(string);
        assertEquals(bigDecimal, bigDecimalResult);
    }

    /**
     * Check result of format number operation (with and without group separator).
     *
     * @param bigDecimal     number to format.
     * @param expectedResult expected result after performing operation.
     */
    private void checkFormat(BigDecimal bigDecimal, String expectedResult) {
        String resultWithGroupSeparator = NumberFormatter.formatNumber(bigDecimal, true);
        assertEquals(expectedResult, resultWithGroupSeparator);

        String resultWithoutGroupSeparator = NumberFormatter.formatNumber(bigDecimal, false);

        assertEquals(expectedResult.replaceAll(",", ""), resultWithoutGroupSeparator);
    }
}
