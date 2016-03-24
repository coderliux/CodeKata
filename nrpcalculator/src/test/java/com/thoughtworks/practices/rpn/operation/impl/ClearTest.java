package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.FakeData;
import com.thoughtworks.practices.rpn.operation.Operation;
import com.thoughtworks.practices.rpn.operation.Operator;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ClearTest {

    @Test
    public void shouldCleanOperandsInStack() throws Exception {
        Clear clear = new Clear();
        Stack<Double> operands = FakeData.getFakeOperandsStack(1d, 2d);
        clear.calculate(operands, null);

        assertEquals(0, operands.size());
    }
}