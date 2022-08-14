package khorikovunitestingpppbook

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CustomerTestWithMocks {

    @Test
    fun purchase_succeeds_when_enough_inventory() {
        // Arrange
        val storeMock = mockk<IStore>(relaxed = true)
        every { storeMock.hasEnoughInventory(Product.SHAMPOO, 5) } returns true
        val customer = Customer()

        // Act
        val success = customer.purchase(storeMock, Product.SHAMPOO, 5)

        // Assert
        assertTrue(success)
        verify(exactly = 1) { storeMock.removeInventory(Product.SHAMPOO, 5) }
    }

    @Test
    fun purchase_fails_when_not_enough_inventory() {
        // Arrange
        val storeMock = mockk<IStore>(relaxed = true)
        every { storeMock.hasEnoughInventory(Product.SHAMPOO, 5) } returns false
        val customer = Customer()

        // Act
        val success = customer.purchase(storeMock, Product.SHAMPOO, 5)

        // Assert
        assertFalse(success)
        verify(exactly = 0) { storeMock.removeInventory(any(), any()) }
    }
}