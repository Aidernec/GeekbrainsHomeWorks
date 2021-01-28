package lesson08.modules;

public class Wall extends Obstacles{
    @Override
    public boolean jumpWall(int maxJump){
        if(maxJump > heigth){
            System.out.println("Прыжок выполнен");
            return true;
        } else {
            System.out.println("Прыжок не выполнен");
            return false;
        }
    }
}
