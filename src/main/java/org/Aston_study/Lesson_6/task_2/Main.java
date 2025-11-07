package org.Aston_study.Lesson_6.task_2;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory phoneBook = new PhoneDirectory();

        phoneBook.add("Иванов", "952-12-37");
        phoneBook.add("Петров", "947-545-44");
        phoneBook.add("Иванов", "555-55-55");
        phoneBook.add("Смирнов", "111-22-55");
        phoneBook.add("Петров", "400-41-42");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Смирнов"));
        System.out.println("Кузнецов: " + phoneBook.get("Кузнецов"));
    }
}
