import com.implemica.bormashenko.calculator.model.CalculatorOperations;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

class ModelTest {

    private static final BigDecimal BIG_DEC_MIN_CALC_MINUS_ONE = new BigDecimal("-10000000000000000");
    private static final BigDecimal BIG_DEC_MIN_CALC = new BigDecimal("-9999999999999999");
    private static final BigDecimal BIG_DEC_MIN_CALC_PLUS_ONE = new BigDecimal("-9999999999999998");
    private static final BigDecimal BIG_DEC_NEG_BILLION = new BigDecimal("-1000000000");
    private static final BigDecimal BIG_DEC_NEG_MILLION = new BigDecimal("-1000000");
    private static final BigDecimal BIG_DEC_NEG_1000 = new BigDecimal("-1000");
    private static final BigDecimal BIG_DEC_NEG_100 = new BigDecimal("-100");
    private static final BigDecimal BIG_DEC_NEG_10 = new BigDecimal("-10");
    private static final BigDecimal BIG_DEC_NEG_2 = new BigDecimal("-2");
    private static final BigDecimal BIG_DEC_NEG_1 = new BigDecimal("-1");
    private static final BigDecimal BIG_DEC_2 = new BigDecimal("2");
    private static final BigDecimal BIG_DEC_100 = new BigDecimal("100");
    private static final BigDecimal BIG_DEC_1000 = new BigDecimal("1000");
    private static final BigDecimal BIG_DEC_MILLION = new BigDecimal("1000000");
    private static final BigDecimal BIG_DEC_BILLION = new BigDecimal("1000000000");
    private static final BigDecimal BIG_DEC_MAX_CALC_MINUS_ONE = new BigDecimal("9999999999999998");
    private static final BigDecimal BIG_DEC_MAX_CALC = new BigDecimal("9999999999999999");
    private static final BigDecimal BIG_DEC_MAX_CALC_PLUS_ONE = new BigDecimal("10000000000000000");

    @Test
    void tests() {
        //first is 0
        checkAdd(BigDecimal.ZERO, BIG_DEC_MIN_CALC_MINUS_ONE, BIG_DEC_MIN_CALC_MINUS_ONE);
        checkAdd(BigDecimal.ZERO, BIG_DEC_MIN_CALC, BIG_DEC_MIN_CALC);
        checkAdd(BigDecimal.ZERO, BIG_DEC_MIN_CALC_PLUS_ONE, BIG_DEC_MIN_CALC_PLUS_ONE);
        checkAdd(BigDecimal.ZERO, BIG_DEC_NEG_BILLION, BIG_DEC_NEG_BILLION);
        checkAdd(BigDecimal.ZERO, BIG_DEC_NEG_MILLION, BIG_DEC_NEG_MILLION);
        checkAdd(BigDecimal.ZERO, BIG_DEC_NEG_1000, BIG_DEC_NEG_1000);
        checkAdd(BigDecimal.ZERO, BIG_DEC_NEG_100, BIG_DEC_NEG_100);
        checkAdd(BigDecimal.ZERO, BIG_DEC_NEG_10, BIG_DEC_NEG_10);
        checkAdd(BigDecimal.ZERO, BIG_DEC_NEG_2, BIG_DEC_NEG_2);
        checkAdd(BigDecimal.ZERO, BIG_DEC_NEG_1, BIG_DEC_NEG_1);

        checkAdd(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

        checkAdd(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE);
        checkAdd(BigDecimal.ZERO, BIG_DEC_2, BIG_DEC_2);
        checkAdd(BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
        checkAdd(BigDecimal.ZERO, BIG_DEC_100, BIG_DEC_100);
        checkAdd(BigDecimal.ZERO, BIG_DEC_1000, BIG_DEC_1000);
        checkAdd(BigDecimal.ZERO, BIG_DEC_MILLION, BIG_DEC_MILLION);
        checkAdd(BigDecimal.ZERO, BIG_DEC_BILLION, BIG_DEC_BILLION);
        checkAdd(BigDecimal.ZERO, BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MAX_CALC_MINUS_ONE);
        checkAdd(BigDecimal.ZERO, BIG_DEC_MAX_CALC, BIG_DEC_MAX_CALC);
        checkAdd(BigDecimal.ZERO, BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MAX_CALC_PLUS_ONE);

        //first is 1
        checkAdd(BigDecimal.ONE, BIG_DEC_MIN_CALC_MINUS_ONE, BIG_DEC_MIN_CALC);
        checkAdd(BigDecimal.ONE, BIG_DEC_MIN_CALC, BIG_DEC_MIN_CALC_PLUS_ONE);
        checkAdd(BigDecimal.ONE, BIG_DEC_MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999997"));
        checkAdd(BigDecimal.ONE, BIG_DEC_NEG_BILLION, new BigDecimal("-999999999"));
        checkAdd(BigDecimal.ONE, BIG_DEC_NEG_MILLION, new BigDecimal("-999999"));
        checkAdd(BigDecimal.ONE, BIG_DEC_NEG_1000, new BigDecimal("-999"));
        checkAdd(BigDecimal.ONE, BIG_DEC_NEG_100, new BigDecimal("-99"));
        checkAdd(BigDecimal.ONE, BIG_DEC_NEG_10, new BigDecimal("-9"));
        checkAdd(BigDecimal.ONE, BIG_DEC_NEG_2, BIG_DEC_NEG_1);
        checkAdd(BigDecimal.ONE, BIG_DEC_NEG_1, BigDecimal.ZERO);

        checkAdd(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE);

        checkAdd(BigDecimal.ONE, BigDecimal.ONE, BIG_DEC_2);
        checkAdd(BigDecimal.ONE, BIG_DEC_2, new BigDecimal("3"));
        checkAdd(BigDecimal.ONE, BigDecimal.TEN, new BigDecimal("11"));
        checkAdd(BigDecimal.ONE, BIG_DEC_100, new BigDecimal("101"));
        checkAdd(BigDecimal.ONE, BIG_DEC_1000, new BigDecimal("1001"));
        checkAdd(BigDecimal.ONE, BIG_DEC_MILLION, new BigDecimal("1000001"));
        checkAdd(BigDecimal.ONE, BIG_DEC_BILLION, new BigDecimal("1000000001"));
        checkAdd(BigDecimal.ONE, BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MAX_CALC);
        checkAdd(BigDecimal.ONE, BIG_DEC_MAX_CALC, BIG_DEC_MAX_CALC_PLUS_ONE);
        checkAdd(BigDecimal.ONE, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000001"));

        //first is 2
        checkAdd(BIG_DEC_2, BIG_DEC_MIN_CALC_MINUS_ONE, BIG_DEC_MIN_CALC_PLUS_ONE);
        checkAdd(BIG_DEC_2, BIG_DEC_MIN_CALC, new BigDecimal("-9999999999999997"));
        checkAdd(BIG_DEC_2, BIG_DEC_MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999996"));
        checkAdd(BIG_DEC_2, BIG_DEC_NEG_BILLION, new BigDecimal("-999999998"));
        checkAdd(BIG_DEC_2, BIG_DEC_NEG_MILLION, new BigDecimal("-999998"));
        checkAdd(BIG_DEC_2, BIG_DEC_NEG_1000, new BigDecimal("-998"));
        checkAdd(BIG_DEC_2, BIG_DEC_NEG_100, new BigDecimal("-98"));
        checkAdd(BIG_DEC_2, BIG_DEC_NEG_10, new BigDecimal("-8"));
        checkAdd(BIG_DEC_2, BIG_DEC_NEG_2, BigDecimal.ZERO);
        checkAdd(BIG_DEC_2, BIG_DEC_NEG_1, BigDecimal.ONE);

        checkAdd(BIG_DEC_2, BigDecimal.ZERO, BIG_DEC_2);

        checkAdd(BIG_DEC_2, BigDecimal.ONE, new BigDecimal("3"));
        checkAdd(BIG_DEC_2, BIG_DEC_2, new BigDecimal("4"));
        checkAdd(BIG_DEC_2, BigDecimal.TEN, new BigDecimal("12"));
        checkAdd(BIG_DEC_2, BIG_DEC_100, new BigDecimal("102"));
        checkAdd(BIG_DEC_2, BIG_DEC_1000, new BigDecimal("1002"));
        checkAdd(BIG_DEC_2, BIG_DEC_MILLION, new BigDecimal("1000002"));
        checkAdd(BIG_DEC_2, BIG_DEC_BILLION, new BigDecimal("1000000002"));
        checkAdd(BIG_DEC_2, BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MAX_CALC_PLUS_ONE);
        checkAdd(BIG_DEC_2, BIG_DEC_MAX_CALC, new BigDecimal("10000000000000001"));
        checkAdd(BIG_DEC_2, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000002"));

        //first is 10
        checkAdd(BigDecimal.TEN, BIG_DEC_MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999999990"));
        checkAdd(BigDecimal.TEN, BIG_DEC_MIN_CALC, new BigDecimal("-9999999999999989"));
        checkAdd(BigDecimal.TEN, BIG_DEC_MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999988"));
        checkAdd(BigDecimal.TEN, BIG_DEC_NEG_BILLION, new BigDecimal("-999999990"));
        checkAdd(BigDecimal.TEN, BIG_DEC_NEG_MILLION,  new BigDecimal("-999990"));
        checkAdd(BigDecimal.TEN, BIG_DEC_NEG_1000,  new BigDecimal("-990"));
        checkAdd(BigDecimal.TEN, BIG_DEC_NEG_100,  new BigDecimal("-90"));
        checkAdd(BigDecimal.TEN, BIG_DEC_NEG_10, BigDecimal.ZERO);
        checkAdd(BigDecimal.TEN, BIG_DEC_NEG_2,  new BigDecimal("8"));
        checkAdd(BigDecimal.TEN, BIG_DEC_NEG_1,  new BigDecimal("9"));

        checkAdd(BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN);

        checkAdd(BigDecimal.TEN, BigDecimal.ONE, new BigDecimal("11"));
        checkAdd(BigDecimal.TEN, BIG_DEC_2, new BigDecimal("12"));
        checkAdd(BigDecimal.TEN, BigDecimal.TEN, new BigDecimal("20"));
        checkAdd(BigDecimal.TEN, BIG_DEC_100, new BigDecimal("110"));
        checkAdd(BigDecimal.TEN, BIG_DEC_1000, new BigDecimal("1010"));
        checkAdd(BigDecimal.TEN, BIG_DEC_MILLION, new BigDecimal("1000010"));
        checkAdd(BigDecimal.TEN, BIG_DEC_BILLION, new BigDecimal("1000000010"));
        checkAdd(BigDecimal.TEN, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("10000000000000008"));
        checkAdd(BigDecimal.TEN, BIG_DEC_MAX_CALC, new BigDecimal("10000000000000009"));
        checkAdd(BigDecimal.TEN, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000010"));

        //first is 100
        checkAdd(BIG_DEC_100, BIG_DEC_MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999999900"));
        checkAdd(BIG_DEC_100, BIG_DEC_MIN_CALC, new BigDecimal("-9999999999999899"));
        checkAdd(BIG_DEC_100, BIG_DEC_MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999999898"));
        checkAdd(BIG_DEC_100, BIG_DEC_NEG_BILLION, new BigDecimal("-999999900"));
        checkAdd(BIG_DEC_100, BIG_DEC_NEG_MILLION, new BigDecimal("-999900"));
        checkAdd(BIG_DEC_100, BIG_DEC_NEG_1000, new BigDecimal("-900"));
        checkAdd(BIG_DEC_100, BIG_DEC_NEG_100, BigDecimal.ZERO);
        checkAdd(BIG_DEC_100, BIG_DEC_NEG_10, new BigDecimal("90"));
        checkAdd(BIG_DEC_100, BIG_DEC_NEG_2, new BigDecimal("98"));
        checkAdd(BIG_DEC_100, BIG_DEC_NEG_1, new BigDecimal("99"));

        checkAdd(BIG_DEC_100, BigDecimal.ZERO, BIG_DEC_100);

        checkAdd(BIG_DEC_100, BigDecimal.ONE, new BigDecimal("101"));
        checkAdd(BIG_DEC_100, BIG_DEC_2, new BigDecimal("102"));
        checkAdd(BIG_DEC_100, BigDecimal.TEN, new BigDecimal("110"));
        checkAdd(BIG_DEC_100, BIG_DEC_100, new BigDecimal("200"));
        checkAdd(BIG_DEC_100, BIG_DEC_1000, new BigDecimal("1100"));
        checkAdd(BIG_DEC_100, BIG_DEC_MILLION, new BigDecimal("1000100"));
        checkAdd(BIG_DEC_100, BIG_DEC_BILLION, new BigDecimal("1000000100"));
        checkAdd(BIG_DEC_100, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("10000000000000098"));
        checkAdd(BIG_DEC_100, BIG_DEC_MAX_CALC, new BigDecimal("10000000000000099"));
        checkAdd(BIG_DEC_100, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("10000000000000100"));

        //first is 1000
        checkAdd(BIG_DEC_1000, BIG_DEC_MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999999000"));
        checkAdd(BIG_DEC_1000, BIG_DEC_MIN_CALC, new BigDecimal("-9999999999998999"));
        checkAdd(BIG_DEC_1000, BIG_DEC_MIN_CALC_PLUS_ONE, new BigDecimal("-9999999999998998"));
        checkAdd(BIG_DEC_1000, BIG_DEC_NEG_BILLION, new BigDecimal("-999999000"));
        checkAdd(BIG_DEC_1000, BIG_DEC_NEG_MILLION, new BigDecimal("-999000"));
        checkAdd(BIG_DEC_1000, BIG_DEC_NEG_1000, BigDecimal.ZERO);
        checkAdd(BIG_DEC_1000, BIG_DEC_NEG_100, new BigDecimal("900"));
        checkAdd(BIG_DEC_1000, BIG_DEC_NEG_10, new BigDecimal("990"));
        checkAdd(BIG_DEC_1000, BIG_DEC_NEG_2, new BigDecimal("998"));
        checkAdd(BIG_DEC_1000, BIG_DEC_NEG_1, new BigDecimal("999"));

        checkAdd(BIG_DEC_1000, BigDecimal.ZERO, BIG_DEC_1000);

        checkAdd(BIG_DEC_1000, BigDecimal.ONE, new BigDecimal("1001"));
        checkAdd(BIG_DEC_1000, BIG_DEC_2, new BigDecimal("1002"));
        checkAdd(BIG_DEC_1000, BigDecimal.TEN, new BigDecimal("1010"));
        checkAdd(BIG_DEC_1000, BIG_DEC_100, new BigDecimal("1100"));
        checkAdd(BIG_DEC_1000, BIG_DEC_1000, new BigDecimal("2000"));
        checkAdd(BIG_DEC_1000, BIG_DEC_MILLION, new BigDecimal("1001000"));
        checkAdd(BIG_DEC_1000, BIG_DEC_BILLION, new BigDecimal("1000001000"));
        checkAdd(BIG_DEC_1000, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("10000000000000998"));
        checkAdd(BIG_DEC_1000, BIG_DEC_MAX_CALC, new BigDecimal("10000000000000999"));
        checkAdd(BIG_DEC_1000, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("10000000000001000"));

        //first is million
        checkAdd(BIG_DEC_MILLION, BIG_DEC_MIN_CALC_MINUS_ONE, new BigDecimal("-9999999999000000"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_MIN_CALC, new BigDecimal("-9999999998999999"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_MIN_CALC_PLUS_ONE, new BigDecimal("-9999999998999998"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_NEG_BILLION, new BigDecimal("-999000000"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_NEG_MILLION, BigDecimal.ZERO);
        checkAdd(BIG_DEC_MILLION, BIG_DEC_NEG_1000, new BigDecimal("999000"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_NEG_100, new BigDecimal("999900"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_NEG_10, new BigDecimal("999990"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_NEG_2, new BigDecimal("999998"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_NEG_1, new BigDecimal("999999"));

        checkAdd(BIG_DEC_MILLION, BigDecimal.ZERO, BIG_DEC_MILLION);

        checkAdd(BIG_DEC_MILLION, BigDecimal.ONE, new BigDecimal("1000001"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_2, new BigDecimal("1000002"));
        checkAdd(BIG_DEC_MILLION, BigDecimal.TEN, new BigDecimal("1000010"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_100, new BigDecimal("1000100"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_1000, new BigDecimal("1001000"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_MILLION, new BigDecimal("2000000"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_BILLION, new BigDecimal("1001000000"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("10000000000999998"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_MAX_CALC, new BigDecimal("10000000000999999"));
        checkAdd(BIG_DEC_MILLION, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("10000000001000000"));

        //first is billion
        checkAdd(BIG_DEC_BILLION, BIG_DEC_MIN_CALC_MINUS_ONE, new BigDecimal("-9999999000000000"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_MIN_CALC, new BigDecimal("-9999998999999999"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_MIN_CALC_PLUS_ONE, new BigDecimal("-9999998999999998"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_NEG_BILLION, BigDecimal.ZERO);
        checkAdd(BIG_DEC_BILLION, BIG_DEC_NEG_MILLION, new BigDecimal("999000000"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_NEG_1000, new BigDecimal("999999000"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_NEG_100, new BigDecimal("999999900"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_NEG_10, new BigDecimal("999999990"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_NEG_2, new BigDecimal("999999998"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_NEG_1, new BigDecimal("999999999"));

        checkAdd(BIG_DEC_BILLION, BigDecimal.ZERO, BIG_DEC_BILLION);

        checkAdd(BIG_DEC_BILLION, BigDecimal.ONE, new BigDecimal("1000000001"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_2, new BigDecimal("1000000002"));
        checkAdd(BIG_DEC_BILLION, BigDecimal.TEN, new BigDecimal("1000000010"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_100, new BigDecimal("1000000100"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_1000, new BigDecimal("1000001000"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_MILLION, new BigDecimal("1001000000"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_BILLION, new BigDecimal("2000000000"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("10000000999999998"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_MAX_CALC, new BigDecimal("10000000999999999"));
        checkAdd(BIG_DEC_BILLION, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("10000001000000000"));

        //first is max calc value minus one
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MIN_CALC_MINUS_ONE, BIG_DEC_NEG_2);
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MIN_CALC, BIG_DEC_NEG_1);
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MIN_CALC_PLUS_ONE, BigDecimal.ZERO);
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_NEG_BILLION, new BigDecimal("9999998999999998"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_NEG_MILLION, new BigDecimal("9999999998999998"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_NEG_1000, new BigDecimal("9999999999998998"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_NEG_100, new BigDecimal("9999999999999898"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_NEG_10, new BigDecimal("9999999999999988"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_NEG_2, new BigDecimal("9999999999999996"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_NEG_1, new BigDecimal("9999999999999997"));

        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BigDecimal.ZERO, BIG_DEC_MAX_CALC_MINUS_ONE);

        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BigDecimal.ONE, BIG_DEC_MAX_CALC);
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_2, BIG_DEC_MAX_CALC_PLUS_ONE);
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BigDecimal.TEN, new BigDecimal("10000000000000008"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_100, new BigDecimal("10000000000000098"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_1000, new BigDecimal("10000000000000998"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MILLION, new BigDecimal("10000000000999998"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_BILLION, new BigDecimal("10000000999999998"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("19999999999999996"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MAX_CALC, new BigDecimal("19999999999999997"));
        checkAdd(BIG_DEC_MAX_CALC_MINUS_ONE, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("19999999999999998"));

        //first is max calc value
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_MIN_CALC_MINUS_ONE, BIG_DEC_NEG_1);
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_MIN_CALC, BigDecimal.ZERO);
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_MIN_CALC_PLUS_ONE, BigDecimal.ONE);
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_NEG_BILLION, new BigDecimal("9999998999999999"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_NEG_MILLION, new BigDecimal("9999999998999999"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_NEG_1000, new BigDecimal("9999999999998999"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_NEG_100, new BigDecimal("9999999999999899"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_NEG_10, new BigDecimal("9999999999999989"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_NEG_2, new BigDecimal("9999999999999997"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_NEG_1, BIG_DEC_MAX_CALC_MINUS_ONE);

        checkAdd(BIG_DEC_MAX_CALC, BigDecimal.ZERO, BIG_DEC_MAX_CALC);

        checkAdd(BIG_DEC_MAX_CALC, BigDecimal.ONE, BIG_DEC_MAX_CALC_PLUS_ONE);
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_2, new BigDecimal("10000000000000001"));
        checkAdd(BIG_DEC_MAX_CALC, BigDecimal.TEN, new BigDecimal("10000000000000009"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_100, new BigDecimal("10000000000000099"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_1000, new BigDecimal("10000000000000999"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_MILLION, new BigDecimal("10000000000999999"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_BILLION, new BigDecimal("10000000999999999"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("19999999999999997"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_MAX_CALC, new BigDecimal("19999999999999998"));
        checkAdd(BIG_DEC_MAX_CALC, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("19999999999999999"));

        //first is max calc value plus one
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MIN_CALC_MINUS_ONE, BigDecimal.ZERO);
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MIN_CALC, BigDecimal.ONE);
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MIN_CALC_PLUS_ONE, BIG_DEC_2);
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_NEG_BILLION, new BigDecimal("9999999000000000"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_NEG_MILLION, new BigDecimal("9999999999000000"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_NEG_1000, new BigDecimal("9999999999999000"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_NEG_100, new BigDecimal("9999999999999900"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_NEG_10, new BigDecimal("9999999999999990"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_NEG_2, new BigDecimal("9999999999999998"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_NEG_1, BIG_DEC_MAX_CALC);

        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BigDecimal.ZERO, BIG_DEC_MAX_CALC_PLUS_ONE);

        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BigDecimal.ONE, new BigDecimal("10000000000000001"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_2, new BigDecimal("10000000000000002"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BigDecimal.TEN, new BigDecimal("10000000000000010"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_100, new BigDecimal("10000000000000100"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_1000, new BigDecimal("10000000000001000"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MILLION, new BigDecimal("10000000001000000"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_BILLION, new BigDecimal("10000001000000000"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MAX_CALC_MINUS_ONE, new BigDecimal("19999999999999998"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MAX_CALC, new BigDecimal("19999999999999999"));
        checkAdd(BIG_DEC_MAX_CALC_PLUS_ONE, BIG_DEC_MAX_CALC_PLUS_ONE, new BigDecimal("20000000000000000"));
    }


    private void checkAdd(BigDecimal firstValue, BigDecimal secondValue, BigDecimal expected) {
        assertEquals(expected, CalculatorOperations.add(firstValue, secondValue));
    }
}
