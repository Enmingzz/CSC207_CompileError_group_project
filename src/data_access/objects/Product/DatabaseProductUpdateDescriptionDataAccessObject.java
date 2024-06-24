package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductUpdateDescriptionDataAccessInterface;
import entity.product.Product;

import java.sql.*;

/**
 * Update specific modify_product description
 * Input is modify_product and String description
 * No return Value
 * @author CompileError group
 */

public class DatabaseProductUpdateDescriptionDataAccessObject implements ProductUpdateDescriptionDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductUpdateDescriptionDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }
    @Override
    public void updateProductDescription(Product product, String description) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "UPDATE Products SET Description = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, description);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
