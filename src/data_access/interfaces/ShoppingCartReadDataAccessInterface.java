package data_access.interfaces;

import entity.ShoppingCart;
import entity.User;

import java.sql.SQLException;

public interface ShoppingCartReadDataAccessInterface {
    ShoppingCart getShoppingCart(User user) throws SQLException;
}
