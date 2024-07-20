package data_access.objects.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartUpdateAddDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseShoppingCartUpdateAddDataAccessObject is responsible for updating a shopping cart by adding a product to it in the database.
 * It implements the ShoppingCartUpdateAddDataAccessInterface.
 */
public class DatabaseShoppingCartUpdateAddDataAccessObject implements ShoppingCartUpdateAddDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    /**
     * Constructs a DatabaseShoppingCartUpdateAddDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseShoppingCartUpdateAddDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the shopping cart for the specified user by adding the specified product to it in the database.
     *
     * @param user    the user whose shopping cart is to be updated
     * @param product the product to be added to the shopping cart
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
        ArrayList<String> listProductsID =  (resultSet.getString("ListProductsID") == null)?
                new ArrayList<String>(): new ArrayList<String>(List.of(resultSet.getString("ListProductsID").substring(1,
                resultSet.getString("ListProductsID").length() - 1).split(",")));
        listProductsID.add(product.getProductID());

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
