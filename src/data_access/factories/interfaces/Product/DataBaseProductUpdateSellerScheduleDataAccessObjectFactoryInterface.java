package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateSellerScheduleDataAccessInterface;

import java.sql.SQLException;

public interface DataBaseProductUpdateSellerScheduleDataAccessObjectFactoryInterface {
    ProductUpdateSellerScheduleDataAccessInterface create() throws SQLException;
}
