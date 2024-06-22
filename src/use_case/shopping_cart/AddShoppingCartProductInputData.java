package use_case.shopping_cart;

import entity.product.Product;
import entity.user.User;

public class AddShoppingCartProductInputData {
    private Product product;
    private User user;

    public AddShoppingCartProductInputData(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}
