package com.devopsclass.exam.services;

import com.devopsclass.exam.exceptions.InvalidOperationException;
import com.devopsclass.exam.serviceImpls.MathOperatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorTest {

    private final MathOperatorImpl mathOperatorService = Mockito.mock(MathOperatorImpl.class);

    @Test
    public void should_create_math_operation_success() throws InvalidOperationException {
        double operand1 = 8;
        double operand2 = 4;
        String operation = "+";

        double mathOperation = mathOperatorService.doMath(operand1,operand2, operation);
        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(mathOperation).usingRecursiveComparison().isEqualTo(actualMathOperator);
    }

}