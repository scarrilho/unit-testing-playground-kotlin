package mocksarentstubs

class Order(private val product: String, private val quantity: Int) {
    var isFilled = false
        private set

    fun fill(warehouse: Warehouse) {
        val hasInventory = warehouse.hasInventory(product, quantity)

        isFilled =  if (hasInventory) {
            warehouse.remove(product, quantity)
            true
        } else {
            false
        }
    }
}