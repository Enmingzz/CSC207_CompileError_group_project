package data_access;

import entity.CommonUserFactory;
import entity.CommonShoppingCartFactory;
import entity.CommonShoppingCartFactory;
import entity.CommonProductFactory;
import entity.User;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseUserLoginLoadDataAccessObject implements UserLoginDataAccessInterface {
    private final Connection connection;
    private final Statement statement;

    public DatabaseUserLoginLoadDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/207project", "root", "Hz04.05.19");
        this.statement = connection.createStatement();
    }

    @Override
    public User getUser(String userEmail) throws SQLException, IOException {
        CommonProductFactory ProductFactory = new CommonProductFactory();
        CommonShoppingCartFactory ShoppingCartFactory = new CommonShoppingCartFactory();
        CommonUserFactory CommonUserFactory = new CommonUserFactory();

        String query = "SELECT * FROM Users WHERE Email = '" + userEmail + "'";
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            String userId = resultSet.getString("UserID");
            String name = resultSet.getString("Name");
            String password = resultSet.getString("Password");
            float rating = resultSet.getFloat("Rating");

            ArrayList<String> lstSellProducts = (ArrayList<String>) resultSet.getArray("ListSellProducts").getArray();
            for (String i : lstSellProducts) {
                query = "SELECT * FROM Products WHERE ProdcutID = '" + i + "'";
                ResultSet resultSetProducts = statement.executeQuery(query);
                if (resultSetProducts.next()) {
                    InputStream inputStream = resultSetProducts.getBinaryStream("ImageData");
                    BufferedImage bufferedImage = ImageIO.read(inputStream);

                    Image image = bufferedImage;
                    String description = resultSetProducts.getString("Description");
                    String title = resultSetProducts.getString("Title");
                    float price = resultSetProducts.getFloat("Price");
                    int Productratinng = resultSetProducts.getInt("Ratinng");
                }
            }


            String cartId = resultSet.getString("CartID");
            query = "SELECT * FROM Carts WHERE UserID = '" + userId + "'";
            ResultSet resultSetCard = statement.executeQuery(query);

            if (resultSetCard.next()) {
                Array listProductId = resultSetCard.getArray("ListProducts");

            }

        }

    return null;
    }
}
