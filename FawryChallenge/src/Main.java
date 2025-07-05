import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Declaring Products with weight parameter for cheese
            Product cheese = new ExpireableProduct("Cheese 400g", 100, 10, 
                                                 LocalDate.now().plusDays(5), 0.4);
                                                 
            Product scratchCard = new Product("Scratch Card", 50, 10, false, false);
            Product tv = new Product("TV", 50, 10, false, false);

            // Create customer
            Customer customer = new Customer("Klara", 2000.0);

            Cart cart = customer.getCart();
            // Adding Products to the cart
            cart.add(cheese, 2);
            cart.add(tv, 3);
            cart.add(scratchCard, 1);

            // Checking out
            CheckOutService.checkout(customer);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}