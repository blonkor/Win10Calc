package Model;

import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperations;
import com.implemica.bormashenko.calculator.model.exceptions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static com.implemica.bormashenko.calculator.model.enums.BinaryOperations.*;
import static com.implemica.bormashenko.calculator.model.enums.UnaryOperations.*;

/**
 * Test class for model of calculation.
 *
 * @author Mykhailo Bormashenko
 */
class CalculationModelTest {

    /**
     * Object of model.
     */
    private static Calculation calculation;

    /**
     * Big decimal value of minimal value that can be shown in view minus one.
     */
    private static final BigDecimal MIN_VALUE_ON_SCREEN_MINUS_ONE = new BigDecimal("-10000000000000000");

    /**
     * Big decimal value of minimal value that can be shown in view.
     */
    private static final BigDecimal MIN_VALUE_ON_SCREEN = new BigDecimal("-9999999999999999");

    /**
     * Big decimal value of minimal value that can be shown in view plus one.
     */
    private static final BigDecimal MIN_VALUE_ON_SCREEN_PLUS_ONE = new BigDecimal("-9999999999999998");

    /**
     * Big decimal value of minimal value that can be shown in view divide by two.
     */
    private static final BigDecimal HALF_MIN_VALUE_ON_SCREEN = new BigDecimal("-5000000000000000");

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
     * Big decimal value of maximal value that can be shown in view divide by two.
     */
    private static final BigDecimal HALF_MAX_VALUE_ON_SCREEN = new BigDecimal("5000000000000000");

    /**
     * Big decimal value of maximal value that can be shown in view minus one.
     */
    private static final BigDecimal MAX_VALUE_ON_SCREEN_MINUS_ONE = new BigDecimal("9999999999999998");

    /**
     * Big decimal value of maximal value that can be shown in view.
     */
    private static final BigDecimal MAX_VALUE_ON_SCREEN = new BigDecimal("9999999999999999");

    /**
     * Big decimal value of maximal value that can be shown in view plus one.
     */
    private static final BigDecimal MAX_VALUE_ON_SCREEN_PLUS_ONE = new BigDecimal("10000000000000000");

    /**
     * Big decimal value of -0.99999999999999999.
     */
    private static final BigDecimal NEG_ZERO_DOT_17_NINES = new BigDecimal("-0.99999999999999999");

    /**
     * Big decimal value of -0.9999999999999999.
     */
    private static final BigDecimal NEG_ZERO_DOT_16_NINES = new BigDecimal("-0.9999999999999999");

    /**
     * Big decimal value of -0.99.
     */
    private static final BigDecimal NEG_NINETY_NINE_HUNDREDTH = new BigDecimal("-0.99");

    /**
     * Big decimal value of -0.9.
     */
    private static final BigDecimal NEG_NINE_TENTH = new BigDecimal("-0.9");

    /**
     * Big decimal value of -0.1.
     */
    private static final BigDecimal NEG_ONE_TENTH = new BigDecimal("-0.1");

    /**
     * Big decimal value of -0.09.
     */
    private static final BigDecimal NEG_NINE_HUNDREDTH = new BigDecimal("-0.09");

    /**
     * Big decimal value of -0.01.
     */
    private static final BigDecimal NEG_ONE_HUNDREDTH = new BigDecimal("-0.01");

    /**
     * Big decimal value of 0.01.
     */
    private static final BigDecimal ONE_HUNDREDTH = new BigDecimal("0.01");

    /**
     * Big decimal value of 0.09.
     */
    private static final BigDecimal NINE_HUNDREDTH = new BigDecimal("0.09");

    /**
     * Big decimal value of 0.1.
     */
    private static final BigDecimal ONE_TENTH = new BigDecimal("0.1");

    /**
     * Big decimal value of 0.9.
     */
    private static final BigDecimal NINE_TENTH = new BigDecimal("0.9");

    /**
     * Big decimal value of 0.99.
     */
    private static final BigDecimal NINETY_NINE_HUNDREDTH = new BigDecimal("0.99");

    /**
     * Big decimal value of 0.9999999999999999.
     */
    private static final BigDecimal ZERO_DOT_16_NINES = new BigDecimal("0.9999999999999999");

    /**
     * Big decimal value of 0.99999999999999999.
     */
    private static final BigDecimal ZERO_DOT_17_NINES = new BigDecimal("0.99999999999999999");

    /**
     * Big decimal value of -1.e+9999 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_PLUS_9999 = new BigDecimal("-1.e+9999");

    /**
     * Big decimal value of -1.e+9998 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_PLUS_9998 = new BigDecimal("-1.e+9998");

    /**
     * Big decimal value of 1.e+9998 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_PLUS_9998 = new BigDecimal("1.e+9998");

    /**
     * Big decimal value of 1.e+9999 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_PLUS_9999 = new BigDecimal("1.e+9999");

    /**
     * Big decimal value of -1.e+17 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_PLUS_17 = new BigDecimal("-1.e+17");

    /**
     * Big decimal value of -1.e+16 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_PLUS_16 = new BigDecimal("-1.e+16");

    /**
     * Big decimal value of 1.e+16 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_PLUS_16 = new BigDecimal("1.e+16");

    /**
     * Big decimal value of 1.e+17 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_PLUS_17 = new BigDecimal("1.e+17");

    /**
     * Big decimal value of -1.e-9999 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_MINUS_9999 = new BigDecimal("-1.e-9999");

    /**
     * Big decimal value of -1.e-9998 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_MINUS_9998 = new BigDecimal("-1.e-9998");

    /**
     * Big decimal value of 1.e-9998 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_MINUS_9998 = new BigDecimal("1.e-9998");

    /**
     * Big decimal value of 1.e-9999 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_MINUS_9999 = new BigDecimal("1.e-9999");

    /**
     * Big decimal value of -1.e-17 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_MINUS_17 = new BigDecimal("-1.e-17");

    /**
     * Big decimal value of -1.e-16 as engineering string.
     */
    private static final BigDecimal NEG_ONE_DOT_E_MINUS_16 = new BigDecimal("-1.e-16");

    /**
     * Big decimal value of 1.e-16 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_MINUS_16 = new BigDecimal("1.e-16");

    /**
     * Big decimal value of 1.e-16 as engineering string.
     */
    private static final BigDecimal ONE_DOT_E_MINUS_17 = new BigDecimal("1.e-17");

    /**
     * Setting up an object of model.
     *
     * @see Calculation
     */
    @BeforeAll
    static void setUpObject() {
        calculation = new Calculation();
    }

    /**
     * Tests for binary add operation.
     *
     * @see BinaryOperations
     */
    @Test
    void addOperationTests() {
        //integers only
        {
            //first is -10000000000000000
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-2.e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, ADD, "-19999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-19999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, ADD, "-1.5e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, ADD, "-1.00000000000001e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, ADD, "-1.000000000000001e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, ADD, "-10000000000000001");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, ADD, "-1.e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, ADD, "-9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, ADD, "-9.99999999999999e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, ADD, "-9.9999999999999e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, ADD, "-5.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, ADD, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "0");

            //first is -9999999999999999
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, ADD, "-19999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-19999999999999997");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, ADD, "-14999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, ADD, "-10000000000000099");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, ADD, "-10000000000000009");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, ADD, "-1.e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, ADD, "-9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ONE, ADD, "-9999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.TEN, ADD, "-9999999999999989");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HUNDRED, ADD, "-9999999999999899");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "-4999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, ADD, "0");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "1");

            //first is -9999999999999998
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-19999999999999996");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, ADD, "-14999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, ADD, "-10000000000000098");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, ADD, "-10000000000000008");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, ADD, "-9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, ADD, "-9999999999999998");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, ADD, "-9999999999999997");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, ADD, "-9999999999999988");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, ADD, "-9999999999999898");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, ADD, "-4999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "0");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, ADD, "1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "2");

            //first is -5000000000000000
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, ADD, "-1.e+16");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, ADD, "-5.0000000000001e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, ADD, "-5.00000000000001e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, ADD, "-5000000000000001");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, ADD, "-5.e+15");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, ADD, "-4999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, ADD, "-4.99999999999999e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, ADD, "-4.9999999999999e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "0");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "4999999999999998");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, ADD, "4999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "5.e+15");

            //first is -100
            checkBinaryOperation(NEG_HUNDRED, NEG_HUNDRED, ADD, "-2.e+2");
            checkBinaryOperation(NEG_HUNDRED, NEG_TEN, ADD, "-1.1e+2");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE, ADD, "-101");

            checkBinaryOperation(NEG_HUNDRED, BigDecimal.ZERO, ADD, "-1.e+2");

            checkBinaryOperation(NEG_HUNDRED, BigDecimal.ONE, ADD, "-99");
            checkBinaryOperation(NEG_HUNDRED, BigDecimal.TEN, ADD, "-9.e+1");
            checkBinaryOperation(NEG_HUNDRED, HUNDRED, ADD, "0");
            checkBinaryOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, ADD, "4.9999999999999e+15");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999898");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN, ADD, "9999999999999899");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9.9999999999999e+15");

            //first is -10
            checkBinaryOperation(NEG_TEN, NEG_TEN, ADD, "-2.e+1");
            checkBinaryOperation(NEG_TEN, NEG_ONE, ADD, "-11");

            checkBinaryOperation(NEG_TEN, BigDecimal.ZERO, ADD, "-1.e+1");

            checkBinaryOperation(NEG_TEN, BigDecimal.ONE, ADD, "-9");
            checkBinaryOperation(NEG_TEN, BigDecimal.TEN, ADD, "0");
            checkBinaryOperation(NEG_TEN, HUNDRED, ADD, "9.e+1");
            checkBinaryOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "4.99999999999999e+15");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999988");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN, ADD, "9999999999999989");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "999999999999999.e+1");

            //first is -1
            checkBinaryOperation(NEG_ONE, NEG_ONE, ADD, "-2");

            checkBinaryOperation(NEG_ONE, BigDecimal.ZERO, ADD, "-1");

            checkBinaryOperation(NEG_ONE, BigDecimal.ONE, ADD, "0");
            checkBinaryOperation(NEG_ONE, BigDecimal.TEN, ADD, "9");
            checkBinaryOperation(NEG_ONE, HUNDRED, ADD, "99");
            checkBinaryOperation(NEG_ONE, HALF_MAX_VALUE_ON_SCREEN, ADD, "4999999999999999");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999997");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN, ADD, "9999999999999998");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9999999999999999");

            //first is 0
            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ZERO, ADD, "0");

            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ONE, ADD, "1");
            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.TEN, ADD, "1.e+1");
            checkBinaryOperation(BigDecimal.ZERO, HUNDRED, ADD, "1.e+2");
            checkBinaryOperation(BigDecimal.ZERO, HALF_MAX_VALUE_ON_SCREEN, ADD, "5.e+15");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999998");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN, ADD, "9999999999999999");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "1.e+16");

            //first is 1
            checkBinaryOperation(BigDecimal.ONE, BigDecimal.ONE, ADD, "2");
            checkBinaryOperation(BigDecimal.ONE, BigDecimal.TEN, ADD, "11");
            checkBinaryOperation(BigDecimal.ONE, HUNDRED, ADD, "101");
            checkBinaryOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000001");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN, ADD, "1.e+16");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000001");

            //first is 10
            checkBinaryOperation(BigDecimal.TEN, BigDecimal.TEN, ADD, "2.e+1");
            checkBinaryOperation(BigDecimal.TEN, HUNDRED, ADD, "1.1e+2");
            checkBinaryOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "5.00000000000001e+15");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "10000000000000008");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN, ADD, "10000000000000009");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "1000000000000001.e+1");

            //first is 100
            checkBinaryOperation(HUNDRED, HUNDRED, ADD, "2.e+2");
            checkBinaryOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, ADD, "5.0000000000001e+15");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "10000000000000098");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN, ADD, "10000000000000099");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "100000000000001.e+2");

            //first is 5000000000000000
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "1.e+16");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "14999999999999998");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, ADD, "14999999999999999");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "1.5e+16");

            //first is 9999999999999998
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "19999999999999996");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, ADD, "19999999999999997");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "19999999999999998");

            //first is 9999999999999999
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, ADD, "19999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "19999999999999999");

            //first is 10000000000000000
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "2.e+16");
        }

        //integer and decimal
        {
            //first is -10000000000000000
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, ADD, "-10000000000000000.99999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, ADD, "-10000000000000000.9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, ADD, "-10000000000000000.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, ADD, "-10000000000000000.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, ADD, "-10000000000000000.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, ADD, "-10000000000000000.09");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, ADD, "-10000000000000000.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, ADD, "-9999999999999999.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, ADD, "-9999999999999999.91");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, ADD, "-9999999999999999.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, ADD, "-9999999999999999.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, ADD, "-9999999999999999.01");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, ADD, "-9999999999999999.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, ADD, "-9999999999999999.00000000000000001");

            //first is -9999999999999999
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, ADD, "-9999999999999999.99999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, ADD, "-9999999999999999.9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, ADD, "-9999999999999999.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, ADD, "-9999999999999999.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, ADD, "-9999999999999999.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, ADD, "-9999999999999999.09");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, ADD, "-9999999999999999.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, ADD, "-9999999999999998.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, ADD, "-9999999999999998.91");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_TENTH, ADD, "-9999999999999998.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_TENTH, ADD, "-9999999999999998.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, ADD, "-9999999999999998.01");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, ADD, "-9999999999999998.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, ADD, "-9999999999999998.00000000000000001");

            //first is -9999999999999998
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, ADD, "-9999999999999998.99999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, ADD, "-9999999999999998.9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, ADD, "-9999999999999998.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, ADD, "-9999999999999998.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, ADD, "-9999999999999998.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, ADD, "-9999999999999998.09");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, ADD, "-9999999999999998.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, ADD, "-9999999999999997.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, ADD, "-9999999999999997.91");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, ADD, "-9999999999999997.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, ADD, "-9999999999999997.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, ADD, "-9999999999999997.01");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, ADD, "-9999999999999997.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, ADD, "-9999999999999997.00000000000000001");

            //first is -5000000000000000
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, ADD, "-5000000000000000.99999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, ADD, "-5000000000000000.9999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, ADD, "-5000000000000000.99");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, ADD, "-5000000000000000.9");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, ADD, "-5000000000000000.1");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, ADD, "-5000000000000000.09");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, ADD, "-5000000000000000.01");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, ADD, "-4999999999999999.99");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, ADD, "-4999999999999999.91");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_TENTH, ADD, "-4999999999999999.9");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_TENTH, ADD, "-4999999999999999.1");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, ADD, "-4999999999999999.01");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, ADD, "-4999999999999999.0000000000000001");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, ADD, "-4999999999999999.00000000000000001");

            //first is -100
            checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_17_NINES, ADD, "-100.99999999999999999");
            checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_16_NINES, ADD, "-100.9999999999999999");
            checkBinaryOperation(NEG_HUNDRED, NEG_NINETY_NINE_HUNDREDTH, ADD, "-100.99");
            checkBinaryOperation(NEG_HUNDRED, NEG_NINE_TENTH, ADD, "-100.9");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_TENTH, ADD, "-100.1");
            checkBinaryOperation(NEG_HUNDRED, NEG_NINE_HUNDREDTH, ADD, "-100.09");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_HUNDREDTH, ADD, "-100.01");

            checkBinaryOperation(NEG_HUNDRED, ONE_HUNDREDTH, ADD, "-99.99");
            checkBinaryOperation(NEG_HUNDRED, NINE_HUNDREDTH, ADD, "-99.91");
            checkBinaryOperation(NEG_HUNDRED, ONE_TENTH, ADD, "-99.9");
            checkBinaryOperation(NEG_HUNDRED, NINE_TENTH, ADD, "-99.1");
            checkBinaryOperation(NEG_HUNDRED, NINETY_NINE_HUNDREDTH, ADD, "-99.01");
            checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_16_NINES, ADD, "-99.0000000000000001");
            checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_17_NINES, ADD, "-99.00000000000000001");

            //first is -10
            checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_17_NINES, ADD, "-10.99999999999999999");
            checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_16_NINES, ADD, "-10.9999999999999999");
            checkBinaryOperation(NEG_TEN, NEG_NINETY_NINE_HUNDREDTH, ADD, "-10.99");
            checkBinaryOperation(NEG_TEN, NEG_NINE_TENTH, ADD, "-10.9");
            checkBinaryOperation(NEG_TEN, NEG_ONE_TENTH, ADD, "-10.1");
            checkBinaryOperation(NEG_TEN, NEG_NINE_HUNDREDTH, ADD, "-10.09");
            checkBinaryOperation(NEG_TEN, NEG_ONE_HUNDREDTH, ADD, "-10.01");

            checkBinaryOperation(NEG_TEN, ONE_HUNDREDTH, ADD, "-9.99");
            checkBinaryOperation(NEG_TEN, NINE_HUNDREDTH, ADD, "-9.91");
            checkBinaryOperation(NEG_TEN, ONE_TENTH, ADD, "-9.9");
            checkBinaryOperation(NEG_TEN, NINE_TENTH, ADD, "-9.1");
            checkBinaryOperation(NEG_TEN, NINETY_NINE_HUNDREDTH, ADD, "-9.01");
            checkBinaryOperation(NEG_TEN, ZERO_DOT_16_NINES, ADD, "-9.0000000000000001");
            checkBinaryOperation(NEG_TEN, ZERO_DOT_17_NINES, ADD, "-9.00000000000000001");

            //first is -1
            checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_17_NINES, ADD, "-1.99999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_16_NINES, ADD, "-1.9999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_NINETY_NINE_HUNDREDTH, ADD, "-1.99");
            checkBinaryOperation(NEG_ONE, NEG_NINE_TENTH, ADD, "-1.9");
            checkBinaryOperation(NEG_ONE, NEG_ONE_TENTH, ADD, "-1.1");
            checkBinaryOperation(NEG_ONE, NEG_NINE_HUNDREDTH, ADD, "-1.09");
            checkBinaryOperation(NEG_ONE, NEG_ONE_HUNDREDTH, ADD, "-1.01");

            checkBinaryOperation(NEG_ONE, ONE_HUNDREDTH, ADD, "-0.99");
            checkBinaryOperation(NEG_ONE, NINE_HUNDREDTH, ADD, "-0.91");
            checkBinaryOperation(NEG_ONE, ONE_TENTH, ADD, "-0.9");
            checkBinaryOperation(NEG_ONE, NINE_TENTH, ADD, "-0.1");
            checkBinaryOperation(NEG_ONE, NINETY_NINE_HUNDREDTH, ADD, "-0.01");
            checkBinaryOperation(NEG_ONE, ZERO_DOT_16_NINES, ADD, "-0.0000000000000001");
            checkBinaryOperation(NEG_ONE, ZERO_DOT_17_NINES, ADD, "-0.00000000000000001");

            //first is 0
            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_17_NINES, ADD, "-0.99999999999999999");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, ADD, "-0.9999999999999999");
            checkBinaryOperation(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, ADD, "-0.99");
            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_TENTH, ADD, "-0.9");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_TENTH, ADD, "-0.1");
            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_HUNDREDTH, ADD, "-0.09");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_HUNDREDTH, ADD, "-0.01");

            checkBinaryOperation(BigDecimal.ZERO, ONE_HUNDREDTH, ADD, "0.01");
            checkBinaryOperation(BigDecimal.ZERO, NINE_HUNDREDTH, ADD, "0.09");
            checkBinaryOperation(BigDecimal.ZERO, ONE_TENTH, ADD, "0.1");
            checkBinaryOperation(BigDecimal.ZERO, NINE_TENTH, ADD, "0.9");
            checkBinaryOperation(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, ADD, "0.99");
            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_16_NINES, ADD, "0.9999999999999999");
            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_17_NINES, ADD, "0.99999999999999999");

            //first is 1
            checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_17_NINES, ADD, "0.00000000000000001");
            checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_16_NINES, ADD, "0.0000000000000001");
            checkBinaryOperation(BigDecimal.ONE, NEG_NINETY_NINE_HUNDREDTH, ADD, "0.01");
            checkBinaryOperation(BigDecimal.ONE, NEG_NINE_TENTH, ADD, "0.1");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_TENTH, ADD, "0.9");
            checkBinaryOperation(BigDecimal.ONE, NEG_NINE_HUNDREDTH, ADD, "0.91");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_HUNDREDTH, ADD, "0.99");

            checkBinaryOperation(BigDecimal.ONE, ONE_HUNDREDTH, ADD, "1.01");
            checkBinaryOperation(BigDecimal.ONE, NINE_HUNDREDTH, ADD, "1.09");
            checkBinaryOperation(BigDecimal.ONE, ONE_TENTH, ADD, "1.1");
            checkBinaryOperation(BigDecimal.ONE, NINE_TENTH, ADD, "1.9");
            checkBinaryOperation(BigDecimal.ONE, NINETY_NINE_HUNDREDTH, ADD, "1.99");
            checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_16_NINES, ADD, "1.9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_17_NINES, ADD, "1.99999999999999999");

            //first is 10
            checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_17_NINES, ADD, "9.00000000000000001");
            checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, ADD, "9.0000000000000001");
            checkBinaryOperation(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, ADD, "9.01");
            checkBinaryOperation(BigDecimal.TEN, NEG_NINE_TENTH, ADD, "9.1");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_TENTH, ADD, "9.9");
            checkBinaryOperation(BigDecimal.TEN, NEG_NINE_HUNDREDTH, ADD, "9.91");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_HUNDREDTH, ADD, "9.99");

            checkBinaryOperation(BigDecimal.TEN, ONE_HUNDREDTH, ADD, "10.01");
            checkBinaryOperation(BigDecimal.TEN, NINE_HUNDREDTH, ADD, "10.09");
            checkBinaryOperation(BigDecimal.TEN, ONE_TENTH, ADD, "10.1");
            checkBinaryOperation(BigDecimal.TEN, NINE_TENTH, ADD, "10.9");
            checkBinaryOperation(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, ADD, "10.99");
            checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_16_NINES, ADD, "10.9999999999999999");
            checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_17_NINES, ADD, "10.99999999999999999");

            //first is 100
            checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_17_NINES, ADD, "99.00000000000000001");
            checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_16_NINES, ADD, "99.0000000000000001");
            checkBinaryOperation(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, ADD, "99.01");
            checkBinaryOperation(HUNDRED, NEG_NINE_TENTH, ADD, "99.1");
            checkBinaryOperation(HUNDRED, NEG_ONE_TENTH, ADD, "99.9");
            checkBinaryOperation(HUNDRED, NEG_NINE_HUNDREDTH, ADD, "99.91");
            checkBinaryOperation(HUNDRED, NEG_ONE_HUNDREDTH, ADD, "99.99");

            checkBinaryOperation(HUNDRED, ONE_HUNDREDTH, ADD, "100.01");
            checkBinaryOperation(HUNDRED, NINE_HUNDREDTH, ADD, "100.09");
            checkBinaryOperation(HUNDRED, ONE_TENTH, ADD, "100.1");
            checkBinaryOperation(HUNDRED, NINE_TENTH, ADD, "100.9");
            checkBinaryOperation(HUNDRED, NINETY_NINE_HUNDREDTH, ADD, "100.99");
            checkBinaryOperation(HUNDRED, ZERO_DOT_16_NINES, ADD, "100.9999999999999999");
            checkBinaryOperation(HUNDRED, ZERO_DOT_17_NINES, ADD, "100.99999999999999999");

            //first is 5000000000000000
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, ADD, "4999999999999999.00000000000000001");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, ADD, "4999999999999999.0000000000000001");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, ADD, "4999999999999999.01");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, ADD, "4999999999999999.1");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, ADD, "4999999999999999.9");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, ADD, "4999999999999999.91");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, ADD, "4999999999999999.99");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, ADD, "5000000000000000.01");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, ADD, "5000000000000000.09");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_TENTH, ADD, "5000000000000000.1");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_TENTH, ADD, "5000000000000000.9");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, ADD, "5000000000000000.99");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, ADD, "5000000000000000.9999999999999999");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, ADD, "5000000000000000.99999999999999999");

            //first is 9999999999999998
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, ADD, "9999999999999997.00000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, ADD, "9999999999999997.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, ADD, "9999999999999997.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, ADD, "9999999999999997.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, ADD, "9999999999999997.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, ADD, "9999999999999997.91");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, ADD, "9999999999999997.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, ADD, "9999999999999998.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, ADD, "9999999999999998.09");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, ADD, "9999999999999998.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, ADD, "9999999999999998.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, ADD, "9999999999999998.99");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, ADD, "9999999999999998.9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, ADD, "9999999999999998.99999999999999999");

            //first is 9999999999999999
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, ADD, "9999999999999998.00000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, ADD, "9999999999999998.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, ADD, "9999999999999998.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, ADD, "9999999999999998.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, ADD, "9999999999999998.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, ADD, "9999999999999998.91");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, ADD, "9999999999999998.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, ADD, "9999999999999999.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, ADD, "9999999999999999.09");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_TENTH, ADD, "9999999999999999.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_TENTH, ADD, "9999999999999999.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, ADD, "9999999999999999.99");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, ADD, "9999999999999999.9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, ADD, "9999999999999999.99999999999999999");

            //first is 10000000000000000
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, ADD, "9999999999999999.00000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, ADD, "9999999999999999.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, ADD, "9999999999999999.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, ADD, "9999999999999999.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, ADD, "9999999999999999.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, ADD, "9999999999999999.91");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, ADD, "9999999999999999.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, ADD, "10000000000000000.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, ADD, "10000000000000000.09");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, ADD, "10000000000000000.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, ADD, "10000000000000000.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, ADD, "10000000000000000.99");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, ADD, "10000000000000000.9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, ADD, "10000000000000000.99999999999999999");
        }

        //decimals only
        {
            //first is -0.99999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, ADD, "-1.99999999999999998");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, ADD, "-1.99999999999999989");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, ADD, "-1.98999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_TENTH, ADD, "-1.89999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_TENTH, ADD, "-1.09999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, ADD, "-1.08999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, ADD, "-1.00999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_HUNDREDTH, ADD, "-0.98999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_HUNDREDTH, ADD, "-0.90999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_TENTH, ADD, "-0.89999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_TENTH, ADD, "-0.09999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, ADD, "-0.00999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, ADD, "-0.00000000000000009");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, ADD, "0");

            //first is -0.9999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, ADD, "-1.9999999999999998");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, ADD, "-1.9899999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, ADD, "-1.8999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, ADD, "-1.0999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, ADD, "-1.0899999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, ADD, "-1.0099999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, ADD, "-0.9899999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, ADD, "-0.9099999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_TENTH, ADD, "-0.8999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_TENTH, ADD, "-0.0999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, ADD, "-0.0099999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, ADD, "0");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, ADD, "0.00000000000000009");

            //first is -0.99
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, ADD, "-1.98");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, ADD, "-1.89");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, ADD, "-1.09");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, ADD, "-1.08");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, ADD, "-1");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, ADD, "-0.98");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, ADD, "-0.9");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, ADD, "-0.89");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, ADD, "-0.09");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "0");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "0.0099999999999999");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "0.00999999999999999");

            //first is -0.9
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, ADD, "-1.8");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, ADD, "-1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, ADD, "-0.99");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, ADD, "-0.91");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, ADD, "-0.89");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, ADD, "-0.81");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_TENTH, ADD, "-0.8");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_TENTH, ADD, "0");
            checkBinaryOperation(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, ADD, "0.09");
            checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_16_NINES, ADD, "0.0999999999999999");
            checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_17_NINES, ADD, "0.09999999999999999");

            //first is -0.1
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, ADD, "-0.2");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_HUNDREDTH, ADD, "-0.19");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, ADD, "-0.11");

            checkBinaryOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, ADD, "-0.09");
            checkBinaryOperation(NEG_ONE_TENTH, NINE_HUNDREDTH, ADD, "-0.01");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_TENTH, ADD, "0");
            checkBinaryOperation(NEG_ONE_TENTH, NINE_TENTH, ADD, "0.8");
            checkBinaryOperation(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, ADD, "0.89");
            checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_16_NINES, ADD, "0.8999999999999999");
            checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_17_NINES, ADD, "0.89999999999999999");

            //first is -0.09
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, ADD, "-0.18");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, ADD, "-0.1");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, ADD, "-0.08");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, ADD, "0");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, ADD, "0.01");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, ADD, "0.81");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "0.9");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "0.9099999999999999");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "0.90999999999999999");

            //first is -0.01
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, ADD, "-0.02");

            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, ADD, "0");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, ADD, "0.08");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, ADD, "0.09");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_TENTH, ADD, "0.89");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "0.98");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "0.9899999999999999");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "0.98999999999999999");

            //first is 0.01
            checkBinaryOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, ADD, "0.02");
            checkBinaryOperation(ONE_HUNDREDTH, NINE_HUNDREDTH, ADD, "0.1");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_TENTH, ADD, "0.11");
            checkBinaryOperation(ONE_HUNDREDTH, NINE_TENTH, ADD, "0.91");
            checkBinaryOperation(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "1");
            checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "1.0099999999999999");
            checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "1.00999999999999999");

            //first is 0.09
            checkBinaryOperation(NINE_HUNDREDTH, NINE_HUNDREDTH, ADD, "0.18");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_TENTH, ADD, "0.19");
            checkBinaryOperation(NINE_HUNDREDTH, NINE_TENTH, ADD, "0.99");
            checkBinaryOperation(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "1.08");
            checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "1.0899999999999999");
            checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "1.08999999999999999");

            //first is 0.1
            checkBinaryOperation(ONE_TENTH, ONE_TENTH, ADD, "0.2");
            checkBinaryOperation(ONE_TENTH, NINE_TENTH, ADD, "1");
            checkBinaryOperation(ONE_TENTH, NINETY_NINE_HUNDREDTH, ADD, "1.09");
            checkBinaryOperation(ONE_TENTH, ZERO_DOT_16_NINES, ADD, "1.0999999999999999");
            checkBinaryOperation(ONE_TENTH, ZERO_DOT_17_NINES, ADD, "1.09999999999999999");

            //first is 0.9
            checkBinaryOperation(NINE_TENTH, NINE_TENTH, ADD, "1.8");
            checkBinaryOperation(NINE_TENTH, NINETY_NINE_HUNDREDTH, ADD, "1.89");
            checkBinaryOperation(NINE_TENTH, ZERO_DOT_16_NINES, ADD, "1.8999999999999999");
            checkBinaryOperation(NINE_TENTH, ZERO_DOT_17_NINES, ADD, "1.89999999999999999");

            //first is 0.99
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "1.98");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "1.9899999999999999");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "1.98999999999999999");

            //first is 0.9999999999999999
            checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, ADD, "1.9999999999999998");
            checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, ADD, "1.99999999999999989");

            //first is 0.99999999999999999
            checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, ADD, "1.99999999999999998");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+9999
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, ADD, "-2.e+9999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, ADD, "-1.1e+9999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, ADD, "-9.e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, ADD, "0");

            //first is -1.e+9998
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, ADD, "-2.e+9998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, ADD, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, ADD, "9.e+9998");

            //first is 1.e+9998
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, ADD, "2.e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, ADD, "1.1e+9999");

            //first is 1.e+9999
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, ADD, "2.e+9999");


            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, ADD, "-2.e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, ADD, "-1.1e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, ADD, "-9.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, ADD, "0");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, ADD, "-2.e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, ADD, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, ADD, "9.e+16");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, ADD, "2.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, ADD, "1.1e+17");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, ADD, "2.e+17");


            //first is -1.e-9999
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, ADD, "-2.e-9999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, ADD, "-1.1e-9998");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, ADD, "9.e-9999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, ADD, "0");

            //first is -1.e-9998
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, ADD, "-2.e-9998");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, ADD, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, ADD, "-9.e-9999");

            //first is 1.e-9998
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, ADD, "2.e-9998");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, ADD, "1.1e-9998");

            //first is 1.e-9999
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, ADD, "2.e-9999");


            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, ADD, "-2.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, ADD, "-1.1e-16");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, ADD, "9.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, ADD, "0");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, ADD, "-2.e-16");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, ADD, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, ADD, "-9.e-17");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, ADD, "2.e-16");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, ADD, "1.1e-16");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, ADD, "2.e-17");
        }

        //with integers
        {
            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-1.1e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, ADD, "-109999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-109999999999999998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "-1.05e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, ADD, "-1.000000000000001e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, ADD, "-1.0000000000000001e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, ADD, "-100000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, ADD, "-1.e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, ADD, "-99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, ADD, "-9.999999999999999e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, ADD, "-9.99999999999999e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "-9.5e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-90000000000000002");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, ADD, "-90000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9.e+16");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-2.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, ADD, "-19999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-19999999999999998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "-1.5e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, ADD, "-1.00000000000001e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, ADD, "-1.000000000000001e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, ADD, "-10000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, ADD, "-1.e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, ADD, "-9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, ADD, "-9.99999999999999e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, ADD, "-9.9999999999999e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "-5.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-2");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, ADD, "-1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "0");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "0");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, ADD, "1");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "2");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "5.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, ADD, "9.9999999999999e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, ADD, "9.99999999999999e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, ADD, "9999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, ADD, "1.e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, ADD, "10000000000000001");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, ADD, "1.000000000000001e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, ADD, "1.00000000000001e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "1.5e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "19999999999999998");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, ADD, "19999999999999999");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "2.e+16");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, ADD, "90000000000000001");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "90000000000000002");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "9.5e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, ADD, "9.99999999999999e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, ADD, "9.999999999999999e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, ADD, "99999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, ADD, "1.e+17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, ADD, "100000000000000001");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, ADD, "1.0000000000000001e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, ADD, "1.000000000000001e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "1.05e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "109999999999999998");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, ADD, "109999999999999999");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "1.1e+17");

            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-10000000000000000.00000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999999.00000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999998.00000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "-5000000000000000.00000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, ADD, "-100.00000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, ADD, "-10.00000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, ADD, "-1.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, ADD, "-1.e-17");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, ADD, "0.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, ADD, "9.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, ADD, "99.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "4999999999999999.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999997.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, ADD, "9999999999999998.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9999999999999999.99999999999999999");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-10000000000000000.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999999.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999998.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "-5000000000000000.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, ADD, "-100.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, ADD, "-10.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, ADD, "-1.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, ADD, "-1.e-16");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, ADD, "0.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, ADD, "9.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, ADD, "99.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "4999999999999999.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999997.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, ADD, "9999999999999998.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9999999999999999.9999999999999999");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-9999999999999999.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999998.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999997.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "-4999999999999999.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, ADD, "-99.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, ADD, "-9.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, ADD, "-0.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, ADD, "1.e-16");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, ADD, "1.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, ADD, "10.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, ADD, "100.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000000.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999998.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, ADD, "9999999999999999.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000000.0000000000000001");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-9999999999999999.99999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999998.99999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999997.99999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "-4999999999999999.99999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, ADD, "-99.99999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, ADD, "-9.99999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, ADD, "-0.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, ADD, "1.e-17");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, ADD, "1.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, ADD, "10.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, ADD, "100.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000000.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999998.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, ADD, "9999999999999999.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000000.00000000000000001");
        }

        //with decimals
        {
            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, ADD, "-100000000000000000.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, ADD, "-100000000000000000.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, ADD, "-100000000000000000.99");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, ADD, "-100000000000000000.9");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, ADD, "-100000000000000000.1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, ADD, "-100000000000000000.09");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, ADD, "-100000000000000000.01");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, ADD, "-99999999999999999.99");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, ADD, "-99999999999999999.91");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_TENTH, ADD, "-99999999999999999.9");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_TENTH, ADD, "-99999999999999999.1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, ADD, "-99999999999999999.01");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, ADD, "-99999999999999999.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, ADD, "-99999999999999999.00000000000000001");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, ADD, "-10000000000000000.99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, ADD, "-10000000000000000.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, ADD, "-10000000000000000.99");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, ADD, "-10000000000000000.9");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, ADD, "-10000000000000000.1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, ADD, "-10000000000000000.09");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, ADD, "-10000000000000000.01");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, ADD, "-9999999999999999.99");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, ADD, "-9999999999999999.91");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_TENTH, ADD, "-9999999999999999.9");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_TENTH, ADD, "-9999999999999999.1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, ADD, "-9999999999999999.01");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, ADD, "-9999999999999999.0000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, ADD, "-9999999999999999.00000000000000001");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, ADD, "9999999999999999.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, ADD, "9999999999999999.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, ADD, "9999999999999999.01");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, ADD, "9999999999999999.1");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, ADD, "9999999999999999.9");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, ADD, "9999999999999999.91");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, ADD, "9999999999999999.99");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, ADD, "10000000000000000.01");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, ADD, "10000000000000000.09");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_TENTH, ADD, "10000000000000000.1");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_TENTH, ADD, "10000000000000000.9");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, ADD, "10000000000000000.99");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, ADD, "10000000000000000.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, ADD, "10000000000000000.99999999999999999");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, ADD, "99999999999999999.00000000000000001");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, ADD, "99999999999999999.0000000000000001");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, ADD, "99999999999999999.01");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, ADD, "99999999999999999.1");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, ADD, "99999999999999999.9");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, ADD, "99999999999999999.91");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, ADD, "99999999999999999.99");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, ADD, "100000000000000000.01");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, ADD, "100000000000000000.09");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_TENTH, ADD, "100000000000000000.1");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_TENTH, ADD, "100000000000000000.9");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, ADD, "100000000000000000.99");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, ADD, "100000000000000000.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, ADD, "100000000000000000.99999999999999999");

            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, ADD, "-1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, ADD, "-0.99999999999999991");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, ADD, "-0.99000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, ADD, "-0.90000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, ADD, "-0.10000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, ADD, "-0.09000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, ADD, "-0.01000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, ADD, "0.00999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, ADD, "0.08999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_TENTH, ADD, "0.09999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_TENTH, ADD, "0.89999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, ADD, "0.98999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, ADD, "0.99999999999999989");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, ADD, "0.99999999999999998");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, ADD, "-1.00000000000000009");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, ADD, "-1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, ADD, "-0.9900000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, ADD, "-0.9000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, ADD, "-0.1000000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, ADD, "-0.0900000000000001");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, ADD, "-0.0100000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, ADD, "0.0099999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, ADD, "0.0899999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_TENTH, ADD, "0.0999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_TENTH, ADD, "0.8999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, ADD, "0.9899999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, ADD, "0.9999999999999998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, ADD, "0.99999999999999989");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, ADD, "-0.99999999999999989");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, ADD, "-0.9999999999999998");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, ADD, "-0.9899999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, ADD, "-0.8999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, ADD, "-0.0999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, ADD, "-0.0899999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, ADD, "-0.0099999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, ADD, "0.0100000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, ADD, "0.0900000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_TENTH, ADD, "0.1000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_TENTH, ADD, "0.9000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, ADD, "0.9900000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, ADD, "1");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, ADD, "1.00000000000000009");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, ADD, "-0.99999999999999998");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, ADD, "-0.99999999999999989");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, ADD, "-0.98999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, ADD, "-0.89999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, ADD, "-0.09999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, ADD, "-0.08999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, ADD, "-0.00999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, ADD, "0.01000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, ADD, "0.09000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_TENTH, ADD, "0.10000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_TENTH, ADD, "0.90000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, ADD, "0.99000000000000001");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, ADD, "0.99999999999999991");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, ADD, "1");
        }

        //several random values
        {
            checkBinaryOperation(new BigDecimal("197"), new BigDecimal("8763"), ADD, "8.96e+3");
            checkBinaryOperation(new BigDecimal("36346"), new BigDecimal("62"), ADD, "36408");

            checkBinaryOperation(new BigDecimal("62"), new BigDecimal("-542"), ADD, "-4.8e+2");
            checkBinaryOperation(new BigDecimal("7654"), new BigDecimal("-62"), ADD, "7592");

            checkBinaryOperation(new BigDecimal("-53252"), new BigDecimal("-52"), ADD, "-53304");
            checkBinaryOperation(new BigDecimal("-1243"), new BigDecimal("-65"), ADD, "-1308");

            checkBinaryOperation(new BigDecimal("623"), new BigDecimal("124.123"), ADD, "747.123");
            checkBinaryOperation(new BigDecimal("324"), new BigDecimal("653.523"), ADD, "977.523");

            checkBinaryOperation(new BigDecimal("7652"), new BigDecimal("-23.598"), ADD, "7628.402");
            checkBinaryOperation(new BigDecimal("2431"), new BigDecimal("-123.124"), ADD, "2307.876");

            checkBinaryOperation(new BigDecimal("-62"), new BigDecimal("76.43"), ADD, "14.43");
            checkBinaryOperation(new BigDecimal("-87"), new BigDecimal("876.1"), ADD, "789.1");

            checkBinaryOperation(new BigDecimal("-63"), new BigDecimal("-0.234"), ADD, "-63.234");
            checkBinaryOperation(new BigDecimal("-1967"), new BigDecimal("-22.76"), ADD, "-1989.76");

            checkBinaryOperation(new BigDecimal("53.14"), new BigDecimal("51.65"), ADD, "104.79");
            checkBinaryOperation(new BigDecimal("75.234"), new BigDecimal("75.234"), ADD, "150.468");

            checkBinaryOperation(new BigDecimal("64.26"), new BigDecimal("-25.7"), ADD, "38.56");
            checkBinaryOperation(new BigDecimal("623.3"), new BigDecimal("-75.2"), ADD, "548.1");

            checkBinaryOperation(new BigDecimal("-532.1"), new BigDecimal("-2.2"), ADD, "-534.3");
            checkBinaryOperation(new BigDecimal("-622.2"), new BigDecimal("-25.6"), ADD, "-647.8");
        }
    }

    /**
     * Tests for binary subtract operation.
     *
     * @see BinaryOperations
     */
    @Test
    void subtractOperationTests() {
        //integers only
        {
            //first is -10000000000000000
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "0");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, SUBTRACT, "-9.9999999999999e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, SUBTRACT, "-9.99999999999999e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, SUBTRACT, "-9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, SUBTRACT, "-1.e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, SUBTRACT, "-10000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, SUBTRACT, "-1.000000000000001e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, SUBTRACT, "-1.00000000000001e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-1.5e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-19999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-2.e+16");

            //first is -9999999999999999
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "0");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "-9999999999999899");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "-9999999999999989");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "-9999999999999998");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "-9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "-1.e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "-10000000000000009");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "-10000000000000099");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-14999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-19999999999999997");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999999");

            //first is -9999999999999998
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "0");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, SUBTRACT, "-9999999999999898");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, SUBTRACT, "-9999999999999988");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, SUBTRACT, "-9999999999999997");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, SUBTRACT, "-9999999999999998");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, SUBTRACT, "-9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, SUBTRACT, "-10000000000000008");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, SUBTRACT, "-10000000000000098");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-14999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-19999999999999996");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999997");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999998");

            //first is -5000000000000000
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "5.e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "4999999999999998");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "0");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "-4.9999999999999e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "-4.99999999999999e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "-4999999999999999");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "-5.e+15");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "-5000000000000001");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "-5.00000000000001e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "-5.0000000000001e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-1.e+16");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-14999999999999998");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "-14999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-1.5e+16");

            //first is -100
            checkBinaryOperation(NEG_HUNDRED, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9.9999999999999e+15");
            checkBinaryOperation(NEG_HUNDRED, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999899");
            checkBinaryOperation(NEG_HUNDRED, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999898");
            checkBinaryOperation(NEG_HUNDRED, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4.9999999999999e+15");
            checkBinaryOperation(NEG_HUNDRED, NEG_HUNDRED, SUBTRACT, "0");
            checkBinaryOperation(NEG_HUNDRED, NEG_TEN, SUBTRACT, "-9.e+1");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE, SUBTRACT, "-99");

            checkBinaryOperation(NEG_HUNDRED, BigDecimal.ZERO, SUBTRACT, "-1.e+2");

            checkBinaryOperation(NEG_HUNDRED, BigDecimal.ONE, SUBTRACT, "-101");
            checkBinaryOperation(NEG_HUNDRED, BigDecimal.TEN, SUBTRACT, "-1.1e+2");
            checkBinaryOperation(NEG_HUNDRED, HUNDRED, SUBTRACT, "-2.e+2");
            checkBinaryOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5.0000000000001e+15");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000098");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000099");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-1.00000000000001e+16");

            //first is -10
            checkBinaryOperation(NEG_TEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9.99999999999999e+15");
            checkBinaryOperation(NEG_TEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999989");
            checkBinaryOperation(NEG_TEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999988");
            checkBinaryOperation(NEG_TEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4.99999999999999e+15");
            checkBinaryOperation(NEG_TEN, NEG_HUNDRED, SUBTRACT, "9.e+1");
            checkBinaryOperation(NEG_TEN, NEG_TEN, SUBTRACT, "0");
            checkBinaryOperation(NEG_TEN, NEG_ONE, SUBTRACT, "-9");

            checkBinaryOperation(NEG_TEN, BigDecimal.ZERO, SUBTRACT, "-1.e+1");

            checkBinaryOperation(NEG_TEN, BigDecimal.ONE, SUBTRACT, "-11");
            checkBinaryOperation(NEG_TEN, BigDecimal.TEN, SUBTRACT, "-2.e+1");
            checkBinaryOperation(NEG_TEN, HUNDRED, SUBTRACT, "-1.1e+2");
            checkBinaryOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5.00000000000001e+15");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000008");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000009");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-1.000000000000001e+16");

            //first is -1
            checkBinaryOperation(NEG_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999");
            checkBinaryOperation(NEG_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998");
            checkBinaryOperation(NEG_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997");
            checkBinaryOperation(NEG_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_HUNDRED, SUBTRACT, "99");
            checkBinaryOperation(NEG_ONE, NEG_TEN, SUBTRACT, "9");
            checkBinaryOperation(NEG_ONE, NEG_ONE, SUBTRACT, "0");

            checkBinaryOperation(NEG_ONE, BigDecimal.ZERO, SUBTRACT, "-1");

            checkBinaryOperation(NEG_ONE, BigDecimal.ONE, SUBTRACT, "-2");
            checkBinaryOperation(NEG_ONE, BigDecimal.TEN, SUBTRACT, "-11");
            checkBinaryOperation(NEG_ONE, HUNDRED, SUBTRACT, "-101");
            checkBinaryOperation(NEG_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000001");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "-1.e+16");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000001");

            //first is 0
            checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "1.e+16");
            checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999");
            checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998");
            checkBinaryOperation(BigDecimal.ZERO, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5.e+15");
            checkBinaryOperation(BigDecimal.ZERO, NEG_HUNDRED, SUBTRACT, "1.e+2");
            checkBinaryOperation(BigDecimal.ZERO, NEG_TEN, SUBTRACT, "1.e+1");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE, SUBTRACT, "1");

            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ZERO, SUBTRACT, "0");

            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ONE, SUBTRACT, "-1");
            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.TEN, SUBTRACT, "-1.e+1");
            checkBinaryOperation(BigDecimal.ZERO, HUNDRED, SUBTRACT, "-1.e+2");
            checkBinaryOperation(BigDecimal.ZERO, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5.e+15");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-1.e+16");

            //first is 1
            checkBinaryOperation(BigDecimal.ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000001");
            checkBinaryOperation(BigDecimal.ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "1.e+16");
            checkBinaryOperation(BigDecimal.ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000001");
            checkBinaryOperation(BigDecimal.ONE, NEG_HUNDRED, SUBTRACT, "101");
            checkBinaryOperation(BigDecimal.ONE, NEG_TEN, SUBTRACT, "11");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE, SUBTRACT, "2");

            checkBinaryOperation(BigDecimal.ONE, BigDecimal.ZERO, SUBTRACT, "1");

            checkBinaryOperation(BigDecimal.ONE, BigDecimal.ONE, SUBTRACT, "0");
            checkBinaryOperation(BigDecimal.ONE, BigDecimal.TEN, SUBTRACT, "-9");
            checkBinaryOperation(BigDecimal.ONE, HUNDRED, SUBTRACT, "-99");
            checkBinaryOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999");

            //first is 10
            checkBinaryOperation(BigDecimal.TEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "1.000000000000001e+16");
            checkBinaryOperation(BigDecimal.TEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "10000000000000009");
            checkBinaryOperation(BigDecimal.TEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000008");
            checkBinaryOperation(BigDecimal.TEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5.00000000000001e+15");
            checkBinaryOperation(BigDecimal.TEN, NEG_HUNDRED, SUBTRACT, "1.1e+2");
            checkBinaryOperation(BigDecimal.TEN, NEG_TEN, SUBTRACT, "2.e+1");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE, SUBTRACT, "11");

            checkBinaryOperation(BigDecimal.TEN, BigDecimal.ZERO, SUBTRACT, "1.e+1");

            checkBinaryOperation(BigDecimal.TEN, BigDecimal.ONE, SUBTRACT, "9");
            checkBinaryOperation(BigDecimal.TEN, BigDecimal.TEN, SUBTRACT, "0");
            checkBinaryOperation(BigDecimal.TEN, HUNDRED, SUBTRACT, "-9.e+1");
            checkBinaryOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4.99999999999999e+15");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999988");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999989");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9.99999999999999e+15");

            //first is 100
            checkBinaryOperation(HUNDRED, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "1.00000000000001e+16");
            checkBinaryOperation(HUNDRED, MIN_VALUE_ON_SCREEN, SUBTRACT, "10000000000000099");
            checkBinaryOperation(HUNDRED, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000098");
            checkBinaryOperation(HUNDRED, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5.0000000000001e+15");
            checkBinaryOperation(HUNDRED, NEG_HUNDRED, SUBTRACT, "2.e+2");
            checkBinaryOperation(HUNDRED, NEG_TEN, SUBTRACT, "1.1e+2");
            checkBinaryOperation(HUNDRED, NEG_ONE, SUBTRACT, "101");

            checkBinaryOperation(HUNDRED, BigDecimal.ZERO, SUBTRACT, "1.e+2");

            checkBinaryOperation(HUNDRED, BigDecimal.ONE, SUBTRACT, "99");
            checkBinaryOperation(HUNDRED, BigDecimal.TEN, SUBTRACT, "9.e+1");
            checkBinaryOperation(HUNDRED, HUNDRED, SUBTRACT, "0");
            checkBinaryOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4.9999999999999e+15");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999898");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999899");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9.9999999999999e+15");

            //first is 5000000000000000
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "1.5e+16");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "14999999999999999");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "14999999999999998");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "1.e+16");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "5.0000000000001e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "5.00000000000001e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "5000000000000001");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "5.e+15");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "4999999999999999");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "4.99999999999999e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "4.9999999999999e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "0");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-4999999999999998");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-5.e+15");

            //first is 9999999999999998
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "19999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "19999999999999997");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "19999999999999996");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "14999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, SUBTRACT, "10000000000000098");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, SUBTRACT, "10000000000000008");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, SUBTRACT, "9999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, SUBTRACT, "9999999999999998");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, SUBTRACT, "9999999999999997");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, SUBTRACT, "9999999999999988");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, SUBTRACT, "9999999999999898");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "0");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "-1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-2");

            //first is 9999999999999999
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "19999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "19999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "19999999999999997");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "14999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "10000000000000099");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "10000000000000009");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "1.e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "9999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "9999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "9999999999999989");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "9999999999999899");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "0");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-1");

            //first is 10000000000000000
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "2.e+16");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "19999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "19999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "1.5e+16");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, SUBTRACT, "1.00000000000001e+16");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, SUBTRACT, "1.000000000000001e+16");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, SUBTRACT, "10000000000000001");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, SUBTRACT, "1.e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, SUBTRACT, "9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, SUBTRACT, "9.99999999999999e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, SUBTRACT, "9.9999999999999e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5.e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "2");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "0");
        }

        //integer and decimal
        {
            //first is -10000000000000000 (and vice versa)
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999999.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.00000000000000001");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999999.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.0000000000000001");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, SUBTRACT, "-9999999999999999.1");
            checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, SUBTRACT, "-9999999999999999.9");
            checkBinaryOperation(NEG_ONE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.9");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.91");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "-9999999999999999.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.99");


            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, SUBTRACT, "-10000000000000000.01");
            checkBinaryOperation(ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, SUBTRACT, "-10000000000000000.09");
            checkBinaryOperation(NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.09");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, SUBTRACT, "-10000000000000000.1");
            checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, SUBTRACT, "-10000000000000000.9");
            checkBinaryOperation(NINE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.9");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "-10000000000000000.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.99");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "-10000000000000000.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "-10000000000000000.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.99999999999999999");

            //first is -9999999999999999 (and vice versa)
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999998.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.00000000000000001");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999998.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.0000000000000001");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "-9999999999999998.1");
            checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "-9999999999999998.9");
            checkBinaryOperation(NEG_ONE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.9");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.91");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "-9999999999999998.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.99");


            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "-9999999999999999.01");
            checkBinaryOperation(ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.09");
            checkBinaryOperation(NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.09");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "-9999999999999999.1");
            checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "-9999999999999999.9");
            checkBinaryOperation(NINE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.9");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.99");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999999.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999999.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.99999999999999999");

            //first is -9999999999999998 (and vice versa)
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999997.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.00000000000000001");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999997.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.0000000000000001");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999997.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, SUBTRACT, "-9999999999999997.1");
            checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, SUBTRACT, "-9999999999999997.9");
            checkBinaryOperation(NEG_ONE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.9");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "-9999999999999997.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.91");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "-9999999999999997.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.99");


            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, SUBTRACT, "-9999999999999998.01");
            checkBinaryOperation(ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.01");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.09");
            checkBinaryOperation(NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.09");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, SUBTRACT, "-9999999999999998.1");
            checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, SUBTRACT, "-9999999999999998.9");
            checkBinaryOperation(NINE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.9");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.99");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999998.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999998.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.99999999999999999");

            //first is -5000000000000000 (and vice versa)
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-4999999999999999.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.00000000000000001");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-4999999999999999.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.0000000000000001");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-4999999999999999.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.01");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "-4999999999999999.1");
            checkBinaryOperation(NEG_NINE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.1");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "-4999999999999999.9");
            checkBinaryOperation(NEG_ONE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.9");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "-4999999999999999.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.91");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "-4999999999999999.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.99");


            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "-5000000000000000.01");
            checkBinaryOperation(ONE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.01");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "-5000000000000000.09");
            checkBinaryOperation(NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.09");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "-5000000000000000.1");
            checkBinaryOperation(ONE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.1");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "-5000000000000000.9");
            checkBinaryOperation(NINE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.9");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "-5000000000000000.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.99");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "-5000000000000000.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.9999999999999999");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "-5000000000000000.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.99999999999999999");

            //first is -100 (and vice versa)
            checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-99.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_HUNDRED, SUBTRACT, "99.00000000000000001");

            checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-99.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_HUNDRED, SUBTRACT, "99.0000000000000001");

            checkBinaryOperation(NEG_HUNDRED, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-99.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "99.01");

            checkBinaryOperation(NEG_HUNDRED, NEG_NINE_TENTH, SUBTRACT, "-99.1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_HUNDRED, SUBTRACT, "99.1");

            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_TENTH, SUBTRACT, "-99.9");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_HUNDRED, SUBTRACT, "99.9");

            checkBinaryOperation(NEG_HUNDRED, NEG_NINE_HUNDREDTH, SUBTRACT, "-99.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "99.91");

            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_HUNDREDTH, SUBTRACT, "-99.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "99.99");


            checkBinaryOperation(NEG_HUNDRED, ONE_HUNDREDTH, SUBTRACT, "-100.01");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "100.01");

            checkBinaryOperation(NEG_HUNDRED, NINE_HUNDREDTH, SUBTRACT, "-100.09");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "100.09");

            checkBinaryOperation(NEG_HUNDRED, ONE_TENTH, SUBTRACT, "-100.1");
            checkBinaryOperation(ONE_TENTH, NEG_HUNDRED, SUBTRACT, "100.1");

            checkBinaryOperation(NEG_HUNDRED, NINE_TENTH, SUBTRACT, "-100.9");
            checkBinaryOperation(NINE_TENTH, NEG_HUNDRED, SUBTRACT, "100.9");

            checkBinaryOperation(NEG_HUNDRED, NINETY_NINE_HUNDREDTH, SUBTRACT, "-100.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "100.99");

            checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_16_NINES, SUBTRACT, "-100.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_HUNDRED, SUBTRACT, "100.9999999999999999");

            checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_17_NINES, SUBTRACT, "-100.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_HUNDRED, SUBTRACT, "100.99999999999999999");

            //first is -10 (and vice versa)
            checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-9.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_TEN, SUBTRACT, "9.00000000000000001");

            checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_TEN, SUBTRACT, "9.0000000000000001");

            checkBinaryOperation(NEG_TEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-9.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "9.01");

            checkBinaryOperation(NEG_TEN, NEG_NINE_TENTH, SUBTRACT, "-9.1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_TEN, SUBTRACT, "9.1");

            checkBinaryOperation(NEG_TEN, NEG_ONE_TENTH, SUBTRACT, "-9.9");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_TEN, SUBTRACT, "9.9");

            checkBinaryOperation(NEG_TEN, NEG_NINE_HUNDREDTH, SUBTRACT, "-9.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "9.91");

            checkBinaryOperation(NEG_TEN, NEG_ONE_HUNDREDTH, SUBTRACT, "-9.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_TEN, SUBTRACT, "9.99");


            checkBinaryOperation(NEG_TEN, ONE_HUNDREDTH, SUBTRACT, "-10.01");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_TEN, SUBTRACT, "10.01");

            checkBinaryOperation(NEG_TEN, NINE_HUNDREDTH, SUBTRACT, "-10.09");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "10.09");

            checkBinaryOperation(NEG_TEN, ONE_TENTH, SUBTRACT, "-10.1");
            checkBinaryOperation(ONE_TENTH, NEG_TEN, SUBTRACT, "10.1");

            checkBinaryOperation(NEG_TEN, NINE_TENTH, SUBTRACT, "-10.9");
            checkBinaryOperation(NINE_TENTH, NEG_TEN, SUBTRACT, "10.9");

            checkBinaryOperation(NEG_TEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "-10.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "10.99");

            checkBinaryOperation(NEG_TEN, ZERO_DOT_16_NINES, SUBTRACT, "-10.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_TEN, SUBTRACT, "10.9999999999999999");

            checkBinaryOperation(NEG_TEN, ZERO_DOT_17_NINES, SUBTRACT, "-10.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_TEN, SUBTRACT, "10.99999999999999999");

            //first is -1 (and vice versa)
            checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.e-17");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE, SUBTRACT, "1.e-17");

            checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.e-16");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE, SUBTRACT, "1.e-16");

            checkBinaryOperation(NEG_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "0.01");

            checkBinaryOperation(NEG_ONE, NEG_NINE_TENTH, SUBTRACT, "-0.1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE, SUBTRACT, "0.1");

            checkBinaryOperation(NEG_ONE, NEG_ONE_TENTH, SUBTRACT, "-0.9");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE, SUBTRACT, "0.9");

            checkBinaryOperation(NEG_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "0.91");

            checkBinaryOperation(NEG_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE, SUBTRACT, "0.99");


            checkBinaryOperation(NEG_ONE, ONE_HUNDREDTH, SUBTRACT, "-1.01");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE, SUBTRACT, "1.01");

            checkBinaryOperation(NEG_ONE, NINE_HUNDREDTH, SUBTRACT, "-1.09");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "1.09");

            checkBinaryOperation(NEG_ONE, ONE_TENTH, SUBTRACT, "-1.1");
            checkBinaryOperation(ONE_TENTH, NEG_ONE, SUBTRACT, "1.1");

            checkBinaryOperation(NEG_ONE, NINE_TENTH, SUBTRACT, "-1.9");
            checkBinaryOperation(NINE_TENTH, NEG_ONE, SUBTRACT, "1.9");

            checkBinaryOperation(NEG_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "1.99");

            checkBinaryOperation(NEG_ONE, ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE, SUBTRACT, "1.9999999999999999");

            checkBinaryOperation(NEG_ONE, ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE, SUBTRACT, "1.99999999999999999");

            //first is 0 (and vice versa)
            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.ZERO, SUBTRACT, "-0.99999999999999999");

            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.ZERO, SUBTRACT, "-0.9999999999999999");

            checkBinaryOperation(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "-0.99");

            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_TENTH, SUBTRACT, "0.9");
            checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.ZERO, SUBTRACT, "-0.9");

            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_TENTH, SUBTRACT, "0.1");
            checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.ZERO, SUBTRACT, "-0.1");

            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_HUNDREDTH, SUBTRACT, "0.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "-0.09");

            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_HUNDREDTH, SUBTRACT, "0.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "-0.01");


            checkBinaryOperation(BigDecimal.ZERO, ONE_HUNDREDTH, SUBTRACT, "-0.01");
            checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "0.01");

            checkBinaryOperation(BigDecimal.ZERO, NINE_HUNDREDTH, SUBTRACT, "-0.09");
            checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "0.09");

            checkBinaryOperation(BigDecimal.ZERO, ONE_TENTH, SUBTRACT, "-0.1");
            checkBinaryOperation(ONE_TENTH, BigDecimal.ZERO, SUBTRACT, "0.1");

            checkBinaryOperation(BigDecimal.ZERO, NINE_TENTH, SUBTRACT, "-0.9");
            checkBinaryOperation(NINE_TENTH, BigDecimal.ZERO, SUBTRACT, "0.9");

            checkBinaryOperation(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "0.99");

            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_16_NINES, SUBTRACT, "-0.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.ZERO, SUBTRACT, "0.9999999999999999");

            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_17_NINES, SUBTRACT, "-0.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.ZERO, SUBTRACT, "0.99999999999999999");

            //first is 1 (and vice versa)
            checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.ONE, SUBTRACT, "-1.99999999999999999");

            checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.ONE, SUBTRACT, "-1.9999999999999999");

            checkBinaryOperation(BigDecimal.ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "-1.99");

            checkBinaryOperation(BigDecimal.ONE, NEG_NINE_TENTH, SUBTRACT, "1.9");
            checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.ONE, SUBTRACT, "-1.9");

            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_TENTH, SUBTRACT, "1.1");
            checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.ONE, SUBTRACT, "-1.1");

            checkBinaryOperation(BigDecimal.ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "1.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "-1.09");

            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "1.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "-1.01");


            checkBinaryOperation(BigDecimal.ONE, ONE_HUNDREDTH, SUBTRACT, "0.99");
            checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "-0.99");

            checkBinaryOperation(BigDecimal.ONE, NINE_HUNDREDTH, SUBTRACT, "0.91");
            checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "-0.91");

            checkBinaryOperation(BigDecimal.ONE, ONE_TENTH, SUBTRACT, "0.9");
            checkBinaryOperation(ONE_TENTH, BigDecimal.ONE, SUBTRACT, "-0.9");

            checkBinaryOperation(BigDecimal.ONE, NINE_TENTH, SUBTRACT, "0.1");
            checkBinaryOperation(NINE_TENTH, BigDecimal.ONE, SUBTRACT, "-0.1");

            checkBinaryOperation(BigDecimal.ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "-0.01");

            checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_16_NINES, SUBTRACT, "0.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.ONE, SUBTRACT, "-0.0000000000000001");

            checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_17_NINES, SUBTRACT, "0.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.ONE, SUBTRACT, "-0.00000000000000001");

            //first is 10 (and vice versa)
            checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "10.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.TEN, SUBTRACT, "-10.99999999999999999");

            checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "10.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.TEN, SUBTRACT, "-10.9999999999999999");

            checkBinaryOperation(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "10.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "-10.99");

            checkBinaryOperation(BigDecimal.TEN, NEG_NINE_TENTH, SUBTRACT, "10.9");
            checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.TEN, SUBTRACT, "-10.9");

            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_TENTH, SUBTRACT, "10.1");
            checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.TEN, SUBTRACT, "-10.1");

            checkBinaryOperation(BigDecimal.TEN, NEG_NINE_HUNDREDTH, SUBTRACT, "10.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "-10.09");

            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_HUNDREDTH, SUBTRACT, "10.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "-10.01");


            checkBinaryOperation(BigDecimal.TEN, ONE_HUNDREDTH, SUBTRACT, "9.99");
            checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "-9.99");

            checkBinaryOperation(BigDecimal.TEN, NINE_HUNDREDTH, SUBTRACT, "9.91");
            checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "-9.91");

            checkBinaryOperation(BigDecimal.TEN, ONE_TENTH, SUBTRACT, "9.9");
            checkBinaryOperation(ONE_TENTH, BigDecimal.TEN, SUBTRACT, "-9.9");

            checkBinaryOperation(BigDecimal.TEN, NINE_TENTH, SUBTRACT, "9.1");
            checkBinaryOperation(NINE_TENTH, BigDecimal.TEN, SUBTRACT, "-9.1");

            checkBinaryOperation(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "9.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "-9.01");

            checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_16_NINES, SUBTRACT, "9.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.TEN, SUBTRACT, "-9.0000000000000001");

            checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_17_NINES, SUBTRACT, "9.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.TEN, SUBTRACT, "-9.00000000000000001");

            //first is 100 (and vice versa)
            checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_17_NINES, SUBTRACT, "100.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HUNDRED, SUBTRACT, "-100.99999999999999999");

            checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_16_NINES, SUBTRACT, "100.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HUNDRED, SUBTRACT, "-100.9999999999999999");

            checkBinaryOperation(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "100.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HUNDRED, SUBTRACT, "-100.99");

            checkBinaryOperation(HUNDRED, NEG_NINE_TENTH, SUBTRACT, "100.9");
            checkBinaryOperation(NEG_NINE_TENTH, HUNDRED, SUBTRACT, "-100.9");

            checkBinaryOperation(HUNDRED, NEG_ONE_TENTH, SUBTRACT, "100.1");
            checkBinaryOperation(NEG_ONE_TENTH, HUNDRED, SUBTRACT, "-100.1");

            checkBinaryOperation(HUNDRED, NEG_NINE_HUNDREDTH, SUBTRACT, "100.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, HUNDRED, SUBTRACT, "-100.09");

            checkBinaryOperation(HUNDRED, NEG_ONE_HUNDREDTH, SUBTRACT, "100.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, HUNDRED, SUBTRACT, "-100.01");


            checkBinaryOperation(HUNDRED, ONE_HUNDREDTH, SUBTRACT, "99.99");
            checkBinaryOperation(ONE_HUNDREDTH, HUNDRED, SUBTRACT, "-99.99");

            checkBinaryOperation(HUNDRED, NINE_HUNDREDTH, SUBTRACT, "99.91");
            checkBinaryOperation(NINE_HUNDREDTH, HUNDRED, SUBTRACT, "-99.91");

            checkBinaryOperation(HUNDRED, ONE_TENTH, SUBTRACT, "99.9");
            checkBinaryOperation(ONE_TENTH, HUNDRED, SUBTRACT, "-99.9");

            checkBinaryOperation(HUNDRED, NINE_TENTH, SUBTRACT, "99.1");
            checkBinaryOperation(NINE_TENTH, HUNDRED, SUBTRACT, "-99.1");

            checkBinaryOperation(HUNDRED, NINETY_NINE_HUNDREDTH, SUBTRACT, "99.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, HUNDRED, SUBTRACT, "-99.01");

            checkBinaryOperation(HUNDRED, ZERO_DOT_16_NINES, SUBTRACT, "99.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, HUNDRED, SUBTRACT, "-99.0000000000000001");

            checkBinaryOperation(HUNDRED, ZERO_DOT_17_NINES, SUBTRACT, "99.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, HUNDRED, SUBTRACT, "-99.00000000000000001");

            //first is 5000000000000000 (and vice versa)
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "5000000000000000.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.99999999999999999");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "5000000000000000.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.9999999999999999");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "5000000000000000.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.99");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "5000000000000000.9");
            checkBinaryOperation(NEG_NINE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.9");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "5000000000000000.1");
            checkBinaryOperation(NEG_ONE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.1");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "5000000000000000.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.09");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "5000000000000000.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.01");


            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "4999999999999999.99");
            checkBinaryOperation(ONE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.99");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "4999999999999999.91");
            checkBinaryOperation(NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.91");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "4999999999999999.9");
            checkBinaryOperation(ONE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.9");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "4999999999999999.1");
            checkBinaryOperation(NINE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.1");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "4999999999999999.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.01");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "4999999999999999.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.0000000000000001");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "4999999999999999.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.00000000000000001");

            //first is 9999999999999998 (and vice versa)
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "9999999999999998.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.99999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "9999999999999998.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.9999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999998.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, SUBTRACT, "9999999999999998.9");
            checkBinaryOperation(NEG_NINE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.9");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, SUBTRACT, "9999999999999998.1");
            checkBinaryOperation(NEG_ONE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.1");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "9999999999999998.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.09");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "9999999999999998.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.01");


            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, SUBTRACT, "9999999999999997.99");
            checkBinaryOperation(ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, SUBTRACT, "9999999999999997.91");
            checkBinaryOperation(NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.91");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, SUBTRACT, "9999999999999997.9");
            checkBinaryOperation(ONE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.9");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, SUBTRACT, "9999999999999997.1");
            checkBinaryOperation(NINE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.1");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999997.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.01");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "9999999999999997.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.0000000000000001");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "9999999999999997.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.00000000000000001");

            //first is 9999999999999999 (and vice versa)
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "9999999999999999.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.99999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "9999999999999999.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.9999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999999.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "9999999999999999.9");
            checkBinaryOperation(NEG_NINE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.9");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "9999999999999999.1");
            checkBinaryOperation(NEG_ONE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.1");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "9999999999999999.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.09");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "9999999999999999.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.01");


            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "9999999999999998.99");
            checkBinaryOperation(ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "9999999999999998.91");
            checkBinaryOperation(NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.91");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "9999999999999998.9");
            checkBinaryOperation(ONE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.9");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "9999999999999998.1");
            checkBinaryOperation(NINE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.1");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999998.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.01");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "9999999999999998.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.0000000000000001");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "9999999999999998.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.00000000000000001");

            //first is 10000000000000000 (and vice versa)
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "10000000000000000.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.99999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "10000000000000000.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.9999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "10000000000000000.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, SUBTRACT, "10000000000000000.9");
            checkBinaryOperation(NEG_NINE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.9");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, SUBTRACT, "10000000000000000.1");
            checkBinaryOperation(NEG_ONE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.1");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "10000000000000000.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.09");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "10000000000000000.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.01");


            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, SUBTRACT, "9999999999999999.99");
            checkBinaryOperation(ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, SUBTRACT, "9999999999999999.91");
            checkBinaryOperation(NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.91");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, SUBTRACT, "9999999999999999.9");
            checkBinaryOperation(ONE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.9");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, SUBTRACT, "9999999999999999.1");
            checkBinaryOperation(NINE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.1");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999999.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.01");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "9999999999999999.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.0000000000000001");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "9999999999999999.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.00000000000000001");
        }

        //decimals only
        {
            //first is -0.99999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9.e-17");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.00999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_TENTH, SUBTRACT, "-0.09999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_TENTH, SUBTRACT, "-0.89999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.90999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.98999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_HUNDREDTH, SUBTRACT, "-1.00999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_HUNDREDTH, SUBTRACT, "-1.08999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_TENTH, SUBTRACT, "-1.09999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_TENTH, SUBTRACT, "-1.89999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, SUBTRACT, "-1.99999999999999989");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");

            //first is -0.9999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "9.e-17");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.0099999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, SUBTRACT, "-0.0999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, SUBTRACT, "-0.8999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.9099999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.9899999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, SUBTRACT, "-1.0099999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, SUBTRACT, "-1.0899999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_TENTH, SUBTRACT, "-1.0999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_TENTH, SUBTRACT, "-1.8999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.9899999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999989");

            //first is -0.99
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.00999999999999999");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.0099999999999999");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "-0.09");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "-0.89");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.9");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.98");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "-1");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "-1.08");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "-1.09");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "-1.89");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "-1.9899999999999999");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "-1.98999999999999999");

            //first is -0.9
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.09999999999999999");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.0999999999999999");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.09");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, SUBTRACT, "0");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, SUBTRACT, "-0.8");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.81");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.89");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, SUBTRACT, "-0.91");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, SUBTRACT, "-0.99");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_TENTH, SUBTRACT, "-1");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_TENTH, SUBTRACT, "-1.8");
            checkBinaryOperation(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.89");
            checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "-1.8999999999999999");
            checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "-1.89999999999999999");

            //first is -0.1
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.89999999999999999");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.8999999999999999");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.89");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_TENTH, SUBTRACT, "0.8");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, SUBTRACT, "0");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.01");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.09");

            checkBinaryOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, SUBTRACT, "-0.11");
            checkBinaryOperation(NEG_ONE_TENTH, NINE_HUNDREDTH, SUBTRACT, "-0.19");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_TENTH, SUBTRACT, "-0.2");
            checkBinaryOperation(NEG_ONE_TENTH, NINE_TENTH, SUBTRACT, "-1");
            checkBinaryOperation(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.09");
            checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "-1.0999999999999999");
            checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "-1.09999999999999999");

            //first is -0.09
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.90999999999999999");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.9099999999999999");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.9");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "0.81");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "0.01");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "0");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.08");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "-0.1");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "-0.18");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "-0.19");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "-0.99");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.08");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "-1.0899999999999999");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "-1.08999999999999999");

            //first is -0.01
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.98999999999999999");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.9899999999999999");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.98");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "0.89");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "0.09");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "0.08");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "0");

            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "-0.02");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "-0.1");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, SUBTRACT, "-0.11");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_TENTH, SUBTRACT, "-0.91");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-1");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "-1.0099999999999999");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "-1.00999999999999999");

            //first is 0.01
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.00999999999999999");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.0099999999999999");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "0.91");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "0.11");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "0.1");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "0.02");

            checkBinaryOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "0");
            checkBinaryOperation(ONE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "-0.08");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_TENTH, SUBTRACT, "-0.09");
            checkBinaryOperation(ONE_HUNDREDTH, NINE_TENTH, SUBTRACT, "-0.89");
            checkBinaryOperation(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.98");
            checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "-0.9899999999999999");
            checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "-0.98999999999999999");

            //first is 0.09
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.08999999999999999");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.0899999999999999");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1.08");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "0.99");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "0.19");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "0.18");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "0.1");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "0.08");
            checkBinaryOperation(NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "0");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "-0.01");
            checkBinaryOperation(NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "-0.81");
            checkBinaryOperation(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.9");
            checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "-0.9099999999999999");
            checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "-0.90999999999999999");

            //first is 0.1
            checkBinaryOperation(ONE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.09999999999999999");
            checkBinaryOperation(ONE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.0999999999999999");
            checkBinaryOperation(ONE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1.09");
            checkBinaryOperation(ONE_TENTH, NEG_NINE_TENTH, SUBTRACT, "1");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_TENTH, SUBTRACT, "0.2");
            checkBinaryOperation(ONE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "0.19");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "0.11");

            checkBinaryOperation(ONE_TENTH, ONE_HUNDREDTH, SUBTRACT, "0.09");
            checkBinaryOperation(ONE_TENTH, NINE_HUNDREDTH, SUBTRACT, "0.01");
            checkBinaryOperation(ONE_TENTH, ONE_TENTH, SUBTRACT, "0");
            checkBinaryOperation(ONE_TENTH, NINE_TENTH, SUBTRACT, "-0.8");
            checkBinaryOperation(ONE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.89");
            checkBinaryOperation(ONE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "-0.8999999999999999");
            checkBinaryOperation(ONE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "-0.89999999999999999");

            //first is 0.9
            checkBinaryOperation(NINE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.89999999999999999");
            checkBinaryOperation(NINE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.8999999999999999");
            checkBinaryOperation(NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1.89");
            checkBinaryOperation(NINE_TENTH, NEG_NINE_TENTH, SUBTRACT, "1.8");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_TENTH, SUBTRACT, "1");
            checkBinaryOperation(NINE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "0.99");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "0.91");

            checkBinaryOperation(NINE_TENTH, ONE_HUNDREDTH, SUBTRACT, "0.89");
            checkBinaryOperation(NINE_TENTH, NINE_HUNDREDTH, SUBTRACT, "0.81");
            checkBinaryOperation(NINE_TENTH, ONE_TENTH, SUBTRACT, "0.8");
            checkBinaryOperation(NINE_TENTH, NINE_TENTH, SUBTRACT, "0");
            checkBinaryOperation(NINE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.09");
            checkBinaryOperation(NINE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "-0.0999999999999999");
            checkBinaryOperation(NINE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "-0.09999999999999999");

            //first is 0.99
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.98999999999999999");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.9899999999999999");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1.98");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "1.89");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "1.09");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "1.08");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "1");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "0.98");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "0.9");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "0.89");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "0.09");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "0");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "-0.0099999999999999");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "-0.00999999999999999");

            //first is 0.9999999999999999
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.99999999999999989");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.9999999999999998");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1.9899999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINE_TENTH, SUBTRACT, "1.8999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_TENTH, SUBTRACT, "1.0999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "1.0899999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "1.0099999999999999");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_HUNDREDTH, SUBTRACT, "0.9899999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NINE_HUNDREDTH, SUBTRACT, "0.9099999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_TENTH, SUBTRACT, "0.8999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NINE_TENTH, SUBTRACT, "0.0999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.0099999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, SUBTRACT, "0");
            checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, SUBTRACT, "-9.e-17");

            //first is 0.99999999999999999
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.99999999999999998");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1.99999999999999989");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "1.98999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINE_TENTH, SUBTRACT, "1.89999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_TENTH, SUBTRACT, "1.09999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "1.08999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "1.00999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_HUNDREDTH, SUBTRACT, "0.98999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NINE_HUNDREDTH, SUBTRACT, "0.90999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_TENTH, SUBTRACT, "0.89999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NINE_TENTH, SUBTRACT, "0.09999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.00999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, SUBTRACT, "9.e-17");
            checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, SUBTRACT, "0");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+9999
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-9.e+9998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, SUBTRACT, "-1.1e+9999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, SUBTRACT, "-2.e+9999");

            //first is -1.e+9998
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "9.e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, SUBTRACT, "-2.e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, SUBTRACT, "-1.1e+9999");

            //first is 1.e+9998
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "1.1e+9999");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "2.e+9998");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, SUBTRACT, "0");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, SUBTRACT, "-9.e+9998");

            //first is 1.e+9999
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "2.e+9999");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "1.1e+9999");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, SUBTRACT, "9.e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, SUBTRACT, "0");


            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-9.e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, SUBTRACT, "-1.1e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, SUBTRACT, "-2.e+17");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "9.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, SUBTRACT, "-2.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, SUBTRACT, "-1.1e+17");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "1.1e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "2.e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, SUBTRACT, "0");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, SUBTRACT, "-9.e+16");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "2.e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "1.1e+17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, SUBTRACT, "9.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, SUBTRACT, "0");


            //first is -1.e-9999
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "9.e-9999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, SUBTRACT, "-1.1e-9998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, SUBTRACT, "-2.e-9999");

            //first is -1.e-9998
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-9.e-9999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, SUBTRACT, "-2.e-9998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, SUBTRACT, "-1.1e-9998");

            //first is 1.e-9998
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "1.1e-9998");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "2.e-9998");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, SUBTRACT, "0");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, SUBTRACT, "9.e-9999");

            //first is 1.e-9999
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "2.e-9999");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "1.1e-9998");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, SUBTRACT, "-9.e-9999");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, SUBTRACT, "0");


            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "9.e-17");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, SUBTRACT, "-1.1e-16");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, SUBTRACT, "-2.e-17");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-9.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, SUBTRACT, "-2.e-16");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, SUBTRACT, "-1.1e-16");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "1.1e-16");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "2.e-16");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, SUBTRACT, "0");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, SUBTRACT, "9.e-17");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "2.e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "1.1e-16");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, SUBTRACT, "-9.e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, SUBTRACT, "0");
        }

        //with integers
        {
            //first is -1.e+17 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9.e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "9.e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "-90000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "90000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-90000000000000002");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "90000000000000002");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-9.5e+16");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "9.5e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, SUBTRACT, "-9.99999999999999e+16");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "9.99999999999999e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, SUBTRACT, "-9.999999999999999e+16");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "9.999999999999999e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, SUBTRACT, "-99999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, SUBTRACT, "-1.e+17");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "1.e+17");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, SUBTRACT, "-100000000000000001");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, SUBTRACT, "-1.0000000000000001e+17");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "1.0000000000000001e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, SUBTRACT, "-1.000000000000001e+17");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "1.000000000000001e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-1.05e+17");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "1.05e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-109999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "109999999999999998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "-109999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "109999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-1.1e+17");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "1.1e+17");

            //first is -1.e+16 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "0");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "2");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5.e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "5.e+15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, SUBTRACT, "-9.9999999999999e+15");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9.9999999999999e+15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, SUBTRACT, "-9.99999999999999e+15");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9.99999999999999e+15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, SUBTRACT, "-9999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, SUBTRACT, "-1.e+16");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "1.e+16");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, SUBTRACT, "-10000000000000001");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, SUBTRACT, "-1.000000000000001e+16");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "1.000000000000001e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, SUBTRACT, "-1.00000000000001e+16");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "1.00000000000001e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-1.5e+16");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "1.5e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-19999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "19999999999999998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "19999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-2.e+16");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "2.e+16");

            //first is 1.e+16 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "2.e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "-2.e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "19999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "-19999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "19999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "-19999999999999998");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "1.5e+16");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "-1.5e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, SUBTRACT, "1.00000000000001e+16");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_16, SUBTRACT, "-1.00000000000001e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, SUBTRACT, "1.000000000000001e+16");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_16, SUBTRACT, "-1.000000000000001e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, SUBTRACT, "10000000000000001");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000001");


            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, SUBTRACT, "1.e+16");
            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_16, SUBTRACT, "-1.e+16");


            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, SUBTRACT, "9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, SUBTRACT, "9.99999999999999e+15");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_16, SUBTRACT, "-9.99999999999999e+15");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, SUBTRACT, "9.9999999999999e+15");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_16, SUBTRACT, "-9.9999999999999e+15");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5.e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "-5.e+15");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "2");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "-2");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "-1");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "0");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "0");

            //first is 1.e+17 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "1.1e+17");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "-1.1e+17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "109999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "-109999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "109999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "-109999999999999998");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "1.05e+17");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "-1.05e+17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, SUBTRACT, "1.000000000000001e+17");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_17, SUBTRACT, "-1.000000000000001e+17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, SUBTRACT, "1.0000000000000001e+17");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_17, SUBTRACT, "-1.0000000000000001e+17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, SUBTRACT, "100000000000000001");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000001");


            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, SUBTRACT, "1.e+17");
            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_17, SUBTRACT, "-1.e+17");


            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, SUBTRACT, "99999999999999999");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, SUBTRACT, "9.999999999999999e+16");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_17, SUBTRACT, "-9.999999999999999e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, SUBTRACT, "9.99999999999999e+16");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_17, SUBTRACT, "-9.99999999999999e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "9.5e+16");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "-9.5e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "90000000000000002");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "-90000000000000002");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "90000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "-90000000000000001");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9.e+16");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "-9.e+16");


            //first is -1.e-17 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.99999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999999.99999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.99999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999998.99999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.99999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999997.99999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.99999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-4999999999999999.99999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, SUBTRACT, "99.99999999999999999");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-99.99999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, SUBTRACT, "9.99999999999999999");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-9.99999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, SUBTRACT, "0.99999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.99999999999999999");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, SUBTRACT, "-1.e-17");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "1.e-17");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, SUBTRACT, "-1.00000000000000001");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "1.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, SUBTRACT, "-10.00000000000000001");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "10.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, SUBTRACT, "-100.00000000000000001");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "100.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.00000000000000001");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "5000000000000000.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.00000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999998.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.00000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999999.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.00000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "10000000000000000.00000000000000001");

            //first is -1.e-16 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999.9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999999.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999998.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999997.9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999997.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.9999999999999999");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-4999999999999999.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, SUBTRACT, "99.9999999999999999");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-99.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, SUBTRACT, "9.9999999999999999");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-9.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, SUBTRACT, "0.9999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.9999999999999999");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, SUBTRACT, "-1.e-16");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "1.e-16");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, SUBTRACT, "-1.0000000000000001");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "1.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, SUBTRACT, "-10.0000000000000001");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "10.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, SUBTRACT, "-100.0000000000000001");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "100.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.0000000000000001");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "5000000000000000.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999998.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999998.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999999.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-10000000000000000.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "10000000000000000.0000000000000001");

            //first is 1.e-16 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "-10000000000000000.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999999.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999998.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.0000000000000001");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "-5000000000000000.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, SUBTRACT, "100.0000000000000001");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_16, SUBTRACT, "-100.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, SUBTRACT, "10.0000000000000001");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_16, SUBTRACT, "-10.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, SUBTRACT, "1.0000000000000001");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "-1.0000000000000001");


            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, SUBTRACT, "1.e-16");
            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_16, SUBTRACT, "-1.e-16");


            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, SUBTRACT, "-0.9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "0.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, SUBTRACT, "-9.9999999999999999");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_16, SUBTRACT, "9.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, SUBTRACT, "-99.9999999999999999");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_16, SUBTRACT, "99.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.9999999999999999");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "4999999999999999.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999997.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999998.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999999.9999999999999999");

            //first is 1.e-17 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000000.00000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "-10000000000000000.00000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.00000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999999.00000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999998.00000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999998.00000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.00000000000000001");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "-5000000000000000.00000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, SUBTRACT, "100.00000000000000001");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_17, SUBTRACT, "-100.00000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, SUBTRACT, "10.00000000000000001");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_17, SUBTRACT, "-10.00000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, SUBTRACT, "1.00000000000000001");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "-1.00000000000000001");


            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, SUBTRACT, "1.e-17");
            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_17, SUBTRACT, "-1.e-17");


            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, SUBTRACT, "-0.99999999999999999");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "0.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, SUBTRACT, "-9.99999999999999999");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_17, SUBTRACT, "9.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, SUBTRACT, "-99.99999999999999999");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_17, SUBTRACT, "99.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.99999999999999999");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "4999999999999999.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999997.99999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999997.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.99999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999998.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999999.99999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999999.99999999999999999");
        }

        //with decimals
        {
            //first is -1.e+17 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-99999999999999999.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-99999999999999999.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-99999999999999999.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999.01");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, SUBTRACT, "-99999999999999999.1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999.1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, SUBTRACT, "-99999999999999999.9");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999.9");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, SUBTRACT, "-99999999999999999.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999.91");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, SUBTRACT, "-99999999999999999.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999.99");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, SUBTRACT, "-100000000000000000.01");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000.01");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, SUBTRACT, "-100000000000000000.09");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000.09");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_TENTH, SUBTRACT, "-100000000000000000.1");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000.1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_TENTH, SUBTRACT, "-100000000000000000.9");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000.9");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, SUBTRACT, "-100000000000000000.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000.99");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, SUBTRACT, "-100000000000000000.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, SUBTRACT, "-100000000000000000.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000.99999999999999999");

            //first is -1.e+16 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999999.00000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999.00000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999999.0000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999.0000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.01");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999.01");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, SUBTRACT, "-9999999999999999.1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999.1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, SUBTRACT, "-9999999999999999.9");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999.9");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.91");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999.91");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, SUBTRACT, "-9999999999999999.99");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999.99");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, SUBTRACT, "-10000000000000000.01");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000.01");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, SUBTRACT, "-10000000000000000.09");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000.09");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_TENTH, SUBTRACT, "-10000000000000000.1");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000.1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_TENTH, SUBTRACT, "-10000000000000000.9");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000.9");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, SUBTRACT, "-10000000000000000.99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000.99");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, SUBTRACT, "-10000000000000000.9999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, SUBTRACT, "-10000000000000000.99999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000.99999999999999999");

            //first is 1.e+16 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, SUBTRACT, "10000000000000000.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, SUBTRACT, "10000000000000000.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "10000000000000000.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000.99");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, SUBTRACT, "10000000000000000.9");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000.9");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, SUBTRACT, "10000000000000000.1");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000.1");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, SUBTRACT, "10000000000000000.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000.09");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, SUBTRACT, "10000000000000000.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000.01");


            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, SUBTRACT, "9999999999999999.99");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999.99");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, SUBTRACT, "9999999999999999.91");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999.91");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_TENTH, SUBTRACT, "9999999999999999.9");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999.9");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_TENTH, SUBTRACT, "9999999999999999.1");
            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999.1");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999999.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999.01");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, SUBTRACT, "9999999999999999.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, SUBTRACT, "9999999999999999.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999.00000000000000001");

            //first is 1.e+17 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, SUBTRACT, "100000000000000000.99999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000.99999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, SUBTRACT, "100000000000000000.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "100000000000000000.99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000.99");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, SUBTRACT, "100000000000000000.9");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000.9");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, SUBTRACT, "100000000000000000.1");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000.1");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, SUBTRACT, "100000000000000000.09");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000.09");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, SUBTRACT, "100000000000000000.01");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000.01");


            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, SUBTRACT, "99999999999999999.99");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999.99");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, SUBTRACT, "99999999999999999.91");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999.91");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_TENTH, SUBTRACT, "99999999999999999.9");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999.9");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_TENTH, SUBTRACT, "99999999999999999.1");
            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999.1");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, SUBTRACT, "99999999999999999.01");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999.01");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, SUBTRACT, "99999999999999999.0000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999.0000000000000001");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, SUBTRACT, "99999999999999999.00000000000000001");
            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999.00000000000000001");


            //first is -1.e-17 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.99999999999999998");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.99999999999999998");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.99999999999999989");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.99999999999999989");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.98999999999999999");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.98999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, SUBTRACT, "0.89999999999999999");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.89999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, SUBTRACT, "0.09999999999999999");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.09999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, SUBTRACT, "0.08999999999999999");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.08999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, SUBTRACT, "0.00999999999999999");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-0.00999999999999999");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, SUBTRACT, "-0.01000000000000001");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0.01000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, SUBTRACT, "-0.09000000000000001");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0.09000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_TENTH, SUBTRACT, "-0.10000000000000001");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0.10000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_TENTH, SUBTRACT, "-0.90000000000000001");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0.90000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.99000000000000001");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0.99000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, SUBTRACT, "-0.99999999999999991");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0.99999999999999991");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, SUBTRACT, "-1");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "1");

            //first is -1.e-16 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.99999999999999989");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.99999999999999989");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.9999999999999998");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.9999999999999998");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.9899999999999999");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.9899999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, SUBTRACT, "0.8999999999999999");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.8999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, SUBTRACT, "0.0999999999999999");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.0999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, SUBTRACT, "0.0899999999999999");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.0899999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, SUBTRACT, "0.0099999999999999");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-0.0099999999999999");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, SUBTRACT, "-0.0100000000000001");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "0.0100000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, SUBTRACT, "-0.0900000000000001");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "0.0900000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_TENTH, SUBTRACT, "-0.1000000000000001");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "0.1000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_TENTH, SUBTRACT, "-0.9000000000000001");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "0.9000000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.9900000000000001");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "0.9900000000000001");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, SUBTRACT, "-1");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "1");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, SUBTRACT, "-1.00000000000000009");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "1.00000000000000009");

            //first is 1.e-16 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1.00000000000000009");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_16, SUBTRACT, "-1.00000000000000009");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, SUBTRACT, "1");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_16, SUBTRACT, "-1");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.9900000000000001");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, SUBTRACT, "-0.9900000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, SUBTRACT, "0.9000000000000001");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_MINUS_16, SUBTRACT, "-0.9000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, SUBTRACT, "0.1000000000000001");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_MINUS_16, SUBTRACT, "-0.1000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, SUBTRACT, "0.0900000000000001");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, SUBTRACT, "-0.0900000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, SUBTRACT, "0.0100000000000001");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_MINUS_16, SUBTRACT, "-0.0100000000000001");


            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, SUBTRACT, "-0.0099999999999999");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_MINUS_16, SUBTRACT, "0.0099999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, SUBTRACT, "-0.0899999999999999");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, SUBTRACT, "0.0899999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_TENTH, SUBTRACT, "-0.0999999999999999");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_MINUS_16, SUBTRACT, "0.0999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_TENTH, SUBTRACT, "-0.8999999999999999");
            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_MINUS_16, SUBTRACT, "0.8999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.9899999999999999");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, SUBTRACT, "0.9899999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, SUBTRACT, "-0.9999999999999998");
            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_16, SUBTRACT, "0.9999999999999998");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, SUBTRACT, "-0.99999999999999989");
            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_16, SUBTRACT, "0.99999999999999989");

            //first is 1.e-17 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, SUBTRACT, "1");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_17, SUBTRACT, "-1");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.99999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_17, SUBTRACT, "-0.99999999999999991");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.99000000000000001");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, SUBTRACT, "-0.99000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, SUBTRACT, "0.90000000000000001");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_MINUS_17, SUBTRACT, "-0.90000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, SUBTRACT, "0.10000000000000001");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_MINUS_17, SUBTRACT, "-0.10000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, SUBTRACT, "0.09000000000000001");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, SUBTRACT, "-0.09000000000000001");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, SUBTRACT, "0.01000000000000001");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_MINUS_17, SUBTRACT, "-0.01000000000000001");


            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, SUBTRACT, "-0.00999999999999999");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_MINUS_17, SUBTRACT, "0.00999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, SUBTRACT, "-0.08999999999999999");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, SUBTRACT, "0.08999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_TENTH, SUBTRACT, "-0.09999999999999999");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_MINUS_17, SUBTRACT, "0.09999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_TENTH, SUBTRACT, "-0.89999999999999999");
            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_MINUS_17, SUBTRACT, "0.89999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.98999999999999999");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, SUBTRACT, "0.98999999999999999");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, SUBTRACT, "-0.99999999999999989");
            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_17, SUBTRACT, "0.99999999999999989");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, SUBTRACT, "-0.99999999999999998");
            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_17, SUBTRACT, "0.99999999999999998");
        }

        //several random values (and vice versa)
        {
            checkBinaryOperation(new BigDecimal("523"), new BigDecimal("876"), SUBTRACT, "-353");
            checkBinaryOperation(new BigDecimal("876"), new BigDecimal("523"), SUBTRACT, "353");
            checkBinaryOperation(new BigDecimal("34"), new BigDecimal("65"), SUBTRACT, "-31");
            checkBinaryOperation(new BigDecimal("65"), new BigDecimal("34"), SUBTRACT, "31");

            checkBinaryOperation(new BigDecimal("724"), new BigDecimal("-652"), SUBTRACT, "1376");
            checkBinaryOperation(new BigDecimal("-652"), new BigDecimal("724"), SUBTRACT, "-1376");
            checkBinaryOperation(new BigDecimal("763"), new BigDecimal("-865"), SUBTRACT, "1628");
            checkBinaryOperation(new BigDecimal("-865"), new BigDecimal("763"), SUBTRACT, "-1628");

            checkBinaryOperation(new BigDecimal("-6521"), new BigDecimal("-41"), SUBTRACT, "-6.48e+3");
            checkBinaryOperation(new BigDecimal("-41"), new BigDecimal("-6521"), SUBTRACT, "6.48e+3");
            checkBinaryOperation(new BigDecimal("-7624"), new BigDecimal("-7245"), SUBTRACT, "-379");
            checkBinaryOperation(new BigDecimal("-7245"), new BigDecimal("-7624"), SUBTRACT, "379");

            checkBinaryOperation(new BigDecimal("763"), new BigDecimal("245.876"), SUBTRACT, "517.124");
            checkBinaryOperation(new BigDecimal("245.876"), new BigDecimal("763"), SUBTRACT, "-517.124");
            checkBinaryOperation(new BigDecimal("9876"), new BigDecimal("123.87"), SUBTRACT, "9752.13");
            checkBinaryOperation(new BigDecimal("123.87"), new BigDecimal("9876"), SUBTRACT, "-9752.13");

            checkBinaryOperation(new BigDecimal("6425"), new BigDecimal("-123.65"), SUBTRACT, "6548.65");
            checkBinaryOperation(new BigDecimal("-123.65"), new BigDecimal("6425"), SUBTRACT, "-6548.65");
            checkBinaryOperation(new BigDecimal("987"), new BigDecimal("-12.65"), SUBTRACT, "999.65");
            checkBinaryOperation(new BigDecimal("-12.65"), new BigDecimal("987"), SUBTRACT, "-999.65");

            checkBinaryOperation(new BigDecimal("-6"), new BigDecimal("76.123"), SUBTRACT, "-82.123");
            checkBinaryOperation(new BigDecimal("76.123"), new BigDecimal("-6"), SUBTRACT, "82.123");
            checkBinaryOperation(new BigDecimal("-6543"), new BigDecimal("12.43"), SUBTRACT, "-6555.43");
            checkBinaryOperation(new BigDecimal("12.43"), new BigDecimal("-6543"), SUBTRACT, "6555.43");

            checkBinaryOperation(new BigDecimal("-876"), new BigDecimal("-21.41"), SUBTRACT, "-854.59");
            checkBinaryOperation(new BigDecimal("-21.41"), new BigDecimal("-876"), SUBTRACT, "854.59");
            checkBinaryOperation(new BigDecimal("-987"), new BigDecimal("-12.21"), SUBTRACT, "-974.79");
            checkBinaryOperation(new BigDecimal("-12.21"), new BigDecimal("-987"), SUBTRACT, "974.79");

            checkBinaryOperation(new BigDecimal("12.11"), new BigDecimal("87.0765"), SUBTRACT, "-74.9665");
            checkBinaryOperation(new BigDecimal("87.0765"), new BigDecimal("12.11"), SUBTRACT, "74.9665");
            checkBinaryOperation(new BigDecimal("123.66"), new BigDecimal("1111.09"), SUBTRACT, "-987.43");
            checkBinaryOperation(new BigDecimal("1111.09"), new BigDecimal("123.66"), SUBTRACT, "987.43");

            checkBinaryOperation(new BigDecimal("123.65"), new BigDecimal("-1.2"), SUBTRACT, "124.85");
            checkBinaryOperation(new BigDecimal("-1.2"), new BigDecimal("123.65"), SUBTRACT, "-124.85");
            checkBinaryOperation(new BigDecimal("5.1"), new BigDecimal("-12.7"), SUBTRACT, "17.8");
            checkBinaryOperation(new BigDecimal("-12.7"), new BigDecimal("5.1"), SUBTRACT, "-17.8");

            checkBinaryOperation(new BigDecimal("-0.112"), new BigDecimal("-3.2"), SUBTRACT, "3.088");
            checkBinaryOperation(new BigDecimal("-3.2"), new BigDecimal("-0.112"), SUBTRACT, "-3.088");
            checkBinaryOperation(new BigDecimal("-9.1"), new BigDecimal("-1.224"), SUBTRACT, "-7.876");
            checkBinaryOperation(new BigDecimal("-1.224"), new BigDecimal("-9.1"), SUBTRACT, "7.876");
        }
    }

    /**
     * Tests for binary multiply operation.
     *
     * @see BinaryOperations
     */
    @Test
    void multiplyOperationTests() {
        //integers only
        {
            //first is -10000000000000000
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.e+32");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, MULTIPLY, "1.e+18");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, MULTIPLY, "1.e+17");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, MULTIPLY, "1.e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, MULTIPLY, "-1.e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, MULTIPLY, "-1.e+17");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, MULTIPLY, "-1.e+18");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e+32");

            //first is -9999999999999999
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, MULTIPLY, "99999999999999980000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "99999999999999970000000000000002");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "4.9999999999999995e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, MULTIPLY, "9.999999999999999e+17");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, MULTIPLY, "9.999999999999999e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, MULTIPLY, "9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ONE, MULTIPLY, "-9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.TEN, MULTIPLY, "-9.999999999999999e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HUNDRED, MULTIPLY, "-9.999999999999999e+17");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-4.9999999999999995e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-99999999999999970000000000000002");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "-99999999999999980000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999999e+31");

            //first is -9999999999999998
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "99999999999999960000000000000004");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "4.999999999999999e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, MULTIPLY, "9.999999999999998e+17");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, MULTIPLY, "9.999999999999998e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, MULTIPLY, "9999999999999998");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, MULTIPLY, "-9999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, MULTIPLY, "-9.999999999999998e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, MULTIPLY, "-9.999999999999998e+17");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-4.999999999999999e+31");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-99999999999999960000000000000004");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "-99999999999999970000000000000002");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998e+31");

            //first is -5000000000000000
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "2.5e+31");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, MULTIPLY, "5.e+17");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, MULTIPLY, "5.e+16");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, MULTIPLY, "5.e+15");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, MULTIPLY, "-5.e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, MULTIPLY, "-5.e+16");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, MULTIPLY, "-5.e+17");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-2.5e+31");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-4.999999999999999e+31");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "-4.9999999999999995e+31");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-5.e+31");

            //first is -100
            checkBinaryOperation(NEG_HUNDRED, NEG_HUNDRED, MULTIPLY, "1.e+4");
            checkBinaryOperation(NEG_HUNDRED, NEG_TEN, MULTIPLY, "1.e+3");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE, MULTIPLY, "1.e+2");

            checkBinaryOperation(NEG_HUNDRED, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_HUNDRED, BigDecimal.ONE, MULTIPLY, "-1.e+2");
            checkBinaryOperation(NEG_HUNDRED, BigDecimal.TEN, MULTIPLY, "-1.e+3");
            checkBinaryOperation(NEG_HUNDRED, HUNDRED, MULTIPLY, "-1.e+4");
            checkBinaryOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e+17");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998e+17");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e+17");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e+18");

            //first is -10
            checkBinaryOperation(NEG_TEN, NEG_TEN, MULTIPLY, "1.e+2");
            checkBinaryOperation(NEG_TEN, NEG_ONE, MULTIPLY, "1.e+1");

            checkBinaryOperation(NEG_TEN, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_TEN, BigDecimal.ONE, MULTIPLY, "-1.e+1");
            checkBinaryOperation(NEG_TEN, BigDecimal.TEN, MULTIPLY, "-1.e+2");
            checkBinaryOperation(NEG_TEN, HUNDRED, MULTIPLY, "-1.e+3");
            checkBinaryOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e+16");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998e+16");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e+16");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e+17");

            //first is -1
            checkBinaryOperation(NEG_ONE, NEG_ONE, MULTIPLY, "1");

            checkBinaryOperation(NEG_ONE, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_ONE, BigDecimal.ONE, MULTIPLY, "-1");
            checkBinaryOperation(NEG_ONE, BigDecimal.TEN, MULTIPLY, "-1.e+1");
            checkBinaryOperation(NEG_ONE, HUNDRED, MULTIPLY, "-1.e+2");
            checkBinaryOperation(NEG_ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e+15");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9999999999999998");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9999999999999999");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e+16");

            //first is 0
            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ONE, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.TEN, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, HUNDRED, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0");

            //first is 1
            checkBinaryOperation(BigDecimal.ONE, BigDecimal.ONE, MULTIPLY, "1");
            checkBinaryOperation(BigDecimal.ONE, BigDecimal.TEN, MULTIPLY, "1.e+1");
            checkBinaryOperation(BigDecimal.ONE, HUNDRED, MULTIPLY, "1.e+2");
            checkBinaryOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.e+15");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9999999999999998");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e+16");

            //first is 10
            checkBinaryOperation(BigDecimal.TEN, BigDecimal.TEN, MULTIPLY, "1.e+2");
            checkBinaryOperation(BigDecimal.TEN, HUNDRED, MULTIPLY, "1.e+3");
            checkBinaryOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.e+16");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998e+16");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e+16");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e+17");

            //first is 100
            checkBinaryOperation(HUNDRED, HUNDRED, MULTIPLY, "1.e+4");
            checkBinaryOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.e+17");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998e+17");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e+17");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e+18");

            //first is 5000000000000000
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "2.5e+31");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "4.999999999999999e+31");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "4.9999999999999995e+31");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "5.e+31");

            //first is 9999999999999998
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "99999999999999960000000000000004");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "99999999999999970000000000000002");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998e+31");

            //first is 9999999999999999
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "99999999999999980000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999999e+31");

            //first is 10000000000000000
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e+32");
        }

        //integer and decimal
        {
            //first is -10000000000000000
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, MULTIPLY, "9.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, MULTIPLY, "1.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "9.e+14");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "1.e+14");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, MULTIPLY, "-1.e+14");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, MULTIPLY, "-9.e+14");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, MULTIPLY, "-1.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, MULTIPLY, "-9.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.9");

            //first is -9999999999999999
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9999999999999998.90000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9999999999999998.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9899999999999999.01");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, MULTIPLY, "8999999999999999.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, MULTIPLY, "999999999999999.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, MULTIPLY, "899999999999999.91");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, MULTIPLY, "99999999999999.99");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, MULTIPLY, "-99999999999999.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, MULTIPLY, "-899999999999999.91");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_TENTH, MULTIPLY, "-999999999999999.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_TENTH, MULTIPLY, "-8999999999999999.1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9899999999999999.01");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999998.0000000000000001");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999998.90000000000000001");

            //first is -9999999999999998
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9999999999999997.90000000000000002");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9999999999999997.0000000000000002");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9899999999999998.02");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, MULTIPLY, "8999999999999998.2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, MULTIPLY, "999999999999999.8");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "899999999999999.82");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "99999999999999.98");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, MULTIPLY, "-99999999999999.98");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, MULTIPLY, "-899999999999999.82");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, MULTIPLY, "-999999999999999.8");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, MULTIPLY, "-8999999999999998.2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9899999999999998.02");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999997.0000000000000002");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999997.90000000000000002");

            //first is -5000000000000000
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "4999999999999999.95");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "4999999999999999.5");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "4.95e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, MULTIPLY, "4.5e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, MULTIPLY, "5.e+14");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, MULTIPLY, "4.5e+14");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, MULTIPLY, "5.e+13");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, MULTIPLY, "-5.e+13");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, MULTIPLY, "-4.5e+14");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_TENTH, MULTIPLY, "-5.e+14");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_TENTH, MULTIPLY, "-4.5e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "-4.95e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, MULTIPLY, "-4999999999999999.5");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, MULTIPLY, "-4999999999999999.95");

            //first is -100
            checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_17_NINES, MULTIPLY, "99.999999999999999");
            checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_16_NINES, MULTIPLY, "99.99999999999999");
            checkBinaryOperation(NEG_HUNDRED, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "99");
            checkBinaryOperation(NEG_HUNDRED, NEG_NINE_TENTH, MULTIPLY, "9.e+1");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_TENTH, MULTIPLY, "1.e+1");
            checkBinaryOperation(NEG_HUNDRED, NEG_NINE_HUNDREDTH, MULTIPLY, "9");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_HUNDREDTH, MULTIPLY, "1");

            checkBinaryOperation(NEG_HUNDRED, ONE_HUNDREDTH, MULTIPLY, "-1");
            checkBinaryOperation(NEG_HUNDRED, NINE_HUNDREDTH, MULTIPLY, "-9");
            checkBinaryOperation(NEG_HUNDRED, ONE_TENTH, MULTIPLY, "-1.e+1");
            checkBinaryOperation(NEG_HUNDRED, NINE_TENTH, MULTIPLY, "-9.e+1");
            checkBinaryOperation(NEG_HUNDRED, NINETY_NINE_HUNDREDTH, MULTIPLY, "-99");
            checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_16_NINES, MULTIPLY, "-99.99999999999999");
            checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_17_NINES, MULTIPLY, "-99.999999999999999");

            //first is -10
            checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999");
            checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999");
            checkBinaryOperation(NEG_TEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9");
            checkBinaryOperation(NEG_TEN, NEG_NINE_TENTH, MULTIPLY, "9");
            checkBinaryOperation(NEG_TEN, NEG_ONE_TENTH, MULTIPLY, "1");
            checkBinaryOperation(NEG_TEN, NEG_NINE_HUNDREDTH, MULTIPLY, "0.9");
            checkBinaryOperation(NEG_TEN, NEG_ONE_HUNDREDTH, MULTIPLY, "0.1");

            checkBinaryOperation(NEG_TEN, ONE_HUNDREDTH, MULTIPLY, "-0.1");
            checkBinaryOperation(NEG_TEN, NINE_HUNDREDTH, MULTIPLY, "-0.9");
            checkBinaryOperation(NEG_TEN, ONE_TENTH, MULTIPLY, "-1");
            checkBinaryOperation(NEG_TEN, NINE_TENTH, MULTIPLY, "-9");
            checkBinaryOperation(NEG_TEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9");
            checkBinaryOperation(NEG_TEN, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999");
            checkBinaryOperation(NEG_TEN, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999");

            //first is -1
            checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "0.99999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "0.9999999999999999");
            checkBinaryOperation(NEG_ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "0.99");
            checkBinaryOperation(NEG_ONE, NEG_NINE_TENTH, MULTIPLY, "0.9");
            checkBinaryOperation(NEG_ONE, NEG_ONE_TENTH, MULTIPLY, "0.1");
            checkBinaryOperation(NEG_ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "0.09");
            checkBinaryOperation(NEG_ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "0.01");

            checkBinaryOperation(NEG_ONE, ONE_HUNDREDTH, MULTIPLY, "-0.01");
            checkBinaryOperation(NEG_ONE, NINE_HUNDREDTH, MULTIPLY, "-0.09");
            checkBinaryOperation(NEG_ONE, ONE_TENTH, MULTIPLY, "-0.1");
            checkBinaryOperation(NEG_ONE, NINE_TENTH, MULTIPLY, "-0.9");
            checkBinaryOperation(NEG_ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.99");
            checkBinaryOperation(NEG_ONE, ZERO_DOT_16_NINES, MULTIPLY, "-0.9999999999999999");
            checkBinaryOperation(NEG_ONE, ZERO_DOT_17_NINES, MULTIPLY, "-0.99999999999999999");

            //first is 0
            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_17_NINES, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_TENTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_TENTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_HUNDREDTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_HUNDREDTH, MULTIPLY, "0");

            checkBinaryOperation(BigDecimal.ZERO, ONE_HUNDREDTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NINE_HUNDREDTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, ONE_TENTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NINE_TENTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_16_NINES, MULTIPLY, "0");
            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_17_NINES, MULTIPLY, "0");

            //first is 1
            checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-0.99999999999999999");
            checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-0.9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.99");
            checkBinaryOperation(BigDecimal.ONE, NEG_NINE_TENTH, MULTIPLY, "-0.9");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_TENTH, MULTIPLY, "-0.1");
            checkBinaryOperation(BigDecimal.ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.09");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.01");

            checkBinaryOperation(BigDecimal.ONE, ONE_HUNDREDTH, MULTIPLY, "0.01");
            checkBinaryOperation(BigDecimal.ONE, NINE_HUNDREDTH, MULTIPLY, "0.09");
            checkBinaryOperation(BigDecimal.ONE, ONE_TENTH, MULTIPLY, "0.1");
            checkBinaryOperation(BigDecimal.ONE, NINE_TENTH, MULTIPLY, "0.9");
            checkBinaryOperation(BigDecimal.ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.99");
            checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_16_NINES, MULTIPLY, "0.9999999999999999");
            checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_17_NINES, MULTIPLY, "0.99999999999999999");

            //first is 10
            checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999");
            checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999");
            checkBinaryOperation(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9");
            checkBinaryOperation(BigDecimal.TEN, NEG_NINE_TENTH, MULTIPLY, "-9");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_TENTH, MULTIPLY, "-1");
            checkBinaryOperation(BigDecimal.TEN, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.9");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.1");

            checkBinaryOperation(BigDecimal.TEN, ONE_HUNDREDTH, MULTIPLY, "0.1");
            checkBinaryOperation(BigDecimal.TEN, NINE_HUNDREDTH, MULTIPLY, "0.9");
            checkBinaryOperation(BigDecimal.TEN, ONE_TENTH, MULTIPLY, "1");
            checkBinaryOperation(BigDecimal.TEN, NINE_TENTH, MULTIPLY, "9");
            checkBinaryOperation(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9");
            checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999");
            checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999");

            //first is 100
            checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-99.999999999999999");
            checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-99.99999999999999");
            checkBinaryOperation(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-99");
            checkBinaryOperation(HUNDRED, NEG_NINE_TENTH, MULTIPLY, "-9.e+1");
            checkBinaryOperation(HUNDRED, NEG_ONE_TENTH, MULTIPLY, "-1.e+1");
            checkBinaryOperation(HUNDRED, NEG_NINE_HUNDREDTH, MULTIPLY, "-9");
            checkBinaryOperation(HUNDRED, NEG_ONE_HUNDREDTH, MULTIPLY, "-1");

            checkBinaryOperation(HUNDRED, ONE_HUNDREDTH, MULTIPLY, "1");
            checkBinaryOperation(HUNDRED, NINE_HUNDREDTH, MULTIPLY, "9");
            checkBinaryOperation(HUNDRED, ONE_TENTH, MULTIPLY, "1.e+1");
            checkBinaryOperation(HUNDRED, NINE_TENTH, MULTIPLY, "9.e+1");
            checkBinaryOperation(HUNDRED, NINETY_NINE_HUNDREDTH, MULTIPLY, "99");
            checkBinaryOperation(HUNDRED, ZERO_DOT_16_NINES, MULTIPLY, "99.99999999999999");
            checkBinaryOperation(HUNDRED, ZERO_DOT_17_NINES, MULTIPLY, "99.999999999999999");

            //first is 5000000000000000
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-4999999999999999.95");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-4999999999999999.5");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-4.95e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, MULTIPLY, "-4.5e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, MULTIPLY, "-5.e+14");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, MULTIPLY, "-4.5e+14");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, MULTIPLY, "-5.e+13");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, MULTIPLY, "5.e+13");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, MULTIPLY, "4.5e+14");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_TENTH, MULTIPLY, "5.e+14");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_TENTH, MULTIPLY, "4.5e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "4.95e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, MULTIPLY, "4999999999999999.5");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, MULTIPLY, "4999999999999999.95");

            //first is 9999999999999998
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999997.90000000000000002");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999997.0000000000000002");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9899999999999998.02");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, MULTIPLY, "-8999999999999998.2");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, MULTIPLY, "-999999999999999.8");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "-899999999999999.82");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "-99999999999999.98");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, MULTIPLY, "99999999999999.98");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, MULTIPLY, "899999999999999.82");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, MULTIPLY, "999999999999999.8");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, MULTIPLY, "8999999999999998.2");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "9899999999999998.02");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, MULTIPLY, "9999999999999997.0000000000000002");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, MULTIPLY, "9999999999999997.90000000000000002");

            //first is 9999999999999999
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999998.90000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999998.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9899999999999999.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, MULTIPLY, "-8999999999999999.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, MULTIPLY, "-999999999999999.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, MULTIPLY, "-899999999999999.91");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, MULTIPLY, "-99999999999999.99");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, MULTIPLY, "99999999999999.99");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, MULTIPLY, "899999999999999.91");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_TENTH, MULTIPLY, "999999999999999.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_TENTH, MULTIPLY, "8999999999999999.1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "9899999999999999.01");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, MULTIPLY, "9999999999999998.0000000000000001");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, MULTIPLY, "9999999999999998.90000000000000001");

            //first is 10000000000000000
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, MULTIPLY, "-9.e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, MULTIPLY, "-1.e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.e+14");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.e+14");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, MULTIPLY, "1.e+14");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, MULTIPLY, "9.e+14");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, MULTIPLY, "1.e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, MULTIPLY, "9.e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.9");
        }

        //decimals only
        {
            //first is -0.99999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, MULTIPLY, "0.9999999999999999800000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, MULTIPLY, "0.999999999999999890000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "0.9899999999999999901");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_TENTH, MULTIPLY, "0.899999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_TENTH, MULTIPLY, "0.099999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, MULTIPLY, "0.0899999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, MULTIPLY, "0.0099999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_HUNDREDTH, MULTIPLY, "-0.0099999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_HUNDREDTH, MULTIPLY, "-0.0899999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_TENTH, MULTIPLY, "-0.099999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_TENTH, MULTIPLY, "-0.899999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.9899999999999999901");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, MULTIPLY, "-0.999999999999999890000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, MULTIPLY, "-0.9999999999999999800000000000000001");

            //first is -0.9999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, MULTIPLY, "0.99999999999999980000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "0.989999999999999901");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, MULTIPLY, "0.89999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, MULTIPLY, "0.09999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, MULTIPLY, "0.089999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, MULTIPLY, "0.009999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, MULTIPLY, "-0.009999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, MULTIPLY, "-0.089999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_TENTH, MULTIPLY, "-0.09999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_TENTH, MULTIPLY, "-0.89999999999999991");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.989999999999999901");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, MULTIPLY, "-0.99999999999999980000000000000001");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, MULTIPLY, "-0.999999999999999890000000000000001");

            //first is -0.99
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "0.9801");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, MULTIPLY, "0.891");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, MULTIPLY, "0.099");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, MULTIPLY, "0.0891");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, MULTIPLY, "0.0099");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "-0.0099");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "-0.0891");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, MULTIPLY, "-0.099");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, MULTIPLY, "-0.891");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.9801");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "-0.989999999999999901");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "-0.9899999999999999901");

            //first is -0.9
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, MULTIPLY, "0.81");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, MULTIPLY, "0.09");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, MULTIPLY, "0.081");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, MULTIPLY, "0.009");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, MULTIPLY, "-0.009");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, MULTIPLY, "-0.081");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_TENTH, MULTIPLY, "-0.09");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_TENTH, MULTIPLY, "-0.81");
            checkBinaryOperation(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.891");
            checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "-0.89999999999999991");
            checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "-0.899999999999999991");

            //first is -0.1
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, MULTIPLY, "0.01");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_HUNDREDTH, MULTIPLY, "0.009");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, MULTIPLY, "0.001");

            checkBinaryOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, MULTIPLY, "-0.001");
            checkBinaryOperation(NEG_ONE_TENTH, NINE_HUNDREDTH, MULTIPLY, "-0.009");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_TENTH, MULTIPLY, "-0.01");
            checkBinaryOperation(NEG_ONE_TENTH, NINE_TENTH, MULTIPLY, "-0.09");
            checkBinaryOperation(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.099");
            checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "-0.09999999999999999");
            checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "-0.099999999999999999");

            //first is -0.09
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, MULTIPLY, "0.0081");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, MULTIPLY, "0.0009");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "-0.0009");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "-0.0081");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, MULTIPLY, "-0.009");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, MULTIPLY, "-0.081");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.0891");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "-0.089999999999999991");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "-0.0899999999999999991");

            //first is -0.01
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, MULTIPLY, "0.0001");

            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "-0.0001");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "-0.0009");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, MULTIPLY, "-0.001");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_TENTH, MULTIPLY, "-0.009");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.0099");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "-0.009999999999999999");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "-0.0099999999999999999");

            //first is 0.01
            checkBinaryOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "0.0001");
            checkBinaryOperation(ONE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "0.0009");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_TENTH, MULTIPLY, "0.001");
            checkBinaryOperation(ONE_HUNDREDTH, NINE_TENTH, MULTIPLY, "0.009");
            checkBinaryOperation(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.0099");
            checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "0.009999999999999999");
            checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "0.0099999999999999999");

            //first is 0.09
            checkBinaryOperation(NINE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "0.0081");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_TENTH, MULTIPLY, "0.009");
            checkBinaryOperation(NINE_HUNDREDTH, NINE_TENTH, MULTIPLY, "0.081");
            checkBinaryOperation(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.0891");
            checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "0.089999999999999991");
            checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "0.0899999999999999991");

            //first is 0.1
            checkBinaryOperation(ONE_TENTH, ONE_TENTH, MULTIPLY, "0.01");
            checkBinaryOperation(ONE_TENTH, NINE_TENTH, MULTIPLY, "0.09");
            checkBinaryOperation(ONE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.099");
            checkBinaryOperation(ONE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "0.09999999999999999");
            checkBinaryOperation(ONE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "0.099999999999999999");

            //first is 0.9
            checkBinaryOperation(NINE_TENTH, NINE_TENTH, MULTIPLY, "0.81");
            checkBinaryOperation(NINE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.891");
            checkBinaryOperation(NINE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "0.89999999999999991");
            checkBinaryOperation(NINE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "0.899999999999999991");

            //first is 0.99
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.9801");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "0.989999999999999901");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "0.9899999999999999901");

            //first is 0.9999999999999999
            checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, MULTIPLY, "0.99999999999999980000000000000001");
            checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, MULTIPLY, "0.999999999999999890000000000000001");

            //first is 0.99999999999999999
            checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, MULTIPLY, "0.9999999999999999800000000000000001");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, MULTIPLY, "1.e+34");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, MULTIPLY, "1.e+33");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, MULTIPLY, "-1.e+33");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, MULTIPLY, "-1.e+34");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, MULTIPLY, "1.e+32");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, MULTIPLY, "-1.e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, MULTIPLY, "-1.e+33");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, MULTIPLY, "1.e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, MULTIPLY, "1.e+33");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, MULTIPLY, "1.e+34");


            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, MULTIPLY, "1.e-34");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, MULTIPLY, "1.e-33");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, MULTIPLY, "-1.e-33");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, MULTIPLY, "-1.e-34");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, MULTIPLY, "1.e-32");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, MULTIPLY, "-1.e-32");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, MULTIPLY, "-1.e-33");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, MULTIPLY, "1.e-32");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, MULTIPLY, "1.e-33");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, MULTIPLY, "1.e-34");
        }

        //with integers
        {
            //first is -1.e-9999
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.e-9983");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e-9984");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998e-9984");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.e-9984");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_HUNDRED, MULTIPLY, "1.e-9997");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_TEN, MULTIPLY, "1.e-9998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE, MULTIPLY, "1.e-9999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ONE, MULTIPLY, "-1.e-9999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.TEN, MULTIPLY, "-1.e-9998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HUNDRED, MULTIPLY, "-1.e-9997");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e-9984");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998e-9984");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e-9984");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e-9983");

            //first is -1.e-9998
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.e-9982");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e-9983");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998e-9983");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.e-9983");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_HUNDRED, MULTIPLY, "1.e-9996");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_TEN, MULTIPLY, "1.e-9997");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE, MULTIPLY, "1.e-9998");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ONE, MULTIPLY, "-1.e-9998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.TEN, MULTIPLY, "-1.e-9997");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HUNDRED, MULTIPLY, "-1.e-9996");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e-9983");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998e-9983");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e-9983");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e-9982");

            //first is 1.e-9998
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.e-9982");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e-9983");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998e-9983");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.e-9983");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_HUNDRED, MULTIPLY, "-1.e-9996");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_TEN, MULTIPLY, "-1.e-9997");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE, MULTIPLY, "-1.e-9998");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ONE, MULTIPLY, "1.e-9998");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.TEN, MULTIPLY, "1.e-9997");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, HUNDRED, MULTIPLY, "1.e-9996");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.e-9983");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998e-9983");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e-9983");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e-9982");

            //first is 1.e-9999
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.e-9983");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e-9984");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998e-9984");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.e-9984");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_HUNDRED, MULTIPLY, "-1.e-9997");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_TEN, MULTIPLY, "-1.e-9998");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE, MULTIPLY, "-1.e-9999");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ONE, MULTIPLY, "1.e-9999");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.TEN, MULTIPLY, "1.e-9998");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, HUNDRED, MULTIPLY, "1.e-9997");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.e-9984");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998e-9984");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e-9984");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e-9983");


            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.e+33");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, MULTIPLY, "1.e+19");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, MULTIPLY, "1.e+18");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, MULTIPLY, "1.e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, MULTIPLY, "-1.e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, MULTIPLY, "-1.e+18");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, MULTIPLY, "-1.e+19");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e+33");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.e+32");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e+31");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998e+31");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.e+31");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, MULTIPLY, "1.e+18");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, MULTIPLY, "1.e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, MULTIPLY, "1.e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, MULTIPLY, "-1.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, MULTIPLY, "-1.e+17");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, MULTIPLY, "-1.e+18");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.e+31");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998e+31");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e+31");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.e+32");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e+31");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998e+31");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.e+31");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, MULTIPLY, "-1.e+18");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, MULTIPLY, "-1.e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, MULTIPLY, "-1.e+16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, MULTIPLY, "1.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, MULTIPLY, "1.e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, MULTIPLY, "1.e+18");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.e+31");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998e+31");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e+31");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e+32");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.e+33");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, MULTIPLY, "-1.e+19");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, MULTIPLY, "-1.e+18");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, MULTIPLY, "-1.e+17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, MULTIPLY, "1.e+17");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, MULTIPLY, "1.e+18");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, MULTIPLY, "1.e+19");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999e+32");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.e+33");


            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0.1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "0.09999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0.09999999999999998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "0.05");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, MULTIPLY, "1.e-15");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, MULTIPLY, "1.e-16");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, MULTIPLY, "1.e-17");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, MULTIPLY, "-1.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, MULTIPLY, "-1.e-16");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, MULTIPLY, "-1.e-15");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.05");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-0.09999999999999998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.09999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-0.1");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "0.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0.9999999999999998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "0.5");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, MULTIPLY, "1.e-14");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, MULTIPLY, "1.e-15");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, MULTIPLY, "1.e-16");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, MULTIPLY, "-1.e-16");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, MULTIPLY, "-1.e-15");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, MULTIPLY, "-1.e-14");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.5");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-0.9999999999999998");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-0.9999999999999998");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.5");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, MULTIPLY, "-1.e-14");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, MULTIPLY, "-1.e-15");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, MULTIPLY, "-1.e-16");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, MULTIPLY, "1.e-16");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, MULTIPLY, "1.e-15");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, MULTIPLY, "1.e-14");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "0.5");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0.9999999999999998");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "0.9999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-0.1");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.09999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-0.09999999999999998");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.05");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, MULTIPLY, "-1.e-15");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, MULTIPLY, "-1.e-16");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, MULTIPLY, "-1.e-17");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, MULTIPLY, "0");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, MULTIPLY, "1.e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, MULTIPLY, "1.e-16");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, MULTIPLY, "1.e-15");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "0.05");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0.09999999999999998");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "0.09999999999999999");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0.1");
        }

        //with decimals
        {
            //first is -1.e+9999
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINE_TENTH, MULTIPLY, "9.e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, MULTIPLY, "1.e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINE_HUNDREDTH, MULTIPLY, "9.e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, MULTIPLY, "1.e+9997");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, MULTIPLY, "-1.e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NINE_HUNDREDTH, MULTIPLY, "-9.e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_TENTH, MULTIPLY, "-1.e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NINE_TENTH, MULTIPLY, "-9.e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e+9998");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e+9998");

            //first is -1.e+9998
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINE_TENTH, MULTIPLY, "9.e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, MULTIPLY, "1.e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINE_HUNDREDTH, MULTIPLY, "9.e+9996");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, MULTIPLY, "1.e+9996");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, MULTIPLY, "-1.e+9996");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NINE_HUNDREDTH, MULTIPLY, "-9.e+9996");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_TENTH, MULTIPLY, "-1.e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NINE_TENTH, MULTIPLY, "-9.e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e+9997");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e+9997");

            //first is 1.e+9998
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_NINE_TENTH, MULTIPLY, "-9.e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, MULTIPLY, "-1.e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.e+9996");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.e+9996");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, MULTIPLY, "1.e+9996");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NINE_HUNDREDTH, MULTIPLY, "9.e+9996");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_TENTH, MULTIPLY, "1.e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NINE_TENTH, MULTIPLY, "9.e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e+9997");

            //first is 1.e+9999
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_NINE_TENTH, MULTIPLY, "-9.e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, MULTIPLY, "-1.e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.e+9997");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, MULTIPLY, "1.e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NINE_HUNDREDTH, MULTIPLY, "9.e+9997");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_TENTH, MULTIPLY, "1.e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NINE_TENTH, MULTIPLY, "9.e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e+9998");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e+9998");


            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "99999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, MULTIPLY, "9.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, MULTIPLY, "1.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "9.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "1.e+15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, MULTIPLY, "-1.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, MULTIPLY, "-9.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_TENTH, MULTIPLY, "-1.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_TENTH, MULTIPLY, "-9.e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e+16");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, MULTIPLY, "-99999999999999999");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.9");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, MULTIPLY, "9.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, MULTIPLY, "1.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "9.e+14");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "1.e+14");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, MULTIPLY, "-1.e+14");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, MULTIPLY, "-9.e+14");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_TENTH, MULTIPLY, "-1.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_TENTH, MULTIPLY, "-9.e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+15");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.9");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.9");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, MULTIPLY, "-9.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, MULTIPLY, "-1.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.e+14");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.e+14");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, MULTIPLY, "1.e+14");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, MULTIPLY, "9.e+14");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_TENTH, MULTIPLY, "1.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_TENTH, MULTIPLY, "9.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.9");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-99999999999999999");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, MULTIPLY, "-9.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, MULTIPLY, "-1.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.e+15");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, MULTIPLY, "1.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, MULTIPLY, "9.e+15");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_TENTH, MULTIPLY, "1.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_TENTH, MULTIPLY, "9.e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e+16");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, MULTIPLY, "99999999999999999");


            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, MULTIPLY, "9.e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, MULTIPLY, "1.e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "9.e-19");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "1.e-19");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, MULTIPLY, "-1.e-19");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, MULTIPLY, "-9.e-19");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_TENTH, MULTIPLY, "-1.e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_TENTH, MULTIPLY, "-9.e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e-18");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, MULTIPLY, "9.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, MULTIPLY, "1.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "9.e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "1.e-18");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, MULTIPLY, "-1.e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, MULTIPLY, "-9.e-18");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_TENTH, MULTIPLY, "-1.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_TENTH, MULTIPLY, "-9.e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e-17");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e-17");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, MULTIPLY, "-9.e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, MULTIPLY, "-1.e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.e-18");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, MULTIPLY, "1.e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, MULTIPLY, "9.e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_TENTH, MULTIPLY, "1.e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_TENTH, MULTIPLY, "9.e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e-17");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e-17");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, MULTIPLY, "-9.e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, MULTIPLY, "-1.e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.e-19");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.e-19");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, MULTIPLY, "1.e-19");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, MULTIPLY, "9.e-19");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_TENTH, MULTIPLY, "1.e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_TENTH, MULTIPLY, "9.e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999e-18");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999e-18");
        }

        //several random values
        {
            checkBinaryOperation(new BigDecimal("41"), new BigDecimal("13"), MULTIPLY, "533");
            checkBinaryOperation(new BigDecimal("64"), new BigDecimal("56"), MULTIPLY, "3584");

            checkBinaryOperation(new BigDecimal("123"), new BigDecimal("-13"), MULTIPLY, "-1599");
            checkBinaryOperation(new BigDecimal("41"), new BigDecimal("-65"), MULTIPLY, "-2665");

            checkBinaryOperation(new BigDecimal("-876"), new BigDecimal("-13"), MULTIPLY, "11388");
            checkBinaryOperation(new BigDecimal("-54"), new BigDecimal("-53"), MULTIPLY, "2862");

            checkBinaryOperation(new BigDecimal("12"), new BigDecimal("541.652"), MULTIPLY, "6499.824");
            checkBinaryOperation(new BigDecimal("9"), new BigDecimal("13.764"), MULTIPLY, "123.876");

            checkBinaryOperation(new BigDecimal("132"), new BigDecimal("-23.13"), MULTIPLY, "-3053.16");
            checkBinaryOperation(new BigDecimal("12"), new BigDecimal("-76.87"), MULTIPLY, "-922.44");

            checkBinaryOperation(new BigDecimal("-65"), new BigDecimal("65.13"), MULTIPLY, "-4233.45");
            checkBinaryOperation(new BigDecimal("-76"), new BigDecimal("75.123"), MULTIPLY, "-5709.348");

            checkBinaryOperation(new BigDecimal("-13"), new BigDecimal("-6.12"), MULTIPLY, "79.56");
            checkBinaryOperation(new BigDecimal("-76"), new BigDecimal("-13.5"), MULTIPLY, "1026");

            checkBinaryOperation(new BigDecimal("33.12"), new BigDecimal("6.13"), MULTIPLY, "203.0256");
            checkBinaryOperation(new BigDecimal("86.7"), new BigDecimal("5.132"), MULTIPLY, "444.9444");

            checkBinaryOperation(new BigDecimal("1.75"), new BigDecimal("-0.1"), MULTIPLY, "-0.175");
            checkBinaryOperation(new BigDecimal("23.5"), new BigDecimal("-6.87"), MULTIPLY, "-161.445");

            checkBinaryOperation(new BigDecimal("-765.1"), new BigDecimal("-1.8"), MULTIPLY, "1377.18");
            checkBinaryOperation(new BigDecimal("-65.7"), new BigDecimal("-7.8"), MULTIPLY, "512.46");
        }
    }

    /**
     * Tests for binary divide operation.
     *
     * @see BinaryOperations
     */
    @Test
    void divideOperationTests() {
        //integers only
        {
            //first is -10000000000000000
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, DIVIDE, "1.e+14");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, DIVIDE, "1.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, DIVIDE, "1.e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, DIVIDE, "-1.e+16");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, DIVIDE, "-1.e+15");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, DIVIDE, "-1.e+14");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1");

            //first is -9999999999999999
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "0.9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, DIVIDE, "1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1.9999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, DIVIDE, "99999999999999.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, DIVIDE, "999999999999999.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, DIVIDE, "9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ONE, DIVIDE, "-9999999999999999");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.TEN, DIVIDE, "-999999999999999.9");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HUNDRED, DIVIDE, "-99999999999999.99");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1.9999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, DIVIDE, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-0.9999999999999999");

            //first is -9999999999999998
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "0.9999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1.9999999999999996");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, DIVIDE, "99999999999999.98");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, DIVIDE, "999999999999999.8");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, DIVIDE, "9999999999999998");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, DIVIDE, "-9999999999999998");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, DIVIDE, "-999999999999999.8");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, DIVIDE, "-99999999999999.98");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1.9999999999999996");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-0.9999999999999998");

            //first is -5000000000000000
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "0.5");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, DIVIDE, "5.e+13");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, DIVIDE, "5.e+14");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, DIVIDE, "5.e+15");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, DIVIDE, "-5.e+15");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, DIVIDE, "-5.e+14");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, DIVIDE, "-5.e+13");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-0.5");

            //first is -100
            checkBinaryOperation(NEG_HUNDRED, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e-14");
            checkBinaryOperation(NEG_HUNDRED, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e-14");
            checkBinaryOperation(NEG_HUNDRED, NEG_HUNDRED, DIVIDE, "1");
            checkBinaryOperation(NEG_HUNDRED, NEG_TEN, DIVIDE, "1.e+1");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE, DIVIDE, "1.e+2");

            checkBinaryOperation(NEG_HUNDRED, BigDecimal.ONE, DIVIDE, "-1.e+2");
            checkBinaryOperation(NEG_HUNDRED, BigDecimal.TEN, DIVIDE, "-1.e+1");
            checkBinaryOperation(NEG_HUNDRED, HUNDRED, DIVIDE, "-1");
            checkBinaryOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e-14");
            checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e-14");

            //first is -10
            checkBinaryOperation(NEG_TEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e-15");
            checkBinaryOperation(NEG_TEN, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e-15");
            checkBinaryOperation(NEG_TEN, NEG_HUNDRED, DIVIDE, "0.1");
            checkBinaryOperation(NEG_TEN, NEG_TEN, DIVIDE, "1");
            checkBinaryOperation(NEG_TEN, NEG_ONE, DIVIDE, "1.e+1");

            checkBinaryOperation(NEG_TEN, BigDecimal.ONE, DIVIDE, "-1.e+1");
            checkBinaryOperation(NEG_TEN, BigDecimal.TEN, DIVIDE, "-1");
            checkBinaryOperation(NEG_TEN, HUNDRED, DIVIDE, "-0.1");
            checkBinaryOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e-15");
            checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e-15");

            //first is -1
            checkBinaryOperation(NEG_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e-16");
            checkBinaryOperation(NEG_ONE, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e-16");
            checkBinaryOperation(NEG_ONE, NEG_HUNDRED, DIVIDE, "0.01");
            checkBinaryOperation(NEG_ONE, NEG_TEN, DIVIDE, "0.1");
            checkBinaryOperation(NEG_ONE, NEG_ONE, DIVIDE, "1");

            checkBinaryOperation(NEG_ONE, BigDecimal.ONE, DIVIDE, "-1");
            checkBinaryOperation(NEG_ONE, BigDecimal.TEN, DIVIDE, "-0.1");
            checkBinaryOperation(NEG_ONE, HUNDRED, DIVIDE, "-0.01");
            checkBinaryOperation(NEG_ONE, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e-16");
            checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e-16");

            //first is 0
            checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_HUNDRED, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_TEN, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ONE, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, BigDecimal.TEN, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, HUNDRED, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN, DIVIDE, "0");
            checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "0");

            //first is 1
            checkBinaryOperation(BigDecimal.ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e-16");
            checkBinaryOperation(BigDecimal.ONE, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e-16");
            checkBinaryOperation(BigDecimal.ONE, NEG_HUNDRED, DIVIDE, "-0.01");
            checkBinaryOperation(BigDecimal.ONE, NEG_TEN, DIVIDE, "-0.1");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE, DIVIDE, "-1");

            checkBinaryOperation(BigDecimal.ONE, BigDecimal.ONE, DIVIDE, "1");
            checkBinaryOperation(BigDecimal.ONE, BigDecimal.TEN, DIVIDE, "0.1");
            checkBinaryOperation(BigDecimal.ONE, HUNDRED, DIVIDE, "0.01");
            checkBinaryOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e-16");
            checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e-16");

            //first is 10
            checkBinaryOperation(BigDecimal.TEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e-15");
            checkBinaryOperation(BigDecimal.TEN, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e-15");
            checkBinaryOperation(BigDecimal.TEN, NEG_HUNDRED, DIVIDE, "-0.1");
            checkBinaryOperation(BigDecimal.TEN, NEG_TEN, DIVIDE, "-1");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE, DIVIDE, "-1.e+1");

            checkBinaryOperation(BigDecimal.TEN, BigDecimal.ONE, DIVIDE, "1.e+1");
            checkBinaryOperation(BigDecimal.TEN, BigDecimal.TEN, DIVIDE, "1");
            checkBinaryOperation(BigDecimal.TEN, HUNDRED, DIVIDE, "0.1");
            checkBinaryOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e-15");
            checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e-15");

            //first is 100
            checkBinaryOperation(HUNDRED, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e-14");
            checkBinaryOperation(HUNDRED, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e-14");
            checkBinaryOperation(HUNDRED, NEG_HUNDRED, DIVIDE, "-1");
            checkBinaryOperation(HUNDRED, NEG_TEN, DIVIDE, "-1.e+1");
            checkBinaryOperation(HUNDRED, NEG_ONE, DIVIDE, "-1.e+2");

            checkBinaryOperation(HUNDRED, BigDecimal.ONE, DIVIDE, "1.e+2");
            checkBinaryOperation(HUNDRED, BigDecimal.TEN, DIVIDE, "1.e+1");
            checkBinaryOperation(HUNDRED, HUNDRED, DIVIDE, "1");
            checkBinaryOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e-14");
            checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e-14");

            //first is 5000000000000000
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-0.5");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_HUNDRED, DIVIDE, "-5.e+13");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_TEN, DIVIDE, "-5.e+14");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE, DIVIDE, "-5.e+15");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.ONE, DIVIDE, "5.e+15");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.TEN, DIVIDE, "5.e+14");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HUNDRED, DIVIDE, "5.e+13");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "0.5");

            //first is 9999999999999998
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-0.9999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1.9999999999999996");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, DIVIDE, "-99999999999999.98");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, DIVIDE, "-999999999999999.8");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, DIVIDE, "-9999999999999998");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, DIVIDE, "9999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, DIVIDE, "999999999999999.8");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, DIVIDE, "99999999999999.98");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1.9999999999999996");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "0.9999999999999998");

            //first is 9999999999999999
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-0.9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, DIVIDE, "-1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1.9999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_HUNDRED, DIVIDE, "-99999999999999.99");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_TEN, DIVIDE, "-999999999999999.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE, DIVIDE, "-9999999999999999");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.ONE, DIVIDE, "9999999999999999");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.TEN, DIVIDE, "999999999999999.9");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, HUNDRED, DIVIDE, "99999999999999.99");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1.9999999999999998");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, DIVIDE, "1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "0.9999999999999999");

            //first is 10000000000000000
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, DIVIDE, "-1.e+14");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, DIVIDE, "-1.e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, DIVIDE, "-1.e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, DIVIDE, "1.e+16");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, DIVIDE, "1.e+15");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, DIVIDE, "1.e+14");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1");
        }

        //integer and decimal
        {
            //first is -10000000000000000 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "9.9999999999999999e-17");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "9.999999999999999e-17");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "9.9e-17");

            checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "9.e-17");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, DIVIDE, "1.e+17");
            checkBinaryOperation(NEG_ONE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e-17");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "9.e-18");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, DIVIDE, "1.e+18");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e-18");


            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, DIVIDE, "-1.e+18");
            checkBinaryOperation(ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e-18");

            checkBinaryOperation(NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-9.e-18");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, DIVIDE, "-1.e+17");
            checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e-17");

            checkBinaryOperation(NINE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-9.e-17");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-9.9e-17");

            checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-9.999999999999999e-17");

            checkBinaryOperation(ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-9.9999999999999999e-17");

            //first is -9999999999999999 (and vice versa)
            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, DIVIDE, "1.e+16");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN, DIVIDE, "1.e-16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, DIVIDE, "1.01010101010101e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, DIVIDE, "1.111111111111111e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, DIVIDE, "9.999999999999999e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, DIVIDE, "1.111111111111111e+17");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, DIVIDE, "9.999999999999999e+17");


            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, DIVIDE, "-9.999999999999999e+17");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, DIVIDE, "-1.111111111111111e+17");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_TENTH, DIVIDE, "-9.999999999999999e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_TENTH, DIVIDE, "-1.111111111111111e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, DIVIDE, "-1.01010101010101e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, DIVIDE, "-1.e+16");
            checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN, DIVIDE, "-1.e-16");

            //first is -9999999999999998 (and vice versa)
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, DIVIDE, "9.999999999999998e+16");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, DIVIDE, "9.999999999999998e+17");


            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, DIVIDE, "-9.999999999999998e+17");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, DIVIDE, "-9.999999999999998e+16");

            //first is -5000000000000000 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1.99999999999999998e-16");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1.9999999999999998e-16");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1.98e-16");

            checkBinaryOperation(NEG_NINE_TENTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1.8e-16");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, DIVIDE, "5.e+16");
            checkBinaryOperation(NEG_ONE_TENTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e-17");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "1.8e-17");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, DIVIDE, "5.e+17");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e-18");


            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, DIVIDE, "-5.e+17");
            checkBinaryOperation(ONE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e-18");

            checkBinaryOperation(NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1.8e-17");

            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_TENTH, DIVIDE, "-5.e+16");
            checkBinaryOperation(ONE_TENTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e-17");

            checkBinaryOperation(NINE_TENTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1.8e-16");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1.98e-16");

            checkBinaryOperation(ZERO_DOT_16_NINES, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1.9999999999999998e-16");

            checkBinaryOperation(ZERO_DOT_17_NINES, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-1.99999999999999998e-16");

            //first is -100 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_HUNDRED, DIVIDE, "0.0099999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_HUNDRED, DIVIDE, "0.009999999999999999");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_HUNDRED, DIVIDE, "0.0099");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_HUNDRED, DIVIDE, "0.009");

            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_TENTH, DIVIDE, "1.e+3");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_HUNDRED, DIVIDE, "0.001");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_HUNDRED, DIVIDE, "0.0009");

            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_HUNDREDTH, DIVIDE, "1.e+4");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_HUNDRED, DIVIDE, "0.0001");


            checkBinaryOperation(NEG_HUNDRED, ONE_HUNDREDTH, DIVIDE, "-1.e+4");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_HUNDRED, DIVIDE, "-0.0001");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_HUNDRED, DIVIDE, "-0.0009");

            checkBinaryOperation(NEG_HUNDRED, ONE_TENTH, DIVIDE, "-1.e+3");
            checkBinaryOperation(ONE_TENTH, NEG_HUNDRED, DIVIDE, "-0.001");

            checkBinaryOperation(NINE_TENTH, NEG_HUNDRED, DIVIDE, "-0.009");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_HUNDRED, DIVIDE, "-0.0099");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_HUNDRED, DIVIDE, "-0.009999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_HUNDRED, DIVIDE, "-0.0099999999999999999");

            //first is -10 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_TEN, DIVIDE, "0.099999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_TEN, DIVIDE, "0.09999999999999999");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_TEN, DIVIDE, "0.099");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_TEN, DIVIDE, "0.09");

            checkBinaryOperation(NEG_TEN, NEG_ONE_TENTH, DIVIDE, "1.e+2");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_TEN, DIVIDE, "0.01");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_TEN, DIVIDE, "0.009");

            checkBinaryOperation(NEG_TEN, NEG_ONE_HUNDREDTH, DIVIDE, "1.e+3");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_TEN, DIVIDE, "0.001");


            checkBinaryOperation(NEG_TEN, ONE_HUNDREDTH, DIVIDE, "-1.e+3");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_TEN, DIVIDE, "-0.001");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_TEN, DIVIDE, "-0.009");

            checkBinaryOperation(NEG_TEN, ONE_TENTH, DIVIDE, "-1.e+2");
            checkBinaryOperation(ONE_TENTH, NEG_TEN, DIVIDE, "-0.01");

            checkBinaryOperation(NINE_TENTH, NEG_TEN, DIVIDE, "-0.09");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_TEN, DIVIDE, "-0.099");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_TEN, DIVIDE, "-0.09999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_TEN, DIVIDE, "-0.099999999999999999");

            //first is -1 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE, DIVIDE, "0.99999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE, DIVIDE, "0.9999999999999999");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE, DIVIDE, "0.99");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE, DIVIDE, "0.9");

            checkBinaryOperation(NEG_ONE, NEG_ONE_TENTH, DIVIDE, "1.e+1");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE, DIVIDE, "0.1");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE, DIVIDE, "0.09");

            checkBinaryOperation(NEG_ONE, NEG_ONE_HUNDREDTH, DIVIDE, "1.e+2");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE, DIVIDE, "0.01");


            checkBinaryOperation(NEG_ONE, ONE_HUNDREDTH, DIVIDE, "-1.e+2");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE, DIVIDE, "-0.01");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE, DIVIDE, "-0.09");

            checkBinaryOperation(NEG_ONE, ONE_TENTH, DIVIDE, "-1.e+1");
            checkBinaryOperation(ONE_TENTH, NEG_ONE, DIVIDE, "-0.1");

            checkBinaryOperation(NINE_TENTH, NEG_ONE, DIVIDE, "-0.9");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE, DIVIDE, "-0.99");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE, DIVIDE, "-0.9999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE, DIVIDE, "-0.99999999999999999");

            //first is 0 (and vice versa)
            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_17_NINES, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_TENTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_TENTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_HUNDREDTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_HUNDREDTH, DIVIDE, "0");


            checkBinaryOperation(BigDecimal.ZERO, ONE_HUNDREDTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NINE_HUNDREDTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, ONE_TENTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NINE_TENTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_16_NINES, DIVIDE, "0");

            checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_17_NINES, DIVIDE, "0");

            //first is 1 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.ONE, DIVIDE, "-0.99999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.ONE, DIVIDE, "-0.9999999999999999");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.ONE, DIVIDE, "-0.99");

            checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.ONE, DIVIDE, "-0.9");

            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_TENTH, DIVIDE, "-1.e+1");
            checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.ONE, DIVIDE, "-0.1");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.ONE, DIVIDE, "-0.09");

            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e+2");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.ONE, DIVIDE, "-0.01");


            checkBinaryOperation(BigDecimal.ONE, ONE_HUNDREDTH, DIVIDE, "1.e+2");
            checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.ONE, DIVIDE, "0.01");

            checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.ONE, DIVIDE, "0.09");

            checkBinaryOperation(BigDecimal.ONE, ONE_TENTH, DIVIDE, "1.e+1");
            checkBinaryOperation(ONE_TENTH, BigDecimal.ONE, DIVIDE, "0.1");

            checkBinaryOperation(NINE_TENTH, BigDecimal.ONE, DIVIDE, "0.9");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.ONE, DIVIDE, "0.99");

            checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.ONE, DIVIDE, "0.9999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.ONE, DIVIDE, "0.99999999999999999");

            //first is 10 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.TEN, DIVIDE, "-0.099999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.TEN, DIVIDE, "-0.09999999999999999");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.TEN, DIVIDE, "-0.099");

            checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.TEN, DIVIDE, "-0.09");

            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_TENTH, DIVIDE, "-1.e+2");
            checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.TEN, DIVIDE, "-0.01");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.TEN, DIVIDE, "-0.009");

            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e+3");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.TEN, DIVIDE, "-0.001");


            checkBinaryOperation(BigDecimal.TEN, ONE_HUNDREDTH, DIVIDE, "1.e+3");
            checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.TEN, DIVIDE, "0.001");

            checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.TEN, DIVIDE, "0.009");

            checkBinaryOperation(BigDecimal.TEN, ONE_TENTH, DIVIDE, "1.e+2");
            checkBinaryOperation(ONE_TENTH, BigDecimal.TEN, DIVIDE, "0.01");

            checkBinaryOperation(NINE_TENTH, BigDecimal.TEN, DIVIDE, "0.09");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.TEN, DIVIDE, "0.099");

            checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.TEN, DIVIDE, "0.09999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.TEN, DIVIDE, "0.099999999999999999");

            //first is 100 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HUNDRED, DIVIDE, "-0.0099999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HUNDRED, DIVIDE, "-0.009999999999999999");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HUNDRED, DIVIDE, "-0.0099");

            checkBinaryOperation(NEG_NINE_TENTH, HUNDRED, DIVIDE, "-0.009");

            checkBinaryOperation(HUNDRED, NEG_ONE_TENTH, DIVIDE, "-1.e+3");
            checkBinaryOperation(NEG_ONE_TENTH, HUNDRED, DIVIDE, "-0.001");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, HUNDRED, DIVIDE, "-0.0009");

            checkBinaryOperation(HUNDRED, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e+4");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, HUNDRED, DIVIDE, "-0.0001");


            checkBinaryOperation(HUNDRED, ONE_HUNDREDTH, DIVIDE, "1.e+4");
            checkBinaryOperation(ONE_HUNDREDTH, HUNDRED, DIVIDE, "0.0001");

            checkBinaryOperation(NINE_HUNDREDTH, HUNDRED, DIVIDE, "0.0009");

            checkBinaryOperation(HUNDRED, ONE_TENTH, DIVIDE, "1.e+3");
            checkBinaryOperation(ONE_TENTH, HUNDRED, DIVIDE, "0.001");

            checkBinaryOperation(NINE_TENTH, HUNDRED, DIVIDE, "0.009");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, HUNDRED, DIVIDE, "0.0099");

            checkBinaryOperation(ZERO_DOT_16_NINES, HUNDRED, DIVIDE, "0.009999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, HUNDRED, DIVIDE, "0.0099999999999999999");

            //first is 5000000000000000 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1.99999999999999998e-16");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1.9999999999999998e-16");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1.98e-16");

            checkBinaryOperation(NEG_NINE_TENTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1.8e-16");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, DIVIDE, "-5.e+16");
            checkBinaryOperation(NEG_ONE_TENTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e-17");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-1.8e-17");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, DIVIDE, "-5.e+17");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e-18");


            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, DIVIDE, "5.e+17");
            checkBinaryOperation(ONE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e-18");

            checkBinaryOperation(NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1.8e-17");

            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_TENTH, DIVIDE, "5.e+16");
            checkBinaryOperation(ONE_TENTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e-17");

            checkBinaryOperation(NINE_TENTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1.8e-16");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1.98e-16");

            checkBinaryOperation(ZERO_DOT_16_NINES, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1.9999999999999998e-16");

            checkBinaryOperation(ZERO_DOT_17_NINES, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "1.99999999999999998e-16");

            //first is 9999999999999998 (and vice versa)
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, DIVIDE, "-9.999999999999998e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, DIVIDE, "-9.999999999999998e+17");


            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, DIVIDE, "9.999999999999998e+17");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, DIVIDE, "9.999999999999998e+16");

            //first is 9999999999999999 (and vice versa)
            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, DIVIDE, "-1.e+16");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN, DIVIDE, "-1.e-16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, DIVIDE, "-1.01010101010101e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, DIVIDE, "-1.111111111111111e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, DIVIDE, "-9.999999999999999e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, DIVIDE, "-1.111111111111111e+17");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, DIVIDE, "-9.999999999999999e+17");


            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, DIVIDE, "9.999999999999999e+17");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, DIVIDE, "1.111111111111111e+17");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_TENTH, DIVIDE, "9.999999999999999e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_TENTH, DIVIDE, "1.111111111111111e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, DIVIDE, "1.01010101010101e+16");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, DIVIDE, "1.e+16");
            checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN, DIVIDE, "1.e-16");

            //first is 10000000000000000 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-9.9999999999999999e-17");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-9.999999999999999e-17");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-9.9e-17");

            checkBinaryOperation(NEG_NINE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-9.e-17");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, DIVIDE, "-1.e+17");
            checkBinaryOperation(NEG_ONE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e-17");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-9.e-18");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e+18");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e-18");


            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, DIVIDE, "1.e+18");
            checkBinaryOperation(ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e-18");

            checkBinaryOperation(NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "9.e-18");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, DIVIDE, "1.e+17");
            checkBinaryOperation(ONE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e-17");

            checkBinaryOperation(NINE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "9.e-17");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "9.9e-17");

            checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "9.999999999999999e-17");

            checkBinaryOperation(ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "9.9999999999999999e-17");
        }

        //decimals only
        {
            //first is -0.99999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, DIVIDE, "1");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_TENTH, DIVIDE, "1.1111111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_TENTH, DIVIDE, "9.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, DIVIDE, "11.111111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, DIVIDE, "99.999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_HUNDREDTH, DIVIDE, "-99.999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_HUNDREDTH, DIVIDE, "-11.111111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_TENTH, DIVIDE, "-9.9999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_TENTH, DIVIDE, "-1.1111111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, DIVIDE, "-1");

            //first is -0.9999999999999999
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, DIVIDE, "1");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, DIVIDE, "1.01010101010101");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, DIVIDE, "1.111111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, DIVIDE, "9.999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, DIVIDE, "11.11111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, DIVIDE, "99.99999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, DIVIDE, "-99.99999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, DIVIDE, "-11.11111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_TENTH, DIVIDE, "-9.999999999999999");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_TENTH, DIVIDE, "-1.111111111111111");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, DIVIDE, "-1.01010101010101");
            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, DIVIDE, "-1");

            //first is -0.99
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, DIVIDE, "1");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, DIVIDE, "1.1");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, DIVIDE, "9.9");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, DIVIDE, "11");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, DIVIDE, "99");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, DIVIDE, "-99");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, DIVIDE, "-11");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, DIVIDE, "-9.9");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, DIVIDE, "-1.1");
            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, DIVIDE, "-1");

            //first is -0.9
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, DIVIDE, "1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, DIVIDE, "9");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, DIVIDE, "1.e+1");
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, DIVIDE, "9.e+1");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, DIVIDE, "-9.e+1");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, DIVIDE, "-1.e+1");
            checkBinaryOperation(NEG_NINE_TENTH, ONE_TENTH, DIVIDE, "-9");
            checkBinaryOperation(NEG_NINE_TENTH, NINE_TENTH, DIVIDE, "-1");

            //first is -0.1
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, DIVIDE, "1");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, DIVIDE, "1.e+1");

            checkBinaryOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, DIVIDE, "-1.e+1");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_TENTH, DIVIDE, "-1");

            //first is -0.09
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_TENTH, DIVIDE, "0.1");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_TENTH, DIVIDE, "0.9");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, DIVIDE, "1");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, DIVIDE, "9");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, DIVIDE, "-9");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, DIVIDE, "-1");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, DIVIDE, "-0.9");
            checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, DIVIDE, "-0.1");

            //first is -0.01
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_TENTH, DIVIDE, "0.1");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, DIVIDE, "1");

            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, DIVIDE, "-1");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, DIVIDE, "-0.1");

            //first is 0.01
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_TENTH, DIVIDE, "-0.1");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, DIVIDE, "-1");

            checkBinaryOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, DIVIDE, "1");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_TENTH, DIVIDE, "0.1");

            //first is 0.09
            checkBinaryOperation(NINE_HUNDREDTH, NEG_NINE_TENTH, DIVIDE, "-0.1");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_TENTH, DIVIDE, "-0.9");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, DIVIDE, "-1");
            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, DIVIDE, "-9");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_HUNDREDTH, DIVIDE, "9");
            checkBinaryOperation(NINE_HUNDREDTH, NINE_HUNDREDTH, DIVIDE, "1");
            checkBinaryOperation(NINE_HUNDREDTH, ONE_TENTH, DIVIDE, "0.9");
            checkBinaryOperation(NINE_HUNDREDTH, NINE_TENTH, DIVIDE, "0.1");

            //first is 0.1
            checkBinaryOperation(ONE_TENTH, NEG_ONE_TENTH, DIVIDE, "-1");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e+1");

            checkBinaryOperation(ONE_TENTH, ONE_HUNDREDTH, DIVIDE, "1.e+1");
            checkBinaryOperation(ONE_TENTH, ONE_TENTH, DIVIDE, "1");

            //first is 0.9
            checkBinaryOperation(NINE_TENTH, NEG_NINE_TENTH, DIVIDE, "-1");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_TENTH, DIVIDE, "-9");
            checkBinaryOperation(NINE_TENTH, NEG_NINE_HUNDREDTH, DIVIDE, "-1.e+1");
            checkBinaryOperation(NINE_TENTH, NEG_ONE_HUNDREDTH, DIVIDE, "-9.e+1");

            checkBinaryOperation(NINE_TENTH, ONE_HUNDREDTH, DIVIDE, "9.e+1");
            checkBinaryOperation(NINE_TENTH, NINE_HUNDREDTH, DIVIDE, "1.e+1");
            checkBinaryOperation(NINE_TENTH, ONE_TENTH, DIVIDE, "9");
            checkBinaryOperation(NINE_TENTH, NINE_TENTH, DIVIDE, "1");

            //first is 0.99
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, DIVIDE, "-1");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, DIVIDE, "-1.1");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, DIVIDE, "-9.9");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, DIVIDE, "-11");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, DIVIDE, "-99");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, DIVIDE, "99");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, DIVIDE, "11");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_TENTH, DIVIDE, "9.9");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINE_TENTH, DIVIDE, "1.1");
            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, DIVIDE, "1");

            //first is 0.9999999999999999
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, DIVIDE, "-1");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, DIVIDE, "-1.01010101010101");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINE_TENTH, DIVIDE, "-1.111111111111111");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_TENTH, DIVIDE, "-9.999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, DIVIDE, "-11.11111111111111");
            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, DIVIDE, "-99.99999999999999");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_HUNDREDTH, DIVIDE, "99.99999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NINE_HUNDREDTH, DIVIDE, "11.11111111111111");
            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_TENTH, DIVIDE, "9.999999999999999");
            checkBinaryOperation(ZERO_DOT_16_NINES, NINE_TENTH, DIVIDE, "1.111111111111111");
            checkBinaryOperation(ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, DIVIDE, "1.01010101010101");
            checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, DIVIDE, "1");

            //first is 0.99999999999999999
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, DIVIDE, "-1");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINE_TENTH, DIVIDE, "-1.1111111111111111");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_TENTH, DIVIDE, "-9.9999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, DIVIDE, "-11.111111111111111");
            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, DIVIDE, "-99.999999999999999");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_HUNDREDTH, DIVIDE, "99.999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NINE_HUNDREDTH, DIVIDE, "11.111111111111111");
            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_TENTH, DIVIDE, "9.9999999999999999");
            checkBinaryOperation(ZERO_DOT_17_NINES, NINE_TENTH, DIVIDE, "1.1111111111111111");
            checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, DIVIDE, "1");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+9999
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "1.e+1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e+1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, DIVIDE, "-1");

            //first is -1.e+9998
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "0.1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, DIVIDE, "-1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, DIVIDE, "-0.1");

            //first is 1.e+9998
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-0.1");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-1");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, DIVIDE, "1");
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, DIVIDE, "0.1");

            //first is 1.e+9999
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-1");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e+1");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, DIVIDE, "1.e+1");
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, DIVIDE, "1");


            //first is -1.e+17
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1.e+1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, DIVIDE, "-1.e+1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, DIVIDE, "-1");

            //first is -1.e+16
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "0.1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, DIVIDE, "-1");
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, DIVIDE, "-0.1");

            //first is 1.e+16
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-0.1");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, DIVIDE, "1");
            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, DIVIDE, "0.1");

            //first is 1.e+17
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-1");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1.e+1");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, DIVIDE, "1.e+1");
            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, DIVIDE, "1");


            //first is -1.e-9999
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "0.1");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, DIVIDE, "-0.1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, DIVIDE, "-1");

            //first is -1.e-9998
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "1");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, DIVIDE, "-1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+1");

            //first is 1.e-9998
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+1");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-1");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, DIVIDE, "1");
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+1");

            //first is 1.e-9999
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-1");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-0.1");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, DIVIDE, "0.1");
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, DIVIDE, "1");


            //first is -1.e-17
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "0.1");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, DIVIDE, "-0.1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, DIVIDE, "-1");

            //first is -1.e-16
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1.e+1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "1");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, DIVIDE, "-1");
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+1");

            //first is 1.e-16
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+1");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-1");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, DIVIDE, "1");
            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, DIVIDE, "1.e+1");

            //first is 1.e-17
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-0.1");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, DIVIDE, "0.1");
            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, DIVIDE, "1");
        }

        //with integers
        {
            //first is -1.e+9999 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e+9983");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9983");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "9.999999999999999e-9984");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "9.999999999999998e-9984");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e+9983");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "5.e-9984");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_HUNDRED, DIVIDE, "1.e+9997");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9997");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_TEN, DIVIDE, "1.e+9998");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE, DIVIDE, "1.e+9999");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9999");


            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "0");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.ONE, DIVIDE, "-1.e+9999");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.TEN, DIVIDE, "-1.e+9998");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, HUNDRED, DIVIDE, "-1.e+9997");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9997");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e+9983");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-5.e-9984");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-9.999999999999998e-9984");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-9.999999999999999e-9984");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e+9983");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9983");

            //first is -1.e+9998 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e+9982");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9982");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "9.999999999999999e-9983");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "9.999999999999998e-9983");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e+9982");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "5.e-9983");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_HUNDRED, DIVIDE, "1.e+9996");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9996");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_TEN, DIVIDE, "1.e+9997");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9997");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE, DIVIDE, "1.e+9998");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9998");


            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "0");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.ONE, DIVIDE, "-1.e+9998");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.TEN, DIVIDE, "-1.e+9997");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9997");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, HUNDRED, DIVIDE, "-1.e+9996");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9996");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e+9982");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-5.e-9983");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-9.999999999999998e-9983");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-9.999999999999999e-9983");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e+9982");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9982");

            //first is 1.e+9998 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e+9982");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9982");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, DIVIDE, "-9.999999999999999e-9983");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9998, DIVIDE, "-9.999999999999998e-9983");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e+9982");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, DIVIDE, "-5.e-9983");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_HUNDRED, DIVIDE, "-1.e+9996");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9996");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_TEN, DIVIDE, "-1.e+9997");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9997");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE, DIVIDE, "-1.e+9998");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9998");


            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_9998, DIVIDE, "0");


            checkBinaryOperation(ONE_DOT_E_PLUS_9998, BigDecimal.ONE, DIVIDE, "1.e+9998");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9998");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, BigDecimal.TEN, DIVIDE, "1.e+9997");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9997");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, HUNDRED, DIVIDE, "1.e+9996");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9996");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e+9982");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, DIVIDE, "5.e-9983");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9998, DIVIDE, "9.999999999999998e-9983");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, DIVIDE, "9.999999999999999e-9983");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e+9982");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9982");

            //first is 1.e+9999 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e+9983");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9983");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, DIVIDE, "-9.999999999999999e-9984");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9999, DIVIDE, "-9.999999999999998e-9984");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e+9983");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, DIVIDE, "-5.e-9984");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_HUNDRED, DIVIDE, "-1.e+9997");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9997");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_TEN, DIVIDE, "-1.e+9998");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9998");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE, DIVIDE, "-1.e+9999");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_9999, DIVIDE, "-1.e-9999");


            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_9999, DIVIDE, "0");


            checkBinaryOperation(ONE_DOT_E_PLUS_9999, BigDecimal.ONE, DIVIDE, "1.e+9999");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9999");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, BigDecimal.TEN, DIVIDE, "1.e+9998");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9998");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, HUNDRED, DIVIDE, "1.e+9997");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9997");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e+9983");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, DIVIDE, "5.e-9984");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9999, DIVIDE, "9.999999999999998e-9984");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, DIVIDE, "9.999999999999999e-9984");

            checkBinaryOperation(ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e+9983");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9999, DIVIDE, "1.e-9983");


            //first is -1.e+17 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e+1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "0.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "0.09999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "0.09999999999999998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e+1");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "0.05");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, DIVIDE, "1.e+15");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "1.e-15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, DIVIDE, "1.e+16");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "1.e-16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, DIVIDE, "1.e+17");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "1.e-17");


            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "0");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, DIVIDE, "-1.e+17");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, DIVIDE, "-1.e+16");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, DIVIDE, "-1.e+15");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e+1");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-0.05");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-0.09999999999999998");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-0.09999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e+1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-0.1");

            //first is -1.e+16 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "0.9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "0.9999999999999998");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "0.5");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, DIVIDE, "1.e+14");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1.e-14");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, DIVIDE, "1.e+15");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1.e-15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, DIVIDE, "1.e+16");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1.e-16");


            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "0");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, DIVIDE, "-1.e+16");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-16");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, DIVIDE, "-1.e+15");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-15");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, DIVIDE, "-1.e+14");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-14");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-0.5");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-0.9999999999999998");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-0.9999999999999999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1");

            //first is 1.e+16 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_16, DIVIDE, "-1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, DIVIDE, "-0.9999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_16, DIVIDE, "-0.9999999999999998");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, DIVIDE, "-0.5");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, DIVIDE, "-1.e+14");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-14");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, DIVIDE, "-1.e+15");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-15");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, DIVIDE, "-1.e+16");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-16");


            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_16, DIVIDE, "0");


            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, DIVIDE, "1.e+16");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_16, DIVIDE, "1.e-16");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, DIVIDE, "1.e+15");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_16, DIVIDE, "1.e-15");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, DIVIDE, "1.e+14");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_16, DIVIDE, "1.e-14");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, DIVIDE, "0.5");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_16, DIVIDE, "0.9999999999999998");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, DIVIDE, "0.9999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_16, DIVIDE, "1");

            //first is 1.e+17 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e+1");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_17, DIVIDE, "-0.1");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, DIVIDE, "-0.09999999999999999");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_17, DIVIDE, "-0.09999999999999998");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e+1");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, DIVIDE, "-0.05");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, DIVIDE, "-1.e+15");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-15");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, DIVIDE, "-1.e+16");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-16");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, DIVIDE, "-1.e+17");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-17");


            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_17, DIVIDE, "0");


            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, DIVIDE, "1.e+17");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_17, DIVIDE, "1.e-17");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, DIVIDE, "1.e+16");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_17, DIVIDE, "1.e-16");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, DIVIDE, "1.e+15");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_17, DIVIDE, "1.e-15");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e+1");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, DIVIDE, "0.05");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_17, DIVIDE, "0.09999999999999998");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, DIVIDE, "0.09999999999999999");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e+1");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_17, DIVIDE, "0.1");


            //first is -1.e-9999 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE, DIVIDE, "1.e-9999");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+9999");

            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "0");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ONE, DIVIDE, "-1.e-9999");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+9999");

            //first is -1.e-9998 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_TEN, DIVIDE, "1.e-9999");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9999");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE, DIVIDE, "1.e-9998");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9998");


            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "0");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ONE, DIVIDE, "-1.e-9998");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9998");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.TEN, DIVIDE, "-1.e-9999");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9999");

            //first is 1.e-9998 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_TEN, DIVIDE, "-1.e-9999");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9999");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE, DIVIDE, "-1.e-9998");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9998");


            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_9998, DIVIDE, "0");


            checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ONE, DIVIDE, "1.e-9998");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9998");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.TEN, DIVIDE, "1.e-9999");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9999");

            //first is 1.e-9999 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE, DIVIDE, "-1.e-9999");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+9999");

            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_9999, DIVIDE, "0");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ONE, DIVIDE, "1.e-9999");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+9999");


            //first is -1.e-17 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e-33");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1.e+33");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "9.999999999999999e+32");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "9.999999999999998e+32");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e-33");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "5.e+32");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, DIVIDE, "1.e-19");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1.e+19");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, DIVIDE, "1.e-18");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1.e+18");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, DIVIDE, "1.e-17");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1.e+17");


            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "0");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, DIVIDE, "-1.e-17");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, DIVIDE, "-1.e-18");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+18");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, DIVIDE, "-1.e-19");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+19");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e-33");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-5.e+32");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-9.999999999999998e+32");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-9.999999999999999e+32");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e-33");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+33");

            //first is -1.e-16 (and vice versa)
            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "1.e-32");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "1.e+32");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "9.999999999999999e+31");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "9.999999999999998e+31");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "2.e-32");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "5.e+31");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, DIVIDE, "1.e-18");
            checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "1.e+18");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, DIVIDE, "1.e-17");
            checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "1.e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, DIVIDE, "1.e-16");
            checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "1.e+16");


            checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "0");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, DIVIDE, "-1.e-16");
            checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, DIVIDE, "-1.e-17");
            checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+17");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, DIVIDE, "-1.e-18");
            checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+18");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "-2.e-32");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-5.e+31");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-9.999999999999998e+31");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-9.999999999999999e+31");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "-1.e-32");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+32");

            //first is 1.e-16 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e-32");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+32");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, DIVIDE, "-9.999999999999999e+31");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_16, DIVIDE, "-9.999999999999998e+31");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e-32");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, DIVIDE, "-5.e+31");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, DIVIDE, "-1.e-18");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+18");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, DIVIDE, "-1.e-17");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+17");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, DIVIDE, "-1.e-16");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+16");


            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_16, DIVIDE, "0");


            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, DIVIDE, "1.e-16");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_16, DIVIDE, "1.e+16");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, DIVIDE, "1.e-17");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_16, DIVIDE, "1.e+17");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, DIVIDE, "1.e-18");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_16, DIVIDE, "1.e+18");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e-32");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, DIVIDE, "5.e+31");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_16, DIVIDE, "9.999999999999998e+31");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, DIVIDE, "9.999999999999999e+31");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e-32");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_16, DIVIDE, "1.e+32");

            //first is 1.e-17 (and vice versa)
            checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, DIVIDE, "-1.e-33");
            checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+33");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, DIVIDE, "-9.999999999999999e+32");

            checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_17, DIVIDE, "-9.999999999999998e+32");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, DIVIDE, "-2.e-33");
            checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, DIVIDE, "-5.e+32");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, DIVIDE, "-1.e-19");
            checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+19");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, DIVIDE, "-1.e-18");
            checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+18");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, DIVIDE, "-1.e-17");
            checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+17");


            checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_17, DIVIDE, "0");


            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, DIVIDE, "1.e-17");
            checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_17, DIVIDE, "1.e+17");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, DIVIDE, "1.e-18");
            checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_17, DIVIDE, "1.e+18");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, DIVIDE, "1.e-19");
            checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_17, DIVIDE, "1.e+19");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, DIVIDE, "2.e-33");
            checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, DIVIDE, "5.e+32");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_17, DIVIDE, "9.999999999999998e+32");

            checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, DIVIDE, "9.999999999999999e+32");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, DIVIDE, "1.e-33");
            checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_17, DIVIDE, "1.e+33");
        }

        //with decimals
        {
            //first is -1.e+9998 (and vice versa)
            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "9.e-9999");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, DIVIDE, "1.e+9999");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9999");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_TENTH, DIVIDE, "-1.e+9999");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9999");

            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_PLUS_9998, DIVIDE, "-9.e-9999");

            //first is 1.e+9998 (and vice versa)
            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_PLUS_9998, DIVIDE, "-9.e-9999");

            checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, DIVIDE, "-1.e+9999");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_PLUS_9998, DIVIDE, "-1.e-9999");


            checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_TENTH, DIVIDE, "1.e+9999");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_PLUS_9998, DIVIDE, "1.e-9999");

            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_PLUS_9998, DIVIDE, "9.e-9999");


            //first is -1.e-9999 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "9.9999999999999999e+9998");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "9.999999999999999e+9998");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "9.9e+9998");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "9.e+9998");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_TENTH, DIVIDE, "1.e-9998");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+9998");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "9.e+9997");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_HUNDREDTH, DIVIDE, "1.e-9997");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+9997");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_HUNDREDTH, DIVIDE, "-1.e-9997");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+9997");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-9.e+9997");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_TENTH, DIVIDE, "-1.e-9998");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+9998");

            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-9.e+9998");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-9.9e+9998");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-9.999999999999999e+9998");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_9999, DIVIDE, "-9.9999999999999999e+9998");

            //first is -1.e-9998 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "9.9999999999999999e+9997");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "9.999999999999999e+9997");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "9.9e+9997");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "9.e+9997");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_TENTH, DIVIDE, "1.e-9997");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9997");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "9.e+9996");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_HUNDREDTH, DIVIDE, "1.e-9996");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9996");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_HUNDREDTH, DIVIDE, "-1.e-9996");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9996");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-9.e+9996");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_TENTH, DIVIDE, "-1.e-9997");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9997");

            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-9.e+9997");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-9.9e+9997");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-9.999999999999999e+9997");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_9998, DIVIDE, "-9.9999999999999999e+9997");

            //first is 1.e-9998 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_9998, DIVIDE, "-9.9999999999999999e+9997");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_9998, DIVIDE, "-9.999999999999999e+9997");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_9998, DIVIDE, "-9.9e+9997");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_MINUS_9998, DIVIDE, "-9.e+9997");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_TENTH, DIVIDE, "-1.e-9997");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9997");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_MINUS_9998, DIVIDE, "-9.e+9996");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e-9996");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_MINUS_9998, DIVIDE, "-1.e+9996");


            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_HUNDREDTH, DIVIDE, "1.e-9996");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9996");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_MINUS_9998, DIVIDE, "9.e+9996");

            checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_TENTH, DIVIDE, "1.e-9997");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_MINUS_9998, DIVIDE, "1.e+9997");

            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_MINUS_9998, DIVIDE, "9.e+9997");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_9998, DIVIDE, "9.9e+9997");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_9998, DIVIDE, "9.999999999999999e+9997");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_9998, DIVIDE, "9.9999999999999999e+9997");

            //first is 1.e-9999 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_9999, DIVIDE, "-9.9999999999999999e+9998");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_9999, DIVIDE, "-9.999999999999999e+9998");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_9999, DIVIDE, "-9.9e+9998");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_MINUS_9999, DIVIDE, "-9.e+9998");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_TENTH, DIVIDE, "-1.e-9998");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+9998");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_MINUS_9999, DIVIDE, "-9.e+9997");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e-9997");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_MINUS_9999, DIVIDE, "-1.e+9997");


            checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_HUNDREDTH, DIVIDE, "1.e-9997");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+9997");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_MINUS_9999, DIVIDE, "9.e+9997");

            checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_TENTH, DIVIDE, "1.e-9998");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_MINUS_9999, DIVIDE, "1.e+9998");

            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_MINUS_9999, DIVIDE, "9.e+9998");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_9999, DIVIDE, "9.9e+9998");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_9999, DIVIDE, "9.999999999999999e+9998");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_9999, DIVIDE, "9.9999999999999999e+9998");


            //first is -1.e+17 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "9.9999999999999999e-18");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "9.999999999999999e-18");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "9.9e-18");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "9.e-18");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, DIVIDE, "1.e+18");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "1.e-18");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "9.e-19");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, DIVIDE, "1.e+19");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "1.e-19");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, DIVIDE, "-1.e+19");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-19");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-9.e-19");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_TENTH, DIVIDE, "-1.e+18");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-18");

            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-9.e-18");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-9.9e-18");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-9.999999999999999e-18");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_17, DIVIDE, "-9.9999999999999999e-18");

            //first is -1.e+16 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "9.9999999999999999e-17");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "9.999999999999999e-17");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "9.9e-17");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "9.e-17");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, DIVIDE, "1.e+17");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1.e-17");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "9.e-18");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, DIVIDE, "1.e+18");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "1.e-18");


            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, DIVIDE, "-1.e+18");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-18");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-9.e-18");

            checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_TENTH, DIVIDE, "-1.e+17");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-17");

            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-9.e-17");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-9.9e-17");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-9.999999999999999e-17");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_PLUS_16, DIVIDE, "-9.9999999999999999e-17");

            //first is 1.e+16 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_16, DIVIDE, "-9.9999999999999999e-17");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_16, DIVIDE, "-9.999999999999999e-17");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, DIVIDE, "-9.9e-17");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_PLUS_16, DIVIDE, "-9.e-17");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, DIVIDE, "-1.e+17");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-17");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, DIVIDE, "-9.e-18");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e+18");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_PLUS_16, DIVIDE, "-1.e-18");


            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, DIVIDE, "1.e+18");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_PLUS_16, DIVIDE, "1.e-18");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, DIVIDE, "9.e-18");

            checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_TENTH, DIVIDE, "1.e+17");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_PLUS_16, DIVIDE, "1.e-17");

            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_PLUS_16, DIVIDE, "9.e-17");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_16, DIVIDE, "9.9e-17");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_16, DIVIDE, "9.999999999999999e-17");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_16, DIVIDE, "9.9999999999999999e-17");

            //first is 1.e+17 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_17, DIVIDE, "-9.9999999999999999e-18");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_17, DIVIDE, "-9.999999999999999e-18");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, DIVIDE, "-9.9e-18");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_PLUS_17, DIVIDE, "-9.e-18");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, DIVIDE, "-1.e+18");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-18");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, DIVIDE, "-9.e-19");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e+19");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_PLUS_17, DIVIDE, "-1.e-19");


            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, DIVIDE, "1.e+19");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_PLUS_17, DIVIDE, "1.e-19");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, DIVIDE, "9.e-19");

            checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_TENTH, DIVIDE, "1.e+18");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_PLUS_17, DIVIDE, "1.e-18");

            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_PLUS_17, DIVIDE, "9.e-18");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_PLUS_17, DIVIDE, "9.9e-18");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_PLUS_17, DIVIDE, "9.999999999999999e-18");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_PLUS_17, DIVIDE, "9.9999999999999999e-18");


            //first is -1.e-17 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "99999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "9.999999999999999e+16");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "9.9e+16");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "9.e+16");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, DIVIDE, "1.e-16");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1.e+16");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "9.e+15");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, DIVIDE, "1.e-15");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "1.e+15");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, DIVIDE, "-1.e-15");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+15");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-9.e+15");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_TENTH, DIVIDE, "-1.e-16");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+16");

            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-9.e+16");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-9.9e+16");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-9.999999999999999e+16");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_17, DIVIDE, "-99999999999999999");

            //first is -1.e-16 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "9999999999999999.9");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "9.999999999999999e+15");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "9.9e+15");

            checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "9.e+15");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, DIVIDE, "1.e-15");
            checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "1.e+15");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "9.e+14");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, DIVIDE, "1.e-14");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "1.e+14");


            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, DIVIDE, "-1.e-14");
            checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+14");

            checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-9.e+14");

            checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_TENTH, DIVIDE, "-1.e-15");
            checkBinaryOperation(ONE_TENTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+15");

            checkBinaryOperation(NINE_TENTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-9.e+15");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-9.9e+15");

            checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-9.999999999999999e+15");

            checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_DOT_E_MINUS_16, DIVIDE, "-9999999999999999.9");

            //first is 1.e-16 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_16, DIVIDE, "-9999999999999999.9");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_16, DIVIDE, "-9.999999999999999e+15");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, DIVIDE, "-9.9e+15");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_MINUS_16, DIVIDE, "-9.e+15");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, DIVIDE, "-1.e-15");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+15");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, DIVIDE, "-9.e+14");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e-14");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_MINUS_16, DIVIDE, "-1.e+14");


            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, DIVIDE, "1.e-14");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_MINUS_16, DIVIDE, "1.e+14");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, DIVIDE, "9.e+14");

            checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_TENTH, DIVIDE, "1.e-15");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_MINUS_16, DIVIDE, "1.e+15");

            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_MINUS_16, DIVIDE, "9.e+15");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_16, DIVIDE, "9.9e+15");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_16, DIVIDE, "9.999999999999999e+15");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_16, DIVIDE, "9999999999999999.9");

            //first is 1.e-17 (and vice versa)
            checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_17, DIVIDE, "-99999999999999999");

            checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_17, DIVIDE, "-9.999999999999999e+16");

            checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, DIVIDE, "-9.9e+16");

            checkBinaryOperation(NEG_NINE_TENTH, ONE_DOT_E_MINUS_17, DIVIDE, "-9.e+16");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, DIVIDE, "-1.e-16");
            checkBinaryOperation(NEG_ONE_TENTH, ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+16");

            checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, DIVIDE, "-9.e+15");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, DIVIDE, "-1.e-15");
            checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_DOT_E_MINUS_17, DIVIDE, "-1.e+15");


            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, DIVIDE, "1.e-15");
            checkBinaryOperation(ONE_HUNDREDTH, ONE_DOT_E_MINUS_17, DIVIDE, "1.e+15");

            checkBinaryOperation(NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, DIVIDE, "9.e+15");

            checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_TENTH, DIVIDE, "1.e-16");
            checkBinaryOperation(ONE_TENTH, ONE_DOT_E_MINUS_17, DIVIDE, "1.e+16");

            checkBinaryOperation(NINE_TENTH, ONE_DOT_E_MINUS_17, DIVIDE, "9.e+16");

            checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_DOT_E_MINUS_17, DIVIDE, "9.9e+16");

            checkBinaryOperation(ZERO_DOT_16_NINES, ONE_DOT_E_MINUS_17, DIVIDE, "9.999999999999999e+16");

            checkBinaryOperation(ZERO_DOT_17_NINES, ONE_DOT_E_MINUS_17, DIVIDE, "99999999999999999");
        }

        //several random values
        {
            checkBinaryOperation(new BigDecimal("24"), new BigDecimal("12"), DIVIDE, "2");
            checkBinaryOperation(new BigDecimal("415"), new BigDecimal("5"), DIVIDE, "83");

            checkBinaryOperation(new BigDecimal("123"), new BigDecimal("-3"), DIVIDE, "-41");
            checkBinaryOperation(new BigDecimal("140"), new BigDecimal("-7"), DIVIDE, "-2.e+1");

            checkBinaryOperation(new BigDecimal("-41"), new BigDecimal("-41"), DIVIDE, "1");
            checkBinaryOperation(new BigDecimal("-651"), new BigDecimal("-6"), DIVIDE, "108.5");

            checkBinaryOperation(new BigDecimal("504"), new BigDecimal("2.52"), DIVIDE, "2.e+2");
            checkBinaryOperation(new BigDecimal("1001"), new BigDecimal("10.01"), DIVIDE, "1.e+2");

            checkBinaryOperation(new BigDecimal("101"), new BigDecimal("-1.01"), DIVIDE, "-1.e+2");
            checkBinaryOperation(new BigDecimal("88"), new BigDecimal("-2.2"), DIVIDE, "-4.e+1");

            checkBinaryOperation(new BigDecimal("-5342"), new BigDecimal("53.42"), DIVIDE, "-1.e+2");
            checkBinaryOperation(new BigDecimal("-100"), new BigDecimal("0.05"), DIVIDE, "-2.e+3");

            checkBinaryOperation(new BigDecimal("-65"), new BigDecimal("-6.5"), DIVIDE, "1.e+1");
            checkBinaryOperation(new BigDecimal("-123"), new BigDecimal("-1.23"), DIVIDE, "1.e+2");

            checkBinaryOperation(new BigDecimal("555.555"), new BigDecimal("555.555"), DIVIDE, "1");
            checkBinaryOperation(new BigDecimal("132.5"), new BigDecimal("66.25"), DIVIDE, "2");

            checkBinaryOperation(new BigDecimal("65.65"), new BigDecimal("-32.825"), DIVIDE, "-2");
            checkBinaryOperation(new BigDecimal("15.12"), new BigDecimal("-0.3"), DIVIDE, "-50.4");

            checkBinaryOperation(new BigDecimal("-0.76"), new BigDecimal("-0.001"), DIVIDE, "7.6e+2");
            checkBinaryOperation(new BigDecimal("-1061.5"), new BigDecimal("-1.1"), DIVIDE, "965");
        }
    }

    /**
     * Tests for percentage of first operation.
     */
    @Test
    void percentageOfFirstTests() {
        //integers only
        {
            //first is -100000000000000000
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, "1.e+30");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, "9.999999999999999e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, "9.999999999999998e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, "5.e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, "1.e+16");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, "1.e+15");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, "1.e+14");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, "-1.e+14");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, "-1.e+15");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, "-1.e+16");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, "-5.e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-9.999999999999998e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, "-9.999999999999999e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e+30");

            //first is -9999999999999999
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, "999999999999999800000000000000.01");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, "999999999999999700000000000000.02");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, "4.9999999999999995e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, "9999999999999999");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, "999999999999999.9");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, "99999999999999.99");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ONE, "-99999999999999.99");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, BigDecimal.TEN, "-999999999999999.9");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, HUNDRED, "-9999999999999999");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, "-4.9999999999999995e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-999999999999999700000000000000.02");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, "-999999999999999800000000000000.01");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-9.999999999999999e+29");

            //first is -9999999999999998
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, "999999999999999600000000000000.04");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, "4.999999999999999e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, "9999999999999998");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, "999999999999999.8");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, "99999999999999.98");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, "-99999999999999.98");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, "-999999999999999.8");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, "-9999999999999998");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, "-4.999999999999999e+29");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-999999999999999600000000000000.04");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, "-999999999999999700000000000000.02");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-9.999999999999998e+29");

            //first is -50000000000000000
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, "2.5e+29");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, "5.e+15");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, "5.e+14");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, "5.e+13");

            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, "-5.e+13");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, "-5.e+14");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, "-5.e+15");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, "-2.5e+29");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-4.999999999999999e+29");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, "-4.9999999999999995e+29");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-5.e+29");

            //first is -100
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_HUNDRED, "1.e+2");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_TEN, "1.e+1");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_ONE, "1");

            checkPercentageOfFirstOperation(NEG_HUNDRED, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_HUNDRED, BigDecimal.ONE, "-1");
            checkPercentageOfFirstOperation(NEG_HUNDRED, BigDecimal.TEN, "-1.e+1");
            checkPercentageOfFirstOperation(NEG_HUNDRED, HUNDRED, "-1.e+2");
            checkPercentageOfFirstOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, "-5.e+15");
            checkPercentageOfFirstOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-9999999999999998");
            checkPercentageOfFirstOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN, "-9999999999999999");
            checkPercentageOfFirstOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e+16");

            //first is -10
            checkPercentageOfFirstOperation(NEG_TEN, NEG_TEN, "1");
            checkPercentageOfFirstOperation(NEG_TEN, NEG_ONE, "0.1");

            checkPercentageOfFirstOperation(NEG_TEN, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_TEN, BigDecimal.ONE, "-0.1");
            checkPercentageOfFirstOperation(NEG_TEN, BigDecimal.TEN, "-1");
            checkPercentageOfFirstOperation(NEG_TEN, HUNDRED, "-1.e+1");
            checkPercentageOfFirstOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, "-5.e+14");
            checkPercentageOfFirstOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-999999999999999.8");
            checkPercentageOfFirstOperation(NEG_TEN, MAX_VALUE_ON_SCREEN, "-999999999999999.9");
            checkPercentageOfFirstOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e+15");

            //first is -1
            checkPercentageOfFirstOperation(NEG_ONE, NEG_ONE, "0.01");

            checkPercentageOfFirstOperation(NEG_ONE, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE, BigDecimal.ONE, "-0.01");
            checkPercentageOfFirstOperation(NEG_ONE, BigDecimal.TEN, "-0.1");
            checkPercentageOfFirstOperation(NEG_ONE, HUNDRED, "-1");
            checkPercentageOfFirstOperation(NEG_ONE, HALF_MAX_VALUE_ON_SCREEN, "-5.e+13");
            checkPercentageOfFirstOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-99999999999999.98");
            checkPercentageOfFirstOperation(NEG_ONE, MAX_VALUE_ON_SCREEN, "-99999999999999.99");
            checkPercentageOfFirstOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e+14");

            //first is 0
            checkPercentageOfFirstOperation(BigDecimal.ZERO, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(BigDecimal.ZERO, BigDecimal.ONE, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, BigDecimal.TEN, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, HUNDRED, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, HALF_MAX_VALUE_ON_SCREEN, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_MINUS_ONE, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_PLUS_ONE, "0");

            //first is 1
            checkPercentageOfFirstOperation(BigDecimal.ONE, BigDecimal.ONE, "0.01");
            checkPercentageOfFirstOperation(BigDecimal.ONE, BigDecimal.TEN, "0.1");
            checkPercentageOfFirstOperation(BigDecimal.ONE, HUNDRED, "1");
            checkPercentageOfFirstOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, "5.e+13");
            checkPercentageOfFirstOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, "99999999999999.98");
            checkPercentageOfFirstOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN, "99999999999999.99");
            checkPercentageOfFirstOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e+14");

            //first is 10
            checkPercentageOfFirstOperation(BigDecimal.TEN, BigDecimal.TEN, "1");
            checkPercentageOfFirstOperation(BigDecimal.TEN, HUNDRED, "1.e+1");
            checkPercentageOfFirstOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, "5.e+14");
            checkPercentageOfFirstOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, "999999999999999.8");
            checkPercentageOfFirstOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN, "999999999999999.9");
            checkPercentageOfFirstOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e+15");

            //first is 100
            checkPercentageOfFirstOperation(HUNDRED, HUNDRED, "1.e+2");
            checkPercentageOfFirstOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, "5.e+15");
            checkPercentageOfFirstOperation(HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, "9999999999999998");
            checkPercentageOfFirstOperation(HUNDRED, MAX_VALUE_ON_SCREEN, "9999999999999999");
            checkPercentageOfFirstOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e+16");

            //first is 5000000000000000
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, "2.5e+29");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, "4.999999999999999e+29");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, "4.9999999999999995e+29");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, "5.e+29");

            //first is 9999999999999998
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, "999999999999999600000000000000.04");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, "999999999999999700000000000000.02");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, "9.999999999999998e+29");

            //first is 9999999999999999
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, "999999999999999800000000000000.01");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, "9.999999999999999e+29");

            //first is 10000000000000000
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e+30");
        }

        //integer and decimal
        {
            //first is -10000000000000000
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, "99999999999999.999");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, "99999999999999.99");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, "9.9e+13");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, "9.e+13");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, "1.e+13");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, "9.e+12");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, "1e+12");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, "-1.e+12");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, "-9.e+12");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, "-1.e+13");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, "-9.e+13");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, "-9.9e+13");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, "-99999999999999.99");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, "-99999999999999.999");

            //first is -9999999999999999
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, "99999999999999.9890000000000000001");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, "99999999999999.980000000000000001");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, "98999999999999.9901");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, "89999999999999.991");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, "9999999999999.999");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, "8999999999999.9991");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, "999999999999.9999");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, "-999999999999.9999");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, "-8999999999999.9991");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, ONE_TENTH, "-9999999999999.999");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NINE_TENTH, "-89999999999999.991");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, "-98999999999999.9901");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, "-99999999999999.980000000000000001");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, "-99999999999999.9890000000000000001");

            //first is -9999999999999998
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, "99999999999999.9790000000000000002");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, "99999999999999.970000000000000002");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, "98999999999999.9802");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, "89999999999999.982");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, "9999999999999.998");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, "8999999999999.9982");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, "999999999999.9998");

            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, "-999999999999.9998");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, "-8999999999999.9982");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, "-9999999999999.998");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, "-89999999999999.982");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, "-98999999999999.9802");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, "-99999999999999.970000000000000002");
            checkPercentageOfFirstOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, "-99999999999999.9790000000000000002");

            //first is -5000000000000000
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, "49999999999999.9995");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, "49999999999999.995");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, "4.95e+13");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, "4.5e+13");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, "5.e+12");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, "4.5e+12");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, "5.e+11");

            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, "-5.e+11");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, "-4.5e+12");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_TENTH, "-5.e+12");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_TENTH, "-4.5e+13");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, "-4.95e+13");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, "-49999999999999.995");
            checkPercentageOfFirstOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, "-49999999999999.9995");

            //first is -100
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_ZERO_DOT_17_NINES, "0.99999999999999999");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_ZERO_DOT_16_NINES, "0.9999999999999999");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_NINETY_NINE_HUNDREDTH, "0.99");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_NINE_TENTH, "0.9");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_ONE_TENTH, "0.1");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_NINE_HUNDREDTH, "0.09");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NEG_ONE_HUNDREDTH, "0.01");

            checkPercentageOfFirstOperation(NEG_HUNDRED, ONE_HUNDREDTH, "-0.01");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NINE_HUNDREDTH, "-0.09");
            checkPercentageOfFirstOperation(NEG_HUNDRED, ONE_TENTH, "-0.1");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NINE_TENTH, "-0.9");
            checkPercentageOfFirstOperation(NEG_HUNDRED, NINETY_NINE_HUNDREDTH, "-0.99");
            checkPercentageOfFirstOperation(NEG_HUNDRED, ZERO_DOT_16_NINES, "-0.9999999999999999");
            checkPercentageOfFirstOperation(NEG_HUNDRED, ZERO_DOT_17_NINES, "-0.99999999999999999");

            //first is -10
            checkPercentageOfFirstOperation(NEG_TEN, NEG_ZERO_DOT_17_NINES, "0.099999999999999999");
            checkPercentageOfFirstOperation(NEG_TEN, NEG_ZERO_DOT_16_NINES, "0.09999999999999999");
            checkPercentageOfFirstOperation(NEG_TEN, NEG_NINETY_NINE_HUNDREDTH, "0.099");
            checkPercentageOfFirstOperation(NEG_TEN, NEG_NINE_TENTH, "0.09");
            checkPercentageOfFirstOperation(NEG_TEN, NEG_ONE_TENTH, "0.01");
            checkPercentageOfFirstOperation(NEG_TEN, NEG_NINE_HUNDREDTH, "0.009");
            checkPercentageOfFirstOperation(NEG_TEN, NEG_ONE_HUNDREDTH, "0.001");

            checkPercentageOfFirstOperation(NEG_TEN, ONE_HUNDREDTH, "-0.001");
            checkPercentageOfFirstOperation(NEG_TEN, NINE_HUNDREDTH, "-0.009");
            checkPercentageOfFirstOperation(NEG_TEN, ONE_TENTH, "-0.01");
            checkPercentageOfFirstOperation(NEG_TEN, NINE_TENTH, "-0.09");
            checkPercentageOfFirstOperation(NEG_TEN, NINETY_NINE_HUNDREDTH, "-0.099");
            checkPercentageOfFirstOperation(NEG_TEN, ZERO_DOT_16_NINES, "-0.09999999999999999");
            checkPercentageOfFirstOperation(NEG_TEN, ZERO_DOT_17_NINES, "-0.099999999999999999");

            //first is -1
            checkPercentageOfFirstOperation(NEG_ONE, NEG_ZERO_DOT_17_NINES, "0.0099999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE, NEG_ZERO_DOT_16_NINES, "0.009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE, NEG_NINETY_NINE_HUNDREDTH, "0.0099");
            checkPercentageOfFirstOperation(NEG_ONE, NEG_NINE_TENTH, "0.009");
            checkPercentageOfFirstOperation(NEG_ONE, NEG_ONE_TENTH, "0.001");
            checkPercentageOfFirstOperation(NEG_ONE, NEG_NINE_HUNDREDTH, "0.0009");
            checkPercentageOfFirstOperation(NEG_ONE, NEG_ONE_HUNDREDTH, "0.0001");

            checkPercentageOfFirstOperation(NEG_ONE, ONE_HUNDREDTH, "-0.0001");
            checkPercentageOfFirstOperation(NEG_ONE, NINE_HUNDREDTH, "-0.0009");
            checkPercentageOfFirstOperation(NEG_ONE, ONE_TENTH, "-0.001");
            checkPercentageOfFirstOperation(NEG_ONE, NINE_TENTH, "-0.009");
            checkPercentageOfFirstOperation(NEG_ONE, NINETY_NINE_HUNDREDTH, "-0.0099");
            checkPercentageOfFirstOperation(NEG_ONE, ZERO_DOT_16_NINES, "-0.009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE, ZERO_DOT_17_NINES, "-0.0099999999999999999");

            //first is 0
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NEG_ZERO_DOT_17_NINES, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NEG_NINE_TENTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NEG_ONE_TENTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NEG_NINE_HUNDREDTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NEG_ONE_HUNDREDTH, "0");

            checkPercentageOfFirstOperation(BigDecimal.ZERO, ONE_HUNDREDTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NINE_HUNDREDTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, ONE_TENTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NINE_TENTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, ZERO_DOT_16_NINES, "0");
            checkPercentageOfFirstOperation(BigDecimal.ZERO, ZERO_DOT_17_NINES, "0");

            //first is 1
            checkPercentageOfFirstOperation(BigDecimal.ONE, NEG_ZERO_DOT_17_NINES, "-0.0099999999999999999");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NEG_ZERO_DOT_16_NINES, "-0.009999999999999999");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NEG_NINETY_NINE_HUNDREDTH, "-0.0099");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NEG_NINE_TENTH, "-0.009");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NEG_ONE_TENTH, "-0.001");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NEG_NINE_HUNDREDTH, "-0.0009");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NEG_ONE_HUNDREDTH, "-0.0001");

            checkPercentageOfFirstOperation(BigDecimal.ONE, ONE_HUNDREDTH, "0.0001");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NINE_HUNDREDTH, "0.0009");
            checkPercentageOfFirstOperation(BigDecimal.ONE, ONE_TENTH, "0.001");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NINE_TENTH, "0.009");
            checkPercentageOfFirstOperation(BigDecimal.ONE, NINETY_NINE_HUNDREDTH, "0.0099");
            checkPercentageOfFirstOperation(BigDecimal.ONE, ZERO_DOT_16_NINES, "0.009999999999999999");
            checkPercentageOfFirstOperation(BigDecimal.ONE, ZERO_DOT_17_NINES, "0.0099999999999999999");

            //first is 10
            checkPercentageOfFirstOperation(BigDecimal.TEN, NEG_ZERO_DOT_17_NINES, "-0.099999999999999999");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, "-0.09999999999999999");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, "-0.099");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NEG_NINE_TENTH, "-0.09");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NEG_ONE_TENTH, "-0.01");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NEG_NINE_HUNDREDTH, "-0.009");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NEG_ONE_HUNDREDTH, "-0.001");

            checkPercentageOfFirstOperation(BigDecimal.TEN, ONE_HUNDREDTH, "0.001");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NINE_HUNDREDTH, "0.009");
            checkPercentageOfFirstOperation(BigDecimal.TEN, ONE_TENTH, "0.01");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NINE_TENTH, "0.09");
            checkPercentageOfFirstOperation(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, "0.099");
            checkPercentageOfFirstOperation(BigDecimal.TEN, ZERO_DOT_16_NINES, "0.09999999999999999");
            checkPercentageOfFirstOperation(BigDecimal.TEN, ZERO_DOT_17_NINES, "0.099999999999999999");

            //first is 100
            checkPercentageOfFirstOperation(HUNDRED, NEG_ZERO_DOT_17_NINES, "-0.99999999999999999");
            checkPercentageOfFirstOperation(HUNDRED, NEG_ZERO_DOT_16_NINES, "-0.9999999999999999");
            checkPercentageOfFirstOperation(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, "-0.99");
            checkPercentageOfFirstOperation(HUNDRED, NEG_NINE_TENTH, "-0.9");
            checkPercentageOfFirstOperation(HUNDRED, NEG_ONE_TENTH, "-0.1");
            checkPercentageOfFirstOperation(HUNDRED, NEG_NINE_HUNDREDTH, "-0.09");
            checkPercentageOfFirstOperation(HUNDRED, NEG_ONE_HUNDREDTH, "-0.01");

            checkPercentageOfFirstOperation(HUNDRED, ONE_HUNDREDTH, "0.01");
            checkPercentageOfFirstOperation(HUNDRED, NINE_HUNDREDTH, "0.09");
            checkPercentageOfFirstOperation(HUNDRED, ONE_TENTH, "0.1");
            checkPercentageOfFirstOperation(HUNDRED, NINE_TENTH, "0.9");
            checkPercentageOfFirstOperation(HUNDRED, NINETY_NINE_HUNDREDTH, "0.99");
            checkPercentageOfFirstOperation(HUNDRED, ZERO_DOT_16_NINES, "0.9999999999999999");
            checkPercentageOfFirstOperation(HUNDRED, ZERO_DOT_17_NINES, "0.99999999999999999");

            //first is 5000000000000000
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, "-49999999999999.9995");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, "-49999999999999.995");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, "-4.95e+13");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, "-4.5e+13");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, "-5.e+12");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, "-4.5e+12");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, "-5.e+11");

            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, "5.e+11");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, "4.5e+12");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_TENTH, "5.e+12");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_TENTH, "4.5e+13");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, "4.95e+13");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, "49999999999999.995");
            checkPercentageOfFirstOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, "49999999999999.9995");

            //first is 9999999999999998
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, "-99999999999999.9790000000000000002");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, "-99999999999999.970000000000000002");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, "-98999999999999.9802");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, "-89999999999999.982");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, "-9999999999999.998");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, "-8999999999999.9982");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, "-999999999999.9998");

            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, "999999999999.9998");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, "8999999999999.9982");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, "9999999999999.998");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, "89999999999999.982");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, "98999999999999.9802");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, "99999999999999.970000000000000002");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, "99999999999999.9790000000000000002");

            //first is 9999999999999999
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, "-99999999999999.9890000000000000001");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, "-99999999999999.980000000000000001");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, "-98999999999999.9901");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, "-89999999999999.991");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, "-9999999999999.999");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, "-8999999999999.9991");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, "-999999999999.9999");

            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, "999999999999.9999");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, "8999999999999.9991");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, ONE_TENTH, "9999999999999.999");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NINE_TENTH, "89999999999999.991");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, "98999999999999.9901");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, "99999999999999.980000000000000001");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, "99999999999999.9890000000000000001");

            //first is 10000000000000000
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, "-99999999999999.999");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, "-99999999999999.99");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, "-9.9e+13");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, "-9.e+13");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, "-1.e+13");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, "-9.e+12");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, "-1e+12");

            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, "1.e+12");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, "9.e+12");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, "1.e+13");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, "9.e+13");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, "9.9e+13");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, "99999999999999.99");
            checkPercentageOfFirstOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, "99999999999999.999");
        }

        //decimals only
        {
            //first is -0.99999999999999999
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, "0.009999999999999999800000000000000001");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, "0.00999999999999999890000000000000001");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, "0.009899999999999999901");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_TENTH, "0.00899999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_TENTH, "0.00099999999999999999");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, "0.000899999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, "0.000099999999999999999");

            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, ONE_HUNDREDTH, "-0.000099999999999999999");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NINE_HUNDREDTH, "-0.000899999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, ONE_TENTH, "-0.00099999999999999999");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NINE_TENTH, "-0.00899999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, "-0.009899999999999999901");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, "-0.00999999999999999890000000000000001");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, "-0.009999999999999999800000000000000001");

            //first is -0.9999999999999999
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, "0.0099999999999999980000000000000001");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, "0.00989999999999999901");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, "0.0089999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, "0.0009999999999999999");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, "0.00089999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, "0.00009999999999999999");

            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, "-0.00009999999999999999");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, "-0.00089999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, ONE_TENTH, "-0.0009999999999999999");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NINE_TENTH, "-0.0089999999999999991");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, "-0.00989999999999999901");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, "-0.0099999999999999980000000000000001");
            checkPercentageOfFirstOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, "-0.00999999999999999890000000000000001");

            //first is -0.99
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, "0.009801");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, "0.00891");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, "0.00099");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, "0.000891");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, "0.000099");

            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, "-0.000099");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, "-0.000891");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, "-0.00099");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, "-0.00891");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, "-0.009801");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, "-0.00989999999999999901");
            checkPercentageOfFirstOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, "-0.009899999999999999901");

            //first is -0.9
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, "0.0081");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, "0.0009");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, "0.00081");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, "0.00009");

            checkPercentageOfFirstOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, "-0.00009");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, "-0.00081");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, ONE_TENTH, "-0.0009");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, NINE_TENTH, "-0.0081");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, "-0.00891");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, ZERO_DOT_16_NINES, "-0.0089999999999999991");
            checkPercentageOfFirstOperation(NEG_NINE_TENTH, ZERO_DOT_17_NINES, "-0.00899999999999999991");

            //first is -0.1
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, "0.0001");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, NEG_NINE_HUNDREDTH, "0.00009");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, "0.00001");

            checkPercentageOfFirstOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, "-0.00001");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, NINE_HUNDREDTH, "-0.00009");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, ONE_TENTH, "-0.0001");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, NINE_TENTH, "-0.0009");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, "-0.00099");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, ZERO_DOT_16_NINES, "-0.0009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE_TENTH, ZERO_DOT_17_NINES, "-0.00099999999999999999");

            //first is -0.09
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, "0.000081");
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, "0.000009");

            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, "-0.000009");
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, "-0.000081");
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, "-0.00009");
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, "-0.00081");
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, "-0.000891");
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, "-0.00089999999999999991");
            checkPercentageOfFirstOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_17_NINES, "-0.000899999999999999991");

            //first is -0.01
            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, "0.000001");

            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, "-0.000001");
            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, "-0.000009");
            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, "-0.00001");
            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, NINE_TENTH, "-0.00009");
            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, "-0.000099");
            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, "-0.00009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_17_NINES, "-0.000099999999999999999");

            //first is 0.01
            checkPercentageOfFirstOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, "0.000001");
            checkPercentageOfFirstOperation(ONE_HUNDREDTH, NINE_HUNDREDTH, "0.000009");
            checkPercentageOfFirstOperation(ONE_HUNDREDTH, ONE_TENTH, "0.00001");
            checkPercentageOfFirstOperation(ONE_HUNDREDTH, NINE_TENTH, "0.00009");
            checkPercentageOfFirstOperation(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, "0.000099");
            checkPercentageOfFirstOperation(ONE_HUNDREDTH, ZERO_DOT_16_NINES, "0.00009999999999999999");
            checkPercentageOfFirstOperation(ONE_HUNDREDTH, ZERO_DOT_17_NINES, "0.000099999999999999999");

            //first is 0.09
            checkPercentageOfFirstOperation(NINE_HUNDREDTH, NINE_HUNDREDTH, "0.000081");
            checkPercentageOfFirstOperation(NINE_HUNDREDTH, ONE_TENTH, "0.00009");
            checkPercentageOfFirstOperation(NINE_HUNDREDTH, NINE_TENTH, "0.00081");
            checkPercentageOfFirstOperation(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, "0.000891");
            checkPercentageOfFirstOperation(NINE_HUNDREDTH, ZERO_DOT_16_NINES, "0.00089999999999999991");
            checkPercentageOfFirstOperation(NINE_HUNDREDTH, ZERO_DOT_17_NINES, "0.000899999999999999991");

            //first is 0.1
            checkPercentageOfFirstOperation(ONE_TENTH, ONE_TENTH, "0.0001");
            checkPercentageOfFirstOperation(ONE_TENTH, NINE_TENTH, "0.0009");
            checkPercentageOfFirstOperation(ONE_TENTH, NINETY_NINE_HUNDREDTH, "0.00099");
            checkPercentageOfFirstOperation(ONE_TENTH, ZERO_DOT_16_NINES, "0.0009999999999999999");
            checkPercentageOfFirstOperation(ONE_TENTH, ZERO_DOT_17_NINES, "0.00099999999999999999");

            //first is 0.9
            checkPercentageOfFirstOperation(NINE_TENTH, NINE_TENTH, "0.0081");
            checkPercentageOfFirstOperation(NINE_TENTH, NINETY_NINE_HUNDREDTH, "0.00891");
            checkPercentageOfFirstOperation(NINE_TENTH, ZERO_DOT_16_NINES, "0.0089999999999999991");
            checkPercentageOfFirstOperation(NINE_TENTH, ZERO_DOT_17_NINES, "0.00899999999999999991");

            //first is 0.99
            checkPercentageOfFirstOperation(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, "0.009801");
            checkPercentageOfFirstOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, "0.00989999999999999901");
            checkPercentageOfFirstOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, "0.009899999999999999901");

            //first is 0.9999999999999999
            checkPercentageOfFirstOperation(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, "0.0099999999999999980000000000000001");
            checkPercentageOfFirstOperation(ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, "0.00999999999999999890000000000000001");

            //first is 0.99999999999999999
            checkPercentageOfFirstOperation(ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, "0.009999999999999999800000000000000001");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+9999
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9999, "0.01");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9998, "0.1");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_17, "1.e+9980");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_16, "1.e+9981");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_16, "-1.e+9981");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_17, "-1.e+9980");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9998, "-0.1");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9999, "-0.01");

            //first is -1.e+9998
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_9998, "0.01");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_17, "1.e+9979");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_16, "1.e+9980");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_16, "-1.e+9980");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_17, "-1.e+9979");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_9998, "-0.01");

            //first is 1.e+9998
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_9998, "-0.01");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_17, "-1.e+9979");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_16, "-1.e+9980");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_16, "1.e+9980");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_17, "1.e+9979");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_9998, "0.01");

            //first is 1.e+9999
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9999, "-0.01");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9998, "-0.1");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_17, "-1.e+9980");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_16, "-1.e+9981");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_16, "1.e+9981");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_17, "1.e+9980");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9998, "0.1");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9999, "0.01");


            //first is -1.e+17
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, "1.e+32");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, "1.e+31");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, "-1.e+31");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, "-1.e+32");


            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_9999, "1.e-9984");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_9998, "1.e-9983");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_17, "0.01");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_16, "0.1");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_16, "-0.1");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_17, "-0.01");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_9998, "-1.e-9983");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_9999, "-1.e-9984");

            //first is -1.e+16
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, "1.e+30");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, "-1.e+30");


            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_9999, "1.e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_9998, "1.e-9984");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_17, "0.001");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_16, "0.01");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_16, "-0.01");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_17, "-0.001");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_9998, "-1.e-9984");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_9999, "-1.e-9985");

            //first is 1.e+16
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, "-1.e+30");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, "1.e+30");


            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_9999, "-1.e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_9998, "-1.e-9984");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_17, "-0.001");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_MINUS_16, "-0.01");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_16, "0.01");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_17, "0.001");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_9998, "1.e-9984");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_MINUS_9999, "1.e-9985");

            //first is 1.e+17
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, "-1.e+32");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, "-1.e+31");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, "1.e+31");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, "1.e+32");


            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_9999, "-1.e-9984");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_9998, "-1.e-9983");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_17, "-0.01");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_MINUS_16, "-0.1");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_16, "0.1");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_17, "0.01");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_9998, "1.e-9983");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_MINUS_9999, "1.e-9984");
        }

        //with integers
        {
            //first is -1.e+9999
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_HUNDRED, "1.e+9999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_TEN, "1.e+9998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE, "1.e+9997");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.ONE, "-1.e+9997");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.TEN, "-1.e+9998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, HUNDRED, "-1.e+9999");

            //first is -1.e+9998
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_HUNDRED, "1.e+9998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_TEN, "1.e+9997");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE, "1.e+9996");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.ONE, "-1.e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.TEN, "-1.e+9997");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, HUNDRED, "-1.e+9998");

            //first is -1.e+17
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, "1.e+31");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, "9.999999999999999e+30");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, "9.999999999999998e+30");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, "5.e+30");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, "1.e+17");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, "1.e+16");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, "1.e+15");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, "-1.e+15");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, "-1.e+16");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, "-1.e+17");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, "-5.e+30");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-9.999999999999998e+30");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, "-9.999999999999999e+30");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e+31");

            //first is -1.e+16
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, "1.e+30");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, "9.999999999999999e+29");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, "9.999999999999998e+29");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, "5.e+29");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, "1.e+16");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, "1.e+15");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, "1.e+14");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, "-1.e+14");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, "-1.e+15");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, "-1.e+16");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, "-5.e+29");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-9.999999999999998e+29");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, "-9.999999999999999e+29");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e+30");

            //first is 1.e+16
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, "-1.e+30");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, "-9.999999999999999e+29");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, "-9.999999999999998e+29");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, "-5.e+29");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, "-1.e+16");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_TEN, "-1.e+15");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE, "-1.e+14");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, "1.e+14");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, "1.e+15");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, HUNDRED, "1.e+16");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, "5.e+29");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, "9.999999999999998e+29");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, "9.999999999999999e+29");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e+30");

            //first is 1.e+17
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, "-1.e+31");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, "-9.999999999999999e+30");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, "-9.999999999999998e+30");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, "-5.e+30");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, "-1.e+17");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_TEN, "-1.e+16");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE, "-1.e+15");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, "1.e+15");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, "1.e+16");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, HUNDRED, "1.e+17");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, "5.e+30");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, "9.999999999999998e+30");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, "9.999999999999999e+30");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e+31");

            //first is 1.e+9998
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_HUNDRED, "-1.e+9998");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_TEN, "-1.e+9997");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ONE, "-1.e+9996");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, BigDecimal.ONE, "1.e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, BigDecimal.TEN, "1.e+9997");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, HUNDRED, "1.e+9998");

            //first is 1.e+9999
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_HUNDRED, "-1.e+9999");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_TEN, "-1.e+9998");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ONE, "-1.e+9997");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, BigDecimal.ONE, "1.e+9997");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, BigDecimal.TEN, "1.e+9998");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, HUNDRED, "1.e+9999");


            //first is -1.e-9999
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, "1.e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, "9.999999999999999e-9986");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, "9.999999999999998e-9986");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, "5.e-9986");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_HUNDRED, "1.e-9999");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, HUNDRED, "-1.e-9999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, "-5.e-9986");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-9.999999999999998e-9986");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, "-9.999999999999999e-9986");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e-9985");

            //first is -1.e-9998
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, "1.e-9984");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, "9.999999999999999e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, "9.999999999999998e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, "5.e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_HUNDRED, "1.e-9998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_TEN, "1.e-9999");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.TEN, "-1.e-9999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, HUNDRED, "-1.e-9998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, "-5.e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-9.999999999999998e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, "-9.999999999999999e-9985");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-1.e-9984");

            //first is -1.e-17
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, "0.001");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, "0.0009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, "0.0009999999999999998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, "0.0005");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, "1.e-17");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, "1.e-18");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, "1.e-19");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, "-1.e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, "-1.e-18");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, "-1.e-17");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, "-0.0005");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-0.0009999999999999998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, "-0.0009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-0.001");

            //first is -1.e-16
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, "0.01");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, "0.009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, "0.009999999999999998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, "0.005");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, "1.e-16");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, "1.e-17");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, "1.e-18");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, "-1.e-18");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, "-1.e-17");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, "-1.e-16");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, "-0.005");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, "-0.009999999999999998");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, "-0.009999999999999999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, "-0.01");

            //first is 1.e-16
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, "-0.01");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, "-0.009999999999999999");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, "-0.009999999999999998");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, "-0.005");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, "-1.e-16");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_TEN, "-1.e-17");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_ONE, "-1.e-18");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, "1.e-18");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, "1.e-17");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, HUNDRED, "1.e-16");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, "0.005");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, "0.009999999999999998");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, "0.009999999999999999");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, "0.01");

            //first is 1.e-17
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, "-0.001");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, "-0.0009999999999999999");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, "-0.0009999999999999998");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, "-0.0005");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, "-1.e-17");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_TEN, "-1.e-18");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_ONE, "-1.e-19");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, "1.e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, "1.e-18");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, HUNDRED, "1.e-17");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, "0.0005");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, "0.0009999999999999998");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, "0.0009999999999999999");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, "0.001");

            //first is 1.e-9998
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, "-1.e-9984");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, "-9.999999999999999e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, "-9.999999999999998e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, "-5.e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, NEG_HUNDRED, "-1.e-9998");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, NEG_TEN, "-1.e-9999");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, BigDecimal.TEN, "1.e-9999");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, HUNDRED, "1.e-9998");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, "5.e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, "9.999999999999998e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, "9.999999999999999e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e-9984");

            //first is 1.e-9999
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, "-1.e-9985");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, "-9.999999999999999e-9986");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, "-9.999999999999998e-9986");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, "-5.e-9986");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, NEG_HUNDRED, "-1.e-9999");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, "0");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, HUNDRED, "1.e-9999");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, "5.e-9986");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, "9.999999999999998e-9986");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, "9.999999999999999e-9986");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e-9985");
        }

        //with decimals
        {
            //first is -1.e+9999
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_17_NINES, "9.9999999999999999e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_16_NINES, "9.999999999999999e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINETY_NINE_HUNDREDTH, "9.9e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINE_TENTH, "9.e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, "1.e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINE_HUNDREDTH, "9.e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, "1.e+9995");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, "-1.e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NINE_HUNDREDTH, "-9.e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_TENTH, "-1.e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NINE_TENTH, "-9.e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, NINETY_NINE_HUNDREDTH, "-9.9e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ZERO_DOT_16_NINES, "-9.999999999999999e+9996");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9999, ZERO_DOT_17_NINES, "-9.9999999999999999e+9996");

            //first is -1.e+9998
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_17_NINES, "9.9999999999999999e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_16_NINES, "9.999999999999999e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINETY_NINE_HUNDREDTH, "9.9e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINE_TENTH, "9.e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, "1.e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINE_HUNDREDTH, "9.e+9994");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, "1.e+9994");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, "-1.e+9994");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NINE_HUNDREDTH, "-9.e+9994");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_TENTH, "-1.e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NINE_TENTH, "-9.e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, NINETY_NINE_HUNDREDTH, "-9.9e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, ZERO_DOT_16_NINES, "-9.999999999999999e+9995");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_9998, ZERO_DOT_17_NINES, "-9.9999999999999999e+9995");

            //first is -1.e+17
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, "999999999999999.99");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, "999999999999999.9");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, "9.9e+14");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, "9.e+14");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, "1.e+14");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, "9.e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, "1.e+13");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, "-1.e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, "-9.e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ONE_TENTH, "-1.e+14");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NINE_TENTH, "-9.e+14");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, "-9.9e+14");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, "-999999999999999.9");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, "-999999999999999.99");

            //first is -1.e+16
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, "99999999999999.999");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, "99999999999999.99");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, "9.9e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, "9.e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, "1.e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, "9.e+12");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, "1.e+12");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, "-1.e+12");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, "-9.e+12");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ONE_TENTH, "-1.e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NINE_TENTH, "-9.e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, "-9.9e+13");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, "-99999999999999.99");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, "-99999999999999.999");

            //first is 1.e+16
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, "-99999999999999.999");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, "-99999999999999.99");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, "-9.9e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, "-9.e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, "-1.e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, "-9.e+12");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, "-1.e+12");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, "1.e+12");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, "9.e+12");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ONE_TENTH, "1.e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NINE_TENTH, "9.e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, "9.9e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, "99999999999999.99");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, "99999999999999.999");

            //first is 1.e+17
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, "-999999999999999.99");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, "-999999999999999.9");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, "-9.9e+14");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, "-9.e+14");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, "-1.e+14");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, "-9.e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, "-1.e+13");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, "1.e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, "9.e+13");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ONE_TENTH, "1.e+14");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NINE_TENTH, "9.e+14");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, "9.9e+14");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, "999999999999999.9");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, "999999999999999.99");

            //first is 1.e+9998
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_17_NINES, "-9.9999999999999999e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_16_NINES, "-9.999999999999999e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_NINETY_NINE_HUNDREDTH, "-9.9e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_NINE_TENTH, "-9.e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, "-1.e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_NINE_HUNDREDTH, "-9.e+9994");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, "-1.e+9994");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, "1.e+9994");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NINE_HUNDREDTH, "9.e+9994");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, ONE_TENTH, "1.e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NINE_TENTH, "9.e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, NINETY_NINE_HUNDREDTH, "9.9e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, ZERO_DOT_16_NINES, "9.999999999999999e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9998, ZERO_DOT_17_NINES, "9.9999999999999999e+9995");

            //first is 1.e+9999
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_17_NINES, "-9.9999999999999999e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_16_NINES, "-9.999999999999999e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_NINETY_NINE_HUNDREDTH, "-9.9e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_NINE_TENTH, "-9.e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, "-1.e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_NINE_HUNDREDTH, "-9.e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, "-1.e+9995");

            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, "1.e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NINE_HUNDREDTH, "9.e+9995");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ONE_TENTH, "1.e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NINE_TENTH, "9.e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, NINETY_NINE_HUNDREDTH, "9.9e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ZERO_DOT_16_NINES, "9.999999999999999e+9996");
            checkPercentageOfFirstOperation(ONE_DOT_E_PLUS_9999, ZERO_DOT_17_NINES, "9.9999999999999999e+9996");

            //first is -1.e-17
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, "9.9999999999999999e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, "9.999999999999999e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, "9.9e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, "9.e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, "1.e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, "9.e-21");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, "1.e-21");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, "-1.e-21");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, "-9.e-21");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, ONE_TENTH, "-1.e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NINE_TENTH, "-9.e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, "-9.9e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, "-9.999999999999999e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, "-9.9999999999999999e-20");

            //first is -1.e-16
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, "9.9999999999999999e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, "9.999999999999999e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, "9.9e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, "9.e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, "1.e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, "9.e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, "1.e-20");

            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, "-1.e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, "-9.e-20");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, ONE_TENTH, "-1.e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NINE_TENTH, "-9.e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, "-9.9e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, "-9.999999999999999e-19");
            checkPercentageOfFirstOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, "-9.9999999999999999e-19");

            //first is 1.e-16
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, "-9.9999999999999999e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, "-9.999999999999999e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, "-9.9e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, "-9.e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, "-1.e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, "-9.e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, "-1.e-20");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, "1.e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, "9.e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, ONE_TENTH, "1.e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NINE_TENTH, "9.e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, "9.9e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, "9.999999999999999e-19");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, "9.9999999999999999e-19");

            //first is 1.e-17
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, "-9.9999999999999999e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, "-9.999999999999999e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, "-9.9e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, "-9.e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, "-1.e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, "-9.e-21");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, "-1.e-21");

            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, "1.e-21");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, "9.e-21");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, ONE_TENTH, "1.e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NINE_TENTH, "9.e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, "9.9e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, "9.999999999999999e-20");
            checkPercentageOfFirstOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, "9.9999999999999999e-20");
        }

        //several random values
        {
            checkPercentageOfFirstOperation(new BigDecimal("14"), new BigDecimal("51"), "7.14");
            checkPercentageOfFirstOperation(new BigDecimal("6523"), new BigDecimal("123"), "8023.29");

            checkPercentageOfFirstOperation(new BigDecimal("123"), new BigDecimal("-31"), "-38.13");
            checkPercentageOfFirstOperation(new BigDecimal("874"), new BigDecimal("-41"), "-358.34");

            checkPercentageOfFirstOperation(new BigDecimal("-31"), new BigDecimal("-1321"), "409.51");
            checkPercentageOfFirstOperation(new BigDecimal("-132"), new BigDecimal("-52"), "68.64");

            checkPercentageOfFirstOperation(new BigDecimal("51354"), new BigDecimal("132.12"), "67848.9048");
            checkPercentageOfFirstOperation(new BigDecimal("54"), new BigDecimal("21.4"), "11.556");

            checkPercentageOfFirstOperation(new BigDecimal("221"), new BigDecimal("-123.512"), "-272.96152");
            checkPercentageOfFirstOperation(new BigDecimal("54"), new BigDecimal("-2135.13"), "-1152.9702");

            checkPercentageOfFirstOperation(new BigDecimal("-12"), new BigDecimal("1.2"), "-0.144");
            checkPercentageOfFirstOperation(new BigDecimal("-87"), new BigDecimal("23.61"), "-20.5407");

            checkPercentageOfFirstOperation(new BigDecimal("-65"), new BigDecimal("-10.11"), "6.5715");
            checkPercentageOfFirstOperation(new BigDecimal("-324"), new BigDecimal("-12.31"), "39.8844");

            checkPercentageOfFirstOperation(new BigDecimal("21.12"), new BigDecimal("7.6"), "1.60512");
            checkPercentageOfFirstOperation(new BigDecimal("5132.123"), new BigDecimal("24.24"), "1244.0266152");

            checkPercentageOfFirstOperation(new BigDecimal("42.64"), new BigDecimal("-67.8"), "-28.90992");
            checkPercentageOfFirstOperation(new BigDecimal("31.31"), new BigDecimal("-34.5"), "-10.80195");

            checkPercentageOfFirstOperation(new BigDecimal("-74.1"), new BigDecimal("-2.23"), "1.65243");
            checkPercentageOfFirstOperation(new BigDecimal("-7.2"), new BigDecimal("-23.53"), "1.69416");
        }
    }

    /**
     * Tests for percentage of 100 operation.
     */
    @Test
    void percentageOf100Tests() {
        //integers 
        {
            checkPercentageOf100Operation(MIN_VALUE_ON_SCREEN_MINUS_ONE, "-1.e+14");
            checkPercentageOf100Operation(MIN_VALUE_ON_SCREEN, "-99999999999999.99");
            checkPercentageOf100Operation(MIN_VALUE_ON_SCREEN_PLUS_ONE, "-99999999999999.98");
            checkPercentageOf100Operation(HALF_MIN_VALUE_ON_SCREEN, "-5.e+13");
            checkPercentageOf100Operation(NEG_HUNDRED, "-1");
            checkPercentageOf100Operation(NEG_TEN, "-0.1");
            checkPercentageOf100Operation(NEG_ONE, "-0.01");

            checkPercentageOf100Operation(BigDecimal.ZERO, "0");

            checkPercentageOf100Operation(BigDecimal.ONE, "0.01");
            checkPercentageOf100Operation(BigDecimal.TEN, "0.1");
            checkPercentageOf100Operation(HUNDRED, "1");
            checkPercentageOf100Operation(HALF_MAX_VALUE_ON_SCREEN, "5.e+13");
            checkPercentageOf100Operation(MAX_VALUE_ON_SCREEN_MINUS_ONE, "99999999999999.98");
            checkPercentageOf100Operation(MAX_VALUE_ON_SCREEN, "99999999999999.99");
            checkPercentageOf100Operation(MAX_VALUE_ON_SCREEN_PLUS_ONE, "1.e+14");
        }

        //decimals
        {
            checkPercentageOf100Operation(NEG_ZERO_DOT_17_NINES, "-0.0099999999999999999");
            checkPercentageOf100Operation(NEG_ZERO_DOT_16_NINES, "-0.009999999999999999");
            checkPercentageOf100Operation(NEG_NINETY_NINE_HUNDREDTH, "-0.0099");
            checkPercentageOf100Operation(NEG_NINE_TENTH, "-0.009");
            checkPercentageOf100Operation(NEG_ONE_TENTH, "-0.001");
            checkPercentageOf100Operation(NEG_NINE_HUNDREDTH, "-0.0009");
            checkPercentageOf100Operation(NEG_ONE_HUNDREDTH, "-0.0001");

            checkPercentageOf100Operation(ONE_HUNDREDTH, "0.0001");
            checkPercentageOf100Operation(NINE_HUNDREDTH, "0.0009");
            checkPercentageOf100Operation(ONE_TENTH, "0.001");
            checkPercentageOf100Operation(NINE_TENTH, "0.009");
            checkPercentageOf100Operation(NINETY_NINE_HUNDREDTH, "0.0099");
            checkPercentageOf100Operation(ZERO_DOT_16_NINES, "0.009999999999999999");
            checkPercentageOf100Operation(ZERO_DOT_17_NINES, "0.0099999999999999999");
        }

        //engineer numbers
        {
            checkPercentageOf100Operation(NEG_ONE_DOT_E_PLUS_9999, "-1.e+9997");
            checkPercentageOf100Operation(NEG_ONE_DOT_E_PLUS_9998, "-1.e+9996");
            checkPercentageOf100Operation(NEG_ONE_DOT_E_PLUS_17, "-1.e+15");
            checkPercentageOf100Operation(NEG_ONE_DOT_E_PLUS_16, "-1.e+14");

            checkPercentageOf100Operation(ONE_DOT_E_PLUS_16, "1.e+14");
            checkPercentageOf100Operation(ONE_DOT_E_PLUS_17, "1.e+15");
            checkPercentageOf100Operation(ONE_DOT_E_PLUS_9998, "1.e+9996");
            checkPercentageOf100Operation(ONE_DOT_E_PLUS_9999, "1.e+9997");


            checkPercentageOf100Operation(NEG_ONE_DOT_E_MINUS_17, "-1.e-19");
            checkPercentageOf100Operation(NEG_ONE_DOT_E_MINUS_16, "-1.e-18");

            checkPercentageOf100Operation(ONE_DOT_E_MINUS_16, "1.e-18");
            checkPercentageOf100Operation(ONE_DOT_E_MINUS_17, "1.e-19");
        }

        //several random values
        {
            checkPercentageOf100Operation(new BigDecimal("73"), "0.73");
            checkPercentageOf100Operation(new BigDecimal("8734"), "87.34");

            checkPercentageOf100Operation(new BigDecimal("-42"), "-0.42");
            checkPercentageOf100Operation(new BigDecimal("-876"), "-8.76");

            checkPercentageOf100Operation(new BigDecimal("2423.73"), "24.2373");
            checkPercentageOf100Operation(new BigDecimal("87.234"), "0.87234");

            checkPercentageOf100Operation(new BigDecimal("-123.623"), "-1.23623");
            checkPercentageOf100Operation(new BigDecimal("-432.62"), "-4.3262");
        }
    }

    /**
     * Tests for unary negate operation.
     *
     * @see UnaryOperations
     */
    @Test
    void negateOperationTests() {
        //integers 
        {
            checkUnaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEGATE, "1.e+16");
            checkUnaryOperation(MIN_VALUE_ON_SCREEN, NEGATE, "9999999999999999");
            checkUnaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEGATE, "9999999999999998");
            checkUnaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEGATE, "5.e+15");
            checkUnaryOperation(NEG_HUNDRED, NEGATE, "1.e+2");
            checkUnaryOperation(NEG_TEN, NEGATE, "1.e+1");
            checkUnaryOperation(NEG_ONE, NEGATE, "1");

            checkUnaryOperation(BigDecimal.ZERO, NEGATE, "0");

            checkUnaryOperation(BigDecimal.ONE, NEGATE, "-1");
            checkUnaryOperation(BigDecimal.TEN, NEGATE, "-1.e+1");
            checkUnaryOperation(HUNDRED, NEGATE, "-1.e+2");
            checkUnaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEGATE, "-5.e+15");
            checkUnaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEGATE, "-9999999999999998");
            checkUnaryOperation(MAX_VALUE_ON_SCREEN, NEGATE, "-9999999999999999");
            checkUnaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEGATE, "-1.e+16");
        }

        //decimals
        {
            checkUnaryOperation(NEG_ZERO_DOT_17_NINES, NEGATE, "0.99999999999999999");
            checkUnaryOperation(NEG_ZERO_DOT_16_NINES, NEGATE, "0.9999999999999999");
            checkUnaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEGATE, "0.99");
            checkUnaryOperation(NEG_NINE_TENTH, NEGATE, "0.9");
            checkUnaryOperation(NEG_ONE_TENTH, NEGATE, "0.1");
            checkUnaryOperation(NEG_NINE_HUNDREDTH, NEGATE, "0.09");
            checkUnaryOperation(NEG_ONE_HUNDREDTH, NEGATE, "0.01");

            checkUnaryOperation(ONE_HUNDREDTH, NEGATE, "-0.01");
            checkUnaryOperation(NINE_HUNDREDTH, NEGATE, "-0.09");
            checkUnaryOperation(ONE_TENTH, NEGATE, "-0.1");
            checkUnaryOperation(NINE_TENTH, NEGATE, "-0.9");
            checkUnaryOperation(NINETY_NINE_HUNDREDTH, NEGATE, "-0.99");
            checkUnaryOperation(ZERO_DOT_16_NINES, NEGATE, "-0.9999999999999999");
            checkUnaryOperation(ZERO_DOT_17_NINES, NEGATE, "-0.99999999999999999");
        }

        //engineer numbers
        {
            checkUnaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEGATE, "1.e+9999");
            checkUnaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEGATE, "1.e+9998");
            checkUnaryOperation(NEG_ONE_DOT_E_PLUS_17, NEGATE, "1.e+17");
            checkUnaryOperation(NEG_ONE_DOT_E_PLUS_16, NEGATE, "1.e+16");

            checkUnaryOperation(ONE_DOT_E_PLUS_16, NEGATE, "-1.e+16");
            checkUnaryOperation(ONE_DOT_E_PLUS_17, NEGATE, "-1.e+17");
            checkUnaryOperation(ONE_DOT_E_PLUS_9998, NEGATE, "-1.e+9998");
            checkUnaryOperation(ONE_DOT_E_PLUS_9999, NEGATE, "-1.e+9999");


            checkUnaryOperation(NEG_ONE_DOT_E_MINUS_17, NEGATE, "1.e-17");
            checkUnaryOperation(NEG_ONE_DOT_E_MINUS_16, NEGATE, "1.e-16");

            checkUnaryOperation(ONE_DOT_E_MINUS_16, NEGATE, "-1.e-16");
            checkUnaryOperation(ONE_DOT_E_MINUS_17, NEGATE, "-1.e-17");
        }

        //several random values
        {
            checkUnaryOperation(new BigDecimal("6324"), NEGATE, "-6324");
            checkUnaryOperation(new BigDecimal("987"), NEGATE, "-987");

            checkUnaryOperation(new BigDecimal("-213"), NEGATE, "213");
            checkUnaryOperation(new BigDecimal("-6512"), NEGATE, "6512");

            checkUnaryOperation(new BigDecimal("84.13"), NEGATE, "-84.13");
            checkUnaryOperation(new BigDecimal("98735.8457"), NEGATE, "-98735.8457");

            checkUnaryOperation(new BigDecimal("-234.123"), NEGATE, "234.123");
            checkUnaryOperation(new BigDecimal("-6434.213"), NEGATE, "6434.213");
        }
    }

    /**
     * Tests for unary sqr operation.
     *
     * @see UnaryOperations
     */
    @Test
    void sqrOperationTests() {
        //integers 
        {
            checkUnaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, SQR, "1.e+32");
            checkUnaryOperation(MIN_VALUE_ON_SCREEN, SQR, "99999999999999980000000000000001");
            checkUnaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, SQR, "99999999999999960000000000000004");
            checkUnaryOperation(HALF_MIN_VALUE_ON_SCREEN, SQR, "2.5e+31");
            checkUnaryOperation(NEG_HUNDRED, SQR, "1.e+4");
            checkUnaryOperation(NEG_TEN, SQR, "1.e+2");
            checkUnaryOperation(NEG_ONE, SQR, "1");

            checkUnaryOperation(BigDecimal.ZERO, SQR, "0");

            checkUnaryOperation(BigDecimal.ONE, SQR, "1");
            checkUnaryOperation(BigDecimal.TEN, SQR, "1.e+2");
            checkUnaryOperation(HUNDRED, SQR, "1.e+4");
            checkUnaryOperation(HALF_MAX_VALUE_ON_SCREEN, SQR, "2.5e+31");
            checkUnaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, SQR, "99999999999999960000000000000004");
            checkUnaryOperation(MAX_VALUE_ON_SCREEN, SQR, "99999999999999980000000000000001");
            checkUnaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, SQR, "1.e+32");
        }

        //decimals
        {
            checkUnaryOperation(NEG_ZERO_DOT_17_NINES, SQR, "0.9999999999999999800000000000000001");
            checkUnaryOperation(NEG_ZERO_DOT_16_NINES, SQR, "0.99999999999999980000000000000001");
            checkUnaryOperation(NEG_NINETY_NINE_HUNDREDTH, SQR, "0.9801");
            checkUnaryOperation(NEG_NINE_TENTH, SQR, "0.81");
            checkUnaryOperation(NEG_ONE_TENTH, SQR, "0.01");
            checkUnaryOperation(NEG_NINE_HUNDREDTH, SQR, "0.0081");
            checkUnaryOperation(NEG_ONE_HUNDREDTH, SQR, "0.0001");

            checkUnaryOperation(ONE_HUNDREDTH, SQR, "0.0001");
            checkUnaryOperation(NINE_HUNDREDTH, SQR, "0.0081");
            checkUnaryOperation(ONE_TENTH, SQR, "0.01");
            checkUnaryOperation(NINE_TENTH, SQR, "0.81");
            checkUnaryOperation(NINETY_NINE_HUNDREDTH, SQR, "0.9801");
            checkUnaryOperation(ZERO_DOT_16_NINES, SQR, "0.99999999999999980000000000000001");
            checkUnaryOperation(ZERO_DOT_17_NINES, SQR, "0.9999999999999999800000000000000001");
        }

        //engineer numbers
        {
            checkUnaryOperation(NEG_ONE_DOT_E_PLUS_17, SQR, "1.e+34");
            checkUnaryOperation(NEG_ONE_DOT_E_PLUS_16, SQR, "1.e+32");

            checkUnaryOperation(ONE_DOT_E_PLUS_16, SQR, "1.e+32");
            checkUnaryOperation(ONE_DOT_E_PLUS_17, SQR, "1.e+34");


            checkUnaryOperation(NEG_ONE_DOT_E_MINUS_17, SQR, "1.e-34");
            checkUnaryOperation(NEG_ONE_DOT_E_MINUS_16, SQR, "1.e-32");

            checkUnaryOperation(ONE_DOT_E_MINUS_16, SQR, "1.e-32");
            checkUnaryOperation(ONE_DOT_E_MINUS_17, SQR, "1.e-34");
        }

        //several random values
        {
            checkUnaryOperation(new BigDecimal("743"), SQR, "552049");
            checkUnaryOperation(new BigDecimal("324"), SQR, "104976");

            checkUnaryOperation(new BigDecimal("-87634"), SQR, "7679717956");
            checkUnaryOperation(new BigDecimal("-234"), SQR, "54756");

            checkUnaryOperation(new BigDecimal("987.12"), SQR, "974405.8944");
            checkUnaryOperation(new BigDecimal("1.2"), SQR, "1.44");

            checkUnaryOperation(new BigDecimal("-31.62"), SQR, "999.8244");
            checkUnaryOperation(new BigDecimal("-65.123"), SQR, "4241.005129");
        }
    }

    /**
     * Tests for unary sqrt operation.
     *
     * @see UnaryOperations
     */
    @Test
    void sqrtOperationTests() {
        //integers 
        {
            checkUnaryOperation(BigDecimal.ZERO, SQRT, "0");

            checkUnaryOperation(BigDecimal.ONE, SQRT, "1");
            checkUnaryOperation(new BigDecimal("9"), SQRT, "3");
            checkUnaryOperation(HUNDRED, SQRT, "1.e+1");
            checkUnaryOperation(new BigDecimal("25000000000000"), SQRT, "5.e+6");
            checkUnaryOperation(new BigDecimal("11111108888889"), SQRT, "3333333");
            checkUnaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, SQRT, "1.e+8");
        }

        //decimals
        {
            checkUnaryOperation(ONE_HUNDREDTH, SQRT, "0.1");
            checkUnaryOperation(new BigDecimal("0.015625"), SQRT, "0.125");
            checkUnaryOperation(new BigDecimal("0.04"), SQRT, "0.2");
            checkUnaryOperation(new BigDecimal("0.36"), SQRT, "0.6");
            checkUnaryOperation(NINE_HUNDREDTH, SQRT, "0.3");
        }

        //engineer numbers
        {
            checkUnaryOperation(ONE_DOT_E_PLUS_16, SQRT, "-1.e+16");
            checkUnaryOperation(ONE_DOT_E_PLUS_17, SQRT, "-1.e+17");
            checkUnaryOperation(ONE_DOT_E_PLUS_9998, SQRT, "-1.e+9998");
            checkUnaryOperation(ONE_DOT_E_PLUS_9999, SQRT, "-1.e+9999");

            checkUnaryOperation(ONE_DOT_E_MINUS_16, SQRT, "-1.e-16");
            checkUnaryOperation(ONE_DOT_E_MINUS_17, SQRT, "-1.e-17");
        }

        //several random values
        {
            checkUnaryOperation(new BigDecimal("6324"), SQRT, "-6324");
            checkUnaryOperation(new BigDecimal("987"), SQRT, "-987");

            checkUnaryOperation(new BigDecimal("84.13"), SQRT, "-84.13");
            checkUnaryOperation(new BigDecimal("98735.8457"), SQRT, "-98735.8457");
        }
    }

    /**
     * Tests for overflow exception while using binary operations in model.
     *
     * @see OverflowException
     */
    void unaryOverflowExceptionTests() {
        //sqr operation

    }

    /**
     * Tests for overflow exception while using binary operations in model.
     *
     * @see OverflowException
     */
    @Test
    void binaryOverflowExceptionTests() {
        //add operation
        {
            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), new BigDecimal("-9.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), new BigDecimal("-8.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), new BigDecimal("-2.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), NEG_ONE_DOT_E_PLUS_9999, ADD);

            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("-8.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("-8.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("-2.e+9999"), ADD);

            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("8.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("8.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("2.e+9999"), ADD);

            checkBinaryOverflowException(new BigDecimal("9.e+9999"), new BigDecimal("9.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("9.e+9999"), new BigDecimal("8.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("9.e+9999"), new BigDecimal("2.e+9999"), ADD);
            checkBinaryOverflowException(new BigDecimal("9.e+9999"), ONE_DOT_E_PLUS_9999, ADD);
        }

        //subtract operation
        {
            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), new BigDecimal("9.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("9.e+9999"), new BigDecimal("-9.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), new BigDecimal("8.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("-9.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), new BigDecimal("2.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("2.e+9999"), new BigDecimal("-9.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), ONE_DOT_E_PLUS_9999, SUBTRACT);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, new BigDecimal("-9.e+9999"), SUBTRACT);


            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("8.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("-8.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("8.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("-8.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("2.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("2.e+9999"), new BigDecimal("-8.e+9999"), SUBTRACT);


            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("-8.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("8.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("-8.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("8.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("8.e+9999"), new BigDecimal("-2.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("-2.e+9999"), new BigDecimal("8.e+9999"), SUBTRACT);


            checkBinaryOverflowException(new BigDecimal("9.e+9999"), new BigDecimal("-9.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("-9.e+9999"), new BigDecimal("9.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("9.e+9999"), new BigDecimal("-8.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("-8.e+9999"), new BigDecimal("9.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("9.e+9999"), new BigDecimal("-2.e+9999"), SUBTRACT);
            checkBinaryOverflowException(new BigDecimal("-2.e+9999"), new BigDecimal("9.e+9999"), SUBTRACT);

            checkBinaryOverflowException(new BigDecimal("9.e+9999"), NEG_ONE_DOT_E_PLUS_9999, SUBTRACT);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, new BigDecimal("9.e+9999"), SUBTRACT);
        }

        //multiply operation
        {
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_TEN, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.TEN, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_HUNDRED, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, HUNDRED, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, MULTIPLY);


            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_HUNDRED, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, HUNDRED, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, MULTIPLY);


            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("-1.e+5000"), MULTIPLY);
            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("1.e+5000"), MULTIPLY);


            checkBinaryOverflowException(new BigDecimal("1.e+5000"), new BigDecimal("-1.e+5000"), MULTIPLY);
            checkBinaryOverflowException(new BigDecimal("1.e+5000"), new BigDecimal("1.e+5000"), MULTIPLY);


            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, NEG_HUNDRED, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, HUNDRED, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, MULTIPLY);


            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_TEN, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, BigDecimal.TEN, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_HUNDRED, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, HUNDRED, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, MULTIPLY);


            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_TENTH, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_TENTH, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_HUNDREDTH, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_HUNDREDTH, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, MULTIPLY);


            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_HUNDREDTH, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, ONE_HUNDREDTH, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, MULTIPLY);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, MULTIPLY);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, MULTIPLY);


            checkBinaryOverflowException(new BigDecimal("-1.e-5000"), new BigDecimal("-1.e-5000"), MULTIPLY);
            checkBinaryOverflowException(new BigDecimal("-1.e-5000"), new BigDecimal("1.e-5000"), MULTIPLY);


            checkBinaryOverflowException(new BigDecimal("1.e-5000"), new BigDecimal("-1.e-5000"), MULTIPLY);
            checkBinaryOverflowException(new BigDecimal("1.e-5000"), new BigDecimal("1.e-5000"), MULTIPLY);


            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, NEG_ONE_HUNDREDTH, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, ONE_HUNDREDTH, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, MULTIPLY);


            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_TENTH, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, ONE_TENTH, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_HUNDREDTH, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, ONE_HUNDREDTH, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, MULTIPLY);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, MULTIPLY);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, MULTIPLY);
        }

        //divide operation
        {
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9999, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9999, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9998, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9998, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_TENTH, DIVIDE);


            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_9999, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_9999, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_9998, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_9998, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, DIVIDE);


            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("-1.e-5000"), DIVIDE);
            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("1.e-5000"), DIVIDE);


            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("-1.e-5000"), DIVIDE);
            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("1.e-5000"), DIVIDE);


            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_9999, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_9999, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_MINUS_9998, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, ONE_DOT_E_MINUS_9998, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, DIVIDE);


            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9999, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9999, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_MINUS_9998, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, ONE_DOT_E_MINUS_9998, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_PLUS_9999, ONE_TENTH, DIVIDE);


            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_PLUS_9999, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_PLUS_9999, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_PLUS_9998, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_PLUS_9998, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_HUNDRED, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, HUNDRED, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_TEN, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.TEN, DIVIDE);


            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_PLUS_9999, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_PLUS_9999, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_PLUS_9998, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_PLUS_9998, DIVIDE);

            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_HUNDRED, DIVIDE);
            checkBinaryOverflowException(NEG_ONE_DOT_E_MINUS_9998, HUNDRED, DIVIDE);


            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("-1.e-5000"), DIVIDE);
            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("1.e-5000"), DIVIDE);


            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("-1.e-5000"), DIVIDE);
            checkBinaryOverflowException(new BigDecimal("-1.e+5000"), new BigDecimal("1.e-5000"), DIVIDE);


            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_PLUS_9999, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, ONE_DOT_E_PLUS_9999, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_PLUS_9998, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, ONE_DOT_E_PLUS_9998, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, NEG_HUNDRED, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9998, HUNDRED, DIVIDE);


            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_PLUS_9999, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, ONE_DOT_E_PLUS_9999, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_PLUS_9998, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, ONE_DOT_E_PLUS_9998, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_HUNDRED, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, HUNDRED, DIVIDE);

            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, NEG_TEN, DIVIDE);
            checkBinaryOverflowException(ONE_DOT_E_MINUS_9999, BigDecimal.TEN, DIVIDE);
        }
    }

    /**
     * Tests for overflow exception while using percentage of first operation in model.
     *
     * @see OverflowException
     */
    @Test
    void percentageOfFirstOverflowExceptionTests() {
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, new BigDecimal("-1000"));
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, new BigDecimal("1000"));

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, new BigDecimal("-1001"));
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, new BigDecimal("1001"));

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998);

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999);


        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9998, new BigDecimal("-10000"));
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9998, new BigDecimal("10000"));

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998);

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999);


        checkPercentageOfFirstOverflowException(new BigDecimal("-1.e+5001"), new BigDecimal("-1.e+5001"));
        checkPercentageOfFirstOverflowException(new BigDecimal("-1.e+5001"), new BigDecimal("1.e+5001"));


        checkPercentageOfFirstOverflowException(new BigDecimal("1.e+5001"), new BigDecimal("-1.e+5001"));
        checkPercentageOfFirstOverflowException(new BigDecimal("1.e+5001"), new BigDecimal("1.e+5001"));


        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9998, new BigDecimal("-10000"));
        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9998, new BigDecimal("10000"));

        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998);

        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999);


        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, new BigDecimal("-1000"));
        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, new BigDecimal("1000"));

        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, new BigDecimal("-1001"));
        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, new BigDecimal("1001"));

        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998);

        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999);


        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, new BigDecimal("-0.001"));
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, new BigDecimal("0.001"));

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, new BigDecimal("-0.0001"));
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, new BigDecimal("0.0001"));

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998);

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999);


        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9998, new BigDecimal("-0.0001"));
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9998, new BigDecimal("0.0001"));

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998);

        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999);
        checkPercentageOfFirstOverflowException(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999);


        checkPercentageOfFirstOverflowException(new BigDecimal("-1.e-5001"), new BigDecimal("-1.e-5001"));
        checkPercentageOfFirstOverflowException(new BigDecimal("-1.e-5001"), new BigDecimal("1.e-5001"));


        checkPercentageOfFirstOverflowException(new BigDecimal("1.e-5001"), new BigDecimal("-1.e-5001"));
        checkPercentageOfFirstOverflowException(new BigDecimal("1.e-5001"), new BigDecimal("1.e-5001"));


        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9998, new BigDecimal("-0.0001"));
        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9998, new BigDecimal("0.0001"));

        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998);

        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999);


        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, new BigDecimal("-0.001"));
        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, new BigDecimal("0.001"));

        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, new BigDecimal("-0.0001"));
        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, new BigDecimal("0.0001"));

        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998);

        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999);
        checkPercentageOfFirstOverflowException(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999);
    }

    /**
     * Tests for overflow exception while using percentage of 100 operation in model.
     *
     * @see OverflowException
     */
    @Test
    void percentageOf100OverFlowExceptionTests() {
        checkPercentageOf100Overflow(NEG_ONE_DOT_E_MINUS_9999);
        checkPercentageOf100Overflow(NEG_ONE_DOT_E_MINUS_9998);

        checkPercentageOf100Overflow(ONE_DOT_E_MINUS_9998);
        checkPercentageOf100Overflow(ONE_DOT_E_MINUS_9999);
    }

    /**
     * Tests for divide by zero exception in model.
     */
    @Test
    void divideByZeroExceptionTests() {
        checkDivideByZeroException(MIN_VALUE_ON_SCREEN_MINUS_ONE);
        checkDivideByZeroException(MIN_VALUE_ON_SCREEN);
        checkDivideByZeroException(MIN_VALUE_ON_SCREEN_PLUS_ONE);
        checkDivideByZeroException(HALF_MIN_VALUE_ON_SCREEN);
        checkDivideByZeroException(NEG_HUNDRED);
        checkDivideByZeroException(NEG_TEN);
        checkDivideByZeroException(NEG_ONE);

        checkDivideByZeroException(BigDecimal.ONE);
        checkDivideByZeroException(BigDecimal.TEN);
        checkDivideByZeroException(HUNDRED);
        checkDivideByZeroException(HALF_MAX_VALUE_ON_SCREEN);
        checkDivideByZeroException(MAX_VALUE_ON_SCREEN_MINUS_ONE);
        checkDivideByZeroException(MAX_VALUE_ON_SCREEN);
        checkDivideByZeroException(MAX_VALUE_ON_SCREEN_PLUS_ONE);


        checkDivideByZeroException(NEG_ZERO_DOT_17_NINES);
        checkDivideByZeroException(NEG_ZERO_DOT_16_NINES);
        checkDivideByZeroException(NEG_NINETY_NINE_HUNDREDTH);
        checkDivideByZeroException(NEG_NINE_TENTH);
        checkDivideByZeroException(NEG_ONE_TENTH);
        checkDivideByZeroException(NEG_NINE_HUNDREDTH);
        checkDivideByZeroException(NEG_ONE_HUNDREDTH);

        checkDivideByZeroException(ONE_HUNDREDTH);
        checkDivideByZeroException(NINE_HUNDREDTH);
        checkDivideByZeroException(ONE_TENTH);
        checkDivideByZeroException(NINE_TENTH);
        checkDivideByZeroException(NINETY_NINE_HUNDREDTH);
        checkDivideByZeroException(ZERO_DOT_16_NINES);
        checkDivideByZeroException(ZERO_DOT_17_NINES);


        checkDivideByZeroException(NEG_ONE_DOT_E_PLUS_9999);
        checkDivideByZeroException(NEG_ONE_DOT_E_PLUS_9998);

        checkDivideByZeroException(ONE_DOT_E_PLUS_9998);
        checkDivideByZeroException(ONE_DOT_E_PLUS_9999);

        checkDivideByZeroException(NEG_ONE_DOT_E_PLUS_17);
        checkDivideByZeroException(NEG_ONE_DOT_E_PLUS_16);

        checkDivideByZeroException(ONE_DOT_E_PLUS_16);
        checkDivideByZeroException(ONE_DOT_E_PLUS_17);

        checkDivideByZeroException(NEG_ONE_DOT_E_MINUS_9999);
        checkDivideByZeroException(NEG_ONE_DOT_E_MINUS_9998);

        checkDivideByZeroException(ONE_DOT_E_MINUS_9998);
        checkDivideByZeroException(ONE_DOT_E_MINUS_9999);

        checkDivideByZeroException(NEG_ONE_DOT_E_MINUS_17);
        checkDivideByZeroException(NEG_ONE_DOT_E_MINUS_16);

        checkDivideByZeroException(ONE_DOT_E_MINUS_16);
        checkDivideByZeroException(ONE_DOT_E_MINUS_17);
    }

    /**
     * Test for divide zero by zero exception in model.
     */
    @Test
    void divideZeroByZeroExceptionTest() {
        calculation.setFirst(BigDecimal.ZERO);
        calculation.setSecond(BigDecimal.ZERO);
        calculation.setBinaryOperation(DIVIDE);

        try {
            calculation.calculateBinary();
            fail();
        } catch (ArithmeticException e) {
            String exceptionMessage = "Result is undefined";
            assertEquals(exceptionMessage, e.getMessage());
        }
    }

    /**
     * Method for testing binary operations in model.
     *
     * @param first          first value of equation.
     * @param second         second value of equation.
     * @param operation      binary operation to use.
     * @param expectedResult result that should be obtained.
     * @see BinaryOperations
     * @see Calculation
     */
    private void checkBinaryOperation(BigDecimal first, BigDecimal second, BinaryOperations operation, String expectedResult) {
        calculation.setFirst(first);
        calculation.setSecond(second);
        calculation.setBinaryOperation(operation);
        calculation.calculateBinary();

        assertEquals(new BigDecimal(expectedResult), calculation.getResult());

        if (operation == ADD || operation == MULTIPLY) {
            calculation.setFirst(second);
            calculation.setSecond(first);
            calculation.calculateBinary();

            assertEquals(new BigDecimal(expectedResult), calculation.getResult());
        }
    }

    /**
     * Method for testing percentage of first number.
     *
     * @param first          first value.
     * @param second         second value.
     * @param expectedSecond expected big decimal value of second parameter after performing percentage of first operation.
     * @see Calculation
     */
    private void checkPercentageOfFirstOperation(BigDecimal first, BigDecimal second, String expectedSecond) {
        calculation.setFirst(first);
        calculation.setSecond(second);
        calculation.percentageOfFirst();

        assertEquals(new BigDecimal(expectedSecond), calculation.getSecond());

        calculation.setFirst(second);
        calculation.setSecond(first);
        calculation.percentageOfFirst();

        assertEquals(new BigDecimal(expectedSecond), calculation.getSecond());
    }

    /**
     * Method for testing percentage of 100.
     *
     * @param value          big decimal value.
     * @param expectedSecond expected big decimal value of second parameter after performing percentage of 100 operation.
     * @see Calculation
     */
    private void checkPercentageOf100Operation(BigDecimal value, String expectedSecond) {
        calculation.setSecond(value);
        calculation.percentageOf100();

        assertEquals(new BigDecimal(expectedSecond), calculation.getSecond());
    }

    /**
     * Method for testing binary operations in model.
     *
     * @param value          big decimal value.
     * @param operation      unary operation to use.
     * @param expectedResult result that should be obtained.
     * @see UnaryOperations
     * @see Calculation
     */
    private void checkUnaryOperation(BigDecimal value, UnaryOperations operation, String expectedResult) {
        calculation.setFirst(value);
        calculation.calculateUnary(operation);

        assertEquals(new BigDecimal(expectedResult), calculation.getResult());
    }

    /**
     * Method for testing overflow exception while using binary operations in model.
     *
     * @param first     first value of equation.
     * @param second    second value of equation.
     * @param operation binary operation to use.
     * @see OverflowException
     * @see BinaryOperations
     * @see Calculation
     */
    private void checkBinaryOverflowException(BigDecimal first, BigDecimal second, BinaryOperations operation) {
        calculation.setFirst(first);
        calculation.setSecond(second);
        calculation.setBinaryOperation(operation);

        String exceptionMessage = "Overflow";

        try {
            calculation.calculateBinary();
            System.out.println(calculation.getResult());
            fail();
        } catch (OverflowException e) {
            assertEquals(exceptionMessage, e.getMessage());
        }

        if (operation == ADD || operation == MULTIPLY) {
            calculation.setFirst(second);
            calculation.setSecond(first);

            try {
                calculation.calculateBinary();
                fail();
            } catch (OverflowException e) {
                assertEquals(exceptionMessage, e.getMessage());
            }
        }
    }

    /**
     * Method for testing overflow exception while using percentage of first operation in model.
     *
     * @param first  first value.
     * @param second second value.
     * @see OverflowException
     * @see Calculation
     */
    private void checkPercentageOfFirstOverflowException(BigDecimal first, BigDecimal second) {
        calculation.setFirst(first);
        calculation.setSecond(second);

        String exceptionMessage = "Overflow";

        try {
            calculation.percentageOfFirst();
            fail();
        } catch (OverflowException e) {
            assertEquals(exceptionMessage, e.getMessage());
        }

        calculation.setFirst(second);
        calculation.setSecond(first);

        try {
            calculation.percentageOfFirst();
            fail();
        } catch (OverflowException e) {
            assertEquals(exceptionMessage, e.getMessage());
        }
    }

    private void checkUnaryOverflowException() {

    }

    /**
     * Method for testing overflow exception while using percentage of 100 operation in model.
     *
     * @param value big decimal value.
     * @see OverflowException
     * @see Calculation
     */
    private void checkPercentageOf100Overflow(BigDecimal value) {
        calculation.setSecond(value);

        try {
            calculation.percentageOf100();
            fail();
        } catch (OverflowException e) {
            String exceptionMessage = "Overflow";
            assertEquals(exceptionMessage, e.getMessage());
        }
    }

    /**
     * Method for testing divide by zero exception in model.
     * Second value of equation is set as 0. Binary operation is set as DIVIDE.
     *
     * @param value first value of equation.
     * @see Calculation
     */
    private void checkDivideByZeroException(BigDecimal value) {
        calculation.setFirst(value);
        calculation.setSecond(BigDecimal.ZERO);
        calculation.setBinaryOperation(DIVIDE);

        try {
            calculation.calculateBinary();
            fail();
        } catch (ArithmeticException e) {
            String exceptionMessage = "Cannot divide by zero";
            assertEquals(exceptionMessage, e.getMessage());
        }
    }
}