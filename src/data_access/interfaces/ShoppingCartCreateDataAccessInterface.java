package data_access.interfaces;

import entity.User;

import java.sql.SQLException;

public interface ShoppingCartCreateDataAccessInterface {
    void saveShoppingCart(User user) throws SQLException;
}
