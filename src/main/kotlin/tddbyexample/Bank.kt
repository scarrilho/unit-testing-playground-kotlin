package tddbyexample

class Bank {
    private val rates = hashMapOf<Pair, Int>()
    fun reduce(source: Expression, to: String): Money {
        return source.reduce(this, to)
    }

    fun rate(from: String, to: String): Int {
        return if (from == to) {
            1
        } else {
            rates[Pair(from, to)]!! // using !! for now
        }
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates[Pair(from, to)] = rate
    }
}