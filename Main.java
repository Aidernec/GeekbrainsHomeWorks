package lesson08;

import lesson08.modules.Obstacles;
import lesson08.modules.Treadmill;
import lesson08.modules.Wall;
import lesson08.subjects.Cat;
import lesson08.subjects.Human;
import lesson08.subjects.Robot;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("human1", 12, 150);
        Human human2 = new Human("human2", 6, 400);
        Human human3 = new Human("human3", 4, 100);
        Cat cat = new Cat("Cat", 15, 200);
        Robot robot = new Robot("robot", 2, 80);

        Wall wall = new Wall();
        Treadmill treadmill = new Treadmill();

//        wall.jumpWall(human.jump());
//        wall.jumpWall(robot.jump());
//
//        treadmill.runTreadmill(human1.run());
//        treadmill.runTreadmill(robot.run());
//        treadmill.runTreadmill(cat.run());

//        Obstacles[] obstacles = new Obstacles[2];
//        obstacles[0] = wall;
//        obstacles[1] = treadmill;

        Human[] humanMembers = new Human[3];
        humanMembers[0] = human1;
        humanMembers[1] = human2;
        humanMembers[2] = human3;

        for (Human h: humanMembers){
            if(wall.jumpWall(h.jump())){
                treadmill.runTreadmill(h.run());
            }
        }


    }
}
