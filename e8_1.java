import java.util.ArrayList;
import java.util.List;

class Payment {
    private List<Item> items;

    public Payment() {
        this.items = new ArrayList<>();
    }

    public void add_item(String name, double price, int quantity) {
        Item item = new Item(name, price, quantity);
        items.add(item);
    }

    public double calculate_check() {
        double sum = 0;
        for (Item item : items) {
            sum += item.calculate_position();
        }
        return sum;
    }

    public void Receipt() {
        System.out.println("Receipt:");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println("Total: UAH " + calculate_check());
    }

    private class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double calculate_position() {
            return price * quantity;
        }

        @Override
        public String toString() {
            return name + " - UAH " + price + " x " + quantity + " = UAH " + calculate_position();
        }
    }
}

public class e8_1 {

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.add_item("Black T-shirt", 599, 2);
        payment.add_item("Nike sneakers", 2345, 1);
        payment.add_item("Silver ring", 3300, 1);
        payment.add_item("Christmas socks with deers", 80, 5);

        payment.Receipt();
    }
}
