package com.thoughtworks.practices.rpn.operation.impl;

import com.thoughtworks.practices.rpn.FakeData;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class DivisionTest {

    @Test
    public void shouldDivisionOperandsReturnInteger() throws Exception {
        Division division = new Division();
        Stack<Double> operands = FakeData.getFakeOperandsStack(6d, 2d);
        division.calculate(operands, null);

        assertEquals(3d, operands.pop());
    }

    @Test
    public void shouldDivisionOperandsReturnOFraction() throws Exception {
        Division division = new Division();
        Stack<Double> operands = FakeData.getFakeOperandsStack(1d, 5d);
        division.calculate(operands, null);

        assertEquals(0.2, operands.pop());
    }
}