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

        assertEquals(BigDecimal.ZERO, calculation.getFirst());
        assertEquals(BigDecimal.ZERO, calculation.getSecond());
        assertEquals(BigDecimal.ZERO, calculation.getResult());
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
        checkSubtractOperation("0.00000000000000000000000000001", "0.01",
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
        //easy cases
        checkMultiplyOperation("2", "2", "4");
        checkMultiplyOperation("-3", "-3", "9");
        checkMultiplyOperation("5.5", "3.2", "17.6");
        checkMultiplyOperation("-10.2", "-7", "71.4");
        checkMultiplyOperation("7.4", "-5.1", "-37.74");
        checkMultiplyOperation("1.e+5", "1.e+8", "1.e+13");
        checkMultiplyOperation("1.e-20", "5.e-20", "5.e-40");

        //cases with zero
        checkMultiplyOperation("0", "0", "0");
        checkMultiplyOperation("2", "0", "0");
        checkMultiplyOperation("-3", "0", "0");
        checkMultiplyOperation("5.5", "0", "0");
        checkMultiplyOperation("0", "-7", "0");
        checkMultiplyOperation("0", "-5.1", "0");
        checkMultiplyOperation("0", "1.e+8", "0");

        //big numbers
        checkMultiplyOperation("10000000000000000", "10000000000000000", "1.e+32");
        checkMultiplyOperation("5000000000000000", "9999999999999999",
                "4.9999999999999995e+31");
        checkMultiplyOperation("1234567890987654321", "1", "1234567890987654321");
        checkMultiplyOperation("100000000000000000000000000", "10", "1.e+27");

        //with decimals
        checkMultiplyOperation("10000000000000000", "0.1", "1.e+15");
        checkMultiplyOperation("5000000000000000", "0.9999999999999999",
                "4999999999999999.5");
        checkMultiplyOperation("1234567890987654321", "123.123",
                "152003702442072962964.483");
        checkMultiplyOperation("100000000000000000000000000", "0.00000000000000000000000000001",
                "0.001");

        //decimal and decimal
        checkMultiplyOperation("0.0000000000001", "0.1", "0.00000000000001");
        checkMultiplyOperation("0.0000000000000001", "0.9999999999999999",
                "0.00000000000000009999999999999999");
        checkMultiplyOperation("1234567890.987654321", "123.123",
                "152003702442.072962964483");
        checkMultiplyOperation("0.01", "0.00000000000000000000000000001",
                "0.0000000000000000000000000000001");

        //boundary
        checkMultiplyOperation("4.5e+9999", "2", "9.e+9999");
        checkMultiplyOperation("9.e+9998", "10", "9.e+9999");
        checkMultiplyOperation("9.e-9998", "0.1", "9.e-9999");
        checkMultiplyOperation("4.5e-9999", "2", "9.e-9999");

        checkMultiplyOperation("-4.5e+9999", "2", "-9.e+9999");
        checkMultiplyOperation("9.e+9998", "-10", "-9.e+9999");
        checkMultiplyOperation("9.e-9998", "-0.1", "-9.e-9999");
        checkMultiplyOperation("-4.5e-9999", "2", "-9.e-9999");

        //several random values
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

    /**
     * Tests for divide operation.
     */
    @Test
    void divideOperationTests() {
        //easy cases
        checkDivideOperation("2", "2", "1");
        checkDivideOperation("-3", "-3", "1");

        checkDivideOperation("4", "2", "2");
        checkDivideOperation("2", "4", "0.5");

        checkDivideOperation("-10.2", "-102", "0.1");
        checkDivideOperation("-102", "-10.2", "1.e+1");

        checkDivideOperation("7.4", "-0.5", "-14.8");

        checkDivideOperation("-5.55", "1.11", "-5");

        checkDivideOperation("1.e+5", "1.e+8", "0.001");
        checkDivideOperation("1.e+8", "1.e+5", "1.e+3");

        checkDivideOperation("1.e-20", "5.e-20", "0.2");
        checkDivideOperation("5.e-20", "1.e-20", "5");

        //cases with zero
        checkDivideOperation("0", "2", "0");
        checkDivideOperation("0", "-3", "0");
        checkDivideOperation("0", "5.5", "0");
        checkDivideOperation("0", "-7", "0");
        checkDivideOperation("0", "-5.1", "0");
        checkDivideOperation("0", "1.e+8", "0");

        //big numbers
        checkDivideOperation("10000000000000000", "-10000000000000000", "-1");
        checkDivideOperation("8888888888888888", "-4444444444444444", "-2");
        checkDivideOperation("1234567890987654321", "1", "1234567890987654321");
        checkDivideOperation("100000000000000000000000000", "10", "1.e+25");
        checkDivideOperation("-10", "100000000000000000000000000", "-1.e-25");

        //with decimals
        checkDivideOperation("10000000000000000", "0.1", "1.e+17");
        checkDivideOperation("0.1", "10000000000000000", "1.e-17");

        checkDivideOperation("9999999999999999", "0.9999999999999999", "1.e+16");
        checkDivideOperation("0.9999999999999999", "9999999999999999", "1.e-16");

        checkDivideOperation("1234567890987654321", "0.2", "6172839454938271605");
        checkDivideOperation("6172839454938271605", "0.02", "3.0864197274691358025e+20");

        checkDivideOperation("100000000000000000000000000", "0.00000000000000000000000000001",
                "1.e+55");
        checkDivideOperation("0.00000000000000000000000000001", "100000000000000000000000000",
                "1.e-55");

        //decimal and decimal
        checkDivideOperation("0.0000000000001", "0.1", "0.000000000001");
        checkDivideOperation("0.1", "0.0000000000001", "1.e+12");

        checkDivideOperation("-0.0000000000000001", "-0.00000000000000008", "1.25");
        checkDivideOperation("-0.00000000000000008", "-0.0000000000000001", "0.8");

        checkDivideOperation("246.246", "-123.123", "-2");
        checkDivideOperation("-123.123", "246.246", "-0.5");

        checkDivideOperation("-0.01", "0.00000000000000000000000000001", "-1.e+27");
        checkDivideOperation("0.00000000000000000000000000001", "-0.01", "-1.e-27");

        //boundary
        checkDivideOperation("1.e+9998", "0.1", "1.e+9999");
        checkDivideOperation("-0.1", "1.e+9998", "-1.e-9999");

        checkDivideOperation("9.e+9998", "0.2", "4.5e+9999");
        checkDivideOperation("0.2", "-1.e+9998", "-2.e-9999");

        checkDivideOperation("1.e-9998", "10", "1.e-9999");
        checkDivideOperation("-10", "1.e-9998", "-1.e+9999");

        checkDivideOperation("9.e-9998", "20", "4.5e-9999");
        checkDivideOperation("20", "-1.e-9998", "-2.e+9999");

        //several random values
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

    /**
     * Tests for negate operation.
     */
    @Test
    void negateOperationTests() {
        //easy cases
        checkNegateOperation("2", "-2");
        checkNegateOperation("-3", "3");
        checkNegateOperation("5.5", "-5.5");
        checkNegateOperation("-10.2", "10.2");
        checkNegateOperation("7.4", "-7.4");
        checkNegateOperation("-1.e+5", "1.e+5");
        checkNegateOperation("1.e-20", "-1.e-20");

        //cases with zero
        checkNegateOperation("0", "0");

        //big numbers
        checkNegateOperation("10000000000000000", "-1.e+16");
        checkNegateOperation("-5000000000000000", "5.e+15");
        checkNegateOperation("1234567890987654321", "-1234567890987654321");
        checkNegateOperation("-100000000000000000000000000", "1.e+26");

        //decimals
        checkNegateOperation("0.0000000000001", "-0.0000000000001");
        checkNegateOperation("-0.0000000000000001", "0.0000000000000001");
        checkNegateOperation("1234567890.987654321", "-1234567890.987654321");
        checkNegateOperation("-0.00000000000000000000000000009", "0.00000000000000000000000000009");

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
        //easy cases
        checkSqrOperation("2", "4");
        checkSqrOperation("-3", "9");
        checkSqrOperation("5.5", "30.25");
        checkSqrOperation("-10.2", "104.04");
        checkSqrOperation("7.4", "54.76");
        checkSqrOperation("-1.e+5", "1.e+10");
        checkSqrOperation("1.e-20", "1.e-40");

        //cases with zero
        checkSqrOperation("0", "0");

        //big numbers
        checkSqrOperation("10000000000000000", "1.e+32");
        checkSqrOperation("-5000000000000000", "2.5e+31");
        checkSqrOperation("1234567890987654321", "1524157877457704723228166437789971041");
        checkSqrOperation("-100000000000000000000000000", "1.e+52");

        //decimals
        checkSqrOperation("0.0000000000001", "1.e-26");
        checkSqrOperation("-0.0000000000000001", "1.e-32");
        checkSqrOperation("1234567890.987654321", "1524157877457704723.228166437789971041");
        checkSqrOperation("-0.00000000000000000000000000009", "8.1e-57");

        //boundary
        checkSqrOperation("1.e+4999", "1.e+9998");
        checkSqrOperation("-9.e+4999", "8.1e+9999");
        checkSqrOperation("1.e-4999", "1.e-9998");
        checkSqrOperation("-9.e-4999", "8.1e-9997");

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
        //easy cases
        checkSqrtOperation("4", "2");
        checkSqrtOperation("9", "3");
        checkSqrtOperation("100", "1.e+1");
        checkSqrtOperation("1.21", "1.1");
        checkSqrtOperation("0.81", "0.9");
        checkSqrtOperation("1.e+5", "316.2277660168379");
        checkSqrtOperation("1.e-20", "1.e-10");

        //cases with zero
        checkSqrtOperation("0", "0");

        //big numbers
        checkSqrtOperation("10000000000000000", "1.e+8");
        checkSqrtOperation("5000000000000000", "70710678.11865475");
        checkSqrtOperation("1234567890987654", "35136418.30049918");
        checkSqrtOperation("100000000000000000000000000", "1.e+13");

        //decimals
        checkSqrtOperation("0.0000000000001", "3.162277660168379e-7");
        checkSqrtOperation("0.0000000000000001", "0.00000001");
        checkSqrtOperation("1234567890.987654", "35136.41830049918");
        checkSqrtOperation("0.0000000000000000000000000009", "3.e-14");

        //several random values
        checkSqrtOperation("9132131", "3021.941594405822");
        checkSqrtOperation("1235123", "1111.360877483097");

        checkSqrtOperation("123.5523", "11.11540822462225");
        checkSqrtOperation("123.1243", "11.09613896812761");

        checkSqrtOperation("7373", "85.86617494683224");
        checkSqrtOperation("123198743", "11099.49291634532");

        checkSqrtOperation("312.5632", "17.67945700523633");
        checkSqrtOperation("123.87624525", "11.1299705862145");
    }

    /**
     * Tests for inverse operation.
     */
    @Test
    void inverseOperationTests() {
        //easy cases
        checkInverseOperation("2", "0.5");
        checkInverseOperation("0.5", "2");

        checkInverseOperation("-100", "-0.01");
        checkInverseOperation("-0.01", "-1.e+2");

        checkInverseOperation("1.e+5", "1.e-5");
        checkInverseOperation("1.e+5", "0.00001");

        //big numbers
        checkInverseOperation("10000000000000000", "1.e-16");
        checkInverseOperation("0.0000000000000001", "1.e+16");

        checkInverseOperation("-5000000000000000", "-2.e-16");
        checkInverseOperation("-0.00000000000000002", "-5.e+16");

        checkInverseOperation("-100000000000000000000000000", "-1.e-26");
        checkInverseOperation("-0.00000000000000000000000001", "-1.e+26");

        checkInverseOperation("0.00000000000000000000000000008", "1.25E+28");
        checkInverseOperation("12500000000000000000000000000", "0.00000000000000000000000000008");

        //boundary
        checkInverseOperation("1.e+9999", "1.e-9999");
        checkInverseOperation("-2.e+9998", "-5.e-9999");

        checkInverseOperation("1.e-9999", "1.e+9999");
        checkInverseOperation("-2.e-9999", "-5.e+9998");

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
        //easy cases
        checkPercentageOfFirstOperation("100", "100", "1.e+2");
        checkPercentageOfFirstOperation("50", "-100", "-5.e+1");
        checkPercentageOfFirstOperation("100", "15", "15");
        checkPercentageOfFirstOperation("10.1", "-5", "-0.505");
        checkPercentageOfFirstOperation("75.276", "67.2", "50.585472");
        checkPercentageOfFirstOperation("1.e+5", "1.e+8", "1.e+11");
        checkPercentageOfFirstOperation("1.e-20", "5.e-20", "5.e-42");

        //cases with zero
        checkPercentageOfFirstOperation("0", "0", "0");
        checkPercentageOfFirstOperation("2", "0", "0");
        checkPercentageOfFirstOperation("-3", "0", "0");
        checkPercentageOfFirstOperation("5.5", "0", "0");
        checkPercentageOfFirstOperation("0", "-7", "0");
        checkPercentageOfFirstOperation("0", "-5.1", "0");
        checkPercentageOfFirstOperation("0", "1.e+8", "0");

        //big numbers
        checkPercentageOfFirstOperation("10000000000000000", "10000000000000000", "1.e+30");
        checkPercentageOfFirstOperation("5000000000000000", "9999999999999999", "4.9999999999999995e+29");
        checkPercentageOfFirstOperation("1234567890987654321", "1", "12345678909876543.21");
        checkPercentageOfFirstOperation("100000000000000000000000000", "10", "1.e+25");

        //with decimals
        checkPercentageOfFirstOperation("10000000000000000", "0.1", "1.e+13");
        checkPercentageOfFirstOperation("5000000000000000", "0.9999999999999999", "49999999999999.995");
        checkPercentageOfFirstOperation("1234567890987654321", "123.123", "1520037024420729629.64483");
        checkPercentageOfFirstOperation("100000000000000000000000000", "0.00000000000000000000000000001", "0.00001");

        //decimal and decimal
        checkPercentageOfFirstOperation("0.0000000000001", "0.1", "1.e-16");
        checkPercentageOfFirstOperation("0.0000000000000001", "0.9999999999999999", "9.999999999999999e-19");
        checkPercentageOfFirstOperation("1234567890.987654321", "123.123", "1520037024.42072962964483");
        checkPercentageOfFirstOperation("0.01", "0.00000000000000000000000000001", "1.e-33");

        //boundary
        checkPercentageOfFirstOperation("9.e+9997", "10000", "9.e+9999");
        checkPercentageOfFirstOperation("-9.e+9999", "-100", "9.e+9999");
        checkPercentageOfFirstOperation("9.e-9997", "1", "9.e-9999");
        checkPercentageOfFirstOperation("-9.e-9999", "-100", "9.e-9999");

        checkPercentageOfFirstOperation("-9.e+9997", "10000", "-9.e+9999");
        checkPercentageOfFirstOperation("9.e+9999", "-100", "-9.e+9999");
        checkPercentageOfFirstOperation("-9.e-9997", "1", "-9.e-9999");
        checkPercentageOfFirstOperation("9.e-9999", "-100", "-9.e-9999");

        //several random values
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

    /**
     * Tests for percentage of 100 operation.
     */
    @Test
    void percentageOf100Tests() {
        //easy cases
        checkPercentageOf100Operation("100", "1");
        checkPercentageOf100Operation("-10", "-0.1");
        checkPercentageOf100Operation("50", "0.5");
        checkPercentageOf100Operation("-789", "-7.89");
        checkPercentageOf100Operation("5.5", "0.055");
        checkPercentageOf100Operation("-10.2", "-0.102");
        checkPercentageOf100Operation("7.4", "0.074");
        checkPercentageOf100Operation("-1.e+5", "-1.e+3");
        checkPercentageOf100Operation("1.e-20", "1.e-22");

        //cases with zero
        checkPercentageOf100Operation("0", "0");

        //big numbers
        checkPercentageOf100Operation("10000000000000000", "1.e+14");
        checkPercentageOf100Operation("-5000000000000000", "-5.e+13");
        checkPercentageOf100Operation("1234567890987654321", "12345678909876543.21");
        checkPercentageOf100Operation("-100000000000000000000000000", "-1.e+24");

        //decimals
        checkPercentageOf100Operation("0.0000000000001", "0.000000000000001");
        checkPercentageOf100Operation("-0.0000000000000001", "-0.000000000000000001");
        checkPercentageOf100Operation("1234567890.987654321", "12345678.90987654321");
        checkPercentageOf100Operation("-0.00000000000000000000000000009",
                "-0.0000000000000000000000000000009");

        //boundary
        checkPercentageOf100Operation("9.e+9999", "9.e+9997");
        checkPercentageOf100Operation("1.e-9997", "1.e-9999");
        checkPercentageOf100Operation("-9.e-9997", "-9.e-9999");

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
        assertEquals(BigDecimal.ZERO, calculation.getResult());
    }

    /**
     * Tests for {@code OverflowException} while using {@code BinaryOperation}.
     */
    @Test
    void binaryOverflowExceptionTests() {
        //add operation
        checkAddOverflowException("9.e+9999", "9.e+9999");
        checkAddOverflowException("9.e+9999", "1.e+9999");
        checkAddOverflowException("8.e+9999", "2.e+9999");

        checkAddOverflowException("-9.e+9999", "-9.e+9999");
        checkAddOverflowException("-9.e+9999", "-1.e+9999");
        checkAddOverflowException("-8.e+9999", "-2.e+9999");

        //subtract operation
        checkSubtractOverflowException("9.e+9999", "-9.e+9999");
        checkSubtractOverflowException("-9.e+9999", "9.e+9999");

        checkSubtractOverflowException("9.e+9999", "-1.e+9999");
        checkSubtractOverflowException("-1.e+9999", "9.e+9999");

        checkSubtractOverflowException("8.e+9999", "-2.e+9999");
        checkSubtractOverflowException("-2.e+9999", "8.e+9999");

        checkSubtractOverflowException("-9.e+9999", "9.e+9999");
        checkSubtractOverflowException("9.e+9999", "-9.e+9999");

        checkSubtractOverflowException("-9.e+9999", "1.e+9999");
        checkSubtractOverflowException("1.e+9999", "-9.e+9999");

        checkSubtractOverflowException("-8.e+9999", "2.e+9999");
        checkSubtractOverflowException("2.e+9999", "-8.e+9999");

        //multiply operation
        checkMultiplyOverflowException("1.e+9999", "-1.e+9999");
        checkMultiplyOverflowException("1.e+9999", "1.e+9999");

        checkMultiplyOverflowException("1.e+9999", "-10");
        checkMultiplyOverflowException("1.e+9999", "10");

        checkMultiplyOverflowException("1.e+5000", "-1.e+5000");
        checkMultiplyOverflowException("1.e+5000", "1.e+5000");

        checkMultiplyOverflowException("-1.e+9999", "-10");
        checkMultiplyOverflowException("-1.e+9999", "10");

        checkMultiplyOverflowException("-1.e+9999", "-1.e+9999");
        checkMultiplyOverflowException("-1.e+9999", "1.e+9999");

        checkMultiplyOverflowException("-1.e+5000", "-1.e+5000");
        checkMultiplyOverflowException("-1.e+5000", "1.e+5000");


        checkMultiplyOverflowException("1.e-9999", "-1.e-9999");
        checkMultiplyOverflowException("1.e-9999", "1.e-9999");

        checkMultiplyOverflowException("1.e-9999", "-0.1");
        checkMultiplyOverflowException("1.e-9999", "0.1");

        checkMultiplyOverflowException("1.e-5000", "-1.e-5000");
        checkMultiplyOverflowException("1.e-5000", "1.e-5000");

        checkMultiplyOverflowException("-1.e-9999", "-0.1");
        checkMultiplyOverflowException("-1.e-9999", "0.1");

        checkMultiplyOverflowException("-1.e-9999", "-1.e-9999");
        checkMultiplyOverflowException("-1.e-9999", "1.e-9999");

        checkMultiplyOverflowException("-1.e-5000", "-1.e-5000");
        checkMultiplyOverflowException("-1.e-5000", "1.e-5000");

        //divide operation
        checkDivideOverflowException("1.e+9999", "-1.e-9999");
        checkDivideOverflowException("1.e+9999", "1.e-9999");

        checkDivideOverflowException("1.e+9999", "-0.1");
        checkDivideOverflowException("1.e+9999", "0.1");

        checkDivideOverflowException("1.e+5000", "-1.e-5000");
        checkDivideOverflowException("1.e+5000", "1.e-5000");

        checkDivideOverflowException("-1.e+9999", "-1.e-9999");
        checkDivideOverflowException("-1.e+9999", "1.e-9999");

        checkDivideOverflowException("-1.e+9999", "-0.1");
        checkDivideOverflowException("-1.e+9999", "0.1");

        checkDivideOverflowException("-1.e+5000", "-1.e-5000");
        checkDivideOverflowException("-1.e+5000", "1.e-5000");


        checkDivideOverflowException("1.e-9999", "-1.e+9999");
        checkDivideOverflowException("1.e-9999", "1.e+9999");

        checkDivideOverflowException("1.e-9999", "-10");
        checkDivideOverflowException("1.e-9999", "10");

        checkDivideOverflowException("1.e-5000", "-1.e+5000");
        checkDivideOverflowException("1.e-5000", "1.e+5000");

        checkDivideOverflowException("-1.e-9999", "-1.e+9999");
        checkDivideOverflowException("-1.e-9999", "1.e+9999");

        checkDivideOverflowException("-1.e-9999", "-10");
        checkDivideOverflowException("-1.e-9999", "10");

        checkDivideOverflowException("-1.e-5000", "-1.e+5000");
        checkDivideOverflowException("-1.e-5000", "1.e+5000");
    }

    /**
     * Tests for {@code OverflowException} while using {@code UnaryOperation.SQR} operation.
     */
    @Test
    void sqrOverflowExceptionTests() {
        checkSqrOverflowException("1.e+9999");
        checkSqrOverflowException("1.e+5000");

        checkSqrOverflowException("-1.e+9999");
        checkSqrOverflowException("-1.e+5000");

        checkSqrOverflowException("1.e-9999");
        checkSqrOverflowException("1.e-5000");

        checkSqrOverflowException("-1.e-9999");
        checkSqrOverflowException("-1.e-5000");
    }

    /**
     * Tests for {@code OverflowException} while using percentage of first operation.
     */
    @Test
    void percentageOfFirstOverflowExceptionTests() {
        checkPercentageOfFirstOverflowException("1.e+9999", "-1.e+9999");
        checkPercentageOfFirstOverflowException("1.e+9999", "1.e+9999");

        checkPercentageOfFirstOverflowException("1.e+9999", "-1000");
        checkPercentageOfFirstOverflowException("1.e+9999", "1000");

        checkPercentageOfFirstOverflowException("1.e+5001", "-1.e+5001");
        checkPercentageOfFirstOverflowException("1.e+5001", "1.e+5001");

        checkPercentageOfFirstOverflowException("-1.e+9999", "-1.e+9999");
        checkPercentageOfFirstOverflowException("-1.e+9999", "1.e+9999");

        checkPercentageOfFirstOverflowException("-1.e+9999", "-1000");
        checkPercentageOfFirstOverflowException("-1.e+9999", "1000");

        checkPercentageOfFirstOverflowException("-1.e+5001", "-1.e+5001");
        checkPercentageOfFirstOverflowException("-1.e+5001", "1.e+5001");


        checkPercentageOfFirstOverflowException("1.e-9999", "-1.e-9999");
        checkPercentageOfFirstOverflowException("1.e-9999", "1.e-9999");

        checkPercentageOfFirstOverflowException("1.e-9999", "-0.0001");
        checkPercentageOfFirstOverflowException("1.e-9999", "0.0001");

        checkPercentageOfFirstOverflowException("1.e-5001", "-1.e-5001");
        checkPercentageOfFirstOverflowException("1.e-5001", "1.e-5001");

        checkPercentageOfFirstOverflowException("-1.e-9999", "-1.e-9999");
        checkPercentageOfFirstOverflowException("-1.e-9999", "1.e-9999");

        checkPercentageOfFirstOverflowException("-1.e-9999", "-0.0001");
        checkPercentageOfFirstOverflowException("-1.e-9999", "0.0001");

        checkPercentageOfFirstOverflowException("-1.e-5001", "-1.e-5001");
        checkPercentageOfFirstOverflowException("-1.e-5001", "1.e-5001");
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
        checkDivideByZeroException("1");
        checkDivideByZeroException("2");
        checkDivideByZeroException("10000000000000000");
        checkDivideByZeroException("-1");
        checkDivideByZeroException("-2");
        checkDivideByZeroException("-10000000000000000");

        checkDivideByZeroException("0.1");
        checkDivideByZeroException("0.9");
        checkDivideByZeroException("0.9999999999999999");
        checkDivideByZeroException("-0.1");
        checkDivideByZeroException("-0.9");
        checkDivideByZeroException("-0.9999999999999999");

        checkDivideByZeroException("1.e+9999");
        checkDivideByZeroException("1.e+9998");
        checkDivideByZeroException("-1.e+9999");
        checkDivideByZeroException("-1.e+9998");

        checkDivideByZeroException("1.e-9999");
        checkDivideByZeroException("1.e-9998");
        checkDivideByZeroException("-1.e-9999");
        checkDivideByZeroException("-1.e-9998");
    }

    /**
     * Tests for {@code UnaryOperation.SQRT} of negative number exception.
     */
    @Test
    void negativeSqrtExceptionTests() {
        checkNegativeSqrtException("-1");
        checkNegativeSqrtException("-9");
        checkNegativeSqrtException("-10000000000000000");

        checkNegativeSqrtException("-0.1");
        checkNegativeSqrtException("-0.9");
        checkNegativeSqrtException("-0.9999999999999999");

        checkNegativeSqrtException("-1.e+9998");
        checkNegativeSqrtException("-1.e+9999");

        checkNegativeSqrtException("-1.e-9999");
        checkNegativeSqrtException("-1.e-9998");
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
        calculation.setBinaryOperation(SUBTRACT);
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

        calculation.setSecond(second);
        calculation.setBinaryOperation(DIVIDE);
        calculation.calculatePercentage();
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