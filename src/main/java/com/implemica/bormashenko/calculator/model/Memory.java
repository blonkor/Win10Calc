package com.implemica.bormashenko.calculator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Model of memory.
 *
 * @author Mykhailo Bormashenko
 */
public class Memory {

    private Stack<BigDecimal> store = new Stack<>();

    public Stack<BigDecimal> getStore() {
        return store;
    }

    public void storeToMemory(BigDecimal number) {
        store.push(number);
    }

    public void clearMemory() {
        store.clear();
    }

    public BigDecimal recall() {
        return store.peek();
    }

    public void addToMemory(BigDecimal number) {
        if (store.isEmpty()) {
            storeToMemory(number);
        } else {
            BigDecimal memory = store.pop();
            store.push(memory.add(number));
        }
    }

    public void subtractFromMemory(BigDecimal number) {
        if (store.isEmpty()) {
            storeToMemory(number);
        } else {
            BigDecimal memory = store.pop();
            store.push(memory.subtract(number));
        }
    }


}
