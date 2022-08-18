package tddbyexample

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class MultiCurrencyTest {
    @Test
    fun testMultiplication() {
        // Given
        val five = Dollar(5)

        // Then
        assertEquals(Dollar(10), five.times(2))
        assertEquals(Dollar(15), five.times(3))
    }

    @Test
    fun testEquality() {
        assertEquals(Dollar(5), Dollar(5))
        assertNotEquals(Dollar(5), Dollar(6))
        assertEquals(Franc(5), Franc(5))
        assertNotEquals(Franc(5), Franc(6))
        assertEquals(Franc(5) as Money, Dollar(5) as Money)
    }

    @Test
    fun testFrancMultiplication() {
        // Given
        val five = Franc(5)

        // Then
        assertEquals(Franc(10), five.times(2))
        assertEquals(Franc(15), five.times(3))
    }
}