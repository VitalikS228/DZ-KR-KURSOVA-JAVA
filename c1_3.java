import java.util.Scanner;

public class c1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input amount of numbers: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.println("Amount of numbers must be more than 0.");
            System.out.print("Input amount of numbers: ");
            n = scanner.nextInt();
        }

        double[] numbers = new double[n];
        double sum = 0.0;
        double sq_sum = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.print("Input number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
            sq_sum += numbers[i] * numbers[i];
        }
        scanner.close();

        double mean = sum / n;
        double var = (sq_sum / n) - (mean * mean);
        double dev = Math.sqrt(var);

        System.out.printf("Mean - %f", mean);
        System.out.printf("\nSample standard deviation - %f", dev);
    }
}
