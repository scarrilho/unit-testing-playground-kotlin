package khorikovunitestingpppbook

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CustomerTestClassic {

    @Test
    fun purchase_succeeds_when_enough_inventory() {
        // Arrange
        val store = Store()
        store.addInventory(Product.SHAMPOO, 10)
        val customer = Customer()

        // Act
        val success = customer.purchase(store, Product.SHAMPOO, 5)

        // Assert
        assertTrue(success)
        assertEquals(5, store.getInventory(Product.SHAMPOO))
    }

    @Test
    fun purchase_fails_when_not_enough_inventory() {
        // Arrange
        val store = Store()
        store.addInventory(Product.SHAMPOO, 10)
        val customer = Customer()

        // Act
        val success = customer.purchase(store, Product.SHAMPOO, 15)

        // Assert
        assertFalse(success)
        assertEquals(10, store.getInventory(Product.SHAMPOO))
    }
}