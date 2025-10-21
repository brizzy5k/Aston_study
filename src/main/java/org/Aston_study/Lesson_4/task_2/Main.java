package org.Aston_study.Lesson_4.task_2;

public class Main {
    public static void main(String[] args) {


        // Тут не совсем понимаю что лучше использовать при создании нового объекта
        // Интерфейс (пример, CalculationGeometricFigure (...) = new Circle (...)  или Класс фигуры (пример, Circle ... = new Circle(...)
        CalculationGeometricFigure circle = new Circle(5.0, "Красный", "Синий");
        CalculationGeometricFigure rectangle = new Rectangle(4.0, 6.0, "Синий", "Красный");
        CalculationGeometricFigure triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Зеленый");


        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();

    }
}
