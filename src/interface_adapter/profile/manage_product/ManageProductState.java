package interface_adapter.profile.manage_product;

import entity.product.Product;
import entity.product.ProductFactory;
import entity.user.User;

import java.util.ArrayList;
/**
 * Represents the state for managing products in the user's profile, including the user, products, and messages related to product modifications.
 */
public class ManageProductState {
    private Product product;
    private User user;
    private ArrayList<Product> products = new ArrayList<Product>();
    private String modifyProductMessage = null;
    /**
     * Constructs a {@link ManageProductState} with the specified product factory.
     *
     * @param productFactory the factory to create products
     */
    public ManageProductState(ProductFactory productFactory) {
    }

    /**
     * Gets the current user.
     *
     * @return the current user
     */
    public User getUser(){return user;}

    /**
     * Gets the list of products.
     *
     * @return the list of products
     */
    public ArrayList<Product> getProduct() {return products;}

    /**
     * Sets the current user.
     *
     * @param user the user to set
     */
    public void setUser(User user){this.user = user;}

    /**
     * Sets the list of products.
     *
     * @param products the list of products to set
     */
    public void setProduct(ArrayList<Product> products) {this.products = products;}

    /**
     * Gets the message related to product modifications.
     *
     * @return the modify product message
     */
    public String getModifyProductMessage() {return modifyProductMessage;}

    /**
     * Sets the message related to product modifications.
     *
     * @param message the modify product message to set
     */
    public void setModifyProductMessage(String message) {this.modifyProductMessage = message;}
}
