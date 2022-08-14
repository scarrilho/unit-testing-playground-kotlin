package khorikovunitestingpppbook

interface IStore {
    fun addInventory(product: Product, quantity: Int)
    fun getInventory(product: Product): Int
    fun hasEnoughInventory(product: Product, quantity: Int): Boolean
    fun removeInventory(product: Product, quantity: Int)
}