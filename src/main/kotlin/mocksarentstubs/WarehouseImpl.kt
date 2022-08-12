package mocksarentstubs

class WarehouseImpl: Warehouse {
    private val inventory = hashMapOf<String, Int>()

    override fun add(product: String, quantity: Int) {
        inventory.putIfAbsent(product, quantity)
    }

    override fun getInventory(product: String): Int {
        return inventory.getOrDefault(product, 0)
    }

    override fun hasInventory(product: String, quantity: Int): Boolean {
        return inventory.getOrDefault(product, 0) >= quantity
    }

    override fun remove(product: String, quantity: Int) {
        if (!inventory.containsKey(product)) return

        val currentCount = inventory.getOrDefault(product, 0)

        if (quantity <= currentCount) {
            inventory[product] = currentCount - quantity
        }
    }
}