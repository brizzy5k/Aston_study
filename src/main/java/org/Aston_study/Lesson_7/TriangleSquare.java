package org.Aston_study.Lesson_7;

public class TriangleSquare {
    public static void main(String[] args) {
        TriangleSquare triangle = new TriangleSquare();
        System.out.println(triangle.calculateByBaseAndHeight(10,5));
    }

    public static double calculateByBaseAndHeight(double base, double height) {
        return 0.5 * base * height;
    }

    public static double calculateBySides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами невозможен");
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
