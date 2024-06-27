package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductUpdateBuyerScheduleDataAccessInterface;
import entity.product.Product;

import java.time.LocalDateTime;
import java.sql.*;

public class DatabaseProductUpdateBuyerScheduleDataAccessObject implements ProductUpdateBuyerScheduleDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseProductUpdateBuyerScheduleDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateBuyerScheduleByProductID(Product product, LocalDateTime buyerScheduleTime) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        query = "UPDATE Products SET BuyerTime = ? WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(buyerScheduleTime));
        preparedStatement.setString(2, product.getProductID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
