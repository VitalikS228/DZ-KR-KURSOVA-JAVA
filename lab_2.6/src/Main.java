import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int rows = 3; // Кількість рядків матриці
        int cols = 3; // Кількість стовпців матриці

        // Створення матриці
        int[][] matrix = new int[rows][cols];

        // Заповнення матриці випадковими числами
        fillMatrixRandomly(matrix);

        // Виведення матриці на екран
        System.out.println("Матриця:");
        printMatrix(matrix);

        // Обчислення та виведення норми матриці
        double norm = calculateMatrixNorm(matrix);
        System.out.println("Норма матриці: " + norm);
    }

    // Метод для заповнення матриці випадковими числами
    private static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10); // Випадкове число від 0 до 9 (можна змінити за потребою)
            }
        }
    }

    // Метод для виведення матриці на екран
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Метод для обчислення норми матриці
    private static double calculateMatrixNorm(int[][] matrix) {
        double sum = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += Math.pow(matrix[i][j], 2);
            }
        }
        return Math.sqrt(sum);
    }
}