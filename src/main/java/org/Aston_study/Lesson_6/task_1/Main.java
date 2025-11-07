package org.Aston_study.Lesson_6.task_1;

import lombok.Data;

import java.util.*;

@Data
public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Student tempStudent = new Student("", "", 0, Map.of());

        students.add(new Student("Иван Иванов", "ИКПИ-11", 1,
                Map.of("Математика", 5, "Физика", 4, "Программирование", 5)));

        students.add(new Student("Петр Петров", "ИКПИ-11", 1,
                Map.of("Математика", 3, "Физика", 3, "Программирование", 2)));

        students.add(new Student("Мария Сидорова", "ИТП-21", 2,
                Map.of("Математика", 4, "Физика", 5, "Химия", 4)));

        students.add(new Student("Анна Козлова", "ИТП-21", 2,
                Map.of("Математика", 2, "Физика", 2, "Химия", 3)));

        students.add(new Student("Алексей Смирнов", "ИТП-31", 3,
                Map.of("Математика", 2, "Физика", 2, "Химия", 2)));

        students.add(new Student("Галина Сергеевна", "ИТП-31", 3,
                Map.of("Математика", 4, "Физика", 4, "Химия", 4)));

        System.out.println("Исходный список студентов:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("===============================================================");
        tempStudent.printStudents(students, 1);
        tempStudent.printStudents(students, 2);
        tempStudent.printStudents(students, 3);
        tempStudent.printStudents(students, 4);

        tempStudent.removeFailedStudents(students);
        System.out.println("===============================================================");
        System.out.println("После удаления неуспевающих студентов:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("===============================================================");
        tempStudent.promoteSuccessfulStudents(students);
        System.out.println("После перевода на следующий курс:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("===============================================================");
        tempStudent.printStudents(students, 1);
        tempStudent.printStudents(students, 2);
        tempStudent.printStudents(students, 3);
        tempStudent.printStudents(students, 4);
    }
}
