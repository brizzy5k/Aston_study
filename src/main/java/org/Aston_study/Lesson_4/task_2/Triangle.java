package org.Aston_study.Lesson_4.task_2;

public class Triangle implements GeometricFigure{
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        // Проверка на существование треугольника
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    private boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA;
    }

    @Override
    public double calculatePerimeter() {
        return sideA+sideB+sideC;
    }

    @Override
    public double calculateSquare() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }


}
