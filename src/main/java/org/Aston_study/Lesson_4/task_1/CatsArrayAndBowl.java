package org.Aston_study.Lesson_4.task_1;

public class CatsArrayAndBowl {
    public static void main(String[] args) {
        Cat[] cats = new Cat[4];
        cats[0]= new Cat("Васька",5);
        cats[1]= new Cat("Персик",10);
        cats[2]= new Cat("Мурзик",20);
        cats[3]= new Cat("Снежок",15);



        Bowl bowl2 = new Bowl(2,40);
        for(int i = 0; i<cats.length; i++){
            cats[i].catInfo();
            System.out.println("-----------");
            cats[i].eatFromBowl(bowl2);
        }
        for(int i = 0; i<cats.length; i++){
            cats[i].catInfo();
        }

       // bowl2.fillBowl(15);
    }
}
