package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;
import entity.product.Product;
import java.sql.*;

/**
 * DatabaseProductUpdateTransferEmailDataAccessObject is responsible for updating the transfer email of a product in the database.
 * It implements the ProductUpdateTransferEmailDataAccessInterface.
 */
public class DatabaseProductUpdateTransferEmailDataAccessObject implements ProductUpdateTransferEmailDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateTransferEmailDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateTransferEmailDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the transfer email of the specified product in the database.
     *
     * @param product the product whose transfer email is to be updated
     * @param eMail   the new transfer email to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateProductEmail(Product product, String eMail) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET TransferEmail = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, eMail);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
