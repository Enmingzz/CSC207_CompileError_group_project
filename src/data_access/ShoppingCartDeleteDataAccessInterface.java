package data_access;

import entity.ShoppingCart;

import java.sql.SQLException;

public interface ShoppingCartDeleteDataAccessInterface {
    void deleteShoppingCart(ShoppingCart cart) throws SQLException;
}
