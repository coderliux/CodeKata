package com.thoughtworks.practices.rpn;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

/**
 * Should use mock tools to verify method invoking
 */
public class RPNCalculatorTest {


    @Test
    public void shouldReturnTwoNumbersBuffer() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        calculator.calculate("1 2");
        assertEquals("1 2", calculator.getBuffer());
    }

    @Test
    public void shouldReturnFractionBufferResult() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        calculator.calculate("4 2 3 5 4 + - * /");
        assertEquals("-0.3333333333", calculator.getBuffer());
    }

    @Test
    public void shouldReturnFractionWhenFractionInput() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        calculator.calculate("4.4 2.2 3 5 4 + - * /");
        assertEquals("-0.3333333333", calculator.getBuffer());
    }

    @Test
    public void shouldGetWarningMessage() {
        RPNCalculator calculator = new RPNCalculator();
        try {
            calculator.calculate("3 -");
        } catch (CalculateException e) {
            assertEquals("operator - (position: 1): insufficient parameters", e.getMessage());
        }
        assertEquals("3", calculator.getBuffer());

    }

    @Test
    public void shouldReturnBufferWhenHasOneUndo() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        calculator.calculate("6 3 1 + 5 * undo +");
        assertEquals("10", calculator.getBuffer());
    }

    @Test
    public void shouldReturnBufferWhenHasNumberAfterClear() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        calculator.calculate("3 4 + clear 1");
        assertEquals("1", calculator.getBuffer());
    }

    @Test
    public void shouldReturnBufferWhenInputHasUndoAndMultipleLine() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        calculator.calculate("6 5 4 3");
        assertEquals("6 5 4 3", calculator.getBuffer());

        calculator.calculate("undo undo *");
        assertEquals("30", calculator.getBuffer());

        calculator.calculate("10 *");
        assertEquals("300", calculator.getBuffer());

        calculator.calculate("undo");
        assertEquals("30", calculator.getBuffer());
    }

    @Test
    public void shouldReturnBuffer() {
        Stack<Double> input = FakeData.getFakeOperandsStack(1d, 2.2d, 3.0d);

    }
}