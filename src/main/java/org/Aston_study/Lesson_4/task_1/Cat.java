package org.Aston_study.Lesson_4.task_1;

public class Cat extends Animal {
    final int runMaxDistance = 200;

    public Cat(String name) {
        this.name = name;
        this.isFed = false;
        incrementCounters();
    }

    public void run(int distance) {
        if (distance < runMaxDistance) {
            System.out.println("Кот " + this.name + " пробежал " + distance + " м");
        } else {
            System.out.println("Кот " + this.name + " не может пробежать больше " + runMaxDistance + "м");
        }
    }

    public void swim(int distance) {
        System.out.println("Кот " + this.name + " не умеет плавать");
    }

    void catInfo() {
        System.out.println("-----ИНФОРМАЦИЯ О КОТЕ-----");
        System.out.println("Имя: " + this.name);
        if (!isFed) {
            System.out.println("Голод: " + this.hungerCount);
        } else {
            System.out.println("Кот сыт");
        }
    }

    public void eatFromBowl(Bowl bowl, int catHungerCount) {
        this.hungerCount = catHungerCount;
        if (isFed) {
            System.out.println("Кот " + this.name + " уже сыт и не хочет есть");
            return;
        }

        if (bowl.foodCount >= this.hungerCount) {
            bowl.foodCount -= hungerCount;
            this.isFed = true;
            System.out.println("Кот " + this.name + " поел из миски №" + bowl.bowlId + " и теперь сыт. Съедено: " + this.hungerCount + " еды");
            this.hungerCount = 0;
            bowl.checkFoodInBowl();
        } else {
            System.out.println("В миске не хватает еды. Добавьте еще: " + (this.hungerCount - bowl.foodCount));
        }
    }

    private void incrementCounters() {
        animalCount++;
        catCount++;
    }
}
