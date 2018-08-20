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

    @Test void testSimpleAddition() {
        Money ten = Money.dollar(10);
        Expression sum = ten.plus(ten);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), reduced);
    }

    @Test void testPlusReturnsSum() {
        Money ten = Money.dollar(10);
        Expression result = ten.plus(ten);
        Sum sum = (Sum) result;
        assertEquals(ten, sum.augend);
        assertEquals(ten, sum.addend);
    }

    @Test void testReduceSum() {
        Expression sum = new Sum(Money.dollar(13), Money.dollar(11));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(24), result);
    }

    @Test void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test void testEquality() {
        assertAll(
            () -> assertEquals(Money.dollar(5), Money.dollar(5)),
            () -> assertNotEquals(Money.dollar(5), Money.dollar(7)),
            () -> assertNotEquals(Money.franc(5), Money.dollar(5))
        );
    }

    @Test void testCurrency() {
        assertAll(
            () -> assertEquals("USD", Money.dollar(1).currency()),
            () -> assertEquals("CHF", Money.franc(1).currency())
        );
    }
}
