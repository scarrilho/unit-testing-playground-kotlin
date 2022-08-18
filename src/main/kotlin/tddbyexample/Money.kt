package tddbyexample

abstract class Money(protected val amount: Int, protected val currency: String) {
    companion object {
        fun dollar(amount: Int): Dollar = Dollar(amount, "USD")
        fun franc(amount: Int): Franc = Franc(amount, "CHF")
    }

    abstract fun times(multiplier: Int): Money
    fun currency(): String = currency

    override fun equals(other: Any?): Boolean =
        other is Money && other.amount == amount

    override fun hashCode(): Int {
        return amount
    }
}