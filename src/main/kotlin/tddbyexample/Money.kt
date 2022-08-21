package tddbyexample

class Money(val amount: Int, private val currency: String): Expression {
    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }

    override fun equals(other: Any?): Boolean =
        other is Money && other.amount == amount && currency() == other.currency()

    override fun hashCode(): Int {
        return amount
    }
     override fun times(multiplier: Int): Expression {
         return Money(amount*multiplier, currency)
     }

     override fun plus(addend: Expression): Expression {
         return Sum(this, addend)
     }

    override fun reduce(bank: Bank, to: String): Money {
        val rate: Int = bank.rate(currency, to)
        return Money(amount/rate, to)
    }

    fun currency(): String = currency
}