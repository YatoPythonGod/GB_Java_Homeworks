package Task_1;

//Реализовать простой калькулятор

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Task_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Please enter first number: ");
        double number_1 = Double.parseDouble(iScanner.nextLine());
        System.out.print("Please enter second number: ");
        double number_2 = Double.parseDouble(iScanner.nextLine());
        System.out.print("Please enter operation: ");
        String operation = iScanner.nextLine();
        System.out.println(simple_calc(number_1, number_2, operation));
        iScanner.close();

    }

    static Double simple_calc (double num_1, double num_2, String operation){
        Map<String, Double> dictionary = new HashMap<String, Double>();
        dictionary.put(String.valueOf('-'), num_1 - num_2);
        dictionary.put(String.valueOf('+'), num_1 + num_2);
        dictionary.put(String.valueOf('/'), num_1 / num_2);
        dictionary.put(String.valueOf('*'), num_1 * num_2);
        return dictionary.get(operation);
    }

}
