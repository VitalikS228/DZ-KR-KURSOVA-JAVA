import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Polynomial {
    int degree;           // Ступінь поліному
    double[] coefficients; // Коефіцієнти поліному

    // Конструктор для ініціалізації поліному
    public Polynomial(int degree, double[] coefficients) {
        this.degree = degree;
        this.coefficients = coefficients;
    }

    // Метод для обчислення значення поліному для заданого x
    public double calculate(double x) {
        double result = 0.0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(x, degree - i);
        }
        return result;
    }

    // Метод для отримання рядкового представлення поліному
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= degree; i++) {
            sb.append(coefficients[i]);
            if (degree - i > 0) {
                sb.append("x^").append(degree - i);
            }
            if (i < degree) {
                sb.append(" + ");
            }
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

        // Створення списку поліномів
        List<Polynomial> polynomialList = new ArrayList<>();
        polynomialList.add(new Polynomial(2, new double[]{1, -2, 1})); // x^2 - 2x + 1
        polynomialList.add(new Polynomial(1, new double[]{3, 0}));      // 3x
        polynomialList.add(new Polynomial(0, new double[]{4}));         // 4

        // Створення множини поліномів
        Set<Polynomial> polynomialSet = new HashSet<>();
        polynomialSet.add(new Polynomial(2, new double[]{1, -2, 1})); // x^2 - 2x + 1
        polynomialSet.add(new Polynomial(1, new double[]{3, 0}));      // 3x
        polynomialSet.add(new Polynomial(0, new double[]{4}));         // 4

        // Виведення поліномів у списку
        System.out.println("Список поліномів:");
        for (Polynomial polynomial : polynomialList) {
            System.out.println(polynomial);
        }

        // Виведення поліномів у множині
        System.out.println("\nМножина поліномів:");
        for (Polynomial polynomial : polynomialSet) {
            System.out.println(polynomial);
        }

        int m = 3; // Кількість поліномів у масиві



        // Створення масиву поліномів
        Polynomial[] polynomials = new Polynomial[m];
        polynomials[0] = new Polynomial(2, new double[]{1, -2, 1}); // x^2 - 2x + 1
        polynomials[1] = new Polynomial(1, new double[]{3, 0});      // 3x
        polynomials[2] = new Polynomial(0, new double[]{4});         // 4

        // Обчислення суми поліномів
        Polynomial sum = calculateSum(polynomials);

        // Виведення результатів
        System.out.println("Поліноми:");
        for (Polynomial polynomial : polynomials) {
            System.out.println(polynomial);
        }

        System.out.println("\nСума поліномів:");
        System.out.println(sum);
    }

    // Метод для обчислення суми поліномів у масиві
    private static Polynomial calculateSum(Polynomial[] polynomials) {
        int maxDegree = findMaxDegree(polynomials);

        double[] coefficientsSum = new double[maxDegree + 1];
        for (Polynomial polynomial : polynomials) {
            for (int i = 0; i <= polynomial.degree; i++) {
                coefficientsSum[i] += polynomial.coefficients[i];
            }
        }

        return new Polynomial(maxDegree, coefficientsSum);
    }

    // Метод для знаходження максимального ступеня серед поліномів у масиві
    private static int findMaxDegree(Polynomial[] polynomials) {
        int maxDegree = 0;
        for (Polynomial polynomial : polynomials) {
            maxDegree = Math.max(maxDegree, polynomial.degree);
        }
        return maxDegree;
    }
}