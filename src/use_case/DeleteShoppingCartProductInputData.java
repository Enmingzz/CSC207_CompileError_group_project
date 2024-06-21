package use_case;

import entity.Product;
import entity.User;


public class DeleteShoppingCartProductInputData {
    final private User user;
    // user of cart
    final private Product product;
    // product to be deleted

    public DeleteShoppingCartProductInputData(User user, Product product) {
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
