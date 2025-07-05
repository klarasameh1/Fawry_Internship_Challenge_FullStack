public class Product {
    String name;
    int price;
    int quantity;
    boolean isExpireable;
    boolean isShippable;

    public Product(String name, int price, int quantity, boolean isExpireable , boolean isShippable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpireable = isExpireable;
        this.isShippable = isShippable;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void reduceQuantity(int amount) { quantity -= amount; }
    public boolean isExpireable() { return isExpireable; }
    public boolean isShippable() { return isShippable; }


}
