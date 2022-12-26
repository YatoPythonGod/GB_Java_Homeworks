package Task_5;

import java.util.Arrays;
import java.util.LinkedList;

//Реализовать алгоритм пирамидальной сортировки (HeapSort).
public class Task_3 {
    public static void main(String[] args) {
        int[] userArr = new int[]{2, 3, 1, 4, 5, 8, 7, 6, 11, 10, 9};
        LinkedList<Integer> userHeap = createHeap(userArr);
        System.out.println(userHeap);
        for (int i = userArr.length - 1; i >= 0; i--) {
            userArr[i] = remove(userHeap);
        }
        System.out.println(Arrays.toString(userArr));
    }

    static void addEl(int el, LinkedList<Integer> heap) {
        int n = heap.size() - 1;
        n += 1;
        heap.add(el);
        int p = n;
        while (p > 0 && heap.get(p) > heap.get(p / 2)) {
            int tmp = heap.get(p);
            heap.remove(p);
            heap.add(p, heap.get(p / 2));
            heap.remove(p / 2);
            heap.add(p / 2, tmp);
            p /= 2;
        }
    }

    static LinkedList<Integer> createHeap(int[] arr) {
        LinkedList<Integer> newHeap = new LinkedList<>();
        for (int el : arr) {
            addEl(el, newHeap);
        }
        return newHeap;
    }

    static int remove(LinkedList<Integer> heap) {
        int result = heap.pollFirst();
        if (heap.size() < 2) {
            System.out.println(heap); // для наглядности
            return result;}
        if (heap.size() == 2) {
            if (heap.peekLast() > heap.peekFirst()) {
                heap.addFirst(heap.pollLast());
            }
            System.out.println(heap); // для наглядности
            return result;
        }

        int n = heap.size() - 1;
        heap.addFirst(heap.get(n));
        heap.pollLast();


        int p = 1;

        while (p * 2 + 1 < n + 2) {
            int max = p * 2;
            if (p * 2 + 1 < n + 2 && heap.get(max+1 - 1) > heap.get(max - 1)) max += 1;
            if (heap.get(p - 1) < heap.get(max - 1)) {
                int tmp = heap.get(p - 1);
                heap.add(p - 1, heap.get(max - 1));
                heap.remove(p + 1 - 1);
                heap.add(max - 1, tmp);
                heap.remove(max + 1 - 1);
            }
            p = max;
        }
        System.out.println(heap); // для наглядности
        return result;

    }


}
