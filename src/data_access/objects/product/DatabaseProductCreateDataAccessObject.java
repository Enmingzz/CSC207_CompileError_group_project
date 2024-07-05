package data_access.objects.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import entity.product.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;

/**
 * DatabaseProductCreateDataAccessObject receives modify_product from CreateProductUseCaseInteractor
 * no return value
 */
public class DatabaseProductCreateDataAccessObject implements ProductCreateDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void saveProduct(Product product) throws SQLException, IOException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "INSERT INTO Products (Description, Title, Price, TransferEmail, SellerID, " +
                "Address, ListTags, Image) VALUES (?,?,?,?,?,?,?,?)";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getDescription());
        preparedStatement.setString(2, product.getTitle());
        preparedStatement.setFloat(3, product.getPrice());
        preparedStatement.setString(4, product.geteTransferEmail());
        preparedStatement.setString(5, product.getSellerStudentNumber());
        preparedStatement.setString(6, product.getAddress());
        preparedStatement.setString(7, String.valueOf(product.getListTags()));

        BufferedImage bufferedImage = (BufferedImage) product.getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos);
        byte[] arrayImageByte =  baos.toByteArray();

        preparedStatement.setBytes(11, arrayImageByte);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
