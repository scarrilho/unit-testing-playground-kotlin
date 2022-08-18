package tddbyexample

open class Money(protected val amount: Int) {
    override fun equals(other: Any?): Boolean =
        other is Money && other.amount == amount

    override fun hashCode(): Int {
        return amount
    }
}