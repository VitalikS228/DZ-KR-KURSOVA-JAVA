import java.util.Scanner;

public class e1_1 {

    public static void main(String[] args) {
        // !!! counts words by spaces, so in text "hello , world" will be 3 words
        // (just to show 2 variants)
        // another method witch detect punctuation marks not as words
        // is given in exercise e1_7
        String str = "This is the text that is defined in the program";
        System.out.println("Text defined in the program: \n" + str);
        System.out.println("Number of words in the text:" + count_words(str));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInput text to count words:");
        str = scanner.nextLine();
        System.out.println("Number of words in your text: " + count_words(str));

        scanner.close();
    }

    private static int count_words(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] words = str.split("\\s+");
        return words.length;
    }
}
