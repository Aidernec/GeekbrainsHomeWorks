package lesson01.offline;

public class homeWork {
    // Задание 1
    public static double doMath(int a, int b, int c, int d){
       return a*(b+(c/d));
    };

    // Задание 2
    public static boolean doCheck(int a, int b){
        if(a + b >= 10 && a + b <= 20){
            return true;
        } else {
            return false;
        }
    }

    // Задание 3
    public static void checkNum(int a){
        if(a >= 0){
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // Задание 4
    public static String sayHello(String name){
        return "Привет, " + name;
    }

    // Задание 5
    public static void checkYear(int yearToCheck){
        if(yearToCheck % 400 == 0 || yearToCheck % 4 == 0 && yearToCheck % 100 != 0){
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }

    // Вызов методов
    public static void main(String[] args){
        System.out.println(doMath(5,9,7,5));
        System.out.println(doCheck(15,5));
        checkNum(10);
        System.out.println(sayHello("Юрий"));
        checkYear(2020);
    }
}

