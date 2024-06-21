package data_access.objects;

import data_access.interfaces.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.shopping_cart.ShoppingCart;

import java.sql.*;

public class DatabaseShoppingCartUpdateDeleteDataAccessObject implements ShoppingCartUpdateDeleteDataAccessInterface {
    @Override
    public void deleteShoppingCart(ShoppingCart cart) throws SQLException {

    }
}
