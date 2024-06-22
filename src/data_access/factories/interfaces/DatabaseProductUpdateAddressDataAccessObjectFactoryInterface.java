package data_access.factories.interfaces;

import data_access.interfaces.ProductUpdateAddressDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateAddressDataAccessObjectFactoryInterface {
    ProductUpdateAddressDataAccessInterface create() throws SQLException;
}
