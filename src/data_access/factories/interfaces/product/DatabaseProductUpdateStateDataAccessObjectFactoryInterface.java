package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateStateDataAccessObjectFactoryInterface {
    ProductUpdateStateDataAccessInterface create() throws SQLException;
}
