package data_access.interfaces.shopping_cart;

import entity.user.User;

import java.sql.SQLException;

public interface ShoppingCartCreateDataAccessInterface {
    void saveShoppingCart(User user) throws SQLException;
}
