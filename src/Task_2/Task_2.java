package Task_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;


//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Task_2 {
    public static void main(String[] args) throws IOException {
        int[] user_arr = new int[10];
        for (int i = 0; i < 10; i++) {
            user_arr[i] = new Random().nextInt(10);
        }
        System.out.println(Arrays.toString(user_arr));
        System.out.println(Arrays.toString(bubble_sort(user_arr)));

    }

    static int[] bubble_sort(int[] arr) throws IOException {
        Logger logger = Logger.getLogger(Task_2.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("src/Task_2/mylog.log");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.log(Level.INFO, Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1] ^ (arr[j + 1] = arr[j]);
                    logger.log(Level.INFO, Arrays.toString(arr));
                }
            }
        }
        return arr;
    }
}
