import java.util.Scanner;

public class e1_24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input items amount (int): ");
        int items_amount = scanner.nextInt();
        System.out.print("Input max backpack weight (int): ");
        int max_weight = scanner.nextInt();

        int[] weights = new int[items_amount];
        for (int i = 0; i < items_amount; i++) {
            System.out.print("Input item " + (i + 1) + " weight (int): ");
            weights[i] = scanner.nextInt();
        }
        int result = backpack(items_amount, max_weight, weights);
        System.out.printf("Max weight that a backpack with your things can carry - %d", result);
    }

    public static int backpack(int N, int W, int[] weights) {
        if (N == 0 || W == 0) {
            return 0;
        }
        if (weights[N - 1] > W) {
            return backpack(N - 1, W, weights);
        } else {
            int include = weights[N - 1] + backpack(N - 1, W - weights[N - 1], weights);
            int exclude = backpack(N - 1, W, weights);
            return Math.max(include, exclude);
        }
    }
}
