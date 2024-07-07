package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;
import entity.product.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class InMemoryProductUpdateBuyerScheduleDataAccessObject implements ProductUpdateBuyerScheduleDataAccessInterface {

    @Override
    public void updateBuyerScheduleByProductID(Product product, LocalDateTime buyerScheduleTime) throws SQLException {

    }
}
