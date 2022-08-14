package khorikovunitestingpppbook

class Customer() {
    fun purchase(store: IStore, product: Product, quantity: Int): Boolean {
        val hasInventory = store.hasEnoughInventory(product, quantity)

        val isSuccess =  if (hasInventory) {
            store.removeInventory(product, quantity)
            true
        } else {
            false
        }

        return isSuccess
    }
}