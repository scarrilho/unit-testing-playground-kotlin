package tddbyexample

abstract class Money(protected val amount: Int) {
    abstract fun times(multiplier: Int): Money
    companion object {
        fun dollar(amount: Int): Dollar = Dollar(amount)
        fun franc(amount: Int): Franc = Franc(amount)
    }
    override fun equals(other: Any?): Boolean =
        other is Money && other.amount == amount

    override fun hashCode(): Int {
        return amount
    }
}