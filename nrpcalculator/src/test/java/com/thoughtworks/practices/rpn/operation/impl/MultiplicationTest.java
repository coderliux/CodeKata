package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.FakeData;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class MultiplicationTest {

    @Test
    public void shouldMultiplyOperands() throws Exception {
        Multiplication multiplication = new Multiplication();
        Stack<Double> operands = FakeData.getFakeOperandsStack(5d, 2d);
        multiplication.calculate(operands, null);

        assertEquals(10d, operands.pop());
    }
}