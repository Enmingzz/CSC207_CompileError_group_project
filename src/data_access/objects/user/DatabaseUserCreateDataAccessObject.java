package data_access.objects.user;

import data_access.interfaces.user.UserCreateDataAccessInterface;
import entity.user.User;

import java.sql.*;

public class DatabaseUserCreateDataAccessObject implements UserCreateDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    public DatabaseUserCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

    }
//    @Override
//    public boolean existsByUTorID(String identifier) throws SQLException {
//        query = "SELECT UserID FROM Users WHERE UserID = ?";
//        preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setString(1, identifier);
//
//        resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()) {
//            resultSet.close();
//            preparedStatement.close();
//            connection.close();
//            return true;
//        }
//        resultSet.close();
//        preparedStatement.close();
//        connection.close();
//        return false;
//    }

    @Override
    public void saveUser(User user) throws SQLException {
        query = "INSERT INTO Users (UserID, Name, Email, Password) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getStudentNumber());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
