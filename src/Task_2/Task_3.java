//Дана json строка (можно сохранить в файл и читать из файла)
//
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

package Task_2;


import java.util.HashMap;

public class Task_3 {
    public static void main(String[] args) {
        String json_string = new String("[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
        System.out.println(parse_json(json_string));
    }

    static StringBuilder parse_json(String json_string) {
        String rep_json_string = json_string.replace(" ", "").replace("\"", "").
                replace("[", "").replace("]", "").replace("{", "");
        String[] arr_json = rep_json_string.split("},");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr_json.length; i++) {
            String[] local_arr = arr_json[i].replace("}", "").split(",");
            HashMap<String, String> local_dict = new HashMap<String, String>();
            for (String item : local_arr) {
                local_dict.put(item.split(":")[0], item.split(":")[1]);
            }
            result.append(String.format("Студент %s получил %s по предмету %s.\n",
                    local_dict.get("фамилия"), local_dict.get("оценка"), local_dict.get("предмет")));
        }
        return result;
    }
}
