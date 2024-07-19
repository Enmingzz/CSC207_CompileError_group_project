package data_access.objects.product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import entity.product.Product;

import java.sql.*;

/**
 * DatabaseProductUpdateDescriptionDataAccessObject is responsible for updating the description of a product in the database.
 * It implements the ProductUpdateDescriptionDataAccessInterface.
 * <p>
 * This class updates the description of a specific product in the database.
 * </p>
 * <p>
 * Input: Product object and String description
 * Output: No return value
 * </p>
 *
 * <p>
 * Created by CompileError group
 * </p>
 */
public class DatabaseProductUpdateDescriptionDataAccessObject implements ProductUpdateDescriptionDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdateDescriptionDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdateDescriptionDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the description of the specified product in the database.
     *
     * @param product     the product whose description is to be updated
     * @param description the new description to be set for the product
     * @throws SQLException if a database access error occurs
     */
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
