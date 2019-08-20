package Model;

import com.implemica.bormashenko.calculator.model.Memory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MemoryModelTest {

    private static Memory memory;

    @BeforeAll
    static void setupObject() {
        memory = new Memory();
    }

    @Test
    void storeToMemoryTests() {
        //one
        checkOperationsWithStore(new BigDecimal[]{newBD("21314")});
        checkOperationsWithStore(new BigDecimal[]{newBD("123981742")});

        checkOperationsWithStore(new BigDecimal[]{newBD("-4126")});
        checkOperationsWithStore(new BigDecimal[]{newBD("-124718")});

        checkOperationsWithStore(new BigDecimal[]{newBD("5124.1236")});
        checkOperationsWithStore(new BigDecimal[]{newBD("64319.014")});

        checkOperationsWithStore(new BigDecimal[]{newBD("-5189.4154")});
        checkOperationsWithStore(new BigDecimal[]{newBD("-124.541")});

        //two
        checkOperationsWithStore(new BigDecimal[]{newBD("652"), newBD("6534")});
        checkOperationsWithStore(new BigDecimal[]{newBD("1246"), newBD("124")});

        checkOperationsWithStore(new BigDecimal[]{newBD("-6542"), newBD("3257")});
        checkOperationsWithStore(new BigDecimal[]{newBD("-7653"), newBD("651")});

        checkOperationsWithStore(new BigDecimal[]{newBD("653.234"), newBD("623")});
        checkOperationsWithStore(new BigDecimal[]{newBD("32.653"), newBD("234")});

        checkOperationsWithStore(new BigDecimal[]{newBD("-324.64"), newBD("736")});
        checkOperationsWithStore(new BigDecimal[]{newBD("-234.234"), newBD("235")});

        //more
        checkOperationsWithStore(new BigDecimal[]{newBD("765.3"), newBD("-23.56"), newBD("65363")});
        checkOperationsWithStore(new BigDecimal[]{newBD("1324"), newBD("-124"), newBD("652523.5")});

        checkOperationsWithStore(new BigDecimal[]{newBD("-436834"), newBD("7347357"),
                newBD("-2676856"), newBD("-34696")});
        checkOperationsWithStore(new BigDecimal[]{newBD("-436834"), newBD("3467643"),
                newBD("3468465"), newBD("34537.8")});

        checkOperationsWithStore(new BigDecimal[]{newBD("97.34578"), newBD("874245"),
                newBD("-0.95574"), newBD("-23564"), newBD("876.53366")});
        checkOperationsWithStore(new BigDecimal[]{newBD("97.748"), newBD("-4"),
                newBD("98.45"), newBD("235834.5"), newBD("-1375")});

        checkOperationsWithStore(new BigDecimal[]{newBD("-257245.2357"), newBD("9647"),
                newBD("235253"), newBD("-2625"), newBD("-237235"), newBD("876")});
        checkOperationsWithStore(new BigDecimal[]{newBD("-234.234"), newBD("235"),
                newBD("-235.67"), newBD("7345"), newBD("-23.525"), newBD("-21372.8")});
    }


    private void checkOperationsWithStore(BigDecimal[] values) {
        checkStoreToMemory(values);
        checkRecall(values[values.length - 1]);
        checkClearMemory();
    }

    private void checkStoreToMemory(BigDecimal[] values) {
        for (BigDecimal value : values) {
            memory.storeToMemory(value);
        }

        Object[] storage = memory.getStore().toArray();

        if (storage.length == values.length) {
            for (int i = 0; i < storage.length; i++) {
                assertEquals(values[i], storage[i]);
            }
        } else {
            fail();
        }
    }

    private void checkRecall(BigDecimal expectedRecalledValue) {
        assertEquals(expectedRecalledValue, memory.recall());
    }

    private void checkClearMemory() {
        memory.clearMemory();
        assertTrue(memory.getStore().isEmpty());
    }

    private BigDecimal newBD(String number) {
        return new BigDecimal(number);
    }
}
