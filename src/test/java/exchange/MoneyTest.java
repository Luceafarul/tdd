package exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test void testDollarMultiplicationTwoTimes() {
        Dollar five = new Dollar(5);
        assertAll(
            () -> assertEquals(new Dollar(10), five.times(2)),
            () -> assertEquals(new Dollar(15), five.times(3))
        );
    }

    @Test void testFrancMultiplicationTwoTimes() {
        Franc five = new Franc(5);
        assertAll(
            () -> assertEquals(new Franc(10), five.times(2)),
            () -> assertEquals(new Franc(15), five.times(3))
        );
    }

    @Test void testEquality() {
        assertAll(
            () -> assertEquals(new Dollar(5), new Dollar(5)),
            () -> assertNotEquals(new Dollar(5), new Dollar(7)),
            () -> assertEquals(new Franc(5), new Franc(5)),
            () -> assertNotEquals(new Franc(5), new Franc(7)),
            () -> assertNotEquals(new Franc(5), new Dollar(5))
        );
    }
}
