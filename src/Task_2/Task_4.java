//4*. К калькулятору из предыдущего дз добавить логирование.

package Task_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.*;


public class Task_4 {
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

    static Double simple_calc(double num_1, double num_2, String operation) {
        Logger logger = Logger.getLogger(Task_2.class.getName());
        try {
            FileHandler fh = new FileHandler("src/Task_2/calc_log.log", true);
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            Map<String, Double> dictionary = new HashMap<String, Double>();
            dictionary.put(String.valueOf('-'), num_1 - num_2);
            dictionary.put(String.valueOf('+'), num_1 + num_2);
            dictionary.put(String.valueOf('/'), num_1 / num_2);
            dictionary.put(String.valueOf('*'), num_1 * num_2);
            logger.log(Level.INFO, String.format("User input: %s %s %s", num_1, operation, num_2));
            double result = dictionary.get(operation);
            logger.log(Level.INFO, String.format("Result: %s", result));
            return result;
        } catch (IOException ex) {
            logger.log(Level.WARNING, "IOException ", ex.getMessage());
        }
        return 0.0;
    }
}
