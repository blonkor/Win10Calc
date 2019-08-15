package Model;

import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.implemica.bormashenko.calculator.model.enums.BinaryOperations.*;

class CalculationModelTest {

    private static Calculation calculation;

    private static final BigDecimal MIN_VALUE_ON_SCREEN_MINUS_ONE = new BigDecimal("-10000000000000000");

    private static final BigDecimal MIN_VALUE_ON_SCREEN = new BigDecimal("-9999999999999999");

    private static final BigDecimal MIN_VALUE_ON_SCREEN_PLUS_ONE = new BigDecimal("-9999999999999998");

    private static final BigDecimal HALF_MIN_VALUE_ON_SCREEN = new BigDecimal("-5000000000000000");

    private static final BigDecimal NEG_HUNDRED = new BigDecimal("-100");

    private static final BigDecimal NEG_TEN = new BigDecimal("-10");

    private static final BigDecimal NEG_ONE = new BigDecimal("-1");

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    private static final BigDecimal HALF_MAX_VALUE_ON_SCREEN = new BigDecimal("5000000000000000");

    private static final BigDecimal MAX_VALUE_ON_SCREEN_MINUS_ONE = new BigDecimal("9999999999999998");

    private static final BigDecimal MAX_VALUE_ON_SCREEN = new BigDecimal("9999999999999999");

    private static final BigDecimal MAX_VALUE_ON_SCREEN_PLUS_ONE = new BigDecimal("10000000000000000");

    private static final BigDecimal NEG_ZERO_DOT_17_NINES = new BigDecimal("-0.99999999999999999");

    private static final BigDecimal NEG_ZERO_DOT_16_NINES = new BigDecimal("-0.9999999999999999");

    private static final BigDecimal NEG_NINETY_NINE_HUNDREDTH = new BigDecimal("-0.99");

    private static final BigDecimal NEG_NINE_TENTH = new BigDecimal("-0.9");

    private static final BigDecimal NEG_ONE_TENTH = new BigDecimal("-0.1");

    private static final BigDecimal NEG_NINE_HUNDREDTH = new BigDecimal("-0.09");

    private static final BigDecimal NEG_ONE_HUNDREDTH = new BigDecimal("-0.01");

    private static final BigDecimal ONE_HUNDREDTH = new BigDecimal("0.01");

    private static final BigDecimal NINE_HUNDREDTH = new BigDecimal("0.09");

    private static final BigDecimal ONE_TENTH = new BigDecimal("0.1");

    private static final BigDecimal NINE_TENTH = new BigDecimal("0.9");

    private static final BigDecimal NINETY_NINE_HUNDREDTH = new BigDecimal("0.99");

    private static final BigDecimal ZERO_DOT_16_NINES = new BigDecimal("0.9999999999999999");

    private static final BigDecimal ZERO_DOT_17_NINES = new BigDecimal("0.99999999999999999");

    private static final BigDecimal NEG_ONE_DOT_E_PLUS_9999 = new BigDecimal("-1.E+9999");

    private static final BigDecimal NEG_ONE_DOT_E_PLUS_9998 = new BigDecimal("-1.E+9998");

    private static final BigDecimal ONE_DOT_E_PLUS_9998 = new BigDecimal("1.E+9998");

    private static final BigDecimal ONE_DOT_E_PLUS_9999 = new BigDecimal("1.E+9999");

    private static final BigDecimal NEG_ONE_DOT_E_PLUS_17 = new BigDecimal("-1.E+17");

    private static final BigDecimal NEG_ONE_DOT_E_PLUS_16 = new BigDecimal("-1.E+16");

    private static final BigDecimal ONE_DOT_E_PLUS_16 = new BigDecimal("1.E+16");

    private static final BigDecimal ONE_DOT_E_PLUS_17 = new BigDecimal("1.E+17");

    private static final BigDecimal NEG_ONE_DOT_E_MINUS_9999 = new BigDecimal("-1.E-9999");

    private static final BigDecimal NEG_ONE_DOT_E_MINUS_9998 = new BigDecimal("-1.E-9998");

    private static final BigDecimal ONE_DOT_E_MINUS_9998 = new BigDecimal("1.E-9998");

    private static final BigDecimal ONE_DOT_E_MINUS_9999 = new BigDecimal("1.E-9999");

    private static final BigDecimal NEG_ONE_DOT_E_MINUS_17 = new BigDecimal("-1.E-17");

    private static final BigDecimal NEG_ONE_DOT_E_MINUS_16 = new BigDecimal("-1.E-16");

    private static final BigDecimal ONE_DOT_E_MINUS_16 = new BigDecimal("1.E-16");

    private static final BigDecimal ONE_DOT_E_MINUS_17 = new BigDecimal("1.E-17");

    @BeforeAll
    static void setUpObject() {
        calculation = new Calculation();
    }

    @Test
    void addOperationTests() {
        //integers only
        //first is -10000000000000000
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-20000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, ADD, "-19999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-19999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, ADD, "-15000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, ADD, "-10000000000000100");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, ADD, "-10000000000000010");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, ADD, "-10000000000000001");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, ADD, "-10000000000000000");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, ADD, "-9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, ADD, "-9999999999999990");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, ADD, "-9999999999999900");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, ADD, "-5000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-2");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, ADD, "-1");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "0");

        //first is -9999999999999999
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, ADD, "-19999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-19999999999999997");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, ADD, "-14999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, ADD, "-10000000000000099");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, ADD, "-10000000000000009");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, ADD, "-10000000000000000");

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
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, ADD, "-10000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, ADD, "-5000000000000100");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, ADD, "-5000000000000010");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, ADD, "-5000000000000001");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, ADD, "-5000000000000000");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, ADD, "-4999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, ADD, "-4999999999999990");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, ADD, "-4999999999999900");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "0");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "4999999999999998");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, ADD, "4999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "5000000000000000");

        //first is -100
        checkBinaryOperation(NEG_HUNDRED, NEG_HUNDRED, ADD, "-200");
        checkBinaryOperation(NEG_HUNDRED, NEG_TEN, ADD, "-110");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE, ADD, "-101");

        checkBinaryOperation(NEG_HUNDRED, BigDecimal.ZERO, ADD, "-100");

        checkBinaryOperation(NEG_HUNDRED, BigDecimal.ONE, ADD, "-99");
        checkBinaryOperation(NEG_HUNDRED, BigDecimal.TEN, ADD, "-90");
        checkBinaryOperation(NEG_HUNDRED, HUNDRED, ADD, "0");
        checkBinaryOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, ADD, "4999999999999900");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999898");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN, ADD, "9999999999999899");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9999999999999900");

        //first is -10
        checkBinaryOperation(NEG_TEN, NEG_TEN, ADD, "-20");
        checkBinaryOperation(NEG_TEN, NEG_ONE, ADD, "-11");

        checkBinaryOperation(NEG_TEN, BigDecimal.ZERO, ADD, "-10");

        checkBinaryOperation(NEG_TEN, BigDecimal.ONE, ADD, "-9");
        checkBinaryOperation(NEG_TEN, BigDecimal.TEN, ADD, "0");
        checkBinaryOperation(NEG_TEN, HUNDRED, ADD, "90");
        checkBinaryOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "4999999999999990");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999988");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN, ADD, "9999999999999989");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9999999999999990");

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
        checkBinaryOperation(BigDecimal.ZERO, BigDecimal.TEN, ADD, "10");
        checkBinaryOperation(BigDecimal.ZERO, HUNDRED, ADD, "100");
        checkBinaryOperation(BigDecimal.ZERO, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999998");
        checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN, ADD, "9999999999999999");
        checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000000");

        //first is 1
        checkBinaryOperation(BigDecimal.ONE, BigDecimal.ONE, ADD, "2");
        checkBinaryOperation(BigDecimal.ONE, BigDecimal.TEN, ADD, "11");
        checkBinaryOperation(BigDecimal.ONE, HUNDRED, ADD, "101");
        checkBinaryOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000001");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999999");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN, ADD, "10000000000000000");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000001");

        //first is 10
        checkBinaryOperation(BigDecimal.TEN, BigDecimal.TEN, ADD, "20");
        checkBinaryOperation(BigDecimal.TEN, HUNDRED, ADD, "110");
        checkBinaryOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000010");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "10000000000000008");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN, ADD, "10000000000000009");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000010");

        //first is 100
        checkBinaryOperation(HUNDRED, HUNDRED, ADD, "200");
        checkBinaryOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000100");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "10000000000000098");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN, ADD, "10000000000000099");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000100");

        //first is 5000000000000000
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, ADD, "10000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "14999999999999998");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, ADD, "14999999999999999");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "15000000000000000");

        //first is 9999999999999998
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "19999999999999996");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, ADD, "19999999999999997");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "19999999999999998");

        //first is 9999999999999999
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, ADD, "19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "19999999999999999");

        //first is 10000000000000000
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "20000000000000000");


        //integer and decimal
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


        //decimals only
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
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, ADD, "0.00000000000000000");

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
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, ADD, "0.0000000000000000");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, ADD, "0.00000000000000009");

        //first is -0.99
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, ADD, "-1.98");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, ADD, "-1.89");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, ADD, "-1.09");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, ADD, "-1.08");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, ADD, "-1.00");

        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, ADD, "-0.98");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, ADD, "-0.90");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, ADD, "-0.89");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, ADD, "-0.09");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "0.00");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "0.0099999999999999");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "0.00999999999999999");

        //first is -0.9
        checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, ADD, "-1.8");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, ADD, "-1.0");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, ADD, "-0.99");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, ADD, "-0.91");

        checkBinaryOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, ADD, "-0.89");
        checkBinaryOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, ADD, "-0.81");
        checkBinaryOperation(NEG_NINE_TENTH, ONE_TENTH, ADD, "-0.8");
        checkBinaryOperation(NEG_NINE_TENTH, NINE_TENTH, ADD, "0.0");
        checkBinaryOperation(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, ADD, "0.09");
        checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_16_NINES, ADD, "0.0999999999999999");
        checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_17_NINES, ADD, "0.09999999999999999");

        //first is -0.1
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, ADD, "-0.2");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_HUNDREDTH, ADD, "-0.19");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, ADD, "-0.11");

        checkBinaryOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, ADD, "-0.09");
        checkBinaryOperation(NEG_ONE_TENTH, NINE_HUNDREDTH, ADD, "-0.01");
        checkBinaryOperation(NEG_ONE_TENTH, ONE_TENTH, ADD, "0.0");
        checkBinaryOperation(NEG_ONE_TENTH, NINE_TENTH, ADD, "0.8");
        checkBinaryOperation(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, ADD, "0.89");
        checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_16_NINES, ADD, "0.8999999999999999");
        checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_17_NINES, ADD, "0.89999999999999999");

        //first is -0.09
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, ADD, "-0.18");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, ADD, "-0.10");

        checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, ADD, "-0.08");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, ADD, "0.00");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, ADD, "0.01");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, ADD, "0.81");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "0.90");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "0.9099999999999999");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "0.90999999999999999");

        //first is -0.01
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, ADD, "-0.02");

        checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, ADD, "0.00");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, ADD, "0.08");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, ADD, "0.09");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_TENTH, ADD, "0.89");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "0.98");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, ADD, "0.9899999999999999");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_17_NINES, ADD, "0.98999999999999999");

        //first is 0.01
        checkBinaryOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, ADD, "0.02");
        checkBinaryOperation(ONE_HUNDREDTH, NINE_HUNDREDTH, ADD, "0.10");
        checkBinaryOperation(ONE_HUNDREDTH, ONE_TENTH, ADD, "0.11");
        checkBinaryOperation(ONE_HUNDREDTH, NINE_TENTH, ADD, "0.91");
        checkBinaryOperation(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, ADD, "1.00");
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
        checkBinaryOperation(ONE_TENTH, NINE_TENTH, ADD, "1.0");
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


        //engineer numbers
        //with engineer numbers
        //first is -1.E+9999
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, ADD, "-2.E+9999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, ADD, "-1.1E+9999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, ADD, "-9.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, ADD, "0.E+9999");

        //first is -1.E+9998
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, ADD, "-2.E+9998");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, ADD, "0.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, ADD, "9.E+9998");

        //first is 1.E+9998
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, ADD, "2.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, ADD, "1.1E+9999");

        //first is 1.E+9999
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, ADD, "2.E+9999");

        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, ADD, "-2.E+17");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, ADD, "-1.1E+17");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, ADD, "-9.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, ADD, "0.E+17");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, ADD, "-2.E+16");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, ADD, "0.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, ADD, "9.E+16");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, ADD, "2.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, ADD, "1.1E+17");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, ADD, "2.E+17");

        //first is -1.E-9999
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, ADD, "-2.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, ADD, "-1.1E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, ADD, "9.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, ADD, "0.E-9999");

        //first is -1.E-9998
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, ADD, "-2E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, ADD, "0.E-9998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, ADD, "-9.E-9999");

        //first is 1.E-9998
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, ADD, "2.E-9998");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, ADD, "1.1E-9998");

        //first is 1.E-9999
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, ADD, "2.E-9999");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, ADD, "-2.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, ADD, "-1.1E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, ADD, "9.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, ADD, "0.E-17");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, ADD, "-2E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, ADD, "0.E-16");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, ADD, "-9.E-17");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, ADD, "2.E-16");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, ADD, "1.1E-16");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, ADD, "2.E-17");


        //with integers
        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-110000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, ADD, "-109999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-109999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "-105000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, ADD, "-100000000000000100");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, ADD, "-100000000000000010");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, ADD, "-100000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, ADD, "-100000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, ADD, "-99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, ADD, "-99999999999999990");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, ADD, "-99999999999999900");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "-95000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-90000000000000002");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, ADD, "-90000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-90000000000000000");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-20000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, ADD, "-19999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-19999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "-15000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, ADD, "-10000000000000100");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, ADD, "-10000000000000010");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, ADD, "-10000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, ADD, "-10000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, ADD, "-9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, ADD, "-9999999999999990");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, ADD, "-9999999999999900");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "-5000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-2");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, ADD, "-1");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "0");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "0");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, ADD, "1");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "2");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "5000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, ADD, "9999999999999900");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, ADD, "9999999999999990");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, ADD, "9999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, ADD, "10000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, ADD, "10000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, ADD, "10000000000000010");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, ADD, "10000000000000100");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "15000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "19999999999999998");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, ADD, "19999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "20000000000000000");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "90000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, ADD, "90000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "90000000000000002");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "95000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, ADD, "99999999999999900");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, ADD, "99999999999999990");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, ADD, "99999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, ADD, "100000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, ADD, "100000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, ADD, "100000000000000010");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, ADD, "100000000000000100");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "105000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "109999999999999998");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, ADD, "109999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "110000000000000000");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-10000000000000000.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999999.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999998.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "-5000000000000000.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, ADD, "-100.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, ADD, "-10.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, ADD, "-1.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, ADD, "-1.E-17");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, ADD, "0.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, ADD, "9.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, ADD, "99.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "4999999999999999.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999997.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, ADD, "9999999999999998.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9999999999999999.99999999999999999");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-10000000000000000.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999999.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999998.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "-5000000000000000.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, ADD, "-100.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, ADD, "-10.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, ADD, "-1.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, ADD, "-1.E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, ADD, "0.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, ADD, "9.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, ADD, "99.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "4999999999999999.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999997.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, ADD, "9999999999999998.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "9999999999999999.9999999999999999");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-9999999999999999.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999998.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999997.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, ADD, "-4999999999999999.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, ADD, "-99.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, ADD, "-9.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, ADD, "-0.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, ADD, "1.E-16");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, ADD, "1.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, ADD, "10.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, ADD, "100.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000000.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999998.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, ADD, "9999999999999999.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000000.0000000000000001");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, ADD, "-9999999999999999.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, ADD, "-9999999999999998.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, ADD, "-9999999999999997.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, ADD, "-4999999999999999.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, ADD, "-99.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, ADD, "-9.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, ADD, "-0.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, ADD, "1.E-17");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, ADD, "1.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, ADD, "10.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, ADD, "100.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, ADD, "5000000000000000.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, ADD, "9999999999999998.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, ADD, "9999999999999999.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, ADD, "10000000000000000.00000000000000001");


        //with decimals
        //first is -1.E+17
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

        //first is -1.E+16
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

        //first is 1.E+16
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

        //first is 1.E+17
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

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, ADD, "-1.00000000000000000");
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

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, ADD, "-1.00000000000000009");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, ADD, "-1.0000000000000000");
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

        //first is 1.E-16
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
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, ADD, "1.0000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, ADD, "1.00000000000000009");

        //first is 1.E-17
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
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, ADD, "1.00000000000000000");


        //several random values
        checkBinaryOperation(new BigDecimal("197"), new BigDecimal("8763"), ADD, "8960");
        checkBinaryOperation(new BigDecimal("36346"), new BigDecimal("62"), ADD, "36408");
        checkBinaryOperation(new BigDecimal("62"), new BigDecimal("-542"), ADD, "-480");
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

    @Test
    void subtractOperationTests() {
        //integers only
        //first is -10000000000000000
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-15000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, SUBTRACT, "-10000000000000100");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, SUBTRACT, "-10000000000000010");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, SUBTRACT, "-10000000000000001");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, SUBTRACT, "-10000000000000000");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, SUBTRACT, "-9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, SUBTRACT, "-9999999999999990");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, SUBTRACT, "-9999999999999900");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-2");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "-1");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "0");

        //first is -9999999999999999
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999997");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-14999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "-10000000000000099");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "-10000000000000009");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "-10000000000000000");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "-9999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "-9999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "-9999999999999989");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "-9999999999999899");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-1");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "1");

        //first is -9999999999999998
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-14999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, SUBTRACT, "-10000000000000098");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, SUBTRACT, "-10000000000000008");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, SUBTRACT, "-9999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, SUBTRACT, "-9999999999999998");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, SUBTRACT, "-9999999999999997");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, SUBTRACT, "-9999999999999988");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, SUBTRACT, "-9999999999999898");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "1");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "2");

        //first is -5000000000000000
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "-5000000000000100");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "-5000000000000010");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "-5000000000000001");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "-5000000000000000");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "-4999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "-4999999999999990");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "-4999999999999900");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "0");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "4999999999999998");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "5000000000000000");

        //first is -100
        checkBinaryOperation(NEG_HUNDRED, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(NEG_HUNDRED, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(NEG_HUNDRED, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(NEG_HUNDRED, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(NEG_HUNDRED, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(NEG_HUNDRED, NEG_TEN, SUBTRACT, "-110");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE, SUBTRACT, "-101");

        checkBinaryOperation(NEG_HUNDRED, BigDecimal.ZERO, SUBTRACT, "-100");

        checkBinaryOperation(NEG_HUNDRED, BigDecimal.ONE, SUBTRACT, "-99");
        checkBinaryOperation(NEG_HUNDRED, BigDecimal.TEN, SUBTRACT, "-90");
        checkBinaryOperation(NEG_HUNDRED, HUNDRED, SUBTRACT, "0");
        checkBinaryOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999900");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999898");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999899");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999900");

        //first is -10
        checkBinaryOperation(NEG_TEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(NEG_TEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(NEG_TEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(NEG_TEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(NEG_TEN, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(NEG_TEN, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(NEG_TEN, NEG_ONE, SUBTRACT, "-11");

        checkBinaryOperation(NEG_TEN, BigDecimal.ZERO, SUBTRACT, "-10");

        checkBinaryOperation(NEG_TEN, BigDecimal.ONE, SUBTRACT, "-9");
        checkBinaryOperation(NEG_TEN, BigDecimal.TEN, SUBTRACT, "0");
        checkBinaryOperation(NEG_TEN, HUNDRED, SUBTRACT, "90");
        checkBinaryOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999990");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999988");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999989");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999990");

        //first is -1
        checkBinaryOperation(NEG_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(NEG_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(NEG_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(NEG_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(NEG_ONE, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(NEG_ONE, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(NEG_ONE, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(NEG_ONE, BigDecimal.ZERO, SUBTRACT, "-1");

        checkBinaryOperation(NEG_ONE, BigDecimal.ONE, SUBTRACT, "0");
        checkBinaryOperation(NEG_ONE, BigDecimal.TEN, SUBTRACT, "9");
        checkBinaryOperation(NEG_ONE, HUNDRED, SUBTRACT, "99");
        checkBinaryOperation(NEG_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999");
        checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997");
        checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998");
        checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999");

        //first is 0
        checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(BigDecimal.ZERO, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(BigDecimal.ZERO, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(BigDecimal.ZERO, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(BigDecimal.ZERO, BigDecimal.ONE, SUBTRACT, "1");
        checkBinaryOperation(BigDecimal.ZERO, BigDecimal.TEN, SUBTRACT, "10");
        checkBinaryOperation(BigDecimal.ZERO, HUNDRED, SUBTRACT, "100");
        checkBinaryOperation(BigDecimal.ZERO, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998");
        checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999");
        checkBinaryOperation(BigDecimal.ZERO, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000");

        //first is 1
        checkBinaryOperation(BigDecimal.ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(BigDecimal.ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(BigDecimal.ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(BigDecimal.ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(BigDecimal.ONE, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(BigDecimal.ONE, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(BigDecimal.ONE, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(BigDecimal.ONE, BigDecimal.ONE, SUBTRACT, "2");
        checkBinaryOperation(BigDecimal.ONE, BigDecimal.TEN, SUBTRACT, "11");
        checkBinaryOperation(BigDecimal.ONE, HUNDRED, SUBTRACT, "101");
        checkBinaryOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000001");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999999");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "10000000000000000");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000001");

        //first is 10
        checkBinaryOperation(BigDecimal.TEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(BigDecimal.TEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(BigDecimal.TEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(BigDecimal.TEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(BigDecimal.TEN, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(BigDecimal.TEN, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(BigDecimal.TEN, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(BigDecimal.TEN, BigDecimal.ONE, SUBTRACT, "2");
        checkBinaryOperation(BigDecimal.TEN, BigDecimal.TEN, SUBTRACT, "20");
        checkBinaryOperation(BigDecimal.TEN, HUNDRED, SUBTRACT, "110");
        checkBinaryOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000010");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000008");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "10000000000000009");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000010");

        //first is 100
        checkBinaryOperation(HUNDRED, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(HUNDRED, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(HUNDRED, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(HUNDRED, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(HUNDRED, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(HUNDRED, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(HUNDRED, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(HUNDRED, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(HUNDRED, BigDecimal.ONE, SUBTRACT, "2");
        checkBinaryOperation(HUNDRED, BigDecimal.TEN, SUBTRACT, "20");
        checkBinaryOperation(HUNDRED, HUNDRED, SUBTRACT, "200");
        checkBinaryOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000100");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "10000000000000098");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN, SUBTRACT, "10000000000000099");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000100");

        //first is 5000000000000000
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "2");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "20");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "200");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "10000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "14999999999999998");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "14999999999999999");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "15000000000000000");

        //first is 9999999999999998
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, SUBTRACT, "2");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, SUBTRACT, "20");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, SUBTRACT, "200");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "10000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "19999999999999996");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "19999999999999997");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "19999999999999998");

        //first is 9999999999999999
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.ONE, SUBTRACT, "2");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, BigDecimal.TEN, SUBTRACT, "20");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, HUNDRED, SUBTRACT, "200");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "10000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "19999999999999996");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, SUBTRACT, "19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "19999999999999999");

        //first is 10000000000000000
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999996");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, SUBTRACT, "-200");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, SUBTRACT, "-20");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, SUBTRACT, "-2");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, SUBTRACT, "0");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, SUBTRACT, "2");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, SUBTRACT, "20");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, SUBTRACT, "200");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "10000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "19999999999999996");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, SUBTRACT, "19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "20000000000000000");


        //integer and decimal
        //first is -10000000000000000 (and vice versa)
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-10000000000000000.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.99999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-10000000000000000.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.9999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-10000000000000000.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.99");

        checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.9");
        checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.9");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, SUBTRACT, "-10000000000000000.1");
        checkBinaryOperation(NEG_ONE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.1");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "-10000000000000000.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.09");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "-10000000000000000.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.01");


        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, SUBTRACT, "-9999999999999999.99");
        checkBinaryOperation(ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.99");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.91");
        checkBinaryOperation(NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.91");

        checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.9");
        checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.9");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, SUBTRACT, "-9999999999999999.1");
        checkBinaryOperation(NINE_TENTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.1");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.01");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.01");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999999.0000000000000001");
        checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.0000000000000001");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999999.00000000000000001");
        checkBinaryOperation(ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.00000000000000001");

        //first is -9999999999999999 (and vice versa)
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999999.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.99999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999999.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.9999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.99");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "-9999999999999999.9");
        checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.9");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "-9999999999999999.1");
        checkBinaryOperation(NEG_ONE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.1");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "-9999999999999999.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.09");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "-9999999999999999.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.01");


        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "-9999999999999998.99");
        checkBinaryOperation(ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.99");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.91");
        checkBinaryOperation(NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.91");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "-9999999999999998.9");
        checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.9");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "-9999999999999998.1");
        checkBinaryOperation(NINE_TENTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.1");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.01");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.01");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999998.0000000000000001");
        checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.0000000000000001");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999998.00000000000000001");
        checkBinaryOperation(ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.00000000000000001");

        //first is -9999999999999998 (and vice versa)
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999998.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.99999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999998.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.9999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.99");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, SUBTRACT, "-9999999999999998.9");
        checkBinaryOperation(NEG_NINE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.9");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, SUBTRACT, "-9999999999999998.1");
        checkBinaryOperation(NEG_ONE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.1");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "-9999999999999998.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.09");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "-9999999999999998.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.01");


        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, SUBTRACT, "-9999999999999997.99");
        checkBinaryOperation(ONE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.99");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, SUBTRACT, "-9999999999999997.91");
        checkBinaryOperation(NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.91");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, SUBTRACT, "-9999999999999997.9");
        checkBinaryOperation(ONE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.9");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, SUBTRACT, "-9999999999999997.1");
        checkBinaryOperation(NINE_TENTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.1");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "-9999999999999997.01");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.01");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "-9999999999999997.0000000000000001");
        checkBinaryOperation(ZERO_DOT_16_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.0000000000000001");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "-9999999999999997.00000000000000001");
        checkBinaryOperation(ZERO_DOT_17_NINES, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.00000000000000001");

        //first is -5000000000000000 (and vice versa)
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-5000000000000000.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.99999999999999999");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-5000000000000000.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.9999999999999999");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-5000000000000000.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.99");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "-5000000000000000.9");
        checkBinaryOperation(NEG_NINE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.9");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "-5000000000000000.1");
        checkBinaryOperation(NEG_ONE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.1");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "-5000000000000000.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.09");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "-5000000000000000.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.01");


        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "-4999999999999999.99");
        checkBinaryOperation(ONE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.99");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "-4999999999999999.91");
        checkBinaryOperation(NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.91");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "-4999999999999999.9");
        checkBinaryOperation(ONE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.9");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "-4999999999999999.1");
        checkBinaryOperation(NINE_TENTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.1");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "-4999999999999999.01");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.01");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "-4999999999999999.0000000000000001");
        checkBinaryOperation(ZERO_DOT_16_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.0000000000000001");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "-4999999999999999.00000000000000001");
        checkBinaryOperation(ZERO_DOT_17_NINES, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.00000000000000001");

        //first is -100 (and vice versa)
        checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-100.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_HUNDRED, SUBTRACT, "-100.99999999999999999");

        checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-100.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_HUNDRED, SUBTRACT, "-100.9999999999999999");

        checkBinaryOperation(NEG_HUNDRED, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-100.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "-100.99");

        checkBinaryOperation(NEG_HUNDRED, NEG_NINE_TENTH, SUBTRACT, "-100.9");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_HUNDRED, SUBTRACT, "-100.9");

        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_TENTH, SUBTRACT, "-100.1");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_HUNDRED, SUBTRACT, "-100.1");

        checkBinaryOperation(NEG_HUNDRED, NEG_NINE_HUNDREDTH, SUBTRACT, "-100.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "-100.09");

        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_HUNDREDTH, SUBTRACT, "-100.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "-100.01");


        checkBinaryOperation(NEG_HUNDRED, ONE_HUNDREDTH, SUBTRACT, "-99.99");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "-99.99");

        checkBinaryOperation(NEG_HUNDRED, NINE_HUNDREDTH, SUBTRACT, "-99.91");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "-99.91");

        checkBinaryOperation(NEG_HUNDRED, ONE_TENTH, SUBTRACT, "-99.9");
        checkBinaryOperation(ONE_TENTH, NEG_HUNDRED, SUBTRACT, "-99.9");

        checkBinaryOperation(NEG_HUNDRED, NINE_TENTH, SUBTRACT, "-99.1");
        checkBinaryOperation(NINE_TENTH, NEG_HUNDRED, SUBTRACT, "-99.1");

        checkBinaryOperation(NEG_HUNDRED, NINETY_NINE_HUNDREDTH, SUBTRACT, "-99.01");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_HUNDRED, SUBTRACT, "-99.01");

        checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_16_NINES, SUBTRACT, "-99.0000000000000001");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_HUNDRED, SUBTRACT, "-99.0000000000000001");

        checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_17_NINES, SUBTRACT, "-99.00000000000000001");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_HUNDRED, SUBTRACT, "-99.00000000000000001");

        //first is -10 (and vice versa)
        checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-10.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_TEN, SUBTRACT, "-10.99999999999999999");

        checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-10.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_TEN, SUBTRACT, "-10.9999999999999999");

        checkBinaryOperation(NEG_TEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-10.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "-10.99");

        checkBinaryOperation(NEG_TEN, NEG_NINE_TENTH, SUBTRACT, "-10.9");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_TEN, SUBTRACT, "-10.9");

        checkBinaryOperation(NEG_TEN, NEG_ONE_TENTH, SUBTRACT, "-10.1");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_TEN, SUBTRACT, "-10.1");

        checkBinaryOperation(NEG_TEN, NEG_NINE_HUNDREDTH, SUBTRACT, "-10.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "-10.09");

        checkBinaryOperation(NEG_TEN, NEG_ONE_HUNDREDTH, SUBTRACT, "-10.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_TEN, SUBTRACT, "-10.01");


        checkBinaryOperation(NEG_TEN, ONE_HUNDREDTH, SUBTRACT, "-9.99");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_TEN, SUBTRACT, "-9.99");

        checkBinaryOperation(NEG_TEN, NINE_HUNDREDTH, SUBTRACT, "-9.91");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "-9.91");

        checkBinaryOperation(NEG_TEN, ONE_TENTH, SUBTRACT, "-9.9");
        checkBinaryOperation(ONE_TENTH, NEG_TEN, SUBTRACT, "-9.9");

        checkBinaryOperation(NEG_TEN, NINE_TENTH, SUBTRACT, "-9.1");
        checkBinaryOperation(NINE_TENTH, NEG_TEN, SUBTRACT, "-9.1");

        checkBinaryOperation(NEG_TEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "-9.01");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_TEN, SUBTRACT, "-9.01");

        checkBinaryOperation(NEG_TEN, ZERO_DOT_16_NINES, SUBTRACT, "-9.0000000000000001");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_TEN, SUBTRACT, "-9.0000000000000001");

        checkBinaryOperation(NEG_TEN, ZERO_DOT_17_NINES, SUBTRACT, "-9.00000000000000001");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_TEN, SUBTRACT, "-9.00000000000000001");

        //first is -1 (and vice versa)
        checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE, SUBTRACT, "-1.99999999999999999");

        checkBinaryOperation(NEG_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE, SUBTRACT, "-1.9999999999999999");

        checkBinaryOperation(NEG_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "-1.99");

        checkBinaryOperation(NEG_ONE, NEG_NINE_TENTH, SUBTRACT, "-1.9");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE, SUBTRACT, "-1.9");

        checkBinaryOperation(NEG_ONE, NEG_ONE_TENTH, SUBTRACT, "-1.1");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE, SUBTRACT, "-1.1");

        checkBinaryOperation(NEG_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "-1.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "-1.09");

        checkBinaryOperation(NEG_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "-1.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE, SUBTRACT, "-1.01");


        checkBinaryOperation(NEG_ONE, ONE_HUNDREDTH, SUBTRACT, "-0.99");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE, SUBTRACT, "-0.99");

        checkBinaryOperation(NEG_ONE, NINE_HUNDREDTH, SUBTRACT, "-0.91");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "-0.91");

        checkBinaryOperation(NEG_ONE, ONE_TENTH, SUBTRACT, "-0.9");
        checkBinaryOperation(ONE_TENTH, NEG_ONE, SUBTRACT, "-0.9");

        checkBinaryOperation(NEG_ONE, NINE_TENTH, SUBTRACT, "-0.1");
        checkBinaryOperation(NINE_TENTH, NEG_ONE, SUBTRACT, "-0.1");

        checkBinaryOperation(NEG_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.01");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE, SUBTRACT, "-0.01");

        checkBinaryOperation(NEG_ONE, ZERO_DOT_16_NINES, SUBTRACT, "-0.0000000000000001");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE, SUBTRACT, "-0.0000000000000001");

        checkBinaryOperation(NEG_ONE, ZERO_DOT_17_NINES, SUBTRACT, "-0.00000000000000001");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE, SUBTRACT, "-0.00000000000000001");

        //first is 0 (and vice versa)
        checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-0.99999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.ZERO, SUBTRACT, "-0.99999999999999999");

        checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-0.9999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.ZERO, SUBTRACT, "-0.9999999999999999");

        checkBinaryOperation(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.99");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "-0.99");

        checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_TENTH, SUBTRACT, "-0.9");
        checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.ZERO, SUBTRACT, "-0.9");

        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_TENTH, SUBTRACT, "-0.1");
        checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.ZERO, SUBTRACT, "-0.1");

        checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.09");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "-0.09");

        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.01");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "-0.01");


        checkBinaryOperation(BigDecimal.ZERO, ONE_HUNDREDTH, SUBTRACT, "0.01");
        checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "0.01");

        checkBinaryOperation(BigDecimal.ZERO, NINE_HUNDREDTH, SUBTRACT, "0.09");
        checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "0.09");

        checkBinaryOperation(BigDecimal.ZERO, ONE_TENTH, SUBTRACT, "0.1");
        checkBinaryOperation(ONE_TENTH, BigDecimal.ZERO, SUBTRACT, "0.1");

        checkBinaryOperation(BigDecimal.ZERO, NINE_TENTH, SUBTRACT, "0.9");
        checkBinaryOperation(NINE_TENTH, BigDecimal.ZERO, SUBTRACT, "0.9");

        checkBinaryOperation(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.ZERO, SUBTRACT, "0.99");

        checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_16_NINES, SUBTRACT, "0.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.ZERO, SUBTRACT, "0.9999999999999999");

        checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_17_NINES, SUBTRACT, "0.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.ZERO, SUBTRACT, "0.99999999999999999");

        //first is 1 (and vice versa)
        checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "0.00000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.ONE, SUBTRACT, "0.00000000000000001");

        checkBinaryOperation(BigDecimal.ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "0.0000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.ONE, SUBTRACT, "0.0000000000000001");

        checkBinaryOperation(BigDecimal.ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "0.01");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "0.01");

        checkBinaryOperation(BigDecimal.ONE, NEG_NINE_TENTH, SUBTRACT, "0.1");
        checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.ONE, SUBTRACT, "0.1");

        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_TENTH, SUBTRACT, "0.9");
        checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.ONE, SUBTRACT, "0.9");

        checkBinaryOperation(BigDecimal.ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "0.91");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "0.91");

        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "0.99");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "0.99");


        checkBinaryOperation(BigDecimal.ONE, ONE_HUNDREDTH, SUBTRACT, "1.01");
        checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "1.01");

        checkBinaryOperation(BigDecimal.ONE, NINE_HUNDREDTH, SUBTRACT, "1.09");
        checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "1.09");

        checkBinaryOperation(BigDecimal.ONE, ONE_TENTH, SUBTRACT, "1.1");
        checkBinaryOperation(ONE_TENTH, BigDecimal.ONE, SUBTRACT, "1.1");

        checkBinaryOperation(BigDecimal.ONE, NINE_TENTH, SUBTRACT, "1.9");
        checkBinaryOperation(NINE_TENTH, BigDecimal.ONE, SUBTRACT, "1.9");

        checkBinaryOperation(BigDecimal.ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.ONE, SUBTRACT, "1.99");

        checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_16_NINES, SUBTRACT, "1.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.ONE, SUBTRACT, "1.9999999999999999");

        checkBinaryOperation(BigDecimal.ONE, ZERO_DOT_17_NINES, SUBTRACT, "1.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.ONE, SUBTRACT, "1.99999999999999999");

        //first is 10 (and vice versa)
        checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "9.00000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, BigDecimal.TEN, SUBTRACT, "9.00000000000000001");

        checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "9.0000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, BigDecimal.TEN, SUBTRACT, "9.0000000000000001");

        checkBinaryOperation(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "9.01");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "9.01");

        checkBinaryOperation(BigDecimal.TEN, NEG_NINE_TENTH, SUBTRACT, "9.1");
        checkBinaryOperation(NEG_NINE_TENTH, BigDecimal.TEN, SUBTRACT, "9.1");

        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_TENTH, SUBTRACT, "9.9");
        checkBinaryOperation(NEG_ONE_TENTH, BigDecimal.TEN, SUBTRACT, "9.9");

        checkBinaryOperation(BigDecimal.TEN, NEG_NINE_HUNDREDTH, SUBTRACT, "9.91");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "9.91");

        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_HUNDREDTH, SUBTRACT, "9.99");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "9.99");


        checkBinaryOperation(BigDecimal.TEN, ONE_HUNDREDTH, SUBTRACT, "10.01");
        checkBinaryOperation(ONE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "10.01");

        checkBinaryOperation(BigDecimal.TEN, NINE_HUNDREDTH, SUBTRACT, "10.09");
        checkBinaryOperation(NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "10.09");

        checkBinaryOperation(BigDecimal.TEN, ONE_TENTH, SUBTRACT, "10.1");
        checkBinaryOperation(ONE_TENTH, BigDecimal.TEN, SUBTRACT, "10.1");

        checkBinaryOperation(BigDecimal.TEN, NINE_TENTH, SUBTRACT, "10.9");
        checkBinaryOperation(NINE_TENTH, BigDecimal.TEN, SUBTRACT, "10.9");

        checkBinaryOperation(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "10.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, BigDecimal.TEN, SUBTRACT, "10.99");

        checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_16_NINES, SUBTRACT, "10.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, BigDecimal.TEN, SUBTRACT, "10.9999999999999999");

        checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_17_NINES, SUBTRACT, "10.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, BigDecimal.TEN, SUBTRACT, "10.99999999999999999");

        //first is 100 (and vice versa)
        checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_17_NINES, SUBTRACT, "99.00000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HUNDRED, SUBTRACT, "99.00000000000000001");

        checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_16_NINES, SUBTRACT, "99.0000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HUNDRED, SUBTRACT, "99.0000000000000001");

        checkBinaryOperation(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "99.01");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HUNDRED, SUBTRACT, "99.01");

        checkBinaryOperation(HUNDRED, NEG_NINE_TENTH, SUBTRACT, "99.1");
        checkBinaryOperation(NEG_NINE_TENTH, HUNDRED, SUBTRACT, "99.1");

        checkBinaryOperation(HUNDRED, NEG_ONE_TENTH, SUBTRACT, "99.9");
        checkBinaryOperation(NEG_ONE_TENTH, HUNDRED, SUBTRACT, "99.9");

        checkBinaryOperation(HUNDRED, NEG_NINE_HUNDREDTH, SUBTRACT, "99.91");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, HUNDRED, SUBTRACT, "99.91");

        checkBinaryOperation(HUNDRED, NEG_ONE_HUNDREDTH, SUBTRACT, "99.99");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, HUNDRED, SUBTRACT, "99.99");


        checkBinaryOperation(HUNDRED, ONE_HUNDREDTH, SUBTRACT, "100.01");
        checkBinaryOperation(ONE_HUNDREDTH, HUNDRED, SUBTRACT, "100.01");

        checkBinaryOperation(HUNDRED, NINE_HUNDREDTH, SUBTRACT, "100.09");
        checkBinaryOperation(NINE_HUNDREDTH, HUNDRED, SUBTRACT, "100.09");

        checkBinaryOperation(HUNDRED, ONE_TENTH, SUBTRACT, "100.1");
        checkBinaryOperation(ONE_TENTH, HUNDRED, SUBTRACT, "100.1");

        checkBinaryOperation(HUNDRED, NINE_TENTH, SUBTRACT, "100.9");
        checkBinaryOperation(NINE_TENTH, HUNDRED, SUBTRACT, "100.9");

        checkBinaryOperation(HUNDRED, NINETY_NINE_HUNDREDTH, SUBTRACT, "100.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, HUNDRED, SUBTRACT, "100.99");

        checkBinaryOperation(HUNDRED, ZERO_DOT_16_NINES, SUBTRACT, "100.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, HUNDRED, SUBTRACT, "100.9999999999999999");

        checkBinaryOperation(HUNDRED, ZERO_DOT_17_NINES, SUBTRACT, "100.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, HUNDRED, SUBTRACT, "100.99999999999999999");

        //first is 5000000000000000 (and vice versa)
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "4999999999999999.00000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.00000000000000001");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "4999999999999999.0000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.0000000000000001");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "4999999999999999.01");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.01");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "4999999999999999.1");
        checkBinaryOperation(NEG_NINE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.1");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "4999999999999999.9");
        checkBinaryOperation(NEG_ONE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.9");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "4999999999999999.91");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.91");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "4999999999999999.99");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.99");


        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "5000000000000000.01");
        checkBinaryOperation(ONE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.01");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "5000000000000000.09");
        checkBinaryOperation(NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.09");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "5000000000000000.1");
        checkBinaryOperation(ONE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.1");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "5000000000000000.9");
        checkBinaryOperation(NINE_TENTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.9");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "5000000000000000.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.99");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "5000000000000000.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.9999999999999999");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "5000000000000000.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.99999999999999999");

        //first is 9999999999999998 (and vice versa)
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "9999999999999997.00000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.00000000000000001");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "9999999999999997.0000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.0000000000000001");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999997.01");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.01");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, SUBTRACT, "9999999999999997.1");
        checkBinaryOperation(NEG_NINE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.1");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, SUBTRACT, "9999999999999997.9");
        checkBinaryOperation(NEG_ONE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.9");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "9999999999999997.91");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.91");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "9999999999999997.99");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.99");


        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, SUBTRACT, "9999999999999998.01");
        checkBinaryOperation(ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.01");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, SUBTRACT, "9999999999999998.09");
        checkBinaryOperation(NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.09");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, SUBTRACT, "9999999999999998.1");
        checkBinaryOperation(ONE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.1");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, SUBTRACT, "9999999999999998.9");
        checkBinaryOperation(NINE_TENTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.9");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999998.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.99");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "9999999999999998.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.9999999999999999");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "9999999999999998.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.99999999999999999");

        //first is 9999999999999999 (and vice versa)
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, SUBTRACT, "9999999999999998.00000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.00000000000000001");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, SUBTRACT, "9999999999999998.0000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.0000000000000001");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999998.01");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.01");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, SUBTRACT, "9999999999999998.1");
        checkBinaryOperation(NEG_NINE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.1");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, SUBTRACT, "9999999999999998.9");
        checkBinaryOperation(NEG_ONE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.9");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, SUBTRACT, "9999999999999998.91");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.91");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, SUBTRACT, "9999999999999998.99");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.99");


        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, SUBTRACT, "9999999999999999.01");
        checkBinaryOperation(ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.01");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, SUBTRACT, "9999999999999999.09");
        checkBinaryOperation(NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.09");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_TENTH, SUBTRACT, "9999999999999999.1");
        checkBinaryOperation(ONE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.1");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINE_TENTH, SUBTRACT, "9999999999999999.9");
        checkBinaryOperation(NINE_TENTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.9");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999999.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.99");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, SUBTRACT, "9999999999999999.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.9999999999999999");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, SUBTRACT, "9999999999999999.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.99999999999999999");

        //first is 10000000000000000 (and vice versa)
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, SUBTRACT, "9999999999999999.00000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.00000000000000001");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, SUBTRACT, "9999999999999999.0000000000000001");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.0000000000000001");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "9999999999999999.01");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.01");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, SUBTRACT, "9999999999999999.1");
        checkBinaryOperation(NEG_NINE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.1");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, SUBTRACT, "9999999999999999.9");
        checkBinaryOperation(NEG_ONE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.9");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, SUBTRACT, "9999999999999999.91");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.91");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, SUBTRACT, "9999999999999999.99");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.99");


        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, SUBTRACT, "10000000000000000.01");
        checkBinaryOperation(ONE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.01");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, SUBTRACT, "10000000000000000.09");
        checkBinaryOperation(NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.09");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, SUBTRACT, "10000000000000000.1");
        checkBinaryOperation(ONE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.1");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, SUBTRACT, "10000000000000000.9");
        checkBinaryOperation(NINE_TENTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.9");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, SUBTRACT, "10000000000000000.99");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.99");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, SUBTRACT, "10000000000000000.9999999999999999");
        checkBinaryOperation(ZERO_DOT_16_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.9999999999999999");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, SUBTRACT, "10000000000000000.99999999999999999");
        checkBinaryOperation(ZERO_DOT_17_NINES, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.99999999999999999");


        //decimals only
        //first is -0.99999999999999999
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.99999999999999989");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_TENTH, SUBTRACT, "-1.89999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_TENTH, SUBTRACT, "-1.09999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "-1.08999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "-1.00999999999999999");

        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_HUNDREDTH, SUBTRACT, "-0.98999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_HUNDREDTH, SUBTRACT, "-0.90999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_TENTH, SUBTRACT, "-0.89999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_TENTH, SUBTRACT, "-0.09999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.00999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, SUBTRACT, "-0.00000000000000009");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, SUBTRACT, "0.00000000000000000");

        //first is -0.9999999999999999
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.9899999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, SUBTRACT, "-1.8999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, SUBTRACT, "-1.0999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "-1.0899999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "-1.0099999999999999");

        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, SUBTRACT, "-0.9899999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, SUBTRACT, "-0.9099999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_TENTH, SUBTRACT, "-0.8999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_TENTH, SUBTRACT, "-0.0999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "-0.0099999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, SUBTRACT, "0.0000000000000000");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, SUBTRACT, "0.00000000000000009");

        //first is -0.99
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "-1.89");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "-1.09");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-1.08");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-1.00");

        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "-0.98");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "-0.90");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "-0.89");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "-0.09");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.00");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "0.0099999999999999");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "0.00999999999999999");

        //first is -0.9
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, SUBTRACT, "-1.0");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.99");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.91");

        checkBinaryOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, SUBTRACT, "-0.89");
        checkBinaryOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, SUBTRACT, "-0.81");
        checkBinaryOperation(NEG_NINE_TENTH, ONE_TENTH, SUBTRACT, "-0.8");
        checkBinaryOperation(NEG_NINE_TENTH, NINE_TENTH, SUBTRACT, "0.0");
        checkBinaryOperation(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.09");
        checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "0.0999999999999999");
        checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "0.09999999999999999");

        //first is -0.1
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.19");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.11");

        checkBinaryOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, SUBTRACT, "-0.09");
        checkBinaryOperation(NEG_ONE_TENTH, NINE_HUNDREDTH, SUBTRACT, "-0.01");
        checkBinaryOperation(NEG_ONE_TENTH, ONE_TENTH, SUBTRACT, "0.0");
        checkBinaryOperation(NEG_ONE_TENTH, NINE_TENTH, SUBTRACT, "0.8");
        checkBinaryOperation(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.89");
        checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "0.8999999999999999");
        checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "0.89999999999999999");

        //first is -0.09
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.10");

        checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "-0.08");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "0.00");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "0.01");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "0.81");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.90");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "0.9099999999999999");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "0.90999999999999999");

        //first is -0.01
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "0.00");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "0.08");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, SUBTRACT, "0.09");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_TENTH, SUBTRACT, "0.89");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "0.98");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "0.9899999999999999");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "0.98999999999999999");

        //first is 0.01
        checkBinaryOperation(ONE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "0.02");
        checkBinaryOperation(ONE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "0.10");
        checkBinaryOperation(ONE_HUNDREDTH, ONE_TENTH, SUBTRACT, "0.11");
        checkBinaryOperation(ONE_HUNDREDTH, NINE_TENTH, SUBTRACT, "0.91");
        checkBinaryOperation(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.00");
        checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "1.0099999999999999");
        checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "1.00999999999999999");

        //first is 0.09
        checkBinaryOperation(NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "0.02");
        checkBinaryOperation(NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "0.18");
        checkBinaryOperation(NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "0.19");
        checkBinaryOperation(NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "0.99");
        checkBinaryOperation(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.08");
        checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "1.0899999999999999");
        checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "1.08999999999999999");

        //first is 0.1
        checkBinaryOperation(ONE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(ONE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(ONE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(ONE_TENTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(ONE_TENTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(ONE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(ONE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(ONE_TENTH, ONE_HUNDREDTH, SUBTRACT, "0.02");
        checkBinaryOperation(ONE_TENTH, NINE_HUNDREDTH, SUBTRACT, "0.18");
        checkBinaryOperation(ONE_TENTH, ONE_TENTH, SUBTRACT, "0.2");
        checkBinaryOperation(ONE_TENTH, NINE_TENTH, SUBTRACT, "1.0");
        checkBinaryOperation(ONE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.09");
        checkBinaryOperation(ONE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "1.0999999999999999");
        checkBinaryOperation(ONE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "1.09999999999999999");

        //first is 0.9
        checkBinaryOperation(NINE_TENTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NINE_TENTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NINE_TENTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NINE_TENTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(NINE_TENTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(NINE_TENTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(NINE_TENTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(NINE_TENTH, ONE_HUNDREDTH, SUBTRACT, "0.02");
        checkBinaryOperation(NINE_TENTH, NINE_HUNDREDTH, SUBTRACT, "0.18");
        checkBinaryOperation(NINE_TENTH, ONE_TENTH, SUBTRACT, "0.2");
        checkBinaryOperation(NINE_TENTH, NINE_TENTH, SUBTRACT, "1.8");
        checkBinaryOperation(NINE_TENTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.89");
        checkBinaryOperation(NINE_TENTH, ZERO_DOT_16_NINES, SUBTRACT, "1.8999999999999999");
        checkBinaryOperation(NINE_TENTH, ZERO_DOT_17_NINES, SUBTRACT, "1.89999999999999999");

        //first is 0.99
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, SUBTRACT, "0.02");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, SUBTRACT, "0.18");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, ONE_TENTH, SUBTRACT, "0.2");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINE_TENTH, SUBTRACT, "1.8");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.98");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, SUBTRACT, "1.9899999999999999");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, SUBTRACT, "1.98999999999999999");

        //first is 0.9999999999999999
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(ZERO_DOT_16_NINES, ONE_HUNDREDTH, SUBTRACT, "0.02");
        checkBinaryOperation(ZERO_DOT_16_NINES, NINE_HUNDREDTH, SUBTRACT, "0.18");
        checkBinaryOperation(ZERO_DOT_16_NINES, ONE_TENTH, SUBTRACT, "0.2");
        checkBinaryOperation(ZERO_DOT_16_NINES, NINE_TENTH, SUBTRACT, "1.8");
        checkBinaryOperation(ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.98");
        checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, SUBTRACT, "1.9999999999999998");
        checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, SUBTRACT, "1.99999999999999989");

        //first is 0.99999999999999999
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, SUBTRACT, "-1.99999999999999998");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, SUBTRACT, "-1.9999999999999998");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, SUBTRACT, "-1.98");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINE_TENTH, SUBTRACT, "-1.8");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_TENTH, SUBTRACT, "-0.2");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, SUBTRACT, "-0.18");
        checkBinaryOperation(ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, SUBTRACT, "-0.02");

        checkBinaryOperation(ZERO_DOT_17_NINES, ONE_HUNDREDTH, SUBTRACT, "0.02");
        checkBinaryOperation(ZERO_DOT_17_NINES, NINE_HUNDREDTH, SUBTRACT, "0.18");
        checkBinaryOperation(ZERO_DOT_17_NINES, ONE_TENTH, SUBTRACT, "0.2");
        checkBinaryOperation(ZERO_DOT_17_NINES, NINE_TENTH, SUBTRACT, "1.8");
        checkBinaryOperation(ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, SUBTRACT, "1.98");
        checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, SUBTRACT, "1.9999999999999998");
        checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, SUBTRACT, "1.99999999999999998");


        //engineer numbers
        //with engineer numbers
        //first is -1.E+9999
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-2.E+9999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-1.1E+9999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, SUBTRACT, "-9.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, SUBTRACT, "0.E+9999");

        //first is -1.E+9998
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-2.E+9999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-2.E+9998");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, SUBTRACT, "0.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, SUBTRACT, "9.E+9998");

        //first is 1.E+9998
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-2.E+9999");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-2.E+9998");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, SUBTRACT, "2.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, SUBTRACT, "1.1E+9999");

        //first is 1.E+9999
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-2.E+9999");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-2.E+9998");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, SUBTRACT, "2.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, SUBTRACT, "2.E+9999");

        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-2.E+17");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-1.1E+17");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, SUBTRACT, "-9.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, SUBTRACT, "0.E+17");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-2.E+17");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-2.E+16");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, SUBTRACT, "0.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, SUBTRACT, "9.E+16");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-2.E+17");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, SUBTRACT, "0.E+16");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, SUBTRACT, "2.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, SUBTRACT, "1.1E+17");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-2.E+17");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, SUBTRACT, "0.E+16");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, SUBTRACT, "2.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, SUBTRACT, "2.E+17");

        //first is -1.E-9999
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-2.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-1.1E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, SUBTRACT, "9.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, SUBTRACT, "0.E-9999");

        //first is -1.E-9998
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-2.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-2E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, SUBTRACT, "0.E-9998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, SUBTRACT, "-9.E-9999");

        //first is 1.E-9998
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-2.E-9999");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-2E-9998");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, SUBTRACT, "2.E-9998");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, SUBTRACT, "1.1E-9998");

        //first is 1.E-9999
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-2.E-9999");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-2E-9998");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, SUBTRACT, "2.E-9998");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, SUBTRACT, "2.E-9999");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-2.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-1.1E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, SUBTRACT, "9.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, SUBTRACT, "0.E-17");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-2.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-2E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, SUBTRACT, "0.E-16");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, SUBTRACT, "-9.E-17");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-2.E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-2E-16");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, SUBTRACT, "2.E-16");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, SUBTRACT, "1.1E-16");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-2.E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-2E-16");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, SUBTRACT, "2.E-16");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, SUBTRACT, "2.E-17");


        //with integers
        //first is -1.E+9999 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-110000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-110000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN, SUBTRACT, "-109999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-109999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-109999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-109999999999999998");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-105000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-105000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_HUNDRED, SUBTRACT, "-100000000000000100");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-100000000000000100");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_TEN, SUBTRACT, "-100000000000000010");
        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-100000000000000010");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE, SUBTRACT, "-100000000000000001");
        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-100000000000000001");


        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.ZERO, SUBTRACT, "-100000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-100000000000000000");


        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.ONE, SUBTRACT, "-99999999999999999");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, BigDecimal.TEN, SUBTRACT, "-99999999999999990");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-99999999999999990");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, HUNDRED, SUBTRACT, "-99999999999999900");
        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-99999999999999900");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-95000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-95000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-90000000000000002");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-90000000000000002");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN, SUBTRACT, "-90000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-90000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-90000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9999, SUBTRACT, "-90000000000000000");


        //first is -1.E+9998 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-20000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-19999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-19999999999999998");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-15000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-15000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_HUNDRED, SUBTRACT, "-10000000000000100");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-10000000000000100");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_TEN, SUBTRACT, "-10000000000000010");
        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-10000000000000010");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE, SUBTRACT, "-10000000000000001");
        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-10000000000000001");


        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.ZERO, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-10000000000000000");


        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.ONE, SUBTRACT, "-9999999999999999");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, BigDecimal.TEN, SUBTRACT, "-9999999999999990");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-9999999999999990");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, HUNDRED, SUBTRACT, "-9999999999999900");
        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-9999999999999900");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-5000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-2");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-2");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN, SUBTRACT, "-1");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "-1");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "0");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_9998, SUBTRACT, "0");


        //first is 1.E+9998 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9998, SUBTRACT, "0");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN, SUBTRACT, "1");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, SUBTRACT, "1");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "2");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9998, SUBTRACT, "2");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, SUBTRACT, "5000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_HUNDRED, SUBTRACT, "9999999999999900");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_9998, SUBTRACT, "9999999999999900");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_TEN, SUBTRACT, "9999999999999990");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_9998, SUBTRACT, "9999999999999990");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE, SUBTRACT, "9999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_9998, SUBTRACT, "9999999999999999");


        checkBinaryOperation(ONE_DOT_E_PLUS_9998, BigDecimal.ZERO, SUBTRACT, "10000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_9998, SUBTRACT, "10000000000000000");


        checkBinaryOperation(ONE_DOT_E_PLUS_9998, BigDecimal.ONE, SUBTRACT, "10000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_9998, SUBTRACT, "10000000000000001");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, BigDecimal.TEN, SUBTRACT, "10000000000000010");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_9998, SUBTRACT, "10000000000000010");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, HUNDRED, SUBTRACT, "10000000000000100");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_9998, SUBTRACT, "10000000000000100");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "15000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, SUBTRACT, "15000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9998, SUBTRACT, "19999999999999998");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN, SUBTRACT, "19999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9998, SUBTRACT, "19999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "20000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9998, SUBTRACT, "20000000000000000");


        //first is 1.E+9999 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "90000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9999, SUBTRACT, "90000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN, SUBTRACT, "90000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, SUBTRACT, "90000000000000001");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "90000000000000002");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9999, SUBTRACT, "90000000000000002");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "95000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, SUBTRACT, "95000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_HUNDRED, SUBTRACT, "99999999999999900");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_9999, SUBTRACT, "99999999999999900");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_TEN, SUBTRACT, "99999999999999990");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_9999, SUBTRACT, "99999999999999990");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE, SUBTRACT, "99999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_9999, SUBTRACT, "99999999999999999");


        checkBinaryOperation(ONE_DOT_E_PLUS_9999, BigDecimal.ZERO, SUBTRACT, "100000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_9999, SUBTRACT, "100000000000000000");


        checkBinaryOperation(ONE_DOT_E_PLUS_9999, BigDecimal.ONE, SUBTRACT, "100000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_9999, SUBTRACT, "100000000000000001");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, BigDecimal.TEN, SUBTRACT, "100000000000000010");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_9999, SUBTRACT, "100000000000000010");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, HUNDRED, SUBTRACT, "100000000000000100");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_9999, SUBTRACT, "100000000000000100");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "105000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, SUBTRACT, "105000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "109999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_9999, SUBTRACT, "109999999999999998");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN, SUBTRACT, "109999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_9999, SUBTRACT, "109999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "110000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_9999, SUBTRACT, "110000000000000000");


        //first is -1.E+17 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-110000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-110000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "-109999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-109999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-109999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-109999999999999998");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-105000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-105000000000000000");

        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000100");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, SUBTRACT, "-100000000000000100");

        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000010");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, SUBTRACT, "-100000000000000010");

        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, SUBTRACT, "-100000000000000001");


        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-100000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, SUBTRACT, "-100000000000000000");


        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, SUBTRACT, "-99999999999999999");

        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999990");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, SUBTRACT, "-99999999999999990");

        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-99999999999999900");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, SUBTRACT, "-99999999999999900");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-95000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-95000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-90000000000000002");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-90000000000000002");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "-90000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-90000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-90000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_17, SUBTRACT, "-90000000000000000");


        //first is -1.E+16 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-20000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-20000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "-19999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-19999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-19999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-19999999999999998");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-15000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-15000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, SUBTRACT, "-10000000000000100");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000100");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, SUBTRACT, "-10000000000000010");
        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000010");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, SUBTRACT, "-10000000000000001");
        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000001");


        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, SUBTRACT, "-10000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-10000000000000000");


        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, SUBTRACT, "-9999999999999999");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, SUBTRACT, "-9999999999999990");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999990");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, SUBTRACT, "-9999999999999900");
        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-9999999999999900");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-5000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-2");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-2");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "-1");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "-1");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "0");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_PLUS_16, SUBTRACT, "0");


        //first is 1.E+16 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "0");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "1");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "1");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "2");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "2");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "5000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, SUBTRACT, "9999999999999900");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999900");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, SUBTRACT, "9999999999999990");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999990");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, SUBTRACT, "9999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "9999999999999999");


        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, SUBTRACT, "10000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000000");


        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, SUBTRACT, "10000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000001");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, SUBTRACT, "10000000000000010");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000010");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, SUBTRACT, "10000000000000100");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_16, SUBTRACT, "10000000000000100");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "15000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "15000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "19999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "19999999999999998");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "19999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_16, SUBTRACT, "19999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "20000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_16, SUBTRACT, "20000000000000000");


        //first is 1.E+17 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "90000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "90000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "90000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "90000000000000001");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "90000000000000002");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "90000000000000002");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "95000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "95000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, SUBTRACT, "99999999999999900");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999900");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, SUBTRACT, "99999999999999990");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999990");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, SUBTRACT, "99999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "99999999999999999");


        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, SUBTRACT, "100000000000000000");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000000");


        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, SUBTRACT, "100000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000001");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, SUBTRACT, "100000000000000010");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000010");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, SUBTRACT, "100000000000000100");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_PLUS_17, SUBTRACT, "100000000000000100");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "105000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "105000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "109999999999999998");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "109999999999999998");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "109999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_PLUS_17, SUBTRACT, "109999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "110000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_PLUS_17, SUBTRACT, "110000000000000000");


        //first is -1.E-9999 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.00000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-10000000000000000.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.00000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-9999999999999999.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.00000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-9999999999999998.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.00000000000000001");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-5000000000000000.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_HUNDRED, SUBTRACT, "-100.00000000000000001");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-100.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_TEN, SUBTRACT, "-10.00000000000000001");
        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-10.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE, SUBTRACT, "-1.00000000000000001");
        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-1.00000000000000001");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, SUBTRACT, "-1.E-17");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "-1.E-17");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ONE, SUBTRACT, "0.99999999999999999");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "0.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.TEN, SUBTRACT, "9.99999999999999999");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "9.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HUNDRED, SUBTRACT, "99.99999999999999999");
        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "99.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.99999999999999999");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "4999999999999999.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.99999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "9999999999999997.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.99999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "9999999999999998.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.99999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_9999, SUBTRACT, "9999999999999999.99999999999999999");


        //first is -1.E-9998 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.0000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-10000000000000000.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.0000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-9999999999999999.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.0000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-9999999999999998.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.0000000000000001");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-5000000000000000.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_HUNDRED, SUBTRACT, "-100.0000000000000001");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-100.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_TEN, SUBTRACT, "-10.0000000000000001");
        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-10.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE, SUBTRACT, "-1.0000000000000001");
        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-1.0000000000000001");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, SUBTRACT, "-1.E-16");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "-1.E-16");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ONE, SUBTRACT, "0.9999999999999999");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "0.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.TEN, SUBTRACT, "9.9999999999999999");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "9.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HUNDRED, SUBTRACT, "99.9999999999999999");
        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "99.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.9999999999999999");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "4999999999999999.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.9999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "9999999999999997.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.9999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "9999999999999998.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.9999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_9998, SUBTRACT, "9999999999999999.9999999999999999");


        //first is 1.E-9998 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_9998, SUBTRACT, "-9999999999999999.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9998, SUBTRACT, "-9999999999999998.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_9998, SUBTRACT, "-9999999999999997.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.9999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9998, SUBTRACT, "-4999999999999999.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_HUNDRED, SUBTRACT, "-99.9999999999999999");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_9998, SUBTRACT, "-99.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_TEN, SUBTRACT, "-9.9999999999999999");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_9998, SUBTRACT, "-9.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE, SUBTRACT, "-0.9999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_9998, SUBTRACT, "-0.9999999999999999");


        checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, SUBTRACT, "1.E-16");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_9998, SUBTRACT, "1.E-16");


        checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ONE, SUBTRACT, "1.0000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_9998, SUBTRACT, "1.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.TEN, SUBTRACT, "10.0000000000000001");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_9998, SUBTRACT, "10.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, HUNDRED, SUBTRACT, "100.0000000000000001");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_9998, SUBTRACT, "100.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.0000000000000001");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9998, SUBTRACT, "5000000000000000.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.0000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_9998, SUBTRACT, "9999999999999998.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.0000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9998, SUBTRACT, "9999999999999999.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.0000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_9998, SUBTRACT, "10000000000000000.0000000000000001");


        //first is 1.E-9999 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.99999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_9999, SUBTRACT, "-9999999999999999.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.99999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9999, SUBTRACT, "-9999999999999998.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.99999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_9999, SUBTRACT, "-9999999999999997.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.99999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9999, SUBTRACT, "-4999999999999999.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_HUNDRED, SUBTRACT, "-99.99999999999999999");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_9999, SUBTRACT, "-99.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_TEN, SUBTRACT, "-9.99999999999999999");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_9999, SUBTRACT, "-9.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE, SUBTRACT, "-0.99999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_9999, SUBTRACT, "-0.99999999999999999");


        checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, SUBTRACT, "1.E-17");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_9999, SUBTRACT, "1.E-17");


        checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ONE, SUBTRACT, "1.00000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_9999, SUBTRACT, "1.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.TEN, SUBTRACT, "10.00000000000000001");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_9999, SUBTRACT, "10.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, HUNDRED, SUBTRACT, "100.00000000000000001");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_9999, SUBTRACT, "100.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.00000000000000001");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9999, SUBTRACT, "5000000000000000.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.00000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_9999, SUBTRACT, "9999999999999998.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.00000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_9999, SUBTRACT, "9999999999999999.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.00000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_9999, SUBTRACT, "10000000000000000.00000000000000001");


        //first is -1.E-17 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.00000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-10000000000000000.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.00000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999999.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.00000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999998.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.00000000000000001");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-5000000000000000.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, SUBTRACT, "-100.00000000000000001");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-100.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, SUBTRACT, "-10.00000000000000001");
        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-10.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, SUBTRACT, "-1.00000000000000001");
        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-1.00000000000000001");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, SUBTRACT, "-1.E-17");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "-1.E-17");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, SUBTRACT, "0.99999999999999999");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "0.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, SUBTRACT, "9.99999999999999999");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "9.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, SUBTRACT, "99.99999999999999999");
        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "99.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.99999999999999999");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "4999999999999999.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.99999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999997.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.99999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999998.99999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.99999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999999.99999999999999999");


        //first is -1.E-16 (and vice versa)
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-10000000000000000.0000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-10000000000000000.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999999.0000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999999.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999998.0000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999998.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-5000000000000000.0000000000000001");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-5000000000000000.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, SUBTRACT, "-100.0000000000000001");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-100.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, SUBTRACT, "-10.0000000000000001");
        checkBinaryOperation(NEG_TEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-10.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, SUBTRACT, "-1.0000000000000001");
        checkBinaryOperation(NEG_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-1.0000000000000001");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, SUBTRACT, "-1.E-16");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "-1.E-16");


        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, SUBTRACT, "0.9999999999999999");
        checkBinaryOperation(BigDecimal.ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "0.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, SUBTRACT, "9.9999999999999999");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "9.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, SUBTRACT, "99.9999999999999999");
        checkBinaryOperation(HUNDRED, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "99.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "4999999999999999.9999999999999999");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "4999999999999999.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999997.9999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999997.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999998.9999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999998.9999999999999999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "9999999999999999.9999999999999999");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999999.9999999999999999");


        //first is 1.E-16 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999999.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999998.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "-9999999999999997.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.9999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "-4999999999999999.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, SUBTRACT, "-99.9999999999999999");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_16, SUBTRACT, "-99.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, SUBTRACT, "-9.9999999999999999");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_16, SUBTRACT, "-9.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, SUBTRACT, "-0.9999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "-0.9999999999999999");


        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, SUBTRACT, "1.E-16");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_16, SUBTRACT, "1.E-16");


        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, SUBTRACT, "1.0000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "1.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, SUBTRACT, "10.0000000000000001");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_16, SUBTRACT, "10.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, SUBTRACT, "100.0000000000000001");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_16, SUBTRACT, "100.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.0000000000000001");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "5000000000000000.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.0000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999998.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.0000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_16, SUBTRACT, "9999999999999999.0000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.0000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_16, SUBTRACT, "10000000000000000.0000000000000001");


        //first is 1.E-17 (and vice versa)
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "-9999999999999999.99999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999999.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, SUBTRACT, "-9999999999999998.99999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999998.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "-9999999999999997.99999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "-9999999999999997.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, SUBTRACT, "-4999999999999999.99999999999999999");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "-4999999999999999.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, SUBTRACT, "-99.99999999999999999");
        checkBinaryOperation(NEG_HUNDRED, ONE_DOT_E_MINUS_17, SUBTRACT, "-99.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, SUBTRACT, "-9.99999999999999999");
        checkBinaryOperation(NEG_TEN, ONE_DOT_E_MINUS_17, SUBTRACT, "-9.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, SUBTRACT, "-0.99999999999999999");
        checkBinaryOperation(NEG_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "-0.99999999999999999");


        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, SUBTRACT, "1.E-17");
        checkBinaryOperation(BigDecimal.ZERO, ONE_DOT_E_MINUS_17, SUBTRACT, "1.E-17");


        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, SUBTRACT, "1.00000000000000001");
        checkBinaryOperation(BigDecimal.ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "1.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, SUBTRACT, "10.00000000000000001");
        checkBinaryOperation(BigDecimal.TEN, ONE_DOT_E_MINUS_17, SUBTRACT, "10.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, SUBTRACT, "100.00000000000000001");
        checkBinaryOperation(HUNDRED, ONE_DOT_E_MINUS_17, SUBTRACT, "100.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, SUBTRACT, "5000000000000000.00000000000000001");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "5000000000000000.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, SUBTRACT, "9999999999999998.00000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999998.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, SUBTRACT, "9999999999999999.00000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, ONE_DOT_E_MINUS_17, SUBTRACT, "9999999999999999.00000000000000001");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, SUBTRACT, "10000000000000000.00000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_DOT_E_MINUS_17, SUBTRACT, "10000000000000000.00000000000000001");


        //with decimals
        //first is -1.E+17
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

        //first is -1.E+16
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

        //first is 1.E+16
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

        //first is 1.E+17
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

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, ADD, "-1.00000000000000000");
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

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, ADD, "-1.00000000000000009");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, ADD, "-1.0000000000000000");
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

        //first is 1.E-16
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
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, ADD, "1.0000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, ADD, "1.00000000000000009");

        //first is 1.E-17
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
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, ADD, "1.00000000000000000");


        //several random values
        checkBinaryOperation(new BigDecimal("523"), new BigDecimal("876"), SUBTRACT, "8960");
        checkBinaryOperation(new BigDecimal("876"), new BigDecimal("523"), SUBTRACT, "36408");
        checkBinaryOperation(new BigDecimal("34"), new BigDecimal("65"), SUBTRACT, "8960");
        checkBinaryOperation(new BigDecimal("65"), new BigDecimal("34"), SUBTRACT, "36408");
        
        checkBinaryOperation(new BigDecimal("724"), new BigDecimal("-652"), SUBTRACT, "-480");
        checkBinaryOperation(new BigDecimal("-652"), new BigDecimal("724"), SUBTRACT, "7592");
        checkBinaryOperation(new BigDecimal("763"), new BigDecimal("-865"), SUBTRACT, "-480");
        checkBinaryOperation(new BigDecimal("865"), new BigDecimal("763"), SUBTRACT, "7592");
        
        checkBinaryOperation(new BigDecimal("-6521"), new BigDecimal("-41"), SUBTRACT, "-53304");
        checkBinaryOperation(new BigDecimal("-41"), new BigDecimal("-6521"), SUBTRACT, "-1308");
        checkBinaryOperation(new BigDecimal("-7624"), new BigDecimal("-7245"), SUBTRACT, "-53304");
        checkBinaryOperation(new BigDecimal("-7245"), new BigDecimal("-7624"), SUBTRACT, "-1308");
        
        checkBinaryOperation(new BigDecimal("763"), new BigDecimal("245.876"), SUBTRACT, "747.123");
        checkBinaryOperation(new BigDecimal("245.876"), new BigDecimal("763"), SUBTRACT, "977.523");
        checkBinaryOperation(new BigDecimal("9876"), new BigDecimal("123.87"), SUBTRACT, "747.123");
        checkBinaryOperation(new BigDecimal("123.87"), new BigDecimal("9876"), SUBTRACT, "977.523");
        
        checkBinaryOperation(new BigDecimal("6425"), new BigDecimal("-123.65"), SUBTRACT, "7628.402");
        checkBinaryOperation(new BigDecimal("-123.65"), new BigDecimal("6425"), SUBTRACT, "2307.876");
        checkBinaryOperation(new BigDecimal("987"), new BigDecimal("-12.65"), SUBTRACT, "7628.402");
        checkBinaryOperation(new BigDecimal("-12.65"), new BigDecimal("987"), SUBTRACT, "2307.876");
        
        checkBinaryOperation(new BigDecimal("-6"), new BigDecimal("76.123"), SUBTRACT, "14.43");
        checkBinaryOperation(new BigDecimal("76.123"), new BigDecimal("-6"), SUBTRACT, "789.1");
        checkBinaryOperation(new BigDecimal("-6543"), new BigDecimal("12.43"), SUBTRACT, "14.43");
        checkBinaryOperation(new BigDecimal("12.43"), new BigDecimal("-6543"), SUBTRACT, "789.1");
        
        checkBinaryOperation(new BigDecimal("-876"), new BigDecimal("-21.41"), SUBTRACT, "-63.234");
        checkBinaryOperation(new BigDecimal("-21.41"), new BigDecimal("-876"), SUBTRACT, "-1989.76");
        checkBinaryOperation(new BigDecimal("-987"), new BigDecimal("-12.21"), SUBTRACT, "-63.234");
        checkBinaryOperation(new BigDecimal("-12.21"), new BigDecimal("-987"), SUBTRACT, "-1989.76");
        
        checkBinaryOperation(new BigDecimal("12.11"), new BigDecimal("87.0765"), SUBTRACT, "104.79");
        checkBinaryOperation(new BigDecimal("87.0765"), new BigDecimal("12.11"), SUBTRACT, "150.468");
        checkBinaryOperation(new BigDecimal("123.66"), new BigDecimal("1111.09"), SUBTRACT, "104.79");
        checkBinaryOperation(new BigDecimal("1111.09"), new BigDecimal("123.66"), SUBTRACT, "150.468");
        
        checkBinaryOperation(new BigDecimal("123.65"), new BigDecimal("-1.2"), SUBTRACT, "38.56");
        checkBinaryOperation(new BigDecimal("-1.2"), new BigDecimal("123.65"), SUBTRACT, "548.1");
        checkBinaryOperation(new BigDecimal("5.1"), new BigDecimal("-12.7"), SUBTRACT, "38.56");
        checkBinaryOperation(new BigDecimal("-12.7"), new BigDecimal("5.1"), SUBTRACT, "548.1");
        
        checkBinaryOperation(new BigDecimal("-0.112"), new BigDecimal("-3.2"), SUBTRACT, "-534.3");
        checkBinaryOperation(new BigDecimal("-3.2"), new BigDecimal("-0.112"), SUBTRACT, "-647.8");
        checkBinaryOperation(new BigDecimal("-9.1"), new BigDecimal("-1.224"), SUBTRACT, "-534.3");
        checkBinaryOperation(new BigDecimal("-1.224"), new BigDecimal("-9.1"), SUBTRACT, "-647.8");
    }

    @Test
    void multiplyOperationTests() {
        //integers only
        //first is -10000000000000000
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "100000000000000000000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN, MULTIPLY, "99999999999999990000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "99999999999999980000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "50000000000000000000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_HUNDRED, MULTIPLY, "1000000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_TEN, MULTIPLY, "100000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE, MULTIPLY, "10000000000000000");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ZERO, MULTIPLY, "0");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.ONE, MULTIPLY, "-10000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, BigDecimal.TEN, MULTIPLY, "-100000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HUNDRED, MULTIPLY, "-1000000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-50000000000000000000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-99999999999999980000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "-99999999999999990000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-100000000000000000000000000000000");

        //first is -9999999999999999
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN, MULTIPLY, "99999999999999980000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "99999999999999970000000000000002");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "49999999999999995000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_HUNDRED, MULTIPLY, "999999999999999900");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_TEN, MULTIPLY, "99999999999999990");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, NEG_ONE, MULTIPLY, "9999999999999999");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, MULTIPLY, "0");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.ONE, MULTIPLY, "-9999999999999999");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, BigDecimal.TEN, MULTIPLY, "-99999999999999990");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, HUNDRED, MULTIPLY, "-999999999999999900");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-49999999999999995000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-99999999999999970000000000000002");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "-99999999999999980000000000000001");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-99999999999999990000000000000000");

        //first is -9999999999999998
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "99999999999999960000000000000004");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "49999999999999990000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_HUNDRED, MULTIPLY, "999999999999999800");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_TEN, MULTIPLY, "99999999999999980");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE, MULTIPLY, "9999999999999998");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ZERO, MULTIPLY, "0");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.ONE, MULTIPLY, "-9999999999999998");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, BigDecimal.TEN, MULTIPLY, "-99999999999999980");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HUNDRED, MULTIPLY, "-999999999999999800");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-49999999999999990000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-99999999999999960000000000000004");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "-99999999999999970000000000000002");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-99999999999999980000000000000000");

        //first is -5000000000000000
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "25000000000000000000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_HUNDRED, MULTIPLY, "500000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_TEN, MULTIPLY, "50000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE, MULTIPLY, "5000000000000000");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ZERO, MULTIPLY, "0");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.ONE, MULTIPLY, "-5000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, BigDecimal.TEN, MULTIPLY, "-50000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HUNDRED, MULTIPLY, "-500000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-25000000000000000000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-49999999999999990000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "-49999999999999995000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-50000000000000000000000000000000");

        //first is -100
        checkBinaryOperation(NEG_HUNDRED, NEG_HUNDRED, MULTIPLY, "10000");
        checkBinaryOperation(NEG_HUNDRED, NEG_TEN, MULTIPLY, "1000");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE, MULTIPLY, "100");

        checkBinaryOperation(NEG_HUNDRED, BigDecimal.ZERO, MULTIPLY, "0");

        checkBinaryOperation(NEG_HUNDRED, BigDecimal.ONE, MULTIPLY, "-100");
        checkBinaryOperation(NEG_HUNDRED, BigDecimal.TEN, MULTIPLY, "-1000");
        checkBinaryOperation(NEG_HUNDRED, HUNDRED, MULTIPLY, "-10000");
        checkBinaryOperation(NEG_HUNDRED, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-500000000000000000");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-999999999999999800");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN, MULTIPLY, "-999999999999999900");
        checkBinaryOperation(NEG_HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1000000000000000000");

        //first is -10
        checkBinaryOperation(NEG_TEN, NEG_TEN, MULTIPLY, "100");
        checkBinaryOperation(NEG_TEN, NEG_ONE, MULTIPLY, "10");

        checkBinaryOperation(NEG_TEN, BigDecimal.ZERO, MULTIPLY, "0");

        checkBinaryOperation(NEG_TEN, BigDecimal.ONE, MULTIPLY, "-10");
        checkBinaryOperation(NEG_TEN, BigDecimal.TEN, MULTIPLY, "-100");
        checkBinaryOperation(NEG_TEN, HUNDRED, MULTIPLY, "-1000");
        checkBinaryOperation(NEG_TEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-50000000000000000");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-99999999999999980");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "-99999999999999990");
        checkBinaryOperation(NEG_TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-100000000000000000");

        //first is -1
        checkBinaryOperation(NEG_ONE, NEG_ONE, MULTIPLY, "1");

        checkBinaryOperation(NEG_ONE, BigDecimal.ZERO, MULTIPLY, "0");

        checkBinaryOperation(NEG_ONE, BigDecimal.ONE, MULTIPLY, "-1");
        checkBinaryOperation(NEG_ONE, BigDecimal.TEN, MULTIPLY, "-10");
        checkBinaryOperation(NEG_ONE, HUNDRED, MULTIPLY, "-100");
        checkBinaryOperation(NEG_ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5000000000000000");
        checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9999999999999998");
        checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9999999999999999");
        checkBinaryOperation(NEG_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-10000000000000000");

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
        checkBinaryOperation(BigDecimal.ONE, BigDecimal.TEN, MULTIPLY, "10");
        checkBinaryOperation(BigDecimal.ONE, HUNDRED, MULTIPLY, "100");
        checkBinaryOperation(BigDecimal.ONE, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5000000000000000");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9999999999999998");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "9999999999999999");
        checkBinaryOperation(BigDecimal.ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "10000000000000000");

        //first is 10
        checkBinaryOperation(BigDecimal.TEN, BigDecimal.TEN, MULTIPLY, "100");
        checkBinaryOperation(BigDecimal.TEN, HUNDRED, MULTIPLY, "1000");
        checkBinaryOperation(BigDecimal.TEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "50000000000000000");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "99999999999999980");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "99999999999999990");
        checkBinaryOperation(BigDecimal.TEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "100000000000000000");

        //first is 100
        checkBinaryOperation(HUNDRED, HUNDRED, MULTIPLY, "10000");
        checkBinaryOperation(HUNDRED, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "500000000000000000");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "999999999999999800");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN, MULTIPLY, "999999999999999900");
        checkBinaryOperation(HUNDRED, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1000000000000000000");

        //first is 5000000000000000
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "25000000000000000000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "49999999999999990000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "49999999999999995000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "50000000000000000000000000000000");

        //first is 9999999999999998
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "99999999999999960000000000000004");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN, MULTIPLY, "99999999999999970000000000000002");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_MINUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "99999999999999980000000000000000");

        //first is 9999999999999999
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN, MULTIPLY, "99999999999999980000000000000001");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "99999999999999990000000000000000");

        //first is 10000000000000000
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "100000000000000000000000000000000");


        //integer and decimal
        //first is -10000000000000000
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.90000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999.0000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9900000000000000.00");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_TENTH, MULTIPLY, "9000000000000000.0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_TENTH, MULTIPLY, "1000000000000000.0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "900000000000000.00");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "100000000000000.00");

        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_HUNDREDTH, MULTIPLY, "-100000000000000.00");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_HUNDREDTH, MULTIPLY, "-900000000000000.00");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ONE_TENTH, MULTIPLY, "-1000000000000000.0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINE_TENTH, MULTIPLY, "-9000000000000000.0");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9900000000000000.00");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999.0000000000000000");
        checkBinaryOperation(MIN_VALUE_ON_SCREEN_MINUS_ONE, ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.90000000000000000");

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
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "4999999999999999.95000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "4999999999999999.5000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "4950000000000000.00");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_TENTH, MULTIPLY, "4500000000000000.0");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_TENTH, MULTIPLY, "500000000000000.0");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, MULTIPLY, "450000000000000.00");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, MULTIPLY, "50000000000000.00");

        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_HUNDREDTH, MULTIPLY, "-50000000000000.00");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_HUNDREDTH, MULTIPLY, "-450000000000000.00");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ONE_TENTH, MULTIPLY, "-500000000000000.0");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINE_TENTH, MULTIPLY, "-4500000000000000.0");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "-4950000000000000.00");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, MULTIPLY, "-4999999999999999.5000000000000000");
        checkBinaryOperation(HALF_MIN_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, MULTIPLY, "-4999999999999999.95000000000000000");

        //first is -100
        checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_17_NINES, MULTIPLY, "99.99999999999999900");
        checkBinaryOperation(NEG_HUNDRED, NEG_ZERO_DOT_16_NINES, MULTIPLY, "99.9999999999999900");
        checkBinaryOperation(NEG_HUNDRED, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "99.00");
        checkBinaryOperation(NEG_HUNDRED, NEG_NINE_TENTH, MULTIPLY, "90.0");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_TENTH, MULTIPLY, "10.0");
        checkBinaryOperation(NEG_HUNDRED, NEG_NINE_HUNDREDTH, MULTIPLY, "9.00");
        checkBinaryOperation(NEG_HUNDRED, NEG_ONE_HUNDREDTH, MULTIPLY, "1.00");

        checkBinaryOperation(NEG_HUNDRED, ONE_HUNDREDTH, MULTIPLY, "-1.00");
        checkBinaryOperation(NEG_HUNDRED, NINE_HUNDREDTH, MULTIPLY, "-9.00");
        checkBinaryOperation(NEG_HUNDRED, ONE_TENTH, MULTIPLY, "-10.0");
        checkBinaryOperation(NEG_HUNDRED, NINE_TENTH, MULTIPLY, "-90.0");
        checkBinaryOperation(NEG_HUNDRED, NINETY_NINE_HUNDREDTH, MULTIPLY, "-99.00");
        checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_16_NINES, MULTIPLY, "-99.9999999999999900");
        checkBinaryOperation(NEG_HUNDRED, ZERO_DOT_17_NINES, MULTIPLY, "-99.99999999999999900");

        //first is -10
        checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.99999999999999990");
        checkBinaryOperation(NEG_TEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.9999999999999990");
        checkBinaryOperation(NEG_TEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.90");
        checkBinaryOperation(NEG_TEN, NEG_NINE_TENTH, MULTIPLY, "9.0");
        checkBinaryOperation(NEG_TEN, NEG_ONE_TENTH, MULTIPLY, "1.0");
        checkBinaryOperation(NEG_TEN, NEG_NINE_HUNDREDTH, MULTIPLY, "0.90");
        checkBinaryOperation(NEG_TEN, NEG_ONE_HUNDREDTH, MULTIPLY, "0.10");

        checkBinaryOperation(NEG_TEN, ONE_HUNDREDTH, MULTIPLY, "-0.10");
        checkBinaryOperation(NEG_TEN, NINE_HUNDREDTH, MULTIPLY, "-0.90");
        checkBinaryOperation(NEG_TEN, ONE_TENTH, MULTIPLY, "-1.0");
        checkBinaryOperation(NEG_TEN, NINE_TENTH, MULTIPLY, "-9.0");
        checkBinaryOperation(NEG_TEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.90");
        checkBinaryOperation(NEG_TEN, ZERO_DOT_16_NINES, MULTIPLY, "-9.9999999999999990");
        checkBinaryOperation(NEG_TEN, ZERO_DOT_17_NINES, MULTIPLY, "-9.99999999999999990");

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
        checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_17_NINES, MULTIPLY, "0.E-17");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ZERO_DOT_16_NINES, MULTIPLY, "0.E-16");
        checkBinaryOperation(BigDecimal.ZERO, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_TENTH, MULTIPLY, "0.0");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_TENTH, MULTIPLY, "0.0");
        checkBinaryOperation(BigDecimal.ZERO, NEG_NINE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(BigDecimal.ZERO, NEG_ONE_HUNDREDTH, MULTIPLY, "0.00");

        checkBinaryOperation(BigDecimal.ZERO, ONE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(BigDecimal.ZERO, NINE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(BigDecimal.ZERO, ONE_TENTH, MULTIPLY, "0.0");
        checkBinaryOperation(BigDecimal.ZERO, NINE_TENTH, MULTIPLY, "0.0");
        checkBinaryOperation(BigDecimal.ZERO, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_16_NINES, MULTIPLY, "0.E-16");
        checkBinaryOperation(BigDecimal.ZERO, ZERO_DOT_17_NINES, MULTIPLY, "0.E-17");

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
        checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.99999999999999990");
        checkBinaryOperation(BigDecimal.TEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.9999999999999990");
        checkBinaryOperation(BigDecimal.TEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.90");
        checkBinaryOperation(BigDecimal.TEN, NEG_NINE_TENTH, MULTIPLY, "-9.0");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_TENTH, MULTIPLY, "-1.0");
        checkBinaryOperation(BigDecimal.TEN, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.90");
        checkBinaryOperation(BigDecimal.TEN, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.10");

        checkBinaryOperation(BigDecimal.TEN, ONE_HUNDREDTH, MULTIPLY, "0.10");
        checkBinaryOperation(BigDecimal.TEN, NINE_HUNDREDTH, MULTIPLY, "0.90");
        checkBinaryOperation(BigDecimal.TEN, ONE_TENTH, MULTIPLY, "1.0");
        checkBinaryOperation(BigDecimal.TEN, NINE_TENTH, MULTIPLY, "9.0");
        checkBinaryOperation(BigDecimal.TEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.90");
        checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_16_NINES, MULTIPLY, "9.9999999999999990");
        checkBinaryOperation(BigDecimal.TEN, ZERO_DOT_17_NINES, MULTIPLY, "9.99999999999999990");

        //first is 100
        checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-99.99999999999999900");
        checkBinaryOperation(HUNDRED, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-99.9999999999999900");
        checkBinaryOperation(HUNDRED, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-99.00");
        checkBinaryOperation(HUNDRED, NEG_NINE_TENTH, MULTIPLY, "-90.0");
        checkBinaryOperation(HUNDRED, NEG_ONE_TENTH, MULTIPLY, "-10.0");
        checkBinaryOperation(HUNDRED, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.00");
        checkBinaryOperation(HUNDRED, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.00");

        checkBinaryOperation(HUNDRED, ONE_HUNDREDTH, MULTIPLY, "1.00");
        checkBinaryOperation(HUNDRED, NINE_HUNDREDTH, MULTIPLY, "9.00");
        checkBinaryOperation(HUNDRED, ONE_TENTH, MULTIPLY, "10.0");
        checkBinaryOperation(HUNDRED, NINE_TENTH, MULTIPLY, "90.0");
        checkBinaryOperation(HUNDRED, NINETY_NINE_HUNDREDTH, MULTIPLY, "99.00");
        checkBinaryOperation(HUNDRED, ZERO_DOT_16_NINES, MULTIPLY, "99.9999999999999900");
        checkBinaryOperation(HUNDRED, ZERO_DOT_17_NINES, MULTIPLY, "99.99999999999999900");

        //first is 5000000000000000
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-4999999999999999.95000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-4999999999999999.5000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-4950000000000000.00");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_TENTH, MULTIPLY, "-4500000000000000.0");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_TENTH, MULTIPLY, "-500000000000000.0");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_NINE_HUNDREDTH, MULTIPLY, "-450000000000000.00");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NEG_ONE_HUNDREDTH, MULTIPLY, "-50000000000000.00");

        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_HUNDREDTH, MULTIPLY, "50000000000000.00");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_HUNDREDTH, MULTIPLY, "450000000000000.00");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ONE_TENTH, MULTIPLY, "500000000000000.0");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINE_TENTH, MULTIPLY, "4500000000000000.0");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, NINETY_NINE_HUNDREDTH, MULTIPLY, "4950000000000000.00");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_16_NINES, MULTIPLY, "4999999999999999.5000000000000000");
        checkBinaryOperation(HALF_MAX_VALUE_ON_SCREEN, ZERO_DOT_17_NINES, MULTIPLY, "4999999999999999.95000000000000000");

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
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.90000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999.0000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9900000000000000.00");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_TENTH, MULTIPLY, "-9000000000000000.0");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_TENTH, MULTIPLY, "-1000000000000000.0");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_NINE_HUNDREDTH, MULTIPLY, "-900000000000000.00");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NEG_ONE_HUNDREDTH, MULTIPLY, "-100000000000000.00");

        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_HUNDREDTH, MULTIPLY, "100000000000000.00");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_HUNDREDTH, MULTIPLY, "900000000000000.00");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ONE_TENTH, MULTIPLY, "1000000000000000.0");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINE_TENTH, MULTIPLY, "9000000000000000.0");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, NINETY_NINE_HUNDREDTH, MULTIPLY, "9900000000000000.00");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999.0000000000000000");
        checkBinaryOperation(MAX_VALUE_ON_SCREEN_PLUS_ONE, ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.90000000000000000");


        //decimals only
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

        //engineer numbers
        //with engineer numbers
        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, MULTIPLY, "1.E+34");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, MULTIPLY, "1.E+33");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, MULTIPLY, "-1.E+33");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, MULTIPLY, "-1.E+34");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, MULTIPLY, "1.E+32");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, MULTIPLY, "-1.E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, MULTIPLY, "-1.E+33");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, MULTIPLY, "1.E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, MULTIPLY, "1.E+33");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, MULTIPLY, "1.E+34");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, MULTIPLY, "1.E-34");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, MULTIPLY, "1.E-33");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, MULTIPLY, "-1.E-33");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, MULTIPLY, "-1.E-34");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, MULTIPLY, "1.E-32");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, MULTIPLY, "-1.E-32");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, MULTIPLY, "-1.E-33");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, MULTIPLY, "1.E-32");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, MULTIPLY, "1.E-33");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, MULTIPLY, "1.E-34");

        //with integers
        //first is -1.E-9999
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.0000000000000000E-9983");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E-9984");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998E-9984");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E-9984");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_HUNDRED, MULTIPLY, "1.00E-9997");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_TEN, MULTIPLY, "1.0E-9998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE, MULTIPLY, "1.E-9999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, MULTIPLY, "0.E-9999");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.ONE, MULTIPLY, "-1.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, BigDecimal.TEN, MULTIPLY, "-1.0E-9998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HUNDRED, MULTIPLY, "-1.00E-9997");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E-9984");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998E-9984");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E-9984");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.0000000000000000E-9983");

        //first is -1.E-9998
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.0000000000000000E-9982");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E-9983");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998E-9983");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E-9983");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_HUNDRED, MULTIPLY, "1.00E-9996");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_TEN, MULTIPLY, "1.0E-9997");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE, MULTIPLY, "1.E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, MULTIPLY, "0.E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.ONE, MULTIPLY, "-1.E-9998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, BigDecimal.TEN, MULTIPLY, "-1.0E-9997");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HUNDRED, MULTIPLY, "-1.00E-9996");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E-9983");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998E-9983");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E-9983");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.0000000000000000E-9982");

        //first is 1.E-9998
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.0000000000000000E-9982");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E-9983");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998E-9983");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E-9983");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_HUNDRED, MULTIPLY, "-1.00E-9996");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_TEN, MULTIPLY, "-1.0E-9997");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, NEG_ONE, MULTIPLY, "-1.E-9998");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ZERO, MULTIPLY, "0.E-9998");

        checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.ONE, MULTIPLY, "1.E-9998");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, BigDecimal.TEN, MULTIPLY, "1.0E-9997");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, HUNDRED, MULTIPLY, "1.00E-9996");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E-9983");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998E-9983");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E-9983");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.0000000000000000E-9982");

        //first is 1.E-9999
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.0000000000000000E-9983");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E-9984");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998E-9984");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E-9984");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_HUNDRED, MULTIPLY, "-1.00E-9997");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_TEN, MULTIPLY, "-1.0E-9998");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, NEG_ONE, MULTIPLY, "-1.E-9999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ZERO, MULTIPLY, "0.E-9999");

        checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.ONE, MULTIPLY, "1.E-9999");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, BigDecimal.TEN, MULTIPLY, "1.0E-9998");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, HUNDRED, MULTIPLY, "1.00E-9997");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E-9984");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998E-9984");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E-9984");
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.0000000000000000E-9983");

        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.0000000000000000E+33");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, MULTIPLY, "1.00E+19");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, MULTIPLY, "1.0E+18");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, MULTIPLY, "1.E+17");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, MULTIPLY, "0.E+17");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, MULTIPLY, "-1.E+17");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, MULTIPLY, "-1.0E+18");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, MULTIPLY, "-1.00E+19");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.0000000000000000E+33");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.0000000000000000E+32");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E+31");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9.999999999999998E+31");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E+31");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, MULTIPLY, "1.00E+18");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, MULTIPLY, "1.0E+17");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, MULTIPLY, "1.E+16");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, MULTIPLY, "0.E+16");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, MULTIPLY, "-1.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, MULTIPLY, "-1.0E+17");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, MULTIPLY, "-1.00E+18");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E+31");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9.999999999999998E+31");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E+31");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.0000000000000000E+32");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.0000000000000000E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E+31");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998E+31");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E+31");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, MULTIPLY, "-1.00E+18");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, MULTIPLY, "-1.0E+17");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, MULTIPLY, "-1E+16");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, MULTIPLY, "0.E+16");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, MULTIPLY, "1E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, MULTIPLY, "1.0E+17");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, MULTIPLY, "1.00E+18");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E+31");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998E+31");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E+31");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.0000000000000000E+32");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.0000000000000000E+33");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9.999999999999999E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9.999999999999998E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5.000000000000000E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, MULTIPLY, "-1.00E+19");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, MULTIPLY, "-1.0E+18");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, MULTIPLY, "-1.E+17");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, MULTIPLY, "0.E+17");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, MULTIPLY, "1.E+17");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, MULTIPLY, "1.0E+18");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, MULTIPLY, "1.00E+19");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5.000000000000000E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9.999999999999998E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "9.999999999999999E+32");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.0000000000000000E+33");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0.10000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "0.09999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0.09999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "0.05000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, MULTIPLY, "1.00E-15");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, MULTIPLY, "1.0E-16");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, MULTIPLY, "1E-17");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, MULTIPLY, "0.E-17");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, MULTIPLY, "-1E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, MULTIPLY, "-1.0E-16");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, MULTIPLY, "-1.00E-15");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.05000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-0.09999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.09999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-0.10000000000000000");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "1.0000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "0.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0.9999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "0.5000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, MULTIPLY, "1.00E-14");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, MULTIPLY, "1.0E-15");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, MULTIPLY, "1.E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, MULTIPLY, "0.E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, MULTIPLY, "-1.E-16");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, MULTIPLY, "-1.0E-15");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, MULTIPLY, "-1.00E-14");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.5000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-0.9999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "-0.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-1.0000000000000000");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-1.0000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-0.9999999999999998");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.5000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, MULTIPLY, "-1.00E-14");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, MULTIPLY, "-1.0E-15");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, MULTIPLY, "-1.E-16");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, MULTIPLY, "0.E-16");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, MULTIPLY, "1.E-16");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, MULTIPLY, "1.0E-15");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, MULTIPLY, "1.00E-14");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "0.5000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0.9999999999999998");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "0.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "1.0000000000000000");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-0.10000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.09999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-0.09999999999999998");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-0.05000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, MULTIPLY, "-1.00E-15");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, MULTIPLY, "-1.0E-16");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, MULTIPLY, "-1E-17");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, MULTIPLY, "0.E-17");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, MULTIPLY, "1E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, MULTIPLY, "1.0E-16");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, MULTIPLY, "1.00E-15");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "0.05000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0.09999999999999998");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "0.09999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0.10000000000000000");


        //with decimals
        //first is -1.E+9999
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINE_TENTH, MULTIPLY, "9.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, MULTIPLY, "1.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_NINE_HUNDREDTH, MULTIPLY, "9.E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, MULTIPLY, "1.E+9997");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, MULTIPLY, "-1.E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NINE_HUNDREDTH, MULTIPLY, "-9.E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_TENTH, MULTIPLY, "-1.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NINE_TENTH, MULTIPLY, "-9.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E+9998");

        //first is -1.E+9998
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINE_TENTH, MULTIPLY, "9.E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, MULTIPLY, "1.E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_NINE_HUNDREDTH, MULTIPLY, "9.E+9996");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, MULTIPLY, "1.E+9996");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, MULTIPLY, "-1.E+9996");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NINE_HUNDREDTH, MULTIPLY, "-9.E+9996");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_TENTH, MULTIPLY, "-1.E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NINE_TENTH, MULTIPLY, "-9.E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E+9997");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E+9997");

        //first is 1.E+9998
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_NINE_TENTH, MULTIPLY, "-9.E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_TENTH, MULTIPLY, "-1.E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.E+9996");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.E+9996");

        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_HUNDREDTH, MULTIPLY, "1.E+9996");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NINE_HUNDREDTH, MULTIPLY, "9.E+9996");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_TENTH, MULTIPLY, "1.E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NINE_TENTH, MULTIPLY, "9.E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E+9997");

        //first is 1.E+9999
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_NINE_TENTH, MULTIPLY, "-9.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_TENTH, MULTIPLY, "-1.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.E+9997");

        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_HUNDREDTH, MULTIPLY, "1.E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NINE_HUNDREDTH, MULTIPLY, "9.E+9997");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_TENTH, MULTIPLY, "1.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NINE_TENTH, MULTIPLY, "9.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E+9998");

        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, MULTIPLY, "9.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, MULTIPLY, "1.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "9.E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "1.E+15");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, MULTIPLY, "-1.E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, MULTIPLY, "-9.E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_TENTH, MULTIPLY, "-1.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_TENTH, MULTIPLY, "-9.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, MULTIPLY, "-99999999999999999");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.9");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, MULTIPLY, "9.E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, MULTIPLY, "1.E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "9.E+14");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "1.E+14");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, MULTIPLY, "-1.E+14");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, MULTIPLY, "-9.E+14");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_TENTH, MULTIPLY, "-1.E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_TENTH, MULTIPLY, "-9.E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+15");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.9");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.9");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, MULTIPLY, "-9.E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, MULTIPLY, "-1.E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.E+14");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.E+14");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, MULTIPLY, "1.E+14");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, MULTIPLY, "9.E+14");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_TENTH, MULTIPLY, "1.E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_TENTH, MULTIPLY, "9.E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.9");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-99999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, MULTIPLY, "-9.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, MULTIPLY, "-1.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.E+15");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, MULTIPLY, "1.E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, MULTIPLY, "9.E+15");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_TENTH, MULTIPLY, "1.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_TENTH, MULTIPLY, "9.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, MULTIPLY, "99999999999999999");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, MULTIPLY, "9.E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, MULTIPLY, "1.E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "9.E-19");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "1.E-19");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, MULTIPLY, "-1.E-19");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, MULTIPLY, "-9.E-19");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_TENTH, MULTIPLY, "-1.E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_TENTH, MULTIPLY, "-9.E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E-18");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, MULTIPLY, "9.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, MULTIPLY, "1.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "9.E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "1.E-18");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, MULTIPLY, "-1.E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, MULTIPLY, "-9.E-18");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_TENTH, MULTIPLY, "-1.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_TENTH, MULTIPLY, "-9.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E-17");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, MULTIPLY, "-9.E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, MULTIPLY, "-1.E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.E-18");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, MULTIPLY, "1.E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, MULTIPLY, "9.E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_TENTH, MULTIPLY, "1.E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_TENTH, MULTIPLY, "9.E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E-17");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E-17");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-9.9999999999999999E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-9.999999999999999E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-9.9E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, MULTIPLY, "-9.E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, MULTIPLY, "-1.E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "-9.E-19");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.E-19");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, MULTIPLY, "1.E-19");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, MULTIPLY, "9.E-19");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_TENTH, MULTIPLY, "1.E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_TENTH, MULTIPLY, "9.E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "9.9E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, MULTIPLY, "9.999999999999999E-18");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, MULTIPLY, "9.9999999999999999E-18");


        //several random values
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
        checkBinaryOperation(new BigDecimal("-76"), new BigDecimal("-13.5"), MULTIPLY, "1026.0");
        checkBinaryOperation(new BigDecimal("33.12"), new BigDecimal("6.13"), MULTIPLY, "203.0256");
        checkBinaryOperation(new BigDecimal("86.7"), new BigDecimal("5.132"), MULTIPLY, "444.9444");
        checkBinaryOperation(new BigDecimal("1.75"), new BigDecimal("-0.1"), MULTIPLY, "-0.175");
        checkBinaryOperation(new BigDecimal("23.5"), new BigDecimal("-6.87"), MULTIPLY, "-161.445");
        checkBinaryOperation(new BigDecimal("-765.1"), new BigDecimal("-1.8"), MULTIPLY, "1377.18");
        checkBinaryOperation(new BigDecimal("-65.7"), new BigDecimal("-7.8"), MULTIPLY, "512.46");
    }

    private void checkBinaryOperation(BigDecimal first, BigDecimal second, BinaryOperations operation, String result) {
        calculation.setFirst(first);
        calculation.setSecond(second);
        calculation.setBinaryOperation(operation);
        calculation.calculateBinary();

        assertEquals(new BigDecimal(result), calculation.getResult());

        if (operation == ADD || operation == MULTIPLY) {
            calculation.setFirst(second);
            calculation.setSecond(first);
            calculation.calculateBinary();

            assertEquals(new BigDecimal(result), calculation.getResult());
        }
    }
}