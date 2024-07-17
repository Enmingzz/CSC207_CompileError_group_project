package use_case.search_product;

import entity.user.User;

/**
 * The SearchProductByNameInputData class holds the data required for searching products by name,
 * including the user and the product name to search for.
 */
public class SearchProductByNameInputData {

    final private User user;

    final private String productName;

    /**
     * Constructs a SearchProductByNameInputData object.
     *
     * @param user the user performing the search
     * @param productName the name of the product to search for
     */
    public SearchProductByNameInputData(User user, String productName) {
        this.user = user;
        this.productName = productName;
    }

    public User getUser() {
        return user;
    }

    public String getProductName() {
        return productName;
    }

}
