package org.Aston_study.Lesson_6.task_1;

import lombok.Data;

import java.util.*;

@Data
public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>(grades);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return grades.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void promoteToNextCourse() {
        this.course++;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', group='%s', course=%d, avg=%.2f}",
                name, group, course, calculateAverageGrade());
    }

    public void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " (группа: " + student.getGroup() +
                        ", средний балл: " + String.format("%.2f", student.calculateAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("На данном курсе студентов не найдено.");
        }
        System.out.println("");
    }

    public void removeFailedStudents(Set<Student> students) {
        students.removeIf(student -> student.calculateAverageGrade() < 3.0);
    }

    public void promoteSuccessfulStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.calculateAverageGrade() >= 3.0) {
                student.promoteToNextCourse();
            }
        }
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}
