package com.implemica.bormashenko.calculator.model;

import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;
import com.implemica.bormashenko.calculator.model.util.OverflowValidation;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Model of memory for calculator.
 * <p>
 * Allows user to save values in memory, and to recall them later.
 *
 * @author Mykhailo Bormashenko
 */
public class Memory {

    /**
     * Store for memory's objects.
     */
    private Stack<BigDecimal> store = new Stack<>();

    /**
     * Returns copy of the store.
     *
     * @return copy of the store.
     */
    public Stack<BigDecimal> getStore() {
        Stack<BigDecimal> clone = new Stack<>();
        clone.addAll(store);

        return clone;
    }

    /**
     * Saves object in memory.
     *
     * @param number object to save.
     */
    public void storeToMemory(BigDecimal number) {
        store.push(number);
    }

    /**
     * Clears memory store.
     */
    public void clearMemory() {
        store.clear();
    }

    /**
     * Recalls last saved in memory object.
     *
     * @return last saved in memory object or null if store is empty.
     * @throws OverflowException while validation for recalled value is failed.
     */
    public BigDecimal recall() throws OverflowException {
        if (store.isEmpty()) {
            return null;
        } else {
            BigDecimal recalledValue = store.peek();

            if (OverflowValidation.overflowValidationFailed(recalledValue, false, BigDecimal.ZERO)) {
                throw new OverflowException();
            }

            return recalledValue;
        }
    }

    /**
     * Adds value to the last saved in memory object.
     * <p>
     * Result of adding will be set instead of current last passed to memory object.
     * If store is empty, this operation will save the value in the memory.
     *
     * @param number value to add to the last saved in memory object.
     */
    public void addToMemory(BigDecimal number) {
        if (store.isEmpty()) {
            storeToMemory(number);
        } else {
            BigDecimal memory = store.pop();
            store.push(memory.add(number).stripTrailingZeros());
        }
    }

    /**
     * Subtracts value from the last saved in memory object.
     * <p>
     * Result of subtracting will be set instead of current last passed to memory object.
     * If store is empty, this operation will save the negated value in the memory.
     *
     * @param number value to subtract from last saved in memory object.
     */
    public void subtractFromMemory(BigDecimal number) {
        if (store.isEmpty()) {
            storeToMemory(number.negate());
        } else {
            BigDecimal memory = store.pop();
            store.push(memory.subtract(number).stripTrailingZeros());
        }
    }
}
