package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdateNameDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateNameDataAccessInterface.
 */
public interface DatabaseProductUpdateNameDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateNameDataAccessInterface.
     *
     * @return an instance of ProductUpdateNameDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateNameDataAccessInterface create() throws SQLException;
}
