package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

public class DeleteProductInputData {
    private final User user;
    private final Product product;

    public DeleteProductInputData(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}
