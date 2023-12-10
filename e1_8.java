
/**
 * Import of scanner
 */
import java.util.Scanner;

/**
 * Creating class
 */
public class e1_8 {
    /**
     * Main programm
     * 
     * @param params parameters
     */
    public static void main(String[] params) {
        /**
         * Creating new scanner object
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * Output of the question
         */
        System.out.println("What is your name? ");
        /**
         * Reading answer
         */
        String name = scanner.nextLine();
        /**
         * Answering to user
         */
        System.out.println("Hello, " + name);
        /**
         * Closing scanner
         */
        scanner.close();
    }
}