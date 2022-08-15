package simplecalculator

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SimpleCalculatorTestWithMock {

    @Test
    fun calculate_addInts_confirmCallToAdd() { // InteractionTesting with isolation framework
        // Arrange
        val operationMock = mockk<Operation>(relaxed = true)
        val calculator = SimpleCalculator(operationMock)

        // Act
        calculator.calculate(1, 1, "+")

        // Assert
        verify(exactly = 1) { operationMock.add(any(), any()) }
    }

    @Test
    fun calculate_multiplyInts_confirmCallToMultiply() { // InteractionTesting with spy
        // Arrange
        val operationMultiplySpy = OperationMultiplySpy()
        val calculator = SimpleCalculator(operationMultiplySpy)

        // Act
        calculator.calculate(2, 2, "*")
        val numOfCallsToMultiply = operationMultiplySpy.multiplyCallsCount

        // Assert
        assertEquals(1, numOfCallsToMultiply)
    }
}