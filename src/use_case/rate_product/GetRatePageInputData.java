package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

public class GetRatePageInputData {
    private final User user;
    private final Product product;

    public GetRatePageInputData(User user, Product product) {
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
