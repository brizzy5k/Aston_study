package org.Aston_study.Lesson_7;

public class ArithmeticOperations {
    public static void main(String[] args) {
        double a = 10;
        double b = 15;
        double c = 5;
        double d = 0;
        System.out.println(sum(a, b));
        System.out.println(sum(b, c));
        System.out.println(subtract(a, b));
        System.out.println(subtract(b, c));
        System.out.println(multiply(a, b));
        System.out.println(multiply(a, c));
        System.out.println(divide(a, b));
        System.out.println(divide(b, c));
        System.out.println(divide(a, d));
    }

    public static double sum(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль невозможно!");
        }
        return num1 / num2;
    }
}
