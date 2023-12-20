import java.util.Scanner;

public class e2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = in.nextLine();
        System.out.printf("Hello, %s", name);
        in.close();
    }
}