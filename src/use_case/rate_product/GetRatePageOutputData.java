package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

public class GetRatePageOutputData {
    private final Product product;
    private final User user;

    public GetRatePageOutputData(User user, Product product) {
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
