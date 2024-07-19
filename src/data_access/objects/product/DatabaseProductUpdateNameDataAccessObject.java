package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
import entity.product.Product;

import java.sql.*;

/**
 * DatabaseProductUpdateNameDataAccessObject is responsible for updating the name (title) of a product in the database.
 * It implements the ProductUpdateNameDataAccessInterface.
 */
public class DatabaseProductUpdateNameDataAccessObject implements ProductUpdateNameDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateNameDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateNameDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the name (title) of the specified product in the database.
     *
     * @param product the product whose name is to be updated
     * @param name    the new name to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateProductName(Product product, String name) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET Title = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
