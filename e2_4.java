public class e2_4 { // 2_4 test
    public static void main(String[] args) {
        matrix test = new matrix();
        test.print_matrix();

        int[][] matrix_data = test.get_matrix();
        int[] sums = test.sum_between_positive();
        System.out.println("Sum between first and second positive elements in each row:");
        for (int i = 0; i < sums.length; i++) {
            System.out.print("Row " + (i + 1) + ": Sum = " + sums[i] + " ; ");

            int first_positive = -1;
            int second_positive = -1;

            for (int j = 0; j < matrix_data[i].length; j++) {
                if (matrix_data[i][j] > 0) {
                    if (first_positive == -1) {
                        first_positive = j;
                    } else if (second_positive == -1) {
                        second_positive = j;
                        break;
                    }
                }
            }

            if (first_positive != -1 && second_positive != -1) {
                System.out.print("Elements: ");
                for (int j = first_positive; j <= second_positive; j++) {
                    System.out.print(matrix_data[i][j] + " ");
                }
                System.out.println();
            } else {
                System.out.println("There is no two positive elements in row.");
            }
        }
    }
}
