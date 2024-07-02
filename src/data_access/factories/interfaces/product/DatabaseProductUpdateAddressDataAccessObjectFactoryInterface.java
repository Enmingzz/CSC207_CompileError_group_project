package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateAddressDataAccessObjectFactoryInterface {
    ProductUpdateAddressDataAccessInterface create() throws SQLException;
}
