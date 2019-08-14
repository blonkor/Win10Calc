import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperations;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.implemica.bormashenko.calculator.model.enums.BinaryOperations.*;

class ModelTest {

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
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-1.99999999999999998");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-1.99999999999999989");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-1.98999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_TENTH, MULTIPLY, "-1.89999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_TENTH, MULTIPLY, "-1.09999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_NINE_HUNDREDTH, MULTIPLY, "-1.08999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.00999999999999999");

        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_HUNDREDTH, MULTIPLY, "-0.98999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_HUNDREDTH, MULTIPLY, "-0.90999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ONE_TENTH, MULTIPLY, "-0.89999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINE_TENTH, MULTIPLY, "-0.09999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.00999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_16_NINES, MULTIPLY, "-0.00000000000000009");
        checkBinaryOperation(NEG_ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, MULTIPLY, "0.00000000000000000");

        //first is -0.9999999999999999
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-1.9999999999999998");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-1.9899999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_TENTH, MULTIPLY, "-1.8999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_TENTH, MULTIPLY, "-1.0999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_NINE_HUNDREDTH, MULTIPLY, "-1.0899999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.0099999999999999");

        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_HUNDREDTH, MULTIPLY, "-0.9899999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_HUNDREDTH, MULTIPLY, "-0.9099999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ONE_TENTH, MULTIPLY, "-0.8999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINE_TENTH, MULTIPLY, "-0.0999999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.0099999999999999");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, MULTIPLY, "0.0000000000000000");
        checkBinaryOperation(NEG_ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, MULTIPLY, "0.00000000000000009");

        //first is -0.99
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-1.98");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_TENTH, MULTIPLY, "-1.89");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_TENTH, MULTIPLY, "-1.09");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, MULTIPLY, "-1.08");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, MULTIPLY, "-1.00");

        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "-0.98");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "-0.90");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ONE_TENTH, MULTIPLY, "-0.89");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINE_TENTH, MULTIPLY, "-0.09");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "0.0099999999999999");
        checkBinaryOperation(NEG_NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "0.00999999999999999");

        //first is -0.9
        checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_TENTH, MULTIPLY, "-1.8");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_TENTH, MULTIPLY, "-1.0");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.99");
        checkBinaryOperation(NEG_NINE_TENTH, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.91");

        checkBinaryOperation(NEG_NINE_TENTH, ONE_HUNDREDTH, MULTIPLY, "-0.89");
        checkBinaryOperation(NEG_NINE_TENTH, NINE_HUNDREDTH, MULTIPLY, "-0.81");
        checkBinaryOperation(NEG_NINE_TENTH, ONE_TENTH, MULTIPLY, "-0.8");
        checkBinaryOperation(NEG_NINE_TENTH, NINE_TENTH, MULTIPLY, "0.0");
        checkBinaryOperation(NEG_NINE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.09");
        checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "0.0999999999999999");
        checkBinaryOperation(NEG_NINE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "0.09999999999999999");

        //first is -0.1
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_TENTH, MULTIPLY, "-0.2");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.19");
        checkBinaryOperation(NEG_ONE_TENTH, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.11");

        checkBinaryOperation(NEG_ONE_TENTH, ONE_HUNDREDTH, MULTIPLY, "-0.09");
        checkBinaryOperation(NEG_ONE_TENTH, NINE_HUNDREDTH, MULTIPLY, "-0.01");
        checkBinaryOperation(NEG_ONE_TENTH, ONE_TENTH, MULTIPLY, "0.0");
        checkBinaryOperation(NEG_ONE_TENTH, NINE_TENTH, MULTIPLY, "0.8");
        checkBinaryOperation(NEG_ONE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.89");
        checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "0.8999999999999999");
        checkBinaryOperation(NEG_ONE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "0.89999999999999999");

        //first is -0.09
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.18");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.10");

        checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "-0.08");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ONE_TENTH, MULTIPLY, "0.01");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINE_TENTH, MULTIPLY, "0.81");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.90");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "0.9099999999999999");
        checkBinaryOperation(NEG_NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "0.90999999999999999");

        //first is -0.01
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.02");

        checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "0.00");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "0.08");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ONE_TENTH, MULTIPLY, "0.09");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINE_TENTH, MULTIPLY, "0.89");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.98");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "0.9899999999999999");
        checkBinaryOperation(NEG_ONE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "0.98999999999999999");

        //first is 0.01
        checkBinaryOperation(ONE_HUNDREDTH, ONE_HUNDREDTH, MULTIPLY, "0.02");
        checkBinaryOperation(ONE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "0.10");
        checkBinaryOperation(ONE_HUNDREDTH, ONE_TENTH, MULTIPLY, "0.11");
        checkBinaryOperation(ONE_HUNDREDTH, NINE_TENTH, MULTIPLY, "0.91");
        checkBinaryOperation(ONE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "1.00");
        checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "1.0099999999999999");
        checkBinaryOperation(ONE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "1.00999999999999999");

        //first is 0.09
        checkBinaryOperation(NINE_HUNDREDTH, NINE_HUNDREDTH, MULTIPLY, "0.18");
        checkBinaryOperation(NINE_HUNDREDTH, ONE_TENTH, MULTIPLY, "0.19");
        checkBinaryOperation(NINE_HUNDREDTH, NINE_TENTH, MULTIPLY, "0.99");
        checkBinaryOperation(NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "1.08");
        checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "1.0899999999999999");
        checkBinaryOperation(NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "1.08999999999999999");

        //first is 0.1
        checkBinaryOperation(ONE_TENTH, ONE_TENTH, MULTIPLY, "0.2");
        checkBinaryOperation(ONE_TENTH, NINE_TENTH, MULTIPLY, "1.0");
        checkBinaryOperation(ONE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "1.09");
        checkBinaryOperation(ONE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "1.0999999999999999");
        checkBinaryOperation(ONE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "1.09999999999999999");

        //first is 0.9
        checkBinaryOperation(NINE_TENTH, NINE_TENTH, MULTIPLY, "1.8");
        checkBinaryOperation(NINE_TENTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "1.89");
        checkBinaryOperation(NINE_TENTH, ZERO_DOT_16_NINES, MULTIPLY, "1.8999999999999999");
        checkBinaryOperation(NINE_TENTH, ZERO_DOT_17_NINES, MULTIPLY, "1.89999999999999999");

        //first is 0.99
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, NINETY_NINE_HUNDREDTH, MULTIPLY, "1.98");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_16_NINES, MULTIPLY, "1.9899999999999999");
        checkBinaryOperation(NINETY_NINE_HUNDREDTH, ZERO_DOT_17_NINES, MULTIPLY, "1.98999999999999999");

        //first is 0.9999999999999999
        checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_16_NINES, MULTIPLY, "1.9999999999999998");
        checkBinaryOperation(ZERO_DOT_16_NINES, ZERO_DOT_17_NINES, MULTIPLY, "1.99999999999999989");

        //first is 0.99999999999999999
        checkBinaryOperation(ZERO_DOT_17_NINES, ZERO_DOT_17_NINES, MULTIPLY, "1.99999999999999998");

        //engineer numbers
        //with engineer numbers
        //first is -1.E+9999
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9999, MULTIPLY, "-2.E+9999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, NEG_ONE_DOT_E_PLUS_9998, MULTIPLY, "-1.1E+9999");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9998, MULTIPLY, "-9.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, MULTIPLY, "0.E+9999");

        //first is -1.E+9998
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, NEG_ONE_DOT_E_PLUS_9998, MULTIPLY, "-2.E+9998");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, MULTIPLY, "0.E+9998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, MULTIPLY, "9.E+9998");

        //first is 1.E+9998
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9998, MULTIPLY, "2.E+9998");
        checkBinaryOperation(ONE_DOT_E_PLUS_9998, ONE_DOT_E_PLUS_9999, MULTIPLY, "1.1E+9999");

        //first is 1.E+9999
        checkBinaryOperation(ONE_DOT_E_PLUS_9999, ONE_DOT_E_PLUS_9999, MULTIPLY, "2.E+9999");

        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_17, MULTIPLY, "-2.E+17");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_DOT_E_PLUS_16, MULTIPLY, "-1.1E+17");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_16, MULTIPLY, "-9.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, MULTIPLY, "0.E+17");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_DOT_E_PLUS_16, MULTIPLY, "-2.E+16");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, MULTIPLY, "0.E+16");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, MULTIPLY, "9.E+16");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_16, MULTIPLY, "2.E+16");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_DOT_E_PLUS_17, MULTIPLY, "1.1E+17");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_DOT_E_PLUS_17, MULTIPLY, "2.E+17");

        //first is -1.E-9999
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9999, MULTIPLY, "-2.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, NEG_ONE_DOT_E_MINUS_9998, MULTIPLY, "-1.1E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9998, MULTIPLY, "9.E-9999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, MULTIPLY, "0.E-9999");

        //first is -1.E-9998
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, NEG_ONE_DOT_E_MINUS_9998, MULTIPLY, "-2E-9998");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, MULTIPLY, "0.E-9998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, MULTIPLY, "-9.E-9999");

        //first is 1.E-9998
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9998, MULTIPLY, "2.E-9998");
        checkBinaryOperation(ONE_DOT_E_MINUS_9998, ONE_DOT_E_MINUS_9999, MULTIPLY, "1.1E-9998");

        //first is 1.E-9999
        checkBinaryOperation(ONE_DOT_E_MINUS_9999, ONE_DOT_E_MINUS_9999, MULTIPLY, "2.E-9999");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_17, MULTIPLY, "-2.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_DOT_E_MINUS_16, MULTIPLY, "-1.1E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_16, MULTIPLY, "9.E-17");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, MULTIPLY, "0.E-17");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_DOT_E_MINUS_16, MULTIPLY, "-2E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, MULTIPLY, "0.E-16");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, MULTIPLY, "-9.E-17");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_16, MULTIPLY, "2.E-16");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_DOT_E_MINUS_17, MULTIPLY, "1.1E-16");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_DOT_E_MINUS_17, MULTIPLY, "2.E-17");

        //with integers
        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-110000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "-109999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-109999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-105000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_HUNDRED, MULTIPLY, "-100000000000000100");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_TEN, MULTIPLY, "-100000000000000010");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE, MULTIPLY, "-100000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ZERO, MULTIPLY, "-100000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.ONE, MULTIPLY, "-99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, BigDecimal.TEN, MULTIPLY, "-99999999999999990");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HUNDRED, MULTIPLY, "-99999999999999900");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-95000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-90000000000000002");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "-90000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-90000000000000000");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-20000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "-19999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-19999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-15000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_HUNDRED, MULTIPLY, "-10000000000000100");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_TEN, MULTIPLY, "-10000000000000010");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE, MULTIPLY, "-10000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ZERO, MULTIPLY, "-10000000000000000");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.ONE, MULTIPLY, "-9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, BigDecimal.TEN, MULTIPLY, "-9999999999999990");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HUNDRED, MULTIPLY, "-9999999999999900");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "-5000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-2");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "-1");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "0");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "0");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "1");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "2");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "5000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_HUNDRED, MULTIPLY, "9999999999999900");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_TEN, MULTIPLY, "9999999999999990");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE, MULTIPLY, "9999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ZERO, MULTIPLY, "10000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.ONE, MULTIPLY, "10000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, BigDecimal.TEN, MULTIPLY, "10000000000000010");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HUNDRED, MULTIPLY, "10000000000000100");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "15000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "19999999999999998");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "19999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "20000000000000000");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "90000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "90000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "90000000000000002");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "95000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_HUNDRED, MULTIPLY, "99999999999999900");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_TEN, MULTIPLY, "99999999999999990");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE, MULTIPLY, "99999999999999999");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ZERO, MULTIPLY, "100000000000000000");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.ONE, MULTIPLY, "100000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, BigDecimal.TEN, MULTIPLY, "100000000000000010");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HUNDRED, MULTIPLY, "100000000000000100");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "105000000000000000");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "109999999999999998");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "109999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "110000000000000000");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-10000000000000000.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9999999999999999.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9999999999999998.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5000000000000000.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_HUNDRED, MULTIPLY, "-100.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_TEN, MULTIPLY, "-10.00000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE, MULTIPLY, "-1.00000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ZERO, MULTIPLY, "-1.E-17");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.ONE, MULTIPLY, "0.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, BigDecimal.TEN, MULTIPLY, "9.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HUNDRED, MULTIPLY, "99.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "4999999999999999.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9999999999999997.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "9999999999999998.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9999999999999999.99999999999999999");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-10000000000000000.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9999999999999999.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9999999999999998.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-5000000000000000.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_HUNDRED, MULTIPLY, "-100.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_TEN, MULTIPLY, "-10.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE, MULTIPLY, "-1.0000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ZERO, MULTIPLY, "-1.E-16");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.ONE, MULTIPLY, "0.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, BigDecimal.TEN, MULTIPLY, "9.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HUNDRED, MULTIPLY, "99.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "4999999999999999.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9999999999999997.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "9999999999999998.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "9999999999999999.9999999999999999");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9999999999999999.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9999999999999998.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9999999999999997.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-4999999999999999.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_HUNDRED, MULTIPLY, "-99.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_TEN, MULTIPLY, "-9.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE, MULTIPLY, "-0.9999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ZERO, MULTIPLY, "1.E-16");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.ONE, MULTIPLY, "1.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, BigDecimal.TEN, MULTIPLY, "10.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HUNDRED, MULTIPLY, "100.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5000000000000000.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9999999999999998.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN, MULTIPLY, "9999999999999999.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "10000000000000000.0000000000000001");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "-9999999999999999.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN, MULTIPLY, "-9999999999999998.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MIN_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "-9999999999999997.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MIN_VALUE_ON_SCREEN, MULTIPLY, "-4999999999999999.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_HUNDRED, MULTIPLY, "-99.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_TEN, MULTIPLY, "-9.99999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE, MULTIPLY, "-0.99999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ZERO, MULTIPLY, "1.E-17");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.ONE, MULTIPLY, "1.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, BigDecimal.TEN, MULTIPLY, "10.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HUNDRED, MULTIPLY, "100.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, HALF_MAX_VALUE_ON_SCREEN, MULTIPLY, "5000000000000000.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_MINUS_ONE, MULTIPLY, "9999999999999998.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN, MULTIPLY, "9999999999999999.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, MAX_VALUE_ON_SCREEN_PLUS_ONE, MULTIPLY, "10000000000000000.00000000000000001");

        //with decimals
        //first is -1.E+17
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-100000000000000000.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-100000000000000000.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-100000000000000000.99");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, MULTIPLY, "-100000000000000000.9");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, MULTIPLY, "-100000000000000000.1");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "-100000000000000000.09");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "-100000000000000000.01");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, MULTIPLY, "-99999999999999999.99");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, MULTIPLY, "-99999999999999999.91");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ONE_TENTH, MULTIPLY, "-99999999999999999.9");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINE_TENTH, MULTIPLY, "-99999999999999999.1");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "-99999999999999999.01");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, MULTIPLY, "-99999999999999999.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, MULTIPLY, "-99999999999999999.00000000000000001");

        //first is -1.E+16
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-10000000000000000.99999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-10000000000000000.9999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-10000000000000000.99");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, MULTIPLY, "-10000000000000000.9");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, MULTIPLY, "-10000000000000000.1");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "-10000000000000000.09");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "-10000000000000000.01");

        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, MULTIPLY, "-9999999999999999.99");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, MULTIPLY, "-9999999999999999.91");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ONE_TENTH, MULTIPLY, "-9999999999999999.9");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINE_TENTH, MULTIPLY, "-9999999999999999.1");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "-9999999999999999.01");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, MULTIPLY, "-9999999999999999.0000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, MULTIPLY, "-9999999999999999.00000000000000001");

        //first is 1.E+16
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "9999999999999999.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "9999999999999999.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "9999999999999999.01");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_TENTH, MULTIPLY, "9999999999999999.1");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_TENTH, MULTIPLY, "9999999999999999.9");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "9999999999999999.91");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "9999999999999999.99");

        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_HUNDREDTH, MULTIPLY, "10000000000000000.01");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_HUNDREDTH, MULTIPLY, "10000000000000000.09");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ONE_TENTH, MULTIPLY, "10000000000000000.1");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NINE_TENTH, MULTIPLY, "10000000000000000.9");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "10000000000000000.99");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_16_NINES, MULTIPLY, "10000000000000000.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_16, ZERO_DOT_17_NINES, MULTIPLY, "10000000000000000.99999999999999999");

        //first is 1.E+17
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "99999999999999999.00000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "99999999999999999.0000000000000001");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "99999999999999999.01");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_TENTH, MULTIPLY, "99999999999999999.1");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_TENTH, MULTIPLY, "99999999999999999.9");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "99999999999999999.91");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "99999999999999999.99");

        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_HUNDREDTH, MULTIPLY, "100000000000000000.01");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_HUNDREDTH, MULTIPLY, "100000000000000000.09");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ONE_TENTH, MULTIPLY, "100000000000000000.1");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NINE_TENTH, MULTIPLY, "100000000000000000.9");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "100000000000000000.99");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_16_NINES, MULTIPLY, "100000000000000000.9999999999999999");
        checkBinaryOperation(ONE_DOT_E_PLUS_17, ZERO_DOT_17_NINES, MULTIPLY, "100000000000000000.99999999999999999");

        //first is -1.E-17
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-1.00000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-0.99999999999999991");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.99000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, MULTIPLY, "-0.90000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, MULTIPLY, "-0.10000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.09000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.01000000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, MULTIPLY, "0.00999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, MULTIPLY, "0.08999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ONE_TENTH, MULTIPLY, "0.09999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINE_TENTH, MULTIPLY, "0.89999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.98999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, MULTIPLY, "0.99999999999999989");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, MULTIPLY, "0.99999999999999998");

        //first is -1.E-16
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-1.00000000000000009");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-1.0000000000000000");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.9900000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, MULTIPLY, "-0.9000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, MULTIPLY, "-0.1000000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.0900000000000001");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.0100000000000001");

        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, MULTIPLY, "0.0099999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, MULTIPLY, "0.0899999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ONE_TENTH, MULTIPLY, "0.0999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINE_TENTH, MULTIPLY, "0.8999999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.9899999999999999");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, MULTIPLY, "0.9999999999999998");
        checkBinaryOperation(NEG_ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, MULTIPLY, "0.99999999999999989");

        //first is 1.E-16
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-0.99999999999999989");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-0.9999999999999998");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.9899999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_TENTH, MULTIPLY, "-0.8999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_TENTH, MULTIPLY, "-0.0999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.0899999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.0099999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_HUNDREDTH, MULTIPLY, "0.0100000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_HUNDREDTH, MULTIPLY, "0.0900000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ONE_TENTH, MULTIPLY, "0.1000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NINE_TENTH, MULTIPLY, "0.9000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.9900000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_16_NINES, MULTIPLY, "1.0000000000000000");
        checkBinaryOperation(ONE_DOT_E_MINUS_16, ZERO_DOT_17_NINES, MULTIPLY, "1.00000000000000009");

        //first is 1.E-17
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_17_NINES, MULTIPLY, "-0.99999999999999998");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ZERO_DOT_16_NINES, MULTIPLY, "-0.99999999999999989");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINETY_NINE_HUNDREDTH, MULTIPLY, "-0.98999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_TENTH, MULTIPLY, "-0.89999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_TENTH, MULTIPLY, "-0.09999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_NINE_HUNDREDTH, MULTIPLY, "-0.08999999999999999");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NEG_ONE_HUNDREDTH, MULTIPLY, "-0.00999999999999999");

        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_HUNDREDTH, MULTIPLY, "0.01000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_HUNDREDTH, MULTIPLY, "0.09000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ONE_TENTH, MULTIPLY, "0.10000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NINE_TENTH, MULTIPLY, "0.90000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, NINETY_NINE_HUNDREDTH, MULTIPLY, "0.99000000000000001");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_16_NINES, MULTIPLY, "0.99999999999999991");
        checkBinaryOperation(ONE_DOT_E_MINUS_17, ZERO_DOT_17_NINES, MULTIPLY, "1.00000000000000000");

        //several random values
        checkBinaryOperation(new BigDecimal("197"), new BigDecimal("8763"), MULTIPLY, "8960");
        checkBinaryOperation(new BigDecimal("36346"), new BigDecimal("62"), MULTIPLY, "36408");
        checkBinaryOperation(new BigDecimal("62"), new BigDecimal("-542"), MULTIPLY, "-480");
        checkBinaryOperation(new BigDecimal("7654"), new BigDecimal("-62"), MULTIPLY, "7592");
        checkBinaryOperation(new BigDecimal("-53252"), new BigDecimal("-52"), MULTIPLY, "-53304");
        checkBinaryOperation(new BigDecimal("-1243"), new BigDecimal("-65"), MULTIPLY, "-1308");
        checkBinaryOperation(new BigDecimal("623"), new BigDecimal("124.123"), MULTIPLY, "747.123");
        checkBinaryOperation(new BigDecimal("324"), new BigDecimal("653.523"), MULTIPLY, "977.523");
        checkBinaryOperation(new BigDecimal("7652"), new BigDecimal("-23.598"), MULTIPLY, "7628.402");
        checkBinaryOperation(new BigDecimal("2431"), new BigDecimal("-123.124"), MULTIPLY, "2307.876");
        checkBinaryOperation(new BigDecimal("-62"), new BigDecimal("76.43"), MULTIPLY, "14.43");
        checkBinaryOperation(new BigDecimal("-87"), new BigDecimal("876.1"), MULTIPLY, "789.1");
        checkBinaryOperation(new BigDecimal("-63"), new BigDecimal("-0.234"), MULTIPLY, "-63.234");
        checkBinaryOperation(new BigDecimal("-1967"), new BigDecimal("-22.76"), MULTIPLY, "-1989.76");
        checkBinaryOperation(new BigDecimal("53.14"), new BigDecimal("51.65"), MULTIPLY, "104.79");
        checkBinaryOperation(new BigDecimal("75.234"), new BigDecimal("75.234"), MULTIPLY, "150.468");
        checkBinaryOperation(new BigDecimal("64.26"), new BigDecimal("-25.7"), MULTIPLY, "38.56");
        checkBinaryOperation(new BigDecimal("623.3"), new BigDecimal("-75.2"), MULTIPLY, "548.1");
        checkBinaryOperation(new BigDecimal("-532.1"), new BigDecimal("-2.2"), MULTIPLY, "-534.3");
        checkBinaryOperation(new BigDecimal("-622.2"), new BigDecimal("-25.6"), MULTIPLY, "-647.8");
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