public class e2_3 {
    public static void main(String[] args) {
        char[] characters = { 'K', 'N', 'U', '1', '2', '3' };
        for (char c : characters) {
            String binchar = char_to_binary(c);
            System.out.printf("%s = %s\n", c, binchar);
        }
    }

    public static String char_to_binary(char c) {
        int uc_value = (int) c;
        String binchar = Integer.toBinaryString(uc_value);
        while (binchar.length() < 8) {
            binchar = "0" + binchar;
        }
        return binchar;
    }
}
