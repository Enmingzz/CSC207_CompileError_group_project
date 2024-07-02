package use_case.shopping_cart;

import entity.user.User;
import entity.product.Product;
import java.util.List;

public class AddShoppingCartProductOutputData {
    private final User user;
    private final List<Product> listProducts;
    private final float totalPrice;

    public AddShoppingCartProductOutputData(User user, List<Product> listProducts, float totalPrice) {
        this.user = user;
        this.listProducts = listProducts;
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
