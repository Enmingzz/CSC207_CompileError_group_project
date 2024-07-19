package data_access.interfaces.shopping_cart;

import entity.user.User;
import entity.product.Product;

import java.sql.SQLException;

/**
 * ShoppingCartUpdateDeleteDataAccessInterface provides an abstraction for updating a shopping cart by removing a product from it in the database.
 */
public interface ShoppingCartUpdateDeleteDataAccessInterface {

    /**
     * Updates the shopping cart for the specified user by removing the specified product from it in the database.
     *
     * @param user    the user whose shopping cart is to be updated
     * @param product the product to be removed from the shopping cart
     * @throws SQLException if a database access error occurs
     */
    void updateShoppingCart(User user, Product product) throws SQLException;
}
