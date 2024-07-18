package data_access.interfaces.shopping_cart;

import entity.shopping_cart.ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;

/**
 * ShoppingCartReadDataAccessInterface provides an abstraction for retrieving a shopping cart for a user from the database.
 */
public interface ShoppingCartReadDataAccessInterface {

    /**
     * Retrieves the shopping cart for the specified user from the database.
     *
     * @param userID the ID of the user whose shopping cart is to be retrieved
     * @return the shopping cart for the specified user
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during the retrieval process
     */
    ShoppingCart getShoppingCart(String userID) throws SQLException, IOException;
}
