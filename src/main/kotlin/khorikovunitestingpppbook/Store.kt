package khorikovunitestingpppbook

class Store: IStore {
    private val inventory = hashMapOf<Product, Int>()

    override fun addInventory(product: Product, quantity: Int) {
        inventory.putIfAbsent(product, quantity)
    }

    override fun getInventory(product: Product): Int {
        return inventory.getOrDefault(product, 0)
    }

    override fun hasEnoughInventory(product: Product, quantity: Int): Boolean {
        return inventory.getOrDefault(product, 0) >= quantity
    }

    override fun removeInventory(product: Product, quantity: Int) {
        if (!inventory.containsKey(product)) return

        val currentCount = inventory.getOrDefault(product, 0)

        if (quantity <= currentCount) {
            inventory[product] = currentCount - quantity
        }
    }
}