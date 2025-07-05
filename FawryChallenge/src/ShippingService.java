import java.util.List;

public class ShippingService {
    public static void ship(List<IShippable> items) {
        System.out.println("Shipping the following items:");
        for (IShippable item : items) {
            System.out.println("- " + item.getName() + " (Weight: " + item.getWeight() + ")");
        }
    }
}
