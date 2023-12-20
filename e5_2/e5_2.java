package e5_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class e5_2 {

    public static int count_empty_strings(String file_name) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (str.trim().isEmpty()) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int max_len_strings(String file_name) {
        int max = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            String str;
            while ((str = br.readLine()) != null) {
                int len = str.length();
                if (len > max) {
                    max = len;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return max;
    }

    public static void main(String[] args) {
        String file_name = "e5_2/input.txt";

        int emoty_strings = count_empty_strings(file_name);
        System.out.println("Number of empty strings in file: " + emoty_strings);

        int max_len = max_len_strings(file_name);
        System.out.println("Maximum length of strings in file: " + max_len);
    }
}
