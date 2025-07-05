import java.time.LocalDate;

public class ExpireableProduct extends Product {
    private LocalDate expiryDate;
    private double weight;  // Add weight field

    public ExpireableProduct(String name, int price, int quantity, 
                           LocalDate expiryDate, double weight) {  // Add weight parameter
        super(name, price, quantity, true, true);  // Set isShippable to true
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public double getWeight() {  // Add getter for weight
        return weight;
    }
}