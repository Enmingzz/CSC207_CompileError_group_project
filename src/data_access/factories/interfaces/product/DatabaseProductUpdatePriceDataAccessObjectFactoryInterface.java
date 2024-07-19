package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdatePriceDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdatePriceDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdatePriceDataAccessInterface.
 */
public interface DatabaseProductUpdatePriceDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdatePriceDataAccessInterface.
     *
     * @return an instance of ProductUpdatePriceDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdatePriceDataAccessInterface create() throws SQLException;
}
