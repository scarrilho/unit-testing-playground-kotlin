package tddbyexample

class Dollar(private val amount: Int) {

    fun times(multiplier: Int): Dollar {
        return Dollar(amount*multiplier)
    }

    // Unnecessary, but added to follow the book
    override fun equals(other: Any?): Boolean =
        other is Dollar && other.amount == amount

    override fun hashCode(): Int {
        return amount
    }
}