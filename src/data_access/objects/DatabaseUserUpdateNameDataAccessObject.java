package data_access.objects;


import data_access.interfaces.UserUpdateNameDataAccessInterface;
import entity.user.User;

import java.sql.*;
import java.sql.SQLException;

public class DatabaseUserUpdateNameDataAccessObject implements UserUpdateNameDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseUserUpdateNameDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

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
