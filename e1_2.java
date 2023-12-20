import java.util.Scanner;

public class e1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input first string: ");
        String s1 = in.nextLine();
        System.out.println("Input second string: ");
        String s2 = in.nextLine();
        in.close();

        if (s1.equals(s2)) {
            System.out.println("Stringgs are equal");
        } else {
            System.out.println("Strings are not equal((");
        }
    }
}
