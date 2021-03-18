package homework;

import java.util.Arrays;

public class ChangeArray<T extends Number> {
    private T[] arr;

    public ChangeArray(T[] obj) {
        this.arr = obj;
    }

    public void change(T[] obj) {
        System.out.println(Arrays.toString(obj));
        T num1 = obj[0];
        T num2 = obj[1];

        obj[0] = num2;
        obj[1] = num1;
        System.out.println(Arrays.toString(obj));
    }

}
