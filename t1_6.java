public class t1_6 {
    public static void main(String[] params) {
        double sum = 0.0;
        int count = 0;
        for (String p : params) {
            try {
                double num = Double.parseDouble(p);
                sum += num;
                count++;
            } catch (NumberFormatException e) { // if not number
            }
        }
        System.out.println("Sum: " + sum + ", Count:" + count);
    }
}
