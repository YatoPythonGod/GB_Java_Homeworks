// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки. Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package Task_2;


public class Task_1 {
    public static void main(String[] args) {
        System.out.println(create_sql_query("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}"));
    }

    static String create_sql_query(String json_string) {

        String[] arr = json_string.replace(" ", "").replaceAll(":", " = ").replace("{", "").replace("}", "").split(",");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].split("=")[0].replace("\"", "") + "=" + arr[i].split("=")[1];
        }
        return "SELECT * from students WHERE " + String.join(" and ", arr);
    }
}
