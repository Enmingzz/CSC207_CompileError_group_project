package use_case.shopping_cart;

import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;

public class DeleteShoppingCartProductOutputData {
    private final User user;
    private final ArrayList<Product> listProducts;
    private final float totalPrice;

    public DeleteShoppingCartProductOutputData(User user, ArrayList<Product> listProducts, float totalPrice) {
        this.user = user;
        this.listProducts = listProducts;
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
