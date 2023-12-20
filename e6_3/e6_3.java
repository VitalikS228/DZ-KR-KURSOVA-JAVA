package e6_3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class e6_3 {

    private static final String input_file_name = "e6_3/input.txt";
    private static final String output_file_name = "e6_3/output.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        do {
            System.out.println("1. With even numbers");
            System.out.println("2. With numbers divisible by 3 and 5");
            System.out.println("3. With exact squares");
            System.out.println("4. With numbers in reverse order");
            System.out.println("5. With all numbers without repetitions");
            System.out.println("6. Exit");
            System.out.println("Select option to fill output.txt:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    fill_file(get_even_numbers(read_file(input_file_name)));
                    break;
                case 2:
                    fill_file(get_numbers_divisible_by_3_and_5(read_file(input_file_name)));
                    break;
                case 3:
                    fill_file(get_perfect_squares(read_file(input_file_name)));
                    break;
                case 4:
                    fill_file(get_reversed_numbers(read_file(input_file_name)));
                    break;
                case 5:
                    fill_file(get_distinct_numbers(read_file(input_file_name)));
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect choice");
            }

            if (!exit) {
                System.out.println("The output.txt file is filled. Do you want to continue? (y/n)");
                String continueChoice = scanner.next().toLowerCase();
                if (!continueChoice.equals("yes")) {
                    exit = true;
                }
            }
        } while (!exit);

        System.out.println("Program terminated.");
        scanner.close();
    }

    private static List<Integer> read_file(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            List<Integer> numbers = new ArrayList<>();
            while (fileScanner.hasNextInt()) {
                numbers.add(fileScanner.nextInt());
            }
            return numbers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static void fill_file(List<Integer> numbers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(output_file_name))) {
            for (int num : numbers) {
                writer.print(num + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> get_even_numbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    private static List<Integer> get_numbers_divisible_by_3_and_5(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 3 == 0 && n % 5 == 0).collect(Collectors.toList());
    }

    private static List<Integer> get_perfect_squares(List<Integer> numbers) {
        return numbers.stream().filter(n -> Math.sqrt(n) % 1 == 0).collect(Collectors.toList());
    }

    private static List<Integer> get_reversed_numbers(List<Integer> numbers) {
        Collections.reverse(numbers);
        return numbers;
    }

    private static List<Integer> get_distinct_numbers(List<Integer> numbers) {
        return new ArrayList<>(new HashSet<>(numbers));
    }
}
