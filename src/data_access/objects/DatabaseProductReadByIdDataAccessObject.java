package data_access.objects;

import data_access.interfaces.ProductReadByIdDataAccessInterface;
import entity.product.Product;
import entity.product.ProductFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {
    private final Connection connection;
    private final ProductFactory productFactory;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    public DatabaseProductReadByIdDataAccessObject(ProductFactory productFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.productFactory = productFactory;
    }

    @Override
    public Product getProductById(String productID) throws SQLException, IOException {
        query = "SELECT * FROM Products WHERE ProductsID = ?";
        preparedStatement.setString(1, productID);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();

        String productsID = resultSet.getString("ProductsID");
        String description = resultSet.getString("Description");
        String title = resultSet.getString("Title");
        float price = resultSet.getFloat("Price");
        int state = resultSet.getInt("State");
        int rating = resultSet.getInt("Rating");
        String transferEmail = resultSet.getString("TransferEmail");
        String sellerID = resultSet.getString("SellerID");
        String address = resultSet.getString("Address");
        ArrayList<String> listTags = new ArrayList<String>(List.of(resultSet.getString("ListTags").substring(1
                , resultSet.getString("ListTags").length() - 1).split(",")));
        Image image = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("Image")));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return productFactory.createProduct(image, description, title, price, rating, state,
                transferEmail, sellerID, address, listTags, productsID);
    }

}
