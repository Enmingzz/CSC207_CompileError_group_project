package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdateNameDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateNameDataAccessObjectFactoryInterface {

    ProductUpdateNameDataAccessInterface create() throws SQLException;
}
