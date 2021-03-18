package homework;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2};

        // Задание 1
        ChangeArray changer = new ChangeArray(arr);
        changer.change(arr);

        // Задание 2 не получается разобраться из за чего возникает ошибка
        MakeArrayList listing = new MakeArrayList(arr);
        listing.makeList();

        // задание 3, к сожалению не успел еще
    }
}
