package lesson08.modules;

public class Obstacles {

    protected int width = 100;
    protected int heigth = 5;

    protected boolean runTreadmill(int maxRun){
        if(maxRun > width){
            System.out.println("Смог пробежать");
            return true;
        } else {
            System.out.println("Не смог пробежать");
            return false;
        }
    }

    protected boolean jumpWall(int maxJump){
        if(maxJump > heigth){
            System.out.println("Прыжок выполнен");
            return true;
        } else {
            System.out.println("Прыжок не выполнен");
            return false;
        }
    }
}
