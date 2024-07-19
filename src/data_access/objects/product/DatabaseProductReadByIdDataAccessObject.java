package data_access.objects.product;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
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
 * DatabaseProductReadByIdDataAccessObject is responsible for retrieving a product by its ID from the database.
 * It implements the ProductReadByIdDataAccessInterface.
 */
public class DatabaseProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {
    private final ProductFactory productFactory;
    private final ScheduleFactory scheduleFactory;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    /**
     * Constructs a DatabaseProductReadByIdDataAccessObject and establishes a connection to the database.
     *
     * @param productFactory  a factory for creating Product objects
     * @param scheduleFactory a factory for creating Schedule objects
     * @throws SQLException if a database access error occurs
     */
    public DatabaseProductReadByIdDataAccessObject(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.productFactory = productFactory;
        this.scheduleFactory = scheduleFactory;
    }

    /**
     * Retrieves a product from the database using the provided product ID.
     *
     * @param productID the ID of the product to be retrieved
     * @return the product with the specified ID, or null if no such product exists
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during image processing
     */
    @Override
    public Product getProductById(String productID) throws SQLException, IOException {
        ArrayList<LocalDateTime> listSellerTimes = new ArrayList<>();
        ArrayList<String> rowTime;
        LocalDateTime buyerTime = null;

        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "SELECT * FROM Products WHERE ProductsID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, productID);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String productsID = resultSet.getString("ProductsID");
            String description = resultSet.getString("Description");
            String title = resultSet.getString("Title");
            float price = resultSet.getFloat("Price");
            int state = resultSet.getInt("State");
            int rating = resultSet.getInt("Rating");
            String transferEmail = resultSet.getString("TransferEmail");
            String sellerID = resultSet.getString("SellerID");
            String address = resultSet.getString("Address");
            ArrayList<String> listTags = new ArrayList<>(List.of(resultSet.getString("ListTags").substring(1, resultSet.getString("ListTags").length() - 1).split(",")));
            Image image = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("Image")));

            if (!Objects.equals(resultSet.getString("ListSellerTimes").toLowerCase(), "null")) {
                rowTime = new ArrayList<>(List.of(resultSet.getString("ListSellerTimes").substring(1, resultSet.getString("ListTags").length() - 1).split(",")));
                for (String time : rowTime) {
                    listSellerTimes.add(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                }
            }

            if (!Objects.equals(resultSet.getString("BuyerTime").toLowerCase(), "null")) {
                buyerTime = LocalDateTime.parse(resultSet.getString("BuyerTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
            }

            Schedule schedule = scheduleFactory.createSchedule(buyerTime, listSellerTimes);

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return productFactory.createProduct(image, description, title, price, rating, state, transferEmail, sellerID, address, listTags, productsID, schedule);
        } else {
            return null;
        }
    }
}
