package com.devopsclass.exam.services;

import com.devopsclass.exam.exceptions.InvalidOperationException;

public interface MathOperator {

    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;

}
