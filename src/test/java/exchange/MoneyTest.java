package exchange;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    private Expression fiveDollars;
    private Expression tenFrancs;
    private Bank bank;

    @BeforeEach void setUp() {
        fiveDollars = Money.dollar(5);
        tenFrancs = Money.franc(10);
        bank = new Bank();
        bank.addRate("CHF", "USD", 2);
    }

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
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(24), result);
    }

    @Test void testSumPlusMoney() {
        Expression sum = new Sum(fiveDollars, tenFrancs).plus(tenFrancs);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test void testSumTimes() {
        Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    @Test void testReduceMoney() {
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test void testReduceMoneyWithDifferentCurrency() {
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test void testMixedAddition() {
        Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
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
