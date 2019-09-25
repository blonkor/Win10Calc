package tests.model;

import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperation;
import com.implemica.bormashenko.calculator.model.exceptions.DivideByZeroException;
import com.implemica.bormashenko.calculator.model.exceptions.DivideZeroByZeroException;
import com.implemica.bormashenko.calculator.model.exceptions.NegativeRootException;
import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.*;
import static com.implemica.bormashenko.calculator.model.enums.UnaryOperation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class that contains demo test case to show how is {@link Calculation} works.
 *
 * @author Mykhailo Bormashenko
 */
class DemoTest {

    /**
     * Message for divide by zero exception.
     */
    private static final String DIVIDE_BY_ZERO_MESSAGE = "Cannot divide by zero";

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
     * Demo test case to show how is {@link Calculation} works.
     * <p>
     * The demo equation is: ((5 + 3) * 7 - 2) / 5.
     */
    @Test
    void demoCase() {
        //calculate (5 + 3)
        calculation.setFirst(new BigDecimal("5"));
        calculation.setSecond(new BigDecimal("3"));
        calculation.setBinaryOperation(ADD);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then multiply previous result on 7
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("7"));
        calculation.setBinaryOperation(MULTIPLY);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then subtract 2 from previous result
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("2"));
        calculation.setBinaryOperation(SUBTRACT);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then divide previous result by 5
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("5"));
        calculation.setBinaryOperation(DIVIDE);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //assert result
        assertEquals(new BigDecimal("10.8"), calculation.getResult());

        System.out.println(calculation.getResult());
    }

    /**
     * Demo test case to show how is {@link Calculation} works with unary operations.
     * <p>
     * The demo equation is: ((5² + (-3)) * 7 - (√4)) / ((1/5)²).
     */
    @Test
    void demoCaseForUnary() {
        //calculate (5²)
        calculation.setFirst(new BigDecimal("5"));
        try {
            calculation.calculateUnary(SQR);
        } catch (OverflowException | DivideByZeroException | NegativeRootException e) {
            fail();
        }

        //then set binary operation +.
        calculation.setBinaryOperation(ADD);

        //calculate (-3) and set it as second.
        // For not no loose previous result, set it as second before calculation.
        calculation.setSecond(calculation.getResult());
        calculation.setFirst(new BigDecimal("3"));

        try {
            calculation.calculateUnary(NEGATE);
        } catch (OverflowException | DivideByZeroException | NegativeRootException e) {
            fail();
        }

        calculation.setFirst(calculation.getSecond());
        calculation.setSecond(calculation.getResult());

        //then calculate (5² + (-3)) (binary operation is previously set).
        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then multiply previous result on 7.
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("7"));
        calculation.setBinaryOperation(MULTIPLY);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then set binary operation -.
        calculation.setBinaryOperation(SUBTRACT);

        //calculate (√4) and set it as second.
        // For not no loose previous result, set it as second before calculation.
        calculation.setSecond(calculation.getResult());
        calculation.setFirst(new BigDecimal("4"));

        try {
            calculation.calculateUnary(SQRT);
        } catch (OverflowException | DivideByZeroException | NegativeRootException e) {
            fail();
        }

        calculation.setFirst(calculation.getSecond());
        calculation.setSecond(calculation.getResult());

        //then subtract result of (√4) from result of ((5² + (-3)) * 7) (binary operation is previously set).

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }
        
        //then set binary operation /.
        calculation.setBinaryOperation(DIVIDE);

        //calculate ((1/5)²) and set it as second.
        // For not no loose previous result, set it as second before calculation.
        calculation.setSecond(calculation.getResult());
        calculation.setFirst(new BigDecimal("5"));

        try {
            calculation.calculateUnary(INVERSE);
        } catch (OverflowException | DivideByZeroException | NegativeRootException e) {
            fail();
        }

        calculation.setFirst(calculation.getResult());

        try {
            calculation.calculateUnary(SQR);
        } catch (OverflowException | DivideByZeroException | NegativeRootException e) {
            fail();
        }

        calculation.setFirst(calculation.getSecond());
        calculation.setSecond(calculation.getResult());

        //then divide result of ((5² + (-3)) * 7 - (√4)) by result of (1/5) (binary operation is previously set).
        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //assert result
        assertEquals(new BigDecimal("3.8e+3"), calculation.getResult());

        System.out.println(calculation.getResult());
    }

    /**
     * Demo test case to show how is {@link Calculation} works.
     * <p>
     * The demo equation is: ((5 + 3) * 7 - 2) / 0.
     */
    @Test
    void demoCaseForExceptions() {
        //calculate (5 + 3)
        calculation.setFirst(new BigDecimal("5"));
        calculation.setSecond(new BigDecimal("3"));
        calculation.setBinaryOperation(ADD);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then multiply previous result on 7
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("7"));
        calculation.setBinaryOperation(MULTIPLY);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then subtract 2 from previous result
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("2"));
        calculation.setBinaryOperation(SUBTRACT);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideByZeroException | DivideZeroByZeroException e) {
            fail();
        }

        //then divide previous result by 5
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("0"));
        calculation.setBinaryOperation(DIVIDE);

        try {
            calculation.calculateBinary();
        } catch (OverflowException | DivideZeroByZeroException e) {
            fail();
        } catch (DivideByZeroException e) {
            assertEquals(DIVIDE_BY_ZERO_MESSAGE, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
