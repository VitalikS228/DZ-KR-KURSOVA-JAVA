import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CoffeeVan {
    private List<Coffee> coffeeList = new ArrayList<>();
    private double maxVolume;  // максимальний об'єм фургона

    public CoffeeVan(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void addCoffee(Coffee coffee) {
        // Перевірка на максимальний об'єм фургона
        double totalVolume = calculateTotalVolume();
        if (totalVolume + coffee.getWeight() > maxVolume) {
            System.out.println("Фургон перевищує максимальний об'єм! Кава " + coffee.getName() + " не була додана.");
            return;
        }

        coffeeList.add(coffee);
        System.out.println("Кава " + coffee.getName() + " додана до фургона.");
    }

    public void sortCoffeeByPriceWeightRatio() {
        Collections.sort(coffeeList, Comparator.comparingDouble(coffee -> coffee.getPrice() / coffee.getWeight()));
    }

    public List<Coffee> findCoffeeByQualityTypeAndPackaging(double minQuality, double maxQuality, CoffeeType type, PackagingType packagingType) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            double quality = coffee.getPrice() / coffee.getWeight();
            if (quality >= minQuality && quality <= maxQuality && coffee.getType() == type && coffee.getPackagingType() == packagingType) {
                result.add(coffee);
            }
        }
        return result;
    }

    public List<Coffee> findCoffeeByQualityAndType(double minQuality, double maxQuality, CoffeeType type) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            double quality = coffee.getPrice() / coffee.getWeight();
            if (quality >= minQuality && quality <= maxQuality && coffee.getType() == type) {
                result.add(coffee);
            }
        }
        return result;
    }

    public List<Coffee> findCoffeeByQuality(double minQuality, double maxQuality) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            double quality = coffee.getPrice() / coffee.getWeight();
            if (quality >= minQuality && quality <= maxQuality) {
                result.add(coffee);
            }
        }
        return result;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public double calculateTotalVolume() {
        double totalVolume = 0;
        for (Coffee coffee : coffeeList) {
            totalVolume += coffee.getWeight();
        }
        return totalVolume;
    }
}
