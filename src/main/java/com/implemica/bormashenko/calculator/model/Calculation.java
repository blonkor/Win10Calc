package com.implemica.bormashenko.calculator.model;

import com.implemica.bormashenko.calculator.model.enums.BinaryOperation;
import com.implemica.bormashenko.calculator.model.enums.UnaryOperation;
import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * This class contains model of how the calculator works.
 *
 * @author Mykhailo Bormashenko
 */
public class Calculation {

    /**
     * Message for divide zero by zero {@link ArithmeticException}.
     */
    private static final String DIVIDE_ZERO_BY_ZERO_MESSAGE = "Result is undefined";

    /**
     * Message for divide by zero {@link ArithmeticException}.
     */
    private static final String DIVIDE_BY_ZERO_MESSAGE = "Cannot divide by zero";

    /**
     * Message for invalid input {@link ArithmeticException}.
     */
    private static final String INVALID_INPUT_MESSAGE = "Invalid input";

    /**
     * Scale for {@code BinaryOperation.DIVIDE}.
     *
     * @see BinaryOperation
     */
    private static final int DIVIDE_SCALE = 10000;

    /**
     * MathContext for {@code UnaryOperation.SQRT}.
     *
     * @see UnaryOperation
     */
    private static final MathContext SQRT_CONTEXT = MathContext.DECIMAL64;

    /**
     * Bound for maximal value.
     * <p>
     * If this bound reached, {@link OverflowException} should be thrown.
     */
    private static final BigDecimal MAX_INTEGER_VALUE = new BigDecimal("1.e+10000");

    /**
     * Bound for minimal value.
     * <p>
     * If this bound reached, {@link OverflowException} should be thrown.
     */
    private static final BigDecimal MIN_DECIMAL_VALUE = new BigDecimal("1.e-10000");

    /**
     * Max possible scale for number.
     *
     * If scale is bigger, {@link OverflowException} should be thrown.
     */
    private static final int MAX_SCALE = 9999;

    /**
     * {@code BigDecimal} value of 0.5.
     */
    private static final BigDecimal ONE_HALF = new BigDecimal("0.5");

    /**
     * {@code BigDecimal} value of 100.
     */
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    /**
     * First number of equation.
     */
    private BigDecimal first = BigDecimal.ZERO;

    /**
     * Second number of equation.
     */
    private BigDecimal second = BigDecimal.ZERO;

    /**
     * Result of equation.
     */
    private BigDecimal result = BigDecimal.ZERO;

    /**
     * {@link BinaryOperation} of equation.
     */
    private BinaryOperation binaryOperation;

    public void setFirst(BigDecimal first) {
        this.first = first;
    }

    public BigDecimal getFirst() {
        return first;
    }

    public void setSecond(BigDecimal second) {
        this.second = second;
    }

    public BigDecimal getSecond() {
        return second;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setBinaryOperation(BinaryOperation binaryOperation) {
        this.binaryOperation = binaryOperation;
    }

    public BinaryOperation getBinaryOperation() {
        return binaryOperation;
    }

    /**
     * Resets all fields to theirs primary state.
     */
    public void resetAll() {
        first = BigDecimal.ZERO;
        second = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        binaryOperation = null;
    }

    /**
     * Calculates result using first value, {@link BinaryOperation} and second value.
     *
     * @throws OverflowException while validation for result is failed.
     */
    public void calculateBinary() {
        if (binaryOperation == BinaryOperation.ADD) {
            result = add();
        } else if (binaryOperation == BinaryOperation.SUBTRACT) {
            result = subtract();
        } else if (binaryOperation == BinaryOperation.MULTIPLY) {
            result = multiply();
        } else if (binaryOperation == BinaryOperation.DIVIDE) {
            result = divide();
        }

        result = result.stripTrailingZeros();

        if (overflowValidationFailed(result, binaryOperation == BinaryOperation.DIVIDE)) {
            throw new OverflowException();
        }
    }

    /**
     * Calculates result using first value and {@link UnaryOperation}.
     *
     * @param unaryOperation operation to perform.
     * @throws OverflowException while validation for result is failed.
     */
    public void calculateUnary(UnaryOperation unaryOperation) {
        if (unaryOperation == UnaryOperation.NEGATE) {
            result = negate();
        } else if (unaryOperation == UnaryOperation.SQR) {
            result = sqr();
        } else if (unaryOperation == UnaryOperation.SQRT) {
            result = sqrt();
        } else if (unaryOperation == UnaryOperation.INVERSE) {
            result = inverse();
        }

        result = result.stripTrailingZeros();

        if (overflowValidationFailed(result, false)) {
            throw new OverflowException();
        }
    }

    /**
     * Calculates second number as a percentage of first number if current {@code BinaryOperation} is
     * {@code BinaryOperation.ADD} or {@code BinaryOperation.SUBTRACT}, or as a percentage of 100 if current
     * {@code BinaryOperation} is {@code BinaryOperation.MULTIPLY} or {@code BinaryOperation.DIVIDE}
     *
     * @throws OverflowException while validation for result is failed.
     */
    public void calculatePercentage() {
        if (binaryOperation == null) {
            resetAll();
        } else if (binaryOperation == BinaryOperation.ADD || binaryOperation == BinaryOperation.SUBTRACT) {
            result = percentageOfFirst();
        } else if (binaryOperation == BinaryOperation.MULTIPLY || binaryOperation == BinaryOperation.DIVIDE) {
            result = percentageOf100();
        }

        result = result.stripTrailingZeros();

        if (overflowValidationFailed(result, false)) {
            throw new OverflowException();
        }
    }

    /**
     * Checks that number in range ({@code MAX_INTEGER_VALUE}, {@code MAX_INTEGER_VALUE}).
     *
     * @param value big decimal value to check.
     * @return true if validation failed or false otherwise.
     */
    boolean overflowValidationFailed(BigDecimal value, boolean divide) {
        if (divide && !first.equals(BigDecimal.ZERO) && value.equals(BigDecimal.ZERO)) {
            return true;
        }

        return value.abs().compareTo(MAX_INTEGER_VALUE) >= 0 ||
                (value.abs().compareTo(MIN_DECIMAL_VALUE) <= 0 && !value.equals(BigDecimal.ZERO));
    }

    /**
     * Adds first number to second.
     *
     * @return result of adding two numbers.
     */
    private BigDecimal add() {
        return first.add(second);
    }

    /**
     * Subtracts second value from first.
     *
     * @return result of subtracting one number from another.
     */
    private BigDecimal subtract() {
        return first.subtract(second);
    }

    /**
     * Multiplies first number and second.
     *
     * @return result of multiplying two numbers.
     */
    private BigDecimal multiply() {
        return first.multiply(second);
    }

    /**
     * Divides first number on second.
     *
     * @return result of dividing one number on another.
     * @throws ArithmeticException while second number is 0.
     */
    private BigDecimal divide() {
        if (first.equals(BigDecimal.ZERO) && !second.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }

        if (second.equals(BigDecimal.ZERO)) {

            if (first.equals(BigDecimal.ZERO)) {
                throw new ArithmeticException(DIVIDE_ZERO_BY_ZERO_MESSAGE);
            }

            throw new ArithmeticException(DIVIDE_BY_ZERO_MESSAGE);
        }

        return first.divide(second, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Calculates negated first number.
     *
     * @return negated first number.
     */
    private BigDecimal negate() {
        return first.negate();
    }

    /**
     * Calculates square of first number.
     *
     * @return square of first number.
     */
    private BigDecimal sqr() {
        return first.multiply(first);
    }

    /**
     * Calculates square root of first number.
     * <p>
     * This method is almost copied from JDK.9 src.
     * All additional information You can find at
     * {@link = "https://docs.oracle.com/javase/9/docs/api/java/math/BigDecimal.html#sqrt-java.math.MathContext-"}
     *
     * @return square root of first number.
     * @throws ArithmeticException while first value is negative.
     */
    private BigDecimal sqrt() {
        int signum = first.signum();

        if (signum < 0) {
            throw new ArithmeticException(INVALID_INPUT_MESSAGE);
        }

        if (signum == 0) {
            return BigDecimal.ZERO;
        }

        int preferredScale = first.scale() / 2;
        BigDecimal zeroWithFinalPreferredScale = BigDecimal.valueOf(0L, preferredScale);
        BigDecimal stripped = first.stripTrailingZeros();
        int strippedScale = stripped.scale();

        if (stripped.unscaledValue().equals(BigInteger.ONE) &&
                strippedScale % 2 == 0) {
            BigDecimal result = BigDecimal.valueOf(1L, strippedScale / 2);

            if (result.scale() != preferredScale) {
                result = result.add(zeroWithFinalPreferredScale, SQRT_CONTEXT);
            }

            return result;
        }

        int scaleAdjust;
        int scale = stripped.scale() - stripped.precision() + 1;

        if (scale % 2 == 0) {
            scaleAdjust = scale;
        } else {
            scaleAdjust = scale - 1;
        }

        BigDecimal working = stripped.scaleByPowerOfTen(scaleAdjust);

        BigDecimal guess = new BigDecimal(Math.sqrt(working.doubleValue()));
        int guessPrecision = 15;
        int originalPrecision = SQRT_CONTEXT.getPrecision();

        BigDecimal approx = guess;
        int workingPrecision = working.precision();

        do {
            int tmpPrecision = Math.max(Math.max(guessPrecision, originalPrecision + 2), workingPrecision);
            MathContext mcTmp = new MathContext(tmpPrecision, RoundingMode.HALF_EVEN);
            approx = ONE_HALF.multiply(approx.add(working.divide(approx, mcTmp), mcTmp));
            guessPrecision *= 2;
        } while (guessPrecision < originalPrecision + 2);

        BigDecimal result;
        result = approx.scaleByPowerOfTen(-scaleAdjust / 2).round(SQRT_CONTEXT);

        if (result.scale() != preferredScale) {
            result = result.stripTrailingZeros().
                    add(zeroWithFinalPreferredScale,
                            new MathContext(originalPrecision, RoundingMode.UNNECESSARY));
        }

        return result;
    }

    /**
     * Calculates inverted first number.
     *
     * @return inverted first number.
     * @throws ArithmeticException while first number is 0.
     */
    private BigDecimal inverse() {
        if (first.equals(BigDecimal.ZERO)) {
            throw new ArithmeticException(DIVIDE_BY_ZERO_MESSAGE);
        }

        return BigDecimal.ONE.divide(first, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Calculates second number as a percentage of the first.
     *
     * @throws OverflowException while validation for second value is failed.
     */
    private BigDecimal percentageOfFirst() {
        if (second.scale() + first.scale() > MAX_SCALE) {
            throw new OverflowException();
        }

        return first.multiply(second).divide(ONE_HUNDRED, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
    }

    /**
     * Calculates second number as a percentage of 100.
     *
     * @throws OverflowException while validation for second number is failed.
     */
    private BigDecimal percentageOf100() {
        if (second.scale() - ONE_HUNDRED.stripTrailingZeros().scale() > MAX_SCALE) {
            throw new OverflowException();
        }

        return second.divide(ONE_HUNDRED, DIVIDE_SCALE, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
    }
}
