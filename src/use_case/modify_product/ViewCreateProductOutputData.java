package use_case.modify_product;

import entity.user.User;

/**
 * Contains the output data for the process of viewing or handling the creation of a product.
 *
 * This class holds the user information needed for displaying or processing the product creation view.
 */
public class ViewCreateProductOutputData {

    private final User user;

    /**
     * Constructs a ViewCreateProductOutputData instance with the specified user.
     *
     * @param user The user associated with the product creation or viewing process.
     */
    public ViewCreateProductOutputData(User user) {
        this.user = user;
    }

    /**
     * Returns the user associated with the product creation or viewing process.
     *
     * @return The user associated with the product creation or viewing process.
     */
    public User getUser() {
        return user;
    }
}
