package org.Aston_study.Lesson_7;

public class NumberComparator {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        NumberComparator nc = new NumberComparator();
        System.out.println(nc.compare(a, b));
        System.out.println(nc.isGreater(a,b));
        System.out.println(nc.isLess(a,b));
        System.out.println(nc.isEqual(a,b));

    }

    public static String compare(int num1, int num2) {
        if (num1 > num2) {
            return num1 + " > " + num2;
        } else if (num1 < num2) {
            return num1 + " < " + num2;
        } else {
            return num1 + " = " + num2;
        }
    }

    public static boolean isGreater(int num1, int num2) {
        return num1 > num2;
    }

    public static boolean isLess(int num1, int num2) {
        return num1 < num2;
    }

    public static boolean isEqual(int num1, int num2) {
        return num1 == num2;
    }
}
