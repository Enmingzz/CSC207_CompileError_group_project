package data_access;

import entity.Product;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseShoppingCartDeleteDataAccessObject implements ShoppingCartDeleteDataAccessInterface {
    private final Connection connection;
    private final User user;
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
        query = "SELECT ListProductsID FROM Carts WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getStudentNumber());
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String rowData = resultSet.getString("ListProductsID");
            ArrayList<String> listProductID = new ArrayList<String>(Arrays.asList(rowData.substring(1,
                    rowData.length() - 1).split(",")));
            listProductID.remove(product.getProductID());

            query = "UPDATE Carts SET ListProductsID = ? WHERE UserID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(listProductID));
            preparedStatement.setString(2, user.getStudentNumber());
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
    }
}
