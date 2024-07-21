package use_case.modify_product;

import entity.product.Product;

import java.sql.SQLException;

/**
 * Interface defining the operations for changing the price of a product.
 * <p>
 * This interface provides a method for updating the price of a {@link Product} in the system. Implementations
 * of this interface are responsible for applying the price change and handling any related data access
 * operations or business logic.
 * </p>
 */
public interface ChangeProductPriceInterface {
    /**
     * Executes the operation to change the price of the specified product.
     *
     * @param product the product whose price is to be changed
     * @param price the new price for the product, represented as a {@code String}
     * @return the updated product with the new price
     * @throws SQLException if a database access error occurs
     */
    Product execute(Product product, String price) throws SQLException;
}
