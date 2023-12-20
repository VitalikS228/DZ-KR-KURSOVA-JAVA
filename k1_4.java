import java.util.StringTokenizer;

public class e1_4 {
    public static void main(String[] args) {
        String str = "This is a small example of sentence with an article";
        System.out.println("Original text: " + str);

        String result = remove_articles(str);

        System.out.println("Text after removing articles: " + result);
    }

    public static String remove_articles(String str) {
        StringBuffer result_buffer = new StringBuffer();
        StringTokenizer tokenizer = new StringTokenizer(str);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            if (!word.equalsIgnoreCase("a") && !word.equalsIgnoreCase("an")) {
                result_buffer.append(word).append(" ");
            }
        }

        return result_buffer.toString().trim();
    }
}
