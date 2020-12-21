package lesson02.offline;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class homeWork02 {
    public static void main(String[] args) {
        // Задание 1
        int[] arrayInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0};
        changeArrayItems(arrayInt);

        // Задание 2
        int[] arrayEmpt = new int[8];
        fillArray(arrayEmpt);

        // Задание 3
        int[] arrayToMult = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyArray(arrayToMult);

        // Задание 4
        int[] arrayToSearch = {1, 2, 3, 4, 5};
        searchArray(arrayToSearch);

        // Задание 5
        int[][] arraySqr = new int[3][3];
        makeCross(arraySqr);
        System.out.println(Arrays.toString(arraySqr[0]));
        System.out.println(Arrays.toString(arraySqr[1]));
        System.out.println(Arrays.toString(arraySqr[2]));

        // Задание 6
        int[] arrayToSumAndCheck = {1, 1, 1, 2, 1};

        // Задание 7-8
        int[] arrayToMove = {1, 2, 3, 4, 5};
        moveNumbers(arrayToMove, -2);
    }
    // Задание 1
    public static void changeArrayItems(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = array[i] == 1 ? 0 : 1;
        }
    }

    // Задание 2
    public static void fillArray(int[] array){
        int numForArr = 1;
        for(int i = 0; i < array.length; i++){
            array[i] = numForArr;
            numForArr += 3;
        }
    }

    // Задание 3
    public static void multiplyArray(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = array[i] < 6 ? array[i] * 2 : array[i];
        }
    }

    // Задание 4
    public static void searchArray(int[] array){
        // Этот вариант я сделал сам
//        int largestNumber = array[0];
//        int smallestNumber = array[0];
//        for (int i = 0; i < array.length; i++){
//            largestNumber = largestNumber > array[i] ? array[i] : largestNumber;
//        }
//        for (int i = 0; i < array.length; i++){
//            smallestNumber = smallestNumber < array[i] ? array[i] : smallestNumber;
//        }

        // Этот вариант нашел в интернете, когда хотел написать короче
        int max = IntStream.of(array).max().orElse(Integer.MIN_VALUE);
        int min = IntStream.of(array).min().orElse(Integer.MAX_VALUE);
    }

    // Задание 5
    public static void makeCross(int[][] array){
        for (int y = 0; y < array.length; y++){
            for (int x = 0; x < array.length; x++){
                if(y != 1){
                    if(x == 0 || x == 2){
                        array[y][x] = 1;
                    }
                } else {
                    if(x == 1){
                        array[y][x] = 1;
                    }
                }
            }
        }
    }

    // Задание 6
    public static boolean checkSum(int[] array){
        int sumLeft;
        int sumRight;
        for(int i = 0; i < array.length + 1; i++){
            sumLeft = 0;
            sumRight = 0;
            for(int l = 0; l < i; l++){
                sumLeft += array[l];
            }
            for (int r = i; r < array.length; r++){
                sumRight += array[r];
            }
            if(sumLeft == sumRight){
                return true;
            }
        }
        return false;
    }

    // Задание 7-8
    public static void moveNumbers(int[] array, int num){
        int firstNum = array[0];
        int lastNum = array[array.length - 1];
        if(num > 0){
            for (int i = 0; i < num; i++){
                for (int j = 1; j < array.length; j++){
                    array[array.length - j] = array[array.length - (j + 1)];
                }
                array[0] = lastNum;
                lastNum = array[array.length - 1];
            }
        }else {
            num *= -1;
            for (int i = 0; i < num; i++){
                    for (int j = 1; j < array.length; j++){
                        array[j - 1] = array[j];
                }
                array[array.length - 1] = firstNum;
                firstNum = array[0];
            }
        }
    }
}
