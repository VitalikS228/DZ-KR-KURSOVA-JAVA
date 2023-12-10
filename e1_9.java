
/**
 * Import of scanner
 */
import java.util.Scanner;

/**
 * Creating class
 */
public class e1_9 {
    /**
     * Main program
     * <p>
     * HTML list:
     * <ul>
     * <li>This is</li>
     * <li>HTML</li>
     * <li>list</li>
     * </ul>
     * </p>
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
         * Answering the user
         */
        System.out.println("Hello, " + name);
        /**
         * Closing scanner
         */
        scanner.close();
    }
}
