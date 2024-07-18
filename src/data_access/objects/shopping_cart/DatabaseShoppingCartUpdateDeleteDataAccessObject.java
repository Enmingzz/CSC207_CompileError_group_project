package data_access.objects.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseShoppingCartUpdateDeleteDataAccessObject is responsible for updating a shopping cart by removing a product from it in the database.
 * It implements the ShoppingCartUpdateDeleteDataAccessInterface.
 */
public class DatabaseShoppingCartUpdateDeleteDataAccessObject implements ShoppingCartUpdateDeleteDataAccessInterface {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseShoppingCartUpdateDeleteDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseShoppingCartUpdateDeleteDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the shopping cart for the specified user by removing the specified product from it in the database.
     *
     * @param user    the user whose shopping cart is to be updated
     * @param product the product to be removed from the shopping cart
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateShoppingCart(User user, Product product) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "SELECT ListProductsID FROM Carts WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getStudentNumber());
        resultSet = preparedStatement.executeQuery();
        resultSet.next();

        String rowList = resultSet.getString("ListProductsID");
        ArrayList<String> listProductsID = new ArrayList<>(List.of(rowList.substring(1, rowList.length() - 1).split(",")));
        listProductsID.remove(product.getProductID());

        query = "UPDATE Carts SET ListProductsID = ? WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(listProductsID));
        preparedStatement.setString(2, user.getStudentNumber());
        preparedStatement.executeUpdate();

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
