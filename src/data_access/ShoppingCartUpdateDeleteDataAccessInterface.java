package data_access;

import entity.ShoppingCart;
import entity.Product;

import java.sql.SQLException;

public interface ShoppingCartUpdateDeleteDataAccessInterface {
    void updateShoppingCart(ShoppingCart shoppingCart, Product product) throws SQLException;
}
