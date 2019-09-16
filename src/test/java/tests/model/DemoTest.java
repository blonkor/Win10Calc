package tests.model;

import com.implemica.bormashenko.calculator.model.Calculation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.*;
import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.DIVIDE;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        calculation.calculateBinary();

        //then multiply previous result on 7
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("7"));
        calculation.setBinaryOperation(MULTIPLY);
        calculation.calculateBinary();

        //then subtract 2 from previous result
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("2"));
        calculation.setBinaryOperation(SUBTRACT);
        calculation.calculateBinary();

        //then divide previous result by 5
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(new BigDecimal("5"));
        calculation.setBinaryOperation(DIVIDE);
        calculation.calculateBinary();

        //assert result
        assertEquals(new BigDecimal("10.8"), calculation.getResult());

        System.out.println(calculation.getResult());
    }
}
