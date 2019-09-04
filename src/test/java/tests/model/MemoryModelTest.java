package tests.model;

import com.implemica.bormashenko.calculator.model.Memory;
import com.implemica.bormashenko.calculator.model.exceptions.OverflowException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link Memory}.
 *
 * @author Mykhailo Bormashenko
 */
class MemoryModelTest {

    /**
     * Exception message for {@link OverflowException}.
     */
    private static final String OVERFLOW_MESSAGE = "Overflow";

    /**
     * Object of {@code Memory}.
     */
    private static Memory memory;

    /**
     * Tests for operations with store.
     * <p>
     * Includes next operations:
     * store to memory;
     * recall from memory;
     * clear memory;
     * add to empty memory;
     * subtract from empty memory.
     */
    @Test
    void operationsWithStoreTests() {
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
        checkOperationsWithStore(new BigDecimal[]{newBD("765.3"), newBD("-23.56"),
                newBD("65363")});
        checkOperationsWithStore(new BigDecimal[]{newBD("1324"), newBD("-124"),
                newBD("652523.5")});

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

    /**
     * Tests for add to memory operation.
     */
    @Test
    void addToMemoryTests() {
        //one
        checkAddToMemory(new BigDecimal[]{newBD("642")},
                newBD("5"), newBD("647"));
        checkAddToMemory(new BigDecimal[]{newBD("-987")},
                newBD("13"), newBD("-974"));
        checkAddToMemory(new BigDecimal[]{newBD("123.74213")},
                newBD("76"), newBD("199.74213"));
        checkAddToMemory(new BigDecimal[]{newBD("-724.8743")},
                newBD("1325"), newBD("600.1257"));

        checkAddToMemory(new BigDecimal[]{newBD("762")},
                newBD("-6"), newBD("756"));
        checkAddToMemory(new BigDecimal[]{newBD("-246.246")},
                newBD("-12"), newBD("-258.246"));
        checkAddToMemory(new BigDecimal[]{newBD("2466")},
                newBD("-75"), newBD("2391"));
        checkAddToMemory(new BigDecimal[]{newBD("-23.25")},
                newBD("-134"), newBD("-157.25"));

        checkAddToMemory(new BigDecimal[]{newBD("765147")},
                newBD("764.234"), newBD("765911.234"));
        checkAddToMemory(new BigDecimal[]{newBD("-2575")},
                newBD("243.87"), newBD("-2331.13"));
        checkAddToMemory(new BigDecimal[]{newBD("246.234")},
                newBD("987.2475"), newBD("1233.4815"));
        checkAddToMemory(new BigDecimal[]{newBD("-865.24")},
                newBD("275.23"), newBD("-590.01"));

        checkAddToMemory(new BigDecimal[]{newBD("7536")},
                newBD("-24380.904"), newBD("-16844.904"));
        checkAddToMemory(new BigDecimal[]{newBD("-21346")},
                newBD("-246.83"), newBD("-21592.83"));
        checkAddToMemory(new BigDecimal[]{newBD("752.2345")},
                newBD("-765432.234"), newBD("-764679.9995"));
        checkAddToMemory(new BigDecimal[]{newBD("-76.2576")},
                newBD("-243.75324"), newBD("-320.01084"));

        //two
        checkAddToMemory(new BigDecimal[]{newBD("243"), newBD("7654")},
                newBD("65"), newBD("7719"));
        checkAddToMemory(new BigDecimal[]{newBD("-765"), newBD("97")},
                newBD("-234"), newBD("-137"));
        checkAddToMemory(new BigDecimal[]{newBD("234.7652"), newBD("324")},
                newBD("652.243"), newBD("976.243"));
        checkAddToMemory(new BigDecimal[]{newBD("-765.234"), newBD("765")},
                newBD("-234.75"), newBD("530.25"));

        checkAddToMemory(new BigDecimal[]{newBD("234"), newBD("-234")},
                newBD("8652"), newBD("8418"));
        checkAddToMemory(new BigDecimal[]{newBD("-765"), newBD("-876")},
                newBD("-234"), newBD("-1.11e+3"));
        checkAddToMemory(new BigDecimal[]{newBD("246.2437"), newBD("-24")},
                newBD("9876.234"), newBD("9852.234"));
        checkAddToMemory(new BigDecimal[]{newBD("-234.876"), newBD("-765")},
                newBD("-234.86"), newBD("-999.86"));

        checkAddToMemory(new BigDecimal[]{newBD("2375"), newBD("76.234")},
                newBD("243"), newBD("319.234"));
        checkAddToMemory(new BigDecimal[]{newBD("-2347"), newBD("243.87")},
                newBD("-876"), newBD("-632.13"));
        checkAddToMemory(new BigDecimal[]{newBD("876.234"), newBD("234.908")},
                newBD("723.823"), newBD("958.731"));
        checkAddToMemory(new BigDecimal[]{newBD("-237.8765"), newBD("2432.65")},
                newBD("-324.765"), newBD("2107.885"));

        checkAddToMemory(new BigDecimal[]{newBD("423"), newBD("-47654.25")},
                newBD("0"), newBD("-47654.25"));
        checkAddToMemory(new BigDecimal[]{newBD("-876"), newBD("-75.4")},
                newBD("-85"), newBD("-160.4"));
        checkAddToMemory(new BigDecimal[]{newBD("234.2347"), newBD("-234.2")},
                newBD("234.987"), newBD("0.787"));
        checkAddToMemory(new BigDecimal[]{newBD("-987.1237"), newBD("-0.123465")},
                newBD("-86.234"), newBD("-86.357465"));

        //more
        checkAddToMemory(new BigDecimal[]{newBD("12376"), newBD("876542"), newBD("146")},
                newBD("6324"), newBD("6.47e+3"));
        checkAddToMemory(new BigDecimal[]{newBD("243567"), newBD("1236"), newBD("8724")},
                newBD("6324"), newBD("15048"));

        checkAddToMemory(new BigDecimal[]{newBD("123641327"), newBD("1472"),
                        newBD("654315"), newBD("1265423")},
                newBD("2346754"), newBD("3612177"));
        checkAddToMemory(new BigDecimal[]{newBD("127443"), newBD("1245765"),
                        newBD("3468465"), newBD("345312")},
                newBD("6324"), newBD("351636"));

        checkAddToMemory(new BigDecimal[]{newBD("97.34578"), newBD("874245"),
                        newBD("1234655434"), newBD("1233564"), newBD("871234366")},
                newBD("6324"), newBD("8.7124069e+8"));
        checkAddToMemory(new BigDecimal[]{newBD("921358"), newBD("1234556"),
                        newBD("98.45"), newBD("235834.5"), newBD("126375")},
                newBD("6324"), newBD("132699"));

        checkAddToMemory(new BigDecimal[]{newBD("1232557"), newBD("9647"), newBD("235253"),
                        newBD("145625"), newBD("123235"), newBD("876")},
                newBD("6324"), newBD("7.2e+3"));
        checkAddToMemory(new BigDecimal[]{newBD("12344"), newBD("235"), newBD("12467"),
                        newBD("7345"), newBD("1534214"), newBD("12351438")},
                newBD("6324"), newBD("12357762"));
    }

    /**
     * Tests for subtract from memory operation.
     */
    @Test
    void subtractFromMemoryTests() {
        //one
        checkSubtractFromMemory(new BigDecimal[]{newBD("76523")},
                newBD("1234"), newBD("75289"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-2134")},
                newBD("123"), newBD("-2257"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("653.13512")},
                newBD("541"), newBD("112.13512"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-21365.1236")},
                newBD("12353"), newBD("-33718.1236"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("862")},
                newBD("-1367"), newBD("2229"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-9882.1487")},
                newBD("-5327"), newBD("-4555.1487"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("86287")},
                newBD("-3426"), newBD("89713"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-72.98")},
                newBD("-10"), newBD("-62.98"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("1237")},
                newBD("763.3674"), newBD("473.6326"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-1238762")},
                newBD("6234.1237"), newBD("-1244996.1237"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("1123.7654")},
                newBD("1365.13267"), newBD("-241.36727"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-1367.1247")},
                newBD("12375.1365"), newBD("-13742.2612"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("123567")},
                newBD("-11.23"), newBD("123578.23"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-1235")},
                newBD("-121.56"), newBD("-1113.44"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("132.000008756")},
                newBD("-0.123"), newBD("132.123008756"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-123.09")},
                newBD("-0.1"), newBD("-122.99"));

        //two
        checkSubtractFromMemory(new BigDecimal[]{newBD("0"), newBD("1237")},
                newBD("13"), newBD("1224"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-765"), newBD("21387")},
                newBD("-2136"), newBD("23523"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("87.09"), newBD("2436")},
                newBD("1.65"), newBD("2434.35"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-0.3"), newBD("0")},
                newBD("-12.1"), newBD("12.1"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("765"), newBD("-316")},
                newBD("0"), newBD("-316"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-1237"), newBD("-98")},
                newBD("-234"), newBD("136"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("3.98"), newBD("-6")},
                newBD("213.65"), newBD("-219.65"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-2476.876"), newBD("-2411")},
                newBD("-123.56"), newBD("-2287.44"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("78"), newBD("12.35")},
                newBD("78"), newBD("-65.65"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-13"), newBD("3.7")},
                newBD("-8"), newBD("11.7"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("123.75"), newBD("1437.75")},
                newBD("135.1237"), newBD("1302.6263"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-6237.12"), newBD("7.12")},
                newBD("-6.12"), newBD("13.24"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("65"), newBD("-123.5")},
                newBD("4.5"), newBD("-128"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-36"), newBD("-15.74")},
                newBD("-42"), newBD("26.26"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("367.1237"), newBD("-87.123")},
                newBD("12345.2135"), newBD("-12432.3365"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("-7614.213"), newBD("-67.08")},
                newBD("-9.2"), newBD("-57.88"));

        //more
        checkSubtractFromMemory(new BigDecimal[]{newBD("2"), newBD("2"), newBD("2")},
                newBD("1"), newBD("1"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("56"), newBD("78"), newBD("137")},
                newBD("782"), newBD("-645"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("56332"), newBD("12375"),
                        newBD("12367"), newBD("12437")},
                newBD("12345"), newBD("92"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("123"), newBD("456"),
                        newBD("789"), newBD("101112")},
                newBD("131415"), newBD("-30303"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("213.412"), newBD("54"),
                        newBD("1235"), newBD("765"), newBD("132")},
                newBD("752"), newBD("-6.2e+2"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("6321"), newBD("765421"),
                        newBD("98.45"), newBD("235834.5"), newBD("890")},
                newBD("10000"), newBD("-9.11e+3"));

        checkSubtractFromMemory(new BigDecimal[]{newBD("1398"), newBD("84"), newBD("808"),
                        newBD("12364"), newBD("1236"), newBD("1470")},
                newBD("13275"), newBD("-11805"));
        checkSubtractFromMemory(new BigDecimal[]{newBD("1367"), newBD("890"), newBD("2135"),
                        newBD("12376"), newBD("1456"), newBD("1390")},
                newBD("13"), newBD("1377"));
    }

    /**
     * Tests for recall from memory operation while memory is empty.
     */
    @Test
    void recallFromEmptyMemory() {
        memory = new Memory();
        assertNull(memory.recall());

        memory.addToMemory(newBD("545"));
        memory.clearMemory();

        assertNull(memory.recall());
    }

    /**
     * Tests for recall from memory operation while this operation should cause {@code OverflowException}.
     */
    @Test
    void recallOverflowExceptionTests() {
        //one
        checkRecallOverflowException(new BigDecimal[]{newBD("1.e+10001")});
        checkRecallOverflowException(new BigDecimal[]{newBD("1.e+10000")});

        checkRecallOverflowException(new BigDecimal[]{newBD("-1.e+10000")});
        checkRecallOverflowException(new BigDecimal[]{newBD("-1.e+10001")});

        checkRecallOverflowException(new BigDecimal[]{newBD("1.e-10001")});
        checkRecallOverflowException(new BigDecimal[]{newBD("1.e-10000")});

        checkRecallOverflowException(new BigDecimal[]{newBD("-1.e-10000")});
        checkRecallOverflowException(new BigDecimal[]{newBD("-1.e-10001")});

        //two
        checkRecallOverflowException(new BigDecimal[]{newBD("13563"), newBD("1.e+10001")});
        checkRecallOverflowException(new BigDecimal[]{newBD("-1235"), newBD("1.e+10000")});

        checkRecallOverflowException(new BigDecimal[]{newBD("-43653"), newBD("-1.e+10000")});
        checkRecallOverflowException(new BigDecimal[]{newBD("6256"), newBD("-1.e+10001")});

        checkRecallOverflowException(new BigDecimal[]{newBD("123456"), newBD("1.e-10001")});
        checkRecallOverflowException(new BigDecimal[]{newBD("0.9521"), newBD("1.e-10000")});

        checkRecallOverflowException(new BigDecimal[]{newBD("-9876.345"), newBD("-1.e-10000")});
        checkRecallOverflowException(new BigDecimal[]{newBD("748"), newBD("-1.e-10001")});

        //more
        checkRecallOverflowException(new BigDecimal[]{newBD("-76.53"), newBD("-1452"),
                newBD("1.e+10001")});
        checkRecallOverflowException(new BigDecimal[]{newBD("23456"), newBD("-12456"),
                newBD("1.e+10000")});

        checkRecallOverflowException(new BigDecimal[]{newBD("-8765"), newBD("2536"),
                newBD("-1436"), newBD("-1.e+10000")});
        checkRecallOverflowException(new BigDecimal[]{newBD("-1237.65"), newBD("-312.5"),
                newBD("7635"), newBD("-1.e+10001")});

        checkRecallOverflowException(new BigDecimal[]{newBD("123562"), newBD("-1145762"),
                newBD("-6.511"), newBD("7653"), newBD("1.e-10001")});
        checkRecallOverflowException(new BigDecimal[]{newBD("-6324"), newBD("21.351"),
                newBD("65213"), newBD("-23446.6642"), newBD("1.e-10000")});

        checkRecallOverflowException(new BigDecimal[]{newBD("653.21"), newBD("543.25"),
                newBD("-123154"), newBD("1351"), newBD("-6541.123"),
                newBD("-1.e-10000")});
        checkRecallOverflowException(new BigDecimal[]{newBD("132511"), newBD("-7653"),
                newBD("-1243.5"), newBD("0.12314"), newBD("653.14"),
                newBD("-1.e-10001")});
    }

    /**
     * Method for testing operations with store.
     * <p>
     * Includes next operations:
     * store to memory;
     * recall from memory;
     * clear memory;
     * add to empty memory;
     * subtract from empty memory.
     *
     * @param values at least one {@code BigDecimal} object that should be saved in memory. If there are more
     *               than one object, they should be saved in memory in the same order that they are stored in
     *               array. With this objects all operation will be performed.
     */
    private void checkOperationsWithStore(BigDecimal[] values) {
        memory = new Memory();

        checkStoreToMemory(values);
        checkRecall(values[values.length - 1]);
        checkClearMemory();
        checkAddToEmptyMemory(values[0]);
        checkSubtractFromEmptyMemory(values[0]);
    }

    /**
     * Method for testing store to memory operation.
     *
     * @param values at least one {@code BigDecimal} object that should be saved in memory. If there are more
     *               than one object, they should be saved in memory in the same order that they are stored in
     *               array. With this objects all operation will be performed.
     */
    private void checkStoreToMemory(BigDecimal[] values) {
        storeValuesToMemory(values);

        Object[] storage = memory.getStore().toArray();

        if (storage.length == values.length) {
            for (int i = 0; i < storage.length; i++) {
                assertEquals(values[i], storage[i]);
            }
        } else {
            fail();
        }
    }

    /**
     * Method for saving objects in memory's store.
     *
     * @param values at least one {@code BigDecimal} object that should be saved in memory. If there are more
     *               than one object, they should be saved in memory in the same order that they are stored in
     *               array. With this objects all operation will be performed.
     */
    private void storeValuesToMemory(BigDecimal[] values) {
        for (BigDecimal value : values) {
            memory.storeToMemory(value);
        }
    }

    /**
     * Method for testing recall from memory operation.
     *
     * @param expectedRecalledValue as {@code Stack} used as memory store, the last saved in memory
     *                              object should be returned while recall operation is performed.
     */
    private void checkRecall(BigDecimal expectedRecalledValue) {
        assertEquals(expectedRecalledValue, memory.recall());
    }

    /**
     * Method for testing clear memory operation.
     * <p>
     * After performing this operation, memory should be empty.
     */
    private void checkClearMemory() {
        memory.clearMemory();
        assertTrue(memory.getStore().isEmpty());
    }

    /**
     * Method for testing add to memory operation while memory store is empty.
     * <p>
     * While memory store is empty, this operation is similar to memory store operation.
     *
     * @param valueToAdd {@code BidDecimal} object that should be added to empty memory.
     */
    private void checkAddToEmptyMemory(BigDecimal valueToAdd) {
        memory = new Memory();

        memory.addToMemory(valueToAdd);
        Object[] storage = memory.getStore().toArray();

        assertEquals(valueToAdd, storage[0]);
    }

    /**
     * Method for testing subtract from memory operation while memory store is empty.
     * <p>
     * While memory store is empty, this operation is similar to memory store operation.
     *
     * @param valueToSubtract {@code BidDecimal} object that should be subtract from empty memory.
     */
    private void checkSubtractFromEmptyMemory(BigDecimal valueToSubtract) {
        memory = new Memory();

        memory.subtractFromMemory(valueToSubtract);
        Object[] storage = memory.getStore().toArray();

        assertEquals(valueToSubtract.negate(), storage[0]);
    }

    /**
     * Method for testing add to memory operation while memory store is not empty.
     *
     * @param values             at least one {@code BidDecimal} object that should be saved in memory. If there
     *                           are more than one object, they should be saved in memory in the same order that
     *                           they are stored in array.
     * @param valueToAdd         {@code BigDecimal} object that should be added to the last saved in memory object.
     * @param expectedFirstValue expected first value in memory store after performing add to memory operation.
     *                           Note that there is {@code Stack} used as memory store, so the last saved in memory
     *                           store object is the object with which the add to memory operation should be performed.
     */
    private void checkAddToMemory(BigDecimal[] values, BigDecimal valueToAdd, BigDecimal expectedFirstValue) {
        memory = new Memory();

        storeValuesToMemory(values);
        memory.addToMemory(valueToAdd);

        Object[] storage = memory.getStore().toArray();

        assertEquals(expectedFirstValue, storage[storage.length - 1]);
    }

    /**
     * Method for testing subtract from memory operation while memory store is not empty.
     *
     * @param values             at least one {@code BidDecimal} object that should be saved in memory. If there are
     *                           more than one object, they should be saved in memory in the same order that
     *                           they are stored in array.
     * @param valueToAdd         {@code BidDecimal} object that should be subtracted from non-empty memory.
     * @param expectedFirstValue expected last value in memory store after performing subtract from memory operation.
     *                           Note that there is {@code Stack} used as memory store, so the last saved in memory
     *                           store object is the object with which the subtract from memory operation should be
     *                           performed.
     */
    private void checkSubtractFromMemory(BigDecimal[] values, BigDecimal valueToAdd, BigDecimal expectedFirstValue) {
        memory = new Memory();

        storeValuesToMemory(values);
        memory.subtractFromMemory(valueToAdd);

        Object[] storage = memory.getStore().toArray();

        assertEquals(expectedFirstValue, storage[storage.length - 1]);
    }

    /**
     * Method for testing exception for recall from memory operation.
     *
     * @param values as {@code Stack} used as memory store, the last saved in memory object should throw
     *               {@code OverflowException} while recall operation is performed.
     * @see OverflowException
     */
    private void checkRecallOverflowException(BigDecimal[] values) {
        memory = new Memory();
        storeValuesToMemory(values);

        try {
            memory.recall();
            fail();
        } catch (OverflowException e) {
            assertEquals(OVERFLOW_MESSAGE, e.getMessage());
        }
    }

    /**
     * Creates new {@code BidDecimal} object.
     *
     * @param number string representation of {@code BidDecimal}.
     * @return {@code BidDecimal} object created from string.
     */
    private BigDecimal newBD(String number) {
        return new BigDecimal(number);
    }
}
