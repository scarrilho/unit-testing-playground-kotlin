package mocksarentstubs

interface Warehouse {
    fun add(product: String, quantity: Int)
    fun getInventory(product: String): Int
    fun hasInventory(product: String, quantity: Int): Boolean
    fun remove(product: String, quantity: Int)

}