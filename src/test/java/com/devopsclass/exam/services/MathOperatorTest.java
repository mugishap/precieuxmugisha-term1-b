package com.devopsclass.exam.services;

import com.devopsclass.exam.exceptions.InvalidOperationException;
import com.devopsclass.exam.serviceImpls.MathOperatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorTest {

    private final MathOperatorImpl mathOperatorService = new MathOperatorImpl();

    @Test
    public void should_create_math_operation_success() throws InvalidOperationException {
        MathOperatorImpl mathOperatorServiceMock = Mockito.mock(MathOperatorImpl.class);
        double operand1 = 8;
        double operand2 = 4;
        String operation = "+";

        double mathOperation = mathOperatorServiceMock.doMath(operand1, operand2, operation);
        when(mathOperatorServiceMock.doMath(operand1, operand2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorServiceMock.doMath(operand1, operand2, operation);

        assertThat(mathOperation).usingRecursiveComparison().isEqualTo(actualMathOperator);
    }

    @Test()
    public void add_success() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(12, 13, "+");
        System.out.println(actual);
        assertEquals(25, actual, 0.01);
    }

    @Test()
    public void divide_success() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(4, 2, "/");
        assertEquals(2, actual, 0.01);
    }

    @Test(expected = InvalidOperationException.class)
    public void divide_by_zero() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(12, 0, "/");
        assertEquals(0, actual, 0.01);
    }

    @Test()
    public void subtract_success() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(20, 13, "-");
        assertEquals(7, actual, 0.01);
    }

    @Test()
    public void multiply_success() throws InvalidOperationException {
        double actual = mathOperatorService.doMath(12, 13, "*");
        assertEquals(156, actual, 0.01);
    }

}