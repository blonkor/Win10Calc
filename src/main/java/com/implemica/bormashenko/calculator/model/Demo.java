package com.implemica.bormashenko.calculator.model;

import com.implemica.bormashenko.calculator.model.exceptions.DivideByZeroException;
import com.implemica.bormashenko.calculator.model.exceptions.DivideZeroByZeroException;
import com.implemica.bormashenko.calculator.model.exceptions.NegativeRootException;
import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;

import java.math.BigDecimal;

import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.*;
import static com.implemica.bormashenko.calculator.model.enums.BinaryOperation.DIVIDE;
import static com.implemica.bormashenko.calculator.model.enums.UnaryOperation.*;

/**
 * Demonstration of how to work with model.
 *
 * @author Mykhailo Bormashenko
 */
public class Demo {

    /**
     * Shows how model works.
     * Demo equation is ((a² + (-b)) * c - (√d)) / (1/e)²
     *
     * @param args command line args.
     * @throws OverflowException         if overflow exception was thrown during calculation.
     * @throws NegativeRootException     if negative root exception was thrown during calculation.
     * @throws DivideByZeroException     if divide by zero exception was thrown during calculation.
     * @throws DivideZeroByZeroException if divide zero by zero exception was thrown during calculation.
     */
    public static void main(String... args) throws OverflowException, NegativeRootException, DivideByZeroException,
            DivideZeroByZeroException {

        Calculation calculation = new Calculation();
        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("3");
        BigDecimal c = new BigDecimal("7");
        BigDecimal d = new BigDecimal("4");
        BigDecimal e = new BigDecimal("5");

        //calculate (a²) and set it as first.
        calculation.calculateUnary(a, SQR);
        calculation.setFirst(calculation.getResult());

        System.out.println("Result of previous operation: " + calculation.getResult());

        //calculate (-b) and set it as second.
        calculation.calculateUnary(b, NEGATE);
        calculation.setSecond(calculation.getResult());

        System.out.println("Result of previous operation: " + calculation.getResult());

        //then calculate (a² + (-b))
        calculation.setBinaryOperation(ADD);
        calculation.calculateBinary();

        System.out.println("Result of previous operation: " + calculation.getResult());

        //then multiply previous result on c
        calculation.setFirst(calculation.getResult());
        calculation.setSecond(c);
        calculation.setBinaryOperation(MULTIPLY);
        calculation.calculateBinary();

        System.out.println("Result of previous operation: " + calculation.getResult());

        //set previous result as first, calculate (√d) and set it as second.
        calculation.setFirst(calculation.getResult());
        calculation.calculateUnary(d, SQRT);
        calculation.setSecond(calculation.getResult());

        System.out.println("Result of previous operation: " + calculation.getResult());

        //then subtract result of (√d) from result of ((a² + (-b)) * c).
        calculation.setBinaryOperation(SUBTRACT);
        calculation.calculateBinary();

        System.out.println("Result of previous operation: " + calculation.getResult());

        //set previous result as first, calculate ((1/e)²) and set it as second.
        calculation.setFirst(calculation.getResult());
        calculation.calculateUnary(e, INVERSE);
        calculation.calculateUnary(calculation.getResult(), SQR);
        calculation.setSecond(calculation.getResult());

        System.out.println("Result of previous operation: " + calculation.getResult());

        calculation.setFirst(BigDecimal.ONE);
        calculation.setSecond(BigDecimal.ZERO);
        //then divide result of ((a² + (-b)) * c - (√d)) by result of (1/e)².
        calculation.setBinaryOperation(DIVIDE);
        calculation.calculateBinary();

        System.out.println("Result of previous operation: " + calculation.getResult());
    }
}

