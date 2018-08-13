package exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {
    @Test void testMultiplicationTwoTimes() {
        Dollar five = new Dollar(5);
        assertAll(
            () -> assertEquals(new Dollar(10), five.times(2)),
            () -> assertEquals(new Dollar(15), five.times(3))
        );
    }

    @Test void testEquality() {
        assertAll(
            () -> assertEquals(new Dollar(5), new Dollar(5)),
            () -> assertNotEquals(new Dollar(5), new Dollar(7))
        );
    }
}
