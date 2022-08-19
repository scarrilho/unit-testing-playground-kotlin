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
}