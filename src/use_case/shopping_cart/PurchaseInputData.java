package use_case.shopping_cart;

import entity.product.Product;
import entity.user.User;

public class PurchaseInputData {
    private final User user;
    private final Product product;

    public PurchaseInputData(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    User getUser() {
        return user;
    }

    Product getProduct() {
        return product;
    }
}
