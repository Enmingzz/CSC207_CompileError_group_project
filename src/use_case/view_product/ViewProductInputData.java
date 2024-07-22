package use_case.view_product;

import entity.product.Product;
import entity.user.User;

/**
 * This class encapsulates the input data required to view a product.
 * It contains a product and the user who is viewing the product.
 */
public class ViewProductInputData {
    private final Product product;
    private final User user;

    /**
     * Constructs a ViewProductInputData object with the specified product and user.
     *
     * @param product the product to be viewed.
     * @param user the user who is viewing the product.
     */
    public ViewProductInputData(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    /**
     * Returns the product to be viewed.
     *
     * @return the product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the user who is viewing the product.
     *
     * @return the user.
     */
    public User getUser() {
        return user;
    }
}
