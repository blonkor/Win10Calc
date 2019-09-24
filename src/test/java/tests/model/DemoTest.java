package tests.model;

import com.implemica.bormashenko.calculator.model.Calculation;
import com.implemica.bormashenko.calculator.model.exceptions.DivideByZeroException;
import com.implemica.bormashenko.calculator.model.exceptions.DivideZeroByZeroException;
import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.*;
import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.DIVIDE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class that contains demo test case to show how is {@link Calculation} works.
 *
 * @author Mykhailo Bormashenko
 */
class DemoTest {

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
}
