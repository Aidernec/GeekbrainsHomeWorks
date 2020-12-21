package lesson03.online;

import java.util.Random;
import java.util.Scanner;

//         Полностью разобраться с кодом, попробовать переписать с нуля;
//        * Усовершенствовать метод проверки победы (через циклы);
//        ** Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.
//        *** Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока

public class XOGame {

    public static final char HUMAN_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static char[][] map;
    public static int mapSizeX;
    public static int mapSizeY;

    public static void initMap(){
        mapSizeX = 5;
        mapSizeY = 5;
        map = new char[mapSizeY][mapSizeX];

        for(int y = 0; y < mapSizeY; y++){
            for (int x = 0; x < mapSizeX; x++){
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap(){
        for (int y = 0; y < mapSizeY; y++){
            for (int x = 0; x < mapSizeX; x++){
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn(){
        int x;
        int y;

        do{
            System.out.println("Введите свои координаты: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y,x) || !isEmptyCell(y,x));
        map[y][x] = HUMAN_DOT;
    }

    public static void aiTurn(char inboxChar){
        int x;
        int y;

        int humanDotsCount = 0;
        boolean set = false;
        for(int h = 0; h < mapSizeY; h++){
            for(int w = 0; w < mapSizeX; w++){
                if ( map[h][w] == inboxChar) {
                    if(!set){
                        humanDotsCount++;
                        if(humanDotsCount > 2){
                            int tryCounter = 0;
                            do {
                                x = RANDOM.nextInt(mapSizeX);
                                y = h;
                                tryCounter++;
                            }while (!isEmptyCell(y, x) && tryCounter < 10);
                            map[y][x] = PC_DOT;
                            set = true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        humanDotsCount = 0;
        for(int w = 0; w < mapSizeY; w++){
            for(int h = 0; h < mapSizeX; h++){
                if ( map[h][w] == inboxChar) {
                    if(!set){
                        humanDotsCount++;
                        if(humanDotsCount > 2){
                            int tryCounter = 0;
                            do {
                                y = RANDOM.nextInt(mapSizeX);
                                x = w;
                                tryCounter++;
                            }while (!isEmptyCell(y, x) && tryCounter < 10);
                            map[y][x] = PC_DOT;
                            set = false;
                        }
                    } else {
                        break;
                    }
                    }
                }
            }

        if(!set){
            do {
                x = RANDOM.nextInt(mapSizeX);
                y = RANDOM.nextInt(mapSizeY);
            }while (!isEmptyCell(y, x));
            map[y][x] = PC_DOT;
        }

    }

    public static boolean checkWin(char inboxChar){
//        if(map[0][0] == inboxChar && map[0][1] == inboxChar && map [0][2] == inboxChar) return true;
//        if(map[1][0] == inboxChar && map[1][1] == inboxChar && map [1][2] == inboxChar) return true;
//        if(map[2][0] == inboxChar && map[2][1] == inboxChar && map [2][2] == inboxChar) return true;

//        if(map[0][0] == inboxChar && map[1][0] == inboxChar && map [2][0] == inboxChar) return true;
//        if(map[0][1] == inboxChar && map[1][1] == inboxChar && map [2][1] == inboxChar) return true;
//        if(map[0][2] == inboxChar && map[1][2] == inboxChar && map [2][2] == inboxChar) return true;

        int isWin = 0;
        for(int y = 0; y < mapSizeY; y++){
            for(int x = 0; x < mapSizeX; x++){
                if(map[y][x] == inboxChar) {
                    isWin++;
                }
            }
            if(isWin == 4) return true;
            isWin = 0;
        }
        isWin = 0;
        for(int x = 0; x < mapSizeX; x++){
            for(int y = 0; y < mapSizeY; y++){
                if(map[y][x] == inboxChar) {
                    isWin++;
                }
            }
            if(isWin == 4) return true;
            isWin = 0;
        }
        isWin = 0;
        for(int y = 0; y < mapSizeY; y++){
            for(int x = 0; x < mapSizeX; x++){
                if (x == y && map[y][x] == inboxChar) {
                    isWin++;
                    if(isWin == 4) return true;
                }
            }
        }
//        isWin = 0;
//        for(int y = mapSizeY - 1; y >= 0; y--){
//            for(int x = 0; x < mapSizeX; x++){
//                    if(map[y][x] == inboxChar) {
//                        System.out.println(map[y][x]);
//                        isWin++;
//                        if(isWin == 4) return true;
//                    }
//            }
//            isWin = 0;
//        }


//        if(map[0][0] == inboxChar && map[1][1] == inboxChar && map [2][2] == inboxChar) return true;
//        if(map[0][2] == inboxChar && map[1][1] == inboxChar && map [2][0] == inboxChar) return true;

        return false;
    }

    public static boolean isMapFull(){
        for (int y = 0; y < mapSizeY; y++){
            for (int x = 0; x < mapSizeX; x++){
                if(map[y][x] == EMPTY_DOT) return false;
            }
        }
        return  true;
    }

    public static boolean isValidCell(int y, int x){
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean isEmptyCell(int y, int x){
        return map[y][x] == EMPTY_DOT;
    }

    public static void main(String[] args){
        initMap();
        printMap();

        while (true){
            humanTurn();
            printMap();

            if(checkWin(HUMAN_DOT)){
                System.out.println("Human win!");
                break;
            }
            if(isMapFull()){
                System.out.println("Hичья!");
                break;
            }

            aiTurn(HUMAN_DOT);
            printMap();

            if(checkWin(PC_DOT)){
                System.out.println("Ai win!");
                break;
            }
            if(isMapFull()){
                System.out.println("Hичья!");
                break;
            }
        }

    }
}
