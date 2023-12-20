import java.util.Scanner;
import java.lang.Math;

public class e2_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input A and B separated by space: ");
        String s = in.nextLine();
        in.close();

        String[] numbers = s.split("\\s");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);

        System.out.printf("A = %d, B = %d\n", a, b);

        double Q = Math.sqrt(a * b);

        System.out.printf("Geometric mean of A and B is %f or %e", Q, Q);
    }
}
