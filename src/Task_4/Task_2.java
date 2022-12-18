package Task_4;
//Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;

public class Task_2 {
    public static void main(String[] args) {
        LinkedList<String> user_list = new LinkedList<String>();
        for (int i = 1; i < 11; i++) {
            user_list.add(String.valueOf(i));
        }
        System.out.printf("In: %s%n", user_list);
        enqueue(user_list, "Hello");
        enqueue(user_list, "Java");
        System.out.println(user_list);
        System.out.println(dequeue(user_list));
        System.out.println(first(user_list));
        System.out.println(user_list);
    }

    static void enqueue(LinkedList<String> user_list, String element) {
        user_list.addLast(element);
    }

    static String dequeue(LinkedList<String> user_list) {
        return user_list.pollFirst();
    }

    static String first(LinkedList<String> user_list) {
        return user_list.peekFirst();
    }
}
