package interface_adapter.modify_product.create;

import entity.user.User;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the state of the "create product" view.
 *
 * This class holds all the necessary data for creating a product, including product details, user information,
 * and error messages. It provides getters and setters for these fields, allowing for the manipulation and retrieval
 * of state information related to product creation.
 */
public class CreateProductState {

    private Image image = null;
    private String description = "";
    private String price = "";
    private String title = "";
    private String eTransferEmail = "";
    private String address = "";
    private ArrayList<String> listTags = new ArrayList<String>();

    private String createProductError = null;

    private String path;

    private User user;

    /**
     * Constructs a new CreateProductState by copying the fields from another CreateProductState instance.
     *
     * @param copy The CreateProductState instance to copy.
     */
    public CreateProductState(CreateProductState copy) {
        image = copy.image;
        description = copy.description;
        price = copy.price;
        title = copy.title;
        eTransferEmail = copy.eTransferEmail;
        address = copy.address;
        listTags = copy.listTags;
        createProductError = copy.createProductError;
        user = copy.user;
    }

    /**
     * Default constructor for CreateProductState.
     * Initializes all fields with default values.
     */
    public CreateProductState() {}

    /**
     * Gets the image associated with the product.
     *
     * @return The image associated with the product.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Gets the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Gets the title of the product.
     *
     * @return The title of the product.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the email for eTransfer related to the product.
     *
     * @return The eTransfer email.
     */
    public String geteTransferEmail() {
        return eTransferEmail;
    }

    /**
     * Gets the address associated with the product.
     *
     * @return The address associated with the product.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the list of tags associated with the product.
     *
     * @return The list of tags.
     */
    public ArrayList<String> getListTags() {
        return listTags;
    }

    /**
     * Gets the user associated with the product creation.
     *
     * @return The user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets the path related to the product.
     *
     * @return The path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets any error message related to the product creation.
     *
     * @return The error message, or null if no error.
     */
    public String getCreateProductError() {
        return createProductError;
    }

    /**
     * Sets the image associated with the product.
     *
     * @param image The image to set.
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Sets the description of the product.
     *
     * @param des The description to set.
     */
    public void setDescription(String des) {
        description = des;
    }

    /**
     * Sets the price of the product.
     *
     * @param pri The price to set.
     */
    public void setPrice(String pri) {
        price = pri;
    }

    /**
     * Sets the title of the product.
     *
     * @param titl The title to set.
     */
    public void setTitle(String titl) {
        title = titl;
    }

    /**
     * Sets the eTransfer email related to the product.
     *
     * @param email The eTransfer email to set.
     */
    public void seteTransferEmail(String email) {
        eTransferEmail = email;
    }

    /**
     * Sets the address associated with the product.
     *
     * @param add The address to set.
     */
    public void setAddress(String add) {
        address = add;
    }

    /**
     * Sets the list of tags associated with the product.
     *
     * @param tags The list of tags to set.
     */
    public void setListTags(ArrayList<String> tags) {
        listTags = tags;
    }

    /**
     * Sets the user associated with the product creation.
     *
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets the path related to the product.
     *
     * @param path The path to set.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets the error message related to the product creation.
     *
     * @param err The error message to set.
     */
    public void setCreateProductError(String err) {
        this.createProductError = err;
    }
}
