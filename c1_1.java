public class c1_1 {
    public static void main(String[] args) {
        String[] strs = { "word_1", "word_2", "word_3", "word_4", "word_5" };

        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]);
            if (i < strs.length - 1) {
                System.out.print(", ");
            }
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.printf("\nidx - %d : %s", i, strs[i]);
        }
    }
}
