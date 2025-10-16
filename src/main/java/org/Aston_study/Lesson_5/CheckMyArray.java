package org.Aston_study.Lesson_5;

public class CheckMyArraySize {
    public static void checkArraySize(String[][] array) throws MyArraySizeException {

        if (array.length != 4) {
            throw new MyArraySizeException("Недопустимое количество строк.");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        "Недопустимое количество столбцов."
                );
            }
        }

        System.out.println("Размер массива корректен (4x4).");
    }
}
