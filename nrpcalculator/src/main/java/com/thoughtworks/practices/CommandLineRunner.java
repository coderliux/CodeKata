package com.thoughtworks.practices;

import com.thoughtworks.practices.rpn.CalculateException;
import com.thoughtworks.practices.rpn.RPNCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CommandLineRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        println("Please input RPN Expression: ");
        RPNCalculator rpnCalculator = new RPNCalculator();

        while (true) {
            String expression = scanner.nextLine();

            try {
                rpnCalculator.calculate(expression);
            } catch (CalculateException e) {
                println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                println("Calculate with unknown error:" + e.getMessage());
            }

            println("buffer: " + rpnCalculator.getBuffer());
        }
    }

    public static void println(String input) {
        System.out.println(input);
    }
}
