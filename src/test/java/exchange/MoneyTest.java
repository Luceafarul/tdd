package exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test void testDollarMultiplicationTwoTimes() {
        Money five = Money.dollar(5);
        assertAll(
            () -> assertEquals(Money.dollar(10), five.times(2)),
            () -> assertEquals(Money.dollar(15), five.times(3))
        );
    }

    @Test void testFrancMultiplicationTwoTimes() {
        Money five = Money.franc(5);
        assertAll(
            () -> assertEquals(Money.franc(10), five.times(2)),
            () -> assertEquals(Money.franc(15), five.times(3))
        );
    }

    @Test void testEquality() {
        assertAll(
            () -> assertEquals(Money.dollar(5), Money.dollar(5)),
            () -> assertNotEquals(Money.dollar(5), Money.dollar(7)),
            () -> assertEquals(Money.franc(5), Money.franc(5)),
            () -> assertNotEquals(Money.franc(5), Money.franc(7)),
            () -> assertNotEquals(Money.franc(5), Money.dollar(5))
        );
    }
}
