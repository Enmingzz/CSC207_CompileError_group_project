package use_case.shopping_cart;

import entity.product.Product;
import entity.user.User;

public class ConfirmInputData {
    private User user;
    private Product product;

    public ConfirmInputData(User user, Product product) {
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
