package org.Aston_study.Lesson_5;

import static org.Aston_study.Lesson_5.CheckMyArray.checkArrayAndSum;
import static org.Aston_study.Lesson_5.CheckMyArray.checkArraySize;

public class Main {

    public static void main(String[] args) {
        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arr2 = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] arr3 = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] arr4 = {
                {"1", "3", "3", "4"},
                {"5", "6", "SWQS", "8"},
                {"9", "xcxzcxzc", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            //checkArraySize(arr1);
            //checkArraySize(arr2);
            //checkArraySize(arr3);

            checkArrayAndSum(arr1);
            //checkArrayAndSum(arr2);
            //checkArrayAndSum(arr3);
            //checkArrayAndSum(arr4);


        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();

        }

        try {
            int[] arr5 = {1, 2, 3, 4};
            System.out.println(arr5[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();

        }
        System.out.println("Конец программы");
    }
}
