package simplecalculator

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SimpleCalculatorTestWithMock {

    @Test
    fun calculate_addInts_confirmCallToAdd() { // Interaction testing with isolation framework
        // Given
        val operationMock = mockk<Operation>()
        every { operationMock.add(1,1) } returns 2

        val calculator = SimpleCalculator(operationMock)

        // When
        calculator.calculate(1, 1, "+")

        // Then
        verify(exactly = 1) { operationMock.add(any(), any()) }
    }

    @Test
    fun calculate_multiplyInts_confirmSuccessOperationsWithStub() {
        // Given
        val operationStub = mockk<Operation>()
        every { operationStub.add(1,1) } returns 2

        val calculator = SimpleCalculator(operationStub)

        // When
        val result = calculator.calculate(1, 1, "+")

        // Then
        assertEquals(1, calculator.getCount())
        assertEquals(2, result) // asserting against stubs is an anti-pattern
    }
    @Test
    fun calculate_multiplyInts_confirmCallToMultiply() { // Interaction testing with spy
        // Given
        val operationMultiplySpy = OperationMultiplySpy()
        val calculator = SimpleCalculator(operationMultiplySpy)

        // When
        calculator.calculate(2, 2, "*")
        val numOfCallsToMultiply = operationMultiplySpy.multiplyCallsCount

        // Then
        assertEquals(1, numOfCallsToMultiply)
    }
}