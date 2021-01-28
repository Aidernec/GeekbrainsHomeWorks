package lesson08.subjects;

public class Cat {
    String name;
    int maxJumpHeigth;
    int maxRunWidth;
    public Cat(String name, int maxJumpHeigth, int maxRunWidth){
        this.name = name;
        this.maxJumpHeigth = maxJumpHeigth;
        this.maxRunWidth = maxRunWidth;
    }

    public int run(){
        System.out.println(name + " run");
        return maxRunWidth;
    }

    public int jump(){
        System.out.println(name + " Jump");
        return maxJumpHeigth;
    }

}
