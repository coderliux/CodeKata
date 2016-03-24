package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.FakeData;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;


public class UndoTest {

    @Test
    public void shouldReCalculateResult() throws Exception {
        Stack<String> historyInput = FakeData.getFakeInputSequence("3", "4", "5", "+", "undo");
        Stack<Double> operands = FakeData.getFakeOperandsStack(1d, 2d);

        Undo undo = new Undo();
        undo.calculate(operands, historyInput);

        assertEquals(historyInput.size(), operands.size());
        assertEquals(2, operands.size());
        assertEquals(4d, operands.pop());
        assertEquals(3d, operands.pop());

    }
}