package data_access.objects;

import data_access.interfaces.ShoppingCartReadDataAccessInterface;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.shopping_cart.ShoppingCart;
import entity.shopping_cart.ShoppingCartFactory;
import entity.user.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseShoppingCartReadDataAccessObject implements ShoppingCartReadDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;
    private final ShoppingCartFactory shoppingCartFactory;
    private final ProductFactory productFactory;

    public DatabaseShoppingCartReadDataAccessObject(ShoppingCartFactory shoppingCartFactory, ProductFactory productFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.shoppingCartFactory = shoppingCartFactory;
        this.productFactory = productFactory;
    }
    @Override
    public ShoppingCart getShoppingCart(User user) throws SQLException, IOException {
        Product product;
        ArrayList<Product> listProducts = new ArrayList<Product>();
        DatabaseProductReadByIdDataAccessObject databaseProductReadByIdDataAccessObject =
                new DatabaseProductReadByIdDataAccessObject(productFactory);

        query = "SELECT * FROM Carts WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getStudentNumber());
        resultSet = preparedStatement.executeQuery();
        resultSet.next();

        float totalPrice = resultSet.getFloat("TotalPrice");
        ArrayList<String> rowProducts = new ArrayList<String>(List.of(resultSet.getString("Products").substring(1,
                resultSet.getString("Products").length() - 1).split(",")));

        for (String item : rowProducts) {
            product = databaseProductReadByIdDataAccessObject.getProductById(item);
            listProducts.add(product);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return  shoppingCartFactory.createShoppingCart(totalPrice, user.getStudentNumber(), listProducts);
    }
}
