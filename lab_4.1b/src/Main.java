import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення x: ");
        double x = scanner.nextDouble();

        double result = calculatePolynomial(x);

        System.out.println("Результат обчислення многочлена: " + result);
    }

    public static double calculatePolynomial(double x) {
        // Обчислення значення многочлена y = x^4 + x^3 + x^2 + x + 1
        double xSquared = x * x;
        double xCubed = xSquared * x;
        double xToPower4 = xCubed * x;
        double result = xToPower4 + xCubed + xSquared + x + 1;

        return result;
    }
}