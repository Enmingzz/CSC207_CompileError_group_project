package data_access.objects.User;

import data_access.interfaces.User.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.*;

public class DatabaseUserReadDataAccessObject implements UserReadDataAccessInterface {
    private final Connection connection;
    private final UserFactory userFactory;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    public DatabaseUserReadDataAccessObject(UserFactory userFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.userFactory = userFactory;
    }

    @Override
    public User getUser(String studentNumber) throws SQLException {
        System.out.println("I am here");
        query = "SELECT * FROM Users WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, studentNumber);
        resultSet = preparedStatement.executeQuery();
        String userID;
        String name;
        String email;
        String password;
        float rating;
        if (resultSet.next()) {
            userID = resultSet.getString("UserID");
            name = resultSet.getString("Name");
            email = resultSet.getString("Email");
            password = resultSet.getString("Password");
            rating = resultSet.getFloat("Rating");
        } else{
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return null;
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        System.out.println("I am still here");
        return userFactory.createUser(name, password, email, rating, userID);
    }
}
