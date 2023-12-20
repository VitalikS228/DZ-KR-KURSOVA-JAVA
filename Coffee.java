class Coffee {
    private String name;
    private double weight; // вага в грамах
    private double price;  // ціна за грам
    private CoffeeType type;  // тип кави
    private PackagingType packagingType; // тип фасування

    public Coffee(String name, double weight, double price, CoffeeType type, PackagingType packagingType) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.packagingType = packagingType;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public CoffeeType getType() {
        return type;
    }

    public PackagingType getPackagingType() {
        return packagingType;
    }

    @Override
    public String toString() {
        return name + " (Type: " + type + ", Packaging: " + packagingType + ")";
    }
}
