import java.util.Scanner;

public class e1_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your text, ctrl+z and enter on last line to finish:");

        int char_count = 0;
        int word_count = 0;
        int rows_count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char_count += line.length();
            word_count += count_words(line);
            rows_count++;
        }
        System.out.println("Characters: " + (char_count));
        System.out.println("Words: " + word_count);
        System.out.println("Rows: " + rows_count);
        scanner.close();
    }

    private static int count_words(String line) {
        if (line.isEmpty()) {
            return 0;
        }
        String[] words = line.split("\\s+");
        return words.length;
    }
}
