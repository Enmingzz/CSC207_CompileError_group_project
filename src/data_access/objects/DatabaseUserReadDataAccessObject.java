package data_access.objects;

import data_access.interfaces.UserReadDataAccessInterface;
import entity.user.User;
import entity.user.UserFactory;

import java.sql.*;

public class DatabaseUserReadDataAccessObject implements UserReadDataAccessInterface {
    private final Connection connection;
    private final UserFactory userFactory;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;
    private User user;

    public DatabaseUserReadDataAccessObject(UserFactory userFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.userFactory = userFactory;
    }

    @Override
    public User getUser(String studentNumber) throws SQLException {
        query = "SELECT * FROM Users WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, studentNumber);
        resultSet = preparedStatement.executeQuery();

        String userID = resultSet.getString("UserID");
        String name = resultSet.getString("Name");
        String email = resultSet.getString("Email");
        String password = resultSet.getString("Password");
        float rating = resultSet.getFloat("Rating");
        user = userFactory.createUser(name, password, email, rating, userID);

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }
}
