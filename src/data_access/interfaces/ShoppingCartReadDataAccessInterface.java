package data_access.interfaces;

import entity.shopping_cart.ShoppingCart;
import entity.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface ShoppingCartReadDataAccessInterface {
    ShoppingCart getShoppingCart(User user) throws SQLException, IOException;
}
