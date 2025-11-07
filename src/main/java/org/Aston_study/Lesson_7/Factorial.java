package org.Aston_study.Lesson_7;

public class Factorial {
    public static void main(String[] args) {
        Factorial num = new Factorial();
        System.out.println(num.factorial(5));
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не может быть отрицательным");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
