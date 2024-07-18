package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;

import java.sql.SQLException;

/**
 * DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateBuyerScheduleDataAccessInterface.
 */
public interface DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateBuyerScheduleDataAccessInterface.
     *
     * @return an instance of ProductUpdateBuyerScheduleDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateBuyerScheduleDataAccessInterface create() throws SQLException;
}
