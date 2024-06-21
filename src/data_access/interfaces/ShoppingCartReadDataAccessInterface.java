package data_access.interfaces;

import entity.shopping_cart.ShoppingCart;

import java.sql.SQLException;

public interface ShoppingCartReadDataAccessInterface {
    ShoppingCart getShoppingCart(String userId) throws SQLException;
}
