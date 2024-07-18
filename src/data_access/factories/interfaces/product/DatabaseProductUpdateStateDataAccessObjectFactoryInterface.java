package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdateStateDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateStateDataAccessInterface.
 */
public interface DatabaseProductUpdateStateDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateStateDataAccessInterface.
     *
     * @return an instance of ProductUpdateStateDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateStateDataAccessInterface create() throws SQLException;
}
