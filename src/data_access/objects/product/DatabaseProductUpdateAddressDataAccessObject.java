package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;
import entity.product.Product;
import java.sql.*;

/**
 * DatabaseProductUpdateAddressDataAccessObject is responsible for updating the address of a product in the database.
 * It implements the ProductUpdateAddressDataAccessInterface.
 */
public class DatabaseProductUpdateAddressDataAccessObject implements ProductUpdateAddressDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateAddressDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateAddressDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the address of the specified product in the database.
     *
     * @param product the product whose address is to be updated
     * @param address the new address to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateProductAddress(Product product, String address) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET Address = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, address);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
