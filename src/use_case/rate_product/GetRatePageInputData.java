package use_case.rate_product;

import entity.product.Product;
import entity.user.User;

/**
 * Represents the input data required to retrieve the rating page.
 *
 * This class encapsulates the information necessary to process a request for the rating
 * page, including details about the user making the request and the product being rated.
 */
public class GetRatePageInputData {

    private final User user;
    private final Product product;

    /**
     * Constructs a new instance of {@code GetRatePageInputData} with the specified user and product.
     *
     * @param user The user requesting the rating page.
     * @param product The product for which the rating page is being requested.
     */
    public GetRatePageInputData(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    /**
     * Returns the user requesting the rating page.
     *
     * @return The user associated with the request.
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the product for which the rating page is being requested.
     *
     * @return The product associated with the request.
     */
    public Product getProduct() {
        return product;
    }
}
