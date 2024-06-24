package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateStateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateStateDataAccessObjectFactoryInterface {
    ProductUpdateStateDataAccessInterface create() throws SQLException;
}
