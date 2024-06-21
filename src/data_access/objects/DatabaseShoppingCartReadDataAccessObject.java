package data_access.objects;

import data_access.interfaces.ShoppingCartReadDataAccessInterface;
import entity.ShoppingCart;
import entity.User;

import java.sql.*;

public class DatabaseShoppingCartReadDataAccessObject implements ShoppingCartReadDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;
    public DatabaseShoppingCartReadDataAccessObject() {
        this.connection =

    }
    @Override
    public ShoppingCart getShoppingCart(User user) {
        return null;
    }
}
