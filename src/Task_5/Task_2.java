package Task_5;

import java.util.*;

//Пусть дан список сотрудников:Иван Иванов ( и остальные, полный текст дз будет на платформе)
//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
public class Task_2 {
    public static void main(String[] args) {
        String [] names = new String[]{"Иван Иванов", "Василий Уткин", "Дмитрий Губерниев", "Иван Ургант",
                "Алесандр Емельянинко", "Алесандр Овечкин", "Иван Штыков"};
        System.out.println(createMap(names));

        ArrayList<ArrayList<String>> count_sort = new ArrayList<>(createMap(names).values());
        count_sort.sort((o1, o2) -> o2.size() - o1.size());
        for (ArrayList<String> list: count_sort){
            System.out.printf("%d - %s\n", list.size(), list.get(0).split(" ")[0]);
        }

    }

    static HashMap<String, ArrayList<String>> createMap (String [] names){
        HashMap<String, ArrayList<String>> namesMap = new HashMap<>();
        for (String name: names) {
            String firstName = name.split(" ")[0];

            if (namesMap.containsKey(firstName)){
                ArrayList<String> tmp = namesMap.get(firstName);
                tmp.add(name);
                namesMap.put(firstName, tmp);
            } else  namesMap.put(firstName, new ArrayList<>(Collections.singleton(name)));
        }
        return namesMap;
    }



}
