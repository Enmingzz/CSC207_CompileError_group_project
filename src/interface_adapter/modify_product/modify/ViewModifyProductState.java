package interface_adapter.modify_product.modify;

import entity.product.Product;
import entity.user.User;

import java.awt.*;

/**
 * Represents the state of the view for modifying a product.
 *
 * This class holds the state information required for displaying and modifying
 * a product, including details about the product, user, and any relevant
 * messages or images.
 */
public class ViewModifyProductState {
    private User user = null;
    private Product product = null;

    private String description = "";
    private String price = "";
    private String address = "";
    private String title = "";
    private String email = "";
    private String message = "";

    private String path = "";
    private Image image = null;

    /**
     * Constructs a ViewModifyProductState with the specified user, product, and product details.
     *
     * @param user The user who owns or is modifying the product.
     * @param product The product being modified.
     * @param description The description of the product.
     * @param price The price of the product.
     * @param email The email for eTransfer related to the product.
     * @param title The title of the product.
     * @param address The address associated with the product.
     */
    public ViewModifyProductState(User user, Product product,
                                  String description, String price, String email, String title, String address) {
        this.user = user;
        this.product = product;

        this.description = description;
        this.price = price;
        this.email = email;
        this.title = title;
        this.address = address;
    }

    /**
     * Constructs an empty ViewModifyProductState.
     * This constructor allows setting properties individually later.
     */
    public ViewModifyProductState() {
    }

    // Getters and Setters for each property

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
