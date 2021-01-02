package lesson06.offline;

import java.io.*;
import java.util.Scanner;

public class homeWork06 {
    public static void main(String[] args) {

        File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
        File fileWithAbsolutePath = new File(tempDirectory.getAbsolutePath() + "/testFile.txt");
        System.out.println(fileWithAbsolutePath);

        try {
            int outbox1;
            int outbox2;
            FileInputStream fis1 = new FileInputStream("text1.txt");
            FileInputStream fis2 = new FileInputStream("text2.txt");
            FileOutputStream fos = new FileOutputStream("text3.txt", true);
            while ((outbox1 = fis1.read()) != -1){
                fos.write((char)outbox1);
            }
            // не совсем понял, почему ругается на закрытие потока. я думал, его нужно закрывать после каждой итерации
            //fos.close();
            fis1.close();

            byte[] str = "\n SECOND FILE TEXT BEGIN \n".getBytes();
            fos.write(str);
            //fos.close();

            while ((outbox2 = fis2.read()) != -1){
                fos.write((char)outbox2);
            }
            fos.close();
            fis1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(searchInOneFile()){
            System.out.println("\n Есть такое слово");
        }else {
            System.out.println("\n Нет такого слова");
        }

    }

    public static boolean searchInOneFile(){
        System.out.println("Введите искомое слово или строку");
        Scanner scanner = new Scanner(System.in);
        String searchWord = scanner.nextLine();

        try {
            FileInputStream textToSearch = new FileInputStream("text3.txt");
            int letter;
            StringBuilder text = new StringBuilder();
            while ((letter = textToSearch.read()) != -1){
//                System.out.print((char)letter);
                text.append((char) letter);
            }
//            System.out.print("ВЫВОДИМ ТЕКСТ " + text);
            textToSearch.close();

            return text.toString().contains(searchWord);

        } catch (IOException e) {
            e.printStackTrace();
        }

            return false;
    }

    public boolean searchInDirectory(File directory){
        String[] files = directory.list();
        return  files.length == 0;
    }
}
