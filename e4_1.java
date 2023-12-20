import java.util.Scanner;

public class e4_1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input (int) p, q (devided by space): ");
        int p = in.nextInt();
        int q = in.nextInt();
        in.close();

        if (q == 0) {
            System.out.println("Dividing to zero is impossible.");
            return;
        }

        int int_part = p / q;
        p = p % q;

        StringBuilder res = new StringBuilder();
        res.append(int_part);
        res.append(".");

        int r = p;
        int position = 0;
        int[] positions = new int[q];

        while (r != 0 && positions[r] == 0) {
            positions[r] = position;
            r *= 10;
            res.append(r / q);
            r %= q;
            position++;
        }

        if (r != 0) {
            res.insert(res.length() - (position - positions[r]), "(");
            res.append(")");
        }

        System.out.println(res.toString());
    }
}
