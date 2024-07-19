package data_access.interfaces.product;

import entity.product.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ProductReadByUserDataAccessInterface provides an abstraction for retrieving products from the database using a user ID.
 */
public interface ProductReadByUserDataAccessInterface {

    /**
     * Retrieves products associated with the specified user ID from the database.
     *
     * @param userID the ID of the user whose products are to be retrieved
     * @return an ArrayList of products associated with the specified user ID
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    ArrayList<Product> getProductByUser(String userID) throws SQLException, IOException;
}
