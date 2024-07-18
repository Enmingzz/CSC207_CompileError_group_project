package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdateAddressDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateAddressDataAccessInterface.
 */
public interface DatabaseProductUpdateAddressDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateAddressDataAccessInterface.
     *
     * @return an instance of ProductUpdateAddressDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateAddressDataAccessInterface create() throws SQLException;
}
