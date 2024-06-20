package data_access;

import entity.ShoppingCart;
import entity.Product;

import java.sql.SQLException;

public interface ShoppingCartUpdateDataAccessInterface {
    // To be implemented to get the UtorID in shoppingCart and ProductID in product to be written in database
    void updateShoppingCart(ShoppingCart shoppingCart, Product product) throws SQLException;
}
