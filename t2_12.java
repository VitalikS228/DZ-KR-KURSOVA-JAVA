import java.util.Scanner;

public class t2_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення натурального числа M
        System.out.print("Введіть натуральне число M: ");
        long m = scanner.nextLong();

        // Введення номеру біта j
        System.out.print("Введіть номер біта j: ");
        int j = scanner.nextInt();

        // Встановлення біта з номером j рівним нулю
        long result = setBitToZero(m, j);

        // Виведення результату в десятковому та шістнадцятковому вигляді
        System.out.println("Отримане число в десятковому вигляді: " + result);
        System.out.println("Отримане число в шістнадцятковому вигляді: " + Long.toHexString(result));
    }

    // Метод для встановлення біта з номером j рівним нулю
    private static long setBitToZero(long number, int position) {
        // Використовуємо побітові операції для встановлення біта в 0
        return number & ~(1L << position);
    }
}