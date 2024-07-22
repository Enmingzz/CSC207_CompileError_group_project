package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

/**
 * Represents the output data for the rate product use case.
 *
 * This class contains information about the product being rated and the user who is
 * performing the rating. It is used to pass data between the rate product use case and
 * the view or presenter.
 */
public class RateProductOutputData {

    private final Product product;
    private final User user;

    /**
     * Constructs a new RateProductOutputData object.
     *
     * @param user    The user who is rating the product.
     * @param product The product being rated.
     */
    public RateProductOutputData(User user, Product product) {
        this.product = product;
        this.user = user;
    }

    /**
     * Returns the product being rated.
     *
     * @return The product being rated.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the user who is rating the product.
     *
     * @return The user who is rating the product.
     */
    public User getUser() {
        return user;
    }
}
