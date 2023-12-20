import java.util.Scanner;

public class e1_2 {

    public static void main(String[] args) {
        String str = "This is the text that is defined in the program";
        System.out.println("Text defined in the program: \n" + str);
        System.out.println("Reversed text: \n" + reverse_string(str));
        System.out.println("Reversed text by words: \n" + reverse_words(str));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInput text to reverse:");
        str = scanner.nextLine();
        System.out.println("Reversed text: \n" + reverse_string(str));
        System.out.println("Reversed text by words: \n" + reverse_words(str));

        scanner.close();
    }

    private static String reverse_string(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    private static String reverse_words(String str) {
        String[] words = str.split("\\s+");
        StringBuilder reversed_words = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed_words.append(words[i]).append(" ");
        }
        return reversed_words.toString().trim();
    }
}
