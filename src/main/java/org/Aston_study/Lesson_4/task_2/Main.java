package org.Aston_study.Lesson_4.task_2;

public class Main {
    public static void main(String[] args) {

        GeometricFigure circle = new Circle(5.0, GeometricFigure.COLOR_RED, GeometricFigure.COLOR_BLUE);
        GeometricFigure rectangle = new Rectangle(4.0, 6.0, GeometricFigure.COLOR_BLUE, GeometricFigure.COLOR_RED);
        GeometricFigure triangle = new Triangle(3.0, 4.0, 5.0, GeometricFigure.COLOR_GREEN, GeometricFigure.COLOR_GREEN);


        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();

    }
}
