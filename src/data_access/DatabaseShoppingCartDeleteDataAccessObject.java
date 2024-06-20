package data_access;

import entity.Product;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseShoppingCartDeleteDataAccessObject implements ShoppingCartDeleteDataAccessInterface {
    private final Connection connection;
    private final User user;
    private Product product;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;

    public DatabaseShoppingCartDeleteDataAccessObject(User user) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.user = user;
    }
    @Override
    public void deleteShoppingCart(Product product) throws SQLException {
        query = "SELECT ListProductID FROM ShoppingCart WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String
        }

    }
}
