class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class SimpleFraction {
    private Number numerator;
    private Number denominator;

    public SimpleFraction(Number numerator, Number denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Виведення дробу на екран
    public void display() {
        System.out.println(numerator.getValue() + "/" + denominator.getValue());
    }

    // Додавання двох дробів
    public SimpleFraction add(SimpleFraction otherFraction) {
        Number newNumerator = new Number(this.numerator.getValue() * otherFraction.denominator.getValue() +
                otherFraction.numerator.getValue() * this.denominator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * otherFraction.denominator.getValue());

        return new SimpleFraction(newNumerator, newDenominator);
    }

    // Віднімання двох дробів
    public SimpleFraction subtract(SimpleFraction otherFraction) {
        Number newNumerator = new Number(this.numerator.getValue() * otherFraction.denominator.getValue() -
                otherFraction.numerator.getValue() * this.denominator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * otherFraction.denominator.getValue());

        return new SimpleFraction(newNumerator, newDenominator);
    }

    // Множення двох дробів
    public SimpleFraction multiply(SimpleFraction otherFraction) {
        Number newNumerator = new Number(this.numerator.getValue() * otherFraction.numerator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * otherFraction.denominator.getValue());

        return new SimpleFraction(newNumerator, newDenominator);
    }

    // Ділення двох дробів
    public SimpleFraction divide(SimpleFraction otherFraction) {
        Number newNumerator = new Number(this.numerator.getValue() * otherFraction.denominator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * otherFraction.numerator.getValue());

        return new SimpleFraction(newNumerator, newDenominator);
    }
}

public class Main {
    public static void main(String[] args) {
        Number numerator1 = new Number(3);
        Number denominator1 = new Number(4);
        SimpleFraction fraction1 = new SimpleFraction(numerator1, denominator1);

        Number numerator2 = new Number(2);
        Number denominator2 = new Number(5);
        SimpleFraction fraction2 = new SimpleFraction(numerator2, denominator2);

        // Додавання
        SimpleFraction sum = fraction1.add(fraction2);
        System.out.print("Сума: ");
        sum.display();

        // Віднімання
        SimpleFraction difference = fraction1.subtract(fraction2);
        System.out.print("Різниця: ");
        difference.display();

        // Множення
        SimpleFraction product = fraction1.multiply(fraction2);
        System.out.print("Добуток: ");
        product.display();

        // Ділення
        SimpleFraction quotient = fraction1.divide(fraction2);
        System.out.print("Частка: ");
        quotient.display();
    }
}
