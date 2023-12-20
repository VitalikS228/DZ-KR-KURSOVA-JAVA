import java.util.Scanner;

public class e3_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a, b, c (devided by space): ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        in.close();

        int uniqueValues = 0;

        if (a != b && a != c) {
            uniqueValues++;
        }
        if (b != a && b != c) {
            uniqueValues++;
        }
        if (c != a && c != b) {
            uniqueValues++;
        }

        System.out.println("number of different values among " + a + ", " + b + ", " + c + " is " + uniqueValues);
    }
}
