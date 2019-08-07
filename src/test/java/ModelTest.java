//import com.implemica.bormashenko.calculator.model.CalculatorOperations;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Test class for model of calculator application.
// *
// * @author Mykhailo Bormashenko.
// */
//class ModelTest {
//
//    /**
//     * Big decimal value of minimal number that calculator's result label can show minus one.
//     */
//    private static final BigDecimal MIN_CALC_MINUS_ONE = new BigDecimal("-10000000000000000");
//
//    /**
//     * Big decimal value of minimal number that calculator's result label can show.
//     */
//    private static final BigDecimal MIN_CALC = new BigDecimal("-9999999999999999");
//
//    /**
//     * Big decimal value of minimal number that calculator's result label can show plus one.
//     */
//    private static final BigDecimal MIN_CALC_PLUS_ONE = new BigDecimal("-9999999999999998");
//
//    /**
//     * Big decimal value of -1000.
//     */
//    private static final BigDecimal NEG_THOUSAND = new BigDecimal("-1000");
//
//    /**
//     * Big decimal value of -100.
//     */
//    private static final BigDecimal NEG_HUNDRED = new BigDecimal("-100");
//
//    /**
//     * Big decimal value of -10.
//     */
//    private static final BigDecimal NEG_TEN = new BigDecimal("-10");
//
//    /**
//     * Big decimal value of -1.
//     */
//    private static final BigDecimal NEG_ONE = new BigDecimal("-1");
//
//    /**
//     * Big decimal value of 100.
//     */
//    private static final BigDecimal HUNDRED = new BigDecimal("100");
//
//    /**
//     * Big decimal value of 1000.
//     */
//    private static final BigDecimal THOUSAND = new BigDecimal("1000");
//
//    /**
//     * Big decimal value of maximal number that calculator's result label can show minus one.
//     */
//    private static final BigDecimal MAX_CALC_MINUS_ONE = new BigDecimal("9999999999999998");
//
//    /**
//     * Big decimal value of maximal number that calculator's result label can show.
//     */
//    private static final BigDecimal MAX_CALC = new BigDecimal("9999999999999999");
//
//    /**
//     * Big decimal value of maximal number that calculator's result label can show plus one.
//     */
//    private static final BigDecimal MAX_CALC_PLUS_ONE = new BigDecimal("10000000000000000");
//
//    /**
//     * Big decimal value of -9.99.
//     */
//    private static final BigDecimal NEG_NINE_AND_NINETY_NINE_HUNDREDTH = new BigDecimal("-9.99");
//
//    /**
//     * Big decimal value of -9.9.
//     */
//    private static final BigDecimal NEG_NINE_AND_NINE_TENTH = new BigDecimal("-9.9");
//
//    /**
//     * Big decimal value of -0.9999999999999999.
//     * This value is the longest that can be shown in the calculator's result label.
//     */
//    private static final BigDecimal NEG_ZERO_DOT_16_NINES = new BigDecimal("-0.9999999999999999");
//
//    /**
//     * Big decimal value of -0.0000000000000009.
//     * This value is the longest that can be shown in the calculator's result label.
//     */
//    private static final BigDecimal NEG_ZERO_DOT_15_ZEROS_NINE = new BigDecimal("-0.0000000000000009");
//
//    /**
//     * Big decimal value of -0.99.
//     */
//    private static final BigDecimal NEG_NINETY_NINE_HUNDREDTH = new BigDecimal("-0.99");
//
//    /**
//     * Big decimal value of -0.09.
//     */
//    private static final BigDecimal NEG_NINE_HUNDREDTH = new BigDecimal("-0.09");
//
//    /**
//     * Big decimal value of -0.9.
//     */
//    private static final BigDecimal NEG_NINE_TENTH = new BigDecimal("-0.9");
//
//    /**
//     * Big decimal value of -0.0000000000000001.
//     * This value is the longest that can be shown in the calculator's result label.
//     */
//    private static final BigDecimal NEG_ZERO_DOT_15_ZEROS_ONE = new BigDecimal("-0.0000000000000001");
//
//    /**
//     * Big decimal value of -0.01.
//     */
//    private static final BigDecimal NEG_ONE_HUNDREDTH = new BigDecimal("-0.01");
//
//    /**
//     * Big decimal value of -0.1.
//     */
//    private static final BigDecimal NEG_ONE_TENTH = new BigDecimal("-0.1");
//
//    /**
//     * Big decimal value of 0.0.
//     */
//    private static final BigDecimal ZERO_DOT_ZERO = new BigDecimal("0.0");
//
//    /**
//     * Big decimal value of 0.1.
//     */
//    private static final BigDecimal ONE_TENTH = new BigDecimal("0.1");
//
//    /**
//     * Big decimal value of 0.01.
//     */
//    private static final BigDecimal ONE_HUNDREDTH = new BigDecimal("0.01");
//
//    /**
//     * Big decimal value of 0.0000000000000001.
//     * This value is the longest that can be shown in the calculator's result label.
//     */
//    private static final BigDecimal ZERO_DOT_15_ZEROS_ONE = new BigDecimal("0.0000000000000001");
//
//    /**
//     * Big decimal value of 1.1.
//     */
//    private static final BigDecimal ONE_AND_ONE_TENTH = new BigDecimal("1.1");
//
//    /**
//     * Big decimal value of 1.01.
//     */
//    private static final BigDecimal ONE_AND_ONE_HUNDREDTH = new BigDecimal("1.01");
//
//    /**
//     * Big decimal value of 0.9.
//     */
//    private static final BigDecimal NINE_TENTH = new BigDecimal("0.9");
//
//    /**
//     * Big decimal value of 0.09.
//     */
//    private static final BigDecimal NINE_HUNDREDTH = new BigDecimal("0.09");
//
//    /**
//     * Big decimal value of 0.99.
//     */
//    private static final BigDecimal NINETY_NINE_HUNDREDTH = new BigDecimal("0.99");
//
//    /**
//     * Big decimal value of 0.0000000000000009.
//     * This value is the longest that can be shown in the calculator's result label.
//     */
//    private static final BigDecimal ZERO_DOT_15_ZEROS_NINE = new BigDecimal("0.0000000000000009");
//
//    /**
//     * Big decimal value of 0.9999999999999999.
//     * This value is the longest that can be shown in the calculator's result label.
//     */
//    private static final BigDecimal ZERO_DOT_16_NINES = new BigDecimal("0.9999999999999999");
//
//    /**
//     * Big decimal value of 9.9.
//     */
//    private static final BigDecimal NINE_AND_NINE_TENTH = new BigDecimal("9.9");
//
//    /**
//     * Big decimal value of 9.09.
//     */
//    private static final BigDecimal NINE_AND_NINE_HUNDREDTH = new BigDecimal("9.09");
//
//    /**
//     * Big decimal value of 9.99.
//     */
//    private static final BigDecimal NINE_AND_NINETY_NINE_HUNDREDTH = new BigDecimal("9.99");
//
//    /**
//     * Big decimal value of 9.000000000000009.
//     * This value is the longest that can be shown in the calculator's result label.
//     */
//    private static final BigDecimal NINE_DOT_14_ZEROS_NINE = new BigDecimal("9.000000000000009");
//
//    @Test
//    void tests() {
//        //add operation tests
//        //integer values only
//        //first is min calc value minus one
//        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC_MINUS_ONE, bigDec("-2.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC, bigDec("-2.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC_PLUS_ONE, bigDec("-2.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_THOUSAND, bigDec("-1.0000000000001e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_HUNDRED, bigDec("-1.00000000000001e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_TEN, bigDec("-1.000000000000001e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_ONE, bigDec("-1.e+16"));
//
//        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.ZERO, bigDec("-1.e+16"));
//
//        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.ONE, MIN_CALC);
//        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.TEN, bigDec("-9999999999999990"));
//        checkAdd(MIN_CALC_MINUS_ONE, HUNDRED, bigDec("-9999999999999900"));
//        checkAdd(MIN_CALC_MINUS_ONE, THOUSAND, bigDec("-9999999999999000"));
//        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, bigDec("-2"));
//        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC, NEG_ONE);
//        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, BigDecimal.ZERO);
//
//        //first is min calc value
//        checkAdd(MIN_CALC, MIN_CALC, bigDec("-2.e+16"));
//        checkAdd(MIN_CALC, MIN_CALC_PLUS_ONE, bigDec("-2.e+16"));
//        checkAdd(MIN_CALC, NEG_THOUSAND, bigDec("-1.0000000000001e+16"));
//        checkAdd(MIN_CALC, NEG_HUNDRED, bigDec("-1.00000000000001e+16"));
//        checkAdd(MIN_CALC, NEG_TEN, bigDec("-1.000000000000001e+16"));
//        checkAdd(MIN_CALC, NEG_ONE, bigDec("-1.e+16"));
//
//        checkAdd(MIN_CALC, BigDecimal.ZERO, MIN_CALC);
//
//        checkAdd(MIN_CALC, BigDecimal.ONE, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC, BigDecimal.TEN, bigDec("-9999999999999989"));
//        checkAdd(MIN_CALC, HUNDRED, bigDec("-9999999999999899"));
//        checkAdd(MIN_CALC, THOUSAND, bigDec("-9999999999998999"));
//        checkAdd(MIN_CALC, MAX_CALC_MINUS_ONE, NEG_ONE);
//        checkAdd(MIN_CALC, MAX_CALC, BigDecimal.ZERO);
//        checkAdd(MIN_CALC, MAX_CALC_PLUS_ONE, BigDecimal.ONE);
//
//        //first is min calc value plus one
//        checkAdd(MIN_CALC_PLUS_ONE, MIN_CALC_PLUS_ONE, bigDec("-2.e+16"));
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_THOUSAND, bigDec("-1.0000000000001e+16"));
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_HUNDRED, bigDec("-1.00000000000001e+16"));
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_TEN, bigDec("-1.000000000000001e+16"));
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_ONE, MIN_CALC);
//
//        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.ZERO, MIN_CALC_PLUS_ONE);
//
//        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.ONE, bigDec("-9999999999999997"));
//        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.TEN, bigDec("-9999999999999988"));
//        checkAdd(MIN_CALC_PLUS_ONE, HUNDRED, bigDec("-9999999999999898"));
//        checkAdd(MIN_CALC_PLUS_ONE, THOUSAND, bigDec("-9999999999998998"));
//        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC_MINUS_ONE, BigDecimal.ZERO);
//        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC, BigDecimal.ONE);
//        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, bigDec("2"));
//
//        //first is -1000
//        checkAdd(NEG_THOUSAND, NEG_THOUSAND, bigDec("-2000"));
//        checkAdd(NEG_THOUSAND, NEG_HUNDRED, bigDec("-1100"));
//        checkAdd(NEG_THOUSAND, NEG_TEN, bigDec("-1010"));
//        checkAdd(NEG_THOUSAND, NEG_ONE, bigDec("-1001"));
//
//        checkAdd(NEG_THOUSAND, BigDecimal.ZERO, NEG_THOUSAND);
//
//        checkAdd(NEG_THOUSAND, BigDecimal.ONE, bigDec("-999"));
//        checkAdd(NEG_THOUSAND, BigDecimal.TEN, bigDec("-990"));
//        checkAdd(NEG_THOUSAND, HUNDRED, bigDec("-900"));
//        checkAdd(NEG_THOUSAND, THOUSAND, BigDecimal.ZERO);
//        checkAdd(NEG_THOUSAND, MAX_CALC_MINUS_ONE, bigDec("9999999999998998"));
//        checkAdd(NEG_THOUSAND, MAX_CALC, bigDec("9999999999998999"));
//        checkAdd(NEG_THOUSAND, MAX_CALC_PLUS_ONE, bigDec("9999999999999000"));
//
//        //first is -100
//        checkAdd(NEG_HUNDRED, NEG_HUNDRED, bigDec("-200"));
//        checkAdd(NEG_HUNDRED, NEG_TEN, bigDec("-110"));
//        checkAdd(NEG_HUNDRED, NEG_ONE, bigDec("-101"));
//
//        checkAdd(NEG_HUNDRED, BigDecimal.ZERO, NEG_HUNDRED);
//
//        checkAdd(NEG_HUNDRED, BigDecimal.ONE, bigDec("-99"));
//        checkAdd(NEG_HUNDRED, BigDecimal.TEN, bigDec("-90"));
//        checkAdd(NEG_HUNDRED, HUNDRED, BigDecimal.ZERO);
//        checkAdd(NEG_HUNDRED, THOUSAND, bigDec("900"));
//        checkAdd(NEG_HUNDRED, MAX_CALC_MINUS_ONE, bigDec("9999999999999898"));
//        checkAdd(NEG_HUNDRED, MAX_CALC, bigDec("9999999999999899"));
//        checkAdd(NEG_HUNDRED, MAX_CALC_PLUS_ONE, bigDec("9999999999999900"));
//
//        //first is -10
//        checkAdd(NEG_TEN, NEG_TEN, bigDec("-20"));
//        checkAdd(NEG_TEN, NEG_ONE, bigDec("-11"));
//
//        checkAdd(NEG_TEN, BigDecimal.ZERO, NEG_TEN);
//
//        checkAdd(NEG_TEN, BigDecimal.ONE, bigDec("-9"));
//        checkAdd(NEG_TEN, BigDecimal.TEN, BigDecimal.ZERO);
//        checkAdd(NEG_TEN, HUNDRED, bigDec("90"));
//        checkAdd(NEG_TEN, THOUSAND, bigDec("990"));
//        checkAdd(NEG_TEN, MAX_CALC_MINUS_ONE, bigDec("9999999999999988"));
//        checkAdd(NEG_TEN, MAX_CALC, bigDec("9999999999999989"));
//        checkAdd(NEG_TEN, MAX_CALC_PLUS_ONE, bigDec("9999999999999990"));
//
//        //first is -1
//        checkAdd(NEG_ONE, NEG_ONE, bigDec("-2"));
//
//        checkAdd(NEG_ONE, BigDecimal.ZERO, NEG_ONE);
//
//        checkAdd(NEG_ONE, BigDecimal.ONE, BigDecimal.ZERO);
//        checkAdd(NEG_ONE, BigDecimal.TEN, bigDec("9"));
//        checkAdd(NEG_ONE, HUNDRED, bigDec("99"));
//        checkAdd(NEG_ONE, THOUSAND, bigDec("999"));
//        checkAdd(NEG_ONE, MAX_CALC_MINUS_ONE, bigDec("9999999999999997"));
//        checkAdd(NEG_ONE, MAX_CALC, MAX_CALC_MINUS_ONE);
//        checkAdd(NEG_ONE, MAX_CALC_PLUS_ONE, MAX_CALC);
//
//        //first is 0
//        checkAdd(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
//
//        checkAdd(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE);
//        checkAdd(BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
//        checkAdd(BigDecimal.ZERO, HUNDRED, HUNDRED);
//        checkAdd(BigDecimal.ZERO, THOUSAND, THOUSAND);
//        checkAdd(BigDecimal.ZERO, MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE);
//        checkAdd(BigDecimal.ZERO, MAX_CALC, MAX_CALC);
//        checkAdd(BigDecimal.ZERO, MAX_CALC_PLUS_ONE, bigDec("1.e+16"));
//
//        //first is 1
//        checkAdd(BigDecimal.ONE, BigDecimal.ONE, bigDec("2"));
//        checkAdd(BigDecimal.ONE, BigDecimal.TEN, bigDec("11"));
//        checkAdd(BigDecimal.ONE, HUNDRED, bigDec("101"));
//        checkAdd(BigDecimal.ONE, THOUSAND, bigDec("1001"));
//        checkAdd(BigDecimal.ONE, MAX_CALC_MINUS_ONE, MAX_CALC);
//        checkAdd(BigDecimal.ONE, MAX_CALC, bigDec("1.e+16"));
//        checkAdd(BigDecimal.ONE, MAX_CALC_PLUS_ONE, bigDec("1.e+16"));
//
//        //first is 10
//        checkAdd(BigDecimal.TEN, BigDecimal.TEN, bigDec("20"));
//        checkAdd(BigDecimal.TEN, HUNDRED, bigDec("110"));
//        checkAdd(BigDecimal.TEN, THOUSAND, bigDec("1010"));
//        checkAdd(BigDecimal.TEN, MAX_CALC_MINUS_ONE, bigDec("1.000000000000001e+16"));
//        checkAdd(BigDecimal.TEN, MAX_CALC, bigDec("1.000000000000001e+16"));
//        checkAdd(BigDecimal.TEN, MAX_CALC_PLUS_ONE, bigDec("1.000000000000001e+16"));
//
//        //first is 100
//        checkAdd(HUNDRED, HUNDRED, bigDec("200"));
//        checkAdd(HUNDRED, THOUSAND, bigDec("1100"));
//        checkAdd(HUNDRED, MAX_CALC_MINUS_ONE, bigDec("1.00000000000001e+16"));
//        checkAdd(HUNDRED, MAX_CALC, bigDec("1.00000000000001e+16"));
//        checkAdd(HUNDRED, MAX_CALC_PLUS_ONE, bigDec("1.00000000000001e+16"));
//
//        //first is 1000
//        checkAdd(THOUSAND, THOUSAND, bigDec("2000"));
//        checkAdd(THOUSAND, MAX_CALC_MINUS_ONE, bigDec("1.0000000000001e+16"));
//        checkAdd(THOUSAND, MAX_CALC, bigDec("1.0000000000001e+16"));
//        checkAdd(THOUSAND, MAX_CALC_PLUS_ONE, bigDec("1.0000000000001e+16"));
//
//        //first is max calc value minus one
//        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, bigDec("2.e+16"));
//        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC, bigDec("2.e+16"));
//        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, bigDec("2.e+16"));
//
//        //first is max calc value
//        checkAdd(MAX_CALC, MAX_CALC, bigDec("2.e+16"));
//        checkAdd(MAX_CALC, MAX_CALC_PLUS_ONE, bigDec("2.e+16"));
//
//        //first is max calc value plus one
//        checkAdd(MAX_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, bigDec("2.e+16"));
//
//        //decimals only
//        //first is -9.99
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-19.98"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_AND_NINE_TENTH, bigDec("-19.89"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, bigDec("-10.99"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-9.990000000000001"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-10.98"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-10.08"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, bigDec("-10.89"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_TEN);
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-10.09"));
//
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_TENTH, bigDec("-9.89"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-9.98"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("-8.89"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("-8.98"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_TENTH, bigDec("-9.09"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, NEG_NINE_AND_NINE_TENTH);
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("-9"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-9.989999999999999"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("-8.99"));
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, NEG_NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, NEG_NINE_TENTH);
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, BigDecimal.ZERO);
//        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("-0.989999999999991"));
//
//        //first is -9.9
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINE_AND_NINE_TENTH, bigDec("-19.8"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_16_NINES, bigDec("-10.9"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-9.900000000000001"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-10.89"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINE_HUNDREDTH, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINE_TENTH, bigDec("-10.8"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ONE_HUNDREDTH, bigDec("-9.91"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ONE_TENTH, NEG_TEN);
//
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_ZERO, NEG_NINE_AND_NINE_TENTH);
//
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_TENTH, bigDec("-9.8"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_HUNDREDTH, bigDec("-9.89"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_AND_ONE_TENTH, bigDec("-8.8"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("-8.89"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_TENTH, bigDec("-9"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_HUNDREDTH, bigDec("-9.81"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("-8.91"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-9.899999999999999"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_16_NINES, bigDec("-8.9"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH, BigDecimal.ZERO);
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("-0.81"));
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("-0.899999999999991"));
//
//        //first is -0.9999999999999999
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, bigDec("-2"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-1.000000000000001"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.99"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, bigDec("-1.09"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, bigDec("-1.9"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE);
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, bigDec("-1.01"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, bigDec("-1.1"));
//
//        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_ZERO, NEG_ZERO_DOT_16_NINES);
//
//        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_TENTH, bigDec("-0.8999999999999999"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, bigDec("-0.9899999999999999"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9999999999999998"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_AND_ONE_TENTH, bigDec("0.1000000000000001"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_AND_ONE_HUNDREDTH, bigDec("0.0100000000000001"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_TENTH, bigDec("-0.0999999999999999"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, bigDec("-0.9099999999999999"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, bigDec("-0.0099999999999999"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.999999999999999"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, BigDecimal.ZERO);
//        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_AND_NINE_TENTH, bigDec("8.9"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_AND_NINE_HUNDREDTH, bigDec("8.09"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("8.99"));
//        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_DOT_14_ZEROS_NINE, bigDec("8.000000000000009"));
//
//        //first is -0.0000000000000009
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0000000000000018"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINETY_NINE_HUNDREDTH, bigDec("-0.9900000000000009"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINE_HUNDREDTH, bigDec("-0.0900000000000009"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINE_TENTH, bigDec("-0.9000000000000009"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.000000000000001"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ONE_HUNDREDTH, bigDec("-0.0100000000000009"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ONE_TENTH, bigDec("-0.1000000000000009"));
//
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_ZERO, NEG_ZERO_DOT_15_ZEROS_NINE);
//
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_TENTH, bigDec("0.0999999999999991"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_HUNDREDTH, bigDec("0.0099999999999991"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0000000000000008"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_AND_ONE_TENTH, bigDec("1.099999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_AND_ONE_HUNDREDTH, bigDec("1.009999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_TENTH, bigDec("0.8999999999999991"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_HUNDREDTH, bigDec("0.0899999999999991"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINETY_NINE_HUNDREDTH, bigDec("0.9899999999999991"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE, BigDecimal.ZERO);
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_NINES, bigDec("0.999999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_TENTH, bigDec("9.899999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, bigDec("9.089999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.989999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("9.000000000000008"));
//
//        //first is -0.99
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.98"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-1.08"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, bigDec("-1.89"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9900000000000001"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_ONE);
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-1.09"));
//
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINETY_NINE_HUNDREDTH);
//
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, bigDec("-0.89"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-0.98"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9899999999999999"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("0.11"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.02"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, NEG_NINE_HUNDREDTH);
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, NEG_NINE_TENTH);
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, BigDecimal.ZERO);
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.9899999999999991"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.0099999999999999"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("8.91"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.1"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9"));
//        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.010000000000009"));
//
//        //first is -0.09
//        checkAdd(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-0.18"));
//        checkAdd(NEG_NINE_HUNDREDTH, NEG_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0900000000000001"));
//        checkAdd(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_ONE_TENTH);
//        checkAdd(NEG_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-0.19"));
//
//        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINE_HUNDREDTH);
//
//        checkAdd(NEG_NINE_HUNDREDTH, ONE_TENTH, ONE_HUNDREDTH);
//        checkAdd(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-0.08"));
//        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0899999999999999"));
//        checkAdd(NEG_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, ONE_AND_ONE_HUNDREDTH);
//        checkAdd(NEG_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.92"));
//        checkAdd(NEG_NINE_HUNDREDTH, NINE_TENTH, bigDec("0.81"));
//        checkAdd(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, BigDecimal.ZERO);
//        checkAdd(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, NINE_TENTH);
//        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0899999999999991"));
//        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.9099999999999999"));
//        checkAdd(NEG_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.81"));
//        checkAdd(NEG_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9"));
//        checkAdd(NEG_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH);
//        checkAdd(NEG_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.910000000000009"));
//
//        //first is -0.9
//        checkAdd(NEG_NINE_TENTH, NEG_NINE_TENTH, bigDec("-1.8"));
//        checkAdd(NEG_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9000000000000001"));
//        checkAdd(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, bigDec("-0.91"));
//        checkAdd(NEG_NINE_TENTH, NEG_ONE_TENTH, NEG_ONE);
//
//        checkAdd(NEG_NINE_TENTH, ZERO_DOT_ZERO, NEG_NINE_TENTH);
//
//        checkAdd(NEG_NINE_TENTH, ONE_TENTH, bigDec("-0.8"));
//        checkAdd(NEG_NINE_TENTH, ONE_HUNDREDTH, bigDec("-0.89"));
//        checkAdd(NEG_NINE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.8999999999999999"));
//        checkAdd(NEG_NINE_TENTH, ONE_AND_ONE_TENTH, bigDec("0.2"));
//        checkAdd(NEG_NINE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.11"));
//        checkAdd(NEG_NINE_TENTH, NINE_TENTH, BigDecimal.ZERO);
//        checkAdd(NEG_NINE_TENTH, NINE_HUNDREDTH, bigDec("-0.81"));
//        checkAdd(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.8999999999999991"));
//        checkAdd(NEG_NINE_TENTH, ZERO_DOT_16_NINES, bigDec("0.0999999999999999"));
//        checkAdd(NEG_NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("9"));
//        checkAdd(NEG_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.19"));
//        checkAdd(NEG_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkAdd(NEG_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.100000000000009"));
//
//        //first is -0.0000000000000001
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0000000000000002"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE_HUNDREDTH, bigDec("-0.0100000000000001"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE_TENTH, bigDec("-0.1000000000000001"));
//
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_ZERO, NEG_ZERO_DOT_15_ZEROS_ONE);
//
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_TENTH, bigDec("0.0999999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_HUNDREDTH, bigDec("0.0099999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE, BigDecimal.ZERO);
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_TENTH, bigDec("0.8999999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_HUNDREDTH, bigDec("0.0899999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINETY_NINE_HUNDREDTH, bigDec("0.9899999999999999"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0000000000000008"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES, bigDec("0.9999999999999998"));
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);
//
//        //first is -0.01
//        checkAdd(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, bigDec("-0.02"));
//        checkAdd(NEG_ONE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-0.11"));
//
//        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_ZERO, NEG_ONE_HUNDREDTH);
//
//        checkAdd(NEG_ONE_HUNDREDTH, ONE_TENTH, NINE_HUNDREDTH);
//        checkAdd(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, BigDecimal.ZERO);
//        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0099999999999999"));
//        checkAdd(NEG_ONE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("1.09"));
//        checkAdd(NEG_ONE_HUNDREDTH, NINE_TENTH, bigDec("0.89"));
//        checkAdd(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, bigDec("0.08"));
//        checkAdd(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("0.98"));
//        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0099999999999991"));
//        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.9899999999999999"));
//        checkAdd(NEG_ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.89"));
//        checkAdd(NEG_ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.08"));
//        checkAdd(NEG_ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.98"));
//        checkAdd(NEG_ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.990000000000009"));
//
//        //first is -0.1
//        checkAdd(NEG_ONE_TENTH, NEG_ONE_TENTH, bigDec("-0.2"));
//
//        checkAdd(NEG_ONE_TENTH, ZERO_DOT_ZERO, NEG_ONE_TENTH);
//
//        checkAdd(NEG_ONE_TENTH, ONE_TENTH, BigDecimal.ZERO);
//        checkAdd(NEG_ONE_TENTH, ONE_HUNDREDTH, NEG_NINE_HUNDREDTH);
//        checkAdd(NEG_ONE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0999999999999999"));
//        checkAdd(NEG_ONE_TENTH, ONE_AND_ONE_TENTH, BigDecimal.ONE);
//        checkAdd(NEG_ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.91"));
//        checkAdd(NEG_ONE_TENTH, NINE_TENTH, bigDec("0.8"));
//        checkAdd(NEG_ONE_TENTH, NINE_HUNDREDTH, NEG_ONE_HUNDREDTH);
//        checkAdd(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("0.89"));
//        checkAdd(NEG_ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0999999999999991"));
//        checkAdd(NEG_ONE_TENTH, ZERO_DOT_16_NINES, bigDec("0.8999999999999999"));
//        checkAdd(NEG_ONE_TENTH, NINE_AND_NINE_TENTH, bigDec("9.8"));
//        checkAdd(NEG_ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.99"));
//        checkAdd(NEG_ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.89"));
//        checkAdd(NEG_ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.900000000000009"));
//
//        //first is 0.0
//        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_ZERO, BigDecimal.ZERO);
//
//        checkAdd(ZERO_DOT_ZERO, ONE_TENTH, ONE_TENTH);
//        checkAdd(ZERO_DOT_ZERO, ONE_HUNDREDTH, ONE_HUNDREDTH);
//        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE);
//        checkAdd(ZERO_DOT_ZERO, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkAdd(ZERO_DOT_ZERO, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
//        checkAdd(ZERO_DOT_ZERO, NINE_TENTH, NINE_TENTH);
//        checkAdd(ZERO_DOT_ZERO, NINE_HUNDREDTH, NINE_HUNDREDTH);
//        checkAdd(ZERO_DOT_ZERO, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
//        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE);
//        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_16_NINES, ZERO_DOT_16_NINES);
//        checkAdd(ZERO_DOT_ZERO, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkAdd(ZERO_DOT_ZERO, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkAdd(ZERO_DOT_ZERO, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(ZERO_DOT_ZERO, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);
//
//        //first is 0.1
//        checkAdd(ONE_TENTH, ONE_TENTH, bigDec("0.2"));
//        checkAdd(ONE_TENTH, ONE_HUNDREDTH, bigDec("0.11"));
//        checkAdd(ONE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("0.1000000000000001"));
//        checkAdd(ONE_TENTH, ONE_AND_ONE_TENTH, bigDec("1.2"));
//        checkAdd(ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("1.11"));
//        checkAdd(ONE_TENTH, NINE_TENTH, BigDecimal.ONE);
//        checkAdd(ONE_TENTH, NINE_HUNDREDTH, bigDec("0.19"));
//        checkAdd(ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("1.09"));
//        checkAdd(ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.1000000000000009"));
//        checkAdd(ONE_TENTH, ZERO_DOT_16_NINES, ONE_AND_ONE_TENTH);
//        checkAdd(ONE_TENTH, NINE_AND_NINE_TENTH, BigDecimal.TEN);
//        checkAdd(ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.19"));
//        checkAdd(ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.09"));
//        checkAdd(ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.100000000000009"));
//
//        //first is 0.01
//        checkAdd(ONE_HUNDREDTH, ONE_HUNDREDTH, bigDec("0.02"));
//        checkAdd(ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("0.0100000000000001"));
//        checkAdd(ONE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("1.11"));
//        checkAdd(ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("1.02"));
//        checkAdd(ONE_HUNDREDTH, NINE_TENTH, bigDec("0.91"));
//        checkAdd(ONE_HUNDREDTH, NINE_HUNDREDTH, ONE_TENTH);
//        checkAdd(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, BigDecimal.ONE);
//        checkAdd(ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0100000000000009"));
//        checkAdd(ONE_HUNDREDTH, ZERO_DOT_16_NINES, ONE_AND_ONE_HUNDREDTH);
//        checkAdd(ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.91"));
//        checkAdd(ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.1"));
//        checkAdd(ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, BigDecimal.TEN);
//        checkAdd(ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.010000000000009"));
//
//        //first is 0.0000000000000001
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE, bigDec("0.0000000000000002"));
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_TENTH, bigDec("0.9000000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_HUNDREDTH, bigDec("0.0900000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINETY_NINE_HUNDREDTH, bigDec("0.9900000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.000000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES, BigDecimal.ONE);
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);
//
//        //first is 1.1
//        checkAdd(ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH, bigDec("2.2"));
//        checkAdd(ONE_AND_ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("2.11"));
//        checkAdd(ONE_AND_ONE_TENTH, NINE_TENTH, bigDec("2"));
//        checkAdd(ONE_AND_ONE_TENTH, NINE_HUNDREDTH, bigDec("1.19"));
//        checkAdd(ONE_AND_ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("2.09"));
//        checkAdd(ONE_AND_ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("1.100000000000001"));
//        checkAdd(ONE_AND_ONE_TENTH, ZERO_DOT_16_NINES, bigDec("2.1"));
//        checkAdd(ONE_AND_ONE_TENTH, NINE_AND_NINE_TENTH, bigDec("11"));
//        checkAdd(ONE_AND_ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.19"));
//        checkAdd(ONE_AND_ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("11.09"));
//        checkAdd(ONE_AND_ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("10.10000000000001"));
//
//        //first is 1.01
//        checkAdd(ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("2.02"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_TENTH, bigDec("1.91"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_HUNDREDTH, ONE_AND_ONE_TENTH);
//        checkAdd(ONE_AND_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("2"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("1.010000000000001"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("2.01"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("10.91"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.1"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("11"));
//        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("10.01000000000001"));
//
//        //first is 0.9
//        checkAdd(NINE_TENTH, NINE_TENTH, bigDec("1.8"));
//        checkAdd(NINE_TENTH, NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
//        checkAdd(NINE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("1.89"));
//        checkAdd(NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.9000000000000009"));
//        checkAdd(NINE_TENTH, ZERO_DOT_16_NINES, bigDec("1.9"));
//        checkAdd(NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("10.8"));
//        checkAdd(NINE_TENTH, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.89"));
//        checkAdd(NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.900000000000009"));
//
//        //first is 0.09
//        checkAdd(NINE_HUNDREDTH, NINE_HUNDREDTH, bigDec("0.18"));
//        checkAdd(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("1.08"));
//        checkAdd(NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0900000000000009"));
//        checkAdd(NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("1.09"));
//        checkAdd(NINE_HUNDREDTH, NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkAdd(NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.18"));
//        checkAdd(NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.08"));
//        checkAdd(NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.090000000000009"));
//
//        //first is 0.99
//        checkAdd(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("1.98"));
//        checkAdd(NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.9900000000000009"));
//        checkAdd(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("1.99"));
//        checkAdd(NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("10.89"));
//        checkAdd(NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.08"));
//        checkAdd(NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.98"));
//        checkAdd(NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.990000000000009"));
//
//        //first is 0.0000000000000009
//        checkAdd(ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0000000000000018"));
//        checkAdd(ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_NINES, bigDec("1.000000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_TENTH, bigDec("9.900000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, bigDec("9.090000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.990000000000001"));
//        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("9.00000000000001"));
//
//        //first is 0.9999999999999999
//        checkAdd(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, bigDec("2"));
//        checkAdd(ZERO_DOT_16_NINES, NINE_AND_NINE_TENTH, bigDec("10.9"));
//        checkAdd(ZERO_DOT_16_NINES, NINE_AND_NINE_HUNDREDTH, bigDec("10.09"));
//        checkAdd(ZERO_DOT_16_NINES, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.99"));
//        checkAdd(ZERO_DOT_16_NINES, NINE_DOT_14_ZEROS_NINE, bigDec("10.00000000000001"));
//
//        //first is 9.9
//        checkAdd(NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("19.8"));
//        checkAdd(NINE_AND_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("18.99"));
//        checkAdd(NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.89"));
//        checkAdd(NINE_AND_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.90000000000001"));
//
//        //first is 9.09
//        checkAdd(NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("18.18"));
//        checkAdd(NINE_AND_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.08"));
//        checkAdd(NINE_AND_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.09000000000001"));
//
//        //first is 9.99
//        checkAdd(NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.98"));
//        checkAdd(NINE_AND_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.99000000000001"));
//
//        //first is 9.000000000000009
//        checkAdd(NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("18.00000000000002"));
//
//        //integer and decimal
//        //first is min calc value minus one
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-1.000000000000001e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_ZERO_DOT_16_NINES, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_NINE_TENTH, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, NEG_ONE_TENTH, bigDec("-1.e+16"));
//
//        checkAdd(MIN_CALC_MINUS_ONE, ZERO_DOT_ZERO, bigDec("-1.e+16"));
//
//        checkAdd(MIN_CALC_MINUS_ONE, ONE_TENTH, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, ZERO_DOT_15_ZEROS_ONE, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC_MINUS_ONE, ONE_AND_ONE_TENTH, MIN_CALC);
//        checkAdd(MIN_CALC_MINUS_ONE, NINE_TENTH, MIN_CALC);
//        checkAdd(MIN_CALC_MINUS_ONE, NINETY_NINE_HUNDREDTH, MIN_CALC);
//        checkAdd(MIN_CALC_MINUS_ONE, ZERO_DOT_16_NINES, MIN_CALC);
//        checkAdd(MIN_CALC_MINUS_ONE, NINE_AND_NINE_TENTH, bigDec("-9999999999999990"));
//        checkAdd(MIN_CALC_MINUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-9999999999999990"));
//
//        //first is min calc value
//        checkAdd(MIN_CALC, NEG_NINE_AND_NINE_TENTH, bigDec("-1.000000000000001e+16"));
//        checkAdd(MIN_CALC, NEG_ZERO_DOT_16_NINES, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC, NEG_NINE_TENTH, bigDec("-1.e+16"));
//        checkAdd(MIN_CALC, NEG_ZERO_DOT_15_ZEROS_ONE, MIN_CALC);
//        checkAdd(MIN_CALC, NEG_ONE_TENTH, MIN_CALC);
//
//        checkAdd(MIN_CALC, ZERO_DOT_ZERO, MIN_CALC);
//
//        checkAdd(MIN_CALC, ONE_TENTH, MIN_CALC);
//        checkAdd(MIN_CALC, ZERO_DOT_15_ZEROS_ONE, MIN_CALC);
//        checkAdd(MIN_CALC, ONE_AND_ONE_TENTH, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC, NINE_TENTH, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC, NINETY_NINE_HUNDREDTH, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC, ZERO_DOT_16_NINES, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC, NINE_AND_NINE_TENTH, bigDec("-9999999999999989"));
//        checkAdd(MIN_CALC, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-9999999999999989"));
//
//        //first is min calc value plus one
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-1.000000000000001e+16"));
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_ZERO_DOT_16_NINES, MIN_CALC);
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MIN_CALC);
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_NINE_TENTH, MIN_CALC);
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC_PLUS_ONE, NEG_ONE_TENTH, MIN_CALC_PLUS_ONE);
//
//        checkAdd(MIN_CALC_PLUS_ONE, ZERO_DOT_ZERO, MIN_CALC_PLUS_ONE);
//
//        checkAdd(MIN_CALC_PLUS_ONE, ONE_TENTH, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC_PLUS_ONE, ZERO_DOT_15_ZEROS_ONE, MIN_CALC_PLUS_ONE);
//        checkAdd(MIN_CALC_PLUS_ONE, ONE_AND_ONE_TENTH, bigDec("-9999999999999997"));
//        checkAdd(MIN_CALC_PLUS_ONE, NINE_TENTH, bigDec("-9999999999999997"));
//        checkAdd(MIN_CALC_PLUS_ONE, NINETY_NINE_HUNDREDTH, bigDec("-9999999999999997"));
//        checkAdd(MIN_CALC_PLUS_ONE, ZERO_DOT_16_NINES, bigDec("-9999999999999997"));
//        checkAdd(MIN_CALC_PLUS_ONE, NINE_AND_NINE_TENTH, bigDec("-9999999999999988"));
//        checkAdd(MIN_CALC_PLUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-9999999999999988"));
//
//        //first is -1
//        checkAdd(NEG_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-10.9"));
//        checkAdd(NEG_ONE, NEG_ZERO_DOT_16_NINES, bigDec("-2"));
//        checkAdd(NEG_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.99"));
//        checkAdd(NEG_ONE, NEG_NINE_TENTH, bigDec("-1.9"));
//        checkAdd(NEG_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE);
//        checkAdd(NEG_ONE, NEG_ONE_TENTH, bigDec("-1.1"));
//
//        checkAdd(NEG_ONE, ZERO_DOT_ZERO, NEG_ONE);
//
//        checkAdd(NEG_ONE, ONE_TENTH, NEG_NINE_TENTH);
//        checkAdd(NEG_ONE, ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_16_NINES);
//        checkAdd(NEG_ONE, ONE_AND_ONE_TENTH, ONE_TENTH);
//        checkAdd(NEG_ONE, NINE_TENTH, NEG_ONE_TENTH);
//        checkAdd(NEG_ONE, NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH);
//        checkAdd(NEG_ONE, ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_ONE);
//        checkAdd(NEG_ONE, NINE_AND_NINE_TENTH, bigDec("8.9"));
//        checkAdd(NEG_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("8.99"));
//
//        //first is 0
//        checkAdd(BigDecimal.ZERO, NEG_NINE_AND_NINE_TENTH, NEG_NINE_AND_NINE_TENTH);
//        checkAdd(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES);
//        checkAdd(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH);
//        checkAdd(BigDecimal.ZERO, NEG_NINE_TENTH, NEG_NINE_TENTH);
//        checkAdd(BigDecimal.ZERO, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE);
//        checkAdd(BigDecimal.ZERO, NEG_ONE_TENTH, NEG_ONE_TENTH);
//
//        checkAdd(BigDecimal.ZERO, ZERO_DOT_ZERO, BigDecimal.ZERO);
//
//        checkAdd(BigDecimal.ZERO, ONE_TENTH, ONE_TENTH);
//        checkAdd(BigDecimal.ZERO, ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE);
//        checkAdd(BigDecimal.ZERO, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkAdd(BigDecimal.ZERO, NINE_TENTH, NINE_TENTH);
//        checkAdd(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
//        checkAdd(BigDecimal.ZERO, ZERO_DOT_16_NINES, ZERO_DOT_16_NINES);
//        checkAdd(BigDecimal.ZERO, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkAdd(BigDecimal.ZERO, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//
//        //first is 1
//        checkAdd(BigDecimal.ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-8.9"));
//        checkAdd(BigDecimal.ONE, NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_ONE);
//        checkAdd(BigDecimal.ONE, NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH);
//        checkAdd(BigDecimal.ONE, NEG_NINE_TENTH, ONE_TENTH);
//        checkAdd(BigDecimal.ONE, NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES);
//        checkAdd(BigDecimal.ONE, NEG_ONE_TENTH, NINE_TENTH);
//
//        checkAdd(BigDecimal.ONE, ZERO_DOT_ZERO, BigDecimal.ONE);
//
//        checkAdd(BigDecimal.ONE, ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkAdd(BigDecimal.ONE, ZERO_DOT_15_ZEROS_ONE, BigDecimal.ONE);
//        checkAdd(BigDecimal.ONE, ONE_AND_ONE_TENTH, bigDec("2.1"));
//        checkAdd(BigDecimal.ONE, NINE_TENTH, bigDec("1.9"));
//        checkAdd(BigDecimal.ONE, NINETY_NINE_HUNDREDTH, bigDec("1.99"));
//        checkAdd(BigDecimal.ONE, ZERO_DOT_16_NINES, bigDec("2"));
//        checkAdd(BigDecimal.ONE, NINE_AND_NINE_TENTH, bigDec("10.9"));
//        checkAdd(BigDecimal.ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.99"));
//
//        //first is 10
//        checkAdd(BigDecimal.TEN, NEG_NINE_AND_NINE_TENTH, ONE_TENTH);
//        checkAdd(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, bigDec("9"));
//        checkAdd(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, bigDec("9.01"));
//        checkAdd(BigDecimal.TEN, NEG_NINE_TENTH, bigDec("9.1"));
//        checkAdd(BigDecimal.TEN, NEG_ZERO_DOT_15_ZEROS_ONE, BigDecimal.TEN);
//        checkAdd(BigDecimal.TEN, NEG_ONE_TENTH, NINE_AND_NINE_TENTH);
//
//        checkAdd(BigDecimal.TEN, ZERO_DOT_ZERO, BigDecimal.TEN);
//
//        checkAdd(BigDecimal.TEN, ONE_TENTH, bigDec("10.1"));
//        checkAdd(BigDecimal.TEN, ZERO_DOT_15_ZEROS_ONE, BigDecimal.TEN);
//        checkAdd(BigDecimal.TEN, ONE_AND_ONE_TENTH, bigDec("11.1"));
//        checkAdd(BigDecimal.TEN, NINE_TENTH, bigDec("10.9"));
//        checkAdd(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, bigDec("10.99"));
//        checkAdd(BigDecimal.TEN, ZERO_DOT_16_NINES, bigDec("11"));
//        checkAdd(BigDecimal.TEN, NINE_AND_NINE_TENTH, bigDec("19.9"));
//        checkAdd(BigDecimal.TEN, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.99"));
//
//        //first is 100
//        checkAdd(HUNDRED, NEG_NINE_AND_NINE_TENTH, bigDec("90.1"));
//        checkAdd(HUNDRED, NEG_ZERO_DOT_16_NINES, bigDec("99"));
//        checkAdd(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, bigDec("99.01"));
//        checkAdd(HUNDRED, NEG_NINE_TENTH, bigDec("99.1"));
//        checkAdd(HUNDRED, NEG_ZERO_DOT_15_ZEROS_ONE, HUNDRED);
//        checkAdd(HUNDRED, NEG_ONE_TENTH, bigDec("99.9"));
//
//        checkAdd(HUNDRED, ZERO_DOT_ZERO, HUNDRED);
//
//        checkAdd(HUNDRED, ONE_TENTH, bigDec("100.1"));
//        checkAdd(HUNDRED, ZERO_DOT_15_ZEROS_ONE, HUNDRED);
//        checkAdd(HUNDRED, ONE_AND_ONE_TENTH, bigDec("101.1"));
//        checkAdd(HUNDRED, NINE_TENTH, bigDec("100.9"));
//        checkAdd(HUNDRED, NINETY_NINE_HUNDREDTH, bigDec("100.99"));
//        checkAdd(HUNDRED, ZERO_DOT_16_NINES, bigDec("101"));
//        checkAdd(HUNDRED, NINE_AND_NINE_TENTH, bigDec("109.9"));
//        checkAdd(HUNDRED, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("109.99"));
//
//        //first is max calc value minus one
//        checkAdd(MAX_CALC_MINUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("9999999999999988"));
//        checkAdd(MAX_CALC_MINUS_ONE, NEG_ZERO_DOT_16_NINES, bigDec("9999999999999997"));
//        checkAdd(MAX_CALC_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("9999999999999997"));
//        checkAdd(MAX_CALC_MINUS_ONE, NEG_NINE_TENTH, bigDec("9999999999999997"));
//        checkAdd(MAX_CALC_MINUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, MAX_CALC_MINUS_ONE);
//        checkAdd(MAX_CALC_MINUS_ONE, NEG_ONE_TENTH, MAX_CALC_MINUS_ONE);
//
//        checkAdd(MAX_CALC_MINUS_ONE, ZERO_DOT_ZERO, MAX_CALC_MINUS_ONE);
//
//        checkAdd(MAX_CALC_MINUS_ONE, ONE_TENTH, MAX_CALC_MINUS_ONE);
//        checkAdd(MAX_CALC_MINUS_ONE, ZERO_DOT_15_ZEROS_ONE, MAX_CALC_MINUS_ONE);
//        checkAdd(MAX_CALC_MINUS_ONE, ONE_AND_ONE_TENTH,  MAX_CALC);
//        checkAdd(MAX_CALC_MINUS_ONE, NINE_TENTH,  MAX_CALC);
//        checkAdd(MAX_CALC_MINUS_ONE, NINETY_NINE_HUNDREDTH,  MAX_CALC);
//        checkAdd(MAX_CALC_MINUS_ONE, ZERO_DOT_16_NINES,  MAX_CALC);
//        checkAdd(MAX_CALC_MINUS_ONE, NINE_AND_NINE_TENTH, bigDec("1.000000000000001e+16"));
//        checkAdd(MAX_CALC_MINUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("1.000000000000001e+16"));
//
//        //first is max calc value
//        checkAdd(MAX_CALC, NEG_NINE_AND_NINE_TENTH, bigDec("9999999999999989"));
//        checkAdd(MAX_CALC, NEG_ZERO_DOT_16_NINES, MAX_CALC_MINUS_ONE);
//        checkAdd(MAX_CALC, NEG_NINETY_NINE_HUNDREDTH, MAX_CALC_MINUS_ONE);
//        checkAdd(MAX_CALC, NEG_NINE_TENTH, MAX_CALC_MINUS_ONE);
//        checkAdd(MAX_CALC, NEG_ZERO_DOT_15_ZEROS_ONE, MAX_CALC);
//        checkAdd(MAX_CALC, NEG_ONE_TENTH, MAX_CALC);
//
//        checkAdd(MAX_CALC, ZERO_DOT_ZERO, MAX_CALC);
//
//        checkAdd(MAX_CALC, ONE_TENTH, MAX_CALC);
//        checkAdd(MAX_CALC, ZERO_DOT_15_ZEROS_ONE, MAX_CALC);
//        checkAdd(MAX_CALC, ONE_AND_ONE_TENTH, bigDec("1.e+16"));
//        checkAdd(MAX_CALC, NINE_TENTH, bigDec("1.e+16"));
//        checkAdd(MAX_CALC, NINETY_NINE_HUNDREDTH, bigDec("1.e+16"));
//        checkAdd(MAX_CALC, ZERO_DOT_16_NINES, bigDec("1.e+16"));
//        checkAdd(MAX_CALC, NINE_AND_NINE_TENTH, bigDec("1.000000000000001e+16"));
//        checkAdd(MAX_CALC, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("1.000000000000001e+16"));
//
//        //first is max calc value plus one
//        checkAdd(MAX_CALC_PLUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("9999999999999990"));
//        checkAdd(MAX_CALC_PLUS_ONE, NEG_ZERO_DOT_16_NINES, bigDec("9999999999999999"));
//        checkAdd(MAX_CALC_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("9999999999999999"));
//        checkAdd(MAX_CALC_PLUS_ONE, NEG_NINE_TENTH, bigDec("9999999999999999"));
//        checkAdd(MAX_CALC_PLUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("1.e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, NEG_ONE_TENTH, bigDec("1.e+16"));
//
//        checkAdd(MAX_CALC_PLUS_ONE, ZERO_DOT_ZERO, bigDec("1.e+16"));
//
//        checkAdd(MAX_CALC_PLUS_ONE, ONE_TENTH, bigDec("1.e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, ZERO_DOT_15_ZEROS_ONE, bigDec("1.e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, ONE_AND_ONE_TENTH, bigDec("1.e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, NINE_TENTH, bigDec("1.e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, NINETY_NINE_HUNDREDTH, bigDec("1.e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, ZERO_DOT_16_NINES, bigDec("1.e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, NINE_AND_NINE_TENTH, bigDec("1.000000000000001e+16"));
//        checkAdd(MAX_CALC_PLUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("1.000000000000001e+16"));
//
//
//        //subtract operation tests
//        //integer values only
//        //first is min calc value minus one
//        checkSubtract(MIN_CALC_MINUS_ONE, MIN_CALC_MINUS_ONE, BigDecimal.ZERO);
//        checkSubtract(MIN_CALC_MINUS_ONE, MIN_CALC, NEG_ONE);
//        checkSubtract(MIN_CALC_MINUS_ONE, MIN_CALC_PLUS_ONE, bigDec("-2"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_THOUSAND, bigDec("-9999999999999000"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_HUNDRED, bigDec("-9999999999999900"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_TEN, bigDec("-9999999999999990"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_ONE, MIN_CALC);
//
//        checkSubtract(MIN_CALC_MINUS_ONE, BigDecimal.ZERO, bigDec("-1.e+16"));
//
//        checkSubtract(MIN_CALC_MINUS_ONE, BigDecimal.ONE, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, BigDecimal.TEN, bigDec("-1.000000000000001e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, HUNDRED, bigDec("-1.00000000000001e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, THOUSAND, bigDec("-1.0000000000001e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, bigDec("-2.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, MAX_CALC, bigDec("-2.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, bigDec("-2.e+16"));
//
//        //first is min calc value
//        checkSubtract(MIN_CALC, MIN_CALC, bigDec("-2.e+16"));
//        checkSubtract(MIN_CALC, MIN_CALC_PLUS_ONE, bigDec("-2.e+16"));
//        checkSubtract(MIN_CALC, NEG_THOUSAND, bigDec("-1.0000000000001e+16"));
//        checkSubtract(MIN_CALC, NEG_HUNDRED, bigDec("-1.00000000000001e+16"));
//        checkSubtract(MIN_CALC, NEG_TEN, bigDec("-1.000000000000001e+16"));
//        checkSubtract(MIN_CALC, NEG_ONE, bigDec("-1.e+16"));
//
//        checkSubtract(MIN_CALC, BigDecimal.ZERO, MIN_CALC);
//
//        checkSubtract(MIN_CALC, BigDecimal.ONE, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC, BigDecimal.TEN, bigDec("-9999999999999989"));
//        checkSubtract(MIN_CALC, HUNDRED, bigDec("-9999999999999899"));
//        checkSubtract(MIN_CALC, THOUSAND, bigDec("-9999999999998999"));
//        checkSubtract(MIN_CALC, MAX_CALC_MINUS_ONE, NEG_ONE);
//        checkSubtract(MIN_CALC, MAX_CALC, BigDecimal.ZERO);
//        checkSubtract(MIN_CALC, MAX_CALC_PLUS_ONE, BigDecimal.ONE);
//
//        //first is min calc value plus one
//        checkSubtract(MIN_CALC_PLUS_ONE, MIN_CALC_PLUS_ONE, bigDec("-2.e+16"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_THOUSAND, bigDec("-1.0000000000001e+16"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_HUNDRED, bigDec("-1.00000000000001e+16"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_TEN, bigDec("-1.000000000000001e+16"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_ONE, MIN_CALC);
//
//        checkSubtract(MIN_CALC_PLUS_ONE, BigDecimal.ZERO, MIN_CALC_PLUS_ONE);
//
//        checkSubtract(MIN_CALC_PLUS_ONE, BigDecimal.ONE, bigDec("-9999999999999997"));
//        checkSubtract(MIN_CALC_PLUS_ONE, BigDecimal.TEN, bigDec("-9999999999999988"));
//        checkSubtract(MIN_CALC_PLUS_ONE, HUNDRED, bigDec("-9999999999999898"));
//        checkSubtract(MIN_CALC_PLUS_ONE, THOUSAND, bigDec("-9999999999998998"));
//        checkSubtract(MIN_CALC_PLUS_ONE, MAX_CALC_MINUS_ONE, BigDecimal.ZERO);
//        checkSubtract(MIN_CALC_PLUS_ONE, MAX_CALC, BigDecimal.ONE);
//        checkSubtract(MIN_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, bigDec("2"));
//
//        //first is -1000
//        checkSubtract(NEG_THOUSAND, NEG_THOUSAND, bigDec("-2000"));
//        checkSubtract(NEG_THOUSAND, NEG_HUNDRED, bigDec("-1100"));
//        checkSubtract(NEG_THOUSAND, NEG_TEN, bigDec("-1010"));
//        checkSubtract(NEG_THOUSAND, NEG_ONE, bigDec("-1001"));
//
//        checkSubtract(NEG_THOUSAND, BigDecimal.ZERO, NEG_THOUSAND);
//
//        checkSubtract(NEG_THOUSAND, BigDecimal.ONE, bigDec("-999"));
//        checkSubtract(NEG_THOUSAND, BigDecimal.TEN, bigDec("-990"));
//        checkSubtract(NEG_THOUSAND, HUNDRED, bigDec("-900"));
//        checkSubtract(NEG_THOUSAND, THOUSAND, BigDecimal.ZERO);
//        checkSubtract(NEG_THOUSAND, MAX_CALC_MINUS_ONE, bigDec("9999999999998998"));
//        checkSubtract(NEG_THOUSAND, MAX_CALC, bigDec("9999999999998999"));
//        checkSubtract(NEG_THOUSAND, MAX_CALC_PLUS_ONE, bigDec("9999999999999000"));
//
//        //first is -100
//        checkSubtract(NEG_HUNDRED, NEG_HUNDRED, bigDec("-200"));
//        checkSubtract(NEG_HUNDRED, NEG_TEN, bigDec("-110"));
//        checkSubtract(NEG_HUNDRED, NEG_ONE, bigDec("-101"));
//
//        checkSubtract(NEG_HUNDRED, BigDecimal.ZERO, NEG_HUNDRED);
//
//        checkSubtract(NEG_HUNDRED, BigDecimal.ONE, bigDec("-99"));
//        checkSubtract(NEG_HUNDRED, BigDecimal.TEN, bigDec("-90"));
//        checkSubtract(NEG_HUNDRED, HUNDRED, BigDecimal.ZERO);
//        checkSubtract(NEG_HUNDRED, THOUSAND, bigDec("900"));
//        checkSubtract(NEG_HUNDRED, MAX_CALC_MINUS_ONE, bigDec("9999999999999898"));
//        checkSubtract(NEG_HUNDRED, MAX_CALC, bigDec("9999999999999899"));
//        checkSubtract(NEG_HUNDRED, MAX_CALC_PLUS_ONE, bigDec("9999999999999900"));
//
//        //first is -10
//        checkSubtract(NEG_TEN, NEG_TEN, bigDec("-20"));
//        checkSubtract(NEG_TEN, NEG_ONE, bigDec("-11"));
//
//        checkSubtract(NEG_TEN, BigDecimal.ZERO, NEG_TEN);
//
//        checkSubtract(NEG_TEN, BigDecimal.ONE, bigDec("-9"));
//        checkSubtract(NEG_TEN, BigDecimal.TEN, BigDecimal.ZERO);
//        checkSubtract(NEG_TEN, HUNDRED, bigDec("90"));
//        checkSubtract(NEG_TEN, THOUSAND, bigDec("990"));
//        checkSubtract(NEG_TEN, MAX_CALC_MINUS_ONE, bigDec("9999999999999988"));
//        checkSubtract(NEG_TEN, MAX_CALC, bigDec("9999999999999989"));
//        checkSubtract(NEG_TEN, MAX_CALC_PLUS_ONE, bigDec("9999999999999990"));
//
//        //first is -1
//        checkSubtract(NEG_ONE, NEG_ONE, bigDec("-2"));
//
//        checkSubtract(NEG_ONE, BigDecimal.ZERO, NEG_ONE);
//
//        checkSubtract(NEG_ONE, BigDecimal.ONE, BigDecimal.ZERO);
//        checkSubtract(NEG_ONE, BigDecimal.TEN, bigDec("9"));
//        checkSubtract(NEG_ONE, HUNDRED, bigDec("99"));
//        checkSubtract(NEG_ONE, THOUSAND, bigDec("999"));
//        checkSubtract(NEG_ONE, MAX_CALC_MINUS_ONE, bigDec("9999999999999997"));
//        checkSubtract(NEG_ONE, MAX_CALC, MAX_CALC_MINUS_ONE);
//        checkSubtract(NEG_ONE, MAX_CALC_PLUS_ONE, MAX_CALC);
//
//        //first is 0
//        checkSubtract(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
//
//        checkSubtract(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE);
//        checkSubtract(BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
//        checkSubtract(BigDecimal.ZERO, HUNDRED, HUNDRED);
//        checkSubtract(BigDecimal.ZERO, THOUSAND, THOUSAND);
//        checkSubtract(BigDecimal.ZERO, MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE);
//        checkSubtract(BigDecimal.ZERO, MAX_CALC, MAX_CALC);
//        checkSubtract(BigDecimal.ZERO, MAX_CALC_PLUS_ONE, bigDec("1.e+16"));
//
//        //first is 1
//        checkSubtract(BigDecimal.ONE, BigDecimal.ONE, bigDec("2"));
//        checkSubtract(BigDecimal.ONE, BigDecimal.TEN, bigDec("11"));
//        checkSubtract(BigDecimal.ONE, HUNDRED, bigDec("101"));
//        checkSubtract(BigDecimal.ONE, THOUSAND, bigDec("1001"));
//        checkSubtract(BigDecimal.ONE, MAX_CALC_MINUS_ONE, MAX_CALC);
//        checkSubtract(BigDecimal.ONE, MAX_CALC, bigDec("1.e+16"));
//        checkSubtract(BigDecimal.ONE, MAX_CALC_PLUS_ONE, bigDec("1.e+16"));
//
//        //first is 10
//        checkSubtract(BigDecimal.TEN, BigDecimal.TEN, bigDec("20"));
//        checkSubtract(BigDecimal.TEN, HUNDRED, bigDec("110"));
//        checkSubtract(BigDecimal.TEN, THOUSAND, bigDec("1010"));
//        checkSubtract(BigDecimal.TEN, MAX_CALC_MINUS_ONE, bigDec("1.000000000000001e+16"));
//        checkSubtract(BigDecimal.TEN, MAX_CALC, bigDec("1.000000000000001e+16"));
//        checkSubtract(BigDecimal.TEN, MAX_CALC_PLUS_ONE, bigDec("1.000000000000001e+16"));
//
//        //first is 100
//        checkSubtract(HUNDRED, HUNDRED, bigDec("200"));
//        checkSubtract(HUNDRED, THOUSAND, bigDec("1100"));
//        checkSubtract(HUNDRED, MAX_CALC_MINUS_ONE, bigDec("1.00000000000001e+16"));
//        checkSubtract(HUNDRED, MAX_CALC, bigDec("1.00000000000001e+16"));
//        checkSubtract(HUNDRED, MAX_CALC_PLUS_ONE, bigDec("1.00000000000001e+16"));
//
//        //first is 1000
//        checkSubtract(THOUSAND, THOUSAND, bigDec("2000"));
//        checkSubtract(THOUSAND, MAX_CALC_MINUS_ONE, bigDec("1.0000000000001e+16"));
//        checkSubtract(THOUSAND, MAX_CALC, bigDec("1.0000000000001e+16"));
//        checkSubtract(THOUSAND, MAX_CALC_PLUS_ONE, bigDec("1.0000000000001e+16"));
//
//        //first is max calc value minus one
//        checkSubtract(MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, bigDec("2.e+16"));
//        checkSubtract(MAX_CALC_MINUS_ONE, MAX_CALC, bigDec("2.e+16"));
//        checkSubtract(MAX_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, bigDec("2.e+16"));
//
//        //first is max calc value
//        checkSubtract(MAX_CALC, MAX_CALC, bigDec("2.e+16"));
//        checkSubtract(MAX_CALC, MAX_CALC_PLUS_ONE, bigDec("2.e+16"));
//
//        //first is max calc value plus one
//        checkSubtract(MAX_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, bigDec("2.e+16"));
//
//        //decimals only
//        //first is -9.99
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-19.98"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_AND_NINE_TENTH, bigDec("-19.89"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, bigDec("-10.99"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-9.990000000000001"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-10.98"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-10.08"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, bigDec("-10.89"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_TEN);
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-10.09"));
//
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_TENTH, bigDec("-9.89"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-9.98"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("-8.89"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("-8.98"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_TENTH, bigDec("-9.09"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, NEG_NINE_AND_NINE_TENTH);
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("-9"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-9.989999999999999"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("-8.99"));
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, NEG_NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, NEG_NINE_TENTH);
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, BigDecimal.ZERO);
//        checkSubtract(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("-0.989999999999991"));
//
//        //first is -9.9
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_NINE_AND_NINE_TENTH, bigDec("-19.8"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_16_NINES, bigDec("-10.9"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-9.900000000000001"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-10.89"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_NINE_HUNDREDTH, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_NINE_TENTH, bigDec("-10.8"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_ONE_HUNDREDTH, bigDec("-9.91"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NEG_ONE_TENTH, NEG_TEN);
//
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_ZERO, NEG_NINE_AND_NINE_TENTH);
//
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ONE_TENTH, bigDec("-9.8"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ONE_HUNDREDTH, bigDec("-9.89"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ONE_AND_ONE_TENTH, bigDec("-8.8"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("-8.89"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NINE_TENTH, bigDec("-9"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NINE_HUNDREDTH, bigDec("-9.81"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("-8.91"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-9.899999999999999"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_16_NINES, bigDec("-8.9"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH, BigDecimal.ZERO);
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("-0.81"));
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_AND_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("-0.899999999999991"));
//
//        //first is -0.9999999999999999
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, bigDec("-2"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-1.000000000000001"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.99"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, bigDec("-1.09"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, bigDec("-1.9"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE);
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, bigDec("-1.01"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, bigDec("-1.1"));
//
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ZERO_DOT_ZERO, NEG_ZERO_DOT_16_NINES);
//
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ONE_TENTH, bigDec("-0.8999999999999999"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, bigDec("-0.9899999999999999"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9999999999999998"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ONE_AND_ONE_TENTH, bigDec("0.1000000000000001"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ONE_AND_ONE_HUNDREDTH, bigDec("0.0100000000000001"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NINE_TENTH, bigDec("-0.0999999999999999"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, bigDec("-0.9099999999999999"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, bigDec("-0.0099999999999999"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.999999999999999"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, BigDecimal.ZERO);
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NINE_AND_NINE_TENTH, bigDec("8.9"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NINE_AND_NINE_HUNDREDTH, bigDec("8.09"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("8.99"));
//        checkSubtract(NEG_ZERO_DOT_16_NINES, NINE_DOT_14_ZEROS_NINE, bigDec("8.000000000000009"));
//
//        //first is -0.0000000000000009
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0000000000000018"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINETY_NINE_HUNDREDTH, bigDec("-0.9900000000000009"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINE_HUNDREDTH, bigDec("-0.0900000000000009"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINE_TENTH, bigDec("-0.9000000000000009"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.000000000000001"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ONE_HUNDREDTH, bigDec("-0.0100000000000009"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ONE_TENTH, bigDec("-0.1000000000000009"));
//
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_ZERO, NEG_ZERO_DOT_15_ZEROS_NINE);
//
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_TENTH, bigDec("0.0999999999999991"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_HUNDREDTH, bigDec("0.0099999999999991"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0000000000000008"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_AND_ONE_TENTH, bigDec("1.099999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_AND_ONE_HUNDREDTH, bigDec("1.009999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_TENTH, bigDec("0.8999999999999991"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_HUNDREDTH, bigDec("0.0899999999999991"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NINETY_NINE_HUNDREDTH, bigDec("0.9899999999999991"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE, BigDecimal.ZERO);
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_NINES, bigDec("0.999999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_TENTH, bigDec("9.899999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, bigDec("9.089999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.989999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("9.000000000000008"));
//
//        //first is -0.99
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.98"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-1.08"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, bigDec("-1.89"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9900000000000001"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_ONE);
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-1.09"));
//
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINETY_NINE_HUNDREDTH);
//
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, bigDec("-0.89"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-0.98"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9899999999999999"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("0.11"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.02"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, NEG_NINE_HUNDREDTH);
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, NEG_NINE_TENTH);
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, BigDecimal.ZERO);
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.9899999999999991"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.0099999999999999"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("8.91"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.1"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9"));
//        checkSubtract(NEG_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.010000000000009"));
//
//        //first is -0.09
//        checkSubtract(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-0.18"));
//        checkSubtract(NEG_NINE_HUNDREDTH, NEG_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0900000000000001"));
//        checkSubtract(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_ONE_TENTH);
//        checkSubtract(NEG_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-0.19"));
//
//        checkSubtract(NEG_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINE_HUNDREDTH);
//
//        checkSubtract(NEG_NINE_HUNDREDTH, ONE_TENTH, ONE_HUNDREDTH);
//        checkSubtract(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-0.08"));
//        checkSubtract(NEG_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0899999999999999"));
//        checkSubtract(NEG_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, ONE_AND_ONE_HUNDREDTH);
//        checkSubtract(NEG_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.92"));
//        checkSubtract(NEG_NINE_HUNDREDTH, NINE_TENTH, bigDec("0.81"));
//        checkSubtract(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, BigDecimal.ZERO);
//        checkSubtract(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, NINE_TENTH);
//        checkSubtract(NEG_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0899999999999991"));
//        checkSubtract(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.9099999999999999"));
//        checkSubtract(NEG_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.81"));
//        checkSubtract(NEG_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9"));
//        checkSubtract(NEG_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH);
//        checkSubtract(NEG_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.910000000000009"));
//
//        //first is -0.9
//        checkSubtract(NEG_NINE_TENTH, NEG_NINE_TENTH, bigDec("-1.8"));
//        checkSubtract(NEG_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9000000000000001"));
//        checkSubtract(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, bigDec("-0.91"));
//        checkSubtract(NEG_NINE_TENTH, NEG_ONE_TENTH, NEG_ONE);
//
//        checkSubtract(NEG_NINE_TENTH, ZERO_DOT_ZERO, NEG_NINE_TENTH);
//
//        checkSubtract(NEG_NINE_TENTH, ONE_TENTH, bigDec("-0.8"));
//        checkSubtract(NEG_NINE_TENTH, ONE_HUNDREDTH, bigDec("-0.89"));
//        checkSubtract(NEG_NINE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.8999999999999999"));
//        checkSubtract(NEG_NINE_TENTH, ONE_AND_ONE_TENTH, bigDec("0.2"));
//        checkSubtract(NEG_NINE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.11"));
//        checkSubtract(NEG_NINE_TENTH, NINE_TENTH, BigDecimal.ZERO);
//        checkSubtract(NEG_NINE_TENTH, NINE_HUNDREDTH, bigDec("-0.81"));
//        checkSubtract(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.8999999999999991"));
//        checkSubtract(NEG_NINE_TENTH, ZERO_DOT_16_NINES, bigDec("0.0999999999999999"));
//        checkSubtract(NEG_NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("9"));
//        checkSubtract(NEG_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.19"));
//        checkSubtract(NEG_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkSubtract(NEG_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.100000000000009"));
//
//        //first is -0.0000000000000001
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0000000000000002"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE_HUNDREDTH, bigDec("-0.0100000000000001"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE_TENTH, bigDec("-0.1000000000000001"));
//
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_ZERO, NEG_ZERO_DOT_15_ZEROS_ONE);
//
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_TENTH, bigDec("0.0999999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_HUNDREDTH, bigDec("0.0099999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE, BigDecimal.ZERO);
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_TENTH, bigDec("0.8999999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_HUNDREDTH, bigDec("0.0899999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NINETY_NINE_HUNDREDTH, bigDec("0.9899999999999999"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0000000000000008"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES, bigDec("0.9999999999999998"));
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);
//
//        //first is -0.01
//        checkSubtract(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, bigDec("-0.02"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-0.11"));
//
//        checkSubtract(NEG_ONE_HUNDREDTH, ZERO_DOT_ZERO, NEG_ONE_HUNDREDTH);
//
//        checkSubtract(NEG_ONE_HUNDREDTH, ONE_TENTH, NINE_HUNDREDTH);
//        checkSubtract(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, BigDecimal.ZERO);
//        checkSubtract(NEG_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0099999999999999"));
//        checkSubtract(NEG_ONE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("1.09"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NINE_TENTH, bigDec("0.89"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, bigDec("0.08"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("0.98"));
//        checkSubtract(NEG_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0099999999999991"));
//        checkSubtract(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.9899999999999999"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.89"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.08"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.98"));
//        checkSubtract(NEG_ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.990000000000009"));
//
//        //first is -0.1
//        checkSubtract(NEG_ONE_TENTH, NEG_ONE_TENTH, bigDec("-0.2"));
//
//        checkSubtract(NEG_ONE_TENTH, ZERO_DOT_ZERO, NEG_ONE_TENTH);
//
//        checkSubtract(NEG_ONE_TENTH, ONE_TENTH, BigDecimal.ZERO);
//        checkSubtract(NEG_ONE_TENTH, ONE_HUNDREDTH, NEG_NINE_HUNDREDTH);
//        checkSubtract(NEG_ONE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0999999999999999"));
//        checkSubtract(NEG_ONE_TENTH, ONE_AND_ONE_TENTH, BigDecimal.ONE);
//        checkSubtract(NEG_ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.91"));
//        checkSubtract(NEG_ONE_TENTH, NINE_TENTH, bigDec("0.8"));
//        checkSubtract(NEG_ONE_TENTH, NINE_HUNDREDTH, NEG_ONE_HUNDREDTH);
//        checkSubtract(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("0.89"));
//        checkSubtract(NEG_ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0999999999999991"));
//        checkSubtract(NEG_ONE_TENTH, ZERO_DOT_16_NINES, bigDec("0.8999999999999999"));
//        checkSubtract(NEG_ONE_TENTH, NINE_AND_NINE_TENTH, bigDec("9.8"));
//        checkSubtract(NEG_ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.99"));
//        checkSubtract(NEG_ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.89"));
//        checkSubtract(NEG_ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.900000000000009"));
//
//        //first is 0.0
//        checkSubtract(ZERO_DOT_ZERO, ZERO_DOT_ZERO, BigDecimal.ZERO);
//
//        checkSubtract(ZERO_DOT_ZERO, ONE_TENTH, ONE_TENTH);
//        checkSubtract(ZERO_DOT_ZERO, ONE_HUNDREDTH, ONE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_ZERO, ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE);
//        checkSubtract(ZERO_DOT_ZERO, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkSubtract(ZERO_DOT_ZERO, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_ZERO, NINE_TENTH, NINE_TENTH);
//        checkSubtract(ZERO_DOT_ZERO, NINE_HUNDREDTH, NINE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_ZERO, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_ZERO, ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE);
//        checkSubtract(ZERO_DOT_ZERO, ZERO_DOT_16_NINES, ZERO_DOT_16_NINES);
//        checkSubtract(ZERO_DOT_ZERO, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkSubtract(ZERO_DOT_ZERO, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_ZERO, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_ZERO, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);
//
//        //first is 0.1
//        checkSubtract(ONE_TENTH, ONE_TENTH, bigDec("0.2"));
//        checkSubtract(ONE_TENTH, ONE_HUNDREDTH, bigDec("0.11"));
//        checkSubtract(ONE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("0.1000000000000001"));
//        checkSubtract(ONE_TENTH, ONE_AND_ONE_TENTH, bigDec("1.2"));
//        checkSubtract(ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("1.11"));
//        checkSubtract(ONE_TENTH, NINE_TENTH, BigDecimal.ONE);
//        checkSubtract(ONE_TENTH, NINE_HUNDREDTH, bigDec("0.19"));
//        checkSubtract(ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("1.09"));
//        checkSubtract(ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.1000000000000009"));
//        checkSubtract(ONE_TENTH, ZERO_DOT_16_NINES, ONE_AND_ONE_TENTH);
//        checkSubtract(ONE_TENTH, NINE_AND_NINE_TENTH, BigDecimal.TEN);
//        checkSubtract(ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.19"));
//        checkSubtract(ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.09"));
//        checkSubtract(ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.100000000000009"));
//
//        //first is 0.01
//        checkSubtract(ONE_HUNDREDTH, ONE_HUNDREDTH, bigDec("0.02"));
//        checkSubtract(ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("0.0100000000000001"));
//        checkSubtract(ONE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("1.11"));
//        checkSubtract(ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("1.02"));
//        checkSubtract(ONE_HUNDREDTH, NINE_TENTH, bigDec("0.91"));
//        checkSubtract(ONE_HUNDREDTH, NINE_HUNDREDTH, ONE_TENTH);
//        checkSubtract(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, BigDecimal.ONE);
//        checkSubtract(ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0100000000000009"));
//        checkSubtract(ONE_HUNDREDTH, ZERO_DOT_16_NINES, ONE_AND_ONE_HUNDREDTH);
//        checkSubtract(ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.91"));
//        checkSubtract(ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.1"));
//        checkSubtract(ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, BigDecimal.TEN);
//        checkSubtract(ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.010000000000009"));
//
//        //first is 0.0000000000000001
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE, bigDec("0.0000000000000002"));
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, NINE_TENTH, bigDec("0.9000000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, NINE_HUNDREDTH, bigDec("0.0900000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, NINETY_NINE_HUNDREDTH, bigDec("0.9900000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.000000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES, BigDecimal.ONE);
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(ZERO_DOT_15_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);
//
//        //first is 1.1
//        checkSubtract(ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH, bigDec("2.2"));
//        checkSubtract(ONE_AND_ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("2.11"));
//        checkSubtract(ONE_AND_ONE_TENTH, NINE_TENTH, bigDec("2"));
//        checkSubtract(ONE_AND_ONE_TENTH, NINE_HUNDREDTH, bigDec("1.19"));
//        checkSubtract(ONE_AND_ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("2.09"));
//        checkSubtract(ONE_AND_ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("1.100000000000001"));
//        checkSubtract(ONE_AND_ONE_TENTH, ZERO_DOT_16_NINES, bigDec("2.1"));
//        checkSubtract(ONE_AND_ONE_TENTH, NINE_AND_NINE_TENTH, bigDec("11"));
//        checkSubtract(ONE_AND_ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.19"));
//        checkSubtract(ONE_AND_ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("11.09"));
//        checkSubtract(ONE_AND_ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("10.10000000000001"));
//
//        //first is 1.01
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("2.02"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, NINE_TENTH, bigDec("1.91"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, NINE_HUNDREDTH, ONE_AND_ONE_TENTH);
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("2"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("1.010000000000001"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("2.01"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("10.91"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.1"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("11"));
//        checkSubtract(ONE_AND_ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("10.01000000000001"));
//
//        //first is 0.9
//        checkSubtract(NINE_TENTH, NINE_TENTH, bigDec("1.8"));
//        checkSubtract(NINE_TENTH, NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
//        checkSubtract(NINE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("1.89"));
//        checkSubtract(NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.9000000000000009"));
//        checkSubtract(NINE_TENTH, ZERO_DOT_16_NINES, bigDec("1.9"));
//        checkSubtract(NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("10.8"));
//        checkSubtract(NINE_TENTH, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.89"));
//        checkSubtract(NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.900000000000009"));
//
//        //first is 0.09
//        checkSubtract(NINE_HUNDREDTH, NINE_HUNDREDTH, bigDec("0.18"));
//        checkSubtract(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("1.08"));
//        checkSubtract(NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0900000000000009"));
//        checkSubtract(NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("1.09"));
//        checkSubtract(NINE_HUNDREDTH, NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//        checkSubtract(NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.18"));
//        checkSubtract(NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.08"));
//        checkSubtract(NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.090000000000009"));
//
//        //first is 0.99
//        checkSubtract(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("1.98"));
//        checkSubtract(NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.9900000000000009"));
//        checkSubtract(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("1.99"));
//        checkSubtract(NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("10.89"));
//        checkSubtract(NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.08"));
//        checkSubtract(NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.98"));
//        checkSubtract(NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.990000000000009"));
//
//        //first is 0.0000000000000009
//        checkSubtract(ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0000000000000018"));
//        checkSubtract(ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_NINES, bigDec("1.000000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_TENTH, bigDec("9.900000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, bigDec("9.090000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.990000000000001"));
//        checkSubtract(ZERO_DOT_15_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("9.00000000000001"));
//
//        //first is 0.9999999999999999
//        checkSubtract(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, bigDec("2"));
//        checkSubtract(ZERO_DOT_16_NINES, NINE_AND_NINE_TENTH, bigDec("10.9"));
//        checkSubtract(ZERO_DOT_16_NINES, NINE_AND_NINE_HUNDREDTH, bigDec("10.09"));
//        checkSubtract(ZERO_DOT_16_NINES, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.99"));
//        checkSubtract(ZERO_DOT_16_NINES, NINE_DOT_14_ZEROS_NINE, bigDec("10.00000000000001"));
//
//        //first is 9.9
//        checkSubtract(NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("19.8"));
//        checkSubtract(NINE_AND_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("18.99"));
//        checkSubtract(NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.89"));
//        checkSubtract(NINE_AND_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.90000000000001"));
//
//        //first is 9.09
//        checkSubtract(NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("18.18"));
//        checkSubtract(NINE_AND_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.08"));
//        checkSubtract(NINE_AND_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.09000000000001"));
//
//        //first is 9.99
//        checkSubtract(NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.98"));
//        checkSubtract(NINE_AND_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.99000000000001"));
//
//        //first is 9.000000000000009
//        checkSubtract(NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("18.00000000000002"));
//
//        //integer and decimal
//        //first is min calc value minus one
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-1.000000000000001e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_ZERO_DOT_16_NINES, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_NINE_TENTH, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NEG_ONE_TENTH, bigDec("-1.e+16"));
//
//        checkSubtract(MIN_CALC_MINUS_ONE, ZERO_DOT_ZERO, bigDec("-1.e+16"));
//
//        checkSubtract(MIN_CALC_MINUS_ONE, ONE_TENTH, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, ZERO_DOT_15_ZEROS_ONE, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC_MINUS_ONE, ONE_AND_ONE_TENTH, MIN_CALC);
//        checkSubtract(MIN_CALC_MINUS_ONE, NINE_TENTH, MIN_CALC);
//        checkSubtract(MIN_CALC_MINUS_ONE, NINETY_NINE_HUNDREDTH, MIN_CALC);
//        checkSubtract(MIN_CALC_MINUS_ONE, ZERO_DOT_16_NINES, MIN_CALC);
//        checkSubtract(MIN_CALC_MINUS_ONE, NINE_AND_NINE_TENTH, bigDec("-9999999999999990"));
//        checkSubtract(MIN_CALC_MINUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-9999999999999990"));
//
//        //first is min calc value
//        checkSubtract(MIN_CALC, NEG_NINE_AND_NINE_TENTH, bigDec("-1.000000000000001e+16"));
//        checkSubtract(MIN_CALC, NEG_ZERO_DOT_16_NINES, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC, NEG_NINE_TENTH, bigDec("-1.e+16"));
//        checkSubtract(MIN_CALC, NEG_ZERO_DOT_15_ZEROS_ONE, MIN_CALC);
//        checkSubtract(MIN_CALC, NEG_ONE_TENTH, MIN_CALC);
//
//        checkSubtract(MIN_CALC, ZERO_DOT_ZERO, MIN_CALC);
//
//        checkSubtract(MIN_CALC, ONE_TENTH, MIN_CALC);
//        checkSubtract(MIN_CALC, ZERO_DOT_15_ZEROS_ONE, MIN_CALC);
//        checkSubtract(MIN_CALC, ONE_AND_ONE_TENTH, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC, NINE_TENTH, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC, NINETY_NINE_HUNDREDTH, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC, ZERO_DOT_16_NINES, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC, NINE_AND_NINE_TENTH, bigDec("-9999999999999989"));
//        checkSubtract(MIN_CALC, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-9999999999999989"));
//
//        //first is min calc value plus one
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-1.000000000000001e+16"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_ZERO_DOT_16_NINES, MIN_CALC);
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MIN_CALC);
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_NINE_TENTH, MIN_CALC);
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC_PLUS_ONE, NEG_ONE_TENTH, MIN_CALC_PLUS_ONE);
//
//        checkSubtract(MIN_CALC_PLUS_ONE, ZERO_DOT_ZERO, MIN_CALC_PLUS_ONE);
//
//        checkSubtract(MIN_CALC_PLUS_ONE, ONE_TENTH, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC_PLUS_ONE, ZERO_DOT_15_ZEROS_ONE, MIN_CALC_PLUS_ONE);
//        checkSubtract(MIN_CALC_PLUS_ONE, ONE_AND_ONE_TENTH, bigDec("-9999999999999997"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NINE_TENTH, bigDec("-9999999999999997"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NINETY_NINE_HUNDREDTH, bigDec("-9999999999999997"));
//        checkSubtract(MIN_CALC_PLUS_ONE, ZERO_DOT_16_NINES, bigDec("-9999999999999997"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NINE_AND_NINE_TENTH, bigDec("-9999999999999988"));
//        checkSubtract(MIN_CALC_PLUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-9999999999999988"));
//
//        //first is -1
//        checkSubtract(NEG_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-10.9"));
//        checkSubtract(NEG_ONE, NEG_ZERO_DOT_16_NINES, bigDec("-2"));
//        checkSubtract(NEG_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.99"));
//        checkSubtract(NEG_ONE, NEG_NINE_TENTH, bigDec("-1.9"));
//        checkSubtract(NEG_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE);
//        checkSubtract(NEG_ONE, NEG_ONE_TENTH, bigDec("-1.1"));
//
//        checkSubtract(NEG_ONE, ZERO_DOT_ZERO, NEG_ONE);
//
//        checkSubtract(NEG_ONE, ONE_TENTH, NEG_NINE_TENTH);
//        checkSubtract(NEG_ONE, ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_16_NINES);
//        checkSubtract(NEG_ONE, ONE_AND_ONE_TENTH, ONE_TENTH);
//        checkSubtract(NEG_ONE, NINE_TENTH, NEG_ONE_TENTH);
//        checkSubtract(NEG_ONE, NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH);
//        checkSubtract(NEG_ONE, ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_ONE);
//        checkSubtract(NEG_ONE, NINE_AND_NINE_TENTH, bigDec("8.9"));
//        checkSubtract(NEG_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("8.99"));
//
//        //first is 0
//        checkSubtract(BigDecimal.ZERO, NEG_NINE_AND_NINE_TENTH, NEG_NINE_AND_NINE_TENTH);
//        checkSubtract(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES);
//        checkSubtract(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH);
//        checkSubtract(BigDecimal.ZERO, NEG_NINE_TENTH, NEG_NINE_TENTH);
//        checkSubtract(BigDecimal.ZERO, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE);
//        checkSubtract(BigDecimal.ZERO, NEG_ONE_TENTH, NEG_ONE_TENTH);
//
//        checkSubtract(BigDecimal.ZERO, ZERO_DOT_ZERO, BigDecimal.ZERO);
//
//        checkSubtract(BigDecimal.ZERO, ONE_TENTH, ONE_TENTH);
//        checkSubtract(BigDecimal.ZERO, ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE);
//        checkSubtract(BigDecimal.ZERO, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkSubtract(BigDecimal.ZERO, NINE_TENTH, NINE_TENTH);
//        checkSubtract(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
//        checkSubtract(BigDecimal.ZERO, ZERO_DOT_16_NINES, ZERO_DOT_16_NINES);
//        checkSubtract(BigDecimal.ZERO, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
//        checkSubtract(BigDecimal.ZERO, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
//
//        //first is 1
//        checkSubtract(BigDecimal.ONE, NEG_NINE_AND_NINE_TENTH, bigDec("-8.9"));
//        checkSubtract(BigDecimal.ONE, NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_ONE);
//        checkSubtract(BigDecimal.ONE, NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH);
//        checkSubtract(BigDecimal.ONE, NEG_NINE_TENTH, ONE_TENTH);
//        checkSubtract(BigDecimal.ONE, NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES);
//        checkSubtract(BigDecimal.ONE, NEG_ONE_TENTH, NINE_TENTH);
//
//        checkSubtract(BigDecimal.ONE, ZERO_DOT_ZERO, BigDecimal.ONE);
//
//        checkSubtract(BigDecimal.ONE, ONE_TENTH, ONE_AND_ONE_TENTH);
//        checkSubtract(BigDecimal.ONE, ZERO_DOT_15_ZEROS_ONE, BigDecimal.ONE);
//        checkSubtract(BigDecimal.ONE, ONE_AND_ONE_TENTH, bigDec("2.1"));
//        checkSubtract(BigDecimal.ONE, NINE_TENTH, bigDec("1.9"));
//        checkSubtract(BigDecimal.ONE, NINETY_NINE_HUNDREDTH, bigDec("1.99"));
//        checkSubtract(BigDecimal.ONE, ZERO_DOT_16_NINES, bigDec("2"));
//        checkSubtract(BigDecimal.ONE, NINE_AND_NINE_TENTH, bigDec("10.9"));
//        checkSubtract(BigDecimal.ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.99"));
//
//        //first is 10
//        checkSubtract(BigDecimal.TEN, NEG_NINE_AND_NINE_TENTH, ONE_TENTH);
//        checkSubtract(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, bigDec("9"));
//        checkSubtract(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, bigDec("9.01"));
//        checkSubtract(BigDecimal.TEN, NEG_NINE_TENTH, bigDec("9.1"));
//        checkSubtract(BigDecimal.TEN, NEG_ZERO_DOT_15_ZEROS_ONE, BigDecimal.TEN);
//        checkSubtract(BigDecimal.TEN, NEG_ONE_TENTH, NINE_AND_NINE_TENTH);
//
//        checkSubtract(BigDecimal.TEN, ZERO_DOT_ZERO, BigDecimal.TEN);
//
//        checkSubtract(BigDecimal.TEN, ONE_TENTH, bigDec("10.1"));
//        checkSubtract(BigDecimal.TEN, ZERO_DOT_15_ZEROS_ONE, BigDecimal.TEN);
//        checkSubtract(BigDecimal.TEN, ONE_AND_ONE_TENTH, bigDec("11.1"));
//        checkSubtract(BigDecimal.TEN, NINE_TENTH, bigDec("10.9"));
//        checkSubtract(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, bigDec("10.99"));
//        checkSubtract(BigDecimal.TEN, ZERO_DOT_16_NINES, bigDec("11"));
//        checkSubtract(BigDecimal.TEN, NINE_AND_NINE_TENTH, bigDec("19.9"));
//        checkSubtract(BigDecimal.TEN, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.99"));
//
//        //first is 100
//        checkSubtract(HUNDRED, NEG_NINE_AND_NINE_TENTH, bigDec("90.1"));
//        checkSubtract(HUNDRED, NEG_ZERO_DOT_16_NINES, bigDec("99"));
//        checkSubtract(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, bigDec("99.01"));
//        checkSubtract(HUNDRED, NEG_NINE_TENTH, bigDec("99.1"));
//        checkSubtract(HUNDRED, NEG_ZERO_DOT_15_ZEROS_ONE, HUNDRED);
//        checkSubtract(HUNDRED, NEG_ONE_TENTH, bigDec("99.9"));
//
//        checkSubtract(HUNDRED, ZERO_DOT_ZERO, HUNDRED);
//
//        checkSubtract(HUNDRED, ONE_TENTH, bigDec("100.1"));
//        checkSubtract(HUNDRED, ZERO_DOT_15_ZEROS_ONE, HUNDRED);
//        checkSubtract(HUNDRED, ONE_AND_ONE_TENTH, bigDec("101.1"));
//        checkSubtract(HUNDRED, NINE_TENTH, bigDec("100.9"));
//        checkSubtract(HUNDRED, NINETY_NINE_HUNDREDTH, bigDec("100.99"));
//        checkSubtract(HUNDRED, ZERO_DOT_16_NINES, bigDec("101"));
//        checkSubtract(HUNDRED, NINE_AND_NINE_TENTH, bigDec("109.9"));
//        checkSubtract(HUNDRED, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("109.99"));
//
//        //first is max calc value minus one
//        checkSubtract(MAX_CALC_MINUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("9999999999999988"));
//        checkSubtract(MAX_CALC_MINUS_ONE, NEG_ZERO_DOT_16_NINES, bigDec("9999999999999997"));
//        checkSubtract(MAX_CALC_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("9999999999999997"));
//        checkSubtract(MAX_CALC_MINUS_ONE, NEG_NINE_TENTH, bigDec("9999999999999997"));
//        checkSubtract(MAX_CALC_MINUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, MAX_CALC_MINUS_ONE);
//        checkSubtract(MAX_CALC_MINUS_ONE, NEG_ONE_TENTH, MAX_CALC_MINUS_ONE);
//
//        checkSubtract(MAX_CALC_MINUS_ONE, ZERO_DOT_ZERO, MAX_CALC_MINUS_ONE);
//
//        checkSubtract(MAX_CALC_MINUS_ONE, ONE_TENTH, MAX_CALC_MINUS_ONE);
//        checkSubtract(MAX_CALC_MINUS_ONE, ZERO_DOT_15_ZEROS_ONE, MAX_CALC_MINUS_ONE);
//        checkSubtract(MAX_CALC_MINUS_ONE, ONE_AND_ONE_TENTH,  MAX_CALC);
//        checkSubtract(MAX_CALC_MINUS_ONE, NINE_TENTH,  MAX_CALC);
//        checkSubtract(MAX_CALC_MINUS_ONE, NINETY_NINE_HUNDREDTH,  MAX_CALC);
//        checkSubtract(MAX_CALC_MINUS_ONE, ZERO_DOT_16_NINES,  MAX_CALC);
//        checkSubtract(MAX_CALC_MINUS_ONE, NINE_AND_NINE_TENTH, bigDec("1.000000000000001e+16"));
//        checkSubtract(MAX_CALC_MINUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("1.000000000000001e+16"));
//
//        //first is max calc value
//        checkSubtract(MAX_CALC, NEG_NINE_AND_NINE_TENTH, bigDec("9999999999999989"));
//        checkSubtract(MAX_CALC, NEG_ZERO_DOT_16_NINES, MAX_CALC_MINUS_ONE);
//        checkSubtract(MAX_CALC, NEG_NINETY_NINE_HUNDREDTH, MAX_CALC_MINUS_ONE);
//        checkSubtract(MAX_CALC, NEG_NINE_TENTH, MAX_CALC_MINUS_ONE);
//        checkSubtract(MAX_CALC, NEG_ZERO_DOT_15_ZEROS_ONE, MAX_CALC);
//        checkSubtract(MAX_CALC, NEG_ONE_TENTH, MAX_CALC);
//
//        checkSubtract(MAX_CALC, ZERO_DOT_ZERO, MAX_CALC);
//
//        checkSubtract(MAX_CALC, ONE_TENTH, MAX_CALC);
//        checkSubtract(MAX_CALC, ZERO_DOT_15_ZEROS_ONE, MAX_CALC);
//        checkSubtract(MAX_CALC, ONE_AND_ONE_TENTH, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC, NINE_TENTH, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC, NINETY_NINE_HUNDREDTH, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC, ZERO_DOT_16_NINES, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC, NINE_AND_NINE_TENTH, bigDec("1.000000000000001e+16"));
//        checkSubtract(MAX_CALC, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("1.000000000000001e+16"));
//
//        //first is max calc value plus one
//        checkSubtract(MAX_CALC_PLUS_ONE, NEG_NINE_AND_NINE_TENTH, bigDec("9999999999999990"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NEG_ZERO_DOT_16_NINES, bigDec("9999999999999999"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, bigDec("9999999999999999"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NEG_NINE_TENTH, bigDec("9999999999999999"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NEG_ONE_TENTH, bigDec("1.e+16"));
//
//        checkSubtract(MAX_CALC_PLUS_ONE, ZERO_DOT_ZERO, bigDec("1.e+16"));
//
//        checkSubtract(MAX_CALC_PLUS_ONE, ONE_TENTH, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, ZERO_DOT_15_ZEROS_ONE, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, ONE_AND_ONE_TENTH, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NINE_TENTH, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NINETY_NINE_HUNDREDTH, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, ZERO_DOT_16_NINES, bigDec("1.e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NINE_AND_NINE_TENTH, bigDec("1.000000000000001e+16"));
//        checkSubtract(MAX_CALC_PLUS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("1.000000000000001e+16"));
//    }
//
//    /**
//     * Test for add operation.
//     *
//     * @param firstValue  first big decimal value.
//     * @param secondValue second big decimal value.
//     * @param expected    expected result of adding those values.
//     */
//    private void checkAdd(BigDecimal firstValue, BigDecimal secondValue, BigDecimal expected) {
//        assertEquals(expected, CalculatorOperations.add(firstValue, secondValue));
//        assertEquals(expected, CalculatorOperations.add(secondValue, firstValue));
//    }
//
//    /**
//     * Test for subtract operation.
//     *
//     * @param firstValue  first big decimal value.
//     * @param secondValue second big decimal value.
//     * @param expected    expected result of subtracting second value from first value.
//     */
//    private void checkSubtract(BigDecimal firstValue, BigDecimal secondValue, BigDecimal expected) {
//        assertEquals(expected, CalculatorOperations.subtract(firstValue, secondValue));
//        assertEquals(expected.negate(), CalculatorOperations.subtract(secondValue, firstValue));
//    }
//
//    /**
//     * Creates big decimal number from string.
//     *
//     * @param number string big decimal number.
//     * @return big decimal value of the number.
//     */
//    private BigDecimal bigDec(String number) {
//        return new BigDecimal(number);
//    }
//}
