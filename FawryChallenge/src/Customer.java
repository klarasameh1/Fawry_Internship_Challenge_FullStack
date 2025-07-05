public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }
    public void deduct(double amount) { balance -= amount; }
    public Cart getCart() { return cart; }
}
