package data_access;

import entity.User;

import java.sql.*;

//TODO: This is only a testing version for Signup DataAccessObject to check the connection of Database!
public class DatabaseUserSignupSaveDataAccessObject implements UserSignupDataAccessInterface {
    private final Connection connection;
    private final Statement statement;
    private User user;

    public DatabaseUserSignupSaveDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/207project", "root", "Hz04.05.19");
        this.statement = connection.createStatement();
//        this.user = user;

    }
    @Override
    public boolean existsByUTorID(String identifier) throws SQLException {
        String query = "SELECT UserID FROM Users WHERE UserID = '" + identifier + "'";
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            resultSet.close();
            statement.close();
            connection.close();
            return true;
        }
        resultSet.close();
        statement.close();
        connection.close();
        return false;
    }

    @Override
    public void saveUser(User user) throws SQLException {
        String query = "INSERT INTO Users (UserID, Name, Email, Password) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getUtroid());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());

        preparedStatement.close();
        statement.close();
        connection.close();
    }
//TODO: Delete this psvm after testing successful.
    public static void main(String[] args) throws SQLException {
        DatabaseUserSignupSaveDataAccessObject dataAccessObject = new DatabaseUserSignupSaveDataAccessObject();
        System.out.println(dataAccessObject.existsByUTorID("1"));
    }
}
