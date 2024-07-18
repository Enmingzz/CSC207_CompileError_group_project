package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.Product;

import java.sql.*;

/**
 * DatabaseProductUpdateStateDataAccessObject is responsible for updating the state of a product in the database.
 * It implements the ProductUpdateStateDataAccessInterface.
 */
public class DatabaseProductUpdateStateDataAccessObject implements ProductUpdateStateDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateStateDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateStateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the state of the specified product in the database.
     *
     * @param product the product whose state is to be updated
     * @param state   the new state to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateProductState(Product product, int state) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET State = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, state);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
