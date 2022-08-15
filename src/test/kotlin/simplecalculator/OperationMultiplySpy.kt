package simplecalculator

class OperationMultiplySpy: Operation {
    var multiplyCallsCount = 0

    override fun add(first: Int, second: Int): Int {
        TODO("Not yet implemented")
    }

    override fun subtract(first: Int, second: Int): Int {
        TODO("Not yet implemented")
    }

    override fun multiply(first: Int, second: Int): Int {
        multiplyCallsCount += 1
        return first * second
    }

    override fun divide(first: Int, second: Int): Int {
        TODO("Not yet implemented")
    }
}