package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

public class RateProductInputData {
    private final User user;
    private final String rating;
    private final Product product;

    public RateProductInputData(User user, String rating, Product product) {
        this.user = user;
        this.rating = rating;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public String getRating() {
        return rating;
    }

    public Product getProduct() {
        return product;
    }
}
