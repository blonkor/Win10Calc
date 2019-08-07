import com.implemica.bormashenko.calculator.model.CalculatorOperations;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Test class for model of calculator application.
 *
 * @author Mykhailo Bormashenko.
 */
class ModelTest {

    /**
     * Big decimal value of minimal number that calculator's result label can show minus one.
     */
    private static final BigDecimal MIN_CALC_MINUS_ONE = new BigDecimal("-10000000000000000");

    /**
     * Big decimal value of minimal number that calculator's result label can show.
     */
    private static final BigDecimal MIN_CALC = new BigDecimal("-9999999999999999");

    /**
     * Big decimal value of minimal number that calculator's result label can show plus one.
     */
    private static final BigDecimal MIN_CALC_PLUS_ONE = new BigDecimal("-9999999999999998");

    /**
     * Big decimal value of -1000.
     */
    private static final BigDecimal NEG_THOUSAND = new BigDecimal("-1000");

    /**
     * Big decimal value of -100.
     */
    private static final BigDecimal NEG_HUNDRED = new BigDecimal("-100");

    /**
     * Big decimal value of -10.
     */
    private static final BigDecimal NEG_TEN = new BigDecimal("-10");

    /**
     * Big decimal value of -1.
     */
    private static final BigDecimal NEG_ONE = new BigDecimal("-1");

    /**
     * Big decimal value of 100.
     */
    private static final BigDecimal HUNDRED = new BigDecimal("100");

    /**
     * Big decimal value of 1000.
     */
    private static final BigDecimal THOUSAND = new BigDecimal("1000");

    /**
     * Big decimal value of maximal number that calculator's result label can show minus one.
     */
    private static final BigDecimal MAX_CALC_MINUS_ONE = new BigDecimal("9999999999999998");

    /**
     * Big decimal value of maximal number that calculator's result label can show.
     */
    private static final BigDecimal MAX_CALC = new BigDecimal("9999999999999999");

    /**
     * Big decimal value of maximal number that calculator's result label can show plus one.
     */
    private static final BigDecimal MAX_CALC_PLUS_ONE = new BigDecimal("10000000000000000");

    /**
     * Big decimal value of -9.99.
     */
    private static final BigDecimal NEG_NINE_AND_NINETY_NINE_HUNDREDTH = new BigDecimal("-9.99");

    /**
     * Big decimal value of -9.9.
     */
    private static final BigDecimal NEG_NINE_AND_NINE_TENTH = new BigDecimal("-9.9");

    /**
     * Big decimal value of -0.9999999999999999.
     * This value is the longest that can be shown in the calculator's result label.
     */
    private static final BigDecimal NEG_ZERO_DOT_16_NINES = new BigDecimal("-0.9999999999999999");

    /**
     * Big decimal value of -0.00000000000000009.
     * This value can not be shown in the calculator's result label.
     */
    private static final BigDecimal NEG_ZERO_DOT_16_ZEROS_NINE = new BigDecimal("-0.00000000000000009");

    /**
     * Big decimal value of -0.0000000000000009.
     * This value is the longest that can be shown in the calculator's result label.
     */
    private static final BigDecimal NEG_ZERO_DOT_15_ZEROS_NINE = new BigDecimal("-0.0000000000000009");

    /**
     * Big decimal value of -0.99.
     */
    private static final BigDecimal NEG_NINETY_NINE_HUNDREDTH = new BigDecimal("-0.99");

    /**
     * Big decimal value of -0.09.
     */
    private static final BigDecimal NEG_NINE_HUNDREDTH = new BigDecimal("-0.09");

    /**
     * Big decimal value of -0.9.
     */
    private static final BigDecimal NEG_NINE_TENTH = new BigDecimal("-0.9");

    /**
     * Big decimal value of -0.00000000000000001.
     * This value can not be shown in the calculator's result label.
     */
    private static final BigDecimal NEG_ZERO_DOT_16_ZEROS_ONE = new BigDecimal("-0.00000000000000001");

    /**
     * Big decimal value of -0.0000000000000001.
     * This value is the longest that can be shown in the calculator's result label.
     */
    private static final BigDecimal NEG_ZERO_DOT_15_ZEROS_ONE = new BigDecimal("-0.0000000000000001");

    /**
     * Big decimal value of -0.01.
     */
    private static final BigDecimal NEG_ONE_HUNDREDTH = new BigDecimal("-0.01");

    /**
     * Big decimal value of -0.1.
     */
    private static final BigDecimal NEG_ONE_TENTH = new BigDecimal("-0.1");

    /**
     * Big decimal value of 0.0.
     */
    private static final BigDecimal ZERO_DOT_ZERO = new BigDecimal("0.0");

    /**
     * Big decimal value of 0.1.
     */
    private static final BigDecimal ONE_TENTH = new BigDecimal("0.1");

    /**
     * Big decimal value of 0.01.
     */
    private static final BigDecimal ONE_HUNDREDTH = new BigDecimal("0.01");

    /**
     * Big decimal value of 0.0000000000000001.
     * This value is the longest that can be shown in the calculator's result label.
     */
    private static final BigDecimal ZERO_DOT_15_ZEROS_ONE = new BigDecimal("0.0000000000000001");

    /**
     * Big decimal value of 0.00000000000000001.
     * This value can not be shown in the calculator's result label.
     */
    private static final BigDecimal ZERO_DOT_16_ZEROS_ONE = new BigDecimal("0.00000000000000001");

    /**
     * Big decimal value of 1.1.
     */
    private static final BigDecimal ONE_AND_ONE_TENTH = new BigDecimal("1.1");

    /**
     * Big decimal value of 1.01.
     */
    private static final BigDecimal ONE_AND_ONE_HUNDREDTH = new BigDecimal("1.01");

    /**
     * Big decimal value of 0.9.
     */
    private static final BigDecimal NINE_TENTH = new BigDecimal("0.9");

    /**
     * Big decimal value of 0.09.
     */
    private static final BigDecimal NINE_HUNDREDTH = new BigDecimal("0.09");

    /**
     * Big decimal value of 0.99.
     */
    private static final BigDecimal NINETY_NINE_HUNDREDTH = new BigDecimal("0.99");

    /**
     * Big decimal value of 0.0000000000000009.
     * This value is the longest that can be shown in the calculator's result label.
     */
    private static final BigDecimal ZERO_DOT_15_ZEROS_NINE = new BigDecimal("0.0000000000000009");

    /**
     * Big decimal value of 0.00000000000000009.
     * This value can not be shown in the calculator's result label.
     */
    private static final BigDecimal ZERO_DOT_16_ZEROS_NINE = new BigDecimal("0.00000000000000009");

    /**
     * Big decimal value of 0.9999999999999999.
     * This value is the longest that can be shown in the calculator's result label.
     */
    private static final BigDecimal ZERO_DOT_16_NINES = new BigDecimal("0.9999999999999999");

    /**
     * Big decimal value of 9.9.
     */
    private static final BigDecimal NINE_AND_NINE_TENTH = new BigDecimal("9.9");

    /**
     * Big decimal value of 9.09.
     */
    private static final BigDecimal NINE_AND_NINE_HUNDREDTH = new BigDecimal("9.09");

    /**
     * Big decimal value of 9.99.
     */
    private static final BigDecimal NINE_AND_NINETY_NINE_HUNDREDTH = new BigDecimal("9.99");

    /**
     * Big decimal value of 9.000000000000009.
     * This value is the longest that can be shown in the calculator's result label.
     */
    private static final BigDecimal NINE_DOT_14_ZEROS_NINE = new BigDecimal("9.000000000000009");

    @Test
    void tests() {
        //add operation tests
        //integer values only
        //first is min calc value minus one
        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC_MINUS_ONE, bigDec("-20000000000000000"));
        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC, bigDec("-19999999999999999"));
        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC_PLUS_ONE, bigDec("-19999999999999998"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_THOUSAND, bigDec("-10000000000001000"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_HUNDRED, bigDec("-10000000000000100"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_TEN, bigDec("-10000000000000010"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_ONE, bigDec("-10000000000000001"));

        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.ZERO, MIN_CALC_MINUS_ONE);

        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.ONE, MIN_CALC);
        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.TEN, bigDec("-9999999999999990"));
        checkAdd(MIN_CALC_MINUS_ONE, HUNDRED, bigDec("-9999999999999900"));
        checkAdd(MIN_CALC_MINUS_ONE, THOUSAND, bigDec("-9999999999999000"));
        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, bigDec("-2"));
        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC, NEG_ONE);
        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, BigDecimal.ZERO);

        //first is min calc value
        checkAdd(MIN_CALC, MIN_CALC, bigDec("-19999999999999998"));
        checkAdd(MIN_CALC, MIN_CALC_PLUS_ONE, bigDec("-19999999999999997"));
        checkAdd(MIN_CALC, NEG_THOUSAND, bigDec("-10000000000000999"));
        checkAdd(MIN_CALC, NEG_HUNDRED, bigDec("-10000000000000099"));
        checkAdd(MIN_CALC, NEG_TEN, bigDec("-10000000000000009"));
        checkAdd(MIN_CALC, NEG_ONE, MIN_CALC_MINUS_ONE);

        checkAdd(MIN_CALC, BigDecimal.ZERO, MIN_CALC);

        checkAdd(MIN_CALC, BigDecimal.ONE, MIN_CALC_PLUS_ONE);
        checkAdd(MIN_CALC, BigDecimal.TEN, bigDec("-9999999999999989"));
        checkAdd(MIN_CALC, HUNDRED, bigDec("-9999999999999899"));
        checkAdd(MIN_CALC, THOUSAND, bigDec("-9999999999998999"));
        checkAdd(MIN_CALC, MAX_CALC_MINUS_ONE, NEG_ONE);
        checkAdd(MIN_CALC, MAX_CALC, BigDecimal.ZERO);
        checkAdd(MIN_CALC, MAX_CALC_PLUS_ONE, BigDecimal.ONE);

        //first is min calc value plus one
        checkAdd(MIN_CALC_PLUS_ONE, MIN_CALC_PLUS_ONE, bigDec("-19999999999999996"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_THOUSAND, bigDec("-10000000000000998"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_HUNDRED, bigDec("-10000000000000098"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_TEN, bigDec("-10000000000000008"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_ONE, MIN_CALC);

        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.ZERO, MIN_CALC_PLUS_ONE);

        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.ONE, bigDec("-9999999999999997"));
        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.TEN, bigDec("-9999999999999988"));
        checkAdd(MIN_CALC_PLUS_ONE, HUNDRED, bigDec("-9999999999999898"));
        checkAdd(MIN_CALC_PLUS_ONE, THOUSAND, bigDec("-9999999999998998"));
        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC_MINUS_ONE, BigDecimal.ZERO);
        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC, BigDecimal.ONE);
        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, bigDec("2"));

        //first is -1000
        checkAdd(NEG_THOUSAND, NEG_THOUSAND, bigDec("-2000"));
        checkAdd(NEG_THOUSAND, NEG_HUNDRED, bigDec("-1100"));
        checkAdd(NEG_THOUSAND, NEG_TEN, bigDec("-1010"));
        checkAdd(NEG_THOUSAND, NEG_ONE, bigDec("-1001"));

        checkAdd(NEG_THOUSAND, BigDecimal.ZERO, NEG_THOUSAND);

        checkAdd(NEG_THOUSAND, BigDecimal.ONE, bigDec("-999"));
        checkAdd(NEG_THOUSAND, BigDecimal.TEN, bigDec("-990"));
        checkAdd(NEG_THOUSAND, HUNDRED, bigDec("-900"));
        checkAdd(NEG_THOUSAND, THOUSAND, BigDecimal.ZERO);
        checkAdd(NEG_THOUSAND, MAX_CALC_MINUS_ONE, bigDec("9999999999998998"));
        checkAdd(NEG_THOUSAND, MAX_CALC, bigDec("9999999999998999"));
        checkAdd(NEG_THOUSAND, MAX_CALC_PLUS_ONE, bigDec("9999999999999000"));

        //first is -100
        checkAdd(NEG_HUNDRED, NEG_HUNDRED, bigDec("-200"));
        checkAdd(NEG_HUNDRED, NEG_TEN, bigDec("-110"));
        checkAdd(NEG_HUNDRED, NEG_ONE, bigDec("-101"));

        checkAdd(NEG_HUNDRED, BigDecimal.ZERO, NEG_HUNDRED);

        checkAdd(NEG_HUNDRED, BigDecimal.ONE, bigDec("-99"));
        checkAdd(NEG_HUNDRED, BigDecimal.TEN, bigDec("-90"));
        checkAdd(NEG_HUNDRED, HUNDRED, BigDecimal.ZERO);
        checkAdd(NEG_HUNDRED, THOUSAND, bigDec("900"));
        checkAdd(NEG_HUNDRED, MAX_CALC_MINUS_ONE, bigDec("9999999999999898"));
        checkAdd(NEG_HUNDRED, MAX_CALC, bigDec("9999999999999899"));
        checkAdd(NEG_HUNDRED, MAX_CALC_PLUS_ONE, bigDec("9999999999999900"));

        //first is -10
        checkAdd(NEG_TEN, NEG_TEN, bigDec("-20"));
        checkAdd(NEG_TEN, NEG_ONE, bigDec("-11"));

        checkAdd(NEG_TEN, BigDecimal.ZERO, NEG_TEN);

        checkAdd(NEG_TEN, BigDecimal.ONE, bigDec("-9"));
        checkAdd(NEG_TEN, BigDecimal.TEN, BigDecimal.ZERO);
        checkAdd(NEG_TEN, HUNDRED, bigDec("90"));
        checkAdd(NEG_TEN, THOUSAND, bigDec("990"));
        checkAdd(NEG_TEN, MAX_CALC_MINUS_ONE, bigDec("9999999999999988"));
        checkAdd(NEG_TEN, MAX_CALC, bigDec("9999999999999989"));
        checkAdd(NEG_TEN, MAX_CALC_PLUS_ONE, bigDec("9999999999999990"));

        //first is -1
        checkAdd(NEG_ONE, NEG_ONE, bigDec("-2"));

        checkAdd(NEG_ONE, BigDecimal.ZERO, NEG_ONE);

        checkAdd(NEG_ONE, BigDecimal.ONE, BigDecimal.ZERO);
        checkAdd(NEG_ONE, BigDecimal.TEN, bigDec("9"));
        checkAdd(NEG_ONE, HUNDRED, bigDec("99"));
        checkAdd(NEG_ONE, THOUSAND, bigDec("999"));
        checkAdd(NEG_ONE, MAX_CALC_MINUS_ONE, bigDec("9999999999999997"));
        checkAdd(NEG_ONE, MAX_CALC, MAX_CALC_MINUS_ONE);
        checkAdd(NEG_ONE, MAX_CALC_PLUS_ONE, MAX_CALC);

        //first is 0
        checkAdd(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

        checkAdd(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE);
        checkAdd(BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
        checkAdd(BigDecimal.ZERO, HUNDRED, HUNDRED);
        checkAdd(BigDecimal.ZERO, THOUSAND, THOUSAND);
        checkAdd(BigDecimal.ZERO, MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE);
        checkAdd(BigDecimal.ZERO, MAX_CALC, MAX_CALC);
        checkAdd(BigDecimal.ZERO, MAX_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE);

        //first is 1
        checkAdd(BigDecimal.ONE, BigDecimal.ONE, bigDec("2"));
        checkAdd(BigDecimal.ONE, BigDecimal.TEN, bigDec("11"));
        checkAdd(BigDecimal.ONE, HUNDRED, bigDec("101"));
        checkAdd(BigDecimal.ONE, THOUSAND, bigDec("1001"));
        checkAdd(BigDecimal.ONE, MAX_CALC_MINUS_ONE, MAX_CALC);
        checkAdd(BigDecimal.ONE, MAX_CALC, MAX_CALC_PLUS_ONE);
        checkAdd(BigDecimal.ONE, MAX_CALC_PLUS_ONE, bigDec("10000000000000001"));

        //first is 10
        checkAdd(BigDecimal.TEN, BigDecimal.TEN, bigDec("20"));
        checkAdd(BigDecimal.TEN, HUNDRED, bigDec("110"));
        checkAdd(BigDecimal.TEN, THOUSAND, bigDec("1010"));
        checkAdd(BigDecimal.TEN, MAX_CALC_MINUS_ONE, bigDec("10000000000000008"));
        checkAdd(BigDecimal.TEN, MAX_CALC, bigDec("10000000000000009"));
        checkAdd(BigDecimal.TEN, MAX_CALC_PLUS_ONE, bigDec("10000000000000010"));

        //first is 100
        checkAdd(HUNDRED, HUNDRED, bigDec("200"));
        checkAdd(HUNDRED, THOUSAND, bigDec("1100"));
        checkAdd(HUNDRED, MAX_CALC_MINUS_ONE, bigDec("10000000000000098"));
        checkAdd(HUNDRED, MAX_CALC, bigDec("10000000000000099"));
        checkAdd(HUNDRED, MAX_CALC_PLUS_ONE, bigDec("10000000000000100"));

        //first is 1000
        checkAdd(THOUSAND, THOUSAND, bigDec("2000"));
        checkAdd(THOUSAND, MAX_CALC_MINUS_ONE, bigDec("10000000000000998"));
        checkAdd(THOUSAND, MAX_CALC, bigDec("10000000000000999"));
        checkAdd(THOUSAND, MAX_CALC_PLUS_ONE, bigDec("10000000000001000"));

        //first is max calc value minus one
        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, bigDec("19999999999999996"));
        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC, bigDec("19999999999999997"));
        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, bigDec("19999999999999998"));

        //first is max calc value
        checkAdd(MAX_CALC, MAX_CALC, bigDec("19999999999999998"));
        checkAdd(MAX_CALC, MAX_CALC_PLUS_ONE, bigDec("19999999999999999"));

        //first is max calc value plus one
        checkAdd(MAX_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, bigDec("20000000000000000"));

        //decimals only
        //first is -9.99
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("-19.98"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_AND_NINE_TENTH, bigDec("-19.89"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, bigDec("-10.99"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_ZEROS_NINE, bigDec("-9.9900000000000001"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-9.990000000000001"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-10.98"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-10.08"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, bigDec("-10.89"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_TEN);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-10.09"));

        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);

        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_TENTH, bigDec("-9.89"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-9.98"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_ONE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("-8.89"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("-8.98"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_TENTH, bigDec("-9.09"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, NEG_NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("-9"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-9.989999999999999"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("-8.99"));
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, NEG_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, NEG_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, BigDecimal.ZERO);
        checkAdd(NEG_NINE_AND_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("-0.989999999999991"));

        //first is -9.9
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINE_AND_NINE_TENTH, bigDec("-19.8"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_16_NINES, bigDec("-10.9"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_16_ZEROS_NINE, NEG_NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-9.899999999999999"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-10.89"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINE_HUNDREDTH, NEG_NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_NINE_TENTH, bigDec("-10.8"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_16_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ONE_HUNDREDTH, bigDec("-9.91"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NEG_ONE_TENTH, NEG_TEN);

        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_ZERO, NEG_NINE_AND_NINE_TENTH);

        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_TENTH, bigDec("-9.8"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_HUNDREDTH, bigDec("-9.89"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_15_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_16_ZEROS_ONE, NEG_NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_AND_ONE_TENTH, bigDec("-8.8"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("-8.89"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_TENTH, bigDec("-9"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_HUNDREDTH, bigDec("-9.81"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("-8.91"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-9.989999999999999"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_16_ZEROS_NINE, NEG_NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, ZERO_DOT_16_NINES, bigDec("-8.99"));
        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH, BigDecimal.ZERO);
        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, NEG_NINE_TENTH);
        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, BigDecimal.ZERO);
        checkAdd(NEG_NINE_AND_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("-0.989999999999991"));

        //first is -0.9999999999999999
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, bigDec("-2"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_16_NINES);
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-1.000000000000001"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.99"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, bigDec("-1.09"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, bigDec("-1.9"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_ZEROS_ONE, NEG_ZERO_DOT_16_NINES);
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE);
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, bigDec("-1.01"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, bigDec("-1.1"));

        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_ZERO, NEG_ZERO_DOT_16_NINES);

        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_TENTH, bigDec("-0.8999999999999999"));
        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, bigDec("-0.9899999999999999"));
        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9999999999999998"));
        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_ZEROS_ONE, NEG_ZERO_DOT_16_NINES);
        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_AND_ONE_TENTH, bigDec("0.1000000000000001"));
        checkAdd(NEG_ZERO_DOT_16_NINES, ONE_AND_ONE_HUNDREDTH, bigDec("0.0100000000000001"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_TENTH, bigDec("-0.0999999999999999"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, bigDec("-0.9099999999999999"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, bigDec("-0.0099999999999999"));
        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_16_NINES);
        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_16_NINES);
        checkAdd(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_AND_NINE_TENTH, bigDec("8.9"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_AND_NINE_HUNDREDTH, bigDec("8.09"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("8.99"));
        checkAdd(NEG_ZERO_DOT_16_NINES, NINE_DOT_14_ZEROS_NINE, bigDec("8.000000000000009"));

        //first is -0.00000000000000009
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_16_ZEROS_NINE, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_NINE);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_NINE_TENTH, NEG_NINE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_16_ZEROS_ONE, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NEG_ONE_TENTH, NEG_ONE_TENTH);

        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_ZERO, BigDecimal.ZERO);

        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ONE_TENTH, ONE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ONE_HUNDREDTH, ONE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_16_ZEROS_ONE, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NINE_TENTH, NINE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NINE_HUNDREDTH, NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_16_ZEROS_NINE, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_16_NINES, ZERO_DOT_16_NINES);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);

        //first is -0.0000000000000009
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0000000000000018"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINETY_NINE_HUNDREDTH, bigDec("-0.9900000000000009"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINE_HUNDREDTH, bigDec("-0.0900000000000009"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_NINE_TENTH, bigDec("-0.9000000000000009"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_16_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_NINE);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.000000000000001"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ONE_HUNDREDTH, bigDec("-0.0100000000000009"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NEG_ONE_TENTH, bigDec("-0.1000000000000009"));

        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_ZERO, NEG_ZERO_DOT_15_ZEROS_NINE);

        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_TENTH, bigDec("0.0999999999999991"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_HUNDREDTH, bigDec("0.0099999999999991"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0000000000000008"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_NINE);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_AND_ONE_TENTH, bigDec("1.099999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ONE_AND_ONE_HUNDREDTH, bigDec("1.009999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_TENTH, bigDec("0.8999999999999991"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_HUNDREDTH, bigDec("0.0899999999999991"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINETY_NINE_HUNDREDTH, bigDec("0.9899999999999991"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_15_ZEROS_NINE);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_NINES, bigDec("0.999999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_TENTH, bigDec("9.899999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, bigDec("9.089999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.989999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("9.000000000000008"));

        //first is -0.99
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, bigDec("-1.98"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-1.08"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, bigDec("-1.89"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_ZEROS_ONE, bigDec("-0.9900000000000001"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, NEG_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_ONE);
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-1.09"));

        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINETY_NINE_HUNDREDTH);

        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, bigDec("-0.89"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-0.98"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9899999999999999"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_ONE, NEG_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("0.11"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.02"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, NEG_NINE_HUNDREDTH);
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, NEG_NINE_TENTH);
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, BigDecimal.ZERO);
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.9899999999999991"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, NEG_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.0099999999999999"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("8.91"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.1"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9"));
        checkAdd(NEG_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.010000000000009"));

        //first is -0.09
        checkAdd(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, bigDec("-0.18"));
        checkAdd(NEG_NINE_HUNDREDTH, NEG_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_16_ZEROS_ONE, NEG_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0900000000000001"));
        checkAdd(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, NEG_ONE_TENTH);
        checkAdd(NEG_NINE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-0.19"));

        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_ZERO, NEG_NINE_HUNDREDTH);

        checkAdd(NEG_NINE_HUNDREDTH, ONE_TENTH, ONE_HUNDREDTH);
        checkAdd(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, bigDec("-0.08"));
        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0899999999999999"));
        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_ONE, NEG_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_HUNDREDTH, ONE_AND_ONE_TENTH, ONE_AND_ONE_HUNDREDTH);
        checkAdd(NEG_NINE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.92"));
        checkAdd(NEG_NINE_HUNDREDTH, NINE_TENTH, bigDec("0.81"));
        checkAdd(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, BigDecimal.ZERO);
        checkAdd(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, NINE_TENTH);
        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0899999999999991"));
        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, bigDec("-0.0899999999999999"));
        checkAdd(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.9099999999999999"));
        checkAdd(NEG_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.81"));
        checkAdd(NEG_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9"));
        checkAdd(NEG_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH);
        checkAdd(NEG_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.910000000000009"));

        //first is -0.9
        checkAdd(NEG_NINE_TENTH, NEG_NINE_TENTH, bigDec("-1.8"));
        checkAdd(NEG_NINE_TENTH, NEG_ZERO_DOT_16_ZEROS_ONE, NEG_NINE_TENTH);
        checkAdd(NEG_NINE_TENTH, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.9000000000000001"));
        checkAdd(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, bigDec("-0.91"));
        checkAdd(NEG_NINE_TENTH, NEG_ONE_TENTH, NEG_ONE);

        checkAdd(NEG_NINE_TENTH, ZERO_DOT_ZERO, NEG_NINE_TENTH);

        checkAdd(NEG_NINE_TENTH, ONE_TENTH, bigDec("-0.8"));
        checkAdd(NEG_NINE_TENTH, ONE_HUNDREDTH, bigDec("-0.89"));
        checkAdd(NEG_NINE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.8999999999999999"));
        checkAdd(NEG_NINE_TENTH, ZERO_DOT_16_ZEROS_ONE, NEG_NINE_TENTH);
        checkAdd(NEG_NINE_TENTH, ONE_AND_ONE_TENTH, bigDec("0.2"));
        checkAdd(NEG_NINE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.11"));
        checkAdd(NEG_NINE_TENTH, NINE_TENTH, BigDecimal.ZERO);
        checkAdd(NEG_NINE_TENTH, NINE_HUNDREDTH, bigDec("-0.81"));
        checkAdd(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH);
        checkAdd(NEG_NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.8999999999999991"));
        checkAdd(NEG_NINE_TENTH, ZERO_DOT_16_ZEROS_NINE, bigDec("-0.8999999999999999"));
        checkAdd(NEG_NINE_TENTH, ZERO_DOT_16_NINES, bigDec("0.0999999999999999"));
        checkAdd(NEG_NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("9"));
        checkAdd(NEG_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.19"));
        checkAdd(NEG_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(NEG_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.100000000000009"));

        //first is -0.00000000000000001
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NEG_ZERO_DOT_16_ZEROS_ONE, bigDec("-0.00000000000000002"));
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.00000000000000011"));
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NEG_ONE_TENTH, NEG_ONE_TENTH);

        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_ZERO, NEG_ZERO_DOT_16_ZEROS_ONE);

        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ONE_TENTH, ONE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ONE_HUNDREDTH, ONE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_ZEROS_NINE);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_16_ZEROS_ONE, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NINE_TENTH, NINE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NINE_HUNDREDTH, NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.00000000000000089"));
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_16_ZEROS_NINE, bigDec("0.00000000000000008"));
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_16_NINES, bigDec("0.9999999999999999"));
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_16_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);

        //first is -0.0000000000000001
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0000000000000002"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE_HUNDREDTH, bigDec("-0.0100000000000001"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NEG_ONE_TENTH, bigDec("-0.1000000000000001"));

        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_ZERO, NEG_ZERO_DOT_15_ZEROS_ONE);

        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_TENTH, bigDec("0.0999999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_HUNDREDTH, bigDec("0.0099999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE, BigDecimal.ZERO);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_ZEROS_ONE, bigDec("-0.00000000000000009"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_TENTH, bigDec("0.8999999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_HUNDREDTH, bigDec("0.0899999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINETY_NINE_HUNDREDTH, bigDec("0.9899999999999999"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0000000000000008"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_ZEROS_NINE, NEG_ZERO_DOT_16_ZEROS_ONE);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES, bigDec("0.9999999999999998"));
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NEG_ZERO_DOT_15_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);

        //first is -0.01
        checkAdd(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, bigDec("-0.02"));
        checkAdd(NEG_ONE_HUNDREDTH, NEG_ONE_TENTH, bigDec("-0.11"));

        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_ZERO, NEG_ONE_HUNDREDTH);

        checkAdd(NEG_ONE_HUNDREDTH, ONE_TENTH, NINE_HUNDREDTH);
        checkAdd(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, BigDecimal.ZERO);
        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0099999999999999"));
        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_16_ZEROS_ONE, NEG_ONE_HUNDREDTH);
        checkAdd(NEG_ONE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("1.09"));
        checkAdd(NEG_ONE_HUNDREDTH, NINE_TENTH, bigDec("0.89"));
        checkAdd(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, bigDec("0.08"));
        checkAdd(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("0.98"));
        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0099999999999991"));
        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, bigDec("-0.0099999999999999"));
        checkAdd(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0.9899999999999999"));
        checkAdd(NEG_ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.89"));
        checkAdd(NEG_ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.08"));
        checkAdd(NEG_ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.98"));
        checkAdd(NEG_ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.990000000000009"));

        //first is -0.1
        checkAdd(NEG_ONE_TENTH, NEG_ONE_TENTH, bigDec("-0.2"));

        checkAdd(NEG_ONE_TENTH, ZERO_DOT_ZERO, NEG_ONE_TENTH);

        checkAdd(NEG_ONE_TENTH, ONE_TENTH, BigDecimal.ZERO);
        checkAdd(NEG_ONE_TENTH, ONE_HUNDREDTH, NEG_NINE_HUNDREDTH);
        checkAdd(NEG_ONE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("-0.0999999999999999"));
        checkAdd(NEG_ONE_TENTH, ZERO_DOT_16_ZEROS_ONE, NEG_ONE_TENTH);
        checkAdd(NEG_ONE_TENTH, ONE_AND_ONE_TENTH, BigDecimal.ONE);
        checkAdd(NEG_ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("0.91"));
        checkAdd(NEG_ONE_TENTH, NINE_TENTH, bigDec("0.8"));
        checkAdd(NEG_ONE_TENTH, NINE_HUNDREDTH, NEG_ONE_HUNDREDTH);
        checkAdd(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("0.89"));
        checkAdd(NEG_ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("-0.0999999999999991"));
        checkAdd(NEG_ONE_TENTH, ZERO_DOT_16_ZEROS_NINE, bigDec("-0.0999999999999999"));
        checkAdd(NEG_ONE_TENTH, ZERO_DOT_16_NINES, bigDec("0.8999999999999999"));
        checkAdd(NEG_ONE_TENTH, NINE_AND_NINE_TENTH, bigDec("9.8"));
        checkAdd(NEG_ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("8.99"));
        checkAdd(NEG_ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.89"));
        checkAdd(NEG_ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("8.900000000000009"));

        //first is 0.0
        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_ZERO, BigDecimal.ZERO);

        checkAdd(ZERO_DOT_ZERO, ONE_TENTH, ONE_TENTH);
        checkAdd(ZERO_DOT_ZERO, ONE_HUNDREDTH, ONE_HUNDREDTH);
        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE);
        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_16_ZEROS_ONE);
        checkAdd(ZERO_DOT_ZERO, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
        checkAdd(ZERO_DOT_ZERO, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
        checkAdd(ZERO_DOT_ZERO, NINE_TENTH, NINE_TENTH);
        checkAdd(ZERO_DOT_ZERO, NINE_HUNDREDTH, NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_ZERO, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE);
        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_16_ZEROS_NINE);
        checkAdd(ZERO_DOT_ZERO, ZERO_DOT_16_NINES, ZERO_DOT_16_NINES);
        checkAdd(ZERO_DOT_ZERO, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
        checkAdd(ZERO_DOT_ZERO, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_ZERO, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_ZERO, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);

        //first is 0.1
        checkAdd(ONE_TENTH, ONE_TENTH, bigDec("0.2"));
        checkAdd(ONE_TENTH, ONE_HUNDREDTH, bigDec("0.11"));
        checkAdd(ONE_TENTH, ZERO_DOT_15_ZEROS_ONE, bigDec("0.1000000000000001"));
        checkAdd(ONE_TENTH, ZERO_DOT_16_ZEROS_ONE, ONE_TENTH);
        checkAdd(ONE_TENTH, ONE_AND_ONE_TENTH, bigDec("1.2"));
        checkAdd(ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("1.11"));
        checkAdd(ONE_TENTH, NINE_TENTH, BigDecimal.ONE);
        checkAdd(ONE_TENTH, NINE_HUNDREDTH, bigDec("0.19"));
        checkAdd(ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("1.09"));
        checkAdd(ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.1000000000000009"));
        checkAdd(ONE_TENTH, ZERO_DOT_16_ZEROS_NINE, bigDec("0.1000000000000001"));
        checkAdd(ONE_TENTH, ZERO_DOT_16_NINES, ONE_AND_ONE_TENTH);
        checkAdd(ONE_TENTH, NINE_AND_NINE_TENTH, BigDecimal.TEN);
        checkAdd(ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.19"));
        checkAdd(ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.09"));
        checkAdd(ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.100000000000009"));

        //first is 0.01
        checkAdd(ONE_HUNDREDTH, ONE_HUNDREDTH, bigDec("0.02"));
        checkAdd(ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_ONE, bigDec("0.0100000000000001"));
        checkAdd(ONE_HUNDREDTH, ZERO_DOT_16_ZEROS_ONE, ONE_HUNDREDTH);
        checkAdd(ONE_HUNDREDTH, ONE_AND_ONE_TENTH, bigDec("1.11"));
        checkAdd(ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("1.02"));
        checkAdd(ONE_HUNDREDTH, NINE_TENTH, bigDec("0.91"));
        checkAdd(ONE_HUNDREDTH, NINE_HUNDREDTH, ONE_TENTH);
        checkAdd(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, BigDecimal.ONE);
        checkAdd(ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0100000000000009"));
        checkAdd(ONE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, bigDec("0.0100000000000001"));
        checkAdd(ONE_HUNDREDTH, ZERO_DOT_16_NINES, ONE_AND_ONE_HUNDREDTH);
        checkAdd(ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("9.91"));
        checkAdd(ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.1"));
        checkAdd(ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, BigDecimal.TEN);
        checkAdd(ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.010000000000009"));

        //first is 0.0000000000000001
        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_ONE, bigDec("0.0000000000000002"));
        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_ZEROS_ONE, bigDec("0.00000000000000011"));
        checkAdd(ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
        checkAdd(ZERO_DOT_15_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_TENTH, bigDec("0.9000000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_HUNDREDTH, bigDec("0.0900000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINETY_NINE_HUNDREDTH, bigDec("0.9900000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.000000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_ZEROS_NINE, bigDec("0.00000000000000019"));
        checkAdd(ZERO_DOT_15_ZEROS_ONE, ZERO_DOT_16_NINES, BigDecimal.ONE);
        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_15_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);

        //first is 0.00000000000000001
        checkAdd(ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_16_ZEROS_ONE, bigDec("0.00000000000000002"));
        checkAdd(ZERO_DOT_16_ZEROS_ONE, ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, NINE_TENTH, NINE_TENTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, NINE_HUNDREDTH, NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0000000000000091"));
        checkAdd(ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_15_ZEROS_ONE);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, ZERO_DOT_16_NINES, ZERO_DOT_16_NINES);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_16_ZEROS_ONE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);

        //first is 1.1
        checkAdd(ONE_AND_ONE_TENTH, ONE_AND_ONE_TENTH, bigDec("2.2"));
        checkAdd(ONE_AND_ONE_TENTH, ONE_AND_ONE_HUNDREDTH, bigDec("2.11"));
        checkAdd(ONE_AND_ONE_TENTH, NINE_TENTH, bigDec("2"));
        checkAdd(ONE_AND_ONE_TENTH, NINE_HUNDREDTH, bigDec("1.19"));
        checkAdd(ONE_AND_ONE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("2.09"));
        checkAdd(ONE_AND_ONE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("1.100000000000001"));
        checkAdd(ONE_AND_ONE_TENTH, ZERO_DOT_16_ZEROS_NINE, ONE_AND_ONE_TENTH);
        checkAdd(ONE_AND_ONE_TENTH, ZERO_DOT_16_NINES, bigDec("2.1"));
        checkAdd(ONE_AND_ONE_TENTH, NINE_AND_NINE_TENTH, bigDec("11"));
        checkAdd(ONE_AND_ONE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.19"));
        checkAdd(ONE_AND_ONE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("11.09"));
        checkAdd(ONE_AND_ONE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("10.10000000000001"));

        //first is 1.01
        checkAdd(ONE_AND_ONE_HUNDREDTH, ONE_AND_ONE_HUNDREDTH, bigDec("2.02"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_TENTH, bigDec("1.91"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_HUNDREDTH, ONE_AND_ONE_TENTH);
        checkAdd(ONE_AND_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("2"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("1.010000000000001"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, ONE_AND_ONE_HUNDREDTH);
        checkAdd(ONE_AND_ONE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("0"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("10.91"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.1"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("11"));
        checkAdd(ONE_AND_ONE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("10.01000000000001"));

        //first is 0.9
        checkAdd(NINE_TENTH, NINE_TENTH, bigDec("1.8"));
        checkAdd(NINE_TENTH, NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH);
        checkAdd(NINE_TENTH, NINETY_NINE_HUNDREDTH, bigDec("1.89"));
        checkAdd(NINE_TENTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.9000000000000009"));
        checkAdd(NINE_TENTH, ZERO_DOT_16_ZEROS_NINE, bigDec("0.9000000000000001"));
        checkAdd(NINE_TENTH, ZERO_DOT_16_NINES, bigDec("1.9"));
        checkAdd(NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("10.8"));
        checkAdd(NINE_TENTH, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.89"));
        checkAdd(NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.900000000000009"));

        //first is 0.09
        checkAdd(NINE_HUNDREDTH, NINE_HUNDREDTH, bigDec("0.18"));
        checkAdd(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("1.08"));
        checkAdd(NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0900000000000009"));
        checkAdd(NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, bigDec("0.0900000000000001"));
        checkAdd(NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("1.09"));
        checkAdd(NINE_HUNDREDTH, NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("9.18"));
        checkAdd(NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.08"));
        checkAdd(NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.090000000000009"));

        //first is 0.99
        checkAdd(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, bigDec("1.98"));
        checkAdd(NINETY_NINE_HUNDREDTH, ZERO_DOT_15_ZEROS_NINE, bigDec("0.9900000000000009"));
        checkAdd(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_ZEROS_NINE, bigDec("0.9900000000000001"));
        checkAdd(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, bigDec("1.99"));
        checkAdd(NINETY_NINE_HUNDREDTH, NINE_AND_NINE_TENTH, bigDec("10.89"));
        checkAdd(NINETY_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("10.08"));
        checkAdd(NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.98"));
        checkAdd(NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("9.990000000000009"));

        //first is 0.0000000000000009
        checkAdd(ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_15_ZEROS_NINE, bigDec("0.0000000000000018"));
        checkAdd(ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_ZEROS_NINE, bigDec("0.00000000000000099"));
        checkAdd(ZERO_DOT_15_ZEROS_NINE, ZERO_DOT_16_NINES, bigDec("1.000000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_TENTH, bigDec("9.900000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, bigDec("9.090000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("9.990000000000001"));
        checkAdd(ZERO_DOT_15_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("9.00000000000001"));

        //first is 0.00000000000000009
        checkAdd(ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_16_ZEROS_NINE, bigDec("1.8e-16"));
        checkAdd(ZERO_DOT_16_ZEROS_NINE, ZERO_DOT_16_NINES, BigDecimal.ONE);
        checkAdd(ZERO_DOT_16_ZEROS_NINE, NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH);
        checkAdd(ZERO_DOT_16_ZEROS_NINE, NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_16_ZEROS_NINE, NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH);
        checkAdd(ZERO_DOT_16_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE);

        //first is 0.9999999999999999
        checkAdd(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, bigDec("2"));
        checkAdd(ZERO_DOT_16_NINES, NINE_AND_NINE_TENTH, bigDec("10.9"));
        checkAdd(ZERO_DOT_16_NINES, NINE_AND_NINE_HUNDREDTH, bigDec("10.09"));
        checkAdd(ZERO_DOT_16_NINES, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("10.99"));
        checkAdd(ZERO_DOT_16_NINES, NINE_DOT_14_ZEROS_NINE, bigDec("10.00000000000001"));

        //first is 9.9
        checkAdd(NINE_AND_NINE_TENTH, NINE_AND_NINE_TENTH, bigDec("19.8"));
        checkAdd(NINE_AND_NINE_TENTH, NINE_AND_NINE_HUNDREDTH, bigDec("18.99"));
        checkAdd(NINE_AND_NINE_TENTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.89"));
        checkAdd(NINE_AND_NINE_TENTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.90000000000001"));

        //first is 9.09
        checkAdd(NINE_AND_NINE_HUNDREDTH, NINE_AND_NINE_HUNDREDTH, bigDec("18.18"));
        checkAdd(NINE_AND_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.08"));
        checkAdd(NINE_AND_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.09000000000001"));

        //first is 9.99
        checkAdd(NINE_AND_NINETY_NINE_HUNDREDTH, NINE_AND_NINETY_NINE_HUNDREDTH, bigDec("19.98"));
        checkAdd(NINE_AND_NINETY_NINE_HUNDREDTH, NINE_DOT_14_ZEROS_NINE, bigDec("18.99000000000001"));

        //first is 9.000000000000009
        checkAdd(NINE_DOT_14_ZEROS_NINE, NINE_DOT_14_ZEROS_NINE, bigDec("18.00000000000002"));
    }

    /**
     * Test for add operation.
     *
     * @param firstValue  first big decimal value.
     * @param secondValue second big decimal value.
     * @param expected    expected result of adding those values.
     */
    private void checkAdd(BigDecimal firstValue, BigDecimal secondValue, BigDecimal expected) {
        assertEquals(expected, CalculatorOperations.add(firstValue, secondValue));
        assertEquals(expected, CalculatorOperations.add(secondValue, firstValue));
    }

    /**
     * Creates big decimal number from string.
     *
     * @param number string big decimal number.
     * @return big decimal value of the number.
     */
    private BigDecimal bigDec(String number) {
        return new BigDecimal(number);
    }
}
