package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

/**
 * Class representing the input data required for deleting a product.
 * This class encapsulates the user requesting the deletion and the product to be deleted.
 */
public class DeleteProductInputData {

    private final User user;
    private final Product product;

    /**
     * Constructs a new instance of DeleteProductInputData with the specified user and product.
     *
     * @param user the user requesting the deletion
     * @param product the product to be deleted
     */
    public DeleteProductInputData(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    /**
     * Gets the product to be deleted.
     *
     * @return the product to be deleted
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the user requesting the deletion.
     *
     * @return the user requesting the deletion
     */
    public User getUser() {
        return user;
    }
}
