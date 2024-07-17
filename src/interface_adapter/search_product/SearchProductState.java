package interface_adapter.search_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * The SearchProductState class holds the state information for the search product page,
 * including the user and the list of products.
 */
public class SearchProductState {
    private User user = null;
    private ArrayList<Product> products = new ArrayList<>();

    /**
     * Constructs a new SearchProductState object as a copy of the specified state.
     *
     * @param copy the state to copy
     */
    public SearchProductState(SearchProductState copy) {
        this.user = copy.user;
        this.products = copy.products;
    }

    /**
     * Constructs a SearchProductState object with default values.
     */
    public SearchProductState() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
