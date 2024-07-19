package data_access.objects.product;

import data_access.interfaces.product.ProductDeleteDataAccessByIDInterface;

import java.sql.*;

/**
 * DatabaseProductDeleteByIDDataAccessObject is responsible for deleting a product from the database using its ID.
 * It implements the ProductDeleteDataAccessByIDInterface.
 */
public class DatabaseProductDeleteByIDDataAccessObject implements ProductDeleteDataAccessByIDInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductDeleteByIDDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductDeleteByIDDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Deletes a product from the database using the provided product ID.
     *
     * @param productID the ID of the product to be deleted
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void deleteProductByID(String productID) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "DELETE FROM Products WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, productID);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}

