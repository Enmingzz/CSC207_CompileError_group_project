package data_access.objects.product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import entity.product.Product;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;

/**
 * DatabaseProductUpdatePictureDataAccessObject is responsible for updating the picture of a product in the database.
 * It implements the ProductUpdatePictureDataAccessInterface.
 */
public class DatabaseProductUpdatePictureDataAccessObject implements ProductUpdatePictureDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseProductUpdatePictureDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductUpdatePictureDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the picture of the specified product in the database.
     *
     * @param product the product whose picture is to be updated
     * @param image   the new picture to be set for the product
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    @Override
    public void updateProductPicture(Product product, Image image) throws SQLException, IOException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Products SET Image = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);

        BufferedImage bufferedImage = (BufferedImage) image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        byte[] arrayImageByte = baos.toByteArray();

        preparedStatement.setBytes(1, arrayImageByte);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
