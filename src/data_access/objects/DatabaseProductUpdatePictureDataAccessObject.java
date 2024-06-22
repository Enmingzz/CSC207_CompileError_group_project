package data_access.objects;

import data_access.interfaces.ProductUpdatePictureDataAccessInterface;
import entity.product.Product;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;

public class DatabaseProductUpdatePictureDataAccessObject implements ProductUpdatePictureDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductUpdatePictureDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateProductPicture(Product product, Image image) throws SQLException, IOException {
        query = "UPDATE Products SET Image = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);

        BufferedImage bufferedImage = (BufferedImage) image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos);
        byte[] arrayImageByte =  baos.toByteArray();

        preparedStatement.setBytes(1, arrayImageByte);
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();


    }
}
