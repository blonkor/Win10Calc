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
     * Regex for all integer numbers not in engineer representation.
     */
    private static final String INTEGER_NUMBER_REGEX = "-?\\d+";

    /**
     * Regex for all decimal numbers not in engineer representation.
     */
    private static final String DECIMAL_NUMBER_REGEX = "-?\\d+\\.\\d+";

    /**
     * Regex for all numbers not engineer representation.
     */
    private static final String ENGINEER_NUMBER_REGEX = "-?\\d\\.\\d*e[+-]\\d+";

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
     * Tests for the only add operation.
     */
    @Test
    void addOperationTests() {
        //easy cases
        checkBinaryOperations("2+2", "4");
        checkBinaryOperations("-3+-3", "-6");
        checkBinaryOperations("5.5+3.2", "8.7");
        checkBinaryOperations("-10.2+-7", "-17.2");
        checkBinaryOperations("7.4+-5.1", "2.3");
        checkBinaryOperations("1.e+5+1.e+8", "1.001e+8");
        checkBinaryOperations("1.e-20+5.e-20", "6.e-20");

        //cases with zero
        checkBinaryOperations("0+0", "0");
        checkBinaryOperations("2+0", "2");
        checkBinaryOperations("-3+0", "-3");
        checkBinaryOperations("5.5+0", "5.5");
        checkBinaryOperations("0+-7", "-7");
        checkBinaryOperations("0+-5.1", "-5.1");
        checkBinaryOperations("0+1.e+8", "1.e+8");

        //big numbers
        checkBinaryOperations("10000000000000000+10000000000000000", "2.e+16");
        checkBinaryOperations("5000000000000000+9999999999999999", "14999999999999999");
        checkBinaryOperations("1234567890987654321+1", "1234567890987654322");
        checkBinaryOperations("100000000000000000000000000+10",
                "1.0000000000000000000000001e+26");

        //with decimals
        checkBinaryOperations("10000000000000000+0.1", "10000000000000000.1");
        checkBinaryOperations("5000000000000000+0.9999999999999999",
                "5000000000000000.9999999999999999");
        checkBinaryOperations("1234567890987654321+123.123", "1234567890987654444.123");
        checkBinaryOperations("100000000000000000000000000+0.00000000000000000000000000001",
                "100000000000000000000000000.00000000000000000000000000001");

        //decimal and decimal
        checkBinaryOperations("0.0000000000001+0.1", "0.1000000000001");
        checkBinaryOperations("0.0000000000000001+0.9999999999999999", "1");
        checkBinaryOperations("1234567890.987654321+123.123", "1234568014.110654321");
        checkBinaryOperations("0.01+0.00000000000000000000000000001",
                "0.01000000000000000000000000001");

        //boundary
        checkBinaryOperations("8.e+9999+1.e+9999", "9.e+9999");
        checkBinaryOperations("9.e+9999+9.e+9998", "9.9e+9999");
        checkBinaryOperations("8.e-9999+1.e-9999", "9.e-9999");
        checkBinaryOperations("9.e-9999+9.e-9998", "9.9e-9998");

        checkBinaryOperations("-8.e+9999+-1.e+9999", "-9.e+9999");
        checkBinaryOperations("-9.e+9999+-9.e+9998", "-9.9e+9999");
        checkBinaryOperations("-8.e-9999+-1.e-9999", "-9.e-9999");
        checkBinaryOperations("-9.e-9999+-9.e-9998", "-9.9e-9998");

        //several random values
        checkBinaryOperations("197+8763", "8.96e+3");
        checkBinaryOperations("36346+62", "36408");

        checkBinaryOperations("62+-542", "-4.8e+2");
        checkBinaryOperations("7654+-62", "7592");

        checkBinaryOperations("-53252+-52", "-53304");
        checkBinaryOperations("-1243+-65", "-1308");

        checkBinaryOperations("623+124.123", "747.123");
        checkBinaryOperations("324+653.523", "977.523");

        checkBinaryOperations("7652+-23.598", "7628.402");
        checkBinaryOperations("2431+-123.124", "2307.876");

        checkBinaryOperations("-62+76.43", "14.43");
        checkBinaryOperations("-87+876.1", "789.1");

        checkBinaryOperations("-63+-0.234", "-63.234");
        checkBinaryOperations("-1967+-22.76", "-1989.76");

        checkBinaryOperations("53.14+51.65", "104.79");
        checkBinaryOperations("75.234+75.234", "150.468");

        checkBinaryOperations("64.26+-25.7", "38.56");
        checkBinaryOperations("623.3+-75.2", "548.1");

        checkBinaryOperations("-532.1+-2.2", "-534.3");
        checkBinaryOperations("-622.2+-25.6", "-647.8");
    }

    /**
     * Tests for the only subtract operation.
     */
    @Test
    void subtractOperationTests() {
        //easy cases
        checkBinaryOperations("2-2", "0");
        checkBinaryOperations("-3--3", "0");
        checkBinaryOperations("5.5-3.2", "2.3");
        checkBinaryOperations("-10.2--7", "-3.2");
        checkBinaryOperations("-5.1-7.4", "-12.5");
        checkBinaryOperations("1.e+8-1.e+5", "9.99e+7");
        checkBinaryOperations("5.e-20-1.e-20", "4.e-20");

        //cases with zero
        checkBinaryOperations("0-0", "0");
        checkBinaryOperations("2-0", "2");
        checkBinaryOperations("-3-0", "-3");
        checkBinaryOperations("5.5-0", "5.5");
        checkBinaryOperations("0--7", "7");
        checkBinaryOperations("0--5.1", "5.1");
        checkBinaryOperations("0-1.e+8", "-1.e+8");

        //big numbers
        checkBinaryOperations("10000000000000000-10000000000000000", "0");
        checkBinaryOperations("5000000000000000-9999999999999999", "-4999999999999999");
        checkBinaryOperations("1234567890987654321-1", "1.23456789098765432e+18");
        checkBinaryOperations("10-100000000000000000000000000",
                "-9.999999999999999999999999e+25");

        //with decimals
        checkBinaryOperations("10000000000000000-0.1", "9999999999999999.9");
        checkBinaryOperations("0.9999999999999999-5000000000000000",
                "-4999999999999999.0000000000000001");
        checkBinaryOperations("1234567890987654321-123.123", "1234567890987654197.877");
        checkBinaryOperations("100000000000000000000000000-0.00000000000000000000000000001",
                "99999999999999999999999999.99999999999999999999999999999");

        //decimal and decimal
        checkBinaryOperations("0.0000000000001-0.1", "-0.0999999999999");
        checkBinaryOperations("0.0000000000000001-0.9999999999999999", "-0.9999999999999998");
        checkBinaryOperations("1234567890.987654321-123.123", "1234567767.864654321");
        checkBinaryOperations("0.01-0.00000000000000000000000000001",
                "0.00999999999999999999999999999");

        //boundary
        checkBinaryOperations("8.e+9999--1.e+9999", "9.e+9999");
        checkBinaryOperations("-1.e+9999-8.e+9999", "-9.e+9999");

        checkBinaryOperations("9.e+9999--9.e+9998", "9.9e+9999");
        checkBinaryOperations("-9.e+9998-9.e+9999", "-9.9e+9999");

        checkBinaryOperations("8.e-9999--1.e-9999", "9.e-9999");
        checkBinaryOperations("-1.e-9999-8.e-9999", "-9.e-9999");

        checkBinaryOperations("9.e-9999--9.e-9998", "9.9e-9998");
        checkBinaryOperations("-9.e-9998-9.e-9999", "-9.9e-9998");

        //several random values (and vice versa)
        checkBinaryOperations("523-876", "-353");
        checkBinaryOperations("65-34", "31");

        checkBinaryOperations("724--652", "1376");
        checkBinaryOperations("-865-763", "-1628");

        checkBinaryOperations("-6521--41", "-6.48e+3");
        checkBinaryOperations("-7245--7624", "379");

        checkBinaryOperations("763-245.876", "517.124");
        checkBinaryOperations("123.87-9876", "-9752.13");

        checkBinaryOperations("6425--123.65", "6548.65");
        checkBinaryOperations("-12.65-987", "-999.65");

        checkBinaryOperations("-6-76.123", "-82.123");
        checkBinaryOperations("12.43--6543", "6555.43");

        checkBinaryOperations("-876--21.41", "-854.59");
        checkBinaryOperations("-12.21--987", "974.79");

        checkBinaryOperations("12.11-87.0765", "-74.9665");
        checkBinaryOperations("1111.09-123.66", "987.43");

        checkBinaryOperations("123.65--1.2", "124.85");
        checkBinaryOperations("-12.7-5.1", "-17.8");

        checkBinaryOperations("-0.112--3.2", "3.088");
        checkBinaryOperations("-1.224--9.1", "7.876");
    }

    /**
     * Tests for the only multiply operation.
     */
    @Test
    void multiplyOperationTests() {
        //easy cases
        checkBinaryOperations("2*2", "4");
        checkBinaryOperations("-3*-3", "9");
        checkBinaryOperations("5.5*3.2", "17.6");
        checkBinaryOperations("-10.2*-7", "71.4");
        checkBinaryOperations("7.4*-5.1", "-37.74");
        checkBinaryOperations("1.e+5*1.e+8", "1.e+13");
        checkBinaryOperations("1.e-20*5.e-20", "5.e-40");

        //cases with zero
        checkBinaryOperations("0*0", "0");
        checkBinaryOperations("2*0", "0");
        checkBinaryOperations("-3*0", "0");
        checkBinaryOperations("5.5*0", "0");
        checkBinaryOperations("0*-7", "0");
        checkBinaryOperations("0*-5.1", "0");
        checkBinaryOperations("0*1.e+8", "0");

        //big numbers
        checkBinaryOperations("10000000000000000*10000000000000000", "1.e+32");
        checkBinaryOperations("5000000000000000*9999999999999999", "4.9999999999999995e+31");
        checkBinaryOperations("1234567890987654321*1", "1234567890987654321");
        checkBinaryOperations("100000000000000000000000000*10", "1.e+27");

        //with decimals
        checkBinaryOperations("10000000000000000*0.1", "1.e+15");
        checkBinaryOperations("5000000000000000*0.9999999999999999", "4999999999999999.5");
        checkBinaryOperations("1234567890987654321*123.123", "152003702442072962964.483");
        checkBinaryOperations("100000000000000000000000000*0.00000000000000000000000000001",
                "0.001");

        //decimal and decimal
        checkBinaryOperations("0.0000000000001*0.1", "0.00000000000001");
        checkBinaryOperations("0.0000000000000001*0.9999999999999999",
                "0.00000000000000009999999999999999");
        checkBinaryOperations("1234567890.987654321*123.123", "152003702442.072962964483");
        checkBinaryOperations("0.01*0.00000000000000000000000000001",
                "0.0000000000000000000000000000001");

        //boundary
        checkBinaryOperations("4.5e+9999*2", "9.e+9999");
        checkBinaryOperations("9.e+9998*10", "9.e+9999");
        checkBinaryOperations("9.e-9998*0.1", "9.e-9999");
        checkBinaryOperations("4.5e-9999*2", "9.e-9999");

        checkBinaryOperations("-4.5e+9999*2", "-9.e+9999");
        checkBinaryOperations("9.e+9998*-10", "-9.e+9999");
        checkBinaryOperations("9.e-9998*-0.1", "-9.e-9999");
        checkBinaryOperations("-4.5e-9999*2", "-9.e-9999");

        //several random values
        checkBinaryOperations("41*13", "533");
        checkBinaryOperations("64*56", "3584");

        checkBinaryOperations("123*-13", "-1599");
        checkBinaryOperations("41*-65", "-2665");

        checkBinaryOperations("-876*-13", "11388");
        checkBinaryOperations("-54*-53", "2862");

        checkBinaryOperations("12*541.652", "6499.824");
        checkBinaryOperations("9*13.764", "123.876");

        checkBinaryOperations("132*-23.13", "-3053.16");
        checkBinaryOperations("12*-76.87", "-922.44");

        checkBinaryOperations("-65*65.13", "-4233.45");
        checkBinaryOperations("-76*75.123", "-5709.348");

        checkBinaryOperations("-13*-6.12", "79.56");
        checkBinaryOperations("-76*-13.5", "1026");

        checkBinaryOperations("33.12*6.13", "203.0256");
        checkBinaryOperations("86.7*5.132", "444.9444");

        checkBinaryOperations("1.75*-0.1", "-0.175");
        checkBinaryOperations("23.5*-6.87", "-161.445");

        checkBinaryOperations("-765.1*-1.8", "1377.18");
        checkBinaryOperations("-65.7*-7.8", "512.46");
    }

    /**
     * Tests for the only divide operation.
     */
    @Test
    void divideOperationTests() {
        //easy cases
        checkBinaryOperations("2/2", "1");
        checkBinaryOperations("-3/-3", "1");
        checkBinaryOperations("4/2", "2");
        checkBinaryOperations("-10.2/-102", "0.1");
        checkBinaryOperations("7.4/-0.5", "-14.8");
        checkBinaryOperations("-5.55/1.11", "-5");
        checkBinaryOperations("1.e+5/1.e+8", "0.001");
        checkBinaryOperations("1.e-20/5.e-20", "0.2");

        //cases with zero
        checkBinaryOperations("0/2", "0");
        checkBinaryOperations("0/-3", "0");
        checkBinaryOperations("0/5.5", "0");
        checkBinaryOperations("0/-7", "0");
        checkBinaryOperations("0/-5.1", "0");
        checkBinaryOperations("0/1.e+8", "0");

        //big numbers
        checkBinaryOperations("10000000000000000/-10000000000000000", "-1");
        checkBinaryOperations("8888888888888888/-4444444444444444", "-2");
        checkBinaryOperations("1234567890987654321/1", "1234567890987654321");
        checkBinaryOperations("100000000000000000000000000/10", "1.e+25");

        //with decimals
        checkBinaryOperations("10000000000000000/0.1", "1.e+17");
        checkBinaryOperations("9999999999999999/0.9999999999999999", "1.e+16");
        checkBinaryOperations("1234567890987654321/0.2", "6172839454938271605");
        checkBinaryOperations("100000000000000000000000000/0.00000000000000000000000000001",
                "1.e+55");

        //decimal and decimal
        checkBinaryOperations("0.0000000000001/0.1", "0.000000000001");
        checkBinaryOperations("-0.00000000000000008/-0.0000000000000001", "0.8");
        checkBinaryOperations("246.246/-123.123", "-2");
        checkBinaryOperations("-0.01/0.00000000000000000000000000001", "-1.e+27");

        //boundary
        checkBinaryOperations("1.e+9998/0.1", "1.e+9999");
        checkBinaryOperations("-0.1/1.e+9998", "-1.e-9999");

        checkBinaryOperations("9.e+9998/0.2", "4.5e+9999");
        checkBinaryOperations("0.2/-1.e+9998", "-2.e-9999");

        checkBinaryOperations("1.e-9998/10", "1.e-9999");
        checkBinaryOperations("-10/1.e-9998", "-1.e+9999");

        checkBinaryOperations("9.e-9998/20", "4.5e-9999");
        checkBinaryOperations("20/-1.e-9998", "-2.e+9999");

        //several random values
        checkBinaryOperations("24/12", "2");
        checkBinaryOperations("415/5", "83");

        checkBinaryOperations("123/-3", "-41");
        checkBinaryOperations("140/-7", "-2.e+1");

        checkBinaryOperations("-41/-41", "1");
        checkBinaryOperations("-651/-6", "108.5");

        checkBinaryOperations("504/2.52", "2.e+2");
        checkBinaryOperations("1001/10.01", "1.e+2");

        checkBinaryOperations("101/-1.01", "-1.e+2");
        checkBinaryOperations("88/-2.2", "-4.e+1");

        checkBinaryOperations("-5342/53.42", "-1.e+2");
        checkBinaryOperations("-100/0.05", "-2.e+3");

        checkBinaryOperations("-65/-6.5", "1.e+1");
        checkBinaryOperations("-123/-1.23", "1.e+2");

        checkBinaryOperations("555.555/555.555", "1");
        checkBinaryOperations("132.5/66.25", "2");

        checkBinaryOperations("65.65/-32.825", "-2");
        checkBinaryOperations("15.12/-0.3", "-50.4");

        checkBinaryOperations("-0.76/-0.001", "7.6e+2");
        checkBinaryOperations("-1061.5/-1.1", "965");
    }

    /**
     * Tests for equations that contains only binary operations.
     */
    @Test
    void severalBinaryOperations() {
        //integer numbers
        checkBinaryOperations("1+1+1", "3");
        checkBinaryOperations("10-2-2", "6");
        checkBinaryOperations("2*2*2", "8");
        checkBinaryOperations("125/5/5", "5");

        checkBinaryOperations("1000+1245-1455+123", "913");
        checkBinaryOperations("1014+14-28/100", "1.e+1");
        checkBinaryOperations("2*90/45+25-5", "24");
        checkBinaryOperations("125/5*55+12-9", "1378");

        //integer and decimal
        checkBinaryOperations("1.6+1+1", "3.6");
        checkBinaryOperations("10-2.7-2", "5.3");
        checkBinaryOperations("2*2*2.102", "8.408");
        checkBinaryOperations("125.5/5/0.251", "1.e+2");

        checkBinaryOperations("124.126+0.143-0.043*2+5", "253.452");
        checkBinaryOperations("132/2*0.4+1.2", "27.6");
        checkBinaryOperations("564.01-0.1+2.1*500-100", "282905");
        checkBinaryOperations("111*222/2.22*11.5", "1.2765e+5");

        //decimal numbers
        checkBinaryOperations("1.6+6.8+0.2", "8.6");
        checkBinaryOperations("50.5-0.1-0.4", "5.e+1");
        checkBinaryOperations("0.1*4.1*0.2", "0.082");
        checkBinaryOperations("0.1/0.01/0.001", "1.e+4");

        checkBinaryOperations("19481.312+312.124-123.14", "19670.296");
        checkBinaryOperations("777.777/7.77*1.111-5.4", "105.8111");
        checkBinaryOperations("123.123-1.1+1.2*5.2", "640.7596");
        checkBinaryOperations("100.001/0.0001*5.5-1231313.131313", "4268741.868687");

        //engineers
        checkBinaryOperations("1.e+120+5.e+120+7.e+120", "1.3e+121");
        checkBinaryOperations("5.e-6-1.e-6-1.e-2", "-0.009996");
        checkBinaryOperations("7.e+12*2.e+5*2.e-5", "2.8e+13");
        checkBinaryOperations("1.e-500/1.e+1000/1.e+500", "1.e-2000");

        checkBinaryOperations("1.6532e+13*1.41e+134-1.e+147", "1.331012e+147");
        checkBinaryOperations("1.11e-67/2.22e+67*1.e+131", "0.0005");
        checkBinaryOperations("1.67e+120-1.57e+120+1.e+120/5.e+100*2.e-5", "4.4e+14");
        checkBinaryOperations("1.e-50+1.e-100*1.e+50",
                "1.00000000000000000000000000000000000000000000000001");
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
        //the very boundary test case
        checkBinaryOverflowException("9999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
                "999999999999999999999+1");

        //add operation
        checkBinaryOverflowException("9.e+9999+9.e+9999");
        checkBinaryOverflowException("9.e+9999+1.e+9999");
        checkBinaryOverflowException("8.e+9999+2.e+9999");

        checkBinaryOverflowException("-9.e+9999+-9.e+9999");
        checkBinaryOverflowException("-9.e+9999+-1.e+9999");
        checkBinaryOverflowException("-8.e+9999+-2.e+9999");

        //subtract operation
        checkBinaryOverflowException("9.e+9999--9.e+9999");
        checkBinaryOverflowException("-9.e+9999-9.e+9999");

        checkBinaryOverflowException("9.e+9999--1.e+9999");
        checkBinaryOverflowException("-1.e+9999-9.e+9999");

        checkBinaryOverflowException("8.e+9999--2.e+9999");
        checkBinaryOverflowException("-2.e+9999-8.e+9999");

        checkBinaryOverflowException("-9.e+9999-9.e+9999");
        checkBinaryOverflowException("9.e+9999--9.e+9999");

        checkBinaryOverflowException("-9.e+9999-1.e+9999");
        checkBinaryOverflowException("1.e+9999--9.e+9999");

        checkBinaryOverflowException("-8.e+9999-2.e+9999");
        checkBinaryOverflowException("2.e+9999--8.e+9999");

        //multiply operation
        checkBinaryOverflowException("1.e+9999*-1.e+9999");
        checkBinaryOverflowException("1.e+9999*1.e+9999");

        checkBinaryOverflowException("1.e+9999*-10");
        checkBinaryOverflowException("1.e+9999*10");

        checkBinaryOverflowException("1.e+5000*-1.e+5000");
        checkBinaryOverflowException("1.e+5000*1.e+5000");

        checkBinaryOverflowException("-1.e+9999*-10");
        checkBinaryOverflowException("-1.e+9999*10");

        checkBinaryOverflowException("-1.e+9999*-1.e+9999");
        checkBinaryOverflowException("-1.e+9999*1.e+9999");

        checkBinaryOverflowException("-1.e+5000*-1.e+5000");
        checkBinaryOverflowException("-1.e+5000*1.e+5000");


        checkBinaryOverflowException("1.e-9999*-1.e-9999");
        checkBinaryOverflowException("1.e-9999*1.e-9999");

        checkBinaryOverflowException("1.e-9999*-0.1");
        checkBinaryOverflowException("1.e-9999*0.1");

        checkBinaryOverflowException("1.e-5000*-1.e-5000");
        checkBinaryOverflowException("1.e-5000*1.e-5000");

        checkBinaryOverflowException("-1.e-9999*-0.1");
        checkBinaryOverflowException("-1.e-9999*0.1");

        checkBinaryOverflowException("-1.e-9999*-1.e-9999");
        checkBinaryOverflowException("-1.e-9999*1.e-9999");

        checkBinaryOverflowException("-1.e-5000*-1.e-5000");
        checkBinaryOverflowException("-1.e-5000*1.e-5000");

        //divide operation
        checkBinaryOverflowException("1.e+9999/-1.e-9999");
        checkBinaryOverflowException("1.e+9999/1.e-9999");

        checkBinaryOverflowException("1.e+9999/-0.1");
        checkBinaryOverflowException("1.e+9999/0.1");

        checkBinaryOverflowException("1.e+5000/-1.e-5000");
        checkBinaryOverflowException("1.e+5000/1.e-5000");

        checkBinaryOverflowException("-1.e+9999/-1.e-9999");
        checkBinaryOverflowException("-1.e+9999/1.e-9999");

        checkBinaryOverflowException("-1.e+9999/-0.1");
        checkBinaryOverflowException("-1.e+9999/0.1");

        checkBinaryOverflowException("-1.e+5000/-1.e-5000");
        checkBinaryOverflowException("-1.e+5000/1.e-5000");


        checkBinaryOverflowException("1.e-9999/-1.e+9999");
        checkBinaryOverflowException("1.e-9999/1.e+9999");

        checkBinaryOverflowException("1.e-9999/-10");
        checkBinaryOverflowException("1.e-9999/10");

        checkBinaryOverflowException("1.e-5000/-1.e+5000");
        checkBinaryOverflowException("1.e-5000/1.e+5000");

        checkBinaryOverflowException("-1.e-9999/-1.e+9999");
        checkBinaryOverflowException("-1.e-9999/1.e+9999");

        checkBinaryOverflowException("-1.e-9999/-10");
        checkBinaryOverflowException("-1.e-9999/10");

        checkBinaryOverflowException("-1.e-5000/-1.e+5000");
        checkBinaryOverflowException("-1.e-5000/1.e+5000");
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
     * Method for testing {@link BinaryOperation} in {@link Calculation}.
     *
     * @param equation       equation that should be calculated. Should contain only numbers or operation symbols and
     *                       starts with number. Splitting numbers and operations is not necessary, but possible with
     *                       any number of spacings.
     *                       <p>
     *                       F.e., 2+2*2 will firstly calculate 2 + 2, and then the result will be multiplied on 2.
     *                       <p>
     *                       - 5 + 10 will cause an exception, but -5 + 10 will correctly calculate result (5).
     *                       <p>
     *                       4 * 2 4 will calculate 4 * 2 and then will multiply the result on 4 (final result is 32)
     *                       <p>
     *                       Passing several operations in a row will set the last passed operation (only if it is not -,
     *                       otherwise will be performed previous operation with negated next number).
     *                       <p>
     *                       3 +* 6 will calculate 3 * 6 (but 3 +-6 will calculate 3 + -6, as well as 3 + -6).
     * @param expectedResult result that should be obtained.
     */
    private void checkBinaryOperations(String equation, String expectedResult) {
        String[] args = splitEquation(equation);
        performTestCalculation(args);

        assertEquals(new BigDecimal(expectedResult), calculation.getResult());
    }

    /**
     * Splits equation to numbers and operations.
     *
     * @param equation equation to split.
     * @return array obtained after split operation.
     */
    private String[] splitEquation(String equation) {
        //saving characters
        equation = equation.replaceAll("e\\+", "ePlus");
        equation = equation.replaceAll("e-", "eMinus");
        equation = equation.replaceAll("^\\s*-", "neg");
        equation = equation.replaceAll("\\+\\s*-", "+neg");
        equation = equation.replaceAll("-\\s*-", "-neg");
        equation = equation.replaceAll("\\*\\s*-", "*neg");
        equation = equation.replaceAll("/\\s*-", "/neg");

        //replacing operations
        equation = equation.replaceAll("\\+", " + ");
        equation = equation.replaceAll("-", " - ");
        equation = equation.replaceAll("\\*", " * ");
        equation = equation.replaceAll("/", " / ");

        //returning saved characters
        equation = equation.replaceAll("ePlus", "e+");
        equation = equation.replaceAll("eMinus", "e-");
        equation = equation.replaceAll("neg", "-");

        return equation.split("\\s+");
    }

    /**
     * Performs calculation for tests.
     *
     * @param args numbers that should be set as second in {@link Calculation} (except the first number, that should be
     *             set as first) and {@link BinaryOperation}s that should be set as operation.
     *             <p>
     *             F.e., args = {"2", "+", "2"}. Method will firstly calculate 2 + 2, and then the result will be
     *             multiplied on 2.
     *             <p>
     *             args = {"-", "5", "+", "10"} will cause an exception, but args = {"-5", "+", "10"} will correctly
     *             calculate result (5).
     *             <p>
     *             args = {"3", "+*", "6"} will cause an exception, but args = {"3", "+", "*", "6"} will calculate 3 * 6.
     *             <p>
     *             args = {"4", "*", "2", "4"} will calculate 4 * 2 and then will multiply the result on 4 (final result
     *             is 32)
     */
    private void performTestCalculation(String[] args) {
        calculation.resetAll();
        calculation.setFirst(new BigDecimal(args[0]));

        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("+")) {
                calculation.setBinaryOperation(ADD);
            } else if (args[i].equals("-")) {
                calculation.setBinaryOperation(SUBTRACT);
            } else if (args[i].equals("*")) {
                calculation.setBinaryOperation(MULTIPLY);
            } else if (args[i].equals("/")) {
                calculation.setBinaryOperation(DIVIDE);
            } else if (args[i].matches(INTEGER_NUMBER_REGEX) || args[i].matches(DECIMAL_NUMBER_REGEX) ||
                    args[i].matches(ENGINEER_NUMBER_REGEX)) {
                calculation.setSecond(new BigDecimal(args[i]));
                calculation.calculateBinary();
                calculation.setFirst(calculation.getResult());
            } else {
                throw new IllegalArgumentException("Expected: binary operation or number. Got: " + args[i]);
            }
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
     * @param operation      {@link UnaryOperation} to use.
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
     * @param expectedResult result that should be obtained and set as result in {@link Calculation}.
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
     * @param expectedResult result that should be obtained and set as result in {@link Calculation}.
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
     * @param expectedResult result that should be obtained and set as result in {@link Calculation}.
     */
    private void checkPercentageOf100Operation(String second, String expectedResult) {
        checkPercentageOf100Operation(new BigDecimal(second), new BigDecimal(expectedResult));
    }

    /**
     * Method for testing percentage of 100 operation in {@link Calculation}.
     *
     * @param second         second number of equation.
     * @param expectedResult result that should be obtained and set as result in {@link Calculation}.
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
     * Method for testing throwing {@link OverflowException} while using binary operations.
     *
     * @param equation equation that should be calculated. Should contain only numbers or operation symbols and
     *                 starts with number. Splitting numbers and operations is not necessary, but possible with
     *                 any number of spacings. For the equation, an {@link OverflowException} should be thrown.
     *                 <p>
     *                 F.e., 2+2*2 will firstly calculate 2 + 2, and then the result will be multiplied on 2.
     *                 <p>
     *                 - 5 + 10 will cause an exception, but -5 + 10 will correctly calculate result (5).
     *                 <p>
     *                 4 * 2 4 will calculate 4 * 2 and then will multiply the result on 4 (final result is 32)
     *                 <p>
     *                 Passing several operations in a row will set the last passed operation (only if it is not -,
     *                 otherwise will be performed previous operation with negated next number).
     *                 <p>
     *                 3 +* 6 will calculate 3 * 6 (but 3 +-6 will calculate 3 + -6, as well as 3 + -6).
     */
    private void checkBinaryOverflowException(String equation) {
        String[] args = splitEquation(equation);

        try {
            performTestCalculation(args);
            fail();
        } catch (OverflowException e) {
            assertEquals(OVERFLOW_MESSAGE, e.getMessage());
        }
    }

    /**
     * Method for testing {@link OverflowException} while using {@code UnaryOperation.SQRT} in {@link Calculation}.
     * <p>
     * For inputted value, an {@link OverflowException} should be thrown.
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
     * For inputted values, an {@link OverflowException} should be thrown.
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