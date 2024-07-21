package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

/**
 * Contains the input data required for the use case of viewing or handling modifications to a product.
 *
 * This class encapsulates the information needed to manage the modification of a product, including
 * details about both the user making the request and the product being modified.
 */
public class ViewModifyProductInputData {

    private final User user;
    private final Product product;

    /**
     * Constructs an instance of {@code ViewModifyProductInputData} with the specified user and product.
     *
     * @param user The user who is making the request to modify the product.
     * @param product The product that is to be modified.
     */
    public ViewModifyProductInputData(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    /**
     * Returns the user associated with this input data.
     *
     * @return The user who is making the request to modify the product.
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the product associated with this input data.
     *
     * @return The product that is to be modified.
     */
    public Product getProduct() {
        return product;
    }
}
