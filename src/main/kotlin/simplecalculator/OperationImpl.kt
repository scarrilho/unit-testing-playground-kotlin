package simplecalculator

class OperationImpl: Operation {
    override fun add(first: Int, second: Int): Int = first + second
    override fun subtract(first: Int, second: Int): Int = first - second
    override fun multiply(first: Int, second: Int): Int = first * second
    override fun divide(first: Int, second: Int): Int = first / second
}