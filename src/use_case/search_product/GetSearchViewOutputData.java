package use_case.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * The GetSearchViewOutputData class holds the data required for the output
 * of retrieving the search page.
 */
public class GetSearchViewOutputData {
    private final User user;
    private final ArrayList<Product> allProducts;

    /**
     * Constructs a GetSearchViewOutputData object with the specified user and list of products.
     *
     * @param user the user requesting the search page
     * @param allProducts the list of all on sale products to be displayed in the search page
     */
    public GetSearchViewOutputData(User user, ArrayList<Product> allProducts) {
        this.user = user;
        this.allProducts = allProducts;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }
}
