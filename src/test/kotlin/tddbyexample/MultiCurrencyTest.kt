package tddbyexample

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class MultiCurrencyTest {
    @Test
    fun testMultiplication() {
        // Given
        val five = Dollar(5)

        // When
        var product = five.times(2)

        // Then
        assertEquals(10, product.amount)

        product = five.times(3)
        assertEquals(15, product.amount)
    }

    @Test
    fun testEquality() {
        assertEquals(Dollar(5), Dollar(5))
        assertNotEquals(Dollar(5), Dollar(6))
    }
}