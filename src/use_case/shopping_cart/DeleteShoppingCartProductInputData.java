package use_case.shopping_cart;

import entity.product.Product;
import entity.user.User;


public class DeleteShoppingCartProductInputData {
    final private User user;
    // user of cart
    final private Product product;
    // modify_product to be deleted

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
