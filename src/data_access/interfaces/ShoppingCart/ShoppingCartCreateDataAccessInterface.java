package data_access.interfaces.ShoppingCart;

import entity.user.User;

import java.sql.SQLException;

public interface ShoppingCartCreateDataAccessInterface {
    void saveShoppingCart(User user) throws SQLException;
}
