package homework;

import homework.annotation.AfterSuite;
import homework.annotation.BeforeSuite;
import homework.annotation.Test;

public class TestClass {
    @BeforeSuite
    public static void setUp(){
        System.out.println("setUp");
    }

    @AfterSuite
    public static void tearDown(){
        System.out.println("tearDown");
    }

    @Test(priority = 4)
    public static void test1(){
        System.out.println("test1");
    }

    @Test(priority = 3)
    public static void test2(){
        System.out.println("test2");
    }

    @Test(priority = 2)
    public static void test3(){
        System.out.println("test3");
    }

    @Test(priority = 1)
    public static void test4(){
        System.out.println("test4");
    }


}
