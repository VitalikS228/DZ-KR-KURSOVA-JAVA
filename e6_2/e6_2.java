package e6_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class e6_2 {

    public static void main(String[] args) {
        try {
            List<Integer> components = read_components_from_file("e6_2/input.txt");

            number_of_even(components);
            number_of_squares_of_odd(components);
            min_max_diff(components);
            max_increasing_sequence(components);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> read_components_from_file(String filePath) throws IOException {
        List<Integer> components = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                components.add(scanner.nextInt());
            }
        }
        return components;
    }

    private static void number_of_even(List<Integer> components) {
        long count = components.stream().filter(x -> x % 2 == 0).count();
        System.out.println("a) Number of even components: " + count + "\n");
    }

    private static void number_of_squares_of_odd(List<Integer> components) {
        long count = components.stream()
                .filter(x -> x % 2 != 0)
                .mapToInt(x -> x)
                .filter(x -> Math.sqrt(x) % 1 == 0)
                .count();
        System.out.println("b) Number of squares of odd numbers: " + count + "\n");
    }

    private static void min_max_diff(List<Integer> components) {
        int max_even = components.stream().filter(x -> x % 2 == 0).max(Integer::compareTo).orElse(0);
        int min_odd = components.stream().filter(x -> x % 2 != 0).min(Integer::compareTo).orElse(0);

        System.out.println("c) Max even number: " + max_even);
        System.out.println("c) Min odd number: " + min_odd);
        System.out.println("c) Difference: " + (max_even - min_odd) + "\n");
    }

    private static void max_increasing_sequence(List<Integer> components) {
        List<Integer> max_sequence = new ArrayList<>();
        List<Integer> current_sequence = new ArrayList<>();

        for (int i = 0; i < components.size() - 1; i++) {
            if (components.get(i) < components.get(i + 1)) {
                current_sequence.add(components.get(i));

                if (i == components.size() - 2) {
                    current_sequence.add(components.get(i + 1));
                }
            } else {
                current_sequence.add(components.get(i));
                if (current_sequence.size() > max_sequence.size()) {
                    max_sequence = new ArrayList<>(current_sequence);
                }
                current_sequence.clear();
            }
        }

        System.out.println("d) Max increasing sequence: " + Arrays.toString(max_sequence.toArray()));
        System.out.println("d) Number of components in the sequence: " + max_sequence.size());
    }
}
