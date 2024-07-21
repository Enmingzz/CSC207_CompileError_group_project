package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

/**
 * Represents the output data for the product creation use case.
 * This class holds the information needed to present the result of a successful product creation.
 */
public class CreateProductOutputData {

    private final Product product;
    private final User user;

    /**
     * Constructs a CreateProductOutputData instance with the specified user and product.
     *
     * @param user the user who created the product
     * @param product the newly created product
     */
    public CreateProductOutputData(User user, Product product) {
        this.product = product;
        this.user = user;
    }

    /**
     * Gets the product associated with this output data.
     *
     * @return the product that was created
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the user associated with this output data.
     *
     * @return the user who created the product
     */
    public User getUser() {
        return user;
    }
}
