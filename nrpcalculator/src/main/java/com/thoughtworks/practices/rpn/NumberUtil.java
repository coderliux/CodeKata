package com.thoughtworks.practices.rpn;

import com.thoughtworks.practices.rpn.operation.Operator;

import java.text.DecimalFormat;
import java.util.Arrays;

public class NumberUtil {

    public static String formatDecimal(double value) {
        DecimalFormat decimalFormater = new DecimalFormat("#.##########");
        return decimalFormater.format(value);
    }

    public static boolean isOperand(String number) {
        try {
            double v = Double.parseDouble(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isNumberOperator(String operator){
        return !(Operator.CLEAR.equals(operator)||Operator.UNDO.equals(operator));
    }

    public static String[] filterEmptyElement(String[] inputSequence) {
        return Arrays.stream(inputSequence)
                .filter(s -> s.trim().length() > 0)
                .toArray(String[]::new);
    }
}
