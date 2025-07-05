import java.util.*;

public class CheckOutService {

    public static void checkout(Customer customer) throws Exception {
        Cart cart = customer.getCart();

        if (cart.isEmpty()) {
            throw new Exception("Cart is empty");
        }

        // Initialize totals
        double subtotal = 0;
        double totalWeight = 0;

        // Prepare output lists
        List<String> shippingLines = new ArrayList<>();
        List<String> receiptLines = new ArrayList<>();

        // Process each item
        // Inside the CheckOutService.checkout() method, modify the item processing
        // loop:
        for (CartItem item : cart.getItems()) {
            Product product = item.product;
            int quantity = item.quantity;

            if (product.isShippable() && product instanceof ExpireableProduct) {
                ExpireableProduct shippable = (ExpireableProduct) product;
                double itemTotal = product.getPrice() * quantity;
                double itemWeight = shippable.getWeight() * quantity;

                subtotal += itemTotal;
                totalWeight += itemWeight;

                shippingLines.add(String.format("%dx %s %dg",
                        quantity, product.getName(), (int) (shippable.getWeight() * 1000)));
                receiptLines.add(String.format("%dx %s %d",
                        quantity, product.getName(), (int) itemTotal));
            }
        }

        // Calculate final amounts
        double shipping = totalWeight * 30;
        double total = subtotal + shipping;

        // Validate balance
        if (customer.getBalance() < total) {
            throw new Exception("Insufficient balance");
        }

        // Process payment and update inventory
        customer.deduct(total);
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        // Print output in exact requested format
        printOutput(shippingLines, receiptLines, totalWeight, subtotal, shipping, total);
    }

    private static void printOutput(List<String> shippingLines,
            List<String> receiptLines,
            double totalWeight,
            double subtotal,
            double shipping,
            double total) {
        // Shipment notice
        System.out.println("** Shipment notice **");
        for (String line : shippingLines) {
            System.out.println(line);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);

        // Receipt
        System.out.println("\n** Checkout receipt **");
        for (String line : receiptLines) {
            System.out.println(line);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %d\n", (int) subtotal);
        System.out.printf("Shipping %d\n", (int) shipping);
        System.out.printf("Amount %d\n", (int) total);
    }
}