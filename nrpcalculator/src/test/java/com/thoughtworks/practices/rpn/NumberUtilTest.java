package com.thoughtworks.practices.rpn;

import com.thoughtworks.practices.rpn.operation.Operator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NumberUtilTest {

    @Test
    public void testFormatDecimal() throws Exception {
        String result = NumberUtil.formatDecimal(1d/3d);
        assertEquals("0.3333333333", result);
    }

    @Test
    public void testIsOperand() throws Exception {
        boolean isOperand = NumberUtil.isOperand("1d");
        assertEquals(true, isOperand);
    }

    @Test
    public void testIsNotOperand() throws Exception {
        boolean isOperand = NumberUtil.isOperand("1df");
        assertEquals(false, isOperand);
    }

    @Test
    public void testIsNumberOperator() throws Exception {
        boolean isOperator = NumberUtil.isNumberOperator(Operator.ADDITION);
        assertEquals(true, isOperator);
        isOperator = NumberUtil.isNumberOperator(Operator.SUBTRACTION);
        assertEquals(true, isOperator);
        isOperator = NumberUtil.isNumberOperator(Operator.MULTIPLICATION);
        assertEquals(true, isOperator);
        isOperator = NumberUtil.isNumberOperator(Operator.DIVISION);
        assertEquals(true, isOperator);

        isOperator = NumberUtil.isNumberOperator(Operator.UNDO);
        assertEquals(false, isOperator);

    }

    @Test
    public void testFilterEmptyElement() {
        String[] inputSequence = {"1", "2", "", "+", "3", " ", "5"};
        inputSequence = NumberUtil.filterEmptyElement(inputSequence);
        assertEquals(5, inputSequence.length);
        assertEquals("+", inputSequence[2]);
    }
}