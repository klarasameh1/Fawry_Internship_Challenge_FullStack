public class ShippableProduct extends Product implements IShippable {
     private double weight;

    public ShippableProduct(String name, int price, int quantity, boolean isExpireable, double weight) {
        super(name, price, quantity, isExpireable, true);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}

