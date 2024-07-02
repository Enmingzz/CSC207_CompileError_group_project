package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateNameDataAccessObjectFactoryInterface {

    ProductUpdateNameDataAccessInterface create() throws SQLException;
}
