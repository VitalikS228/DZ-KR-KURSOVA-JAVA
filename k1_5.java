import java.util.StringTokenizer;

public class e1_5 {
    public static void main(String[] args) {
        String str = "This is a small example of text that contains small and large words";

        String result = addVeryBeforeWords(str);

        System.out.println("Original text: " + str);
        System.out.println("Modified text:" + result);
    }

    private static String addVeryBeforeWords(String str) {
        StringBuffer result_buffer = new StringBuffer();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            if (word.equals("small") || word.equals("large")) {
                result_buffer.append("very ").append(word).append(" ");
            } else {
                result_buffer.append(word).append(" ");
            }
        }

        return result_buffer.toString().trim();
    }
}
