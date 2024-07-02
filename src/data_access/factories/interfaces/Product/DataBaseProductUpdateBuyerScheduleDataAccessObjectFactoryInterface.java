package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateBuyerScheduleDataAccessInterface;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.ScheduleFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface {
    ProductUpdateBuyerScheduleDataAccessInterface create() throws SQLException;
}
