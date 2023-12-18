package com.devopsclass.exam.serviceImpls;

import com.devopsclass.exam.exceptions.InvalidOperationException;
import com.devopsclass.exam.services.MathOperator;
import org.springframework.stereotype.Service;

@Service
public class MathOperatorImpl implements MathOperator {

    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        System.out.println("operand1: " + operand1);
        System.out.println("operand2: " + operand2);
        System.out.println("operation: " + operation);

        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            default:
                throw new
                        RuntimeException("Unknown operation");

        }
    }
}
