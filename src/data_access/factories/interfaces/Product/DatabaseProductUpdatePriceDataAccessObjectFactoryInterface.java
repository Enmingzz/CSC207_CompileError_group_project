package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdatePriceDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdatePriceDataAccessObjectFactoryInterface {
    ProductUpdatePriceDataAccessInterface create() throws SQLException;
}
