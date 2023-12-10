public class e1_5 {
    public static void main(String[] params) {
        if (params.length != 3) { // if wrong input
            System.out.println("Input 3 parameters:");
        } else {
            String p1 = params[0];
            String p2 = params[1];
            String p3 = params[2];

            System.out.println("Your parameters: " + p1 + ", " + p2 + ", " + p3);
        }
    }
}
