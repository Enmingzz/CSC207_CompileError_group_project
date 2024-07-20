package data_access.objects.product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
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
 * DataBaseProductReadAllDataAccessObject is responsible for retrieving all product data from the database.
 * It implements the ProductReadAllDataAccessInterface.
 */
public class DataBaseProductReadAllDataAccessObject implements ProductReadAllDataAccessInterface {
    private final ProductFactory productFactory;
    private final ScheduleFactory scheduleFactory;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    /**
     * Constructs a DataBaseProductReadAllDataAccessObject and establishes a connection to the database.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @throws SQLException if a database access error occurs
     */
    public DataBaseProductReadAllDataAccessObject(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.productFactory = productFactory;
        this.scheduleFactory = scheduleFactory;
    }

    /**
     * Retrieves all products from the database and returns them as a list.
     *
     * @return a list of all products from the database
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    @Override
    public ArrayList<Product> getAllProducts() throws SQLException, IOException {
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

        query = "SELECT * FROM Products";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            productsID = resultSet.getString("ProductID");
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

            if (!Objects.equals(resultSet.getString("ListSellerTimes"), null)) {
                rowTime = new ArrayList<>(List.of(resultSet.getString("ListSellerTimes").substring(1, resultSet.getString("ListSellerTimes").length() - 1).split(",")));
                for (String time : rowTime) {
                    listSellerTimes.add(LocalDateTime.parse(time.trim(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                }
            }

            if (!Objects.equals(resultSet.getString("BuyerTime"), null)) {
                buyerTime = LocalDateTime.parse(resultSet.getString("BuyerTime"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
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

