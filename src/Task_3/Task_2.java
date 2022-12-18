package Task_3;

import java.util.ArrayList;
import java.util.Arrays;

//Пусть дан произвольный список целых чисел, удалить из него четные числа
public class Task_2 {
    public static void main(String[] args) {
        Integer[] user_arr = new Integer[20];
        for (int i = 1; i < user_arr.length + 1; i++) {
            user_arr[i - 1] = i;
        }
        System.out.printf("In: %s%n", Arrays.toString(user_arr));
        System.out.printf("Out: %s%n", remove_even_num(user_arr));
    }

    static ArrayList<Integer> remove_even_num(Integer[] arr) {
        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(arr));
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) % 2 == 0) {
                result.remove(i);
                i--;
            }
        }
        return result;
    }
}
