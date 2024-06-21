package data_access;

import entity.ShoppingCart;
import entity.Product;

import java.sql.SQLException;

public interface ShoppingCartDeleteDataAccessInterface {
    void deleteShoppingCart(ShoppingCart shoppingCart, Product product) throws SQLException;
}
