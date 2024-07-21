package use_case.modify_product;

import entity.user.User;

/**
 * Represents the input data required for viewing or handling the creation of a product.
 *
 * This class contains the necessary information to view or manage the creation of a product, specifically the user
 * associated with the request.
 */
public class ViewCreateProductInputData {

    private final User user;

    /**
     * Constructs a new instance of ViewCreateProductInputData with the specified user.
     *
     * @param user The user associated with the request to view or create a product.
     */
    public ViewCreateProductInputData(User user) {
        this.user = user;
    }

    /**
     * Returns the user associated with this input data.
     *
     * @return The user associated with this input data.
     */
    public User getUser() {
        return user;
    }
}
