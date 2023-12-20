import java.util.Scanner;

public class e2_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input n, m (devided by space): ");
        int n = in.nextInt();
        int m = in.nextInt();
        in.close();

        int f = 1 << m;
        int num = n ^ f;
        System.out.printf("X = %d", num);
    }
}
