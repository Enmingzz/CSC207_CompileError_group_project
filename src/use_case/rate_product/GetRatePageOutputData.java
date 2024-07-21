package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

/**
 * Represents the output data for retrieving a rating page.
 *
 * This class encapsulates the data required for displaying the rating page, including
 * information about the user and the product being rated.
 */
public class GetRatePageOutputData {

    private final Product product;
    private final User user;

    /**
     * Constructs a new instance of {@code GetRatePageOutputData}.
     *
     * @param user The user associated with the rating page.
     * @param product The product that is being rated.
     */
    public GetRatePageOutputData(User user, Product product) {
        this.product = product;
        this.user = user;
    }

    /**
     * Gets the product associated with the rating page.
     *
     * @return The product being rated.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the user associated with the rating page.
     *
     * @return The user who is interacting with the rating page.
     */
    public User getUser() {
        return user;
    }
}
