package com.thoughtworks.practices.rpn;

import com.thoughtworks.practices.rpn.operation.Operation;
import com.thoughtworks.practices.rpn.operation.OperationFactory;

import java.util.Stack;

public class RPNCalculator {
    public static final String EXPRESSION_SPLITOR = " ";

    private Stack<Double> operands = new Stack<>();
    private Stack<String> historyInput = new Stack<>();

    public void calculate(String inputLineText) throws CalculateException {
        String[] inputSequence = inputLineText.split(EXPRESSION_SPLITOR);
        inputSequence = NumberUtil.filterEmptyElement(inputSequence);
        calculate(inputSequence);
    }

    public Stack<Double> calculate(String[] inputSequence) throws CalculateException {
        for (int i = 0; i < inputSequence.length; i++) {
            String operandOrOperator = inputSequence[i];

            recordToHistory(operandOrOperator);
            if (NumberUtil.isOperand(operandOrOperator)) {
                operands.push(Double.valueOf(operandOrOperator));
            } else if (OperationFactory.isSupportedOperation(operandOrOperator)) {
                checkOperator(operandOrOperator, i);
                performCalculate(operandOrOperator);
            } else {
                throw new CalculateException("input " + operandOrOperator + " at (position: " + i + ") insufficient ");
            }
        }
        return operands;
    }

    private void recordToHistory(String operandOrOperator) throws CalculateException {
        historyInput.push(operandOrOperator);
    }

    private void checkOperator(String operandOrOperator, int operatorIndex)
            throws CalculateException {
        if (operands.size() < 2 && NumberUtil.isNumberOperator(operandOrOperator)) {
            String message = "operator " + operandOrOperator + " (position: " + operatorIndex
                    + "): insufficient parameters";
            throw new CalculateException(message);
        }
    }

    private void performCalculate(String operator) throws CalculateException {
        Operation operation = OperationFactory.buildOperation(operator);
        operation.calculate(operands, historyInput);

    }

    public String getBuffer() {
        StringBuilder sf = new StringBuilder();
        int size = operands.size();
        for (int i = 0; i < size; i++) {
            Double operand = operands.elementAt(i);
            sf.append(NumberUtil.formatDecimal(operand));
            if (i < (size -1)) {
                //not the last one
                sf.append(EXPRESSION_SPLITOR);
            }
        }
        return sf.toString();
    }
}
