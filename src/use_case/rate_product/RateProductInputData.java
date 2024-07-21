package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

/**
 * Data class for encapsulating the input data required for rating a product.
 *
 * This class holds the necessary information for the rate product use case,
 * including the user rating, the user performing the rating, and the product being rated.
 */
public class RateProductInputData {

    private final User user;
    private final String rating;
    private final Product product;

    /**
     * Constructs an instance of {@code RateProductInputData} with the specified user,
     * rating, and product.
     *
     * @param user The user providing the rating.
     * @param rating The rating given by the user.
     * @param product The product being rated.
     */
    public RateProductInputData(User user, String rating, Product product) {
        this.user = user;
        this.rating = rating;
        this.product = product;
    }

    /**
     * Returns the user providing the rating.
     *
     * @return The user providing the rating.
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the rating given by the user.
     *
     * @return The rating given by the user.
     */
    public String getRating() {
        return rating;
    }

    /**
     * Returns the product being rated.
     *
     * @return The product being rated.
     */
    public Product getProduct() {
        return product;
    }
}
