package mocksarentstubs

import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class OrderTestClassic {

    lateinit var warehouse: Warehouse

    private val TALISKER = "Talisker"
    private val HIGHLAND_PARK = "Highland Park"

    @BeforeEach
    fun setUp() {
        warehouse = WarehouseImpl()
        warehouse.add(TALISKER, 50)
        warehouse.add(HIGHLAND_PARK, 25)
    }

    @Test
    fun testOrderIsFilledIfEnoughInWarehouse() {
        // Arrange
        val order = Order(TALISKER, 50)

        // Act
        order.fill(warehouse)

        // Assert
        assertTrue(order.isFilled)
        assertEquals(0, warehouse.getInventory(TALISKER))
    }

    @Test
    fun testOrderDoesNotRemoveIfNotEnough() {
        // Arrange
        val order = Order(TALISKER, 51)

        // Act
        order.fill(warehouse)

        // Assert
        assertFalse(order.isFilled)
        assertEquals(50, warehouse.getInventory(TALISKER))
    }
}