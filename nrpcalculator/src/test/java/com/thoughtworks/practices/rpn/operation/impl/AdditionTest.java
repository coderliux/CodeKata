package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.FakeData;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class AdditionTest {

    @Test
    public void shouldAddOperands() throws Exception {
        Addition addition = new Addition();
        Stack<Double> operands = FakeData.getFakeOperandsStack(1d, 2d);
        addition.calculate(operands, null);

        assertEquals(3d, operands.pop());

    }
}