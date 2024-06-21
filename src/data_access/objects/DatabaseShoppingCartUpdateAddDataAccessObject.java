package data_access.objects;

import data_access.interfaces.ShoppingCartUpdateAddDataAccessInterface;
import entity.Product;
import entity.User;

import java.sql.*;

public class DatabaseShoppingCartUpdateAddDataAccessObject implements ShoppingCartUpdateAddDataAccessInterface {
    @Override
    public void updateShoppingCart(User user, Product product) throws SQLException {

    }

    @Override
    public void updateShoppingCart(String shoppingCartUserID, String addedProductID) throws SQLException {

    }
}
