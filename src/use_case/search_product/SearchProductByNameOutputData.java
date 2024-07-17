package use_case.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * The SearchProductByNameOutputData class holds the data required for the output
 * of searching products by name, including the user and the list of matching products.
 */
public class SearchProductByNameOutputData {
    private final User user;
    private final ArrayList<Product> products;

    /**
     * Constructs a SearchProductByNameOutputData object.
     *
     * @param user the user performing the search
     * @param products the list of products matching the search query
     */
    public SearchProductByNameOutputData(User user, ArrayList<Product> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
