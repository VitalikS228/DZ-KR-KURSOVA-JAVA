import java.util.Scanner;
import java.lang.Math;

public class e2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input A (int): ");
        Double a = in.nextDouble();
        System.out.print("Input B (int): ");
        String b = in.next();
        in.close();

        System.out.printf("A = %f, B = %s\n", a, b);

        int a_digintcount = (int) (Math.log10(a) + 1); // через логарифм
        int b_digintcount = (int) (b.length()); // через довжину рядку
        System.out.printf("A have %d digits, and B have %s digits\n", a_digintcount, b_digintcount);

        double Q = 1 / ((1 / a) + (1 / Double.parseDouble(b)));

        System.out.printf("Garmonic mean of A and B is %.2f", Q);
    }
}
