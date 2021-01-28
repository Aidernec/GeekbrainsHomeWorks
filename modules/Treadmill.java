package lesson08.modules;

public class Treadmill extends Obstacles {
    @Override
    public boolean runTreadmill(int maxRun){
        if(maxRun > width){
            System.out.println("Смог пробежать");
            return true;
        } else {
            System.out.println("Не смог пробежать");
            return false;
        }
    }
}
