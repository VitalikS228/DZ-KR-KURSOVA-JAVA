import java.util.Scanner;

public class e2_2 { // 2_2 test
    public static void main(String[] args) {
        matrix test = new matrix();
        System.out.println("Initial matrix:");
        test.print_matrix();

        Scanner in = new Scanner(System.in);

        System.out.print("How you want to shift matrix? Input 1 - for right, 2 - left, 3 - up, 4 - down: ");
        int flag = in.nextInt();

        test.cyclic_shift(flag);
        test.print_matrix();

    }
}
