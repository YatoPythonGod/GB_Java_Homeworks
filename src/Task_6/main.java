package Task_6;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {

        Laptop lap_1 = new Laptop("Lenovo Legion 5", "Lenovo", "Black", "2K", "RTX 3070", "Intel 12700K", 32, 512, "Windows 10", 100000);
        Laptop lap_2 = new Laptop("Mac PRO 16", "Apple", "Silver", "4K", "M1", "M1", 32, 1024, "IOS", 200000);
        Laptop lap_3 = new Laptop("Asus Strix 3", "Asus", "Black", "2K", "RTX 3060", "Intel 12600K", 16, 512, "Windows 11", 120000);
        Laptop lap_4 = new Laptop("Asus Strix 3", "Asus", "White", "2K", "RTX 3060", "Intel 12600K", 16, 512, "Windows 11", 120000);

        System.out.println(lap_1);
        System.out.println(lap_2);
        System.out.println(lap_3);
        System.out.println(lap_4);

        HashSet<Laptop> shop = new HashSet<>();
        shop.add(lap_1);
        shop.add(lap_2);
        shop.add(lap_3);
        shop.add(lap_4);

        System.out.println(shop);
        System.out.println(shop.size());

        System.out.println(appStart(shop));

    }

    public static void mainMenu() {
        System.out.println("""
                Menu:
                1. MIN RAM size
                2. MIN Storage size
                3. OS
                4. Color
                5. Apply selection
                """);
    }

    public static int getInt(String msg) {
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }

    public static String getString(String msg) {
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        return result;
    }

    public static String appStart(HashSet<Laptop> shop){
        int user_choice = 0;
        int min_ram = 0;
        int min_storage = 0;
        String os = null;
        String color = null;

        while (user_choice != 5) {
            mainMenu();
            user_choice = getInt("Choice option please:");
            switch (user_choice) {
                case 1 -> min_ram = getInt("Please input minimum size of RAM:");
                case 2 -> min_storage = getInt("Please input minimum size of storage:");
                case 3 -> os = getString("Please input name OS:");
                case 4 -> color = getString("Please input laptops color:");
                case 5 -> System.out.println("See result...");
                default -> System.out.println("Incorrect input");
                }
        }
        ArrayList<Laptop> result = new ArrayList<>();

        for (Laptop lap: shop) {
            if(lap.getRam_size() >= min_ram && lap.getStorage_size()  >= min_storage && (color == null || lap.getColor().equals(color))
                    && (os == null || lap.getColor().equals(os))){
                result.add(lap);
            }
        }

        if (result.size() == 0) return "Sorry, the list of laptops satisfying your request is empty";

        StringBuilder choice_result = new StringBuilder();
        for (Laptop lap : result) {
            choice_result.append(lap.toString()).append("\n");
        }
        return choice_result.toString();
    }
}
