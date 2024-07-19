package data_access.interfaces.product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ProductReadByTagDataAccessInterface provides an abstraction for retrieving products from the database using a tag.
 */
public interface ProductReadByTagDataAccessInterface {

    /**
     * Retrieves products with the specified tag from the database.
     *
     * @param tag the tag of the products to be retrieved
     * @return an ArrayList of products with the specified tag
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    ArrayList<Product> getProductByTag(String tag) throws SQLException, IOException;
}
