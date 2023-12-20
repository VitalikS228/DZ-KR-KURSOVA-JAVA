package e6_1;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Flower> flowers;
    private double accessory_price;

    public Bouquet() {
        this.flowers = new ArrayList<>();
        this.accessory_price = 0;
    }

    public void add_flower(Flower flower) {
        flowers.add(flower);
    }

    public void add_accessory(String accessory) {
        accessory_price += Double.parseDouble(accessory.split(" ")[accessory.split(" ").length - 2]);
    }

    public double calculate_price() {
        double price = accessory_price;
        for (Flower flower : flowers) {
            price += flower.getPrice();
        }
        return price;
    }

    public void print_bouquet() {
        System.out.println("\nBouquet:");
        for (Flower flower : flowers) {
            System.out.println(flower.toString());
        }
        System.out.println("Accessory Price: " + accessory_price + " UAH");
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public double getAccessoryPrice() {
        return accessory_price;
    }
}
