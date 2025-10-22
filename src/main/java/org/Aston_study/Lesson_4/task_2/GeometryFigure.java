package org.Aston_study.Lesson_4.task_2;

public abstract class GeometryFigure implements CalculationGeometricFigure {
    protected String fillColor;
    protected String borderColor;

    public GeometryFigure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public abstract double calculateSquare();

    public abstract double calculatePerimeter();

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
