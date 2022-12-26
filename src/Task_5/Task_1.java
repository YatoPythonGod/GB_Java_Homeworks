package Task_5;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class Task_1 {
    public static void main(String[] args) {
        HashMap<String, Set<String>> phoneBook = new HashMap<>();
        add_phoneBook("Иван", "89261699231", phoneBook);
        add_phoneBook("Иван", "89261699123", phoneBook);
        add_phoneBook("Василий", "89261699080", phoneBook);

        System.out.println(phoneBook);

    }

    public static void add_phoneBook(String name, String phoneNumber, HashMap<String, Set<String>> book){
        if (book.containsKey(name)) {
            Set<String> tmt = book.get(name);
            tmt.add(phoneNumber);
            book.put(name, tmt);
        } else book.put(name, new HashSet<String>(Collections.singleton(phoneNumber)));
    }

}
