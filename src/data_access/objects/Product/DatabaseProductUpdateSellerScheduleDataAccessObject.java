package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductUpdateSellerScheduleDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.*;

public class DatabaseProductUpdateSellerScheduleDataAccessObject implements ProductUpdateSellerScheduleDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductUpdateSellerScheduleDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }
    @Override
    public void updateSellerSchedule(Product product, ArrayList<LocalDateTime> listTimes) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "UPDATE Products SET ListSellerTimes = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(listTimes));
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }
}
