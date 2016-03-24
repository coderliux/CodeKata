package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.CalculateException;
import com.thoughtworks.practices.rpn.operation.Operation;

import java.util.Stack;

public class Unsupported implements Operation {
    private String operator;

    public Unsupported(String operator) {
        this.operator = operator;
    }

    @Override
    public void calculate(Stack<Double> operands, Stack<String> historyInput) throws CalculateException {
        throw new CalculateException("Unsupported operation: " + operator);
    }
}
