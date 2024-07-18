package data_access.objects.product;

import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;
import entity.product.Product;
import java.sql.*;

/**
 * DatabaseProductUpdatePriceDataAccessObject is responsible for updating the price of a product in the database.
 * It implements the ProductUpdatePriceDataAccessInterface.
 */
public class DatabaseProductUpdatePriceDataAccessObject implements ProductUpdatePriceDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdatePriceDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdatePriceDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the price of the specified product in the database.
     *
     * @param product the product whose price is to be updated
     * @param price   the new price to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateProductPrice(Product product, float price) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET Price = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setFloat(1, price);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
