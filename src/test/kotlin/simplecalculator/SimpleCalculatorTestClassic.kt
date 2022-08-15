package simplecalculator

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SimpleCalculatorTestClassic {

    @Test
    fun calculate_addInts_returnCorrectResult() { // Value based test
        // Arrange
        val operation = OperationImpl()
        val calculator = SimpleCalculator(operation)

        // Act
        val result = calculator.calculate(1, 1, "+")

        // Assert
        assertEquals(2, result)
    }

    @Test
    fun getCount_successfulOperationFirstTime_countIsOne() { // State based test
        // Arrange
        val operation = OperationImpl()
        val calculator = SimpleCalculator(operation)

        // Act
        calculator.calculate(1, 1, "+")
        val finalCount = calculator.getCount()

        // Assert
        assertEquals(1, finalCount)
    }

    @Test
    fun reset_resetWhenCountIsThree_countIsZero() { // State based test
        // Arrange
        val operation = OperationImpl()
        val calculator = SimpleCalculator(operation)

        calculator.calculate(1, 1, "+")
        calculator.calculate(2, 1, "-")
        calculator.calculate(1, 1, "*")

        val initialCount = calculator.getCount()

        // Act
        calculator.reset()
        val finalCount = calculator.getCount()

        // Assert
        assertEquals(3, initialCount)
        assertEquals(0, finalCount)
    }

}