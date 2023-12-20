package e1_5_debug;

public class debug_class {
    public static void debug(String... args) {
        System.out.print("Debug: ");
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }
}
