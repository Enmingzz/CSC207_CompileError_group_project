package data_access.objects.product;

import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;

import java.sql.*;

public class DatabaseProductDeleteByIDDataAccessObject implements ProductDeleteDataAccessByIDInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductDeleteByIDDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }
    @Override
    public void deleteProductByID(String productID) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "Delete FROM Prodcuts WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, productID);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }
}
