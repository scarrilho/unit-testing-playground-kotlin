package tddbyexample

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class MultiCurrencyTest {
    @Test
    fun testMultiplication() {
        // Given
        val five: Money = Money.dollar(5)

        // Then
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5))
        assertNotEquals(Money.dollar(5), Money.dollar(6))
        assertNotEquals(Money.franc(5), Money.dollar(5))
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum: Expression = five.plus(five)
        val bank = Bank()

        val reduced: Money = bank.reduce(sum, "USD")

        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun testPlusReturnsSum() {
        val five = Money.dollar(5)

        val result: Expression = five.plus(five)
        val sum: Sum = result as Sum

        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }

    @Test
    fun testReduceSum() {
        val sum: Expression = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()

        val result: Money = bank.reduce(sum, "USD")

        assertEquals(Money.dollar(7), result)
    }

    @Test
    fun testReduceMoney() {
        val bank = Bank()
        val result: Money = bank.reduce(Money.dollar(1), "USD")

        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")

        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testPairEquals() {
        assertEquals(Pair("abc", "DEF"), Pair("abc", "DEF"))
        assertNotEquals(Pair("abc", "def"), Pair("abc", "DEF"))
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

    @Test
    fun testMixedAddition() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank = Bank()

        bank.addRate("CHF", "USD", 2)
        val money: Money = bank.reduce(fiveBucks.plus(tenFrancs), "USD")

        //assertEquals(10, money.amount)
        assertEquals(Money.dollar(10), money)

    }
}