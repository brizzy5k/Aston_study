package org.Aston_study.Lesson_4.task_1;

public class Bowl {
    int foodCount;
    int bowlId;


    Bowl(int id, int food){
        this.bowlId=id;
        this.foodCount=food;

    }

    void fillBowl(int food){
        this.foodCount+=food;
        System.out.println("В миску №" + bowlId + " положили "+ food + " еды. Теперь в миске: " + foodCount + " еды");

    }

    void checkFoodInBowl(){
        if (foodCount>0) {
            System.out.println("В миске №" + this.bowlId + ": " + this.foodCount + " еды");
        }else {
            System.out.println("В миске №" + this.bowlId + ": Нет еды");
        }
    }

}
