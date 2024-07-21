package use_case.modify_product;

import entity.product.Product;
import entity.user.User;

/**
 * Contains the data required for preparing the view after a product deletion.
 * This class is used to encapsulate the result of a delete product operation.
 */
public class DeleteProductOutputData {

    private final Product product;
    private final User user;

    /**
     * Constructs a new instance of DeleteProductOutputData.
     *
     * @param user the user who initiated the deletion
     * @param product the product that was deleted
     */
    public DeleteProductOutputData(User user, Product product) {
        this.product = product;
        this.user = user;
    }

    /**
     * Gets the product that was deleted.
     *
     * @return the deleted product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets the user who initiated the deletion.
     *
     * @return the user who initiated the deletion
     */
    public User getUser() {
        return user;
    }
}
