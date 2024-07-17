package use_case.profile.manage_product;

import entity.user.User;

/**
 * Represents the input data for managing a product.
 * Contains the user who is managing the product.
 */
public class ManageProductInputData {

    private final User user;

    /**
     * Constructs a ManageProductInputData object with the given user.
     *
     * @param user the user who is managing the product
     */
    public ManageProductInputData(User user) {
        this.user = user;
    }

    /**
     * Returns the user who is managing the product.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

}
