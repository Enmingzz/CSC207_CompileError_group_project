package data_access.objects.shopping_cart;

import data_access.interfaces.shopping_cart.ShoppingCartReadDataAccessInterface;
import data_access.objects.product.DatabaseProductReadByIdDataAccessObject;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseShoppingCartReadDataAccessObject is responsible for retrieving a shopping cart for a user from the database.
 * It implements the ShoppingCartReadDataAccessInterface.
 */
public class DatabaseShoppingCartReadDataAccessObject implements ShoppingCartReadDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;
    private final ShoppingCartFactory shoppingCartFactory;
    private final ProductFactory productFactory;
    private final ScheduleFactory scheduleFactory;

    /**
     * Constructs a DatabaseShoppingCartReadDataAccessObject and establishes a connection to the database.
     *
     * @param shoppingCartFactory a factory for creating ShoppingCart objects
     * @param productFactory      a factory for creating Product objects
     * @param scheduleFactory     a factory for creating Schedule objects
     * @throws SQLException if a database access error occurs
     */
    public DatabaseShoppingCartReadDataAccessObject(ShoppingCartFactory shoppingCartFactory, ProductFactory productFactory, ScheduleFactory scheduleFactory) throws SQLException {
        this.scheduleFactory = scheduleFactory;
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.shoppingCartFactory = shoppingCartFactory;
        this.productFactory = productFactory;
    }

    /**
     * Retrieves the shopping cart for the specified user from the database.
     *
     * @param userID the ID of the user whose shopping cart is to be retrieved
     * @return the shopping cart for the specified user
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an error occurs during product retrieval
     */
    @Override
    public ShoppingCart getShoppingCart(String userID) throws SQLException, IOException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        Product product;
        ArrayList<Product> listProducts = new ArrayList<>();
        DatabaseProductReadByIdDataAccessObject databaseProductReadByIdDataAccessObject =
                new DatabaseProductReadByIdDataAccessObject(productFactory, scheduleFactory);

        query = "SELECT * FROM Carts WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userID);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            float totalPrice = resultSet.getFloat("TotalPrice");
            ArrayList<String> rowProducts = (resultSet.getString("ListProductsID") == null)?
                    new ArrayList<String>(): new ArrayList<>(List.of(resultSet.getString("ListProductsID").substring(1,
                    resultSet.getString("ListProductsID").length() - 1).split(", ")));

            for (String item : rowProducts) {
                product = databaseProductReadByIdDataAccessObject.getProductById(item.trim());
                listProducts.add(product);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return shoppingCartFactory.createShoppingCart(totalPrice, userID, listProducts);

        } else {
            resultSet.close();
            preparedStatement.close();
            connection.close();

            return null;
        }


    }
}
