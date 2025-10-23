package org.Aston_study.Lesson_4.task_1;

public class CatsArrayAndBowl {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Васька");
        cats[1] = new Cat("Персик");
        cats[2] = new Cat("Мурзик");
        cats[3] = new Cat("Снежок");

        Bowl bowl2 = new Bowl(2, 40);
        for (int i = 0; i < cats.length; i++) {
            cats[i].catInfo();
            System.out.println("-----------");
            cats[i].eatFromBowl(bowl2, 15);
        }
        for (int i = 0; i < cats.length; i++) {
            cats[i].catInfo();
        }
        bowl2.fillBowl(5);
        cats[3].eatFromBowl(bowl2, 15);
        cats[2].catInfo();
        cats[3].catInfo();
    }
}
