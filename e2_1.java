public class e2_1 {
    public static void main(String[] args) {
        int a = 0xD430;
        int b = 0xF431;
        System.out.printf("a = %d, b = %d\n", a, b);

        int op_not = ~a;
        int op_and = a & b;
        int op_or = a | b;
        int op_xor = a ^ b;
        int op_rshift = a >> b;
        int op_lshift = a << b;
        int op_zero_rshift = a >>> b;
        System.out.printf("Not (a) = %s\n", Integer.toBinaryString(op_not));
        System.out.printf("Left shift (a,b) = %s\n", Integer.toBinaryString(op_lshift));
        System.out.printf("OR (a,b) = %s\n", Integer.toBinaryString(op_or));
        System.out.printf("AND (a,b) = %s\n", Integer.toBinaryString(op_and));
        System.out.printf("XOR (a,b) = %s\n", Integer.toBinaryString(op_xor));
        System.out.printf("Right shift (a,b) = %s\n", Integer.toBinaryString(op_rshift));
        System.out.printf("Zero right shift (a,b) = %s\n", Integer.toBinaryString(op_zero_rshift));
    }
}