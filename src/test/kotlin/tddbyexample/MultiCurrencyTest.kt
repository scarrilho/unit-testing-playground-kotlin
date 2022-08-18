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
        assertEquals(Money.franc(5), Money.franc(5))
        assertNotEquals(Money.franc(5), Money.franc(6))
        assertEquals(Franc(5) as Money, Money.dollar(5) as Money)
    }

    @Test
    fun testFrancMultiplication() {
        // Given
        val five = Money.franc(5)

        // Then
        assertEquals(Money.franc(10), five.times(2))
        assertEquals(Money.franc(15), five.times(3))
    }
}