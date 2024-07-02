package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;

import java.sql.SQLException;

public interface DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface {
    ProductUpdateBuyerScheduleDataAccessInterface create() throws SQLException;
}
