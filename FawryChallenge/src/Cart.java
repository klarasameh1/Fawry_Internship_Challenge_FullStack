import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) throws Exception {
        if (quantity > product.getQuantity()) {
            throw new Exception("Not enough quantity available.");
        }
        if (product instanceof ExpireableProduct && ((ExpireableProduct) product).isExpired()) {
            throw new Exception("Cannot add expired product: " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
