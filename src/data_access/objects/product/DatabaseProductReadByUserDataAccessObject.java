package data_access.objects.product;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
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
 * DatabaseProductReadByUserDataAccessObject is responsible for retrieving products by user ID from the database.
 * It implements the ProductReadByUserDataAccessInterface.
 */
public class DatabaseProductReadByUserDataAccessObject implements ProductReadByUserDataAccessInterface {
    private final ProductFactory productFactory;
    private final ScheduleFactory scheduleFactory;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    /**
     * Constructs a DatabaseProductReadByUserDataAccessObject and establishes a connection to the database.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductReadByUserDataAccessObject(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.productFactory = productFactory;
        this.scheduleFactory = scheduleFactory;
    }

    /**
     * Retrieves products from the database that are associated with the provided user ID.
     *
     * @param userID the ID of the user whose products are to be retrieved
     * @return a list of products associated with the given user ID
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
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
        ArrayList<String> rowTime;
        ArrayList<LocalDateTime> listSellerTimes = new ArrayList<>();
        LocalDateTime buyerTime = null;
        Schedule schedule;
        Product product;
        ArrayList<Product> listProducts = new ArrayList<>();

        query = "SELECT * FROM Products WHERE SellerID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userID);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            productsID = resultSet.getString("ProductID");
            description = resultSet.getString("Description");
            title = resultSet.getString("Title");
            price = resultSet.getFloat("Price");
            state = resultSet.getInt("State");
            rating = resultSet.getInt("Rating");
            transferEmail = resultSet.getString("TransferEmail");
            address = resultSet.getString("Address");
            listTags = new ArrayList<>(List.of(resultSet.getString("ListTags").substring(1, resultSet.getString("ListTags").length() - 1).split(",")));
            image = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("Image")));

            if (!Objects.equals(resultSet.getString("ListSellerTimes"), null)) {
                rowTime = new ArrayList<>(List.of(resultSet.getString("ListSellerTimes").substring(1, resultSet.getString("ListTags").length() - 1).split(",")));
                for (String time : rowTime) {
                    listSellerTimes.add(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                }
            }

            if (!Objects.equals(resultSet.getString("BuyerTime"), null)) {
                buyerTime = LocalDateTime.parse(resultSet.getString("BuyerTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
            }

            schedule = scheduleFactory.createSchedule(buyerTime, listSellerTimes);

            product = productFactory.createProduct(image, description, title, price, rating, state, transferEmail, userID, address, listTags, productsID, schedule);
            listProducts.add(product);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listProducts;
    }
}
