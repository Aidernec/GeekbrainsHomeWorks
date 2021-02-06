package level2Lesson03.homework;


import java.util.*;

public class PhoneBook {
   static Map<String, ArrayList<String>> phoneBook = new TreeMap<>();

    public static void addNewPhone(String name, String phone){
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).add(phone);
        } else {
            phoneBook.put(name, new ArrayList<>(Arrays.asList(phone)));
        }
    }

    public static void getPhone(String name){
        System.out.println(name + " тел: " + phoneBook.get(name));
    }

}
