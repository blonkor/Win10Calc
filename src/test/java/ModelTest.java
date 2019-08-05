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
     * Big decimal value of -1000000.
     */
    private static final BigDecimal NEG_MILLION = new BigDecimal("-1000000");

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
     * Big decimal value of -2.
     */
    private static final BigDecimal NEG_TWO = new BigDecimal("-2");

    /**
     * Big decimal value of -1.
     */
    private static final BigDecimal NEG_ONE = new BigDecimal("-1");

    /**
     * Big decimal value of 2.
     */
    private static final BigDecimal TWO = new BigDecimal("2");

    /**
     * Big decimal value of 100.
     */
    private static final BigDecimal HUNDRED = new BigDecimal("100");

    /**
     * Big decimal value of 1000.
     */
    private static final BigDecimal THOUSAND = new BigDecimal("1000");

    /**
     * Big decimal value of 1000000.
     */
    private static final BigDecimal MILLION = new BigDecimal("1000000");

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

    @Test
    void tests() {
        //add operation tests
        //integer values only
        //first is min calc value minus one
        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC_MINUS_ONE, new BigDecimal("-20000000000000000"));
        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC, new BigDecimal("-19999999999999999"));
        checkAdd(MIN_CALC_MINUS_ONE, MIN_CALC_PLUS_ONE, new BigDecimal("-19999999999999998"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_MILLION, new BigDecimal("-10000000001000000"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_THOUSAND, new BigDecimal("-10000000000001000"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_HUNDRED, new BigDecimal("-10000000000000100"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_TEN, new BigDecimal("-10000000000000010"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_TWO, new BigDecimal("-10000000000000002"));
        checkAdd(MIN_CALC_MINUS_ONE, NEG_ONE, new BigDecimal("-10000000000000001"));

        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.ZERO, MIN_CALC_MINUS_ONE);

        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.ONE, MIN_CALC);
        checkAdd(MIN_CALC_MINUS_ONE, TWO, MIN_CALC_PLUS_ONE);
        checkAdd(MIN_CALC_MINUS_ONE, BigDecimal.TEN, new BigDecimal("-9999999999999990"));
        checkAdd(MIN_CALC_MINUS_ONE, HUNDRED, new BigDecimal("-9999999999999900"));
        checkAdd(MIN_CALC_MINUS_ONE, THOUSAND, new BigDecimal("-9999999999999000"));
        checkAdd(MIN_CALC_MINUS_ONE, MILLION, new BigDecimal("-9999999999000000"));
        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, NEG_TWO);
        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC, NEG_ONE);
        checkAdd(MIN_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, BigDecimal.ZERO);

        //first is min calc value
        checkAdd(MIN_CALC, MIN_CALC_MINUS_ONE, new BigDecimal("-19999999999999999"));
        checkAdd(MIN_CALC, MIN_CALC, new BigDecimal("-19999999999999998"));
        checkAdd(MIN_CALC, MIN_CALC_PLUS_ONE, new BigDecimal("-19999999999999997"));
        checkAdd(MIN_CALC, NEG_MILLION, new BigDecimal("-10000000000999999"));
        checkAdd(MIN_CALC, NEG_THOUSAND, new BigDecimal("-10000000000000999"));
        checkAdd(MIN_CALC, NEG_HUNDRED, new BigDecimal("-10000000000000099"));
        checkAdd(MIN_CALC, NEG_TEN, new BigDecimal("-10000000000000009"));
        checkAdd(MIN_CALC, NEG_TWO, new BigDecimal("-10000000000000001"));
        checkAdd(MIN_CALC, NEG_ONE, MIN_CALC_MINUS_ONE);

        checkAdd(MIN_CALC, BigDecimal.ZERO, MIN_CALC);

        checkAdd(MIN_CALC, BigDecimal.ONE, MIN_CALC_PLUS_ONE);
        checkAdd(MIN_CALC, TWO, new BigDecimal("-9999999999999997"));
        checkAdd(MIN_CALC, BigDecimal.TEN, new BigDecimal("-9999999999999989"));
        checkAdd(MIN_CALC, HUNDRED, new BigDecimal("-9999999999999899"));
        checkAdd(MIN_CALC, THOUSAND, new BigDecimal("-9999999999998999"));
        checkAdd(MIN_CALC, MILLION, new BigDecimal("-9999999998999999"));
        checkAdd(MIN_CALC, MAX_CALC_MINUS_ONE, NEG_ONE);
        checkAdd(MIN_CALC, MAX_CALC, BigDecimal.ZERO);
        checkAdd(MIN_CALC, MAX_CALC_PLUS_ONE, BigDecimal.ONE);

        //first is min calc value plus one
        checkAdd(MIN_CALC_PLUS_ONE, MIN_CALC_MINUS_ONE, new BigDecimal("-19999999999999998"));
        checkAdd(MIN_CALC_PLUS_ONE, MIN_CALC, new BigDecimal("-19999999999999997"));
        checkAdd(MIN_CALC_PLUS_ONE, MIN_CALC_PLUS_ONE, new BigDecimal("-19999999999999996"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_MILLION, new BigDecimal("-10000000000999998"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_THOUSAND, new BigDecimal("-10000000000000998"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_HUNDRED, new BigDecimal("-10000000000000098"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_TEN, new BigDecimal("-10000000000000008"));
        checkAdd(MIN_CALC_PLUS_ONE, NEG_TWO, MIN_CALC_MINUS_ONE);
        checkAdd(MIN_CALC_PLUS_ONE, NEG_ONE, MIN_CALC);

        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.ZERO, MIN_CALC_PLUS_ONE);

        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.ONE, new BigDecimal("-9999999999999997"));
        checkAdd(MIN_CALC_PLUS_ONE, TWO, new BigDecimal("-9999999999999996"));
        checkAdd(MIN_CALC_PLUS_ONE, BigDecimal.TEN, new BigDecimal("-9999999999999988"));
        checkAdd(MIN_CALC_PLUS_ONE, HUNDRED, new BigDecimal("-9999999999999898"));
        checkAdd(MIN_CALC_PLUS_ONE, THOUSAND, new BigDecimal("-9999999999998998"));
        checkAdd(MIN_CALC_PLUS_ONE, MILLION, new BigDecimal("-9999999998999998"));
        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC_MINUS_ONE, BigDecimal.ZERO);
        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC, BigDecimal.ONE);
        checkAdd(MIN_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, TWO);

        //first is -million
        checkAdd(NEG_MILLION, MIN_CALC_MINUS_ONE, new BigDecimal("-10000000001000000"));
        checkAdd(NEG_MILLION, MIN_CALC, new BigDecimal("-10000000000999999"));
        checkAdd(NEG_MILLION, MIN_CALC_PLUS_ONE, new BigDecimal("-10000000000999998"));
        checkAdd(NEG_MILLION, NEG_MILLION, new BigDecimal("-2000000"));
        checkAdd(NEG_MILLION, NEG_THOUSAND, new BigDecimal("-1001000"));
        checkAdd(NEG_MILLION, NEG_HUNDRED, new BigDecimal("-1000100"));
        checkAdd(NEG_MILLION, NEG_TEN, new BigDecimal("-1000010"));
        checkAdd(NEG_MILLION, NEG_TWO, new BigDecimal("-1000002"));
        checkAdd(NEG_MILLION, NEG_ONE, new BigDecimal("-1000001"));

        checkAdd(NEG_MILLION, BigDecimal.ZERO, NEG_MILLION);

        checkAdd(NEG_MILLION, BigDecimal.ONE, new BigDecimal("-999999"));
        checkAdd(NEG_MILLION, TWO, new BigDecimal("-999998"));
        checkAdd(NEG_MILLION, BigDecimal.TEN, new BigDecimal("-999990"));
        checkAdd(NEG_MILLION, HUNDRED, new BigDecimal("-999900"));
        checkAdd(NEG_MILLION, THOUSAND, new BigDecimal("-999000"));
        checkAdd(NEG_MILLION, MILLION, BigDecimal.ZERO);
        checkAdd(NEG_MILLION, MAX_CALC_MINUS_ONE, new BigDecimal("9999999998999998"));
        checkAdd(NEG_MILLION, MAX_CALC, new BigDecimal("9999999998999999"));
        checkAdd(NEG_MILLION, MAX_CALC_PLUS_ONE, new BigDecimal("9999999999000000"));

        //first is -1000
        checkAdd(NEG_THOUSAND, MIN_CALC_MINUS_ONE, new BigDecimal("-10000000000001000"));
        checkAdd(NEG_THOUSAND, MIN_CALC, new BigDecimal("-10000000000000999"));
        checkAdd(NEG_THOUSAND, MIN_CALC_PLUS_ONE, new BigDecimal("-10000000000000998"));
        checkAdd(NEG_THOUSAND, NEG_MILLION, new BigDecimal("-1001000"));
        checkAdd(NEG_THOUSAND, NEG_THOUSAND, new BigDecimal("-2000"));
        checkAdd(NEG_THOUSAND, NEG_HUNDRED, new BigDecimal("-1100"));
        checkAdd(NEG_THOUSAND, NEG_TEN, new BigDecimal("-1010"));
        checkAdd(NEG_THOUSAND, NEG_TWO, new BigDecimal("-1002"));
        checkAdd(NEG_THOUSAND, NEG_ONE, new BigDecimal("-1001"));

        checkAdd(NEG_THOUSAND, BigDecimal.ZERO, NEG_THOUSAND);

        checkAdd(NEG_THOUSAND, BigDecimal.ONE, new BigDecimal("-999"));
        checkAdd(NEG_THOUSAND, TWO, new BigDecimal("-998"));
        checkAdd(NEG_THOUSAND, BigDecimal.TEN, new BigDecimal("-990"));
        checkAdd(NEG_THOUSAND, HUNDRED, new BigDecimal("-900"));
        checkAdd(NEG_THOUSAND, THOUSAND, BigDecimal.ZERO);
        checkAdd(NEG_THOUSAND, MILLION, new BigDecimal("999000"));
        checkAdd(NEG_THOUSAND, MAX_CALC_MINUS_ONE, new BigDecimal("9999999999998998"));
        checkAdd(NEG_THOUSAND, MAX_CALC, new BigDecimal("9999999999998999"));
        checkAdd(NEG_THOUSAND, MAX_CALC_PLUS_ONE, new BigDecimal("9999999999999000"));

        //first is -100
        checkAdd(NEG_HUNDRED, MIN_CALC_MINUS_ONE, new BigDecimal("-10000000000000100"));
        checkAdd(NEG_HUNDRED, MIN_CALC, new BigDecimal("-10000000000000099"));
        checkAdd(NEG_HUNDRED, MIN_CALC_PLUS_ONE, new BigDecimal("-10000000000000098"));
        checkAdd(NEG_HUNDRED, NEG_MILLION, new BigDecimal("-1000100"));
        checkAdd(NEG_HUNDRED, NEG_THOUSAND, new BigDecimal("-1100"));
        checkAdd(NEG_HUNDRED, NEG_HUNDRED, new BigDecimal("-200"));
        checkAdd(NEG_HUNDRED, NEG_TEN, new BigDecimal("-110"));
        checkAdd(NEG_HUNDRED, NEG_TWO, new BigDecimal("-102"));
        checkAdd(NEG_HUNDRED, NEG_ONE, new BigDecimal("-101"));

        checkAdd(NEG_HUNDRED, BigDecimal.ZERO, NEG_HUNDRED);

        checkAdd(NEG_HUNDRED, BigDecimal.ONE, new BigDecimal("-99"));
        checkAdd(NEG_HUNDRED, TWO, new BigDecimal("-98"));
        checkAdd(NEG_HUNDRED, BigDecimal.TEN, new BigDecimal("-90"));
        checkAdd(NEG_HUNDRED, HUNDRED, BigDecimal.ZERO);
        checkAdd(NEG_HUNDRED, THOUSAND, new BigDecimal("900"));
        checkAdd(NEG_HUNDRED, MILLION, new BigDecimal("999900"));
        checkAdd(NEG_HUNDRED, MAX_CALC_MINUS_ONE, new BigDecimal("9999999999999898"));
        checkAdd(NEG_HUNDRED, MAX_CALC, new BigDecimal("9999999999999899"));
        checkAdd(NEG_HUNDRED, MAX_CALC_PLUS_ONE, new BigDecimal("9999999999999900"));

        //first is -10
        checkAdd(NEG_TEN, MIN_CALC_MINUS_ONE, new BigDecimal("-10000000000000010"));
        checkAdd(NEG_TEN, MIN_CALC, new BigDecimal("-10000000000000009"));
        checkAdd(NEG_TEN, MIN_CALC_PLUS_ONE, new BigDecimal("-10000000000000008"));
        checkAdd(NEG_TEN, NEG_MILLION, new BigDecimal("-1000010"));
        checkAdd(NEG_TEN, NEG_THOUSAND, new BigDecimal("-1010"));
        checkAdd(NEG_TEN, NEG_HUNDRED, new BigDecimal("-110"));
        checkAdd(NEG_TEN, NEG_TEN, new BigDecimal("-20"));
        checkAdd(NEG_TEN, NEG_TWO, new BigDecimal("-12"));
        checkAdd(NEG_TEN, NEG_ONE, new BigDecimal("-11"));

        checkAdd(NEG_TEN, BigDecimal.ZERO, NEG_TEN);

        checkAdd(NEG_TEN, BigDecimal.ONE, new BigDecimal("-9"));
        checkAdd(NEG_TEN, TWO, new BigDecimal("-8"));
        checkAdd(NEG_TEN, BigDecimal.TEN, BigDecimal.ZERO);
        checkAdd(NEG_TEN, HUNDRED, new BigDecimal("90"));
        checkAdd(NEG_TEN, THOUSAND, new BigDecimal("990"));
        checkAdd(NEG_TEN, MILLION, new BigDecimal("999990"));
        checkAdd(NEG_TEN, MAX_CALC_MINUS_ONE, new BigDecimal("9999999999999988"));
        checkAdd(NEG_TEN, MAX_CALC, new BigDecimal("9999999999999989"));
        checkAdd(NEG_TEN, MAX_CALC_PLUS_ONE, new BigDecimal("9999999999999990"));

        //first is -2
        checkAdd(NEG_TWO, MIN_CALC_MINUS_ONE, new BigDecimal("-10000000000000002"));
        checkAdd(NEG_TWO, MIN_CALC, new BigDecimal("-10000000000000001"));
        checkAdd(NEG_TWO, MIN_CALC_PLUS_ONE, MIN_CALC_MINUS_ONE);
        checkAdd(NEG_TWO, NEG_MILLION, new BigDecimal("-1000002"));
        checkAdd(NEG_TWO, NEG_THOUSAND, new BigDecimal("-1002"));
        checkAdd(NEG_TWO, NEG_HUNDRED, new BigDecimal("-102"));
        checkAdd(NEG_TWO, NEG_TEN, new BigDecimal("-12"));
        checkAdd(NEG_TWO, NEG_TWO, new BigDecimal("-4"));
        checkAdd(NEG_TWO, NEG_ONE, new BigDecimal("-3"));

        checkAdd(NEG_TWO, BigDecimal.ZERO, NEG_TWO);

        checkAdd(NEG_TWO, BigDecimal.ONE, NEG_ONE);
        checkAdd(NEG_TWO, TWO, BigDecimal.ZERO);
        checkAdd(NEG_TWO, BigDecimal.TEN, new BigDecimal("8"));
        checkAdd(NEG_TWO, HUNDRED, new BigDecimal("98"));
        checkAdd(NEG_TWO, THOUSAND, new BigDecimal("998"));
        checkAdd(NEG_TWO, MILLION, new BigDecimal("999998"));
        checkAdd(NEG_TWO, MAX_CALC_MINUS_ONE, new BigDecimal("9999999999999996"));
        checkAdd(NEG_TWO, MAX_CALC, new BigDecimal("9999999999999997"));
        checkAdd(NEG_TWO, MAX_CALC_PLUS_ONE, MAX_CALC_MINUS_ONE);

        //first is -1
        checkAdd(NEG_ONE, MIN_CALC_MINUS_ONE, new BigDecimal("-10000000000000001"));
        checkAdd(NEG_ONE, MIN_CALC, MIN_CALC_MINUS_ONE);
        checkAdd(NEG_ONE, MIN_CALC_PLUS_ONE, MIN_CALC);
        checkAdd(NEG_ONE, NEG_MILLION, new BigDecimal("-1000001"));
        checkAdd(NEG_ONE, NEG_THOUSAND, new BigDecimal("-1001"));
        checkAdd(NEG_ONE, NEG_HUNDRED, new BigDecimal("-101"));
        checkAdd(NEG_ONE, NEG_TEN, new BigDecimal("-11"));
        checkAdd(NEG_ONE, NEG_TWO, new BigDecimal("-3"));
        checkAdd(NEG_ONE, NEG_ONE, NEG_TWO);

        checkAdd(NEG_ONE, BigDecimal.ZERO, NEG_ONE);

        checkAdd(NEG_ONE, BigDecimal.ONE, BigDecimal.ZERO);
        checkAdd(NEG_ONE, TWO, BigDecimal.ONE);
        checkAdd(NEG_ONE, BigDecimal.TEN, new BigDecimal("9"));
        checkAdd(NEG_ONE, HUNDRED, new BigDecimal("99"));
        checkAdd(NEG_ONE, THOUSAND, new BigDecimal("999"));
        checkAdd(NEG_ONE, MILLION, new BigDecimal("999999"));
        checkAdd(NEG_ONE, MAX_CALC_MINUS_ONE, new BigDecimal("9999999999999997"));
        checkAdd(NEG_ONE, MAX_CALC, MAX_CALC_MINUS_ONE);
        checkAdd(NEG_ONE, MAX_CALC_PLUS_ONE, MAX_CALC);

        //first is 0
        checkAdd(BigDecimal.ZERO, MIN_CALC_MINUS_ONE, MIN_CALC_MINUS_ONE);
        checkAdd(BigDecimal.ZERO, MIN_CALC, MIN_CALC);
        checkAdd(BigDecimal.ZERO, MIN_CALC_PLUS_ONE, MIN_CALC_PLUS_ONE);
        checkAdd(BigDecimal.ZERO, NEG_MILLION, NEG_MILLION);
        checkAdd(BigDecimal.ZERO, NEG_THOUSAND, NEG_THOUSAND);
        checkAdd(BigDecimal.ZERO, NEG_HUNDRED, NEG_HUNDRED);
        checkAdd(BigDecimal.ZERO, NEG_TEN, NEG_TEN);
        checkAdd(BigDecimal.ZERO, NEG_TWO, NEG_TWO);
        checkAdd(BigDecimal.ZERO, NEG_ONE, NEG_ONE);

        checkAdd(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

        checkAdd(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE);
        checkAdd(BigDecimal.ZERO, TWO, TWO);
        checkAdd(BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
        checkAdd(BigDecimal.ZERO, HUNDRED, HUNDRED);
        checkAdd(BigDecimal.ZERO, THOUSAND, THOUSAND);
        checkAdd(BigDecimal.ZERO, MILLION, MILLION);
        checkAdd(BigDecimal.ZERO, MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE);
        checkAdd(BigDecimal.ZERO, MAX_CALC, MAX_CALC);
        checkAdd(BigDecimal.ZERO, MAX_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE);

        //first is 1
        checkAdd(BigDecimal.ONE, MIN_CALC_MINUS_ONE, MIN_CALC);
        checkAdd(BigDecimal.ONE, MIN_CALC, MIN_CALC_PLUS_ONE);
        checkAdd(BigDecimal.ONE, MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999997"));
        checkAdd(BigDecimal.ONE, NEG_MILLION, new BigDecimal("-999999"));
        checkAdd(BigDecimal.ONE, NEG_THOUSAND, new BigDecimal("-999"));
        checkAdd(BigDecimal.ONE, NEG_HUNDRED, new BigDecimal("-99"));
        checkAdd(BigDecimal.ONE, NEG_TEN, new BigDecimal("-9"));
        checkAdd(BigDecimal.ONE, NEG_TWO, NEG_ONE);
        checkAdd(BigDecimal.ONE, NEG_ONE, BigDecimal.ZERO);

        checkAdd(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE);

        checkAdd(BigDecimal.ONE, BigDecimal.ONE, TWO);
        checkAdd(BigDecimal.ONE, TWO, new BigDecimal("3"));
        checkAdd(BigDecimal.ONE, BigDecimal.TEN, new BigDecimal("11"));
        checkAdd(BigDecimal.ONE, HUNDRED, new BigDecimal("101"));
        checkAdd(BigDecimal.ONE, THOUSAND, new BigDecimal("1001"));
        checkAdd(BigDecimal.ONE, MILLION, new BigDecimal("1000001"));
        checkAdd(BigDecimal.ONE, MAX_CALC_MINUS_ONE, MAX_CALC);
        checkAdd(BigDecimal.ONE, MAX_CALC, MAX_CALC_PLUS_ONE);
        checkAdd(BigDecimal.ONE, MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000001"));

        //first is 2
        checkAdd(TWO, MIN_CALC_MINUS_ONE, MIN_CALC_PLUS_ONE);
        checkAdd(TWO, MIN_CALC, new BigDecimal("-9999999999999997"));
        checkAdd(TWO, MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999996"));
        checkAdd(TWO, NEG_MILLION, new BigDecimal("-999998"));
        checkAdd(TWO, NEG_THOUSAND, new BigDecimal("-998"));
        checkAdd(TWO, NEG_HUNDRED, new BigDecimal("-98"));
        checkAdd(TWO, NEG_TEN, new BigDecimal("-8"));
        checkAdd(TWO, NEG_TWO, BigDecimal.ZERO);
        checkAdd(TWO, NEG_ONE, BigDecimal.ONE);

        checkAdd(TWO, BigDecimal.ZERO, TWO);

        checkAdd(TWO, BigDecimal.ONE, new BigDecimal("3"));
        checkAdd(TWO, TWO, new BigDecimal("4"));
        checkAdd(TWO, BigDecimal.TEN, new BigDecimal("12"));
        checkAdd(TWO, HUNDRED, new BigDecimal("102"));
        checkAdd(TWO, THOUSAND, new BigDecimal("1002"));
        checkAdd(TWO, MILLION, new BigDecimal("1000002"));
        checkAdd(TWO, MAX_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE);
        checkAdd(TWO, MAX_CALC, new BigDecimal("10000000000000001"));
        checkAdd(TWO, MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000002"));

        //first is 10
        checkAdd(BigDecimal.TEN, MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999999990"));
        checkAdd(BigDecimal.TEN, MIN_CALC, new BigDecimal("-9999999999999989"));
        checkAdd(BigDecimal.TEN, MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999988"));
        checkAdd(BigDecimal.TEN, NEG_MILLION, new BigDecimal("-999990"));
        checkAdd(BigDecimal.TEN, NEG_THOUSAND, new BigDecimal("-990"));
        checkAdd(BigDecimal.TEN, NEG_HUNDRED, new BigDecimal("-90"));
        checkAdd(BigDecimal.TEN, NEG_TEN, BigDecimal.ZERO);
        checkAdd(BigDecimal.TEN, NEG_TWO, new BigDecimal("8"));
        checkAdd(BigDecimal.TEN, NEG_ONE, new BigDecimal("9"));

        checkAdd(BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN);

        checkAdd(BigDecimal.TEN, BigDecimal.ONE, new BigDecimal("11"));
        checkAdd(BigDecimal.TEN, TWO, new BigDecimal("12"));
        checkAdd(BigDecimal.TEN, BigDecimal.TEN, new BigDecimal("20"));
        checkAdd(BigDecimal.TEN, HUNDRED, new BigDecimal("110"));
        checkAdd(BigDecimal.TEN, THOUSAND, new BigDecimal("1010"));
        checkAdd(BigDecimal.TEN, MILLION, new BigDecimal("1000010"));
        checkAdd(BigDecimal.TEN, MAX_CALC_MINUS_ONE, new BigDecimal("10000000000000008"));
        checkAdd(BigDecimal.TEN, MAX_CALC, new BigDecimal("10000000000000009"));
        checkAdd(BigDecimal.TEN, MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000010"));

        //first is 100
        checkAdd(HUNDRED, MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999999900"));
        checkAdd(HUNDRED, MIN_CALC, new BigDecimal("-9999999999999899"));
        checkAdd(HUNDRED, MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999898"));
        checkAdd(HUNDRED, NEG_MILLION, new BigDecimal("-999900"));
        checkAdd(HUNDRED, NEG_THOUSAND, new BigDecimal("-900"));
        checkAdd(HUNDRED, NEG_HUNDRED, BigDecimal.ZERO);
        checkAdd(HUNDRED, NEG_TEN, new BigDecimal("90"));
        checkAdd(HUNDRED, NEG_TWO, new BigDecimal("98"));
        checkAdd(HUNDRED, NEG_ONE, new BigDecimal("99"));

        checkAdd(HUNDRED, BigDecimal.ZERO, HUNDRED);

        checkAdd(HUNDRED, BigDecimal.ONE, new BigDecimal("101"));
        checkAdd(HUNDRED, TWO, new BigDecimal("102"));
        checkAdd(HUNDRED, BigDecimal.TEN, new BigDecimal("110"));
        checkAdd(HUNDRED, HUNDRED, new BigDecimal("200"));
        checkAdd(HUNDRED, THOUSAND, new BigDecimal("1100"));
        checkAdd(HUNDRED, MILLION, new BigDecimal("1000100"));
        checkAdd(HUNDRED, MAX_CALC_MINUS_ONE, new BigDecimal("10000000000000098"));
        checkAdd(HUNDRED, MAX_CALC, new BigDecimal("10000000000000099"));
        checkAdd(HUNDRED, MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000100"));

        //first is 1000
        checkAdd(THOUSAND, MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999999000"));
        checkAdd(THOUSAND, MIN_CALC, new BigDecimal("-9999999999998999"));
        checkAdd(THOUSAND, MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999998998"));
        checkAdd(THOUSAND, NEG_MILLION, new BigDecimal("-999000"));
        checkAdd(THOUSAND, NEG_THOUSAND, BigDecimal.ZERO);
        checkAdd(THOUSAND, NEG_HUNDRED, new BigDecimal("900"));
        checkAdd(THOUSAND, NEG_TEN, new BigDecimal("990"));
        checkAdd(THOUSAND, NEG_TWO, new BigDecimal("998"));
        checkAdd(THOUSAND, NEG_ONE, new BigDecimal("999"));

        checkAdd(THOUSAND, BigDecimal.ZERO, THOUSAND);

        checkAdd(THOUSAND, BigDecimal.ONE, new BigDecimal("1001"));
        checkAdd(THOUSAND, TWO, new BigDecimal("1002"));
        checkAdd(THOUSAND, BigDecimal.TEN, new BigDecimal("1010"));
        checkAdd(THOUSAND, HUNDRED, new BigDecimal("1100"));
        checkAdd(THOUSAND, THOUSAND, new BigDecimal("2000"));
        checkAdd(THOUSAND, MILLION, new BigDecimal("1001000"));
        checkAdd(THOUSAND, MAX_CALC_MINUS_ONE, new BigDecimal("10000000000000998"));
        checkAdd(THOUSAND, MAX_CALC, new BigDecimal("10000000000000999"));
        checkAdd(THOUSAND, MAX_CALC_PLUS_ONE, new BigDecimal("10000000000001000"));

        //first is million
        checkAdd(MILLION, MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999000000"));
        checkAdd(MILLION, MIN_CALC, new BigDecimal("-9999999998999999"));
        checkAdd(MILLION, MIN_CALC_PLUS_ONE, new BigDecimal("-9999999998999998"));
        checkAdd(MILLION, NEG_MILLION, BigDecimal.ZERO);
        checkAdd(MILLION, NEG_THOUSAND, new BigDecimal("999000"));
        checkAdd(MILLION, NEG_HUNDRED, new BigDecimal("999900"));
        checkAdd(MILLION, NEG_TEN, new BigDecimal("999990"));
        checkAdd(MILLION, NEG_TWO, new BigDecimal("999998"));
        checkAdd(MILLION, NEG_ONE, new BigDecimal("999999"));

        checkAdd(MILLION, BigDecimal.ZERO, MILLION);

        checkAdd(MILLION, BigDecimal.ONE, new BigDecimal("1000001"));
        checkAdd(MILLION, TWO, new BigDecimal("1000002"));
        checkAdd(MILLION, BigDecimal.TEN, new BigDecimal("1000010"));
        checkAdd(MILLION, HUNDRED, new BigDecimal("1000100"));
        checkAdd(MILLION, THOUSAND, new BigDecimal("1001000"));
        checkAdd(MILLION, MILLION, new BigDecimal("2000000"));
        checkAdd(MILLION, MAX_CALC_MINUS_ONE, new BigDecimal("10000000000999998"));
        checkAdd(MILLION, MAX_CALC, new BigDecimal("10000000000999999"));
        checkAdd(MILLION, MAX_CALC_PLUS_ONE, new BigDecimal("10000000001000000"));

        //first is max calc value minus one
        checkAdd(MAX_CALC_MINUS_ONE, MIN_CALC_MINUS_ONE, NEG_TWO);
        checkAdd(MAX_CALC_MINUS_ONE, MIN_CALC, NEG_ONE);
        checkAdd(MAX_CALC_MINUS_ONE, MIN_CALC_PLUS_ONE, BigDecimal.ZERO);
        checkAdd(MAX_CALC_MINUS_ONE, NEG_MILLION, new BigDecimal("9999999998999998"));
        checkAdd(MAX_CALC_MINUS_ONE, NEG_THOUSAND, new BigDecimal("9999999999998998"));
        checkAdd(MAX_CALC_MINUS_ONE, NEG_HUNDRED, new BigDecimal("9999999999999898"));
        checkAdd(MAX_CALC_MINUS_ONE, NEG_TEN, new BigDecimal("9999999999999988"));
        checkAdd(MAX_CALC_MINUS_ONE, NEG_TWO, new BigDecimal("9999999999999996"));
        checkAdd(MAX_CALC_MINUS_ONE, NEG_ONE, new BigDecimal("9999999999999997"));

        checkAdd(MAX_CALC_MINUS_ONE, BigDecimal.ZERO, MAX_CALC_MINUS_ONE);

        checkAdd(MAX_CALC_MINUS_ONE, BigDecimal.ONE, MAX_CALC);
        checkAdd(MAX_CALC_MINUS_ONE, TWO, MAX_CALC_PLUS_ONE);
        checkAdd(MAX_CALC_MINUS_ONE, BigDecimal.TEN, new BigDecimal("10000000000000008"));
        checkAdd(MAX_CALC_MINUS_ONE, HUNDRED, new BigDecimal("10000000000000098"));
        checkAdd(MAX_CALC_MINUS_ONE, THOUSAND, new BigDecimal("10000000000000998"));
        checkAdd(MAX_CALC_MINUS_ONE, MILLION, new BigDecimal("10000000000999998"));
        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC_MINUS_ONE, new BigDecimal("19999999999999996"));
        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC, new BigDecimal("19999999999999997"));
        checkAdd(MAX_CALC_MINUS_ONE, MAX_CALC_PLUS_ONE, new BigDecimal("19999999999999998"));

        //first is max calc value
        checkAdd(MAX_CALC, MIN_CALC_MINUS_ONE, NEG_ONE);
        checkAdd(MAX_CALC, MIN_CALC, BigDecimal.ZERO);
        checkAdd(MAX_CALC, MIN_CALC_PLUS_ONE, BigDecimal.ONE);
        checkAdd(MAX_CALC, NEG_MILLION, new BigDecimal("9999999998999999"));
        checkAdd(MAX_CALC, NEG_THOUSAND, new BigDecimal("9999999999998999"));
        checkAdd(MAX_CALC, NEG_HUNDRED, new BigDecimal("9999999999999899"));
        checkAdd(MAX_CALC, NEG_TEN, new BigDecimal("9999999999999989"));
        checkAdd(MAX_CALC, NEG_TWO, new BigDecimal("9999999999999997"));
        checkAdd(MAX_CALC, NEG_ONE, MAX_CALC_MINUS_ONE);

        checkAdd(MAX_CALC, BigDecimal.ZERO, MAX_CALC);

        checkAdd(MAX_CALC, BigDecimal.ONE, MAX_CALC_PLUS_ONE);
        checkAdd(MAX_CALC, TWO, new BigDecimal("10000000000000001"));
        checkAdd(MAX_CALC, BigDecimal.TEN, new BigDecimal("10000000000000009"));
        checkAdd(MAX_CALC, HUNDRED, new BigDecimal("10000000000000099"));
        checkAdd(MAX_CALC, THOUSAND, new BigDecimal("10000000000000999"));
        checkAdd(MAX_CALC, MILLION, new BigDecimal("10000000000999999"));
        checkAdd(MAX_CALC, MAX_CALC_MINUS_ONE, new BigDecimal("19999999999999997"));
        checkAdd(MAX_CALC, MAX_CALC, new BigDecimal("19999999999999998"));
        checkAdd(MAX_CALC, MAX_CALC_PLUS_ONE, new BigDecimal("19999999999999999"));

        //first is max calc value plus one
        checkAdd(MAX_CALC_PLUS_ONE, MIN_CALC_MINUS_ONE, BigDecimal.ZERO);
        checkAdd(MAX_CALC_PLUS_ONE, MIN_CALC, BigDecimal.ONE);
        checkAdd(MAX_CALC_PLUS_ONE, MIN_CALC_PLUS_ONE, TWO);
        checkAdd(MAX_CALC_PLUS_ONE, NEG_MILLION, new BigDecimal("9999999999000000"));
        checkAdd(MAX_CALC_PLUS_ONE, NEG_THOUSAND, new BigDecimal("9999999999999000"));
        checkAdd(MAX_CALC_PLUS_ONE, NEG_HUNDRED, new BigDecimal("9999999999999900"));
        checkAdd(MAX_CALC_PLUS_ONE, NEG_TEN, new BigDecimal("9999999999999990"));
        checkAdd(MAX_CALC_PLUS_ONE, NEG_TWO, new BigDecimal("9999999999999998"));
        checkAdd(MAX_CALC_PLUS_ONE, NEG_ONE, MAX_CALC);

        checkAdd(MAX_CALC_PLUS_ONE, BigDecimal.ZERO, MAX_CALC_PLUS_ONE);

        checkAdd(MAX_CALC_PLUS_ONE, BigDecimal.ONE, new BigDecimal("10000000000000001"));
        checkAdd(MAX_CALC_PLUS_ONE, TWO, new BigDecimal("10000000000000002"));
        checkAdd(MAX_CALC_PLUS_ONE, BigDecimal.TEN, new BigDecimal("10000000000000010"));
        checkAdd(MAX_CALC_PLUS_ONE, HUNDRED, new BigDecimal("10000000000000100"));
        checkAdd(MAX_CALC_PLUS_ONE, THOUSAND, new BigDecimal("10000000000001000"));
        checkAdd(MAX_CALC_PLUS_ONE, MILLION, new BigDecimal("10000000001000000"));
        checkAdd(MAX_CALC_PLUS_ONE, MAX_CALC_MINUS_ONE, new BigDecimal("19999999999999998"));
        checkAdd(MAX_CALC_PLUS_ONE, MAX_CALC, new BigDecimal("19999999999999999"));
        checkAdd(MAX_CALC_PLUS_ONE, MAX_CALC_PLUS_ONE, new BigDecimal("20000000000000000"));
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
    }
}
