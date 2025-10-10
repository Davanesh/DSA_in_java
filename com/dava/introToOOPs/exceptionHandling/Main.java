package com.dava.introToOOPs.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 2;
        int b = 0;
        try {
            div(a, b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("this will run no matter what!");
        }
    }
    static int div(int a, int b) throws ArithmeticException {
        if(b == 0) {
            throw new ArithmeticException("don't div anum by '0'");
        }
        return a / b;
    }
}
