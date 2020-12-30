package lesson05.offline;

import lesson05.offline.animals.Bird;
import lesson05.offline.animals.Dog;
import lesson05.offline.animals.Cat;
import lesson05.offline.animals.Horse;
import lesson05.offline.models.Animal;

public class main {
    public static void main(String[] args){
        float randomNum = (float) (400 + Math.random() * 600);
        Bird bird = new Bird("Bird", 5, 0, 0.2f);
        Dog dog = new Dog("Dog", randomNum, 10, 0.5f);
        Cat cat = new Cat("Cat", 200, 0, 2f);
        Horse horse = new Horse("Horse", 1500, 100, 3f);

        Animal[] allAnimals = {bird, dog, cat, horse};

        for (int i = 0; i < allAnimals.length; i++) {
            allAnimals[i].run(500);
            allAnimals[i].jump(1.8f);
            allAnimals[i].swim(5);
        }
    }
}
