package simplecalculator

interface Operation {
    fun add(first: Int, second: Int): Int
    fun subtract(first: Int, second: Int): Int
    fun multiply(first: Int, second: Int): Int
    fun divide(first: Int, second: Int): Int
}