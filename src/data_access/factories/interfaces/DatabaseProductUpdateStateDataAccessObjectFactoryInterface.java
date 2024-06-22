package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdateStateDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateStateDataAccessObjectFactoryInterface {
    ProductUpdateStateDataAccessInterface create() throws SQLException;
}
