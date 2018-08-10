package exchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {
    @Test void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar ten = five.times(2);
        assertEquals(10, ten.amount);
    }

    @Test void testMultiplicationTwoTimes() {
        Dollar five = new Dollar(5);

        Dollar ten = five.times(2);
        Dollar fifteen = five.times(3);
        assertAll(
                () -> assertEquals(10, ten.amount),
                () -> assertEquals(15, fifteen.amount)
        );
    }

    @Test void testEquality() {
        assertAll(
                () -> assertEquals(new Dollar(5), new Dollar(5)),
                () -> assertNotEquals(new Dollar(5), new Dollar(7))
        );
    }


}
