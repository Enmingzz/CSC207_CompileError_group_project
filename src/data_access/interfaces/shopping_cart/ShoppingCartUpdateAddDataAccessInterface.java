package data_access.interfaces.shopping_cart;

import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

/**
 * ShoppingCartUpdateAddDataAccessInterface provides an abstraction for updating a shopping cart by adding a product to it in the database.
 */
public interface ShoppingCartUpdateAddDataAccessInterface {

    /**
     * Updates the shopping cart for the specified user by adding the specified product to it in the database.
     *
     * @param user    the user whose shopping cart is to be updated
     * @param product the product to be added to the shopping cart
     * @throws SQLException if a database access error occurs
     */
    void updateShoppingCart(User user, Product product) throws SQLException;
}
