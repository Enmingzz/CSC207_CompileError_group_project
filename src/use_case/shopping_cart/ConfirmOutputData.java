package use_case.shopping_cart;

import entity.user.User;
import entity.product.Product;

public class ConfirmOutputData {
    private final User user;
    private final Product product;

    public ConfirmOutputData(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }
}
