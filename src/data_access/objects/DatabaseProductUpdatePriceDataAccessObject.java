package data_access.objects;

import data_access.interfaces.ProductUpdatePriceDataAccessInterface;
import entity.product.Product;
import java.sql.*;

public class DatabaseProductUpdatePriceDataAccessObject implements ProductUpdatePriceDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductUpdatePriceDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateProductPrice(Product product, float price) throws SQLException {
        query = "UPDATE Products SET Price = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setFloat(1, price);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
