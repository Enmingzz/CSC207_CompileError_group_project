package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdatePriceDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdatePriceDataAccessObjectFactoryInterface {
    ProductUpdatePriceDataAccessInterface create() throws SQLException;
}
