package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductUpdateNameDataAccessInterface;
import entity.product.Product;

import java.sql.*;

public class DatabaseProductUpdateNameDataAccessObject implements ProductUpdateNameDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductUpdateNameDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }
    @Override
    public void updateProductName(Product product, String name) throws SQLException {
        query = "UPDATE Products SET Title = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
