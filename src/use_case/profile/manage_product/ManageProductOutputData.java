package use_case.profile.manage_product;

import entity.product.Product;
import entity.user.User;

import java.util.ArrayList;

/**
 * Represents the output data for managing products.
 * Contains the list of products and the user associated with the products.
 */

public class ManageProductOutputData {
    private final ArrayList<Product> products;
    private final User user;

    /**
     * Constructs a ManageProductOutputData object with the given list of products and user.
     *
     * @param products the list of products
     * @param user the user associated with the products
     */

    public ManageProductOutputData(ArrayList<Product> products, User user) {
        this.user = user;
        this.products = products;
    }

    /**
     * Returns the list of products.
     *
     * @return the list of products
     */

    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Returns the user associated with the products.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
