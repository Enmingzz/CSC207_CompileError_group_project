package data_access;

import entity.Product;

import java.sql.SQLException;

public interface ShoppingCartDeleteDataAccessInterface {
    void deleteShoppingCart(Product product) throws SQLException;
}
