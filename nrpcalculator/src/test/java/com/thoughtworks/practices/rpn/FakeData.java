package com.thoughtworks.practices.rpn;

import java.util.Stack;

public class FakeData {
    public static Stack<Double> getFakeOperandsStack(double... numbers) {
        Stack<Double> operands = new Stack<>();
        for (double number : numbers) {
            operands.push(number);
        }
        return operands;
    }

    public static Stack<String> getFakeInputSequence(String... numbers) {
        Stack<String> operands = new Stack<>();
        for (String number : numbers) {
            operands.push(number);
        }
        return operands;
    }
}
