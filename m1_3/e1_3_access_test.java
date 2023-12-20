public class e1_3_access_test {
    public static void main(String[] args) {
        e1_3_class e1_3_example = new e1_3_class();

        System.out.println("Public field: " + e1_3_example.public_field);
        // System.out.println("Private field: " + e1_3_example.private_field); // error
        System.out.println("Protected field: " + e1_3_example.protected_field);
        System.out.println("Default field: " + e1_3_example.default_access_field);

        e1_3_example.public_method();
        // e1_3_example.private_method(); // error
        e1_3_example.protected_method();
        e1_3_example.default_access_method();
    }
}
