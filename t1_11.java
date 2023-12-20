import java.util.Scanner;

public class t1_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість об'єктів:");
        int numberOfObjects = scanner.nextInt();
        scanner.nextLine(); // Очищаємо буфер після nextInt()

        double totalX = 0.0;
        double totalY = 0.0;
        double totalMass = 0.0;

        for (int i = 0; i < numberOfObjects; i++) {
            System.out.println("Введіть координати та масу для об'єкта " + (i + 1) + " (x, y, m):");
            String input = scanner.nextLine();
            String[] values = input.split(",");

            if (values.length == 3) {
                double x = Double.parseDouble(values[0]);
                double y = Double.parseDouble(values[1]);
                double mass = Double.parseDouble(values[2]);

                totalX += x * mass;
                totalY += y * mass;
                totalMass += mass;
            } else {
                System.out.println("Неправильний формат введення. Повторіть спробу.");
                i--; // Зменшуємо лічильник, щоб коректно обробити некоректне введення
            }
        }

        if (totalMass > 0) {
            double centroidX = totalX / totalMass;
            double centroidY = totalY / totalMass;

            System.out.printf("Центр мас: (%.2f, %.2f, %.2f)%n", centroidX, centroidY, totalMass);
        } else {
            System.out.println("Неможливо обчислити центр мас для введених даних.");
        }

        scanner.close();
    }
}