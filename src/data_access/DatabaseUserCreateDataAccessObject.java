package data_access;

import entity.User;

import java.sql.*;

//TODO: This is only a testing version for Signup DataAccessObject to check the connection of Database!
public class DatabaseUserCreateDataAccessObject implements UserCreateDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private User user;
    private String query;

    public DatabaseUserCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
//        this.user = user;

    }
    @Override
    public boolean existsByUTorID(String identifier) throws SQLException {
        query = "SELECT UserID FROM Users WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, identifier);

        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return true;
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return false;
    }

    @Override
    public void saveUser(User user) throws SQLException {
        query = "INSERT INTO Users (UserID, Name, Email, Password) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getUtorid());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public void saveUser() throws SQLException {
        query = "INSERT INTO dbo.Users (UserID, Name, Email, Password) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "1");
        preparedStatement.setString(2, "Tester");
        preparedStatement.setString(3, "test@test.com");
        preparedStatement.setString(4, "123456");
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
//TODO: Delete this psvm after testing successful.
    public static void main(String[] args) throws SQLException {
        DatabaseUserCreateDataAccessObject dataAccessObject = new DatabaseUserCreateDataAccessObject();
        System.out.println(dataAccessObject.existsByUTorID("1"));
//        dataAccessObject.saveUser();
    }
}
