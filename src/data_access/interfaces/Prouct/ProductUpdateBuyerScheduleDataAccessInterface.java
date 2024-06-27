package data_access.interfaces.Prouct;

import entity.product.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface ProductUpdateBuyerScheduleDataAccessInterface {
    void updateBuyerScheduleByProductID(Product product, LocalDateTime buyerScheduleTime) throws SQLException;
}
