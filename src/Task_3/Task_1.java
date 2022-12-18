package Task_3;

import java.util.Arrays;

public class Task_1 {
    public static void main(String[] args) {
        int[] user_arr = new int[]{2, 3, 1, 4, 5, 8, 7, 6};
        System.out.printf("In: %s%n", Arrays.toString(user_arr));
        System.out.printf("Out: %s%n", Arrays.toString(sortArray(user_arr)));
    }

    public static int[] sortArray(int[] arrayA) {
        if (arrayA == null) {
            return null;
        }
        if (arrayA.length < 2) {
            return arrayA;
        }
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        arrayB = sortArray(arrayB);
        arrayC = sortArray(arrayC);

        return mergeArray(arrayB, arrayC);
    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA > arrayA.length - 1) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB > arrayB.length - 1) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayC;
    }
}