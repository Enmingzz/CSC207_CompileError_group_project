package data_access.interfaces.product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * ProductDeleteDataAccessByIDInterface provides an abstraction for deleting a product from the database using its ID.
 */
public interface ProductDeleteDataAccessByIDInterface {

    /**
     * Deletes the product with the specified ID from the database.
     *
     * @param productID the ID of the product to be deleted
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during the deletion process
     */
    void deleteProductByID(String productID) throws SQLException, IOException;
}
