import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створимо фургон з максимальним об'ємом
        System.out.print("Введіть максимальний об'єм фургона (в грамах): ");
        double maxVolume = scanner.nextDouble();
        CoffeeVan coffeeVan = new CoffeeVan(maxVolume);

        // Додамо різні типи кави до фургона
        coffeeVan.addCoffee(new Coffee("Arabica", 500, 0.02, CoffeeType.GRAIN, PackagingType.JAR));
        coffeeVan.addCoffee(new Coffee("Robusta", 700, 0.015, CoffeeType.GROUND, PackagingType.PACKET));
        coffeeVan.addCoffee(new Coffee("Instant Coffee", 300, 0.03, CoffeeType.INSTANT, PackagingType.JAR));

        // Додайте інші типи кави

        // Перевіримо, чи фургон не перевищує максимальний об'єм
        double totalVolume = coffeeVan.calculateTotalVolume();
        if (totalVolume > coffeeVan.getMaxVolume()) {
            System.out.println("Фургон перевищує максимальний об'єм!");
            return;
        }

        // Введіть діапазон параметрів якості та типу кави
        System.out.print("Введіть мінімальний рейтинг якості: ");
        double minQuality = scanner.nextDouble();
        System.out.print("Введіть максимальний рейтинг якості: ");
        double maxQuality = scanner.nextDouble();
        System.out.print("Введіть тип кави (GRAIN, GROUND, INSTANT): ");
        String coffeeTypeStr = scanner.next();
        CoffeeType coffeeType;
        try {
            coffeeType = CoffeeType.valueOf(coffeeTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Введений неправильний тип кави. Використовуйте GRAIN, GROUND або INSTANT.");
            return;
        }

        System.out.print("Введіть тип фасування (JAR, PACKET): ");
        String packagingTypeStr = scanner.next();
        PackagingType packagingType;
        try {
            packagingType = PackagingType.valueOf(packagingTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Введений неправильний тип фасування. Використовуйте JAR або PACKET.");
            return;
        }

        // Знайти каву, яка відповідає заданим параметрам якості, типу та фасування
        List<Coffee> selectedCoffee = coffeeVan.findCoffeeByQualityTypeAndPackaging(minQuality, maxQuality, coffeeType, packagingType);

        // Вивести результат
        System.out.println("Сортована кава:");
        for (Coffee coffee : coffeeVan.findCoffeeByQuality(minQuality, maxQuality)) {
            System.out.println(coffee);
        }

        System.out.println("Кава відповідно до заданих параметрів якості, типу та фасування:");
        for (Coffee coffee : selectedCoffee) {
            System.out.println(coffee);
        }
    }
}
