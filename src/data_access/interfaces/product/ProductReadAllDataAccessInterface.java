package data_access.interfaces.product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ProductReadAllDataAccessInterface provides an abstraction for retrieving all products from the database.
 */
public interface ProductReadAllDataAccessInterface {

    /**
     * Retrieves all products from the database.
     *
     * @return an ArrayList of all products
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    ArrayList<Product> getAllProducts() throws SQLException, IOException;
}
