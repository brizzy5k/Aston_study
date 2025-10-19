package org.Aston_study.Lesson_5;

public class CheckMyArray {
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


    public static void checkArrayAndSum(String[][] array) throws MyArraySizeException,MyArrayDataException{
        int sum=0;

        checkArraySize(array);

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Ошибка преобразования в ячейке [" + i + "][" + j + "]: значение " + array[i][j] + " не является числом."
                    );
                }
            }
        }

        System.out.println("Сумма массива = " + sum);
    }
}
