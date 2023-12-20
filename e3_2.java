import java.util.Random;

public class e3_2 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            int rand1 = random.nextInt(100);
            int rand2 = random.nextInt(100);
            if (rand1 > rand2) {
                System.out.println(rand1 + " is more than " + rand2);
            } else if (rand1 < rand2) {
                System.out.println(rand1 + " is less than " + rand2);
            } else {
                System.out.println(rand1 + " equal to the " + rand2);
            }
        }
    }
}
