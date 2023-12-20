package k6_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class k6_6 {
    // add exception for incorrect data and coordinates
    // (string #4 is invalid for rectangle conditions)

    public static void main(String[] args) {
        findMaxRectangleArea("k6_6/input.txt");
    }

    public static void findMaxRectangleArea(String file_name) {
        int max_area = Integer.MIN_VALUE;
        int max_x1 = 0, max_y1 = 0, max_x2 = 0, max_y2 = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] tokens = str.split(" ");

                if (tokens.length != 5) {
                    System.out.println("Incorrect data: " + str);
                    continue;
                }

                int x1 = Integer.parseInt(tokens[1]);
                int y1 = Integer.parseInt(tokens[2]);
                int x2 = Integer.parseInt(tokens[3]);
                int y2 = Integer.parseInt(tokens[4]);

                if (x1 >= x2 || y1 <= y2) {
                    System.out.println("Incorrect coordinates: " + str);
                    continue;
                }

                int area = Math.abs((x2 - x1) * (y2 - y1));
                if (area > max_area) {
                    max_area = area;
                    max_x1 = x1;
                    max_y1 = y1;
                    max_x2 = x2;
                    max_y2 = y2;
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println("Maximum area: " + max_area);
        System.out.println("Coordinates of the rectangle with the maximum area:");
        System.out.println("Upper left corner: (" + max_x1 + ", " + max_y1 + ")");
        System.out.println("Bottom right corner: (" + max_x2 + ", " + max_y2 + ")");
    }
}
