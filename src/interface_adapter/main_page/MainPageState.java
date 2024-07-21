package interface_adapter.main_page;

import java.util.ArrayList;
import entity.product.Product;
import entity.user.User;

/**
 * Represents the state of the main page, including the current user and a list of all products.
 */
public class MainPageState {

    private User user = null;
    private ArrayList<Product> allProducts = new ArrayList<>();

    /**
     * Constructs a {@link MainPageState} with default values.
     */
    public MainPageState() {
    }

    /**
     * Gets the current user.
     *
     * @return the current user
     */
    public User getUser() {
        return user;
    }
    /**
     * Sets the current user.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Gets the list of all products.
     *
     * @return the list of all products
     */
    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }
    /**
     * Sets the list of all products.
     *
     * @param allProducts the list of products to set
     */
    public void setAllProducts(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    }
}