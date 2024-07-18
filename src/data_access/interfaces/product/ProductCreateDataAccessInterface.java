package data_access.interfaces.product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;

/**
 * ProductCreateDataAccessInterface provides an abstraction for creating and saving a product in the database.
 */
public interface ProductCreateDataAccessInterface {

    /**
     * Saves the specified product in the database.
     *
     * @param product the product to be saved
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    void saveProduct(Product product) throws SQLException, IOException;
}
