import java.util.Scanner;

public class c1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input integers devided by space: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        int current_number = Integer.parseInt(numbers[0]);
        int max_count = 1;
        int current_count = 1;
        int max_number = current_number;

        for (int i = 1; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);

            if (num == current_number) {
                current_count++;
                if (current_count > max_count) {
                    max_count = current_count;
                    max_number = current_number;
                }
            } else {
                current_number = num;
                current_count = 1;
            }
        }
        System.out.print(max_number + " is repeated " + max_count + " times in a row.");
    }
}
