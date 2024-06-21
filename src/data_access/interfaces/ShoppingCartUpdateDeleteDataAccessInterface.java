package data_access.interfaces;

import entity.product.Product;
import entity.user.User;

import java.sql.SQLException;

public interface ShoppingCartUpdateDeleteDataAccessInterface {
    void updateShoppingCart(User user, Product product) throws SQLException;
}
