package data_access.objects.product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DatabaseProductReadByNameDataAccessObject is responsible for retrieving products by their name from the database.
 * It implements the ProductReadByNameDataAccessInterface.
 */
public class DatabaseProductReadByNameDataAccessObject implements ProductReadByNameDataAccessInterface {
    private final ProductFactory productFactory;
    private final ScheduleFactory scheduleFactory;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    /**
     * Constructs a DatabaseProductReadByNameDataAccessObject and establishes a connection to the database.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductReadByNameDataAccessObject(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.productFactory = productFactory;
        this.scheduleFactory = scheduleFactory;
    }

    /**
     * Retrieves products from the database that match the provided name.
     *
     * @param name the name to search for in the product tags
     * @return a list of products that match the given name
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    @Override
    public ArrayList<Product> getProductByName(String name) throws SQLException, IOException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        String productsID;
        String sellerID;
        String description;
        String title;
        float price;
        int state;
        int rating;
        String transferEmail;
        String address;
        ArrayList<String> listTags;
        Image image;
        ArrayList<String> rowTime;
        ArrayList<LocalDateTime> listSellerTimes = new ArrayList<>();
        LocalDateTime buyerTime = null;
        Schedule schedule;
        Product product;
        ArrayList<Product> listProducts = new ArrayList<>();

        query = "SELECT * FROM Products WHERE ListTags LIKE ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, '%' + name + '%');
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            productsID = resultSet.getString("ProductsID");
            sellerID = resultSet.getString("SellerID");
            description = resultSet.getString("Description");
            title = resultSet.getString("Title");
            price = resultSet.getFloat("Price");
            state = resultSet.getInt("State");
            rating = resultSet.getInt("Rating");
            transferEmail = resultSet.getString("TransferEmail");
            address = resultSet.getString("Address");
            listTags = new ArrayList<>(List.of(resultSet.getString("ListTags").substring(1, resultSet.getString("ListTags").length() - 1).split(",")));
            image = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("Image")));

            if (!Objects.equals(resultSet.getString("ListSellerTimes").toLowerCase(), "null")) {
                rowTime = new ArrayList<>(List.of(resultSet.getString("ListSellerTimes").substring(1, resultSet.getString("ListTags").length() - 1).split(",")));
                for (String time : rowTime) {
                    listSellerTimes.add(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                }
            }

            if (!Objects.equals(resultSet.getString("BuyerTime").toLowerCase(), "null")) {
                buyerTime = LocalDateTime.parse(resultSet.getString("BuyerTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
            }

            schedule = scheduleFactory.createSchedule(buyerTime, listSellerTimes);

            product = productFactory.createProduct(image, description, title, price, rating, state, transferEmail, sellerID, address, listTags, productsID, schedule);
            listProducts.add(product);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listProducts;
    }
}
