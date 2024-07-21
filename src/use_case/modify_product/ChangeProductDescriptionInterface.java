package use_case.modify_product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface for modifying the description of a Product.
 * <p>
 * This interface defines a contract for classes responsible for changing the description of a product
 * in a persistent storage or data source.
 * </p>
 */
public interface ChangeProductDescriptionInterface {

    /**
     * Updates the description of the specified product.
     * <p>
     * This method applies the given description to the product and persists the change to the data source.
     * </p>
     *
     * @param product the product whose description is to be updated
     * @param description the new description to set for the product
     * @return the updated Product instance with the new description
     * @throws SQLException if there is a database access error
     * @throws IOException if there is an I/O error during the update process
     */
    Product execute(Product product, String description) throws SQLException, IOException;
}
