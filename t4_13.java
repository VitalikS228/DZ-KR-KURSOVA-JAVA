import java.util.Arrays;

class Vector {
    private double[] components;

    public Vector(double[] components) {
        this.components = Arrays.copyOf(components, components.length);
    }

    // Метод інкремента
    public void increment() {
        for (int i = 0; i < components.length; i++) {
            components[i]++;
        }
    }

    // Метод декремента
    public void decrement() {
        for (int i = 0; i < components.length; i++) {
            components[i]--;
        }
    }

    // Метод індексування
    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return components[index];
    }

    // Метод для обчислення скалярного добутку
    public static double dotProduct(Vector v1, Vector v2) {
        if (v1.components.length != v2.components.length) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }

        double result = 0;
        for (int i = 0; i < v1.components.length; i++) {
            result += v1.components[i] * v2.components[i];
        }

        return result;
    }

    // Метод для обчислення довжини вектора
    public double length() {
        double sumOfSquares = 0;
        for (double component : components) {
            sumOfSquares += Math.pow(component, 2);
        }

        return Math.sqrt(sumOfSquares);
    }

    // Метод для обчислення кута між векторами в радіанах
    public static double angleBetween(Vector v1, Vector v2) {
        double dotProduct = dotProduct(v1, v2);
        double v1Length = v1.length();
        double v2Length = v2.length();

        return Math.acos(dotProduct / (v1Length * v2Length));
    }

    public static void main(String[] args) {
        // Приклад використання
        double[] components1 = {1, 2, 3};
        double[] components2 = {4, 5, 6};

        Vector vector1 = new Vector(components1);
        Vector vector2 = new Vector(components2);

        vector1.increment();
        vector2.decrement();

        System.out.println("Vector 1: " + Arrays.toString(components1));
        System.out.println("Vector 2: " + Arrays.toString(components2));

        System.out.println("Dot Product: " + dotProduct(vector1, vector2));
        System.out.println("Length of Vector 1: " + vector1.length());
        System.out.println("Length of Vector 2: " + vector2.length());

        double angle = angleBetween(vector1, vector2);
        System.out.println("Angle between vectors (in radians): " + angle);
    }
}
