package org.Aston_study.Lesson_4.task_2;

public class Circle extends GeometryFigure {
    private double radius;


    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double calculateSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
