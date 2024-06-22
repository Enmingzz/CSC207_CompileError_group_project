package data_access.objects;

import data_access.interfaces.UserUpdatePasswordDataAccessInterface;
import entity.user.User;

import java.sql.*;

public class DatabaseUserUpdatePasswordDataAccessObject implements UserUpdatePasswordDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseUserUpdatePasswordDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateUserPassword(User user, String password) throws SQLException {
        query = "UPDATE Users SET Password = ? WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, user.getStudentNumber());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
