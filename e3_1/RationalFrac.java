package e3_1;

public class RationalFrac {
    private int num;
    private int den;

    public RationalFrac(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        if ((num < 0 && den > 0) || (num > 0 && den < 0)) {
            this.num = -Math.abs(num);
        } else {
            this.num = Math.abs(num);
        }

        this.den = Math.abs(den);
        simplify();
    }

    private void simplify() {
        int gcd = gcd(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;
        if (den < 0) {
            num = -num;
            den = -den;
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // addition
    public RationalFrac add(RationalFrac other) {
        int new_num = this.num * other.den + other.num * this.den;
        int new_den = this.den * other.den;
        return new RationalFrac(new_num, new_den);
    }

    // subtraction
    public RationalFrac subtract(RationalFrac other) {
        int new_num = this.num * other.den - other.num * this.den;
        int new_den = this.den * other.den;
        return new RationalFrac(new_num, new_den);
    }

    // multiplication
    public RationalFrac multiply(RationalFrac other) {
        int new_num = this.num * other.num;
        int new_den = this.den * other.den;
        return new RationalFrac(new_num, new_den);
    }

    // division
    public RationalFrac divide(RationalFrac other) {
        if (other.num == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        int new_num = this.num * other.den;
        int new_den = this.den * other.num;
        return new RationalFrac(new_num, new_den);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    public static void main(String[] args) {
        int k = 3;
        RationalFrac[] fractions = new RationalFrac[k];

        fractions[0] = new RationalFrac(1, 2);
        fractions[1] = new RationalFrac(3, 4);
        fractions[2] = new RationalFrac(2, 3);

        System.out.println("Fractions:");
        for (RationalFrac fraction : fractions) {
            System.out.println(fraction);
        }

        RationalFrac add_result = fractions[0].add(fractions[1]);
        System.out.println("\nadding: " + fractions[0] + " + " + fractions[1] + " = " + add_result);

        RationalFrac sub_result = fractions[0].subtract(fractions[1]);
        System.out.println("\nsubstracting: " + fractions[0] + " - " + fractions[1] + " = " + sub_result);

        RationalFrac mul_result = fractions[0].multiply(fractions[1]);
        System.out.println("\nmultiplying: " + fractions[0] + " * " + fractions[1] + " = " + mul_result);

        RationalFrac div_result = fractions[0].divide(fractions[1]);
        System.out.println("\ndividing: (" + fractions[0] + ") / (" + fractions[1] + ") = " + div_result);

        // sum
        RationalFrac sum = new RationalFrac(0, 1);
        for (RationalFrac fraction : fractions) {
            sum = sum.add(fraction);
        }

        System.out.println("\nSum of all fractions: " + sum + "\n");
    }
}
