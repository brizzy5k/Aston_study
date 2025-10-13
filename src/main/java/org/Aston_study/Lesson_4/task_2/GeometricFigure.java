package org.Aston_study.Lesson_4.task_2;

public interface GeometricFigure {
    String COLOR_RED = "Красный";
    String COLOR_BLUE = "Синий";
    String COLOR_GREEN = "Зеленый";

    double calculateSquare();
    String getFillColor();
    String getBorderColor();
    double calculatePerimeter();



    default void printInfo() {
        System.out.println("----- " + this.getClass().getSimpleName() + " -----");
        System.out.println("Площадь: " + String.format("%.2f", calculateSquare()));
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println();
    }
}
