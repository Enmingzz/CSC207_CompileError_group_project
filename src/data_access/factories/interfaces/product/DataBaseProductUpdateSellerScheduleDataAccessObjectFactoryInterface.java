package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;

import java.sql.SQLException;

/**
 * DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateSellerScheduleDataAccessInterface.
 */
public interface DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateSellerScheduleDataAccessInterface.
     *
     * @return an instance of ProductUpdateSellerScheduleDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateSellerScheduleDataAccessInterface create() throws SQLException;
}
