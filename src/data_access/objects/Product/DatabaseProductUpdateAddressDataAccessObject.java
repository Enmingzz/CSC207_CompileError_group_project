package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductUpdateAddressDataAccessInterface;
import entity.product.Product;
import java.sql.*;

public class DatabaseProductUpdateAddressDataAccessObject implements ProductUpdateAddressDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductUpdateAddressDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateProductAddress(Product product, String address) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "UPDATE Prodcuts SET Address = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, address);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
