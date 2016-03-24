package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.FakeData;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class SubtractionTest {

    @Test
    public void shouldSubtractOperandsReturnNegativeNumber() throws Exception {
        Subtraction subtraction = new Subtraction();
        Stack<Double> operands = FakeData.getFakeOperandsStack(1d, 2d);
        subtraction.calculate(operands, null);

        assertEquals(-1d,operands.pop());
    }

    @Test
    public void shouldSubtractOperandsReturnPositiveNumber() throws Exception {
        Subtraction subtraction = new Subtraction();
        Stack<Double> operands = FakeData.getFakeOperandsStack(3d, 2d);
        subtraction.calculate(operands, null);

        assertEquals(1d,operands.pop());
    }
}