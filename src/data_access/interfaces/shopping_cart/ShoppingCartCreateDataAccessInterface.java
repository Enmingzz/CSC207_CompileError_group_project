package data_access.interfaces.shopping_cart;

import entity.user.User;

import java.sql.SQLException;

/**
 * ShoppingCartCreateDataAccessInterface provides an abstraction for creating and saving a shopping cart for a user in the database.
 */
public interface ShoppingCartCreateDataAccessInterface {

    /**
     * Saves a shopping cart for the specified user in the database.
     *
     * @param user the user for whom the shopping cart is to be created
     * @throws SQLException if a database access error occurs
     */
    void saveShoppingCart(User user) throws SQLException;
}
