import java.util.StringTokenizer;

public class e1_3 {
    public static void main(String[] args) {
        String str = "This is a small example of a small text thats contains a word 'small'";

        String result = replace_words(str);

        System.out.println("Original text: " + str);
        System.out.println("Modified text: " + result);
    }

    private static String replace_words(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, " ");

        StringBuffer result_buffer = new StringBuffer();

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            if (word.equals("small")) {
                result_buffer.append("very large");
            } else {
                result_buffer.append(word);
            }

            result_buffer.append(" ");
        }

        return result_buffer.toString().trim();
    }
}
