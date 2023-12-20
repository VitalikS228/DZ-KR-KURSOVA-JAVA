import java.util.Scanner;
import java.lang.Math;

public class e4_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input (x1 y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Input (x2 y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.println("Input (x3 y3):");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        double s = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        System.out.println("S = " + s);

        scanner.close();
    }
}
