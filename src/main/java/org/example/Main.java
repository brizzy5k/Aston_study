package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      /*  printThreeWords();    //1.Отпечатать в столбец три слова: Orange, Banana, Apple
        checkSumSign();    //2.Вывести в консоль сообщение “Сумма положительная” если a+b, в противном случае - “Сумма отрицательная”
        printColor();    //3. Вывести в консоль "Красный" (value<=0), "Желтый" (0<value<=100), "Зеленый" (value>100)
        compareNumbers();   //4. Вывести a >= b или a < b
        checkSumInterval(5,6);    //5. Если  10 < a + b < 20 (true), иначе (false)
        checkNumberPositiveSign(-3);    //6. Напечатать в консоль, положительное ли число передали или отрицательное
        checkNumberNegativeSign(2);    //7.  Вернуть true, если число отрицательное, и вернуть false если положительное
        printStringTimes("Aston",4);    //8. Отпечатать в консоль указанную строку, указанное количество раз
        checkLeapYear(2025);    //9.  Определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false)
        arrayConvert();     //10. Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0
        arrayFiller();     //11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100
        doubleNumbersLessThanSix()  //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
        crossDoubleArray(5); //13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        printArrayInitialValue(5,4); //14. Метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.

*/



    }
    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(){
        int a=9, b=-4;
        if (a+b>0){
            System.out.println("Сумма положительна");
        }else
            System.out.println("Сумма отрицательна");
    }

    public static void printColor(){
        int value=101;
        if (value<=0){
            System.out.println("Красный");
        }
        if ( 0 <value && value <= 100){
            System.out.println("Желтый");
        }
        if (value>100){
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = 10,b = 30;
        if (a >= b){
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumInterval(int a,int b){
        if(a + b <= 20 && a + b > 10) {
            System.out.println("True");
            return true;
        }
        System.out.println("false");
        return false;
    }

    public static void checkNumberPositiveSign(int value){
        if (value < 0){
            System.out.println("Отрицательное значение");
        }else{
            System.out.println("Положительное значение");
        }
    }

    public static boolean checkNumberNegativeSign(int value){
        if (value<0){
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;
    }

    public static void printStringTimes(String s, int value){
        for (int i = 0; i  < value; i++){
            System.out.println(s);
        }
    }

    public static boolean checkLeapYear(int year){
        if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)){
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;
    }

    public static void arrayConvert(){
        int arr[]={1,1,0,0,0,0,1};
        System.out.println("Before "+ Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println("After " + Arrays.toString(arr) );
    }

    public static void arrayFiller(){
        int arr [] = new int[100];
        System.out.println("New array " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            arr[i]=i+1;
        }
        System.out.println("Filled array " +Arrays.toString(arr));
    }

    public static void doubleNumbersLessThanSix(){
        int arr [] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Before " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            if (arr[i]<6){ arr[i]=arr[i]*2;}
        }
        System.out.println("After " + Arrays.toString(arr));
    }

    public static void crossDoubleArray(int size){
        int arr[][] = new int[size][size];
        for (int i = 0; i < size; i++){

            arr[i][i]=1;
            arr[i][size-1-i]=1;

            for (int j = 0; j < size; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void printArrayInitialValue(int len, int initialValue){
        int arr[] = new int[len];
        for (int i = 0; i < len; i++){
            arr[i]=initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}