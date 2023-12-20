import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.print("Input integers. Input 0 to stop reading: ");

        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            if (input > max) {
                max = input;
            }
            if (input < min) {
                min = input;
            }
        }

        if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
            System.out.println("Nothing in input, but 0");
        } else {
            System.out.printf("Max: %d\n", max);
            System.out.printf("Min: %d", min);
        }
        scanner.close();
    }
}
