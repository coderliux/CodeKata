package com.thoughtworks.practices.rpn.operation;


import com.thoughtworks.practices.rpn.CalculateException;
import com.thoughtworks.practices.rpn.operation.impl.*;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    public static Map<String, Operation> SUPPORTED_OPERATION = new HashMap<>();

    static {
        SUPPORTED_OPERATION.put(Operator.ADDITION, new Addition());
        SUPPORTED_OPERATION.put(Operator.SUBTRACTION, new Subtraction());
        SUPPORTED_OPERATION.put(Operator.MULTIPLICATION, new Multiplication());
        SUPPORTED_OPERATION.put(Operator.DIVISION, new Division());
        SUPPORTED_OPERATION.put(Operator.UNDO, new Undo());
        SUPPORTED_OPERATION.put(Operator.CLEAR, new Clear());
    }

    public static Operation buildOperation(String operator) throws CalculateException {
        Operation operation = SUPPORTED_OPERATION.get(operator);
        if (operation == null) {
            operation = new Unsupported(operator);
        }
        return operation;
    }

    public static boolean isSupportedOperation(String operator){
        return SUPPORTED_OPERATION.containsKey(operator);
    }
}
