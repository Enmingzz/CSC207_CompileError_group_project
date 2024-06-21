package data_access;

import entity.Product;
import entity.ShoppingCart;

import java.sql.*;

public class DatabaseShoppingCartUpdateAddDataAccessObject implements ShoppingCartUpdateAddDataAccessInterface {
    @Override
    public void updateShoppingCart(String studentNumber, Product product) throws SQLException {

    }

    @Override
    public void updateShoppingCart(String shoppingCartUserID, String addedProductID) throws SQLException {

    }
}
