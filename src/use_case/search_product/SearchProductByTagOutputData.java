package use_case.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * The SearchProductByTagOutputData class holds the data required for the output
 * of searching products by tag, including the user and the list of matching products.
 */
public class SearchProductByTagOutputData {
    private final User user;
    private final ArrayList<Product> products;

    /**
     * Constructs a SearchProductByTagOutputData object.
     *
     * @param user the user performing the search
     * @param products the list of products matching the search tag
     */
    public SearchProductByTagOutputData(User user, ArrayList<Product> products) {
        this.user = user;
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }
}
