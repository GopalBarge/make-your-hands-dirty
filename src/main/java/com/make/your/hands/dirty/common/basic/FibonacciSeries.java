package com.make.your.hands.dirty.common.basic;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 10; // Change this value to the number of Fibonacci numbers you want

        System.out.println("Fibonacci Series up to " + n + " terms:");
        printFibonacciSeries(n);
    }

    private static void printFibonacciSeries(int n) {
        int firstTerm = 0, secondTerm = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(firstTerm + " ");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}