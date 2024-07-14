package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

public class DeleteProductOutputData {
    private final Product product;
    private final User user;

    public DeleteProductOutputData(User user, Product product) {
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
