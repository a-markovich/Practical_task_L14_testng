package Lesson_14_testng;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try {
            BigInteger result = Calculator.getFactorial(5);
            System.out.println(result);
        } catch (FactorialException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
