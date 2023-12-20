package e6_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class e6_1 {

    public static void main(String[] args) {
        try {
            File file_name = new File("e6_1/input.txt");
            Scanner scanner = new Scanner(file_name);
            List<Double> numbers = new ArrayList<>();

            while (scanner.hasNext()) {
                numbers.add(scanner.nextDouble());
            }

            scanner.close();

            double sum = get_sum(numbers);
            System.out.println("a) Sum of file components: " + sum + "\n");

            int negative_count = get_negative_count(numbers);
            System.out.println("b) Number of negative components: " + negative_count + "\n");

            double last_number = get_last_number(numbers);
            System.out.println("c) Last file component: " + last_number + "\n");

            double max_number = get_max_number(numbers);
            System.out.println("d) Largest file component: " + max_number + "\n");

            double min_even_number = get_min_even_number(numbers);
            System.out.println("e) Smallest component of a file with pair number: " + min_even_number + "\n");

            double[] max_min_sum = get_max_min_sum(numbers);
            System.out.println("f) Largest component: " + max_min_sum[0]);
            System.out.println("f) Smallest component: " + max_min_sum[1]);
            System.out
                    .println("f) Sum of largest and smallest components: " + (max_min_sum[0] + max_min_sum[1]) + "\n");

            double[] first_last_diff = get_first_last_diff(numbers);
            System.out.println("g) First component: " + first_last_diff[0]);
            System.out.println("g) Last component: " + first_last_diff[1]);
            System.out
                    .println("g) The difference between the first and last components: "
                            + (first_last_diff[0] - first_last_diff[1]) + "\n");

            double average = get_average(numbers);
            int below_average_count = get_below_average_count(numbers, average);
            System.out.println("h) Arithmetic mean of the file components: " + average);
            System.out.println("h) Number of components less than the arithmetic mean: " + below_average_count);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static double get_sum(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int get_negative_count(List<Double> numbers) {
        int count = 0;
        for (double number : numbers) {
            if (number < 0) {
                count++;
            }
        }
        return count;
    }

    private static double get_last_number(List<Double> numbers) {
        return numbers.get(numbers.size() - 1);
    }

    private static double get_max_number(List<Double> numbers) {
        double max = Double.MIN_VALUE;
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static double get_min_even_number(List<Double> numbers) {
        double min_even = Double.MAX_VALUE;
        for (int i = 0; i < numbers.size(); i += 2) {
            if (numbers.get(i) < min_even) {
                min_even = numbers.get(i);
            }
        }
        return min_even;
    }

    private static double[] get_max_min_sum(List<Double> numbers) {
        double max = get_max_number(numbers);
        double min = get_min_number(numbers);
        return new double[] { max, min };
    }

    private static double get_min_number(List<Double> numbers) {
        double min = Double.MAX_VALUE;
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static double[] get_first_last_diff(List<Double> numbers) {
        double first = numbers.get(0);
        double last = numbers.get(numbers.size() - 1);
        return new double[] { first, last };
    }

    private static int get_below_average_count(List<Double> numbers, double average) {
        int count = 0;
        for (double number : numbers) {
            if (number < average) {
                count++;
            }
        }
        return count;
    }

    private static double get_average(List<Double> numbers) {
        double sum = get_sum(numbers);
        return sum / numbers.size();
    }
}
