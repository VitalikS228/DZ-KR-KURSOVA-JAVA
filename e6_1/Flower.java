package e6_1;

public class Flower {
    private String name;
    private double price;
    private int freshness;
    private double length;

    public Flower(String name, double price, int freshness, double length) {
        this.name = name;
        this.price = price;
        this.freshness = freshness;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Flower: " + name + ", " + price + " UAH, freshness " + freshness + "/5, " + length + " cm.";
    }
}
