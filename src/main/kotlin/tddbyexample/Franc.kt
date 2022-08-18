package tddbyexample

class Franc(private val amount: Int) {
    fun times(multiplier: Int): Franc {
        return Franc(amount*multiplier)
    }

    // Unnecessary, but added to follow the book
    override fun equals(other: Any?): Boolean =
        other is Franc && other.amount == amount

    override fun hashCode(): Int {
        return amount
    }
}