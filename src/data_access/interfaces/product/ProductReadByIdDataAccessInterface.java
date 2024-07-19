package data_access.interfaces.product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * ProductReadByIdDataAccessInterface provides an abstraction for retrieving a product from the database using its ID.
 */
public interface ProductReadByIdDataAccessInterface {

    /**
     * Retrieves the product with the specified ID from the database.
     *
     * @param productID the ID of the product to be retrieved
     * @return the product with the specified ID
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    Product getProductById(String productID) throws SQLException, IOException;
}
