package Task_4;

//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;

public class Task_1 {
    public static void main(String[] args) {
        LinkedList<Integer> user_list = new LinkedList<Integer>();
        for (int i = 1; i < 11; i++) {
            user_list.add(i);
        }
        System.out.printf("In: %s%n", user_list);
        System.out.printf("Out: %s%n", reverse_arr(user_list));
    }

    static LinkedList<Integer> reverse_arr(LinkedList<Integer> user_list) {

        for (int i = 0; i < user_list.size() / 2; i++) {
            Integer temp = user_list.get(i);
            user_list.set(i, user_list.get(user_list.size() - 1 - i));
            user_list.set(user_list.size() - 1 - i, temp);
        }
        return user_list;
    }
}
