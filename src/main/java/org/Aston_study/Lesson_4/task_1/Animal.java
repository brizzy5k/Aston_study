package org.Aston_study.Lesson_4.task_1;

public abstract class Animal {
    protected static int animalCount = 0;
    protected static int catCount = 0;
    protected static int dogCount = 0;

    protected String name;
    protected boolean isFed;
    protected int hungerCount;

    public static void printAnimalCount() {
        System.out.println("-----СТАТИСТИКА ЖИВОТНЫХ-----");
        System.out.println("Всего животных: " + animalCount);
        System.out.println("Котов: " + catCount);
        System.out.println("Собак: " + dogCount);
    }

    abstract void run(int distance);
    abstract void swim(int distance);
}
