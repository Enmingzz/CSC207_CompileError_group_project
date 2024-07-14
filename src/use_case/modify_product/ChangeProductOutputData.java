package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

public class ChangeProductOutputData {
    private final Product product;
    private final String message;
    private final User user;

    public ChangeProductOutputData(Product product, String message, User user) {
        this.product = product;
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
    public Product getProduct() {
        return product;
    }
    public User getUser() {
        return user;
    }
}
