package tddbyexample

class Sum(var augend: Money, var addend: Money) : Expression {
    override fun reduce(bank: Bank, to: String): Money {
        val amount = augend.amount + addend.amount
        return Money(amount, to)
    }

}