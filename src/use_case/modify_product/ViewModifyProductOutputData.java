package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

/**
 * Holds the output data required for presenting the results of a product modification view.
 *
 * This class encapsulates the details about the product being modified and the user who is performing
 * the modification, providing the necessary information for presenting the modification results.
 */
public class ViewModifyProductOutputData {

    private final Product product;
    private final User user;

    /**
     * Constructs a new instance of {@code ViewModifyProductOutputData}.
     *
     * @param user The user who is performing the product modification.
     * @param product The product that is being modified.
     */
    public ViewModifyProductOutputData(User user, Product product) {
        this.product = product;
        this.user = user;
    }

    /**
     * Gets the product associated with the modification view.
     *
     * @return The product that is being modified.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the user performing the product modification.
     *
     * @return The user who is modifying the product.
     */
    public User getUser() {
        return user;
    }
}
