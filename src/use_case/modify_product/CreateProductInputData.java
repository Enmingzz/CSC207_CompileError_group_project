package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the input data required to create a new product.
 * This class encapsulates all the necessary information to create a product, including details about the user,
 * the product itself, and additional attributes.
 */
public class CreateProductInputData {
    private final User user;
    private final Image image;
    private final String description;
    private final String price;
    private final String title;
    private final String eTransferEmail;
    private final String address;
    private final ArrayList<String> listTags;

    /**
     * Constructs an instance of {@code CreateProductInputData} with the specified values.
     *
     * @param user           the user creating the product
     * @param image          the image of the product
     * @param description    the description of the product
     * @param price          the price of the product as a string
     * @param title          the title of the product
     * @param eTransferEmail the email for e-transfer
     * @param address        the address where the product is located
     * @param listTags       a list of tags associated with the product
     */
    public CreateProductInputData(User user, Image image, String description, String price, String title,
                                  String eTransferEmail, String address, ArrayList<String> listTags) {
        this.image = image;
        this.description = description;
        this.user = user;
        this.price = price;
        this.title = title;
        this.eTransferEmail = eTransferEmail;
        this.address = address;
        this.listTags = listTags;
    }

    /**
     * Returns the user creating the product.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the image of the product.
     *
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Returns the price of the product as a string.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Returns the title of the product.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the email for e-transfer.
     *
     * @return the eTransferEmail
     */
    public String geteTransferEmail() {
        return eTransferEmail;
    }

    /**
     * Returns the address where the product is located.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns a list of tags associated with the product.
     *
     * @return the list of tags
     */
    public ArrayList<String> getListTags() {
        return listTags;
    }

    /**
     * Returns the description of the product.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
