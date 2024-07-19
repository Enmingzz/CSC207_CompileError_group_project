package data_access.interfaces.product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ProductReadByNameDataAccessInterface provides an abstraction for retrieving products from the database using their name.
 */
public interface ProductReadByNameDataAccessInterface {

    /**
     * Retrieves products with the specified name from the database.
     *
     * @param name the name of the products to be retrieved
     * @return an ArrayList of products with the specified name
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    ArrayList<Product> getProductByName(String name) throws SQLException, IOException;
}
