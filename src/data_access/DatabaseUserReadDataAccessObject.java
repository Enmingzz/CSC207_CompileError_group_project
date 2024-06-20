package data_access;

import entity.CommonUserFactory;
import entity.CommonShoppingCartFactory;
import entity.CommonProductFactory;
import entity.User;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseUserReadDataAccessObject implements UserReadDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private CommonUserFactory commonUserFactory = null;
    private String query;
    private User user = null;

    public DatabaseUserReadDataAccessObject(CommonUserFactory commonUserFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.commonUserFactory = commonUserFactory;
    }

    @Override
    public User getUser(String studentNumber) throws SQLException {
        query = "SELECT * FROM Users WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, studentNumber);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String userID = resultSet.getString("UserID");
            String name = resultSet.getString("Name");
            String email = resultSet.getString("Email");
            String password = resultSet.getString("Password");
            float rating = resultSet.getFloat("Rating");
            user = commonUserFactory.createUser(name, password, email, rating, userID);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }
}
