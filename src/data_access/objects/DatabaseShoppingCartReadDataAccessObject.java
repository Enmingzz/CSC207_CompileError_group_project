package data_access.objects;

import data_access.interfaces.ShoppingCartReadDataAccessInterface;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.User;

import java.sql.*;

public class DatabaseShoppingCartReadDataAccessObject implements ShoppingCartReadDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;
    private final ShoppingCartFactory shoppingCartFactory;

    public DatabaseShoppingCartReadDataAccessObject(ShoppingCartFactory shoppingCartFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.shoppingCartFactory = shoppingCartFactory;
    }
    @Override
    public ShoppingCart getShoppingCart(User user) throws SQLException {
        ShoppingCart shoppingCart = null;
        query = "SELECT * FROM shopping_cart WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getStudentNumber());
        resultSet = preparedStatement.executeQuery();

        String totalPrice = resultSet.getString("TotalPrice");
        String listProducts = resultSet.getString("ListProductID");
        return null;
    }
}
