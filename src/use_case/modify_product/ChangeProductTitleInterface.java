package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * Interface defining the operations for changing the title of a product.
 * This interface provides a method for updating the title of a {@link Product} in the system. Implementations
 * of this interface are responsible for applying the title change and handling any related data access
 * operations or business logic.
 */
public interface ChangeProductTitleInterface {
    /**
     * Executes the operation to change the title of the specified product.
     *
     * @param product the product whose title is to be changed
     * @param title the new title for the product
     * @return the updated product with the new title
     * @throws SQLException if a database access error occurs
     */
    Product execute(Product product, String title) throws SQLException;
}
