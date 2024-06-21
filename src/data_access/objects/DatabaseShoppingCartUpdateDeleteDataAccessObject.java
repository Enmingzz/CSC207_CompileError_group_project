package data_access.objects;

import data_access.interfaces.ShoppingCartUpdateDeleteDataAccessInterface;
import entity.product.Product;
import entity.shopping_cart.ShoppingCart;
import entity.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseShoppingCartUpdateDeleteDataAccessObject implements ShoppingCartUpdateDeleteDataAccessInterface {
    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseShoppingCartUpdateDeleteDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateShoppingCart(User user, Product product) throws SQLException {
        query = "SELECT ListProductsID FROM Carts WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getStudentNumber());
        resultSet = preparedStatement.executeQuery();
        resultSet.next();

        String rowlist = resultSet.getString("ListProductsID");
        ArrayList<String> listProductsID = new ArrayList<String>(List.of(rowlist.substring(1, rowlist.length() - 1).split(",")));
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
