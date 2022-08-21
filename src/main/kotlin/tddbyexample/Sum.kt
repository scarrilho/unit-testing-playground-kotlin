package tddbyexample

class Sum(var augend: Expression, var addend: Expression) : Expression {
    override fun reduce(bank: Bank, to: String): Money {
        val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
        return Money(amount, to)
    }

    override fun plus(addend: Expression): Expression {
        TODO("Not yet implemented")
    }

}