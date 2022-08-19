package tddbyexample

class Money(private val amount: Int, private val currency: String): Expression {
    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
     fun times(multiplier: Int): Money {
         return Money(amount*multiplier, currency)
     }
    fun currency(): String = currency

     fun plus(addend: Money): Expression {
         return Money(addend.amount + amount, currency)
     }

    override fun equals(other: Any?): Boolean =
        other is Money && other.amount == amount && currency() == other.currency()

     override fun hashCode(): Int {
        return amount
    }
}