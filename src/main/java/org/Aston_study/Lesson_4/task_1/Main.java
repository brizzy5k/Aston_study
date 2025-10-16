package org.Aston_study.Lesson_4.task_1;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик");
        Dog dog1 = new Dog("Жучка");
        Bowl bowl1 = new Bowl(1,10);


        cat1.run(100);
        cat1.swim(100);
        dog1.run(600);
        dog1.swim(10);



        Cat cat2 = new Cat("Борис",10);
       // cat2.catInfo();
        cat2.eatFromBowl(bowl1);
        bowl1.fillBowl(20);


        Animal.printAnimalCount();

    }

}
