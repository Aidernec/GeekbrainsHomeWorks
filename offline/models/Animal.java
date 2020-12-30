package lesson05.offline.models;

public class Animal {
    String name;
    float maxRun, maxSwim, maxJump;

    public Animal(String name, float maxRun, float maxSwim, float maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

    public void run(float distance){
        if(distance < maxRun){
            System.out.println(name + " run " + distance + "м");
        } else {
            System.out.println("Слишком большая дистанция бега для " + name);
        }
    }

    public void swim(float distance){
        if(maxSwim == 0){
            System.out.println(name + " не умеет плавать");
        } else if(distance < maxSwim ){{
            System.out.println(name + " swim " + distance + "м");
        }

        } else {
            System.out.println("Слишком большая дистанция заплыва для " + name);
        }
    }

    public void jump(float distance){
        if(distance < maxJump){
            System.out.println(name + " jump " + distance + "м");
        } else {
            System.out.println("Слишком большая дистанция прыжка для " + name);
        }
    }
}
