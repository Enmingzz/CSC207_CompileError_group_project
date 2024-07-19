package data_access.objects.user;

import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.User;

import java.sql.*;

/**
 * DatabaseUserUpdatePasswordDataAccessObject is responsible for updating the password of a user in the database.
 * It implements the UserUpdatePasswordDataAccessInterface.
 */
public class DatabaseUserUpdatePasswordDataAccessObject implements UserUpdatePasswordDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseUserUpdatePasswordDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseUserUpdatePasswordDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the password of the specified user in the database.
     *
     * @param user     the user whose password is to be updated
     * @param password the new password to be set for the user
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateUserPassword(User user, String password) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "UPDATE Users SET Password = ? WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, user.getStudentNumber());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
