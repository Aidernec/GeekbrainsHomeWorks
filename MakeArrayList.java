package homework;

import java.util.ArrayList;

public class MakeArrayList<T extends Number> {
    private ArrayList<T> newList;
    private T[] arr;

    public MakeArrayList(T[] arr) {
        this.arr = arr;
    }

    public ArrayList<T> makeList() {
        for (T el : arr) {
            newList.add(el);
        }
        System.out.println(newList);
        return newList;
    }

    ;
}
