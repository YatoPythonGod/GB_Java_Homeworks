package Task_4;

import java.util.*;

//* В калькулятор добавьте возможность отменить последнюю операцию.
public class Task_3 {
    public static void main(String[] args) {
        Queue<Double> queue = new LinkedList<>();
        StringBuilder out_print = new StringBuilder();
        Scanner iScanner = new Scanner(System.in);
        String operation = null;
        double result = 0.0;
        double back_number = 0.0;
        double d_number = 0.0;
        boolean flag = true;

        // back - отмена операции
        // exit - выход

        while (flag) {
            if (isNumeric(String.valueOf(out_print))) {
                System.out.print("Please enter operation: ");
                String pre_operation = iScanner.nextLine().toLowerCase();
                if (pre_operation.equals("exit")) {
                    flag = false;
                    continue;
                } else if (pre_operation.equals("back")) {
                    out_print.setLength(0);
                    if (back_number != 0) {
                        out_print.append(back_number);
                        System.out.println(out_print);
                        if (result != 0.0) result = back_number;
                        queue.clear();
                        queue.add(back_number);
                        continue;}
                    else {
                        queue.clear();
                        continue;}

                } else {
                    operation = pre_operation;
                    out_print.append(String.format(" %s ", operation));
                    System.out.println(out_print);
                }
            }

            System.out.print("Please enter number: ");
            String number = iScanner.nextLine().toLowerCase();
            if (number.equals("exit")) {
                flag = false;
                continue;
            } else if (number.equals("back")) {
                out_print.setLength(0);
                if (result != 0.0) {
                    out_print.append(result);
                }
                else if (queue.size() == 1 && result == 0.0){
                    out_print.append(queue.peek());
                }
                System.out.println(out_print);
                continue;
            }
            d_number = Double.parseDouble(number);
            queue.add(d_number);
            out_print.append(number);
            System.out.println(out_print);

            if (queue.size() > 1 && operation != null) {
                back_number = queue.poll();
                result = simple_calc(back_number, queue.poll(), operation);
                queue.add(result);
                out_print = new StringBuilder(Double.toString(result));
                System.out.println(out_print);
            }

        }

        iScanner.close();


    }

    static Double simple_calc(double num_1, double num_2, String operation) {
        Map<String, Double> dictionary = new HashMap<String, Double>();
        dictionary.put(String.valueOf('-'), num_1 - num_2);
        dictionary.put(String.valueOf('+'), num_1 + num_2);
        dictionary.put(String.valueOf('/'), num_1 / num_2);
        dictionary.put(String.valueOf('*'), num_1 * num_2);
        return dictionary.get(operation);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
