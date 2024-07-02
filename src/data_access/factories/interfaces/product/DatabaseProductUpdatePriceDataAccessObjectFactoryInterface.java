package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdatePriceDataAccessObjectFactoryInterface {
    ProductUpdatePriceDataAccessInterface create() throws SQLException;
}
