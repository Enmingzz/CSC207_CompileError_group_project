package interface_adapter.shopping_cart;

import entity.user.User;
import entity.product.Product;
import java.util.ArrayList;


/**
 * Represents the state of the shopping cart, including the list of products, user information, total price, and error message.
 */
public class ShoppingCartState {
    private ArrayList<Product> listProducts = new ArrayList<>();
    private User user = null;
    private float totalPrice = 0;
    private String errorMessage = "";
    /**
     * Constructs a {@link ShoppingCartState} by copying another shopping cart state.
     *
     * @param copy the shopping cart state to copy
     */
    public ShoppingCartState(ShoppingCartState copy) {
        listProducts = copy.listProducts;
        user = copy.user;
        totalPrice = copy.totalPrice;
        errorMessage = copy.errorMessage;
    }
    /**
     * Constructs an empty {@link ShoppingCartState}.
     */
    public ShoppingCartState() {}
    /**
     * Gets the user associated with the shopping cart.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }
    /**
     * Sets the user associated with the shopping cart.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Gets the list of products in the shopping cart.
     *
     * @return the list of products
     */
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }
    /**
     * Sets the list of products in the shopping cart.
     *
     * @param listProducts the list of products to set
     */
    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
    /**
     * Gets the total price of the products in the shopping cart.
     *
     * @return the total price
     */
    public float getTotalPrice() {
        return totalPrice;
    }
    /**
     * Sets the total price of the products in the shopping cart.
     *
     * @param totalPrice the total price to set
     */
    public void setTotalPrice(float totalPrice){
        this.totalPrice = totalPrice;
    }
    /**
     * Gets the error message associated with the shopping cart state.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    /**
     * Sets the error message associated with the shopping cart state.
     *
     * @param errorMessage the error message to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
