package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateSellerScheduleDataAccessInterface;

import java.sql.SQLException;

public interface DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface {
    ProductUpdateSellerScheduleDataAccessInterface create() throws SQLException;
}
