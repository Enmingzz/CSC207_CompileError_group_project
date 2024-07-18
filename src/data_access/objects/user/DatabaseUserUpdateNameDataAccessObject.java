package data_access.objects.user;

import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import entity.user.User;

import java.sql.*;
import java.sql.SQLException;

/**
 * DatabaseUserUpdateNameDataAccessObject is responsible for updating the name of a user in the database.
 * It implements the UserUpdateNameDataAccessInterface.
 */
public class DatabaseUserUpdateNameDataAccessObject implements UserUpdateNameDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseUserUpdateNameDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseUserUpdateNameDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the name of the specified user in the database.
     *
     * @param user the user whose name is to be updated
     * @param name the new name to be set for the user
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateUserName(User user, String name) throws SQLException {
        query = "UPDATE Users SET Name = ? WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, user.getStudentNumber());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
