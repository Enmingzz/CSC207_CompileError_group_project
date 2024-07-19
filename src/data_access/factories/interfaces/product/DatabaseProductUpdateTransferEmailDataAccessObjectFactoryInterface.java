package data_access.factories.interfaces.product;

import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;

import java.sql.SQLException;

/**
 * DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface provides an abstraction for creating instances of ProductUpdateTransferEmailDataAccessInterface.
 */
public interface DatabaseProductUpdateTransferEmailDataAccessObjectFactoryInterface {

    /**
     * Creates an instance of ProductUpdateTransferEmailDataAccessInterface.
     *
     * @return an instance of ProductUpdateTransferEmailDataAccessInterface
     * @throws SQLException if a database access error occurs
     */
    ProductUpdateTransferEmailDataAccessInterface create() throws SQLException;
}
