import java.util.Scanner;

public class e2_1 { // 2_1 test
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        matrix test = new matrix();
        System.out.println("Initial matrix:");
        test.print_matrix();

        System.out.print("What you want to sort? Input 1 for rows, 0 for columns: ");
        int flag = in.nextInt();

        if (flag == 1) {
            test.sort_rows();
            System.out.println("Matrix sorted in rows:");
            test.print_matrix();
        }
        if (flag == 0) {
            test.sort_columns();
            System.out.println("Matrix sorted in columns:");
            test.print_matrix();
        }
    }
}
