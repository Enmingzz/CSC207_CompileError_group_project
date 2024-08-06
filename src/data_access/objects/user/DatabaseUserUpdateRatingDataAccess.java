package data_access.objects.user;

import data_access.interfaces.user.UserUpdateRatingDataAccessInterface;
import entity.product.Product;
import entity.user.User;

import java.sql.*;

public class DatabaseUserUpdateRatingDataAccess implements UserUpdateRatingDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;

    public DatabaseUserUpdateRatingDataAccess() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateUserRating(Product product) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "SELECT Rating FROM Products WHERE SellerID = ? AND State = -1";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getSellerStudentNumber());
        resultSet = preparedStatement.executeQuery();

        int total = 0;
        int count = 0;

        while (resultSet.next()) {
            total += resultSet.getInt(1);
            count += 1;
        }

        if (count != 0) {
            query = "UPDATE Users SET Rating = ? WHERE UserID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, Math.round(((float) total / count) * 10.0f) / 10.0f);
            preparedStatement.setString(2, product.getSellerStudentNumber());
            preparedStatement.executeUpdate();
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
