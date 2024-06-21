package data_access.interfaces;

import entity.shopping_cart.ShoppingCart;
import entity.product.Product;

import java.sql.SQLException;

public interface ShoppingCartUpdateDeleteDataAccessInterface {
    void updateShoppingCart(ShoppingCart shoppingCart, Product product) throws SQLException;
}
