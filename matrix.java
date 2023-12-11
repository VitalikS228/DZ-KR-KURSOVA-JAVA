import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class matrix {
    private int[][] a;

    public matrix() {
        Scanner in_1 = new Scanner(System.in);

        System.out.print("Console input (print 1) or random fill (print 0)?\n");
        int flag = in_1.nextInt();
        if (flag == 1) {
            console_input();
        }
        if (flag == 0) {
            random_fill();
        }
    }

    private void console_input() {
        Scanner in_2 = new Scanner(System.in);

        System.out.print("Input matrix dimensions (n m): ");
        int n = in_2.nextInt();
        int m = in_2.nextInt();
        a = new int[n][m];

        in_2.nextLine();

        System.out.println("Input matrix elements separated by space in rows:");

        for (int i = 0; i < n; i++) {
            System.out.printf("Input row #%d (%d elements): ", i + 1, m);
            String line = in_2.nextLine();
            String[] elements = line.split(" ");

            while (elements.length != m) {
                System.out.println("Error: wrong elements count");
                System.out.printf("Input row #%d (%d elements): ", i + 1, m);
                line = in_2.nextLine();
                elements = line.split(" ");
            }

            for (int j = 0; j < m; j++) {
                while (!elements[j].matches("\\d+")) {
                    System.out.println("Error: input must be only integer numbers");
                    System.out.printf("Input row #%d (%d elements): ", i + 1, m);
                    line = in_2.nextLine();
                    elements = line.split(" ");
                }
                a[i][j] = Integer.parseInt(elements[j]);
            }
        }
    }

    private void random_fill() {
        Random rand = new Random();
        Scanner in_3 = new Scanner(System.in);
        System.out.print("Input matrix dimensions (n m): ");
        int n = in_3.nextInt();
        int m = in_3.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = rand.nextInt(2 * n + 1) - n;
            }
        }
    }

    public void sort_rows() { // 2_1
        for (int i = 0; i < a.length; i++) {
            Arrays.sort(a[i]);
        }
    }

    public void sort_columns() { // 2_1
        for (int col = 0; col < a[0].length; col++) {
            int[] column = new int[a.length];

            for (int row = 0; row < a.length; row++) {
                column[row] = a[row][col];
            }
            Arrays.sort(column);
            for (int row = 0; row < a.length; row++) {
                a[row][col] = column[row];
            }
        }
    }

    public void cyclic_shift(int k) { // 2_2
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m];

        switch (k) {
            case 1: // right
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int new_col = (j + 1) % m;
                        result[i][new_col] = a[i][j];
                    }
                }
                break;
            case 2: // left
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int new_col = (j - 1 + m) % m;
                        result[i][new_col] = a[i][j];
                    }
                }
                break;
            case 3: // up
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int new_row = (i - 1 + n) % n;
                        result[new_row][j] = a[i][j];
                    }
                }
                break;
            case 4: // down
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int new_row = (i + 1) % n;
                        result[new_row][j] = a[i][j];
                    }
                }
                break;
            default:
                System.out.println("\nInvalid input. k must be 1,2,3 or 4 for shift right, left, up and down.");
                break;
        }
        a = result;
    }

    public void largest_increasing_group() { // 2_3
        int max_count = 0;
        int current_count = 1;
        int[] largest_group = new int[a.length * a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length - 1; j++) {
                if (a[i][j] < a[i][j + 1]) {
                    current_count++;
                } else {
                    if (current_count > max_count) {
                        max_count = current_count;
                        int start_idx = j - max_count + 1;
                        for (int k = 0; k < max_count; k++) {
                            largest_group[k] = a[i][start_idx + k];
                        }
                    }
                    current_count = 1;
                }
            }
        }

        if (current_count > max_count) {
            max_count = current_count;
            int startIndex = a[0].length - max_count;
            for (int k = 0; k < max_count; k++) {
                largest_group[k] = a[a.length - 1][startIndex + k];
            }
        }

        if (max_count > 1) {
            System.out.println("\nLargest increasing group: ");
            for (int k = 0; k < max_count; k++) {
                System.out.print(largest_group[k] + " ");
            }
            System.out.println("\nAmount of elements in largest increasing group: " + max_count);
        } else {
            System.out.println("\nThere is no increasing group.");
        }
    }

    public int[] sum_between_positive() { // 2_4
        int n = a.length;
        int m = a[0].length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int first_positive = -1;
            int second_positive = -1;

            for (int j = 0; j < m; j++) {
                if (a[i][j] > 0) {
                    if (first_positive == -1) {
                        first_positive = j;
                    } else if (second_positive == -1) {
                        second_positive = j;
                        break;
                    }
                }
            }

            if (first_positive != -1 && second_positive != -1) {
                for (int j = first_positive + 1; j < second_positive; j++) {
                    sum += a[i][j];
                }
            }
            result[i] = sum;
        }

        return result;
    }

    public void compress_matrix() {
        int num_rows = a.length;
        int num_cols = a[0].length;

        boolean[] zero_rows = new boolean[num_rows];
        boolean[] zero_cols = new boolean[num_cols];

        for (int i = 0; i < num_rows; i++) {
            boolean all_zeros = true;
            for (int j = 0; j < num_cols; j++) {
                if (a[i][j] != 0) {
                    all_zeros = false;
                    break;
                }
            }
            zero_rows[i] = all_zeros;
        }

        for (int j = 0; j < num_cols; j++) {
            boolean all_zeros = true;
            for (int i = 0; i < num_rows; i++) {
                if (a[i][j] != 0) {
                    all_zeros = false;
                    break;
                }
            }
            zero_cols[j] = all_zeros;
        }

        int new_num_rows = 0;
        int new_num_cols = 0;

        for (boolean zero_row : zero_rows) {
            if (!zero_row) {
                new_num_rows++;
            }
        }

        for (boolean zero_col : zero_cols) {
            if (!zero_col) {
                new_num_cols++;
            }
        }

        int[][] compressed_matrix = new int[new_num_rows][new_num_cols];
        int new_row = 0;

        for (int i = 0; i < num_rows; i++) {
            int new_col = 0;
            if (!zero_rows[i]) {
                for (int j = 0; j < num_cols; j++) {
                    if (!zero_cols[j]) {
                        compressed_matrix[new_row][new_col] = a[i][j];
                        new_col++;
                    }
                }
                new_row++;
            }
        }

        a = compressed_matrix;
    }

    public int[][] get_matrix() {
        return a;
    }

    public void print_matrix() {
        System.out.println("Matrix a[" + a.length + "][" + a[0].length + "]:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        matrix matrix = new matrix();
        matrix.print_matrix();
    }

}
