package com.thoughtworks.practices.rpn.operation;

import com.thoughtworks.practices.rpn.CalculateException;
import java.util.Stack;

public interface Operation {
    void calculate(Stack<Double> operands, Stack<String> historyInput) throws CalculateException;
}
