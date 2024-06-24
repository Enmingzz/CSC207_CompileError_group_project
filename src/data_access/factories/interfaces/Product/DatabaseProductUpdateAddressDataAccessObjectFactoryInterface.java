package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductUpdateAddressDataAccessInterface;

import java.sql.SQLException;

public interface DatabaseProductUpdateAddressDataAccessObjectFactoryInterface {
    ProductUpdateAddressDataAccessInterface create() throws SQLException;
}
