import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта Scanner для введення з консолі
        Scanner scanner = new Scanner(System.in);

        // Введення дійсного числа x
        System.out.print("Введіть дійсне число x: ");
        double x = scanner.nextDouble();

        // Обчислення косинуса для введеного числа x
        double cosValue = Math.cos(x);

        // Виведення результату
        System.out.println("Косинус для введеного числа " + x + " дорівнює: " + cosValue);

        // Закриття Scanner
        scanner.close();
    }
}
