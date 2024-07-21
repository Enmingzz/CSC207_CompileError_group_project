package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

import java.awt.*;

/**
 * A data class that encapsulates the input data required for changing various attributes of a product.
 */
public class ChangeProductInputData {
    private final User user;
    private final String changedDescription;
    private final String changedPrice;
    private final String address;
    private final String title;
    private final String email;
    private final Product product;
    private final Image image;

    /**
     * Constructs a ChangeProductInputData instance with the specified parameters.
     *
     * @param user               the user making the changes
     * @param product            the product to be changed
     * @param changedDescription the new description for the product
     * @param changedPrice       the new price for the product
     * @param address            the new address associated with the product
     * @param title              the new title for the product
     * @param email              the new email associated with the product
     * @param image              the new image for the product
     */
    public ChangeProductInputData(User user, Product product, String changedDescription, String changedPrice,
                                  String address, String title, String email, Image image) {
        this.user = user;
        this.product = product;
        this.changedDescription = changedDescription;
        this.changedPrice = changedPrice;
        this.address = address;
        this.title = title;
        this.email = email;
        this.image = image;
    }

    /**
     * Returns the user making the changes.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the new description for the product.
     *
     * @return the new description
     */
    public String getChangedDescription() {
        return changedDescription;
    }

    /**
     * Returns the new price for the product.
     *
     * @return the new price
     */
    public String getChangedPrice() {
        return changedPrice;
    }

    /**
     * Returns the new address associated with the product.
     *
     * @return the new address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the new title for the product.
     *
     * @return the new title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the new email associated with the product.
     *
     * @return the new email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the new image for the product.
     *
     * @return the new image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Returns the product to be changed.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }
}
