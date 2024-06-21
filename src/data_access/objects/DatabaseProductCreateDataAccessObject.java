package data_access.objects;

import data_access.interfaces.ProductCreateDataAccessInterface;
import entity.product.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;

/**
 * DatabaseProductCreateDataAccessObject receives product from CreateProductUseCaseInteractor
 * no return value
 */
public class DatabaseProductCreateDataAccessObject implements ProductCreateDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void saveProduct(Product product) throws SQLException, IOException {
        query = "INSERT INTO Products (ProductID, Description, Title, Price, State, Rating, TransferEmail, SellerID, " +
                "Address, ListTags, Image) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getProductID());
        preparedStatement.setString(2, product.getDescription());
        preparedStatement.setString(3, product.getTitle());
        preparedStatement.setFloat(4, product.getPrice());
        preparedStatement.setInt(5, product.getState());
        preparedStatement.setFloat(6, product.getRating());
        preparedStatement.setString(7, product.geteTransferEmail());
        preparedStatement.setString(8, product.getSellerStudentNumber());
        preparedStatement.setString(9, product.getAddress());
        preparedStatement.setString(10, String.valueOf(product.getListTags()));

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
