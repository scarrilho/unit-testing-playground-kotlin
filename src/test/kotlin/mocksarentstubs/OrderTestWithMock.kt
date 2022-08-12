package mocksarentstubs

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class OrderTestWithMock {

    private val TALISKER = "Talisker"

    @Test
    fun testOrderIsFilledIfEnoughInWarehouse() {
        // Arrange
        val order = Order(TALISKER, 50)
        val warehouse = mockk<Warehouse>(relaxed = true)
        every { warehouse.hasInventory(TALISKER, 50) } returns true

        // Act
        order.fill(warehouse)

        // Assert
        assertTrue(order.isFilled)
        verify(exactly = 1) { warehouse.hasInventory(TALISKER, 50) }
        verify(exactly = 1) { warehouse.remove(TALISKER, 50) }

        verifyOrder {
            warehouse.hasInventory(TALISKER, 50)
            warehouse.remove(TALISKER, 50)
        }
    }

    @Test
    fun testOrderDoesNotRemoveIfNotEnough() {
        // Arrange
        val order = Order(TALISKER, 51)
        val warehouse = mockk<Warehouse>(relaxed = true)
        every { warehouse.hasInventory(any(), any()) } returns false

        // Act
        order.fill(warehouse)

        // Assert
        verify(exactly = 1) { warehouse.hasInventory(any(), any()) }
        verify(exactly = 0) { warehouse.remove(any(), any()) }
        assertFalse(order.isFilled)
    }
}