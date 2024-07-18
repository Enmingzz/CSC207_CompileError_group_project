package data_access.objects.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartCreateDataAccessInterface;
import entity.user.User;

import java.sql.*;

/**
 * DatabaseShoppingCartCreateDataAccessObject is responsible for creating and saving a shopping cart for a user in the database.
 * It implements the ShoppingCartCreateDataAccessInterface.
 */
public class DatabaseShoppingCartCreateDataAccessObject implements ShoppingCartCreateDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseShoppingCartCreateDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseShoppingCartCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Saves a shopping cart for the specified user in the database.
     *
     * @param user the user for whom the shopping cart is to be created
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void saveShoppingCart(User user) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "INSERT INTO ShoppingCart (UserID) VALUES (?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getStudentNumber());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
