package level2Lesson03.homework;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Первая часть задания
        String [] words = {"apple", "grape", "banana", "house", "dog", "phone", "dog", "map", "apple", "cat"};

        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        System.out.println(wordsList);

        Map<String, Integer> newList = new HashMap<>();

        for (String string : wordsList) {
            newList.put(string, Collections.frequency(wordsList, string));
        }
        System.out.println(newList);



//        Вторая часть задания

        PhoneBook.addNewPhone("Kate", "1385438837687");
        PhoneBook.addNewPhone("Kate", "4864646453");
        PhoneBook.addNewPhone("Alex", "94123497");
        PhoneBook.getPhone("Kate");
        PhoneBook.getPhone("Alex");


    }
}
