package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

/**
 * Class representing the output data for the product modification use case.
 * <p>
 * This class encapsulates the information that is returned after a product has been modified. It includes the
 * modified product details, a message indicating the result of the modification operation, and the user
 * associated with the modification.
 * </p>
 */
public class ChangeProductOutputData {
    private final Product product;
    private final String message;
    private final User user;

    /**
     * Constructs a new {@code ChangeProductOutputData} instance.
     *
     * @param product the modified product
     * @param message a message indicating the result of the modification operation
     * @param user the user associated with the modification
     */
    public ChangeProductOutputData(Product product, String message, User user) {
        this.product = product;
        this.message = message;
        this.user = user;
    }

    /**
     * Gets the message indicating the result of the modification operation.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the modified product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the user associated with the modification.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
