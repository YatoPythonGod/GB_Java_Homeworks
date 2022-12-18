package Task_3;

import java.util.ArrayList;
import java.util.Random;

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class Task_3 {
    public static void main(String[] args) {
        ArrayList<Integer> user_list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            user_list.add(new Random().nextInt(10));
        }
        System.out.println(user_list);
        System.out.println(min_mid_max(user_list));
    }

    static String min_mid_max(ArrayList<Integer> arr) {
        int min = arr.get(0);
        int max = arr.get(0);
        double mid = arr.get(0);
        if (arr.size() < 2) return String.format("Min: %s \nMax: %s \nMid: %s \n", min, max, mid);
        double sum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            sum += arr.get(i);
            if (arr.get(i) < min) min = arr.get(i);
            else if (arr.get(i) > max) max = arr.get(i);
        }
        mid = sum / arr.size();
        return String.format("Min: %s \nMax: %s \nMid: %s \n", min, max, mid);
    }
}
