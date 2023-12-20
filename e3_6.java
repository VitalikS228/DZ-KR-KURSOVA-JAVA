import java.util.Random;

public class e3_6 {
    public static void main(String[] args) {
        int n = 9999999;
        int alice_wins = 0;

        for (int i = 0; i < n; i++) {
            int aliceCount = 0;
            int bobCount = 0;
            boolean alice_condition_1 = false;
            boolean alice_condition_2 = false;
            boolean bob_condition = false;
            Random rand = new Random();

            while (true) {

                Boolean drop = rand.nextBoolean();
                if (drop && alice_condition_1) {
                    alice_condition_2 = true;
                } else if (drop && alice_condition_1 == false) {
                    alice_condition_1 = true;
                } else {
                    alice_condition_1 = false;
                    alice_condition_2 = false;
                }

                drop = rand.nextBoolean();
                if (drop == false && bob_condition) {
                    break;
                } else if (drop && bob_condition) {
                    bob_condition = false;
                } else if (drop && bob_condition == false) {
                    bob_condition = true;
                }

                if (alice_condition_2) {
                    alice_wins++;
                    break;
                }

            }

            if (aliceCount < bobCount) {
                alice_wins++;
            }
        }

        double p = (double) alice_wins / n;
        System.out.printf("Result - %f", p);
    }
}
