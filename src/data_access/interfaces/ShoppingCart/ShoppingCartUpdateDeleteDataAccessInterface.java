package data_access.interfaces.ShoppingCart;

import entity.user.User;
import entity.product.Product;

import java.sql.SQLException;

public interface ShoppingCartUpdateDeleteDataAccessInterface {
    void updateShoppingCart(User user, Product product) throws SQLException;
}
