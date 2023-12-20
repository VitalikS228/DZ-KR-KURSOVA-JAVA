public class e2_2 {
    public static void main(String[] args) {

        int a = 0x7FFFFFFF;
        System.out.printf("a = %d = %s\n", a, Integer.toBinaryString(a));

        int n = 0;
        while (a != 0) {
            a = a >> 1;
            n += 1;
            System.out.printf("a >> 1 = %s, iteration %d\n", Integer.toBinaryString(a), n);
        }
        System.out.print("\n");

        int b = 0b1011010111001;
        System.out.printf("b = %d = %s\n", b, Integer.toBinaryString(b));

        b = b << 5;
        System.out.printf("b << 5 = %d = %s\n\n", b, Integer.toBinaryString(b));

        n = 0;
        while (b != 0) {
            b = b >>> 1;
            n += 1;
            System.out.printf("b >>> 1 = %s, iteration %d\n", Integer.toBinaryString(b), n);
        }

    }
}
