package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;
import java.sql.*;

/**
 * DatabaseProductUpdateBuyerScheduleDataAccessObject is responsible for updating the buyer's schedule time of a product in the database.
 * It implements the ProductUpdateBuyerScheduleDataAccessInterface.
 */
public class DatabaseProductUpdateBuyerScheduleDataAccessObject implements ProductUpdateBuyerScheduleDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateBuyerScheduleDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateBuyerScheduleDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the buyer's schedule time for the specified product in the database.
     *
     * @param product           the product whose buyer's schedule time is to be updated
     * @param buyerScheduleTime the new buyer's schedule time to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateBuyerScheduleByProductID(Product product, LocalDateTime buyerScheduleTime) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET BuyerTime = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, buyerScheduleTime.toString());
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
