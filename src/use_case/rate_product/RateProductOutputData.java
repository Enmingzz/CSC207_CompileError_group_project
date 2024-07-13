package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

public class RateProductOutputData {
    private Product product;
    private User user;

    public RateProductOutputData(User user, Product product) {
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
