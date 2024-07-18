package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateRatingDataAccessInterface;
import entity.product.Product;

import java.sql.*;

/**
 * DatabaseProductUpdateRatingDataAccessObject is responsible for updating the rating of a product in the database.
 * It implements the ProductUpdateRatingDataAccessInterface.
 */
public class DatabaseProductUpdateRatingDataAccessObject implements ProductUpdateRatingDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateRatingDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateRatingDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the rating of the specified product in the database.
     *
     * @param product the product whose rating is to be updated
     * @param rating  the new rating to be set for the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateProductRating(Product product, int rating) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET Rating = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, rating);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
