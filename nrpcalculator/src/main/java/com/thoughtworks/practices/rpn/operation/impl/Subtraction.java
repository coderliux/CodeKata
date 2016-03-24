package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.CalculateException;
import com.thoughtworks.practices.rpn.operation.Operation;

import java.util.Stack;

public class Subtraction implements Operation {
    @Override
    public void calculate(Stack<Double> operands, Stack<String> historyInput) throws CalculateException {
        double secondOperand = operands.pop();
        double firstOperand = operands.pop();
        double result = firstOperand - secondOperand;

        operands.push(result);
    }
}
