import java.util.Scanner;
import java.util.StringTokenizer;

public class e1_7 {

    public static void main(String[] args) { // counts words by spaces, but detect punctuation marks
        String str = "This is the text. Yes, this text is defined in the program!";
        System.out.println("Text defined in the program: \n" + str);

        System.out.println("Number of characters: " + count_characters(str));
        System.out.println("Number of punctuation marks: " + count_punctuation(str));
        System.out.println("Number of words: " + count_words(str));
        System.out.println("Number of sentences: " + count_sentences(str));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInput text to count characters, punctuation marks, words and sentences:");
        str = scanner.nextLine();

        System.out.println("Number of characters: " + count_characters(str));
        System.out.println("Number of punctuation marks: " + count_punctuation(str));
        System.out.println("Number of words: " + count_words(str));
        System.out.println("Number of sentences: " + count_sentences(str));

        scanner.close();
    }

    private static int count_words(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        StringTokenizer tokenizer = new StringTokenizer(str);
        int word_count = 0;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (contains_letters_or_numbers(token)) {
                word_count++;
            }
        }

        return word_count;
    }

    private static boolean contains_letters_or_numbers(String str) {
        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    private static int count_characters(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        return str.length();
    }

    private static int count_punctuation(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int punctuation_count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
            } else if (Character.isWhitespace(c)) {
            } else {
                punctuation_count++;
            }
        }

        return punctuation_count;
    }

    private static int count_sentences(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        StringTokenizer tokenizer = new StringTokenizer(str, ".!?");
        return tokenizer.countTokens();
    }
}
