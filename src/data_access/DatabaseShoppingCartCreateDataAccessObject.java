package data_access;

import entity.User;

import java.sql.*;

public class DatabaseShoppingCartCreateDataAccessObject implements ShoppingCartCreateDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseShoppingCartCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }
    @Override
    public void saveShoppingCart(User user) throws SQLException {
        query = "INSERT INTO ShoppingCart(UserID) VALUES(?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getStudentNumber());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
