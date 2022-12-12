package Task_1;

// Вывести все простые числа от 1 до 1000

import java.util.ArrayList;
import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {
        System.out.println(get_prime_num(1000));

    }
    static ArrayList<Integer> get_prime_num(int max_num){
        boolean [] bool_arr = new boolean[max_num];
        Arrays.fill(bool_arr, true);
        for (int i = 2; i * i < max_num; i++){
            if (bool_arr[i]){
                for(int j = 2 * i; j < max_num; j += i){
                    bool_arr[j] = false;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i < max_num; i++ ){
            if (bool_arr[i]) result.add(i);
        }
        return result;
    }
}
