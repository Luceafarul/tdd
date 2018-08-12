package exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrancTest {
    @Test void testMultiplicationTwoTimes() {
        Franc five = new Franc(5);
        assertAll(
            () -> assertEquals(new Franc(10), five.times(2)),
            () -> assertEquals(new Franc(15), five.times(3))
        );
    }
}
