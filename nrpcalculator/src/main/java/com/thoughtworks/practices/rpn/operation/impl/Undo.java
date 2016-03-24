package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.CalculateException;
import com.thoughtworks.practices.rpn.NumberUtil;
import com.thoughtworks.practices.rpn.RPNCalculator;
import com.thoughtworks.practices.rpn.operation.Operation;
import com.thoughtworks.practices.rpn.operation.OperationFactory;
import com.thoughtworks.practices.rpn.operation.Operator;

import java.util.Stack;

public class Undo implements Operation {
    @Override
    public void calculate(Stack<Double> operands, Stack<String> historyInput) throws CalculateException {
        if (!Operator.UNDO.equalsIgnoreCase(historyInput.pop())) {
            throw new CalculateException("undo not the last");
        }
        if (OperationFactory.isSupportedOperation(historyInput.pop())) {
            historyInput.pop();
        }
        String[] inputSequenceAfterUndo = new String[historyInput.size()];
        historyInput.toArray(inputSequenceAfterUndo);
        operands.clear();
        reCalculate(inputSequenceAfterUndo).stream().forEach(operands::push);
    }

    public Stack<Double> reCalculate(String[] inputSequenceAfterUndo) throws CalculateException {
        return new RPNCalculator().calculate(inputSequenceAfterUndo);
    }
}
