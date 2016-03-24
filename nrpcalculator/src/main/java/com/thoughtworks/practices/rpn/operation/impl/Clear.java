package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.operation.Operation;
import com.thoughtworks.practices.rpn.operation.Operator;

import java.util.Stack;

public class Clear implements Operation {
    @Override
    public void calculate(Stack<Double> operands, Stack<String> historyInput) {
        operands.clear();
    }
}
