package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductReadByUserDataAccessInterface;
import entity.product.Product;
import entity.product.ProductFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProductReadByUserDataAccessObject implements ProductReadByUserDataAccessInterface {
    private Connection connection;
    private final ProductFactory productFactory;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    public DatabaseProductReadByUserDataAccessObject(ProductFactory productFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.productFactory = productFactory;
    }

    @Override
    public ArrayList<Product> getProductByUser(String userID) throws SQLException, IOException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        String productsID;
        String description;
        String title;
        float price;
        int state;
        int rating;
        String transferEmail;
        String address;
        ArrayList<String> listTags;
        Image image;
        Product product;
        ArrayList<Product> listProducts = new ArrayList<Product>();

        query = "SELECT * FROM Products WHERE UserID = ?";
        preparedStatement.setString(1, userID);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            productsID = resultSet.getString("ProductsID");
            description = resultSet.getString("Description");
            title = resultSet.getString("Title");
            price = resultSet.getFloat("Price");
            state = resultSet.getInt("State");
            rating = resultSet.getInt("Rating");
            transferEmail = resultSet.getString("TransferEmail");
            address = resultSet.getString("Address");
            listTags = new ArrayList<String>(List.of(resultSet.getString("ListTags").substring(1
                    , resultSet.getString("ListTags").length() - 1).split(",")));
            image = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("Image")));
            product = productFactory.createProduct(image, description, title, price, rating, state,
                    transferEmail, userID, address, listTags, productsID);
            listProducts.add(product);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listProducts;
    }
}
