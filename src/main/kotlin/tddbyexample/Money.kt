package tddbyexample

 open class Money(protected val amount: Int, protected val currency: String) {
    companion object {
        fun dollar(amount: Int): Dollar = Dollar(amount, "USD")
        fun franc(amount: Int): Franc = Franc(amount, "CHF")
    }
     fun times(multiplier: Int): Money {
         return Money(amount*multiplier, currency)
     }
    fun currency(): String = currency

    override fun equals(other: Any?): Boolean =
        other is Money && other.amount == amount && currency() == other.currency()

     override fun hashCode(): Int {
        return amount
    }
}