package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.*;

/**
 * DatabaseProductUpdateSellerScheduleDataAccessObject is responsible for updating the seller's schedule times of a product in the database.
 * It implements the ProductUpdateSellerScheduleDataAccessInterface.
 */
public class DatabaseProductUpdateSellerScheduleDataAccessObject implements ProductUpdateSellerScheduleDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateSellerScheduleDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateSellerScheduleDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the seller's schedule times for the specified product in the database.
     *
     * @param product  the product whose seller's schedule times are to be updated
     * @param listTimes the new list of seller's schedule times to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateSellerSchedule(Product product, ArrayList<LocalDateTime> listTimes) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET ListSellerTimes = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(listTimes));
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
