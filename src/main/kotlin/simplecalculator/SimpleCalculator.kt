package simplecalculator

class SimpleCalculator(private val operation: Operation) {
    private var successfulOperationsCount = 0

    fun calculate(firstNum: Int, secondNum: Int, operator: String): Int? {
        val result = when (operator) {
            "+" -> operation.add(firstNum, secondNum)
            "-" -> operation.subtract(firstNum, secondNum)
            "*" -> operation.multiply(firstNum, secondNum)
            "/" -> operation.divide(firstNum, secondNum)
            else -> null
        }

        if (null != result) {
            successfulOperationsCount += 1
        }

        return result
    }

    fun getCount(): Int = successfulOperationsCount

    fun reset() {
        successfulOperationsCount = 0
    }
}
