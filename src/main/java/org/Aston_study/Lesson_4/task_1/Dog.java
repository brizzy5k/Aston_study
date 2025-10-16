package org.Aston_study.Lesson_4.task_1;

public class Dog extends Animal {
    final int runMaxDistance = 500;
    final int swimMaxDistance = 10;

    public Dog(String name){
        this.name=name;
        incrementCounters();
    }

    void run(int distance) {
        if(distance<runMaxDistance) {
            System.out.println("Собака " + this.name + " пробежала " + distance + " м");
        }else{
            System.out.println("Собака " + this.name + "не может пробежать больше " + runMaxDistance + "м");
        }
    }


    void swim(int distance) {
        if(distance<swimMaxDistance) {
            System.out.println("Собака " + this.name + " проплыла " + distance + " м");
        }else{
            System.out.println("Собака " + this.name + "не может проплыть больше " + swimMaxDistance + "м");
        }
    }

    private void incrementCounters() {
        animalCount++;
        dogCount++;
    }

}
