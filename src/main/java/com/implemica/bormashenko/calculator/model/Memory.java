package com.implemica.bormashenko.calculator.model;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Model of memory.
 *
 * @author Mykhailo Bormashenko
 */
public class Memory {

    /**
     * Store for memory's objects.
     */
    private Stack<BigDecimal> store = new Stack<>();

    public Stack<BigDecimal> getStore() {
        return store;
    }

    /**
     * Passes object to memory.
     * @param number object to pass.
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
     * Recalls last passed to memory object.
     * @return last passed to memory object or null if store is empty.
     */
    public BigDecimal recall() {
        if (!store.isEmpty()) {
            return store.peek();
        } else {
            return null;
        }
    }

    /**
     * Adds value to last passed to memory. Result of adding will be set instead of
     * current last passed to memory object.
     * If store is empty, this operation is similar to store to memory operation.
     * @param number value to add to last passed to memory.
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
     * Subtracts value from last passed to memory. Result of subtracting will be set instead of
     * current last passed to memory object.
     * If store is empty, this operation is similar to store to memory operation.
     * @param number value to subtract from last passed to memory.
     */
    public void subtractFromMemory(BigDecimal number) {
        if (store.isEmpty()) {
            storeToMemory(number);
        } else {
            BigDecimal memory = store.pop();
            store.push(memory.subtract(number).stripTrailingZeros());
        }
    }
}
