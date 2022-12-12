package Task_1;
import java.util.Objects;


//Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

import static Task_1.Task_3.simple_calc;

public class Task_4 {
    public static void main(String[] args) {
        System.out.println(solve_equation("2? + ?5 = 69"));
    }

    static String solve_equation(String equation) {
        String[] arr_equation = equation.replaceAll(" ", "").split("=");
        StringBuilder result_equation = new StringBuilder(arr_equation[1]);
        StringBuilder num_1 = null;
        StringBuilder num_2 = null;
        String eq_operation = null;
        for (String operation : new String[]{"-", "+", "/", "*"}) {
            if (arr_equation[0].contains(operation)) eq_operation = operation ;
        }

        if (Objects.equals(null, eq_operation)) num_1 = new StringBuilder(arr_equation[0]);
        else  {
            num_1 = new StringBuilder(arr_equation[0].split("\\" + eq_operation )[0]);
            num_2 = new StringBuilder(arr_equation[0].split("\\" + eq_operation )[1]);
        }


        if (Objects.equals(null, num_2)) {
            double[] num1_arr = string_to_arr(num_1);
            double[] result_equation_arr = string_to_arr(result_equation);
            for (double num: num1_arr){
                for (double res: result_equation_arr){
                    if (num == res) return String.format("%s = %s", num, res);
                }
            }
        }
        else {

            double[] num1_arr = string_to_arr(num_1);
            double[] num2_arr = string_to_arr(num_2);
            double[] result_equation_arr = string_to_arr(result_equation);

            for (double num1: num1_arr){
                for (double num2: num2_arr){
                    double intermediate_res = simple_calc(num1, num2, eq_operation);
                    if (check(result_equation_arr, intermediate_res)) {
                        return String.format("%s %s %s = %s", num1, eq_operation, num2, simple_calc(num1, num2, eq_operation));
                    }
            }

        }
            return String.format("Выражени: %s - не имеет решения", equation);
        }
      return null;
    }


    static double[] string_to_arr(StringBuilder str) {
        if (str.indexOf("?") != -1) {
            int search_ind = str.indexOf("?");
            double[] str_arr = new double[10];
            int count = 0;
            int start = search_ind == 0 ? 1 : 0;
            for (int i = start; i < 10; i++) {
                str.setCharAt(search_ind, Character.forDigit(i, 10));
                str_arr[count] = Double.parseDouble(String.valueOf(str));
                count++;
            }
            return str_arr;
        } else return new double[]{Double.parseDouble(String.valueOf(str))};
    }

    public static boolean check(double[] arr, double target)
    {
        for (double i: arr)
        {
            if (target == i) {
                return true;
            }
        }
        return false;
    }
}

