package e6_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerShop {
    private static List<Flower> flowers;
    private static List<String> Accessories;

    static {
        flowers = new ArrayList<>();
        flowers.add(new Flower("Rose", 51.2, 3, 30));
        flowers.add(new Flower("Tulip", 82.1, 5, 25));
        flowers.add(new Flower("Lily", 24.3, 4, 35));

        Accessories = new ArrayList<>();
        Accessories.add("Blue tape - 10.0 UAH");
        Accessories.add("Red tape - 10.0 UAH");
        Accessories.add("White wrap - 15.5 UAH");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice; // console menu
        Bouquet bouquet = null;

        do {
            System.out.println("\n1. Create bouquet and calculate price");
            System.out.println("2. Sort flowers by freshness");
            System.out.println("3. Find flowers by length");
            System.out.println("0. Exit");

            System.out.print("Select option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bouquet = create_bouquet(scanner);
                    break;
                case 2:
                    sort_flowers_by_freshness();
                    break;
                case 3:
                    find_flowers_by_length(scanner);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Wrong choice. Select 0-3:");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static Bouquet create_bouquet(Scanner scanner) {
        Bouquet bouquet = new Bouquet();
        int flower_choice;
        boolean flag = false;

        do {
            System.out.println("\nFlowers:");
            for (int i = 0; i < flowers.size(); i++) {
                System.out.println((i + 1) + ". " + flowers.get(i).toString());
            }
            System.out.print("Select flower to add (0 to finish): ");
            flower_choice = scanner.nextInt();
            if (flower_choice > 0 && flower_choice <= flowers.size()) {
                bouquet.add_flower(flowers.get(flower_choice - 1));
                flag = true;
            }
        } while (flower_choice != 0);

        if (!flag) {
            System.out.println("Cannot create a bouquet without flowers. Please add at least one flower.");
            return null;
        }

        add_accessory_to_bouquet(scanner, bouquet);

        System.out.println("Your bouquet created!");
        System.out.println("Bouquet price is " + bouquet.calculate_price() + " UAH");

        return bouquet;
    }

    private static void add_accessory_to_bouquet(Scanner scanner, Bouquet bouquet) {
        System.out.println("\nAccessories:");
        for (int i = 0; i < Accessories.size(); i++) {
            System.out.println((i + 1) + ". " + Accessories.get(i));
        }

        System.out.print("Select accessory to add: ");
        int accessory_choice = scanner.nextInt();

        if (accessory_choice > 0 && accessory_choice <= Accessories.size()) {
            bouquet.add_accessory(Accessories.get(accessory_choice - 1));
        }
    }

    private static void sort_flowers_by_freshness() {
        flowers.sort((f1, f2) -> f2.getFreshness() - f1.getFreshness());
        System.out.println("\nSorted Flowers:");
        print_flowers();
    }

    private static void find_flowers_by_length(Scanner scanner) {
        System.out.print("Minimal length: ");
        double min_length = scanner.nextDouble();
        System.out.print("Maximum length: ");
        double max_length = scanner.nextDouble();

        List<Flower> selected_flowers = new ArrayList<>();
        for (Flower flower : flowers) {
            double len = flower.getLength();
            if (len >= min_length && len <= max_length) {
                selected_flowers.add(flower);
            }
        }
        System.out.println("Flowers with length between " + min_length + " and " + max_length + ":");
        for (Flower flower : selected_flowers) {
            System.out.println(flower.getName() + " - " + flower.getLength() + " cm");
        }
    }

    private static void print_flowers() {
        System.out.println("Available Flowers:");
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }
}
