package com.codegym;

public class Calculator {
    static final char ADDITION = '+';
    static final char SUBSTRACTION = '-';
    static final char MULTIPLICATION = '*';
    static final char DIVISION = '/';

    public static int calculate(int firstOperand, int secondOprand, char operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOprand;
            case SUBSTRACTION:
                return firstOperand - secondOprand;
            case MULTIPLICATION:
                return firstOperand * secondOprand;
            case DIVISION:
                if (secondOprand != 0)
                    return firstOperand / secondOprand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
