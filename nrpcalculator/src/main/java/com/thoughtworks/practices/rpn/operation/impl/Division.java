package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.operation.Operation;

import java.util.Stack;

public class Division implements Operation {
    @Override
    public void calculate(Stack<Double> operands, Stack<String> historyInput)  {
        double secondOperand = operands.pop();
        double firstOperand = operands.pop();
        double result = firstOperand / secondOperand;

        operands.push(result);
    }
}
