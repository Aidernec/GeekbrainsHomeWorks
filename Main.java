package level2Lesson02.homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int sizeX = 4;
        int sizeY = 4;
        String[][] newArr = new String[sizeY][sizeX];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                newArr[i][j] = "1";
            }
        }
//        newArr[2][3] = "g";
        getArray(newArr, sizeY, sizeX);
    }

    public static void getArray(String[][] arr, int sizeY, int sizeX) throws Exception{
        int sum = 0;
        if(sizeY == 4){
            if(sizeX == 4){
                System.out.println("Размер массива подходящий");
            }else {
                throw new MyArraySizeException("Вторая часть массива не соответствует развмеру 4");
            }
        }else {
            throw new MyArraySizeException("Первая часть массива не соответствует развмеру 4");
        }

        for (int i = 0; i < sizeY; i++) {
                for (int j = 0; j < sizeX; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (Exception e){
                    e.printStackTrace();
                    throw new MyArrayDataException("Ошибка произошла в ячейке " + i + ", " + j);
                }
            }
        }
        System.out.println("Сумма элементов равна " + sum);
    }
}
