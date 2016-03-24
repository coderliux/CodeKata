package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.CalculateException;
import com.thoughtworks.practices.rpn.FakeData;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.*;

public class UnsupportedTest {

    @Test
    public void shouldThrowExceptionWhenUnsupported() {
        Unsupported unsupported = new Unsupported("ddd");
        Stack<Double> operands = FakeData.getFakeOperandsStack(1d, 2d);

        try {
            unsupported.calculate(operands, null);
            fail("no exception throws");
        } catch (CalculateException e) {
            assertTrue(true);
        }
    }
}