package tests.model;

import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.BinaryOperation;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperation;
import com.implemica.bormashenko.calculator.model.exceptions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.*;
import static com.implemica.bormashenko.calculator.model.enums.UnaryOperation.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link Calculation}.
 *
 * @author Mykhailo Bormashenko
 */
class CalculationModelTest {

    /**
     * Exception message for {@link OverflowException}.
     */
    private static final String OVERFLOW_MESSAGE = "Overflow";

    /**
     * Exception message for divide by zero {@link ArithmeticException}.
     */
    private static final String DIVIDE_BY_ZERO_MESSAGE = "Cannot divide by zero";

    /**
     * Exception message for divide zero by zero {@link ArithmeticException}.
     */
    private static final String DIVIDE_ZERO_BY_ZERO_MESSAGE = "Result is undefined";

    /**
     * Exception message for invalid input {@link ArithmeticException}.
     */
    private static final String INVALID_INPUT_MESSAGE = "Invalid input";

    /**
     * Object of {@link Calculation}.
     */
    private static Calculation calculation;

    /**
     * Setting up an object of {@link Calculation}.
     *
     * @see Calculation
     */
    @BeforeAll
    static void setupObject() {
        calculation = new Calculation();
    }

    /**
     * Test for reset all operation.
     */
    @Test
    void resetAllTests() {
        calculation.setFirst(BigDecimal.ONE);
        calculation.setSecond(BigDecimal.TEN);
        calculation.setBinaryOperation(ADD);
        calculation.calculateBinary();

        calculation.resetAll();

        assertEquals(calculation.getFirst(), BigDecimal.ZERO);
        assertEquals(calculation.getSecond(), BigDecimal.ZERO);
        assertNull(calculation.getResult());
        assertNull(calculation.getBinaryOperation());
    }

    /**
     * Tests for add operation.
     */
    @Test
    void addOperationTests() {
        //easy cases
        checkAddOperation("2", "2", "4");
        checkAddOperation("-3", "-3", "-6");
        checkAddOperation("5.5", "3.2", "8.7");
        checkAddOperation("-10.2", "-7", "-17.2");
        checkAddOperation("7.4", "-5.1", "2.3");
        checkAddOperation("1.e+5", "1.e+8", "1.001e+8");
        checkAddOperation("1.e-20", "5.e-20", "6.e-20");

        //cases with zero
        checkAddOperation("0", "0", "0");
        checkAddOperation("2", "0", "2");
        checkAddOperation("-3", "0", "-3");
        checkAddOperation("5.5", "0", "5.5");
        checkAddOperation("0", "-7", "-7");
        checkAddOperation("0", "-5.1", "-5.1");
        checkAddOperation("0", "1.e+8", "1.e+8");

        //big numbers
        checkAddOperation("10000000000000000", "10000000000000000", "2.e+16");
        checkAddOperation("5000000000000000", "9999999999999999", "14999999999999999");
        checkAddOperation("1234567890987654321", "1", "1234567890987654322");
        checkAddOperation("100000000000000000000000000", "10",
                "1.0000000000000000000000001e+26");

        //with decimals
        checkAddOperation("10000000000000000", "0.1", "10000000000000000.1");
        checkAddOperation("5000000000000000", "0.9999999999999999",
                "5000000000000000.9999999999999999");
        checkAddOperation("1234567890987654321", "123.123", "1234567890987654444.123");
        checkAddOperation("100000000000000000000000000", "0.00000000000000000000000000001",
                "100000000000000000000000000.00000000000000000000000000001");

        //decimal and decimal
        checkAddOperation("0.0000000000001", "0.1", "0.1000000000001");
        checkAddOperation("0.0000000000000001", "0.9999999999999999", "1");
        checkAddOperation("1234567890.987654321", "123.123", "1234568014.110654321");
        checkAddOperation("0.01", "0.00000000000000000000000000001",
                "0.01000000000000000000000000001");

        //boundary
        checkAddOperation("8.e+9999", "1.e+9999", "9.e+9999");
        checkAddOperation("9.e+9999", "9.e+9998", "9.9e+9999");
        checkAddOperation("8.e-9999", "1.e-9999", "9.e-9999");
        checkAddOperation("9.e-9999", "9.e-9998", "9.9e-9998");

        checkAddOperation("-8.e+9999", "-1.e+9999", "-9.e+9999");
        checkAddOperation("-9.e+9999", "-9.e+9998", "-9.9e+9999");
        checkAddOperation("-8.e-9999", "-1.e-9999", "-9.e-9999");
        checkAddOperation("-9.e-9999", "-9.e-9998", "-9.9e-9998");

        //several random values
        checkAddOperation("197", "8763", "8.96e+3");
        checkAddOperation("36346", "62", "36408");

        checkAddOperation("62", "-542", "-4.8e+2");
        checkAddOperation("7654", "-62", "7592");

        checkAddOperation("-53252", "-52", "-53304");
        checkAddOperation("-1243", "-65", "-1308");

        checkAddOperation("623", "124.123", "747.123");
        checkAddOperation("324", "653.523", "977.523");

        checkAddOperation("7652", "-23.598", "7628.402");
        checkAddOperation("2431", "-123.124", "2307.876");

        checkAddOperation("-62", "76.43", "14.43");
        checkAddOperation("-87", "876.1", "789.1");

        checkAddOperation("-63", "-0.234", "-63.234");
        checkAddOperation("-1967", "-22.76", "-1989.76");

        checkAddOperation("53.14", "51.65", "104.79");
        checkAddOperation("75.234", "75.234", "150.468");

        checkAddOperation("64.26", "-25.7", "38.56");
        checkAddOperation("623.3", "-75.2", "548.1");

        checkAddOperation("-532.1", "-2.2", "-534.3");
        checkAddOperation("-622.2", "-25.6", "-647.8");
    }

    /**
     * Tests for subtract operation.
     */
    @Test
    void subtractOperationTests() {
        //easy cases
        checkSubtractOperation("2", "2", "0");
        checkSubtractOperation("-3", "-3", "0");

        checkSubtractOperation("5.5", "3.2", "2.3");
        checkSubtractOperation("3.2", "5.5", "-2.3");

        checkSubtractOperation("-10.2", "-7", "-3.2");
        checkSubtractOperation("-7", "-10.2", "3.2");

        checkSubtractOperation("7.4", "-5.1", "12.5");
        checkSubtractOperation("-5.1", "7.4", "-12.5");

        checkSubtractOperation("1.e+5", "1.e+8", "-9.99e+7");
        checkSubtractOperation("1.e+8", "1.e+5", "9.99e+7");

        checkSubtractOperation("1.e-20", "5.e-20", "-4.e-20");
        checkSubtractOperation("5.e-20", "1.e-20", "4.e-20");

        //cases with zero
        checkSubtractOperation("0", "0", "0");

        checkSubtractOperation("2", "0", "2");
        checkSubtractOperation("0", "2", "-2");

        checkSubtractOperation("-3", "0", "-3");
        checkSubtractOperation("0", "-3", "3");

        checkSubtractOperation("5.5", "0", "5.5");
        checkSubtractOperation("0", "5.5", "-5.5");

        checkSubtractOperation("-7", "0", "-7");
        checkSubtractOperation("0", "-7", "7");

        checkSubtractOperation("-5.1", "0", "-5.1");
        checkSubtractOperation("0", "-5.1", "5.1");

        checkSubtractOperation("1.e+8", "0", "1.e+8");
        checkSubtractOperation("0", "1.e+8", "-1.e+8");

        //big numbers
        checkSubtractOperation("10000000000000000", "10000000000000000", "0");

        checkSubtractOperation("5000000000000000", "9999999999999999", "-4999999999999999");
        checkSubtractOperation("9999999999999999", "5000000000000000", "4999999999999999");

        checkSubtractOperation("1234567890987654321", "1", "1.23456789098765432e+18");
        checkSubtractOperation("1", "1234567890987654321", "-1.23456789098765432e+18");

        checkSubtractOperation("100000000000000000000000000", "10",
                "9.999999999999999999999999e+25");
        checkSubtractOperation("10", "100000000000000000000000000",
                "-9.999999999999999999999999e+25");

        //with decimals
        checkSubtractOperation("10000000000000000", "0.1", "9999999999999999.9");
        checkSubtractOperation("0.1", "10000000000000000", "-9999999999999999.9");

        checkSubtractOperation("5000000000000000", "0.9999999999999999",
                "4999999999999999.0000000000000001");
        checkSubtractOperation("0.9999999999999999", "5000000000000000",
                "-4999999999999999.0000000000000001");

        checkSubtractOperation("1234567890987654321", "123.123", "1234567890987654197.877");
        checkSubtractOperation("123.123", "1234567890987654321", "-1234567890987654197.877");

        checkSubtractOperation("100000000000000000000000000", "0.00000000000000000000000000001",
                "99999999999999999999999999.99999999999999999999999999999");
        checkSubtractOperation("0.00000000000000000000000000001", "100000000000000000000000000",
                "-99999999999999999999999999.99999999999999999999999999999");

        //decimal and decimal
        checkSubtractOperation("0.0000000000001", "0.1", "-0.0999999999999");
        checkSubtractOperation("0.1", "0.0000000000001", "0.0999999999999");

        checkSubtractOperation("0.0000000000000001", "0.9999999999999999",
                "-0.9999999999999998");
        checkSubtractOperation("0.9999999999999999", "0.0000000000000001",
                "0.9999999999999998");

        checkSubtractOperation("1234567890.987654321", "123.123", "1234567767.864654321");
        checkSubtractOperation("123.123", "1234567890.987654321", "-1234567767.864654321");

        checkSubtractOperation("0.01", "0.00000000000000000000000000001",
                "0.00999999999999999999999999999");
        checkSubtractOperation("0.00000000000000000000000000001","0.01",
                "-0.00999999999999999999999999999");

        //boundary
        checkSubtractOperation("8.e+9999", "-1.e+9999", "9.e+9999");
        checkSubtractOperation("-1.e+9999", "8.e+9999", "-9.e+9999");

        checkSubtractOperation("9.e+9999", "-9.e+9998", "9.9e+9999");
        checkSubtractOperation("-9.e+9998", "9.e+9999", "-9.9e+9999");

        checkSubtractOperation("8.e-9999", "-1.e-9999", "9.e-9999");
        checkSubtractOperation("-1.e-9999", "8.e-9999", "-9.e-9999");

        checkSubtractOperation("9.e-9999", "-9.e-9998", "9.9e-9998");
        checkSubtractOperation("-9.e-9998", "9.e-9999", "-9.9e-9998");

        //several random values (and vice versa)
        checkSubtractOperation("523", "876", "-353");
        checkSubtractOperation("876", "523", "353");
        checkSubtractOperation("34", "65", "-31");
        checkSubtractOperation("65", "34", "31");

        checkSubtractOperation("724", "-652", "1376");
        checkSubtractOperation("-652", "724", "-1376");
        checkSubtractOperation("763", "-865", "1628");
        checkSubtractOperation("-865", "763", "-1628");

        checkSubtractOperation("-6521", "-41", "-6.48e+3");
        checkSubtractOperation("-41", "-6521", "6.48e+3");
        checkSubtractOperation("-7624", "-7245", "-379");
        checkSubtractOperation("-7245", "-7624", "379");

        checkSubtractOperation("763", "245.876", "517.124");
        checkSubtractOperation("245.876", "763", "-517.124");
        checkSubtractOperation("9876", "123.87", "9752.13");
        checkSubtractOperation("123.87", "9876", "-9752.13");

        checkSubtractOperation("6425", "-123.65", "6548.65");
        checkSubtractOperation("-123.65", "6425", "-6548.65");
        checkSubtractOperation("987", "-12.65", "999.65");
        checkSubtractOperation("-12.65", "987", "-999.65");

        checkSubtractOperation("-6", "76.123", "-82.123");
        checkSubtractOperation("76.123", "-6", "82.123");
        checkSubtractOperation("-6543", "12.43", "-6555.43");
        checkSubtractOperation("12.43", "-6543", "6555.43");

        checkSubtractOperation("-876", "-21.41", "-854.59");
        checkSubtractOperation("-21.41", "-876", "854.59");
        checkSubtractOperation("-987", "-12.21", "-974.79");
        checkSubtractOperation("-12.21", "-987", "974.79");

        checkSubtractOperation("12.11", "87.0765", "-74.9665");
        checkSubtractOperation("87.0765", "12.11", "74.9665");
        checkSubtractOperation("123.66", "1111.09", "-987.43");
        checkSubtractOperation("1111.09", "123.66", "987.43");

        checkSubtractOperation("123.65", "-1.2", "124.85");
        checkSubtractOperation("-1.2", "123.65", "-124.85");
        checkSubtractOperation("5.1", "-12.7", "17.8");
        checkSubtractOperation("-12.7", "5.1", "-17.8");

        checkSubtractOperation("-0.112", "-3.2", "3.088");
        checkSubtractOperation("-3.2", "-0.112", "-3.088");
        checkSubtractOperation("-9.1", "-1.224", "-7.876");
        checkSubtractOperation("-1.224", "-9.1", "7.876");
    }

    /**
     * Tests for multiply operation.
     */
    @Test
    void multiplyOperationTests() {
        //integers only
        {
            //first is -10000000000000000
            checkMultiplyOperation("-10000000000000000", "-10000000000000000", "1.e+32");
            checkMultiplyOperation("-10000000000000000", "-9999999999999999", "9.999999999999999e+31");
            checkMultiplyOperation("-10000000000000000", "-9999999999999998",
                    "9.999999999999998e+31");
            checkMultiplyOperation("-10000000000000000", "-10", "1.e+17");
            checkMultiplyOperation("-10000000000000000", "-1", "1.e+16");

            checkMultiplyOperation("-10000000000000000", "0", "0");

            checkMultiplyOperation("-10000000000000000", "1", "-1.e+16");
            checkMultiplyOperation("-10000000000000000", "10", "-1.e+17");
            checkMultiplyOperation("-10000000000000000", "9999999999999998",
                    "-9.999999999999998e+31");
            checkMultiplyOperation("-10000000000000000", "9999999999999999",
                    "-9.999999999999999e+31");
            checkMultiplyOperation("-10000000000000000", "10000000000000000", "-1.e+32");

            //first is -9999999999999999
            checkMultiplyOperation("-9999999999999999", "-9999999999999999",
                    "99999999999999980000000000000001");
            checkMultiplyOperation("-9999999999999999", "-9999999999999998",
                    "99999999999999970000000000000002");
            checkMultiplyOperation("-9999999999999999", "-10", "9.999999999999999e+16");
            checkMultiplyOperation("-9999999999999999", "-1", "9999999999999999");

            checkMultiplyOperation("-9999999999999999", "0", "0");

            checkMultiplyOperation("-9999999999999999", "1", "-9999999999999999");
            checkMultiplyOperation("-9999999999999999", "10", "-9.999999999999999e+16");
            checkMultiplyOperation("-9999999999999999", "9999999999999998",
                    "-99999999999999970000000000000002");
            checkMultiplyOperation("-9999999999999999", "9999999999999999",
                    "-99999999999999980000000000000001");
            checkMultiplyOperation("-9999999999999999", "10000000000000000", "-9.999999999999999e+31");

            //first is -9999999999999998
            checkMultiplyOperation("-9999999999999998", "-9999999999999998",
                    "99999999999999960000000000000004");
            checkMultiplyOperation("-9999999999999998", "-10", "9.999999999999998e+16");
            checkMultiplyOperation("-9999999999999998", "-1", "9999999999999998");

            checkMultiplyOperation("-9999999999999998", "0", "0");

            checkMultiplyOperation("-9999999999999998", "1", "-9999999999999998");
            checkMultiplyOperation("-9999999999999998", "10", "-9.999999999999998e+16");
            checkMultiplyOperation("-9999999999999998", "9999999999999998",
                    "-99999999999999960000000000000004");
            checkMultiplyOperation("-9999999999999998", "9999999999999999",
                    "-99999999999999970000000000000002");
            checkMultiplyOperation("-9999999999999998", "10000000000000000",
                    "-9.999999999999998e+31");

            //first is -10
            checkMultiplyOperation("-10", "-10", "1.e+2");
            checkMultiplyOperation("-10", "-1", "1.e+1");

            checkMultiplyOperation("-10", "0", "0");

            checkMultiplyOperation("-10", "1", "-1.e+1");
            checkMultiplyOperation("-10", "10", "-1.e+2");
            checkMultiplyOperation("-10", "9999999999999998", "-9.999999999999998e+16");
            checkMultiplyOperation("-10", "9999999999999999", "-9.999999999999999e+16");
            checkMultiplyOperation("-10", "10000000000000000", "-1.e+17");

            //first is -1
            checkMultiplyOperation("-1", "-1", "1");

            checkMultiplyOperation("-1", "0", "0");

            checkMultiplyOperation("-1", "1", "-1");
            checkMultiplyOperation("-1", "10", "-1.e+1");
            checkMultiplyOperation("-1", "9999999999999998", "-9999999999999998");
            checkMultiplyOperation("-1", "9999999999999999", "-9999999999999999");
            checkMultiplyOperation("-1", "10000000000000000", "-1.e+16");

            //first is 0
            checkMultiplyOperation("0", "0", "0");

            checkMultiplyOperation("0", "1", "0");
            checkMultiplyOperation("0", "10", "0");
            checkMultiplyOperation("0", "9999999999999998", "0");
            checkMultiplyOperation("0", "9999999999999999", "0");
            checkMultiplyOperation("0", "10000000000000000", "0");

            //first is 1
            checkMultiplyOperation("1", "1", "1");
            checkMultiplyOperation("1", "10", "1.e+1");
            checkMultiplyOperation("1", "9999999999999998", "9999999999999998");
            checkMultiplyOperation("1", "9999999999999999", "9999999999999999");
            checkMultiplyOperation("1", "10000000000000000", "1.e+16");

            //first is 10
            checkMultiplyOperation("10", "10", "1.e+2");
            checkMultiplyOperation("10", "9999999999999998", "9.999999999999998e+16");
            checkMultiplyOperation("10", "9999999999999999", "9.999999999999999e+16");
            checkMultiplyOperation("10", "10000000000000000", "1.e+17");

            //first is 9999999999999998
            checkMultiplyOperation("9999999999999998", "9999999999999998",
                    "99999999999999960000000000000004");
            checkMultiplyOperation("9999999999999998", "9999999999999999",
                    "99999999999999970000000000000002");
            checkMultiplyOperation("9999999999999998", "10000000000000000",
                    "9.999999999999998e+31");

            //first is 9999999999999999
            checkMultiplyOperation("9999999999999999", "9999999999999999",
                    "99999999999999980000000000000001");
            checkMultiplyOperation("9999999999999999", "10000000000000000", "9.999999999999999e+31");

            //first is 10000000000000000
            checkMultiplyOperation("10000000000000000", "10000000000000000", "1.e+32");
        }

        //integer and decimal
        {
            //first is -10000000000000000
            checkMultiplyOperation("-10000000000000000", "-0.9999999999999999", "9999999999999999");
            checkMultiplyOperation("-10000000000000000", "-0.9", "9.e+15");
            checkMultiplyOperation("-10000000000000000", "-0.1", "1.e+15");

            checkMultiplyOperation("-10000000000000000", "0.1", "-1.e+15");
            checkMultiplyOperation("-10000000000000000", "0.9", "-9.e+15");
            checkMultiplyOperation("-10000000000000000", "0.9999999999999999", "-9999999999999999");

            //first is -9999999999999999
            checkMultiplyOperation("-9999999999999999", "-0.9999999999999999",
                    "9999999999999998.0000000000000001");
            checkMultiplyOperation("-9999999999999999", "-0.9", "8999999999999999.1");
            checkMultiplyOperation("-9999999999999999", "-0.1", "999999999999999.9");

            checkMultiplyOperation("-9999999999999999", "0.1", "-999999999999999.9");
            checkMultiplyOperation("-9999999999999999", "0.9", "-8999999999999999.1");
            checkMultiplyOperation("-9999999999999999", "0.9999999999999999",
                    "-9999999999999998.0000000000000001");

            //first is -9999999999999998
            checkMultiplyOperation("-9999999999999998", "-0.9999999999999999",
                    "9999999999999997.0000000000000002");
            checkMultiplyOperation("-9999999999999998", "-0.9", "8999999999999998.2");
            checkMultiplyOperation("-9999999999999998", "-0.1", "999999999999999.8");

            checkMultiplyOperation("-9999999999999998", "0.1", "-999999999999999.8");
            checkMultiplyOperation("-9999999999999998", "0.9", "-8999999999999998.2");
            checkMultiplyOperation("-9999999999999998", "0.9999999999999999",
                    "-9999999999999997.0000000000000002");

            //first is -10
            checkMultiplyOperation("-10", "-0.9999999999999999", "9.999999999999999");
            checkMultiplyOperation("-10", "-0.9", "9");
            checkMultiplyOperation("-10", "-0.1", "1");

            checkMultiplyOperation("-10", "0.1", "-1");
            checkMultiplyOperation("-10", "0.9", "-9");
            checkMultiplyOperation("-10", "0.9999999999999999", "-9.999999999999999");

            //first is -1
            checkMultiplyOperation("-1", "-0.9999999999999999", "0.9999999999999999");
            checkMultiplyOperation("-1", "-0.9", "0.9");
            checkMultiplyOperation("-1", "-0.1", "0.1");

            checkMultiplyOperation("-1", "0.1", "-0.1");
            checkMultiplyOperation("-1", "0.9", "-0.9");
            checkMultiplyOperation("-1", "0.9999999999999999", "-0.9999999999999999");

            //first is 0
            checkMultiplyOperation("0", "-0.9999999999999999", "0");
            checkMultiplyOperation("0", "-0.9", "0");
            checkMultiplyOperation("0", "-0.1", "0");

            checkMultiplyOperation("0", "0.1", "0");
            checkMultiplyOperation("0", "0.9", "0");
            checkMultiplyOperation("0", "0.9999999999999999", "0");

            //first is 1
            checkMultiplyOperation("1", "-0.9999999999999999", "-0.9999999999999999");
            checkMultiplyOperation("1", "-0.9", "-0.9");
            checkMultiplyOperation("1", "-0.1", "-0.1");

            checkMultiplyOperation("1", "0.1", "0.1");
            checkMultiplyOperation("1", "0.9", "0.9");
            checkMultiplyOperation("1", "0.9999999999999999", "0.9999999999999999");

            //first is 10
            checkMultiplyOperation("10", "-0.9999999999999999", "-9.999999999999999");
            checkMultiplyOperation("10", "-0.9", "-9");
            checkMultiplyOperation("10", "-0.1", "-1");

            checkMultiplyOperation("10", "0.1", "1");
            checkMultiplyOperation("10", "0.9", "9");
            checkMultiplyOperation("10", "0.9999999999999999", "9.999999999999999");

            //first is 9999999999999998
            checkMultiplyOperation("9999999999999998", "-0.9999999999999999",
                    "-9999999999999997.0000000000000002");
            checkMultiplyOperation("9999999999999998", "-0.9", "-8999999999999998.2");
            checkMultiplyOperation("9999999999999998", "-0.1", "-999999999999999.8");

            checkMultiplyOperation("9999999999999998", "0.1", "999999999999999.8");
            checkMultiplyOperation("9999999999999998", "0.9", "8999999999999998.2");
            checkMultiplyOperation("9999999999999998", "0.9999999999999999",
                    "9999999999999997.0000000000000002");

            //first is 9999999999999999
            checkMultiplyOperation("9999999999999999", "-0.9999999999999999",
                    "-9999999999999998.0000000000000001");
            checkMultiplyOperation("9999999999999999", "-0.9", "-8999999999999999.1");
            checkMultiplyOperation("9999999999999999", "-0.1", "-999999999999999.9");

            checkMultiplyOperation("9999999999999999", "0.1", "999999999999999.9");
            checkMultiplyOperation("9999999999999999", "0.9", "8999999999999999.1");
            checkMultiplyOperation("9999999999999999", "0.9999999999999999", "9999999999999998.0000000000000001");

            //first is 10000000000000000
            checkMultiplyOperation("10000000000000000", "-0.9999999999999999", "-9999999999999999");
            checkMultiplyOperation("10000000000000000", "-0.9", "-9.e+15");
            checkMultiplyOperation("10000000000000000", "-0.1", "-1.e+15");

            checkMultiplyOperation("10000000000000000", "0.1", "1.e+15");
            checkMultiplyOperation("10000000000000000", "0.9", "9.e+15");
            checkMultiplyOperation("10000000000000000", "0.9999999999999999", "9999999999999999");
        }

        //decimals only
        {
            //first is -0.9999999999999999
            checkMultiplyOperation("-0.9999999999999999", "-0.9999999999999999",
                    "0.99999999999999980000000000000001");
            checkMultiplyOperation("-0.9999999999999999", "-0.9", "0.89999999999999991");
            checkMultiplyOperation("-0.9999999999999999", "-0.1", "0.09999999999999999");

            checkMultiplyOperation("-0.9999999999999999", "0.1", "-0.09999999999999999");
            checkMultiplyOperation("-0.9999999999999999", "0.9", "-0.89999999999999991");
            checkMultiplyOperation("-0.9999999999999999", "0.9999999999999999",
                    "-0.99999999999999980000000000000001");

            //first is -0.9
            checkMultiplyOperation("-0.9", "-0.9", "0.81");
            checkMultiplyOperation("-0.9", "-0.1", "0.09");

            checkMultiplyOperation("-0.9", "0.1", "-0.09");
            checkMultiplyOperation("-0.9", "0.9", "-0.81");
            checkMultiplyOperation("-0.9", "0.9999999999999999", "-0.89999999999999991");

            //first is -0.1
            checkMultiplyOperation("-0.1", "-0.1", "0.01");

            checkMultiplyOperation("-0.1", "0.1", "-0.01");
            checkMultiplyOperation("-0.1", "0.9", "-0.09");
            checkMultiplyOperation("-0.1", "0.9999999999999999", "-0.09999999999999999");

            //first is 0.1
            checkMultiplyOperation("0.1", "0.1", "0.01");
            checkMultiplyOperation("0.1", "0.9", "0.09");
            checkMultiplyOperation("0.1", "0.9999999999999999", "0.09999999999999999");

            //first is 0.9
            checkMultiplyOperation("0.9", "0.9", "0.81");
            checkMultiplyOperation("0.9", "0.9999999999999999", "0.89999999999999991");

            //first is 0.9999999999999999
            checkMultiplyOperation("0.9999999999999999", "0.9999999999999999", "0.99999999999999980000000000000001");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+17
            checkMultiplyOperation("-1.e+17", "-1.e+17", "1.e+34");
            checkMultiplyOperation("-1.e+17", "-1.e+16", "1.e+33");

            checkMultiplyOperation("-1.e+17", "1.e+16", "-1.e+33");
            checkMultiplyOperation("-1.e+17", "1.e+17", "-1.e+34");

            //first is -1.e+16
            checkMultiplyOperation("-1.e+16", "-1.e+16", "1.e+32");

            checkMultiplyOperation("-1.e+16", "1.e+16", "-1.e+32");
            checkMultiplyOperation("-1.e+16", "1.e+17", "-1.e+33");

            //first is 1.e+16
            checkMultiplyOperation("1.e+16", "1.e+16", "1.e+32");
            checkMultiplyOperation("1.e+16", "1.e+17", "1.e+33");

            //first is 1.e+17
            checkMultiplyOperation("1.e+17", "1.e+17", "1.e+34");


            //first is -1.e-17
            checkMultiplyOperation("-1.e-17", "-1.e-17", "1.e-34");
            checkMultiplyOperation("-1.e-17", "-1.e-16", "1.e-33");

            checkMultiplyOperation("-1.e-17", "1.e-16", "-1.e-33");
            checkMultiplyOperation("-1.e-17", "1.e-17", "-1.e-34");

            //first is -1.e-16
            checkMultiplyOperation("-1.e-16", "-1.e-16", "1.e-32");

            checkMultiplyOperation("-1.e-16", "1.e-16", "-1.e-32");
            checkMultiplyOperation("-1.e-16", "1.e-17", "-1.e-33");

            //first is 1.e-16
            checkMultiplyOperation("1.e-16", "1.e-16", "1.e-32");
            checkMultiplyOperation("1.e-16", "1.e-17", "1.e-33");

            //first is 1.e-17
            checkMultiplyOperation("1.e-17", "1.e-17", "1.e-34");
        }

        //with integers
        {
            //first is -1.e-9999
            checkMultiplyOperation("-1.e-9999", "-10000000000000000", "1.e-9983");
            checkMultiplyOperation("-1.e-9999", "-9999999999999999", "9.999999999999999e-9984");
            checkMultiplyOperation("-1.e-9999", "-9999999999999998",
                    "9.999999999999998e-9984");
            checkMultiplyOperation("-1.e-9999", "-10", "1.e-9998");
            checkMultiplyOperation("-1.e-9999", "-1", "1.e-9999");

            checkMultiplyOperation("-1.e-9999", "0", "0");

            checkMultiplyOperation("-1.e-9999", "1", "-1.e-9999");
            checkMultiplyOperation("-1.e-9999", "10", "-1.e-9998");
            checkMultiplyOperation("-1.e-9999", "9999999999999998",
                    "-9.999999999999998e-9984");
            checkMultiplyOperation("-1.e-9999", "9999999999999999", "-9.999999999999999e-9984");
            checkMultiplyOperation("-1.e-9999", "10000000000000000", "-1.e-9983");

            //first is -1.e-9998
            checkMultiplyOperation("-1.e-9998", "-10000000000000000", "1.e-9982");
            checkMultiplyOperation("-1.e-9998", "-9999999999999999", "9.999999999999999e-9983");
            checkMultiplyOperation("-1.e-9998", "-9999999999999998",
                    "9.999999999999998e-9983");
            checkMultiplyOperation("-1.e-9998", "-10", "1.e-9997");
            checkMultiplyOperation("-1.e-9998", "-1", "1.e-9998");

            checkMultiplyOperation("-1.e-9998", "0", "0");

            checkMultiplyOperation("-1.e-9998", "1", "-1.e-9998");
            checkMultiplyOperation("-1.e-9998", "10", "-1.e-9997");
            checkMultiplyOperation("-1.e-9998", "9999999999999998",
                    "-9.999999999999998e-9983");
            checkMultiplyOperation("-1.e-9998", "9999999999999999", "-9.999999999999999e-9983");
            checkMultiplyOperation("-1.e-9998", "10000000000000000", "-1.e-9982");

            //first is 1.e-9998
            checkMultiplyOperation("1.e-9998", "-10000000000000000", "-1.e-9982");
            checkMultiplyOperation("1.e-9998", "-9999999999999999", "-9.999999999999999e-9983");
            checkMultiplyOperation("1.e-9998", "-9999999999999998",
                    "-9.999999999999998e-9983");
            checkMultiplyOperation("1.e-9998", "-10", "-1.e-9997");
            checkMultiplyOperation("1.e-9998", "-1", "-1.e-9998");

            checkMultiplyOperation("1.e-9998", "0", "0");

            checkMultiplyOperation("1.e-9998", "1", "1.e-9998");
            checkMultiplyOperation("1.e-9998", "10", "1.e-9997");
            checkMultiplyOperation("1.e-9998", "9999999999999998",
                    "9.999999999999998e-9983");
            checkMultiplyOperation("1.e-9998", "9999999999999999", "9.999999999999999e-9983");
            checkMultiplyOperation("1.e-9998", "10000000000000000", "1.e-9982");

            //first is 1.e-9999
            checkMultiplyOperation("1.e-9999", "-10000000000000000", "-1.e-9983");
            checkMultiplyOperation("1.e-9999", "-9999999999999999", "-9.999999999999999e-9984");
            checkMultiplyOperation("1.e-9999", "-9999999999999998",
                    "-9.999999999999998e-9984");
            checkMultiplyOperation("1.e-9999", "-10", "-1.e-9998");
            checkMultiplyOperation("1.e-9999", "-1", "-1.e-9999");

            checkMultiplyOperation("1.e-9999", "0", "0");

            checkMultiplyOperation("1.e-9999", "1", "1.e-9999");
            checkMultiplyOperation("1.e-9999", "10", "1.e-9998");
            checkMultiplyOperation("1.e-9999", "9999999999999998",
                    "9.999999999999998e-9984");
            checkMultiplyOperation("1.e-9999", "9999999999999999", "9.999999999999999e-9984");
            checkMultiplyOperation("1.e-9999", "10000000000000000", "1.e-9983");


            //first is -1.e+17
            checkMultiplyOperation("-1.e+17", "-10000000000000000", "1.e+33");
            checkMultiplyOperation("-1.e+17", "-9999999999999999", "9.999999999999999e+32");
            checkMultiplyOperation("-1.e+17", "-9999999999999998",
                    "9.999999999999998e+32");
            checkMultiplyOperation("-1.e+17", "-10", "1.e+18");
            checkMultiplyOperation("-1.e+17", "-1", "1.e+17");

            checkMultiplyOperation("-1.e+17", "0", "0");

            checkMultiplyOperation("-1.e+17", "1", "-1.e+17");
            checkMultiplyOperation("-1.e+17", "10", "-1.e+18");
            checkMultiplyOperation("-1.e+17", "9999999999999998",
                    "-9.999999999999998e+32");
            checkMultiplyOperation("-1.e+17", "9999999999999999", "-9.999999999999999e+32");
            checkMultiplyOperation("-1.e+17", "10000000000000000", "-1.e+33");

            //first is -1.e+16
            checkMultiplyOperation("-1.e+16", "-10000000000000000", "1.e+32");
            checkMultiplyOperation("-1.e+16", "-9999999999999999", "9.999999999999999e+31");
            checkMultiplyOperation("-1.e+16", "-9999999999999998",
                    "9.999999999999998e+31");
            checkMultiplyOperation("-1.e+16", "-10", "1.e+17");
            checkMultiplyOperation("-1.e+16", "-1", "1.e+16");

            checkMultiplyOperation("-1.e+16", "0", "0");

            checkMultiplyOperation("-1.e+16", "1", "-1.e+16");
            checkMultiplyOperation("-1.e+16", "10", "-1.e+17");
            checkMultiplyOperation("-1.e+16", "9999999999999998",
                    "-9.999999999999998e+31");
            checkMultiplyOperation("-1.e+16", "9999999999999999", "-9.999999999999999e+31");
            checkMultiplyOperation("-1.e+16", "10000000000000000", "-1.e+32");

            //first is 1.e+16
            checkMultiplyOperation("1.e+16", "-10000000000000000", "-1.e+32");
            checkMultiplyOperation("1.e+16", "-9999999999999999", "-9.999999999999999e+31");
            checkMultiplyOperation("1.e+16", "-9999999999999998", "-9.999999999999998e+31");
            checkMultiplyOperation("1.e+16", "-10", "-1.e+17");
            checkMultiplyOperation("1.e+16", "-1", "-1.e+16");

            checkMultiplyOperation("1.e+16", "0", "0");

            checkMultiplyOperation("1.e+16", "1", "1.e+16");
            checkMultiplyOperation("1.e+16", "10", "1.e+17");
            checkMultiplyOperation("1.e+16", "9999999999999998", "9.999999999999998e+31");
            checkMultiplyOperation("1.e+16", "9999999999999999", "9.999999999999999e+31");
            checkMultiplyOperation("1.e+16", "10000000000000000", "1.e+32");

            //first is 1.e+17
            checkMultiplyOperation("1.e+17", "-10000000000000000", "-1.e+33");
            checkMultiplyOperation("1.e+17", "-9999999999999999", "-9.999999999999999e+32");
            checkMultiplyOperation("1.e+17", "-9999999999999998", "-9.999999999999998e+32");
            checkMultiplyOperation("1.e+17", "-10", "-1.e+18");
            checkMultiplyOperation("1.e+17", "-1", "-1.e+17");

            checkMultiplyOperation("1.e+17", "0", "0");

            checkMultiplyOperation("1.e+17", "1", "1.e+17");
            checkMultiplyOperation("1.e+17", "10", "1.e+18");
            checkMultiplyOperation("1.e+17", "9999999999999998", "9.999999999999998e+32");
            checkMultiplyOperation("1.e+17", "9999999999999999", "9.999999999999999e+32");
            checkMultiplyOperation("1.e+17", "10000000000000000", "1.e+33");


            //first is -1.e-17
            checkMultiplyOperation("-1.e-17", "-10000000000000000", "0.1");
            checkMultiplyOperation("-1.e-17", "-9999999999999999", "0.09999999999999999");
            checkMultiplyOperation("-1.e-17", "-9999999999999998", "0.09999999999999998");
            checkMultiplyOperation("-1.e-17", "-10", "1.e-16");
            checkMultiplyOperation("-1.e-17", "-1", "1.e-17");

            checkMultiplyOperation("-1.e-17", "0", "0");

            checkMultiplyOperation("-1.e-17", "1", "-1.e-17");
            checkMultiplyOperation("-1.e-17", "10", "-1.e-16");
            checkMultiplyOperation("-1.e-17", "9999999999999998",
                    "-0.09999999999999998");
            checkMultiplyOperation("-1.e-17", "9999999999999999", "-0.09999999999999999");
            checkMultiplyOperation("-1.e-17", "10000000000000000", "-0.1");

            //first is -1.e-16
            checkMultiplyOperation("-1.e-16", "-10000000000000000", "1");
            checkMultiplyOperation("-1.e-16", "-9999999999999999", "0.9999999999999999");
            checkMultiplyOperation("-1.e-16", "-9999999999999998", "0.9999999999999998");
            checkMultiplyOperation("-1.e-16", "-10", "1.e-15");
            checkMultiplyOperation("-1.e-16", "-1", "1.e-16");

            checkMultiplyOperation("-1.e-16", "0", "0");

            checkMultiplyOperation("-1.e-16", "1", "-1.e-16");
            checkMultiplyOperation("-1.e-16", "10", "-1.e-15");
            checkMultiplyOperation("-1.e-16", "9999999999999998",
                    "-0.9999999999999998");
            checkMultiplyOperation("-1.e-16", "9999999999999999", "-0.9999999999999999");
            checkMultiplyOperation("-1.e-16", "10000000000000000", "-1");

            //first is 1.e-16
            checkMultiplyOperation("1.e-16", "-10000000000000000", "-1");
            checkMultiplyOperation("1.e-16", "-9999999999999999", "-0.9999999999999999");
            checkMultiplyOperation("1.e-16", "-9999999999999998", "-0.9999999999999998");
            checkMultiplyOperation("1.e-16", "-10", "-1.e-15");
            checkMultiplyOperation("1.e-16", "-1", "-1.e-16");

            checkMultiplyOperation("1.e-16", "0", "0");

            checkMultiplyOperation("1.e-16", "1", "1.e-16");
            checkMultiplyOperation("1.e-16", "10", "1.e-15");
            checkMultiplyOperation("1.e-16", "9999999999999998", "0.9999999999999998");
            checkMultiplyOperation("1.e-16", "9999999999999999", "0.9999999999999999");
            checkMultiplyOperation("1.e-16", "10000000000000000", "1");

            //first is 1.e-17
            checkMultiplyOperation("1.e-17", "-10000000000000000", "-0.1");
            checkMultiplyOperation("1.e-17", "-9999999999999999", "-0.09999999999999999");
            checkMultiplyOperation("1.e-17", "-9999999999999998", "-0.09999999999999998");
            checkMultiplyOperation("1.e-17", "-10", "-1.e-16");
            checkMultiplyOperation("1.e-17", "-1", "-1.e-17");

            checkMultiplyOperation("1.e-17", "0", "0");

            checkMultiplyOperation("1.e-17", "1", "1.e-17");
            checkMultiplyOperation("1.e-17", "10", "1.e-16");
            checkMultiplyOperation("1.e-17", "9999999999999998", "0.09999999999999998");
            checkMultiplyOperation("1.e-17", "9999999999999999", "0.09999999999999999");
            checkMultiplyOperation("1.e-17", "10000000000000000", "0.1");
        }

        //with decimals
        {
            //first is -1.e+9999
            checkMultiplyOperation("-1.e+9999", "-0.9999999999999999", "9.999999999999999e+9998");
            checkMultiplyOperation("-1.e+9999", "-0.9", "9.e+9998");
            checkMultiplyOperation("-1.e+9999", "-0.1", "1.e+9998");

            checkMultiplyOperation("-1.e+9999", "0.1", "-1.e+9998");
            checkMultiplyOperation("-1.e+9999", "0.9", "-9.e+9998");
            checkMultiplyOperation("-1.e+9999", "0.9999999999999999", "-9.999999999999999e+9998");

            //first is -1.e+9998
            checkMultiplyOperation("-1.e+9998", "-0.9999999999999999", "9.999999999999999e+9997");
            checkMultiplyOperation("-1.e+9998", "-0.9", "9.e+9997");
            checkMultiplyOperation("-1.e+9998", "-0.1", "1.e+9997");

            checkMultiplyOperation("-1.e+9998", "0.1", "-1.e+9997");
            checkMultiplyOperation("-1.e+9998", "0.9", "-9.e+9997");
            checkMultiplyOperation("-1.e+9998", "0.9999999999999999", "-9.999999999999999e+9997");

            //first is 1.e+9998
            checkMultiplyOperation("1.e+9998", "-0.9999999999999999", "-9.999999999999999e+9997");
            checkMultiplyOperation("1.e+9998", "-0.9", "-9.e+9997");
            checkMultiplyOperation("1.e+9998", "-0.1", "-1.e+9997");

            checkMultiplyOperation("1.e+9998", "0.1", "1.e+9997");
            checkMultiplyOperation("1.e+9998", "0.9", "9.e+9997");
            checkMultiplyOperation("1.e+9998", "0.9999999999999999", "9.999999999999999e+9997");

            //first is 1.e+9999
            checkMultiplyOperation("1.e+9999", "-0.9999999999999999", "-9.999999999999999e+9998");
            checkMultiplyOperation("1.e+9999", "-0.9", "-9.e+9998");
            checkMultiplyOperation("1.e+9999", "-0.1", "-1.e+9998");

            checkMultiplyOperation("1.e+9999", "0.1", "1.e+9998");
            checkMultiplyOperation("1.e+9999", "0.9", "9.e+9998");
            checkMultiplyOperation("1.e+9999", "0.9999999999999999", "9.999999999999999e+9998");

            //first is -1.e+17
            checkMultiplyOperation("-1.e+17", "-0.9999999999999999", "9.999999999999999e+16");
            checkMultiplyOperation("-1.e+17", "-0.9", "9.e+16");
            checkMultiplyOperation("-1.e+17", "-0.1", "1.e+16");

            checkMultiplyOperation("-1.e+17", "0.1", "-1.e+16");
            checkMultiplyOperation("-1.e+17", "0.9", "-9.e+16");
            checkMultiplyOperation("-1.e+17", "0.9999999999999999", "-9.999999999999999e+16");

            //first is -1.e+16
            checkMultiplyOperation("-1.e+16", "-0.9999999999999999", "9999999999999999");
            checkMultiplyOperation("-1.e+16", "-0.9", "9.e+15");
            checkMultiplyOperation("-1.e+16", "-0.1", "1.e+15");

            checkMultiplyOperation("-1.e+16", "0.1", "-1.e+15");
            checkMultiplyOperation("-1.e+16", "0.9", "-9.e+15");
            checkMultiplyOperation("-1.e+16", "0.9999999999999999", "-9999999999999999");

            //first is 1.e+16
            checkMultiplyOperation("1.e+16", "-0.9999999999999999", "-9999999999999999");
            checkMultiplyOperation("1.e+16", "-0.9", "-9.e+15");
            checkMultiplyOperation("1.e+16", "-0.1", "-1.e+15");

            checkMultiplyOperation("1.e+16", "0.1", "1.e+15");
            checkMultiplyOperation("1.e+16", "0.9", "9.e+15");
            checkMultiplyOperation("1.e+16", "0.9999999999999999", "9999999999999999");

            //first is 1.e+17
            checkMultiplyOperation("1.e+17", "-0.9999999999999999", "-9.999999999999999e+16");
            checkMultiplyOperation("1.e+17", "-0.9", "-9.e+16");
            checkMultiplyOperation("1.e+17", "-0.1", "-1.e+16");

            checkMultiplyOperation("1.e+17", "0.1", "1.e+16");
            checkMultiplyOperation("1.e+17", "0.9", "9.e+16");
            checkMultiplyOperation("1.e+17", "0.9999999999999999", "9.999999999999999e+16");

            //first is -1.e-17
            checkMultiplyOperation("-1.e-17", "-0.9999999999999999", "9.999999999999999e-18");
            checkMultiplyOperation("-1.e-17", "-0.9", "9.e-18");
            checkMultiplyOperation("-1.e-17", "-0.1", "1.e-18");

            checkMultiplyOperation("-1.e-17", "0.1", "-1.e-18");
            checkMultiplyOperation("-1.e-17", "0.9", "-9.e-18");
            checkMultiplyOperation("-1.e-17", "0.9999999999999999", "-9.999999999999999e-18");

            //first is -1.e-16
            checkMultiplyOperation("-1.e-16", "-0.9999999999999999", "9.999999999999999e-17");
            checkMultiplyOperation("-1.e-16", "-0.9", "9.e-17");
            checkMultiplyOperation("-1.e-16", "-0.1", "1.e-17");

            checkMultiplyOperation("-1.e-16", "0.1", "-1.e-17");
            checkMultiplyOperation("-1.e-16", "0.9", "-9.e-17");
            checkMultiplyOperation("-1.e-16", "0.9999999999999999", "-9.999999999999999e-17");

            //first is 1.e-16
            checkMultiplyOperation("1.e-16", "-0.9999999999999999", "-9.999999999999999e-17");
            checkMultiplyOperation("1.e-16", "-0.9", "-9.e-17");
            checkMultiplyOperation("1.e-16", "-0.1", "-1.e-17");

            checkMultiplyOperation("1.e-16", "0.1", "1.e-17");
            checkMultiplyOperation("1.e-16", "0.9", "9.e-17");
            checkMultiplyOperation("1.e-16", "0.9999999999999999", "9.999999999999999e-17");

            //first is 1.e-17
            checkMultiplyOperation("1.e-17", "-0.9999999999999999", "-9.999999999999999e-18");
            checkMultiplyOperation("1.e-17", "-0.9", "-9.e-18");
            checkMultiplyOperation("1.e-17", "-0.1", "-1.e-18");

            checkMultiplyOperation("1.e-17", "0.1", "1.e-18");
            checkMultiplyOperation("1.e-17", "0.9", "9.e-18");
            checkMultiplyOperation("1.e-17", "0.9999999999999999", "9.999999999999999e-18");
        }

        //several random values
        {
            checkMultiplyOperation("41", "13", "533");
            checkMultiplyOperation("64", "56", "3584");

            checkMultiplyOperation("123", "-13", "-1599");
            checkMultiplyOperation("41", "-65", "-2665");

            checkMultiplyOperation("-876", "-13", "11388");
            checkMultiplyOperation("-54", "-53", "2862");

            checkMultiplyOperation("12", "541.652", "6499.824");
            checkMultiplyOperation("9", "13.764", "123.876");

            checkMultiplyOperation("132", "-23.13", "-3053.16");
            checkMultiplyOperation("12", "-76.87", "-922.44");

            checkMultiplyOperation("-65", "65.13", "-4233.45");
            checkMultiplyOperation("-76", "75.123", "-5709.348");

            checkMultiplyOperation("-13", "-6.12", "79.56");
            checkMultiplyOperation("-76", "-13.5", "1026");

            checkMultiplyOperation("33.12", "6.13", "203.0256");
            checkMultiplyOperation("86.7", "5.132", "444.9444");

            checkMultiplyOperation("1.75", "-0.1", "-0.175");
            checkMultiplyOperation("23.5", "-6.87", "-161.445");

            checkMultiplyOperation("-765.1", "-1.8", "1377.18");
            checkMultiplyOperation("-65.7", "-7.8", "512.46");
        }
    }

    /**
     * Tests for divide operation.
     */
    @Test
    void divideOperationTests() {
        //integers only
        {
            //first is -10000000000000000
            checkDivideOperation("-10000000000000000", "-10000000000000000", "1");
            checkDivideOperation("-10000000000000000", "-10", "1.e+15");
            checkDivideOperation("-10000000000000000", "-1", "1.e+16");

            checkDivideOperation("-10000000000000000", "1", "-1.e+16");
            checkDivideOperation("-10000000000000000", "10", "-1.e+15");
            checkDivideOperation("-10000000000000000", "10000000000000000", "-1");

            //first is -9999999999999999
            checkDivideOperation("-9999999999999999", "-10000000000000000", "0.9999999999999999");
            checkDivideOperation("-9999999999999999", "-9999999999999999", "1");
            checkDivideOperation("-9999999999999999", "-10", "999999999999999.9");
            checkDivideOperation("-9999999999999999", "-1", "9999999999999999");

            checkDivideOperation("-9999999999999999", "1", "-9999999999999999");
            checkDivideOperation("-9999999999999999", "10", "-999999999999999.9");
            checkDivideOperation("-9999999999999999", "9999999999999999", "-1");
            checkDivideOperation("-9999999999999999", "10000000000000000", "-0.9999999999999999");

            //first is -9999999999999998
            checkDivideOperation("-9999999999999998", "-10000000000000000",
                    "0.9999999999999998");
            checkDivideOperation("-9999999999999998", "-9999999999999998", "1");
            checkDivideOperation("-9999999999999998", "-10", "999999999999999.8");
            checkDivideOperation("-9999999999999998", "-1", "9999999999999998");

            checkDivideOperation("-9999999999999998", "1", "-9999999999999998");
            checkDivideOperation("-9999999999999998", "10", "-999999999999999.8");
            checkDivideOperation("-9999999999999998", "9999999999999998", "-1");
            checkDivideOperation("-9999999999999998", "10000000000000000",
                    "-0.9999999999999998");

            //first is -10
            checkDivideOperation("-10", "-10000000000000000", "1.e-15");
            checkDivideOperation("-10", "-10", "1");
            checkDivideOperation("-10", "-1", "1.e+1");

            checkDivideOperation("-10", "1", "-1.e+1");
            checkDivideOperation("-10", "10", "-1");
            checkDivideOperation("-10", "10000000000000000", "-1.e-15");

            //first is -1
            checkDivideOperation("-1", "-10000000000000000", "1.e-16");
            checkDivideOperation("-1", "-10", "0.1");
            checkDivideOperation("-1", "-1", "1");

            checkDivideOperation("-1", "1", "-1");
            checkDivideOperation("-1", "10", "-0.1");
            checkDivideOperation("-1", "10000000000000000", "-1.e-16");

            //first is 0
            checkDivideOperation("0", "-10000000000000000", "0");
            checkDivideOperation("0", "-9999999999999999", "0");
            checkDivideOperation("0", "-9999999999999998", "0");
            checkDivideOperation("0", "-10", "0");
            checkDivideOperation("0", "-1", "0");

            checkDivideOperation("0", "1", "0");
            checkDivideOperation("0", "10", "0");
            checkDivideOperation("0", "9999999999999998", "0");
            checkDivideOperation("0", "9999999999999999", "0");
            checkDivideOperation("0", "10000000000000000", "0");

            //first is 1
            checkDivideOperation("1", "-10000000000000000", "-1.e-16");
            checkDivideOperation("1", "-10", "-0.1");
            checkDivideOperation("1", "-1", "-1");

            checkDivideOperation("1", "1", "1");
            checkDivideOperation("1", "10", "0.1");
            checkDivideOperation("1", "10000000000000000", "1.e-16");

            //first is 10
            checkDivideOperation("10", "-10000000000000000", "-1.e-15");
            checkDivideOperation("10", "-10", "-1");
            checkDivideOperation("10", "-1", "-1.e+1");

            checkDivideOperation("10", "1", "1.e+1");
            checkDivideOperation("10", "10", "1");
            checkDivideOperation("10", "10000000000000000", "1.e-15");

            //first is 9999999999999998
            checkDivideOperation("9999999999999998", "-10000000000000000",
                    "-0.9999999999999998");
            checkDivideOperation("9999999999999998", "-9999999999999998", "-1");
            checkDivideOperation("9999999999999998", "-10", "-999999999999999.8");
            checkDivideOperation("9999999999999998", "-1", "-9999999999999998");

            checkDivideOperation("9999999999999998", "1", "9999999999999998");
            checkDivideOperation("9999999999999998", "10", "999999999999999.8");
            checkDivideOperation("9999999999999998", "9999999999999998", "1");
            checkDivideOperation("9999999999999998", "10000000000000000",
                    "0.9999999999999998");

            //first is 9999999999999999
            checkDivideOperation("9999999999999999", "-10000000000000000", "-0.9999999999999999");
            checkDivideOperation("9999999999999999", "-9999999999999999", "-1");
            checkDivideOperation("9999999999999999", "-10", "-999999999999999.9");
            checkDivideOperation("9999999999999999", "-1", "-9999999999999999");

            checkDivideOperation("9999999999999999", "1", "9999999999999999");
            checkDivideOperation("9999999999999999", "10", "999999999999999.9");
            checkDivideOperation("9999999999999999", "9999999999999999", "1");
            checkDivideOperation("9999999999999999", "10000000000000000", "0.9999999999999999");

            //first is 10000000000000000
            checkDivideOperation("10000000000000000", "-10000000000000000", "-1");
            checkDivideOperation("10000000000000000", "-10", "-1.e+15");
            checkDivideOperation("10000000000000000", "-1", "-1.e+16");

            checkDivideOperation("10000000000000000", "1", "1.e+16");
            checkDivideOperation("10000000000000000", "10", "1.e+15");
            checkDivideOperation("10000000000000000", "10000000000000000", "1");
        }

        //integer and decimal
        {
            //first is -10000000000000000 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-10000000000000000", "9.999999999999999e-17");

            checkDivideOperation("-0.9", "-10000000000000000", "9.e-17");

            checkDivideOperation("-10000000000000000", "-0.1", "1.e+17");
            checkDivideOperation("-0.1", "-10000000000000000", "1.e-17");

            checkDivideOperation("-10000000000000000", "0.1", "-1.e+17");
            checkDivideOperation("0.1", "-10000000000000000", "-1.e-17");

            checkDivideOperation("0.9", "-10000000000000000", "-9.e-17");

            checkDivideOperation("0.9999999999999999", "-10000000000000000", "-9.999999999999999e-17");

            //first is -9999999999999999 (and vice versa)
            checkDivideOperation("-9999999999999999", "-0.9999999999999999", "1.e+16");
            checkDivideOperation("-0.9999999999999999", "-9999999999999999", "1.e-16");


            checkDivideOperation("-9999999999999999", "-0.9", "1.111111111111111e+16");

            checkDivideOperation("-9999999999999999", "-0.1", "9.999999999999999e+16");

            checkDivideOperation("-9999999999999999", "0.1", "-9.999999999999999e+16");

            checkDivideOperation("-9999999999999999", "0.9", "-1.111111111111111e+16");

            checkDivideOperation("-9999999999999999", "0.9999999999999999", "-1.e+16");
            checkDivideOperation("0.9999999999999999", "-9999999999999999", "-1.e-16");

            //first is -9999999999999998 (and vice versa)
            checkDivideOperation("-9999999999999998", "-0.1", "9.999999999999998e+16");

            checkDivideOperation("-9999999999999998", "0.1", "-9.999999999999998e+16");

            //first is -10 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-10", "0.09999999999999999");

            checkDivideOperation("-0.9", "-10", "0.09");

            checkDivideOperation("-10", "-0.1", "1.e+2");
            checkDivideOperation("-0.1", "-10", "0.01");

            checkDivideOperation("-10", "0.1", "-1.e+2");
            checkDivideOperation("0.1", "-10", "-0.01");

            checkDivideOperation("0.9", "-10", "-0.09");

            checkDivideOperation("0.9999999999999999", "-10", "-0.09999999999999999");

            //first is -1 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-1", "0.9999999999999999");

            checkDivideOperation("-0.9", "-1", "0.9");

            checkDivideOperation("-1", "-0.1", "1.e+1");
            checkDivideOperation("-0.1", "-1", "0.1");

            checkDivideOperation("-1", "0.1", "-1.e+1");
            checkDivideOperation("0.1", "-1", "-0.1");

            checkDivideOperation("0.9", "-1", "-0.9");

            checkDivideOperation("0.9999999999999999", "-1", "-0.9999999999999999");

            //first is 0 (and vice versa)
            checkDivideOperation("0", "-0.9999999999999999", "0");

            checkDivideOperation("0", "-0.9", "0");

            checkDivideOperation("0", "-0.1", "0");

            checkDivideOperation("0", "0.1", "0");

            checkDivideOperation("0", "0.9", "0");

            checkDivideOperation("0", "0.9999999999999999", "0");


            //first is 1 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "1", "-0.9999999999999999");

            checkDivideOperation("-0.9", "1", "-0.9");

            checkDivideOperation("1", "-0.1", "-1.e+1");
            checkDivideOperation("-0.1", "1", "-0.1");

            checkDivideOperation("1", "0.1", "1.e+1");
            checkDivideOperation("0.1", "1", "0.1");

            checkDivideOperation("0.9", "1", "0.9");

            checkDivideOperation("0.9999999999999999", "1", "0.9999999999999999");

            //first is 10 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "10", "-0.09999999999999999");


            checkDivideOperation("-0.9", "10", "-0.09");

            checkDivideOperation("10", "-0.1", "-1.e+2");
            checkDivideOperation("-0.1", "10", "-0.01");

            checkDivideOperation("10", "0.1", "1.e+2");
            checkDivideOperation("0.1", "10", "0.01");

            checkDivideOperation("0.9", "10", "0.09");


            checkDivideOperation("0.9999999999999999", "10", "0.09999999999999999");

            //first is 9999999999999998 (and vice versa)
            checkDivideOperation("9999999999999998", "-0.1", "-9.999999999999998e+16");

            checkDivideOperation("9999999999999998", "0.1", "9.999999999999998e+16");

            //first is 9999999999999999 (and vice versa)
            checkDivideOperation("9999999999999999", "-0.9999999999999999", "-1.e+16");
            checkDivideOperation("-0.9999999999999999", "9999999999999999", "-1.e-16");

            checkDivideOperation("9999999999999999", "-0.9", "-1.111111111111111e+16");

            checkDivideOperation("9999999999999999", "-0.1", "-9.999999999999999e+16");

            checkDivideOperation("9999999999999999", "0.1", "9.999999999999999e+16");

            checkDivideOperation("9999999999999999", "0.9", "1.111111111111111e+16");

            checkDivideOperation("9999999999999999", "0.9999999999999999", "1.e+16");
            checkDivideOperation("0.9999999999999999", "9999999999999999", "1.e-16");

            //first is 10000000000000000 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "10000000000000000", "-9.999999999999999e-17");

            checkDivideOperation("-0.9", "10000000000000000", "-9.e-17");

            checkDivideOperation("10000000000000000", "-0.1", "-1.e+17");
            checkDivideOperation("-0.1", "10000000000000000", "-1.e-17");

            checkDivideOperation("10000000000000000", "0.1", "1.e+17");
            checkDivideOperation("0.1", "10000000000000000", "1.e-17");

            checkDivideOperation("0.9", "10000000000000000", "9.e-17");

            checkDivideOperation("0.9999999999999999", "10000000000000000", "9.999999999999999e-17");
        }

        //decimals only
        {
            //first is -0.9999999999999999
            checkDivideOperation("-0.9999999999999999", "-0.9999999999999999", "1");
            checkDivideOperation("-0.9999999999999999", "-0.9", "1.111111111111111");
            checkDivideOperation("-0.9999999999999999", "-0.1", "9.999999999999999");

            checkDivideOperation("-0.9999999999999999", "0.1", "-9.999999999999999");
            checkDivideOperation("-0.9999999999999999", "0.9", "-1.111111111111111");
            checkDivideOperation("-0.9999999999999999", "0.9999999999999999", "-1");

            //first is -0.9
            checkDivideOperation("-0.9", "-0.9", "1");
            checkDivideOperation("-0.9", "-0.1", "9");

            checkDivideOperation("-0.9", "0.1", "-9");
            checkDivideOperation("-0.9", "0.9", "-1");

            //first is -0.1
            checkDivideOperation("-0.1", "-0.1", "1");

            checkDivideOperation("-0.1", "0.1", "-1");

            //first is 0.1
            checkDivideOperation("0.1", "-0.1", "-1");

            checkDivideOperation("0.1", "0.1", "1");

            //first is 0.9
            checkDivideOperation("0.9", "-0.9", "-1");
            checkDivideOperation("0.9", "-0.1", "-9");

            checkDivideOperation("0.9", "0.1", "9");
            checkDivideOperation("0.9", "0.9", "1");

            //first is 0.9999999999999999
            checkDivideOperation("0.9999999999999999", "-0.9999999999999999", "-1");
            checkDivideOperation("0.9999999999999999", "-0.9", "-1.111111111111111");
            checkDivideOperation("0.9999999999999999", "-0.1", "-9.999999999999999");

            checkDivideOperation("0.9999999999999999", "0.1", "9.999999999999999");
            checkDivideOperation("0.9999999999999999", "0.9", "1.111111111111111");
            checkDivideOperation("0.9999999999999999", "0.9999999999999999", "1");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+9999
            checkDivideOperation("-1.e+9999", "-1.e+9999", "1");
            checkDivideOperation("-1.e+9999", "-1.e+9998", "1.e+1");

            checkDivideOperation("-1.e+9999", "1.e+9998", "-1.e+1");
            checkDivideOperation("-1.e+9999", "1.e+9999", "-1");

            //first is -1.e+9998
            checkDivideOperation("-1.e+9998", "-1.e+9999", "0.1");
            checkDivideOperation("-1.e+9998", "-1.e+9998", "1");

            checkDivideOperation("-1.e+9998", "1.e+9998", "-1");
            checkDivideOperation("-1.e+9998", "1.e+9999", "-0.1");

            //first is 1.e+9998
            checkDivideOperation("1.e+9998", "-1.e+9999", "-0.1");
            checkDivideOperation("1.e+9998", "-1.e+9998", "-1");

            checkDivideOperation("1.e+9998", "1.e+9998", "1");
            checkDivideOperation("1.e+9998", "1.e+9999", "0.1");

            //first is 1.e+9999
            checkDivideOperation("1.e+9999", "-1.e+9999", "-1");
            checkDivideOperation("1.e+9999", "-1.e+9998", "-1.e+1");

            checkDivideOperation("1.e+9999", "1.e+9998", "1.e+1");
            checkDivideOperation("1.e+9999", "1.e+9999", "1");


            //first is -1.e+17
            checkDivideOperation("-1.e+17", "-1.e+17", "1");
            checkDivideOperation("-1.e+17", "-1.e+16", "1.e+1");

            checkDivideOperation("-1.e+17", "1.e+16", "-1.e+1");
            checkDivideOperation("-1.e+17", "1.e+17", "-1");

            //first is -1.e+16
            checkDivideOperation("-1.e+16", "-1.e+17", "0.1");
            checkDivideOperation("-1.e+16", "-1.e+16", "1");

            checkDivideOperation("-1.e+16", "1.e+16", "-1");
            checkDivideOperation("-1.e+16", "1.e+17", "-0.1");

            //first is 1.e+16
            checkDivideOperation("1.e+16", "-1.e+17", "-0.1");
            checkDivideOperation("1.e+16", "-1.e+16", "-1");

            checkDivideOperation("1.e+16", "1.e+16", "1");
            checkDivideOperation("1.e+16", "1.e+17", "0.1");

            //first is 1.e+17
            checkDivideOperation("1.e+17", "-1.e+17", "-1");
            checkDivideOperation("1.e+17", "-1.e+16", "-1.e+1");

            checkDivideOperation("1.e+17", "1.e+16", "1.e+1");
            checkDivideOperation("1.e+17", "1.e+17", "1");


            //first is -1.e-9999
            checkDivideOperation("-1.e-9999", "-1.e-9999", "1");
            checkDivideOperation("-1.e-9999", "-1.e-9998", "0.1");

            checkDivideOperation("-1.e-9999", "1.e-9998", "-0.1");
            checkDivideOperation("-1.e-9999", "1.e-9999", "-1");

            //first is -1.e-9998
            checkDivideOperation("-1.e-9998", "-1.e-9999", "1.e+1");
            checkDivideOperation("-1.e-9998", "-1.e-9998", "1");

            checkDivideOperation("-1.e-9998", "1.e-9998", "-1");
            checkDivideOperation("-1.e-9998", "1.e-9999", "-1.e+1");

            //first is 1.e-9998
            checkDivideOperation("1.e-9998", "-1.e-9999", "-1.e+1");
            checkDivideOperation("1.e-9998", "-1.e-9998", "-1");

            checkDivideOperation("1.e-9998", "1.e-9998", "1");
            checkDivideOperation("1.e-9998", "1.e-9999", "1.e+1");

            //first is 1.e-9999
            checkDivideOperation("1.e-9999", "-1.e-9999", "-1");
            checkDivideOperation("1.e-9999", "-1.e-9998", "-0.1");

            checkDivideOperation("1.e-9999", "1.e-9998", "0.1");
            checkDivideOperation("1.e-9999", "1.e-9999", "1");


            //first is -1.e-17
            checkDivideOperation("-1.e-17", "-1.e-17", "1");
            checkDivideOperation("-1.e-17", "-1.e-16", "0.1");

            checkDivideOperation("-1.e-17", "1.e-16", "-0.1");
            checkDivideOperation("-1.e-17", "1.e-17", "-1");

            //first is -1.e-16
            checkDivideOperation("-1.e-16", "-1.e-17", "1.e+1");
            checkDivideOperation("-1.e-16", "-1.e-16", "1");

            checkDivideOperation("-1.e-16", "1.e-16", "-1");
            checkDivideOperation("-1.e-16", "1.e-17", "-1.e+1");

            //first is 1.e-16
            checkDivideOperation("1.e-16", "-1.e-17", "-1.e+1");
            checkDivideOperation("1.e-16", "-1.e-16", "-1");

            checkDivideOperation("1.e-16", "1.e-16", "1");
            checkDivideOperation("1.e-16", "1.e-17", "1.e+1");

            //first is 1.e-17
            checkDivideOperation("1.e-17", "-1.e-17", "-1");
            checkDivideOperation("1.e-17", "-1.e-16", "-0.1");

            checkDivideOperation("1.e-17", "1.e-16", "0.1");
            checkDivideOperation("1.e-17", "1.e-17", "1");
        }

        //with integers
        {
            //first is -1.e+9999 (and vice versa)
            checkDivideOperation("-1.e+9999", "-10000000000000000", "1.e+9983");
            checkDivideOperation("-10000000000000000", "-1.e+9999", "1.e-9983");

            checkDivideOperation("-9999999999999999", "-1.e+9999", "9.999999999999999e-9984");

            checkDivideOperation("-9999999999999998", "-1.e+9999",
                    "9.999999999999998e-9984");

            checkDivideOperation("-1.e+9999", "-10", "1.e+9998");
            checkDivideOperation("-10", "-1.e+9999", "1.e-9998");

            checkDivideOperation("-1.e+9999", "-1", "1.e+9999");
            checkDivideOperation("-1", "-1.e+9999", "1.e-9999");


            checkDivideOperation("0", "-1.e+9999", "0");


            checkDivideOperation("-1.e+9999", "1", "-1.e+9999");
            checkDivideOperation("1", "-1.e+9999", "-1.e-9999");

            checkDivideOperation("-1.e+9999", "10", "-1.e+9998");
            checkDivideOperation("10", "-1.e+9999", "-1.e-9998");

            checkDivideOperation("9999999999999998", "-1.e+9999",
                    "-9.999999999999998e-9984");

            checkDivideOperation("9999999999999999", "-1.e+9999", "-9.999999999999999e-9984");

            checkDivideOperation("-1.e+9999", "10000000000000000", "-1.e+9983");
            checkDivideOperation("10000000000000000", "-1.e+9999", "-1.e-9983");

            //first is -1.e+9998 (and vice versa)
            checkDivideOperation("-1.e+9998", "-10000000000000000", "1.e+9982");
            checkDivideOperation("-10000000000000000", "-1.e+9998", "1.e-9982");

            checkDivideOperation("-9999999999999999", "-1.e+9998", "9.999999999999999e-9983");

            checkDivideOperation("-9999999999999998", "-1.e+9998",
                    "9.999999999999998e-9983");

            checkDivideOperation("-1.e+9998", "-10", "1.e+9997");
            checkDivideOperation("-10", "-1.e+9998", "1.e-9997");

            checkDivideOperation("-1.e+9998", "-1", "1.e+9998");
            checkDivideOperation("-1", "-1.e+9998", "1.e-9998");


            checkDivideOperation("0", "-1.e+9998", "0");


            checkDivideOperation("-1.e+9998", "1", "-1.e+9998");
            checkDivideOperation("1", "-1.e+9998", "-1.e-9998");

            checkDivideOperation("-1.e+9998", "10", "-1.e+9997");
            checkDivideOperation("10", "-1.e+9998", "-1.e-9997");

            checkDivideOperation("9999999999999998", "-1.e+9998",
                    "-9.999999999999998e-9983");

            checkDivideOperation("9999999999999999", "-1.e+9998", "-9.999999999999999e-9983");

            checkDivideOperation("-1.e+9998", "10000000000000000", "-1.e+9982");
            checkDivideOperation("10000000000000000", "-1.e+9998", "-1.e-9982");

            //first is 1.e+9998 (and vice versa)
            checkDivideOperation("1.e+9998", "-10000000000000000", "-1.e+9982");
            checkDivideOperation("-10000000000000000", "1.e+9998", "-1.e-9982");

            checkDivideOperation("-9999999999999999", "1.e+9998", "-9.999999999999999e-9983");

            checkDivideOperation("-9999999999999998", "1.e+9998", "-9.999999999999998e-9983");

            checkDivideOperation("1.e+9998", "-10", "-1.e+9997");
            checkDivideOperation("-10", "1.e+9998", "-1.e-9997");

            checkDivideOperation("1.e+9998", "-1", "-1.e+9998");
            checkDivideOperation("-1", "1.e+9998", "-1.e-9998");


            checkDivideOperation("0", "1.e+9998", "0");


            checkDivideOperation("1.e+9998", "1", "1.e+9998");
            checkDivideOperation("1", "1.e+9998", "1.e-9998");

            checkDivideOperation("1.e+9998", "10", "1.e+9997");
            checkDivideOperation("10", "1.e+9998", "1.e-9997");

            checkDivideOperation("9999999999999998", "1.e+9998", "9.999999999999998e-9983");

            checkDivideOperation("9999999999999999", "1.e+9998", "9.999999999999999e-9983");

            checkDivideOperation("1.e+9998", "10000000000000000", "1.e+9982");
            checkDivideOperation("10000000000000000", "1.e+9998", "1.e-9982");

            //first is 1.e+9999 (and vice versa)
            checkDivideOperation("1.e+9999", "-10000000000000000", "-1.e+9983");
            checkDivideOperation("-10000000000000000", "1.e+9999", "-1.e-9983");

            checkDivideOperation("-9999999999999999", "1.e+9999", "-9.999999999999999e-9984");

            checkDivideOperation("-9999999999999998", "1.e+9999", "-9.999999999999998e-9984");

            checkDivideOperation("1.e+9999", "-10", "-1.e+9998");
            checkDivideOperation("-10", "1.e+9999", "-1.e-9998");

            checkDivideOperation("1.e+9999", "-1", "-1.e+9999");
            checkDivideOperation("-1", "1.e+9999", "-1.e-9999");


            checkDivideOperation("0", "1.e+9999", "0");


            checkDivideOperation("1.e+9999", "1", "1.e+9999");
            checkDivideOperation("1", "1.e+9999", "1.e-9999");

            checkDivideOperation("1.e+9999", "10", "1.e+9998");
            checkDivideOperation("10", "1.e+9999", "1.e-9998");

            checkDivideOperation("9999999999999998", "1.e+9999", "9.999999999999998e-9984");

            checkDivideOperation("9999999999999999", "1.e+9999", "9.999999999999999e-9984");

            checkDivideOperation("1.e+9999", "10000000000000000", "1.e+9983");
            checkDivideOperation("10000000000000000", "1.e+9999", "1.e-9983");


            //first is -1.e+17 (and vice versa)
            checkDivideOperation("-1.e+17", "-10000000000000000", "1.e+1");
            checkDivideOperation("-10000000000000000", "-1.e+17", "0.1");

            checkDivideOperation("-9999999999999999", "-1.e+17", "0.09999999999999999");

            checkDivideOperation("-9999999999999998", "-1.e+17", "0.09999999999999998");

            checkDivideOperation("-1.e+17", "-10", "1.e+16");
            checkDivideOperation("-10", "-1.e+17", "1.e-16");

            checkDivideOperation("-1.e+17", "-1", "1.e+17");
            checkDivideOperation("-1", "-1.e+17", "1.e-17");


            checkDivideOperation("0", "-1.e+17", "0");


            checkDivideOperation("-1.e+17", "1", "-1.e+17");
            checkDivideOperation("1", "-1.e+17", "-1.e-17");

            checkDivideOperation("-1.e+17", "10", "-1.e+16");
            checkDivideOperation("10", "-1.e+17", "-1.e-16");

            checkDivideOperation("9999999999999998", "-1.e+17", "-0.09999999999999998");

            checkDivideOperation("9999999999999999", "-1.e+17", "-0.09999999999999999");

            checkDivideOperation("-1.e+17", "10000000000000000", "-1.e+1");
            checkDivideOperation("10000000000000000", "-1.e+17", "-0.1");

            //first is -1.e+16 (and vice versa)
            checkDivideOperation("-1.e+16", "-10000000000000000", "1");
            checkDivideOperation("-10000000000000000", "-1.e+16", "1");

            checkDivideOperation("-9999999999999999", "-1.e+16", "0.9999999999999999");

            checkDivideOperation("-9999999999999998", "-1.e+16", "0.9999999999999998");

            checkDivideOperation("-1.e+16", "-10", "1.e+15");
            checkDivideOperation("-10", "-1.e+16", "1.e-15");

            checkDivideOperation("-1.e+16", "-1", "1.e+16");
            checkDivideOperation("-1", "-1.e+16", "1.e-16");


            checkDivideOperation("0", "-1.e+16", "0");


            checkDivideOperation("-1.e+16", "1", "-1.e+16");
            checkDivideOperation("1", "-1.e+16", "-1.e-16");

            checkDivideOperation("-1.e+16", "10", "-1.e+15");
            checkDivideOperation("10", "-1.e+16", "-1.e-15");

            checkDivideOperation("9999999999999998", "-1.e+16", "-0.9999999999999998");

            checkDivideOperation("9999999999999999", "-1.e+16", "-0.9999999999999999");

            checkDivideOperation("-1.e+16", "10000000000000000", "-1");
            checkDivideOperation("10000000000000000", "-1.e+16", "-1");

            //first is 1.e+16 (and vice versa)
            checkDivideOperation("1.e+16", "-10000000000000000", "-1");
            checkDivideOperation("-10000000000000000", "1.e+16", "-1");

            checkDivideOperation("-9999999999999999", "1.e+16", "-0.9999999999999999");

            checkDivideOperation("-9999999999999998", "1.e+16", "-0.9999999999999998");

            checkDivideOperation("1.e+16", "-10", "-1.e+15");
            checkDivideOperation("-10", "1.e+16", "-1.e-15");

            checkDivideOperation("1.e+16", "-1", "-1.e+16");
            checkDivideOperation("-1", "1.e+16", "-1.e-16");


            checkDivideOperation("0", "1.e+16", "0");


            checkDivideOperation("1.e+16", "1", "1.e+16");
            checkDivideOperation("1", "1.e+16", "1.e-16");

            checkDivideOperation("1.e+16", "10", "1.e+15");
            checkDivideOperation("10", "1.e+16", "1.e-15");

            checkDivideOperation("9999999999999998", "1.e+16", "0.9999999999999998");

            checkDivideOperation("9999999999999999", "1.e+16", "0.9999999999999999");

            checkDivideOperation("1.e+16", "10000000000000000", "1");
            checkDivideOperation("10000000000000000", "1.e+16", "1");

            //first is 1.e+17 (and vice versa)
            checkDivideOperation("1.e+17", "-10000000000000000", "-1.e+1");
            checkDivideOperation("-10000000000000000", "1.e+17", "-0.1");

            checkDivideOperation("-9999999999999999", "1.e+17", "-0.09999999999999999");

            checkDivideOperation("-9999999999999998", "1.e+17", "-0.09999999999999998");

            checkDivideOperation("1.e+17", "-10", "-1.e+16");
            checkDivideOperation("-10", "1.e+17", "-1.e-16");

            checkDivideOperation("1.e+17", "-1", "-1.e+17");
            checkDivideOperation("-1", "1.e+17", "-1.e-17");


            checkDivideOperation("0", "1.e+17", "0");


            checkDivideOperation("1.e+17", "1", "1.e+17");
            checkDivideOperation("1", "1.e+17", "1.e-17");

            checkDivideOperation("1.e+17", "10", "1.e+16");
            checkDivideOperation("10", "1.e+17", "1.e-16");

            checkDivideOperation("9999999999999998", "1.e+17", "0.09999999999999998");

            checkDivideOperation("9999999999999999", "1.e+17", "0.09999999999999999");

            checkDivideOperation("1.e+17", "10000000000000000", "1.e+1");
            checkDivideOperation("10000000000000000", "1.e+17", "0.1");


            //first is -1.e-9999 (and vice versa)
            checkDivideOperation("-1.e-9999", "-1", "1.e-9999");
            checkDivideOperation("-1", "-1.e-9999", "1.e+9999");

            checkDivideOperation("0", "-1.e-9999", "0");

            checkDivideOperation("-1.e-9999", "1", "-1.e-9999");
            checkDivideOperation("1", "-1.e-9999", "-1.e+9999");

            //first is -1.e-9998 (and vice versa)
            checkDivideOperation("-1.e-9998", "-10", "1.e-9999");
            checkDivideOperation("-10", "-1.e-9998", "1.e+9999");

            checkDivideOperation("-1.e-9998", "-1", "1.e-9998");
            checkDivideOperation("-1", "-1.e-9998", "1.e+9998");


            checkDivideOperation("0", "-1.e-9998", "0");


            checkDivideOperation("-1.e-9998", "1", "-1.e-9998");
            checkDivideOperation("1", "-1.e-9998", "-1.e+9998");

            checkDivideOperation("-1.e-9998", "10", "-1.e-9999");
            checkDivideOperation("10", "-1.e-9998", "-1.e+9999");

            //first is 1.e-9998 (and vice versa)
            checkDivideOperation("1.e-9998", "-10", "-1.e-9999");
            checkDivideOperation("-10", "1.e-9998", "-1.e+9999");

            checkDivideOperation("1.e-9998", "-1", "-1.e-9998");
            checkDivideOperation("-1", "1.e-9998", "-1.e+9998");


            checkDivideOperation("0", "1.e-9998", "0");


            checkDivideOperation("1.e-9998", "1", "1.e-9998");
            checkDivideOperation("1", "1.e-9998", "1.e+9998");

            checkDivideOperation("1.e-9998", "10", "1.e-9999");
            checkDivideOperation("10", "1.e-9998", "1.e+9999");

            //first is 1.e-9999 (and vice versa)
            checkDivideOperation("1.e-9999", "-1", "-1.e-9999");
            checkDivideOperation("-1", "1.e-9999", "-1.e+9999");

            checkDivideOperation("0", "1.e-9999", "0");

            checkDivideOperation("1.e-9999", "1", "1.e-9999");
            checkDivideOperation("1", "1.e-9999", "1.e+9999");


            //first is -1.e-17 (and vice versa)
            checkDivideOperation("-1.e-17", "-10000000000000000", "1.e-33");
            checkDivideOperation("-10000000000000000", "-1.e-17", "1.e+33");

            checkDivideOperation("-9999999999999999", "-1.e-17", "9.999999999999999e+32");

            checkDivideOperation("-9999999999999998", "-1.e-17", "9.999999999999998e+32");

            checkDivideOperation("-1.e-17", "-10", "1.e-18");
            checkDivideOperation("-10", "-1.e-17", "1.e+18");

            checkDivideOperation("-1.e-17", "-1", "1.e-17");
            checkDivideOperation("-1", "-1.e-17", "1.e+17");


            checkDivideOperation("0", "-1.e-17", "0");


            checkDivideOperation("-1.e-17", "1", "-1.e-17");
            checkDivideOperation("1", "-1.e-17", "-1.e+17");

            checkDivideOperation("-1.e-17", "10", "-1.e-18");
            checkDivideOperation("10", "-1.e-17", "-1.e+18");

            checkDivideOperation("9999999999999998", "-1.e-17",
                    "-9.999999999999998e+32");

            checkDivideOperation("9999999999999999", "-1.e-17", "-9.999999999999999e+32");

            checkDivideOperation("-1.e-17", "10000000000000000", "-1.e-33");
            checkDivideOperation("10000000000000000", "-1.e-17", "-1.e+33");

            //first is -1.e-16 (and vice versa)
            checkDivideOperation("-1.e-16", "-10000000000000000", "1.e-32");
            checkDivideOperation("-10000000000000000", "-1.e-16", "1.e+32");

            checkDivideOperation("-9999999999999999", "-1.e-16", "9.999999999999999e+31");

            checkDivideOperation("-9999999999999998", "-1.e-16", "9.999999999999998e+31");

            checkDivideOperation("-1.e-16", "-10", "1.e-17");
            checkDivideOperation("-10", "-1.e-16", "1.e+17");

            checkDivideOperation("-1.e-16", "-1", "1.e-16");
            checkDivideOperation("-1", "-1.e-16", "1.e+16");


            checkDivideOperation("0", "-1.e-16", "0");


            checkDivideOperation("-1.e-16", "1", "-1.e-16");
            checkDivideOperation("1", "-1.e-16", "-1.e+16");

            checkDivideOperation("-1.e-16", "10", "-1.e-17");
            checkDivideOperation("10", "-1.e-16", "-1.e+17");

            checkDivideOperation("9999999999999998", "-1.e-16",
                    "-9.999999999999998e+31");

            checkDivideOperation("9999999999999999", "-1.e-16", "-9.999999999999999e+31");

            checkDivideOperation("-1.e-16", "10000000000000000", "-1.e-32");
            checkDivideOperation("10000000000000000", "-1.e-16", "-1.e+32");

            //first is 1.e-16 (and vice versa)
            checkDivideOperation("1.e-16", "-10000000000000000", "-1.e-32");
            checkDivideOperation("-10000000000000000", "1.e-16", "-1.e+32");

            checkDivideOperation("-9999999999999999", "1.e-16", "-9.999999999999999e+31");

            checkDivideOperation("-9999999999999998", "1.e-16", "-9.999999999999998e+31");

            checkDivideOperation("1.e-16", "-10", "-1.e-17");
            checkDivideOperation("-10", "1.e-16", "-1.e+17");

            checkDivideOperation("1.e-16", "-1", "-1.e-16");
            checkDivideOperation("-1", "1.e-16", "-1.e+16");


            checkDivideOperation("0", "1.e-16", "0");


            checkDivideOperation("1.e-16", "1", "1.e-16");
            checkDivideOperation("1", "1.e-16", "1.e+16");

            checkDivideOperation("1.e-16", "10", "1.e-17");
            checkDivideOperation("10", "1.e-16", "1.e+17");

            checkDivideOperation("9999999999999998", "1.e-16", "9.999999999999998e+31");

            checkDivideOperation("9999999999999999", "1.e-16", "9.999999999999999e+31");

            checkDivideOperation("1.e-16", "10000000000000000", "1.e-32");
            checkDivideOperation("10000000000000000", "1.e-16", "1.e+32");

            //first is 1.e-17 (and vice versa)
            checkDivideOperation("1.e-17", "-10000000000000000", "-1.e-33");
            checkDivideOperation("-10000000000000000", "1.e-17", "-1.e+33");

            checkDivideOperation("-9999999999999999", "1.e-17", "-9.999999999999999e+32");

            checkDivideOperation("-9999999999999998", "1.e-17", "-9.999999999999998e+32");

            checkDivideOperation("1.e-17", "-10", "-1.e-18");
            checkDivideOperation("-10", "1.e-17", "-1.e+18");

            checkDivideOperation("1.e-17", "-1", "-1.e-17");
            checkDivideOperation("-1", "1.e-17", "-1.e+17");


            checkDivideOperation("0", "1.e-17", "0");


            checkDivideOperation("1.e-17", "1", "1.e-17");
            checkDivideOperation("1", "1.e-17", "1.e+17");

            checkDivideOperation("1.e-17", "10", "1.e-18");
            checkDivideOperation("10", "1.e-17", "1.e+18");

            checkDivideOperation("9999999999999998", "1.e-17", "9.999999999999998e+32");

            checkDivideOperation("9999999999999999", "1.e-17", "9.999999999999999e+32");

            checkDivideOperation("1.e-17", "10000000000000000", "1.e-33");
            checkDivideOperation("10000000000000000", "1.e-17", "1.e+33");
        }

        //with decimals
        {
            //first is -1.e+9998 (and vice versa)
            checkDivideOperation("-0.9", "-1.e+9998", "9.e-9999");

            checkDivideOperation("-1.e+9998", "-0.1", "1.e+9999");
            checkDivideOperation("-0.1", "-1.e+9998", "1.e-9999");


            checkDivideOperation("-1.e+9998", "0.1", "-1.e+9999");
            checkDivideOperation("0.1", "-1.e+9998", "-1.e-9999");

            checkDivideOperation("0.9", "-1.e+9998", "-9.e-9999");

            //first is 1.e+9998 (and vice versa)
            checkDivideOperation("-0.9", "1.e+9998", "-9.e-9999");

            checkDivideOperation("1.e+9998", "-0.1", "-1.e+9999");
            checkDivideOperation("-0.1", "1.e+9998", "-1.e-9999");


            checkDivideOperation("1.e+9998", "0.1", "1.e+9999");
            checkDivideOperation("0.1", "1.e+9998", "1.e-9999");

            checkDivideOperation("0.9", "1.e+9998", "9.e-9999");


            //first is -1.e-9999 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-1.e-9999", "9.999999999999999e+9998");

            checkDivideOperation("-0.9", "-1.e-9999", "9.e+9998");

            checkDivideOperation("-1.e-9999", "-0.1", "1.e-9998");
            checkDivideOperation("-0.1", "-1.e-9999", "1.e+9998");

            checkDivideOperation("-1.e-9999", "0.1", "-1.e-9998");
            checkDivideOperation("0.1", "-1.e-9999", "-1.e+9998");

            checkDivideOperation("0.9", "-1.e-9999", "-9.e+9998");

            checkDivideOperation("0.9999999999999999", "-1.e-9999", "-9.999999999999999e+9998");

            //first is -1.e-9998 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-1.e-9998", "9.999999999999999e+9997");

            checkDivideOperation("-0.9", "-1.e-9998", "9.e+9997");

            checkDivideOperation("-1.e-9998", "-0.1", "1.e-9997");
            checkDivideOperation("-0.1", "-1.e-9998", "1.e+9997");

            checkDivideOperation("-1.e-9998", "0.1", "-1.e-9997");
            checkDivideOperation("0.1", "-1.e-9998", "-1.e+9997");

            checkDivideOperation("0.9", "-1.e-9998", "-9.e+9997");

            checkDivideOperation("0.9999999999999999", "-1.e-9998", "-9.999999999999999e+9997");

            //first is 1.e-9998 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "1.e-9998", "-9.999999999999999e+9997");

            checkDivideOperation("-0.9", "1.e-9998", "-9.e+9997");

            checkDivideOperation("1.e-9998", "-0.1", "-1.e-9997");
            checkDivideOperation("-0.1", "1.e-9998", "-1.e+9997");

            checkDivideOperation("1.e-9998", "0.1", "1.e-9997");
            checkDivideOperation("0.1", "1.e-9998", "1.e+9997");

            checkDivideOperation("0.9", "1.e-9998", "9.e+9997");

            checkDivideOperation("0.9999999999999999", "1.e-9998", "9.999999999999999e+9997");

            //first is 1.e-9999 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "1.e-9999", "-9.999999999999999e+9998");

            checkDivideOperation("-0.9", "1.e-9999", "-9.e+9998");

            checkDivideOperation("1.e-9999", "-0.1", "-1.e-9998");
            checkDivideOperation("-0.1", "1.e-9999", "-1.e+9998");

            checkDivideOperation("1.e-9999", "0.1", "1.e-9998");
            checkDivideOperation("0.1", "1.e-9999", "1.e+9998");

            checkDivideOperation("0.9", "1.e-9999", "9.e+9998");

            checkDivideOperation("0.9999999999999999", "1.e-9999", "9.999999999999999e+9998");

            //first is -1.e+17 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-1.e+17", "9.999999999999999e-18");

            checkDivideOperation("-0.9", "-1.e+17", "9.e-18");

            checkDivideOperation("-1.e+17", "-0.1", "1.e+18");
            checkDivideOperation("-0.1", "-1.e+17", "1.e-18");

            checkDivideOperation("-1.e+17", "0.1", "-1.e+18");
            checkDivideOperation("0.1", "-1.e+17", "-1.e-18");

            checkDivideOperation("0.9", "-1.e+17", "-9.e-18");

            checkDivideOperation("0.9999999999999999", "-1.e+17", "-9.999999999999999e-18");

            //first is -1.e+16 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-1.e+16", "9.999999999999999e-17");

            checkDivideOperation("-0.9", "-1.e+16", "9.e-17");

            checkDivideOperation("-1.e+16", "-0.1", "1.e+17");
            checkDivideOperation("-0.1", "-1.e+16", "1.e-17");

            checkDivideOperation("-1.e+16", "0.1", "-1.e+17");
            checkDivideOperation("0.1", "-1.e+16", "-1.e-17");

            checkDivideOperation("0.9", "-1.e+16", "-9.e-17");

            checkDivideOperation("0.9999999999999999", "-1.e+16", "-9.999999999999999e-17");

            //first is 1.e+16 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "1.e+16", "-9.999999999999999e-17");

            checkDivideOperation("-0.9", "1.e+16", "-9.e-17");

            checkDivideOperation("1.e+16", "-0.1", "-1.e+17");
            checkDivideOperation("-0.1", "1.e+16", "-1.e-17");

            checkDivideOperation("1.e+16", "0.1", "1.e+17");
            checkDivideOperation("0.1", "1.e+16", "1.e-17");

            checkDivideOperation("0.9", "1.e+16", "9.e-17");

            checkDivideOperation("0.9999999999999999", "1.e+16", "9.999999999999999e-17");

            //first is 1.e+17 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "1.e+17", "-9.999999999999999e-18");

            checkDivideOperation("-0.9", "1.e+17", "-9.e-18");

            checkDivideOperation("1.e+17", "-0.1", "-1.e+18");
            checkDivideOperation("-0.1", "1.e+17", "-1.e-18");

            checkDivideOperation("1.e+17", "0.1", "1.e+18");
            checkDivideOperation("0.1", "1.e+17", "1.e-18");

            checkDivideOperation("0.9", "1.e+17", "9.e-18");

            checkDivideOperation("0.9999999999999999", "1.e+17", "9.999999999999999e-18");

            //first is -1.e-17 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-1.e-17", "9.999999999999999e+16");

            checkDivideOperation("-0.9", "-1.e-17", "9.e+16");

            checkDivideOperation("-1.e-17", "-0.1", "1.e-16");
            checkDivideOperation("-0.1", "-1.e-17", "1.e+16");

            checkDivideOperation("-1.e-17", "0.1", "-1.e-16");
            checkDivideOperation("0.1", "-1.e-17", "-1.e+16");

            checkDivideOperation("0.9", "-1.e-17", "-9.e+16");

            checkDivideOperation("0.9999999999999999", "-1.e-17", "-9.999999999999999e+16");

            //first is -1.e-16 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "-1.e-16", "9.999999999999999e+15");

            checkDivideOperation("-0.9", "-1.e-16", "9.e+15");

            checkDivideOperation("-1.e-16", "-0.1", "1.e-15");
            checkDivideOperation("-0.1", "-1.e-16", "1.e+15");

            checkDivideOperation("-1.e-16", "0.1", "-1.e-15");
            checkDivideOperation("0.1", "-1.e-16", "-1.e+15");

            checkDivideOperation("0.9", "-1.e-16", "-9.e+15");

            checkDivideOperation("0.9999999999999999", "-1.e-16", "-9.999999999999999e+15");

            //first is 1.e-16 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "1.e-16", "-9.999999999999999e+15");

            checkDivideOperation("-0.9", "1.e-16", "-9.e+15");

            checkDivideOperation("1.e-16", "-0.1", "-1.e-15");
            checkDivideOperation("-0.1", "1.e-16", "-1.e+15");

            checkDivideOperation("1.e-16", "0.1", "1.e-15");
            checkDivideOperation("0.1", "1.e-16", "1.e+15");

            checkDivideOperation("0.9", "1.e-16", "9.e+15");

            checkDivideOperation("0.9999999999999999", "1.e-16", "9.999999999999999e+15");

            //first is 1.e-17 (and vice versa)
            checkDivideOperation("-0.9999999999999999", "1.e-17", "-9.999999999999999e+16");

            checkDivideOperation("-0.9", "1.e-17", "-9.e+16");

            checkDivideOperation("1.e-17", "-0.1", "-1.e-16");
            checkDivideOperation("-0.1", "1.e-17", "-1.e+16");

            checkDivideOperation("1.e-17", "0.1", "1.e-16");
            checkDivideOperation("0.1", "1.e-17", "1.e+16");

            checkDivideOperation("0.9", "1.e-17", "9.e+16");

            checkDivideOperation("0.9999999999999999", "1.e-17", "9.999999999999999e+16");
        }

        //several random values
        {
            checkDivideOperation("24", "12", "2");
            checkDivideOperation("415", "5", "83");

            checkDivideOperation("123", "-3", "-41");
            checkDivideOperation("140", "-7", "-2.e+1");

            checkDivideOperation("-41", "-41", "1");
            checkDivideOperation("-651", "-6", "108.5");

            checkDivideOperation("504", "2.52", "2.e+2");
            checkDivideOperation("1001", "10.01", "1.e+2");

            checkDivideOperation("101", "-1.01", "-1.e+2");
            checkDivideOperation("88", "-2.2", "-4.e+1");

            checkDivideOperation("-5342", "53.42", "-1.e+2");
            checkDivideOperation("-100", "0.05", "-2.e+3");

            checkDivideOperation("-65", "-6.5", "1.e+1");
            checkDivideOperation("-123", "-1.23", "1.e+2");

            checkDivideOperation("555.555", "555.555", "1");
            checkDivideOperation("132.5", "66.25", "2");

            checkDivideOperation("65.65", "-32.825", "-2");
            checkDivideOperation("15.12", "-0.3", "-50.4");

            checkDivideOperation("-0.76", "-0.001", "7.6e+2");
            checkDivideOperation("-1061.5", "-1.1", "965");
        }
    }

    /**
     * Tests for negate operation.
     */
    @Test
    void negateOperationTests() {
        //integers
        checkNegateOperation("-10000000000000000", "1.e+16");
        checkNegateOperation("-9999999999999999", "9999999999999999");
        checkNegateOperation("-9999999999999998", "9999999999999998");
        checkNegateOperation("-10", "1.e+1");
        checkNegateOperation("-1", "1");

        checkNegateOperation("0", "0");

        checkNegateOperation("1", "-1");
        checkNegateOperation("10", "-1.e+1");
        checkNegateOperation("9999999999999998", "-9999999999999998");
        checkNegateOperation("9999999999999999", "-9999999999999999");
        checkNegateOperation("10000000000000000", "-1.e+16");


        //decimals

        checkNegateOperation("-0.9999999999999999", "0.9999999999999999");
        checkNegateOperation("-0.9", "0.9");
        checkNegateOperation("-0.1", "0.1");

        checkNegateOperation("0.1", "-0.1");
        checkNegateOperation("0.9", "-0.9");
        checkNegateOperation("0.9999999999999999", "-0.9999999999999999");


        //engineer numbers

        checkNegateOperation("-1.e+9999", "1.e+9999");
        checkNegateOperation("-1.e+9998", "1.e+9998");
        checkNegateOperation("-1.e+17", "1.e+17");
        checkNegateOperation("-1.e+16", "1.e+16");

        checkNegateOperation("1.e+16", "-1.e+16");
        checkNegateOperation("1.e+17", "-1.e+17");
        checkNegateOperation("1.e+9998", "-1.e+9998");
        checkNegateOperation("1.e+9999", "-1.e+9999");


        checkNegateOperation("-1.e-9999", "1.e-9999");
        checkNegateOperation("-1.e-9998", "1.e-9998");
        checkNegateOperation("-1.e-17", "1.e-17");
        checkNegateOperation("-1.e-16", "1.e-16");

        checkNegateOperation("1.e-16", "-1.e-16");
        checkNegateOperation("1.e-17", "-1.e-17");
        checkNegateOperation("1.e-9998", "-1.e-9998");
        checkNegateOperation("1.e-9999", "-1.e-9999");


        //several random values

        checkNegateOperation("6324", "-6324");
        checkNegateOperation("987", "-987");

        checkNegateOperation("-213", "213");
        checkNegateOperation("-6512", "6512");

        checkNegateOperation("84.13", "-84.13");
        checkNegateOperation("98735.8457", "-98735.8457");

        checkNegateOperation("-234.123", "234.123");
        checkNegateOperation("-6434.213", "6434.213");

    }

    /**
     * Tests for square operation.
     */
    @Test
    void sqrOperationTests() {
        //integers 

        checkSqrOperation("-10000000000000000", "1.e+32");
        checkSqrOperation("-9999999999999999", "99999999999999980000000000000001");
        checkSqrOperation("-9999999999999998", "99999999999999960000000000000004");
        checkSqrOperation("-10", "1.e+2");
        checkSqrOperation("-1", "1");

        checkSqrOperation("0", "0");

        checkSqrOperation("1", "1");
        checkSqrOperation("10", "1.e+2");
        checkSqrOperation("9999999999999998", "99999999999999960000000000000004");
        checkSqrOperation("9999999999999999", "99999999999999980000000000000001");
        checkSqrOperation("10000000000000000", "1.e+32");


        //decimals

        checkSqrOperation("-0.9999999999999999", "0.99999999999999980000000000000001");
        checkSqrOperation("-0.9", "0.81");
        checkSqrOperation("-0.1", "0.01");

        checkSqrOperation("0.1", "0.01");
        checkSqrOperation("0.9", "0.81");
        checkSqrOperation("0.9999999999999999", "0.99999999999999980000000000000001");


        //engineer numbers

        checkSqrOperation("-1.e+17", "1.e+34");
        checkSqrOperation("-1.e+16", "1.e+32");

        checkSqrOperation("1.e+16", "1.e+32");
        checkSqrOperation("1.e+17", "1.e+34");


        checkSqrOperation("-1.e-17", "1.e-34");
        checkSqrOperation("-1.e-16", "1.e-32");

        checkSqrOperation("1.e-16", "1.e-32");
        checkSqrOperation("1.e-17", "1.e-34");


        //several random values

        checkSqrOperation("743", "552049");
        checkSqrOperation("324", "104976");

        checkSqrOperation("-87634", "7679717956");
        checkSqrOperation("-234", "54756");

        checkSqrOperation("987.12", "974405.8944");
        checkSqrOperation("1.2", "1.44");

        checkSqrOperation("-31.62", "999.8244");
        checkSqrOperation("-65.123", "4241.005129");

    }

    /**
     * Tests for square root operation.
     */
    @Test
    void sqrtOperationTests() {
        //integers 

        checkSqrtOperation("0", "0");

        checkSqrtOperation("1", "1");
        checkSqrtOperation("9", "3");
        checkSqrtOperation("25000000000000", "5.e+6");
        checkSqrtOperation("11111108888889", "3333333");
        checkSqrtOperation("10000000000000000", "1.e+8");


        //decimals

        checkSqrtOperation("0.015625", "0.125");
        checkSqrtOperation("0.04", "0.2");
        checkSqrtOperation("0.36", "0.6");


        //engineer numbers

        checkSqrtOperation("1.e+16", "1.e+8");
        checkSqrtOperation("1.e+17", "316227766.0168379");
        checkSqrtOperation("1.e+9998", "1.e+4999");
        checkSqrtOperation("1.e+9999", "3.162277660168379e+4999");

        checkSqrtOperation("1.e-16", "1.e-8");
        checkSqrtOperation("1.e-17", "3.162277660168379e-9");


        //several random values

        checkSqrtOperation("9132131", "3021.941594405822");
        checkSqrtOperation("1235123", "1111.360877483097");

        checkSqrtOperation("123.5523", "11.11540822462225");
        checkSqrtOperation("123.1243", "11.09613896812761");

    }

    /**
     * Tests for inverse operation.
     */
    @Test
    void inverseOperationTests() {
        //integers
        checkInverseOperation("-10000000000000000", "-1.e-16");
        checkInverseOperation("-10", "-1.e-1");
        checkInverseOperation("-1", "-1");

        checkInverseOperation("1", "1");
        checkInverseOperation("10", "1.e-1");
        checkInverseOperation("10000000000000000", "1.e-16");


        //decimals

        checkInverseOperation("-0.1", "-1.e+1");

        checkInverseOperation("0.1", "1.e+1");


        //engineer numbers

        checkInverseOperation("-1.e+9999", "-1.e-9999");
        checkInverseOperation("-1.e+9998", "-1.e-9998");
        checkInverseOperation("-1.e+17", "-1.e-17");
        checkInverseOperation("-1.e+16", "-1.e-16");

        checkInverseOperation("1.e+16", "1.e-16");
        checkInverseOperation("1.e+17", "1.e-17");
        checkInverseOperation("1.e+9998", "1.e-9998");
        checkInverseOperation("1.e+9999", "1.e-9999");


        checkInverseOperation("-1.e-9999", "-1.e+9999");
        checkInverseOperation("-1.e-9998", "-1.e+9998");
        checkInverseOperation("-1.e-17", "-1.e+17");
        checkInverseOperation("-1.e-16", "-1.e+16");

        checkInverseOperation("1.e-16", "1.e+16");
        checkInverseOperation("1.e-17", "1.e+17");
        checkInverseOperation("1.e-9998", "1.e+9998");
        checkInverseOperation("1.e-9999", "1.e+9999");


        //several random values

        checkInverseOperation("50", "0.02");
        checkInverseOperation("2", "0.5");

        checkInverseOperation("-800", "-0.00125");
        checkInverseOperation("-1000", "-0.001");

        checkInverseOperation("0.5", "2");
        checkInverseOperation("0.8", "1.25");

        checkInverseOperation("-0.025", "-4.e+1");
        checkInverseOperation("-6.25", "-0.16");

    }

    /**
     * Tests for percentage of first operation.
     */
    @Test
    void percentageOfFirstTests() {
        //integers only
        {
            //first is -100000000000000000
            checkPercentageOfFirstOperation("-10000000000000000", "-10000000000000000", "1.e+30");
            checkPercentageOfFirstOperation("-10000000000000000", "-9999999999999999",
                    "9.999999999999999e+29");
            checkPercentageOfFirstOperation("-10000000000000000", "-9999999999999998",
                    "9.999999999999998e+29");
            checkPercentageOfFirstOperation("-10000000000000000", "-10", "1.e+15");
            checkPercentageOfFirstOperation("-10000000000000000", "-1", "1.e+14");

            checkPercentageOfFirstOperation("-10000000000000000", "0", "0");

            checkPercentageOfFirstOperation("-10000000000000000", "1", "-1.e+14");
            checkPercentageOfFirstOperation("-10000000000000000", "10", "-1.e+15");
            checkPercentageOfFirstOperation("-10000000000000000", "9999999999999998",
                    "-9.999999999999998e+29");
            checkPercentageOfFirstOperation("-10000000000000000", "9999999999999999",
                    "-9.999999999999999e+29");
            checkPercentageOfFirstOperation("-10000000000000000", "10000000000000000", "-1.e+30");

            //first is -9999999999999999
            checkPercentageOfFirstOperation("-9999999999999999", "-9999999999999999",
                    "999999999999999800000000000000.01");
            checkPercentageOfFirstOperation("-9999999999999999", "-9999999999999998",
                    "999999999999999700000000000000.02");
            checkPercentageOfFirstOperation("-9999999999999999", "-10", "999999999999999.9");
            checkPercentageOfFirstOperation("-9999999999999999", "-1", "99999999999999.99");

            checkPercentageOfFirstOperation("-9999999999999999", "0", "0");

            checkPercentageOfFirstOperation("-9999999999999999", "1", "-99999999999999.99");
            checkPercentageOfFirstOperation("-9999999999999999", "10", "-999999999999999.9");
            checkPercentageOfFirstOperation("-9999999999999999", "9999999999999998",
                    "-999999999999999700000000000000.02");
            checkPercentageOfFirstOperation("-9999999999999999", "9999999999999999",
                    "-999999999999999800000000000000.01");
            checkPercentageOfFirstOperation("-9999999999999999", "10000000000000000",
                    "-9.999999999999999e+29");

            //first is -9999999999999998
            checkPercentageOfFirstOperation("-9999999999999998", "-9999999999999998",
                    "999999999999999600000000000000.04");
            checkPercentageOfFirstOperation("-9999999999999998", "-10", "999999999999999.8");
            checkPercentageOfFirstOperation("-9999999999999998", "-1", "99999999999999.98");

            checkPercentageOfFirstOperation("-9999999999999998", "0", "0");

            checkPercentageOfFirstOperation("-9999999999999998", "1", "-99999999999999.98");
            checkPercentageOfFirstOperation("-9999999999999998", "10", "-999999999999999.8");
            checkPercentageOfFirstOperation("-9999999999999998", "9999999999999998",
                    "-999999999999999600000000000000.04");
            checkPercentageOfFirstOperation("-9999999999999998", "9999999999999999",
                    "-999999999999999700000000000000.02");
            checkPercentageOfFirstOperation("-9999999999999998", "10000000000000000",
                    "-9.999999999999998e+29");

            //first is -10
            checkPercentageOfFirstOperation("-10", "-10", "1");
            checkPercentageOfFirstOperation("-10", "-1", "0.1");

            checkPercentageOfFirstOperation("-10", "0", "0");

            checkPercentageOfFirstOperation("-10", "1", "-0.1");
            checkPercentageOfFirstOperation("-10", "10", "-1");
            checkPercentageOfFirstOperation("-10", "9999999999999998", "-999999999999999.8");
            checkPercentageOfFirstOperation("-10", "9999999999999999", "-999999999999999.9");
            checkPercentageOfFirstOperation("-10", "10000000000000000", "-1.e+15");

            //first is -1
            checkPercentageOfFirstOperation("-1", "-1", "0.01");

            checkPercentageOfFirstOperation("-1", "0", "0");

            checkPercentageOfFirstOperation("-1", "1", "-0.01");
            checkPercentageOfFirstOperation("-1", "10", "-0.1");
            checkPercentageOfFirstOperation("-1", "9999999999999998", "-99999999999999.98");
            checkPercentageOfFirstOperation("-1", "9999999999999999", "-99999999999999.99");
            checkPercentageOfFirstOperation("-1", "10000000000000000", "-1.e+14");

            //first is 0
            checkPercentageOfFirstOperation("0", "0", "0");

            checkPercentageOfFirstOperation("0", "1", "0");
            checkPercentageOfFirstOperation("0", "10", "0");
            checkPercentageOfFirstOperation("0", "9999999999999998", "0");
            checkPercentageOfFirstOperation("0", "9999999999999999", "0");
            checkPercentageOfFirstOperation("0", "10000000000000000", "0");

            //first is 1
            checkPercentageOfFirstOperation("1", "1", "0.01");
            checkPercentageOfFirstOperation("1", "10", "0.1");
            checkPercentageOfFirstOperation("1", "9999999999999998", "99999999999999.98");
            checkPercentageOfFirstOperation("1", "9999999999999999", "99999999999999.99");
            checkPercentageOfFirstOperation("1", "10000000000000000", "1.e+14");

            //first is 10
            checkPercentageOfFirstOperation("10", "10", "1");
            checkPercentageOfFirstOperation("10", "9999999999999998", "999999999999999.8");
            checkPercentageOfFirstOperation("10", "9999999999999999", "999999999999999.9");
            checkPercentageOfFirstOperation("10", "10000000000000000", "1.e+15");

            //first is 9999999999999998
            checkPercentageOfFirstOperation("9999999999999998", "9999999999999998",
                    "999999999999999600000000000000.04");
            checkPercentageOfFirstOperation("9999999999999998", "9999999999999999",
                    "999999999999999700000000000000.02");
            checkPercentageOfFirstOperation("9999999999999998", "10000000000000000",
                    "9.999999999999998e+29");

            //first is 9999999999999999
            checkPercentageOfFirstOperation("9999999999999999", "9999999999999999",
                    "999999999999999800000000000000.01");
            checkPercentageOfFirstOperation("9999999999999999", "10000000000000000", "9.999999999999999e+29");

            //first is 10000000000000000
            checkPercentageOfFirstOperation("10000000000000000", "10000000000000000", "1.e+30");
        }

        //integer and decimal
        {
            //first is -10000000000000000
            checkPercentageOfFirstOperation("-10000000000000000", "-0.9999999999999999", "99999999999999.99");
            checkPercentageOfFirstOperation("-10000000000000000", "-0.9", "9.e+13");
            checkPercentageOfFirstOperation("-10000000000000000", "-0.1", "1.e+13");

            checkPercentageOfFirstOperation("-10000000000000000", "0.1", "-1.e+13");
            checkPercentageOfFirstOperation("-10000000000000000", "0.9", "-9.e+13");
            checkPercentageOfFirstOperation("-10000000000000000", "0.9999999999999999", "-99999999999999.99");

            //first is -9999999999999999
            checkPercentageOfFirstOperation("-9999999999999999", "-0.9999999999999999",
                    "99999999999999.980000000000000001");
            checkPercentageOfFirstOperation("-9999999999999999", "-0.9", "89999999999999.991");
            checkPercentageOfFirstOperation("-9999999999999999", "-0.1", "9999999999999.999");

            checkPercentageOfFirstOperation("-9999999999999999", "0.1", "-9999999999999.999");
            checkPercentageOfFirstOperation("-9999999999999999", "0.9", "-89999999999999.991");
            checkPercentageOfFirstOperation("-9999999999999999", "0.9999999999999999",
                    "-99999999999999.980000000000000001");

            //first is -9999999999999998
            checkPercentageOfFirstOperation("-9999999999999998", "-0.9999999999999999",
                    "99999999999999.970000000000000002");
            checkPercentageOfFirstOperation("-9999999999999998", "-0.9", "89999999999999.982");
            checkPercentageOfFirstOperation("-9999999999999998", "-0.1", "9999999999999.998");

            checkPercentageOfFirstOperation("-9999999999999998", "0.1", "-9999999999999.998");
            checkPercentageOfFirstOperation("-9999999999999998", "0.9", "-89999999999999.982");
            checkPercentageOfFirstOperation("-9999999999999998", "0.9999999999999999",
                    "-99999999999999.970000000000000002");

            //first is -10
            checkPercentageOfFirstOperation("-10", "-0.9999999999999999", "0.09999999999999999");
            checkPercentageOfFirstOperation("-10", "-0.9", "0.09");
            checkPercentageOfFirstOperation("-10", "-0.1", "0.01");

            checkPercentageOfFirstOperation("-10", "0.1", "-0.01");
            checkPercentageOfFirstOperation("-10", "0.9", "-0.09");
            checkPercentageOfFirstOperation("-10", "0.9999999999999999", "-0.09999999999999999");

            //first is -1
            checkPercentageOfFirstOperation("-1", "-0.9999999999999999", "0.009999999999999999");
            checkPercentageOfFirstOperation("-1", "-0.9", "0.009");
            checkPercentageOfFirstOperation("-1", "-0.1", "0.001");

            checkPercentageOfFirstOperation("-1", "0.1", "-0.001");
            checkPercentageOfFirstOperation("-1", "0.9", "-0.009");
            checkPercentageOfFirstOperation("-1", "0.9999999999999999", "-0.009999999999999999");

            //first is 0
            checkPercentageOfFirstOperation("0", "-0.9999999999999999", "0");
            checkPercentageOfFirstOperation("0", "-0.9", "0");
            checkPercentageOfFirstOperation("0", "-0.1", "0");

            checkPercentageOfFirstOperation("0", "0.1", "0");
            checkPercentageOfFirstOperation("0", "0.9", "0");
            checkPercentageOfFirstOperation("0", "0.9999999999999999", "0");

            //first is 1
            checkPercentageOfFirstOperation("1", "-0.9999999999999999", "-0.009999999999999999");
            checkPercentageOfFirstOperation("1", "-0.9", "-0.009");
            checkPercentageOfFirstOperation("1", "-0.1", "-0.001");

            checkPercentageOfFirstOperation("1", "0.1", "0.001");
            checkPercentageOfFirstOperation("1", "0.9", "0.009");
            checkPercentageOfFirstOperation("1", "0.9999999999999999", "0.009999999999999999");

            //first is 10
            checkPercentageOfFirstOperation("10", "-0.9999999999999999", "-0.09999999999999999");
            checkPercentageOfFirstOperation("10", "-0.9", "-0.09");
            checkPercentageOfFirstOperation("10", "-0.1", "-0.01");

            checkPercentageOfFirstOperation("10", "0.1", "0.01");
            checkPercentageOfFirstOperation("10", "0.9", "0.09");
            checkPercentageOfFirstOperation("10", "0.9999999999999999", "0.09999999999999999");

            //first is 9999999999999998
            checkPercentageOfFirstOperation("9999999999999998", "-0.9999999999999999",
                    "-99999999999999.970000000000000002");
            checkPercentageOfFirstOperation("9999999999999998", "-0.9", "-89999999999999.982");
            checkPercentageOfFirstOperation("9999999999999998", "-0.1", "-9999999999999.998");

            checkPercentageOfFirstOperation("9999999999999998", "0.1", "9999999999999.998");
            checkPercentageOfFirstOperation("9999999999999998", "0.9", "89999999999999.982");
            checkPercentageOfFirstOperation("9999999999999998", "0.9999999999999999",
                    "99999999999999.970000000000000002");

            //first is 9999999999999999
            checkPercentageOfFirstOperation("9999999999999999", "-0.9999999999999999",
                    "-99999999999999.980000000000000001");
            checkPercentageOfFirstOperation("9999999999999999", "-0.9", "-89999999999999.991");
            checkPercentageOfFirstOperation("9999999999999999", "-0.1", "-9999999999999.999");

            checkPercentageOfFirstOperation("9999999999999999", "0.1", "9999999999999.999");
            checkPercentageOfFirstOperation("9999999999999999", "0.9", "89999999999999.991");
            checkPercentageOfFirstOperation("9999999999999999", "0.9999999999999999",
                    "99999999999999.980000000000000001");

            //first is 10000000000000000
            checkPercentageOfFirstOperation("10000000000000000", "-0.9999999999999999", "-99999999999999.99");
            checkPercentageOfFirstOperation("10000000000000000", "-0.9", "-9.e+13");
            checkPercentageOfFirstOperation("10000000000000000", "-0.1", "-1.e+13");

            checkPercentageOfFirstOperation("10000000000000000", "0.1", "1.e+13");
            checkPercentageOfFirstOperation("10000000000000000", "0.9", "9.e+13");
            checkPercentageOfFirstOperation("10000000000000000", "0.9999999999999999", "99999999999999.99");
        }

        //decimals only
        {
            //first is -0.9999999999999999
            checkPercentageOfFirstOperation("-0.9999999999999999", "-0.9999999999999999",
                    "0.0099999999999999980000000000000001");
            checkPercentageOfFirstOperation("-0.9999999999999999", "-0.9", "0.0089999999999999991");
            checkPercentageOfFirstOperation("-0.9999999999999999", "-0.1", "0.0009999999999999999");

            checkPercentageOfFirstOperation("-0.9999999999999999", "0.1", "-0.0009999999999999999");
            checkPercentageOfFirstOperation("-0.9999999999999999", "0.9", "-0.0089999999999999991");
            checkPercentageOfFirstOperation("-0.9999999999999999", "0.9999999999999999",
                    "-0.0099999999999999980000000000000001");

            //first is -0.9
            checkPercentageOfFirstOperation("-0.9", "-0.9", "0.0081");
            checkPercentageOfFirstOperation("-0.9", "-0.1", "0.0009");

            checkPercentageOfFirstOperation("-0.9", "0.1", "-0.0009");
            checkPercentageOfFirstOperation("-0.9", "0.9", "-0.0081");
            checkPercentageOfFirstOperation("-0.9", "0.9999999999999999", "-0.0089999999999999991");

            //first is -0.1
            checkPercentageOfFirstOperation("-0.1", "-0.1", "0.0001");

            checkPercentageOfFirstOperation("-0.1", "0.1", "-0.0001");
            checkPercentageOfFirstOperation("-0.1", "0.9", "-0.0009");
            checkPercentageOfFirstOperation("-0.1", "0.9999999999999999", "-0.0009999999999999999");

            //first is 0.1
            checkPercentageOfFirstOperation("0.1", "0.1", "0.0001");
            checkPercentageOfFirstOperation("0.1", "0.9", "0.0009");
            checkPercentageOfFirstOperation("0.1", "0.9999999999999999", "0.0009999999999999999");

            //first is 0.9
            checkPercentageOfFirstOperation("0.9", "0.9", "0.0081");
            checkPercentageOfFirstOperation("0.9", "0.9999999999999999", "0.0089999999999999991");

            //first is 0.9999999999999999
            checkPercentageOfFirstOperation("0.9999999999999999", "0.9999999999999999",
                    "0.0099999999999999980000000000000001");
        }

        //engineer numbers
        //with engineer numbers
        {
            //first is -1.e+9999
            checkPercentageOfFirstOperation("-1.e+9999", "-1.e-9999", "0.01");
            checkPercentageOfFirstOperation("-1.e+9999", "-1.e-9998", "0.1");
            checkPercentageOfFirstOperation("-1.e+9999", "-1.e-17", "1.e+9980");
            checkPercentageOfFirstOperation("-1.e+9999", "-1.e-16", "1.e+9981");

            checkPercentageOfFirstOperation("-1.e+9999", "1.e-16", "-1.e+9981");
            checkPercentageOfFirstOperation("-1.e+9999", "1.e-17", "-1.e+9980");
            checkPercentageOfFirstOperation("-1.e+9999", "1.e-9998", "-0.1");
            checkPercentageOfFirstOperation("-1.e+9999", "1.e-9999", "-0.01");

            //first is -1.e+9998
            checkPercentageOfFirstOperation("-1.e+9998", "-1.e-9998", "0.01");
            checkPercentageOfFirstOperation("-1.e+9998", "-1.e-17", "1.e+9979");
            checkPercentageOfFirstOperation("-1.e+9998", "-1.e-16", "1.e+9980");

            checkPercentageOfFirstOperation("-1.e+9998", "1.e-16", "-1.e+9980");
            checkPercentageOfFirstOperation("-1.e+9998", "1.e-17", "-1.e+9979");
            checkPercentageOfFirstOperation("-1.e+9998", "1.e-9998", "-0.01");

            //first is 1.e+9998
            checkPercentageOfFirstOperation("1.e+9998", "-1.e-9998", "-0.01");
            checkPercentageOfFirstOperation("1.e+9998", "-1.e-17", "-1.e+9979");
            checkPercentageOfFirstOperation("1.e+9998", "-1.e-16", "-1.e+9980");

            checkPercentageOfFirstOperation("1.e+9998", "1.e-16", "1.e+9980");
            checkPercentageOfFirstOperation("1.e+9998", "1.e-17", "1.e+9979");
            checkPercentageOfFirstOperation("1.e+9998", "1.e-9998", "0.01");

            //first is 1.e+9999
            checkPercentageOfFirstOperation("1.e+9999", "-1.e-9999", "-0.01");
            checkPercentageOfFirstOperation("1.e+9999", "-1.e-9998", "-0.1");
            checkPercentageOfFirstOperation("1.e+9999", "-1.e-17", "-1.e+9980");
            checkPercentageOfFirstOperation("1.e+9999", "-1.e-16", "-1.e+9981");

            checkPercentageOfFirstOperation("1.e+9999", "1.e-16", "1.e+9981");
            checkPercentageOfFirstOperation("1.e+9999", "1.e-17", "1.e+9980");
            checkPercentageOfFirstOperation("1.e+9999", "1.e-9998", "0.1");
            checkPercentageOfFirstOperation("1.e+9999", "1.e-9999", "0.01");


            //first is -1.e+17
            checkPercentageOfFirstOperation("-1.e+17", "-1.e+17", "1.e+32");
            checkPercentageOfFirstOperation("-1.e+17", "-1.e+16", "1.e+31");

            checkPercentageOfFirstOperation("-1.e+17", "1.e+16", "-1.e+31");
            checkPercentageOfFirstOperation("-1.e+17", "1.e+17", "-1.e+32");


            checkPercentageOfFirstOperation("-1.e+17", "-1.e-9999", "1.e-9984");
            checkPercentageOfFirstOperation("-1.e+17", "-1.e-9998", "1.e-9983");
            checkPercentageOfFirstOperation("-1.e+17", "-1.e-17", "0.01");
            checkPercentageOfFirstOperation("-1.e+17", "-1.e-16", "0.1");

            checkPercentageOfFirstOperation("-1.e+17", "1.e-16", "-0.1");
            checkPercentageOfFirstOperation("-1.e+17", "1.e-17", "-0.01");
            checkPercentageOfFirstOperation("-1.e+17", "1.e-9998", "-1.e-9983");
            checkPercentageOfFirstOperation("-1.e+17", "1.e-9999", "-1.e-9984");

            //first is -1.e+16
            checkPercentageOfFirstOperation("-1.e+16", "-1.e+16", "1.e+30");

            checkPercentageOfFirstOperation("-1.e+16", "1.e+16", "-1.e+30");


            checkPercentageOfFirstOperation("-1.e+16", "-1.e-9999", "1.e-9985");
            checkPercentageOfFirstOperation("-1.e+16", "-1.e-9998", "1.e-9984");
            checkPercentageOfFirstOperation("-1.e+16", "-1.e-17", "0.001");
            checkPercentageOfFirstOperation("-1.e+16", "-1.e-16", "0.01");

            checkPercentageOfFirstOperation("-1.e+16", "1.e-16", "-0.01");
            checkPercentageOfFirstOperation("-1.e+16", "1.e-17", "-0.001");
            checkPercentageOfFirstOperation("-1.e+16", "1.e-9998", "-1.e-9984");
            checkPercentageOfFirstOperation("-1.e+16", "1.e-9999", "-1.e-9985");

            //first is 1.e+16
            checkPercentageOfFirstOperation("1.e+16", "-1.e+16", "-1.e+30");

            checkPercentageOfFirstOperation("1.e+16", "1.e+16", "1.e+30");


            checkPercentageOfFirstOperation("1.e+16", "-1.e-9999", "-1.e-9985");
            checkPercentageOfFirstOperation("1.e+16", "-1.e-9998", "-1.e-9984");
            checkPercentageOfFirstOperation("1.e+16", "-1.e-17", "-0.001");
            checkPercentageOfFirstOperation("1.e+16", "-1.e-16", "-0.01");

            checkPercentageOfFirstOperation("1.e+16", "1.e-16", "0.01");
            checkPercentageOfFirstOperation("1.e+16", "1.e-17", "0.001");
            checkPercentageOfFirstOperation("1.e+16", "1.e-9998", "1.e-9984");
            checkPercentageOfFirstOperation("1.e+16", "1.e-9999", "1.e-9985");

            //first is 1.e+17
            checkPercentageOfFirstOperation("1.e+17", "-1.e+17", "-1.e+32");
            checkPercentageOfFirstOperation("1.e+17", "-1.e+16", "-1.e+31");

            checkPercentageOfFirstOperation("1.e+17", "1.e+16", "1.e+31");
            checkPercentageOfFirstOperation("1.e+17", "1.e+17", "1.e+32");


            checkPercentageOfFirstOperation("1.e+17", "-1.e-9999", "-1.e-9984");
            checkPercentageOfFirstOperation("1.e+17", "-1.e-9998", "-1.e-9983");
            checkPercentageOfFirstOperation("1.e+17", "-1.e-17", "-0.01");
            checkPercentageOfFirstOperation("1.e+17", "-1.e-16", "-0.1");

            checkPercentageOfFirstOperation("1.e+17", "1.e-16", "0.1");
            checkPercentageOfFirstOperation("1.e+17", "1.e-17", "0.01");
            checkPercentageOfFirstOperation("1.e+17", "1.e-9998", "1.e-9983");
            checkPercentageOfFirstOperation("1.e+17", "1.e-9999", "1.e-9984");
        }

        //with integers
        {
            //first is -1.e+9999
            checkPercentageOfFirstOperation("-1.e+9999", "-10", "1.e+9998");
            checkPercentageOfFirstOperation("-1.e+9999", "-1", "1.e+9997");

            checkPercentageOfFirstOperation("-1.e+9999", "0", "0");

            checkPercentageOfFirstOperation("-1.e+9999", "1", "-1.e+9997");
            checkPercentageOfFirstOperation("-1.e+9999", "10", "-1.e+9998");

            //first is -1.e+9998
            checkPercentageOfFirstOperation("-1.e+9998", "-10", "1.e+9997");
            checkPercentageOfFirstOperation("-1.e+9998", "-1", "1.e+9996");

            checkPercentageOfFirstOperation("-1.e+9998", "0", "0");

            checkPercentageOfFirstOperation("-1.e+9998", "1", "-1.e+9996");
            checkPercentageOfFirstOperation("-1.e+9998", "10", "-1.e+9997");

            //first is -1.e+17
            checkPercentageOfFirstOperation("-1.e+17", "-10000000000000000", "1.e+31");
            checkPercentageOfFirstOperation("-1.e+17", "-9999999999999999", "9.999999999999999e+30");
            checkPercentageOfFirstOperation("-1.e+17", "-9999999999999998",
                    "9.999999999999998e+30");
            checkPercentageOfFirstOperation("-1.e+17", "-10", "1.e+16");
            checkPercentageOfFirstOperation("-1.e+17", "-1", "1.e+15");

            checkPercentageOfFirstOperation("-1.e+17", "0", "0");

            checkPercentageOfFirstOperation("-1.e+17", "1", "-1.e+15");
            checkPercentageOfFirstOperation("-1.e+17", "10", "-1.e+16");
            checkPercentageOfFirstOperation("-1.e+17", "9999999999999998",
                    "-9.999999999999998e+30");
            checkPercentageOfFirstOperation("-1.e+17", "9999999999999999", "-9.999999999999999e+30");
            checkPercentageOfFirstOperation("-1.e+17", "10000000000000000", "-1.e+31");

            //first is -1.e+16
            checkPercentageOfFirstOperation("-1.e+16", "-10000000000000000", "1.e+30");
            checkPercentageOfFirstOperation("-1.e+16", "-9999999999999999", "9.999999999999999e+29");
            checkPercentageOfFirstOperation("-1.e+16", "-9999999999999998",
                    "9.999999999999998e+29");
            checkPercentageOfFirstOperation("-1.e+16", "-10", "1.e+15");
            checkPercentageOfFirstOperation("-1.e+16", "-1", "1.e+14");

            checkPercentageOfFirstOperation("-1.e+16", "0", "0");

            checkPercentageOfFirstOperation("-1.e+16", "1", "-1.e+14");
            checkPercentageOfFirstOperation("-1.e+16", "10", "-1.e+15");
            checkPercentageOfFirstOperation("-1.e+16", "9999999999999998",
                    "-9.999999999999998e+29");
            checkPercentageOfFirstOperation("-1.e+16", "9999999999999999", "-9.999999999999999e+29");
            checkPercentageOfFirstOperation("-1.e+16", "10000000000000000", "-1.e+30");

            //first is 1.e+16
            checkPercentageOfFirstOperation("1.e+16", "-10000000000000000", "-1.e+30");
            checkPercentageOfFirstOperation("1.e+16", "-9999999999999999", "-9.999999999999999e+29");
            checkPercentageOfFirstOperation("1.e+16", "-9999999999999998", "-9.999999999999998e+29");
            checkPercentageOfFirstOperation("1.e+16", "-10", "-1.e+15");
            checkPercentageOfFirstOperation("1.e+16", "-1", "-1.e+14");

            checkPercentageOfFirstOperation("1.e+16", "0", "0");

            checkPercentageOfFirstOperation("1.e+16", "1", "1.e+14");
            checkPercentageOfFirstOperation("1.e+16", "10", "1.e+15");
            checkPercentageOfFirstOperation("1.e+16", "9999999999999998", "9.999999999999998e+29");
            checkPercentageOfFirstOperation("1.e+16", "9999999999999999", "9.999999999999999e+29");
            checkPercentageOfFirstOperation("1.e+16", "10000000000000000", "1.e+30");

            //first is 1.e+17
            checkPercentageOfFirstOperation("1.e+17", "-10000000000000000", "-1.e+31");
            checkPercentageOfFirstOperation("1.e+17", "-9999999999999999", "-9.999999999999999e+30");
            checkPercentageOfFirstOperation("1.e+17", "-9999999999999998", "-9.999999999999998e+30");
            checkPercentageOfFirstOperation("1.e+17", "-10", "-1.e+16");
            checkPercentageOfFirstOperation("1.e+17", "-1", "-1.e+15");

            checkPercentageOfFirstOperation("1.e+17", "0", "0");

            checkPercentageOfFirstOperation("1.e+17", "1", "1.e+15");
            checkPercentageOfFirstOperation("1.e+17", "10", "1.e+16");
            checkPercentageOfFirstOperation("1.e+17", "9999999999999998", "9.999999999999998e+30");
            checkPercentageOfFirstOperation("1.e+17", "9999999999999999", "9.999999999999999e+30");
            checkPercentageOfFirstOperation("1.e+17", "10000000000000000", "1.e+31");

            //first is 1.e+9998
            checkPercentageOfFirstOperation("1.e+9998", "-10", "-1.e+9997");
            checkPercentageOfFirstOperation("1.e+9998", "-1", "-1.e+9996");

            checkPercentageOfFirstOperation("1.e+9998", "0", "0");

            checkPercentageOfFirstOperation("1.e+9998", "1", "1.e+9996");
            checkPercentageOfFirstOperation("1.e+9998", "10", "1.e+9997");

            //first is 1.e+9999
            checkPercentageOfFirstOperation("1.e+9999", "-10", "-1.e+9998");
            checkPercentageOfFirstOperation("1.e+9999", "-1", "-1.e+9997");

            checkPercentageOfFirstOperation("1.e+9999", "0", "0");

            checkPercentageOfFirstOperation("1.e+9999", "1", "1.e+9997");
            checkPercentageOfFirstOperation("1.e+9999", "10", "1.e+9998");


            //first is -1.e-9999
            checkPercentageOfFirstOperation("-1.e-9999", "-10000000000000000", "1.e-9985");
            checkPercentageOfFirstOperation("-1.e-9999", "-9999999999999999", "1.e-9985");
            checkPercentageOfFirstOperation("-1.e-9999", "-9999999999999998", "1.e-9985");

            checkPercentageOfFirstOperation("-1.e-9999", "0", "0");

            checkPercentageOfFirstOperation("-1.e-9999", "9999999999999998", "-1.e-9985");
            checkPercentageOfFirstOperation("-1.e-9999", "9999999999999999", "-1.e-9985");
            checkPercentageOfFirstOperation("-1.e-9999", "10000000000000000", "-1.e-9985");

            //first is -1.e-9998
            checkPercentageOfFirstOperation("-1.e-9998", "-10000000000000000", "1.e-9984");
            checkPercentageOfFirstOperation("-1.e-9998", "-9999999999999999", "9.999999999999999e-9985");
            checkPercentageOfFirstOperation("-1.e-9998", "-9999999999999998",
                    "9.999999999999998e-9985");
            checkPercentageOfFirstOperation("-1.e-9998", "-10", "1.e-9999");

            checkPercentageOfFirstOperation("-1.e-9998", "0", "0");

            checkPercentageOfFirstOperation("-1.e-9998", "10", "-1.e-9999");
            checkPercentageOfFirstOperation("-1.e-9998", "9999999999999998",
                    "-9.999999999999998e-9985");
            checkPercentageOfFirstOperation("-1.e-9998", "9999999999999999", "-9.999999999999999e-9985");
            checkPercentageOfFirstOperation("-1.e-9998", "10000000000000000", "-1.e-9984");

            //first is -1.e-17
            checkPercentageOfFirstOperation("-1.e-17", "-10000000000000000", "0.001");
            checkPercentageOfFirstOperation("-1.e-17", "-9999999999999999", "0.0009999999999999999");
            checkPercentageOfFirstOperation("-1.e-17", "-9999999999999998",
                    "0.0009999999999999998");
            checkPercentageOfFirstOperation("-1.e-17", "-10", "1.e-18");
            checkPercentageOfFirstOperation("-1.e-17", "-1", "1.e-19");

            checkPercentageOfFirstOperation("-1.e-17", "0", "0");

            checkPercentageOfFirstOperation("-1.e-17", "1", "-1.e-19");
            checkPercentageOfFirstOperation("-1.e-17", "10", "-1.e-18");
            checkPercentageOfFirstOperation("-1.e-17", "9999999999999998",
                    "-0.0009999999999999998");
            checkPercentageOfFirstOperation("-1.e-17", "9999999999999999", "-0.0009999999999999999");
            checkPercentageOfFirstOperation("-1.e-17", "10000000000000000", "-0.001");

            //first is -1.e-16
            checkPercentageOfFirstOperation("-1.e-16", "-10000000000000000", "0.01");
            checkPercentageOfFirstOperation("-1.e-16", "-9999999999999999", "0.009999999999999999");
            checkPercentageOfFirstOperation("-1.e-16", "-9999999999999998",
                    "0.009999999999999998");
            checkPercentageOfFirstOperation("-1.e-16", "-10", "1.e-17");
            checkPercentageOfFirstOperation("-1.e-16", "-1", "1.e-18");

            checkPercentageOfFirstOperation("-1.e-16", "0", "0");

            checkPercentageOfFirstOperation("-1.e-16", "1", "-1.e-18");
            checkPercentageOfFirstOperation("-1.e-16", "10", "-1.e-17");
            checkPercentageOfFirstOperation("-1.e-16", "9999999999999998",
                    "-0.009999999999999998");
            checkPercentageOfFirstOperation("-1.e-16", "9999999999999999", "-0.009999999999999999");
            checkPercentageOfFirstOperation("-1.e-16", "10000000000000000", "-0.01");

            //first is 1.e-16
            checkPercentageOfFirstOperation("1.e-16", "-10000000000000000", "-0.01");
            checkPercentageOfFirstOperation("1.e-16", "-9999999999999999", "-0.009999999999999999");
            checkPercentageOfFirstOperation("1.e-16", "-9999999999999998", "-0.009999999999999998");
            checkPercentageOfFirstOperation("1.e-16", "-10", "-1.e-17");
            checkPercentageOfFirstOperation("1.e-16", "-1", "-1.e-18");

            checkPercentageOfFirstOperation("1.e-16", "0", "0");

            checkPercentageOfFirstOperation("1.e-16", "1", "1.e-18");
            checkPercentageOfFirstOperation("1.e-16", "10", "1.e-17");
            checkPercentageOfFirstOperation("1.e-16", "9999999999999998", "0.009999999999999998");
            checkPercentageOfFirstOperation("1.e-16", "9999999999999999", "0.009999999999999999");
            checkPercentageOfFirstOperation("1.e-16", "10000000000000000", "0.01");

            //first is 1.e-17
            checkPercentageOfFirstOperation("1.e-17", "-10000000000000000", "-0.001");
            checkPercentageOfFirstOperation("1.e-17", "-9999999999999999", "-0.0009999999999999999");
            checkPercentageOfFirstOperation("1.e-17", "-9999999999999998", "-0.0009999999999999998");
            checkPercentageOfFirstOperation("1.e-17", "-10", "-1.e-18");
            checkPercentageOfFirstOperation("1.e-17", "-1", "-1.e-19");

            checkPercentageOfFirstOperation("1.e-17", "0", "0");

            checkPercentageOfFirstOperation("1.e-17", "1", "1.e-19");
            checkPercentageOfFirstOperation("1.e-17", "10", "1.e-18");
            checkPercentageOfFirstOperation("1.e-17", "9999999999999998", "0.0009999999999999998");
            checkPercentageOfFirstOperation("1.e-17", "9999999999999999", "0.0009999999999999999");
            checkPercentageOfFirstOperation("1.e-17", "10000000000000000", "0.001");

            //first is 1.e-9998
            checkPercentageOfFirstOperation("1.e-9998", "-10000000000000000", "-1.e-9984");
            checkPercentageOfFirstOperation("1.e-9998", "-9999999999999999", "-9.999999999999999e-9985");
            checkPercentageOfFirstOperation("1.e-9998", "-9999999999999998",
                    "-9.999999999999998e-9985");
            checkPercentageOfFirstOperation("1.e-9998", "-10", "-1.e-9999");

            checkPercentageOfFirstOperation("1.e-9998", "0", "0");

            checkPercentageOfFirstOperation("1.e-9998", "10", "1.e-9999");
            checkPercentageOfFirstOperation("1.e-9998", "9999999999999998",
                    "9.999999999999998e-9985");
            checkPercentageOfFirstOperation("1.e-9998", "9999999999999999", "9.999999999999999e-9985");
            checkPercentageOfFirstOperation("1.e-9998", "10000000000000000", "1.e-9984");

            //first is 1.e-9999
            checkPercentageOfFirstOperation("1.e-9999", "-10000000000000000", "-1.e-9985");
            checkPercentageOfFirstOperation("1.e-9999", "-9999999999999999", "-1.e-9985");
            checkPercentageOfFirstOperation("1.e-9999", "-9999999999999998", "-1.e-9985");

            checkPercentageOfFirstOperation("1.e-9999", "0", "0");

            checkPercentageOfFirstOperation("1.e-9999", "9999999999999998", "1.e-9985");
            checkPercentageOfFirstOperation("1.e-9999", "9999999999999999", "1.e-9985");
            checkPercentageOfFirstOperation("1.e-9999", "10000000000000000", "1.e-9985");
        }

        //with decimals
        {
            //first is -1.e+9999
            checkPercentageOfFirstOperation("-1.e+9999", "-0.9999999999999999", "9.999999999999999e+9996");
            checkPercentageOfFirstOperation("-1.e+9999", "-0.9", "9.e+9996");
            checkPercentageOfFirstOperation("-1.e+9999", "-0.1", "1.e+9996");

            checkPercentageOfFirstOperation("-1.e+9999", "0.1", "-1.e+9996");
            checkPercentageOfFirstOperation("-1.e+9999", "0.9", "-9.e+9996");
            checkPercentageOfFirstOperation("-1.e+9999", "0.9999999999999999", "-9.999999999999999e+9996");

            //first is -1.e+9998
            checkPercentageOfFirstOperation("-1.e+9998", "-0.9999999999999999", "9.999999999999999e+9995");
            checkPercentageOfFirstOperation("-1.e+9998", "-0.9", "9.e+9995");
            checkPercentageOfFirstOperation("-1.e+9998", "-0.1", "1.e+9995");

            checkPercentageOfFirstOperation("-1.e+9998", "0.1", "-1.e+9995");
            checkPercentageOfFirstOperation("-1.e+9998", "0.9", "-9.e+9995");
            checkPercentageOfFirstOperation("-1.e+9998", "0.9999999999999999", "-9.999999999999999e+9995");

            //first is -1.e+17
            checkPercentageOfFirstOperation("-1.e+17", "-0.9999999999999999", "999999999999999.9");
            checkPercentageOfFirstOperation("-1.e+17", "-0.9", "9.e+14");
            checkPercentageOfFirstOperation("-1.e+17", "-0.1", "1.e+14");

            checkPercentageOfFirstOperation("-1.e+17", "0.1", "-1.e+14");
            checkPercentageOfFirstOperation("-1.e+17", "0.9", "-9.e+14");
            checkPercentageOfFirstOperation("-1.e+17", "0.9999999999999999", "-999999999999999.9");

            //first is -1.e+16
            checkPercentageOfFirstOperation("-1.e+16", "-0.9999999999999999", "99999999999999.99");
            checkPercentageOfFirstOperation("-1.e+16", "-0.9", "9.e+13");
            checkPercentageOfFirstOperation("-1.e+16", "-0.1", "1.e+13");

            checkPercentageOfFirstOperation("-1.e+16", "0.1", "-1.e+13");
            checkPercentageOfFirstOperation("-1.e+16", "0.9", "-9.e+13");
            checkPercentageOfFirstOperation("-1.e+16", "0.9999999999999999", "-99999999999999.99");

            //first is 1.e+16
            checkPercentageOfFirstOperation("1.e+16", "-0.9999999999999999", "-99999999999999.99");
            checkPercentageOfFirstOperation("1.e+16", "-0.9", "-9.e+13");
            checkPercentageOfFirstOperation("1.e+16", "-0.1", "-1.e+13");

            checkPercentageOfFirstOperation("1.e+16", "0.1", "1.e+13");
            checkPercentageOfFirstOperation("1.e+16", "0.9", "9.e+13");
            checkPercentageOfFirstOperation("1.e+16", "0.9999999999999999", "99999999999999.99");

            //first is 1.e+17
            checkPercentageOfFirstOperation("1.e+17", "-0.9999999999999999", "-999999999999999.9");
            checkPercentageOfFirstOperation("1.e+17", "-0.9", "-9.e+14");
            checkPercentageOfFirstOperation("1.e+17", "-0.1", "-1.e+14");

            checkPercentageOfFirstOperation("1.e+17", "0.1", "1.e+14");
            checkPercentageOfFirstOperation("1.e+17", "0.9", "9.e+14");
            checkPercentageOfFirstOperation("1.e+17", "0.9999999999999999", "999999999999999.9");

            //first is 1.e+9998
            checkPercentageOfFirstOperation("1.e+9998", "-0.9999999999999999", "-9.999999999999999e+9995");
            checkPercentageOfFirstOperation("1.e+9998", "-0.9", "-9.e+9995");
            checkPercentageOfFirstOperation("1.e+9998", "-0.1", "-1.e+9995");

            checkPercentageOfFirstOperation("1.e+9998", "0.1", "1.e+9995");
            checkPercentageOfFirstOperation("1.e+9998", "0.9", "9.e+9995");
            checkPercentageOfFirstOperation("1.e+9998", "0.9999999999999999", "9.999999999999999e+9995");

            //first is 1.e+9999
            checkPercentageOfFirstOperation("1.e+9999", "-0.9999999999999999", "-9.999999999999999e+9996");
            checkPercentageOfFirstOperation("1.e+9999", "-0.9", "-9.e+9996");
            checkPercentageOfFirstOperation("1.e+9999", "-0.1", "-1.e+9996");

            checkPercentageOfFirstOperation("1.e+9999", "0.1", "1.e+9996");
            checkPercentageOfFirstOperation("1.e+9999", "0.9", "9.e+9996");
            checkPercentageOfFirstOperation("1.e+9999", "0.9999999999999999", "9.999999999999999e+9996");

            //first is -1.e-17
            checkPercentageOfFirstOperation("-1.e-17", "-0.9999999999999999", "9.999999999999999e-20");
            checkPercentageOfFirstOperation("-1.e-17", "-0.9", "9.e-20");
            checkPercentageOfFirstOperation("-1.e-17", "-0.1", "1.e-20");

            checkPercentageOfFirstOperation("-1.e-17", "0.1", "-1.e-20");
            checkPercentageOfFirstOperation("-1.e-17", "0.9", "-9.e-20");
            checkPercentageOfFirstOperation("-1.e-17", "0.9999999999999999", "-9.999999999999999e-20");

            //first is -1.e-16
            checkPercentageOfFirstOperation("-1.e-16", "-0.9999999999999999", "9.999999999999999e-19");
            checkPercentageOfFirstOperation("-1.e-16", "-0.9", "9.e-19");
            checkPercentageOfFirstOperation("-1.e-16", "-0.1", "1.e-19");

            checkPercentageOfFirstOperation("-1.e-16", "0.1", "-1.e-19");
            checkPercentageOfFirstOperation("-1.e-16", "0.9", "-9.e-19");
            checkPercentageOfFirstOperation("-1.e-16", "0.9999999999999999", "-9.999999999999999e-19");

            //first is 1.e-16
            checkPercentageOfFirstOperation("1.e-16", "-0.9999999999999999", "-9.999999999999999e-19");
            checkPercentageOfFirstOperation("1.e-16", "-0.9", "-9.e-19");
            checkPercentageOfFirstOperation("1.e-16", "-0.1", "-1.e-19");

            checkPercentageOfFirstOperation("1.e-16", "0.1", "1.e-19");
            checkPercentageOfFirstOperation("1.e-16", "0.9", "9.e-19");
            checkPercentageOfFirstOperation("1.e-16", "0.9999999999999999", "9.999999999999999e-19");

            //first is 1.e-17
            checkPercentageOfFirstOperation("1.e-17", "-0.9999999999999999", "-9.999999999999999e-20");
            checkPercentageOfFirstOperation("1.e-17", "-0.9", "-9.e-20");
            checkPercentageOfFirstOperation("1.e-17", "-0.1", "-1.e-20");

            checkPercentageOfFirstOperation("1.e-17", "0.1", "1.e-20");
            checkPercentageOfFirstOperation("1.e-17", "0.9", "9.e-20");
            checkPercentageOfFirstOperation("1.e-17", "0.9999999999999999", "9.999999999999999e-20");
        }

        //several random values
        {
            checkPercentageOfFirstOperation("14", "51", "7.14");
            checkPercentageOfFirstOperation("6523", "123", "8023.29");

            checkPercentageOfFirstOperation("123", "-31", "-38.13");
            checkPercentageOfFirstOperation("874", "-41", "-358.34");

            checkPercentageOfFirstOperation("-31", "-1321", "409.51");
            checkPercentageOfFirstOperation("-132", "-52", "68.64");

            checkPercentageOfFirstOperation("51354", "132.12", "67848.9048");
            checkPercentageOfFirstOperation("54", "21.4", "11.556");

            checkPercentageOfFirstOperation("221", "-123.512", "-272.96152");
            checkPercentageOfFirstOperation("54", "-2135.13", "-1152.9702");

            checkPercentageOfFirstOperation("-12", "1.2", "-0.144");
            checkPercentageOfFirstOperation("-87", "23.61", "-20.5407");

            checkPercentageOfFirstOperation("-65", "-10.11", "6.5715");
            checkPercentageOfFirstOperation("-324", "-12.31", "39.8844");

            checkPercentageOfFirstOperation("21.12", "7.6", "1.60512");
            checkPercentageOfFirstOperation("5132.123", "24.24", "1244.0266152");

            checkPercentageOfFirstOperation("42.64", "-67.8", "-28.90992");
            checkPercentageOfFirstOperation("31.31", "-34.5", "-10.80195");

            checkPercentageOfFirstOperation("-74.1", "-2.23", "1.65243");
            checkPercentageOfFirstOperation("-7.2", "-23.53", "1.69416");
        }
    }

    /**
     * Tests for percentage of 100 operation.
     */
    @Test
    void percentageOf100Tests() {
        //integers
        checkPercentageOf100Operation("-10000000000000000", "-1.e+14");
        checkPercentageOf100Operation("-9999999999999999", "-99999999999999.99");
        checkPercentageOf100Operation("-9999999999999998", "-99999999999999.98");
        checkPercentageOf100Operation("-10", "-0.1");
        checkPercentageOf100Operation("-1", "-0.01");

        checkPercentageOf100Operation("0", "0");

        checkPercentageOf100Operation("1", "0.01");
        checkPercentageOf100Operation("10", "0.1");
        checkPercentageOf100Operation("9999999999999998", "99999999999999.98");
        checkPercentageOf100Operation("9999999999999999", "99999999999999.99");
        checkPercentageOf100Operation("10000000000000000", "1.e+14");

        //decimals
        checkPercentageOf100Operation("-0.9999999999999999", "-0.009999999999999999");
        checkPercentageOf100Operation("-0.9", "-0.009");
        checkPercentageOf100Operation("-0.1", "-0.001");

        checkPercentageOf100Operation("0.1", "0.001");
        checkPercentageOf100Operation("0.9", "0.009");
        checkPercentageOf100Operation("0.9999999999999999", "0.009999999999999999");

        //engineer numbers
        checkPercentageOf100Operation("-1.e+9999", "-1.e+9997");
        checkPercentageOf100Operation("-1.e+9998", "-1.e+9996");
        checkPercentageOf100Operation("-1.e+17", "-1.e+15");
        checkPercentageOf100Operation("-1.e+16", "-1.e+14");

        checkPercentageOf100Operation("1.e+16", "1.e+14");
        checkPercentageOf100Operation("1.e+17", "1.e+15");
        checkPercentageOf100Operation("1.e+9998", "1.e+9996");
        checkPercentageOf100Operation("1.e+9999", "1.e+9997");


        checkPercentageOf100Operation("-1.e-17", "-1.e-19");
        checkPercentageOf100Operation("-1.e-16", "-1.e-18");

        checkPercentageOf100Operation("1.e-16", "1.e-18");
        checkPercentageOf100Operation("1.e-17", "1.e-19");

        //several random values
        checkPercentageOf100Operation("73", "0.73");
        checkPercentageOf100Operation("8734", "87.34");

        checkPercentageOf100Operation("-42", "-0.42");
        checkPercentageOf100Operation("-876", "-8.76");

        checkPercentageOf100Operation("2423.73", "24.2373");
        checkPercentageOf100Operation("87.234", "0.87234");

        checkPercentageOf100Operation("-123.623", "-1.23623");
        checkPercentageOf100Operation("-432.62", "-4.3262");
    }

    /**
     * Test for percentage operation while {@code BinaryOperation} in {@code Calculation} is set to null.
     */
    @Test
    void percentageForBinaryNull() {
        calculation.setBinaryOperation(null);
        calculation.setFirst(BigDecimal.ONE);
        calculation.setSecond(BigDecimal.TEN);

        calculation.calculatePercentage();

        assertEquals(BigDecimal.ZERO, calculation.getFirst());
        assertEquals(BigDecimal.ZERO, calculation.getSecond());
    }

    /**
     * Tests for {@code OverflowException} while using {@code BinaryOperation}.
     */
    @Test
    void binaryOverflowExceptionTests() {
        //add operation
        {
            checkAddOverflowException("-9.e+9999", "-9.e+9999");
            checkAddOverflowException("-9.e+9999", "-8.e+9999");
            checkAddOverflowException("-9.e+9999", "-2.e+9999");
            checkAddOverflowException("-9.e+9999", "-1.e+9999");

            checkAddOverflowException("-8.e+9999", "-8.e+9999");
            checkAddOverflowException("-8.e+9999", "-8.e+9999");
            checkAddOverflowException("-8.e+9999", "-2.e+9999");

            checkAddOverflowException("8.e+9999", "8.e+9999");
            checkAddOverflowException("8.e+9999", "8.e+9999");
            checkAddOverflowException("8.e+9999", "2.e+9999");

            checkAddOverflowException("9.e+9999", "9.e+9999");
            checkAddOverflowException("9.e+9999", "8.e+9999");
            checkAddOverflowException("9.e+9999", "2.e+9999");
            checkAddOverflowException("9.e+9999", "1.e+9999");
        }

        //subtract operation
        {
            checkSubtractOverflowException("-9.e+9999", "9.e+9999");
            checkSubtractOverflowException("9.e+9999", "-9.e+9999");

            checkSubtractOverflowException("-9.e+9999", "8.e+9999");
            checkSubtractOverflowException("8.e+9999", "-9.e+9999");

            checkSubtractOverflowException("-9.e+9999", "2.e+9999");
            checkSubtractOverflowException("2.e+9999", "-9.e+9999");

            checkSubtractOverflowException("-9.e+9999", "1.e+9999");
            checkSubtractOverflowException("1.e+9999", "-9.e+9999");


            checkSubtractOverflowException("-8.e+9999", "8.e+9999");
            checkSubtractOverflowException("8.e+9999", "-8.e+9999");

            checkSubtractOverflowException("-8.e+9999", "8.e+9999");
            checkSubtractOverflowException("8.e+9999", "-8.e+9999");

            checkSubtractOverflowException("-8.e+9999", "2.e+9999");
            checkSubtractOverflowException("2.e+9999", "-8.e+9999");


            checkSubtractOverflowException("8.e+9999", "-8.e+9999");
            checkSubtractOverflowException("-8.e+9999", "8.e+9999");

            checkSubtractOverflowException("8.e+9999", "-8.e+9999");
            checkSubtractOverflowException("-8.e+9999", "8.e+9999");

            checkSubtractOverflowException("8.e+9999", "-2.e+9999");
            checkSubtractOverflowException("-2.e+9999", "8.e+9999");


            checkSubtractOverflowException("9.e+9999", "-9.e+9999");
            checkSubtractOverflowException("-9.e+9999", "9.e+9999");

            checkSubtractOverflowException("9.e+9999", "-8.e+9999");
            checkSubtractOverflowException("-8.e+9999", "9.e+9999");

            checkSubtractOverflowException("9.e+9999", "-2.e+9999");
            checkSubtractOverflowException("-2.e+9999", "9.e+9999");

            checkSubtractOverflowException("9.e+9999", "-1.e+9999");
            checkSubtractOverflowException("-1.e+9999", "9.e+9999");
        }

        //multiply operation
        {
            checkMultiplyOverflowException("-1.e+9999", "-10");
            checkMultiplyOverflowException("-1.e+9999", "10");

            checkMultiplyOverflowException("-1.e+9999", "-1.e+9998");
            checkMultiplyOverflowException("-1.e+9999", "1.e+9998");

            checkMultiplyOverflowException("-1.e+9999", "-1.e+9999");
            checkMultiplyOverflowException("-1.e+9999", "1.e+9999");


            checkMultiplyOverflowException("-1.e+9998", "-1.e+9998");
            checkMultiplyOverflowException("-1.e+9998", "1.e+9998");

            checkMultiplyOverflowException("-1.e+9998", "-1.e+9999");
            checkMultiplyOverflowException("-1.e+9998", "1.e+9999");


            checkMultiplyOverflowException("-1.e+5000", "-1.e+5000");
            checkMultiplyOverflowException("-1.e+5000", "1.e+5000");


            checkMultiplyOverflowException("1.e+5000", "-1.e+5000");
            checkMultiplyOverflowException("1.e+5000", "1.e+5000");

            checkMultiplyOverflowException("1.e+9998", "-1.e+9998");
            checkMultiplyOverflowException("1.e+9998", "1.e+9998");

            checkMultiplyOverflowException("1.e+9998", "-1.e+9999");
            checkMultiplyOverflowException("1.e+9998", "1.e+9999");


            checkMultiplyOverflowException("1.e+9999", "-10");
            checkMultiplyOverflowException("1.e+9999", "10");

            checkMultiplyOverflowException("1.e+9999", "-1.e+9998");
            checkMultiplyOverflowException("1.e+9999", "1.e+9998");

            checkMultiplyOverflowException("1.e+9999", "-1.e+9999");
            checkMultiplyOverflowException("1.e+9999", "1.e+9999");


            checkMultiplyOverflowException("-1.e-9999", "-0.1");
            checkMultiplyOverflowException("-1.e-9999", "0.1");

            checkMultiplyOverflowException("-1.e-9999", "-1.e-9998");
            checkMultiplyOverflowException("-1.e-9999", "1.e-9998");

            checkMultiplyOverflowException("-1.e-9999", "-1.e-9999");
            checkMultiplyOverflowException("-1.e-9999", "1.e-9999");


            checkMultiplyOverflowException("-1.e-9998", "-1.e-9998");
            checkMultiplyOverflowException("-1.e-9998", "1.e-9998");

            checkMultiplyOverflowException("-1.e-9998", "-1.e-9999");
            checkMultiplyOverflowException("-1.e-9998", "1.e-9999");


            checkMultiplyOverflowException("-1.e-5000", "-1.e-5000");
            checkMultiplyOverflowException("-1.e-5000", "1.e-5000");


            checkMultiplyOverflowException("1.e-5000", "-1.e-5000");
            checkMultiplyOverflowException("1.e-5000", "1.e-5000");


            checkMultiplyOverflowException("1.e-9998", "-1.e-9998");
            checkMultiplyOverflowException("1.e-9998", "1.e-9998");

            checkMultiplyOverflowException("1.e-9998", "-1.e-9999");
            checkMultiplyOverflowException("1.e-9998", "1.e-9999");


            checkMultiplyOverflowException("1.e-9999", "-0.1");
            checkMultiplyOverflowException("1.e-9999", "0.1");

            checkMultiplyOverflowException("1.e-9999", "-1.e-9998");
            checkMultiplyOverflowException("1.e-9999", "1.e-9998");

            checkMultiplyOverflowException("1.e-9999", "-1.e-9999");
            checkMultiplyOverflowException("1.e-9999", "1.e-9999");
        }

        //divide operation
        {
            checkDivideOverflowException("-1.e+9999", "-1.e-9999");
            checkDivideOverflowException("-1.e+9999", "1.e-9999");

            checkDivideOverflowException("-1.e+9999", "-1.e-9998");
            checkDivideOverflowException("-1.e+9999", "1.e-9998");

            checkDivideOverflowException("-1.e+9999", "-0.1");
            checkDivideOverflowException("-1.e+9999", "0.1");


            checkDivideOverflowException("-1.e+9998", "-1.e-9999");
            checkDivideOverflowException("-1.e+9998", "1.e-9999");

            checkDivideOverflowException("-1.e+9998", "-1.e-9998");
            checkDivideOverflowException("-1.e+9998", "1.e-9998");

            checkDivideOverflowException("-1.e+5000", "-1.e-5000");
            checkDivideOverflowException("-1.e+5000", "1.e-5000");


            checkDivideOverflowException("-1.e+5000", "-1.e-5000");
            checkDivideOverflowException("-1.e+5000", "1.e-5000");


            checkDivideOverflowException("1.e+9998", "-1.e-9999");
            checkDivideOverflowException("1.e+9998", "1.e-9999");

            checkDivideOverflowException("1.e+9998", "-1.e-9998");
            checkDivideOverflowException("1.e+9998", "1.e-9998");


            checkDivideOverflowException("1.e+9999", "-1.e-9999");
            checkDivideOverflowException("1.e+9999", "1.e-9999");

            checkDivideOverflowException("1.e+9999", "-1.e-9998");
            checkDivideOverflowException("1.e+9999", "1.e-9998");

            checkDivideOverflowException("1.e+9999", "-0.1");
            checkDivideOverflowException("1.e+9999", "0.1");


            checkDivideOverflowException("-1.e-9999", "-1.e+9999");
            checkDivideOverflowException("-1.e-9999", "1.e+9999");

            checkDivideOverflowException("-1.e-9999", "-1.e+9998");
            checkDivideOverflowException("-1.e-9999", "1.e+9998");

            checkDivideOverflowException("-1.e-9999", "-10");
            checkDivideOverflowException("-1.e-9999", "10");


            checkDivideOverflowException("-1.e-9998", "-1.e+9999");
            checkDivideOverflowException("-1.e-9998", "1.e+9999");

            checkDivideOverflowException("-1.e-9998", "-1.e+9998");
            checkDivideOverflowException("-1.e-9998", "1.e+9998");


            checkDivideOverflowException("-1.e+5000", "-1.e-5000");
            checkDivideOverflowException("-1.e+5000", "1.e-5000");


            checkDivideOverflowException("-1.e+5000", "-1.e-5000");
            checkDivideOverflowException("-1.e+5000", "1.e-5000");


            checkDivideOverflowException("1.e-9998", "-1.e+9999");
            checkDivideOverflowException("1.e-9998", "1.e+9999");

            checkDivideOverflowException("1.e-9998", "-1.e+9998");
            checkDivideOverflowException("1.e-9998", "1.e+9998");


            checkDivideOverflowException("1.e-9999", "-1.e+9999");
            checkDivideOverflowException("1.e-9999", "1.e+9999");

            checkDivideOverflowException("1.e-9999", "-1.e+9998");
            checkDivideOverflowException("1.e-9999", "1.e+9998");

            checkDivideOverflowException("1.e-9999", "-10");
            checkDivideOverflowException("1.e-9999", "10");
        }
    }

    /**
     * Tests for {@code OverflowException} while using {@code UnaryOperation.SQR} operation.
     */
    @Test
    void sqrOverflowExceptionTests() {
        checkSqrOverflowException("-1.e+9999");
        checkSqrOverflowException("-1.e+9998");
        checkSqrOverflowException("-1.e+7500");
        checkSqrOverflowException("-1.e+5000");

        checkSqrOverflowException("1.e+5000");
        checkSqrOverflowException("1.e+7500");
        checkSqrOverflowException("1.e+9998");
        checkSqrOverflowException("1.e+9999");


        checkSqrOverflowException("-1.e-9999");
        checkSqrOverflowException("-1.e-9998");
        checkSqrOverflowException("-1.e-7500");
        checkSqrOverflowException("-1.e-5000");

        checkSqrOverflowException("1.e-5000");
        checkSqrOverflowException("1.e-7500");
        checkSqrOverflowException("1.e-9998");
        checkSqrOverflowException("1.e-9999");
    }

    /**
     * Tests for {@code OverflowException} while using percentage of first operation.
     */
    @Test
    void percentageOfFirstOverflowExceptionTests() {
        checkPercentageOfFirstOverflowException("-1.e+9999", "-1000");
        checkPercentageOfFirstOverflowException("-1.e+9999", "1000");

        checkPercentageOfFirstOverflowException("-1.e+9999", "-1001");
        checkPercentageOfFirstOverflowException("-1.e+9999", "1001");

        checkPercentageOfFirstOverflowException("-1.e+9999", "-1.e+9998");
        checkPercentageOfFirstOverflowException("-1.e+9999", "1.e+9998");

        checkPercentageOfFirstOverflowException("-1.e+9999", "-1.e+9999");
        checkPercentageOfFirstOverflowException("-1.e+9999", "1.e+9999");


        checkPercentageOfFirstOverflowException("-1.e+9998", "-10000");
        checkPercentageOfFirstOverflowException("-1.e+9998", "10000");

        checkPercentageOfFirstOverflowException("-1.e+9998", "-1.e+9998");
        checkPercentageOfFirstOverflowException("-1.e+9998", "1.e+9998");

        checkPercentageOfFirstOverflowException("-1.e+9998", "-1.e+9999");
        checkPercentageOfFirstOverflowException("-1.e+9998", "1.e+9999");


        checkPercentageOfFirstOverflowException("-1.e+5001", "-1.e+5001");
        checkPercentageOfFirstOverflowException("-1.e+5001", "1.e+5001");


        checkPercentageOfFirstOverflowException("1.e+5001", "-1.e+5001");
        checkPercentageOfFirstOverflowException("1.e+5001", "1.e+5001");


        checkPercentageOfFirstOverflowException("1.e+9998", "-10000");
        checkPercentageOfFirstOverflowException("1.e+9998", "10000");

        checkPercentageOfFirstOverflowException("1.e+9998", "-1.e+9998");
        checkPercentageOfFirstOverflowException("1.e+9998", "1.e+9998");

        checkPercentageOfFirstOverflowException("1.e+9998", "-1.e+9999");
        checkPercentageOfFirstOverflowException("1.e+9998", "1.e+9999");


        checkPercentageOfFirstOverflowException("1.e+9999", "-1000");
        checkPercentageOfFirstOverflowException("1.e+9999", "1000");

        checkPercentageOfFirstOverflowException("1.e+9999", "-1001");
        checkPercentageOfFirstOverflowException("1.e+9999", "1001");

        checkPercentageOfFirstOverflowException("1.e+9999", "-1.e+9998");
        checkPercentageOfFirstOverflowException("1.e+9999", "1.e+9998");

        checkPercentageOfFirstOverflowException("1.e+9999", "-1.e+9999");
        checkPercentageOfFirstOverflowException("1.e+9999", "1.e+9999");


        checkPercentageOfFirstOverflowException("-1.e-9999", "-0.001");
        checkPercentageOfFirstOverflowException("-1.e-9999", "0.001");

        checkPercentageOfFirstOverflowException("-1.e-9999", "-0.0001");
        checkPercentageOfFirstOverflowException("-1.e-9999", "0.0001");

        checkPercentageOfFirstOverflowException("-1.e-9999", "-1.e-9998");
        checkPercentageOfFirstOverflowException("-1.e-9999", "1.e-9998");

        checkPercentageOfFirstOverflowException("-1.e-9999", "-1.e-9999");
        checkPercentageOfFirstOverflowException("-1.e-9999", "1.e-9999");


        checkPercentageOfFirstOverflowException("-1.e-9998", "-0.0001");
        checkPercentageOfFirstOverflowException("-1.e-9998", "0.0001");

        checkPercentageOfFirstOverflowException("-1.e-9998", "-1.e-9998");
        checkPercentageOfFirstOverflowException("-1.e-9998", "1.e-9998");

        checkPercentageOfFirstOverflowException("-1.e-9998", "-1.e-9999");
        checkPercentageOfFirstOverflowException("-1.e-9998", "1.e-9999");


        checkPercentageOfFirstOverflowException("-1.e-5001", "-1.e-5001");
        checkPercentageOfFirstOverflowException("-1.e-5001", "1.e-5001");


        checkPercentageOfFirstOverflowException("1.e-5001", "-1.e-5001");
        checkPercentageOfFirstOverflowException("1.e-5001", "1.e-5001");


        checkPercentageOfFirstOverflowException("1.e-9998", "-0.0001");
        checkPercentageOfFirstOverflowException("1.e-9998", "0.0001");

        checkPercentageOfFirstOverflowException("1.e-9998", "-1.e-9998");
        checkPercentageOfFirstOverflowException("1.e-9998", "1.e-9998");

        checkPercentageOfFirstOverflowException("1.e-9998", "-1.e-9999");
        checkPercentageOfFirstOverflowException("1.e-9998", "1.e-9999");


        checkPercentageOfFirstOverflowException("1.e-9999", "-0.001");
        checkPercentageOfFirstOverflowException("1.e-9999", "0.001");

        checkPercentageOfFirstOverflowException("1.e-9999", "-0.0001");
        checkPercentageOfFirstOverflowException("1.e-9999", "0.0001");

        checkPercentageOfFirstOverflowException("1.e-9999", "-1.e-9998");
        checkPercentageOfFirstOverflowException("1.e-9999", "1.e-9998");

        checkPercentageOfFirstOverflowException("1.e-9999", "-1.e-9999");
        checkPercentageOfFirstOverflowException("1.e-9999", "1.e-9999");
    }

    /**
     * Tests for {@code OverflowException} while using percentage of 100 operation.
     */
    @Test
    void percentageOf100OverFlowExceptionTests() {
        checkPercentageOf100OverflowException("-1.e-9999");
        checkPercentageOf100OverflowException("-1.e-9998");

        checkPercentageOf100OverflowException("1.e-9998");
        checkPercentageOf100OverflowException("1.e-9999");
    }

    /**
     * Tests for divide by zero exception.
     */
    @Test
    void divideByZeroExceptionTests() {
        checkDivideByZeroException("-10000000000000000");
        checkDivideByZeroException("-9999999999999999");
        checkDivideByZeroException("-9999999999999998");
        checkDivideByZeroException("-10");
        checkDivideByZeroException("-1");

        checkDivideByZeroException("1");
        checkDivideByZeroException("10");
        checkDivideByZeroException("9999999999999998");
        checkDivideByZeroException("9999999999999999");
        checkDivideByZeroException("10000000000000000");


        checkDivideByZeroException("-0.9999999999999999");
        checkDivideByZeroException("-0.9");
        checkDivideByZeroException("-0.1");

        checkDivideByZeroException("0.1");
        checkDivideByZeroException("0.9");
        checkDivideByZeroException("0.9999999999999999");


        checkDivideByZeroException("-1.e+9999");
        checkDivideByZeroException("-1.e+9998");

        checkDivideByZeroException("1.e+9998");
        checkDivideByZeroException("1.e+9999");

        checkDivideByZeroException("-1.e+17");
        checkDivideByZeroException("-1.e+16");

        checkDivideByZeroException("1.e+16");
        checkDivideByZeroException("1.e+17");

        checkDivideByZeroException("-1.e-9999");
        checkDivideByZeroException("-1.e-9998");

        checkDivideByZeroException("1.e-9998");
        checkDivideByZeroException("1.e-9999");

        checkDivideByZeroException("-1.e-17");
        checkDivideByZeroException("-1.e-16");

        checkDivideByZeroException("1.e-16");
        checkDivideByZeroException("1.e-17");
    }

    /**
     * Tests for {@code UnaryOperation.SQRT} of negative number exception.
     */
    @Test
    void negativeSqrtExceptionTests() {
        //integers 
        {
            checkNegativeSqrtException("-1");
            checkNegativeSqrtException("-10");
            checkNegativeSqrtException("-9");
            checkNegativeSqrtException("-25000000000000");
            checkNegativeSqrtException("-11111108888889");
            checkNegativeSqrtException("-9999999999999998");
            checkNegativeSqrtException("-9999999999999999");
            checkNegativeSqrtException("-10000000000000000");
        }

        //decimals
        {
            checkNegativeSqrtException("-0.1");
            checkNegativeSqrtException("-0.9");
            checkNegativeSqrtException("-0.9999999999999999");
        }

        //engineer numbers
        {
            checkNegativeSqrtException("-1.e+16");
            checkNegativeSqrtException("-1.e+17");
            checkNegativeSqrtException("-1.e+9998");
            checkNegativeSqrtException("-1.e+9999");

            checkNegativeSqrtException("-1.e-9999");
            checkNegativeSqrtException("-1.e-9998");
            checkNegativeSqrtException("-1.e-16");
            checkNegativeSqrtException("-1.e-17");
        }
    }

    /**
     * Test for divide zero by zero exception.
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
            assertEquals(DIVIDE_ZERO_BY_ZERO_MESSAGE, e.getMessage());
        }
    }

    /**
     * Tests for inverse by zero exception.
     */
    @Test
    void inverseZeroExceptionTest() {
        calculation.setFirst(BigDecimal.ZERO);

        try {
            calculation.calculateUnary(INVERSE);
            fail();
        } catch (ArithmeticException e) {
            assertEquals(DIVIDE_BY_ZERO_MESSAGE, e.getMessage());
        }
    }

    /**
     * Method for testing {@code BinaryOperation.ADD} in {@link Calculation}.
     * <p>
     *
     * @param first          first number of equation.
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkAddOperation(String first, String second, String expectedResult) {
        checkBinaryOperation(new BigDecimal(first), new BigDecimal(second), ADD, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@code BinaryOperation.SUBTRACT} in {@link Calculation}.
     * <p>
     *
     * @param first          first number of equation.
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkSubtractOperation(String first, String second, String expectedResult) {
        checkBinaryOperation(new BigDecimal(first), new BigDecimal(second), SUBTRACT, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@code BinaryOperation.MULTIPLY} in {@link Calculation}.
     * <p>
     *
     * @param first          first number of equation.
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkMultiplyOperation(String first, String second, String expectedResult) {
        checkBinaryOperation(new BigDecimal(first), new BigDecimal(second), MULTIPLY, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@code BinaryOperation.DIVIDE}  in {@link Calculation}.
     * <p>
     *
     * @param first          first number of equation.
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkDivideOperation(String first, String second, String expectedResult) {
        checkBinaryOperation(new BigDecimal(first), new BigDecimal(second), DIVIDE, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@link BinaryOperation} in {@link Calculation}.
     * <p>
     * For operations {@code BinaryOperation.ADD} and {@code BinaryOperation.MULTIPLY} it is possible to swap numbers
     * of equation between each other to obtain the same result.
     *
     * @param first          first number of equation.
     * @param second         second number of equation.
     * @param operation      {@code BinaryOperation} to use.
     * @param expectedResult result that should be obtained.
     */
    private void checkBinaryOperation(BigDecimal first, BigDecimal second, BinaryOperation operation,
                                      BigDecimal expectedResult) {
        calculation.setFirst(first);
        calculation.setSecond(second);
        calculation.setBinaryOperation(operation);
        calculation.calculateBinary();

        assertEquals(expectedResult, calculation.getResult());

        if (operation == ADD || operation == MULTIPLY) {
            calculation.setFirst(second);
            calculation.setSecond(first);
            calculation.calculateBinary();

            assertEquals(expectedResult, calculation.getResult());
        }
    }

    /**
     * Method for testing {@code UnaryOperation.NEGATE} in {@link Calculation}.
     *
     * @param first          first number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkNegateOperation(String first, String expectedResult) {
        checkUnaryOperation(new BigDecimal(first), NEGATE, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@code UnaryOperation.SQR} in {@link Calculation}.
     *
     * @param first          first number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkSqrOperation(String first, String expectedResult) {
        checkUnaryOperation(new BigDecimal(first), SQR, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@code UnaryOperation.SQRT} in {@link Calculation}.
     *
     * @param first          first number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkSqrtOperation(String first, String expectedResult) {
        checkUnaryOperation(new BigDecimal(first), SQRT, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@code UnaryOperation.INVERSE} in {@link Calculation}.
     *
     * @param first          first number of equation.
     * @param expectedResult result that should be obtained.
     */
    private void checkInverseOperation(String first, String expectedResult) {
        checkUnaryOperation(new BigDecimal(first), INVERSE, new BigDecimal(expectedResult));
    }

    /**
     * Method for testing {@link UnaryOperation} in {@link Calculation}.
     *
     * @param first          first number of equation.
     * @param operation      {@code UnaryOperation} to use.
     * @param expectedResult result that should be obtained.
     */
    private void checkUnaryOperation(BigDecimal first, UnaryOperation operation, BigDecimal expectedResult) {
        calculation.setFirst(first);
        calculation.calculateUnary(operation);

        assertEquals(expectedResult, calculation.getResult());
    }

    /**
     * Method for testing percentage of first number in {@link Calculation}.
     * <p>
     * For this operation it is possible to swap numbers of equation between each other to obtain the same result.
     *
     * @param first          first number of equation.
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained and set as result in {@code Calculation}.
     */
    private void checkPercentageOfFirstOperation(String first, String second, String expectedResult) {
        checkPercentageOfFirstOperation(new BigDecimal(first), new BigDecimal(second),
                new BigDecimal(expectedResult));
    }

    /**
     * Method for testing percentage of first number in {@link Calculation}.
     * <p>
     * For this operation it is possible to swap numbers of equation between each other to obtain the same result.
     *
     * @param first          first number of equation.
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained and set as result in {@code Calculation}.
     */
    private void checkPercentageOfFirstOperation(BigDecimal first, BigDecimal second, BigDecimal expectedResult) {
        calculation.setFirst(first);
        calculation.setSecond(second);
        calculation.setBinaryOperation(ADD);
        calculation.calculatePercentage();

        assertEquals(expectedResult, calculation.getResult());

        calculation.setFirst(second);
        calculation.setSecond(first);
        calculation.calculatePercentage();

        assertEquals(expectedResult, calculation.getResult());
    }

    /**
     * Method for testing percentage of 100 operation in {@link Calculation}.
     *
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained and set as result in {@code Calculation}.
     */
    private void checkPercentageOf100Operation(String second, String expectedResult) {
        checkPercentageOf100Operation(new BigDecimal(second), new BigDecimal(expectedResult));
    }

    /**
     * Method for testing percentage of 100 operation in {@link Calculation}.
     *
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained and set as result in {@code Calculation}.
     */
    private void checkPercentageOf100Operation(BigDecimal second, BigDecimal expectedResult) {
        calculation.setSecond(second);
        calculation.setBinaryOperation(MULTIPLY);
        calculation.calculatePercentage();

        assertEquals(expectedResult, calculation.getResult());
    }

    /**
     * Method for testing {@link OverflowException} while using {@code BinaryOperation.ADD} in {@link Calculation}
     * <p>
     * For inputted values, {@code OverflowException} should be thrown.
     *
     * @param first  first number of equation.
     * @param second second number of equation.
     */
    private void checkAddOverflowException(String first, String second) {
        checkBinaryOverflowException(new BigDecimal(first), new BigDecimal(second), ADD);
    }

    /**
     * Method for testing {@link OverflowException} while using {@code BinaryOperation.SUBTRACT} in {@link Calculation}
     * <p>
     * For inputted values, {@code OverflowException} should be thrown.
     *
     * @param first  first number of equation.
     * @param second second number of equation.
     */
    private void checkSubtractOverflowException(String first, String second) {
        checkBinaryOverflowException(new BigDecimal(first), new BigDecimal(second), SUBTRACT);
    }

    /**
     * Method for testing {@link OverflowException} while using {@code BinaryOperation.MULTIPLY} in {@link Calculation}
     * <p>
     * For inputted values, {@code OverflowException} should be thrown.
     *
     * @param first  first number of equation.
     * @param second second number of equation.
     */
    private void checkMultiplyOverflowException(String first, String second) {
        checkBinaryOverflowException(new BigDecimal(first), new BigDecimal(second), MULTIPLY);
    }

    /**
     * Method for testing {@link OverflowException} while using {@code BinaryOperation.DIVIDE} in {@link Calculation}
     * <p>
     * For inputted values, {@code OverflowException} should be thrown.
     *
     * @param first  first number of equation.
     * @param second second number of equation.
     */
    private void checkDivideOverflowException(String first, String second) {
        checkBinaryOverflowException(new BigDecimal(first), new BigDecimal(second), DIVIDE);
    }

    /**
     * Method for testing {@link OverflowException} while using {@link BinaryOperation} in {@link Calculation}
     * <p>
     * For inputted values, {@code OverflowException} should be thrown.
     * <p>
     * For operations {@code BinaryOperation.ADD} and {@code BinaryOperation.MULTIPLY} it is possible to swap numbers
     * of equation between each other to obtain the same result.
     *
     * @param first     first number of equation.
     * @param second    second number of equation.
     * @param operation {@code BinaryOperation} to use.
     */
    private void checkBinaryOverflowException(BigDecimal first, BigDecimal second, BinaryOperation operation) {
        calculation.setFirst(first);
        calculation.setSecond(second);
        calculation.setBinaryOperation(operation);

        try {
            calculation.calculateBinary();
            fail();
        } catch (OverflowException e) {
            assertEquals(OVERFLOW_MESSAGE, e.getMessage());
        }

        if (operation == ADD || operation == MULTIPLY) {
            calculation.setFirst(second);
            calculation.setSecond(first);

            try {
                calculation.calculateBinary();
                fail();
            } catch (OverflowException e) {
                assertEquals(OVERFLOW_MESSAGE, e.getMessage());
            }
        }
    }

    /**
     * Method for testing {@link OverflowException} while using {@code UnaryOperation.SQRT} in {@link Calculation}.
     * <p>
     * For inputted value, {@code OverflowException} should be thrown.
     *
     * @param first first number of equation.
     * @see UnaryOperation
     */
    private void checkSqrOverflowException(String first) {
        calculation.setFirst(new BigDecimal(first));

        try {
            calculation.calculateUnary(UnaryOperation.SQR);
            fail();
        } catch (OverflowException e) {
            assertEquals(OVERFLOW_MESSAGE, e.getMessage());
        }
    }

    /**
     * Method for testing {@link OverflowException} while using percentage of first operation in {@link Calculation}.
     * <p>
     * For inputted values, {@code OverflowException} should be thrown.
     * <p>
     * For this operation it is possible to swap numbers of equation between each other to obtain the same result.
     *
     * @param first  first number of equation.
     * @param second second number of equation.
     */
    private void checkPercentageOfFirstOverflowException(String first, String second) {
        calculation.setFirst(new BigDecimal(first));
        calculation.setSecond(new BigDecimal(second));
        calculation.setBinaryOperation(ADD);

        try {
            calculation.calculatePercentage();
            fail();
        } catch (OverflowException e) {
            assertEquals(OVERFLOW_MESSAGE, e.getMessage());
        }

        calculation.setFirst(new BigDecimal(second));
        calculation.setSecond(new BigDecimal(first));
        calculation.setBinaryOperation(ADD);

        try {
            calculation.calculatePercentage();
            fail();
        } catch (OverflowException e) {
            assertEquals(OVERFLOW_MESSAGE, e.getMessage());
        }
    }

    /**
     * Method for testing {@link OverflowException} while using percentage of 100 operation in {@link Calculation}.
     * <p>
     * For inputted values, {@code OverflowException} should be thrown.
     *
     * @param second second number of equation.
     */
    private void checkPercentageOf100OverflowException(String second) {
        calculation.setSecond(new BigDecimal(second));
        calculation.setBinaryOperation(MULTIPLY);

        try {
            calculation.calculatePercentage();
            fail();
        } catch (OverflowException e) {
            assertEquals(OVERFLOW_MESSAGE, e.getMessage());
        }
    }

    /**
     * Method for testing divide by zero exception in {@link Calculation}.
     * <p>
     * For inputted value, {@code ArithmeticException} should be thrown.
     *
     * @param first first number of equation.
     */
    private void checkDivideByZeroException(String first) {
        calculation.setFirst(new BigDecimal(first));
        calculation.setSecond(BigDecimal.ZERO);
        calculation.setBinaryOperation(DIVIDE);

        try {
            calculation.calculateBinary();
            fail();
        } catch (ArithmeticException e) {
            assertEquals(DIVIDE_BY_ZERO_MESSAGE, e.getMessage());
        }
    }

    /**
     * Method for testing negative sqrt (invalid input) exception in {@link Calculation}.
     * <p>
     * For inputted value, {@code ArithmeticException} should be thrown.
     *
     * @param first first number of equation.
     */
    private void checkNegativeSqrtException(String first) {
        calculation.setFirst(new BigDecimal(first));

        try {
            calculation.calculateUnary(SQRT);
            fail();
        } catch (ArithmeticException e) {
            assertEquals(INVALID_INPUT_MESSAGE, e.getMessage());
        }
    }
}