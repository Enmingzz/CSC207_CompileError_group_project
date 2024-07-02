package data_access.interfaces.shopping_cart;

import entity.shopping_cart.ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;

public interface ShoppingCartReadDataAccessInterface {
    ShoppingCart getShoppingCart(String userID) throws SQLException, IOException;
}
