package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
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

public class DatabaseProductReadByNameDataAccessObject implements ProductReadByNameDataAccessInterface {
    private final ProductFactory productFactory;
    private final ScheduleFactory scheduleFactory;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;


    public DatabaseProductReadByNameDataAccessObject(ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.productFactory = productFactory;
        this.scheduleFactory = scheduleFactory;
    }

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
        ArrayList<LocalDateTime> listSellerTimes = new ArrayList<LocalDateTime>();
        LocalDateTime buyerTime;
        Schedule schedule;
        Product product;
        ArrayList<Product> listProducts = new ArrayList<Product>();

        query = "SELECT * FROM Products WHERE ListTags LIKE ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, '%'+name+'%');
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
            listTags = new ArrayList<String>(java.util.List.of(resultSet.getString("ListTags").substring(1
                    , resultSet.getString("ListTags").length() - 1).split(",")));
            image = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("Image")));

            rowTime = new ArrayList<String>(List.of(resultSet.getString("ListSellerTimes").substring(1
                    , resultSet.getString("ListTags").length() - 1).split(",")));
            for(String time: rowTime){
                listSellerTimes.add(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }

            buyerTime = LocalDateTime.parse(resultSet.getString("BuyerTime"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            schedule = scheduleFactory.createSchedule(buyerTime, listSellerTimes);

            product = productFactory.createProduct(image, description, title, price, rating, state,
                    transferEmail, sellerID, address, listTags, productsID, schedule);
            listProducts.add(product);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listProducts;
    }
}
