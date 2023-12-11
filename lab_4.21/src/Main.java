public class Main {
    public static void main(String[] args) {
        double x = 5.0; // Ваше значення x

        // Обчислення експоненти за рядом Тейлора
        double expByTaylorSeries = calculateExponential(x);

        // Обчислення експоненти за допомогою бібліотечної функції
        double expByLibraryFunction = Math.exp(x);

        // Виведення результатів
        System.out.println("Значення за рядом Тейлора: " + expByTaylorSeries);
        System.out.println("Значення за допомогою бібліотеки: " + expByLibraryFunction);

        // Порівняння результатів
        double epsilon = 1e-10; // Точність порівняння
        if (Math.abs(expByTaylorSeries - expByLibraryFunction) < epsilon) {
            System.out.println("Результати співпадають.");
        } else {
            System.out.println("Результати не співпадають.");
        }
    }

    // Метод для обчислення експоненти за рядом Тейлора
    private static double calculateExponential(double x) {
        double result = 1.0;
        double term = 1.0;
        int n = 1;

        while (Math.abs(term) > 1e-10) {
            term *= x / n;
            result += term;
            n++;
        }

        return result;
    }
}