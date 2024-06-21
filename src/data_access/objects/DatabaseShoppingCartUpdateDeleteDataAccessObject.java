package data_access.objects;

import data_access.interfaces.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.product.Product;
import entity.shopping_cart.ShoppingCart;

import java.sql.*;

public class DatabaseShoppingCartUpdateDeleteDataAccessObject implements ShoppingCartUpdateDeleteDataAccessInterface {

    @Override
    public void updateShoppingCart(ShoppingCart shoppingCart, Product product) throws SQLException {

    }
}
