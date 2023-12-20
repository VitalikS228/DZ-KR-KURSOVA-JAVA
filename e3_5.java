import java.util.Arrays;
import java.util.Scanner;

public class e3_5 {

    public static void main(String[] args) {
        int[] numbers = new int[5];
        Scanner in = new Scanner(System.in);
        System.out.print("Input 5 int numbers (devided by space): ");
        numbers[0] = in.nextInt();
        numbers[1] = in.nextInt();
        numbers[2] = in.nextInt();
        numbers[3] = in.nextInt();
        numbers[4] = in.nextInt();
        in.close();

        Arrays.sort(numbers);
        System.out.println("median: " + numbers[2]);
    }
}
